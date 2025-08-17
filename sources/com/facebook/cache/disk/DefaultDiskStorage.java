package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DefaultDiskStorage implements DiskStorage {
    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    /* access modifiers changed from: private */
    public static final Class<?> TAG = DefaultDiskStorage.class;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);
    /* access modifiers changed from: private */
    public final CacheErrorLogger mCacheErrorLogger;
    /* access modifiers changed from: private */
    public final Clock mClock = SystemClock.get();
    private final boolean mIsExternal;
    /* access modifiers changed from: private */
    public final File mRootDirectory;
    /* access modifiers changed from: private */
    public final File mVersionDirectory;

    private class EntriesCollector implements FileTreeVisitor {
        private final List<DiskStorage.Entry> result;

        private EntriesCollector() {
            this.result = new ArrayList();
        }

        public List<DiskStorage.Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }

        public void postVisitDirectory(File file) {
        }

        public void preVisitDirectory(File file) {
        }

        public void visitFile(File file) {
            FileInfo access$000 = DefaultDiskStorage.this.getShardFileInfo(file);
            if (access$000 != null && access$000.type == ".cnt") {
                this.result.add(new EntryImpl(access$000.resourceId, file));
            }
        }
    }

    static class EntryImpl implements DiskStorage.Entry {
        private final String id;
        private final FileBinaryResource resource;
        private long size;
        private long timestamp;

        public String getId() {
            return this.id;
        }

        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }

        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.getFile().lastModified();
            }
            return this.timestamp;
        }

        private EntryImpl(String str, File file) {
            Preconditions.checkNotNull(file);
            this.id = (String) Preconditions.checkNotNull(str);
            this.resource = FileBinaryResource.create(file);
            this.size = -1;
            this.timestamp = -1;
        }

        public FileBinaryResource getResource() {
            return this.resource;
        }
    }

    private static class FileInfo {
        public final String resourceId;
        @FileType
        public final String type;

        public static FileInfo fromFile(File file) {
            String access$800;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf <= 0 || (access$800 = DefaultDiskStorage.getFileTypefromExtension(name.substring(lastIndexOf))) == null) {
                return null;
            }
            String substring = name.substring(0, lastIndexOf);
            if (access$800.equals(".tmp")) {
                int lastIndexOf2 = substring.lastIndexOf(46);
                if (lastIndexOf2 <= 0) {
                    return null;
                }
                substring = substring.substring(0, lastIndexOf2);
            }
            return new FileInfo(access$800, substring);
        }

        public File createTempFile(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        public String toPath(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public String toString() {
            return this.type + "(" + this.resourceId + ")";
        }

        private FileInfo(@FileType String str, String str2) {
            this.type = str;
            this.resourceId = str2;
        }
    }

    public @interface FileType {
        public static final String CONTENT = ".cnt";
        public static final String TEMP = ".tmp";
    }

    private static class IncompleteFileException extends IOException {
        public IncompleteFileException(long j2, long j3) {
            super("File was not written completely. Expected: " + j2 + ", found: " + j3);
        }
    }

    class InserterImpl implements DiskStorage.Inserter {
        private final String mResourceId;
        final File mTemporaryFile;

        public InserterImpl(String str, File file) {
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        public boolean cleanUp() {
            return !this.mTemporaryFile.exists() || this.mTemporaryFile.delete();
        }

        public BinaryResource commit(Object obj) throws IOException {
            return commit(obj, DefaultDiskStorage.this.mClock.now());
        }

        /* JADX INFO: finally extract failed */
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mTemporaryFile);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    writerCallback.write(countingOutputStream);
                    countingOutputStream.flush();
                    long count = countingOutputStream.getCount();
                    fileOutputStream.close();
                    if (this.mTemporaryFile.length() != count) {
                        throw new IncompleteFileException(count, this.mTemporaryFile.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                DefaultDiskStorage.this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.TAG, "updateResource", e2);
                throw e2;
            }
        }

        public BinaryResource commit(Object obj, long j2) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File contentFileFor = DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
            try {
                FileUtils.rename(this.mTemporaryFile, contentFileFor);
                if (contentFileFor.exists()) {
                    contentFileFor.setLastModified(j2);
                }
                return FileBinaryResource.create(contentFileFor);
            } catch (FileUtils.RenameException e2) {
                Throwable cause = e2.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                DefaultDiskStorage.this.mCacheErrorLogger.logError(cacheErrorCategory, DefaultDiskStorage.TAG, "commit", e2);
                throw e2;
            }
        }
    }

    private class PurgingVisitor implements FileTreeVisitor {
        private boolean insideBaseDirectory;

        private PurgingVisitor() {
        }

        private boolean isExpectedFile(File file) {
            FileInfo access$000 = DefaultDiskStorage.this.getShardFileInfo(file);
            boolean z2 = false;
            if (access$000 == null) {
                return false;
            }
            String str = access$000.type;
            if (str == ".tmp") {
                return isRecentFile(file);
            }
            if (str == ".cnt") {
                z2 = true;
            }
            Preconditions.checkState(z2);
            return true;
        }

        private boolean isRecentFile(File file) {
            return file.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
        }

        public void postVisitDirectory(File file) {
            if (!DefaultDiskStorage.this.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                file.delete();
            }
            if (this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = false;
            }
        }

        public void preVisitDirectory(File file) {
            if (!this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = true;
            }
        }

        public void visitFile(File file) {
            if (!this.insideBaseDirectory || !isExpectedFile(file)) {
                file.delete();
            }
        }
    }

    public DefaultDiskStorage(File file, int i2, CacheErrorLogger cacheErrorLogger) {
        Preconditions.checkNotNull(file);
        this.mRootDirectory = file;
        this.mIsExternal = isExternal(file, cacheErrorLogger);
        this.mVersionDirectory = new File(file, getVersionSubdirectoryName(i2));
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
    }

    private long doRemove(File file) {
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1;
    }

    private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry entry) throws IOException {
        String str;
        EntryImpl entryImpl = (EntryImpl) entry;
        byte[] read = entryImpl.getResource().read();
        String typeOfBytes = typeOfBytes(read);
        if (!typeOfBytes.equals("undefined") || read.length < 4) {
            str = "";
        } else {
            str = String.format((Locale) null, "0x%02X 0x%02X 0x%02X 0x%02X", new Object[]{Byte.valueOf(read[0]), Byte.valueOf(read[1]), Byte.valueOf(read[2]), Byte.valueOf(read[3])});
        }
        String str2 = str;
        return new DiskStorage.DiskDumpInfoEntry(entryImpl.getId(), entryImpl.getResource().getFile().getPath(), typeOfBytes, (float) entryImpl.getSize(), str2);
    }

    /* access modifiers changed from: private */
    @FileType
    public static String getFileTypefromExtension(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    private String getFilename(String str) {
        FileInfo fileInfo = new FileInfo(".cnt", str);
        return fileInfo.toPath(getSubdirectoryPath(fileInfo.resourceId));
    }

    /* access modifiers changed from: private */
    public FileInfo getShardFileInfo(File file) {
        FileInfo fromFile = FileInfo.fromFile(file);
        if (fromFile == null) {
            return null;
        }
        if (getSubdirectory(fromFile.resourceId).equals(file.getParentFile())) {
            return fromFile;
        }
        return null;
    }

    private File getSubdirectory(String str) {
        return new File(getSubdirectoryPath(str));
    }

    private String getSubdirectoryPath(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        return this.mVersionDirectory + File.separator + valueOf;
    }

    static String getVersionSubdirectoryName(int i2) {
        return String.format((Locale) null, "%s.ols%d.%d", new Object[]{DEFAULT_DISK_STORAGE_VERSION_PREFIX, 100, Integer.valueOf(i2)});
    }

    private static boolean isExternal(File file, CacheErrorLogger cacheErrorLogger) {
        String str;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return false;
            }
            String file2 = externalStorageDirectory.toString();
            try {
                str = file.getCanonicalPath();
                try {
                    return str.contains(file2);
                } catch (IOException e2) {
                    e = e2;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.OTHER;
                    Class<?> cls = TAG;
                    cacheErrorLogger.logError(cacheErrorCategory, cls, "failed to read folder to check if external: " + str, e);
                    return false;
                }
            } catch (IOException e3) {
                e = e3;
                str = null;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory2 = CacheErrorLogger.CacheErrorCategory.OTHER;
                Class<?> cls2 = TAG;
                cacheErrorLogger.logError(cacheErrorCategory2, cls2, "failed to read folder to check if external: " + str, e);
                return false;
            }
        } catch (Exception e4) {
            cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to get the external storage directory!", e4);
            return false;
        }
    }

    private void mkdirs(File file, String str) throws IOException {
        try {
            FileUtils.mkdirs(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, str, e2);
            throw e2;
        }
    }

    private boolean query(String str, boolean z2) {
        File contentFileFor = getContentFileFor(str);
        boolean exists = contentFileFor.exists();
        if (z2 && exists) {
            contentFileFor.setLastModified(this.mClock.now());
        }
        return exists;
    }

    private void recreateDirectoryIfVersionChanges() {
        boolean z2 = true;
        if (this.mRootDirectory.exists()) {
            if (!this.mVersionDirectory.exists()) {
                FileTree.deleteRecursively(this.mRootDirectory);
            } else {
                z2 = false;
            }
        }
        if (z2) {
            try {
                FileUtils.mkdirs(this.mVersionDirectory);
            } catch (FileUtils.CreateDirectoryException unused) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR;
                Class<?> cls = TAG;
                cacheErrorLogger.logError(cacheErrorCategory, cls, "version directory could not be created: " + this.mVersionDirectory, (Throwable) null);
            }
        }
    }

    private String typeOfBytes(byte[] bArr) {
        if (bArr.length < 2) {
            return "undefined";
        }
        byte b2 = bArr[0];
        if (b2 == -1 && bArr[1] == -40) {
            return "jpg";
        }
        if (b2 == -119 && bArr[1] == 80) {
            return "png";
        }
        if (b2 == 82 && bArr[1] == 73) {
            return "webp";
        }
        if (b2 == 71 && bArr[1] == 73) {
            return "gif";
        }
        return "undefined";
    }

    public void clearAll() {
        FileTree.deleteContents(this.mRootDirectory);
    }

    public boolean contains(String str, Object obj) {
        return query(str, false);
    }

    /* access modifiers changed from: package-private */
    public File getContentFileFor(String str) {
        return new File(getFilename(str));
    }

    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        List<DiskStorage.Entry> entries = getEntries();
        DiskStorage.DiskDumpInfo diskDumpInfo = new DiskStorage.DiskDumpInfo();
        for (DiskStorage.Entry dumpCacheEntry : entries) {
            DiskStorage.DiskDumpInfoEntry dumpCacheEntry2 = dumpCacheEntry(dumpCacheEntry);
            String str = dumpCacheEntry2.type;
            Integer num = diskDumpInfo.typeCounts.get(str);
            if (num == null) {
                diskDumpInfo.typeCounts.put(str, 1);
            } else {
                diskDumpInfo.typeCounts.put(str, Integer.valueOf(num.intValue() + 1));
            }
            diskDumpInfo.entries.add(dumpCacheEntry2);
        }
        return diskDumpInfo;
    }

    public BinaryResource getResource(String str, Object obj) {
        File contentFileFor = getContentFileFor(str);
        if (!contentFileFor.exists()) {
            return null;
        }
        contentFileFor.setLastModified(this.mClock.now());
        return FileBinaryResource.createOrNull(contentFileFor);
    }

    public String getStorageName() {
        String absolutePath = this.mRootDirectory.getAbsolutePath();
        return "_" + absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()) + "_" + absolutePath.hashCode();
    }

    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        FileInfo fileInfo = new FileInfo(".tmp", str);
        File subdirectory = getSubdirectory(fileInfo.resourceId);
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "insert");
        }
        try {
            return new InserterImpl(str, fileInfo.createTempFile(subdirectory));
        } catch (IOException e2) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e2);
            throw e2;
        }
    }

    public boolean isEnabled() {
        return true;
    }

    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor());
    }

    public long remove(DiskStorage.Entry entry) {
        return doRemove(((EntryImpl) entry).getResource().getFile());
    }

    public boolean touch(String str, Object obj) {
        return query(str, true);
    }

    public List<DiskStorage.Entry> getEntries() throws IOException {
        EntriesCollector entriesCollector = new EntriesCollector();
        FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
        return entriesCollector.getEntries();
    }

    public long remove(String str) {
        return doRemove(getContentFileFor(str));
    }

    public boolean isExternal() {
        return this.mIsExternal;
    }
}

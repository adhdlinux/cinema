package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DynamicDefaultDiskStorage implements DiskStorage {
    private static final Class<?> TAG = DynamicDefaultDiskStorage.class;
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    volatile State mCurrentState = new State((File) null, (DiskStorage) null);
    private final int mVersion;

    static class State {
        public final DiskStorage delegate;
        public final File rootDirectory;

        State(File file, DiskStorage diskStorage) {
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    public DynamicDefaultDiskStorage(int i2, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i2;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
    }

    private void createStorage() throws IOException {
        File file = new File(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        createRootDirectoryIfNecessary(file);
        this.mCurrentState = new State(file, new DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
    }

    private boolean shouldCreateNewStorage() {
        File file;
        State state = this.mCurrentState;
        if (state.delegate == null || (file = state.rootDirectory) == null || !file.exists()) {
            return true;
        }
        return false;
    }

    public void clearAll() throws IOException {
        get().clearAll();
    }

    public boolean contains(String str, Object obj) throws IOException {
        return get().contains(str, obj);
    }

    /* access modifiers changed from: package-private */
    public void createRootDirectoryIfNecessary(File file) throws IOException {
        try {
            FileUtils.mkdirs(file);
            FLog.d(TAG, "Created cache directory %s", (Object) file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e2) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", e2);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate != null && this.mCurrentState.rootDirectory != null) {
            FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized DiskStorage get() throws IOException {
        if (shouldCreateNewStorage()) {
            deleteOldStorageIfNecessary();
            createStorage();
        }
        return (DiskStorage) Preconditions.checkNotNull(this.mCurrentState.delegate);
    }

    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return get().getDumpInfo();
    }

    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        return get().getEntries();
    }

    public BinaryResource getResource(String str, Object obj) throws IOException {
        return get().getResource(str, obj);
    }

    public String getStorageName() {
        try {
            return get().getStorageName();
        } catch (IOException unused) {
            return "";
        }
    }

    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        return get().insert(str, obj);
    }

    public boolean isEnabled() {
        try {
            return get().isEnabled();
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean isExternal() {
        try {
            return get().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    public void purgeUnexpectedResources() {
        try {
            get().purgeUnexpectedResources();
        } catch (IOException e2) {
            FLog.e(TAG, "purgeUnexpectedResources", (Throwable) e2);
        }
    }

    public long remove(DiskStorage.Entry entry) throws IOException {
        return get().remove(entry);
    }

    public boolean touch(String str, Object obj) throws IOException {
        return get().touch(str, obj);
    }

    public long remove(String str) throws IOException {
        return get().remove(str);
    }
}

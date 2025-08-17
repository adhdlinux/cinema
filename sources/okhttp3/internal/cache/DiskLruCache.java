package okhttp3.internal.cache;

import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public final class DiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final String VERSION_1 = "1";
    private final int appVersion;
    /* access modifiers changed from: private */
    public boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    /* access modifiers changed from: private */
    public boolean hasJournalErrors;
    /* access modifiers changed from: private */
    public boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    /* access modifiers changed from: private */
    public BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    /* access modifiers changed from: private */
    public boolean mostRecentRebuildFailed;
    /* access modifiers changed from: private */
    public boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size;
    private final int valueCount;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry2) {
            boolean[] zArr;
            Intrinsics.f(entry2, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry2;
            if (entry2.getReadable$okhttp()) {
                zArr = null;
            } else {
                zArr = new boolean[diskLruCache.getValueCount$okhttp()];
            }
            this.written = zArr;
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    Unit unit = Unit.f40298a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    Unit unit = Unit.f40298a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (!Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this)) {
                return;
            }
            if (this.this$0.civilizedFileSystem) {
                this.this$0.completeEdit$okhttp(this, false);
            } else {
                this.entry.setZombie$okhttp(true);
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r4 = okio.Okio.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
            return r4;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Sink newSink(int r4) {
            /*
                r3 = this;
                okhttp3.internal.cache.DiskLruCache r0 = r3.this$0
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x005c }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x0050
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x005c }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x005c }
                boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r3)     // Catch:{ all -> 0x005c }
                if (r1 != 0) goto L_0x001b
                okio.Sink r4 = okio.Okio.b()     // Catch:{ all -> 0x005c }
                monitor-exit(r0)
                return r4
            L_0x001b:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x005c }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x005c }
                if (r1 != 0) goto L_0x002a
                boolean[] r1 = r3.written     // Catch:{ all -> 0x005c }
                kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ all -> 0x005c }
                r1[r4] = r2     // Catch:{ all -> 0x005c }
            L_0x002a:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x005c }
                java.util.List r1 = r1.getDirtyFiles$okhttp()     // Catch:{ all -> 0x005c }
                java.lang.Object r4 = r1.get(r4)     // Catch:{ all -> 0x005c }
                java.io.File r4 = (java.io.File) r4     // Catch:{ all -> 0x005c }
                okhttp3.internal.io.FileSystem r1 = r0.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x004a }
                okio.Sink r4 = r1.sink(r4)     // Catch:{ FileNotFoundException -> 0x004a }
                okhttp3.internal.cache.FaultHidingSink r1 = new okhttp3.internal.cache.FaultHidingSink     // Catch:{ all -> 0x005c }
                okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1 r2 = new okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1     // Catch:{ all -> 0x005c }
                r2.<init>(r0, r3)     // Catch:{ all -> 0x005c }
                r1.<init>(r4, r2)     // Catch:{ all -> 0x005c }
                monitor-exit(r0)
                return r1
            L_0x004a:
                okio.Sink r4 = okio.Okio.b()     // Catch:{ all -> 0x005c }
                monitor-exit(r0)
                return r4
            L_0x0050:
                java.lang.String r4 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005c }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005c }
                r1.<init>(r4)     // Catch:{ all -> 0x005c }
                throw r1     // Catch:{ all -> 0x005c }
            L_0x005c:
                r4 = move-exception
                monitor-exit(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):okio.Sink");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Source newSource(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x004b }
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x003f
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004b }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x004b }
                r2 = 0
                if (r1 == 0) goto L_0x003d
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004b }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x004b }
                boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r4)     // Catch:{ all -> 0x004b }
                if (r1 == 0) goto L_0x003d
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004b }
                boolean r1 = r1.getZombie$okhttp()     // Catch:{ all -> 0x004b }
                if (r1 == 0) goto L_0x0027
                goto L_0x003d
            L_0x0027:
                okhttp3.internal.io.FileSystem r1 = r0.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x003b }
                okhttp3.internal.cache.DiskLruCache$Entry r3 = r4.entry     // Catch:{ FileNotFoundException -> 0x003b }
                java.util.List r3 = r3.getCleanFiles$okhttp()     // Catch:{ FileNotFoundException -> 0x003b }
                java.lang.Object r5 = r3.get(r5)     // Catch:{ FileNotFoundException -> 0x003b }
                java.io.File r5 = (java.io.File) r5     // Catch:{ FileNotFoundException -> 0x003b }
                okio.Source r2 = r1.source(r5)     // Catch:{ FileNotFoundException -> 0x003b }
            L_0x003b:
                monitor-exit(r0)
                return r2
            L_0x003d:
                monitor-exit(r0)
                return r2
            L_0x003f:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004b }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004b }
                r1.<init>(r5)     // Catch:{ all -> 0x004b }
                throw r1     // Catch:{ all -> 0x004b }
            L_0x004b:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }
    }

    public final class Entry {
        private final List<File> cleanFiles = new ArrayList();
        private Editor currentEditor;
        private final List<File> dirtyFiles = new ArrayList();
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String str) {
            Intrinsics.f(str, "key");
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                sb.append(i2);
                this.cleanFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.append(DefaultDiskStorage.FileType.TEMP);
                this.dirtyFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final Source newSource(int i2) {
            Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i2));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(source, this.this$0, this);
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            Intrinsics.f(list, "strings");
            if (list.size() == this.this$0.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.lengths[i2] = Long.parseLong(list.get(i2));
                    }
                } catch (NumberFormatException unused) {
                    invalidLengths(list);
                    throw new KotlinNothingValueException();
                }
            } else {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
        }

        public final void setLockingSourceCount$okhttp(int i2) {
            this.lockingSourceCount = i2;
        }

        public final void setReadable$okhttp(boolean z2) {
            this.readable = z2;
        }

        public final void setSequenceNumber$okhttp(long j2) {
            this.sequenceNumber = j2;
        }

        public final void setZombie$okhttp(boolean z2) {
            this.zombie = z2;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            } else if (!this.readable) {
                return null;
            } else {
                if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                ArrayList<Source> arrayList = new ArrayList<>();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                        arrayList.add(newSource(i2));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (Source closeQuietly : arrayList) {
                        Util.closeQuietly((Closeable) closeQuietly);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final void writeLengths$okhttp(BufferedSink bufferedSink) throws IOException {
            Intrinsics.f(bufferedSink, "writer");
            for (long O : this.lengths) {
                bufferedSink.writeByte(32).O(O);
            }
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j2, List<? extends Source> list, long[] jArr) {
            Intrinsics.f(str, "key");
            Intrinsics.f(list, "sources");
            Intrinsics.f(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j2;
            this.sources = list;
            this.lengths = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i2) {
            return this.lengths[i2];
        }

        public final Source getSource(int i2) {
            return this.sources.get(i2);
        }

        public final String key() {
            return this.key;
        }
    }

    public DiskLruCache(FileSystem fileSystem2, File file, int i2, int i3, long j2, TaskRunner taskRunner) {
        boolean z2;
        Intrinsics.f(fileSystem2, "fileSystem");
        Intrinsics.f(file, "directory");
        Intrinsics.f(taskRunner, "taskRunner");
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i2;
        this.valueCount = i3;
        this.maxSize = j2;
        boolean z3 = false;
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, Util.okHttpName + " Cache");
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (i3 > 0 ? true : z3) {
                this.journalFile = new File(file, JOURNAL_FILE);
                this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
                this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j2);
    }

    /* access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i2 = this.redundantOpCount;
        if (i2 < 2000 || i2 < this.lruEntries.size()) {
            return false;
        }
        return true;
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.c(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it2 = this.lruEntries.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            Intrinsics.e(next, "i.next()");
            Entry entry = next;
            int i2 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i3 = this.valueCount;
                while (i2 < i3) {
                    this.size += entry.getLengths$okhttp()[i2];
                    i2++;
                }
            } else {
                entry.setCurrentEditor$okhttp((Editor) null);
                int i4 = this.valueCount;
                while (i2 < i4) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i2));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i2));
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|(1:22)(1:23)|24|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r9.redundantOpCount = r7 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r1.V() == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        rebuildJournal$okhttp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        r0 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        kotlin.io.CloseableKt.a(r1, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b1, code lost:
        kotlin.io.CloseableKt.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0060 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0060=Splitter:B:19:0x0060, B:27:0x0080=Splitter:B:27:0x0080} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.d(r1)
            java.lang.String r2 = r1.F()     // Catch:{ all -> 0x00ae }
            java.lang.String r3 = r1.F()     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = r1.F()     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r1.F()     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = r1.F()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = MAGIC     // Catch:{ all -> 0x00ae }
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r2)     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x0080
            java.lang.String r7 = VERSION_1     // Catch:{ all -> 0x00ae }
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r3)     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x0080
            int r7 = r9.appVersion     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00ae }
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r7, r4)     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0080
            int r4 = r9.valueCount     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00ae }
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r5)     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0080
            int r4 = r6.length()     // Catch:{ all -> 0x00ae }
            r7 = 0
            if (r4 <= 0) goto L_0x0053
            r4 = 1
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            if (r4 != 0) goto L_0x0080
        L_0x0056:
            java.lang.String r0 = r1.F()     // Catch:{ EOFException -> 0x0060 }
            r9.readJournalLine(r0)     // Catch:{ EOFException -> 0x0060 }
            int r7 = r7 + 1
            goto L_0x0056
        L_0x0060:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r9.lruEntries     // Catch:{ all -> 0x00ae }
            int r0 = r0.size()     // Catch:{ all -> 0x00ae }
            int r7 = r7 - r0
            r9.redundantOpCount = r7     // Catch:{ all -> 0x00ae }
            boolean r0 = r1.V()     // Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x0073
            r9.rebuildJournal$okhttp()     // Catch:{ all -> 0x00ae }
            goto L_0x0079
        L_0x0073:
            okio.BufferedSink r0 = r9.newJournalWriter()     // Catch:{ all -> 0x00ae }
            r9.journalWriter = r0     // Catch:{ all -> 0x00ae }
        L_0x0079:
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00ae }
            r0 = 0
            kotlin.io.CloseableKt.a(r1, r0)
            return
        L_0x0080:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r7.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ae }
            r7.append(r2)     // Catch:{ all -> 0x00ae }
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            r7.append(r3)     // Catch:{ all -> 0x00ae }
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            r7.append(r5)     // Catch:{ all -> 0x00ae }
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            r7.append(r6)     // Catch:{ all -> 0x00ae }
            r0 = 93
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ae }
            r4.<init>(r0)     // Catch:{ all -> 0x00ae }
            throw r4     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) throws IOException {
        String str2;
        String str3 = str;
        int V = StringsKt__StringsKt.V(str, ' ', 0, false, 6, (Object) null);
        if (V != -1) {
            int i2 = V + 1;
            int V2 = StringsKt__StringsKt.V(str, ' ', i2, false, 4, (Object) null);
            if (V2 == -1) {
                str2 = str3.substring(i2);
                Intrinsics.e(str2, "this as java.lang.String).substring(startIndex)");
                String str4 = REMOVE;
                if (V == str4.length() && StringsKt__StringsJVMKt.G(str3, str4, false, 2, (Object) null)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str3.substring(i2, V2);
                Intrinsics.e(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(this, str2);
                this.lruEntries.put(str2, entry);
            }
            if (V2 != -1) {
                String str5 = CLEAN;
                if (V == str5.length() && StringsKt__StringsJVMKt.G(str3, str5, false, 2, (Object) null)) {
                    String substring = str3.substring(V2 + 1);
                    Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                    List u02 = StringsKt__StringsKt.u0(substring, new char[]{' '}, false, 0, 6, (Object) null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp((Editor) null);
                    entry.setLengths$okhttp(u02);
                    return;
                }
            }
            if (V2 == -1) {
                String str6 = DIRTY;
                if (V == str6.length() && StringsKt__StringsJVMKt.G(str3, str6, false, 2, (Object) null)) {
                    entry.setCurrentEditor$okhttp(new Editor(this, entry));
                    return;
                }
            }
            if (V2 == -1) {
                String str7 = READ;
                if (V == str7.length() && StringsKt__StringsJVMKt.G(str3, str7, false, 2, (Object) null)) {
                    return;
                }
            }
            throw new IOException("unexpected journal line: " + str3);
        }
        throw new IOException("unexpected journal line: " + str3);
    }

    private final boolean removeOldestEntry() {
        for (Entry next : this.lruEntries.values()) {
            if (!next.getZombie$okhttp()) {
                Intrinsics.e(next, "toEvict");
                removeEntry$okhttp(next);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.g(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        if (this.initialized) {
            if (!this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                Intrinsics.e(values, "lruEntries.values");
                for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
                    if (!(entry.getCurrentEditor$okhttp() == null || (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) == null)) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.c(bufferedSink);
                bufferedSink.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0135, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache.Editor r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "editor"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)     // Catch:{ all -> 0x0142 }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = r9.getEntry$okhttp()     // Catch:{ all -> 0x0142 }
            okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x0142 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r9)     // Catch:{ all -> 0x0142 }
            if (r1 == 0) goto L_0x0136
            r1 = 0
            if (r10 == 0) goto L_0x0061
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0142 }
            if (r2 != 0) goto L_0x0061
            int r2 = r8.valueCount     // Catch:{ all -> 0x0142 }
            r3 = 0
        L_0x0020:
            if (r3 >= r2) goto L_0x0061
            boolean[] r4 = r9.getWritten$okhttp()     // Catch:{ all -> 0x0142 }
            kotlin.jvm.internal.Intrinsics.c(r4)     // Catch:{ all -> 0x0142 }
            boolean r4 = r4[r3]     // Catch:{ all -> 0x0142 }
            if (r4 == 0) goto L_0x0047
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            java.util.List r5 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0142 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0142 }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x0142 }
            boolean r4 = r4.exists(r5)     // Catch:{ all -> 0x0142 }
            if (r4 != 0) goto L_0x0044
            r9.abort()     // Catch:{ all -> 0x0142 }
            monitor-exit(r8)
            return
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0047:
            r9.abort()     // Catch:{ all -> 0x0142 }
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r10.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r10.append(r0)     // Catch:{ all -> 0x0142 }
            r10.append(r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0142 }
            r9.<init>(r10)     // Catch:{ all -> 0x0142 }
            throw r9     // Catch:{ all -> 0x0142 }
        L_0x0061:
            int r9 = r8.valueCount     // Catch:{ all -> 0x0142 }
        L_0x0063:
            if (r1 >= r9) goto L_0x00af
            java.util.List r2 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0142 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0142 }
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x00a7
            boolean r3 = r0.getZombie$okhttp()     // Catch:{ all -> 0x0142 }
            if (r3 != 0) goto L_0x00a7
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            boolean r3 = r3.exists(r2)     // Catch:{ all -> 0x0142 }
            if (r3 == 0) goto L_0x00ac
            java.util.List r3 = r0.getCleanFiles$okhttp()     // Catch:{ all -> 0x0142 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0142 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0142 }
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            r4.rename(r2, r3)     // Catch:{ all -> 0x0142 }
            long[] r2 = r0.getLengths$okhttp()     // Catch:{ all -> 0x0142 }
            r4 = r2[r1]     // Catch:{ all -> 0x0142 }
            okhttp3.internal.io.FileSystem r2 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            long r2 = r2.size(r3)     // Catch:{ all -> 0x0142 }
            long[] r6 = r0.getLengths$okhttp()     // Catch:{ all -> 0x0142 }
            r6[r1] = r2     // Catch:{ all -> 0x0142 }
            long r6 = r8.size     // Catch:{ all -> 0x0142 }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.size = r6     // Catch:{ all -> 0x0142 }
            goto L_0x00ac
        L_0x00a7:
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            r3.delete(r2)     // Catch:{ all -> 0x0142 }
        L_0x00ac:
            int r1 = r1 + 1
            goto L_0x0063
        L_0x00af:
            r9 = 0
            r0.setCurrentEditor$okhttp(r9)     // Catch:{ all -> 0x0142 }
            boolean r9 = r0.getZombie$okhttp()     // Catch:{ all -> 0x0142 }
            if (r9 == 0) goto L_0x00be
            r8.removeEntry$okhttp(r0)     // Catch:{ all -> 0x0142 }
            monitor-exit(r8)
            return
        L_0x00be:
            int r9 = r8.redundantOpCount     // Catch:{ all -> 0x0142 }
            r1 = 1
            int r9 = r9 + r1
            r8.redundantOpCount = r9     // Catch:{ all -> 0x0142 }
            okio.BufferedSink r9 = r8.journalWriter     // Catch:{ all -> 0x0142 }
            kotlin.jvm.internal.Intrinsics.c(r9)     // Catch:{ all -> 0x0142 }
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0142 }
            r3 = 10
            r4 = 32
            if (r2 != 0) goto L_0x00f3
            if (r10 == 0) goto L_0x00d6
            goto L_0x00f3
        L_0x00d6:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r10 = r8.lruEntries     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x0142 }
            r10.remove(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = REMOVE     // Catch:{ all -> 0x0142 }
            okio.BufferedSink r10 = r9.w(r10)     // Catch:{ all -> 0x0142 }
            r10.writeByte(r4)     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = r0.getKey$okhttp()     // Catch:{ all -> 0x0142 }
            r9.w(r10)     // Catch:{ all -> 0x0142 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0142 }
            goto L_0x0118
        L_0x00f3:
            r0.setReadable$okhttp(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = CLEAN     // Catch:{ all -> 0x0142 }
            okio.BufferedSink r1 = r9.w(r1)     // Catch:{ all -> 0x0142 }
            r1.writeByte(r4)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x0142 }
            r9.w(r1)     // Catch:{ all -> 0x0142 }
            r0.writeLengths$okhttp(r9)     // Catch:{ all -> 0x0142 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x0118
            long r1 = r8.nextSequenceNumber     // Catch:{ all -> 0x0142 }
            r3 = 1
            long r3 = r3 + r1
            r8.nextSequenceNumber = r3     // Catch:{ all -> 0x0142 }
            r0.setSequenceNumber$okhttp(r1)     // Catch:{ all -> 0x0142 }
        L_0x0118:
            r9.flush()     // Catch:{ all -> 0x0142 }
            long r9 = r8.size     // Catch:{ all -> 0x0142 }
            long r0 = r8.maxSize     // Catch:{ all -> 0x0142 }
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0129
            boolean r9 = r8.journalRebuildRequired()     // Catch:{ all -> 0x0142 }
            if (r9 == 0) goto L_0x0134
        L_0x0129:
            okhttp3.internal.concurrent.TaskQueue r0 = r8.cleanupQueue     // Catch:{ all -> 0x0142 }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r1 = r8.cleanupTask     // Catch:{ all -> 0x0142 }
            r2 = 0
            r4 = 2
            r5 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r0, r1, r2, r4, r5)     // Catch:{ all -> 0x0142 }
        L_0x0134:
            monitor-exit(r8)
            return
        L_0x0136:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0142 }
            r10.<init>(r9)     // Catch:{ all -> 0x0142 }
            throw r10     // Catch:{ all -> 0x0142 }
        L_0x0142:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        Intrinsics.f(str, "key");
        return edit$default(this, str, 0, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r11, long r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)     // Catch:{ all -> 0x008f }
            r10.initialize()     // Catch:{ all -> 0x008f }
            r10.checkNotClosed()     // Catch:{ all -> 0x008f }
            r10.validateKey(r11)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r10.lruEntries     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x008f }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x008f }
            long r1 = ANY_SEQUENCE_NUMBER     // Catch:{ all -> 0x008f }
            r3 = 0
            int r4 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0028
            long r1 = r0.getSequenceNumber$okhttp()     // Catch:{ all -> 0x008f }
            int r4 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            monitor-exit(r10)
            return r3
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            okhttp3.internal.cache.DiskLruCache$Editor r12 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x008f }
            goto L_0x0032
        L_0x0031:
            r12 = r3
        L_0x0032:
            if (r12 == 0) goto L_0x0036
            monitor-exit(r10)
            return r3
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            int r12 = r0.getLockingSourceCount$okhttp()     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x0040
            monitor-exit(r10)
            return r3
        L_0x0040:
            boolean r12 = r10.mostRecentTrimFailed     // Catch:{ all -> 0x008f }
            if (r12 != 0) goto L_0x0082
            boolean r12 = r10.mostRecentRebuildFailed     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x0049
            goto L_0x0082
        L_0x0049:
            okio.BufferedSink r12 = r10.journalWriter     // Catch:{ all -> 0x008f }
            kotlin.jvm.internal.Intrinsics.c(r12)     // Catch:{ all -> 0x008f }
            java.lang.String r13 = DIRTY     // Catch:{ all -> 0x008f }
            okio.BufferedSink r13 = r12.w(r13)     // Catch:{ all -> 0x008f }
            r1 = 32
            okio.BufferedSink r13 = r13.writeByte(r1)     // Catch:{ all -> 0x008f }
            okio.BufferedSink r13 = r13.w(r11)     // Catch:{ all -> 0x008f }
            r1 = 10
            r13.writeByte(r1)     // Catch:{ all -> 0x008f }
            r12.flush()     // Catch:{ all -> 0x008f }
            boolean r12 = r10.hasJournalErrors     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x006c
            monitor-exit(r10)
            return r3
        L_0x006c:
            if (r0 != 0) goto L_0x0078
            okhttp3.internal.cache.DiskLruCache$Entry r0 = new okhttp3.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x008f }
            r0.<init>(r10, r11)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r12 = r10.lruEntries     // Catch:{ all -> 0x008f }
            r12.put(r11, r0)     // Catch:{ all -> 0x008f }
        L_0x0078:
            okhttp3.internal.cache.DiskLruCache$Editor r11 = new okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x008f }
            r11.<init>(r10, r0)     // Catch:{ all -> 0x008f }
            r0.setCurrentEditor$okhttp(r11)     // Catch:{ all -> 0x008f }
            monitor-exit(r10)
            return r11
        L_0x0082:
            okhttp3.internal.concurrent.TaskQueue r4 = r10.cleanupQueue     // Catch:{ all -> 0x008f }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r5 = r10.cleanupTask     // Catch:{ all -> 0x008f }
            r6 = 0
            r8 = 2
            r9 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r4, r5, r6, r8, r9)     // Catch:{ all -> 0x008f }
            monitor-exit(r10)
            return r3
        L_0x008f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        Intrinsics.e(values, "lruEntries.values");
        for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
            Intrinsics.e(entry, "entry");
            removeEntry$okhttp(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.c(bufferedSink);
            bufferedSink.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)     // Catch:{ all -> 0x0057 }
            r7.initialize()     // Catch:{ all -> 0x0057 }
            r7.checkNotClosed()     // Catch:{ all -> 0x0057 }
            r7.validateKey(r8)     // Catch:{ all -> 0x0057 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r7.lruEntries     // Catch:{ all -> 0x0057 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0057 }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0057 }
            r1 = 0
            if (r0 != 0) goto L_0x001c
            monitor-exit(r7)
            return r1
        L_0x001c:
            okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.snapshot$okhttp()     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0024
            monitor-exit(r7)
            return r1
        L_0x0024:
            int r1 = r7.redundantOpCount     // Catch:{ all -> 0x0057 }
            int r1 = r1 + 1
            r7.redundantOpCount = r1     // Catch:{ all -> 0x0057 }
            okio.BufferedSink r1 = r7.journalWriter     // Catch:{ all -> 0x0057 }
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = READ     // Catch:{ all -> 0x0057 }
            okio.BufferedSink r1 = r1.w(r2)     // Catch:{ all -> 0x0057 }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0057 }
            okio.BufferedSink r8 = r1.w(r8)     // Catch:{ all -> 0x0057 }
            r1 = 10
            r8.writeByte(r1)     // Catch:{ all -> 0x0057 }
            boolean r8 = r7.journalRebuildRequired()     // Catch:{ all -> 0x0057 }
            if (r8 == 0) goto L_0x0055
            okhttp3.internal.concurrent.TaskQueue r1 = r7.cleanupQueue     // Catch:{ all -> 0x0057 }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r2 = r7.cleanupTask     // Catch:{ all -> 0x0057 }
            r3 = 0
            r5 = 2
            r6 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r7)
            return r0
        L_0x0057:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
        }
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e2) {
                    Platform platform = Platform.Companion.get();
                    platform.log("DiskLruCache " + this.directory + " is corrupt: " + e2.getMessage() + ", removing", 5, e2);
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void rebuildJournal$okhttp() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            okio.BufferedSink r0 = r6.journalWriter     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00c5 }
        L_0x0008:
            okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r6.journalFileTmp     // Catch:{ all -> 0x00c5 }
            okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r0 = okio.Okio.c(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = MAGIC     // Catch:{ all -> 0x00be }
            okio.BufferedSink r1 = r0.w(r1)     // Catch:{ all -> 0x00be }
            r2 = 10
            r1.writeByte(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = VERSION_1     // Catch:{ all -> 0x00be }
            okio.BufferedSink r1 = r0.w(r1)     // Catch:{ all -> 0x00be }
            r1.writeByte(r2)     // Catch:{ all -> 0x00be }
            int r1 = r6.appVersion     // Catch:{ all -> 0x00be }
            long r3 = (long) r1     // Catch:{ all -> 0x00be }
            okio.BufferedSink r1 = r0.O(r3)     // Catch:{ all -> 0x00be }
            r1.writeByte(r2)     // Catch:{ all -> 0x00be }
            int r1 = r6.valueCount     // Catch:{ all -> 0x00be }
            long r3 = (long) r1     // Catch:{ all -> 0x00be }
            okio.BufferedSink r1 = r0.O(r3)     // Catch:{ all -> 0x00be }
            r1.writeByte(r2)     // Catch:{ all -> 0x00be }
            r0.writeByte(r2)     // Catch:{ all -> 0x00be }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r1 = r6.lruEntries     // Catch:{ all -> 0x00be }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x00be }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00be }
        L_0x0049:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00be }
            okhttp3.internal.cache.DiskLruCache$Entry r3 = (okhttp3.internal.cache.DiskLruCache.Entry) r3     // Catch:{ all -> 0x00be }
            okhttp3.internal.cache.DiskLruCache$Editor r4 = r3.getCurrentEditor$okhttp()     // Catch:{ all -> 0x00be }
            r5 = 32
            if (r4 == 0) goto L_0x0071
            java.lang.String r4 = DIRTY     // Catch:{ all -> 0x00be }
            okio.BufferedSink r4 = r0.w(r4)     // Catch:{ all -> 0x00be }
            r4.writeByte(r5)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r3.getKey$okhttp()     // Catch:{ all -> 0x00be }
            r0.w(r3)     // Catch:{ all -> 0x00be }
            r0.writeByte(r2)     // Catch:{ all -> 0x00be }
            goto L_0x0049
        L_0x0071:
            java.lang.String r4 = CLEAN     // Catch:{ all -> 0x00be }
            okio.BufferedSink r4 = r0.w(r4)     // Catch:{ all -> 0x00be }
            r4.writeByte(r5)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r3.getKey$okhttp()     // Catch:{ all -> 0x00be }
            r0.w(r4)     // Catch:{ all -> 0x00be }
            r3.writeLengths$okhttp(r0)     // Catch:{ all -> 0x00be }
            r0.writeByte(r2)     // Catch:{ all -> 0x00be }
            goto L_0x0049
        L_0x0088:
            kotlin.Unit r1 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00be }
            r1 = 0
            kotlin.io.CloseableKt.a(r0, r1)     // Catch:{ all -> 0x00c5 }
            okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r6.journalFile     // Catch:{ all -> 0x00c5 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x00a1
            okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r6.journalFile     // Catch:{ all -> 0x00c5 }
            java.io.File r2 = r6.journalFileBackup     // Catch:{ all -> 0x00c5 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00c5 }
        L_0x00a1:
            okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r6.journalFileTmp     // Catch:{ all -> 0x00c5 }
            java.io.File r2 = r6.journalFile     // Catch:{ all -> 0x00c5 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00c5 }
            okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r6.journalFileBackup     // Catch:{ all -> 0x00c5 }
            r0.delete(r1)     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r0 = r6.newJournalWriter()     // Catch:{ all -> 0x00c5 }
            r6.journalWriter = r0     // Catch:{ all -> 0x00c5 }
            r0 = 0
            r6.hasJournalErrors = r0     // Catch:{ all -> 0x00c5 }
            r6.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x00c5 }
            monitor-exit(r6)
            return
        L_0x00be:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r0, r1)     // Catch:{ all -> 0x00c5 }
            throw r2     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.rebuildJournal$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)     // Catch:{ all -> 0x002e }
            r6.initialize()     // Catch:{ all -> 0x002e }
            r6.checkNotClosed()     // Catch:{ all -> 0x002e }
            r6.validateKey(r7)     // Catch:{ all -> 0x002e }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r6.lruEntries     // Catch:{ all -> 0x002e }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x002e }
            okhttp3.internal.cache.DiskLruCache$Entry r7 = (okhttp3.internal.cache.DiskLruCache.Entry) r7     // Catch:{ all -> 0x002e }
            r0 = 0
            if (r7 != 0) goto L_0x001c
            monitor-exit(r6)
            return r0
        L_0x001c:
            boolean r7 = r6.removeEntry$okhttp(r7)     // Catch:{ all -> 0x002e }
            if (r7 == 0) goto L_0x002c
            long r1 = r6.size     // Catch:{ all -> 0x002e }
            long r3 = r6.maxSize     // Catch:{ all -> 0x002e }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002c
            r6.mostRecentTrimFailed = r0     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r6)
            return r7
        L_0x002e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        BufferedSink bufferedSink;
        Intrinsics.f(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.w(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.w(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i2 = this.valueCount;
        for (int i3 = 0; i3 < i2; i3++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i3));
            this.size -= entry.getLengths$okhttp()[i3];
            entry.getLengths$okhttp()[i3] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.w(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.w(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z2) {
        this.closed = z2;
    }

    public final synchronized void setMaxSize(long j2) {
        this.maxSize = j2;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }
}

package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f16183b;

    /* renamed from: c  reason: collision with root package name */
    private final File f16184c;

    /* renamed from: d  reason: collision with root package name */
    private final File f16185d;

    /* renamed from: e  reason: collision with root package name */
    private final File f16186e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16187f;

    /* renamed from: g  reason: collision with root package name */
    private long f16188g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f16189h;

    /* renamed from: i  reason: collision with root package name */
    private long f16190i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Writer f16191j;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, Entry> f16192k = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f16193l;

    /* renamed from: m  reason: collision with root package name */
    private long f16194m = 0;

    /* renamed from: n  reason: collision with root package name */
    final ThreadPoolExecutor f16195n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());

    /* renamed from: o  reason: collision with root package name */
    private final Callable<Void> f16196o = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.bumptech.glide.disklrucache.DiskLruCache r0 = com.bumptech.glide.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f16191j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.x0()     // Catch:{ all -> 0x0028 }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.p0()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.u0()     // Catch:{ all -> 0x0028 }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f16193l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.AnonymousClass1.call():java.lang.Void");
        }
    };

    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Entry f16198a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f16199b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16200c;

        public void a() throws IOException {
            DiskLruCache.this.D(this, false);
        }

        public void b() {
            if (!this.f16200c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            DiskLruCache.this.D(this, true);
            this.f16200c = true;
        }

        public File f(int i2) throws IOException {
            File k2;
            synchronized (DiskLruCache.this) {
                if (this.f16198a.f16207f == this) {
                    if (!this.f16198a.f16206e) {
                        this.f16199b[i2] = true;
                    }
                    k2 = this.f16198a.k(i2);
                    if (!DiskLruCache.this.f16183b.exists()) {
                        DiskLruCache.this.f16183b.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k2;
        }

        private Editor(Entry entry) {
            this.f16198a = entry;
            this.f16199b = entry.f16206e ? null : new boolean[DiskLruCache.this.f16189h];
        }
    }

    private final class Entry {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f16202a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f16203b;

        /* renamed from: c  reason: collision with root package name */
        File[] f16204c;

        /* renamed from: d  reason: collision with root package name */
        File[] f16205d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f16206e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Editor f16207f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f16208g;

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f16189h) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f16203b[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i2) {
            return this.f16204c[i2];
        }

        public File k(int i2) {
            return this.f16205d[i2];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f16203b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        private Entry(String str) {
            this.f16202a = str;
            this.f16203b = new long[DiskLruCache.this.f16189h];
            this.f16204c = new File[DiskLruCache.this.f16189h];
            this.f16205d = new File[DiskLruCache.this.f16189h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.f16189h; i2++) {
                sb.append(i2);
                this.f16204c[i2] = new File(DiskLruCache.this.f16183b, sb.toString());
                sb.append(DefaultDiskStorage.FileType.TEMP);
                this.f16205d[i2] = new File(DiskLruCache.this.f16183b, sb.toString());
                sb.setLength(length);
            }
        }
    }

    public final class Value {

        /* renamed from: a  reason: collision with root package name */
        private final String f16210a;

        /* renamed from: b  reason: collision with root package name */
        private final long f16211b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f16212c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f16213d;

        public File a(int i2) {
            return this.f16213d[i2];
        }

        private Value(String str, long j2, File[] fileArr, long[] jArr) {
            this.f16210a = str;
            this.f16211b = j2;
            this.f16213d = fileArr;
            this.f16212c = jArr;
        }
    }

    private DiskLruCache(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f16183b = file2;
        this.f16187f = i2;
        this.f16184c = new File(file2, "journal");
        this.f16185d = new File(file2, "journal.tmp");
        this.f16186e = new File(file2, "journal.bkp");
        this.f16189h = i3;
        this.f16188g = j2;
    }

    private void A() {
        if (this.f16191j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void B(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void D(com.bumptech.glide.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = r10.f16198a     // Catch:{ all -> 0x010e }
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r1 = r0.f16207f     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f16206e     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f16189h     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f16199b     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.a()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.a()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.f16189h     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f16203b     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f16203b     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f16190i     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f16190i = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            H(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f16193l     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.f16193l = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f16207f = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f16206e     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f16206e = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.f16202a     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.l()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.f16194m     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.f16194m = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f16208g = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r10 = r9.f16192k     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f16202a     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f16202a     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f16191j     // Catch:{ all -> 0x010e }
            m0(r10)     // Catch:{ all -> 0x010e }
            long r10 = r9.f16190i     // Catch:{ all -> 0x010e }
            long r0 = r9.f16188g     // Catch:{ all -> 0x010e }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ff
            boolean r10 = r9.p0()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f16195n     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f16196o     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.D(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    private static void H(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bumptech.glide.disklrucache.DiskLruCache.Editor j0(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.A()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r5.f16192k     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.f16208g     // Catch:{ all -> 0x005d }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = new com.bumptech.glide.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x005d }
            r0.<init>(r6)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r7 = r5.f16192k     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = r0.f16207f     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r3
        L_0x0034:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = new com.bumptech.glide.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x005d }
            r7.<init>(r0)     // Catch:{ all -> 0x005d }
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f16207f = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f16191j     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f16191j     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f16191j     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f16191j     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f16191j     // Catch:{ all -> 0x005d }
            m0(r6)     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.j0(java.lang.String, long):com.bumptech.glide.disklrucache.DiskLruCache$Editor");
    }

    @TargetApi(26)
    private static void m0(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    public boolean p0() {
        int i2 = this.f16193l;
        if (i2 < 2000 || i2 < this.f16192k.size()) {
            return false;
        }
        return true;
    }

    public static DiskLruCache q0(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    w0(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i2, i3, j2);
            if (diskLruCache.f16184c.exists()) {
                try {
                    diskLruCache.s0();
                    diskLruCache.r0();
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.E();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i3, j2);
            diskLruCache2.u0();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void r0() throws IOException {
        H(this.f16185d);
        Iterator<Entry> it2 = this.f16192k.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            int i2 = 0;
            if (next.f16207f == null) {
                while (i2 < this.f16189h) {
                    this.f16190i += next.f16203b[i2];
                    i2++;
                }
            } else {
                Editor unused = next.f16207f = null;
                while (i2 < this.f16189h) {
                    H(next.j(i2));
                    H(next.k(i2));
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f16193l = r0 - r9.f16192k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.i() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        u0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f16191j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f16184c, true), com.bumptech.glide.disklrucache.Util.f16221a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s0() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.bumptech.glide.disklrucache.StrictLineReader r1 = new com.bumptech.glide.disklrucache.StrictLineReader
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f16184c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bumptech.glide.disklrucache.Util.f16221a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.k()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.k()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.k()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.k()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.k()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f16187f     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f16189h     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.k()     // Catch:{ EOFException -> 0x005f }
            r9.t0(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r2 = r9.f16192k     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f16193l = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.i()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.u0()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f16184c     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = com.bumptech.glide.disklrucache.Util.f16221a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f16191j = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            com.bumptech.glide.disklrucache.Util.a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            com.bumptech.glide.disklrucache.Util.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.s0():void");
    }

    private void t0(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f16192k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = this.f16192k.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.f16192k.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = entry.f16206e = true;
                Editor unused2 = entry.f16207f = null;
                entry.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                Editor unused3 = entry.f16207f = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void u0() throws IOException {
        Writer writer = this.f16191j;
        if (writer != null) {
            B(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16185d), Util.f16221a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write("1");
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(Integer.toString(this.f16187f));
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(Integer.toString(this.f16189h));
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            for (Entry next : this.f16192k.values()) {
                if (next.f16207f != null) {
                    bufferedWriter.write("DIRTY " + next.f16202a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f16202a + next.l() + 10);
                }
            }
            B(bufferedWriter);
            if (this.f16184c.exists()) {
                w0(this.f16184c, this.f16186e, true);
            }
            w0(this.f16185d, this.f16184c, false);
            this.f16186e.delete();
            this.f16191j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16184c, true), Util.f16221a));
        } catch (Throwable th) {
            B(bufferedWriter);
            throw th;
        }
    }

    private static void w0(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            H(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void x0() throws IOException {
        while (this.f16190i > this.f16188g) {
            v0((String) this.f16192k.entrySet().iterator().next().getKey());
        }
    }

    public void E() throws IOException {
        close();
        Util.b(this.f16183b);
    }

    public Editor L(String str) throws IOException {
        return j0(str, -1);
    }

    public synchronized void close() throws IOException {
        if (this.f16191j != null) {
            Iterator it2 = new ArrayList(this.f16192k.values()).iterator();
            while (it2.hasNext()) {
                Entry entry = (Entry) it2.next();
                if (entry.f16207f != null) {
                    entry.f16207f.a();
                }
            }
            x0();
            B(this.f16191j);
            this.f16191j = null;
        }
    }

    public synchronized Value o0(String str) throws IOException {
        A();
        Entry entry = this.f16192k.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f16206e) {
            return null;
        }
        for (File exists : entry.f16204c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f16193l++;
        this.f16191j.append("READ");
        this.f16191j.append(' ');
        this.f16191j.append(str);
        this.f16191j.append(10);
        if (p0()) {
            this.f16195n.submit(this.f16196o);
        }
        return new Value(str, entry.f16208g, entry.f16204c, entry.f16203b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean v0(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.A()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r7.f16192k     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r2 = r0.f16207f     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f16189h     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.f16190i     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f16203b     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f16190i = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f16203b     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.f16193l     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.f16193l = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f16191j     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f16191j     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f16191j     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f16191j     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r7.f16192k     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.p0()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f16195n     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f16196o     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.v0(java.lang.String):boolean");
    }
}

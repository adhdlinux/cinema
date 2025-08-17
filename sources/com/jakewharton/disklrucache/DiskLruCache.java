package com.jakewharton.disklrucache;

import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {

    /* renamed from: p  reason: collision with root package name */
    static final Pattern f31800p = Pattern.compile("[a-z0-9_-]{1,64}");
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final OutputStream f31801q = new OutputStream() {
        public void write(int i2) throws IOException {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f31802b;

    /* renamed from: c  reason: collision with root package name */
    private final File f31803c;

    /* renamed from: d  reason: collision with root package name */
    private final File f31804d;

    /* renamed from: e  reason: collision with root package name */
    private final File f31805e;

    /* renamed from: f  reason: collision with root package name */
    private final int f31806f;

    /* renamed from: g  reason: collision with root package name */
    private long f31807g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f31808h;

    /* renamed from: i  reason: collision with root package name */
    private long f31809i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Writer f31810j;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, Entry> f31811k = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f31812l;

    /* renamed from: m  reason: collision with root package name */
    private long f31813m = 0;

    /* renamed from: n  reason: collision with root package name */
    final ThreadPoolExecutor f31814n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: o  reason: collision with root package name */
    private final Callable<Void> f31815o = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f31810j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.y0()     // Catch:{ all -> 0x0028 }
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.q0()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.v0()     // Catch:{ all -> 0x0028 }
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f31812l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.AnonymousClass1.call():java.lang.Void");
        }
    };

    public final class Editor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Entry f31817a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f31818b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f31819c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31820d;

        private class FaultHidingOutputStream extends FilterOutputStream {
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.f31819c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.f31819c = true;
                }
            }

            public void write(int i2) {
                try {
                    this.out.write(i2);
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.f31819c = true;
                }
            }

            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i2, int i3) {
                try {
                    this.out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.f31819c = true;
                }
            }
        }

        public void a() throws IOException {
            DiskLruCache.this.E(this, false);
        }

        public void e() throws IOException {
            if (this.f31819c) {
                DiskLruCache.this.E(this, false);
                DiskLruCache.this.w0(this.f31817a.f31823a);
            } else {
                DiskLruCache.this.E(this, true);
            }
            this.f31820d = true;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream f(int r4) throws java.io.IOException {
            /*
                r3 = this;
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.f31817a     // Catch:{ all -> 0x0046 }
                com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r1.f31826d     // Catch:{ all -> 0x0046 }
                if (r1 != r3) goto L_0x0040
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.f31817a     // Catch:{ all -> 0x0046 }
                boolean r1 = r1.f31825c     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x0018
                boolean[] r1 = r3.f31818b     // Catch:{ all -> 0x0046 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0046 }
            L_0x0018:
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.f31817a     // Catch:{ all -> 0x0046 }
                java.io.File r4 = r1.k(r4)     // Catch:{ all -> 0x0046 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0024 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0024 }
                goto L_0x0032
            L_0x0024:
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0046 }
                java.io.File r1 = r1.f31802b     // Catch:{ all -> 0x0046 }
                r1.mkdirs()     // Catch:{ all -> 0x0046 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003a }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003a }
            L_0x0032:
                com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream r4 = new com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream     // Catch:{ all -> 0x0046 }
                r2 = 0
                r4.<init>(r1)     // Catch:{ all -> 0x0046 }
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return r4
            L_0x003a:
                java.io.OutputStream r4 = com.jakewharton.disklrucache.DiskLruCache.f31801q     // Catch:{ all -> 0x0046 }
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return r4
            L_0x0040:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0046 }
                r4.<init>()     // Catch:{ all -> 0x0046 }
                throw r4     // Catch:{ all -> 0x0046 }
            L_0x0046:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.f(int):java.io.OutputStream");
        }

        public void g(int i2, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(f(i2), Util.f31841b);
                try {
                    outputStreamWriter2.write(str);
                    Util.a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    Util.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Util.a(outputStreamWriter);
                throw th;
            }
        }

        private Editor(Entry entry) {
            this.f31817a = entry;
            this.f31818b = entry.f31825c ? null : new boolean[DiskLruCache.this.f31808h];
        }
    }

    private final class Entry {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f31823a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f31824b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f31825c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Editor f31826d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public long f31827e;

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f31808h) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f31824b[i2] = Long.parseLong(strArr[i2]);
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
            File q2 = DiskLruCache.this.f31802b;
            return new File(q2, this.f31823a + "." + i2);
        }

        public File k(int i2) {
            File q2 = DiskLruCache.this.f31802b;
            return new File(q2, this.f31823a + "." + i2 + DefaultDiskStorage.FileType.TEMP);
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f31824b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        private Entry(String str) {
            this.f31823a = str;
            this.f31824b = new long[DiskLruCache.this.f31808h];
        }
    }

    public final class Snapshot implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f31829b;

        /* renamed from: c  reason: collision with root package name */
        private final long f31830c;

        /* renamed from: d  reason: collision with root package name */
        private final InputStream[] f31831d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f31832e;

        public InputStream a(int i2) {
            return this.f31831d[i2];
        }

        public void close() {
            for (InputStream a2 : this.f31831d) {
                Util.a(a2);
            }
        }

        public String getString(int i2) throws IOException {
            return DiskLruCache.p0(a(i2));
        }

        private Snapshot(String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            this.f31829b = str;
            this.f31830c = j2;
            this.f31831d = inputStreamArr;
            this.f31832e = jArr;
        }
    }

    private DiskLruCache(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f31802b = file2;
        this.f31806f = i2;
        this.f31803c = new File(file2, "journal");
        this.f31804d = new File(file2, "journal.tmp");
        this.f31805e = new File(file2, "journal.bkp");
        this.f31808h = i3;
        this.f31807g = j2;
    }

    private void D() {
        if (this.f31810j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void E(com.jakewharton.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = r10.f31817a     // Catch:{ all -> 0x0110 }
            com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r0.f31826d     // Catch:{ all -> 0x0110 }
            if (r1 != r10) goto L_0x010a
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f31825c     // Catch:{ all -> 0x0110 }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f31808h     // Catch:{ all -> 0x0110 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f31818b     // Catch:{ all -> 0x0110 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x0110 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0110 }
            if (r3 != 0) goto L_0x0030
            r10.a()     // Catch:{ all -> 0x0110 }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.a()     // Catch:{ all -> 0x0110 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.<init>(r11)     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x004d:
            int r10 = r9.f31808h     // Catch:{ all -> 0x0110 }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0110 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.f31824b     // Catch:{ all -> 0x0110 }
            r3 = r10[r1]     // Catch:{ all -> 0x0110 }
            long r5 = r2.length()     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.f31824b     // Catch:{ all -> 0x0110 }
            r10[r1] = r5     // Catch:{ all -> 0x0110 }
            long r7 = r9.f31809i     // Catch:{ all -> 0x0110 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f31809i = r7     // Catch:{ all -> 0x0110 }
            goto L_0x007e
        L_0x007b:
            L(r10)     // Catch:{ all -> 0x0110 }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f31812l     // Catch:{ all -> 0x0110 }
            r1 = 1
            int r10 = r10 + r1
            r9.f31812l = r10     // Catch:{ all -> 0x0110 }
            r10 = 0
            com.jakewharton.disklrucache.DiskLruCache.Editor unused = r0.f31826d = r10     // Catch:{ all -> 0x0110 }
            boolean r10 = r0.f31825c     // Catch:{ all -> 0x0110 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00c8
            boolean unused = r0.f31825c = r1     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f31810j     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r1.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.f31823a     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.l()     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x00ee
            long r10 = r9.f31813m     // Catch:{ all -> 0x0110 }
            r1 = 1
            long r1 = r1 + r10
            r9.f31813m = r1     // Catch:{ all -> 0x0110 }
            long unused = r0.f31827e = r10     // Catch:{ all -> 0x0110 }
            goto L_0x00ee
        L_0x00c8:
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r10 = r9.f31811k     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.f31823a     // Catch:{ all -> 0x0110 }
            r10.remove(r11)     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f31810j     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = r0.f31823a     // Catch:{ all -> 0x0110 }
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r11)     // Catch:{ all -> 0x0110 }
        L_0x00ee:
            java.io.Writer r10 = r9.f31810j     // Catch:{ all -> 0x0110 }
            r10.flush()     // Catch:{ all -> 0x0110 }
            long r10 = r9.f31809i     // Catch:{ all -> 0x0110 }
            long r0 = r9.f31807g     // Catch:{ all -> 0x0110 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0101
            boolean r10 = r9.q0()     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0108
        L_0x0101:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f31814n     // Catch:{ all -> 0x0110 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f31815o     // Catch:{ all -> 0x0110 }
            r10.submit(r11)     // Catch:{ all -> 0x0110 }
        L_0x0108:
            monitor-exit(r9)
            return
        L_0x010a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            r10.<init>()     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.E(com.jakewharton.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    private static void L(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.jakewharton.disklrucache.DiskLruCache.Editor m0(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.D()     // Catch:{ all -> 0x0061 }
            r5.z0(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r5.f31811k     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.f31827e     // Catch:{ all -> 0x0061 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = new com.jakewharton.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x0061 }
            r0.<init>(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r7 = r5.f31811k     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            com.jakewharton.disklrucache.DiskLruCache$Editor r7 = r0.f31826d     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r3
        L_0x0037:
            com.jakewharton.disklrucache.DiskLruCache$Editor r7 = new com.jakewharton.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x0061 }
            r7.<init>(r0)     // Catch:{ all -> 0x0061 }
            com.jakewharton.disklrucache.DiskLruCache.Editor unused = r0.f31826d = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.f31810j     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.f31810j     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.m0(java.lang.String, long):com.jakewharton.disklrucache.DiskLruCache$Editor");
    }

    /* access modifiers changed from: private */
    public static String p0(InputStream inputStream) throws IOException {
        return Util.c(new InputStreamReader(inputStream, Util.f31841b));
    }

    /* access modifiers changed from: private */
    public boolean q0() {
        int i2 = this.f31812l;
        return i2 >= 2000 && i2 >= this.f31811k.size();
    }

    public static DiskLruCache r0(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    x0(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i2, i3, j2);
            if (diskLruCache.f31803c.exists()) {
                try {
                    diskLruCache.t0();
                    diskLruCache.s0();
                    diskLruCache.f31810j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f31803c, true), Util.f31840a));
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.H();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i3, j2);
            diskLruCache2.v0();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void s0() throws IOException {
        L(this.f31804d);
        Iterator<Entry> it2 = this.f31811k.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            int i2 = 0;
            if (next.f31826d == null) {
                while (i2 < this.f31808h) {
                    this.f31809i += next.f31824b[i2];
                    i2++;
                }
            } else {
                Editor unused = next.f31826d = null;
                while (i2 < this.f31808h) {
                    L(next.j(i2));
                    L(next.k(i2));
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f31812l = r0 - r9.f31811k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x006c=Splitter:B:20:0x006c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t0() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.jakewharton.disklrucache.StrictLineReader r1 = new com.jakewharton.disklrucache.StrictLineReader
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f31803c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.jakewharton.disklrucache.Util.f31840a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.i()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = r1.i()     // Catch:{ all -> 0x009a }
            java.lang.String r4 = r1.i()     // Catch:{ all -> 0x009a }
            java.lang.String r5 = r1.i()     // Catch:{ all -> 0x009a }
            java.lang.String r6 = r1.i()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x006c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x006c
            int r7 = r9.f31806f     // Catch:{ all -> 0x009a }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x009a }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            int r4 = r9.f31808h     // Catch:{ all -> 0x009a }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x009a }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.i()     // Catch:{ EOFException -> 0x005f }
            r9.u0(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r2 = r9.f31811k     // Catch:{ all -> 0x009a }
            int r2 = r2.size()     // Catch:{ all -> 0x009a }
            int r0 = r0 - r2
            r9.f31812l = r0     // Catch:{ all -> 0x009a }
            com.jakewharton.disklrucache.Util.a(r1)
            return
        L_0x006c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r7.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x009a }
            r7.append(r2)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r3)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r5)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r6)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x009a }
            r4.<init>(r0)     // Catch:{ all -> 0x009a }
            throw r4     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            com.jakewharton.disklrucache.Util.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.t0():void");
    }

    private void u0(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f31811k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = this.f31811k.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.f31811k.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = entry.f31825c = true;
                Editor unused2 = entry.f31826d = null;
                entry.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                Editor unused3 = entry.f31826d = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void v0() throws IOException {
        Writer writer = this.f31810j;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31804d), Util.f31840a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write("1");
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(Integer.toString(this.f31806f));
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(Integer.toString(this.f31808h));
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            for (Entry next : this.f31811k.values()) {
                if (next.f31826d != null) {
                    bufferedWriter.write("DIRTY " + next.f31823a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f31823a + next.l() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f31803c.exists()) {
                x0(this.f31803c, this.f31805e, true);
            }
            x0(this.f31804d, this.f31803c, false);
            this.f31805e.delete();
            this.f31810j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31803c, true), Util.f31840a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void x0(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            L(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void y0() throws IOException {
        while (this.f31809i > this.f31807g) {
            w0((String) this.f31811k.entrySet().iterator().next().getKey());
        }
    }

    private void z0(String str) {
        if (!f31800p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public void H() throws IOException {
        close();
        Util.b(this.f31802b);
    }

    public synchronized void close() throws IOException {
        if (this.f31810j != null) {
            Iterator it2 = new ArrayList(this.f31811k.values()).iterator();
            while (it2.hasNext()) {
                Entry entry = (Entry) it2.next();
                if (entry.f31826d != null) {
                    entry.f31826d.a();
                }
            }
            y0();
            this.f31810j.close();
            this.f31810j = null;
        }
    }

    public Editor j0(String str) throws IOException {
        return m0(str, -1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f31812l++;
        r11.f31810j.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (q0() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r11.f31814n.submit(r11.f31815o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return new com.jakewharton.disklrucache.DiskLruCache.Snapshot(r11, r12, com.jakewharton.disklrucache.DiskLruCache.Entry.c(r0), r8, com.jakewharton.disklrucache.DiskLruCache.Entry.a(r0), (com.jakewharton.disklrucache.DiskLruCache.AnonymousClass1) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.jakewharton.disklrucache.DiskLruCache.Snapshot o0(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.D()     // Catch:{ all -> 0x0085 }
            r11.z0(r12)     // Catch:{ all -> 0x0085 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r11.f31811k     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0085 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0085 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.f31825c     // Catch:{ all -> 0x0085 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.f31808h     // Catch:{ all -> 0x0085 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0085 }
            r2 = 0
            r3 = 0
        L_0x0022:
            int r4 = r11.f31808h     // Catch:{ FileNotFoundException -> 0x0075 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0075 }
            java.io.File r5 = r0.j(r3)     // Catch:{ FileNotFoundException -> 0x0075 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0075 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0075 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.f31812l     // Catch:{ all -> 0x0085 }
            int r1 = r1 + 1
            r11.f31812l = r1     // Catch:{ all -> 0x0085 }
            java.io.Writer r1 = r11.f31810j     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r2.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x0085 }
            r2.append(r12)     // Catch:{ all -> 0x0085 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0085 }
            r1.append(r2)     // Catch:{ all -> 0x0085 }
            boolean r1 = r11.q0()     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0062
            java.util.concurrent.ThreadPoolExecutor r1 = r11.f31814n     // Catch:{ all -> 0x0085 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f31815o     // Catch:{ all -> 0x0085 }
            r1.submit(r2)     // Catch:{ all -> 0x0085 }
        L_0x0062:
            com.jakewharton.disklrucache.DiskLruCache$Snapshot r1 = new com.jakewharton.disklrucache.DiskLruCache$Snapshot     // Catch:{ all -> 0x0085 }
            long r6 = r0.f31827e     // Catch:{ all -> 0x0085 }
            long[] r9 = r0.f31824b     // Catch:{ all -> 0x0085 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x0085 }
            monitor-exit(r11)
            return r1
        L_0x0075:
            int r12 = r11.f31808h     // Catch:{ all -> 0x0085 }
            if (r2 >= r12) goto L_0x0083
            r12 = r8[r2]     // Catch:{ all -> 0x0085 }
            if (r12 == 0) goto L_0x0083
            com.jakewharton.disklrucache.Util.a(r12)     // Catch:{ all -> 0x0085 }
            int r2 = r2 + 1
            goto L_0x0075
        L_0x0083:
            monitor-exit(r11)
            return r1
        L_0x0085:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.o0(java.lang.String):com.jakewharton.disklrucache.DiskLruCache$Snapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean w0(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.D()     // Catch:{ all -> 0x0093 }
            r7.z0(r8)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r7.f31811k     // Catch:{ all -> 0x0093 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0093 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0093 }
            r1 = 0
            if (r0 == 0) goto L_0x0091
            com.jakewharton.disklrucache.DiskLruCache$Editor r2 = r0.f31826d     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0091
        L_0x001a:
            int r2 = r7.f31808h     // Catch:{ all -> 0x0093 }
            if (r1 >= r2) goto L_0x005c
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0093 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0046
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r0.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0093 }
            r0.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
            r8.<init>(r0)     // Catch:{ all -> 0x0093 }
            throw r8     // Catch:{ all -> 0x0093 }
        L_0x0046:
            long r2 = r7.f31809i     // Catch:{ all -> 0x0093 }
            long[] r4 = r0.f31824b     // Catch:{ all -> 0x0093 }
            r5 = r4[r1]     // Catch:{ all -> 0x0093 }
            long r2 = r2 - r5
            r7.f31809i = r2     // Catch:{ all -> 0x0093 }
            long[] r2 = r0.f31824b     // Catch:{ all -> 0x0093 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0093 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005c:
            int r0 = r7.f31812l     // Catch:{ all -> 0x0093 }
            r1 = 1
            int r0 = r0 + r1
            r7.f31812l = r0     // Catch:{ all -> 0x0093 }
            java.io.Writer r0 = r7.f31810j     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r2.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            r2.append(r8)     // Catch:{ all -> 0x0093 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0093 }
            r0.append(r2)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r7.f31811k     // Catch:{ all -> 0x0093 }
            r0.remove(r8)     // Catch:{ all -> 0x0093 }
            boolean r8 = r7.q0()     // Catch:{ all -> 0x0093 }
            if (r8 == 0) goto L_0x008f
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f31814n     // Catch:{ all -> 0x0093 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f31815o     // Catch:{ all -> 0x0093 }
            r8.submit(r0)     // Catch:{ all -> 0x0093 }
        L_0x008f:
            monitor-exit(r7)
            return r1
        L_0x0091:
            monitor-exit(r7)
            return r1
        L_0x0093:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.w0(java.lang.String):boolean");
    }
}

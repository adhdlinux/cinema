package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.zip.GZIPInputStream;

class w {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<Runnable> f13460a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f13461b;

    class a implements j0 {

        /* renamed from: com.adcolony.sdk.w$a$a  reason: collision with other inner class name */
        class C0005a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13463b;

            C0005a(h0 h0Var) {
                this.f13463b = h0Var;
            }

            public void run() {
                boolean unused = w.this.x(this.f13463b);
                w.this.b();
            }
        }

        a() {
        }

        public void a(h0 h0Var) {
            w.this.e(new C0005a(h0Var));
        }
    }

    class b implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13466b;

            a(h0 h0Var) {
                this.f13466b = h0Var;
            }

            public void run() {
                boolean unused = w.this.h(this.f13466b, new File(c0.E(this.f13466b.a(), "filepath")));
                w.this.b();
            }
        }

        b() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class c implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13469b;

            a(h0 h0Var) {
                this.f13469b = h0Var;
            }

            public void run() {
                boolean unused = w.this.s(this.f13469b);
                w.this.b();
            }
        }

        c() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class d implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13472b;

            a(h0 h0Var) {
                this.f13472b = h0Var;
            }

            public void run() {
                String unused = w.this.t(this.f13472b);
                w.this.b();
            }
        }

        d() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class e implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13475b;

            a(h0 h0Var) {
                this.f13475b = h0Var;
            }

            public void run() {
                boolean unused = w.this.v(this.f13475b);
                w.this.b();
            }
        }

        e() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class f implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13478b;

            a(h0 h0Var) {
                this.f13478b = h0Var;
            }

            public void run() {
                boolean unused = w.this.n(this.f13478b);
                w.this.b();
            }
        }

        f() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class g implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13481b;

            a(h0 h0Var) {
                this.f13481b = h0Var;
            }

            public void run() {
                boolean unused = w.this.p(this.f13481b);
                w.this.b();
            }
        }

        g() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class h implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13484b;

            a(h0 h0Var) {
                this.f13484b = h0Var;
            }

            public void run() {
                boolean unused = w.this.z(this.f13484b);
                w.this.b();
            }
        }

        h() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    class i implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13487b;

            a(h0 h0Var) {
                this.f13487b = h0Var;
            }

            public void run() {
                boolean unused = w.this.g(this.f13487b);
                w.this.b();
            }
        }

        i() {
        }

        public void a(h0 h0Var) {
            w.this.e(new a(h0Var));
        }
    }

    w() {
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f13461b = false;
        if (!this.f13460a.isEmpty()) {
            this.f13461b = true;
            this.f13460a.removeLast().run();
        }
    }

    /* access modifiers changed from: private */
    public void e(Runnable runnable) {
        if (!this.f13460a.isEmpty() || this.f13461b) {
            this.f13460a.push(runnable);
            return;
        }
        this.f13461b = true;
        runnable.run();
    }

    /* access modifiers changed from: private */
    public boolean g(h0 h0Var) {
        String E = c0.E(h0Var.a(), "filepath");
        a.f().O0().n();
        f1 q2 = c0.q();
        try {
            if (new File(E).mkdir()) {
                c0.w(q2, "success", true);
                h0Var.b(q2).e();
                return true;
            }
            c0.w(q2, "success", false);
            return false;
        } catch (Exception unused) {
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean h(h0 h0Var, File file) {
        a.f().O0().n();
        f1 q2 = c0.q();
        if (k(file)) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            return true;
        }
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    private boolean l(String str) {
        return new File(str).exists();
    }

    /* access modifiers changed from: private */
    public boolean n(h0 h0Var) {
        String E = c0.E(h0Var.a(), "filepath");
        a.f().O0().n();
        f1 q2 = c0.q();
        try {
            boolean l2 = l(E);
            c0.w(q2, "result", l2);
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            return l2;
        } catch (Exception e2) {
            c0.w(q2, "result", false);
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean p(h0 h0Var) {
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "filepath");
        a.f().O0().n();
        f1 q2 = c0.q();
        try {
            int A = c0.A(a2, "offset");
            int A2 = c0.A(a2, "size");
            boolean t2 = c0.t(a2, "gunzip");
            String E2 = c0.E(a2, "output_filepath");
            InputStream w0Var = new w0(new FileInputStream(E), A, A2);
            if (t2) {
                w0Var = new GZIPInputStream(w0Var, 1024);
            }
            if (E2.equals("")) {
                StringBuilder sb = new StringBuilder(w0Var.available());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = w0Var.read(bArr, 0, 1024);
                    if (read < 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, "ISO-8859-1"));
                }
                c0.u(q2, "size", sb.length());
                c0.n(q2, "data", sb.toString());
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(E2);
                byte[] bArr2 = new byte[1024];
                int i2 = 0;
                while (true) {
                    int read2 = w0Var.read(bArr2, 0, 1024);
                    if (read2 < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read2);
                    i2 += read2;
                }
                fileOutputStream.close();
                c0.u(q2, "size", i2);
            }
            w0Var.close();
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            return true;
        } catch (IOException unused) {
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        } catch (OutOfMemoryError unused2) {
            new e0.a().c("Out of memory error - disabling AdColony.").d(e0.f13113h);
            a.f().R(true);
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean s(h0 h0Var) {
        String E = c0.E(h0Var.a(), "filepath");
        a.f().O0().n();
        f1 q2 = c0.q();
        String[] list = new File(E).list();
        if (list != null) {
            e1 c2 = c0.c();
            for (String str : list) {
                f1 q3 = c0.q();
                c0.n(q3, "filename", str);
                if (new File(E + str).isDirectory()) {
                    c0.w(q3, "is_folder", true);
                } else {
                    c0.w(q3, "is_folder", false);
                }
                c0.i(c2, q3);
            }
            c0.w(q2, "success", true);
            c0.l(q2, "entries", c2);
            h0Var.b(q2).e();
            return true;
        }
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: private */
    public String t(h0 h0Var) {
        boolean z2;
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "filepath");
        String E2 = c0.E(a2, "encoding");
        if (E2 == null || !E2.equals("utf8")) {
            z2 = false;
        } else {
            z2 = true;
        }
        a.f().O0().n();
        f1 q2 = c0.q();
        try {
            StringBuilder a3 = a(E, z2);
            c0.w(q2, "success", true);
            c0.n(q2, "data", a3.toString());
            h0Var.b(q2).e();
            return a3.toString();
        } catch (IOException unused) {
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public boolean v(h0 h0Var) {
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "filepath");
        String E2 = c0.E(a2, "new_filepath");
        a.f().O0().n();
        f1 q2 = c0.q();
        try {
            if (new File(E).renameTo(new File(E2))) {
                c0.w(q2, "success", true);
                h0Var.b(q2).e();
                return true;
            }
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        } catch (Exception unused) {
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean x(h0 h0Var) {
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "filepath");
        String E2 = c0.E(a2, "data");
        boolean equals = c0.E(a2, "encoding").equals("utf8");
        a.f().O0().n();
        f1 q2 = c0.q();
        try {
            f(E, E2, equals);
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            return true;
        } catch (IOException unused) {
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f7, code lost:
        new com.adcolony.sdk.e0.a().c("Out of memory error - disabling AdColony.").d(com.adcolony.sdk.e0.f13113h);
        com.adcolony.sdk.a.f().R(true);
        com.adcolony.sdk.c0.w(r5, "success", false);
        r0.b(r5).e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x011a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x011b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean z(com.adcolony.sdk.h0 r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "success"
            com.adcolony.sdk.f1 r2 = r20.a()
            java.lang.String r3 = "filepath"
            java.lang.String r3 = com.adcolony.sdk.c0.E(r2, r3)
            java.lang.String r4 = "bundle_path"
            java.lang.String r4 = com.adcolony.sdk.c0.E(r2, r4)
            java.lang.String r5 = "bundle_filenames"
            com.adcolony.sdk.e1 r2 = com.adcolony.sdk.c0.d(r2, r5)
            com.adcolony.sdk.k r5 = com.adcolony.sdk.a.f()
            com.adcolony.sdk.v0 r5 = r5.O0()
            r5.n()
            com.adcolony.sdk.f1 r5 = com.adcolony.sdk.c0.q()
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r8.<init>(r4)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r10 = "r"
            r9.<init>(r8, r10)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r10 = 32
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r11 = r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.e1 r12 = new com.adcolony.sdk.e1     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r12.<init>()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r14 = new byte[r13]     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r15 = 0
        L_0x004a:
            if (r15 >= r11) goto L_0x00dd
            int r16 = r15 * 44
            int r6 = r16 + 8
            r17 = r8
            long r7 = (long) r6     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.seek(r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.read(r10)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r6 = r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r7 = r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r12.m(r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00b3 }
            r8.<init>()     // Catch:{ JSONException -> 0x00b3 }
            r8.append(r3)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.Object r13 = r2.b(r15)     // Catch:{ JSONException -> 0x00b3 }
            r8.append(r13)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00b3 }
            r18 = r2
            r13 = r3
            long r2 = (long) r6
            r9.seek(r2)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r3 = r7 / 1024
            int r7 = r7 % 1024
            r6 = 0
        L_0x008b:
            if (r6 >= r3) goto L_0x009d
            r16 = r3
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.write(r14, r8, r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r6 = r6 + 1
            r3 = r16
            goto L_0x008b
        L_0x009d:
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.write(r14, r8, r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.close()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r15 = r15 + 1
            r3 = r13
            r8 = r17
            r2 = r18
            r13 = 1024(0x400, float:1.435E-42)
            goto L_0x004a
        L_0x00b3:
            com.adcolony.sdk.e0$a r2 = new com.adcolony.sdk.e0$a     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.<init>()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r3 = "Couldn't extract file name at index "
            com.adcolony.sdk.e0$a r2 = r2.c(r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.e0$a r2 = r2.a(r15)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r3 = " unpacking ad unit bundle at "
            com.adcolony.sdk.e0$a r2 = r2.c(r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.e0$a r2 = r2.c(r4)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.e0 r3 = com.adcolony.sdk.e0.f13113h     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.d(r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2 = 0
            com.adcolony.sdk.c0.w(r5, r1, r2)     // Catch:{ IOException -> 0x011c, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.h0 r3 = r0.b(r5)     // Catch:{ IOException -> 0x011c, OutOfMemoryError -> 0x00f7 }
            r3.e()     // Catch:{ IOException -> 0x011c, OutOfMemoryError -> 0x00f7 }
            return r2
        L_0x00dd:
            r17 = r8
            r9.close()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r17.delete()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2 = 1
            com.adcolony.sdk.c0.w(r5, r1, r2)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r2 = "file_sizes"
            com.adcolony.sdk.c0.l(r5, r2, r12)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.h0 r2 = r0.b(r5)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.e()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r0 = 1
            return r0
        L_0x00f7:
            com.adcolony.sdk.e0$a r2 = new com.adcolony.sdk.e0$a
            r2.<init>()
            java.lang.String r3 = "Out of memory error - disabling AdColony."
            com.adcolony.sdk.e0$a r2 = r2.c(r3)
            com.adcolony.sdk.e0 r3 = com.adcolony.sdk.e0.f13113h
            r2.d(r3)
            com.adcolony.sdk.k r2 = com.adcolony.sdk.a.f()
            r3 = 1
            r2.R(r3)
            r2 = 0
            com.adcolony.sdk.c0.w(r5, r1, r2)
            com.adcolony.sdk.h0 r0 = r0.b(r5)
            r0.e()
            return r2
        L_0x011b:
            r2 = 0
        L_0x011c:
            com.adcolony.sdk.e0$a r3 = new com.adcolony.sdk.e0$a
            r3.<init>()
            java.lang.String r6 = "Failed to find or open ad unit bundle at path: "
            com.adcolony.sdk.e0$a r3 = r3.c(r6)
            com.adcolony.sdk.e0$a r3 = r3.c(r4)
            com.adcolony.sdk.e0 r4 = com.adcolony.sdk.e0.f13114i
            r3.d(r4)
            com.adcolony.sdk.c0.w(r5, r1, r2)
            com.adcolony.sdk.h0 r0 = r0.b(r5)
            r0.e()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.w.z(com.adcolony.sdk.h0):boolean");
    }

    /* access modifiers changed from: package-private */
    public StringBuilder a(String str, boolean z2) throws IOException {
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder((int) file.length());
        if (z2) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), h.f13158a));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            } else {
                bufferedReader.close();
                return sb;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(String str, String str2, boolean z2) throws IOException {
        BufferedWriter bufferedWriter;
        if (z2) {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), h.f13158a));
        } else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)));
        }
        bufferedWriter.write(str2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* access modifiers changed from: package-private */
    public boolean k(File file) {
        try {
            if (!file.isDirectory()) {
                return file.delete();
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            String[] list = file.list();
            if (list.length > 0) {
                return k(new File(file, list[0]));
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        a.e("FileSystem.save", new a());
        a.e("FileSystem.delete", new b());
        a.e("FileSystem.listing", new c());
        a.e("FileSystem.load", new d());
        a.e("FileSystem.rename", new e());
        a.e("FileSystem.exists", new f());
        a.e("FileSystem.extract", new g());
        a.e("FileSystem.unpack_bundle", new h());
        a.e("FileSystem.create_directory", new i());
    }
}

package com.facebook.ads.internal.p.a;

import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class a {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f20446f = new int[20];

    /* renamed from: g  reason: collision with root package name */
    private static final String f20447g = "a";

    /* renamed from: a  reason: collision with root package name */
    protected final q f20448a = new f() {
    };

    /* renamed from: b  reason: collision with root package name */
    protected final d f20449b = new e();

    /* renamed from: c  reason: collision with root package name */
    protected r f20450c = new g();

    /* renamed from: d  reason: collision with root package name */
    protected int f20451d = 2000;

    /* renamed from: e  reason: collision with root package name */
    protected int f20452e = 8000;

    /* renamed from: h  reason: collision with root package name */
    private int f20453h = 3;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f20454i = new TreeMap();

    /* renamed from: j  reason: collision with root package name */
    private boolean f20455j;

    /* renamed from: k  reason: collision with root package name */
    private Set<String> f20456k;

    /* renamed from: l  reason: collision with root package name */
    private Set<String> f20457l;

    static {
        c();
        a();
    }

    public static void a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private static void c() {
    }

    private void c(HttpURLConnection httpURLConnection) {
        for (String next : this.f20454i.keySet()) {
            httpURLConnection.setRequestProperty(next, this.f20454i.get(next));
        }
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return f20446f[i2 + 2] * 1000;
    }

    /* access modifiers changed from: protected */
    public int a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f20448a.a(httpURLConnection);
            if (outputStream != null) {
                this.f20448a.a(outputStream, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public a a(String str, String str2) {
        this.f20454i.put(str, str2);
        return this;
    }

    public n a(l lVar) {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        while (i2 < this.f20453h) {
            try {
                c(a(i2));
                if (this.f20450c.a()) {
                    r rVar = this.f20450c;
                    rVar.a((i2 + 1) + "of" + this.f20453h + ", trying " + lVar.a());
                }
                currentTimeMillis = System.currentTimeMillis();
                n a2 = a(lVar.a(), lVar.b(), lVar.c(), lVar.d());
                if (a2 != null) {
                    return a2;
                }
                i2++;
            } catch (m e2) {
                if (a((Throwable) e2, currentTimeMillis) && i2 < this.f20453h - 1) {
                    continue;
                } else if (!this.f20448a.a(e2) || i2 >= this.f20453h - 1) {
                    throw e2;
                } else {
                    try {
                        Thread.sleep((long) this.f20451d);
                    } catch (InterruptedException unused) {
                        throw e2;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:62|63|64|65|66) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0080, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b6, code lost:
        throw new com.facebook.ads.internal.p.a.m(r5, (com.facebook.ads.internal.p.a.n) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00bc, code lost:
        throw new com.facebook.ads.internal.p.a.m(r5, (com.facebook.ads.internal.p.a.n) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:50:0x008f, B:62:0x00ae] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x00ae */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008f A[SYNTHETIC, Splitter:B:50:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.ads.internal.p.a.n a(java.lang.String r4, com.facebook.ads.internal.p.a.j r5, java.lang.String r6, byte[] r7) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r3.f20455j = r0     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            java.net.HttpURLConnection r4 = r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r3.a((java.net.HttpURLConnection) r4, (com.facebook.ads.internal.p.a.j) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0082 }
            r3.c((java.net.HttpURLConnection) r4)     // Catch:{ Exception -> 0x0082 }
            com.facebook.ads.internal.p.a.r r5 = r3.f20450c     // Catch:{ Exception -> 0x0082 }
            boolean r5 = r5.a()     // Catch:{ Exception -> 0x0082 }
            if (r5 == 0) goto L_0x001b
            com.facebook.ads.internal.p.a.r r5 = r3.f20450c     // Catch:{ Exception -> 0x0082 }
            r5.a(r4, r7)     // Catch:{ Exception -> 0x0082 }
        L_0x001b:
            r4.connect()     // Catch:{ Exception -> 0x0082 }
            r5 = 1
            r3.f20455j = r5     // Catch:{ Exception -> 0x0082 }
            java.util.Set<java.lang.String> r6 = r3.f20457l     // Catch:{ Exception -> 0x0082 }
            if (r6 == 0) goto L_0x002d
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x0082 }
            if (r6 != 0) goto L_0x002d
            r6 = 1
            goto L_0x002e
        L_0x002d:
            r6 = 0
        L_0x002e:
            java.util.Set<java.lang.String> r2 = r3.f20456k     // Catch:{ Exception -> 0x0082 }
            if (r2 == 0) goto L_0x0039
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0082 }
            if (r2 != 0) goto L_0x0039
            r0 = 1
        L_0x0039:
            boolean r5 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0082 }
            if (r5 == 0) goto L_0x0054
            if (r6 != 0) goto L_0x0041
            if (r0 == 0) goto L_0x0054
        L_0x0041:
            r5 = r4
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ Exception -> 0x004c }
            java.util.Set<java.lang.String> r6 = r3.f20457l     // Catch:{ Exception -> 0x004c }
            java.util.Set<java.lang.String> r0 = r3.f20456k     // Catch:{ Exception -> 0x004c }
            com.facebook.ads.internal.p.a.o.a(r5, r6, r0)     // Catch:{ Exception -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r5 = move-exception
            java.lang.String r6 = f20447g     // Catch:{ Exception -> 0x0082 }
            java.lang.String r0 = "Unable to validate SSL certificates."
            android.util.Log.e(r6, r0, r5)     // Catch:{ Exception -> 0x0082 }
        L_0x0054:
            boolean r5 = r4.getDoOutput()     // Catch:{ Exception -> 0x0082 }
            if (r5 == 0) goto L_0x005f
            if (r7 == 0) goto L_0x005f
            r3.a((java.net.HttpURLConnection) r4, (byte[]) r7)     // Catch:{ Exception -> 0x0082 }
        L_0x005f:
            boolean r5 = r4.getDoInput()     // Catch:{ Exception -> 0x0082 }
            if (r5 == 0) goto L_0x006a
            com.facebook.ads.internal.p.a.n r5 = r3.a((java.net.HttpURLConnection) r4)     // Catch:{ Exception -> 0x0082 }
            goto L_0x006f
        L_0x006a:
            com.facebook.ads.internal.p.a.n r5 = new com.facebook.ads.internal.p.a.n     // Catch:{ Exception -> 0x0082 }
            r5.<init>(r4, r1)     // Catch:{ Exception -> 0x0082 }
        L_0x006f:
            com.facebook.ads.internal.p.a.r r6 = r3.f20450c
            boolean r6 = r6.a()
            if (r6 == 0) goto L_0x007c
            com.facebook.ads.internal.p.a.r r6 = r3.f20450c
            r6.a((com.facebook.ads.internal.p.a.n) r5)
        L_0x007c:
            r4.disconnect()
            return r5
        L_0x0080:
            r5 = move-exception
            goto L_0x00bd
        L_0x0082:
            r5 = move-exception
            goto L_0x0089
        L_0x0084:
            r5 = move-exception
            r4 = r1
            goto L_0x00bd
        L_0x0087:
            r5 = move-exception
            r4 = r1
        L_0x0089:
            com.facebook.ads.internal.p.a.n r1 = r3.b((java.net.HttpURLConnection) r4)     // Catch:{ Exception -> 0x00ae }
            if (r1 == 0) goto L_0x00a8
            int r6 = r1.a()     // Catch:{ all -> 0x0080 }
            if (r6 <= 0) goto L_0x00a8
            com.facebook.ads.internal.p.a.r r5 = r3.f20450c
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x00a2
            com.facebook.ads.internal.p.a.r r5 = r3.f20450c
            r5.a((com.facebook.ads.internal.p.a.n) r1)
        L_0x00a2:
            if (r4 == 0) goto L_0x00a7
            r4.disconnect()
        L_0x00a7:
            return r1
        L_0x00a8:
            com.facebook.ads.internal.p.a.m r6 = new com.facebook.ads.internal.p.a.m     // Catch:{ all -> 0x0080 }
            r6.<init>(r5, r1)     // Catch:{ all -> 0x0080 }
            throw r6     // Catch:{ all -> 0x0080 }
        L_0x00ae:
            r5.printStackTrace()     // Catch:{ all -> 0x00b7 }
            com.facebook.ads.internal.p.a.m r6 = new com.facebook.ads.internal.p.a.m     // Catch:{ all -> 0x0080 }
            r6.<init>(r5, r1)     // Catch:{ all -> 0x0080 }
            throw r6     // Catch:{ all -> 0x0080 }
        L_0x00b7:
            com.facebook.ads.internal.p.a.m r6 = new com.facebook.ads.internal.p.a.m     // Catch:{ all -> 0x0080 }
            r6.<init>(r5, r1)     // Catch:{ all -> 0x0080 }
            throw r6     // Catch:{ all -> 0x0080 }
        L_0x00bd:
            com.facebook.ads.internal.p.a.r r6 = r3.f20450c
            boolean r6 = r6.a()
            if (r6 == 0) goto L_0x00ca
            com.facebook.ads.internal.p.a.r r6 = r3.f20450c
            r6.a((com.facebook.ads.internal.p.a.n) r1)
        L_0x00ca:
            if (r4 == 0) goto L_0x00cf
            r4.disconnect()
        L_0x00cf:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.a(java.lang.String, com.facebook.ads.internal.p.a.j, java.lang.String, byte[]):com.facebook.ads.internal.p.a.n");
    }

    public n a(String str, p pVar) {
        return b((l) new i(str, pVar));
    }

    public n a(String str, String str2, byte[] bArr) {
        return b((l) new k(str, (p) null, str2, bArr));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.ads.internal.p.a.n a(java.net.HttpURLConnection r4) {
        /*
            r3 = this;
            r0 = 0
            com.facebook.ads.internal.p.a.q r1 = r3.f20448a     // Catch:{ all -> 0x001d }
            java.io.InputStream r1 = r1.b(r4)     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x000f
            com.facebook.ads.internal.p.a.q r0 = r3.f20448a     // Catch:{ all -> 0x001a }
            byte[] r0 = r0.a((java.io.InputStream) r1)     // Catch:{ all -> 0x001a }
        L_0x000f:
            com.facebook.ads.internal.p.a.n r2 = new com.facebook.ads.internal.p.a.n     // Catch:{ all -> 0x001a }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0019
            r1.close()     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            return r2
        L_0x001a:
            r4 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.a(java.net.HttpURLConnection):com.facebook.ads.internal.p.a.n");
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection a(String str) {
        try {
            new URL(str);
            return this.f20448a.a(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(str + " is not a valid URL", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(l lVar, b bVar) {
        this.f20449b.a(this, bVar).a(lVar);
    }

    public void a(String str, p pVar, b bVar) {
        a((l) new k(str, pVar), bVar);
    }

    /* access modifiers changed from: protected */
    public void a(HttpURLConnection httpURLConnection, j jVar, String str) {
        httpURLConnection.setConnectTimeout(this.f20451d);
        httpURLConnection.setReadTimeout(this.f20452e);
        this.f20448a.a(httpURLConnection, jVar, str);
    }

    public void a(Set<String> set) {
        this.f20457l = set;
    }

    /* access modifiers changed from: protected */
    public boolean a(Throwable th, long j2) {
        long currentTimeMillis = (System.currentTimeMillis() - j2) + 10;
        if (this.f20450c.a()) {
            r rVar = this.f20450c;
            rVar.a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f20451d + ", RT = " + this.f20452e);
        }
        return this.f20455j ? currentTimeMillis >= ((long) this.f20452e) : currentTimeMillis >= ((long) this.f20451d);
    }

    public n b(l lVar) {
        try {
            return a(lVar.a(), lVar.b(), lVar.c(), lVar.d());
        } catch (m e2) {
            this.f20448a.a(e2);
            return null;
        } catch (Exception e3) {
            this.f20448a.a(new m(e3, (n) null));
            return null;
        }
    }

    public n b(String str, p pVar) {
        return b((l) new k(str, pVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001e A[SYNTHETIC, Splitter:B:16:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.ads.internal.p.a.n b(java.net.HttpURLConnection r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.InputStream r1 = r4.getErrorStream()     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x000d
            com.facebook.ads.internal.p.a.q r0 = r3.f20448a     // Catch:{ all -> 0x0018 }
            byte[] r0 = r0.a((java.io.InputStream) r1)     // Catch:{ all -> 0x0018 }
        L_0x000d:
            com.facebook.ads.internal.p.a.n r2 = new com.facebook.ads.internal.p.a.n     // Catch:{ all -> 0x0018 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            return r2
        L_0x0018:
            r4 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r4 = move-exception
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.b(java.net.HttpURLConnection):com.facebook.ads.internal.p.a.n");
    }

    public p b() {
        return new p();
    }

    public void b(int i2) {
        if (i2 < 1 || i2 > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f20453h = i2;
    }

    public void b(Set<String> set) {
        this.f20456k = set;
    }

    public void c(int i2) {
        this.f20451d = i2;
    }
}

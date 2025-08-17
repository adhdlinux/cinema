package com.facebook.ads.internal.o;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.f.d;
import com.facebook.ads.internal.f.e;
import com.facebook.ads.internal.o.f;
import com.facebook.ads.internal.p.a.n;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.q.a.i;
import com.facebook.ads.internal.q.a.m;
import com.facebook.ads.internal.q.a.s;
import com.facebook.ads.internal.q.d.b;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

public class c {

    /* renamed from: i  reason: collision with root package name */
    private static final m f20420i;

    /* renamed from: j  reason: collision with root package name */
    private static final ThreadPoolExecutor f20421j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f20422a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f20423b = e.a();

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.l.a f20424c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f20425d;

    /* renamed from: e  reason: collision with root package name */
    private a f20426e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f20427f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.facebook.ads.internal.p.a.a f20428g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f20429h;

    /* renamed from: com.facebook.ads.internal.o.c$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20433a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.ads.internal.o.f$a[] r0 = com.facebook.ads.internal.o.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20433a = r0
                com.facebook.ads.internal.o.f$a r1 = com.facebook.ads.internal.o.f.a.ADS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20433a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.o.f$a r1 = com.facebook.ads.internal.o.f.a.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.o.c.AnonymousClass3.<clinit>():void");
        }
    }

    public interface a {
        void a(g gVar);

        void a(com.facebook.ads.internal.protocol.a aVar);
    }

    static {
        m mVar = new m();
        f20420i = mVar;
        f20421j = (ThreadPoolExecutor) Executors.newCachedThreadPool(mVar);
    }

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f20422a = applicationContext;
        this.f20424c = com.facebook.ads.internal.l.a.w(applicationContext);
        this.f20429h = d.a();
    }

    private void a(g gVar) {
        a aVar = this.f20426e;
        if (aVar != null) {
            aVar.a(gVar);
        }
        a();
    }

    /* access modifiers changed from: private */
    public void a(com.facebook.ads.internal.protocol.a aVar) {
        a aVar2 = this.f20426e;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        a();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        int i2;
        com.facebook.ads.internal.protocol.a a2;
        try {
            f a3 = this.f20423b.a(str);
            com.facebook.ads.internal.h.c a4 = a3.a();
            if (a4 != null) {
                this.f20424c.a(a4.b());
                a.a(a4.a().d(), this.f20427f);
            }
            int i3 = AnonymousClass3.f20433a[a3.b().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    a2 = com.facebook.ads.internal.protocol.a.a(AdErrorType.UNKNOWN_RESPONSE, str);
                } else {
                    h hVar = (h) a3;
                    String f2 = hVar.f();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(hVar.g(), AdErrorType.ERROR_MESSAGE);
                    if (f2 != null) {
                        str = f2;
                    }
                    a2 = com.facebook.ads.internal.protocol.a.a(adErrorTypeFromCode, str);
                }
                a(a2);
                return;
            }
            g gVar = (g) a3;
            if (a4 != null) {
                if (a4.a().e()) {
                    a.a(str, this.f20427f);
                }
                Map<String, String> map = this.f20425d;
                String str2 = map != null ? map.get("CLIENT_REQUEST_ID") : null;
                String c2 = a3.c();
                if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(str2)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < 32; i4++) {
                        char charAt = "82042s3304s547sso6r044qoq3sn5199".charAt(i4);
                        if ((charAt < 'a' || charAt > 'm') && (charAt < 'A' || charAt > 'M')) {
                            if ((charAt >= 'n' && charAt <= 'z') || (charAt >= 'N' && charAt <= 'Z')) {
                                i2 = charAt - 13;
                            }
                            sb.append(charAt);
                        } else {
                            i2 = charAt + 13;
                        }
                        charAt = (char) i2;
                        sb.append(charAt);
                    }
                    byte[] bytes = (str2 + c2 + sb.toString()).getBytes("iso-8859-1");
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(bytes, 0, bytes.length);
                    if (!a3.d().equals(i.a(instance.digest()))) {
                        com.facebook.ads.internal.q.d.a.a(this.f20422a, "network", b.f20748h, (Exception) new com.facebook.ads.internal.protocol.i());
                    }
                    byte[] bytes2 = (c2 + str2 + sb.toString()).getBytes("iso-8859-1");
                    MessageDigest instance2 = MessageDigest.getInstance("SHA-1");
                    instance2.update(bytes2, 0, bytes2.length);
                    e.a((d) new com.facebook.ads.internal.f.a(c2, i.a(instance2.digest())), this.f20422a);
                }
                if (!TextUtils.isEmpty(a3.e()) && !TextUtils.isEmpty(str2)) {
                    new com.facebook.ads.internal.k.a(this.f20422a, str2, a3.e()).a();
                }
            }
            a(gVar);
        } catch (Exception e2) {
            a(com.facebook.ads.internal.protocol.a.a(AdErrorType.PARSER_FAILURE, e2.getMessage()));
        }
    }

    /* access modifiers changed from: private */
    public com.facebook.ads.internal.p.a.b b() {
        return new com.facebook.ads.internal.p.a.b() {
            /* access modifiers changed from: package-private */
            public void a(com.facebook.ads.internal.p.a.m mVar) {
                a.b(c.this.f20427f);
                com.facebook.ads.internal.p.a.a unused = c.this.f20428g = null;
                try {
                    n a2 = mVar.a();
                    if (a2 != null) {
                        String e2 = a2.e();
                        f a3 = c.this.f20423b.a(e2);
                        if (a3.b() == f.a.ERROR) {
                            h hVar = (h) a3;
                            String f2 = hVar.f();
                            AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(hVar.g(), AdErrorType.ERROR_MESSAGE);
                            c cVar = c.this;
                            if (f2 != null) {
                                e2 = f2;
                            }
                            cVar.a(com.facebook.ads.internal.protocol.a.a(adErrorTypeFromCode, e2));
                            return;
                        }
                    }
                } catch (JSONException unused2) {
                }
                c.this.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.NETWORK_ERROR, mVar.getMessage()));
            }

            public void a(n nVar) {
                if (nVar != null) {
                    String e2 = nVar.e();
                    a.b(c.this.f20427f);
                    com.facebook.ads.internal.p.a.a unused = c.this.f20428g = null;
                    c.this.a(e2);
                }
            }

            public void a(Exception exc) {
                if (com.facebook.ads.internal.p.a.m.class.equals(exc.getClass())) {
                    a((com.facebook.ads.internal.p.a.m) exc);
                } else {
                    c.this.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.NETWORK_ERROR, exc.getMessage()));
                }
            }
        };
    }

    public void a() {
        com.facebook.ads.internal.p.a.a aVar = this.f20428g;
        if (aVar != null) {
            aVar.c(1);
            this.f20428g.b(1);
            this.f20428g = null;
        }
    }

    public void a(final b bVar) {
        a();
        if (s.a(this.f20422a) == s.a.NONE) {
            a(new com.facebook.ads.internal.protocol.a(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f20427f = bVar;
        com.facebook.ads.internal.g.a.a(this.f20422a);
        if (a.a(bVar)) {
            String c2 = a.c(bVar);
            if (c2 != null) {
                a(c2);
            } else {
                a(com.facebook.ads.internal.protocol.a.a(AdErrorType.LOAD_TOO_FREQUENTLY, (String) null));
            }
        } else {
            f20421j.submit(new Runnable() {
                /* JADX WARNING: Can't wrap try/catch for region: R(9:8|9|10|11|12|(1:(1:19)(3:20|22|26))|21|22|26) */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e2, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e3, code lost:
                    com.facebook.ads.internal.o.c.a(r6.f20431b, com.facebook.ads.internal.protocol.a.a(com.facebook.ads.internal.protocol.AdErrorType.AD_REQUEST_FAILED, r0.getMessage()));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
                    return;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0095 */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x00a7 A[Catch:{ Exception -> 0x00e2 }] */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A[Catch:{ Exception -> 0x00e2 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        com.facebook.ads.internal.o.c r0 = com.facebook.ads.internal.o.c.this
                        android.content.Context r0 = r0.f20422a
                        com.facebook.ads.internal.c.b.a(r0)
                        com.facebook.ads.internal.o.b r0 = r3
                        com.facebook.ads.internal.protocol.h r0 = r0.e()
                        boolean r0 = r0.a()
                        if (r0 == 0) goto L_0x003b
                        com.facebook.ads.internal.o.b r0 = r3     // Catch:{ b -> 0x0021 }
                        com.facebook.ads.internal.protocol.h r0 = r0.e()     // Catch:{ b -> 0x0021 }
                        java.lang.String r1 = com.facebook.ads.internal.c.b.f20056b     // Catch:{ b -> 0x0021 }
                        r0.a(r1)     // Catch:{ b -> 0x0021 }
                        goto L_0x002b
                    L_0x0021:
                        r0 = move-exception
                        com.facebook.ads.internal.o.c r1 = com.facebook.ads.internal.o.c.this
                        com.facebook.ads.internal.protocol.a r0 = com.facebook.ads.internal.protocol.a.a(r0)
                        r1.a((com.facebook.ads.internal.protocol.a) r0)
                    L_0x002b:
                        com.facebook.ads.internal.o.c r0 = com.facebook.ads.internal.o.c.this
                        com.facebook.ads.internal.o.b r1 = r3
                        com.facebook.ads.internal.protocol.h r1 = r1.e()
                        java.lang.String r1 = r1.b()
                        r0.a((java.lang.String) r1)
                        return
                    L_0x003b:
                        com.facebook.ads.internal.o.c r0 = com.facebook.ads.internal.o.c.this
                        com.facebook.ads.internal.o.b r1 = r3
                        java.util.Map r1 = r1.f()
                        java.util.Map unused = r0.f20425d = r1
                        com.facebook.ads.internal.o.c r0 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x0095 }
                        java.util.Map r0 = r0.f20425d     // Catch:{ Exception -> 0x0095 }
                        java.lang.String r1 = "M_BANNER_KEY"
                        java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0095 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095 }
                        r3.<init>()     // Catch:{ Exception -> 0x0095 }
                        com.facebook.ads.internal.o.c r4 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x0095 }
                        android.content.Context r4 = r4.f20422a     // Catch:{ Exception -> 0x0095 }
                        java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0095 }
                        r3.append(r4)     // Catch:{ Exception -> 0x0095 }
                        java.lang.String r4 = " "
                        r3.append(r4)     // Catch:{ Exception -> 0x0095 }
                        com.facebook.ads.internal.o.c r4 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x0095 }
                        android.content.Context r4 = r4.f20422a     // Catch:{ Exception -> 0x0095 }
                        android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x0095 }
                        com.facebook.ads.internal.o.c r5 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x0095 }
                        android.content.Context r5 = r5.f20422a     // Catch:{ Exception -> 0x0095 }
                        java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x0095 }
                        java.lang.String r4 = r4.getInstallerPackageName(r5)     // Catch:{ Exception -> 0x0095 }
                        r3.append(r4)     // Catch:{ Exception -> 0x0095 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0095 }
                        byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x0095 }
                        r4 = 2
                        byte[] r3 = android.util.Base64.encode(r3, r4)     // Catch:{ Exception -> 0x0095 }
                        r2.<init>(r3)     // Catch:{ Exception -> 0x0095 }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x0095 }
                    L_0x0095:
                        com.facebook.ads.internal.o.b r0 = r3     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.protocol.f r0 = r0.f20407c     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.protocol.f r1 = com.facebook.ads.internal.protocol.f.NATIVE_250     // Catch:{ Exception -> 0x00e2 }
                        if (r0 == r1) goto L_0x00aa
                        com.facebook.ads.internal.protocol.f r1 = com.facebook.ads.internal.protocol.f.NATIVE_UNKNOWN     // Catch:{ Exception -> 0x00e2 }
                        if (r0 == r1) goto L_0x00aa
                        com.facebook.ads.internal.protocol.f r1 = com.facebook.ads.internal.protocol.f.NATIVE_BANNER     // Catch:{ Exception -> 0x00e2 }
                        if (r0 == r1) goto L_0x00aa
                        if (r0 != 0) goto L_0x00a8
                        goto L_0x00aa
                    L_0x00a8:
                        r0 = 0
                        goto L_0x00ab
                    L_0x00aa:
                        r0 = 1
                    L_0x00ab:
                        com.facebook.ads.internal.o.c r1 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x00e2 }
                        android.content.Context r2 = r1.f20422a     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.a r0 = com.facebook.ads.internal.q.c.d.b(r2, r0)     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.a unused = r1.f20428g = r0     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.o.c r0 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.a r0 = r0.f20428g     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.o.c r1 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r1 = r1.f20429h     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.o.c r2 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.a r2 = r2.f20428g     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.p r2 = r2.b()     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.o.c r3 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x00e2 }
                        java.util.Map r3 = r3.f20425d     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.p r2 = r2.a((java.util.Map<? extends java.lang.String, ? extends java.lang.String>) r3)     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.o.c r3 = com.facebook.ads.internal.o.c.this     // Catch:{ Exception -> 0x00e2 }
                        com.facebook.ads.internal.p.a.b r3 = r3.b()     // Catch:{ Exception -> 0x00e2 }
                        r0.a((java.lang.String) r1, (com.facebook.ads.internal.p.a.p) r2, (com.facebook.ads.internal.p.a.b) r3)     // Catch:{ Exception -> 0x00e2 }
                        goto L_0x00f2
                    L_0x00e2:
                        r0 = move-exception
                        com.facebook.ads.internal.o.c r1 = com.facebook.ads.internal.o.c.this
                        com.facebook.ads.internal.protocol.AdErrorType r2 = com.facebook.ads.internal.protocol.AdErrorType.AD_REQUEST_FAILED
                        java.lang.String r0 = r0.getMessage()
                        com.facebook.ads.internal.protocol.a r0 = com.facebook.ads.internal.protocol.a.a(r2, r0)
                        r1.a((com.facebook.ads.internal.protocol.a) r0)
                    L_0x00f2:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.o.c.AnonymousClass1.run():void");
                }
            });
        }
    }

    public void a(a aVar) {
        this.f20426e = aVar;
    }
}

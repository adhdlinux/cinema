package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ImagesContract;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qb extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35685a;

    /* renamed from: b  reason: collision with root package name */
    public final x6 f35686b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f35687c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35688d;

    /* renamed from: e  reason: collision with root package name */
    public String f35689e;

    /* renamed from: f  reason: collision with root package name */
    public String f35690f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35691g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35692h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f35693i;

    /* renamed from: j  reason: collision with root package name */
    public final long f35694j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f35695k;

    /* renamed from: l  reason: collision with root package name */
    public Boolean f35696l;

    /* renamed from: m  reason: collision with root package name */
    public String f35697m;

    /* renamed from: n  reason: collision with root package name */
    public Runnable f35698n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f35699o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f35700p = false;

    /* renamed from: q  reason: collision with root package name */
    public final LinkedHashMap<String, Float> f35701q = new LinkedHashMap<>();

    /* renamed from: r  reason: collision with root package name */
    public long f35702r;

    /* renamed from: s  reason: collision with root package name */
    public final Runnable f35703s = new a();

    /* renamed from: t  reason: collision with root package name */
    public final Runnable f35704t = new b();

    /* renamed from: u  reason: collision with root package name */
    public final Runnable f35705u = new c();

    /* renamed from: v  reason: collision with root package name */
    public final Runnable f35706v = new d();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            qb qbVar = qb.this;
            qbVar.f35687c.execute(qbVar.f35704t);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            String str;
            qb qbVar = qb.this;
            if (!qbVar.f35691g) {
                try {
                    y8 y8Var = new y8(z8.f36996c);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed smart redirect hop info: ");
                    if (qbVar.f35700p) {
                        str = "Page Finished";
                    } else {
                        str = "Timeout";
                    }
                    sb.append(str);
                    y8Var.f36954d = sb.toString();
                    y8Var.f36956f = qbVar.b();
                    y8Var.f36957g = qbVar.f35690f;
                    y8Var.a(qbVar.f35685a);
                } catch (Throwable th) {
                    y8.a(qbVar.f35685a, th);
                }
                try {
                    qbVar.f35699o = true;
                    o6.b(qbVar.f35685a);
                    qbVar.a();
                    if (!qbVar.f35695k || !MetaData.f36379h.O()) {
                        o6.b(qbVar.f35685a, qbVar.f35689e, qbVar.f35690f);
                    } else {
                        o6.a(qbVar.f35685a, qbVar.f35689e, qbVar.f35690f);
                    }
                    Runnable runnable = qbVar.f35698n;
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (Throwable th2) {
                    y8.a(qbVar.f35685a, th2);
                }
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            qb qbVar = qb.this;
            qbVar.f35687c.execute(qbVar.f35706v);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            qb qbVar = qb.this;
            if (!qbVar.f35699o && !qbVar.f35691g) {
                try {
                    qbVar.f35691g = true;
                    o6.b(qbVar.f35685a);
                    if (!qbVar.f35695k || !MetaData.f36379h.O()) {
                        o6.b(qbVar.f35685a, qbVar.f35689e, qbVar.f35690f);
                    } else {
                        o6.a(qbVar.f35685a, qbVar.f35689e, qbVar.f35690f);
                    }
                    Runnable runnable = qbVar.f35698n;
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (Throwable th) {
                    y8.a(qbVar.f35685a, th);
                }
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f35711a;

        public e(String str) {
            this.f35711a = str;
        }

        public void run() {
            qb qbVar = qb.this;
            String str = this.f35711a;
            if (!qbVar.f35692h) {
                qbVar.f35702r = System.currentTimeMillis();
                qbVar.f35701q.put(str, Float.valueOf(-1.0f));
                qbVar.f35688d.postDelayed(qbVar.f35703s, qbVar.f35693i);
                qbVar.f35692h = true;
            }
            qbVar.f35700p = false;
            qbVar.a();
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f35713a;

        public f(String str) {
            this.f35713a = str;
        }

        public void run() {
            qb qbVar = qb.this;
            String str = this.f35713a;
            qbVar.getClass();
            long currentTimeMillis = System.currentTimeMillis();
            qbVar.f35702r = currentTimeMillis;
            qbVar.f35701q.put(qbVar.f35689e, Float.valueOf(((float) (currentTimeMillis - qbVar.f35702r)) / 1000.0f));
            qbVar.f35701q.put(str, Float.valueOf(-1.0f));
            qbVar.f35689e = str;
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f35715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f35716b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35717c;

        public g(String str, boolean z2, String str2) {
            this.f35715a = str;
            this.f35716b = z2;
            this.f35717c = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0090 A[Catch:{ all -> 0x00e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0099 A[Catch:{ all -> 0x00e3 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                com.startapp.qb r0 = com.startapp.qb.this
                java.lang.String r1 = r8.f35715a
                boolean r2 = r8.f35716b
                java.lang.String r3 = r8.f35717c
                r0.getClass()
                boolean r4 = r0.f35699o     // Catch:{ all -> 0x00e3 }
                if (r4 != 0) goto L_0x00e9
                r4 = 1
                r0.f35691g = r4     // Catch:{ all -> 0x00e3 }
                android.content.Context r5 = r0.f35685a     // Catch:{ all -> 0x00e3 }
                com.startapp.o6.b((android.content.Context) r5)     // Catch:{ all -> 0x00e3 }
                r0.a()     // Catch:{ all -> 0x00e3 }
                android.content.Context r5 = r0.f35685a     // Catch:{ all -> 0x00e3 }
                if (r2 == 0) goto L_0x001f
                r1 = r3
            L_0x001f:
                r2 = 0
                com.startapp.o6.b((android.content.Context) r5, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00e3 }
                java.lang.String r1 = r0.f35697m     // Catch:{ all -> 0x00e3 }
                if (r1 == 0) goto L_0x0075
                java.lang.String r2 = ""
                boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00e3 }
                if (r1 != 0) goto L_0x0075
                java.lang.String r1 = r0.f35689e     // Catch:{ all -> 0x00e3 }
                java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = r0.f35697m     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = r2.toLowerCase()     // Catch:{ all -> 0x00e3 }
                boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x00e3 }
                if (r1 != 0) goto L_0x0075
                com.startapp.y8 r1 = new com.startapp.y8     // Catch:{ all -> 0x00e3 }
                com.startapp.z8 r2 = com.startapp.z8.f36996c     // Catch:{ all -> 0x00e3 }
                r1.<init>((com.startapp.z8) r2)     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = "Wrong package reached"
                r1.f36954d = r2     // Catch:{ all -> 0x00e3 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
                r2.<init>()     // Catch:{ all -> 0x00e3 }
                java.lang.String r3 = "Expected: "
                r2.append(r3)     // Catch:{ all -> 0x00e3 }
                java.lang.String r3 = r0.f35697m     // Catch:{ all -> 0x00e3 }
                r2.append(r3)     // Catch:{ all -> 0x00e3 }
                java.lang.String r3 = ", Link: "
                r2.append(r3)     // Catch:{ all -> 0x00e3 }
                java.lang.String r3 = r0.f35689e     // Catch:{ all -> 0x00e3 }
                r2.append(r3)     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e3 }
                r1.f36955e = r2     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = r0.f35690f     // Catch:{ all -> 0x00e3 }
                r1.f36957g = r2     // Catch:{ all -> 0x00e3 }
                android.content.Context r2 = r0.f35685a     // Catch:{ all -> 0x00e3 }
                r1.a(r2)     // Catch:{ all -> 0x00e3 }
                goto L_0x00db
            L_0x0075:
                com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h     // Catch:{ all -> 0x00e3 }
                com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig r1 = r1.analytics     // Catch:{ all -> 0x00e3 }
                boolean r1 = r1.i()     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = "firstSucceededSmartRedirect"
                r3 = 0
                if (r1 == 0) goto L_0x008b
                com.startapp.x6 r1 = r0.f35686b     // Catch:{ all -> 0x00e3 }
                boolean r1 = r1.getBoolean(r2, r4)     // Catch:{ all -> 0x00e3 }
                if (r1 == 0) goto L_0x008b
                goto L_0x008c
            L_0x008b:
                r4 = 0
            L_0x008c:
                java.lang.Boolean r1 = r0.f35696l     // Catch:{ all -> 0x00e3 }
                if (r1 != 0) goto L_0x0099
                com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h     // Catch:{ all -> 0x00e3 }
                com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig r1 = r1.analytics     // Catch:{ all -> 0x00e3 }
                float r1 = r1.h()     // Catch:{ all -> 0x00e3 }
                goto L_0x00a3
            L_0x0099:
                boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00e3 }
                if (r1 == 0) goto L_0x00a2
                r1 = 1120403456(0x42c80000, float:100.0)
                goto L_0x00a3
            L_0x00a2:
                r1 = 0
            L_0x00a3:
                if (r4 != 0) goto L_0x00b2
                double r4 = java.lang.Math.random()     // Catch:{ all -> 0x00e3 }
                r6 = 4636737291354636288(0x4059000000000000, double:100.0)
                double r4 = r4 * r6
                double r6 = (double) r1     // Catch:{ all -> 0x00e3 }
                int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r1 >= 0) goto L_0x00db
            L_0x00b2:
                com.startapp.y8 r1 = new com.startapp.y8     // Catch:{ all -> 0x00e3 }
                com.startapp.z8 r4 = com.startapp.z8.f37003j     // Catch:{ all -> 0x00e3 }
                r1.<init>((com.startapp.z8) r4)     // Catch:{ all -> 0x00e3 }
                org.json.JSONArray r4 = r0.b()     // Catch:{ all -> 0x00e3 }
                r1.f36956f = r4     // Catch:{ all -> 0x00e3 }
                java.lang.String r4 = r0.f35690f     // Catch:{ all -> 0x00e3 }
                r1.f36957g = r4     // Catch:{ all -> 0x00e3 }
                android.content.Context r4 = r0.f35685a     // Catch:{ all -> 0x00e3 }
                r1.a(r4)     // Catch:{ all -> 0x00e3 }
                com.startapp.x6 r1 = r0.f35686b     // Catch:{ all -> 0x00e3 }
                com.startapp.x6$a r1 = r1.edit()     // Catch:{ all -> 0x00e3 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00e3 }
                r1.a((java.lang.String) r2, r4)     // Catch:{ all -> 0x00e3 }
                android.content.SharedPreferences$Editor r4 = r1.f36915a     // Catch:{ all -> 0x00e3 }
                r4.putBoolean(r2, r3)     // Catch:{ all -> 0x00e3 }
                r1.apply()     // Catch:{ all -> 0x00e3 }
            L_0x00db:
                java.lang.Runnable r1 = r0.f35698n     // Catch:{ all -> 0x00e3 }
                if (r1 == 0) goto L_0x00e9
                r1.run()     // Catch:{ all -> 0x00e3 }
                goto L_0x00e9
            L_0x00e3:
                r1 = move-exception
                android.content.Context r0 = r0.f35685a
                com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r1)
            L_0x00e9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.qb.g.run():void");
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f35719a;

        public h(String str) {
            this.f35719a = str;
        }

        public void run() {
            qb qbVar = qb.this;
            String str = this.f35719a;
            if (!qbVar.f35691g && !qbVar.f35699o && qbVar.f35689e.equals(str) && !o6.b(str)) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    qbVar.f35700p = true;
                    qbVar.a(str);
                    synchronized (qbVar.f35688d) {
                        qbVar.f35688d.removeCallbacks(qbVar.f35705u);
                        qbVar.f35688d.postDelayed(qbVar.f35705u, qbVar.f35694j);
                    }
                }
            }
        }
    }

    public qb(Context context, x6 x6Var, Executor executor, Handler handler, long j2, long j3, boolean z2, Boolean bool, String str, String str2, String str3, Runnable runnable) {
        this.f35685a = context;
        this.f35686b = x6Var;
        this.f35687c = new gb(executor);
        this.f35688d = handler;
        this.f35693i = j2;
        this.f35694j = j3;
        this.f35695k = z2;
        this.f35696l = bool;
        this.f35689e = str;
        this.f35697m = str2;
        this.f35690f = str3;
        this.f35698n = runnable;
    }

    public void a() {
        synchronized (this.f35688d) {
            this.f35688d.removeCallbacks(this.f35705u);
        }
    }

    public JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : this.f35701q.entrySet()) {
            String str = (String) next.getKey();
            Float f2 = (Float) next.getValue();
            JSONObject jSONObject = new JSONObject();
            try {
                a(str);
                jSONObject.put("time", String.valueOf(f2));
                jSONObject.put(ImagesContract.URL, str);
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
            }
        }
        return jSONArray;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f35687c.execute(new h(str));
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f35687c.execute(new e(str));
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        a();
        if (str2 != null && !o6.b(str2) && o6.c(str2)) {
            y8 y8Var = new y8(z8.f36996c);
            y8Var.f36954d = "Failed smart redirect: " + i2;
            y8Var.f36955e = str2;
            y8Var.f36957g = this.f35690f;
            y8Var.a(this.f35685a);
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!(webView == null || str == null)) {
            this.f35687c.execute(new f(str));
            if (lb.b(webView.getContext(), str)) {
                return true;
            }
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            boolean b2 = o6.b(lowerCase);
            boolean startsWith = lowerCase.startsWith("intent://");
            if (!b2 && !startsWith) {
                return false;
            }
            this.f35687c.execute(new g(str, startsWith, webView.getUrl()));
        }
        return true;
    }

    public final void a(String str) {
        Float f2 = this.f35701q.get(str);
        if (f2 == null || f2.floatValue() < 0.0f) {
            this.f35701q.put(str, Float.valueOf(((float) (System.currentTimeMillis() - this.f35702r)) / 1000.0f));
        }
    }
}

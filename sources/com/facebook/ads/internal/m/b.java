package com.facebook.ads.internal.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.ads.internal.p.a.n;
import com.facebook.ads.internal.p.a.p;
import com.facebook.ads.internal.q.c.d;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20261a = "b";

    /* renamed from: b  reason: collision with root package name */
    private final a f20262b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f20263c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ThreadPoolExecutor f20264d;

    /* renamed from: e  reason: collision with root package name */
    private final ConnectivityManager f20265e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.ads.internal.p.a.a f20266f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f20267g;

    /* renamed from: h  reason: collision with root package name */
    private final long f20268h;

    /* renamed from: i  reason: collision with root package name */
    private final long f20269i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f20270j = new Runnable() {
        public void run() {
            b.a(b.this);
            if (b.this.f20274n > 0) {
                try {
                    Thread.sleep(b.this.f20274n);
                } catch (InterruptedException unused) {
                }
            }
            b.this.d();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f20271k = new Runnable() {
        public void run() {
            boolean unused = b.this.f20272l = false;
            if (b.this.f20264d.getQueue().isEmpty()) {
                b.this.f20264d.execute(b.this.f20270j);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f20272l;

    /* renamed from: m  reason: collision with root package name */
    private int f20273m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public long f20274n;

    interface a {
        JSONObject a();

        boolean a(JSONArray jSONArray);

        void b();

        void b(JSONArray jSONArray);

        boolean c();
    }

    b(Context context, a aVar) {
        this.f20262b = aVar;
        this.f20263c = context;
        this.f20264d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f20265e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f20266f = d.b(context);
        this.f20267g = new Handler(Looper.getMainLooper());
        this.f20268h = com.facebook.ads.internal.l.a.l(context);
        this.f20269i = com.facebook.ads.internal.l.a.m(context);
    }

    static /* synthetic */ int a(b bVar) {
        int i2 = bVar.f20273m + 1;
        bVar.f20273m = i2;
        return i2;
    }

    private void a(long j2) {
        this.f20267g.postDelayed(this.f20271k, j2);
    }

    private void c() {
        int i2 = this.f20273m;
        if (i2 >= 5) {
            e();
            b();
            return;
        }
        this.f20274n = i2 == 1 ? 2000 : this.f20274n * 2;
        a();
    }

    /* access modifiers changed from: private */
    public void d() {
        a aVar;
        JSONArray jSONArray;
        try {
            NetworkInfo activeNetworkInfo = this.f20265e.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnectedOrConnecting()) {
                    JSONObject a2 = this.f20262b.a();
                    if (a2 == null) {
                        e();
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("attempt", String.valueOf(this.f20273m));
                    a2.put("data", jSONObject);
                    p pVar = new p();
                    pVar.put("payload", a2.toString());
                    n b2 = this.f20266f.b(com.facebook.ads.internal.o.d.a(this.f20263c), pVar);
                    String e2 = b2 != null ? b2.e() : null;
                    if (TextUtils.isEmpty(e2)) {
                        if (a2.has("events")) {
                            aVar = this.f20262b;
                            jSONArray = a2.getJSONArray("events");
                        }
                        c();
                        return;
                    }
                    if (b2.a() != 200) {
                        if (a2.has("events")) {
                            aVar = this.f20262b;
                            jSONArray = a2.getJSONArray("events");
                        }
                    } else if (this.f20262b.a(new JSONArray(e2))) {
                        if (!this.f20262b.c()) {
                            e();
                            return;
                        }
                    }
                    c();
                    return;
                    aVar.b(jSONArray);
                    c();
                    return;
                }
            }
            a(this.f20269i);
        } catch (Exception unused) {
            c();
        }
    }

    private void e() {
        this.f20273m = 0;
        this.f20274n = 0;
        if (this.f20264d.getQueue().size() == 0) {
            this.f20262b.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20272l = true;
        this.f20267g.removeCallbacks(this.f20271k);
        a(this.f20268h);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.f20272l) {
            this.f20272l = true;
            this.f20267g.removeCallbacks(this.f20271k);
            a(this.f20269i);
        }
    }
}

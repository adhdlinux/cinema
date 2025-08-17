package com.facebook.ads.internal.view.e;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.c.e;
import com.facebook.ads.internal.q.c.f;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.b.a;
import com.facebook.ads.internal.view.component.e;
import com.facebook.ads.internal.view.component.h;
import com.facebook.ads.internal.view.f.b.z;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f21171a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final int f21172b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f21173c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f21174d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f21175e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f21176f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final k f21177g;

    /* renamed from: h  reason: collision with root package name */
    private final String f21178h;

    /* renamed from: i  reason: collision with root package name */
    private final d f21179i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.ads.internal.r.a f21180j;

    /* renamed from: k  reason: collision with root package name */
    private final u f21181k;

    /* renamed from: l  reason: collision with root package name */
    private Executor f21182l = AsyncTask.THREAD_POOL_EXECUTOR;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public a.C0037a f21183m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public com.facebook.ads.internal.view.b.a f21184n;

    /* renamed from: o  reason: collision with root package name */
    private a.b f21185o;

    /* renamed from: com.facebook.ads.internal.view.e.b$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21189a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.ads.internal.view.e.b$a[] r0 = com.facebook.ads.internal.view.e.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21189a = r0
                com.facebook.ads.internal.view.e.b$a r1 = com.facebook.ads.internal.view.e.b.a.MARKUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21189a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.view.e.b$a r1 = com.facebook.ads.internal.view.e.b.a.SCREENSHOTS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21189a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.view.e.b$a r1 = com.facebook.ads.internal.view.e.b.a.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.e.b.AnonymousClass3.<clinit>():void");
        }
    }

    public enum a {
        SCREENSHOTS,
        MARKUP,
        INFO
    }

    static {
        float f2 = x.f20694b;
        f21172b = (int) (4.0f * f2);
        f21173c = (int) (72.0f * f2);
        f21174d = (int) (f2 * 8.0f);
    }

    public b(Context context, c cVar, k kVar, a.C0037a aVar, com.facebook.ads.internal.r.a aVar2, u uVar) {
        this.f21175e = context;
        this.f21176f = cVar;
        this.f21177g = kVar;
        this.f21183m = aVar;
        this.f21178h = com.facebook.ads.internal.j.c.a(kVar.f().b());
        this.f21179i = kVar.d().a();
        this.f21180j = aVar2;
        this.f21181k = uVar;
    }

    /* access modifiers changed from: private */
    public void g() {
        a.C0037a aVar = this.f21183m;
        if (aVar != null) {
            aVar.a(z.REWARDED_VIDEO_END_ACTIVITY.a());
        }
    }

    private View h() {
        h hVar = new h(this.f21175e, this.f21179i, true, false, false);
        hVar.a(this.f21177g.b().a(), this.f21177g.b().c(), false, true);
        hVar.setAlignment(17);
        com.facebook.ads.internal.view.component.a aVar = new com.facebook.ads.internal.view.component.a(this.f21175e, true, false, z.REWARDED_VIDEO_AD_CLICK.a(), this.f21179i, this.f21176f, this.f21183m, this.f21180j, this.f21181k);
        aVar.a(this.f21177g.c(), this.f21177g.g(), new HashMap());
        e eVar = new e(this.f21175e);
        x.a((View) eVar, 0);
        eVar.setRadius(50);
        new com.facebook.ads.internal.view.b.d((ImageView) eVar).a().a(this.f21177g.a().b());
        LinearLayout linearLayout = new LinearLayout(this.f21175e);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i2 = f21173c;
        linearLayout.addView(eVar, new LinearLayout.LayoutParams(i2, i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = f21174d;
        layoutParams.setMargins(0, i3, 0, i3);
        linearLayout.addView(hVar, layoutParams);
        linearLayout.addView(aVar, layoutParams);
        return linearLayout;
    }

    private View i() {
        RecyclerView recyclerView = new RecyclerView(this.f21175e);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f21175e, 0, false));
        recyclerView.setAdapter(new c(this.f21177g.f().d(), f21172b));
        return recyclerView;
    }

    private View j() {
        this.f21185o = new a.c() {
            public void a() {
                if (b.this.f21184n != null && !TextUtils.isEmpty(b.this.f21177g.f().c())) {
                    b.this.f21184n.post(new Runnable() {
                        public void run() {
                            if (b.this.f21184n == null || b.this.f21184n.c()) {
                                Log.w(b.f21171a, "Webview already destroyed, cannot activate");
                                return;
                            }
                            com.facebook.ads.internal.view.b.a f2 = b.this.f21184n;
                            f2.loadUrl("javascript:" + b.this.f21177g.f().c());
                        }
                    });
                }
            }

            public void a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if (!"fbad".equals(parse.getScheme()) || !parse.getAuthority().equals(MRAIDPresenter.CLOSE)) {
                    if ("fbad".equals(parse.getScheme()) && com.facebook.ads.internal.a.c.a(parse.getAuthority()) && b.this.f21183m != null) {
                        b.this.f21183m.a(z.REWARDED_VIDEO_AD_CLICK.a());
                    }
                    com.facebook.ads.internal.a.b a2 = com.facebook.ads.internal.a.c.a(b.this.f21175e, b.this.f21176f, b.this.f21177g.g(), parse, map);
                    if (a2 != null) {
                        try {
                            a2.b();
                        } catch (Exception e2) {
                            Log.e(b.f21171a, "Error executing action", e2);
                        }
                    }
                } else {
                    b.this.g();
                }
            }
        };
        com.facebook.ads.internal.view.b.a aVar = new com.facebook.ads.internal.view.b.a(this.f21175e, new WeakReference(this.f21185o), 1);
        this.f21184n = aVar;
        aVar.loadDataWithBaseURL(com.facebook.ads.internal.q.c.b.a(), this.f21178h, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
        return this.f21184n;
    }

    public boolean a() {
        return b() == a.MARKUP;
    }

    public a b() {
        return !this.f21177g.f().d().isEmpty() ? a.SCREENSHOTS : !TextUtils.isEmpty(this.f21178h) ? a.MARKUP : a.INFO;
    }

    public Pair<a, View> c() {
        a b2 = b();
        int i2 = AnonymousClass3.f21189a[b2.ordinal()];
        return i2 != 1 ? i2 != 2 ? new Pair<>(b2, h()) : new Pair<>(b2, i()) : new Pair<>(b2, j());
    }

    public void d() {
        String a2 = this.f21177g.f().a();
        if (!TextUtils.isEmpty(a2)) {
            com.facebook.ads.internal.q.c.e eVar = new com.facebook.ads.internal.q.c.e(this.f21175e, new HashMap());
            eVar.a((e.a) new e.a() {
                public void a() {
                    if (b.this.f21183m != null) {
                        b.this.f21183m.a(z.REWARD_SERVER_FAILED.a());
                    }
                }

                public void a(f fVar) {
                    a.C0037a aVar;
                    z zVar;
                    if (b.this.f21183m != null) {
                        if (fVar == null || !fVar.a()) {
                            aVar = b.this.f21183m;
                            zVar = z.REWARD_SERVER_FAILED;
                        } else {
                            aVar = b.this.f21183m;
                            zVar = z.REWARD_SERVER_SUCCESS;
                        }
                        aVar.a(zVar.a());
                    }
                }
            });
            eVar.executeOnExecutor(this.f21182l, new String[]{a2});
        }
    }

    public void e() {
        com.facebook.ads.internal.view.b.a aVar = this.f21184n;
        if (aVar != null) {
            aVar.destroy();
            this.f21184n = null;
            this.f21185o = null;
        }
    }
}

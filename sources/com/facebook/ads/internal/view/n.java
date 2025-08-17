package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.j;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.adapters.aa;
import com.facebook.ads.internal.q.a.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.c.e;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.b.a;
import com.facebook.ads.internal.view.f;
import com.facebook.ads.internal.view.f.b.z;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
public class n extends RelativeLayout implements f.a, a, a.d {

    /* renamed from: a  reason: collision with root package name */
    private static final RelativeLayout.LayoutParams f21641a = new RelativeLayout.LayoutParams(-1, -1);

    /* renamed from: b  reason: collision with root package name */
    private final RelativeLayout f21642b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.facebook.ads.internal.m.c f21643c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final k f21644d;

    /* renamed from: e  reason: collision with root package name */
    private final j f21645e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final com.facebook.ads.internal.adapters.a.a f21646f;

    /* renamed from: g  reason: collision with root package name */
    private final f f21647g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final f f21648h;

    /* renamed from: i  reason: collision with root package name */
    private final f f21649i;

    /* renamed from: j  reason: collision with root package name */
    private int f21650j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public WeakReference<com.facebook.ads.internal.view.b.a> f21651k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f21652l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Context f21653m;

    /* renamed from: n  reason: collision with root package name */
    private AudienceNetworkActivity f21654n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public a.C0037a f21655o;

    /* renamed from: p  reason: collision with root package name */
    private a.b f21656p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final AtomicBoolean f21657q = new AtomicBoolean();

    /* renamed from: r  reason: collision with root package name */
    private Executor f21658r = AsyncTask.THREAD_POOL_EXECUTOR;

    /* renamed from: s  reason: collision with root package name */
    private final AudienceNetworkActivity.BackButtonInterceptor f21659s = new AudienceNetworkActivity.BackButtonInterceptor() {
        public boolean interceptBackButton() {
            return !n.this.f21648h.d();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public aa f21660t;

    private static class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<com.facebook.ads.internal.view.b.a> f21666a;

        /* renamed from: b  reason: collision with root package name */
        final com.facebook.ads.internal.m.c f21667b;

        /* renamed from: c  reason: collision with root package name */
        final k f21668c;

        private a(com.facebook.ads.internal.view.b.a aVar, com.facebook.ads.internal.m.c cVar, k kVar) {
            this.f21666a = new WeakReference<>(aVar);
            this.f21667b = cVar;
            this.f21668c = kVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f21666a.get() == null || motionEvent.getAction() != 1) {
                return false;
            }
            HashMap hashMap = new HashMap();
            this.f21666a.get().getViewabilityChecker().a((Map<String, String>) hashMap);
            hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(this.f21666a.get().getTouchDataRecorder().e()));
            this.f21667b.d(this.f21668c.g(), hashMap);
            return false;
        }
    }

    private class b {
        private b() {
        }

        @JavascriptInterface
        public void onCTAClick() {
            if (n.this.f21651k.get() != null) {
                com.facebook.ads.internal.view.b.a aVar = (com.facebook.ads.internal.view.b.a) n.this.f21651k.get();
                com.facebook.ads.internal.view.component.a aVar2 = new com.facebook.ads.internal.view.component.a(n.this.f21653m, true, false, z.REWARDED_VIDEO_AD_CLICK.a(), n.this.f21646f.a(), n.this.f21643c, n.this.f21655o, aVar.getViewabilityChecker(), aVar.getTouchDataRecorder());
                aVar2.a(n.this.f21644d.c(), n.this.f21644d.g(), new HashMap());
                aVar2.performClick();
            }
        }
    }

    private static class c implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a.C0037a> f21670a;

        private c(WeakReference<a.C0037a> weakReference) {
            this.f21670a = weakReference;
        }

        public void a() {
            if (this.f21670a.get() != null) {
                this.f21670a.get().a(z.REWARD_SERVER_FAILED.a());
            }
        }

        public void a(com.facebook.ads.internal.q.c.f fVar) {
            a.C0037a aVar;
            z zVar;
            if (this.f21670a.get() != null) {
                if (fVar == null || !fVar.a()) {
                    aVar = this.f21670a.get();
                    zVar = z.REWARD_SERVER_FAILED;
                } else {
                    aVar = this.f21670a.get();
                    zVar = z.REWARD_SERVER_SUCCESS;
                }
                aVar.a(zVar.a());
            }
        }
    }

    public n(Context context, com.facebook.ads.internal.m.c cVar, a.C0037a aVar, k kVar) {
        super(context);
        this.f21653m = context;
        this.f21655o = aVar;
        this.f21643c = cVar;
        this.f21644d = kVar;
        j j2 = kVar.e().j();
        this.f21645e = j2;
        this.f21646f = kVar.d();
        this.f21642b = new RelativeLayout(context);
        this.f21647g = new f(context);
        this.f21648h = new f(j2.b(), this);
        this.f21649i = new f(3, new f.a() {
            public void a() {
                n.this.c();
            }

            public void a(int i2) {
            }
        });
    }

    private void a(AudienceNetworkActivity audienceNetworkActivity) {
        this.f21650j = audienceNetworkActivity.getRequestedOrientation();
        audienceNetworkActivity.setRequestedOrientation(1);
    }

    private void a(com.facebook.ads.internal.view.b.a aVar) {
        if (this.f21653m != null) {
            aa aaVar = new aa(this.f21653m, this.f21643c, aVar.getViewabilityChecker(), aVar.getTouchDataRecorder(), new com.facebook.ads.internal.adapters.c() {
                public void a() {
                    if (n.this.f21655o != null) {
                        n.this.f21655o.a(z.REWARDED_VIDEO_IMPRESSION.a());
                    }
                }
            });
            this.f21660t = aaVar;
            aaVar.a(this.f21644d);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        com.facebook.ads.internal.view.b.a d2 = d();
        d2.loadUrl(this.f21645e.a());
        d2.setOnTouchListener(new a(d2, this.f21643c, this.f21644d));
        d2.addJavascriptInterface(new b(), "FbPlayableAd");
        x.a((View) this.f21642b, this.f21646f.a().d(true));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, this.f21647g.getId());
        d2.setLayoutParams(layoutParams);
        d2.setVisibility(4);
        d2.setOnAssetsLoadedListener(this);
        this.f21642b.addView(this.f21647g);
        this.f21642b.addView(d2);
    }

    private com.facebook.ads.internal.view.b.a d() {
        this.f21656p = new a.c() {
            public void a(WebResourceError webResourceError) {
                boolean unused = n.this.f21652l = true;
                if (n.this.f21651k.get() != null) {
                    ((com.facebook.ads.internal.view.b.a) n.this.f21651k.get()).setVisibility(4);
                }
                if (n.this.f21655o != null) {
                    n.this.f21655o.a(z.REWARDED_VIDEO_ERROR.a());
                }
            }

            public void b() {
                if (n.this.f21657q.compareAndSet(false, true)) {
                    n.this.f21648h.a();
                    n.this.f21660t.a();
                }
            }
        };
        com.facebook.ads.internal.view.b.a aVar = new com.facebook.ads.internal.view.b.a(this.f21653m, new WeakReference(this.f21656p), 10);
        aVar.setLogMultipleImpressions(false);
        aVar.setWaitForAssetsToLoad(true);
        aVar.setCheckAssetsByJavascriptBridge(false);
        WebSettings settings = aVar.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        a(aVar);
        this.f21651k = new WeakReference<>(aVar);
        return aVar;
    }

    private void e() {
        String a2 = this.f21644d.f().a();
        if (this.f21653m != null || !TextUtils.isEmpty(a2)) {
            e eVar = new e(this.f21653m, new HashMap());
            eVar.a((e.a) new c(new WeakReference(this.f21655o)));
            eVar.executeOnExecutor(this.f21658r, new String[]{a2});
        }
    }

    private void f() {
        a.C0037a aVar = this.f21655o;
        if (aVar != null) {
            aVar.a(z.REWARDED_VIDEO_COMPLETE.a(), new com.facebook.ads.internal.view.f.b.b(0, 0));
        }
    }

    public void a() {
        this.f21647g.a(true);
        e();
        f();
    }

    public void a(int i2) {
        this.f21647g.setProgress((1.0f - (((float) i2) / ((float) this.f21645e.b()))) * 100.0f);
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.f21655o != null && this.f21653m != null) {
            this.f21654n = audienceNetworkActivity;
            audienceNetworkActivity.addBackButtonInterceptor(this.f21659s);
            a(audienceNetworkActivity);
            this.f21647g.a(this.f21646f.a(), true);
            this.f21647g.setShowPageDetails(false);
            this.f21647g.a(this.f21644d.a(), this.f21644d.g(), this.f21645e.b());
            this.f21647g.setToolbarListener(new f.a() {
                public void a() {
                    if (n.this.f21655o != null) {
                        n.this.f21655o.a(z.REWARDED_VIDEO_END_ACTIVITY.a());
                    }
                }
            });
            x.a((View) this.f21647g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            this.f21647g.setLayoutParams(layoutParams);
            com.facebook.ads.internal.view.d.a aVar = new com.facebook.ads.internal.view.d.a(this.f21653m, this.f21644d);
            RelativeLayout relativeLayout = this.f21642b;
            RelativeLayout.LayoutParams layoutParams2 = f21641a;
            relativeLayout.setLayoutParams(layoutParams2);
            x.a((View) this.f21642b, this.f21646f.a().d(true));
            this.f21642b.addView(aVar, layoutParams2);
            addView(this.f21642b);
            setLayoutParams(layoutParams2);
            this.f21655o.a((View) this);
            this.f21649i.a();
        }
    }

    public void a(Bundle bundle) {
    }

    public void b() {
        if (!this.f21652l && this.f21651k.get() != null) {
            this.f21651k.get().setVisibility(0);
        }
    }

    public void i() {
        this.f21649i.b();
        this.f21648h.b();
    }

    public void j() {
        com.facebook.ads.internal.q.a.f fVar;
        if (!this.f21649i.d()) {
            fVar = this.f21649i;
        } else if (!this.f21648h.c()) {
            fVar = this.f21648h;
        } else {
            return;
        }
        fVar.a();
    }

    public void onDestroy() {
        this.f21649i.b();
        this.f21648h.b();
        this.f21647g.setToolbarListener((f.a) null);
        AudienceNetworkActivity audienceNetworkActivity = this.f21654n;
        if (audienceNetworkActivity != null) {
            audienceNetworkActivity.removeBackButtonInterceptor(this.f21659s);
            this.f21654n.setRequestedOrientation(this.f21650j);
        }
        com.facebook.ads.internal.view.b.a aVar = this.f21651k.get();
        if (aVar != null) {
            aVar.removeJavascriptInterface("FbPlayableAd");
        }
        if (aVar != null && !TextUtils.isEmpty(this.f21644d.g())) {
            HashMap hashMap = new HashMap();
            aVar.getViewabilityChecker().a((Map<String, String>) hashMap);
            hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(aVar.getTouchDataRecorder().e()));
            this.f21643c.i(this.f21644d.g(), hashMap);
        }
        this.f21655o = null;
        this.f21656p = null;
        this.f21654n = null;
        this.f21653m = null;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        WeakReference<com.facebook.ads.internal.view.b.a> weakReference = this.f21651k;
        if (weakReference != null && weakReference.get() != null) {
            if (z2) {
                j();
            } else {
                i();
            }
        }
    }

    public void setListener(a.C0037a aVar) {
        this.f21655o = aVar;
    }
}

package com.adcolony.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import java.io.File;

public class AdColonyAdView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private c f12822b;

    /* renamed from: c  reason: collision with root package name */
    private AdColonyAdViewListener f12823c;

    /* renamed from: d  reason: collision with root package name */
    private String f12824d;

    /* renamed from: e  reason: collision with root package name */
    private String f12825e;

    /* renamed from: f  reason: collision with root package name */
    private String f12826f;

    /* renamed from: g  reason: collision with root package name */
    private String f12827g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f12828h;

    /* renamed from: i  reason: collision with root package name */
    private p0 f12829i;

    /* renamed from: j  reason: collision with root package name */
    private h0 f12830j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12831k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12832l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12833m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12834n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12835o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12836p = true;

    /* renamed from: q  reason: collision with root package name */
    private int f12837q;

    /* renamed from: r  reason: collision with root package name */
    private int f12838r;

    /* renamed from: s  reason: collision with root package name */
    private int f12839s;

    /* renamed from: t  reason: collision with root package name */
    private int f12840t;

    /* renamed from: u  reason: collision with root package name */
    private int f12841u;

    /* renamed from: v  reason: collision with root package name */
    private c f12842v;

    class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f12843b;

        b(AdColonyAdView adColonyAdView, Context context) {
            this.f12843b = context;
        }

        public void onClick(View view) {
            Context context = this.f12843b;
            if (context instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) context).f();
            }
        }
    }

    interface c {
        void a();
    }

    AdColonyAdView(Context context, h0 h0Var, AdColonyAdViewListener adColonyAdViewListener) throws RuntimeException {
        super(context);
        this.f12823c = adColonyAdViewListener;
        this.f12825e = adColonyAdViewListener.d();
        f1 a2 = h0Var.a();
        this.f12824d = c0.E(a2, "id");
        this.f12826f = c0.E(a2, "close_button_filepath");
        this.f12831k = c0.t(a2, "trusted_demand_source");
        this.f12835o = c0.t(a2, "close_button_snap_to_webview");
        this.f12840t = c0.A(a2, "close_button_width");
        this.f12841u = c0.A(a2, "close_button_height");
        c cVar = a.f().T().p().get(this.f12824d);
        this.f12822b = cVar;
        if (cVar != null) {
            adColonyAdViewListener.a();
            setLayoutParams(new FrameLayout.LayoutParams(this.f12822b.s(), this.f12822b.k()));
            setBackgroundColor(0);
            addView(this.f12822b);
            return;
        }
        throw new RuntimeException("AdColonyAdView container cannot be null");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f12831k || this.f12834n) {
            a.f().x0().U();
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        int i2;
        int i3;
        if (this.f12831k || this.f12834n) {
            q x02 = a.f().x0();
            Rect Y = x02.Y();
            int i4 = this.f12838r;
            if (i4 <= 0) {
                i4 = Y.width();
            }
            int i5 = this.f12839s;
            if (i5 <= 0) {
                i5 = Y.height();
            }
            int width = (Y.width() - i4) / 2;
            int height = (Y.height() - i5) / 2;
            this.f12822b.setLayoutParams(new FrameLayout.LayoutParams(Y.width(), Y.height()));
            b1 webView = getWebView();
            if (webView != null) {
                h0 h0Var = new h0("WebView.set_bounds", 0);
                f1 q2 = c0.q();
                c0.u(q2, "x", width);
                c0.u(q2, "y", height);
                c0.u(q2, "width", i4);
                c0.u(q2, "height", i5);
                h0Var.d(q2);
                webView.h(h0Var);
                float U = x02.U();
                f1 q3 = c0.q();
                c0.u(q3, "app_orientation", z0.F(z0.M()));
                c0.u(q3, "width", (int) (((float) i4) / U));
                c0.u(q3, "height", (int) (((float) i5) / U));
                c0.u(q3, "x", z0.b(webView));
                c0.u(q3, "y", z0.s(webView));
                c0.n(q3, "ad_session_id", this.f12824d);
                new h0("MRAID.on_size_change", this.f12822b.I(), q3).e();
            }
            ImageView imageView = this.f12828h;
            if (imageView != null) {
                this.f12822b.removeView(imageView);
            }
            Context a2 = a.a();
            if (!(a2 == null || this.f12833m || webView == null)) {
                float U2 = a.f().x0().U();
                int i6 = (int) (((float) this.f12840t) * U2);
                int i7 = (int) (((float) this.f12841u) * U2);
                if (this.f12835o) {
                    i2 = webView.getCurrentX() + webView.getCurrentWidth();
                } else {
                    i2 = Y.width();
                }
                if (this.f12835o) {
                    i3 = webView.getCurrentY();
                } else {
                    i3 = 0;
                }
                ImageView imageView2 = new ImageView(a2.getApplicationContext());
                this.f12828h = imageView2;
                imageView2.setImageURI(Uri.fromFile(new File(this.f12826f)));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
                layoutParams.setMargins(i2 - i6, i3, 0, 0);
                this.f12828h.setOnClickListener(new b(this, a2));
                this.f12822b.addView(this.f12828h, layoutParams);
                this.f12822b.f(this.f12828h, FriendlyObstructionPurpose.CLOSE_AD);
            }
            if (this.f12830j != null) {
                f1 q4 = c0.q();
                c0.w(q4, "success", true);
                this.f12830j.b(q4).e();
                this.f12830j = null;
            }
            return true;
        }
        if (this.f12830j != null) {
            f1 q5 = c0.q();
            c0.w(q5, "success", false);
            this.f12830j.b(q5).e();
            this.f12830j = null;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f12834n;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f12832l;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        b1 webView = getWebView();
        if (this.f12829i != null && webView != null) {
            webView.r();
        }
    }

    public AdColonyAdSize getAdSize() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getClickOverride() {
        return this.f12827g;
    }

    /* access modifiers changed from: package-private */
    public c getContainer() {
        return this.f12822b;
    }

    public AdColonyAdViewListener getListener() {
        return this.f12823c;
    }

    /* access modifiers changed from: package-private */
    public p0 getOmidManager() {
        return this.f12829i;
    }

    /* access modifiers changed from: package-private */
    public int getOrientation() {
        return this.f12837q;
    }

    /* access modifiers changed from: package-private */
    public boolean getTrustedDemandSource() {
        return this.f12831k;
    }

    /* access modifiers changed from: package-private */
    public b1 getWebView() {
        c cVar = this.f12822b;
        if (cVar == null) {
            return null;
        }
        return cVar.L().get(2);
    }

    public String getZoneId() {
        return this.f12825e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12836p && !this.f12832l) {
            this.f12836p = false;
            AdColonyAdViewListener adColonyAdViewListener = this.f12823c;
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.j(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setClickOverride(String str) {
        this.f12827g = str;
    }

    /* access modifiers changed from: package-private */
    public void setExpandMessage(h0 h0Var) {
        this.f12830j = h0Var;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedHeight(int i2) {
        this.f12839s = (int) (((float) i2) * a.f().x0().U());
    }

    /* access modifiers changed from: package-private */
    public void setExpandedWidth(int i2) {
        this.f12838r = (int) (((float) i2) * a.f().x0().U());
    }

    public void setListener(AdColonyAdViewListener adColonyAdViewListener) {
        this.f12823c = adColonyAdViewListener;
    }

    /* access modifiers changed from: package-private */
    public void setNoCloseButton(boolean z2) {
        this.f12833m = this.f12831k && z2;
    }

    /* access modifiers changed from: package-private */
    public void setOmidManager(p0 p0Var) {
        this.f12829i = p0Var;
    }

    /* access modifiers changed from: package-private */
    public void setOnDestroyListenerOrCall(c cVar) {
        if (this.f12832l) {
            cVar.a();
        } else {
            this.f12842v = cVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOrientation(int i2) {
        this.f12837q = i2;
    }

    /* access modifiers changed from: package-private */
    public void setUserInteraction(boolean z2) {
        this.f12834n = z2;
    }
}

package com.adcolony.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import com.adcolony.sdk.c1;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import java.io.File;
import kotlin.Unit;
import kotlin.text.Regex;

public final class l0 extends c1 {
    private final int G;
    private ImageView H;
    private String I = "";
    /* access modifiers changed from: private */
    public String J = "";
    private int K;
    private int L;
    private boolean M;
    private boolean N;

    private final class a extends c1.c {
        public a() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class b extends c1.d {
        public b() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class c extends c1.e {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class d extends c1.f {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class e extends c1.g {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class f {
        public f() {
        }

        public final void a() {
            if (!l0.this.getModuleInitialized()) {
                float U = a.f().x0().U();
                f1 info = l0.this.getInfo();
                l0 l0Var = l0.this;
                c0.u(info, "app_orientation", z0.F(z0.M()));
                c0.u(info, "x", z0.b(l0Var));
                c0.u(info, "y", z0.s(l0Var));
                c0.u(info, "width", (int) (((float) l0Var.getCurrentWidth()) / U));
                c0.u(info, "height", (int) (((float) l0Var.getCurrentHeight()) / U));
                c0.n(info, "ad_session_id", l0Var.getAdSessionId());
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l0 f13251b;

        g(l0 l0Var) {
            this.f13251b = l0Var;
        }

        public final void onClick(View view) {
            z0.k(new Intent("android.intent.action.VIEW", Uri.parse(this.f13251b.J)));
            a.f().a().h(this.f13251b.getAdSessionId());
        }
    }

    public l0(Context context, int i2, h0 h0Var, int i3) {
        super(context, i2, h0Var);
        this.G = i3;
    }

    private final void Y() {
        Context a2 = a.a();
        if (a2 != null && getParentContainer() != null && !this.N) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            ImageView imageView = new ImageView(a2);
            imageView.setImageURI(Uri.fromFile(new File(this.I)));
            imageView.setBackground(gradientDrawable);
            imageView.setOnClickListener(new g(this));
            Unit unit = Unit.f40298a;
            this.H = imageView;
            Z();
            addView(this.H);
        }
    }

    private final void Z() {
        int i2;
        int i3;
        ImageView imageView = this.H;
        if (imageView != null) {
            Rect Y = a.f().x0().Y();
            if (this.M) {
                i2 = getCurrentX() + getCurrentWidth();
            } else {
                i2 = Y.width();
            }
            if (this.M) {
                i3 = getCurrentY() + getCurrentHeight();
            } else {
                i3 = Y.height();
            }
            float U = a.f().x0().U();
            int i4 = (int) (((float) this.K) * U);
            int i5 = (int) (((float) this.L) * U);
            imageView.setLayoutParams(new AbsoluteLayout.LayoutParams(i4, i5, i2 - i4, i3 - i5));
        }
    }

    public final void X() {
        c parentContainer;
        ImageView imageView = this.H;
        if (imageView != null && (parentContainer = getParentContainer()) != null) {
            parentContainer.f(imageView, FriendlyObstructionPurpose.OTHER);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ int getAdc3ModuleId() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void i(h0 h0Var, int i2, c cVar) {
        f1 a2 = h0Var.a();
        this.I = c0.E(a2, "ad_choices_filepath");
        this.J = c0.E(a2, "ad_choices_url");
        this.K = c0.A(a2, "ad_choices_width");
        this.L = c0.A(a2, "ad_choices_height");
        this.M = c0.t(a2, "ad_choices_snap_to_webview");
        this.N = c0.t(a2, "disable_ad_choices");
        super.i(h0Var, i2, cVar);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ boolean m(f1 f1Var, String str) {
        if (super.m(f1Var, str)) {
            return true;
        }
        setEnableMessages(false);
        return true;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void q() {
        boolean z2;
        super.q();
        boolean z3 = true;
        if (this.I.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.J.length() <= 0) {
                z3 = false;
            }
            if (z3) {
                Y();
            }
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setBounds(h0 h0Var) {
        super.setBounds(h0Var);
        Z();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void w() {
        boolean z2;
        if (getMraidFilepath().length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Regex regex = new Regex("script\\s*src\\s*=\\s*\"mraid.js\"");
            setMUrl(z(regex.j(getMUrl(), "script src=\"file://" + getMraidFilepath() + '\"'), c0.E(c0.C(getInfo(), "device_info"), "iab_filepath")));
        }
    }
}

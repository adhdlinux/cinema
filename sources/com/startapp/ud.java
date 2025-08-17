package com.startapp;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.inappbrowser.AnimatingProgressBar;
import com.startapp.sdk.inappbrowser.NavigationBarLayout;
import java.util.HashMap;

public class ud extends v3 implements View.OnClickListener {

    /* renamed from: v  reason: collision with root package name */
    public static boolean f36674v = false;
    public FrameLayout A;
    public String B;

    /* renamed from: w  reason: collision with root package name */
    public RelativeLayout f36675w;

    /* renamed from: x  reason: collision with root package name */
    public NavigationBarLayout f36676x;

    /* renamed from: y  reason: collision with root package name */
    public WebView f36677y;

    /* renamed from: z  reason: collision with root package name */
    public AnimatingProgressBar f36678z;

    public class a extends WebChromeClient {
        public a() {
        }

        public void onProgressChanged(WebView webView, int i2) {
            ud.this.f36678z.setProgress(i2);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (str != null && !str.equals("")) {
                ud.this.f36676x.f36508h.setText(str);
            }
        }
    }

    public static class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public Context f36680a;

        /* renamed from: b  reason: collision with root package name */
        public ud f36681b;

        /* renamed from: c  reason: collision with root package name */
        public NavigationBarLayout f36682c;

        /* renamed from: d  reason: collision with root package name */
        public AnimatingProgressBar f36683d;

        /* renamed from: e  reason: collision with root package name */
        public int f36684e = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36685f = false;

        public b(Context context, NavigationBarLayout navigationBarLayout, AnimatingProgressBar animatingProgressBar, ud udVar) {
            this.f36680a = context;
            this.f36683d = animatingProgressBar;
            this.f36682c = navigationBarLayout;
            this.f36681b = udVar;
        }

        public void onPageFinished(WebView webView, String str) {
            if (!ud.f36674v) {
                this.f36682c.a(webView);
                int i2 = this.f36684e - 1;
                this.f36684e = i2;
                if (i2 == 0) {
                    this.f36685f = false;
                    this.f36683d.a();
                    if (this.f36683d.isShown()) {
                        this.f36683d.setVisibility(8);
                    }
                    this.f36682c.a(webView);
                }
                super.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!ud.f36674v) {
                if (this.f36685f) {
                    this.f36684e = 1;
                    this.f36683d.a();
                    this.f36682c.a(webView);
                } else {
                    this.f36684e = Math.max(this.f36684e, 1);
                }
                this.f36683d.setVisibility(0);
                this.f36682c.f36509i.setText(str);
                this.f36682c.a(webView);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            this.f36683d.a();
            super.onReceivedError(webView, i2, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView != null && str != null && !lb.b(webView.getContext(), str) && !ud.f36674v) {
                if (!this.f36685f) {
                    this.f36685f = true;
                    this.f36683d.a();
                    this.f36684e = 0;
                }
                this.f36684e++;
                if (o6.c(str) && !o6.b(str)) {
                    return false;
                }
                this.f36684e = 1;
                o6.b(this.f36680a, str, (String) null);
                ud udVar = this.f36681b;
                if (udVar != null) {
                    udVar.i();
                }
            }
            return true;
        }
    }

    public ud(String str) {
        this.B = str;
    }

    public void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        wb.a((Context) this.f36704b).a(this.f36706d, new IntentFilter("com.startapp.android.CloseAdActivity"));
        f36674v = false;
        this.f36675w = new RelativeLayout(this.f36704b);
        String str = this.B;
        if (this.f36676x == null) {
            NavigationBarLayout navigationBarLayout = new NavigationBarLayout(this.f36704b);
            this.f36676x = navigationBarLayout;
            navigationBarLayout.setDescendantFocusability(262144);
            navigationBarLayout.setBackgroundColor(Color.parseColor("#e9e9e9"));
            navigationBarLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, p.a(navigationBarLayout.getContext(), 60)));
            navigationBarLayout.setId(RemoteMediaPlayer.STATUS_CANCELED);
            HashMap hashMap = new HashMap();
            hashMap.put("BACK", new vd((Bitmap) null, 14, 22, "back_.png"));
            hashMap.put("BACK_DARK", new vd((Bitmap) null, 14, 22, "back_dark.png"));
            hashMap.put("FORWARD", new vd((Bitmap) null, 14, 22, "forward_.png"));
            hashMap.put("FORWARD_DARK", new vd((Bitmap) null, 14, 22, "forward_dark.png"));
            hashMap.put("X", new vd((Bitmap) null, 23, 23, "x_dark.png"));
            hashMap.put("BROWSER", new vd((Bitmap) null, 28, 28, "browser_icon_dark.png"));
            navigationBarLayout.f36511k = hashMap;
            NavigationBarLayout navigationBarLayout2 = this.f36676x;
            navigationBarLayout2.getClass();
            Typeface typeface = Typeface.DEFAULT;
            Typeface typeface2 = typeface;
            navigationBarLayout2.f36508h = p.a(navigationBarLayout2.getContext(), navigationBarLayout2.f36508h, typeface2, 1, 16.46f, NavigationBarLayout.f36501a, RemoteMediaPlayer.STATUS_TIMED_OUT);
            navigationBarLayout2.f36509i = p.a(navigationBarLayout2.getContext(), navigationBarLayout2.f36508h, typeface2, 1, 12.12f, NavigationBarLayout.f36502b, 2107);
            navigationBarLayout2.f36508h.setText("Loading...");
            RelativeLayout relativeLayout = new RelativeLayout(navigationBarLayout2.getContext());
            navigationBarLayout2.f36503c = relativeLayout;
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            navigationBarLayout2.f36503c.addView(navigationBarLayout2.f36508h, p.a(navigationBarLayout2.getContext(), new int[]{0, 0, 0, 0}, new int[0]));
            RelativeLayout relativeLayout2 = navigationBarLayout2.f36503c;
            TextView textView = navigationBarLayout2.f36509i;
            RelativeLayout.LayoutParams a2 = p.a(navigationBarLayout2.getContext(), new int[]{0, 0, 0, 0}, new int[0]);
            a2.addRule(3, RemoteMediaPlayer.STATUS_TIMED_OUT);
            relativeLayout2.addView(textView, a2);
            for (vd next : navigationBarLayout2.f36511k.values()) {
                Bitmap a3 = ka.a(navigationBarLayout2.getContext(), next.f36748d);
                if (a3 != null) {
                    next.f36745a = Bitmap.createScaledBitmap(a3, p.a(navigationBarLayout2.getContext(), next.f36746b), p.a(navigationBarLayout2.getContext(), next.f36747c), true);
                }
            }
            navigationBarLayout2.f36504d = p.a(navigationBarLayout2.getContext(), navigationBarLayout2.f36504d, navigationBarLayout2.f36511k.get("X").f36745a, 2103);
            navigationBarLayout2.f36506f = p.a(navigationBarLayout2.getContext(), navigationBarLayout2.f36506f, navigationBarLayout2.f36511k.get("BROWSER").f36745a, (int) CastStatusCodes.MEDIA_ERROR);
            navigationBarLayout2.f36507g = p.a(navigationBarLayout2.getContext(), navigationBarLayout2.f36507g, navigationBarLayout2.f36511k.get("BACK").f36745a, 2105);
            navigationBarLayout2.f36505e = p.a(navigationBarLayout2.getContext(), navigationBarLayout2.f36505e, navigationBarLayout2.f36511k.get("FORWARD").f36745a, 2106);
            int a4 = p.a(navigationBarLayout2.getContext(), 10);
            navigationBarLayout2.f36505e.setPadding(a4, a4, a4, a4);
            navigationBarLayout2.f36505e.setEnabled(false);
            navigationBarLayout2.f36507g.setPadding(a4, a4, a4, a4);
            navigationBarLayout2.addView(navigationBarLayout2.f36504d, p.a(navigationBarLayout2.getContext(), new int[]{0, 0, 16, 0}, new int[]{15, 11}));
            ImageView imageView = navigationBarLayout2.f36506f;
            RelativeLayout.LayoutParams a5 = p.a(navigationBarLayout2.getContext(), new int[]{0, 0, 17, 0}, new int[]{15});
            a5.addRule(0, 2103);
            navigationBarLayout2.addView(imageView, a5);
            RelativeLayout relativeLayout3 = navigationBarLayout2.f36503c;
            RelativeLayout.LayoutParams a6 = p.a(navigationBarLayout2.getContext(), new int[]{16, 6, 16, 0}, new int[]{9});
            a6.addRule(0, CastStatusCodes.MEDIA_ERROR);
            navigationBarLayout2.addView(relativeLayout3, a6);
            this.f36676x.setButtonsListener(this);
        }
        this.f36675w.addView(this.f36676x);
        this.f36678z = new AnimatingProgressBar(this.f36704b, (AttributeSet) null, 16842872);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#45d200"));
        this.f36678z.setProgressDrawable(new ClipDrawable(shapeDrawable, 3, 1));
        this.f36678z.setBackgroundColor(-1);
        this.f36678z.setId(2108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, p.a((Context) this.f36704b, 4));
        layoutParams.addRule(3, RemoteMediaPlayer.STATUS_CANCELED);
        this.f36675w.addView(this.f36678z, layoutParams);
        this.A = new FrameLayout(this.f36704b);
        if (this.f36677y == null) {
            try {
                j();
                this.f36677y.loadUrl(str);
            } catch (Throwable th) {
                y8.a((Context) this.f36704b, th);
                this.f36676x.a();
                o6.b((Context) this.f36704b, str, (String) null);
                this.f36704b.finish();
            }
        }
        this.A.addView(this.f36677y);
        this.A.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(3, 2108);
        this.f36675w.addView(this.A, layoutParams2);
        if (bundle2 != null) {
            this.f36677y.restoreState(bundle2);
        }
        this.f36704b.setContentView(this.f36675w, new RelativeLayout.LayoutParams(-2, -2));
    }

    public void b(Bundle bundle) {
        this.f36677y.saveState(bundle);
    }

    public void e() {
    }

    public void f() {
    }

    public void i() {
        try {
            f36674v = true;
            this.f36677y.stopLoading();
            this.f36677y.removeAllViews();
            this.f36677y.postInvalidate();
            hc.a(this.f36677y);
            this.f36677y.destroy();
            this.f36677y = null;
        } catch (Exception unused) {
        }
        this.f36676x.a();
        this.f36704b.finish();
    }

    public final void j() {
        WebView b2 = ComponentLocator.a((Context) this.f36704b).u().b();
        this.f36677y = b2;
        b2.getSettings().setJavaScriptEnabled(true);
        this.f36677y.getSettings().setUseWideViewPort(true);
        this.f36677y.getSettings().setLoadWithOverviewMode(true);
        this.f36677y.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f36677y.getSettings().setBuiltInZoomControls(true);
        this.f36677y.getSettings().setDisplayZoomControls(false);
        this.f36677y.setWebViewClient(new b(this.f36704b, this.f36676x, this.f36678z, this));
        this.f36677y.setWebChromeClient(new a());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2103:
                i();
                return;
            case CastStatusCodes.MEDIA_ERROR:
                WebView webView = this.f36677y;
                if (webView != null) {
                    o6.b((Context) this.f36704b, webView.getUrl(), (String) null);
                    i();
                    return;
                }
                return;
            case 2105:
                WebView webView2 = this.f36677y;
                if (webView2 != null && webView2.canGoBack()) {
                    this.f36678z.a();
                    this.f36677y.goBack();
                    return;
                }
                return;
            case 2106:
                WebView webView3 = this.f36677y;
                if (webView3 != null && webView3.canGoForward()) {
                    this.f36678z.a();
                    this.f36677y.goForward();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i2 != 4) {
            return false;
        }
        WebView webView = this.f36677y;
        if (webView == null || !webView.canGoBack()) {
            i();
            return true;
        }
        this.f36678z.a();
        this.f36677y.goBack();
        return true;
    }
}

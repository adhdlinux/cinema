package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationView;
import com.startapp.sdk.adsbase.commontracking.CloseTrackingParams;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.v3;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class w3 extends v3 implements View.OnClickListener {

    /* renamed from: v  reason: collision with root package name */
    public static final String f36799v = "w3";
    public Long A;
    public long B = 0;
    public z6 C;
    public boolean D = true;
    public boolean E = false;
    public int F = 0;
    public boolean G = false;
    public boolean H;
    public me I;
    public Runnable J = new a();
    public Runnable K = new b();

    /* renamed from: w  reason: collision with root package name */
    public WebView f36800w;

    /* renamed from: x  reason: collision with root package name */
    public RelativeLayout f36801x;

    /* renamed from: y  reason: collision with root package name */
    public ImageButton f36802y;

    /* renamed from: z  reason: collision with root package name */
    public Long f36803z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            w3.this.i();
            w3.this.b();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            w3 w3Var = w3.this;
            w3Var.D = true;
            WebView webView = w3Var.f36800w;
            if (webView != null) {
                webView.setOnTouchListener((View.OnTouchListener) null);
            }
        }
    }

    public class c implements View.OnLongClickListener {
        public c(w3 w3Var) {
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            w3.this.D = true;
            if (motionEvent.getAction() == 2) {
                return true;
            }
            return false;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            w3.this.b();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            WebView webView = w3.this.f36800w;
            if (webView != null) {
                hc.a(webView);
            }
        }
    }

    public class g extends WebViewClient {
        public g() {
        }

        public void onPageFinished(WebView webView, String str) {
            w3.this.a(webView);
            w3 w3Var = w3.this;
            lb.a(w3Var.f36800w, true, "gClientInterface.setMode", w3Var.f36710h);
            Object[] objArr = {"externalLinks"};
            lb.a(w3.this.f36800w, true, "enableScheme", objArr);
            w3.this.r();
            if (w3.this.s()) {
                wb.a(webView.getContext()).a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null || str == null || lb.b(webView.getContext(), str)) {
                return true;
            }
            if (!w3.this.D) {
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "fake_click";
                y8Var.f36957g = w3.this.a();
                y8Var.f36955e = "jsTag=" + w3.this.G;
                y8Var.a(w3.this.f36704b);
            }
            w3 w3Var = w3.this;
            if (!w3Var.G || w3Var.D) {
                return w3Var.a(str, false);
            }
            return false;
        }
    }

    public void a(Bundle bundle) {
        wb.a((Context) this.f36704b).a(this.f36706d, new IntentFilter("com.startapp.android.CloseAdActivity"));
        if (bundle == null) {
            this.H = true;
            if (this.f36703a.hasExtra("lastLoadTime")) {
                this.f36803z = (Long) this.f36703a.getSerializableExtra("lastLoadTime");
            }
            if (this.f36703a.hasExtra("adCacheTtl")) {
                this.A = (Long) this.f36703a.getSerializableExtra("adCacheTtl");
                return;
            }
            return;
        }
        if (bundle.containsKey("postrollHtml")) {
            a(bundle.getString("postrollHtml"));
        }
        if (bundle.containsKey("lastLoadTime")) {
            this.f36803z = (Long) bundle.getSerializable("lastLoadTime");
        }
        if (bundle.containsKey("adCacheTtl")) {
            this.A = (Long) bundle.getSerializable("adCacheTtl");
        }
        this.E = bundle.getBoolean("videoCompletedBroadcastSent", false);
        this.F = bundle.getInt("replayNum");
    }

    public void a(WebView webView) {
    }

    public void a(RelativeLayout relativeLayout) {
    }

    public final void b(String str, int i2, boolean z2) {
        int i3 = i2;
        Activity activity = this.f36704b;
        String[] strArr = this.f36712j;
        String[] strArr2 = i3 < strArr.length ? new String[]{strArr[i3]} : null;
        String[] strArr3 = this.f36713k;
        String str2 = i3 < strArr3.length ? strArr3[i3] : null;
        TrackingParams o2 = o();
        long z3 = AdsCommonMetaData.f36186h.z();
        long y2 = AdsCommonMetaData.f36186h.y();
        boolean a2 = a(i3);
        Boolean[] boolArr = this.f36720r;
        o6.a(activity, str, strArr2, str2, o2, z3, y2, a2, (boolArr == null || i3 < 0 || i3 >= boolArr.length) ? null : boolArr[i3], z2, new e());
    }

    public boolean c() {
        i();
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.f36234q = false;
        this.C.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
        return false;
    }

    public void d() {
        if (this.f36706d != null) {
            wb.a((Context) this.f36704b).a(this.f36706d);
        }
        this.f36706d = null;
        me meVar = this.I;
        if (meVar != null) {
            meVar.a();
            this.I = null;
        }
        WebView webView = this.f36800w;
        Map<Activity, Integer> map = lb.f34876a;
        new Handler(Looper.getMainLooper()).postAtTime((Runnable) null, webView, SystemClock.uptimeMillis() + 1000);
    }

    public void e() {
        z6 z6Var = this.C;
        if (z6Var != null) {
            z6Var.a();
        }
        WebView webView = this.f36800w;
        if (webView != null) {
            hc.a(webView);
        }
    }

    public void f() {
        boolean z2;
        Ad ad = this.f36714l;
        if (ad instanceof InterstitialAd) {
            z2 = ((InterstitialAd) ad).d();
        } else {
            z2 = false;
        }
        if (z2) {
            b();
            return;
        }
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.f36234q = true;
        if (this.C == null) {
            this.C = new z6(this.f36704b, this.f36711i, n(), m());
        }
        WebView webView = this.f36800w;
        if (webView == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f36704b);
            this.f36801x = relativeLayout;
            relativeLayout.setContentDescription("StartApp Ad");
            this.f36801x.setId(1475346432);
            this.f36704b.setContentView(this.f36801x);
            try {
                WebView b2 = ComponentLocator.a((Context) this.f36704b).u().b();
                this.f36800w = b2;
                b2.setBackgroundColor(-16777216);
                this.f36704b.getWindow().getDecorView().findViewById(16908290).setBackgroundColor(7829367);
                this.f36800w.setVerticalScrollBarEnabled(false);
                this.f36800w.setHorizontalScrollBarEnabled(false);
                this.f36800w.getSettings().setJavaScriptEnabled(true);
                this.f36800w.getSettings().setMediaPlaybackRequiresUserGesture(false);
                if (this.f36723u) {
                    hc.a(this.f36800w, (Paint) null);
                }
                this.f36800w.setOnLongClickListener(new c(this));
                this.f36800w.setLongClickable(false);
                this.f36800w.addJavascriptInterface(l(), "startappwall");
                q();
                b(this.f36800w);
                v();
                lb.a((Context) this.f36704b, this.f36800w, this.f36715m);
                this.G = "true".equals(lb.a(this.f36715m, "@jsTag@", "@jsTag@"));
                this.f36801x.addView(this.f36800w, new RelativeLayout.LayoutParams(-1, -1));
                RelativeLayout relativeLayout2 = this.f36801x;
                AdInformationObject adInformationObject = new AdInformationObject(this.f36704b, AdInformationObject.Size.LARGE, this.f36716n, this.f36717o, this.f36714l.getConsentData());
                this.f36705c = adInformationObject;
                adInformationObject.a(relativeLayout2);
            } catch (Throwable th) {
                y8.a((Context) this.f36704b, th);
                b();
            }
        } else {
            hc.b(webView);
            this.C.b();
        }
        this.B = SystemClock.uptimeMillis();
    }

    public void i() {
        String str;
        String[] strArr = this.f36707e;
        if (strArr != null && strArr.length > 0 && (str = strArr[0]) != null) {
            o6.a((Context) this.f36704b, str, o());
        }
    }

    public void j() {
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.f36704b);
            ImageButton imageButton = new ImageButton(this.f36704b);
            this.f36802y = imageButton;
            imageButton.setBackgroundColor(0);
            this.f36802y.setOnClickListener(this);
            int a2 = p.a((Context) this.f36704b, 50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams.addRule(13);
            relativeLayout.addView(this.f36802y, layoutParams);
            a(relativeLayout);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams2.addRule(10);
            layoutParams2.addRule(11);
            this.f36801x.addView(relativeLayout, layoutParams2);
        } catch (Throwable th) {
            y8.a((Context) this.f36704b, th);
        }
    }

    public long k() {
        return (SystemClock.uptimeMillis() - this.B) / 1000;
    }

    public td l() {
        Activity activity = this.f36704b;
        Runnable runnable = this.J;
        Runnable runnable2 = this.K;
        td tdVar = new td((Context) activity, runnable, o(), a(0));
        tdVar.f36585d = runnable;
        tdVar.f36586e = runnable2;
        return tdVar;
    }

    public long m() {
        Long l2 = this.f36719q;
        if (l2 != null) {
            return TimeUnit.SECONDS.toMillis(l2.longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.f36379h.n());
    }

    public TrackingParams n() {
        return new TrackingParams(this.f36718p);
    }

    public TrackingParams o() {
        return new CloseTrackingParams(k(), this.f36718p);
    }

    public void onClick(View view) {
    }

    public boolean p() {
        return false;
    }

    public void q() {
        this.C.b();
    }

    public void r() {
        a((View) this.f36802y);
    }

    public boolean s() {
        return this.H;
    }

    public void t() {
    }

    public void u() {
        if (p() && !this.E && this.F == 0) {
            this.E = true;
            wb.a((Context) this.f36704b).a(new Intent("com.startapp.android.OnVideoCompleted"));
            t();
        }
    }

    public void v() {
        this.f36800w.setWebViewClient(new g());
    }

    public void w() {
        try {
            if (this.f36802y != null) {
                this.f36802y.setImageDrawable(new BitmapDrawable(this.f36704b.getResources(), ma.a("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA39pVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDozODRkZTAxYi00OWRkLWM4NDYtYThkNC0wZWRiMDMwYTZlODAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkE0Q0U2MUY2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkE0Q0U2MUU2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjlkZjAyMGU0LTNlYmUtZTY0ZC04YjRiLWM5ZWY4MTU4ZjFhYyIgc3RSZWY6ZG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmU1MzEzNDdlLTZjMDEtMTFlNS1hZGZlLThmMTBjZWYxMGRiZSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PngNsEEAAANeSURBVHjatFfNS1tBEH+pUZOQ0B4i3sTSxHMRFNQoFBEP7dHgvyDiKWgguQra9F+oxqNiwOTQ+oFI1ZM3jSf1YK5FL41ooaKZzu+x+4gv2bx9Rgd+JNn5zO7s7IzH0CQiCvLHZ8YnxkfGe8ZbwS4zSowTxi/GT4/Hc2u8BLHjCOM745b06VboRJpx7GN8ZfyDxUqlQgcHB5RMJmloaIg6Ozupra3NBL5jDTzIQFYQdDOw5db5B8YxLDw+PtLKygr19PQQWDqIRqOUzWZNXUHH2rvBgr2M39C6uLig/v5+bcd2QLdUKskgYLNX57yvIL2zs0OhUOjZziU6Ojro8PBQBnGl3Alm+BknkMI54mybdS4BW3t7ezKIInzVCwDJYm4Zon4p5xLYzfPzcxlEpl7S3SNpmjlznZwQiXn/5CjEnTUzt5GBsbExamlpUfLBg0wjG8vLy3IXlqTzEAoH7m4kElEqTk1Nmfd7bW2tbhBYAw8ykFXZgQ9RJ1CsQghgEr/29/eVStPT09XFhdbX18nr9Vr81tZWyuVyFh+yMzMzSnvwJWjyDS+MYic2NzeV17O7u9vg2m79jsfjBv9bg7PbxOrqqjExMWHxIdvV1aW0V+VrFDtwhFCGh4cbnl0mk6kp+BsbGybsBNlGtkZGRqToEQK4xjfUc6csXlhYcHyFFhcXHe3Al6BrQz427e3tWldpfn5e6Rw83cIkHyvXAUAZb4SdsKZbPe0BaB+Bz+cjTiDlDmxtbZkybo9AKwn9fj9tb2875gBkINvIFnzJJMQ1PMV9GBgYUF6bQCBgFAoFY3x8/Ml6KpUy0un0kzXIQBY6KqrydapViPL5fM0/Rfcj+fhuJw5CqxBpleJYLEY3NzeW8dnZ2RoZrEmCLHQcSvGdWYrFe7CEFTwUqqjR85XLZUokEkoZ8CADWe3HqKoTcnyOdW5KI5m+vj56eHiQz3G0bkNyeXn5ag3J2dmZ/PffVC1Z8bVast3d3eqWLKDVlAaDwaadh8Nhvaa0XluOHg7n9lzn0MWRarfltp0oysEErRqGDTeDCbK9ajApuh7TxGiWERlrjWZzc3M0ODhYM5phDTzbaHb/rNHMFkhUNK13LobTv6K2RJ3se1yO519s4/k7wf5jG89/6I7n/wUYAGo3YtcprD4sAAAAAElFTkSuQmCC")));
                this.f36802y.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f36802y.setVisibility(0);
            }
        } catch (Throwable th) {
            y8.a((Context) this.f36704b, th);
        }
    }

    public void b() {
        this.f36704b.runOnUiThread(new v3.b());
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.f36234q = false;
        z6 z6Var = this.C;
        if (z6Var != null) {
            z6Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
        }
        this.f36704b.runOnUiThread(new f());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[SYNTHETIC, Splitter:B:11:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            com.startapp.z6 r0 = r5.C
            r1 = 0
            r0.a(r1, r1)
            com.startapp.sdk.adsbase.Ad r0 = r5.f36714l
            android.app.Activity r1 = r5.f36704b
            android.content.Context r1 = com.startapp.ia.a(r1)
            if (r1 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            android.app.Activity r1 = r5.f36704b
        L_0x0013:
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r2 = r5.f36716n
            boolean r1 = com.startapp.o6.a((android.content.Context) r1, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r2)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0025
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.startapp.lb.f34876a
            boolean r0 = r0 instanceof com.startapp.sdk.ads.splash.SplashAd
            if (r0 != 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            boolean r1 = r5.b((java.lang.String) r6)
            if (r1 == 0) goto L_0x0047
            int r1 = com.startapp.o6.a((java.lang.String) r6)     // Catch:{ all -> 0x0040 }
            boolean[] r4 = r5.f36708f     // Catch:{ all -> 0x0040 }
            boolean r4 = r4[r1]     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x003c
            if (r0 != 0) goto L_0x003c
            r5.b(r6, r1, r7)     // Catch:{ all -> 0x0040 }
            goto L_0x0056
        L_0x003c:
            r5.a(r6, r1, r7)     // Catch:{ all -> 0x0040 }
            goto L_0x0056
        L_0x0040:
            r6 = move-exception
            android.app.Activity r7 = r5.f36704b
            com.startapp.y8.a((android.content.Context) r7, (java.lang.Throwable) r6)
            return r3
        L_0x0047:
            boolean[] r1 = r5.f36708f
            boolean r1 = r1[r3]
            if (r1 == 0) goto L_0x0053
            if (r0 != 0) goto L_0x0053
            r5.b(r6, r3, r7)
            goto L_0x0056
        L_0x0053:
            r5.a(r6, r3, r7)
        L_0x0056:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.w3.a(java.lang.String, boolean):boolean");
    }

    public void b(WebView webView) {
        this.D = false;
        webView.setOnTouchListener(new d());
    }

    public void b(Bundle bundle) {
        String str = this.f36715m;
        if (str != null) {
            bundle.putString("postrollHtml", str);
        }
        Long l2 = this.f36803z;
        if (l2 != null) {
            bundle.putLong("lastLoadTime", l2.longValue());
        }
        Long l3 = this.A;
        if (l3 != null) {
            bundle.putLong("adCacheTtl", l3.longValue());
        }
        bundle.putBoolean("videoCompletedBroadcastSent", this.E);
        bundle.putInt("replayNum", this.F);
    }

    public boolean b(String str) {
        return !this.G && str.contains("index=");
    }

    public final void a(String str, int i2, boolean z2) {
        wb.a((Context) this.f36704b).a(new Intent("com.startapp.android.OnClickCallback"));
        Context a2 = ia.a(this.f36704b);
        if (a2 == null) {
            a2 = this.f36704b;
        }
        boolean a3 = o6.a(a2, this.f36716n);
        Activity activity = this.f36704b;
        String[] strArr = this.f36712j;
        boolean z3 = true;
        String[] strArr2 = i2 < strArr.length ? new String[]{strArr[i2]} : null;
        TrackingParams o2 = o();
        if (!a(i2) || a3) {
            z3 = false;
        }
        o6.a((Context) activity, str, strArr2, o2, z3, z2);
        b();
    }

    public void a(View view) {
        AdInformationView adInformationView;
        if (MetaData.f36379h.P()) {
            me meVar = new me(this.f36800w);
            this.I = meVar;
            if (meVar.c()) {
                try {
                    AdInformationObject adInformationObject = this.f36705c;
                    if (!(adInformationObject == null || (adInformationView = adInformationObject.f36263b) == null)) {
                        this.I.a(adInformationView, FriendlyObstructionPurpose.OTHER, (String) null);
                    }
                    if (view != null) {
                        this.I.a(view, FriendlyObstructionPurpose.CLOSE_AD, (String) null);
                    }
                } catch (RuntimeException e2) {
                    Log.e(f36799v, "OMSDK error", e2);
                }
                this.I.a(this.f36800w);
                this.I.e();
                this.I.d();
                this.I.b();
            }
        }
    }
}

package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.j9;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;
import com.vungle.ads.internal.Constants;
import java.util.Map;

public class x3 extends w3 {
    public MraidState L = MraidState.LOADING;
    public d M;
    public m9 N;
    public n9 O;
    public TextView P;
    public ImageView Q;
    public boolean R = false;
    public boolean S = false;
    public Handler T = null;

    public class a implements j9.a {
        public a() {
        }

        public boolean onClickEvent(String str) {
            return x3.this.a(str, true);
        }
    }

    public class b extends WebChromeClient {
        public b() {
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            try {
                if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR && consoleMessage.message().contains("mraid")) {
                    y8 y8Var = new y8(z8.f36996c);
                    y8Var.f36954d = "MraidMode.ConsoleError";
                    y8Var.f36955e = consoleMessage.message();
                    y8Var.a(x3.this.f36704b);
                }
            } catch (Throwable th) {
                y8.a((Context) x3.this.f36704b, th);
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }

    public class c extends l9 {
        public c(k9 k9Var) {
            super(k9Var);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (x3.this.L == MraidState.LOADING) {
                lb.a(webView, true, "mraid.setPlacementType", Constants.PLACEMENT_TYPE_INTERSTITIAL);
                x3 x3Var = x3.this;
                p.a((Context) x3Var.f36704b, webView, x3Var.N);
                x3.this.y();
                x3.this.j();
                x3 x3Var2 = x3.this;
                if (!x3Var2.R) {
                    x3Var2.w();
                }
                x3 x3Var3 = x3.this;
                MraidState mraidState = MraidState.DEFAULT;
                x3Var3.L = mraidState;
                p.a(mraidState, webView);
                lb.a(webView, true, "mraid.fireReadyEvent", new Object[0]);
                x3 x3Var4 = x3.this;
                if (x3Var4.S) {
                    x3Var4.M.fireViewableChangeEvent();
                }
                x3 x3Var5 = x3.this;
                Handler handler = x3Var5.T;
                if (handler != null) {
                    handler.post(new y3(x3Var5));
                }
                x3 x3Var6 = x3.this;
                x3Var6.a((View) x3Var6.f36802y);
            }
        }
    }

    public class d extends j9 {
        public d(j9.a aVar) {
            super(aVar);
        }

        public void close() {
            x3 x3Var = x3.this;
            MraidState mraidState = MraidState.HIDDEN;
            x3Var.L = mraidState;
            p.a(mraidState, x3Var.f36800w);
            x3.this.J.run();
        }

        public void fireViewableChangeEvent() {
            x3 x3Var = x3.this;
            lb.a(x3Var.f36800w, true, "mraid.fireViewableChangeEvent", Boolean.valueOf(x3Var.S));
        }

        public boolean isFeatureSupported(String str) {
            return x3.this.N.f34913b.contains(str);
        }

        public void setOrientationProperties(Map<String, String> map) {
            boolean parseBoolean = Boolean.parseBoolean(map.get("allowOrientationChange"));
            String str = map.get("forceOrientation");
            n9 n9Var = x3.this.O;
            if (n9Var.f34964b != parseBoolean || n9Var.f34965c != n9.a(str)) {
                n9 n9Var2 = x3.this.O;
                n9Var2.f34964b = parseBoolean;
                n9Var2.f34965c = n9.a(str);
                x3 x3Var = x3.this;
                applyOrientationProperties(x3Var.f36704b, x3Var.O);
            }
        }

        public void useCustomClose(String str) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            x3 x3Var = x3.this;
            if (x3Var.R != parseBoolean) {
                boolean unused = x3Var.R = parseBoolean;
                if (parseBoolean) {
                    x3 x3Var2 = x3.this;
                    x3Var2.getClass();
                    try {
                        ImageButton imageButton = x3Var2.f36802y;
                        if (imageButton != null) {
                            imageButton.setVisibility(4);
                        }
                    } catch (Throwable th) {
                        y8.a((Context) x3Var2.f36704b, th);
                    }
                } else {
                    x3.this.w();
                }
            }
        }
    }

    public boolean b(String str) {
        return false;
    }

    public boolean c() {
        if (!x()) {
            return true;
        }
        super.c();
        return false;
    }

    public void e() {
        this.S = false;
        if (this.L == MraidState.DEFAULT) {
            this.M.fireViewableChangeEvent();
        }
        super.e();
    }

    public void f() {
        super.f();
        if (this.T == null && p()) {
            this.T = new Handler();
        }
        this.S = true;
        if (this.L == MraidState.DEFAULT) {
            this.M.fireViewableChangeEvent();
        }
    }

    public long k() {
        return (SystemClock.uptimeMillis() - this.B) / 1000;
    }

    public void onClick(View view) {
        if (x()) {
            this.M.close();
        }
    }

    public boolean p() {
        return this.f36721s > 0;
    }

    public void v() {
        this.f36800w.setWebViewClient(new c(this.M));
        this.f36800w.setWebChromeClient(new b());
    }

    public final boolean x() {
        if ((SystemClock.uptimeMillis() - this.B) / 1000 >= ((long) this.f36721s)) {
            return true;
        }
        return false;
    }

    public void y() {
        Activity activity = this.f36704b;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            p.b(activity, i2, i3, this.f36800w);
            p.a((Context) activity, i2, i3, this.f36800w);
            p.a(activity, 0, 0, i2, i3, this.f36800w);
            p.b(activity, 0, 0, i2, i3, this.f36800w);
        } catch (Throwable th) {
            y8.a((Context) activity, th);
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.N == null) {
            this.N = new m9(this.f36704b);
        }
        if (this.O == null) {
            this.O = new n9(true, 2);
        }
        if (this.M == null) {
            this.M = new d(new a());
        }
    }

    public void a(Configuration configuration) {
        y();
    }

    public boolean a(String str, boolean z2) {
        MraidState mraidState = MraidState.HIDDEN;
        this.L = mraidState;
        p.a(mraidState, this.f36800w);
        try {
            return super.a(str, z2);
        } catch (Throwable th) {
            y8.a((Context) this.f36704b, th);
            return false;
        }
    }

    public void a(RelativeLayout relativeLayout) {
        if (p() && !this.f36722t) {
            int a2 = p.a((Context) this.f36704b, 32);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams.addRule(13);
            ImageView imageView = new ImageView(this.f36704b);
            this.Q = imageView;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setStroke(2, -1);
            int a3 = p.a((Context) this.f36704b, 32);
            gradientDrawable.setSize(a3, a3);
            imageView.setImageDrawable(gradientDrawable);
            this.Q.setScaleType(ImageView.ScaleType.FIT_CENTER);
            relativeLayout.addView(this.Q, layoutParams);
            TextView textView = new TextView(this.f36704b);
            this.P = textView;
            textView.setTextColor(-1);
            this.P.setGravity(17);
            relativeLayout.addView(this.P, layoutParams);
        }
    }
}

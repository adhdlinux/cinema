package com.startapp.sdk.ads.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.google.protobuf.CodedOutputStream;
import com.startapp.hc;
import com.startapp.m3;
import com.startapp.ob;
import com.startapp.p;
import com.startapp.q7;
import com.startapp.r7;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z6;
import java.util.Random;

public abstract class BannerBase extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35869a;

    /* renamed from: b  reason: collision with root package name */
    public AdPreferences f35870b;

    /* renamed from: c  reason: collision with root package name */
    public AdRulesResult f35871c;

    /* renamed from: d  reason: collision with root package name */
    public int f35872d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35873e;

    /* renamed from: f  reason: collision with root package name */
    public Point f35874f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35875g;

    /* renamed from: h  reason: collision with root package name */
    public int f35876h;

    /* renamed from: i  reason: collision with root package name */
    public int f35877i;

    /* renamed from: j  reason: collision with root package name */
    public String f35878j;

    /* renamed from: k  reason: collision with root package name */
    public ob f35879k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f35880l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f35881m;

    /* renamed from: n  reason: collision with root package name */
    public String f35882n;

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f35883o;

    /* renamed from: p  reason: collision with root package name */
    public final Handler f35884p;

    /* renamed from: q  reason: collision with root package name */
    public final Object f35885q;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            AdRulesResult adRulesResult;
            if (BannerBase.this.isShown() || ((adRulesResult = BannerBase.this.f35871c) != null && !adRulesResult.b())) {
                BannerBase.this.j();
            }
        }
    }

    public class b implements Handler.Callback {
        public b() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1 || i2 == 2) {
                BannerBase bannerBase = BannerBase.this;
                bannerBase.m();
                bannerBase.j();
            }
            return true;
        }
    }

    public BannerBase(Context context) {
        super(context);
        this.f35869a = false;
        this.f35872d = 0;
        this.f35873e = true;
        this.f35875g = false;
        int nextInt = new Random().nextInt(100000) + 159868227;
        this.f35876h = nextInt;
        this.f35877i = nextInt + 1;
        this.f35878j = null;
        this.f35880l = false;
        this.f35881m = false;
        this.f35883o = new a();
        this.f35884p = new Handler(Looper.getMainLooper(), new b());
        this.f35885q = new Object();
        try {
            ComponentLocator.a(context).q().a(512);
        } catch (Throwable unused) {
        }
    }

    public abstract void a(int i2);

    public void a(z6 z6Var) {
        if (this.f35879k == null) {
            ob obVar = new ob(g(), z6Var, BannerMetaData.f35889b.a());
            this.f35879k = obVar;
            if (obVar.b()) {
                obVar.run();
            }
        }
    }

    public void b() {
        if (!isInEditMode()) {
            removeCallbacks(this.f35883o);
            synchronized (this.f35885q) {
                this.f35884p.removeMessages(2);
            }
        }
    }

    public int c() {
        return f();
    }

    public abstract int d();

    public abstract String e();

    public abstract int f();

    public View g() {
        return this;
    }

    public abstract String getBidToken();

    public String getErrorMessage() {
        return this.f35882n;
    }

    @Keep
    public abstract int getHeightInDp();

    @Keep
    public abstract int getWidthInDp();

    public void h() {
        if (!isInEditMode()) {
            i();
            return;
        }
        setMinimumWidth(p.a(getContext(), getWidthInDp()));
        setMinimumHeight(p.a(getContext(), getHeightInDp()));
        setBackgroundColor(Color.rgb(169, 169, 169));
        TextView textView = new TextView(getContext());
        textView.setText(e());
        textView.setTextColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(textView, layoutParams);
    }

    public abstract void hideBanner();

    public abstract void i();

    public boolean isClicked() {
        return this.f35880l;
    }

    public boolean isFirstLoad() {
        return this.f35873e;
    }

    public void j() {
        ob obVar = this.f35879k;
        if (obVar != null) {
            obVar.a();
            this.f35879k = null;
        }
        if (this.f35871c == null || AdaptMetaData.f36307a.a().a()) {
            AdRulesResult a2 = AdaptMetaData.f36307a.a().a(AdPreferences.Placement.INAPP_BANNER, this.f35878j);
            this.f35871c = a2;
            if (a2.b()) {
                l();
            } else {
                hideBanner();
            }
        } else if (this.f35871c.b()) {
            l();
        }
    }

    public void k() {
        synchronized (this.f35885q) {
            if (!this.f35884p.hasMessages(1)) {
                this.f35884p.sendEmptyMessage(1);
            }
        }
    }

    public abstract void l();

    public void loadAd(int i2, int i3) {
        if (getParent() == null) {
            try {
                ComponentLocator.a(getContext()).q().a(1024);
            } catch (Throwable unused) {
            }
            this.f35874f = new Point(i2, i3);
            k();
        }
    }

    public void m() {
        if (this.f35869a && !isInEditMode()) {
            removeCallbacks(this.f35883o);
            postDelayed(this.f35883o, (long) c());
            long w2 = (long) (MetaData.f36379h.w() * 1000);
            synchronized (this.f35885q) {
                this.f35884p.removeMessages(2);
                this.f35884p.sendEmptyMessageDelayed(2, w2);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            ComponentLocator.a(getContext()).q().a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
        } catch (Throwable unused) {
        }
        this.f35869a = true;
        m();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f35869a = false;
        b();
        ob obVar = this.f35879k;
        if (obVar != null) {
            obVar.a();
            this.f35879k = null;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        a(bundle.getInt("bannerId"));
        this.f35871c = (AdRulesResult) bundle.getSerializable("adRulesResult");
        this.f35870b = (AdPreferences) bundle.getSerializable("adPreferences");
        this.f35872d = bundle.getInt("offset");
        this.f35873e = bundle.getBoolean("firstLoad");
        this.f35881m = bundle.getBoolean("shouldReloadBanner");
        super.onRestoreInstanceState(bundle.getParcelable("upperState"));
    }

    public Parcelable onSaveInstanceState() {
        if (isClicked()) {
            setClicked(false);
            this.f35881m = true;
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt("bannerId", d());
        bundle.putParcelable("upperState", onSaveInstanceState);
        bundle.putSerializable("adRulesResult", this.f35871c);
        bundle.putSerializable("adPreferences", this.f35870b);
        bundle.putInt("offset", this.f35872d);
        bundle.putBoolean("firstLoad", this.f35873e);
        bundle.putBoolean("shouldReloadBanner", this.f35881m);
        return bundle;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            if (this.f35881m) {
                this.f35881m = false;
                j();
            }
            this.f35869a = true;
            m();
            return;
        }
        this.f35869a = false;
        b();
    }

    public abstract void setAdTag(String str);

    public void setClicked(boolean z2) {
        this.f35880l = z2;
    }

    public void setErrorMessage(String str) {
        this.f35882n = str;
    }

    public void setFirstLoad(boolean z2) {
        this.f35873e = z2;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setAdTag(new m3(context, attributeSet).f34896b);
    }

    public void loadAd() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        loadAd(p.b(getContext(), displayMetrics.widthPixels), p.b(getContext(), displayMetrics.heightPixels));
    }

    public void a() {
        if (isFirstLoad() || AdaptMetaData.f36307a.a().a()) {
            setFirstLoad(false);
            r7.f35760a.a(new q7(AdPreferences.Placement.INAPP_BANNER, this.f35878j));
        }
    }

    public BannerBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(AdPreferences adPreferences) {
        boolean z2 = this.f35869a;
        int i2 = hc.f34643a;
        adPreferences.setHardwareAccelerated((1 != getLayerType() && z2) ? isHardwareAccelerated() : false);
    }

    public BannerBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35869a = false;
        this.f35872d = 0;
        this.f35873e = true;
        this.f35875g = false;
        int nextInt = new Random().nextInt(100000) + 159868227;
        this.f35876h = nextInt;
        this.f35877i = nextInt + 1;
        this.f35878j = null;
        this.f35880l = false;
        this.f35881m = false;
        this.f35883o = new a();
        this.f35884p = new Handler(Looper.getMainLooper(), new b());
        this.f35885q = new Object();
        a(context, attributeSet);
    }
}

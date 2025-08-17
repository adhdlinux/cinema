package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.b;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a  reason: collision with root package name */
    private b f13700a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a((AppLovinAdSize) null, (String) null, (AppLovinSdk) null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        a(appLovinAdSize, str, (AppLovinSdk) null, context, (AttributeSet) null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context.getApplicationContext());
        a(appLovinAdSize, str, appLovinSdk, context, (AttributeSet) null);
    }

    private void a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, displayMetrics.widthPixels, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
    }

    private void a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            b bVar = new b();
            this.f13700a = bVar;
            bVar.a(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
            return;
        }
        a(attributeSet, context);
    }

    public void destroy() {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public b getController() {
        return this.f13700a;
    }

    public AppLovinAdSize getSize() {
        b bVar = this.f13700a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public String getZoneId() {
        b bVar = this.f13700a;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public void loadNextAd() {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.a();
        } else {
            v.g("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.i();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.j();
        }
        super.onDetachedFromWindow();
    }

    public void pause() {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.a(appLovinAd);
        }
    }

    public void resume() {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.a(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.a(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.a(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        b bVar = this.f13700a;
        if (bVar != null) {
            bVar.a(appLovinAdViewEventListener);
        }
    }

    public String toString() {
        return "AppLovinAdView{zoneId='" + getZoneId() + "\", size=" + getSize() + '}';
    }
}

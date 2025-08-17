package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.b;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public class MaxAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private MaxAdViewImpl f15961a;

    /* renamed from: b  reason: collision with root package name */
    private View f15962b;

    /* renamed from: c  reason: collision with root package name */
    private int f15963c;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        String a2 = b.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String a3 = b.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adFormat");
        MaxAdFormat formatFromString = StringUtils.isValidString(a3) ? MaxAdFormat.formatFromString(a3) : b.a(context);
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (a2 == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (!TextUtils.isEmpty(a2)) {
            a(a2, formatFromString, attributeIntValue, AppLovinSdk.getInstance(context), context);
        } else {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
    }

    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context.getApplicationContext());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        a(str, maxAdFormat, 49, appLovinSdk, context);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, b.a(context), appLovinSdk, context);
    }

    private void a(MaxAdFormat maxAdFormat, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int applyDimension = maxAdFormat == MaxAdFormat.MREC ? (int) TypedValue.applyDimension(1, (float) maxAdFormat.getSize().getWidth(), displayMetrics) : displayMetrics.widthPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, applyDimension, (int) TypedValue.applyDimension(1, (float) maxAdFormat.getSize().getHeight(), displayMetrics));
    }

    private void a(String str, MaxAdFormat maxAdFormat, int i2, AppLovinSdk appLovinSdk, Context context) {
        if (!isInEditMode()) {
            View view = new View(context.getApplicationContext());
            this.f15962b = view;
            view.setBackgroundColor(0);
            addView(this.f15962b);
            this.f15962b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f15963c = getVisibility();
            this.f15961a = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.f15962b, appLovinSdk.coreSdk, context);
            setGravity(i2);
            if (getBackground() instanceof ColorDrawable) {
                setBackgroundColor(((ColorDrawable) getBackground()).getColor());
            }
            super.setBackgroundColor(0);
            return;
        }
        a(maxAdFormat, context);
    }

    public void destroy() {
        this.f15961a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f15961a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f15961a.getAdUnitId();
    }

    public String getPlacement() {
        return this.f15961a.getPlacement();
    }

    public void loadAd() {
        this.f15961a.loadAd();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("onWindowVisibilityChanged(visibility=" + i2 + ")");
        if (this.f15961a != null && q.a(this.f15963c, i2)) {
            this.f15961a.onWindowVisibilityChanged(i2);
        }
        this.f15963c = i2;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f15961a.setAdReviewListener(maxAdReviewListener);
    }

    public void setAlpha(float f2) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setAlpha(alpha=" + f2 + ")");
        View view = this.f15962b;
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public void setBackgroundColor(int i2) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setBackgroundColor(color=" + i2 + ")");
        MaxAdViewImpl maxAdViewImpl2 = this.f15961a;
        if (maxAdViewImpl2 != null) {
            maxAdViewImpl2.setPublisherBackgroundColor(i2);
        }
        View view = this.f15962b;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setCustomData(String str) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setCustomData(value=" + str + ")");
        this.f15961a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f15961a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f15961a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f15961a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f15961a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        maxAdViewImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f15961a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f15961a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f15961a.stopAutoRefresh();
    }

    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f15961a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }
}

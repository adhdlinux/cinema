package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinSdkUtils;

public class d extends a {
    public d(e eVar, Activity activity, m mVar) {
        super(eVar, activity, mVar);
    }

    public void a(ImageView imageView, com.applovin.impl.adview.m mVar, com.applovin.impl.adview.m mVar2, a aVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f13867d.addView(appLovinAdView);
        int i2 = 3;
        if (mVar != null) {
            a(this.f13866c.X(), (this.f13866c.ac() ? 3 : 5) | 48, mVar);
        }
        if (mVar2 != null) {
            if (!this.f13866c.ab()) {
                i2 = 5;
            }
            a(this.f13866c.X(), i2 | 48, mVar2);
        }
        if (imageView != null) {
            int dpToPx = AppLovinSdkUtils.dpToPx(this.f13865b, ((Integer) this.f13864a.a(b.cv)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) this.f13864a.a(b.cx)).intValue());
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.f13865b, ((Integer) this.f13864a.a(b.cw)).intValue());
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            this.f13867d.addView(imageView, layoutParams);
        }
        if (aVar != null) {
            this.f13867d.addView(aVar, this.f13868e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f13867d);
        } else {
            this.f13865b.setContentView(this.f13867d);
        }
    }
}

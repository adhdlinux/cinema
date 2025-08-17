package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;

public class b extends a {
    public b(e eVar, Activity activity, m mVar) {
        super(eVar, activity, mVar);
    }

    public void a(com.applovin.impl.adview.m mVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f13867d.addView(appLovinAdView);
        if (mVar != null) {
            a(this.f13866c.X(), (this.f13866c.ab() ? 3 : 5) | 48, mVar);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f13867d);
        } else {
            this.f13865b.setContentView(this.f13867d);
        }
    }
}

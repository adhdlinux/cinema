package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.ads.AdError;

public class t extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private String f19990a;

    /* renamed from: b  reason: collision with root package name */
    private Context f19991b;

    /* renamed from: c  reason: collision with root package name */
    private InterstitialAdapterListener f19992c;

    /* renamed from: d  reason: collision with root package name */
    private InterstitialAdapter f19993d;

    public t(Context context, String str, InterstitialAdapter interstitialAdapter, InterstitialAdapterListener interstitialAdapterListener) {
        this.f19991b = context;
        this.f19990a = str;
        this.f19992c = interstitialAdapterListener;
        this.f19993d = interstitialAdapter;
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f19990a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f19990a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f19990a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f19990a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f19990a);
        intentFilter.addAction("com.facebook.ads.interstitial.activity_destroyed:" + this.f19990a);
        LocalBroadcastManager.b(this.f19991b).c(this, intentFilter);
    }

    public void b() {
        try {
            LocalBroadcastManager.b(this.f19991b).e(this);
        } catch (Exception unused) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        String str = intent.getAction().split(":")[0];
        if (this.f19992c != null && str != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(str)) {
                this.f19992c.onInterstitialAdClicked(this.f19993d, (String) null, true);
            } else if ("com.facebook.ads.interstitial.dismissed".equals(str)) {
                this.f19992c.onInterstitialAdDismissed(this.f19993d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(str)) {
                this.f19992c.onInterstitialAdDisplayed(this.f19993d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(str)) {
                this.f19992c.onInterstitialLoggingImpression(this.f19993d);
            } else if ("com.facebook.ads.interstitial.error".equals(str)) {
                this.f19992c.onInterstitialError(this.f19993d, AdError.INTERNAL_ERROR);
            } else if ("com.facebook.ads.interstitial.activity_destroyed".equals(str)) {
                this.f19992c.onInterstitialActivityDestroyed();
            }
        }
    }
}

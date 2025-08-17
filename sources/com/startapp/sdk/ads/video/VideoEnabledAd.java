package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.e5;
import com.startapp.g6;
import com.startapp.h0;
import com.startapp.lb;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class VideoEnabledAd extends InterstitialAd {
    private static final long serialVersionUID = 1;
    private VideoAdDetails videoAdDetails = null;

    public VideoEnabledAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new e5(this.f36173b, this, adPreferences, adEventListener, this.placement).c();
    }

    public void c(String str) {
        super.c(str);
        String a2 = lb.a(str, "@videoJson@", "@videoJson@");
        if (a2 != null) {
            VideoAdDetails videoAdDetails2 = (VideoAdDetails) h0.a(a2, VideoAdDetails.class);
            this.videoAdDetails = videoAdDetails2;
            if (videoAdDetails2 != null) {
                videoAdDetails2.o();
            }
        }
    }

    public boolean u() {
        return this.videoAdDetails != null;
    }

    public void v() {
        this.videoAdDetails = null;
    }

    public VideoAdDetails w() {
        return this.videoAdDetails;
    }

    public void a(g6 g6Var, VideoConfig videoConfig, boolean z2) {
        this.videoAdDetails = new VideoAdDetails(g6Var, videoConfig, z2);
        Integer num = g6Var.f34575q;
        if (num != null && g6Var.f34576r != null) {
            if (num.intValue() > g6Var.f34576r.intValue()) {
                a(SplashConfig.Orientation.LANDSCAPE);
            } else {
                a(SplashConfig.Orientation.PORTRAIT);
            }
        }
    }
}

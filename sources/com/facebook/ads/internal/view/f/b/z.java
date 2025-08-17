package com.facebook.ads.internal.view.f.b;

public enum z {
    REWARDED_VIDEO_COMPLETE("com.facebook.ads.rewarded_video.completed"),
    REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD("com.facebook.ads.rewarded_video.completed.without.reward"),
    REWARDED_VIDEO_END_ACTIVITY("com.facebook.ads.rewarded_video.end_activity"),
    REWARDED_VIDEO_ERROR("com.facebook.ads.rewarded_video.error"),
    REWARDED_VIDEO_AD_CLICK("com.facebook.ads.rewarded_video.ad_click"),
    REWARDED_VIDEO_IMPRESSION("com.facebook.ads.rewarded_video.ad_impression"),
    REWARDED_VIDEO_CLOSED("com.facebook.ads.rewarded_video.closed"),
    REWARD_SERVER_SUCCESS("com.facebook.ads.rewarded_video.server_reward_success"),
    REWARD_SERVER_FAILED("com.facebook.ads.rewarded_video.server_reward_failed"),
    REWARDED_VIDEO_ACTIVITY_DESTROYED("com.facebook.ads.rewarded_video.activity_destroyed");
    

    /* renamed from: k  reason: collision with root package name */
    private String f21311k;

    private z(String str) {
        this.f21311k = str;
    }

    public String a() {
        return this.f21311k;
    }

    public String a(String str) {
        return this.f21311k + ":" + str;
    }
}

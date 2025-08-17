package com.startapp.sdk.ads.video.tracking;

import com.startapp.sdk.adsbase.commontracking.TrackingParams;

public class VideoTrackingParams extends TrackingParams {
    private static final long serialVersionUID = 1;
    private int completed;
    public boolean internalParamsIndicator;
    private String replayParameter;
    private boolean shouldAppendOffset;
    private String videoPlayingMode;

    public VideoTrackingParams(String str, int i2, int i3, String str2) {
        super(str);
        a(i3);
        this.completed = i2;
        this.videoPlayingMode = str2;
    }

    public VideoTrackingParams a(boolean z2) {
        this.shouldAppendOffset = z2;
        return this;
    }

    public String b(String str) {
        if (!this.internalParamsIndicator) {
            return c();
        }
        return super.e() + str;
    }

    public VideoTrackingParams c(String str) {
        this.replayParameter = str;
        return this;
    }

    public String e() {
        return b(f() + g());
    }

    public String f() {
        return "&cp=" + this.completed;
    }

    public String g() {
        return "&vpm=" + this.videoPlayingMode;
    }

    public String c() {
        if (!this.shouldAppendOffset) {
            return "";
        }
        String str = this.replayParameter;
        if (str != null) {
            return str.replace("%startapp_replay_count%", new Integer(b()).toString());
        }
        return super.c();
    }
}

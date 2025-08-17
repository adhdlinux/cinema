package com.startapp.sdk.adsbase.commontracking;

public class CloseTrackingParams extends TrackingParams {
    private static final long serialVersionUID = 1;
    private final long duration;

    public CloseTrackingParams(long j2, String str) {
        super(str);
        this.duration = j2;
    }

    public String e() {
        return super.e() + "&displayDuration=" + Math.max(0, this.duration);
    }
}

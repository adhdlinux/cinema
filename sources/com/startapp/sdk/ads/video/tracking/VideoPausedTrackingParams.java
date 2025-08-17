package com.startapp.sdk.ads.video.tracking;

public class VideoPausedTrackingParams extends VideoTrackingParams {
    private static final long serialVersionUID = 1;
    private int pauseNum;
    private PauseOrigin pauseOrigin;

    public enum PauseOrigin {
        INAPP,
        EXTERNAL
    }

    public VideoPausedTrackingParams(String str, int i2, int i3, int i4, PauseOrigin pauseOrigin2, String str2) {
        super(str, i2, i3, str2);
        this.pauseNum = i4;
        this.pauseOrigin = pauseOrigin2;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        sb.append("&po=" + this.pauseOrigin.toString());
        sb.append("&pn=" + this.pauseNum);
        sb.append(g());
        return b(sb.toString());
    }
}

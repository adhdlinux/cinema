package com.startapp.sdk.ads.video.tracking;

public class VideoClickedTrackingParams extends VideoTrackingParams {
    private static final long serialVersionUID = 940417627850369979L;
    private boolean isVideoFinished;

    public VideoClickedTrackingParams(String str, int i2, int i3, boolean z2, String str2) {
        super(str, i2, i3, str2);
        this.isVideoFinished = z2;
    }

    public String e() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("&co=");
        if (this.isVideoFinished) {
            str = "POSTROLL";
        } else {
            str = "VIDEO";
        }
        sb2.append(str);
        sb.append(sb2.toString());
        sb.append(g());
        return b(sb.toString());
    }
}

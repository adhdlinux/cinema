package com.startapp.sdk.ads.video;

import com.startapp.f6;
import com.startapp.g6;
import com.startapp.j0;
import com.startapp.sdk.ads.video.tracking.VideoTrackingDetails;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.omsdk.AdVerification;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class VideoAdDetails implements Serializable {
    private static final long serialVersionUID = 7139790917892812511L;
    @j0(type = VerificationDetails.class)
    private VerificationDetails[] adVerifications;
    private String clickUrl;
    private boolean clickable;
    private boolean closeable;
    private boolean isVideoMuted;
    private String localVideoPath;
    @j0(type = PostRollType.class)
    private PostRollType postRoll;
    private String postRollClickThroughUrl;
    private String postRollHtml;
    private boolean skippable;
    private long skippableAfter;
    @j0(complex = true)
    private VideoTrackingDetails videoTrackingDetails;
    private String videoUrl;

    public enum PostRollType {
        IMAGE,
        LAST_FRAME,
        NONE
    }

    public VideoAdDetails() {
    }

    public void a(String str) {
        this.localVideoPath = str;
    }

    public String b() {
        return this.clickUrl;
    }

    public String c() {
        return this.localVideoPath;
    }

    public String d() {
        return this.postRollHtml != null ? this.postRollClickThroughUrl : this.clickUrl;
    }

    public String e() {
        return this.postRollHtml;
    }

    public PostRollType f() {
        return this.postRoll;
    }

    public long g() {
        return this.skippableAfter;
    }

    public VideoTrackingDetails h() {
        return this.videoTrackingDetails;
    }

    public String i() {
        return this.videoUrl;
    }

    public boolean j() {
        return (this.postRoll == PostRollType.NONE && this.postRollHtml == null) ? false : true;
    }

    public boolean k() {
        return this.clickable;
    }

    public boolean l() {
        return this.closeable;
    }

    public boolean m() {
        return this.skippable;
    }

    public boolean n() {
        return this.isVideoMuted;
    }

    public void o() {
        this.skippableAfter = TimeUnit.SECONDS.toMillis(this.skippableAfter);
    }

    public String toString() {
        return super.toString();
    }

    public VideoAdDetails(g6 g6Var, VideoConfig videoConfig, boolean z2) {
        this.videoTrackingDetails = new VideoTrackingDetails(g6Var);
        this.videoUrl = g6Var.k();
        Integer o2 = g6Var.o();
        boolean z3 = true;
        if (z2) {
            this.skippableAfter = o2 != null ? (long) o2.intValue() : videoConfig.m();
            this.skippable = true;
        } else {
            this.skippable = false;
        }
        String c2 = g6Var.c();
        this.clickUrl = c2;
        this.clickable = c2 == null ? false : z3;
        this.postRoll = PostRollType.NONE;
        f6 f2 = g6Var.f();
        if (f2 != null) {
            this.postRollHtml = f2.c().a();
            this.postRollClickThroughUrl = f2.a();
        }
        a(new AdVerification((VerificationDetails[]) g6Var.b().toArray(new VerificationDetails[0])));
    }

    public void a(boolean z2) {
        this.isVideoMuted = z2;
    }

    public AdVerification a() {
        return new AdVerification(this.adVerifications);
    }

    public void a(AdVerification adVerification) {
        if (adVerification.a() != null) {
            this.adVerifications = (VerificationDetails[]) adVerification.a().toArray(new VerificationDetails[0]);
        }
    }
}

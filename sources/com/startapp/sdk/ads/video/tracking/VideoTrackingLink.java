package com.startapp.sdk.ads.video.tracking;

import com.startapp.j0;
import java.io.Serializable;

public abstract class VideoTrackingLink implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean appendReplayParameter;
    private String replayParameter;
    @j0(type = TrackingSource.class)
    private TrackingSource trackingSource;
    private String trackingUrl;

    public enum TrackingSource {
        STARTAPP,
        EXTERNAL
    }

    public void a(boolean z2) {
        this.appendReplayParameter = z2;
    }

    public void b(String str) {
        this.trackingUrl = str;
    }

    public String c() {
        return this.trackingUrl;
    }

    public boolean d() {
        return this.appendReplayParameter;
    }

    public String toString() {
        return "trackingSource=" + this.trackingSource + ", trackingUrl=" + this.trackingUrl + ", replayParameter=" + this.replayParameter + ", appendReplayParameter=" + this.appendReplayParameter;
    }

    public String a() {
        return this.replayParameter;
    }

    public TrackingSource b() {
        return this.trackingSource;
    }

    public void a(String str) {
        this.replayParameter = str;
    }
}

package com.iab.omid.library.applovin.adsession.media;

import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.a;
import com.iab.omid.library.applovin.b.f;
import com.iab.omid.library.applovin.d.b;
import com.iab.omid.library.applovin.d.e;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import org.json.JSONObject;

public final class MediaEvents {
    private final a adSession;

    private MediaEvents(a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession2) {
        a aVar = (a) adSession2;
        e.a((Object) adSession2, "AdSession is null");
        e.g(aVar);
        e.a(aVar);
        e.b(aVar);
        e.e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        e.a((Object) interactionType, "InteractionType is null");
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferFinish");
    }

    public void bufferStart() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferStart");
    }

    public void complete() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("complete");
    }

    public void firstQuartile() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("firstQuartile");
    }

    public void midpoint() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("midpoint");
    }

    public void pause() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        e.a((Object) playerState, "PlayerState is null");
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, AdOperationMetric.INIT_STATE, playerState);
        this.adSession.getAdSessionStatePublisher().a("playerStateChange", jSONObject);
    }

    public void resume() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("resume");
    }

    public void skipped() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("skipped");
    }

    public void start(float f2, float f3) {
        confirmValidDuration(f2);
        confirmValidVolume(f3);
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "duration", Float.valueOf(f2));
        b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f3));
        b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().d()));
        this.adSession.getAdSessionStatePublisher().a(ViewProps.START, jSONObject);
    }

    public void thirdQuartile() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("thirdQuartile");
    }

    public void volumeChange(float f2) {
        confirmValidVolume(f2);
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().d()));
        this.adSession.getAdSessionStatePublisher().a("volumeChange", jSONObject);
    }
}

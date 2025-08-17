package com.iab.omid.library.adcolony.adsession.media;

import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.a;
import com.iab.omid.library.adcolony.b.f;
import com.iab.omid.library.adcolony.d.b;
import com.iab.omid.library.adcolony.d.e;
import org.json.JSONObject;

public final class MediaEvents {

    /* renamed from: a  reason: collision with root package name */
    private final a f31357a;

    private MediaEvents(a aVar) {
        this.f31357a = aVar;
    }

    private void e(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void f(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents g(AdSession adSession) {
        a aVar = (a) adSession;
        e.d(adSession, "AdSession is null");
        e.l(aVar);
        e.c(aVar);
        e.g(aVar);
        e.j(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.v().i(mediaEvents);
        return mediaEvents;
    }

    public void a(InteractionType interactionType) {
        e.d(interactionType, "InteractionType is null");
        e.h(this.f31357a);
        JSONObject jSONObject = new JSONObject();
        b.h(jSONObject, "interactionType", interactionType);
        this.f31357a.v().l("adUserInteraction", jSONObject);
    }

    public void b() {
        e.h(this.f31357a);
        this.f31357a.v().j("bufferFinish");
    }

    public void c() {
        e.h(this.f31357a);
        this.f31357a.v().j("bufferStart");
    }

    public void d() {
        e.h(this.f31357a);
        this.f31357a.v().j("complete");
    }

    public void h() {
        e.h(this.f31357a);
        this.f31357a.v().j("firstQuartile");
    }

    public void i() {
        e.h(this.f31357a);
        this.f31357a.v().j("midpoint");
    }

    public void j() {
        e.h(this.f31357a);
        this.f31357a.v().j("pause");
    }

    public void k() {
        e.h(this.f31357a);
        this.f31357a.v().j("resume");
    }

    public void l() {
        e.h(this.f31357a);
        this.f31357a.v().j("skipped");
    }

    public void m(float f2, float f3) {
        e(f2);
        f(f3);
        e.h(this.f31357a);
        JSONObject jSONObject = new JSONObject();
        b.h(jSONObject, "duration", Float.valueOf(f2));
        b.h(jSONObject, "mediaPlayerVolume", Float.valueOf(f3));
        b.h(jSONObject, "deviceVolume", Float.valueOf(f.a().e()));
        this.f31357a.v().l(ViewProps.START, jSONObject);
    }

    public void n() {
        e.h(this.f31357a);
        this.f31357a.v().j("thirdQuartile");
    }

    public void o(float f2) {
        f(f2);
        e.h(this.f31357a);
        JSONObject jSONObject = new JSONObject();
        b.h(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        b.h(jSONObject, "deviceVolume", Float.valueOf(f.a().e()));
        this.f31357a.v().l("volumeChange", jSONObject);
    }
}

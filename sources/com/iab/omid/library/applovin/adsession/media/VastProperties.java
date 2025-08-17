package com.iab.omid.library.applovin.adsession.media;

import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.applovin.d.c;
import com.iab.omid.library.applovin.d.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31481a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f31482b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31483c;

    /* renamed from: d  reason: collision with root package name */
    private final Position f31484d;

    private VastProperties(boolean z2, Float f2, boolean z3, Position position) {
        this.f31481a = z2;
        this.f31482b = f2;
        this.f31483c = z3;
        this.f31484d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z2, Position position) {
        e.a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z2, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f2, boolean z2, Position position) {
        e.a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f2), z2, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f31481a);
            if (this.f31481a) {
                jSONObject.put("skipOffset", this.f31482b);
            }
            jSONObject.put("autoPlay", this.f31483c);
            jSONObject.put(ViewProps.POSITION, this.f31484d);
        } catch (JSONException e2) {
            c.a("VastProperties: JSON error", e2);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f31484d;
    }

    public Float getSkipOffset() {
        return this.f31482b;
    }

    public boolean isAutoPlay() {
        return this.f31483c;
    }

    public boolean isSkippable() {
        return this.f31481a;
    }
}

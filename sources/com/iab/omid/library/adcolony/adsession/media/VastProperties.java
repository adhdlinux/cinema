package com.iab.omid.library.adcolony.adsession.media;

import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.adcolony.d.c;
import com.iab.omid.library.adcolony.d.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31364a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f31365b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31366c;

    /* renamed from: d  reason: collision with root package name */
    private final Position f31367d;

    private VastProperties(boolean z2, Float f2, boolean z3, Position position) {
        this.f31364a = z2;
        this.f31365b = f2;
        this.f31366c = z3;
        this.f31367d = position;
    }

    public static VastProperties b(boolean z2, Position position) {
        e.d(position, "Position is null");
        return new VastProperties(false, (Float) null, z2, position);
    }

    public static VastProperties c(float f2, boolean z2, Position position) {
        e.d(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f2), z2, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f31364a);
            if (this.f31364a) {
                jSONObject.put("skipOffset", this.f31365b);
            }
            jSONObject.put("autoPlay", this.f31366c);
            jSONObject.put(ViewProps.POSITION, this.f31367d);
        } catch (JSONException e2) {
            c.b("VastProperties: JSON error", e2);
        }
        return jSONObject;
    }
}

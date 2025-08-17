package com.iab.omid.library.vungle.adsession;

import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.g;
import org.json.JSONObject;

public class AdSessionConfiguration {

    /* renamed from: a  reason: collision with root package name */
    private final Owner f31624a;

    /* renamed from: b  reason: collision with root package name */
    private final Owner f31625b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31626c;

    /* renamed from: d  reason: collision with root package name */
    private final CreativeType f31627d;

    /* renamed from: e  reason: collision with root package name */
    private final ImpressionType f31628e;

    private AdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z2) {
        this.f31627d = creativeType;
        this.f31628e = impressionType;
        this.f31624a = owner;
        if (owner2 == null) {
            this.f31625b = Owner.NONE;
        } else {
            this.f31625b = owner2;
        }
        this.f31626c = z2;
    }

    public static AdSessionConfiguration a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z2) {
        g.c(creativeType, "CreativeType is null");
        g.c(impressionType, "ImpressionType is null");
        g.c(owner, "Impression owner is null");
        g.b(owner, creativeType, impressionType);
        return new AdSessionConfiguration(creativeType, impressionType, owner, owner2, z2);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, "impressionOwner", this.f31624a);
        c.i(jSONObject, "mediaEventsOwner", this.f31625b);
        c.i(jSONObject, "creativeType", this.f31627d);
        c.i(jSONObject, "impressionType", this.f31628e);
        c.i(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f31626c));
        return jSONObject;
    }
}

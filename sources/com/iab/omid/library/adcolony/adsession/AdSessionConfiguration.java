package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.d.b;
import com.iab.omid.library.adcolony.d.e;
import org.json.JSONObject;

public class AdSessionConfiguration {

    /* renamed from: a  reason: collision with root package name */
    private final Owner f31288a;

    /* renamed from: b  reason: collision with root package name */
    private final Owner f31289b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31290c;

    /* renamed from: d  reason: collision with root package name */
    private final CreativeType f31291d;

    /* renamed from: e  reason: collision with root package name */
    private final ImpressionType f31292e;

    private AdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z2) {
        this.f31291d = creativeType;
        this.f31292e = impressionType;
        this.f31288a = owner;
        if (owner2 == null) {
            this.f31289b = Owner.NONE;
        } else {
            this.f31289b = owner2;
        }
        this.f31290c = z2;
    }

    public static AdSessionConfiguration a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z2) {
        e.d(creativeType, "CreativeType is null");
        e.d(impressionType, "ImpressionType is null");
        e.d(owner, "Impression owner is null");
        e.b(owner, creativeType, impressionType);
        return new AdSessionConfiguration(creativeType, impressionType, owner, owner2, z2);
    }

    public boolean b() {
        return Owner.NATIVE == this.f31288a;
    }

    public boolean c() {
        return Owner.NATIVE == this.f31289b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.h(jSONObject, "impressionOwner", this.f31288a);
        b.h(jSONObject, "mediaEventsOwner", this.f31289b);
        b.h(jSONObject, "creativeType", this.f31291d);
        b.h(jSONObject, "impressionType", this.f31292e);
        b.h(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f31290c));
        return jSONObject;
    }
}

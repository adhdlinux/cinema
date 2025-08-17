package com.startapp;

import com.iab.omid.library.startio.adsession.CreativeType;
import com.iab.omid.library.startio.adsession.ImpressionType;
import com.iab.omid.library.startio.adsession.Owner;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final Owner f36536a;

    /* renamed from: b  reason: collision with root package name */
    public final Owner f36537b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36538c;

    /* renamed from: d  reason: collision with root package name */
    public final CreativeType f36539d;

    /* renamed from: e  reason: collision with root package name */
    public final ImpressionType f36540e;

    public t(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z2) {
        this.f36539d = creativeType;
        this.f36540e = impressionType;
        this.f36536a = owner;
        if (owner2 == null) {
            this.f36537b = Owner.NONE;
        } else {
            this.f36537b = owner2;
        }
        this.f36538c = z2;
    }
}

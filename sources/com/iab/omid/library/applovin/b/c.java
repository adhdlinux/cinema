package com.iab.omid.library.applovin.b;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.applovin.e.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f31493a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31494b;

    /* renamed from: c  reason: collision with root package name */
    private final FriendlyObstructionPurpose f31495c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31496d;

    public c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f31493a = new a(view);
        this.f31494b = view.getClass().getCanonicalName();
        this.f31495c = friendlyObstructionPurpose;
        this.f31496d = str;
    }

    public a a() {
        return this.f31493a;
    }

    public String b() {
        return this.f31494b;
    }

    public FriendlyObstructionPurpose c() {
        return this.f31495c;
    }

    public String d() {
        return this.f31496d;
    }
}

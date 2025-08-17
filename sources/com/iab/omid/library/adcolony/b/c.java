package com.iab.omid.library.adcolony.b;

import android.view.View;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.adcolony.e.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f31376a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31377b;

    /* renamed from: c  reason: collision with root package name */
    private final FriendlyObstructionPurpose f31378c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31379d;

    public c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f31376a = new a(view);
        this.f31377b = view.getClass().getCanonicalName();
        this.f31378c = friendlyObstructionPurpose;
        this.f31379d = str;
    }

    public a a() {
        return this.f31376a;
    }

    public String b() {
        return this.f31377b;
    }

    public FriendlyObstructionPurpose c() {
        return this.f31378c;
    }

    public String d() {
        return this.f31379d;
    }
}

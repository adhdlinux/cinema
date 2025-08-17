package com.unity3d.scar.adapter.v2100.requests;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.unity3d.scar.adapter.common.requests.RequestExtras;

public class AdRequestFactory {

    /* renamed from: a  reason: collision with root package name */
    private RequestExtras f37174a;

    public AdRequestFactory(RequestExtras requestExtras) {
        this.f37174a = requestExtras;
    }

    public AdRequest a() {
        return c().build();
    }

    public AdRequest b(String str) {
        return c().setAdString(str).build();
    }

    public AdRequest.Builder c() {
        return new AdRequest.Builder().setRequestAgent(this.f37174a.b()).addNetworkExtrasBundle(AdMobAdapter.class, this.f37174a.a());
    }
}

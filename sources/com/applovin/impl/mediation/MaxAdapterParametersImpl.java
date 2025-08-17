package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.mediation.a.h;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {

    /* renamed from: a  reason: collision with root package name */
    private String f14164a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f14165b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f14166c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f14167d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f14168e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f14169f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f14170g;

    /* renamed from: h  reason: collision with root package name */
    private String f14171h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14172i;

    /* renamed from: j  reason: collision with root package name */
    private String f14173j;

    /* renamed from: k  reason: collision with root package name */
    private String f14174k;

    /* renamed from: l  reason: collision with root package name */
    private long f14175l;

    /* renamed from: m  reason: collision with root package name */
    private MaxAdFormat f14176m;

    private MaxAdapterParametersImpl() {
    }

    static MaxAdapterParametersImpl a(a aVar) {
        MaxAdapterParametersImpl a2 = a((f) aVar);
        a2.f14173j = aVar.l();
        a2.f14174k = aVar.i();
        a2.f14175l = aVar.j();
        return a2;
    }

    static MaxAdapterParametersImpl a(f fVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f14164a = fVar.getAdUnitId();
        maxAdapterParametersImpl.f14168e = fVar.O();
        maxAdapterParametersImpl.f14169f = fVar.P();
        maxAdapterParametersImpl.f14170g = fVar.Q();
        maxAdapterParametersImpl.f14171h = fVar.R();
        maxAdapterParametersImpl.f14165b = fVar.T();
        maxAdapterParametersImpl.f14166c = fVar.U();
        maxAdapterParametersImpl.f14167d = fVar.V();
        maxAdapterParametersImpl.f14172i = fVar.N();
        return maxAdapterParametersImpl;
    }

    static MaxAdapterParametersImpl a(h hVar, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl a2 = a((f) hVar);
        a2.f14176m = maxAdFormat;
        return a2;
    }

    public MaxAdFormat getAdFormat() {
        return this.f14176m;
    }

    public String getAdUnitId() {
        return this.f14164a;
    }

    public long getBidExpirationMillis() {
        return this.f14175l;
    }

    public String getBidResponse() {
        return this.f14174k;
    }

    public String getConsentString() {
        return this.f14171h;
    }

    public Bundle getCustomParameters() {
        return this.f14167d;
    }

    public Map<String, Object> getLocalExtraParameters() {
        return this.f14165b;
    }

    public Bundle getServerParameters() {
        return this.f14166c;
    }

    public String getThirdPartyAdPlacementId() {
        return this.f14173j;
    }

    public Boolean hasUserConsent() {
        return this.f14168e;
    }

    public Boolean isAgeRestrictedUser() {
        return this.f14169f;
    }

    public Boolean isDoNotSell() {
        return this.f14170g;
    }

    public boolean isTesting() {
        return this.f14172i;
    }
}

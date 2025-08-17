package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;

public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {

    /* renamed from: a  reason: collision with root package name */
    private final a f14159a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14160b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14161c;

    /* renamed from: d  reason: collision with root package name */
    private final List<MaxNetworkResponseInfo> f14162d;

    /* renamed from: e  reason: collision with root package name */
    private final long f14163e;

    public MaxAdWaterfallInfoImpl(a aVar, long j2, List<MaxNetworkResponseInfo> list) {
        this(aVar, aVar.m(), aVar.n(), j2, list);
    }

    public MaxAdWaterfallInfoImpl(a aVar, String str, String str2, long j2, List<MaxNetworkResponseInfo> list) {
        this.f14159a = aVar;
        this.f14160b = str;
        this.f14161c = str2;
        this.f14162d = list;
        this.f14163e = j2;
    }

    public long getLatencyMillis() {
        return this.f14163e;
    }

    public MaxAd getLoadedAd() {
        return this.f14159a;
    }

    public String getName() {
        return this.f14160b;
    }

    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.f14162d;
    }

    public String getTestName() {
        return this.f14161c;
    }

    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.f14160b + ", testName=" + this.f14161c + ", networkResponses=" + this.f14162d + ", latencyMillis=" + this.f14163e + '}';
    }
}

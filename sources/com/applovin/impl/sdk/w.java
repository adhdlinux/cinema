package com.applovin.impl.sdk;

import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.a.f;
import java.util.HashMap;
import java.util.Map;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private final m f15935a;

    /* renamed from: b  reason: collision with root package name */
    private final v f15936b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, a> f15937c = new HashMap(4);

    /* renamed from: d  reason: collision with root package name */
    private final Object f15938d = new Object();

    w(m mVar) {
        this.f15935a = mVar;
        this.f15936b = mVar.A();
    }

    public a a(String str) {
        a aVar;
        synchronized (this.f15938d) {
            aVar = this.f15937c.get(str);
        }
        return aVar;
    }

    public void a(a aVar) {
        synchronized (this.f15938d) {
            if (v.a()) {
                v vVar = this.f15936b;
                vVar.b("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            }
            this.f15937c.put(aVar.getAdUnitId(), aVar);
        }
    }

    public void b(a aVar) {
        synchronized (this.f15938d) {
            String adUnitId = aVar.getAdUnitId();
            f fVar = this.f15937c.get(adUnitId);
            if (aVar == fVar) {
                if (v.a()) {
                    v vVar = this.f15936b;
                    vVar.b("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + fVar);
                }
                this.f15937c.remove(adUnitId);
            } else if (v.a()) {
                v vVar2 = this.f15936b;
                vVar2.b("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + aVar + " , since it could have already been updated with a new ad: " + fVar);
            }
        }
    }
}

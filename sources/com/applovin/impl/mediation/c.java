package com.applovin.impl.mediation;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.e;
import com.applovin.impl.sdk.v;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final m f14367a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final v f14368b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f14369c;

    /* renamed from: d  reason: collision with root package name */
    private e f14370d;

    public interface a {
        void c(com.applovin.impl.mediation.a.c cVar);
    }

    c(m mVar, a aVar) {
        this.f14367a = mVar;
        this.f14368b = mVar.A();
        this.f14369c = aVar;
    }

    public void a() {
        if (v.a()) {
            this.f14368b.b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        e eVar = this.f14370d;
        if (eVar != null) {
            eVar.a();
            this.f14370d = null;
        }
    }

    public void a(final com.applovin.impl.mediation.a.c cVar, long j2) {
        if (v.a()) {
            v vVar = this.f14368b;
            vVar.b("AdHiddenCallbackTimeoutManager", "Scheduling in " + j2 + "ms...");
        }
        this.f14370d = e.a(j2, this.f14367a, new Runnable() {
            public void run() {
                if (v.a()) {
                    c.this.f14368b.b("AdHiddenCallbackTimeoutManager", "Timing out...");
                }
                c.this.f14369c.c(cVar);
            }
        });
    }
}

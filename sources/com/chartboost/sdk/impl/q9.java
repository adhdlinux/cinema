package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.privacy.model.CCPA;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.Custom;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import com.chartboost.sdk.privacy.model.LGPD;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class q9 implements p9, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final n9 f18440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f18441b;

    public q9(n9 n9Var, a5 a5Var) {
        Intrinsics.f(n9Var, "repository");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18440a = n9Var;
        this.f18441b = a5Var;
    }

    public void a(DataUseConsent dataUseConsent) {
        String privacyStandard;
        if (dataUseConsent == null || (privacyStandard = dataUseConsent.getPrivacyStandard()) == null || privacyStandard.length() == 0) {
            try {
                track((qb) new d4(tb.d.PERSISTENCE_ERROR, "", "", "", (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
            } catch (Exception unused) {
            }
            w7.b("PutDataUseConsentUseCase", "addDataUseConsent failed");
        } else if ((dataUseConsent instanceof GDPR) || (dataUseConsent instanceof CCPA) || (dataUseConsent instanceof COPPA) || (dataUseConsent instanceof LGPD) || (dataUseConsent instanceof Custom)) {
            this.f18440a.b(dataUseConsent);
        } else {
            try {
                tb.d dVar = tb.d.SUBCLASSING_ERROR;
                String name = dataUseConsent.getClass().getName();
                Intrinsics.e(name, "dataUseConsent.javaClass.name");
                track((qb) new x4(dVar, name, "", "", (Mediation) null, 16, (DefaultConstructorMarker) null));
            } catch (Exception unused2) {
            }
            w7.e("PutDataUseConsentUseCase", "Attempt to addDataUseConsent. Context and DataUseConsent cannot be null.");
        }
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18441b.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18441b.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18441b.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18441b.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18441b.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18441b.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m61clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18441b.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m62persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18441b.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m63refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18441b.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m64store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18441b.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m65track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18441b.track(qbVar);
    }
}

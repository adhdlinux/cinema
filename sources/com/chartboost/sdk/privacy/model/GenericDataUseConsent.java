package com.chartboost.sdk.privacy.model;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.a5;
import com.chartboost.sdk.impl.d4;
import com.chartboost.sdk.impl.ib;
import com.chartboost.sdk.impl.kb;
import com.chartboost.sdk.impl.ob;
import com.chartboost.sdk.impl.qb;
import com.chartboost.sdk.impl.tb;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class GenericDataUseConsent implements DataUseConsent, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f19190a;

    /* renamed from: b  reason: collision with root package name */
    public String f19191b;

    /* renamed from: c  reason: collision with root package name */
    public Object f19192c;

    public GenericDataUseConsent() {
        this((a5) null, 1, (DefaultConstructorMarker) null);
    }

    public final Object a() {
        return this.f19192c;
    }

    public final void b(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f19191b = str;
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f19190a.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19190a.clearFromStorage(qbVar);
    }

    public String getPrivacyStandard() {
        return this.f19191b;
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19190a.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f19190a.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f19190a.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19190a.track(qbVar);
    }

    public GenericDataUseConsent(a5 a5Var) {
        Intrinsics.f(a5Var, "eventTracker");
        this.f19190a = a5Var;
        this.f19191b = "";
        this.f19192c = "";
    }

    public final void a(Object obj) {
        Intrinsics.f(obj, "<set-?>");
        this.f19192c = obj;
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m101clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19190a.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m102persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19190a.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m103refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f19190a.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m104store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f19190a.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m105track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19190a.track(qbVar);
    }

    public final void a(String str) {
        try {
            track((qb) new d4(tb.d.CREATION_ERROR, str == null ? "no message" : str, "", "", (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
            throw new Exception(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GenericDataUseConsent(a5 a5Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? kb.a() : a5Var);
    }
}

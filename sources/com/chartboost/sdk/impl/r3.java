package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class r3 implements q3, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f18509a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18510b;

    /* renamed from: c  reason: collision with root package name */
    public final Mediation f18511c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a5 f18512d;

    public r3(String str, String str2, Mediation mediation, a5 a5Var) {
        Intrinsics.f(str, "adType");
        Intrinsics.f(str2, "location");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18509a = str;
        this.f18510b = str2;
        this.f18511c = mediation;
        this.f18512d = a5Var;
    }

    public void a(String str) {
        Intrinsics.f(str, "message");
        track((qb) new m7(tb.f.SUCCESS, str, this.f18509a, this.f18510b, this.f18511c, (ib) null, 32, (DefaultConstructorMarker) null));
    }

    public void b(String str) {
        Intrinsics.f(str, "message");
        track((qb) new x4(tb.f.FAILURE, str, this.f18509a, this.f18510b, this.f18511c));
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18512d.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18512d.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18512d.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18512d.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18512d.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18512d.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m66clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18512d.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m67persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18512d.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m68refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18512d.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m69store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18512d.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m70track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18512d.track(qbVar);
    }
}

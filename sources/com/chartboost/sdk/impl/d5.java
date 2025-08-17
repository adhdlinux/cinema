package com.chartboost.sdk.impl;

import b0.n;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.Thread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class d5 implements a5 {

    /* renamed from: b  reason: collision with root package name */
    public static final d5 f17421b = new d5();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f17422a = kb.a();

    public final void a() {
        Thread.setDefaultUncaughtExceptionHandler(new n(Thread.getDefaultUncaughtExceptionHandler()));
    }

    public final boolean b(Throwable th) {
        String className;
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.e(stackTrace, "throwable.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!(stackTraceElement == null || (className = stackTraceElement.getClassName()) == null)) {
                Intrinsics.e(className, "className");
                if (StringsKt__StringsJVMKt.G(className, "com.chartboost.sdk", false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f17422a.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17422a.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17422a.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f17422a.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f17422a.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17422a.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m16clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17422a.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m17persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17422a.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m18refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f17422a.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m19store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f17422a.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m20track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17422a.track(qbVar);
    }

    public static final void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        d5 d5Var = f17421b;
        Intrinsics.e(th, "throwable");
        if (d5Var.b(th)) {
            d5Var.track((qb) new x4(tb.h.DISMISS_MISSING, d5Var.a(th), (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public final String a(Throwable th) {
        String jSONObject = new JSONObject().put("reason", "dismiss_event due to the unhandled exceptions").put(MRAIDPresenter.ERROR, String.valueOf(th)).toString();
        Intrinsics.e(jSONObject, "JSONObject().put(\"reason…rrorMessage}\").toString()");
        return jSONObject;
    }
}

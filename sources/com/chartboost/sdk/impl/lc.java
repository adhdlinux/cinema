package com.chartboost.sdk.impl;

import android.content.Context;
import android.webkit.WebSettings;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class lc implements a5 {

    /* renamed from: b  reason: collision with root package name */
    public static final lc f18142b = new lc();

    /* renamed from: c  reason: collision with root package name */
    public static String f18143c = "Invalid user-agent value";

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f18144a = kb.a();

    public final String a() {
        return f18143c;
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18144a.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18144a.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18144a.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18144a.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18144a.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18144a.track(qbVar);
    }

    public final void a(Context context) {
        String str;
        Intrinsics.f(context, "context");
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e2) {
            a(e2.toString());
            str = "";
        }
        try {
            str = WebSettings.getDefaultUserAgent(context);
        } catch (Exception e3) {
            a(e3.toString());
        }
        if (str != null) {
            f18143c = str;
        }
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m31clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18144a.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m32persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18144a.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m33refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18144a.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m34store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18144a.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m35track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18144a.track(qbVar);
    }

    public final void a(String str) {
        try {
            track((qb) new x4(tb.e.USER_AGENT_UPDATE_ERROR, str, (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
        } catch (Exception e2) {
            String a2 = mc.f18200a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "sendUserAgentErrorTracking", e2);
        }
    }
}

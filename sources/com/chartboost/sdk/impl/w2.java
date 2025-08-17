package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class w2 implements a5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f18885a;

    public w2(a5 a5Var) {
        Intrinsics.f(a5Var, "eventTracker");
        this.f18885a = a5Var;
    }

    public final void a(z2 z2Var, String str, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adTypeName");
        b(d8.ON_BACKGROUND.c(), z2Var, str, str2);
    }

    public final void b(z2 z2Var, String str, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adTypeName");
        b(d8.ON_FOREGROUND.c(), z2Var, str, str2);
    }

    public final void c(z2 z2Var, String str, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adTypeName");
        b(d8.VIDEO_ENDED.c(), z2Var, str, str2);
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18885a.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18885a.clearFromStorage(qbVar);
    }

    public final void d(z2 z2Var, String str, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adTypeName");
        b(d8.VIDEO_FAILED.c(), z2Var, str, str2);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18885a.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18885a.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18885a.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18885a.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m71clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18885a.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m72persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18885a.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m73refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18885a.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m74store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18885a.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m75track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18885a.track(qbVar);
    }

    public final void a(z2 z2Var, float f2, String str, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adTypeName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("seconds", Float.valueOf(f2));
        String c2 = d8.PLAYBACK_TIME.c();
        String jSONObject2 = jSONObject.toString();
        Intrinsics.e(jSONObject2, "json.toString()");
        a(c2, jSONObject2, z2Var, str, str2);
    }

    public final void b(z2 z2Var, float f2, String str, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adTypeName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("totalDuration", Float.valueOf(f2));
        String c2 = d8.VIDEO_STARTED.c();
        String jSONObject2 = jSONObject.toString();
        Intrinsics.e(jSONObject2, "json.toString()");
        a(c2, jSONObject2, z2Var, str, str2);
    }

    public final void a(String str, String str2, z2 z2Var, String str3, String str4) {
        a("javascript:Chartboost.EventHandler.handleNativeEvent(\"" + str + "\", " + str2 + ')', z2Var, str3, str4);
    }

    public final void b(String str, z2 z2Var, String str2, String str3) {
        a("javascript:Chartboost.EventHandler.handleNativeEvent(\"" + str + "\")", z2Var, str2, str3);
    }

    public final void a(String str, z2 z2Var, String str2, String str3) {
        if (z2Var == null) {
            try {
                track((qb) new d4(tb.h.WEBVIEW_ERROR, "Webview is null", str3, str2, (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
                w7.c("CBTemplateProxy", "Calling native to javascript webview is null");
            } catch (Exception e2) {
                tb.h hVar = tb.h.WEBVIEW_CRASH;
                track((qb) new d4(hVar, "Cannot open url: " + e2, str3, str2, (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
                w7.c("CBTemplateProxy", "Calling native to javascript. Cannot open url: " + e2);
            }
        } else {
            w7.a("CBTemplateProxy", "Calling native to javascript: " + str);
            z2Var.loadUrl(str);
        }
    }
}

package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class rb {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f18522a;

    /* renamed from: b  reason: collision with root package name */
    public final mb f18523b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f18524c;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18525b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final JSONObject invoke(String str) {
            Intrinsics.f(str, "it");
            return new JSONObject(str);
        }
    }

    public rb(SharedPreferences sharedPreferences, mb mbVar, Function1 function1) {
        Intrinsics.f(sharedPreferences, "sharedPreferences");
        Intrinsics.f(mbVar, "trackingBodyBuilder");
        Intrinsics.f(function1, "jsonFactory");
        this.f18522a = sharedPreferences;
        this.f18523b = mbVar;
        this.f18524c = function1;
    }

    public final void a(JSONArray jSONArray) {
        Intrinsics.f(jSONArray, "jsonArray");
        try {
            for (JSONObject jSONObject : r5.asList(jSONArray)) {
                this.f18522a.edit().putString(a(jSONObject), jSONObject.toString()).apply();
            }
        } catch (Exception e2) {
            String a2 = sb.f18599a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "cacheEventToTrackingRequestBodyAndSave error " + e2);
        }
    }

    public final String b(qb qbVar) {
        return qbVar.f().getValue() + qbVar.i();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rb(SharedPreferences sharedPreferences, mb mbVar, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, mbVar, (i2 & 4) != 0 ? a.f18525b : function1);
    }

    public final void a(qb qbVar, v4 v4Var, int i2) {
        Intrinsics.f(qbVar, "event");
        Intrinsics.f(v4Var, "environmentData");
        if (this.f18522a.getAll().size() > i2) {
            String a2 = sb.f18599a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Persistence limit reached. Drop old events!");
            this.f18522a.edit().clear().apply();
        }
        try {
            this.f18522a.edit().putString(b(qbVar), this.f18523b.a(qbVar, v4Var)).apply();
        } catch (Exception e2) {
            String a3 = sb.f18599a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "cacheEventToTrackingRequestBodyAndSave error " + e2);
        }
    }

    public final List a() {
        try {
            List<Object> a02 = CollectionsKt___CollectionsKt.a0(this.f18522a.getAll().values());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(a02, 10));
            for (Object valueOf : a02) {
                Object invoke = this.f18524c.invoke(String.valueOf(valueOf));
                JSONObject jSONObject = (JSONObject) invoke;
                this.f18522a.edit().clear().apply();
                arrayList.add((JSONObject) invoke);
            }
            return arrayList;
        } catch (Exception e2) {
            String a2 = sb.f18599a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "loadEventsAsJsonList error " + e2);
            return CollectionsKt__CollectionsKt.f();
        }
    }

    public final String a(JSONObject jSONObject) {
        return jSONObject.getString("event_name") + jSONObject.getLong("event_timestamp");
    }

    public final void a(qb qbVar, v4 v4Var) {
        Intrinsics.f(qbVar, "event");
        Intrinsics.f(v4Var, "environmentData");
        try {
            String a2 = sb.f18599a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "forcePersistEvent: " + qbVar.f().getValue());
            this.f18522a.edit().putString(qbVar.f().getValue(), this.f18523b.a(qbVar, v4Var)).apply();
        } catch (Exception e2) {
            String a3 = sb.f18599a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "forcePersistEvent error " + e2);
        }
    }

    public final void a(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        try {
            String a2 = sb.f18599a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "clearEventFromStorage: " + qbVar.f().getValue());
            this.f18522a.edit().remove(qbVar.f().getValue()).apply();
        } catch (Exception e2) {
            String a3 = sb.f18599a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "clearEventFromStorage error " + e2);
        }
    }

    public final List a(List list, v4 v4Var) {
        Intrinsics.f(list, "events");
        Intrinsics.f(v4Var, "environmentData");
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add((JSONObject) this.f18524c.invoke(this.f18523b.a((qb) it2.next(), v4Var)));
            }
            return arrayList;
        } catch (Exception e2) {
            String a2 = sb.f18599a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "cacheEventToTrackingRequestBody error " + e2);
            return CollectionsKt__CollectionsKt.f();
        }
    }
}

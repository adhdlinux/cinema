package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.u;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class mb {

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f18198a;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18199b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final JSONObject invoke() {
            return new JSONObject();
        }
    }

    public mb(Function0 function0) {
        Intrinsics.f(function0, "jsonFactory");
        this.f18198a = function0;
    }

    public final String a(qb qbVar, v4 v4Var) {
        Intrinsics.f(qbVar, "event");
        Intrinsics.f(v4Var, "environment");
        String jSONObject = a(a(a(c(c(b(b((JSONObject) this.f18198a.invoke(), v4Var), qbVar), v4Var), qbVar), qbVar), v4Var), v4Var, qbVar.a()).toString();
        Intrinsics.e(jSONObject, "jsonFactory()\n          …)\n            .toString()");
        return jSONObject;
    }

    public final int b(v4 v4Var, String str) {
        if (Intrinsics.a(str, u.b.f18736g.b())) {
            return v4Var.D();
        }
        if (Intrinsics.a(str, u.c.f18737g.b())) {
            return v4Var.E();
        }
        if (Intrinsics.a(str, u.a.f18735g.b())) {
            return v4Var.C();
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject c(org.json.JSONObject r4, com.chartboost.sdk.impl.v4 r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "session_id"
            java.lang.String r1 = r5.B()     // Catch:{ all -> 0x001d }
            r4.put(r0, r1)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "session_count"
            int r5 = r5.z()     // Catch:{ all -> 0x001d }
            org.json.JSONObject r5 = r4.put(r0, r5)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x0018
            r5 = r4
        L_0x0018:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x001d }
            goto L_0x0028
        L_0x001d:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x0028:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L_0x0037
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r0)
        L_0x0037:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 != 0) goto L_0x003e
            r4 = r5
        L_0x003e:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.c(org.json.JSONObject, com.chartboost.sdk.impl.v4):org.json.JSONObject");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mb(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? a.f18199b : function0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject b(org.json.JSONObject r4, com.chartboost.sdk.impl.v4 r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "app_id"
            java.lang.String r1 = r5.a()     // Catch:{ all -> 0x001d }
            r4.put(r0, r1)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "chartboost_sdk_version"
            java.lang.String r5 = r5.g()     // Catch:{ all -> 0x001d }
            org.json.JSONObject r5 = r4.put(r0, r5)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x0018
            r5 = r4
        L_0x0018:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x001d }
            goto L_0x0028
        L_0x001d:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x0028:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L_0x0037
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r0)
        L_0x0037:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 != 0) goto L_0x003e
            r4 = r5
        L_0x003e:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.b(org.json.JSONObject, com.chartboost.sdk.impl.v4):org.json.JSONObject");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject c(org.json.JSONObject r4, com.chartboost.sdk.impl.qb r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x0028 }
            com.chartboost.sdk.Mediation r5 = r5.d()     // Catch:{ all -> 0x0028 }
            if (r5 == 0) goto L_0x001f
            java.lang.String r0 = "mediation_sdk"
            java.lang.String r1 = r5.mediationType     // Catch:{ all -> 0x0028 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = "mediation_sdk_version"
            java.lang.String r1 = r5.libraryVersion     // Catch:{ all -> 0x0028 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = "mediation_sdk_adapter_version"
            java.lang.String r5 = r5.adapterVersion     // Catch:{ all -> 0x0028 }
            org.json.JSONObject r5 = r4.put(r0, r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0020
        L_0x001f:
            r5 = 0
        L_0x0020:
            if (r5 != 0) goto L_0x0023
            r5 = r4
        L_0x0023:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0033
        L_0x0028:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x0033:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L_0x0042
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r0)
        L_0x0042:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 != 0) goto L_0x0049
            r4 = r5
        L_0x0049:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.c(org.json.JSONObject, com.chartboost.sdk.impl.qb):org.json.JSONObject");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(com.chartboost.sdk.impl.v4 r5, java.lang.String r6) {
        /*
            r4 = this;
            kotlin.jvm.functions.Function0 r0 = r4.f18198a
            java.lang.Object r0 = r0.invoke()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            kotlin.Result$Companion r1 = kotlin.Result.f40263c     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_battery_level"
            int r2 = r5.i()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_charging_status"
            boolean r2 = r5.j()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_language"
            java.lang.String r2 = r5.n()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_timezone"
            java.lang.String r2 = r5.w()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_volume"
            int r2 = r5.y()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_mute"
            boolean r2 = r5.r()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_audio_output"
            int r2 = r5.h()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_storage"
            long r2 = r5.v()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_low_memory_warning"
            long r2 = r5.o()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "device_up_time"
            long r2 = r5.x()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "chartboost_sdk_autocache_enabled"
            boolean r2 = r5.b()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "chartboost_sdk_gdpr"
            java.lang.String r2 = r5.e()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "chartboost_sdk_ccpa"
            java.lang.String r2 = r5.c()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "chartboost_sdk_coppa"
            java.lang.String r2 = r5.d()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "chartboost_sdk_lgpd"
            java.lang.String r2 = r5.f()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "session_duration"
            long r2 = r5.A()     // Catch:{ all -> 0x00ac }
            r0.put(r1, r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "session_impression_count"
            int r5 = r4.b((com.chartboost.sdk.impl.v4) r5, (java.lang.String) r6)     // Catch:{ all -> 0x00ac }
            org.json.JSONObject r5 = r0.put(r1, r5)     // Catch:{ all -> 0x00ac }
            if (r5 != 0) goto L_0x00a7
            r5 = r0
        L_0x00a7:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x00ac }
            goto L_0x00b7
        L_0x00ac:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x00b7:
            java.lang.Throwable r6 = kotlin.Result.e(r5)
            if (r6 == 0) goto L_0x00c6
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r6)
        L_0x00c6:
            java.lang.Throwable r6 = kotlin.Result.e(r5)
            if (r6 != 0) goto L_0x00cd
            r0 = r5
        L_0x00cd:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.a(com.chartboost.sdk.impl.v4, java.lang.String):org.json.JSONObject");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject b(org.json.JSONObject r4, com.chartboost.sdk.impl.qb r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "event_name"
            com.chartboost.sdk.impl.tb r1 = r5.f()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = r1.getValue()     // Catch:{ all -> 0x0041 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "event_message"
            java.lang.String r1 = r5.e()     // Catch:{ all -> 0x0041 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "event_type"
            com.chartboost.sdk.impl.qb$b r1 = r5.l()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x0041 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "event_timestamp"
            long r1 = r5.j()     // Catch:{ all -> 0x0041 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "event_latency"
            float r5 = r5.b()     // Catch:{ all -> 0x0041 }
            double r1 = (double) r5     // Catch:{ all -> 0x0041 }
            org.json.JSONObject r5 = r4.put(r0, r1)     // Catch:{ all -> 0x0041 }
            if (r5 != 0) goto L_0x003c
            r5 = r4
        L_0x003c:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x0041 }
            goto L_0x004c
        L_0x0041:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x004c:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L_0x005b
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r0)
        L_0x005b:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 != 0) goto L_0x0062
            r4 = r5
        L_0x0062:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.b(org.json.JSONObject, com.chartboost.sdk.impl.qb):org.json.JSONObject");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(org.json.JSONObject r4, com.chartboost.sdk.impl.qb r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "ad_type"
            java.lang.String r1 = r5.a()     // Catch:{ all -> 0x0081 }
            java.util.Locale r2 = java.util.Locale.ROOT     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = r1.toLowerCase(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)     // Catch:{ all -> 0x0081 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "ad_impression_id"
            com.chartboost.sdk.impl.ib r1 = r5.k()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0026
        L_0x0024:
            java.lang.String r1 = "missing impression id"
        L_0x0026:
            r4.put(r0, r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "ad_creative_id"
            com.chartboost.sdk.impl.ib r1 = r5.k()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0037
            java.lang.String r1 = r1.a()     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0039
        L_0x0037:
            java.lang.String r1 = "missing creative id"
        L_0x0039:
            r4.put(r0, r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "ad_location_id"
            java.lang.String r1 = r5.c()     // Catch:{ all -> 0x0081 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "template_url"
            com.chartboost.sdk.impl.ib r1 = r5.k()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = r1.g()     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0055
        L_0x0053:
            java.lang.String r1 = ""
        L_0x0055:
            r4.put(r0, r1)     // Catch:{ all -> 0x0081 }
            com.chartboost.sdk.impl.ib r5 = r5.k()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0078
            com.chartboost.sdk.impl.ib$a r5 = r5.c()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0078
            java.lang.String r0 = "ad_height"
            int r1 = r5.a()     // Catch:{ all -> 0x0081 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "ad_width"
            int r5 = r5.b()     // Catch:{ all -> 0x0081 }
            org.json.JSONObject r5 = r4.put(r0, r5)     // Catch:{ all -> 0x0081 }
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            if (r5 != 0) goto L_0x007c
            r5 = r4
        L_0x007c:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x0081 }
            goto L_0x008c
        L_0x0081:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x008c:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L_0x009b
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r0)
        L_0x009b:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 != 0) goto L_0x00a2
            r4 = r5
        L_0x00a2:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.a(org.json.JSONObject, com.chartboost.sdk.impl.qb):org.json.JSONObject");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(org.json.JSONObject r4, com.chartboost.sdk.impl.v4 r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_id"
            java.lang.String r1 = r5.m()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_make"
            java.lang.String r1 = r5.p()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_model"
            java.lang.String r1 = r5.q()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_os_version"
            java.lang.String r1 = r5.t()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_platform"
            java.lang.String r1 = r5.u()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_country"
            java.lang.String r1 = r5.l()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_connection_type"
            java.lang.String r1 = r5.k()     // Catch:{ all -> 0x0053 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "device_orientation"
            java.lang.String r5 = r5.s()     // Catch:{ all -> 0x0053 }
            org.json.JSONObject r5 = r4.put(r0, r5)     // Catch:{ all -> 0x0053 }
            if (r5 != 0) goto L_0x004e
            r5 = r4
        L_0x004e:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch:{ all -> 0x0053 }
            goto L_0x005e
        L_0x0053:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.f40263c
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x005e:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L_0x006d
            java.lang.String r1 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r2 = "Cannot generate tracking body data: "
            android.util.Log.e(r1, r2, r0)
        L_0x006d:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 != 0) goto L_0x0074
            r4 = r5
        L_0x0074:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.a(org.json.JSONObject, com.chartboost.sdk.impl.v4):org.json.JSONObject");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(org.json.JSONObject r3, com.chartboost.sdk.impl.v4 r4, java.lang.String r5) {
        /*
            r2 = this;
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = "payload"
            org.json.JSONObject r4 = r2.a((com.chartboost.sdk.impl.v4) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0014 }
            org.json.JSONObject r4 = r3.put(r0, r4)     // Catch:{ all -> 0x0014 }
            if (r4 != 0) goto L_0x000f
            r4 = r3
        L_0x000f:
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch:{ all -> 0x0014 }
            goto L_0x001f
        L_0x0014:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L_0x001f:
            java.lang.Throwable r5 = kotlin.Result.e(r4)
            if (r5 == 0) goto L_0x002e
            java.lang.String r0 = com.chartboost.sdk.impl.nb.f18262a
            java.lang.String r1 = "Cannot generate tracking body data: "
            android.util.Log.e(r0, r1, r5)
        L_0x002e:
            java.lang.Throwable r5 = kotlin.Result.e(r4)
            if (r5 != 0) goto L_0x0035
            r3 = r4
        L_0x0035:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.mb.a(org.json.JSONObject, com.chartboost.sdk.impl.v4, java.lang.String):org.json.JSONObject");
    }
}

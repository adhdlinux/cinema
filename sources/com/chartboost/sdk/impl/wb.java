package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.NetworkHelper;
import com.google.android.gms.common.internal.ImagesContract;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

public final class wb extends t2 {

    /* renamed from: s  reason: collision with root package name */
    public final rb f18904s;

    public static final class a implements t2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rb f18905a;

        public a(rb rbVar) {
            this.f18905a = rbVar;
        }

        public void a(t2 t2Var, CBError cBError) {
            String str;
            JSONArray jSONArray;
            String a2 = xb.f18982a;
            Intrinsics.e(a2, "TAG");
            StringBuilder sb = new StringBuilder();
            sb.append("Request ");
            if (t2Var != null) {
                str = t2Var.e();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(" failed!");
            w7.a(a2, sb.toString());
            if (t2Var != null && (jSONArray = t2Var.f18626q) != null) {
                this.f18905a.a(jSONArray);
            }
        }

        public void a(t2 t2Var, JSONObject jSONObject) {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wb(String str, rb rbVar, t2.a aVar, z4 z4Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, rbVar, (i2 & 4) != 0 ? new a(rbVar) : aVar, z4Var);
    }

    public m2 a() {
        Map k2 = k();
        JSONArray jSONArray = this.f18626q;
        Intrinsics.e(jSONArray, "bodyArray");
        return new m2(k2, i2.a(jSONArray), TraktV2.CONTENT_TYPE_JSON);
    }

    public final Map k() {
        return MapsKt__MapsKt.j(TuplesKt.a(TheTvdb.HEADER_ACCEPT, TraktV2.CONTENT_TYPE_JSON), TuplesKt.a("X-Chartboost-Client", CBUtility.b()), TuplesKt.a("X-Chartboost-API", "9.7.0"));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wb(String str, rb rbVar, t2.a aVar, z4 z4Var) {
        super(NetworkHelper.a(str), NetworkHelper.b(str), (ea) null, i9.NORMAL, aVar, z4Var);
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(rbVar, "trackingEventCache");
        Intrinsics.f(aVar, "callback");
        Intrinsics.f(z4Var, "eventTracker");
        this.f18904s = rbVar;
        this.f18627r = false;
    }
}

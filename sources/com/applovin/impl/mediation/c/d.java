package com.applovin.impl.mediation.c;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f14403a;

    /* renamed from: c  reason: collision with root package name */
    private final String f14404c;

    /* renamed from: d  reason: collision with root package name */
    private final f f14405d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f14406e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f14407f;

    /* renamed from: g  reason: collision with root package name */
    private final MaxError f14408g;

    public d(String str, Map<String, String> map, MaxError maxError, f fVar, m mVar) {
        super("TaskFireMediationPostbacks", mVar);
        this.f14403a = str;
        this.f14404c = str + "_urls";
        this.f14406e = Utils.toUrlSafeMap(map, mVar);
        this.f14408g = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.f14405d = fVar;
        HashMap hashMap = new HashMap(7);
        hashMap.put("AppLovin-Event-Type", str);
        hashMap.put("AppLovin-Ad-Network-Name", fVar.L());
        if (fVar instanceof com.applovin.impl.mediation.a.a) {
            com.applovin.impl.mediation.a.a aVar = (com.applovin.impl.mediation.a.a) fVar;
            hashMap.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            hashMap.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
            hashMap.put("AppLovin-Third-Party-Ad-Placement-ID", aVar.l());
        }
        if (maxError != null) {
            hashMap.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            hashMap.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f14407f = hashMap;
    }

    private String a(String str, MaxError maxError) {
        int i2;
        String str2;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            i2 = maxAdapterError.getMediatedNetworkErrorCode();
            str2 = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            i2 = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage(), d())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i2)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(str2, d()));
    }

    private List<String> a(List<String> list, Map<String, String> map, Map<String, String> map2, MaxError maxError) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            for (String next2 : map.keySet()) {
                next = next.replace(next2, this.f14405d.g(map.get(next2)));
            }
            arrayList.add(a(b(next, map2), maxError));
        }
        return arrayList;
    }

    private Map<String, String> a() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f15333b.a(com.applovin.impl.sdk.c.a.f15187i)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private void a(String str, Map<String, Object> map) {
        d().U().a(h.o().c(str).b("POST").b(this.f14407f).a(false).c(map).b(((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.a.V)).booleanValue()).a());
    }

    private void a(List<String> list) {
        if (!list.isEmpty()) {
            for (String c2 : list) {
                d().U().a(h.o().c(c2).a(false).b(this.f14407f).a());
            }
        }
    }

    private String b(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(next, StringUtils.emptyIfNull(map.get(next)));
        }
        return str;
    }

    private void b(List<String> list) {
        if (!list.isEmpty()) {
            for (String d2 : list) {
                d().X().dispatchPostbackRequest(i.b(d()).a(d2).c(false).b(this.f14407f).a(), o.a.MEDIATION_POSTBACKS, new AppLovinPostbackListener() {
                    public void onPostbackFailure(String str, int i2) {
                        if (v.a()) {
                            d dVar = d.this;
                            dVar.d("Failed to fire postback with code: " + i2 + " and url: " + str);
                        }
                    }

                    public void onPostbackSuccess(String str) {
                    }
                });
            }
        }
    }

    public void run() {
        List<String> f2 = this.f14405d.f(this.f14404c);
        Map<String, String> a2 = a();
        if (((Boolean) d().a(com.applovin.impl.sdk.c.a.P)).booleanValue()) {
            for (String b2 : f2) {
                Uri parse = Uri.parse(a(b(b2, this.f14406e), this.f14408g));
                Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                HashMap hashMap = new HashMap(a2.size());
                for (String next : parse.getQueryParameterNames()) {
                    String queryParameter = parse.getQueryParameter(next);
                    if (a2.containsKey(queryParameter)) {
                        hashMap.put(next, this.f14405d.g(a2.get(queryParameter)));
                    } else {
                        clearQuery.appendQueryParameter(next, queryParameter);
                    }
                }
                a(clearQuery.build().toString(), (Map<String, Object>) hashMap);
            }
            return;
        }
        List<String> a3 = a(f2, a2, this.f14406e, this.f14408g);
        if (((Boolean) d().a(com.applovin.impl.sdk.c.a.f15188j)).booleanValue()) {
            a(a3);
        } else {
            b(a3);
        }
    }
}

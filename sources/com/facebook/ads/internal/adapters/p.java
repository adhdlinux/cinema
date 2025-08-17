package com.facebook.ads.internal.adapters;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.a.d;
import com.facebook.ads.internal.a.e;
import com.facebook.ads.internal.j.c;
import com.facebook.ads.internal.q.a.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19962a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19963b;

    /* renamed from: c  reason: collision with root package name */
    private final d f19964c;

    /* renamed from: d  reason: collision with root package name */
    private final Collection<String> f19965d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f19966e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19967f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19968g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19969h;

    /* renamed from: i  reason: collision with root package name */
    private final int f19970i;

    /* renamed from: j  reason: collision with root package name */
    private final String f19971j;

    private p(String str, String str2, d dVar, Collection<String> collection, Map<String, String> map, String str3, int i2, int i3, int i4, String str4) {
        this.f19962a = str;
        this.f19963b = str2;
        this.f19964c = dVar;
        this.f19965d = collection;
        this.f19966e = map;
        this.f19967f = str3;
        this.f19968g = i2;
        this.f19969h = i3;
        this.f19970i = i4;
        this.f19971j = str4;
    }

    public static p a(Bundle bundle) {
        return new p(c.a(bundle.getByteArray("markup")), (String) null, d.NONE, (Collection<String>) null, (Map<String, String>) null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"), bundle.getInt("skip_after_seconds", 0), bundle.getString("ct"));
    }

    public static p a(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("request_id");
        String a2 = k.a(jSONObject, "ct");
        d a3 = d.a(jSONObject.optString("invalidation_behavior"));
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Collection<String> a4 = e.a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        HashMap hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
        }
        return new p(optString, optString2, a3, a4, hashMap, optString3, hashMap.containsKey("viewability_check_initial_delay") ? Integer.parseInt((String) hashMap.get("viewability_check_initial_delay")) : 0, hashMap.containsKey("viewability_check_interval") ? Integer.parseInt((String) hashMap.get("viewability_check_interval")) : 1000, hashMap.containsKey("skip_after_seconds") ? Integer.parseInt((String) hashMap.get("skip_after_seconds")) : 0, a2);
    }

    public static p b(Intent intent) {
        return new p(c.a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), d.NONE, (Collection<String>) null, (Map<String, String>) null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", 1000), intent.getIntExtra(AudienceNetworkActivity.SKIP_DELAY_SECONDS_KEY, 0), intent.getStringExtra("ct"));
    }

    public d a() {
        return this.f19964c;
    }

    public void a(Intent intent) {
        intent.putExtra("markup", c.a(this.f19962a));
        intent.putExtra("activation_command", this.f19963b);
        intent.putExtra("request_id", this.f19967f);
        intent.putExtra("viewability_check_initial_delay", this.f19968g);
        intent.putExtra("viewability_check_interval", this.f19969h);
        intent.putExtra(AudienceNetworkActivity.SKIP_DELAY_SECONDS_KEY, this.f19970i);
        intent.putExtra("ct", this.f19971j);
    }

    public Collection<String> b() {
        return this.f19965d;
    }

    public String c() {
        return this.f19971j;
    }

    public String d() {
        return this.f19962a;
    }

    public String e() {
        return this.f19963b;
    }

    public Map<String, String> f() {
        return this.f19966e;
    }

    public String g() {
        return this.f19967f;
    }

    public int h() {
        return this.f19968g;
    }

    public int i() {
        return this.f19969h;
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("markup", c.a(this.f19962a));
        bundle.putString("request_id", this.f19967f);
        bundle.putInt("viewability_check_initial_delay", this.f19968g);
        bundle.putInt("viewability_check_interval", this.f19969h);
        bundle.putInt("skip_after_seconds", this.f19970i);
        bundle.putString("ct", this.f19971j);
        return bundle;
    }
}

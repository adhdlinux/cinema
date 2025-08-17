package com.applovin.impl.mediation.a;

import android.os.Bundle;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f14229a;

    /* renamed from: b  reason: collision with root package name */
    protected final m f14230b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f14231c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f14232d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f14233e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Object f14234f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private String f14235g;

    /* renamed from: h  reason: collision with root package name */
    private String f14236h;

    public f(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        } else if (jSONObject != null) {
            this.f14230b = mVar;
            this.f14229a = jSONObject2;
            this.f14231c = jSONObject;
            this.f14232d = map;
        } else {
            throw new IllegalArgumentException("No ad object specified");
        }
    }

    private int a() {
        return b("mute_state", a("mute_state", ((Integer) this.f14230b.a(a.K)).intValue()));
    }

    /* access modifiers changed from: protected */
    public JSONObject I() {
        JSONObject jSONObject;
        synchronized (this.f14234f) {
            jSONObject = this.f14229a;
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public JSONObject J() {
        JSONObject jSONObject;
        synchronized (this.f14233e) {
            jSONObject = this.f14231c;
        }
        return jSONObject;
    }

    public String K() {
        return b("class", (String) null);
    }

    public String L() {
        return b("name", (String) null);
    }

    public String M() {
        return L().split("_")[0];
    }

    public boolean N() {
        return b("is_testing", Boolean.FALSE).booleanValue();
    }

    public Boolean O() {
        String str = this.f14230b.p().getExtraParameters().get("huc");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : b("huc") ? b("huc", Boolean.FALSE) : a("huc", (Boolean) null);
    }

    public Boolean P() {
        String str = this.f14230b.p().getExtraParameters().get("aru");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : b("aru") ? b("aru", Boolean.FALSE) : a("aru", (Boolean) null);
    }

    public Boolean Q() {
        String str = this.f14230b.p().getExtraParameters().get("dns");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : b("dns") ? b("dns", Boolean.FALSE) : a("dns", (Boolean) null);
    }

    public String R() {
        return b("consent_string") ? b("consent_string", (String) null) : a("consent_string", (String) null);
    }

    public boolean S() {
        return b("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    public Map<String, Object> T() {
        return this.f14232d;
    }

    public Bundle U() {
        Bundle bundle = c("server_parameters") instanceof JSONObject ? JsonUtils.toBundle(a("server_parameters", (JSONObject) null)) : new Bundle();
        int a2 = a();
        if (a2 != -1) {
            bundle.putBoolean("is_muted", a2 == 2 ? this.f14230b.p().isMuted() : a2 == 0);
        }
        if (!bundle.containsKey(AppLovinEventParameters.REVENUE_AMOUNT)) {
            bundle.putLong(AppLovinEventParameters.REVENUE_AMOUNT, a(AppLovinEventParameters.REVENUE_AMOUNT, 0));
        }
        if (!bundle.containsKey("currency")) {
            bundle.putString("currency", a("currency", ""));
        }
        return bundle;
    }

    public Bundle V() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), U());
    }

    public long W() {
        return b("adapter_timeout_ms", ((Long) this.f14230b.a(a.f15190l)).longValue());
    }

    public long X() {
        return b("init_completion_delay_ms", -1);
    }

    public long Y() {
        return b("auto_init_delay_ms", 0);
    }

    public String Z() {
        return this.f14236h;
    }

    /* access modifiers changed from: protected */
    public float a(String str, float f2) {
        float f3;
        synchronized (this.f14233e) {
            f3 = JsonUtils.getFloat(this.f14231c, str, f2);
        }
        return f3;
    }

    /* access modifiers changed from: protected */
    public int a(String str, int i2) {
        int i3;
        synchronized (this.f14234f) {
            i3 = JsonUtils.getInt(this.f14229a, str, i2);
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    public long a(String str, long j2) {
        long j3;
        synchronized (this.f14234f) {
            j3 = JsonUtils.getLong(this.f14229a, str, j2);
        }
        return j3;
    }

    /* access modifiers changed from: protected */
    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f14234f) {
            bool2 = JsonUtils.getBoolean(this.f14229a, str, bool);
        }
        return bool2;
    }

    /* access modifiers changed from: protected */
    public String a(String str, String str2) {
        String string;
        synchronized (this.f14234f) {
            string = JsonUtils.getString(this.f14229a, str, str2);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f14234f) {
            jSONArray2 = JsonUtils.getJSONArray(this.f14229a, str, jSONArray);
        }
        return jSONArray2;
    }

    /* access modifiers changed from: protected */
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.f14233e) {
            jSONObject2 = JsonUtils.getJSONObject(this.f14231c, str, jSONObject);
        }
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
        synchronized (this.f14233e) {
            JsonUtils.putObject(this.f14231c, str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public int b(String str, int i2) {
        int i3;
        synchronized (this.f14233e) {
            i3 = JsonUtils.getInt(this.f14231c, str, i2);
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    public long b(String str, long j2) {
        long j3;
        synchronized (this.f14233e) {
            j3 = JsonUtils.getLong(this.f14231c, str, j2);
        }
        return j3;
    }

    /* access modifiers changed from: protected */
    public Boolean b(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f14233e) {
            bool2 = JsonUtils.getBoolean(this.f14231c, str, bool);
        }
        return bool2;
    }

    /* access modifiers changed from: protected */
    public String b(String str, String str2) {
        String string;
        synchronized (this.f14233e) {
            string = JsonUtils.getString(this.f14231c, str, str2);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f14233e) {
            jSONArray2 = JsonUtils.getJSONArray(this.f14231c, str, jSONArray);
        }
        return jSONArray2;
    }

    /* access modifiers changed from: protected */
    public boolean b(String str) {
        boolean has;
        synchronized (this.f14233e) {
            has = this.f14231c.has(str);
        }
        return has;
    }

    /* access modifiers changed from: protected */
    public Object c(String str) {
        Object opt;
        synchronized (this.f14233e) {
            opt = this.f14231c.opt(str);
        }
        return opt;
    }

    /* access modifiers changed from: protected */
    public void c(String str, int i2) {
        synchronized (this.f14233e) {
            JsonUtils.putInt(this.f14231c, str, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void c(String str, long j2) {
        synchronized (this.f14233e) {
            JsonUtils.putLong(this.f14231c, str, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void c(String str, String str2) {
        synchronized (this.f14233e) {
            JsonUtils.putString(this.f14231c, str, str2);
        }
    }

    public void d(String str) {
        this.f14235g = str;
    }

    public void e(String str) {
        this.f14236h = str;
    }

    public List<String> f(String str) {
        if (str != null) {
            JSONArray a2 = a(str, new JSONArray());
            List list = Collections.EMPTY_LIST;
            List optList = JsonUtils.optList(a2, list);
            List optList2 = JsonUtils.optList(b(str, new JSONArray()), list);
            ArrayList arrayList = new ArrayList(optList.size() + optList2.size());
            arrayList.addAll(optList);
            arrayList.addAll(optList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public String g(String str) {
        String b2 = b(str, "");
        return StringUtils.isValidString(b2) ? b2 : a(str, "");
    }

    public String getAdUnitId() {
        return a("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.f14235g;
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + K() + "', adapterName='" + L() + "', isTesting=" + N() + '}';
    }
}

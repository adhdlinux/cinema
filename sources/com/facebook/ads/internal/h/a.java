package com.facebook.ads.internal.h;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f20172a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f20173b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<e, List<String>> f20174c = new HashMap();

    public a(String str, JSONObject jSONObject, JSONArray jSONArray) {
        this.f20172a = str;
        this.f20173b = jSONObject;
        if (jSONArray != null && jSONArray.length() != 0) {
            for (e put : e.values()) {
                this.f20174c.put(put, new LinkedList());
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("type");
                    String string2 = jSONObject2.getString(ImagesContract.URL);
                    e valueOf = e.valueOf(string.toUpperCase(Locale.US));
                    if (valueOf != null && !TextUtils.isEmpty(string2)) {
                        this.f20174c.get(valueOf).add(string2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a() {
        return this.f20172a;
    }

    public List<String> a(e eVar) {
        return this.f20174c.get(eVar);
    }

    public JSONObject b() {
        return this.f20173b;
    }
}

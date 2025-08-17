package com.yoku.house.ads.helper;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RemoveJsonObjectCompat extends AsyncTask<JSONArray, JSONArray, JSONArray> {

    /* renamed from: a  reason: collision with root package name */
    private final JSONArray f38019a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38020b;

    public RemoveJsonObjectCompat(int i2, JSONArray jSONArray) {
        this.f38019a = jSONArray;
        this.f38020b = i2;
    }

    private List<JSONObject> a(JSONArray jSONArray) {
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(optJSONObject);
            }
        }
        return arrayList;
    }

    private JSONArray c(int i2, JSONArray jSONArray) {
        List<JSONObject> a2 = a(jSONArray);
        a2.remove(i2);
        JSONArray jSONArray2 = new JSONArray();
        for (JSONObject put : a2) {
            jSONArray2.put(put);
        }
        return jSONArray2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONArray doInBackground(JSONArray... jSONArrayArr) {
        return c(this.f38020b, this.f38019a);
    }
}

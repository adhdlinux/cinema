package com.startapp;

import android.text.TextUtils;
import com.startapp.sdk.common.SDKException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ab extends eb {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f34212a = new JSONObject();

    public void a(String str, Object obj, boolean z2, boolean z3) throws SDKException {
        if (z2 && obj == null) {
            throw new SDKException("Required value for key: [" + str + "] is missing", (Throwable) null);
        } else if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            try {
                this.f34212a.put(str, obj);
            } catch (JSONException e2) {
                if (z2) {
                    throw new SDKException("failed converting to json object value: [" + obj + "]", e2);
                }
            }
        }
    }

    public String toString() {
        return this.f34212a.toString();
    }

    public void a(String str, Set<String> set, boolean z2, boolean z3) throws SDKException {
        if (z2 && (set == null || set.size() == 0)) {
            throw new SDKException("Required value for key: [" + str + "] is missing", (Throwable) null);
        } else if (set != null && set.size() > 0) {
            try {
                this.f34212a.put(str, new JSONArray(set));
            } catch (JSONException e2) {
                if (z2) {
                    throw new SDKException("failed converting to json array values: [" + set + "]", e2);
                }
            }
        }
    }
}

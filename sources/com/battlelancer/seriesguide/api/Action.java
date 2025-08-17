package com.battlelancer.seriesguide.api;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

public class Action {

    /* renamed from: a  reason: collision with root package name */
    private String f16068a;

    /* renamed from: b  reason: collision with root package name */
    private Intent f16069b;

    /* renamed from: c  reason: collision with root package name */
    private int f16070c;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16071a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f16072b;

        /* renamed from: c  reason: collision with root package name */
        private int f16073c;

        public Builder(String str, int i2) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("Title may not be null or empty.");
            } else if (i2 > 0) {
                this.f16071a = str;
                this.f16073c = i2;
            } else {
                throw new IllegalArgumentException("Entity identifier may not be negative or zero.");
            }
        }

        public Action a() {
            return new Action(this.f16071a, this.f16072b, this.f16073c);
        }

        public Builder b(Intent intent) {
            this.f16072b = intent;
            return this;
        }
    }

    public static Action a(JSONObject jSONObject) throws JSONException {
        int optInt;
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString) || (optInt = jSONObject.optInt("entityIdentifier")) <= 0) {
            return null;
        }
        Builder builder = new Builder(optString, optInt);
        try {
            String optString2 = jSONObject.optString("viewIntent");
            if (!TextUtils.isEmpty(optString2)) {
                builder.b(Intent.parseUri(optString2, 1));
            }
        } catch (URISyntaxException unused) {
        }
        return builder.a();
    }

    public Bundle b() {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f16068a);
        Intent intent = this.f16069b;
        if (intent != null) {
            str = intent.toUri(1);
        } else {
            str = null;
        }
        bundle.putString("viewIntent", str);
        bundle.putInt("entityIdentifier", this.f16070c);
        return bundle;
    }

    public JSONObject c() throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", this.f16068a);
        Intent intent = this.f16069b;
        if (intent != null) {
            str = intent.toUri(1);
        } else {
            str = null;
        }
        jSONObject.put("viewIntent", str);
        jSONObject.put("entityIdentifier", this.f16070c);
        return jSONObject;
    }

    private Action(String str, Intent intent, int i2) {
        this.f16068a = str;
        this.f16069b = intent;
        this.f16070c = i2;
    }
}

package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final m f15090a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15091b;

    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        

        /* renamed from: d  reason: collision with root package name */
        private final String f15096d;

        private a(String str) {
            this.f15096d = str;
        }

        public String toString() {
            return this.f15096d;
        }
    }

    public c(String str, m mVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (mVar != null) {
            this.f15091b = str;
            this.f15090a = mVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    private String a(b<String> bVar) {
        for (String next : this.f15090a.b(bVar)) {
            if (this.f15091b.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    public String a() {
        return this.f15091b;
    }

    public a b() {
        return a(b.ba) != null ? a.REGULAR : a(b.bb) != null ? a.AD_RESPONSE_JSON : a.UNSPECIFIED;
    }

    public String c() {
        String a2 = a(b.ba);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String a3 = a(b.bb);
        if (!TextUtils.isEmpty(a3)) {
            return a3;
        }
        return null;
    }

    public JSONObject d() {
        if (b() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f15091b.substring(c().length()), 0), "UTF-8"));
                if (v.a()) {
                    v A = this.f15090a.A();
                    A.b("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (!v.a()) {
                    return null;
                }
                v A2 = this.f15090a.A();
                A2.b("AdToken", "Unable to decode token '" + this.f15091b + "' into JSON", e2);
                return null;
            }
        } catch (UnsupportedEncodingException e3) {
            if (!v.a()) {
                return null;
            }
            v A3 = this.f15090a.A();
            A3.b("AdToken", "Unable to process ad response from token '" + this.f15091b + "'", e3);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        String str = this.f15091b;
        String str2 = ((c) obj).f15091b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f15091b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String prefixToIndex = StringUtils.prefixToIndex(32, this.f15091b);
        return "AdToken{id=" + prefixToIndex + ", type=" + b() + '}';
    }
}

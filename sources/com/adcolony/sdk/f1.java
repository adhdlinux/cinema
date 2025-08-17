package com.adcolony.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class f1 {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f13126a;

    f1() {
        this(new JSONObject());
    }

    private Iterator<String> s() {
        return this.f13126a.keys();
    }

    /* access modifiers changed from: package-private */
    public Integer A(String str) {
        Integer valueOf;
        try {
            synchronized (this.f13126a) {
                valueOf = Integer.valueOf(this.f13126a.getInt(str));
            }
            return valueOf;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int B(String str) {
        int optInt;
        synchronized (this.f13126a) {
            optInt = this.f13126a.optInt(str);
        }
        return optInt;
    }

    /* access modifiers changed from: package-private */
    public e1 C(String str) {
        e1 e1Var;
        synchronized (this.f13126a) {
            JSONArray optJSONArray = this.f13126a.optJSONArray(str);
            if (optJSONArray != null) {
                e1Var = new e1(optJSONArray);
            } else {
                e1Var = new e1();
            }
        }
        return e1Var;
    }

    /* access modifiers changed from: package-private */
    public e1 D(String str) {
        e1 e1Var;
        synchronized (this.f13126a) {
            JSONArray optJSONArray = this.f13126a.optJSONArray(str);
            if (optJSONArray != null) {
                e1Var = new e1(optJSONArray);
            } else {
                e1Var = null;
            }
        }
        return e1Var;
    }

    /* access modifiers changed from: package-private */
    public f1 E(String str) {
        f1 f1Var;
        synchronized (this.f13126a) {
            JSONObject optJSONObject = this.f13126a.optJSONObject(str);
            if (optJSONObject != null) {
                f1Var = new f1(optJSONObject);
            } else {
                f1Var = new f1();
            }
        }
        return f1Var;
    }

    /* access modifiers changed from: package-private */
    public f1 F(String str) {
        f1 f1Var;
        synchronized (this.f13126a) {
            JSONObject optJSONObject = this.f13126a.optJSONObject(str);
            if (optJSONObject != null) {
                f1Var = new f1(optJSONObject);
            } else {
                f1Var = null;
            }
        }
        return f1Var;
    }

    /* access modifiers changed from: package-private */
    public Object G(String str) {
        Object obj;
        synchronized (this.f13126a) {
            if (this.f13126a.isNull(str)) {
                obj = null;
            } else {
                obj = this.f13126a.opt(str);
            }
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public String H(String str) {
        String optString;
        synchronized (this.f13126a) {
            optString = this.f13126a.optString(str);
        }
        return optString;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String I(java.lang.String r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = r2.f13126a
            monitor-enter(r0)
            org.json.JSONObject r1 = r2.f13126a     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.isNull(r3)     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0021
            org.json.JSONObject r1 = r2.f13126a     // Catch:{ all -> 0x0024 }
            java.lang.Object r3 = r1.opt(r3)     // Catch:{ all -> 0x0024 }
            boolean r1 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0019
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x0019:
            if (r3 == 0) goto L_0x0021
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            r3 = 0
            return r3
        L_0x0024:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.f1.I(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void J(String str) {
        synchronized (this.f13126a) {
            this.f13126a.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public double a(String str, double d2) {
        double optDouble;
        synchronized (this.f13126a) {
            optDouble = this.f13126a.optDouble(str, d2);
        }
        return optDouble;
    }

    /* access modifiers changed from: package-private */
    public int b(String str, int i2) {
        int optInt;
        synchronized (this.f13126a) {
            optInt = this.f13126a.optInt(str, i2);
        }
        return optInt;
    }

    /* access modifiers changed from: package-private */
    public long c(String str, long j2) {
        long optLong;
        synchronized (this.f13126a) {
            optLong = this.f13126a.optLong(str, j2);
        }
        return optLong;
    }

    /* access modifiers changed from: package-private */
    public f1 d(String str, e1 e1Var) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, e1Var.c());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 e(String str, f1 f1Var) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, f1Var.g());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 f(String str, String str2) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, str2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public JSONObject g() {
        return this.f13126a;
    }

    /* access modifiers changed from: package-private */
    public void h(e1 e1Var) {
        synchronized (this.f13126a) {
            Iterator<String> s2 = s();
            while (s2.hasNext()) {
                if (!e1Var.d(s2.next())) {
                    s2.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(f1 f1Var) {
        if (f1Var != null) {
            synchronized (this.f13126a) {
                synchronized (f1Var.f13126a) {
                    Iterator<String> s2 = f1Var.s();
                    while (s2.hasNext()) {
                        String next = s2.next();
                        try {
                            this.f13126a.put(next, f1Var.f13126a.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j(String str) {
        boolean z2;
        synchronized (this.f13126a) {
            Iterator<String> s2 = s();
            while (true) {
                if (s2.hasNext()) {
                    if (str.equals(s2.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean k(String str, boolean z2) {
        boolean optBoolean;
        synchronized (this.f13126a) {
            optBoolean = this.f13126a.optBoolean(str, z2);
        }
        return optBoolean;
    }

    /* access modifiers changed from: package-private */
    public int l(String str) throws JSONException {
        int i2;
        synchronized (this.f13126a) {
            i2 = this.f13126a.getInt(str);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public f1 m(String str, double d2) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, d2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 n(String str, int i2) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, i2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 o(String str, long j2) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, j2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 p(String str, boolean z2) throws JSONException {
        synchronized (this.f13126a) {
            this.f13126a.put(str, z2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return u() == 0;
    }

    /* access modifiers changed from: package-private */
    public e1 r(String str) throws JSONException {
        e1 e1Var;
        synchronized (this.f13126a) {
            e1Var = new e1(this.f13126a.getJSONArray(str));
        }
        return e1Var;
    }

    /* access modifiers changed from: package-private */
    public boolean t(String str, int i2) throws JSONException {
        synchronized (this.f13126a) {
            if (this.f13126a.has(str)) {
                return false;
            }
            this.f13126a.put(str, i2);
            return true;
        }
    }

    public String toString() {
        String jSONObject;
        synchronized (this.f13126a) {
            jSONObject = this.f13126a.toString();
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.f13126a.length();
    }

    /* access modifiers changed from: package-private */
    public long v(String str) throws JSONException {
        long j2;
        synchronized (this.f13126a) {
            j2 = this.f13126a.getLong(str);
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public String w(String str) throws JSONException {
        String string;
        synchronized (this.f13126a) {
            string = this.f13126a.getString(str);
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> x() {
        HashMap hashMap = new HashMap();
        synchronized (this.f13126a) {
            Iterator<String> s2 = s();
            while (s2.hasNext()) {
                String next = s2.next();
                hashMap.put(next, H(next));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public boolean y(String str) {
        boolean optBoolean;
        synchronized (this.f13126a) {
            optBoolean = this.f13126a.optBoolean(str);
        }
        return optBoolean;
    }

    /* access modifiers changed from: package-private */
    public double z(String str) {
        double optDouble;
        synchronized (this.f13126a) {
            optDouble = this.f13126a.optDouble(str);
        }
        return optDouble;
    }

    f1(String str) throws JSONException {
        this(new JSONObject(str));
    }

    f1(Map<?, ?> map) {
        this(new JSONObject(map));
    }

    f1(JSONObject jSONObject) throws NullPointerException {
        jSONObject.getClass();
        this.f13126a = jSONObject;
    }
}

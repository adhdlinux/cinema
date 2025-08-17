package com.adcolony.sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class e1 {

    /* renamed from: a  reason: collision with root package name */
    private final JSONArray f13118a;

    e1() {
        this(new JSONArray());
    }

    /* access modifiers changed from: package-private */
    public e1 a(f1 f1Var) {
        synchronized (this.f13118a) {
            this.f13118a.put(f1Var.g());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public Object b(int i2) throws JSONException {
        return this.f13118a.get(i2);
    }

    /* access modifiers changed from: package-private */
    public JSONArray c() {
        return this.f13118a;
    }

    /* access modifiers changed from: package-private */
    public boolean d(String str) {
        boolean z2;
        synchronized (this.f13118a) {
            z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f13118a.length()) {
                    break;
                } else if (j(i2).equals(str)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f13118a.length();
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) throws JSONException {
        return this.f13118a.getInt(i2);
    }

    /* access modifiers changed from: package-private */
    public e1 g(String str) {
        synchronized (this.f13118a) {
            this.f13118a.put(str);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 h(int i2) {
        f1 f1Var;
        synchronized (this.f13118a) {
            JSONObject optJSONObject = this.f13118a.optJSONObject(i2);
            if (optJSONObject != null) {
                f1Var = new f1(optJSONObject);
            } else {
                f1Var = new f1();
            }
        }
        return f1Var;
    }

    /* access modifiers changed from: package-private */
    public f1[] i() {
        f1[] f1VarArr;
        synchronized (this.f13118a) {
            f1VarArr = new f1[this.f13118a.length()];
            for (int i2 = 0; i2 < this.f13118a.length(); i2++) {
                f1VarArr[i2] = h(i2);
            }
        }
        return f1VarArr;
    }

    /* access modifiers changed from: package-private */
    public String j(int i2) {
        String optString;
        synchronized (this.f13118a) {
            optString = this.f13118a.optString(i2);
        }
        return optString;
    }

    /* access modifiers changed from: package-private */
    public String[] k() {
        String[] strArr;
        synchronized (this.f13118a) {
            strArr = new String[this.f13118a.length()];
            for (int i2 = 0; i2 < this.f13118a.length(); i2++) {
                strArr[i2] = j(i2);
            }
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String l(int r3) {
        /*
            r2 = this;
            org.json.JSONArray r0 = r2.f13118a
            monitor-enter(r0)
            org.json.JSONArray r1 = r2.f13118a     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.isNull(r3)     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0021
            org.json.JSONArray r1 = r2.f13118a     // Catch:{ all -> 0x0024 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.e1.l(int):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public e1 m(int i2) {
        synchronized (this.f13118a) {
            this.f13118a.put(i2);
        }
        return this;
    }

    public String toString() {
        String jSONArray;
        synchronized (this.f13118a) {
            jSONArray = this.f13118a.toString();
        }
        return jSONArray;
    }

    e1(String str) throws JSONException {
        this(new JSONArray(str));
    }

    e1(JSONArray jSONArray) throws NullPointerException {
        jSONArray.getClass();
        this.f13118a = jSONArray;
    }
}

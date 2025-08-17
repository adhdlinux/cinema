package com.applovin.impl.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final m f15210a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f15211b;

    /* renamed from: c  reason: collision with root package name */
    protected final SharedPreferences f15212c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f15213d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Object f15214e = new Object();

    public c(m mVar) {
        this.f15210a = mVar;
        Context L = mVar.L();
        this.f15211b = L;
        this.f15212c = L.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(b.class.getName());
            Class.forName(a.class.getName());
        } catch (Throwable unused) {
        }
        b();
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    private String e() {
        return "com.applovin.sdk." + Utils.shortenKey(this.f15210a.z()) + ".";
    }

    public <T> b<T> a(String str, b<T> bVar) {
        synchronized (this.f15214e) {
            for (b<T> next : b.c()) {
                if (next.a().equals(str)) {
                    return next;
                }
            }
            return bVar;
        }
    }

    public <T> T a(b<T> bVar) {
        if (bVar != null) {
            synchronized (this.f15214e) {
                Object obj = this.f15213d.get(bVar.a());
                if (obj == null) {
                    T b2 = bVar.b();
                    return b2;
                }
                T a2 = bVar.a(obj);
                return a2;
            }
        }
        throw new IllegalArgumentException("No setting type specified");
    }

    public void a() {
        String e2 = e();
        synchronized (this.f15214e) {
            SharedPreferences.Editor edit = this.f15212c.edit();
            for (b next : b.c()) {
                Object obj = this.f15213d.get(next.a());
                if (obj != null) {
                    this.f15210a.a(e2 + next.a(), obj, edit);
                }
            }
            edit.apply();
        }
    }

    public <T> void a(b<?> bVar, Object obj) {
        if (bVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.f15214e) {
                this.f15213d.put(bVar.a(), obj);
            }
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    public void a(JSONObject jSONObject) {
        v A;
        String str;
        String str2;
        synchronized (this.f15214e) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        b<Long> a2 = a(next, (b) null);
                        if (a2 != null) {
                            this.f15213d.put(a2.a(), a(next, jSONObject, a2.b()));
                            if (a2 == b.er) {
                                this.f15213d.put(b.es.a(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e2) {
                        th = e2;
                        if (v.a()) {
                            A = this.f15210a.A();
                            str = "SettingsManager";
                            str2 = "Unable to parse JSON settingsValues array";
                            A.b(str, str2, th);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (v.a()) {
                            A = this.f15210a.A();
                            str = "SettingsManager";
                            str2 = "Unable to convert setting object ";
                            A.b(str, str2, th);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.c.b<java.lang.String>, com.applovin.impl.sdk.c.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> b(com.applovin.impl.sdk.c.b<java.lang.String> r1) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = com.applovin.impl.sdk.utils.CollectionUtils.explode(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.c.c.b(com.applovin.impl.sdk.c.b):java.util.List");
    }

    public void b() {
        String e2 = e();
        synchronized (this.f15214e) {
            for (b next : b.c()) {
                try {
                    Object a2 = this.f15210a.a(e2 + next.a(), null, next.b().getClass(), this.f15212c);
                    if (a2 != null) {
                        this.f15213d.put(next.a(), a2);
                    }
                } catch (Exception e3) {
                    if (v.a()) {
                        v A = this.f15210a.A();
                        A.b("SettingsManager", "Unable to load \"" + next.a() + "\"", e3);
                    }
                }
            }
        }
    }

    public List<MaxAdFormat> c(b<String> bVar) {
        ArrayList arrayList = new ArrayList(6);
        for (String formatFromString : b(bVar)) {
            arrayList.add(MaxAdFormat.formatFromString(formatFromString));
        }
        return arrayList;
    }

    public void c() {
        synchronized (this.f15214e) {
            this.f15213d.clear();
        }
        this.f15210a.a(this.f15212c);
    }

    public boolean d() {
        return this.f15210a.p().isVerboseLoggingEnabled() || ((Boolean) a(b.ab)).booleanValue();
    }
}

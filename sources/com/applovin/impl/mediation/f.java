package com.applovin.impl.mediation;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, g> f14800a = Collections.synchronizedMap(new HashMap(16));

    /* renamed from: b  reason: collision with root package name */
    private final m f14801b;

    /* renamed from: c  reason: collision with root package name */
    private final v f14802c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f14803d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Class<? extends MaxAdapter>> f14804e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Set<String> f14805f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final Object f14806g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private final Set<a> f14807h = new HashSet();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f14808a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14809b;

        /* renamed from: c  reason: collision with root package name */
        private final MaxAdFormat f14810c;

        /* renamed from: d  reason: collision with root package name */
        private final JSONObject f14811d;

        a(String str, String str2, com.applovin.impl.mediation.a.a aVar, m mVar) {
            this.f14808a = str;
            this.f14809b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f14811d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (aVar != null) {
                this.f14810c = aVar.getFormat();
                if (aVar.getFormat() != null) {
                    JsonUtils.putString(jSONObject, "format", aVar.getFormat().getLabel());
                    return;
                }
                return;
            }
            this.f14810c = null;
        }

        /* access modifiers changed from: package-private */
        public JSONObject a() {
            return this.f14811d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f14808a.equals(aVar.f14808a) || !this.f14809b.equals(aVar.f14809b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.f14810c;
            MaxAdFormat maxAdFormat2 = aVar.f14810c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int hashCode = ((this.f14808a.hashCode() * 31) + this.f14809b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.f14810c;
            return hashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f14808a + '\'' + ", operationTag='" + this.f14809b + '\'' + ", format=" + this.f14810c + '}';
        }
    }

    public f(m mVar) {
        if (mVar != null) {
            this.f14801b = mVar;
            this.f14802c = mVar.A();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private g a(com.applovin.impl.mediation.a.f fVar, Class<? extends MaxAdapter> cls, boolean z2) {
        try {
            return new g(fVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.f14801b.Y()}), z2, this.f14801b);
        } catch (Throwable th) {
            if (!v.a()) {
                return null;
            }
            v.c("MediationAdapterManager", "Failed to load adapter: " + fVar, th);
            return null;
        }
    }

    private Class<? extends MaxAdapter> a(String str) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return cls2.asSubclass(cls);
            }
            if (!v.a()) {
                return null;
            }
            v.i("MediationAdapterManager", str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public g a(com.applovin.impl.mediation.a.f fVar) {
        return a(fVar, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ca, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0114, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.impl.mediation.g a(com.applovin.impl.mediation.a.f r10, boolean r11) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0118
            java.lang.String r0 = r10.L()
            java.lang.String r1 = r10.K()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 0
            if (r2 == 0) goto L_0x0035
            boolean r10 = com.applovin.impl.sdk.v.a()
            if (r10 == 0) goto L_0x0034
            com.applovin.impl.sdk.v r10 = r9.f14802c
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "No adapter name provided for "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = ", not loading the adapter "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.e(r11, r0)
        L_0x0034:
            return r3
        L_0x0035:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x005f
            boolean r10 = com.applovin.impl.sdk.v.a()
            if (r10 == 0) goto L_0x005e
            com.applovin.impl.sdk.v r10 = r9.f14802c
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to find default className for '"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "'"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.e(r11, r0)
        L_0x005e:
            return r3
        L_0x005f:
            if (r11 == 0) goto L_0x006c
            java.util.Map<java.lang.String, com.applovin.impl.mediation.g> r2 = r9.f14800a
            java.lang.Object r2 = r2.get(r1)
            com.applovin.impl.mediation.g r2 = (com.applovin.impl.mediation.g) r2
            if (r2 == 0) goto L_0x006c
            return r2
        L_0x006c:
            java.lang.Object r2 = r9.f14803d
            monitor-enter(r2)
            java.util.Set<java.lang.String> r4 = r9.f14805f     // Catch:{ all -> 0x0115 }
            boolean r4 = r4.contains(r1)     // Catch:{ all -> 0x0115 }
            if (r4 != 0) goto L_0x00f0
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r4 = r9.f14804e     // Catch:{ all -> 0x0115 }
            boolean r4 = r4.containsKey(r1)     // Catch:{ all -> 0x0115 }
            if (r4 == 0) goto L_0x0088
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r4 = r9.f14804e     // Catch:{ all -> 0x0115 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0115 }
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ all -> 0x0115 }
            goto L_0x0095
        L_0x0088:
            java.lang.Class r4 = r9.a((java.lang.String) r1)     // Catch:{ all -> 0x0115 }
            if (r4 != 0) goto L_0x0095
            java.util.Set<java.lang.String> r10 = r9.f14805f     // Catch:{ all -> 0x0115 }
            r10.add(r1)     // Catch:{ all -> 0x0115 }
            monitor-exit(r2)     // Catch:{ all -> 0x0115 }
            return r3
        L_0x0095:
            com.applovin.impl.mediation.g r5 = r9.a((com.applovin.impl.mediation.a.f) r10, (java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>) r4, (boolean) r11)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x00cb
            boolean r3 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0115 }
            if (r3 == 0) goto L_0x00b9
            com.applovin.impl.sdk.v r3 = r9.f14802c     // Catch:{ all -> 0x0115 }
            java.lang.String r6 = "MediationAdapterManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r7.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r8 = "Loaded "
            r7.append(r8)     // Catch:{ all -> 0x0115 }
            r7.append(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0115 }
            r3.b(r6, r0)     // Catch:{ all -> 0x0115 }
        L_0x00b9:
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r0 = r9.f14804e     // Catch:{ all -> 0x0115 }
            r0.put(r1, r4)     // Catch:{ all -> 0x0115 }
            if (r11 == 0) goto L_0x00c9
            java.util.Map<java.lang.String, com.applovin.impl.mediation.g> r11 = r9.f14800a     // Catch:{ all -> 0x0115 }
            java.lang.String r10 = r10.K()     // Catch:{ all -> 0x0115 }
            r11.put(r10, r5)     // Catch:{ all -> 0x0115 }
        L_0x00c9:
            monitor-exit(r2)     // Catch:{ all -> 0x0115 }
            return r5
        L_0x00cb:
            boolean r10 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0115 }
            if (r10 == 0) goto L_0x00e9
            com.applovin.impl.sdk.v r10 = r9.f14802c     // Catch:{ all -> 0x0115 }
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r4.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = "Failed to load "
            r4.append(r5)     // Catch:{ all -> 0x0115 }
            r4.append(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0115 }
            r10.e(r11, r0)     // Catch:{ all -> 0x0115 }
        L_0x00e9:
            java.util.Set<java.lang.String> r10 = r9.f14805f     // Catch:{ all -> 0x0115 }
            r10.add(r1)     // Catch:{ all -> 0x0115 }
            monitor-exit(r2)     // Catch:{ all -> 0x0115 }
            return r3
        L_0x00f0:
            boolean r10 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0115 }
            if (r10 == 0) goto L_0x0113
            com.applovin.impl.sdk.v r10 = r9.f14802c     // Catch:{ all -> 0x0115 }
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r1.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r4 = "Not attempting to load "
            r1.append(r4)     // Catch:{ all -> 0x0115 }
            r1.append(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = " due to prior errors"
            r1.append(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0115 }
            r10.b(r11, r0)     // Catch:{ all -> 0x0115 }
        L_0x0113:
            monitor-exit(r2)     // Catch:{ all -> 0x0115 }
            return r3
        L_0x0115:
            r10 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0115 }
            throw r10
        L_0x0118:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "No adapter spec specified"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.f.a(com.applovin.impl.mediation.a.f, boolean):com.applovin.impl.mediation.g");
    }

    public Collection<String> a() {
        Set unmodifiableSet;
        synchronized (this.f14803d) {
            HashSet hashSet = new HashSet(this.f14804e.size());
            for (Class<? extends MaxAdapter> name : this.f14804e.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    public void a(String str, String str2, com.applovin.impl.mediation.a.a aVar) {
        synchronized (this.f14806g) {
            if (v.a()) {
                v A = this.f14801b.A();
                A.e("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.f14807h.add(new a(str, str2, aVar, this.f14801b));
        }
    }

    public Collection<String> b() {
        Set<T> unmodifiableSet;
        synchronized (this.f14803d) {
            unmodifiableSet = Collections.unmodifiableSet(this.f14805f);
        }
        return unmodifiableSet;
    }

    public Collection<JSONObject> c() {
        ArrayList arrayList;
        synchronized (this.f14806g) {
            arrayList = new ArrayList(this.f14807h.size());
            for (a a2 : this.f14807h) {
                arrayList.add(a2.a());
            }
        }
        return arrayList;
    }
}

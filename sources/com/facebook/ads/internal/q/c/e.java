package com.facebook.ads.internal.q.c;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.ads.internal.p.a.n;
import com.facebook.ads.internal.q.a.k;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e extends AsyncTask<String, Void, f> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20733a = "e";

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f20734b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20735c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f20736d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f20737e;

    /* renamed from: f  reason: collision with root package name */
    private n f20738f;

    /* renamed from: g  reason: collision with root package name */
    private a f20739g;

    public interface a {
        void a();

        void a(f fVar);
    }

    static {
        HashSet hashSet = new HashSet();
        f20734b = hashSet;
        hashSet.add("#");
        hashSet.add("null");
    }

    public e(Context context) {
        this(context, (Map<String, String>) null, (Map<String, String>) null);
    }

    public e(Context context, Map<String, String> map) {
        this(context, map, (Map<String, String>) null);
    }

    public e(Context context, Map<String, String> map, Map<String, String> map2) {
        this.f20735c = context;
        HashMap hashMap = null;
        this.f20736d = map != null ? new HashMap(map) : null;
        this.f20737e = map2 != null ? new HashMap(map2) : hashMap;
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String str4 = "?";
        if (str.contains(str4)) {
            str4 = "&";
        }
        return str + str4 + str2 + "=" + URLEncoder.encode(str3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.f20735c
            com.facebook.ads.internal.p.a.a r0 = com.facebook.ads.internal.q.c.d.a(r0)
            r1 = 0
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.f20737e     // Catch:{ Exception -> 0x0037 }
            if (r2 == 0) goto L_0x0023
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037 }
            if (r2 != 0) goto L_0x0012
            goto L_0x0023
        L_0x0012:
            com.facebook.ads.internal.p.a.p r2 = new com.facebook.ads.internal.p.a.p     // Catch:{ Exception -> 0x0037 }
            r2.<init>()     // Catch:{ Exception -> 0x0037 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r5.f20737e     // Catch:{ Exception -> 0x0037 }
            r2.a((java.util.Map<? extends java.lang.String, ? extends java.lang.String>) r3)     // Catch:{ Exception -> 0x0037 }
            com.facebook.ads.internal.p.a.n r0 = r0.b(r6, r2)     // Catch:{ Exception -> 0x0037 }
        L_0x0020:
            r5.f20738f = r0     // Catch:{ Exception -> 0x0037 }
            goto L_0x0029
        L_0x0023:
            r2 = 0
            com.facebook.ads.internal.p.a.n r0 = r0.a((java.lang.String) r6, (com.facebook.ads.internal.p.a.p) r2)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0020
        L_0x0029:
            com.facebook.ads.internal.p.a.n r0 = r5.f20738f     // Catch:{ Exception -> 0x0037 }
            if (r0 == 0) goto L_0x0036
            int r6 = r0.a()     // Catch:{ Exception -> 0x0037 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto L_0x0036
            r1 = 1
        L_0x0036:
            return r1
        L_0x0037:
            r0 = move-exception
            java.lang.String r2 = f20733a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error opening url: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            android.util.Log.e(r2, r6, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.c.e.a(java.lang.String):boolean");
    }

    private String b(String str) {
        try {
            return a(str, "analog", k.a(com.facebook.ads.internal.g.a.a()));
        } catch (Exception unused) {
            return str;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public f doInBackground(String... strArr) {
        String str = strArr[0];
        if (!TextUtils.isEmpty(str) && !f20734b.contains(str)) {
            String b2 = b(str);
            Map<String, String> map = this.f20736d;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : this.f20736d.entrySet()) {
                    b2 = a(b2, (String) next.getKey(), (String) next.getValue());
                }
            }
            int i2 = 1;
            while (true) {
                int i3 = i2 + 1;
                if (i2 > 2) {
                    break;
                } else if (a(b2)) {
                    return new f(this.f20738f);
                } else {
                    i2 = i3;
                }
            }
        }
        return null;
    }

    public void a(a aVar) {
        this.f20739g = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(f fVar) {
        a aVar = this.f20739g;
        if (aVar != null) {
            aVar.a(fVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        a aVar = this.f20739g;
        if (aVar != null) {
            aVar.a();
        }
    }
}

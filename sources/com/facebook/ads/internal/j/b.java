package com.facebook.ads.internal.j;

import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final List<a> f20234a = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r0 = new org.json.JSONArray();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r1.hasNext() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r0.put(((com.facebook.ads.internal.j.a) r1.next()).a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        return r0.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            java.util.List<com.facebook.ads.internal.j.a> r0 = f20234a
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x000d
            java.lang.String r1 = ""
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r1
        L_0x000d:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0038 }
            r1.<init>(r0)     // Catch:{ all -> 0x0038 }
            r0.clear()     // Catch:{ all -> 0x0038 }
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x001f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r1.next()
            com.facebook.ads.internal.j.a r2 = (com.facebook.ads.internal.j.a) r2
            org.json.JSONObject r2 = r2.a()
            r0.put(r2)
            goto L_0x001f
        L_0x0033:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0038:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.j.b.a():java.lang.String");
    }

    public static void a(a aVar) {
        List<a> list = f20234a;
        synchronized (list) {
            list.add(aVar);
        }
    }
}

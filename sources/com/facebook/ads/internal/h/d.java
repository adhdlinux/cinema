package com.facebook.ads.internal.h;

import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.joda.time.DateTimeConstants;
import org.json.JSONObject;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static final String f20184c = "d";

    /* renamed from: d  reason: collision with root package name */
    private static final AdPlacementType f20185d = AdPlacementType.UNKNOWN;

    /* renamed from: a  reason: collision with root package name */
    public int f20186a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f20187b = -1;

    /* renamed from: e  reason: collision with root package name */
    private final long f20188e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    private AdPlacementType f20189f = f20185d;

    /* renamed from: g  reason: collision with root package name */
    private int f20190g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f20191h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f20192i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f20193j = 20;

    /* renamed from: k  reason: collision with root package name */
    private int f20194k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f20195l = 1000;

    /* renamed from: m  reason: collision with root package name */
    private int f20196m = 10000;

    /* renamed from: n  reason: collision with root package name */
    private int f20197n = 200;

    /* renamed from: o  reason: collision with root package name */
    private int f20198o = DateTimeConstants.SECONDS_PER_HOUR;

    /* renamed from: p  reason: collision with root package name */
    private boolean f20199p = false;

    /* renamed from: q  reason: collision with root package name */
    private List<b> f20200q = null;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private d(java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            r10 = this;
            r10.<init>()
            r0 = -1
            r10.f20186a = r0
            r10.f20187b = r0
            com.facebook.ads.internal.protocol.AdPlacementType r1 = f20185d
            r10.f20189f = r1
            r1 = 1
            r10.f20190g = r1
            r2 = 0
            r10.f20191h = r2
            r10.f20192i = r2
            r3 = 20
            r10.f20193j = r3
            r10.f20194k = r2
            r3 = 1000(0x3e8, float:1.401E-42)
            r10.f20195l = r3
            r3 = 10000(0x2710, float:1.4013E-41)
            r10.f20196m = r3
            r3 = 200(0xc8, float:2.8E-43)
            r10.f20197n = r3
            r4 = 3600(0xe10, float:5.045E-42)
            r10.f20198o = r4
            r10.f20199p = r2
            r4 = 0
            r10.f20200q = r4
            long r4 = java.lang.System.currentTimeMillis()
            r10.f20188e = r4
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x003d:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L_0x023f
            java.lang.Object r4 = r11.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            r5.hashCode()
            int r6 = r5.hashCode()
            switch(r6) {
                case -1899431321: goto L_0x00fa;
                case -1561601017: goto L_0x00ee;
                case -856794442: goto L_0x00e2;
                case -726276175: goto L_0x00d6;
                case -634541425: goto L_0x00cb;
                case -553208868: goto L_0x00c0;
                case 3575610: goto L_0x00b5;
                case 700812481: goto L_0x00aa;
                case 858630459: goto L_0x009d;
                case 986744879: goto L_0x0090;
                case 1085444827: goto L_0x0083;
                case 1183549815: goto L_0x0076;
                case 1503616961: goto L_0x0069;
                case 2002133996: goto L_0x005c;
                default: goto L_0x0059;
            }
        L_0x0059:
            r5 = -1
            goto L_0x0105
        L_0x005c:
            java.lang.String r6 = "placement_width"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0065
            goto L_0x0059
        L_0x0065:
            r5 = 13
            goto L_0x0105
        L_0x0069:
            java.lang.String r6 = "placement_height"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0072
            goto L_0x0059
        L_0x0072:
            r5 = 12
            goto L_0x0105
        L_0x0076:
            java.lang.String r6 = "viewability_check_initial_delay"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x007f
            goto L_0x0059
        L_0x007f:
            r5 = 11
            goto L_0x0105
        L_0x0083:
            java.lang.String r6 = "refresh"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x008c
            goto L_0x0059
        L_0x008c:
            r5 = 10
            goto L_0x0105
        L_0x0090:
            java.lang.String r6 = "video_time_polling_interval"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0099
            goto L_0x0059
        L_0x0099:
            r5 = 9
            goto L_0x0105
        L_0x009d:
            java.lang.String r6 = "viewability_check_ticker"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a6
            goto L_0x0059
        L_0x00a6:
            r5 = 8
            goto L_0x0105
        L_0x00aa:
            java.lang.String r6 = "min_viewability_percentage"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00b3
            goto L_0x0059
        L_0x00b3:
            r5 = 7
            goto L_0x0105
        L_0x00b5:
            java.lang.String r6 = "type"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00be
            goto L_0x0059
        L_0x00be:
            r5 = 6
            goto L_0x0105
        L_0x00c0:
            java.lang.String r6 = "cacheable"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00c9
            goto L_0x0059
        L_0x00c9:
            r5 = 5
            goto L_0x0105
        L_0x00cb:
            java.lang.String r6 = "invalidation_duration_in_seconds"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00d4
            goto L_0x0059
        L_0x00d4:
            r5 = 4
            goto L_0x0105
        L_0x00d6:
            java.lang.String r6 = "request_timeout"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00e0
            goto L_0x0059
        L_0x00e0:
            r5 = 3
            goto L_0x0105
        L_0x00e2:
            java.lang.String r6 = "viewability_check_interval"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00ec
            goto L_0x0059
        L_0x00ec:
            r5 = 2
            goto L_0x0105
        L_0x00ee:
            java.lang.String r6 = "refresh_threshold"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00f8
            goto L_0x0059
        L_0x00f8:
            r5 = 1
            goto L_0x0105
        L_0x00fa:
            java.lang.String r6 = "conv_tracking_data"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0104
            goto L_0x0059
        L_0x0104:
            r5 = 0
        L_0x0105:
            switch(r5) {
                case 0: goto L_0x01c8;
                case 1: goto L_0x01ba;
                case 2: goto L_0x01ac;
                case 3: goto L_0x019e;
                case 4: goto L_0x0190;
                case 5: goto L_0x017e;
                case 6: goto L_0x0170;
                case 7: goto L_0x0162;
                case 8: goto L_0x0154;
                case 9: goto L_0x0142;
                case 10: goto L_0x0134;
                case 11: goto L_0x0126;
                case 12: goto L_0x0118;
                case 13: goto L_0x010a;
                default: goto L_0x0108;
            }
        L_0x0108:
            goto L_0x003d
        L_0x010a:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20186a = r4
            goto L_0x003d
        L_0x0118:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20187b = r4
            goto L_0x003d
        L_0x0126:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20194k = r4
            goto L_0x003d
        L_0x0134:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20192i = r4
            goto L_0x003d
        L_0x0142:
            java.lang.Object r4 = r4.getValue()     // Catch:{ NumberFormatException -> 0x0150 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ NumberFormatException -> 0x0150 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0150 }
            r10.f20197n = r4     // Catch:{ NumberFormatException -> 0x0150 }
            goto L_0x003d
        L_0x0150:
            r10.f20197n = r3
            goto L_0x003d
        L_0x0154:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20191h = r4
            goto L_0x003d
        L_0x0162:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20190g = r4
            goto L_0x003d
        L_0x0170:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.internal.protocol.AdPlacementType r4 = com.facebook.ads.internal.protocol.AdPlacementType.fromString(r4)
            r10.f20189f = r4
            goto L_0x003d
        L_0x017e:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r4 = r4.booleanValue()
            r10.f20199p = r4
            goto L_0x003d
        L_0x0190:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20198o = r4
            goto L_0x003d
        L_0x019e:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20196m = r4
            goto L_0x003d
        L_0x01ac:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20195l = r4
            goto L_0x003d
        L_0x01ba:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = java.lang.Integer.parseInt(r4)
            r10.f20193j = r4
            goto L_0x003d
        L_0x01c8:
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            java.util.List r4 = com.facebook.ads.internal.h.b.a(r4)
            r10.f20200q = r4
            android.webkit.CookieManager r4 = android.webkit.CookieManager.getInstance()     // Catch:{ Exception -> 0x0235 }
            boolean r5 = r4.acceptCookie()     // Catch:{ Exception -> 0x0235 }
            r4.setAcceptCookie(r1)     // Catch:{ Exception -> 0x0235 }
            java.util.List<com.facebook.ads.internal.h.b> r6 = r10.f20200q     // Catch:{ Exception -> 0x0235 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0235 }
        L_0x01e5:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0235 }
            if (r7 == 0) goto L_0x0230
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0235 }
            com.facebook.ads.internal.h.b r7 = (com.facebook.ads.internal.h.b) r7     // Catch:{ Exception -> 0x0235 }
            boolean r8 = r7.b()     // Catch:{ Exception -> 0x0235 }
            if (r8 == 0) goto L_0x01e5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235 }
            r8.<init>()     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = r7.f20176b     // Catch:{ Exception -> 0x0235 }
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = "="
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = r7.f20177c     // Catch:{ Exception -> 0x0235 }
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = ";Domain="
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = r7.f20175a     // Catch:{ Exception -> 0x0235 }
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = ";Expires="
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = r7.a()     // Catch:{ Exception -> 0x0235 }
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r9 = ";path=/"
            r8.append(r9)     // Catch:{ Exception -> 0x0235 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0235 }
            java.lang.String r7 = r7.f20175a     // Catch:{ Exception -> 0x0235 }
            r4.setCookie(r7, r8)     // Catch:{ Exception -> 0x0235 }
            goto L_0x01e5
        L_0x0230:
            r4.setAcceptCookie(r5)     // Catch:{ Exception -> 0x0235 }
            goto L_0x003d
        L_0x0235:
            r4 = move-exception
            java.lang.String r5 = f20184c
            java.lang.String r6 = "Failed to set cookie."
            android.util.Log.w(r5, r6, r4)
            goto L_0x003d
        L_0x023f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.h.d.<init>(java.util.Map):void");
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return new d(hashMap);
    }

    public long a() {
        return this.f20188e;
    }

    public AdPlacementType b() {
        return this.f20189f;
    }

    public long c() {
        return (long) (this.f20192i * 1000);
    }

    public long d() {
        return (long) (this.f20193j * 1000);
    }

    public boolean e() {
        return this.f20199p;
    }

    public int f() {
        return this.f20190g;
    }

    public int g() {
        return this.f20191h;
    }

    public int h() {
        return this.f20194k;
    }

    public int i() {
        return this.f20195l;
    }

    public int j() {
        return this.f20196m;
    }

    public int k() {
        return this.f20197n;
    }

    public int l() {
        return this.f20198o * 1000;
    }
}

package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.startapp.sdk.adsbase.remoteconfig.RscMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qe {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35723a;

    /* renamed from: b  reason: collision with root package name */
    public final ua<RscMetadata> f35724b;

    /* renamed from: c  reason: collision with root package name */
    public RscMetadata f35725c;

    /* renamed from: d  reason: collision with root package name */
    public List<ze> f35726d;

    /* renamed from: e  reason: collision with root package name */
    public List<re> f35727e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<ub, Pair<Long, SoftReference<JSONObject>>> f35728f = new WeakHashMap();

    public qe(Context context, ua<RscMetadata> uaVar) {
        this.f35723a = context;
        this.f35724b = uaVar;
    }

    public static JSONArray a(Context context, re reVar) {
        ub ubVar = reVar.f35812a;
        String[] strArr = ubVar.f36664c;
        Object[] objArr = ubVar.f36666e;
        if (strArr.length == objArr.length) {
            int length = strArr.length;
            if (length == 0) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(strArr[i2], objArr[i2]);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (JSONException e2) {
                if (reVar.a(32)) {
                    y8.a(context, (Throwable) e2);
                }
            }
        } else {
            if (reVar.a(512)) {
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "c690e4ef5365d88b";
                y8Var.f36955e = Arrays.toString(strArr) + ", " + Arrays.toString(objArr);
                y8Var.a(context);
            }
            return null;
        }
    }

    public final boolean a(int i2) {
        RscMetadata call = this.f35724b.call();
        if (call == null || !call.d()) {
            call = null;
        }
        return (call == null || (i2 & call.a()) == 0) ? false : true;
    }

    public static boolean a(RscMetadata rscMetadata, int i2) {
        return (rscMetadata == null || (rscMetadata.a() & i2) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a7, code lost:
        r11 = r10.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ae, code lost:
        if (r11 == null) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b1, code lost:
        r12 = r1.f35723a;
        r0 = r11.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01c8, code lost:
        r15 = com.startapp.p.b(a(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01cb, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01d1, code lost:
        if ((r3.a(r11) & r5) != 0) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01d3, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01d5, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01d6, code lost:
        if (r0 != false) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01d8, code lost:
        com.startapp.y8.a(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01dd, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01e3, code lost:
        if ((r3.a(r11) & r6) != 0) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01e5, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01e7, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01e8, code lost:
        if (r0 != false) goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01ea, code lost:
        com.startapp.y8.a(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01ed, code lost:
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01ee, code lost:
        if (r15 != null) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01f1, code lost:
        r0 = r11.h();
        r12 = r11.d();
        r13 = new java.util.ArrayList(java.lang.Math.min(r4.size(), java.lang.Integer.bitCount(r0)));
        r5 = r4.iterator();
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0213, code lost:
        if (r5.hasNext() != false) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0215, code lost:
        r6 = (com.startapp.ze) r5.next();
        r16 = 1 << r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0221, code lost:
        if ((r0 & r16) == 0) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0225, code lost:
        if ((r12 & r16) != 0) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0227, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x022a, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x022c, code lost:
        r13.add(new android.util.Pair(r6, java.lang.Boolean.valueOf(r16)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0238, code lost:
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0242, code lost:
        if (r13.size() >= 1) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0244, code lost:
        r2 = null;
        r5 = 4;
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0250, code lost:
        if (r11.i() != null) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0252, code lost:
        r17 = r11.i().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x025d, code lost:
        r17 = 300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0261, code lost:
        r18 = r11.g();
        r19 = r11.c();
        r20 = r11.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0271, code lost:
        if (r11.e() != null) goto L_0x0273;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0273, code lost:
        r21 = r11.e().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x027e, code lost:
        r21 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0280, code lost:
        r9.add(new com.startapp.re(r15, r13, r17, r18, r19, r20, r21, r3.a(r11)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0292, code lost:
        return a(r3, r4, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0297, code lost:
        return a(r3, (java.util.List<com.startapp.ze>) null, (java.util.List<com.startapp.re>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x029c, code lost:
        return a(r3, (java.util.List<com.startapp.ze>) null, (java.util.List<com.startapp.re>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r4 = r1.f35723a;
        r0 = r3.c();
        r5 = 4;
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r0 == null) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0.length() >= 1) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = com.startapp.p.a(new android.util.JsonReader(new java.io.StringReader(a(r0))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        r4 = new java.util.ArrayList();
        r0 = ((java.util.ArrayList) r0).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        if (r0.hasNext() == false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        r9 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if ((r9 instanceof java.util.Map) != false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        r9 = new com.startapp.ze();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        r9 = (java.util.Map) r9;
        r10 = r9.get("type");
        r9 = r9.get("params");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if ((r10 instanceof java.lang.Number) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r10 = ((java.lang.Number) r10).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r10 == 1) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
        if (r10 == 2) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008e, code lost:
        if (r10 == 3) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        if (r10 == 4) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        if ((r9 instanceof java.util.List) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        r9 = (java.util.List) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        if (r9.size() <= 0) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a0, code lost:
        r10 = com.startapp.z8.a(java.lang.String.valueOf(r9.get(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ac, code lost:
        if (r10 == null) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b2, code lost:
        if (r9.size() <= 1) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r9 = java.lang.String.valueOf(r9.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00be, code lost:
        r9 = new com.startapp.we(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c8, code lost:
        if ((r9 instanceof java.util.Map) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ca, code lost:
        r9 = (java.util.Map) r9;
        r10 = r9.get("action");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d4, code lost:
        if ((r10 instanceof java.lang.String) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        r9 = r9.get("extras");
        r11 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e3, code lost:
        if ((r9 instanceof java.util.Map) == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e5, code lost:
        r9 = ((java.util.Map) r9).entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f3, code lost:
        if (r9.hasNext() == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f5, code lost:
        r12 = (java.util.Map.Entry) r9.next();
        r13 = r12.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0101, code lost:
        if ((r13 instanceof java.lang.String) == false) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0103, code lost:
        r11.put((java.lang.String) r13, java.lang.String.valueOf(r12.getValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0111, code lost:
        r9 = new com.startapp.ve((java.lang.String) r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011b, code lost:
        if ((r9 instanceof java.util.List) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011d, code lost:
        r10 = new java.util.LinkedList();
        r9 = ((java.util.List) r9).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012c, code lost:
        if (r9.hasNext() == false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012e, code lost:
        r11 = r9.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0134, code lost:
        if ((r11 instanceof java.lang.String) == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0136, code lost:
        r11 = com.startapp.z8.a((java.lang.String) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013c, code lost:
        if (r11 == null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013e, code lost:
        r10.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0146, code lost:
        if (r10.size() <= 0) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0148, code lost:
        r9 = new com.startapp.xe(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0150, code lost:
        if ((r9 instanceof java.lang.Number) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0152, code lost:
        r9 = new com.startapp.ue(((java.lang.Number) r9).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015f, code lost:
        r9 = new com.startapp.ze();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0164, code lost:
        r4.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0169, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016e, code lost:
        if (a(r3, 1) != false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0170, code lost:
        com.startapp.y8.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0174, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0175, code lost:
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x017a, code lost:
        if (a(r3, 1) != false) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x017c, code lost:
        com.startapp.y8.a(r4, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017f, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0180, code lost:
        if (r4 == null) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x018a, code lost:
        r0 = r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018e, code lost:
        if (r0 == null) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0198, code lost:
        r9 = new java.util.LinkedList();
        r10 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a5, code lost:
        if (r10.hasNext() != false) goto L_0x01a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x01a1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.startapp.re> a() {
        /*
            r23 = this;
            r1 = r23
            com.startapp.ua<com.startapp.sdk.adsbase.remoteconfig.RscMetadata> r0 = r1.f35724b
            java.lang.Object r0 = r0.call()
            com.startapp.sdk.adsbase.remoteconfig.RscMetadata r0 = (com.startapp.sdk.adsbase.remoteconfig.RscMetadata) r0
            r2 = 0
            if (r0 == 0) goto L_0x0015
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x0015
            r3 = r0
            goto L_0x0016
        L_0x0015:
            r3 = r2
        L_0x0016:
            if (r3 != 0) goto L_0x001d
            java.util.List r0 = r1.a(r2, r2, r2)
            return r0
        L_0x001d:
            monitor-enter(r23)
            com.startapp.sdk.adsbase.remoteconfig.RscMetadata r0 = r1.f35725c     // Catch:{ all -> 0x029d }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x029d }
            if (r0 == 0) goto L_0x002a
            java.util.List<com.startapp.re> r0 = r1.f35727e     // Catch:{ all -> 0x029d }
            monitor-exit(r23)     // Catch:{ all -> 0x029d }
            return r0
        L_0x002a:
            monitor-exit(r23)     // Catch:{ all -> 0x029d }
            android.content.Context r4 = r1.f35723a
            java.lang.String r0 = r3.c()
            r5 = 4
            r6 = 2
            r7 = 0
            r8 = 1
            if (r0 == 0) goto L_0x017f
            int r9 = r0.length()
            if (r9 >= r8) goto L_0x003f
            goto L_0x017f
        L_0x003f:
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x0174 }
            android.util.JsonReader r9 = new android.util.JsonReader     // Catch:{ all -> 0x0169 }
            java.io.StringReader r10 = new java.io.StringReader     // Catch:{ all -> 0x0169 }
            r10.<init>(r0)     // Catch:{ all -> 0x0169 }
            r9.<init>(r10)     // Catch:{ all -> 0x0169 }
            java.util.List r0 = com.startapp.p.a((android.util.JsonReader) r9)     // Catch:{ all -> 0x0169 }
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x005c:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x0180
            java.lang.Object r9 = r0.next()
            boolean r10 = r9 instanceof java.util.Map
            if (r10 != 0) goto L_0x0071
            com.startapp.ze r9 = new com.startapp.ze
            r9.<init>()
            goto L_0x0164
        L_0x0071:
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r10 = "type"
            java.lang.Object r10 = r9.get(r10)
            java.lang.String r11 = "params"
            java.lang.Object r9 = r9.get(r11)
            boolean r11 = r10 instanceof java.lang.Number
            if (r11 == 0) goto L_0x015f
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r10 == r8) goto L_0x014e
            if (r10 == r6) goto L_0x0119
            r11 = 3
            if (r10 == r11) goto L_0x00c6
            if (r10 == r5) goto L_0x0094
            goto L_0x015f
        L_0x0094:
            boolean r10 = r9 instanceof java.util.List
            if (r10 == 0) goto L_0x015f
            java.util.List r9 = (java.util.List) r9
            int r10 = r9.size()
            if (r10 <= 0) goto L_0x015f
            java.lang.Object r10 = r9.get(r7)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            com.startapp.z8 r10 = com.startapp.z8.a(r10)
            if (r10 == 0) goto L_0x015f
            int r11 = r9.size()
            if (r11 <= r8) goto L_0x00bd
            java.lang.Object r9 = r9.get(r8)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            goto L_0x00be
        L_0x00bd:
            r9 = r2
        L_0x00be:
            com.startapp.we r11 = new com.startapp.we
            r11.<init>(r10, r9)
            r9 = r11
            goto L_0x0164
        L_0x00c6:
            boolean r10 = r9 instanceof java.util.Map
            if (r10 == 0) goto L_0x015f
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r10 = "action"
            java.lang.Object r10 = r9.get(r10)
            boolean r11 = r10 instanceof java.lang.String
            if (r11 == 0) goto L_0x015f
            java.lang.String r11 = "extras"
            java.lang.Object r9 = r9.get(r11)
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            boolean r12 = r9 instanceof java.util.Map
            if (r12 == 0) goto L_0x0111
            java.util.Map r9 = (java.util.Map) r9
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x00ef:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x0111
            java.lang.Object r12 = r9.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r13 = r12.getKey()
            boolean r14 = r13 instanceof java.lang.String
            if (r14 == 0) goto L_0x00ef
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r11.put(r13, r12)
            goto L_0x00ef
        L_0x0111:
            com.startapp.ve r9 = new com.startapp.ve
            java.lang.String r10 = (java.lang.String) r10
            r9.<init>(r10, r11)
            goto L_0x0164
        L_0x0119:
            boolean r10 = r9 instanceof java.util.List
            if (r10 == 0) goto L_0x015f
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0128:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0142
            java.lang.Object r11 = r9.next()
            boolean r12 = r11 instanceof java.lang.String
            if (r12 == 0) goto L_0x0128
            java.lang.String r11 = (java.lang.String) r11
            com.startapp.z8 r11 = com.startapp.z8.a(r11)
            if (r11 == 0) goto L_0x0128
            r10.add(r11)
            goto L_0x0128
        L_0x0142:
            int r9 = r10.size()
            if (r9 <= 0) goto L_0x015f
            com.startapp.xe r9 = new com.startapp.xe
            r9.<init>(r10)
            goto L_0x0164
        L_0x014e:
            boolean r10 = r9 instanceof java.lang.Number
            if (r10 == 0) goto L_0x015f
            com.startapp.ue r10 = new com.startapp.ue
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r10.<init>(r9)
            r9 = r10
            goto L_0x0164
        L_0x015f:
            com.startapp.ze r9 = new com.startapp.ze
            r9.<init>()
        L_0x0164:
            r4.add(r9)
            goto L_0x005c
        L_0x0169:
            r0 = move-exception
            boolean r9 = a((com.startapp.sdk.adsbase.remoteconfig.RscMetadata) r3, (int) r8)
            if (r9 == 0) goto L_0x017f
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r0)
            goto L_0x017f
        L_0x0174:
            r0 = move-exception
            r9 = r0
            boolean r0 = a((com.startapp.sdk.adsbase.remoteconfig.RscMetadata) r3, (int) r8)
            if (r0 == 0) goto L_0x017f
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r9)
        L_0x017f:
            r4 = r2
        L_0x0180:
            if (r4 == 0) goto L_0x0298
            int r0 = r4.size()
            if (r0 >= r8) goto L_0x018a
            goto L_0x0298
        L_0x018a:
            java.util.List r0 = r3.b()
            if (r0 == 0) goto L_0x0293
            int r9 = r0.size()
            if (r9 >= r8) goto L_0x0198
            goto L_0x0293
        L_0x0198:
            java.util.LinkedList r9 = new java.util.LinkedList
            r9.<init>()
            java.util.Iterator r10 = r0.iterator()
        L_0x01a1:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x028e
            java.lang.Object r0 = r10.next()
            r11 = r0
            com.startapp.sdk.adsbase.remoteconfig.RscMetadataItem r11 = (com.startapp.sdk.adsbase.remoteconfig.RscMetadataItem) r11
            if (r11 != 0) goto L_0x01b1
            goto L_0x01a1
        L_0x01b1:
            android.content.Context r12 = r1.f35723a
            java.lang.String r0 = r11.a()
            if (r0 == 0) goto L_0x01ed
            int r13 = r0.length()
            if (r13 >= r8) goto L_0x01c0
            goto L_0x01ed
        L_0x01c0:
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x01dc }
            com.startapp.ub r0 = com.startapp.p.b((java.lang.String) r0)     // Catch:{ all -> 0x01ca }
            r15 = r0
            goto L_0x01ee
        L_0x01ca:
            r0 = move-exception
            r13 = r0
            int r0 = r3.a(r11)
            r0 = r0 & r5
            if (r0 == 0) goto L_0x01d5
            r0 = 1
            goto L_0x01d6
        L_0x01d5:
            r0 = 0
        L_0x01d6:
            if (r0 == 0) goto L_0x01ed
            com.startapp.y8.a((android.content.Context) r12, (java.lang.Throwable) r13)
            goto L_0x01ed
        L_0x01dc:
            r0 = move-exception
            r13 = r0
            int r0 = r3.a(r11)
            r0 = r0 & r6
            if (r0 == 0) goto L_0x01e7
            r0 = 1
            goto L_0x01e8
        L_0x01e7:
            r0 = 0
        L_0x01e8:
            if (r0 == 0) goto L_0x01ed
            com.startapp.y8.a((android.content.Context) r12, (java.lang.Throwable) r13)
        L_0x01ed:
            r15 = r2
        L_0x01ee:
            if (r15 != 0) goto L_0x01f1
            goto L_0x01a1
        L_0x01f1:
            int r0 = r11.h()
            int r12 = r11.d()
            java.util.ArrayList r13 = new java.util.ArrayList
            int r14 = r4.size()
            int r5 = java.lang.Integer.bitCount(r0)
            int r5 = java.lang.Math.min(r14, r5)
            r13.<init>(r5)
            java.util.Iterator r5 = r4.iterator()
            r14 = 0
        L_0x020f:
            boolean r16 = r5.hasNext()
            if (r16 == 0) goto L_0x023e
            java.lang.Object r16 = r5.next()
            r6 = r16
            com.startapp.ze r6 = (com.startapp.ze) r6
            int r16 = r8 << r14
            r17 = r0 & r16
            if (r17 == 0) goto L_0x0238
            r16 = r12 & r16
            if (r16 == 0) goto L_0x022a
            r16 = 1
            goto L_0x022c
        L_0x022a:
            r16 = 0
        L_0x022c:
            android.util.Pair r7 = new android.util.Pair
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r16)
            r7.<init>(r6, r2)
            r13.add(r7)
        L_0x0238:
            int r14 = r14 + 1
            r2 = 0
            r6 = 2
            r7 = 0
            goto L_0x020f
        L_0x023e:
            int r0 = r13.size()
            if (r0 >= r8) goto L_0x024a
        L_0x0244:
            r2 = 0
            r5 = 4
            r6 = 2
            r7 = 0
            goto L_0x01a1
        L_0x024a:
            com.startapp.re r0 = new com.startapp.re
            java.lang.Integer r2 = r11.i()
            if (r2 == 0) goto L_0x025d
            java.lang.Integer r2 = r11.i()
            int r2 = r2.intValue()
            r17 = r2
            goto L_0x0261
        L_0x025d:
            r2 = 300(0x12c, float:4.2E-43)
            r17 = 300(0x12c, float:4.2E-43)
        L_0x0261:
            int[] r18 = r11.g()
            java.lang.Integer r19 = r11.c()
            java.lang.Integer r20 = r11.f()
            java.lang.Integer r2 = r11.e()
            if (r2 == 0) goto L_0x027e
            java.lang.Integer r2 = r11.e()
            int r2 = r2.intValue()
            r21 = r2
            goto L_0x0280
        L_0x027e:
            r21 = 0
        L_0x0280:
            int r22 = r3.a(r11)
            r14 = r0
            r16 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            r9.add(r0)
            goto L_0x0244
        L_0x028e:
            java.util.List r0 = r1.a(r3, r4, r9)
            return r0
        L_0x0293:
            java.util.List r0 = r1.a(r3, r2, r2)
            return r0
        L_0x0298:
            java.util.List r0 = r1.a(r3, r2, r2)
            return r0
        L_0x029d:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x029d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.qe.a():java.util.List");
    }

    public final synchronized List<re> a(RscMetadata rscMetadata, List<ze> list, List<re> list2) {
        List<ze> list3 = this.f35726d;
        if (list3 != null) {
            for (ze a2 : list3) {
                try {
                    a2.a(this.f35723a);
                } catch (Throwable th) {
                    if (a(this.f35725c, 64)) {
                        y8.a(this.f35723a, th);
                    }
                }
            }
        }
        this.f35725c = rscMetadata;
        this.f35726d = list;
        this.f35727e = list2;
        if (list != null) {
            for (ze a3 : list) {
                try {
                    a3.a(this.f35723a, this);
                } catch (Throwable th2) {
                    if (a(rscMetadata, 128)) {
                        y8.a(this.f35723a, th2);
                    }
                }
            }
        }
        return list2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        if ((((java.lang.Long) r10.first).longValue() + ((long) (r0 * 1000))) < android.os.SystemClock.elapsedRealtime()) goto L_0x00ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0190 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b1 A[SYNTHETIC, Splitter:B:54:0x00b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.Object r19) {
        /*
            r18 = this;
            r1 = r18
            java.util.List r0 = r18.a()
            r2 = 0
            if (r0 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Iterator r3 = r0.iterator()
            r4 = r2
        L_0x000f:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x01d2
            java.lang.Object r0 = r3.next()
            r5 = r0
            com.startapp.re r5 = (com.startapp.re) r5
            r6 = 2
            r8 = 1
            java.util.List<android.util.Pair<com.startapp.ze, java.lang.Boolean>> r0 = r5.f35813b     // Catch:{ all -> 0x0050 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0050 }
        L_0x0024:
            boolean r9 = r0.hasNext()     // Catch:{ all -> 0x0050 }
            if (r9 == 0) goto L_0x004d
            java.lang.Object r9 = r0.next()     // Catch:{ all -> 0x0050 }
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x0050 }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0050 }
            com.startapp.ze r10 = (com.startapp.ze) r10     // Catch:{ all -> 0x0050 }
            r11 = r19
            boolean r10 = r10.a((java.lang.Object) r11)     // Catch:{ all -> 0x004b }
            if (r10 == 0) goto L_0x0024
            java.lang.Object r0 = r9.second     // Catch:{ all -> 0x004b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0048
            r0 = 2
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            r0 = r0 | r8
            goto L_0x0061
        L_0x004b:
            r0 = move-exception
            goto L_0x0053
        L_0x004d:
            r11 = r19
            goto L_0x0060
        L_0x0050:
            r0 = move-exception
            r11 = r19
        L_0x0053:
            r9 = 256(0x100, float:3.59E-43)
            boolean r9 = r5.a(r9)
            if (r9 == 0) goto L_0x0060
            android.content.Context r9 = r1.f35723a
            com.startapp.y8.a((android.content.Context) r9, (java.lang.Throwable) r0)
        L_0x0060:
            r0 = 0
        L_0x0061:
            r9 = r0 & 1
            if (r9 != 0) goto L_0x0069
            r17 = r3
            goto L_0x0190
        L_0x0069:
            com.startapp.ub r9 = r5.f35812a
            r0 = r0 & 2
            if (r0 != 0) goto L_0x00aa
            int r0 = r5.f35814c
            monitor-enter(r18)
            java.util.Map<com.startapp.ub, android.util.Pair<java.lang.Long, java.lang.ref.SoftReference<org.json.JSONObject>>> r10 = r1.f35728f     // Catch:{ all -> 0x00a7 }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x00a7 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x00a7 }
            monitor-exit(r18)     // Catch:{ all -> 0x00a7 }
            if (r10 != 0) goto L_0x0081
            r12 = r2
            r17 = r3
            goto L_0x00ad
        L_0x0081:
            java.lang.Object r12 = r10.second
            java.lang.ref.SoftReference r12 = (java.lang.ref.SoftReference) r12
            java.lang.Object r12 = r12.get()
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            if (r12 != 0) goto L_0x0090
            r17 = r3
            goto L_0x00a6
        L_0x0090:
            java.lang.Object r10 = r10.first
            java.lang.Long r10 = (java.lang.Long) r10
            long r13 = r10.longValue()
            long r15 = android.os.SystemClock.elapsedRealtime()
            int r0 = r0 * 1000
            r17 = r3
            long r2 = (long) r0
            long r13 = r13 + r2
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ad
        L_0x00a6:
            goto L_0x00ac
        L_0x00a7:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00a7 }
            throw r0
        L_0x00aa:
            r17 = r3
        L_0x00ac:
            r12 = 0
        L_0x00ad:
            r2 = 32
            if (r12 != 0) goto L_0x018e
            android.content.Context r0 = r1.f35723a     // Catch:{ all -> 0x00bd }
            int[] r3 = r5.f35815d     // Catch:{ all -> 0x00bd }
            java.lang.Integer r13 = r5.f35816e     // Catch:{ all -> 0x00bd }
            org.json.JSONArray r0 = r9.a((android.content.Context) r0, (int[]) r3, (java.lang.Integer) r13)     // Catch:{ all -> 0x00bd }
            r3 = r0
            goto L_0x00cc
        L_0x00bd:
            r0 = move-exception
            r3 = 8
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L_0x00cb
            android.content.Context r3 = r1.f35723a
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r0)
        L_0x00cb:
            r3 = 0
        L_0x00cc:
            if (r3 == 0) goto L_0x011f
            java.lang.Integer r0 = r5.f35817f
            if (r0 == 0) goto L_0x011f
            int r0 = r0.intValue()     // Catch:{ all -> 0x0111 }
            if (r0 != r8) goto L_0x00de
            com.startapp.te r0 = new com.startapp.te     // Catch:{ all -> 0x0111 }
            r0.<init>()     // Catch:{ all -> 0x0111 }
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            if (r0 == 0) goto L_0x011f
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x0111 }
            r0.<init>()     // Catch:{ all -> 0x0111 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x0111 }
            int r14 = r3.length()     // Catch:{ all -> 0x0111 }
            r13.<init>(r14)     // Catch:{ all -> 0x0111 }
            int r14 = r3.length()     // Catch:{ all -> 0x0111 }
            r15 = 0
        L_0x00f4:
            if (r15 >= r14) goto L_0x0108
            org.json.JSONObject r7 = r3.getJSONObject(r15)     // Catch:{ all -> 0x0111 }
            if (r7 == 0) goto L_0x0105
            java.lang.String r10 = com.startapp.te.f36589a     // Catch:{ all -> 0x0111 }
            java.lang.String r7 = r7.getString(r10)     // Catch:{ all -> 0x0111 }
            r13.add(r7)     // Catch:{ all -> 0x0111 }
        L_0x0105:
            int r15 = r15 + 1
            goto L_0x00f4
        L_0x0108:
            java.lang.String r7 = com.startapp.p.a((java.util.List<java.lang.String>) r13)     // Catch:{ all -> 0x0111 }
            r0.put(r7)     // Catch:{ all -> 0x0111 }
            r3 = r0
            goto L_0x011f
        L_0x0111:
            r0 = move-exception
            r7 = 2048(0x800, float:2.87E-42)
            boolean r7 = r5.a(r7)
            if (r7 == 0) goto L_0x011f
            android.content.Context r7 = r1.f35723a
            com.startapp.y8.a((android.content.Context) r7, (java.lang.Throwable) r0)
        L_0x011f:
            if (r3 == 0) goto L_0x018e
            int r0 = r3.length()
            if (r0 <= 0) goto L_0x018e
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            int r0 = r5.f35818g     // Catch:{ JSONException -> 0x0165 }
            r0 = r0 & r8
            if (r0 == 0) goto L_0x0133
            r0 = 1
            goto L_0x0134
        L_0x0133:
            r0 = 0
        L_0x0134:
            if (r0 == 0) goto L_0x013f
            java.lang.String r0 = "currentTimeMillis"
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0165 }
            r12.put(r0, r13)     // Catch:{ JSONException -> 0x0165 }
        L_0x013f:
            int r0 = r5.f35818g     // Catch:{ JSONException -> 0x0165 }
            r0 = r0 & r6
            if (r0 == 0) goto L_0x0146
            r7 = 1
            goto L_0x0147
        L_0x0146:
            r7 = 0
        L_0x0147:
            if (r7 == 0) goto L_0x0152
            java.lang.String r0 = "bootTimeMillis"
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x0165 }
            r12.put(r0, r6)     // Catch:{ JSONException -> 0x0165 }
        L_0x0152:
            android.content.Context r0 = r1.f35723a     // Catch:{ JSONException -> 0x0165 }
            org.json.JSONArray r0 = a((android.content.Context) r0, (com.startapp.re) r5)     // Catch:{ JSONException -> 0x0165 }
            if (r0 == 0) goto L_0x015f
            java.lang.String r6 = "params"
            r12.put(r6, r0)     // Catch:{ JSONException -> 0x0165 }
        L_0x015f:
            java.lang.String r0 = "items"
            r12.put(r0, r3)     // Catch:{ JSONException -> 0x0165 }
            goto L_0x0171
        L_0x0165:
            r0 = move-exception
            boolean r3 = r5.a(r2)
            if (r3 == 0) goto L_0x0171
            android.content.Context r3 = r1.f35723a
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r0)
        L_0x0171:
            monitor-enter(r18)
            java.util.Map<com.startapp.ub, android.util.Pair<java.lang.Long, java.lang.ref.SoftReference<org.json.JSONObject>>> r0 = r1.f35728f     // Catch:{ all -> 0x018b }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x018b }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x018b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x018b }
            java.lang.ref.SoftReference r7 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x018b }
            r7.<init>(r12)     // Catch:{ all -> 0x018b }
            r3.<init>(r6, r7)     // Catch:{ all -> 0x018b }
            r0.put(r9, r3)     // Catch:{ all -> 0x018b }
            monitor-exit(r18)
            goto L_0x018e
        L_0x018b:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        L_0x018e:
            if (r12 != 0) goto L_0x0195
        L_0x0190:
            r3 = r17
            r2 = 0
            goto L_0x000f
        L_0x0195:
            if (r4 != 0) goto L_0x019d
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r4 = r0
        L_0x019d:
            java.lang.String r0 = r9.f36662a     // Catch:{ JSONException -> 0x01c5 }
            org.json.JSONObject r0 = r4.optJSONObject(r0)     // Catch:{ JSONException -> 0x01c5 }
            if (r0 != 0) goto L_0x01af
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c5 }
            r0.<init>()     // Catch:{ JSONException -> 0x01c5 }
            java.lang.String r3 = r9.f36662a     // Catch:{ JSONException -> 0x01c5 }
            r4.put(r3, r0)     // Catch:{ JSONException -> 0x01c5 }
        L_0x01af:
            java.lang.String r3 = r9.f36663b     // Catch:{ JSONException -> 0x01c5 }
            org.json.JSONArray r3 = r0.optJSONArray(r3)     // Catch:{ JSONException -> 0x01c5 }
            if (r3 != 0) goto L_0x01c1
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x01c5 }
            r3.<init>()     // Catch:{ JSONException -> 0x01c5 }
            java.lang.String r6 = r9.f36663b     // Catch:{ JSONException -> 0x01c5 }
            r0.put(r6, r3)     // Catch:{ JSONException -> 0x01c5 }
        L_0x01c1:
            r3.put(r12)     // Catch:{ JSONException -> 0x01c5 }
            goto L_0x0190
        L_0x01c5:
            r0 = move-exception
            boolean r2 = r5.a(r2)
            if (r2 == 0) goto L_0x0190
            android.content.Context r2 = r1.f35723a
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r0)
            goto L_0x0190
        L_0x01d2:
            r2 = 0
            if (r4 != 0) goto L_0x01d6
            return r2
        L_0x01d6:
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x01df }
            java.lang.String r2 = com.startapp.lb.c((java.lang.String) r0)     // Catch:{ all -> 0x01df }
            goto L_0x01ed
        L_0x01df:
            r0 = move-exception
            r3 = 16
            boolean r3 = r1.a((int) r3)
            if (r3 == 0) goto L_0x01ed
            android.content.Context r3 = r1.f35723a
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r0)
        L_0x01ed:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.qe.a(java.lang.Object):java.lang.String");
    }

    public static String a(String str) throws IOException {
        byte[] a2 = fc.a(Base64.decode(str, 8));
        Map<Activity, Integer> map = lb.f34876a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream, new Inflater(true));
        inflaterOutputStream.write(a2);
        inflaterOutputStream.close();
        return new String(byteArrayOutputStream.toByteArray());
    }
}

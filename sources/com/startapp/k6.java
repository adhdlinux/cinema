package com.startapp;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.ads.video.vast.VASTResource;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class k6 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f34824a = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});

    /* renamed from: b  reason: collision with root package name */
    public final int f34825b;

    /* renamed from: c  reason: collision with root package name */
    public final float f34826c;

    /* renamed from: d  reason: collision with root package name */
    public a f34827d;

    /* renamed from: e  reason: collision with root package name */
    public VASTErrorCodes f34828e;

    /* renamed from: f  reason: collision with root package name */
    public int f34829f;

    /* renamed from: g  reason: collision with root package name */
    public int f34830g = 10;

    /* renamed from: h  reason: collision with root package name */
    public final Set<f6> f34831h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final String f34832i;

    public interface a {
    }

    public interface b {
    }

    public k6(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f2 = context.getResources().getDisplayMetrics().density;
        f2 = f2 <= 0.0f ? 1.0f : f2;
        float f3 = (float) i2;
        this.f34826c = f3 / ((float) i3);
        this.f34825b = (int) (f3 / f2);
        this.f34832i = ic.a(context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.startapp.i6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: com.startapp.i6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: com.startapp.i6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: com.startapp.i6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.startapp.i6} */
    /* JADX WARNING: type inference failed for: r3v25, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.startapp.j6 r23, com.startapp.g6 r24) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r23.getClass()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "start"
            java.util.List r3 = r0.d(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0018:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x003c
            java.lang.Object r4 = r3.next()
            com.startapp.j6 r4 = (com.startapp.j6) r4
            java.lang.String r4 = r4.d()
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x0018
            com.startapp.l6 r6 = new com.startapp.l6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r4, r5)
            r2.add(r6)
            goto L_0x0018
        L_0x003c:
            java.lang.String r3 = "progress"
            java.util.List r4 = r0.d(r3)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0048:
            boolean r6 = r4.hasNext()
            java.lang.String r7 = "offset"
            if (r6 == 0) goto L_0x008a
            java.lang.Object r6 = r4.next()
            com.startapp.j6 r6 = (com.startapp.j6) r6
            java.lang.String r7 = r6.a(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x0061
            goto L_0x0048
        L_0x0061:
            java.lang.String r7 = r7.trim()
            boolean r8 = com.startapp.l6.a(r7)
            if (r8 == 0) goto L_0x0048
            java.lang.String r6 = r6.d()
            java.lang.Integer r7 = com.startapp.l6.b(r7)
            if (r7 == 0) goto L_0x0048
            int r8 = r7.intValue()
            if (r8 < 0) goto L_0x0048
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0048
            com.startapp.l6 r8 = new com.startapp.l6
            r8.<init>(r6, r7)
            r2.add(r8)
            goto L_0x0048
        L_0x008a:
            java.lang.String r4 = "creativeView"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0096:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00b9
            java.lang.Object r6 = r4.next()
            com.startapp.j6 r6 = (com.startapp.j6) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0096
            com.startapp.l6 r8 = new com.startapp.l6
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x0096
        L_0x00b9:
            java.util.List<com.startapp.l6<java.lang.Integer>> r4 = r1.f34561c
            r4.addAll(r2)
            java.util.List<com.startapp.l6<java.lang.Integer>> r2 = r1.f34561c
            java.util.Collections.sort(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r4 = "firstQuartile"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00d4:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00f9
            java.lang.Object r6 = r4.next()
            com.startapp.j6 r6 = (com.startapp.j6) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x00d4
            com.startapp.l6 r8 = new com.startapp.l6
            r9 = 1048576000(0x3e800000, float:0.25)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x00d4
        L_0x00f9:
            java.lang.String r4 = "midpoint"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0105:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x012a
            java.lang.Object r6 = r4.next()
            com.startapp.j6 r6 = (com.startapp.j6) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0105
            com.startapp.l6 r8 = new com.startapp.l6
            r9 = 1056964608(0x3f000000, float:0.5)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x0105
        L_0x012a:
            java.lang.String r4 = "thirdQuartile"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0136:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x015b
            java.lang.Object r6 = r4.next()
            com.startapp.j6 r6 = (com.startapp.j6) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0136
            com.startapp.l6 r8 = new com.startapp.l6
            r9 = 1061158912(0x3f400000, float:0.75)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x0136
        L_0x015b:
            java.util.List r3 = r0.d(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0165:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01b9
            java.lang.Object r4 = r3.next()
            com.startapp.j6 r4 = (com.startapp.j6) r4
            java.lang.String r6 = r4.a(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x017c
            goto L_0x0165
        L_0x017c:
            java.lang.String r6 = r6.trim()
            java.util.regex.Pattern r8 = com.startapp.l6.f34859b
            java.util.regex.Matcher r8 = r8.matcher(r6)
            boolean r8 = r8.matches()
            if (r8 == 0) goto L_0x0165
            java.lang.String r4 = r4.d()
            java.lang.String r8 = "%"
            java.lang.String r9 = ""
            java.lang.String r6 = r6.replace(r8, r9)     // Catch:{ NumberFormatException -> 0x01b7 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x01b7 }
            r8 = 1120403456(0x42c80000, float:100.0)
            float r6 = r6 / r8
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x0165
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ NumberFormatException -> 0x01b7 }
            if (r8 != 0) goto L_0x0165
            com.startapp.l6 r8 = new com.startapp.l6     // Catch:{ NumberFormatException -> 0x01b7 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ NumberFormatException -> 0x01b7 }
            r8.<init>(r4, r6)     // Catch:{ NumberFormatException -> 0x01b7 }
            r2.add(r8)     // Catch:{ NumberFormatException -> 0x01b7 }
            goto L_0x0165
        L_0x01b7:
            goto L_0x0165
        L_0x01b9:
            java.util.List<com.startapp.l6<java.lang.Float>> r3 = r1.f34562d
            r3.addAll(r2)
            java.util.List<com.startapp.l6<java.lang.Float>> r2 = r1.f34562d
            java.util.Collections.sort(r2)
            java.lang.String r2 = "pause"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f34563e
            r3.addAll(r2)
            java.lang.String r2 = "resume"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f34564f
            r3.addAll(r2)
            java.lang.String r2 = "complete"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f34565g
            r3.addAll(r2)
            java.lang.String r2 = "close"
            java.util.List r2 = r0.e(r2)
            java.lang.String r3 = "closeLinear"
            java.util.List r3 = r0.e(r3)
            r4 = r2
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r4.addAll(r3)
            java.util.List<java.lang.String> r3 = r1.f34566h
            r3.addAll(r2)
            java.lang.String r2 = "skip"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f34569k
            r3.addAll(r2)
            java.lang.String r2 = "ClickTracking"
            java.lang.String r3 = "VideoClicks"
            java.util.List r2 = r0.b(r2, r3)
            java.util.List<java.lang.String> r3 = r1.f34570l
            r3.addAll(r2)
            java.lang.String r2 = "mute"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f34567i
            r3.addAll(r2)
            java.lang.String r2 = "unmute"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f34568j
            r3.addAll(r2)
            java.lang.Integer r2 = r1.f34571m
            r3 = 0
            if (r2 != 0) goto L_0x0258
            java.lang.String r2 = "skipoffset"
            java.lang.String r2 = r0.a(r2)
            if (r2 != 0) goto L_0x0237
            goto L_0x0255
        L_0x0237:
            java.lang.String r4 = r2.trim()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0242
            goto L_0x0255
        L_0x0242:
            boolean r4 = com.startapp.l6.a(r2)
            if (r4 == 0) goto L_0x0255
            java.lang.Integer r2 = com.startapp.l6.b(r2)
            if (r2 == 0) goto L_0x0255
            int r4 = r2.intValue()
            if (r4 < 0) goto L_0x0255
            goto L_0x0256
        L_0x0255:
            r2 = r3
        L_0x0256:
            r1.f34571m = r2
        L_0x0258:
            com.startapp.i6 r2 = r1.f34572n
            if (r2 != 0) goto L_0x0329
            java.lang.String r2 = "Icon"
            java.lang.String r4 = "Icons"
            java.util.List r0 = r0.a(r2, r4, r3, r3)
            com.startapp.sdk.ads.video.vast.VASTResource$Type[] r2 = com.startapp.sdk.ads.video.vast.VASTResource.Type.values()
        L_0x0268:
            r4 = 3
            if (r5 >= r4) goto L_0x0327
            r4 = r2[r5]
            com.startapp.sdk.ads.video.vast.VASTResource$Type r6 = com.startapp.sdk.ads.video.vast.VASTResource.Type.IFRAME_RESOURCE
            if (r4 == r6) goto L_0x0323
            com.startapp.sdk.ads.video.vast.VASTResource$Type r6 = com.startapp.sdk.ads.video.vast.VASTResource.Type.HTML_RESOURCE
            if (r4 != r6) goto L_0x0277
            goto L_0x0323
        L_0x0277:
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x027e:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0323
            java.lang.Object r8 = r6.next()
            com.startapp.j6 r8 = (com.startapp.j6) r8
            java.lang.String r9 = "assetWidth"
            java.lang.Integer r9 = r8.b(r9)
            if (r9 == 0) goto L_0x0293
            goto L_0x0299
        L_0x0293:
            java.lang.String r9 = "width"
            java.lang.Integer r9 = r8.b(r9)
        L_0x0299:
            java.lang.String r10 = "assetHeight"
            java.lang.Integer r10 = r8.b(r10)
            if (r10 == 0) goto L_0x02a2
            goto L_0x02a8
        L_0x02a2:
            java.lang.String r10 = "height"
            java.lang.Integer r10 = r8.b(r10)
        L_0x02a8:
            if (r9 == 0) goto L_0x027e
            int r11 = r9.intValue()
            if (r11 <= 0) goto L_0x027e
            int r11 = r9.intValue()
            r12 = 300(0x12c, float:4.2E-43)
            if (r11 > r12) goto L_0x027e
            if (r10 == 0) goto L_0x027e
            int r11 = r10.intValue()
            if (r11 <= 0) goto L_0x027e
            int r11 = r10.intValue()
            if (r11 <= r12) goto L_0x02c7
            goto L_0x027e
        L_0x02c7:
            int r11 = r9.intValue()
            int r12 = r10.intValue()
            com.startapp.sdk.ads.video.vast.VASTResource r18 = com.startapp.sdk.ads.video.vast.VASTResource.a(r8, r4, r11, r12)
            if (r18 != 0) goto L_0x02d6
            goto L_0x027e
        L_0x02d6:
            com.startapp.i6 r0 = new com.startapp.i6
            int r14 = r9.intValue()
            int r15 = r10.intValue()
            java.lang.String r2 = r8.a(r7)
            if (r2 == 0) goto L_0x02f3
            boolean r4 = com.startapp.l6.a(r2)
            if (r4 == 0) goto L_0x02f3
            java.lang.Integer r2 = com.startapp.l6.b(r2)
            r16 = r2
            goto L_0x02f5
        L_0x02f3:
            r16 = r3
        L_0x02f5:
            java.lang.String r2 = "duration"
            java.lang.String r2 = r8.a(r2)
            if (r2 == 0) goto L_0x0307
            boolean r4 = com.startapp.l6.a(r2)
            if (r4 == 0) goto L_0x0307
            java.lang.Integer r3 = com.startapp.l6.b(r2)
        L_0x0307:
            r17 = r3
            java.lang.String r2 = "IconClickTracking"
            java.lang.String r3 = "IconClicks"
            java.util.List r19 = r8.b(r2, r3)
            java.lang.String r2 = "IconClickThrough"
            java.lang.String r20 = r8.a(r2, r3)
            java.lang.String r2 = "IconViewTracking"
            java.util.List r21 = r8.c(r2)
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            r3 = r0
            goto L_0x0327
        L_0x0323:
            int r5 = r5 + 1
            goto L_0x0268
        L_0x0327:
            r1.f34572n = r3
        L_0x0329:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.k6.a(com.startapp.j6, com.startapp.g6):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.startapp.j6} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.util.List, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v23, types: [java.util.List, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v51 */
    /* JADX WARNING: type inference failed for: r4v52 */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0116, code lost:
        if (r12 != null) goto L_0x0118;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x005a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x01bc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.startapp.g6 a(java.lang.String r21, java.util.List<java.lang.String> r22, com.startapp.k6.b r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            if (r3 == 0) goto L_0x0014
            r4 = r3
            com.startapp.h6 r4 = (com.startapp.h6) r4
            if (r1 == 0) goto L_0x0014
            org.json.JSONArray r4 = r4.f34620c
            r4.put(r1)
        L_0x0014:
            r4 = 0
            com.startapp.j6 r5 = new com.startapp.j6     // Catch:{ Exception -> 0x033a }
            r5.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x033a }
            boolean r1 = r5.f34739b
            java.lang.String r6 = "Error"
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r5.f(r6)
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            if (r1 == 0) goto L_0x0035
            boolean r1 = r5.f34739b
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = r5.f(r6)
            goto L_0x0032
        L_0x0031:
            r1 = r4
        L_0x0032:
            r2.add(r1)
        L_0x0035:
            java.lang.String r1 = "Ad"
            java.util.List r1 = r5.a(r1, r4, r4)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            boolean r5 = r1.isEmpty()
            if (r5 == 0) goto L_0x0056
            int r5 = r22.size()
            if (r5 <= 0) goto L_0x0056
            int r1 = r0.f34829f
            if (r1 <= 0) goto L_0x0050
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r1 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.WrapperNoReponse
            goto L_0x0052
        L_0x0050:
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r1 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.FileNotFound
        L_0x0052:
            r0.a((java.util.List<java.lang.String>) r2, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r1)
            return r4
        L_0x0056:
            java.util.Iterator r1 = r1.iterator()
        L_0x005a:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0338
            java.lang.Object r5 = r1.next()
            com.startapp.j6 r5 = (com.startapp.j6) r5
            java.lang.String r7 = "sequence"
            java.lang.String r7 = r5.a(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            r9 = 2
            if (r8 == 0) goto L_0x0074
            goto L_0x007e
        L_0x0074:
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x007d }
            if (r7 >= r9) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            r7 = 0
            goto L_0x007f
        L_0x007d:
        L_0x007e:
            r7 = 1
        L_0x007f:
            if (r7 != 0) goto L_0x0082
            goto L_0x005a
        L_0x0082:
            java.lang.String r7 = "InLine"
            com.startapp.j6 r7 = r5.b(r7, r4, r4)
            java.lang.String r8 = "Impression"
            if (r7 == 0) goto L_0x023a
            java.util.List r12 = r7.c()
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x0096:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0226
            java.lang.Object r13 = r12.next()
            com.startapp.j6 r13 = (com.startapp.j6) r13
            java.lang.String r14 = "MediaFile"
            java.lang.String r15 = "MediaFiles"
            java.util.List r14 = r13.a(r14, r15, r4, r4)
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.util.Iterator r14 = r14.iterator()
            r15 = -8388608(0xffffffffff800000, float:-Infinity)
            r10 = r4
        L_0x00b3:
            boolean r16 = r14.hasNext()
            java.lang.String r11 = "height"
            java.lang.String r4 = "width"
            if (r16 == 0) goto L_0x01c6
            java.lang.Object r16 = r14.next()
            r9 = r16
            com.startapp.j6 r9 = (com.startapp.j6) r9
            r16 = r1
            java.lang.String r1 = "type"
            java.lang.String r1 = r9.a(r1)
            java.lang.String r18 = r9.d()
            r19 = r12
            java.util.List<java.lang.String> r12 = f34824a
            boolean r12 = r12.contains(r1)
            if (r12 == 0) goto L_0x01b7
            if (r18 != 0) goto L_0x00df
            goto L_0x01b7
        L_0x00df:
            java.lang.Integer r4 = r9.b(r4)
            java.lang.Integer r11 = r9.b(r11)
            java.lang.String r12 = "bitrate"
            java.lang.Integer r12 = r9.b(r12)
            if (r12 == 0) goto L_0x00f2
            r17 = 2
            goto L_0x0118
        L_0x00f2:
            java.lang.String r12 = "minBitrate"
            java.lang.Integer r12 = r9.b(r12)
            java.lang.String r3 = "maxBitrate"
            java.lang.Integer r3 = r9.b(r3)
            if (r12 == 0) goto L_0x0114
            if (r3 == 0) goto L_0x0114
            int r12 = r12.intValue()
            int r3 = r3.intValue()
            int r12 = r12 + r3
            r17 = 2
            int r12 = r12 / 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            goto L_0x0119
        L_0x0114:
            r17 = 2
            if (r12 == 0) goto L_0x0119
        L_0x0118:
            r3 = r12
        L_0x0119:
            if (r4 == 0) goto L_0x01bc
            int r12 = r4.intValue()
            if (r12 <= 0) goto L_0x01bc
            if (r11 == 0) goto L_0x01bc
            int r12 = r11.intValue()
            if (r12 > 0) goto L_0x012b
            goto L_0x01bc
        L_0x012b:
            int r4 = r4.intValue()
            int r11 = r11.intValue()
            float r12 = (float) r4
            float r11 = (float) r11
            float r12 = r12 / r11
            float r11 = r0.f34826c
            float r11 = r11 - r12
            float r11 = java.lang.Math.abs(r11)
            int r12 = r0.f34825b
            int r4 = r12 - r4
            int r4 = r4 / r12
            int r4 = java.lang.Math.abs(r4)
            float r4 = (float) r4
            float r11 = r11 + r4
            if (r3 == 0) goto L_0x0156
            int r4 = r3.intValue()
            if (r4 >= 0) goto L_0x0151
            goto L_0x0156
        L_0x0151:
            int r3 = r3.intValue()
            goto L_0x0157
        L_0x0156:
            r3 = 0
        L_0x0157:
            r4 = 700(0x2bc, float:9.81E-43)
            if (r4 > r3) goto L_0x0161
            r4 = 1500(0x5dc, float:2.102E-42)
            if (r3 > r4) goto L_0x0161
            r3 = 0
            goto L_0x017a
        L_0x0161:
            int r4 = 700 - r3
            int r4 = java.lang.Math.abs(r4)
            float r4 = (float) r4
            r12 = 1143930880(0x442f0000, float:700.0)
            float r4 = r4 / r12
            int r3 = 1500 - r3
            int r3 = java.lang.Math.abs(r3)
            float r3 = (float) r3
            r12 = 1153138688(0x44bb8000, float:1500.0)
            float r3 = r3 / r12
            float r3 = java.lang.Math.min(r4, r3)
        L_0x017a:
            if (r1 != 0) goto L_0x017e
            java.lang.String r1 = ""
        L_0x017e:
            int r4 = r1.hashCode()
            r12 = -1664118616(0xffffffff9ccf90a8, float:-1.3735504E-21)
            if (r4 == r12) goto L_0x0197
            r12 = 1331848029(0x4f62635d, float:3.79816269E9)
            if (r4 == r12) goto L_0x018d
            goto L_0x01a1
        L_0x018d:
            java.lang.String r4 = "video/mp4"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x01a1
            r1 = 0
            goto L_0x01a2
        L_0x0197:
            java.lang.String r4 = "video/3gpp"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x01a1
            r1 = 1
            goto L_0x01a2
        L_0x01a1:
            r1 = -1
        L_0x01a2:
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x01a9
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01ab
        L_0x01a9:
            r1 = 1069547520(0x3fc00000, float:1.5)
        L_0x01ab:
            float r11 = r11 + r4
            float r11 = r11 + r3
            float r4 = r4 / r11
            float r1 = r1 * r4
            int r3 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x01bc
            r15 = r1
            r10 = r9
            goto L_0x01bc
        L_0x01b7:
            r17 = 2
            r14.remove()
        L_0x01bc:
            r3 = r23
            r1 = r16
            r12 = r19
            r4 = 0
            r9 = 2
            goto L_0x00b3
        L_0x01c6:
            r16 = r1
            r19 = r12
            r17 = 2
            if (r10 == 0) goto L_0x021c
            java.lang.String r1 = r10.d()
            if (r1 != 0) goto L_0x01d5
            goto L_0x021c
        L_0x01d5:
            com.startapp.g6 r1 = new com.startapp.g6
            r1.<init>()
            java.util.List r3 = r7.c(r8)
            java.util.List<java.lang.String> r9 = r1.f34560b
            r9.addAll(r3)
            r0.a((com.startapp.j6) r13, (com.startapp.g6) r1)
            java.lang.String r3 = "ClickThrough"
            java.lang.String r9 = "VideoClicks"
            java.lang.String r3 = r13.a(r3, r9)
            r1.f34577s = r3
            java.lang.String r3 = r10.d()
            r1.f34574p = r3
            java.lang.Integer r3 = r10.b(r4)
            r1.f34575q = r3
            java.lang.Integer r3 = r10.b(r11)
            r1.f34576r = r3
            java.util.Set<com.startapp.f6> r3 = r0.f34831h
            java.util.List r4 = r7.a()
            java.util.Set r4 = r0.a((java.util.List<com.startapp.j6>) r4)
            r3.addAll(r4)
            java.util.List r3 = r7.c(r6)
            r2.addAll(r3)
            java.util.List<java.lang.String> r3 = r1.f34559a
            r3.addAll(r2)
            goto L_0x022e
        L_0x021c:
            r3 = r23
            r1 = r16
            r12 = r19
            r4 = 0
            r9 = 2
            goto L_0x0096
        L_0x0226:
            r16 = r1
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r1 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.FileNotFound
            r0.a((java.util.List<java.lang.String>) r2, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r1)
            r1 = 0
        L_0x022e:
            if (r1 == 0) goto L_0x023c
            java.util.List r2 = a((com.startapp.j6) r7)
            java.util.List<com.startapp.sdk.omsdk.VerificationDetails> r3 = r1.f34578t
            r3.addAll(r2)
            return r1
        L_0x023a:
            r16 = r1
        L_0x023c:
            java.lang.String r1 = "Wrapper"
            r3 = 0
            com.startapp.j6 r1 = r5.b(r1, r3, r3)
            if (r1 == 0) goto L_0x0331
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            java.util.List r4 = r1.c(r6)
            r3.addAll(r4)
            java.lang.String r4 = "VASTAdTagURI"
            java.lang.String r4 = r1.f(r4)
            if (r4 != 0) goto L_0x025b
        L_0x0259:
            r4 = 0
            goto L_0x0278
        L_0x025b:
            java.lang.String r4 = r0.a((java.lang.String) r4)     // Catch:{ SocketTimeoutException -> 0x026c, Exception -> 0x0260 }
            goto L_0x0278
        L_0x0260:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0259
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r4 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.WrapperNoReponse
            r0.a((java.util.List<java.lang.String>) r3, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r4)
            goto L_0x0259
        L_0x026c:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0259
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r4 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.WrapperTimeout
            r0.a((java.util.List<java.lang.String>) r3, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r4)
            goto L_0x0259
        L_0x0278:
            if (r4 != 0) goto L_0x027c
            goto L_0x0331
        L_0x027c:
            r5 = r23
            com.startapp.g6 r3 = r0.a(r4, r3, r5)
            if (r3 != 0) goto L_0x0287
            r3 = r5
            goto L_0x0333
        L_0x0287:
            java.util.List r2 = r1.c(r8)
            java.util.List<java.lang.String> r4 = r3.f34560b
            r4.addAll(r2)
            java.util.List r2 = r1.c()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x029a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x02aa
            java.lang.Object r4 = r2.next()
            com.startapp.j6 r4 = (com.startapp.j6) r4
            r0.a((com.startapp.j6) r4, (com.startapp.g6) r3)
            goto L_0x029a
        L_0x02aa:
            java.util.Set<com.startapp.f6> r2 = r0.f34831h
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02c0
            java.util.Set<com.startapp.f6> r2 = r0.f34831h
            java.util.List r4 = r1.a()
            java.util.Set r4 = r0.a((java.util.List<com.startapp.j6>) r4)
            r2.addAll(r4)
            goto L_0x0327
        L_0x02c0:
            java.util.Set<com.startapp.f6> r2 = r0.f34831h
            java.util.Iterator r2 = r2.iterator()
        L_0x02c6:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0327
            java.lang.Object r4 = r2.next()
            com.startapp.f6 r4 = (com.startapp.f6) r4
            java.util.List r5 = r1.a()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x02dc:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x02c6
            java.lang.Object r6 = r5.next()
            com.startapp.j6 r6 = (com.startapp.j6) r6
            java.lang.String r7 = "StaticResource"
            java.lang.String r7 = r6.f(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x030f
            java.lang.String r7 = "IFrameResource"
            java.lang.String r7 = r6.f(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x030f
            java.lang.String r7 = "HTMLResource"
            java.lang.String r7 = r6.f(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x030d
            goto L_0x030f
        L_0x030d:
            r7 = 0
            goto L_0x0310
        L_0x030f:
            r7 = 1
        L_0x0310:
            if (r7 != 0) goto L_0x02dc
            java.lang.String r7 = "CompanionClickTracking"
            java.util.List r7 = r6.c(r7)
            java.util.List<java.lang.String> r8 = r4.f34514e
            r8.addAll(r7)
            java.util.List r6 = r6.b()
            java.util.List<java.lang.String> r7 = r4.f34515f
            r7.addAll(r6)
            goto L_0x02dc
        L_0x0327:
            java.util.List r1 = a((com.startapp.j6) r1)
            java.util.List<com.startapp.sdk.omsdk.VerificationDetails> r2 = r3.f34578t
            r2.addAll(r1)
            return r3
        L_0x0331:
            r3 = r23
        L_0x0333:
            r1 = r16
            r4 = 0
            goto L_0x005a
        L_0x0338:
            r1 = r4
            return r1
        L_0x033a:
            r1 = r4
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r3 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.XMLParsingError
            r0.a((java.util.List<java.lang.String>) r2, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.k6.a(java.lang.String, java.util.List, com.startapp.k6$b):com.startapp.g6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.f34829f
            int r1 = r3.f34830g
            r2 = 0
            if (r0 >= r1) goto L_0x0042
            int r0 = r0 + 1
            r3.f34829f = r0
            java.lang.String r0 = r3.f34832i     // Catch:{ all -> 0x0036 }
            java.net.HttpURLConnection r4 = com.startapp.fb.a(r4, r0)     // Catch:{ all -> 0x0036 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0033 }
            java.io.InputStream r1 = r4.getInputStream()     // Catch:{ all -> 0x0033 }
            r0.<init>(r1)     // Catch:{ all -> 0x0033 }
            java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x0030 }
            r1.<init>(r0)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "\\A"
            java.util.Scanner r1 = r1.useDelimiter(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r1.next()     // Catch:{ all -> 0x0030 }
            com.startapp.lb.a((java.io.Closeable) r0)
            r4.disconnect()
            return r1
        L_0x0030:
            r1 = move-exception
            r2 = r0
            goto L_0x0039
        L_0x0033:
            r0 = move-exception
            r1 = r0
            goto L_0x0039
        L_0x0036:
            r4 = move-exception
            r1 = r4
            r4 = r2
        L_0x0039:
            com.startapp.lb.a((java.io.Closeable) r2)
            if (r4 == 0) goto L_0x0041
            r4.disconnect()
        L_0x0041:
            throw r1
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.k6.a(java.lang.String):java.lang.String");
    }

    public final void a(List<String> list, VASTErrorCodes vASTErrorCodes) {
        this.f34828e = vASTErrorCodes;
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        a aVar = this.f34827d;
        if (aVar != null) {
            e5.a(e5.this, vASTErrorCodes, (List) arrayList);
        }
    }

    public final Set<f6> a(List<j6> list) {
        HashSet hashSet = new HashSet();
        VASTResource.Type[] values = VASTResource.Type.values();
        for (int i2 = 0; i2 < 3; i2++) {
            VASTResource.Type type = values[i2];
            for (j6 next : list) {
                Integer b2 = next.b("assetWidth");
                if (b2 == null) {
                    b2 = next.b("width");
                }
                Integer b3 = next.b("assetHeight");
                if (b3 == null) {
                    b3 = next.b("height");
                }
                if (b2 != null && b2.intValue() >= 300 && b3 != null && b3.intValue() >= 250) {
                    int intValue = b2.intValue();
                    int intValue2 = b3.intValue();
                    Point point = new Point(intValue, intValue2);
                    int i3 = this.f34825b;
                    float f2 = (float) i3;
                    int i4 = (int) (f2 / this.f34826c);
                    if (intValue > i3 || intValue2 > i4) {
                        if (type == VASTResource.Type.HTML_RESOURCE) {
                            point.x = Math.min(i3, intValue);
                            point.y = Math.min(i4, intValue2);
                        } else {
                            float f3 = (float) intValue;
                            float f4 = f3 / f2;
                            float f5 = (float) intValue2;
                            float f6 = f5 / ((float) i4);
                            if (f4 > f6) {
                                point.x = i3;
                                point.y = (int) (f5 / f4);
                            } else {
                                point.x = (int) (f3 / f6);
                                point.y = i4;
                            }
                        }
                    }
                    VASTResource a2 = VASTResource.a(next, type, point.x, point.y);
                    if (a2 != null) {
                        hashSet.add(new f6(point.x, point.y, a2, next.f("CompanionClickThrough"), next.c("CompanionClickTracking"), next.b()));
                    }
                }
            }
        }
        return hashSet;
    }

    public static List<VerificationDetails> a(j6 j6Var) {
        String f2;
        String f3;
        String str;
        List<j6> a2 = j6Var.a("Verification", "AdVerifications", (String) null, (List<String>) null);
        Iterator it2 = ((ArrayList) j6Var.a("Extension", "Extensions", "type", Collections.singletonList("AdVerifications"))).iterator();
        while (it2.hasNext()) {
            ((ArrayList) a2).addAll(((j6) it2.next()).a("Verification", "AdVerifications", (String) null, (List<String>) null));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = ((ArrayList) a2).iterator();
        while (it3.hasNext()) {
            j6 j6Var2 = (j6) it3.next();
            String a3 = j6Var2.a("vendor");
            if (!(a3 == null || (f2 = j6Var2.f("JavaScriptResource")) == null || (f3 = j6Var2.f("VerificationParameters")) == null)) {
                j6 b2 = j6Var2.b("JavaScriptResource", "apiFramework", (List<String>) null);
                if (b2 == null) {
                    str = null;
                } else {
                    str = b2.a("apiFramework");
                }
                if (str != null && str.equalsIgnoreCase("omid")) {
                    arrayList.add(new VerificationDetails(a3, f2, f3));
                }
            }
        }
        return arrayList;
    }
}

package com.utils.subtitle.services.subdl;

import com.movie.FreeMoviesApp;
import com.utils.subtitle.services.LanguageId;
import com.utils.subtitle.services.SubServiceBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class SubDL extends SubServiceBase {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f37761f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private final String f37762d = "https://subdl.com";

    /* renamed from: e  reason: collision with root package name */
    private final String f37763e = "subdl";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047 A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00fb A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0175 A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x023a A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x025c A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02a0 A[Catch:{ Exception -> 0x02f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02bf A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(com.movie.data.model.MovieInfo r38, io.reactivex.ObservableEmitter<? super java.util.ArrayList<com.utils.subtitle.SubtitleInfo>> r39) {
        /*
            r37 = this;
            r0 = r37
            r1 = r38
            r2 = r39
            java.lang.String r3 = "pageProps"
            java.lang.String r4 = "format(format, *args)"
            java.lang.String r5 = "+"
            java.lang.String r6 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            java.lang.String r7 = "subscriber"
            kotlin.jvm.internal.Intrinsics.f(r2, r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            kotlin.jvm.internal.Intrinsics.c(r38)     // Catch:{ Exception -> 0x02f8 }
            java.lang.Integer r8 = r38.getType()     // Catch:{ Exception -> 0x02f8 }
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x02f8 }
            if (r8 != r10) goto L_0x002c
            r8 = 1
            goto L_0x002d
        L_0x002c:
            r8 = 0
        L_0x002d:
            com.original.tase.helper.http.HttpHelper r11 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = r0.f37762d     // Catch:{ Exception -> 0x02f8 }
            java.util.Map[] r13 = new java.util.Map[r9]     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r11 = r11.m(r12, r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = "['\"]?buildId['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]"
            java.lang.String r11 = com.original.tase.utils.Regex.a(r11, r12, r10)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = ""
            boolean r12 = kotlin.jvm.internal.Intrinsics.a(r11, r12)     // Catch:{ Exception -> 0x02f8 }
            if (r12 == 0) goto L_0x0049
            java.lang.String r11 = "XgCT-IYfYWOMnz6jv5nHn"
        L_0x0049:
            if (r8 == 0) goto L_0x0054
            java.lang.Integer r12 = r38.getYear()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x02f8 }
            goto L_0x008b
        L_0x0054:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r12.<init>()     // Catch:{ Exception -> 0x02f8 }
            r13 = 83
            r12.append(r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = r1.session     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r14 = "session"
            kotlin.jvm.internal.Intrinsics.e(r13, r14)     // Catch:{ Exception -> 0x02f8 }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = com.original.tase.utils.Utils.i(r13)     // Catch:{ Exception -> 0x02f8 }
            r12.append(r13)     // Catch:{ Exception -> 0x02f8 }
            r13 = 69
            r12.append(r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = r1.eps     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r14 = "eps"
            kotlin.jvm.internal.Intrinsics.e(r13, r14)     // Catch:{ Exception -> 0x02f8 }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = com.original.tase.utils.Utils.i(r13)     // Catch:{ Exception -> 0x02f8 }
            r12.append(r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x02f8 }
        L_0x008b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r13.<init>()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r1 = r1.name     // Catch:{ Exception -> 0x02f8 }
            r13.append(r1)     // Catch:{ Exception -> 0x02f8 }
            r1 = 32
            r13.append(r1)     // Catch:{ Exception -> 0x02f8 }
            r13.append(r12)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r12 = com.original.tase.helper.TitleHelper.h(r12, r5)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.f40434a     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = "%s/_next/data/%s/search.json?query=%s"
            r14 = 3
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r1 = r0.f37762d     // Catch:{ Exception -> 0x02f8 }
            r15[r9] = r1     // Catch:{ Exception -> 0x02f8 }
            r15[r10] = r11     // Catch:{ Exception -> 0x02f8 }
            r1 = 2
            r15[r1] = r12     // Catch:{ Exception -> 0x02f8 }
            java.lang.Object[] r15 = java.util.Arrays.copyOf(r15, r14)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = java.lang.String.format(r13, r15)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.e(r13, r4)     // Catch:{ Exception -> 0x02f8 }
            com.original.tase.helper.http.HttpHelper r15 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x02f8 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r14.<init>()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r10 = r0.f37762d     // Catch:{ Exception -> 0x02f8 }
            r14.append(r10)     // Catch:{ Exception -> 0x02f8 }
            r10 = 47
            r14.append(r10)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = r15.o(r13, r14)     // Catch:{ Exception -> 0x02f8 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x02f8 }
            r14.<init>(r13)     // Catch:{ Exception -> 0x02f8 }
            org.json.JSONObject r13 = r14.getJSONObject(r3)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r14 = "searchList"
            org.json.JSONObject r13 = r13.getJSONObject(r14)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r14 = "results"
            org.json.JSONArray r13 = r13.getJSONArray(r14)     // Catch:{ Exception -> 0x02f8 }
            java.util.ArrayList r14 = r37.n()     // Catch:{ Exception -> 0x02f8 }
            int r15 = r13.length()     // Catch:{ Exception -> 0x02f8 }
            r10 = 0
        L_0x00f9:
            if (r10 >= r15) goto L_0x02f8
            org.json.JSONObject r1 = r13.getJSONObject(r10)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r9 = "type"
            java.lang.String r9 = r1.getString(r9)     // Catch:{ Exception -> 0x02f8 }
            if (r8 == 0) goto L_0x0125
            r20 = r8
            java.lang.String r8 = "movie"
            boolean r8 = kotlin.jvm.internal.Intrinsics.a(r9, r8)     // Catch:{ Exception -> 0x02f8 }
            if (r8 != 0) goto L_0x0127
            r31 = r3
            r32 = r4
            r23 = r5
            r36 = r6
            r21 = r13
            r22 = r15
        L_0x011d:
            r16 = 3
            r17 = 2
            r19 = 0
            goto L_0x02e2
        L_0x0125:
            r20 = r8
        L_0x0127:
            java.lang.String r8 = "name"
            java.lang.String r8 = r1.getString(r8)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r9 = "year"
            java.lang.String r9 = r1.getString(r9)     // Catch:{ Exception -> 0x02f8 }
            r21 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r13.<init>()     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.c(r8)     // Catch:{ Exception -> 0x02f8 }
            r22 = r15
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r8 = r8.toLowerCase(r15)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.e(r8, r6)     // Catch:{ Exception -> 0x02f8 }
            r13.append(r8)     // Catch:{ Exception -> 0x02f8 }
            r8 = 32
            r13.append(r8)     // Catch:{ Exception -> 0x02f8 }
            r13.append(r9)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r9 = r13.toString()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r9 = com.original.tase.helper.TitleHelper.h(r9, r5)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = "replaceAllkeywithTarget(...)"
            kotlin.jvm.internal.Intrinsics.e(r9, r13)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.c(r12)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = r12.toLowerCase(r15)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.e(r13, r6)     // Catch:{ Exception -> 0x02f8 }
            r15 = 0
            r23 = r5
            r5 = 0
            r8 = 2
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.G(r9, r13, r5, r8, r15)     // Catch:{ Exception -> 0x02f8 }
            if (r9 == 0) goto L_0x02da
            java.lang.String r5 = "slug"
            java.lang.String r5 = r1.getString(r5)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r8 = "sd_id"
            java.lang.String r1 = r1.getString(r8)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.f40434a     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r8 = "%s/_next/data/%s/subtitle/%s/%s.json?sd_id=%s&sd_id=%s"
            r9 = 6
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r15 = r0.f37762d     // Catch:{ Exception -> 0x02f8 }
            r19 = 0
            r13[r19] = r15     // Catch:{ Exception -> 0x02f8 }
            r15 = 1
            r13[r15] = r11     // Catch:{ Exception -> 0x02f8 }
            r17 = 2
            r13[r17] = r1     // Catch:{ Exception -> 0x02f8 }
            r16 = 3
            r13[r16] = r5     // Catch:{ Exception -> 0x02f8 }
            r18 = 4
            r13[r18] = r1     // Catch:{ Exception -> 0x02f8 }
            r1 = 5
            r13[r1] = r5     // Catch:{ Exception -> 0x02f8 }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r13, r9)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r1 = java.lang.String.format(r8, r1)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.e(r1, r4)     // Catch:{ Exception -> 0x02f8 }
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x02f8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r8.<init>()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r9 = r0.f37762d     // Catch:{ Exception -> 0x02f8 }
            r8.append(r9)     // Catch:{ Exception -> 0x02f8 }
            r9 = 47
            r8.append(r9)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r1 = r5.o(r1, r8)     // Catch:{ Exception -> 0x02f8 }
            java.util.Iterator r5 = r14.iterator()     // Catch:{ Exception -> 0x02f8 }
        L_0x01ca:
            boolean r8 = r5.hasNext()     // Catch:{ Exception -> 0x02f8 }
            if (r8 == 0) goto L_0x02d3
            java.lang.Object r8 = r5.next()     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x02f8 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x02f8 }
            r13.<init>(r1)     // Catch:{ Exception -> 0x02f8 }
            org.json.JSONObject r13 = r13.getJSONObject(r3)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r9 = "subtitlesItems"
            org.json.JSONObject r9 = r13.getJSONObject(r9)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.c(r8)     // Catch:{ Exception -> 0x02f8 }
            java.util.Locale r13 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = r8.toLowerCase(r13)     // Catch:{ Exception -> 0x02f8 }
            kotlin.jvm.internal.Intrinsics.e(r13, r6)     // Catch:{ Exception -> 0x02f8 }
            org.json.JSONObject r9 = r9.getJSONObject(r13)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r13 = "https://dl.subdl.com/subtitle/"
            java.lang.String r15 = "title"
            java.lang.String r0 = "link"
            r30 = r1
            java.lang.String r1 = "subs"
            if (r9 == 0) goto L_0x026a
            r31 = r3
            java.lang.String r3 = "bluray"
            org.json.JSONObject r3 = r9.getJSONObject(r3)     // Catch:{ Exception -> 0x02f8 }
            if (r3 == 0) goto L_0x026c
            org.json.JSONArray r3 = r3.getJSONArray(r1)     // Catch:{ Exception -> 0x02f8 }
            if (r3 == 0) goto L_0x026c
            r32 = r4
            int r4 = r3.length()     // Catch:{ Exception -> 0x02f8 }
            r33 = r5
            r5 = 0
        L_0x021a:
            if (r5 >= r4) goto L_0x0267
            r34 = r4
            org.json.JSONObject r4 = r3.getJSONObject(r5)     // Catch:{ Exception -> 0x02f8 }
            r35 = r3
            java.lang.String r3 = r4.getString(r0)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r25 = r4.getString(r15)     // Catch:{ Exception -> 0x02f8 }
            if (r3 == 0) goto L_0x0237
            int r4 = r3.length()     // Catch:{ Exception -> 0x02f8 }
            if (r4 != 0) goto L_0x0235
            goto L_0x0237
        L_0x0235:
            r4 = 0
            goto L_0x0238
        L_0x0237:
            r4 = 1
        L_0x0238:
            if (r4 != 0) goto L_0x025c
            com.utils.subtitle.SubtitleInfo r4 = new com.utils.subtitle.SubtitleInfo     // Catch:{ Exception -> 0x02f8 }
            r36 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r6.<init>()     // Catch:{ Exception -> 0x02f8 }
            r6.append(r13)     // Catch:{ Exception -> 0x02f8 }
            r6.append(r3)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r26 = r6.toString()     // Catch:{ Exception -> 0x02f8 }
            r28 = -1
            com.utils.subtitle.SubtitleInfo$Source r29 = com.utils.subtitle.SubtitleInfo.Source.SubDL     // Catch:{ Exception -> 0x02f8 }
            r24 = r4
            r27 = r8
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ Exception -> 0x02f8 }
            r7.add(r4)     // Catch:{ Exception -> 0x02f8 }
            goto L_0x025e
        L_0x025c:
            r36 = r6
        L_0x025e:
            int r5 = r5 + 1
            r4 = r34
            r3 = r35
            r6 = r36
            goto L_0x021a
        L_0x0267:
            r36 = r6
            goto L_0x0271
        L_0x026a:
            r31 = r3
        L_0x026c:
            r32 = r4
            r33 = r5
            goto L_0x0267
        L_0x0271:
            java.lang.String r3 = "webdl"
            org.json.JSONObject r3 = r9.getJSONObject(r3)     // Catch:{ Exception -> 0x02f8 }
            if (r3 == 0) goto L_0x02c2
            org.json.JSONArray r1 = r3.getJSONArray(r1)     // Catch:{ Exception -> 0x02f8 }
            if (r1 == 0) goto L_0x02c2
            int r3 = r1.length()     // Catch:{ Exception -> 0x02f8 }
            r5 = 0
        L_0x0284:
            if (r5 >= r3) goto L_0x02c2
            org.json.JSONObject r4 = r1.getJSONObject(r5)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r6 = r4.getString(r0)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r25 = r4.getString(r15)     // Catch:{ Exception -> 0x02f8 }
            if (r6 == 0) goto L_0x029d
            int r4 = r6.length()     // Catch:{ Exception -> 0x02f8 }
            if (r4 != 0) goto L_0x029b
            goto L_0x029d
        L_0x029b:
            r4 = 0
            goto L_0x029e
        L_0x029d:
            r4 = 1
        L_0x029e:
            if (r4 != 0) goto L_0x02bf
            com.utils.subtitle.SubtitleInfo r4 = new com.utils.subtitle.SubtitleInfo     // Catch:{ Exception -> 0x02f8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f8 }
            r9.<init>()     // Catch:{ Exception -> 0x02f8 }
            r9.append(r13)     // Catch:{ Exception -> 0x02f8 }
            r9.append(r6)     // Catch:{ Exception -> 0x02f8 }
            java.lang.String r26 = r9.toString()     // Catch:{ Exception -> 0x02f8 }
            r28 = -1
            com.utils.subtitle.SubtitleInfo$Source r29 = com.utils.subtitle.SubtitleInfo.Source.SubDL     // Catch:{ Exception -> 0x02f8 }
            r24 = r4
            r27 = r8
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ Exception -> 0x02f8 }
            r7.add(r4)     // Catch:{ Exception -> 0x02f8 }
        L_0x02bf:
            int r5 = r5 + 1
            goto L_0x0284
        L_0x02c2:
            r0 = r37
            r1 = r30
            r3 = r31
            r4 = r32
            r5 = r33
            r6 = r36
            r9 = 47
            r15 = 1
            goto L_0x01ca
        L_0x02d3:
            r31 = r3
            r32 = r4
            r36 = r6
            goto L_0x02e2
        L_0x02da:
            r31 = r3
            r32 = r4
            r36 = r6
            goto L_0x011d
        L_0x02e2:
            int r10 = r10 + 1
            r0 = r37
            r8 = r20
            r13 = r21
            r15 = r22
            r5 = r23
            r3 = r31
            r4 = r32
            r6 = r36
            r1 = 2
            r9 = 0
            goto L_0x00f9
        L_0x02f8:
            r2.onNext(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.services.subdl.SubDL.j(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }

    public final ArrayList<String> n() {
        boolean z2;
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()})));
        ArrayList<String> arrayList = new ArrayList<>();
        Intrinsics.c(stringSet);
        for (String next : stringSet) {
            String c2 = LanguageId.a().c(next);
            Intrinsics.e(c2, "getLangNameByIso639(...)");
            if (c2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                arrayList.add(LanguageId.a().c(next));
            }
        }
        return arrayList;
    }
}

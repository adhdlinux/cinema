package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class PLockerSK extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37406e = Utils.getProvider(56);

    private int J(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 += Character.codePointAt(str, i3) + i3;
        }
        return i2;
    }

    private int K(Map<String, String> map) {
        int i2;
        try {
            int J = J("XT4Az3r00D");
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getValue();
                String str2 = "XT4Az3r00D" + ((String) next.getKey());
                int i3 = 0;
                for (int i4 = 0; i4 < Math.max(str2.length(), str.length()); i4++) {
                    if (i4 < str.length()) {
                        i2 = i3 + Character.codePointAt(str, i4);
                    } else {
                        i2 = i3 + 0;
                    }
                    if (i4 < str2.length()) {
                        i3 = i2 + Character.codePointAt(str2, i4);
                    } else {
                        i3 = i2 + 0;
                    }
                }
                J += J(Integer.toHexString(i3));
            }
            return J;
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return -1;
        }
    }

    private String L(MovieInfo movieInfo, String str) {
        movieInfo.session.isEmpty();
        String e2 = TitleHelper.e(movieInfo.name.replace("Marvel's ", "").replace("DC's ", ""));
        String str2 = this.f37406e + "/search?keyword=" + com.original.tase.utils.Utils.k(e2, new boolean[0]);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str2, new Map[0])).q0("div.item").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            Element r02 = element.r0("div.inner[data-tip]");
            if (r02 != null) {
                String c2 = Regex.c(HttpHelper.i().o(this.f37406e + "/" + r02.c("data-tip"), str2), "<span>\\s*(\\d{4})\\s*</span>", 1, true);
                if (!(movieInfo.year.equals(c2) ^ true) || !(!movieInfo.sessionYear.equals(c2))) {
                }
            }
            element.r0("div.quality").v0();
            String c3 = element.r0("a.name[href]").c("href");
            if (c3.startsWith("/")) {
                return this.f37406e + "" + c3;
            } else if (c3.startsWith(UriUtil.HTTP_SCHEME)) {
                return c3;
            } else {
                return this.f37406e + "/" + c3;
            }
        }
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04ab, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0171, code lost:
        if (r5.contains(com.google.android.gms.cast.HlsSegmentFormat.TS) != false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0242, code lost:
        if (r9.contains("503 Service Unavailable") == false) goto L_0x02b2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02cb A[SYNTHETIC, Splitter:B:105:0x02cb] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x036e A[Catch:{ Exception -> 0x04b5, all -> 0x04b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0449 A[SYNTHETIC, Splitter:B:174:0x0449] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:212:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:152:0x0378] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04ff  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x019b A[Catch:{ all -> 0x050b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r29, java.lang.String r30, com.movie.data.model.MovieInfo r31, java.lang.String r32) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r3 = r30
            java.lang.String r4 = "?"
            java.lang.String r5 = "&update=0"
            java.lang.String r6 = "&server="
            java.lang.String r7 = "&_="
            java.lang.String r8 = "/ajax/episode/info?ts="
            java.lang.String r9 = "id"
            java.lang.String r10 = "-"
            java.lang.String r11 = "&id="
            r0 = r31
            java.lang.String r0 = r0.session
            boolean r0 = r0.isEmpty()
            r12 = 1
            r13 = r0 ^ 1
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r14 = 0
            java.util.Map[] r15 = new java.util.Map[r14]
            java.lang.String r0 = r0.m(r3, r15)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r15 = "html[data-ts]"
            org.jsoup.nodes.Element r0 = r0.r0(r15)
            if (r0 == 0) goto L_0x0560
            java.lang.String r15 = "data-ts"
            java.lang.String r15 = r0.c(r15)
            java.lang.String r12 = "div[class=watch-page][data-id][data-type]"
            org.jsoup.nodes.Element r0 = r0.r0(r12)
            java.lang.String r12 = "data-id"
            java.lang.String r0 = r0.c(r12)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r16 = r4
            java.lang.String r4 = r1.f37406e
            r14.append(r4)
            java.lang.String r4 = "/ajax/film/servers?ts=%s&_=1201&id=%s"
            r14.append(r4)
            java.lang.String r4 = r14.toString()
            com.original.tase.helper.http.HttpHelper r14 = com.original.tase.helper.http.HttpHelper.i()
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r17 = r5
            r5 = 0
            r2[r5] = r15
            r18 = 1
            r2[r18] = r0
            java.lang.String r0 = java.lang.String.format(r4, r2)
            java.util.Map[] r2 = new java.util.Map[r5]
            java.lang.String r0 = r14.m(r0, r2)
            java.lang.String r2 = "\""
            java.lang.String r4 = ""
            java.lang.String r0 = r0.replace(r2, r4)
            java.lang.String r2 = "\\"
            java.lang.String r0 = r0.replace(r2, r4)
            org.jsoup.nodes.Document r2 = org.jsoup.Jsoup.b(r0)
            java.lang.String r0 = "ul[class*=episodes]"
            org.jsoup.select.Elements r0 = r2.q0(r0)
            java.util.Iterator r5 = r0.iterator()
        L_0x0095:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0560
            java.lang.Object r0 = r5.next()
            r14 = r0
            org.jsoup.nodes.Element r14 = (org.jsoup.nodes.Element) r14
            java.lang.String r0 = "div[data-type][data-id]"
            org.jsoup.nodes.Element r0 = r2.r0(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = r0.c(r12)     // Catch:{ all -> 0x00b1 }
            r18 = r2
            r19 = r5
            goto L_0x00be
        L_0x00b1:
            r0 = move-exception
            r18 = r2
            r19 = r5
            r2 = 0
            boolean[] r5 = new boolean[r2]
            com.original.tase.Logger.d(r0, r5)
            java.lang.String r0 = "28"
        L_0x00be:
            r2 = r0
            java.lang.String r0 = "a[data-id]"
            org.jsoup.select.Elements r0 = r14.q0(r0)
            java.util.Iterator r5 = r0.iterator()
        L_0x00c9:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0550
            java.lang.Object r0 = r5.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            boolean r14 = r29.isDisposed()     // Catch:{ all -> 0x051f }
            if (r14 != 0) goto L_0x051e
            java.lang.String r14 = r0.v0()     // Catch:{ all -> 0x051f }
            java.lang.String r14 = r14.trim()     // Catch:{ all -> 0x051f }
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x051f }
            r20 = r5
            java.lang.String r5 = "eps"
            java.lang.String r5 = r14.replace(r5, r4)     // Catch:{ all -> 0x0518 }
            java.lang.String r14 = "ep"
            java.lang.String r5 = r5.replace(r14, r4)     // Catch:{ all -> 0x0518 }
            boolean r14 = r5.contains(r10)     // Catch:{ all -> 0x0518 }
            if (r14 == 0) goto L_0x0117
            java.lang.String[] r14 = r5.split(r10)     // Catch:{ all -> 0x0102 }
            r21 = r4
            goto L_0x0120
        L_0x0102:
            r0 = move-exception
            r27 = r2
            r21 = r4
            r23 = r8
            r8 = r9
            r22 = r10
            r25 = r12
            r24 = r13
        L_0x0110:
            r2 = r16
            r1 = 0
            r12 = r29
            goto L_0x0534
        L_0x0117:
            r21 = r4
            r14 = 1
            java.lang.String[] r4 = new java.lang.String[r14]     // Catch:{ all -> 0x0514 }
            r14 = 0
            r4[r14] = r5     // Catch:{ all -> 0x0514 }
            r14 = r4
        L_0x0120:
            java.lang.String r4 = "ts"
            if (r13 != 0) goto L_0x0161
            int r5 = r14.length     // Catch:{ all -> 0x0154 }
            r22 = r10
            r10 = 0
        L_0x0128:
            if (r10 >= r5) goto L_0x0151
            r23 = r5
            r5 = r14[r10]     // Catch:{ all -> 0x014f }
            r24 = r13
            java.lang.String r13 = "(\\d+)"
            r25 = r14
            r14 = 1
            java.lang.String r13 = com.original.tase.utils.Regex.a(r5, r13, r14)     // Catch:{ all -> 0x0176 }
            boolean r14 = r13.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r14 != 0) goto L_0x0146
            boolean r5 = r13.equals(r5)     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x0146
            goto L_0x0174
        L_0x0146:
            int r10 = r10 + 1
            r5 = r23
            r13 = r24
            r14 = r25
            goto L_0x0128
        L_0x014f:
            r0 = move-exception
            goto L_0x0157
        L_0x0151:
            r24 = r13
            goto L_0x0174
        L_0x0154:
            r0 = move-exception
            r22 = r10
        L_0x0157:
            r24 = r13
        L_0x0159:
            r27 = r2
            r23 = r8
            r8 = r9
            r25 = r12
            goto L_0x0110
        L_0x0161:
            r22 = r10
            r24 = r13
            java.lang.String r10 = "cam"
            boolean r10 = r5.contains(r10)     // Catch:{ all -> 0x050b }
            if (r10 != 0) goto L_0x0178
            boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x0174
            goto L_0x0178
        L_0x0174:
            r5 = 0
            goto L_0x0179
        L_0x0176:
            r0 = move-exception
            goto L_0x0159
        L_0x0178:
            r5 = 1
        L_0x0179:
            java.lang.String r10 = r0.c(r12)     // Catch:{ all -> 0x050b }
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ all -> 0x050b }
            r0.<init>()     // Catch:{ all -> 0x050b }
            r0.put(r9, r10)     // Catch:{ all -> 0x050b }
            java.lang.String r13 = "server"
            r0.put(r13, r2)     // Catch:{ all -> 0x050b }
            java.lang.String r13 = "update"
            java.lang.String r14 = "0"
            r0.put(r13, r14)     // Catch:{ all -> 0x050b }
            r0.put(r4, r15)     // Catch:{ all -> 0x050b }
            int r4 = r1.K(r0)     // Catch:{ all -> 0x050b }
            r13 = -1
            if (r4 == r13) goto L_0x04ff
            java.util.HashMap r14 = com.original.Constants.c()     // Catch:{ all -> 0x050b }
            java.lang.String r13 = "accept"
            r25 = r12
            java.lang.String r12 = "application/json, text/javascript, */*; q=0.01"
            r14.put(r13, r12)     // Catch:{ all -> 0x04f4 }
            java.lang.String r12 = "referer"
            r14.put(r12, r3)     // Catch:{ all -> 0x04f4 }
            java.lang.String r12 = "User-Agent"
            java.lang.String r13 = com.original.Constants.C     // Catch:{ all -> 0x04f4 }
            r14.put(r12, r13)     // Catch:{ all -> 0x04f4 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x04f4 }
            r12.<init>()     // Catch:{ all -> 0x04f4 }
            java.lang.String r13 = r1.f37406e     // Catch:{ all -> 0x04f4 }
            r12.append(r13)     // Catch:{ all -> 0x04f4 }
            r12.append(r8)     // Catch:{ all -> 0x04f4 }
            r26 = r9
            r13 = 0
            boolean[] r9 = new boolean[r13]     // Catch:{ all -> 0x04e8 }
            java.lang.String r9 = com.original.tase.utils.Utils.k(r15, r9)     // Catch:{ all -> 0x04e8 }
            r12.append(r9)     // Catch:{ all -> 0x04e8 }
            r12.append(r7)     // Catch:{ all -> 0x04e8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x04e8 }
            r9 = 0
            boolean[] r13 = new boolean[r9]     // Catch:{ all -> 0x04e8 }
            java.lang.String r4 = com.original.tase.utils.Utils.k(r4, r13)     // Catch:{ all -> 0x04e8 }
            r12.append(r4)     // Catch:{ all -> 0x04e8 }
            r12.append(r11)     // Catch:{ all -> 0x04e8 }
            boolean[] r4 = new boolean[r9]     // Catch:{ all -> 0x04e8 }
            java.lang.String r4 = com.original.tase.utils.Utils.k(r10, r4)     // Catch:{ all -> 0x04e8 }
            r12.append(r4)     // Catch:{ all -> 0x04e8 }
            r12.append(r6)     // Catch:{ all -> 0x04e8 }
            boolean[] r4 = new boolean[r9]     // Catch:{ all -> 0x04e8 }
            java.lang.String r4 = com.original.tase.utils.Utils.k(r2, r4)     // Catch:{ all -> 0x04e8 }
            r12.append(r4)     // Catch:{ all -> 0x04e8 }
            r4 = r17
            r12.append(r4)     // Catch:{ all -> 0x04e0 }
            java.lang.String r9 = r12.toString()     // Catch:{ all -> 0x04e0 }
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x04e0 }
            java.lang.String r9 = r12.o(r9, r3)     // Catch:{ all -> 0x04e0 }
            java.lang.String r12 = r9.trim()     // Catch:{ all -> 0x04e0 }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ all -> 0x04e0 }
            java.lang.String r13 = "error"
            boolean r12 = r12.contains(r13)     // Catch:{ all -> 0x04e0 }
            java.lang.String r13 = "token"
            if (r12 == 0) goto L_0x023a
            java.lang.String r12 = r9.trim()     // Catch:{ all -> 0x04e0 }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ all -> 0x04e0 }
            boolean r12 = r12.contains(r13)     // Catch:{ all -> 0x04e0 }
            if (r12 == 0) goto L_0x023a
            java.lang.String r12 = r9.trim()     // Catch:{ all -> 0x04e0 }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ all -> 0x04e0 }
            r17 = r13
            java.lang.String r13 = "http"
            boolean r12 = r12.contains(r13)     // Catch:{ all -> 0x04e0 }
            if (r12 == 0) goto L_0x0244
            goto L_0x023c
        L_0x023a:
            r17 = r13
        L_0x023c:
            java.lang.String r12 = "503 Service Unavailable"
            boolean r12 = r9.contains(r12)     // Catch:{ all -> 0x04e0 }
            if (r12 == 0) goto L_0x02b2
        L_0x0244:
            int r0 = r1.K(r0)     // Catch:{ all -> 0x02a7 }
            int r0 = r0 + 45
            r12 = -1
            if (r0 == r12) goto L_0x02b2
            com.original.tase.helper.http.HttpHelper r9 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x02a7 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a7 }
            r12.<init>()     // Catch:{ all -> 0x02a7 }
            java.lang.String r13 = r1.f37406e     // Catch:{ all -> 0x02a7 }
            r12.append(r13)     // Catch:{ all -> 0x02a7 }
            r12.append(r8)     // Catch:{ all -> 0x02a7 }
            r23 = r8
            r13 = 0
            boolean[] r8 = new boolean[r13]     // Catch:{ all -> 0x02a5 }
            java.lang.String r8 = com.original.tase.utils.Utils.k(r15, r8)     // Catch:{ all -> 0x02a5 }
            r12.append(r8)     // Catch:{ all -> 0x02a5 }
            r12.append(r7)     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x02a5 }
            r8 = 0
            boolean[] r13 = new boolean[r8]     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r13)     // Catch:{ all -> 0x02a5 }
            r12.append(r0)     // Catch:{ all -> 0x02a5 }
            r12.append(r11)     // Catch:{ all -> 0x02a5 }
            boolean[] r0 = new boolean[r8]     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r10, r0)     // Catch:{ all -> 0x02a5 }
            r12.append(r0)     // Catch:{ all -> 0x02a5 }
            r12.append(r6)     // Catch:{ all -> 0x02a5 }
            boolean[] r0 = new boolean[r8]     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r2, r0)     // Catch:{ all -> 0x02a5 }
            r12.append(r0)     // Catch:{ all -> 0x02a5 }
            r12.append(r4)     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x02a5 }
            r8 = 1
            java.util.Map[] r12 = new java.util.Map[r8]     // Catch:{ all -> 0x02a5 }
            r8 = 0
            r12[r8] = r14     // Catch:{ all -> 0x02a5 }
            java.lang.String r9 = r9.l(r0, r3, r12)     // Catch:{ all -> 0x02a5 }
            goto L_0x02b4
        L_0x02a5:
            r0 = move-exception
            goto L_0x02aa
        L_0x02a7:
            r0 = move-exception
            r23 = r8
        L_0x02aa:
            r12 = r29
            r27 = r2
            r17 = r4
            goto L_0x04ef
        L_0x02b2:
            r23 = r8
        L_0x02b4:
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ all -> 0x04c7 }
            r0.<init>()     // Catch:{ all -> 0x04c7 }
            com.google.gson.JsonElement r0 = r0.a(r9)     // Catch:{ all -> 0x04c7 }
            com.google.gson.JsonObject r8 = r0.c()     // Catch:{ all -> 0x04c7 }
            java.lang.String r0 = "target"
            com.google.gson.JsonElement r0 = r8.m(r0)     // Catch:{ all -> 0x04c7 }
            java.lang.String r9 = "HD"
            if (r0 == 0) goto L_0x0302
            boolean r12 = r0.h()     // Catch:{ all -> 0x04c7 }
            if (r12 != 0) goto L_0x0302
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x04c7 }
            if (r0 == 0) goto L_0x0302
            boolean r12 = r0.isEmpty()     // Catch:{ all -> 0x04c7 }
            if (r12 != 0) goto L_0x0302
            java.lang.String r12 = "//"
            boolean r12 = r0.startsWith(r12)     // Catch:{ all -> 0x04c7 }
            if (r12 == 0) goto L_0x02f6
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x04c7 }
            r12.<init>()     // Catch:{ all -> 0x04c7 }
            java.lang.String r13 = "http:"
            r12.append(r13)     // Catch:{ all -> 0x04c7 }
            r12.append(r0)     // Catch:{ all -> 0x04c7 }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x04c7 }
        L_0x02f6:
            r12 = 1
            boolean[] r13 = new boolean[r12]     // Catch:{ all -> 0x04c7 }
            r12 = 0
            r13[r12] = r5     // Catch:{ all -> 0x04c7 }
            r12 = r29
            r1.z(r12, r0, r9, r13)     // Catch:{ all -> 0x04ba }
            goto L_0x0304
        L_0x0302:
            r12 = r29
        L_0x0304:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bc }
            r0.<init>()     // Catch:{ Exception -> 0x04bc }
            java.lang.String r13 = r1.f37406e     // Catch:{ Exception -> 0x04bc }
            r0.append(r13)     // Catch:{ Exception -> 0x04bc }
            java.lang.String r13 = "/grabber-api/"
            r0.append(r13)     // Catch:{ Exception -> 0x04bc }
            java.lang.String r13 = r0.toString()     // Catch:{ Exception -> 0x04bc }
            java.lang.String r0 = "grabber"
            com.google.gson.JsonElement r0 = r8.m(r0)     // Catch:{ all -> 0x0324 }
            java.lang.String r13 = r0.e()     // Catch:{ all -> 0x0324 }
            r27 = r2
            goto L_0x032d
        L_0x0324:
            r0 = move-exception
            r27 = r2
            r14 = 0
            boolean[] r2 = new boolean[r14]     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
            com.original.tase.Logger.d(r0, r2)     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
        L_0x032d:
            java.lang.String r0 = "params"
            com.google.gson.JsonElement r0 = r8.m(r0)     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
            com.google.gson.JsonObject r2 = r0.c()     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
            r8 = r17
            com.google.gson.JsonElement r14 = r2.m(r8)     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
            com.google.gson.JsonElement r0 = r2.m(r8)     // Catch:{ all -> 0x0347 }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x0347 }
            r3 = r0
            goto L_0x0350
        L_0x0347:
            r0 = move-exception
            r8 = 0
            boolean[] r3 = new boolean[r8]     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
            com.original.tase.Logger.d(r0, r3)     // Catch:{ Exception -> 0x04be, all -> 0x04b8 }
            r3 = r21
        L_0x0350:
            r8 = r26
            com.google.gson.JsonElement r0 = r2.m(r8)     // Catch:{ all -> 0x035d }
            java.lang.String r10 = r0.e()     // Catch:{ all -> 0x035d }
            r17 = r4
            goto L_0x0366
        L_0x035d:
            r0 = move-exception
            r17 = r4
            r2 = 0
            boolean[] r4 = new boolean[r2]     // Catch:{ Exception -> 0x04b5, all -> 0x04b1 }
            com.original.tase.Logger.d(r0, r4)     // Catch:{ Exception -> 0x04b5, all -> 0x04b1 }
        L_0x0366:
            if (r14 == 0) goto L_0x04ad
            boolean r0 = r14.h()     // Catch:{ Exception -> 0x04b5, all -> 0x04b1 }
            if (r0 != 0) goto L_0x04ad
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04b5, all -> 0x04b1 }
            r0.<init>()     // Catch:{ Exception -> 0x04b5, all -> 0x04b1 }
            r0.append(r13)     // Catch:{ Exception -> 0x04b5, all -> 0x04b1 }
            r2 = r16
            boolean r4 = r13.contains(r2)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            if (r4 == 0) goto L_0x0381
            java.lang.String r4 = "&"
            goto L_0x0382
        L_0x0381:
            r4 = r2
        L_0x0382:
            r0.append(r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r4 = "ts="
            r0.append(r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r4 = 0
            boolean[] r13 = new boolean[r4]     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r13 = com.original.tase.utils.Utils.k(r15, r13)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r0.append(r13)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r0.append(r11)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            boolean[] r13 = new boolean[r4]     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r4 = com.original.tase.utils.Utils.k(r10, r13)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r0.append(r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r4 = "&token="
            r0.append(r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r4 = r14.e()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r10 = 0
            boolean[] r13 = new boolean[r10]     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r4 = com.original.tase.utils.Utils.k(r4, r13)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r0.append(r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r4 = "&mobile=0"
            r0.append(r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            if (r4 != 0) goto L_0x03dd
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r4.<init>()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r4.append(r0)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r0 = "&option="
            r4.append(r0)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r10 = 0
            boolean[] r0 = new boolean[r10]     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r3, r0)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r4.append(r0)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
        L_0x03dd:
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x041e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041e }
            r4.<init>()     // Catch:{ all -> 0x041e }
            r4.append(r0)     // Catch:{ all -> 0x041e }
            java.lang.String r10 = "&_"
            r4.append(r10)     // Catch:{ all -> 0x041e }
            java.net.URL r10 = new java.net.URL     // Catch:{ all -> 0x041e }
            r10.<init>(r0)     // Catch:{ all -> 0x041e }
            java.util.Map r0 = com.original.tase.utils.Utils.m(r10)     // Catch:{ all -> 0x041e }
            int r0 = r1.K(r0)     // Catch:{ all -> 0x041e }
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x041e }
            r10 = 0
            boolean[] r13 = new boolean[r10]     // Catch:{ all -> 0x041e }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r13)     // Catch:{ all -> 0x041e }
            r4.append(r0)     // Catch:{ all -> 0x041e }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x041e }
            r4 = 1
            java.util.Map[] r10 = new java.util.Map[r4]     // Catch:{ all -> 0x041c }
            java.util.HashMap r13 = com.original.Constants.c()     // Catch:{ all -> 0x041c }
            r14 = 0
            r10[r14] = r13     // Catch:{ all -> 0x041c }
            java.lang.String r0 = r3.m(r0, r10)     // Catch:{ all -> 0x041c }
            goto L_0x0428
        L_0x041c:
            r0 = move-exception
            goto L_0x0420
        L_0x041e:
            r0 = move-exception
            r4 = 1
        L_0x0420:
            r3 = 0
            boolean[] r10 = new boolean[r3]     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            com.original.tase.Logger.d(r0, r10)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r0 = r21
        L_0x0428:
            com.google.gson.JsonParser r3 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            r3.<init>()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            com.google.gson.JsonElement r0 = r3.a(r0)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.lang.String r3 = "data"
            com.google.gson.JsonElement r0 = r0.m(r3)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            com.google.gson.JsonArray r0 = r0.b()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
        L_0x0443:
            boolean r0 = r3.hasNext()     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
            if (r0 == 0) goto L_0x0539
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x049e }
            com.google.gson.JsonElement r0 = (com.google.gson.JsonElement) r0     // Catch:{ all -> 0x049e }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ all -> 0x049e }
            java.lang.String r10 = "file"
            com.google.gson.JsonElement r0 = r0.m(r10)     // Catch:{ all -> 0x049e }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x049e }
            boolean r10 = com.original.tase.helper.GoogleVideoHelper.n(r0)     // Catch:{ all -> 0x049e }
            com.original.tase.model.media.MediaSource r13 = new com.original.tase.model.media.MediaSource     // Catch:{ all -> 0x049e }
            if (r5 == 0) goto L_0x047b
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x049e }
            r14.<init>()     // Catch:{ all -> 0x049e }
            java.lang.String r4 = r28.A()     // Catch:{ all -> 0x049e }
            r14.append(r4)     // Catch:{ all -> 0x049e }
            java.lang.String r4 = " (CAM)"
            r14.append(r4)     // Catch:{ all -> 0x049e }
            java.lang.String r4 = r14.toString()     // Catch:{ all -> 0x049e }
            goto L_0x047f
        L_0x047b:
            java.lang.String r4 = r28.A()     // Catch:{ all -> 0x049e }
        L_0x047f:
            if (r10 == 0) goto L_0x0484
            java.lang.String r14 = "GoogleVideo"
            goto L_0x0486
        L_0x0484:
            java.lang.String r14 = "CDN"
        L_0x0486:
            r1 = 0
            r13.<init>(r4, r14, r1)     // Catch:{ all -> 0x049c }
            r13.setStreamLink(r0)     // Catch:{ all -> 0x049e }
            if (r10 == 0) goto L_0x0494
            java.lang.String r0 = com.original.tase.helper.GoogleVideoHelper.h(r0)     // Catch:{ all -> 0x049e }
            goto L_0x0495
        L_0x0494:
            r0 = r9
        L_0x0495:
            r13.setQuality((java.lang.String) r0)     // Catch:{ all -> 0x049e }
            r12.onNext(r13)     // Catch:{ all -> 0x049e }
            goto L_0x04a5
        L_0x049c:
            r0 = move-exception
            goto L_0x04a0
        L_0x049e:
            r0 = move-exception
            r1 = 0
        L_0x04a0:
            boolean[] r4 = new boolean[r1]     // Catch:{ Exception -> 0x04c4, all -> 0x04a9 }
            com.original.tase.Logger.d(r0, r4)     // Catch:{ Exception -> 0x04c4, all -> 0x04ab }
        L_0x04a5:
            r4 = 1
            r1 = r28
            goto L_0x0443
        L_0x04a9:
            r0 = move-exception
            goto L_0x04d3
        L_0x04ab:
            r0 = move-exception
            goto L_0x04d2
        L_0x04ad:
            r2 = r16
            goto L_0x0539
        L_0x04b1:
            r0 = move-exception
            r2 = r16
            goto L_0x04d2
        L_0x04b5:
            r2 = r16
            goto L_0x04c4
        L_0x04b8:
            r0 = move-exception
            goto L_0x04cc
        L_0x04ba:
            r0 = move-exception
            goto L_0x04ca
        L_0x04bc:
            r27 = r2
        L_0x04be:
            r17 = r4
            r2 = r16
            r8 = r26
        L_0x04c4:
            goto L_0x0539
        L_0x04c7:
            r0 = move-exception
            r12 = r29
        L_0x04ca:
            r27 = r2
        L_0x04cc:
            r17 = r4
            r2 = r16
            r8 = r26
        L_0x04d2:
            r1 = 0
        L_0x04d3:
            boolean[] r3 = new boolean[r1]     // Catch:{ all -> 0x04dd }
            com.original.tase.Logger.d(r0, r3)     // Catch:{ all -> 0x04da }
            goto L_0x0539
        L_0x04da:
            r0 = move-exception
            goto L_0x0533
        L_0x04dd:
            r0 = move-exception
            goto L_0x0534
        L_0x04e0:
            r0 = move-exception
            r12 = r29
            r27 = r2
            r17 = r4
            goto L_0x04ed
        L_0x04e8:
            r0 = move-exception
            r12 = r29
            r27 = r2
        L_0x04ed:
            r23 = r8
        L_0x04ef:
            r2 = r16
            r8 = r26
            goto L_0x0533
        L_0x04f4:
            r0 = move-exception
            r12 = r29
            r27 = r2
            r23 = r8
            r8 = r9
            r2 = r16
            goto L_0x0533
        L_0x04ff:
            r27 = r2
            r23 = r8
            r8 = r9
            r25 = r12
            r2 = r16
            r12 = r29
            goto L_0x0539
        L_0x050b:
            r0 = move-exception
            r27 = r2
            r23 = r8
            r8 = r9
            r25 = r12
            goto L_0x052f
        L_0x0514:
            r0 = move-exception
            r27 = r2
            goto L_0x0526
        L_0x0518:
            r0 = move-exception
            r27 = r2
            r21 = r4
            goto L_0x0526
        L_0x051e:
            return
        L_0x051f:
            r0 = move-exception
            r27 = r2
            r21 = r4
            r20 = r5
        L_0x0526:
            r23 = r8
            r8 = r9
            r22 = r10
            r25 = r12
            r24 = r13
        L_0x052f:
            r2 = r16
            r12 = r29
        L_0x0533:
            r1 = 0
        L_0x0534:
            boolean[] r3 = new boolean[r1]
            com.original.tase.Logger.d(r0, r3)
        L_0x0539:
            r1 = r28
            r3 = r30
            r16 = r2
            r9 = r8
            r5 = r20
            r4 = r21
            r10 = r22
            r8 = r23
            r13 = r24
            r12 = r25
            r2 = r27
            goto L_0x00c9
        L_0x0550:
            r25 = r12
            r12 = r29
            r1 = r28
            r3 = r30
            r2 = r18
            r5 = r19
            r12 = r25
            goto L_0x0095
        L_0x0560:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.PLockerSK.M(io.reactivex.ObservableEmitter, java.lang.String, com.movie.data.model.MovieInfo, java.lang.String):void");
    }

    public String A() {
        return "PLockerSK";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo, "-1");
        if (!L.isEmpty()) {
            M(observableEmitter, L, movieInfo, "-1");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo, movieInfo.session);
        if (!L.isEmpty()) {
            M(observableEmitter, L, movieInfo, movieInfo.eps);
        }
    }
}

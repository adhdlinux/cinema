package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class SeriesNine extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37434e = Utils.getProvider(44);

    public String A() {
        return "SeriesNine";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x02f7, code lost:
        if (r4.startsWith("//") == false) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x02f9, code lost:
        r4 = r33 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x030a, code lost:
        r24 = r8;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0313, code lost:
        if (r4.startsWith("/") == false) goto L_0x0327;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0315, code lost:
        r4 = r0.f37434e + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x032d, code lost:
        if (r4.startsWith(r32) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x032f, code lost:
        r4 = r0.f37434e + "/" + r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x05c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r37, com.movie.data.model.MovieInfo r38) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r38
            java.lang.String r3 = "CDN-FastServer"
            java.lang.String r4 = "https:"
            java.lang.Integer r5 = r38.getType()
            int r5 = r5.intValue()
            r6 = 0
            r7 = 1
            if (r5 != r7) goto L_0x0018
            r5 = 1
            goto L_0x0019
        L_0x0018:
            r5 = 0
        L_0x0019:
            java.lang.String r8 = r2.name
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r9 = "-"
            java.lang.String r8 = com.original.tase.helper.TitleHelper.h(r8, r9)
            com.original.tase.helper.http.HttpHelper r9 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r10 = r0.f37434e
            java.util.Map[] r11 = new java.util.Map[r6]
            r9.m(r10, r11)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.String r10 = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"
            java.lang.String r11 = "accept"
            r9.put(r11, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r0.f37434e
            r10.append(r12)
            java.lang.String r12 = "/"
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.String r13 = "referer"
            r9.put(r13, r10)
            java.lang.String r10 = "upgrade-insecure-requests"
            java.lang.String r14 = "1"
            r9.put(r10, r14)
            java.lang.String r10 = "user-agent"
            java.lang.String r14 = com.original.Constants.C
            r9.put(r10, r14)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r14 = r0.f37434e
            java.lang.String r10 = r10.g(r14)
            java.lang.String r14 = "cookie"
            r9.put(r14, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r14 = r0.f37434e
            r10.append(r14)
            java.lang.String r14 = "/movie/search/"
            r10.append(r14)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            com.original.tase.helper.http.HttpHelper r14 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r10)
            java.lang.String r6 = "##forceNoCache##"
            r15.append(r6)
            java.lang.String r15 = r15.toString()
            r17 = r3
            java.util.Map[] r3 = new java.util.Map[r7]
            r16 = 0
            r3[r16] = r9
            java.lang.String r3 = r14.m(r15, r3)
            org.jsoup.nodes.Document r9 = org.jsoup.Jsoup.b(r3)
            java.lang.String r14 = "div.ml-item"
            org.jsoup.select.Elements r9 = r9.q0(r14)
            java.util.Iterator r9 = r9.iterator()
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            java.lang.String r7 = "*/*"
            r15.put(r11, r7)
            java.lang.String r7 = "origin"
            r19 = r3
            java.lang.String r3 = r0.f37434e
            r15.put(r7, r3)
            r15.put(r13, r10)
            boolean r3 = r9.hasNext()
            java.lang.String r7 = "?link_web="
            if (r3 != 0) goto L_0x011d
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r13 = "https://api.ocloud.stream/series/movie/search/"
            r9.append(r13)
            r9.append(r8)
            r9.append(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r13 = r0.f37434e
            r8.append(r13)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            r13 = 0
            boolean[] r1 = new boolean[r13]
            java.lang.String r1 = com.original.tase.utils.Utils.k(r8, r1)
            r9.append(r1)
            java.lang.String r1 = r9.toString()
            r8 = 1
            java.util.Map[] r9 = new java.util.Map[r8]
            r9[r13] = r15
            java.lang.String r3 = r3.m(r1, r9)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r3)
            org.jsoup.select.Elements r1 = r1.q0(r14)
            java.util.Iterator r9 = r1.iterator()
            goto L_0x011f
        L_0x011d:
            r3 = r19
        L_0x011f:
            java.lang.String r1 = r2.year
            java.lang.String r8 = ""
            r14 = r8
            r13 = 0
        L_0x0125:
            boolean r19 = r9.hasNext()
            r20 = r1
            java.lang.String r1 = "p"
            r21 = r3
            java.lang.String r3 = "(\\d+)"
            r22 = r8
            java.lang.String r8 = "a"
            r23 = r13
            java.lang.String r13 = "href"
            r24 = r14
            java.lang.String r14 = "//"
            if (r19 == 0) goto L_0x046b
            java.lang.Object r19 = r9.next()
            r25 = r9
            r9 = r19
            org.jsoup.nodes.Element r9 = (org.jsoup.nodes.Element) r9
            org.jsoup.nodes.Element r9 = r9.r0(r8)
            r19 = r8
            java.lang.String r8 = "data-url"
            java.lang.String r8 = r9.c(r8)
            r26 = r4
            java.lang.String r4 = "title"
            java.lang.String r4 = r9.c(r4)
            boolean r27 = r4.isEmpty()
            if (r27 == 0) goto L_0x016d
            java.lang.String r4 = "h2"
            org.jsoup.nodes.Element r4 = r9.r0(r4)
            java.lang.String r4 = r4.v0()
        L_0x016d:
            r27 = r9
            java.lang.String r9 = "http"
            r28 = r13
            java.lang.String r13 = "http:"
            if (r5 == 0) goto L_0x03cf
            r29 = r5
            java.lang.String r5 = r2.name
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0344
            boolean r5 = r8.isEmpty()
            if (r5 != 0) goto L_0x02ba
            boolean r5 = r8.startsWith(r14)
            if (r5 == 0) goto L_0x019f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r13)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r30 = r4
            goto L_0x01d5
        L_0x019f:
            boolean r5 = r8.startsWith(r12)
            if (r5 == 0) goto L_0x01b9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r30 = r4
            java.lang.String r4 = r0.f37434e
            r5.append(r4)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            goto L_0x01d5
        L_0x01b9:
            r30 = r4
            boolean r4 = r8.startsWith(r9)
            if (r4 != 0) goto L_0x01d5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r0.f37434e
            r4.append(r5)
            r4.append(r12)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
        L_0x01d5:
            java.lang.String r4 = "application/json, text/javascript, */*; q=0.01"
            r15.put(r11, r4)
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r8)
            r5.append(r7)
            r31 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r32 = r9
            java.lang.String r9 = r0.f37434e
            r11.append(r9)
            r11.append(r12)
            java.lang.String r9 = r11.toString()
            r33 = r13
            r11 = 0
            boolean[] r13 = new boolean[r11]
            java.lang.String r9 = com.original.tase.utils.Utils.k(r9, r13)
            r5.append(r9)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r9 = 1
            java.util.Map[] r13 = new java.util.Map[r9]
            r13[r11] = r15
            java.lang.String r4 = r4.m(r5, r13)
            java.lang.String r5 = "\\\""
            java.lang.String r9 = "\""
            java.lang.String r4 = r4.replace(r5, r9)
            java.lang.String r11 = "\\/"
            java.lang.String r4 = r4.replace(r11, r12)
            boolean r13 = r4.isEmpty()
            if (r13 != 0) goto L_0x0236
            java.lang.String r13 = "404"
            boolean r13 = r4.contains(r13)
            if (r13 == 0) goto L_0x028c
        L_0x0236:
            java.lang.String r13 = "yesmovie.io"
            boolean r20 = r8.contains(r13)
            if (r20 == 0) goto L_0x028c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r34 = r15
            java.lang.String r15 = "ocloud.stream"
            java.lang.String r8 = r8.replace(r13, r15)
            r4.append(r8)
            r4.append(r7)
            java.lang.String r8 = r0.f37434e
            r13 = 0
            boolean[] r15 = new boolean[r13]
            java.lang.String r8 = com.original.tase.utils.Utils.k(r8, r15)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.original.tase.helper.http.HttpHelper r8 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r4)
            r13.append(r6)
            java.lang.String r4 = r13.toString()
            r13 = 1
            java.util.Map[] r15 = new java.util.Map[r13]
            java.util.HashMap r18 = com.original.Constants.c()
            r16 = 0
            r15[r16] = r18
            java.lang.String r4 = r8.r(r4, r10, r15)
            java.lang.String r4 = r4.replace(r5, r9)
            java.lang.String r4 = r4.replace(r11, r12)
            goto L_0x028f
        L_0x028c:
            r34 = r15
            r13 = 1
        L_0x028f:
            java.lang.String r5 = "<div\\s+[^>]*class=\"jt-info\"[^>]*>\\s*(\\d{4})\\s*</div>"
            java.lang.String r5 = com.original.tase.utils.Regex.a(r4, r5, r13)
            java.lang.String r8 = "<div\\s+[^>]*class=\"jtip-quality\"[^>]*>\\s*([\\w\\s]+)\\s*</div>"
            java.lang.String r8 = com.original.tase.utils.Regex.a(r4, r8, r13)
            boolean r9 = r0.o(r8)
            java.lang.String r8 = com.original.tase.utils.Regex.a(r8, r3, r13)
            boolean r11 = r8.isEmpty()
            if (r11 != 0) goto L_0x02b8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r8)
            r11.append(r1)
            java.lang.String r8 = r11.toString()
        L_0x02b8:
            r13 = r9
            goto L_0x02cc
        L_0x02ba:
            r30 = r4
            r32 = r9
            r31 = r11
            r33 = r13
            r34 = r15
            r5 = r20
            r4 = r21
            r13 = r23
            r8 = r24
        L_0x02cc:
            java.lang.String r9 = r2.year
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x02eb
            boolean r9 = r4.isEmpty()
            if (r9 == 0) goto L_0x02db
            goto L_0x02eb
        L_0x02db:
            r21 = r4
            r20 = r5
            r24 = r8
            r4 = r27
            r5 = r28
            r11 = r32
            r9 = r33
            goto L_0x0352
        L_0x02eb:
            r4 = r27
            r5 = r28
            java.lang.String r4 = r4.c(r5)
            boolean r6 = r4.startsWith(r14)
            if (r6 == 0) goto L_0x030f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r9 = r33
            r6.append(r9)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
        L_0x030a:
            r24 = r8
            r8 = r4
            goto L_0x0476
        L_0x030f:
            boolean r6 = r4.startsWith(r12)
            if (r6 == 0) goto L_0x0327
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r0.f37434e
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            goto L_0x030a
        L_0x0327:
            r11 = r32
            boolean r6 = r4.startsWith(r11)
            if (r6 != 0) goto L_0x030a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r0.f37434e
            r6.append(r7)
            r6.append(r12)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            goto L_0x030a
        L_0x0344:
            r30 = r4
            r31 = r11
            r34 = r15
            r4 = r27
            r5 = r28
            r11 = r9
            r9 = r13
            r13 = r23
        L_0x0352:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r15 = r2.name
            r8.append(r15)
            java.lang.String r15 = " ("
            r8.append(r15)
            java.lang.String r15 = r2.year
            r8.append(r15)
            java.lang.String r15 = ")"
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            r15 = r30
            boolean r8 = r15.equals(r8)
            if (r8 == 0) goto L_0x03c7
            java.lang.String r8 = r4.c(r5)
            boolean r4 = r8.startsWith(r14)
            if (r4 == 0) goto L_0x0392
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            goto L_0x0476
        L_0x0392:
            boolean r4 = r8.startsWith(r12)
            if (r4 == 0) goto L_0x03ab
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r0.f37434e
            r4.append(r6)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            goto L_0x0476
        L_0x03ab:
            boolean r4 = r8.startsWith(r11)
            if (r4 != 0) goto L_0x0476
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r0.f37434e
            r4.append(r6)
            r4.append(r12)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            goto L_0x0476
        L_0x03c7:
            r1 = r20
            r3 = r21
            r8 = r22
            goto L_0x045d
        L_0x03cf:
            r29 = r5
            r31 = r11
            r34 = r15
            r5 = r28
            r15 = r4
            r11 = r9
            r9 = r13
            r4 = r27
            java.lang.String r8 = com.original.tase.helper.TitleHelper.f(r15)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = r38.getName()
            r13.append(r15)
            java.lang.String r15 = "season"
            r13.append(r15)
            java.lang.String r15 = r2.session
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            java.lang.String r13 = com.original.tase.helper.TitleHelper.e(r13)
            java.lang.String r13 = com.original.tase.helper.TitleHelper.f(r13)
            boolean r8 = r8.startsWith(r13)
            if (r8 == 0) goto L_0x0455
            java.lang.String r8 = r4.c(r5)
            boolean r4 = r8.startsWith(r14)
            if (r4 == 0) goto L_0x0422
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            goto L_0x0474
        L_0x0422:
            boolean r4 = r8.startsWith(r12)
            if (r4 == 0) goto L_0x043a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r0.f37434e
            r4.append(r6)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            goto L_0x0474
        L_0x043a:
            boolean r4 = r8.startsWith(r11)
            if (r4 != 0) goto L_0x0474
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r0.f37434e
            r4.append(r6)
            r4.append(r12)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            goto L_0x0474
        L_0x0455:
            r1 = r20
            r3 = r21
            r8 = r22
            r13 = r23
        L_0x045d:
            r14 = r24
            r9 = r25
            r4 = r26
            r5 = r29
            r11 = r31
            r15 = r34
            goto L_0x0125
        L_0x046b:
            r26 = r4
            r29 = r5
            r19 = r8
            r5 = r13
            r8 = r22
        L_0x0474:
            r13 = r23
        L_0x0476:
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L_0x047d
            return
        L_0x047d:
            java.lang.String r4 = ".html"
            boolean r4 = r8.endsWith(r4)
            if (r4 == 0) goto L_0x0491
            int r4 = r8.length()
            int r4 = r4 + -5
            r6 = 0
            java.lang.String r8 = r8.substring(r6, r4)
            goto L_0x0492
        L_0x0491:
            r6 = 0
        L_0x0492:
            boolean r4 = r8.endsWith(r12)
            if (r4 == 0) goto L_0x04a2
            int r4 = r8.length()
            r7 = 1
            int r4 = r4 - r7
            java.lang.String r8 = r8.substring(r6, r4)
        L_0x04a2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            java.lang.String r7 = "/watching.html"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r8 = new java.util.Map[r6]
            java.lang.String r6 = r7.m(r4, r8)
            org.jsoup.nodes.Document r6 = org.jsoup.Jsoup.b(r6)
            boolean r7 = r24.isEmpty()
            if (r7 == 0) goto L_0x04f2
            java.lang.String r7 = "span.quality"
            org.jsoup.nodes.Element r7 = r6.r0(r7)
            java.lang.String r7 = r7.v0()
            java.lang.String r7 = r7.toLowerCase()
            r8 = 1
            java.lang.String r7 = com.original.tase.utils.Regex.a(r7, r3, r8)
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L_0x04f0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r1)
            java.lang.String r24 = r8.toString()
            goto L_0x04f2
        L_0x04f0:
            java.lang.String r24 = "HD"
        L_0x04f2:
            r1 = r24
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r9 = "User-Agent"
            java.lang.String r10 = com.original.Constants.C
            r8.put(r9, r10)
            java.lang.String r9 = "div.mobile-btn"
            org.jsoup.nodes.Element r9 = r6.r0(r9)     // Catch:{ all -> 0x05ac }
            java.lang.String r10 = "a[href]"
            org.jsoup.nodes.Element r9 = r9.r0(r10)     // Catch:{ all -> 0x05ac }
            java.lang.String r9 = r9.c(r5)     // Catch:{ all -> 0x05ac }
            boolean r10 = r9.startsWith(r14)     // Catch:{ all -> 0x05ac }
            if (r10 == 0) goto L_0x0531
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x052d }
            r10.<init>()     // Catch:{ all -> 0x052d }
            r11 = r26
            r10.append(r11)     // Catch:{ all -> 0x05a7 }
            r10.append(r9)     // Catch:{ all -> 0x05a7 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x05a7 }
            goto L_0x0533
        L_0x052d:
            r11 = r26
            goto L_0x05a7
        L_0x0531:
            r11 = r26
        L_0x0533:
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x05a7 }
            java.lang.String r9 = r10.o(r9, r4)     // Catch:{ all -> 0x05a7 }
            org.jsoup.nodes.Document r9 = org.jsoup.Jsoup.b(r9)     // Catch:{ all -> 0x05a7 }
            java.lang.String r10 = "div.dowload"
            org.jsoup.select.Elements r9 = r9.q0(r10)     // Catch:{ all -> 0x05a7 }
            r10 = r19
            org.jsoup.select.Elements r9 = r9.g(r10)     // Catch:{ all -> 0x05a2 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x05a2 }
        L_0x054f:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x05a2 }
            if (r12 == 0) goto L_0x05a2
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x05a2 }
            org.jsoup.nodes.Element r12 = (org.jsoup.nodes.Element) r12     // Catch:{ all -> 0x05a2 }
            java.lang.String r12 = r12.c(r5)     // Catch:{ all -> 0x05a2 }
            r7.add(r12)     // Catch:{ all -> 0x05a2 }
            boolean r15 = com.original.tase.helper.GoogleVideoHelper.n(r12)     // Catch:{ all -> 0x05a2 }
            r28 = r5
            com.original.tase.model.media.MediaSource r5 = new com.original.tase.model.media.MediaSource     // Catch:{ all -> 0x05a2 }
            r19 = r9
            java.lang.String r9 = r36.A()     // Catch:{ all -> 0x05a2 }
            if (r15 == 0) goto L_0x057b
            java.lang.String r20 = "GoogleVideo"
            r35 = r20
            r20 = r1
            r1 = r35
            goto L_0x057f
        L_0x057b:
            r20 = r1
            r1 = r17
        L_0x057f:
            r5.<init>(r9, r1, r13)     // Catch:{ all -> 0x05a4 }
            r5.setStreamLink(r12)     // Catch:{ all -> 0x05a4 }
            if (r15 == 0) goto L_0x058a
            r5.setPlayHeader(r8)     // Catch:{ all -> 0x05a4 }
        L_0x058a:
            if (r15 == 0) goto L_0x0591
            java.lang.String r1 = com.original.tase.helper.GoogleVideoHelper.h(r12)     // Catch:{ all -> 0x05a4 }
            goto L_0x0593
        L_0x0591:
            r1 = r20
        L_0x0593:
            r5.setQuality((java.lang.String) r1)     // Catch:{ all -> 0x05a4 }
            r1 = r37
            r1.onNext(r5)     // Catch:{ all -> 0x05b3 }
            r9 = r19
            r1 = r20
            r5 = r28
            goto L_0x054f
        L_0x05a2:
            r20 = r1
        L_0x05a4:
            r1 = r37
            goto L_0x05b3
        L_0x05a7:
            r20 = r1
            r10 = r19
            goto L_0x05a4
        L_0x05ac:
            r20 = r1
            r10 = r19
            r11 = r26
            goto L_0x05a4
        L_0x05b3:
            java.lang.String r5 = "div.les-content"
            org.jsoup.select.Elements r5 = r6.q0(r5)
            org.jsoup.select.Elements r5 = r5.g(r10)
            java.util.Iterator r5 = r5.iterator()
        L_0x05c1:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x068a
            java.lang.Object r6 = r5.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r9 = "player-data"
            java.lang.String r9 = r6.c(r9)
            if (r9 == 0) goto L_0x05db
            boolean r10 = r9.isEmpty()
            if (r10 == 0) goto L_0x05e1
        L_0x05db:
            java.lang.String r9 = "data"
            java.lang.String r9 = r6.c(r9)
        L_0x05e1:
            if (r29 != 0) goto L_0x05fd
            java.lang.String r10 = "episode-data"
            java.lang.String r6 = r6.c(r10)
            r10 = 1
            java.lang.String r6 = com.original.tase.utils.Regex.a(r6, r3, r10)
            boolean r10 = r6.isEmpty()
            if (r10 != 0) goto L_0x05c1
            java.lang.String r10 = r2.eps
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x05fd
            goto L_0x05c1
        L_0x05fd:
            boolean r6 = r9.startsWith(r14)
            if (r6 == 0) goto L_0x0612
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            r6.append(r9)
            java.lang.String r9 = r6.toString()
        L_0x0612:
            java.lang.String r6 = "load.php"
            boolean r6 = r9.contains(r6)
            if (r6 == 0) goto L_0x061b
            goto L_0x05c1
        L_0x061b:
            java.lang.String r6 = "vidcloud.icu"
            boolean r6 = r9.contains(r6)
            if (r6 == 0) goto L_0x0672
            java.util.ArrayList r6 = r0.n(r9, r4)
            java.util.Iterator r6 = r6.iterator()
        L_0x062b:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0686
            java.lang.Object r9 = r6.next()
            java.lang.String r9 = r9.toString()
            boolean r10 = r7.contains(r9)
            if (r10 != 0) goto L_0x066f
            r7.add(r9)
            boolean r10 = com.original.tase.helper.GoogleVideoHelper.n(r9)
            com.original.tase.model.media.MediaSource r12 = new com.original.tase.model.media.MediaSource
            java.lang.String r15 = r36.A()
            if (r10 == 0) goto L_0x0653
            java.lang.String r19 = "GoogleVideo"
            r2 = r19
            goto L_0x0655
        L_0x0653:
            r2 = r17
        L_0x0655:
            r12.<init>(r15, r2, r13)
            r12.setStreamLink(r9)
            if (r10 == 0) goto L_0x0660
            r12.setPlayHeader(r8)
        L_0x0660:
            if (r10 == 0) goto L_0x0667
            java.lang.String r2 = com.original.tase.helper.GoogleVideoHelper.h(r9)
            goto L_0x0669
        L_0x0667:
            r2 = r20
        L_0x0669:
            r12.setQuality((java.lang.String) r2)
            r1.onNext(r12)
        L_0x066f:
            r2 = r38
            goto L_0x062b
        L_0x0672:
            boolean r2 = r7.contains(r9)
            if (r2 != 0) goto L_0x0686
            r7.add(r9)
            r2 = 1
            boolean[] r6 = new boolean[r2]
            r10 = 0
            r6[r10] = r13
            r12 = r20
            r0.z(r1, r9, r12, r6)
        L_0x0686:
            r2 = r38
            goto L_0x05c1
        L_0x068a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.SeriesNine.J(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo):void");
    }
}

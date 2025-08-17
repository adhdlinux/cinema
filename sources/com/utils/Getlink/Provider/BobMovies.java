package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class BobMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37264e = Utils.getProvider(84);

    public String A() {
        return "BobMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0395, code lost:
        r1 = true;
        r13 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r23, com.movie.data.model.MovieInfo r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.Integer r3 = r24.getType()
            int r3 = r3.intValue()
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            java.lang.String r6 = r2.name
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = "+"
            java.lang.String r6 = com.original.tase.helper.TitleHelper.h(r6, r7)
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r0.f37264e
            r8.append(r9)
            java.lang.String r9 = "/"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.util.Map[] r10 = new java.util.Map[r4]
            r7.m(r8, r10)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.String r8 = "accept"
            java.lang.String r10 = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"
            r7.put(r8, r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r0.f37264e
            r8.append(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r10 = "referer"
            r7.put(r10, r8)
            java.lang.String r8 = "upgrade-insecure-requests"
            java.lang.String r11 = "1"
            r7.put(r8, r11)
            java.lang.String r8 = "user-agent"
            java.lang.String r11 = com.original.Constants.C
            r7.put(r8, r11)
            com.original.tase.helper.http.HttpHelper r8 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r0.f37264e
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            java.lang.String r8 = r8.g(r11)
            java.lang.String r11 = "cookie"
            r7.put(r11, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = r0.f37264e
            r8.append(r11)
            java.lang.String r11 = "/search-query/"
            r8.append(r11)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            com.original.tase.helper.http.HttpHelper r11 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r12 = new java.util.Map[r5]
            r12[r4] = r7
            java.lang.String r7 = r11.m(r8, r12)
            org.jsoup.nodes.Document r11 = org.jsoup.Jsoup.b(r7)
            java.lang.String r12 = "div.ml-item"
            org.jsoup.select.Elements r11 = r11.q0(r12)
            java.util.Iterator r11 = r11.iterator()
            boolean r13 = r11.hasNext()
            if (r13 != 0) goto L_0x00f2
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "https://api.ocloud.stream/series/movie/search/"
            r11.append(r13)
            r11.append(r6)
            java.lang.String r6 = "?link_web="
            r11.append(r6)
            java.lang.String r6 = r0.f37264e
            r11.append(r6)
            java.lang.String r6 = r11.toString()
            java.util.Map[] r11 = new java.util.Map[r4]
            java.lang.String r7 = r7.m(r6, r11)
            org.jsoup.nodes.Document r6 = org.jsoup.Jsoup.b(r7)
            org.jsoup.select.Elements r6 = r6.q0(r12)
            java.util.Iterator r11 = r6.iterator()
        L_0x00f2:
            java.lang.String r6 = r2.year
        L_0x00f4:
            boolean r12 = r11.hasNext()
            java.lang.String r13 = "a"
            java.lang.String r14 = ""
            java.lang.String r15 = "https:"
            java.lang.String r4 = "//"
            if (r12 == 0) goto L_0x0393
            java.lang.Object r12 = r11.next()
            org.jsoup.nodes.Element r12 = (org.jsoup.nodes.Element) r12
            org.jsoup.nodes.Element r12 = r12.r0(r13)
            java.lang.String r5 = "data-url"
            java.lang.String r5 = r12.c(r5)
            r18 = r6
            java.lang.String r6 = "title"
            java.lang.String r6 = r12.c(r6)
            boolean r19 = r6.isEmpty()
            if (r19 == 0) goto L_0x012a
            java.lang.String r6 = "h2"
            org.jsoup.nodes.Element r6 = r12.r0(r6)
            java.lang.String r6 = r6.v0()
        L_0x012a:
            r19 = r7
            java.lang.String r7 = "href"
            r20 = r11
            java.lang.String r11 = "http"
            if (r3 == 0) goto L_0x030a
            java.lang.String r14 = r2.name
            boolean r14 = r6.equals(r14)
            if (r14 == 0) goto L_0x0295
            boolean r6 = r5.isEmpty()
            java.lang.String r14 = "http:"
            if (r6 != 0) goto L_0x01dd
            boolean r6 = r5.startsWith(r4)
            if (r6 == 0) goto L_0x015a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r14)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L_0x018c
        L_0x015a:
            boolean r6 = r5.startsWith(r9)
            if (r6 == 0) goto L_0x0172
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = r0.f37264e
            r6.append(r1)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L_0x018c
        L_0x0172:
            boolean r1 = r5.startsWith(r11)
            if (r1 != 0) goto L_0x018c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = r0.f37264e
            r1.append(r6)
            r1.append(r9)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
        L_0x018c:
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "##forceNoCache##"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r21 = r13
            r6 = 1
            java.util.Map[] r13 = new java.util.Map[r6]
            java.util.HashMap r17 = com.original.Constants.c()
            r16 = 0
            r13[r16] = r17
            java.lang.String r1 = r1.r(r5, r8, r13)
            java.lang.String r5 = "\\\""
            java.lang.String r8 = "\""
            java.lang.String r1 = r1.replace(r5, r8)
            java.lang.String r5 = "\\/"
            java.lang.String r1 = r1.replace(r5, r9)
            java.lang.String r5 = "<div\\s+[^>]*class=\"jt-info\"[^>]*>\\s*(\\d{4})\\s*</div>"
            java.lang.String r5 = com.original.tase.utils.Regex.a(r1, r5, r6)
            java.lang.String r8 = "<div\\s+[^>]*class=\"jtip-quality\"[^>]*>\\s*([\\w\\s]+)\\s*</div>"
            java.lang.String r8 = com.original.tase.utils.Regex.a(r1, r8, r6)
            boolean r13 = r0.o(r8)
            r18 = r1
            java.lang.String r1 = "(\\d+)"
            java.lang.String r1 = com.original.tase.utils.Regex.a(r8, r1, r6)
            r1.isEmpty()
            r6 = r5
            goto L_0x01e4
        L_0x01dd:
            r21 = r13
            r6 = r18
            r18 = r19
            r13 = 0
        L_0x01e4:
            java.lang.String r1 = r2.year
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0244
            boolean r1 = r18.isEmpty()
            if (r1 == 0) goto L_0x01f3
            goto L_0x0244
        L_0x01f3:
            java.lang.String r1 = r12.c(r7)
            boolean r5 = r1.startsWith(r4)
            if (r5 == 0) goto L_0x020e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
        L_0x020c:
            r14 = r1
            goto L_0x0241
        L_0x020e:
            boolean r5 = r1.startsWith(r9)
            if (r5 == 0) goto L_0x0226
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.f37264e
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            goto L_0x020c
        L_0x0226:
            boolean r5 = r1.startsWith(r11)
            if (r5 != 0) goto L_0x020c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.f37264e
            r5.append(r6)
            r5.append(r9)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            goto L_0x020c
        L_0x0241:
            r1 = 0
            goto L_0x0397
        L_0x0244:
            java.lang.String r1 = r12.c(r7)
            boolean r5 = r1.startsWith(r4)
            if (r5 == 0) goto L_0x0260
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            r5.append(r1)
            java.lang.String r14 = r5.toString()
        L_0x025d:
            r1 = 1
            goto L_0x0397
        L_0x0260:
            boolean r5 = r1.startsWith(r9)
            if (r5 == 0) goto L_0x0278
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.f37264e
            r5.append(r6)
            r5.append(r1)
            java.lang.String r14 = r5.toString()
            goto L_0x025d
        L_0x0278:
            boolean r5 = r1.startsWith(r11)
            if (r5 != 0) goto L_0x0293
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.f37264e
            r5.append(r6)
            r5.append(r9)
            r5.append(r1)
            java.lang.String r14 = r5.toString()
            goto L_0x025d
        L_0x0293:
            r14 = r1
            goto L_0x025d
        L_0x0295:
            r21 = r13
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r2.name
            r1.append(r5)
            java.lang.String r5 = " ("
            r1.append(r5)
            java.lang.String r5 = r2.year
            r1.append(r5)
            java.lang.String r5 = ")"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0387
            java.lang.String r14 = r12.c(r7)
            boolean r1 = r14.startsWith(r4)
            if (r1 == 0) goto L_0x02d5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            goto L_0x0395
        L_0x02d5:
            boolean r1 = r14.startsWith(r9)
            if (r1 == 0) goto L_0x02ee
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r0.f37264e
            r1.append(r5)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            goto L_0x0395
        L_0x02ee:
            boolean r1 = r14.startsWith(r11)
            if (r1 != 0) goto L_0x0395
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r0.f37264e
            r1.append(r5)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            goto L_0x0395
        L_0x030a:
            r21 = r13
            java.lang.String r1 = r6.toLowerCase()
            java.lang.String r1 = com.original.tase.helper.TitleHelper.h(r1, r14)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r2.name
            java.lang.String r6 = r6.toLowerCase()
            r5.append(r6)
            java.lang.String r6 = " season "
            r5.append(r6)
            java.lang.String r6 = r2.session
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = com.original.tase.helper.TitleHelper.h(r5, r14)
            boolean r1 = r1.startsWith(r5)
            if (r1 == 0) goto L_0x0387
            java.lang.String r14 = r12.c(r7)
            boolean r1 = r14.startsWith(r4)
            if (r1 == 0) goto L_0x0354
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            goto L_0x0395
        L_0x0354:
            boolean r1 = r14.startsWith(r9)
            if (r1 == 0) goto L_0x036c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r0.f37264e
            r1.append(r5)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            goto L_0x0395
        L_0x036c:
            boolean r1 = r14.startsWith(r11)
            if (r1 != 0) goto L_0x0395
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r0.f37264e
            r1.append(r5)
            r1.append(r9)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            goto L_0x0395
        L_0x0387:
            r1 = r23
            r6 = r18
            r7 = r19
            r11 = r20
            r4 = 0
            r5 = 1
            goto L_0x00f4
        L_0x0393:
            r21 = r13
        L_0x0395:
            r1 = 1
            r13 = 0
        L_0x0397:
            boolean r5 = r14.isEmpty()
            if (r5 == 0) goto L_0x039e
            return
        L_0x039e:
            java.lang.String r5 = ".html"
            boolean r5 = r14.endsWith(r5)
            if (r5 == 0) goto L_0x03b2
            int r5 = r14.length()
            int r5 = r5 + -5
            r6 = 0
            java.lang.String r5 = r14.substring(r6, r5)
            goto L_0x03b4
        L_0x03b2:
            r6 = 0
            r5 = r14
        L_0x03b4:
            boolean r7 = r5.endsWith(r9)
            if (r7 == 0) goto L_0x03c4
            int r7 = r5.length()
            r8 = 1
            int r7 = r7 - r8
            java.lang.String r5 = r5.substring(r6, r7)
        L_0x03c4:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "/watching.html"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r6 = r6.o(r5, r14)
            if (r1 != 0) goto L_0x03f1
            if (r3 == 0) goto L_0x03f1
            java.lang.String r1 = "tag\"[^>]*>(\\d{4})"
            r7 = 1
            java.lang.String r1 = com.original.tase.utils.Regex.a(r6, r1, r7)
            java.lang.String r7 = r2.year
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x03f1
            return
        L_0x03f1:
            java.util.HashMap r1 = com.original.Constants.c()
            r1.put(r10, r5)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r6)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "User-Agent"
            java.lang.String r7 = com.original.Constants.C
            r5.put(r6, r7)
            java.lang.String r5 = "div.les-content"
            org.jsoup.select.Elements r1 = r1.q0(r5)
            r5 = r21
            org.jsoup.select.Elements r1 = r1.g(r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x0418:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0491
            java.lang.Object r5 = r1.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            java.lang.String r6 = "HD"
            java.lang.String r7 = "load_episode_video\\(['\"]([^'\"]+)['\"]"
            if (r3 == 0) goto L_0x0453
            java.lang.String r5 = r5.toString()
            r8 = 1
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r7, r8)
            boolean r7 = r5.startsWith(r4)
            if (r7 == 0) goto L_0x0448
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r15)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
        L_0x0448:
            boolean[] r7 = new boolean[r8]
            r9 = 0
            r7[r9] = r13
            r9 = r23
            r0.z(r9, r5, r6, r7)
            goto L_0x0418
        L_0x0453:
            r9 = r23
            r8 = 1
            java.lang.String r10 = "episode-id"
            java.lang.String r10 = r5.c(r10)
            int r10 = java.lang.Integer.parseInt(r10)
            int r10 = r10 + r8
            java.lang.String r11 = r2.eps
            int r11 = java.lang.Integer.parseInt(r11)
            if (r10 != r11) goto L_0x048f
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r7, r8)
            boolean r7 = r5.startsWith(r4)
            if (r7 == 0) goto L_0x0486
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r15)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
        L_0x0486:
            boolean[] r7 = new boolean[r8]
            r10 = 0
            r7[r10] = r13
            r0.z(r9, r5, r6, r7)
            goto L_0x0418
        L_0x048f:
            r10 = 0
            goto L_0x0418
        L_0x0491:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.BobMovies.J(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo):void");
    }
}

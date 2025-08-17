package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;

public class AllRelease extends BaseProvider {

    /* renamed from: g  reason: collision with root package name */
    public static String f37240g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f37241h = "";

    /* renamed from: e  reason: collision with root package name */
    public int f37242e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f37243f = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r3 != 20) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean J(com.movie.data.model.MovieInfo r17, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r18, java.util.ArrayList<java.lang.String> r19, int r20, boolean r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r20
            java.util.Iterator r4 = r19.iterator()
            r6 = 0
        L_0x000d:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0362
            java.lang.Object r7 = r4.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "HD"
            r9 = 1
            if (r3 == 0) goto L_0x0323
            java.lang.String r10 = "http:"
            java.lang.String r11 = "<span\\s*class=\\\"d\\\">(\\w+)<\\/span>"
            java.lang.String r12 = "li.elemento"
            java.lang.String r13 = "//"
            java.lang.String r14 = "a"
            java.lang.String r15 = "href"
            if (r3 == r9) goto L_0x0259
            r5 = 2
            if (r3 == r5) goto L_0x0220
            r5 = 3
            if (r3 == r5) goto L_0x01e8
            r5 = 5
            if (r3 == r5) goto L_0x015c
            r5 = 7
            if (r3 == r5) goto L_0x00a0
            r5 = 10
            if (r3 == r5) goto L_0x0041
            r5 = 20
            if (r3 == r5) goto L_0x0259
            goto L_0x009d
        L_0x0041:
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r10 = f37240g
            java.lang.String r5 = r5.o(r7, r10)
            java.lang.String r10 = "<iframe[^>]+src=\"([^\"]+)\"[^>]*>"
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r10, r9)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r5 = r10.o(r5, r7)
            java.lang.String r7 = "source\\s*src\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]"
            java.util.ArrayList r5 = com.original.tase.utils.Regex.f(r5, r7, r9, r9)
            r7 = 0
            java.lang.Object r5 = r5.get(r7)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x006a:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x009d
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = com.original.tase.helper.GoogleVideoHelper.n(r7)
            com.original.tase.model.media.MediaSource r10 = new com.original.tase.model.media.MediaSource
            java.lang.String r11 = r16.A()
            if (r9 == 0) goto L_0x0085
            java.lang.String r12 = "GoogleVideo"
            goto L_0x0087
        L_0x0085:
            java.lang.String r12 = "CDN-FastServer"
        L_0x0087:
            r13 = 0
            r10.<init>(r11, r12, r13)
            r10.setStreamLink(r7)
            if (r9 == 0) goto L_0x0095
            java.lang.String r7 = com.original.tase.helper.GoogleVideoHelper.h(r7)
            goto L_0x0096
        L_0x0095:
            r7 = r8
        L_0x0096:
            r10.setQuality((java.lang.String) r7)
            r2.onNext(r10)
            goto L_0x006a
        L_0x009d:
            r10 = 0
            goto L_0x035e
        L_0x00a0:
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r9 = f37240g
            java.lang.String r5 = r5.o(r7, r9)
            org.jsoup.nodes.Document r5 = org.jsoup.Jsoup.b(r5)
            org.jsoup.select.Elements r7 = r5.q0(r12)
            org.jsoup.select.Elements r7 = r7.g(r14)
            java.util.Iterator r7 = r7.iterator()
        L_0x00ba:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0107
            java.lang.Object r6 = r7.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r9 = r6.toString()
            r12 = 1
            java.lang.String r9 = com.original.tase.utils.Regex.a(r9, r11, r12)
            f37241h = r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00d9
            f37241h = r8
        L_0x00d9:
            java.lang.String r9 = f37241h
            boolean r9 = r0.o(r9)
            java.lang.String r6 = r6.c(r15)
            boolean r12 = r6.startsWith(r13)
            if (r12 == 0) goto L_0x00f8
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            r12.append(r6)
            java.lang.String r6 = r12.toString()
        L_0x00f8:
            java.lang.String r12 = f37241h
            r14 = 1
            boolean[] r3 = new boolean[r14]
            r14 = 0
            r3[r14] = r9
            r0.z(r2, r6, r12, r3)
            r3 = r20
            r6 = 1
            goto L_0x00ba
        L_0x0107:
            java.lang.String r3 = "div.movieplay"
            org.jsoup.select.Elements r3 = r5.q0(r3)
            java.lang.String r5 = "script"
            org.jsoup.select.Elements r3 = r3.g(r5)
            java.util.Iterator r3 = r3.iterator()
        L_0x0117:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x009d
            java.lang.Object r5 = r3.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            java.util.List r5 = r5.j()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "['\"]([^'\"]+[^'\"])['\"]"
            r7 = 1
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r6, r7)
            java.lang.String r6 = "@|g"
            java.lang.String r7 = "%"
            java.lang.String r5 = r5.replaceAll(r6, r7)
            java.lang.String r6 = "UTF-8"
            java.lang.String r5 = java.net.URLDecoder.decode(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0141 }
            goto L_0x0145
        L_0x0141:
            java.lang.String r5 = java.net.URLDecoder.decode(r5)
        L_0x0145:
            java.lang.String r6 = "src=['\"]([^'\"]+[^'\"])['\"]"
            r7 = 1
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r6, r7)
            java.lang.String r6 = f37241h
            boolean[] r8 = new boolean[r7]
            boolean r7 = r0.o(r6)
            r9 = 0
            r8[r9] = r7
            r0.z(r2, r5, r6, r8)
            r6 = 1
            goto L_0x0117
        L_0x015c:
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r5 = f37240g
            java.lang.String r3 = r3.o(r7, r5)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r5 = "div.entry-content"
            org.jsoup.select.Elements r3 = r3.q0(r5)
            org.jsoup.select.Elements r3 = r3.g(r14)
            java.util.Iterator r3 = r3.iterator()
            java.lang.String r5 = f37241h
            boolean r5 = r0.o(r5)
        L_0x017e:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x009d
            java.lang.Object r9 = r3.next()
            org.jsoup.nodes.Element r9 = (org.jsoup.nodes.Element) r9
            java.lang.String r10 = r9.v0()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x0195
            goto L_0x017e
        L_0x0195:
            java.lang.String r9 = r9.c(r15)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r9 = r10.o(r9, r7)
            org.jsoup.nodes.Document r10 = org.jsoup.Jsoup.b(r9)
            java.lang.String r11 = "p"
            org.jsoup.select.Elements r10 = r10.q0(r11)
            java.lang.String r11 = "a[target]"
            org.jsoup.select.Elements r10 = r10.g(r11)
            java.util.Iterator r10 = r10.iterator()
            boolean r12 = r10.hasNext()
            if (r12 != 0) goto L_0x01cd
            org.jsoup.nodes.Document r9 = org.jsoup.Jsoup.b(r9)
            java.lang.String r10 = "li"
            org.jsoup.select.Elements r9 = r9.q0(r10)
            org.jsoup.select.Elements r9 = r9.g(r11)
            java.util.Iterator r10 = r9.iterator()
        L_0x01cd:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x017e
            java.lang.Object r6 = r10.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r6 = r6.c(r15)
            r9 = 1
            boolean[] r11 = new boolean[r9]
            r12 = 0
            r11[r12] = r5
            r0.z(r2, r6, r8, r11)
            r6 = 1
            goto L_0x01cd
        L_0x01e8:
            r12 = 0
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r5 = f37240g
            java.lang.String r3 = r3.o(r7, r5)
            java.lang.String r5 = "data-href\\s*=\\s*\\\\['\"]([^'\"]+[^'\"]*)\\\\['\"]"
            java.util.ArrayList r3 = com.original.tase.utils.Regex.f(r3, r5, r9, r9)
            java.lang.Object r3 = r3.get(r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r3 = r3.iterator()
            java.lang.String r5 = f37241h
            boolean r5 = r0.o(r5)
        L_0x0209:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x009d
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean[] r7 = new boolean[r9]
            r7[r12] = r5
            r0.z(r2, r6, r8, r7)
            r6 = 1
            r9 = 1
            r12 = 0
            goto L_0x0209
        L_0x0220:
            java.lang.String r3 = f37240g
            java.lang.String r3 = com.original.tase.helper.http.sucuri.SucuriCloudProxyHelper.d(r3, r7)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r5 = "table.source-links"
            org.jsoup.select.Elements r3 = r3.q0(r5)
            org.jsoup.select.Elements r3 = r3.g(r14)
            java.util.Iterator r3 = r3.iterator()
            java.lang.String r5 = f37241h
            boolean r5 = r0.o(r5)
        L_0x023e:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x009d
            java.lang.Object r6 = r3.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r6 = r6.c(r15)
            r7 = 1
            boolean[] r9 = new boolean[r7]
            r7 = 0
            r9[r7] = r5
            r0.z(r2, r6, r8, r9)
            r6 = 1
            goto L_0x023e
        L_0x0259:
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r5 = f37240g
            java.lang.String r3 = r3.o(r7, r5)
            if (r21 == 0) goto L_0x0276
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            org.jsoup.select.Elements r3 = r3.q0(r12)
            org.jsoup.select.Elements r3 = r3.g(r14)
            java.util.Iterator r3 = r3.iterator()
            goto L_0x02d8
        L_0x0276:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "href\\s*=\\s*['\"]([^'\"]+[^'\"]*"
            r5.append(r9)
            java.lang.String r9 = r1.session
            r5.append(r9)
            java.lang.String r9 = "x"
            r5.append(r9)
            java.lang.String r9 = r1.eps
            r5.append(r9)
            java.lang.String r9 = ")['\"]"
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r9 = 1
            java.lang.String r3 = com.original.tase.utils.Regex.a(r3, r5, r9)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x02a5
            goto L_0x035e
        L_0x02a5:
            boolean r5 = r3.startsWith(r13)
            if (r5 == 0) goto L_0x02bc
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "https:"
            r3.append(r5)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
        L_0x02bc:
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r3 = r5.o(r3, r7)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r5 = "div.linkstv"
            org.jsoup.select.Elements r3 = r3.q0(r5)
            java.lang.String r5 = "a[href]"
            org.jsoup.select.Elements r3 = r3.g(r5)
            java.util.Iterator r3 = r3.iterator()
        L_0x02d8:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x009d
            java.lang.Object r5 = r3.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            java.lang.String r6 = r5.toString()
            r7 = 1
            java.lang.String r6 = com.original.tase.utils.Regex.a(r6, r11, r7)
            f37241h = r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x02f7
            f37241h = r8
        L_0x02f7:
            java.lang.String r6 = f37241h
            boolean r6 = r0.o(r6)
            java.lang.String r5 = r5.c(r15)
            boolean r7 = r5.startsWith(r13)
            if (r7 == 0) goto L_0x0316
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r10)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
        L_0x0316:
            java.lang.String r7 = f37241h
            r9 = 1
            boolean[] r12 = new boolean[r9]
            r9 = 0
            r12[r9] = r6
            r0.z(r2, r5, r7, r12)
            r6 = 1
            goto L_0x02d8
        L_0x0323:
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r5 = f37240g
            java.lang.String r3 = r3.o(r7, r5)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r5 = "iframe[src]"
            org.jsoup.select.Elements r3 = r3.q0(r5)
            java.util.Iterator r3 = r3.iterator()
            java.lang.String r5 = f37241h
            boolean r5 = r0.o(r5)
        L_0x0341:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x009d
            java.lang.Object r6 = r3.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r7 = "src"
            java.lang.String r6 = r6.c(r7)
            r7 = 1
            boolean[] r9 = new boolean[r7]
            r10 = 0
            r9[r10] = r5
            r0.z(r2, r6, r8, r9)
            r6 = 1
            goto L_0x0341
        L_0x035e:
            r3 = r20
            goto L_0x000d
        L_0x0362:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.AllRelease.J(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter, java.util.ArrayList, int, boolean):boolean");
    }

    public String A() {
        if (this.f37243f == -1) {
            return "AllRelease";
        }
        return "All-Release" + Utils.i(this.f37243f);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37243f = -1;
        int i2 = this.f37242e;
        while (true) {
            int i3 = this.f37243f;
            if (i2 != i3) {
                if (i3 == -1) {
                    this.f37243f = i2;
                }
                ArrayList<String> K = K(movieInfo, this.f37243f, true);
                if (!K.isEmpty()) {
                    J(movieInfo, observableEmitter, K, this.f37243f, true);
                }
                int i4 = this.f37243f + 1;
                this.f37243f = i4;
                if (i4 == com.utils.Utils.f37630w) {
                    this.f37243f = 0;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37243f = -1;
        int i2 = this.f37242e;
        while (true) {
            int i3 = this.f37243f;
            if (i2 != i3) {
                if (i3 == -1) {
                    this.f37243f = i2;
                }
                ArrayList<String> K = K(movieInfo, this.f37243f, false);
                if (!K.isEmpty()) {
                    J(movieInfo, observableEmitter, K, this.f37243f, false);
                }
                int i4 = this.f37243f + 1;
                this.f37243f = i4;
                if (i4 == com.utils.Utils.f37630w) {
                    this.f37243f = 0;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        if (r1 != 20) goto L_0x057b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0105, code lost:
        if (r21 == false) goto L_0x057b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x041b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> K(com.movie.data.model.MovieInfo r19, int r20, boolean r21) {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = com.utils.Utils.Z(r20)
            f37240g = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AllRelease BASE_URL "
            r2.append(r3)
            java.lang.String r3 = f37240g
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.original.tase.Logger.a(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = "accept"
            java.lang.String r5 = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"
            r3.put(r4, r5)
            java.lang.String r4 = "/?s=%s"
            java.lang.String r5 = "h2"
            java.lang.String r6 = "referer"
            java.lang.String r7 = "a"
            java.lang.String r8 = "HD"
            java.lang.String r9 = "href"
            java.lang.String r10 = "/"
            r11 = 1
            if (r1 == 0) goto L_0x04b1
            java.lang.String r13 = ")"
            java.lang.String r14 = " ("
            java.lang.String r15 = ""
            if (r1 == r11) goto L_0x0362
            r11 = 2
            java.lang.String r12 = " "
            if (r1 == r11) goto L_0x0284
            r11 = 3
            r17 = r5
            java.lang.String r5 = "title"
            if (r1 == r11) goto L_0x01bb
            r11 = 5
            if (r1 == r11) goto L_0x0109
            r5 = 7
            if (r1 == r5) goto L_0x0105
            r5 = 10
            if (r1 == r5) goto L_0x0066
            r5 = 20
            if (r1 == r5) goto L_0x0364
            goto L_0x057b
        L_0x0066:
            if (r21 != 0) goto L_0x006a
            goto L_0x057b
        L_0x006a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = f37240g
            r1.append(r4)
            java.lang.String r4 = "/search?s=%s"
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = r0.name
            java.lang.String r4 = r4.toLowerCase()
            r5 = 0
            boolean[] r11 = new boolean[r5]
            java.lang.String r4 = com.original.tase.utils.Utils.k(r4, r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = f37240g
            r11.append(r12)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r3.put(r6, r11)
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]
            r12[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r12)
            java.util.Map[] r4 = new java.util.Map[r11]
            r4[r5] = r3
            java.lang.String r1 = r6.m(r1, r4)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r3 = "div.movie-title"
            org.jsoup.select.Elements r1 = r1.q0(r3)
            org.jsoup.select.Elements r1 = r1.g(r7)
            java.util.Iterator r1 = r1.iterator()
        L_0x00c5:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x057b
            java.lang.Object r3 = r1.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = r3.v0()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x00dc
            goto L_0x00c5
        L_0x00dc:
            f37241h = r8
            java.lang.String r5 = r0.name
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c5
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x0101
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = f37240g
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x0101:
            r2.add(r3)
            goto L_0x00c5
        L_0x0105:
            if (r21 != 0) goto L_0x0364
            goto L_0x057b
        L_0x0109:
            if (r21 != 0) goto L_0x010d
            goto L_0x057b
        L_0x010d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = f37240g
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = r0.name
            java.lang.String r3 = r3.toLowerCase()
            r4 = 0
            boolean[] r6 = new boolean[r4]
            java.lang.String r3 = com.original.tase.utils.Utils.k(r3, r6)
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r4] = r3
            java.lang.String r1 = java.lang.String.format(r1, r7)
            java.lang.String r3 = f37240g
            java.lang.String r1 = r6.o(r1, r3)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r3 = "div.bw_thumb_title"
            org.jsoup.select.Elements r1 = r1.q0(r3)
            java.lang.String r3 = "a[href]"
            org.jsoup.select.Elements r1 = r1.g(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0152:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x057b
            java.lang.Object r3 = r1.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = r3.c(r5)
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x0169
            goto L_0x0152
        L_0x0169:
            f37241h = r4
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x0173
            f37241h = r8
        L_0x0173:
            if (r21 == 0) goto L_0x0152
            java.lang.String r4 = com.original.tase.helper.TitleHelper.h(r4, r15)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r19.getName()
            java.lang.String r7 = com.original.tase.helper.TitleHelper.e(r7)
            r6.append(r7)
            java.lang.String r7 = r0.year
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = com.original.tase.helper.TitleHelper.h(r6, r15)
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x0152
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x01b7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = f37240g
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x01b7:
            r2.add(r3)
            goto L_0x0152
        L_0x01bb:
            if (r21 != 0) goto L_0x01bf
            goto L_0x057b
        L_0x01bf:
            com.original.tase.helper.DateTimeHelper.g()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r0.name
            java.lang.String r3 = r3.toLowerCase()
            r4 = 0
            boolean[] r7 = new boolean[r4]
            java.lang.String r3 = com.original.tase.utils.Utils.k(r3, r7)
            r1.append(r3)
            r1.append(r12)
            java.lang.String r3 = r0.year
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = f37240g
            r4.append(r7)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r3.put(r6, r4)
            java.lang.String r4 = "upgrade-insecure-requests"
            java.lang.String r6 = "1"
            r3.put(r4, r6)
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r11 = 0
            r7[r11] = r1
            java.lang.String r1 = java.lang.String.format(r15, r7)
            java.util.Map[] r6 = new java.util.Map[r6]
            r6[r11] = r3
            java.lang.String r1 = r4.m(r1, r6)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r3 = "div.thumb"
            org.jsoup.select.Elements r1 = r1.q0(r3)
            java.lang.String r3 = "a.clip-link"
            org.jsoup.select.Elements r1 = r1.g(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x022d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x057b
            java.lang.Object r3 = r1.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = r3.c(r5)
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x0244
            goto L_0x022d
        L_0x0244:
            f37241h = r8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r0.name
            r6.append(r7)
            r6.append(r14)
            java.lang.String r7 = r0.year
            r6.append(r7)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            boolean r4 = r4.startsWith(r6)
            if (r4 == 0) goto L_0x022d
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x0280
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = f37240g
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x0280:
            r2.add(r3)
            goto L_0x022d
        L_0x0284:
            if (r21 != 0) goto L_0x0288
            goto L_0x057b
        L_0x0288:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = f37240g
            r1.append(r3)
            java.lang.String r3 = "/index.php?s=%s"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = r0.name
            java.lang.String r3 = r3.toLowerCase()
            r4 = 0
            boolean[] r5 = new boolean[r4]
            java.lang.String r3 = com.original.tase.utils.Utils.k(r3, r5)
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r6[r4] = r3
            java.lang.String r1 = java.lang.String.format(r1, r6)
            java.lang.String r3 = f37240g
            java.lang.String r1 = com.original.tase.helper.http.sucuri.SucuriCloudProxyHelper.d(r3, r1)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r3 = "h1"
            org.jsoup.select.Elements r1 = r1.q0(r3)
            org.jsoup.select.Elements r1 = r1.g(r7)
            java.util.Iterator r1 = r1.iterator()
            r16 = 0
        L_0x02cb:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0324
            java.lang.Object r3 = r1.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = r3.v0()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x02e2
            goto L_0x02cb
        L_0x02e2:
            f37241h = r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.name
            r5.append(r6)
            r5.append(r14)
            java.lang.String r6 = r0.year
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x02cb
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x031e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = f37240g
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x031e:
            r2.add(r3)
            r16 = 1
            goto L_0x02cb
        L_0x0324:
            if (r16 != 0) goto L_0x057b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = f37240g
            r1.append(r3)
            r1.append(r10)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.name
            java.lang.String r4 = r4.toLowerCase()
            r3.append(r4)
            r3.append(r12)
            java.lang.String r0 = r0.year
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "-"
            java.lang.String r0 = com.original.tase.helper.TitleHelper.h(r0, r3)
            r1.append(r0)
            r1.append(r10)
            java.lang.String r0 = r1.toString()
            r2.add(r0)
            goto L_0x057b
        L_0x0362:
            r17 = r5
        L_0x0364:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = f37240g
            r1.append(r5)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = r0.name
            java.lang.String r4 = r4.toLowerCase()
            r5 = 0
            boolean[] r11 = new boolean[r5]
            java.lang.String r4 = com.original.tase.utils.Utils.k(r4, r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = f37240g
            r11.append(r12)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r3.put(r6, r11)
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]
            r12[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r12)
            java.util.Map[] r4 = new java.util.Map[r11]
            r4[r5] = r3
            java.lang.String r1 = r6.m(r1, r4)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r3 = "div.item"
            org.jsoup.select.Elements r1 = r1.q0(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x03b9:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x057b
            java.lang.Object r3 = r1.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = "span.tt"
            org.jsoup.nodes.Element r5 = r3.r0(r4)
            if (r5 == 0) goto L_0x03d6
            org.jsoup.nodes.Element r4 = r3.r0(r4)
            java.lang.String r4 = r4.v0()
            goto L_0x03d7
        L_0x03d6:
            r4 = r15
        L_0x03d7:
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0402
            r5 = r17
            org.jsoup.nodes.Element r4 = r3.r0(r5)
            if (r4 == 0) goto L_0x03ff
            org.jsoup.nodes.Element r4 = r3.r0(r5)
            java.lang.String r4 = r4.v0()
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x0404
            java.lang.String r4 = r3.toString()
            java.lang.String r6 = "<h2>(.+)<\\/h2>"
            r11 = 1
            java.lang.String r4 = com.original.tase.utils.Regex.a(r4, r6, r11)
            goto L_0x0405
        L_0x03ff:
            r17 = r5
            goto L_0x03b9
        L_0x0402:
            r5 = r17
        L_0x0404:
            r11 = 1
        L_0x0405:
            java.lang.String r6 = r3.toString()
            java.lang.String r12 = "<span\\s*class=\\\"calidad2\\\">(\\w+)<\\/span>"
            java.lang.String r6 = com.original.tase.utils.Regex.a(r6, r12, r11)
            f37241h = r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0419
            f37241h = r8
        L_0x0419:
            if (r21 == 0) goto L_0x0485
            java.lang.String r6 = com.original.tase.helper.TitleHelper.f(r4)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r19.getName()
            java.lang.String r12 = com.original.tase.helper.TitleHelper.e(r12)
            r11.append(r12)
            java.lang.String r12 = r0.year
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r11)
            boolean r6 = r6.startsWith(r11)
            if (r6 != 0) goto L_0x0461
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = r0.name
            r6.append(r11)
            r6.append(r14)
            java.lang.String r11 = r0.year
            r6.append(r11)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            boolean r4 = r4.startsWith(r6)
            if (r4 == 0) goto L_0x03ff
        L_0x0461:
            org.jsoup.nodes.Element r3 = r3.r0(r7)
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x0480
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = f37240g
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x0480:
            r2.add(r3)
            goto L_0x03ff
        L_0x0485:
            java.lang.String r6 = r0.name
            boolean r4 = r4.equalsIgnoreCase(r6)
            if (r4 == 0) goto L_0x03ff
            org.jsoup.nodes.Element r3 = r3.r0(r7)
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x04ac
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = f37240g
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x04ac:
            r2.add(r3)
            goto L_0x03ff
        L_0x04b1:
            if (r21 != 0) goto L_0x04b5
            goto L_0x057b
        L_0x04b5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r11 = f37240g
            r1.append(r11)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = r0.name
            java.lang.String r4 = r4.toLowerCase()
            r11 = 0
            boolean[] r12 = new boolean[r11]
            java.lang.String r4 = com.original.tase.utils.Utils.k(r4, r12)
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r13 = f37240g
            java.util.Map[] r14 = new java.util.Map[r11]
            r12.m(r13, r14)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = f37240g
            r12.append(r13)
            r12.append(r10)
            java.lang.String r12 = r12.toString()
            r3.put(r6, r12)
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r12 = 1
            java.lang.Object[] r13 = new java.lang.Object[r12]
            r13[r11] = r4
            java.lang.String r1 = java.lang.String.format(r1, r13)
            java.util.Map[] r4 = new java.util.Map[r12]
            r4[r11] = r3
            java.lang.String r1 = r6.m(r1, r4)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r3 = "div.ml-item"
            org.jsoup.select.Elements r1 = r1.q0(r3)
            org.jsoup.select.Elements r1 = r1.g(r7)
            java.util.Iterator r1 = r1.iterator()
        L_0x0519:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x057b
            java.lang.Object r3 = r1.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = "oldtitle"
            java.lang.String r4 = r3.c(r4)
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x053f
            org.jsoup.nodes.Element r4 = r3.r0(r5)
            if (r4 == 0) goto L_0x0519
            org.jsoup.nodes.Element r4 = r3.r0(r5)
            java.lang.String r4 = r4.v0()
        L_0x053f:
            java.lang.String r6 = r3.toString()
            java.lang.String r7 = "<span\\s*class=\\\"mli-quality\\\">(\\w+)<\\/span>"
            r11 = 1
            java.lang.String r6 = com.original.tase.utils.Regex.a(r6, r7, r11)
            f37241h = r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0554
            f37241h = r8
        L_0x0554:
            java.lang.String r6 = r0.name
            boolean r4 = r4.equalsIgnoreCase(r6)
            if (r4 == 0) goto L_0x0519
            java.lang.String r3 = r3.c(r9)
            boolean r4 = r3.startsWith(r10)
            if (r4 == 0) goto L_0x0577
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = f37240g
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x0577:
            r2.add(r3)
            goto L_0x0519
        L_0x057b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.AllRelease.K(com.movie.data.model.MovieInfo, int, boolean):java.util.ArrayList");
    }
}

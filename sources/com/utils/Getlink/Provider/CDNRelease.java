package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class CDNRelease extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String[] f37270e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f37271f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f37272g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f37273h = 0;

    private static String[] M() {
        String str = GlobalVariable.c().b().getCbflist().get("CDNRelease");
        if (str == null || str.isEmpty()) {
            return Utils.getProvider(33).split(",");
        }
        return str.split(",");
    }

    public String A() {
        if (this.f37272g == -1) {
            return "CDNRelease";
        }
        return "CDNRelease" + com.original.tase.utils.Utils.i(this.f37272g);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37270e = M();
        if (!Utils.f37609b && !BaseProvider.v()) {
            J(movieInfo, observableEmitter);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0198, code lost:
        if (r13.isEmpty() != false) goto L_0x019a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(com.movie.data.model.MovieInfo r20, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = r20.getName()
            r3 = 0
            boolean[] r4 = new boolean[r3]
            java.lang.String r2 = com.original.tase.utils.Utils.k(r2, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "Accept"
            java.lang.String r7 = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"
            r5.put(r6, r7)
            java.lang.String r6 = com.original.Constants.C
            java.lang.String r7 = "User-Agent"
            r5.put(r7, r6)
            com.original.tase.helper.DirectoryIndexHelper r6 = new com.original.tase.helper.DirectoryIndexHelper
            r6.<init>()
            r8 = -1
            r0.f37272g = r8
            r8 = 0
        L_0x0030:
            java.lang.String[] r9 = r0.f37270e
            int r9 = r9.length
            if (r8 >= r9) goto L_0x025c
            int r9 = r8 / 2
            r0.f37272g = r9
            boolean r9 = r21.isDisposed()
            if (r9 == 0) goto L_0x0040
            return
        L_0x0040:
            java.lang.String[] r9 = r0.f37270e
            r9 = r9[r8]
            java.lang.String r10 = "(http.+\\.\\w+)\\/"
            r11 = 1
            java.lang.String r10 = com.original.tase.utils.Regex.a(r9, r10, r11)
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r13 = new java.util.Map[r3]
            java.lang.String r12 = r12.m(r10, r13)
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r13 = r13.g(r10)
            boolean r14 = r13.isEmpty()
            if (r14 != 0) goto L_0x0068
            java.lang.String r14 = "cookie"
            r4.put(r14, r13)
        L_0x0068:
            java.lang.String r12 = com.utils.Getlink.Provider.BaseProvider.k(r12, r10)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            java.lang.String r14 = "/"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "referer"
            r4.put(r14, r13)
            boolean r13 = r12.isEmpty()
            if (r13 != 0) goto L_0x009a
            java.lang.String r13 = "cdn-cgi/l"
            boolean r13 = r12.contains(r13)
            if (r13 == 0) goto L_0x0091
            goto L_0x009a
        L_0x0091:
            java.lang.Object[] r13 = new java.lang.Object[r11]
            r13[r3] = r2
            java.lang.String r12 = java.lang.String.format(r12, r13)
            goto L_0x00a9
        L_0x009a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r9)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
        L_0x00a9:
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r14 = new java.util.Map[r11]
            r14[r3] = r4
            java.lang.String r12 = r13.m(r12, r14)
            boolean r13 = r12.isEmpty()
            if (r13 == 0) goto L_0x00c1
            r3 = r21
            r18 = r2
            goto L_0x0255
        L_0x00c1:
            int r13 = r0.f37273h
            r14 = 3
            if (r13 <= r14) goto L_0x00c7
            return
        L_0x00c7:
            java.lang.String r13 = ""
            org.jsoup.nodes.Document r12 = org.jsoup.Jsoup.b(r12)     // Catch:{ all -> 0x0182 }
            java.lang.String r14 = "h2"
            org.jsoup.select.Elements r12 = r12.q0(r14)     // Catch:{ all -> 0x0182 }
            java.lang.String r14 = "a[href]"
            org.jsoup.select.Elements r12 = r12.g(r14)     // Catch:{ all -> 0x0182 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0182 }
        L_0x00dd:
            boolean r14 = r12.hasNext()     // Catch:{ all -> 0x0182 }
            if (r14 == 0) goto L_0x017f
            java.lang.Object r14 = r12.next()     // Catch:{ all -> 0x0177 }
            org.jsoup.nodes.Element r14 = (org.jsoup.nodes.Element) r14     // Catch:{ all -> 0x0177 }
            java.lang.String r15 = "title"
            java.lang.String r15 = r14.c(r15)     // Catch:{ all -> 0x0177 }
            boolean r16 = r15.isEmpty()     // Catch:{ all -> 0x0177 }
            if (r16 == 0) goto L_0x00f9
            java.lang.String r15 = r14.v0()     // Catch:{ all -> 0x0177 }
        L_0x00f9:
            java.lang.String r3 = com.original.tase.helper.TitleHelper.f(r15)     // Catch:{ all -> 0x0177 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0177 }
            r11.<init>()     // Catch:{ all -> 0x0177 }
            java.lang.String r17 = r20.getName()     // Catch:{ all -> 0x0177 }
            r18 = r2
            java.lang.String r2 = com.original.tase.helper.TitleHelper.e(r17)     // Catch:{ all -> 0x0179 }
            r11.append(r2)     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = r1.year     // Catch:{ all -> 0x0179 }
            r11.append(r2)     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = r11.toString()     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r2)     // Catch:{ all -> 0x0179 }
            boolean r2 = r3.endsWith(r2)     // Catch:{ all -> 0x0179 }
            if (r2 != 0) goto L_0x0170
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r15)     // Catch:{ all -> 0x0179 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0179 }
            r3.<init>()     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = r20.getName()     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.e(r11)     // Catch:{ all -> 0x0179 }
            r3.append(r11)     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = r1.year     // Catch:{ all -> 0x0179 }
            r3.append(r11)     // Catch:{ all -> 0x0179 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0179 }
            java.lang.String r3 = com.original.tase.helper.TitleHelper.f(r3)     // Catch:{ all -> 0x0179 }
            boolean r2 = r2.startsWith(r3)     // Catch:{ all -> 0x0179 }
            if (r2 != 0) goto L_0x0170
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r15)     // Catch:{ all -> 0x0179 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0179 }
            r3.<init>()     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = r20.getName()     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.e(r11)     // Catch:{ all -> 0x0179 }
            r3.append(r11)     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = r1.year     // Catch:{ all -> 0x0179 }
            r3.append(r11)     // Catch:{ all -> 0x0179 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0179 }
            java.lang.String r3 = com.original.tase.helper.TitleHelper.f(r3)     // Catch:{ all -> 0x0179 }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0179 }
            if (r2 == 0) goto L_0x0179
        L_0x0170:
            java.lang.String r2 = "href"
            java.lang.String r13 = r14.c(r2)     // Catch:{ all -> 0x0179 }
            goto L_0x0185
        L_0x0177:
            r18 = r2
        L_0x0179:
            r2 = r18
            r3 = 0
            r11 = 1
            goto L_0x00dd
        L_0x017f:
            r18 = r2
            goto L_0x0185
        L_0x0182:
            r18 = r2
        L_0x0185:
            boolean r2 = r13.isEmpty()
            if (r2 == 0) goto L_0x019e
            java.lang.String r2 = "CDNRelease movie not found "
            com.original.tase.Logger.b(r2, r9)
            java.lang.String r13 = r0.N(r1, r10)
            boolean r2 = r13.isEmpty()
            if (r2 == 0) goto L_0x019e
        L_0x019a:
            r3 = r21
            goto L_0x0255
        L_0x019e:
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r2 = r2.o(r13, r10)
            java.lang.String r3 = "<a[^>]+href=['\"]([^'\"]+(mkv|mp4|avi).+)['\"]"
            r9 = 1
            java.util.ArrayList r2 = com.original.tase.utils.Regex.f(r2, r3, r9, r9)
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r2 = r2.iterator()
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x01c3
            int r10 = r0.f37273h
            int r10 = r10 + r9
            r0.f37273h = r10
        L_0x01c3:
            java.lang.String r9 = "Referer"
            r5.put(r9, r13)
            java.lang.String r9 = com.original.Constants.C
            r5.put(r7, r9)
            java.lang.String r9 = "HQ"
            r10 = r9
        L_0x01d0:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x019a
            java.lang.Object r11 = r2.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "href=['\"]([^'\"]+[^'\"])['\"]"
            r13 = 1
            java.lang.String r11 = com.original.tase.utils.Regex.a(r11, r12, r13)
            java.lang.String r12 = r11.toLowerCase()
            java.lang.String r14 = "trailer"
            boolean r12 = r12.contains(r14)
            if (r12 != 0) goto L_0x0250
            java.lang.String r12 = r11.toLowerCase()
            java.lang.String r14 = "comment"
            boolean r12 = r12.contains(r14)
            if (r12 == 0) goto L_0x01fc
            goto L_0x0250
        L_0x01fc:
            java.lang.String r12 = "mp4"
            boolean r12 = r11.contains(r12)
            if (r12 != 0) goto L_0x0215
            java.lang.String r12 = "mkv"
            boolean r12 = r11.contains(r12)
            if (r12 != 0) goto L_0x0215
            java.lang.String r12 = "avi"
            boolean r12 = r11.contains(r12)
            if (r12 != 0) goto L_0x0215
            goto L_0x0250
        L_0x0215:
            java.lang.String r12 = r19.A()
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r14 = r6.c(r11)
            if (r14 == 0) goto L_0x0232
            java.lang.String r12 = r14.c()
            boolean r15 = r12.equalsIgnoreCase(r9)
            if (r15 != 0) goto L_0x022a
            r10 = r12
        L_0x022a:
            java.lang.String r12 = r14.b()
            java.lang.String r12 = r0.t(r12)
        L_0x0232:
            com.original.tase.model.media.MediaSource r14 = new com.original.tase.model.media.MediaSource
            java.lang.String[] r15 = r0.f37270e
            int r16 = r8 + 1
            r15 = r15[r16]
            boolean r3 = r0.p(r11)
            r14.<init>(r12, r15, r3)
            r14.setStreamLink(r11)
            r14.setPlayHeader(r5)
            r14.setQuality((java.lang.String) r10)
            r3 = r21
            r3.onNext(r14)
            goto L_0x0252
        L_0x0250:
            r3 = r21
        L_0x0252:
            r3 = 0
            goto L_0x01d0
        L_0x0255:
            int r8 = r8 + 2
            r2 = r18
            r3 = 0
            goto L_0x0030
        L_0x025c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.CDNRelease.J(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }

    public String K(MovieInfo movieInfo, String str, String str2) {
        Iterator it2 = Jsoup.b(str).q0("h2").iterator();
        while (it2.hasNext()) {
            try {
                Element r02 = ((Element) it2.next()).r0(a.f20042a);
                String f2 = TitleHelper.f(r02.v0());
                if (f2.contains(TitleHelper.f(TitleHelper.e(movieInfo.getName()) + movieInfo.year))) {
                    String c2 = r02.c("href");
                    if (c2.contains(str2)) {
                        return c2;
                    }
                } else {
                    continue;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public String L(MovieInfo movieInfo, String str, String str2) {
        Iterator it2 = Jsoup.b(str).q0("div[class=r]").iterator();
        if (!it2.hasNext()) {
            return "";
        }
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0(a.f20042a);
            try {
                String f2 = TitleHelper.f(r02.r0("span").v0());
                if (f2.contains(TitleHelper.f(TitleHelper.e(movieInfo.getName()) + movieInfo.year))) {
                    String c2 = r02.c("href");
                    if (c2.contains(str2)) {
                        return c2;
                    }
                } else {
                    continue;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public String N(MovieInfo movieInfo, String str) {
        String str2 = movieInfo.name + " " + movieInfo.year + " site:" + str;
        String K = K(movieInfo, HttpHelper.i().o("https://www.bing.com/search?q=" + str2, "https://www.bing.com"), str);
        if (!K.isEmpty()) {
            return K;
        }
        String k2 = com.original.tase.utils.Utils.k(Utils.G() + "/search?q=" + str2, new boolean[0]);
        String L = L(movieInfo, HttpHelper.i().m(k2 + "##forceNoCache##", new Map[0]), str);
        if (!L.isEmpty()) {
            return L;
        }
        return "";
    }
}

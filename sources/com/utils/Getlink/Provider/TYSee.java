package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.ObservableEmitter;

public class TYSee extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37467e = "https://seehd.nl";

    public String A() {
        return "TYSee";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(movieInfo, observableEmitter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e7, code lost:
        r7 = r10.q0(com.facebook.ads.internal.c.a.f20042a).a("href");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(com.movie.data.model.MovieInfo r17, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.Integer r2 = r17.getType()
            int r2 = r2.intValue()
            r3 = 0
            r4 = 1
            if (r2 != r4) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.f37467e
            r5.append(r6)
            java.lang.String r6 = "/?s="
            r5.append(r6)
            java.lang.String r6 = r1.name
            boolean[] r7 = new boolean[r3]
            java.lang.String r6 = com.original.tase.utils.Utils.k(r6, r7)
            java.lang.String r7 = "%20"
            java.lang.String r8 = "+"
            java.lang.String r6 = r6.replace(r7, r8)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            if (r2 != 0) goto L_0x005b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "+Season+"
            r6.append(r5)
            java.lang.String r5 = r1.session
            r6.append(r5)
            java.lang.String r5 = "+Episode+"
            r6.append(r5)
            java.lang.String r5 = r1.eps
            r6.append(r5)
            java.lang.String r5 = r6.toString()
        L_0x005b:
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r7 = new java.util.Map[r3]
            java.lang.String r6 = r6.m(r5, r7)
            org.jsoup.nodes.Document r6 = org.jsoup.Jsoup.b(r6)
            java.lang.String r7 = "div.item"
            org.jsoup.select.Elements r6 = r6.q0(r7)
            java.util.Iterator r6 = r6.iterator()
            java.lang.String r7 = ""
            java.lang.String r8 = "HQ"
            r9 = r7
        L_0x0078:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0133
            java.lang.Object r10 = r6.next()
            org.jsoup.nodes.Element r10 = (org.jsoup.nodes.Element) r10
            java.lang.String r11 = "h2"
            org.jsoup.nodes.Element r11 = r10.r0(r11)
            java.lang.String r11 = r11.v0()
            if (r2 == 0) goto L_0x00a4
            java.lang.String r8 = "span.year"
            org.jsoup.nodes.Element r8 = r10.r0(r8)
            java.lang.String r9 = r8.v0()
            java.lang.String r8 = "span.calidad2"
            org.jsoup.nodes.Element r8 = r10.r0(r8)
            java.lang.String r8 = r8.v0()
        L_0x00a4:
            java.lang.String r12 = "href"
            java.lang.String r13 = "a"
            if (r2 == 0) goto L_0x00f0
            java.lang.String r14 = r1.name
            boolean r14 = r11.startsWith(r14)
            if (r14 == 0) goto L_0x00ba
            java.lang.String r14 = r1.year
            boolean r14 = r9.equals(r14)
            if (r14 != 0) goto L_0x00e7
        L_0x00ba:
            java.lang.String r14 = "\\(|\\)"
            java.lang.String r11 = r11.replaceAll(r14, r7)
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r11)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = r17.getName()
            java.lang.String r15 = com.original.tase.helper.TitleHelper.e(r15)
            r14.append(r15)
            java.lang.String r15 = r1.year
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r14 = com.original.tase.helper.TitleHelper.f(r14)
            boolean r11 = r11.startsWith(r14)
            if (r11 == 0) goto L_0x0078
        L_0x00e7:
            org.jsoup.select.Elements r1 = r10.q0(r13)
            java.lang.String r7 = r1.a(r12)
            goto L_0x0133
        L_0x00f0:
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r11)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = r17.getName()
            r14.append(r15)
            java.lang.String r15 = " Season "
            r14.append(r15)
            java.lang.String r15 = r1.session
            r14.append(r15)
            java.lang.String r15 = " Episode "
            r14.append(r15)
            java.lang.String r15 = r1.eps
            r14.append(r15)
            java.lang.String r15 = " watch"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r14 = com.original.tase.helper.TitleHelper.e(r14)
            java.lang.String r14 = com.original.tase.helper.TitleHelper.f(r14)
            boolean r11 = r11.startsWith(r14)
            if (r11 == 0) goto L_0x0078
            org.jsoup.select.Elements r1 = r10.q0(r13)
            java.lang.String r7 = r1.a(r12)
        L_0x0133:
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L_0x013a
            return
        L_0x013a:
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r1 = r1.o(r7, r5)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r2 = "div.movieplay"
            org.jsoup.select.Elements r1 = r1.q0(r2)
            java.lang.String r2 = "script"
            org.jsoup.select.Elements r1 = r1.g(r2)
            java.util.Iterator r1 = r1.iterator()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r5 = "referer"
            r2.put(r5, r7)
        L_0x0160:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01a1
            java.lang.Object r2 = r1.next()
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            java.util.List r2 = r2.j()
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "['\"]([^'\"]+[^'\"])['\"]"
            java.lang.String r2 = com.original.tase.utils.Regex.a(r2, r5, r4)
            java.lang.String r5 = "@|g"
            java.lang.String r6 = "%"
            java.lang.String r2 = r2.replaceAll(r5, r6)
            java.lang.String r5 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r5)     // Catch:{ UnsupportedEncodingException -> 0x0189 }
            goto L_0x018d
        L_0x0189:
            java.lang.String r2 = java.net.URLDecoder.decode(r2)
        L_0x018d:
            java.lang.String r5 = "src=['\"]([^'\"]+[^'\"])['\"]"
            java.lang.String r2 = com.original.tase.utils.Regex.a(r2, r5, r4)
            boolean[] r5 = new boolean[r4]
            boolean r6 = r0.o(r8)
            r5[r3] = r6
            r6 = r18
            r0.z(r6, r2, r8, r5)
            goto L_0x0160
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.TYSee.J(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }
}

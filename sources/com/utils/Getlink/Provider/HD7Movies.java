package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class HD7Movies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public HashMap f37335e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f37336f = "";

    /* renamed from: g  reason: collision with root package name */
    private String[] f37337g = null;

    /* renamed from: h  reason: collision with root package name */
    private String[] f37338h = Utils.getProvider(18).split(",");

    /* renamed from: i  reason: collision with root package name */
    private String[] f37339i = Utils.getProvider(19).split(",");

    public HD7Movies() {
        this.f37335e.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        this.f37335e.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US");
        this.f37335e.put("Upgrade-Insecure-Requests", "1");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0176 A[Catch:{ Exception -> 0x0312 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r22, com.movie.data.model.MovieInfo r23, java.lang.String r24, java.lang.String r25) {
        /*
            r21 = this;
            r7 = r21
            java.lang.String r8 = "1080p"
            java.lang.String r9 = "/"
            java.lang.String r10 = ".iso"
            java.lang.Integer r0 = r23.getType()
            int r0 = r0.intValue()
            r11 = 0
            r12 = 1
            if (r0 != r12) goto L_0x0016
            r13 = 1
            goto L_0x0017
        L_0x0016:
            r13 = 0
        L_0x0017:
            com.original.tase.helper.DirectoryIndexHelper r14 = new com.original.tase.helper.DirectoryIndexHelper
            r14.<init>()
            java.lang.String r15 = r23.getName()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "User-Agent"
            java.lang.String r2 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36"
            r0.put(r1, r2)
            if (r13 == 0) goto L_0x0037
            java.lang.Integer r0 = r23.getYear()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0060
        L_0x0037:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "S"
            r0.append(r1)
            int r1 = java.lang.Integer.parseInt(r24)
            java.lang.String r1 = com.original.tase.utils.Utils.i(r1)
            r0.append(r1)
            java.lang.String r1 = "E"
            r0.append(r1)
            int r1 = java.lang.Integer.parseInt(r25)
            java.lang.String r1 = com.original.tase.utils.Utils.i(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0060:
            r6 = r0
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r1 = r7.f37336f
            java.util.Map[] r2 = new java.util.Map[r12]
            java.util.HashMap r3 = r7.f37335e
            r2[r11] = r3
            java.lang.String r0 = r0.m(r1, r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            org.jsoup.parser.Parser r1 = org.jsoup.parser.Parser.a()
            java.lang.String r4 = ""
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.c(r0, r4, r1)
            java.lang.String r1 = "item"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.util.Iterator r16 = r0.iterator()
        L_0x008a:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x033a
            java.lang.Object r0 = r16.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r1 = "title"
            org.jsoup.nodes.Element r1 = r0.r0(r1)
            if (r1 == 0) goto L_0x032b
            java.lang.String r3 = r1.v0()
            java.lang.String r1 = "enclosure[url]"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.util.Iterator r17 = r0.iterator()
        L_0x00ac:
            boolean r0 = r17.hasNext()
            if (r0 == 0) goto L_0x032b
            java.lang.Object r0 = r17.next()     // Catch:{ Exception -> 0x0312 }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ Exception -> 0x0312 }
            java.lang.String r1 = "url"
            java.lang.String r0 = r0.c(r1)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r1 = "openload"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".7z"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".rar"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".zip"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            boolean r1 = r0.contains(r10)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".avi"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".flv"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = "paste"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".xyxy"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".msi"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = "imdb."
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            boolean r1 = r0.contains(r10)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".jpg"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = ".exe"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            boolean r1 = r5.contains(r0)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x0309
            r5.add(r0)     // Catch:{ Exception -> 0x0312 }
            if (r13 != 0) goto L_0x0161
            boolean r1 = r0.contains(r9)     // Catch:{ Exception -> 0x0312 }
            if (r1 == 0) goto L_0x0161
            java.lang.String[] r1 = r0.split(r9)     // Catch:{ Exception -> 0x0312 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0312 }
            if (r2 <= 0) goto L_0x0161
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0312 }
            r2.<init>()     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = "(720p|1080p)"
            java.lang.String r11 = r3.replaceAll(r11, r4)     // Catch:{ Exception -> 0x0312 }
            r2.append(r11)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = " "
            r2.append(r11)     // Catch:{ Exception -> 0x0312 }
            int r11 = r1.length     // Catch:{ Exception -> 0x0312 }
            int r11 = r11 - r12
            r1 = r1[r11]     // Catch:{ Exception -> 0x0312 }
            r2.append(r1)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0312 }
            goto L_0x0162
        L_0x0161:
            r1 = r3
        L_0x0162:
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r15)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = "(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d+|3D)(\\.|\\)|\\]|\\s|)(.+|)"
            java.lang.String r11 = r1.replaceAll(r11, r4)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r11)     // Catch:{ Exception -> 0x0312 }
            boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x0312 }
            if (r2 == 0) goto L_0x0309
            java.lang.String r2 = "[\\.|\\(|\\[|\\s]([2-9]0\\d{2}|1[5-9]\\d{2})[\\.|\\)|\\]|\\s]"
            java.util.ArrayList r2 = com.original.tase.utils.Regex.d(r1, r2, r12)     // Catch:{ Exception -> 0x0312 }
            r11 = 0
            java.lang.Object r2 = r2.get(r11)     // Catch:{ Exception -> 0x0312 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x0312 }
            if (r13 != 0) goto L_0x01a6
            java.lang.String r11 = "[\\.|\\(|\\[|\\s](S\\d*E\\d*)[\\.|\\)|\\]|\\s]"
            java.util.ArrayList r11 = com.original.tase.utils.Regex.d(r1, r11, r12)     // Catch:{ Exception -> 0x0312 }
            r12 = 0
            java.lang.Object r11 = r11.get(r12)     // Catch:{ Exception -> 0x0312 }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ Exception -> 0x0312 }
            r2.addAll(r11)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = "[\\.|\\(|\\[|\\s](S\\d*)[\\.|\\)|\\]|\\s]"
            r12 = 1
            java.util.ArrayList r11 = com.original.tase.utils.Regex.d(r1, r11, r12)     // Catch:{ Exception -> 0x0312 }
            r12 = 0
            java.lang.Object r11 = r11.get(r12)     // Catch:{ Exception -> 0x0312 }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ Exception -> 0x0312 }
            r2.addAll(r11)     // Catch:{ Exception -> 0x0312 }
        L_0x01a6:
            int r11 = r2.size()     // Catch:{ Exception -> 0x0312 }
            if (r11 <= 0) goto L_0x0309
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0312 }
        L_0x01b0:
            boolean r11 = r2.hasNext()     // Catch:{ Exception -> 0x0312 }
            if (r11 == 0) goto L_0x01c8
            java.lang.Object r11 = r2.next()     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = r11.toUpperCase()     // Catch:{ Exception -> 0x0312 }
            boolean r11 = r11.equals(r6)     // Catch:{ Exception -> 0x0312 }
            if (r11 == 0) goto L_0x01b0
            r2 = 1
            goto L_0x01c9
        L_0x01c8:
            r2 = 0
        L_0x01c9:
            if (r2 == 0) goto L_0x0309
            java.lang.String r1 = r1.toUpperCase()     // Catch:{ Exception -> 0x0312 }
            java.lang.String r2 = "(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)"
            java.lang.String r1 = r1.replaceAll(r2, r4)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r2 = "\\.|\\(|\\)|\\[|\\]|\\s|\\-"
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ Exception -> 0x0312 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0312 }
            java.lang.String r11 = "HQ"
            r18 = r11
            r12 = 0
        L_0x01e1:
            if (r12 >= r2) goto L_0x02bc
            r19 = r1[r12]     // Catch:{ Exception -> 0x0312 }
            r23 = r1
            java.lang.String r1 = r19.toLowerCase()     // Catch:{ Exception -> 0x0312 }
            r19 = r2
            java.lang.String r2 = "subs"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "sub"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "dubbed"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "dub"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "dvdscr"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "r5"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "r6"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "camrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "tsrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "hdcam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "hdts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "dvdcam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "dvdts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "cam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "telesync"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ba
            java.lang.String r2 = "ts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 == 0) goto L_0x026e
            goto L_0x02ba
        L_0x026e:
            boolean r2 = r1.contains(r8)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02b0
            java.lang.String r2 = "1080"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 == 0) goto L_0x027d
            goto L_0x02b0
        L_0x027d:
            java.lang.String r2 = "720p"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ad
            java.lang.String r2 = "720"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ad
            java.lang.String r2 = "brrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ad
            java.lang.String r2 = "bdrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ad
            java.lang.String r2 = "hdrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02ad
            java.lang.String r2 = "web-dl"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0312 }
            if (r1 == 0) goto L_0x02b2
        L_0x02ad:
            java.lang.String r18 = "HD"
            goto L_0x02b2
        L_0x02b0:
            r18 = r8
        L_0x02b2:
            int r12 = r12 + 1
            r1 = r23
            r2 = r19
            goto L_0x01e1
        L_0x02ba:
            r1 = 1
            goto L_0x02bd
        L_0x02bc:
            r1 = 0
        L_0x02bd:
            if (r1 != 0) goto L_0x0309
            java.lang.String r1 = r21.A()     // Catch:{ Exception -> 0x0312 }
            if (r13 == 0) goto L_0x02ca
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r2 = r14.c(r0)     // Catch:{ Exception -> 0x0312 }
            goto L_0x02ce
        L_0x02ca:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r2 = r14.d(r0)     // Catch:{ Exception -> 0x0312 }
        L_0x02ce:
            if (r2 == 0) goto L_0x02e6
            java.lang.String r1 = r2.c()     // Catch:{ Exception -> 0x0312 }
            boolean r1 = r1.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0312 }
            if (r1 != 0) goto L_0x02de
            java.lang.String r18 = r2.c()     // Catch:{ Exception -> 0x0312 }
        L_0x02de:
            java.lang.String r1 = r2.b()     // Catch:{ Exception -> 0x0312 }
            java.lang.String r1 = r7.t(r1)     // Catch:{ Exception -> 0x0312 }
        L_0x02e6:
            r11 = r1
            r1 = 0
            boolean[] r12 = new boolean[r1]     // Catch:{ Exception -> 0x0300 }
            r1 = r21
            r2 = r22
            r19 = r3
            r3 = r0
            r20 = r4
            r4 = r18
            r18 = r5
            r5 = r11
            r11 = r6
            r6 = r12
            r1.x(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02fe }
            goto L_0x0310
        L_0x02fe:
            r0 = move-exception
            goto L_0x031a
        L_0x0300:
            r0 = move-exception
            r19 = r3
            r20 = r4
            r18 = r5
            r11 = r6
            goto L_0x031b
        L_0x0309:
            r19 = r3
            r20 = r4
            r18 = r5
            r11 = r6
        L_0x0310:
            r1 = 0
            goto L_0x0320
        L_0x0312:
            r0 = move-exception
            r19 = r3
            r20 = r4
            r18 = r5
            r11 = r6
        L_0x031a:
            r1 = 0
        L_0x031b:
            boolean[] r2 = new boolean[r1]
            com.original.tase.Logger.d(r0, r2)
        L_0x0320:
            r6 = r11
            r5 = r18
            r3 = r19
            r4 = r20
            r11 = 0
            r12 = 1
            goto L_0x00ac
        L_0x032b:
            r20 = r4
            r18 = r5
            r11 = r6
            r1 = 0
            r6 = r11
            r5 = r18
            r4 = r20
            r11 = 0
            r12 = 1
            goto L_0x008a
        L_0x033a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.HD7Movies.J(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo, java.lang.String, java.lang.String):void");
    }

    public String A() {
        return "HD7Movies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            for (String str : this.f37338h) {
                this.f37336f = str;
                J(observableEmitter, movieInfo, "-1", "-1");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            for (String str : this.f37339i) {
                this.f37336f = str;
                J(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
            }
        }
    }
}

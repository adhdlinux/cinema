package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class WrzCraft extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37499e = Utils.getProvider(98);

    /* renamed from: f  reason: collision with root package name */
    public HashMap f37500f;

    public WrzCraft() {
        HashMap hashMap = new HashMap();
        this.f37500f = hashMap;
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        this.f37500f.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US");
        this.f37500f.put("Host", this.f37499e.replace("https://", "").replace("http://", "").replace("/", ""));
        this.f37500f.put("Upgrade-Insecure-Requests", "1");
        this.f37500f.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0179 A[Catch:{ Exception -> 0x0315 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r22, com.movie.data.model.MovieInfo r23, java.lang.String r24, java.lang.String r25) {
        /*
            r21 = this;
            r7 = r21
            java.lang.String r8 = "1080p"
            java.lang.String r9 = "/"
            java.lang.Integer r0 = r23.getType()
            int r0 = r0.intValue()
            r10 = 0
            r11 = 1
            if (r0 != r11) goto L_0x0014
            r12 = 1
            goto L_0x0015
        L_0x0014:
            r12 = 0
        L_0x0015:
            com.original.tase.helper.DirectoryIndexHelper r13 = new com.original.tase.helper.DirectoryIndexHelper
            r13.<init>()
            java.lang.String r14 = r23.getName()
            if (r12 == 0) goto L_0x0029
            java.lang.Integer r0 = r23.getYear()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0052
        L_0x0029:
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
        L_0x0052:
            r15 = r0
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r7.f37499e
            r1.append(r2)
            java.lang.String r2 = "/search/"
            r1.append(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            java.lang.String r6 = " "
            r2.append(r6)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "(\\\\\\|/| -|:|;|\\*|\\?|\"|\\'|<|>|\\|)"
            java.lang.String r2 = r2.replaceAll(r3, r6)
            java.lang.String r3 = "  "
            java.lang.String r2 = r2.replace(r3, r6)
            boolean[] r3 = new boolean[r10]
            java.lang.String r2 = com.original.tase.utils.Utils.k(r2, r3)
            r1.append(r2)
            java.lang.String r2 = "/feed/rss2"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.util.Map[] r2 = new java.util.Map[r11]
            java.util.HashMap r3 = r7.f37500f
            r2[r10] = r3
            java.lang.String r0 = r0.m(r1, r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            org.jsoup.parser.Parser r1 = org.jsoup.parser.Parser.a()
            java.lang.String r4 = ""
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.c(r0, r4, r1)
            java.lang.String r1 = "item"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.util.Iterator r16 = r0.iterator()
        L_0x00bb:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x033d
            java.lang.Object r0 = r16.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r1 = "title"
            org.jsoup.nodes.Element r1 = r0.r0(r1)
            if (r1 == 0) goto L_0x032e
            java.lang.String r3 = r1.v0()
            java.lang.String r1 = "enclosure[url]"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.util.Iterator r17 = r0.iterator()
        L_0x00dd:
            boolean r0 = r17.hasNext()
            if (r0 == 0) goto L_0x032e
            java.lang.Object r0 = r17.next()     // Catch:{ Exception -> 0x0315 }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ Exception -> 0x0315 }
            java.lang.String r1 = "url"
            java.lang.String r0 = r0.c(r1)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r1 = "openload"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = ".7z"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = ".rar"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = ".zip"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = ".iso"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = ".avi"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = ".flv"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = "imdb."
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            boolean r1 = r5.contains(r0)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x030c
            r5.add(r0)     // Catch:{ Exception -> 0x0315 }
            if (r12 != 0) goto L_0x0164
            boolean r1 = r0.contains(r9)     // Catch:{ Exception -> 0x0315 }
            if (r1 == 0) goto L_0x0164
            java.lang.String[] r1 = r0.split(r9)     // Catch:{ Exception -> 0x0315 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0315 }
            if (r2 <= 0) goto L_0x0164
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0315 }
            r2.<init>()     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = "(720p|1080p)"
            java.lang.String r10 = r3.replaceAll(r10, r4)     // Catch:{ Exception -> 0x0315 }
            r2.append(r10)     // Catch:{ Exception -> 0x0315 }
            r2.append(r6)     // Catch:{ Exception -> 0x0315 }
            int r10 = r1.length     // Catch:{ Exception -> 0x0315 }
            int r10 = r10 - r11
            r1 = r1[r10]     // Catch:{ Exception -> 0x0315 }
            r2.append(r1)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0315 }
            goto L_0x0165
        L_0x0164:
            r1 = r3
        L_0x0165:
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r14)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = "(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d+|3D)(\\.|\\)|\\]|\\s|)(.+|)"
            java.lang.String r10 = r1.replaceAll(r10, r4)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = com.original.tase.helper.TitleHelper.f(r10)     // Catch:{ Exception -> 0x0315 }
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x0315 }
            if (r2 == 0) goto L_0x030c
            java.lang.String r2 = "[\\.|\\(|\\[|\\s]([2-9]0\\d{2}|1[5-9]\\d{2})[\\.|\\)|\\]|\\s]"
            java.util.ArrayList r2 = com.original.tase.utils.Regex.d(r1, r2, r11)     // Catch:{ Exception -> 0x0315 }
            r10 = 0
            java.lang.Object r2 = r2.get(r10)     // Catch:{ Exception -> 0x0315 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x0315 }
            if (r12 != 0) goto L_0x01a9
            java.lang.String r10 = "[\\.|\\(|\\[|\\s](S\\d*E\\d*)[\\.|\\)|\\]|\\s]"
            java.util.ArrayList r10 = com.original.tase.utils.Regex.d(r1, r10, r11)     // Catch:{ Exception -> 0x0315 }
            r11 = 0
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0315 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ Exception -> 0x0315 }
            r2.addAll(r10)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = "[\\.|\\(|\\[|\\s](S\\d*)[\\.|\\)|\\]|\\s]"
            r11 = 1
            java.util.ArrayList r10 = com.original.tase.utils.Regex.d(r1, r10, r11)     // Catch:{ Exception -> 0x0315 }
            r11 = 0
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0315 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ Exception -> 0x0315 }
            r2.addAll(r10)     // Catch:{ Exception -> 0x0315 }
        L_0x01a9:
            int r10 = r2.size()     // Catch:{ Exception -> 0x0315 }
            if (r10 <= 0) goto L_0x030c
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0315 }
        L_0x01b3:
            boolean r10 = r2.hasNext()     // Catch:{ Exception -> 0x0315 }
            if (r10 == 0) goto L_0x01cb
            java.lang.Object r10 = r2.next()     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = r10.toUpperCase()     // Catch:{ Exception -> 0x0315 }
            boolean r10 = r10.equals(r15)     // Catch:{ Exception -> 0x0315 }
            if (r10 == 0) goto L_0x01b3
            r2 = 1
            goto L_0x01cc
        L_0x01cb:
            r2 = 0
        L_0x01cc:
            if (r2 == 0) goto L_0x030c
            java.lang.String r1 = r1.toUpperCase()     // Catch:{ Exception -> 0x0315 }
            java.lang.String r2 = "(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)"
            java.lang.String r1 = r1.replaceAll(r2, r4)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r2 = "\\.|\\(|\\)|\\[|\\]|\\s|\\-"
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ Exception -> 0x0315 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0315 }
            java.lang.String r10 = "HQ"
            r18 = r10
            r11 = 0
        L_0x01e4:
            if (r11 >= r2) goto L_0x02bf
            r19 = r1[r11]     // Catch:{ Exception -> 0x0315 }
            r23 = r1
            java.lang.String r1 = r19.toLowerCase()     // Catch:{ Exception -> 0x0315 }
            r19 = r2
            java.lang.String r2 = "subs"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "sub"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "dubbed"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "dub"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "dvdscr"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "r5"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "r6"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "camrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "tsrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "hdcam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "hdts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "dvdcam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "dvdts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "cam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "telesync"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02bd
            java.lang.String r2 = "ts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 == 0) goto L_0x0271
            goto L_0x02bd
        L_0x0271:
            boolean r2 = r1.contains(r8)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02b3
            java.lang.String r2 = "1080"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 == 0) goto L_0x0280
            goto L_0x02b3
        L_0x0280:
            java.lang.String r2 = "720p"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02b0
            java.lang.String r2 = "720"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02b0
            java.lang.String r2 = "brrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02b0
            java.lang.String r2 = "bdrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02b0
            java.lang.String r2 = "hdrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r2 != 0) goto L_0x02b0
            java.lang.String r2 = "web-dl"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0315 }
            if (r1 == 0) goto L_0x02b5
        L_0x02b0:
            java.lang.String r18 = "HD"
            goto L_0x02b5
        L_0x02b3:
            r18 = r8
        L_0x02b5:
            int r11 = r11 + 1
            r1 = r23
            r2 = r19
            goto L_0x01e4
        L_0x02bd:
            r1 = 1
            goto L_0x02c0
        L_0x02bf:
            r1 = 0
        L_0x02c0:
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = r21.A()     // Catch:{ Exception -> 0x0315 }
            if (r12 == 0) goto L_0x02cd
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r2 = r13.c(r0)     // Catch:{ Exception -> 0x0315 }
            goto L_0x02d1
        L_0x02cd:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r2 = r13.d(r0)     // Catch:{ Exception -> 0x0315 }
        L_0x02d1:
            if (r2 == 0) goto L_0x02e9
            java.lang.String r1 = r2.c()     // Catch:{ Exception -> 0x0315 }
            boolean r1 = r1.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0315 }
            if (r1 != 0) goto L_0x02e1
            java.lang.String r18 = r2.c()     // Catch:{ Exception -> 0x0315 }
        L_0x02e1:
            java.lang.String r1 = r2.b()     // Catch:{ Exception -> 0x0315 }
            java.lang.String r1 = r7.t(r1)     // Catch:{ Exception -> 0x0315 }
        L_0x02e9:
            r10 = r1
            r1 = 0
            boolean[] r11 = new boolean[r1]     // Catch:{ Exception -> 0x0303 }
            r1 = r21
            r2 = r22
            r19 = r3
            r3 = r0
            r20 = r4
            r4 = r18
            r18 = r5
            r5 = r10
            r10 = r6
            r6 = r11
            r1.x(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0301 }
            goto L_0x0313
        L_0x0301:
            r0 = move-exception
            goto L_0x031d
        L_0x0303:
            r0 = move-exception
            r19 = r3
            r20 = r4
            r18 = r5
            r10 = r6
            goto L_0x031e
        L_0x030c:
            r19 = r3
            r20 = r4
            r18 = r5
            r10 = r6
        L_0x0313:
            r1 = 0
            goto L_0x0323
        L_0x0315:
            r0 = move-exception
            r19 = r3
            r20 = r4
            r18 = r5
            r10 = r6
        L_0x031d:
            r1 = 0
        L_0x031e:
            boolean[] r2 = new boolean[r1]
            com.original.tase.Logger.d(r0, r2)
        L_0x0323:
            r6 = r10
            r5 = r18
            r3 = r19
            r4 = r20
            r10 = 0
            r11 = 1
            goto L_0x00dd
        L_0x032e:
            r20 = r4
            r18 = r5
            r10 = r6
            r1 = 0
            r6 = r10
            r5 = r18
            r4 = r20
            r10 = 0
            r11 = 1
            goto L_0x00bb
        L_0x033d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.WrzCraft.J(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo, java.lang.String, java.lang.String):void");
    }

    public String A() {
        return "WrzCraft";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, "-1", "-1");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
        }
    }
}

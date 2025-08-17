package com.utils.Getlink.Provider;

import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class CBB extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public HashMap f37265e;

    /* renamed from: f  reason: collision with root package name */
    private String f37266f = "";

    /* renamed from: g  reason: collision with root package name */
    private String[] f37267g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f37268h = "";

    /* renamed from: i  reason: collision with root package name */
    private boolean f37269i = false;

    public CBB() {
        HashMap hashMap = new HashMap();
        this.f37265e = hashMap;
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        this.f37265e.put("accept-Language", "en-US");
        this.f37265e.put("upgrade-Insecure-Requests", "1");
        this.f37265e.put("user-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
    }

    private static String[] J() {
        String str = GlobalVariable.c().b().getCbflist().get("1");
        if (str == null || str.isEmpty()) {
            return new String[0];
        }
        return str.split(",");
    }

    /* JADX WARNING: Removed duplicated region for block: B:173:0x01f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018a A[Catch:{ Exception -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01d6 A[Catch:{ Exception -> 0x0349 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r24, com.movie.data.model.MovieInfo r25, java.lang.String r26, java.lang.String r27) {
        /*
            r23 = this;
            r7 = r23
            java.lang.String r8 = "1080p"
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.Integer r0 = r25.getType()
            int r0 = r0.intValue()
            r10 = 0
            r11 = 1
            if (r0 != r11) goto L_0x0017
            r12 = 1
            goto L_0x0018
        L_0x0017:
            r12 = 0
        L_0x0018:
            com.original.tase.helper.DirectoryIndexHelper r13 = new com.original.tase.helper.DirectoryIndexHelper
            r13.<init>()
            java.lang.String r14 = r25.getName()
            if (r12 == 0) goto L_0x002c
            java.lang.Integer r0 = r25.getYear()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0055
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "S"
            r0.append(r1)
            int r1 = java.lang.Integer.parseInt(r26)
            java.lang.String r1 = com.original.tase.utils.Utils.i(r1)
            r0.append(r1)
            java.lang.String r1 = "E"
            r0.append(r1)
            int r1 = java.lang.Integer.parseInt(r27)
            java.lang.String r1 = com.original.tase.utils.Utils.i(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0055:
            r15 = r0
            boolean r0 = r7.f37269i
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = r7.f37268h
            goto L_0x005f
        L_0x005d:
            java.lang.String r0 = "search"
        L_0x005f:
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.f37266f
            r2.append(r3)
            java.lang.String r6 = "/"
            r2.append(r6)
            r2.append(r0)
            r2.append(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            java.lang.String r5 = " "
            r0.append(r5)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "+"
            java.lang.String r0 = com.original.tase.helper.TitleHelper.h(r0, r3)
            boolean[] r3 = new boolean[r10]
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r3)
            r2.append(r0)
            java.lang.String r0 = "/feed/rss2"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.util.Map[] r2 = new java.util.Map[r10]
            java.lang.String r0 = r1.m(r0, r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            org.jsoup.parser.Parser r1 = org.jsoup.parser.Parser.a()
            java.lang.String r3 = ""
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.c(r0, r3, r1)
            java.lang.String r1 = "item"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.util.Iterator r16 = r0.iterator()
        L_0x00c3:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x0395
            java.lang.Object r0 = r16.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r1 = "title"
            org.jsoup.nodes.Element r1 = r0.r0(r1)
            if (r1 == 0) goto L_0x037e
            java.lang.String r2 = r1.v0()
            java.lang.String r1 = "enclosure[url]"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.util.Iterator r17 = r0.iterator()
        L_0x00e5:
            boolean r0 = r17.hasNext()
            if (r0 == 0) goto L_0x037e
            java.lang.Object r0 = r17.next()     // Catch:{ Exception -> 0x035f }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ Exception -> 0x035f }
            java.lang.String r1 = "url"
            java.lang.String r0 = r0.c(r1)     // Catch:{ Exception -> 0x035f }
            java.lang.String r1 = ".7z"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            java.lang.String r1 = ".rar"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            java.lang.String r1 = ".zip"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            java.lang.String r1 = ".iso"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            java.lang.String r1 = ".avi"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            java.lang.String r1 = ".flv"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            java.lang.String r1 = "imdb."
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            boolean r1 = r4.contains(r0)     // Catch:{ Exception -> 0x035f }
            if (r1 != 0) goto L_0x0353
            r4.add(r0)     // Catch:{ Exception -> 0x035f }
            if (r12 != 0) goto L_0x0175
            boolean r1 = r0.contains(r6)     // Catch:{ Exception -> 0x0167 }
            if (r1 == 0) goto L_0x0175
            java.lang.String[] r1 = r0.split(r6)     // Catch:{ Exception -> 0x0167 }
            int r10 = r1.length     // Catch:{ Exception -> 0x0167 }
            if (r10 <= 0) goto L_0x0175
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0167 }
            r10.<init>()     // Catch:{ Exception -> 0x0167 }
            java.lang.String r11 = "(720p|1080p)"
            java.lang.String r11 = r2.replaceAll(r11, r3)     // Catch:{ Exception -> 0x0167 }
            r10.append(r11)     // Catch:{ Exception -> 0x0167 }
            r10.append(r5)     // Catch:{ Exception -> 0x0167 }
            int r11 = r1.length     // Catch:{ Exception -> 0x0167 }
            r18 = 1
            int r11 = r11 + -1
            r1 = r1[r11]     // Catch:{ Exception -> 0x0167 }
            r10.append(r1)     // Catch:{ Exception -> 0x0167 }
            java.lang.String r1 = r10.toString()     // Catch:{ Exception -> 0x0167 }
            goto L_0x0176
        L_0x0167:
            r0 = move-exception
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            r19 = r14
            r1 = 0
            r14 = r2
            goto L_0x036b
        L_0x0175:
            r1 = r2
        L_0x0176:
            java.lang.String r10 = com.original.tase.helper.TitleHelper.f(r14)     // Catch:{ Exception -> 0x035f }
            java.lang.String r11 = "(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d+|3D)(\\.|\\)|\\]|\\s|)(.+|)"
            java.lang.String r11 = r1.replaceAll(r11, r3)     // Catch:{ Exception -> 0x035f }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r11)     // Catch:{ Exception -> 0x035f }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x035f }
            if (r10 == 0) goto L_0x0353
            java.lang.String r10 = "[\\.|\\(|\\[|\\s]([2-9]0\\d{2}|1[5-9]\\d{2})[\\.|\\)|\\]|\\s]"
            r11 = 1
            java.util.ArrayList r10 = com.original.tase.utils.Regex.d(r1, r10, r11)     // Catch:{ Exception -> 0x035f }
            r11 = 0
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x035f }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x035f }
            if (r12 != 0) goto L_0x01c4
            java.lang.String r11 = "[\\.|\\(|\\[|\\s](S\\d*E\\d*)[\\.|\\)|\\]|\\s]"
            r19 = r14
            r14 = 1
            java.util.ArrayList r11 = com.original.tase.utils.Regex.d(r1, r11, r14)     // Catch:{ Exception -> 0x0349 }
            r14 = 0
            java.lang.Object r11 = r11.get(r14)     // Catch:{ Exception -> 0x0349 }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ Exception -> 0x0349 }
            r10.addAll(r11)     // Catch:{ Exception -> 0x0349 }
            java.lang.String r11 = "[\\.|\\(|\\[|\\s](S\\d*)[\\.|\\)|\\]|\\s]"
            r14 = 1
            java.util.ArrayList r11 = com.original.tase.utils.Regex.d(r1, r11, r14)     // Catch:{ Exception -> 0x0349 }
            r14 = 0
            java.lang.Object r11 = r11.get(r14)     // Catch:{ Exception -> 0x0349 }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ Exception -> 0x0349 }
            r10.addAll(r11)     // Catch:{ Exception -> 0x0349 }
            goto L_0x01c6
        L_0x01bf:
            r0 = move-exception
            r19 = r14
            goto L_0x034a
        L_0x01c4:
            r19 = r14
        L_0x01c6:
            int r11 = r10.size()     // Catch:{ Exception -> 0x0349 }
            if (r11 <= 0) goto L_0x0340
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0349 }
        L_0x01d0:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x0349 }
            if (r11 == 0) goto L_0x01f2
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0349 }
            java.lang.String r14 = r11.toUpperCase()     // Catch:{ Exception -> 0x0349 }
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x0349 }
            if (r14 != 0) goto L_0x01f0
            java.lang.String r11 = r11.toLowerCase()     // Catch:{ Exception -> 0x0349 }
            boolean r11 = r9.contains(r11)     // Catch:{ Exception -> 0x0349 }
            if (r11 == 0) goto L_0x01d0
        L_0x01f0:
            r10 = 1
            goto L_0x01f3
        L_0x01f2:
            r10 = 0
        L_0x01f3:
            if (r10 == 0) goto L_0x0340
            java.lang.String r1 = r1.toUpperCase()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = "(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)"
            java.lang.String r1 = r1.replaceAll(r10, r3)     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = "\\.|\\(|\\)|\\[|\\]|\\s|\\-"
            java.lang.String[] r1 = r1.split(r10)     // Catch:{ Exception -> 0x0349 }
            int r10 = r1.length     // Catch:{ Exception -> 0x0349 }
            java.lang.String r11 = "HQ"
            r20 = r11
            r14 = 0
        L_0x020b:
            if (r14 >= r10) goto L_0x02e6
            r21 = r1[r14]     // Catch:{ Exception -> 0x0349 }
            r25 = r1
            java.lang.String r1 = r21.toLowerCase()     // Catch:{ Exception -> 0x0349 }
            r26 = r2
            java.lang.String r2 = "subs"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "sub"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "dubbed"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "dub"
            boolean r2 = r1.endsWith(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "dvdscr"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "r5"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "r6"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "camrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "tsrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "hdcam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "hdts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "dvdcam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "dvdts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "cam"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "telesync"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02e4
            java.lang.String r2 = "ts"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 == 0) goto L_0x0298
            goto L_0x02e4
        L_0x0298:
            boolean r2 = r1.contains(r8)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02da
            java.lang.String r2 = "1080"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 == 0) goto L_0x02a7
            goto L_0x02da
        L_0x02a7:
            java.lang.String r2 = "720p"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02d7
            java.lang.String r2 = "720"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02d7
            java.lang.String r2 = "brrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02d7
            java.lang.String r2 = "bdrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02d7
            java.lang.String r2 = "hdrip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r2 != 0) goto L_0x02d7
            java.lang.String r2 = "web-dl"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0339 }
            if (r1 == 0) goto L_0x02dc
        L_0x02d7:
            java.lang.String r20 = "HD"
            goto L_0x02dc
        L_0x02da:
            r20 = r8
        L_0x02dc:
            int r14 = r14 + 1
            r1 = r25
            r2 = r26
            goto L_0x020b
        L_0x02e4:
            r1 = 1
            goto L_0x02e9
        L_0x02e6:
            r26 = r2
            r1 = 0
        L_0x02e9:
            if (r1 != 0) goto L_0x033d
            java.lang.String r1 = r23.A()     // Catch:{ Exception -> 0x0339 }
            if (r12 == 0) goto L_0x02f6
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r2 = r13.c(r0)     // Catch:{ Exception -> 0x0339 }
            goto L_0x02fa
        L_0x02f6:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r2 = r13.d(r0)     // Catch:{ Exception -> 0x0339 }
        L_0x02fa:
            if (r2 == 0) goto L_0x0312
            java.lang.String r1 = r2.c()     // Catch:{ Exception -> 0x0339 }
            boolean r1 = r1.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0339 }
            if (r1 != 0) goto L_0x030a
            java.lang.String r20 = r2.c()     // Catch:{ Exception -> 0x0339 }
        L_0x030a:
            java.lang.String r1 = r2.b()     // Catch:{ Exception -> 0x0339 }
            java.lang.String r1 = r7.t(r1)     // Catch:{ Exception -> 0x0339 }
        L_0x0312:
            r10 = r1
            r1 = 0
            boolean[] r11 = new boolean[r1]     // Catch:{ Exception -> 0x032e }
            r1 = r23
            r14 = r26
            r2 = r24
            r21 = r3
            r3 = r0
            r22 = r4
            r4 = r20
            r20 = r5
            r5 = r10
            r10 = r6
            r6 = r11
            r1.x(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x032c }
            goto L_0x035d
        L_0x032c:
            r0 = move-exception
            goto L_0x036a
        L_0x032e:
            r0 = move-exception
            r14 = r26
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            goto L_0x036b
        L_0x0339:
            r0 = move-exception
            r14 = r26
            goto L_0x034b
        L_0x033d:
            r14 = r26
            goto L_0x0341
        L_0x0340:
            r14 = r2
        L_0x0341:
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            goto L_0x035d
        L_0x0349:
            r0 = move-exception
        L_0x034a:
            r14 = r2
        L_0x034b:
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            goto L_0x036a
        L_0x0353:
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            r19 = r14
            r14 = r2
        L_0x035d:
            r1 = 0
            goto L_0x0370
        L_0x035f:
            r0 = move-exception
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            r19 = r14
            r14 = r2
        L_0x036a:
            r1 = 0
        L_0x036b:
            boolean[] r2 = new boolean[r1]
            com.original.tase.Logger.d(r0, r2)
        L_0x0370:
            r6 = r10
            r2 = r14
            r14 = r19
            r5 = r20
            r3 = r21
            r4 = r22
            r10 = 0
            r11 = 1
            goto L_0x00e5
        L_0x037e:
            r21 = r3
            r22 = r4
            r20 = r5
            r10 = r6
            r19 = r14
            r1 = 0
            r6 = r10
            r14 = r19
            r5 = r20
            r3 = r21
            r4 = r22
            r10 = 0
            r11 = 1
            goto L_0x00c3
        L_0x0395:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.CBB.K(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo, java.lang.String, java.lang.String):void");
    }

    public String A() {
        return "CBB";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37267g = J();
        if (BaseProvider.v()) {
            for (String str : this.f37267g) {
                String[] split = str.split("##");
                if (split.length > 1) {
                    this.f37266f = split[0];
                    this.f37268h = split[1];
                    this.f37269i = true;
                } else {
                    this.f37266f = str;
                    this.f37269i = false;
                }
                K(observableEmitter, movieInfo, "-1", "-1");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37267g = J();
        if (BaseProvider.v()) {
            for (String str : this.f37267g) {
                String[] split = str.split("##");
                if (split.length > 1) {
                    this.f37266f = split[0];
                    this.f37268h = split[1];
                    this.f37269i = true;
                } else {
                    this.f37266f = str;
                    this.f37269i = false;
                }
                K(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
            }
        }
    }
}

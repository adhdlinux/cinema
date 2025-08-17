package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class GoGoMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String[] f37329e = Utils.getProvider(46).split(",");

    /* renamed from: f  reason: collision with root package name */
    public String f37330f = Utils.getProvider(46);

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r18, java.lang.String r19, com.movie.data.model.MovieInfo r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r3 = "quality"
            java.lang.Integer r0 = r20.getType()
            int r0 = r0.intValue()
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            java.lang.String r6 = r19.trim()
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = "?p=1"
            boolean r6 = r6.endsWith(r7)
            if (r6 != 0) goto L_0x0037
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r8 = r19
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x003a
        L_0x0037:
            r8 = r19
            r6 = r8
        L_0x003a:
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r1.f37330f
            r8.append(r9)
            java.lang.String r9 = "/"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r7 = r7.o(r6, r8)
            org.jsoup.nodes.Document r7 = org.jsoup.Jsoup.b(r7)
            java.lang.String r8 = "span.quality"
            org.jsoup.nodes.Element r8 = r7.r0(r8)
            if (r8 == 0) goto L_0x007f
            java.lang.String r8 = r8.v0()
            java.lang.String r8 = r8.trim()
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r9 = "cam"
            boolean r9 = r8.contains(r9)
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "ts"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x007f
        L_0x007d:
            r8 = 1
            goto L_0x0080
        L_0x007f:
            r8 = 0
        L_0x0080:
            java.util.HashMap r9 = com.original.Constants.c()
            java.lang.String r10 = "Referer"
            r9.put(r10, r6)
            java.lang.String r6 = "data-name"
            java.lang.String r10 = "data-film"
            if (r0 == 0) goto L_0x00a5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r11 = "ul#ip_server"
            org.jsoup.select.Elements r7 = r7.q0(r11)
            java.lang.String r11 = "a"
            org.jsoup.select.Elements r7 = r7.g(r11)
            r0.addAll(r7)
            goto L_0x014f
        L_0x00a5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r11 = "a.btn-eps.episode_"
            r0.append(r11)
            r12 = r21
            r0.append(r12)
            java.lang.String r13 = "[data-film][data-name]"
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            org.jsoup.nodes.Element r0 = r7.r0(r0)
            if (r0 != 0) goto L_0x00e4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            int r11 = java.lang.Integer.parseInt(r21)
            java.lang.String r11 = com.original.tase.utils.Utils.i(r11)
            r0.append(r11)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            org.jsoup.nodes.Element r0 = r7.r0(r0)
            if (r0 != 0) goto L_0x00e4
            return
        L_0x00e4:
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r1.f37330f
            r11.append(r12)
            java.lang.String r12 = "/index.php"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "postid=server&phimid="
            r12.append(r13)
            java.lang.String r13 = r0.c(r10)
            boolean[] r14 = new boolean[r4]
            java.lang.String r13 = com.original.tase.utils.Utils.k(r13, r14)
            r12.append(r13)
            java.lang.String r13 = "&keyurl="
            r12.append(r13)
            java.lang.String r0 = r0.c(r6)
            boolean[] r13 = new boolean[r4]
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r13)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            java.util.Map[] r12 = new java.util.Map[r5]
            r12[r4] = r9
            java.lang.String r0 = r7.l(r11, r0, r12)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.util.ArrayList r7 = new java.util.ArrayList
            java.lang.String r11 = "div[class*=\"server_\"]"
            org.jsoup.select.Elements r11 = r0.q0(r11)
            r7.<init>(r11)
            boolean r11 = r7.isEmpty()
            if (r11 == 0) goto L_0x014e
            java.lang.String r11 = "li"
            org.jsoup.select.Elements r0 = r0.q0(r11)
            r7.addAll(r0)
        L_0x014e:
            r0 = r7
        L_0x014f:
            java.util.Iterator r7 = r0.iterator()
        L_0x0153:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x047f
            java.lang.Object r0 = r7.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            r18.isDisposed()
            java.lang.String r11 = "a[data-film][data-server][data-name]"
            org.jsoup.nodes.Element r0 = r0.r0(r11)     // Catch:{ Exception -> 0x0469 }
            java.lang.String r11 = r0.c(r10)     // Catch:{ Exception -> 0x0469 }
            boolean[] r12 = new boolean[r4]     // Catch:{ Exception -> 0x0469 }
            java.lang.String r11 = com.original.tase.utils.Utils.k(r11, r12)     // Catch:{ Exception -> 0x0469 }
            java.lang.String r12 = "data-server"
            java.lang.String r12 = r0.c(r12)     // Catch:{ Exception -> 0x0469 }
            boolean[] r13 = new boolean[r4]     // Catch:{ Exception -> 0x0469 }
            java.lang.String r12 = com.original.tase.utils.Utils.k(r12, r13)     // Catch:{ Exception -> 0x0469 }
            com.google.gson.JsonParser r13 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0469 }
            r13.<init>()     // Catch:{ Exception -> 0x0469 }
            com.original.tase.helper.http.HttpHelper r14 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x0469 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0469 }
            r15.<init>()     // Catch:{ Exception -> 0x0469 }
            java.lang.String r5 = r1.f37330f     // Catch:{ Exception -> 0x0469 }
            r15.append(r5)     // Catch:{ Exception -> 0x0469 }
            java.lang.String r5 = "/ip.file/swf/ipplayer/ipplayer.php?u="
            r15.append(r5)     // Catch:{ Exception -> 0x0469 }
            com.google.gson.JsonParser r5 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0469 }
            r5.<init>()     // Catch:{ Exception -> 0x0469 }
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x0469 }
            r19 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0463 }
            r7.<init>()     // Catch:{ Exception -> 0x0463 }
            r16 = r10
            java.lang.String r10 = r1.f37330f     // Catch:{ Exception -> 0x0460 }
            r7.append(r10)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r10 = "/ip.file/swf/plugins/ipplugins.php"
            r7.append(r10)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0460 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0460 }
            r10.<init>()     // Catch:{ Exception -> 0x0460 }
            java.lang.String r1 = "ipplugins=1&ip_film="
            r10.append(r1)     // Catch:{ Exception -> 0x045b }
            r10.append(r11)     // Catch:{ Exception -> 0x045b }
            java.lang.String r1 = "&ip_server="
            r10.append(r1)     // Catch:{ Exception -> 0x045b }
            r10.append(r12)     // Catch:{ Exception -> 0x045b }
            java.lang.String r1 = "&ip_name="
            r10.append(r1)     // Catch:{ Exception -> 0x045b }
            java.lang.String r0 = r0.c(r6)     // Catch:{ Exception -> 0x045b }
            r1 = 0
            boolean[] r11 = new boolean[r1]     // Catch:{ Exception -> 0x0456 }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r11)     // Catch:{ Exception -> 0x0456 }
            r10.append(r0)     // Catch:{ Exception -> 0x0456 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x0456 }
            r10 = 1
            java.util.Map[] r11 = new java.util.Map[r10]     // Catch:{ Exception -> 0x0456 }
            r11[r1] = r9     // Catch:{ Exception -> 0x0456 }
            java.lang.String r0 = r4.l(r7, r0, r11)     // Catch:{ Exception -> 0x045b }
            com.google.gson.JsonElement r0 = r5.a(r0)     // Catch:{ Exception -> 0x045b }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ Exception -> 0x045b }
            java.lang.String r1 = "s"
            com.google.gson.JsonElement r0 = r0.m(r1)     // Catch:{ Exception -> 0x045b }
            java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x045b }
            r1 = 0
            boolean[] r4 = new boolean[r1]     // Catch:{ Exception -> 0x0456 }
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r4)     // Catch:{ Exception -> 0x045b }
            r15.append(r0)     // Catch:{ Exception -> 0x045b }
            java.lang.String r0 = "&w=100%25&h=500&s="
            r15.append(r0)     // Catch:{ Exception -> 0x045b }
            r15.append(r12)     // Catch:{ Exception -> 0x045b }
            java.lang.String r0 = "&n="
            r15.append(r0)     // Catch:{ Exception -> 0x045b }
            r1 = 0
            r15.append(r1)     // Catch:{ Exception -> 0x0456 }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x0456 }
            r4 = 1
            java.util.Map[] r5 = new java.util.Map[r4]     // Catch:{ Exception -> 0x0454 }
            r5[r1] = r9     // Catch:{ Exception -> 0x0456 }
            java.lang.String r0 = r14.m(r0, r5)     // Catch:{ Exception -> 0x045b }
            com.google.gson.JsonElement r0 = r13.a(r0)     // Catch:{ Exception -> 0x045b }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ Exception -> 0x045b }
            java.lang.String r1 = "data"
            com.google.gson.JsonElement r0 = r0.m(r1)     // Catch:{ Exception -> 0x045b }
            boolean r1 = r0.g()     // Catch:{ Exception -> 0x045b }
            java.lang.String r4 = "Cookie"
            java.lang.String r5 = "User-Agent"
            java.lang.String r7 = "GoogleVideo"
            java.lang.String r10 = " (CAM)"
            if (r1 == 0) goto L_0x038c
            com.google.gson.JsonArray r0 = r0.b()     // Catch:{ Exception -> 0x0385 }
            java.util.Iterator r1 = r0.iterator()     // Catch:{ Exception -> 0x0385 }
        L_0x0249:
            boolean r0 = r1.hasNext()     // Catch:{ Exception -> 0x0385 }
            if (r0 == 0) goto L_0x044f
            java.lang.Object r0 = r1.next()     // Catch:{ Exception -> 0x0385 }
            com.google.gson.JsonElement r0 = (com.google.gson.JsonElement) r0     // Catch:{ Exception -> 0x0385 }
            r18.isDisposed()     // Catch:{ Exception -> 0x0385 }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ Exception -> 0x0378 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x0378 }
            r11.<init>()     // Catch:{ Exception -> 0x0378 }
            java.lang.String r12 = "files"
            com.google.gson.JsonElement r12 = r0.m(r12)     // Catch:{ Exception -> 0x0378 }
            boolean r13 = r12.g()     // Catch:{ Exception -> 0x0378 }
            if (r13 == 0) goto L_0x028f
            com.google.gson.JsonArray r12 = r12.b()     // Catch:{ Exception -> 0x0378 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0378 }
        L_0x0275:
            boolean r13 = r12.hasNext()     // Catch:{ Exception -> 0x0378 }
            if (r13 == 0) goto L_0x029c
            java.lang.Object r13 = r12.next()     // Catch:{ Exception -> 0x0378 }
            com.google.gson.JsonElement r13 = (com.google.gson.JsonElement) r13     // Catch:{ Exception -> 0x0378 }
            boolean r14 = r13.h()     // Catch:{ Exception -> 0x0378 }
            if (r14 != 0) goto L_0x0275
            java.lang.String r13 = r13.e()     // Catch:{ Exception -> 0x0378 }
            r11.add(r13)     // Catch:{ Exception -> 0x0378 }
            goto L_0x0275
        L_0x028f:
            boolean r13 = r12.h()     // Catch:{ Exception -> 0x0378 }
            if (r13 != 0) goto L_0x029c
            java.lang.String r12 = r12.e()     // Catch:{ Exception -> 0x0378 }
            r11.add(r12)     // Catch:{ Exception -> 0x0378 }
        L_0x029c:
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x0378 }
        L_0x02a0:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x0378 }
            if (r12 == 0) goto L_0x0375
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x0378 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0378 }
            boolean r13 = r18.isDisposed()     // Catch:{ Exception -> 0x0378 }
            if (r13 == 0) goto L_0x02b3
            return
        L_0x02b3:
            boolean r13 = com.original.tase.helper.GoogleVideoHelper.n(r12)     // Catch:{ Exception -> 0x0378 }
            if (r13 == 0) goto L_0x02eb
            if (r8 == 0) goto L_0x02cf
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0378 }
            r14.<init>()     // Catch:{ Exception -> 0x0378 }
            java.lang.String r15 = r17.A()     // Catch:{ Exception -> 0x0378 }
            r14.append(r15)     // Catch:{ Exception -> 0x0378 }
            r14.append(r10)     // Catch:{ Exception -> 0x0378 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0378 }
            goto L_0x02d3
        L_0x02cf:
            java.lang.String r14 = r17.A()     // Catch:{ Exception -> 0x0378 }
        L_0x02d3:
            java.util.List r14 = com.original.tase.helper.GoogleVideoHelper.k(r12, r14)     // Catch:{ Exception -> 0x0378 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0378 }
        L_0x02db:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x0378 }
            if (r15 == 0) goto L_0x02eb
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x0378 }
            com.original.tase.model.media.MediaSource r15 = (com.original.tase.model.media.MediaSource) r15     // Catch:{ Exception -> 0x0378 }
            r2.onNext(r15)     // Catch:{ Exception -> 0x0378 }
            goto L_0x02db
        L_0x02eb:
            com.original.tase.model.media.MediaSource r14 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0378 }
            if (r8 == 0) goto L_0x0305
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0378 }
            r15.<init>()     // Catch:{ Exception -> 0x0378 }
            r21 = r1
            java.lang.String r1 = r17.A()     // Catch:{ Exception -> 0x0373 }
            r15.append(r1)     // Catch:{ Exception -> 0x0373 }
            r15.append(r10)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = r15.toString()     // Catch:{ Exception -> 0x0373 }
            goto L_0x030b
        L_0x0305:
            r21 = r1
            java.lang.String r1 = r17.A()     // Catch:{ Exception -> 0x0373 }
        L_0x030b:
            if (r13 == 0) goto L_0x030f
            r15 = r7
            goto L_0x0311
        L_0x030f:
            java.lang.String r15 = "CDN"
        L_0x0311:
            if (r13 != 0) goto L_0x0315
            r13 = 1
            goto L_0x0316
        L_0x0315:
            r13 = 0
        L_0x0316:
            r14.<init>(r1, r15, r13)     // Catch:{ Exception -> 0x0373 }
            r14.setStreamLink(r12)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = "HQ"
            boolean r13 = com.original.tase.helper.GoogleVideoHelper.n(r12)     // Catch:{ Exception -> 0x0373 }
            if (r13 == 0) goto L_0x0329
            java.lang.String r1 = com.original.tase.helper.GoogleVideoHelper.h(r12)     // Catch:{ Exception -> 0x0373 }
            goto L_0x0345
        L_0x0329:
            com.google.gson.JsonElement r13 = r0.m(r3)     // Catch:{ Exception -> 0x0373 }
            if (r13 == 0) goto L_0x0345
            com.google.gson.JsonElement r13 = r0.m(r3)     // Catch:{ Exception -> 0x0373 }
            boolean r13 = r13.h()     // Catch:{ Exception -> 0x0373 }
            if (r13 != 0) goto L_0x0345
            com.google.gson.JsonElement r1 = r0.m(r3)     // Catch:{ Exception -> 0x0373 }
            int r1 = r1.a()     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0373 }
        L_0x0345:
            r14.setQuality((java.lang.String) r1)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r1 = "docs"
            boolean r1 = r12.contains(r1)     // Catch:{ Exception -> 0x0373 }
            if (r1 == 0) goto L_0x036c
            java.lang.String r1 = "securesc"
            boolean r1 = r12.contains(r1)     // Catch:{ Exception -> 0x0373 }
            if (r1 == 0) goto L_0x036c
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0373 }
            r1.<init>()     // Catch:{ Exception -> 0x0373 }
            java.lang.String r13 = com.original.Constants.C     // Catch:{ Exception -> 0x0373 }
            r1.put(r5, r13)     // Catch:{ Exception -> 0x0373 }
            java.lang.String r12 = com.original.tase.helper.GoogleVideoHelper.m(r12, r12)     // Catch:{ Exception -> 0x0373 }
            r1.put(r4, r12)     // Catch:{ Exception -> 0x0373 }
            r14.setPlayHeader(r1)     // Catch:{ Exception -> 0x0373 }
        L_0x036c:
            r2.onNext(r14)     // Catch:{ Exception -> 0x0373 }
            r1 = r21
            goto L_0x02a0
        L_0x0373:
            r0 = move-exception
            goto L_0x037b
        L_0x0375:
            r21 = r1
            goto L_0x0381
        L_0x0378:
            r0 = move-exception
            r21 = r1
        L_0x037b:
            r1 = 0
            boolean[] r11 = new boolean[r1]     // Catch:{ Exception -> 0x0456 }
            com.original.tase.Logger.d(r0, r11)     // Catch:{ Exception -> 0x0385 }
        L_0x0381:
            r1 = r21
            goto L_0x0249
        L_0x0385:
            r0 = move-exception
            r7 = r17
            r1 = 0
            r4 = 1
            goto L_0x0471
        L_0x038c:
            boolean r1 = r0.h()     // Catch:{ Exception -> 0x045b }
            if (r1 != 0) goto L_0x044f
            java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x045b }
            java.lang.String r1 = "//"
            boolean r1 = r0.startsWith(r1)     // Catch:{ Exception -> 0x045b }
            if (r1 == 0) goto L_0x03af
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0385 }
            r1.<init>()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r11 = "https:"
            r1.append(r11)     // Catch:{ Exception -> 0x0385 }
            r1.append(r0)     // Catch:{ Exception -> 0x0385 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0385 }
        L_0x03af:
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x045b }
            if (r1 != 0) goto L_0x044f
            boolean r1 = com.original.tase.helper.GoogleVideoHelper.l(r0)     // Catch:{ Exception -> 0x045b }
            if (r1 == 0) goto L_0x043d
            java.util.HashMap r1 = com.original.tase.helper.GoogleVideoHelper.g(r0)     // Catch:{ Exception -> 0x0385 }
            if (r1 == 0) goto L_0x044f
            boolean r11 = r1.isEmpty()     // Catch:{ Exception -> 0x0385 }
            if (r11 != 0) goto L_0x044f
            java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x0385 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0385 }
        L_0x03cf:
            boolean r11 = r1.hasNext()     // Catch:{ Exception -> 0x0385 }
            if (r11 == 0) goto L_0x044f
            java.lang.Object r11 = r1.next()     // Catch:{ Exception -> 0x0385 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x0385 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0385 }
            com.original.tase.model.media.MediaSource r13 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0385 }
            if (r8 == 0) goto L_0x03f9
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0385 }
            r14.<init>()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r15 = r17.A()     // Catch:{ Exception -> 0x0385 }
            r14.append(r15)     // Catch:{ Exception -> 0x0385 }
            r14.append(r10)     // Catch:{ Exception -> 0x0385 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0385 }
            goto L_0x03fd
        L_0x03f9:
            java.lang.String r14 = r17.A()     // Catch:{ Exception -> 0x0385 }
        L_0x03fd:
            r15 = 0
            r13.<init>(r14, r7, r15)     // Catch:{ Exception -> 0x0385 }
            r13.setOriginalLink(r0)     // Catch:{ Exception -> 0x0385 }
            r13.setStreamLink(r12)     // Catch:{ Exception -> 0x0385 }
            java.lang.Object r12 = r11.getValue()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0385 }
            boolean r12 = r12.isEmpty()     // Catch:{ Exception -> 0x0385 }
            if (r12 == 0) goto L_0x0416
            java.lang.String r12 = " HD"
            goto L_0x041c
        L_0x0416:
            java.lang.Object r12 = r11.getValue()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0385 }
        L_0x041c:
            r13.setQuality((java.lang.String) r12)     // Catch:{ Exception -> 0x0385 }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x0385 }
            r12.<init>()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r14 = com.original.Constants.C     // Catch:{ Exception -> 0x0385 }
            r12.put(r5, r14)     // Catch:{ Exception -> 0x0385 }
            java.lang.Object r11 = r11.getKey()     // Catch:{ Exception -> 0x0385 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0385 }
            java.lang.String r11 = com.original.tase.helper.GoogleVideoHelper.m(r0, r11)     // Catch:{ Exception -> 0x0385 }
            r12.put(r4, r11)     // Catch:{ Exception -> 0x0385 }
            r13.setPlayHeader(r12)     // Catch:{ Exception -> 0x0385 }
            r2.onNext(r13)     // Catch:{ Exception -> 0x0385 }
            goto L_0x03cf
        L_0x043d:
            java.lang.String r1 = "HD"
            r4 = 1
            boolean[] r5 = new boolean[r4]     // Catch:{ Exception -> 0x044d }
            r7 = 0
            r5[r7] = r8     // Catch:{ Exception -> 0x044d }
            r7 = r17
            r7.z(r2, r0, r1, r5)     // Catch:{ Exception -> 0x044b }
            goto L_0x0452
        L_0x044b:
            r0 = move-exception
            goto L_0x0470
        L_0x044d:
            r0 = move-exception
            goto L_0x045d
        L_0x044f:
            r4 = 1
            r7 = r17
        L_0x0452:
            r1 = 0
            goto L_0x0476
        L_0x0454:
            r0 = move-exception
            goto L_0x0458
        L_0x0456:
            r0 = move-exception
            r4 = 1
        L_0x0458:
            r7 = r17
            goto L_0x0471
        L_0x045b:
            r0 = move-exception
            r4 = 1
        L_0x045d:
            r7 = r17
            goto L_0x0470
        L_0x0460:
            r0 = move-exception
            r7 = r1
            goto L_0x0467
        L_0x0463:
            r0 = move-exception
            r7 = r1
            r16 = r10
        L_0x0467:
            r4 = 1
            goto L_0x0470
        L_0x0469:
            r0 = move-exception
            r19 = r7
            r16 = r10
            r4 = 1
            r7 = r1
        L_0x0470:
            r1 = 0
        L_0x0471:
            boolean[] r5 = new boolean[r1]
            com.original.tase.Logger.d(r0, r5)
        L_0x0476:
            r1 = r7
            r10 = r16
            r4 = 0
            r5 = 1
            r7 = r19
            goto L_0x0153
        L_0x047f:
            r7 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.GoGoMovies.J(io.reactivex.ObservableEmitter, java.lang.String, com.movie.data.model.MovieInfo, java.lang.String):void");
    }

    public String A() {
        return "GoGoMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String c2;
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("Upgrade-Insecure-Requests", "1");
        for (String str : this.f37329e) {
            hashMap.put("Host", str.replace("http://", "").replace("https://", ""));
            this.f37330f = str;
            HttpHelper.i().m(this.f37330f, new Map[0]);
            HttpHelper.i().D(this.f37330f, "__test");
            String m2 = HttpHelper.i().m(this.f37330f + "/search/" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]) + ".html", hashMap);
            Iterator it2 = Jsoup.b(m2).q0("div.ml-item").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Element element = (Element) it2.next();
                Element r02 = element.r0("a[href][title]");
                if (r02 != null) {
                    c2 = r02.c("href");
                    String c3 = r02.c("title");
                    String a2 = Regex.a(c3, "(.*?)\\s+\\((\\d{4})\\)", 1);
                    String a3 = Regex.a(c3, "(.*?)\\s+\\((\\d{4})\\)", 2);
                    if (!a2.isEmpty()) {
                        c3 = a2;
                    }
                    if (a3.isEmpty()) {
                        a3 = Regex.c(element.toString(), "<div\\s+[^>]*class=\"jt-info\"[^>]*>\\s*(\\d{4})\\s*</div>", 1, true);
                    }
                    if (!c2.isEmpty() && !c3.isEmpty() && TitleHelper.f(c3).equals(TitleHelper.f(movieInfo.getName()))) {
                        if (a3.trim().isEmpty() || !com.original.tase.utils.Utils.o(a3.trim()) || movieInfo.getYear().intValue() <= 0 || Integer.parseInt(a3.trim()) == movieInfo.getYear().intValue()) {
                            m2 = c2;
                        }
                    }
                }
            }
            m2 = c2;
            String trim = m2.trim();
            if (trim.isEmpty()) {
                MovieInfo movieInfo2 = movieInfo;
                ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
            } else {
                if (trim.startsWith("/")) {
                    trim = this.f37330f + trim;
                }
                J(observableEmitter, trim, movieInfo, "-1");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        for (String str2 : this.f37329e) {
            this.f37330f = str2;
            HttpHelper.i().m(this.f37330f, new Map[0]);
            HttpHelper.i().D(this.f37330f, "__test");
            Iterator it2 = Jsoup.b(HttpHelper.i().o(this.f37330f + "/search/" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]) + ".html", this.f37330f + "/")).q0("div.ml-item").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = "";
                    break;
                }
                Element r02 = ((Element) it2.next()).r0("a[href][title]");
                if (r02 != null) {
                    str = r02.c("href");
                    if ((movieInfo.name + " - S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.session))).toLowerCase().equals(r02.c("title").toLowerCase())) {
                        break;
                    }
                }
            }
            String trim = str.trim();
            if (!trim.isEmpty()) {
                if (trim.startsWith("/")) {
                    trim = this.f37330f + trim;
                }
                J(observableEmitter, trim, movieInfo, movieInfo.eps);
            }
        }
    }
}

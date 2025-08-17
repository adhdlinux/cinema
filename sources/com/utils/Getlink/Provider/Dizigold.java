package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import com.uwetrottmann.trakt5.TraktV2;
import io.reactivex.ObservableEmitter;

public class Dizigold extends BaseProvider {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f37304f = {"1", TraktV2.API_VERSION, "3"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f37305g = {"tr", "or", "en"};

    /* renamed from: e  reason: collision with root package name */
    private String f37306e = Utils.getProvider(107);

    public String A() {
        return "Dizigold";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(com.movie.data.model.MovieInfo r27, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r1.f37306e
            r0.append(r3)
            java.lang.String r3 = "/"
            r0.append(r3)
            java.lang.String r4 = r27.getName()
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "Marvel's "
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)
            java.lang.String r4 = com.original.tase.helper.TitleHelper.e(r4)
            java.lang.String r5 = "'"
            java.lang.String r6 = "-"
            java.lang.String r4 = r4.replace(r5, r6)
            java.lang.String r5 = "P.D."
            java.lang.String r7 = "PD"
            java.lang.String r4 = r4.replace(r5, r7)
            java.lang.String r4 = com.original.tase.helper.TitleHelper.h(r4, r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.Integer r3 = r27.getSession()
            r4.append(r3)
            java.lang.String r3 = "-sezon/"
            r4.append(r3)
            java.lang.Integer r3 = r27.getEps()
            r4.append(r3)
            java.lang.String r3 = "-bolum"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()
            r5 = 0
            java.util.Map[] r6 = new java.util.Map[r5]
            java.lang.String r4 = r4.m(r0, r6)
            java.lang.String r6 = ">\\s*(\\d{4})\\s*(?:–|)\\s*<"
            r7 = 1
            java.lang.String r4 = com.original.tase.utils.Regex.a(r4, r6, r7)
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L_0x02a5
            java.lang.Integer r6 = r27.getYear()
            int r6 = r6.intValue()
            if (r6 <= 0) goto L_0x009b
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r6 = r27.getYear()
            int r6 = r6.intValue()
            if (r4 == r6) goto L_0x009b
            goto L_0x02a5
        L_0x009b:
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r0 = r4.o(r3, r0)
            java.lang.String r4 = "var\\s+view_id\\s*=\\s*\"(\\d*)\""
            java.lang.String r4 = com.original.tase.utils.Regex.a(r0, r4, r7)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x00b0
            return
        L_0x00b0:
            java.lang.String[] r6 = f37305g
            int r8 = r6.length
            r9 = 0
        L_0x00b4:
            if (r9 >= r8) goto L_0x02a5
            r10 = r6[r9]
            java.lang.String[] r11 = f37304f
            int r12 = r11.length
            r13 = 0
        L_0x00bc:
            if (r13 >= r12) goto L_0x0294
            r0 = r11[r13]
            boolean r14 = r28.isDisposed()
            if (r14 == 0) goto L_0x00c7
            return
        L_0x00c7:
            com.original.tase.helper.http.HttpHelper r14 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r7 = "https://player.dizigold1.net/?id="
            r15.append(r7)
            r15.append(r4)
            java.lang.String r7 = "&s="
            r15.append(r7)
            r15.append(r0)
            java.lang.String r0 = "&dil="
            r15.append(r0)
            r15.append(r10)
            java.lang.String r0 = "&ref=golden-bird"
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            java.lang.String r0 = r14.o(r0, r3)
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L_0x0275
            org.jsoup.nodes.Document r7 = org.jsoup.Jsoup.b(r0)
            java.lang.String r14 = "iframe[src]"
            org.jsoup.select.Elements r7 = r7.q0(r14)
            java.util.Iterator r7 = r7.iterator()
        L_0x0109:
            boolean r14 = r7.hasNext()
            java.lang.String r15 = "HD"
            if (r14 == 0) goto L_0x0139
            java.lang.Object r14 = r7.next()
            org.jsoup.nodes.Element r14 = (org.jsoup.nodes.Element) r14
            java.lang.String r5 = "src"
            java.lang.String r5 = r14.c(r5)
            java.lang.String r14 = "or"
            boolean r14 = r10.equals(r14)
            if (r14 == 0) goto L_0x0137
            java.lang.String r14 = "adserver"
            boolean r14 = r5.contains(r14)
            if (r14 != 0) goto L_0x0137
            r16 = r3
            r14 = 0
            boolean[] r3 = new boolean[r14]
            r1.z(r2, r5, r15, r3)
            r3 = r16
        L_0x0137:
            r5 = 0
            goto L_0x0109
        L_0x0139:
            r16 = r3
            java.lang.String r3 = "tr"
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x014e
            java.lang.String r3 = "['\"]?kind['\"]?\\s*:\\s*['\"]?(captions|subtitles)['\"]?"
            r5 = 1
            java.lang.String r3 = com.original.tase.utils.Regex.c(r0, r3, r5, r5)
            r3.isEmpty()
            goto L_0x014f
        L_0x014e:
            r5 = 1
        L_0x014f:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r7 = "['\"]?sources[\"']?\\s*:\\s*\\[(.*?)\\}\\s*,?\\s*\\]"
            java.util.ArrayList r7 = com.original.tase.utils.Regex.f(r0, r7, r5, r5)
            r5 = 0
            java.lang.Object r7 = r7.get(r5)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.util.Iterator r5 = r7.iterator()
        L_0x0165:
            boolean r7 = r5.hasNext()
            java.lang.String r14 = "GoogleVideo"
            java.lang.String r17 = "CDN"
            if (r7 == 0) goto L_0x021c
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            r27 = r4
            java.lang.String r4 = "['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]\\s*,\\s*['\"]?label['\"]?\\s*:\\s*['\"]?(\\d{3,4})p"
            r18 = r5
            r5 = 2
            r19 = r6
            r6 = 1
            java.util.ArrayList r4 = com.original.tase.utils.Regex.f(r7, r4, r5, r6)
            r5 = 0
            java.lang.Object r7 = r4.get(r5)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r4 = r4.get(r6)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r5 = 0
        L_0x0191:
            int r6 = r7.size()
            if (r5 >= r6) goto L_0x0214
            java.lang.Object r6 = r7.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r20 = r4.get(r5)     // Catch:{ Exception -> 0x01cf }
            java.lang.String r20 = (java.lang.String) r20     // Catch:{ Exception -> 0x01cf }
            boolean r20 = r20.isEmpty()     // Catch:{ Exception -> 0x01cf }
            if (r20 == 0) goto L_0x01ae
            r22 = r4
            r20 = r7
            goto L_0x01d4
        L_0x01ae:
            r20 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cc }
            r7.<init>()     // Catch:{ Exception -> 0x01cc }
            java.lang.Object r21 = r4.get(r5)     // Catch:{ Exception -> 0x01cc }
            r22 = r4
            r4 = r21
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x01d3 }
            r7.append(r4)     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r4 = "p"
            r7.append(r4)     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x01d3 }
            goto L_0x01d5
        L_0x01cc:
            r22 = r4
            goto L_0x01d3
        L_0x01cf:
            r22 = r4
            r20 = r7
        L_0x01d3:
        L_0x01d4:
            r4 = r15
        L_0x01d5:
            boolean r7 = com.original.tase.helper.GoogleVideoHelper.n(r6)
            r21 = r4
            com.original.tase.model.media.MediaSource r4 = new com.original.tase.model.media.MediaSource
            r23 = r8
            java.lang.String r8 = r26.A()
            r24 = r10
            r25 = r11
            if (r7 == 0) goto L_0x01eb
            r10 = r14
            goto L_0x01ed
        L_0x01eb:
            r10 = r17
        L_0x01ed:
            r11 = 0
            r4.<init>(r8, r10, r11)
            r4.setStreamLink(r6)
            if (r7 == 0) goto L_0x01fb
            java.lang.String r7 = com.original.tase.helper.GoogleVideoHelper.h(r6)
            goto L_0x01fd
        L_0x01fb:
            r7 = r21
        L_0x01fd:
            r4.setQuality((java.lang.String) r7)
            r2.onNext(r4)
            r3.add(r6)
            int r5 = r5 + 1
            r7 = r20
            r4 = r22
            r8 = r23
            r10 = r24
            r11 = r25
            goto L_0x0191
        L_0x0214:
            r4 = r27
            r5 = r18
            r6 = r19
            goto L_0x0165
        L_0x021c:
            r27 = r4
            r19 = r6
            r23 = r8
            r24 = r10
            r25 = r11
            java.util.ArrayList r0 = r1.w(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x022e:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0266
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r3.contains(r4)
            if (r5 != 0) goto L_0x022e
            boolean r5 = com.original.tase.helper.GoogleVideoHelper.n(r4)
            com.original.tase.model.media.MediaSource r6 = new com.original.tase.model.media.MediaSource
            java.lang.String r7 = r26.A()
            if (r5 == 0) goto L_0x024e
            r8 = r14
            goto L_0x0250
        L_0x024e:
            r8 = r17
        L_0x0250:
            r10 = 0
            r6.<init>(r7, r8, r10)
            r6.setStreamLink(r4)
            if (r5 == 0) goto L_0x025e
            java.lang.String r4 = com.original.tase.helper.GoogleVideoHelper.h(r4)
            goto L_0x025f
        L_0x025e:
            r4 = r15
        L_0x025f:
            r6.setQuality((java.lang.String) r4)
            r2.onNext(r6)
            goto L_0x022e
        L_0x0266:
            r3 = 10000(0x2710, double:4.9407E-320)
            java.lang.Thread.sleep(r3)     // Catch:{ all -> 0x026c }
            goto L_0x0281
        L_0x026c:
            r0 = move-exception
            r3 = r0
            r4 = 0
            boolean[] r0 = new boolean[r4]
            com.original.tase.Logger.d(r3, r0)
            goto L_0x0282
        L_0x0275:
            r16 = r3
            r27 = r4
            r19 = r6
            r23 = r8
            r24 = r10
            r25 = r11
        L_0x0281:
            r4 = 0
        L_0x0282:
            int r13 = r13 + 1
            r4 = r27
            r3 = r16
            r6 = r19
            r8 = r23
            r10 = r24
            r11 = r25
            r5 = 0
            r7 = 1
            goto L_0x00bc
        L_0x0294:
            r16 = r3
            r27 = r4
            r19 = r6
            r23 = r8
            r4 = 0
            int r9 = r9 + 1
            r4 = r27
            r5 = 0
            r7 = 1
            goto L_0x00b4
        L_0x02a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.Dizigold.D(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }
}

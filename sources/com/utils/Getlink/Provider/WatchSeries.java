package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class WatchSeries extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f37492e = Utils.getProvider(39).split(",");

    /* renamed from: f  reason: collision with root package name */
    private static String f37493f = "";

    public String A() {
        return "WatchSeries";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cd, code lost:
        f37493f = r14;
        r8 = r15;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ed A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x035f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(com.movie.data.model.MovieInfo r21, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r22) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = r21.getName()
            java.lang.String r2 = r21.getName()
            java.lang.String r3 = "The Daily Show with Trevor Noah"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0015
            java.lang.String r2 = "The Daily Show"
            goto L_0x001f
        L_0x0015:
            java.lang.String r3 = "Will & Grace"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x001f
            java.lang.String r2 = "Will "
        L_0x001f:
            java.lang.String[] r3 = f37492e
            int r4 = r3.length
            java.lang.String r5 = ""
            r6 = 0
            r8 = r5
            r7 = 0
            r9 = 0
        L_0x0028:
            java.lang.String r10 = "a[href]"
            java.lang.String r11 = "href"
            java.lang.String r12 = "/"
            if (r7 >= r4) goto L_0x021b
            r14 = r3[r7]
            com.original.tase.helper.http.HttpHelper r15 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            r16 = r3
            java.lang.String r3 = "/search/"
            r13.append(r3)
            boolean[] r3 = new boolean[r6]
            java.lang.String r3 = com.original.tase.utils.Utils.k(r2, r3)
            r13.append(r3)
            java.lang.String r3 = r13.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            java.lang.String r3 = r15.o(r3, r13)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r13 = "div.table.infoside"
            org.jsoup.select.Elements r3 = r3.q0(r13)
            java.lang.String r13 = "a[itemprop]"
            org.jsoup.select.Elements r3 = r3.g(r13)
            java.util.Iterator r3 = r3.iterator()
        L_0x0079:
            boolean r13 = r3.hasNext()
            if (r13 == 0) goto L_0x00d0
            java.lang.Object r13 = r3.next()
            org.jsoup.nodes.Element r13 = (org.jsoup.nodes.Element) r13
            java.lang.String r15 = r13.c(r11)
            java.lang.String r6 = "title"
            java.lang.String r6 = r13.c(r6)
            boolean r17 = r6.isEmpty()
            if (r17 == 0) goto L_0x009f
            java.lang.String r6 = "h2"
            org.jsoup.select.Elements r6 = r13.q0(r6)
            java.lang.String r6 = r6.h()
        L_0x009f:
            boolean r13 = r6.contains(r2)
            if (r13 != 0) goto L_0x00cd
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r2)
            r17 = r3
            java.lang.String r3 = " ("
            r13.append(r3)
            java.lang.String r3 = r1.year
            r13.append(r3)
            java.lang.String r3 = ")"
            r13.append(r3)
            java.lang.String r3 = r13.toString()
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x00c9
            goto L_0x00cd
        L_0x00c9:
            r3 = r17
            r6 = 0
            goto L_0x0079
        L_0x00cd:
            f37493f = r14
            r8 = r15
        L_0x00d0:
            boolean r3 = r8.isEmpty()
            if (r3 == 0) goto L_0x0207
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r14)
            java.lang.String r13 = "/suggest.php?ajax=1&s="
            r6.append(r13)
            r17 = r4
            r15 = 0
            boolean[] r4 = new boolean[r15]
            java.lang.String r4 = com.original.tase.utils.Utils.k(r2, r4)
            r6.append(r4)
            java.lang.String r4 = "&type=TVShows"
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r18 = r8
            r15 = 1
            java.util.Map[] r8 = new java.util.Map[r15]
            java.util.HashMap r15 = com.original.Constants.c()
            r19 = r9
            r9 = 0
            r8[r9] = r15
            java.lang.String r3 = r3.l(r6, r14, r8)
            boolean r6 = r3.isEmpty()
            if (r6 == 0) goto L_0x0174
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r14)
            r6.append(r13)
            boolean[] r8 = new boolean[r9]
            java.lang.String r8 = com.original.tase.utils.Utils.k(r2, r8)
            r6.append(r8)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r6 = 1
            java.util.Map[] r8 = new java.util.Map[r6]
            java.util.HashMap r6 = com.original.Constants.c()
            r8[r9] = r6
            java.lang.String r3 = r3.l(r4, r14, r8)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0174
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r13)
            boolean[] r6 = new boolean[r9]
            java.lang.String r6 = com.original.tase.utils.Utils.k(r2, r6)
            r4.append(r6)
            java.lang.String r6 = ".&type=TVShows"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r6 = 1
            java.util.Map[] r8 = new java.util.Map[r6]
            java.util.HashMap r6 = com.original.Constants.c()
            r8[r9] = r6
            java.lang.String r3 = r3.l(r4, r14, r8)
        L_0x0174:
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            org.jsoup.select.Elements r3 = r3.q0(r10)
            java.util.Iterator r3 = r3.iterator()
            r8 = r18
            r9 = r19
        L_0x0184:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x020d
            java.lang.Object r4 = r3.next()
            org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
            java.lang.String r6 = r4.c(r11)
            java.lang.String r4 = r4.toString()
            java.lang.String r13 = "</?[^>]*>"
            java.lang.String r4 = r4.replaceAll(r13, r5)
            java.lang.String r13 = "\\((\\d{4})\\)$"
            r15 = 1
            java.lang.String r13 = com.original.tase.utils.Regex.a(r6, r13, r15)
            java.lang.String r15 = com.original.tase.helper.TitleHelper.f(r0)
            java.lang.String r4 = com.original.tase.helper.TitleHelper.f(r4)
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x0184
            java.lang.String r4 = r13.trim()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x01e3
            java.lang.String r4 = r13.trim()
            boolean r4 = com.original.tase.utils.Utils.o(r4)
            if (r4 == 0) goto L_0x01e3
            java.lang.Integer r4 = r21.getYear()
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x01e3
            java.lang.String r4 = r13.trim()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r15 = r21.getYear()
            int r15 = r15.intValue()
            if (r4 != r15) goto L_0x0184
        L_0x01e3:
            f37493f = r14
            java.lang.String r4 = r13.trim()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x01fc
            java.lang.String r4 = r13.trim()
            boolean r4 = com.original.tase.utils.Utils.o(r4)
            if (r4 != 0) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r4 = 0
            goto L_0x01fd
        L_0x01fc:
            r4 = 1
        L_0x01fd:
            java.lang.String r8 = f37493f
            r9 = r4
            if (r8 == 0) goto L_0x0204
            r8 = r6
            goto L_0x020d
        L_0x0204:
            r8 = r6
            goto L_0x0184
        L_0x0207:
            r17 = r4
            r18 = r8
            r19 = r9
        L_0x020d:
            java.lang.String r3 = f37493f
            if (r3 == 0) goto L_0x0212
            goto L_0x021d
        L_0x0212:
            int r7 = r7 + 1
            r3 = r16
            r4 = r17
            r6 = 0
            goto L_0x0028
        L_0x021b:
            r19 = r9
        L_0x021d:
            java.lang.String r0 = f37493f
            if (r0 == 0) goto L_0x040e
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x0229
            goto L_0x040e
        L_0x0229:
            java.lang.String r0 = "//"
            boolean r0 = r8.startsWith(r0)
            java.lang.String r2 = "http"
            if (r0 == 0) goto L_0x0245
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "http:"
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            goto L_0x0277
        L_0x0245:
            boolean r0 = r8.startsWith(r12)
            if (r0 == 0) goto L_0x025d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = f37493f
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            goto L_0x0277
        L_0x025d:
            boolean r0 = r8.startsWith(r2)
            if (r0 != 0) goto L_0x0277
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = f37493f
            r0.append(r3)
            r0.append(r12)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0277:
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r3 = f37493f
            java.lang.String r3 = r0.o(r8, r3)
            if (r9 == 0) goto L_0x02ee
            java.lang.String r0 = "<dd>\\s*(\\d{4})\\s*<"
            r4 = 34
            r5 = 1
            java.util.ArrayList r0 = com.original.tase.utils.Regex.e(r3, r0, r5, r4)     // Catch:{ Exception -> 0x02e3 }
            r4 = 0
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x02e1 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x02e3 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02e3 }
        L_0x0297:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x02e3 }
            if (r4 == 0) goto L_0x02de
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x02e3 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x02e3 }
            boolean r5 = r4.isEmpty()     // Catch:{ Exception -> 0x02e3 }
            if (r5 != 0) goto L_0x0297
            boolean r5 = com.original.tase.utils.Utils.o(r4)     // Catch:{ Exception -> 0x02e3 }
            if (r5 == 0) goto L_0x0297
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x02e3 }
            r5 = 1850(0x73a, float:2.592E-42)
            if (r4 < r5) goto L_0x0297
            r5 = 2030(0x7ee, float:2.845E-42)
            if (r4 > r5) goto L_0x0297
            java.lang.Integer r5 = r21.getYear()     // Catch:{ Exception -> 0x02e3 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x02e3 }
            if (r4 == r5) goto L_0x02dc
            java.lang.Integer r5 = r21.getYear()     // Catch:{ Exception -> 0x02e3 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x02e3 }
            r6 = 1
            int r5 = r5 + r6
            if (r4 == r5) goto L_0x02dc
            java.lang.Integer r5 = r21.getYear()     // Catch:{ Exception -> 0x02e3 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x02e3 }
            int r5 = r5 - r6
            if (r4 != r5) goto L_0x0297
        L_0x02dc:
            r0 = 1
            goto L_0x02df
        L_0x02de:
            r0 = 0
        L_0x02df:
            r15 = r0
            goto L_0x02eb
        L_0x02e1:
            r0 = move-exception
            goto L_0x02e5
        L_0x02e3:
            r0 = move-exception
            r4 = 0
        L_0x02e5:
            boolean[] r5 = new boolean[r4]
            com.original.tase.Logger.d(r0, r5)
            r15 = 1
        L_0x02eb:
            if (r15 != 0) goto L_0x02ee
            return
        L_0x02ee:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "href=\"([^\"]*s"
            r0.append(r4)
            java.lang.String r4 = r1.session
            r0.append(r4)
            java.lang.String r4 = "_e"
            r0.append(r4)
            java.lang.String r1 = r1.eps
            r0.append(r1)
            java.lang.String r1 = "(?!\\d)[^\"]*)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            java.lang.String r0 = com.original.tase.utils.Regex.c(r3, r0, r1, r1)
            boolean r1 = r0.startsWith(r12)
            if (r1 == 0) goto L_0x032d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = f37493f
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0334
        L_0x032d:
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0334
            return
        L_0x0334:
            r1 = r0
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r0 = r0.o(r1, r8)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x034b
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r0 = r0.o(r1, r8)
        L_0x034b:
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r3 = "table.W"
            org.jsoup.select.Elements r0 = r0.q0(r3)
            java.util.Iterator r3 = r0.iterator()
        L_0x0359:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x040b
            java.lang.Object r0 = r3.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r4 = "tr"
            org.jsoup.select.Elements r0 = r0.q0(r4)
            java.util.Iterator r4 = r0.iterator()
        L_0x036f:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0405
            java.lang.Object r0 = r4.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            boolean r5 = r22.isDisposed()     // Catch:{ Exception -> 0x03f8 }
            if (r5 == 0) goto L_0x0382
            return
        L_0x0382:
            org.jsoup.nodes.Element r0 = r0.r0(r10)     // Catch:{ Exception -> 0x03f8 }
            if (r0 == 0) goto L_0x03f1
            java.lang.String r0 = r0.c(r11)     // Catch:{ Exception -> 0x03f8 }
            boolean r5 = r0.startsWith(r12)     // Catch:{ Exception -> 0x03f8 }
            if (r5 != 0) goto L_0x0398
            boolean r5 = r0.startsWith(r2)     // Catch:{ Exception -> 0x03f8 }
            if (r5 != 0) goto L_0x03a9
        L_0x0398:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03f8 }
            r5.<init>()     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r6 = f37493f     // Catch:{ Exception -> 0x03f8 }
            r5.append(r6)     // Catch:{ Exception -> 0x03f8 }
            r5.append(r0)     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x03f8 }
        L_0x03a9:
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r0 = r5.o(r0, r1)     // Catch:{ Exception -> 0x03f8 }
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)     // Catch:{ Exception -> 0x03f8 }
            org.jsoup.select.Elements r0 = r0.q0(r10)     // Catch:{ Exception -> 0x03f8 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x03f8 }
        L_0x03bd:
            boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x03f8 }
            if (r5 == 0) goto L_0x03f1
            java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x03f8 }
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r6 = r5.toString()     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r7 = "click here to play"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x03f8 }
            if (r6 == 0) goto L_0x03ec
            java.lang.String r5 = r5.c(r11)     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r6 = "HQ"
            r7 = 0
            boolean[] r8 = new boolean[r7]     // Catch:{ Exception -> 0x03f8 }
            r7 = r20
            r9 = r22
            r7.z(r9, r5, r6, r8)     // Catch:{ Exception -> 0x03ea }
            goto L_0x03bd
        L_0x03ea:
            r0 = move-exception
            goto L_0x03fd
        L_0x03ec:
            r7 = r20
            r9 = r22
            goto L_0x03bd
        L_0x03f1:
            r7 = r20
            r9 = r22
            r5 = 0
            goto L_0x036f
        L_0x03f8:
            r0 = move-exception
            r7 = r20
            r9 = r22
        L_0x03fd:
            r5 = 0
            boolean[] r6 = new boolean[r5]
            com.original.tase.Logger.d(r0, r6)
            goto L_0x036f
        L_0x0405:
            r7 = r20
            r9 = r22
            goto L_0x0359
        L_0x040b:
            r7 = r20
            return
        L_0x040e:
            r7 = r20
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.WatchSeries.D(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }
}

package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Map;

public class Hd5movies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37345e = Utils.getProvider(28);

    /* renamed from: f  reason: collision with root package name */
    public String f37346f = "";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v9, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v11, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v12, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v13, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v17, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v18, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v19, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v20, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v21, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: com.original.tase.helper.DirectoryIndexHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: com.original.tase.helper.DirectoryIndexHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: com.original.tase.helper.DirectoryIndexHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: com.original.tase.helper.DirectoryIndexHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: com.original.tase.helper.DirectoryIndexHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: com.original.tase.helper.DirectoryIndexHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v37, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r12v19 */
    /* JADX WARNING: type inference failed for: r12v30 */
    /* JADX WARNING: type inference failed for: r12v31 */
    /* JADX WARNING: type inference failed for: r12v32 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r12v39 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K(com.movie.data.model.MovieInfo r25, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r26) {
        /*
            r24 = this;
            r7 = r24
            r0 = r25
            java.lang.String r8 = "1080p"
            java.lang.String r9 = "jksajknsaj\\('([0-9]+)','([^']+)"
            com.movie.data.api.GlobalVariable r1 = com.movie.data.api.GlobalVariable.c()
            com.movie.data.model.AppConfig r1 = r1.b()
            com.movie.data.model.AppConfig$AdsBean r1 = r1.getAds()
            if (r1 == 0) goto L_0x0017
            return
        L_0x0017:
            java.lang.Integer r1 = r25.getType()
            int r1 = r1.intValue()
            r10 = 0
            r11 = 1
            if (r1 != r11) goto L_0x0025
            r12 = 1
            goto L_0x0026
        L_0x0025:
            r12 = 0
        L_0x0026:
            com.original.tase.helper.DirectoryIndexHelper r13 = new com.original.tase.helper.DirectoryIndexHelper
            r13.<init>()
            java.lang.String r1 = r25.getName()
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r3 = r7.f37345e
            java.util.Map[] r4 = new java.util.Map[r10]
            r2.m(r3, r4)
            java.lang.String r14 = ""
            if (r12 == 0) goto L_0x0040
            r2 = r14
            goto L_0x006d
        L_0x0040:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " S"
            r2.append(r3)
            java.lang.String r3 = r0.session
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r3 = com.original.tase.utils.Utils.i(r3)
            r2.append(r3)
            java.lang.String r3 = "E"
            r2.append(r3)
            java.lang.String r3 = r0.eps
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r3 = com.original.tase.utils.Utils.i(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x006d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = " "
            java.lang.String r4 = com.original.tase.helper.TitleHelper.h(r1, r4)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r15 = 2
            if (r12 != 0) goto L_0x0087
            r4 = 2
            goto L_0x0088
        L_0x0087:
            r4 = 1
        L_0x0088:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r11 = r7.f37345e
            r5.append(r11)
            java.lang.String r11 = "/home/index.php?q=%s&t=%s&o="
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r11 = new java.lang.Object[r15]
            r11[r10] = r3
            java.lang.Integer r17 = java.lang.Integer.valueOf(r4)
            r16 = 1
            r11[r16] = r17
            java.lang.String r5 = java.lang.String.format(r5, r11)
            java.lang.String r11 = "referer"
            r6.put(r11, r5)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r19 = r9
            java.lang.String r9 = r7.f37345e
            r15.append(r9)
            java.lang.String r9 = "/"
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            r10.o(r5, r9)
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.f37345e
            r9.append(r10)
            java.lang.String r10 = "/home/ajax.php?reason=show_results"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r10 = 2
            java.lang.Object[] r15 = new java.lang.Object[r10]
            r10 = 0
            r15[r10] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r4 = 1
            r15[r4] = r3
            java.lang.String r3 = "q=%s&o=&t=%s&page="
            java.lang.String r3 = java.lang.String.format(r3, r15)
            java.util.Map[] r15 = new java.util.Map[r4]
            r15[r10] = r6
            java.lang.String r3 = r5.l(r9, r3, r15)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r4 = "div.card-body"
            org.jsoup.select.Elements r3 = r3.q0(r4)
            java.util.Iterator r3 = r3.iterator()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
        L_0x0116:
            boolean r5 = r3.hasNext()
            java.lang.String r9 = "/home/"
            java.lang.String r10 = "http"
            if (r5 == 0) goto L_0x01b8
            java.lang.Object r5 = r3.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            java.lang.String r15 = "a[href]"
            org.jsoup.nodes.Element r15 = r5.r0(r15)
            if (r15 != 0) goto L_0x012f
            goto L_0x0116
        L_0x012f:
            r20 = r3
            java.lang.String r3 = "href"
            java.lang.String r3 = r15.c(r3)
            java.lang.String r5 = r5.v0()
            if (r12 == 0) goto L_0x017b
            java.lang.String r15 = com.original.tase.helper.TitleHelper.f(r5)
            java.lang.String r21 = com.original.tase.helper.TitleHelper.e(r1)
            r22 = r11
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r21)
            boolean r11 = r15.startsWith(r11)
            if (r11 == 0) goto L_0x01b2
            java.lang.String r11 = r5.toUpperCase()
            java.lang.String r15 = r0.year
            boolean r11 = r11.contains(r15)
            if (r11 == 0) goto L_0x01b2
            boolean r10 = r3.contains(r10)
            if (r10 != 0) goto L_0x0177
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r7.f37345e
            r10.append(r11)
            r10.append(r9)
            r10.append(r3)
            java.lang.String r3 = r10.toString()
        L_0x0177:
            r4.put(r5, r3)
            goto L_0x01b2
        L_0x017b:
            r22 = r11
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r5)
            java.lang.String r15 = com.original.tase.helper.TitleHelper.e(r1)
            java.lang.String r15 = com.original.tase.helper.TitleHelper.f(r15)
            boolean r11 = r11.startsWith(r15)
            if (r11 == 0) goto L_0x01b2
            boolean r11 = r5.contains(r2)
            if (r11 == 0) goto L_0x01b2
            boolean r10 = r3.contains(r10)
            if (r10 != 0) goto L_0x01af
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r7.f37345e
            r10.append(r11)
            r10.append(r9)
            r10.append(r3)
            java.lang.String r3 = r10.toString()
        L_0x01af:
            r4.put(r5, r3)
        L_0x01b2:
            r3 = r20
            r11 = r22
            goto L_0x0116
        L_0x01b8:
            r22 = r11
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x01c1
            return
        L_0x01c1:
            r24.J()
            java.util.HashMap r11 = com.original.Constants.c()
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x053d
            java.util.Set r0 = r4.entrySet()
            java.util.Iterator r15 = r0.iterator()
        L_0x01d6:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x053d
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()     // Catch:{ Exception -> 0x051a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x051a }
            java.lang.Object r0 = r0.getKey()     // Catch:{ Exception -> 0x051a }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x051a }
            java.lang.String r2 = ".7z"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = ".rar"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = ".zip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = ".iso"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = ".avi"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = ".flv"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = "imdb."
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x051a }
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = r0.toUpperCase()     // Catch:{ Exception -> 0x051a }
            java.lang.String r3 = "(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)"
            java.lang.String r2 = r2.replaceAll(r3, r14)     // Catch:{ Exception -> 0x051a }
            java.lang.String r3 = "\\.|\\(|\\)|\\[|\\]|\\s|\\-"
            java.lang.String[] r2 = r2.split(r3)     // Catch:{ Exception -> 0x051a }
            int r3 = r2.length     // Catch:{ Exception -> 0x051a }
            java.lang.String r4 = "HQ"
            r20 = r4
            r5 = 0
        L_0x023c:
            if (r5 >= r3) goto L_0x0331
            r21 = r2[r5]     // Catch:{ Exception -> 0x031f }
            r25 = r2
            java.lang.String r2 = r21.toLowerCase()     // Catch:{ Exception -> 0x031f }
            r21 = r3
            java.lang.String r3 = "subs"
            boolean r3 = r2.endsWith(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "sub"
            boolean r3 = r2.endsWith(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "dubbed"
            boolean r3 = r2.endsWith(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "dub"
            boolean r3 = r2.endsWith(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "dvdscr"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "r5"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "r6"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "camrip"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "tsrip"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "hdcam"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "hdts"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "dvdcam"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "dvdts"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "cam"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "telesync"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "ts"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x031d
            java.lang.String r3 = "3d"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 == 0) goto L_0x02d1
            goto L_0x031d
        L_0x02d1:
            boolean r3 = r2.contains(r8)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x0313
            java.lang.String r3 = "1080"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 == 0) goto L_0x02e0
            goto L_0x0313
        L_0x02e0:
            java.lang.String r3 = "720p"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x0310
            java.lang.String r3 = "720"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x0310
            java.lang.String r3 = "brrip"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x0310
            java.lang.String r3 = "bdrip"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x0310
            java.lang.String r3 = "hdrip"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r3 != 0) goto L_0x0310
            java.lang.String r3 = "web-dl"
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x031f }
            if (r2 == 0) goto L_0x0315
        L_0x0310:
            java.lang.String r20 = "HD"
            goto L_0x0315
        L_0x0313:
            r20 = r8
        L_0x0315:
            int r5 = r5 + 1
            r2 = r25
            r3 = r21
            goto L_0x023c
        L_0x031d:
            r2 = 1
            goto L_0x0332
        L_0x031f:
            r0 = move-exception
            r20 = r6
            r23 = r12
            r18 = r13
            r12 = r19
            r13 = r22
            r1 = 0
            r22 = r8
            r8 = r26
            goto L_0x052a
        L_0x0331:
            r2 = 0
        L_0x0332:
            if (r2 != 0) goto L_0x050a
            java.lang.String r2 = r24.A()     // Catch:{ Exception -> 0x051a }
            if (r12 == 0) goto L_0x033f
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r0 = r13.c(r0)     // Catch:{ Exception -> 0x031f }
            goto L_0x0343
        L_0x033f:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r0 = r13.d(r0)     // Catch:{ Exception -> 0x051a }
        L_0x0343:
            if (r0 == 0) goto L_0x035d
            java.lang.String r2 = r0.c()     // Catch:{ Exception -> 0x031f }
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x031f }
            if (r2 != 0) goto L_0x0353
            java.lang.String r20 = r0.c()     // Catch:{ Exception -> 0x031f }
        L_0x0353:
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x031f }
            java.lang.String r0 = r7.t(r0)     // Catch:{ Exception -> 0x031f }
            r5 = r0
            goto L_0x035e
        L_0x035d:
            r5 = r2
        L_0x035e:
            r4 = r20
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x051a }
            r2 = 1
            java.util.Map[] r3 = new java.util.Map[r2]     // Catch:{ Exception -> 0x051a }
            r16 = 0
            r3[r16] = r6     // Catch:{ Exception -> 0x051a }
            java.lang.String r0 = r0.m(r1, r3)     // Catch:{ Exception -> 0x051a }
            r3 = r22
            r11.put(r3, r1)     // Catch:{ Exception -> 0x04fb }
            r1 = r19
            java.lang.String r19 = com.original.tase.utils.Regex.a(r0, r1, r2)     // Catch:{ Exception -> 0x04ee }
            r2 = 2
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r1, r2)     // Catch:{ Exception -> 0x04ee }
            boolean r2 = r19.isEmpty()     // Catch:{ Exception -> 0x04ee }
            if (r2 == 0) goto L_0x038b
            r19 = r1
            r22 = r3
            goto L_0x01d6
        L_0x038b:
            com.squareup.duktape.Duktape r2 = com.squareup.duktape.Duktape.create()     // Catch:{ Exception -> 0x04ee }
            r20 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04da }
            r1.<init>()     // Catch:{ all -> 0x04da }
            r21 = r6
            java.lang.String r6 = r7.f37346f     // Catch:{ all -> 0x04cb }
            r1.append(r6)     // Catch:{ all -> 0x04cb }
            java.lang.String r6 = "abc(%s)"
            r22 = r8
            r23 = r12
            r8 = 1
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ all -> 0x04c1 }
            r8 = 0
            r12[r8] = r19     // Catch:{ all -> 0x04c1 }
            java.lang.String r6 = java.lang.String.format(r6, r12)     // Catch:{ all -> 0x04c1 }
            r1.append(r6)     // Catch:{ all -> 0x04c1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x04c1 }
            java.lang.Object r1 = r2.evaluate(r1)     // Catch:{ all -> 0x04c1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x04c1 }
            r2.close()     // Catch:{ Exception -> 0x04b7 }
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x04b7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04b7 }
            r6.<init>()     // Catch:{ Exception -> 0x04b7 }
            java.lang.String r8 = r7.f37345e     // Catch:{ Exception -> 0x04b7 }
            r6.append(r8)     // Catch:{ Exception -> 0x04b7 }
            java.lang.String r8 = "/home/ajax.php"
            r6.append(r8)     // Catch:{ Exception -> 0x04b7 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x04b7 }
            java.lang.String r8 = "reason=embed&token_d=%s&token=%s"
            r18 = r13
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x04ad }
            r17 = 0
            r13[r17] = r1     // Catch:{ Exception -> 0x04ad }
            r1 = 1
            r13[r1] = r0     // Catch:{ Exception -> 0x04ad }
            java.lang.String r0 = java.lang.String.format(r8, r13)     // Catch:{ Exception -> 0x04ad }
            java.util.Map[] r8 = new java.util.Map[r1]     // Catch:{ Exception -> 0x04ad }
            r8[r17] = r11     // Catch:{ Exception -> 0x04ad }
            java.lang.String r0 = r2.l(r6, r0, r8)     // Catch:{ Exception -> 0x04ad }
            java.lang.String r2 = "<iframe[^>]+src=\"([^\"]+)\"[^>]*>"
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r2, r1)     // Catch:{ Exception -> 0x04ad }
            java.lang.String r1 = "embed/gp.php"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x04ad }
            if (r1 == 0) goto L_0x0491
            boolean r1 = r0.contains(r10)     // Catch:{ Exception -> 0x04ad }
            if (r1 != 0) goto L_0x0418
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ad }
            r1.<init>()     // Catch:{ Exception -> 0x04ad }
            java.lang.String r2 = r7.f37345e     // Catch:{ Exception -> 0x04ad }
            r1.append(r2)     // Catch:{ Exception -> 0x04ad }
            r1.append(r9)     // Catch:{ Exception -> 0x04ad }
            r1.append(r0)     // Catch:{ Exception -> 0x04ad }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x04ad }
        L_0x0418:
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x04ad }
            java.lang.Object r2 = r11.get(r3)     // Catch:{ Exception -> 0x04ad }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04ad }
            java.lang.String r0 = r1.o(r0, r2)     // Catch:{ Exception -> 0x04ad }
            java.lang.String r1 = "['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]"
            r8 = 1
            java.util.ArrayList r0 = com.original.tase.utils.Regex.f(r0, r1, r8, r8)     // Catch:{ Exception -> 0x04ad }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x048d }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x04ad }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x04ad }
        L_0x043a:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x04ad }
            if (r1 == 0) goto L_0x0484
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x04ad }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x04ad }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x04ad }
            r2.<init>()     // Catch:{ Exception -> 0x04ad }
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = com.original.Constants.C     // Catch:{ Exception -> 0x04ad }
            r2.put(r5, r6)     // Catch:{ Exception -> 0x04ad }
            boolean r5 = com.original.tase.helper.GoogleVideoHelper.n(r1)     // Catch:{ Exception -> 0x04ad }
            com.original.tase.model.media.MediaSource r6 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x04ad }
            java.lang.String r13 = r24.A()     // Catch:{ Exception -> 0x04ad }
            if (r5 == 0) goto L_0x0461
            java.lang.String r16 = "GoogleVideo"
            goto L_0x0463
        L_0x0461:
            java.lang.String r16 = "CDN-FastServer"
        L_0x0463:
            r8 = r16
            r12 = 0
            r6.<init>(r13, r8, r12)     // Catch:{ Exception -> 0x04ad }
            r6.setStreamLink(r1)     // Catch:{ Exception -> 0x04ad }
            r6.setPlayHeader(r2)     // Catch:{ Exception -> 0x04ad }
            if (r5 == 0) goto L_0x0476
            java.lang.String r1 = com.original.tase.helper.GoogleVideoHelper.h(r1)     // Catch:{ Exception -> 0x04ad }
            goto L_0x0477
        L_0x0476:
            r1 = r4
        L_0x0477:
            r6.setQuality((java.lang.String) r1)     // Catch:{ Exception -> 0x04ad }
            r8 = r26
            r8.onNext(r6)     // Catch:{ Exception -> 0x0482 }
            r8 = 1
            r12 = 2
            goto L_0x043a
        L_0x0482:
            r0 = move-exception
            goto L_0x04b0
        L_0x0484:
            r8 = r26
            r13 = r3
            r12 = r20
            r20 = r21
            goto L_0x0518
        L_0x048d:
            r0 = move-exception
            r8 = r26
            goto L_0x04a6
        L_0x0491:
            r8 = r26
            r1 = 0
            boolean[] r6 = new boolean[r1]     // Catch:{ Exception -> 0x04a5 }
            r12 = r20
            r1 = r24
            r2 = r26
            r13 = r3
            r3 = r0
            r20 = r21
            r1.x(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x04ec }
            goto L_0x0518
        L_0x04a5:
            r0 = move-exception
        L_0x04a6:
            r13 = r3
            r12 = r20
            r20 = r21
            goto L_0x052a
        L_0x04ad:
            r0 = move-exception
            r8 = r26
        L_0x04b0:
            r13 = r3
            r12 = r20
            r20 = r21
            goto L_0x0529
        L_0x04b7:
            r0 = move-exception
            r8 = r26
            r18 = r13
            r12 = r20
            r20 = r21
            goto L_0x0508
        L_0x04c1:
            r0 = move-exception
            r8 = r26
            r18 = r13
            r12 = r20
            r20 = r21
            goto L_0x04d8
        L_0x04cb:
            r0 = move-exception
            r22 = r8
            r23 = r12
            r18 = r13
            r12 = r20
            r20 = r21
            r8 = r26
        L_0x04d8:
            r13 = r3
            goto L_0x04e8
        L_0x04da:
            r0 = move-exception
            r22 = r8
            r23 = r12
            r18 = r13
            r12 = r20
            r8 = r26
            r13 = r3
            r20 = r6
        L_0x04e8:
            r2.close()     // Catch:{ Exception -> 0x04ec }
            throw r0     // Catch:{ Exception -> 0x04ec }
        L_0x04ec:
            r0 = move-exception
            goto L_0x0529
        L_0x04ee:
            r0 = move-exception
            r20 = r6
            r22 = r8
            r23 = r12
            r18 = r13
            r8 = r26
            r12 = r1
            goto L_0x0508
        L_0x04fb:
            r0 = move-exception
            r20 = r6
            r22 = r8
            r23 = r12
            r18 = r13
            r12 = r19
            r8 = r26
        L_0x0508:
            r13 = r3
            goto L_0x0529
        L_0x050a:
            r20 = r6
            r23 = r12
            r18 = r13
            r12 = r19
            r13 = r22
            r22 = r8
            r8 = r26
        L_0x0518:
            r1 = 0
            goto L_0x052f
        L_0x051a:
            r0 = move-exception
            r20 = r6
            r23 = r12
            r18 = r13
            r12 = r19
            r13 = r22
            r22 = r8
            r8 = r26
        L_0x0529:
            r1 = 0
        L_0x052a:
            boolean[] r2 = new boolean[r1]
            com.original.tase.Logger.d(r0, r2)
        L_0x052f:
            r19 = r12
            r6 = r20
            r8 = r22
            r12 = r23
            r22 = r13
            r13 = r18
            goto L_0x01d6
        L_0x053d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.Hd5movies.K(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }

    public String A() {
        return "Hd5movies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        K(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        K(movieInfo, observableEmitter);
    }

    public String J() {
        String str = this.f37346f;
        if (str == null || str.isEmpty()) {
            HttpHelper i2 = HttpHelper.i();
            this.f37346f = i2.m(Constants.E + "provider/anonembed.txt", new Map[0]);
        }
        return this.f37346f;
    }
}

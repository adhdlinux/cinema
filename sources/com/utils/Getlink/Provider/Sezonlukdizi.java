package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class Sezonlukdizi extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37435e = Utils.getProvider(45);

    public String A() {
        return "Sezonlukdizi";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v38, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0539 A[SYNTHETIC, Splitter:B:197:0x0539] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x05d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(com.movie.data.model.MovieInfo r26, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r27) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            r2 = r27
            java.lang.String r3 = "//"
            java.lang.String r4 = "src"
            java.lang.String r5 = r26.getName()
            java.lang.String r6 = "Marvel's "
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.String r6 = "DC's "
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.String r5 = com.original.tase.helper.TitleHelper.e(r5)
            java.lang.String r6 = "'"
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.String r6 = "Outlander"
            boolean r6 = r5.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0030
            java.lang.String r5 = "outlanderr"
        L_0x0030:
            java.lang.String r6 = "."
            boolean r6 = r5.endsWith(r6)
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x0054
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r9 = r5.length()
            int r9 = r9 - r7
            java.lang.String r5 = r5.substring(r8, r9)
            r6.append(r5)
            java.lang.String r5 = "-"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
        L_0x0054:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = r1.f37435e
            r6.append(r9)
            java.lang.String r9 = "/"
            r6.append(r9)
            java.lang.String r5 = com.original.tase.helper.TitleHelper.g(r5)
            r6.append(r5)
            r6.append(r9)
            java.lang.String r5 = r0.session
            r6.append(r5)
            java.lang.String r5 = "-sezon-"
            r6.append(r5)
            java.lang.String r0 = r0.eps
            r6.append(r0)
            java.lang.String r0 = "-bolum.html"
            r6.append(r0)
            java.lang.String r5 = r6.toString()
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r6 = com.original.Constants.C
            java.lang.String r10 = r1.f37435e
            java.util.Map[] r11 = new java.util.Map[r8]
            java.lang.String r0 = r0.p(r5, r6, r10, r11)
            java.lang.String r6 = "[^\\x00-\\x7F]+"
            java.lang.String r10 = " "
            java.lang.String r0 = r0.replaceAll(r6, r10)
            java.lang.String r6 = "Please complete the security check to access"
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto L_0x00b6
            com.original.tase.RxBus r0 = com.original.tase.RxBus.a()
            com.original.tase.event.ReCaptchaRequiredEvent r2 = new com.original.tase.event.ReCaptchaRequiredEvent
            java.lang.String r3 = r25.A()
            java.lang.String r4 = r1.f37435e
            r2.<init>(r3, r4)
            r0.b(r2)
            return
        L_0x00b6:
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            org.jsoup.select.Elements r6 = new org.jsoup.select.Elements
            r6.<init>()
            java.lang.String r10 = "div#embed"
            org.jsoup.select.Elements r10 = r0.q0(r10)
            java.util.HashMap r11 = com.original.Constants.c()
            java.lang.String r12 = com.original.Constants.C
            java.lang.String r13 = "User-Agent"
            r11.put(r13, r12)
            java.lang.String r12 = "Referer"
            r11.put(r12, r5)
            java.lang.String r14 = "div#playerMenu"
            org.jsoup.select.Elements r15 = r0.q0(r14)
            java.lang.String r8 = "div[data-id][class=item]"
            org.jsoup.select.Elements r8 = r15.g(r8)
            java.util.Iterator r8 = r8.iterator()
            boolean r15 = r8.hasNext()
            java.lang.String r7 = "id="
            r26 = r12
            java.lang.String r12 = "/ajax/dataEmbed.asp"
            r16 = r5
            java.lang.String r5 = "data-id"
            java.lang.String r2 = "iframe[src]"
            if (r15 != 0) goto L_0x019e
            org.jsoup.nodes.Element r0 = r0.r0(r14)
            java.lang.String r8 = "div#dilsec"
            org.jsoup.nodes.Element r0 = r0.r0(r8)
            if (r0 == 0) goto L_0x019b
            java.lang.String r0 = r0.c(r5)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x019b
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r14 = r1.f37435e
            r8.append(r14)
            java.lang.String r14 = "/ajax/dataAlternatif.asp"
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            r14 = 1
            java.lang.Object[] r15 = new java.lang.Object[r14]
            r14 = 0
            r15[r14] = r0
            java.lang.String r0 = "bid=%s&dil=1"
            java.lang.String r0 = java.lang.String.format(r0, r15)
            r17 = r13
            r15 = 1
            java.util.Map[] r13 = new java.util.Map[r15]
            r13[r14] = r11
            java.lang.String r0 = r5.l(r8, r0, r13)
            java.lang.String r5 = "['\"]id['\"]\\s*:(\\d\\w+)"
            java.util.ArrayList r0 = com.original.tase.utils.Regex.f(r0, r5, r15, r15)
            java.lang.Object r0 = r0.get(r14)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x014b:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x01f8
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            com.original.tase.helper.http.HttpHelper r8 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r1.f37435e
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r7)
            r18 = r0
            r15 = 0
            boolean[] r0 = new boolean[r15]
            java.lang.String r0 = com.original.tase.utils.Utils.k(r5, r0)
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            r5 = 1
            java.util.Map[] r14 = new java.util.Map[r5]
            r14[r15] = r11
            java.lang.String r0 = r8.l(r13, r0, r14)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            org.jsoup.select.Elements r0 = r0.q0(r2)
            r10.addAll(r0)
            r0 = r18
            goto L_0x014b
        L_0x019b:
            r17 = r13
            goto L_0x01f8
        L_0x019e:
            r17 = r13
        L_0x01a0:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x01f8
            java.lang.Object r0 = r8.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r0 = r0.c(r5)
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = r1.f37435e
            r14.append(r15)
            r14.append(r12)
            java.lang.String r14 = r14.toString()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r7)
            r18 = r5
            r19 = r7
            r5 = 0
            boolean[] r7 = new boolean[r5]
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r7)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r7 = 1
            java.util.Map[] r15 = new java.util.Map[r7]
            r15[r5] = r11
            java.lang.String r0 = r13.l(r14, r0, r15)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            org.jsoup.select.Elements r0 = r0.q0(r2)
            r10.addAll(r0)
            r5 = r18
            r7 = r19
            goto L_0x01a0
        L_0x01f8:
            java.util.Iterator r0 = r10.iterator()
        L_0x01fc:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0210
            java.lang.Object r5 = r0.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            org.jsoup.select.Elements r5 = r5.q0(r2)
            r6.addAll(r5)
            goto L_0x01fc
        L_0x0210:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0219:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0680
            java.lang.Object r0 = r6.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            boolean r7 = r27.isDisposed()
            if (r7 == 0) goto L_0x022c
            return
        L_0x022c:
            java.lang.String r0 = r0.c(r4)     // Catch:{ Exception -> 0x0653 }
            boolean r7 = r5.contains(r0)     // Catch:{ Exception -> 0x0653 }
            if (r7 != 0) goto L_0x063f
            r5.add(r0)     // Catch:{ Exception -> 0x0653 }
            boolean r7 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0653 }
            java.lang.String r8 = "http:"
            java.lang.String r10 = "https:"
            if (r7 == 0) goto L_0x0269
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0253 }
            r7.<init>()     // Catch:{ Exception -> 0x0253 }
            r7.append(r10)     // Catch:{ Exception -> 0x0253 }
            r7.append(r0)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0253 }
            goto L_0x029c
        L_0x0253:
            r0 = move-exception
            r21 = r2
            r22 = r4
            r20 = r5
            r23 = r16
            r15 = r17
            r1 = 0
            r2 = r27
            r16 = r3
            r17 = r6
            r6 = r26
            goto L_0x0667
        L_0x0269:
            boolean r7 = r0.startsWith(r9)     // Catch:{ Exception -> 0x0653 }
            if (r7 == 0) goto L_0x0281
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0253 }
            r7.<init>()     // Catch:{ Exception -> 0x0253 }
            java.lang.String r11 = r1.f37435e     // Catch:{ Exception -> 0x0253 }
            r7.append(r11)     // Catch:{ Exception -> 0x0253 }
            r7.append(r0)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0253 }
            goto L_0x029c
        L_0x0281:
            boolean r7 = r0.startsWith(r8)     // Catch:{ Exception -> 0x0653 }
            if (r7 != 0) goto L_0x029c
            boolean r7 = r0.startsWith(r10)     // Catch:{ Exception -> 0x0253 }
            if (r7 != 0) goto L_0x029c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0253 }
            r7.<init>()     // Catch:{ Exception -> 0x0253 }
            r7.append(r10)     // Catch:{ Exception -> 0x0253 }
            r7.append(r0)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0253 }
        L_0x029c:
            r7 = r0
            boolean r0 = com.original.tase.helper.GoogleVideoHelper.l(r7)     // Catch:{ Exception -> 0x0653 }
            java.lang.String r11 = "Cookie"
            java.lang.String r12 = "GoogleVideo"
            java.lang.String r13 = "HD"
            if (r0 == 0) goto L_0x035e
            java.util.HashMap r0 = com.original.tase.helper.GoogleVideoHelper.g(r7)     // Catch:{ Exception -> 0x0347 }
            if (r0 == 0) goto L_0x033f
            boolean r14 = r0.isEmpty()     // Catch:{ Exception -> 0x0347 }
            if (r14 != 0) goto L_0x033f
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0347 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0347 }
        L_0x02bd:
            boolean r14 = r0.hasNext()     // Catch:{ Exception -> 0x0347 }
            if (r14 == 0) goto L_0x033f
            java.lang.Object r14 = r0.next()     // Catch:{ Exception -> 0x0347 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ Exception -> 0x0347 }
            java.lang.Object r15 = r14.getKey()     // Catch:{ Exception -> 0x0347 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0347 }
            r18 = r0
            com.original.tase.model.media.MediaSource r0 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0347 }
            r19 = r2
            java.lang.String r2 = r25.A()     // Catch:{ Exception -> 0x032f }
            r20 = r5
            r5 = 0
            r0.<init>(r2, r12, r5)     // Catch:{ Exception -> 0x032b }
            r0.setOriginalLink(r7)     // Catch:{ Exception -> 0x032b }
            r0.setStreamLink(r15)     // Catch:{ Exception -> 0x032b }
            java.lang.Object r2 = r14.getValue()     // Catch:{ Exception -> 0x032b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x032b }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x032b }
            if (r2 == 0) goto L_0x02f3
            r2 = r13
            goto L_0x02f9
        L_0x02f3:
            java.lang.Object r2 = r14.getValue()     // Catch:{ Exception -> 0x032b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x032b }
        L_0x02f9:
            r0.setQuality((java.lang.String) r2)     // Catch:{ Exception -> 0x032b }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x032b }
            r2.<init>()     // Catch:{ Exception -> 0x032b }
            java.lang.String r5 = com.original.Constants.C     // Catch:{ Exception -> 0x032b }
            r15 = r17
            r2.put(r15, r5)     // Catch:{ Exception -> 0x0327 }
            java.lang.Object r5 = r14.getKey()     // Catch:{ Exception -> 0x0327 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0327 }
            java.lang.String r5 = com.original.tase.helper.GoogleVideoHelper.m(r7, r5)     // Catch:{ Exception -> 0x0327 }
            r2.put(r11, r5)     // Catch:{ Exception -> 0x0327 }
            r0.setPlayHeader(r2)     // Catch:{ Exception -> 0x0327 }
            r2 = r27
            r5 = r19
            r2.onNext(r0)     // Catch:{ Exception -> 0x037d }
            r2 = r5
            r17 = r15
            r0 = r18
            r5 = r20
            goto L_0x02bd
        L_0x0327:
            r0 = move-exception
            r2 = r27
            goto L_0x0336
        L_0x032b:
            r0 = move-exception
            r2 = r27
            goto L_0x0334
        L_0x032f:
            r0 = move-exception
            r2 = r27
            r20 = r5
        L_0x0334:
            r15 = r17
        L_0x0336:
            r22 = r4
            r17 = r6
            r23 = r16
            r21 = r19
            goto L_0x0357
        L_0x033f:
            r20 = r5
            r15 = r17
            r5 = r2
            r2 = r27
            goto L_0x037f
        L_0x0347:
            r0 = move-exception
            r20 = r5
            r15 = r17
            r5 = r2
            r2 = r27
        L_0x034f:
            r22 = r4
            r21 = r5
            r17 = r6
            r23 = r16
        L_0x0357:
            r1 = 0
            r6 = r26
            r16 = r3
            goto L_0x0667
        L_0x035e:
            r20 = r5
            r15 = r17
            r5 = r2
            r2 = r27
            java.lang.String r0 = ".asp"
            boolean r0 = r7.contains(r0)     // Catch:{ Exception -> 0x0631 }
            if (r0 != 0) goto L_0x037f
            r8 = 1
            boolean[] r0 = new boolean[r8]     // Catch:{ Exception -> 0x037d }
            r8 = 0
            r0[r8] = r8     // Catch:{ Exception -> 0x037d }
            r1.z(r2, r7, r13, r0)     // Catch:{ Exception -> 0x037d }
            r2 = r5
            r17 = r15
            r5 = r20
            goto L_0x0219
        L_0x037d:
            r0 = move-exception
            goto L_0x034f
        L_0x037f:
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x0631 }
            java.lang.String r14 = com.original.Constants.C     // Catch:{ Exception -> 0x0631 }
            r17 = r6
            r18 = r10
            r6 = 0
            java.util.Map[] r10 = new java.util.Map[r6]     // Catch:{ Exception -> 0x0627 }
            r6 = r16
            java.lang.String r0 = r0.p(r7, r14, r6, r10)     // Catch:{ Exception -> 0x061d }
            org.jsoup.nodes.Document r10 = org.jsoup.Jsoup.b(r0)     // Catch:{ Exception -> 0x061d }
            org.jsoup.select.Elements r10 = r10.q0(r5)     // Catch:{ Exception -> 0x061d }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x061d }
        L_0x039e:
            boolean r14 = r10.hasNext()     // Catch:{ Exception -> 0x061d }
            if (r14 == 0) goto L_0x0465
            java.lang.Object r14 = r10.next()     // Catch:{ Exception -> 0x045c }
            org.jsoup.nodes.Element r14 = (org.jsoup.nodes.Element) r14     // Catch:{ Exception -> 0x045c }
            java.lang.String r14 = r14.c(r4)     // Catch:{ Exception -> 0x045c }
            boolean r16 = com.original.tase.helper.GoogleVideoHelper.b(r14)     // Catch:{ Exception -> 0x045c }
            if (r16 == 0) goto L_0x0441
            boolean r16 = com.original.tase.helper.GoogleVideoHelper.l(r14)     // Catch:{ Exception -> 0x045c }
            if (r16 == 0) goto L_0x0441
            java.util.HashMap r16 = com.original.tase.helper.GoogleVideoHelper.g(r14)     // Catch:{ Exception -> 0x045c }
            if (r16 == 0) goto L_0x0438
            boolean r19 = r16.isEmpty()     // Catch:{ Exception -> 0x045c }
            if (r19 != 0) goto L_0x0438
            java.util.Set r16 = r16.entrySet()     // Catch:{ Exception -> 0x045c }
            java.util.Iterator r16 = r16.iterator()     // Catch:{ Exception -> 0x045c }
        L_0x03ce:
            boolean r19 = r16.hasNext()     // Catch:{ Exception -> 0x045c }
            if (r19 == 0) goto L_0x0438
            java.lang.Object r19 = r16.next()     // Catch:{ Exception -> 0x045c }
            java.util.Map$Entry r19 = (java.util.Map.Entry) r19     // Catch:{ Exception -> 0x045c }
            java.lang.Object r21 = r19.getKey()     // Catch:{ Exception -> 0x045c }
            r22 = r4
            r4 = r21
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0436 }
            r21 = r5
            com.original.tase.model.media.MediaSource r5 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0434 }
            r23 = r6
            java.lang.String r6 = r25.A()     // Catch:{ Exception -> 0x061b }
            r24 = r10
            r10 = 0
            r5.<init>(r6, r12, r10)     // Catch:{ Exception -> 0x061b }
            r5.setStreamLink(r4)     // Catch:{ Exception -> 0x061b }
            java.lang.Object r4 = r19.getValue()     // Catch:{ Exception -> 0x061b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x061b }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x061b }
            if (r4 == 0) goto L_0x0405
            r4 = r13
            goto L_0x040b
        L_0x0405:
            java.lang.Object r4 = r19.getValue()     // Catch:{ Exception -> 0x061b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x061b }
        L_0x040b:
            r5.setQuality((java.lang.String) r4)     // Catch:{ Exception -> 0x061b }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x061b }
            r4.<init>()     // Catch:{ Exception -> 0x061b }
            java.lang.String r6 = com.original.Constants.C     // Catch:{ Exception -> 0x061b }
            r4.put(r15, r6)     // Catch:{ Exception -> 0x061b }
            java.lang.Object r6 = r19.getKey()     // Catch:{ Exception -> 0x061b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x061b }
            java.lang.String r6 = com.original.tase.helper.GoogleVideoHelper.m(r14, r6)     // Catch:{ Exception -> 0x061b }
            r4.put(r11, r6)     // Catch:{ Exception -> 0x061b }
            r5.setPlayHeader(r4)     // Catch:{ Exception -> 0x061b }
            r2.onNext(r5)     // Catch:{ Exception -> 0x061b }
            r5 = r21
            r4 = r22
            r6 = r23
            r10 = r24
            goto L_0x03ce
        L_0x0434:
            r0 = move-exception
            goto L_0x0461
        L_0x0436:
            r0 = move-exception
            goto L_0x045f
        L_0x0438:
            r22 = r4
            r21 = r5
            r23 = r6
            r24 = r10
            goto L_0x0452
        L_0x0441:
            r22 = r4
            r21 = r5
            r23 = r6
            r24 = r10
            r4 = 1
            boolean[] r5 = new boolean[r4]     // Catch:{ Exception -> 0x061b }
            r4 = 0
            r5[r4] = r4     // Catch:{ Exception -> 0x061b }
            r1.z(r2, r14, r13, r5)     // Catch:{ Exception -> 0x061b }
        L_0x0452:
            r5 = r21
            r4 = r22
            r6 = r23
            r10 = r24
            goto L_0x039e
        L_0x045c:
            r0 = move-exception
            r22 = r4
        L_0x045f:
            r21 = r5
        L_0x0461:
            r23 = r6
            goto L_0x063a
        L_0x0465:
            r22 = r4
            r21 = r5
            r23 = r6
            java.lang.String r4 = "['\"]?kind['\"]?\\s*:\\s*['\"]?(captions|subtitles)['\"]?"
            r5 = 1
            java.lang.String r4 = com.original.tase.utils.Regex.c(r0, r4, r5, r5)     // Catch:{ Exception -> 0x061b }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x061b }
            if (r4 != 0) goto L_0x0616
            java.lang.String r4 = "['\"]?\\s*file\\s*['\"]?\\s*[:=,]?\\s*['\"]([^'\"]+)"
            java.util.ArrayList r0 = com.original.tase.utils.Regex.d(r0, r4, r5)     // Catch:{ Exception -> 0x061b }
            r4 = 0
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x061b }
            r4 = r0
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ Exception -> 0x061b }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x061b }
            r5.<init>()     // Catch:{ Exception -> 0x061b }
            java.lang.String r0 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"
            r5.put(r15, r0)     // Catch:{ Exception -> 0x061b }
            r6 = r26
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0614 }
            r14 = 0
        L_0x0496:
            int r0 = r4.size()     // Catch:{ Exception -> 0x0614 }
            if (r14 >= r0) goto L_0x0618
            java.lang.Object r0 = r4.get(r14)     // Catch:{ Exception -> 0x05ed }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x05ed }
            java.lang.String r10 = "\\/"
            java.lang.String r0 = r0.replace(r10, r9)     // Catch:{ Exception -> 0x05ed }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x05ed }
            boolean r10 = r0.isEmpty()     // Catch:{ Exception -> 0x05ed }
            if (r10 != 0) goto L_0x05e2
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x05ed }
            java.lang.String r11 = ".vtt"
            boolean r10 = r10.endsWith(r11)     // Catch:{ Exception -> 0x05ed }
            if (r10 != 0) goto L_0x05e2
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x05ed }
            java.lang.String r11 = ".srt"
            boolean r10 = r10.endsWith(r11)     // Catch:{ Exception -> 0x05ed }
            if (r10 != 0) goto L_0x05e2
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x05ed }
            java.lang.String r11 = ".png"
            boolean r10 = r10.endsWith(r11)     // Catch:{ Exception -> 0x05ed }
            if (r10 != 0) goto L_0x05e2
            boolean r10 = r0.startsWith(r3)     // Catch:{ Exception -> 0x05ed }
            if (r10 == 0) goto L_0x04fc
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ee }
            r10.<init>()     // Catch:{ Exception -> 0x04ee }
            r10.append(r8)     // Catch:{ Exception -> 0x04ee }
            r10.append(r0)     // Catch:{ Exception -> 0x04ee }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x04ee }
        L_0x04eb:
            r10 = r18
            goto L_0x0531
        L_0x04ee:
            r0 = move-exception
            r16 = r3
            r26 = r4
            r19 = r5
            r10 = r18
            r1 = 0
            r18 = r8
            goto L_0x05f9
        L_0x04fc:
            boolean r10 = r0.startsWith(r9)     // Catch:{ Exception -> 0x05ed }
            if (r10 == 0) goto L_0x0514
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ee }
            r10.<init>()     // Catch:{ Exception -> 0x04ee }
            java.lang.String r11 = "https://sezonlukdizi.org"
            r10.append(r11)     // Catch:{ Exception -> 0x04ee }
            r10.append(r0)     // Catch:{ Exception -> 0x04ee }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x04ee }
            goto L_0x04eb
        L_0x0514:
            boolean r10 = r0.startsWith(r8)     // Catch:{ Exception -> 0x05ed }
            if (r10 != 0) goto L_0x04eb
            r10 = r18
            boolean r11 = r0.startsWith(r10)     // Catch:{ Exception -> 0x05da }
            if (r11 != 0) goto L_0x0531
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05da }
            r11.<init>()     // Catch:{ Exception -> 0x05da }
            r11.append(r8)     // Catch:{ Exception -> 0x05da }
            r11.append(r0)     // Catch:{ Exception -> 0x05da }
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x05da }
        L_0x0531:
            int r11 = r0.length()     // Catch:{ Exception -> 0x05da }
            r1 = 10
            if (r11 < r1) goto L_0x05d3
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x05bf }
            r16 = r3
            r11 = 1
            java.util.Map[] r3 = new java.util.Map[r11]     // Catch:{ Exception -> 0x05bd }
            r11 = 0
            r3[r11] = r5     // Catch:{ Exception -> 0x05bd }
            java.lang.String r0 = r1.t(r0, r11, r3)     // Catch:{ Exception -> 0x05bd }
            boolean r1 = com.original.tase.helper.GoogleVideoHelper.n(r0)     // Catch:{ Exception -> 0x05bd }
            r3 = 1
        L_0x054e:
            r11 = 2
            if (r3 > r11) goto L_0x05d5
            com.original.tase.model.media.MediaSource r11 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x05bd }
            r26 = r4
            java.lang.String r4 = r25.A()     // Catch:{ Exception -> 0x05bb }
            if (r1 == 0) goto L_0x0561
            r19 = r5
            r18 = r8
            r5 = r12
            goto L_0x0569
        L_0x0561:
            java.lang.String r18 = "CDN"
            r19 = r5
            r5 = r18
            r18 = r8
        L_0x0569:
            r8 = 0
            r11.<init>(r4, r5, r8)     // Catch:{ Exception -> 0x05b9 }
            if (r1 == 0) goto L_0x0576
            java.lang.String r4 = com.original.tase.helper.GoogleVideoHelper.h(r0)     // Catch:{ Exception -> 0x05b9 }
            r24 = r1
            goto L_0x05a5
        L_0x0576:
            java.lang.String r4 = "(?:\\.|-)(\\d{3,4})p?\\."
            r5 = 1
            java.lang.String r4 = com.original.tase.utils.Regex.a(r0, r4, r5)     // Catch:{ Exception -> 0x05b9 }
            boolean r8 = r4.isEmpty()     // Catch:{ Exception -> 0x05b9 }
            if (r8 != 0) goto L_0x0584
            goto L_0x0585
        L_0x0584:
            r4 = r13
        L_0x0585:
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x05b9 }
            r8.<init>()     // Catch:{ Exception -> 0x05b9 }
            java.lang.String r5 = com.original.Constants.C     // Catch:{ Exception -> 0x05b9 }
            r8.put(r15, r5)     // Catch:{ Exception -> 0x05b9 }
            int r5 = r3 % 2
            if (r5 != 0) goto L_0x05a0
            r8.put(r6, r7)     // Catch:{ Exception -> 0x05b9 }
            java.lang.String r5 = "Accept-Encoding"
            r24 = r1
            java.lang.String r1 = "identity;q=1, *;q=0"
            r8.put(r5, r1)     // Catch:{ Exception -> 0x05b9 }
            goto L_0x05a2
        L_0x05a0:
            r24 = r1
        L_0x05a2:
            r11.setPlayHeader(r8)     // Catch:{ Exception -> 0x05b9 }
        L_0x05a5:
            r11.setStreamLink(r0)     // Catch:{ Exception -> 0x05b9 }
            r11.setQuality((java.lang.String) r4)     // Catch:{ Exception -> 0x05b9 }
            r2.onNext(r11)     // Catch:{ Exception -> 0x05b9 }
            int r3 = r3 + 1
            r4 = r26
            r8 = r18
            r5 = r19
            r1 = r24
            goto L_0x054e
        L_0x05b9:
            r0 = move-exception
            goto L_0x05c8
        L_0x05bb:
            r0 = move-exception
            goto L_0x05c4
        L_0x05bd:
            r0 = move-exception
            goto L_0x05c2
        L_0x05bf:
            r0 = move-exception
            r16 = r3
        L_0x05c2:
            r26 = r4
        L_0x05c4:
            r19 = r5
            r18 = r8
        L_0x05c8:
            r1 = 0
            boolean[] r3 = new boolean[r1]     // Catch:{ Exception -> 0x05d1 }
            com.original.tase.Logger.d(r0, r3)     // Catch:{ Exception -> 0x05cf }
            goto L_0x05fe
        L_0x05cf:
            r0 = move-exception
            goto L_0x05f8
        L_0x05d1:
            r0 = move-exception
            goto L_0x05f9
        L_0x05d3:
            r16 = r3
        L_0x05d5:
            r26 = r4
            r19 = r5
            goto L_0x05ea
        L_0x05da:
            r0 = move-exception
            r16 = r3
            r26 = r4
            r19 = r5
            goto L_0x05f6
        L_0x05e2:
            r16 = r3
            r26 = r4
            r19 = r5
            r10 = r18
        L_0x05ea:
            r18 = r8
            goto L_0x05fe
        L_0x05ed:
            r0 = move-exception
            r16 = r3
            r26 = r4
            r19 = r5
            r10 = r18
        L_0x05f6:
            r18 = r8
        L_0x05f8:
            r1 = 0
        L_0x05f9:
            boolean[] r3 = new boolean[r1]     // Catch:{ Exception -> 0x0611 }
            com.original.tase.Logger.d(r0, r3)     // Catch:{ Exception -> 0x060e }
        L_0x05fe:
            int r14 = r14 + 1
            r1 = r25
            r4 = r26
            r3 = r16
            r8 = r18
            r5 = r19
            r18 = r10
            goto L_0x0496
        L_0x060e:
            r0 = move-exception
            goto L_0x0666
        L_0x0611:
            r0 = move-exception
            goto L_0x0667
        L_0x0614:
            r0 = move-exception
            goto L_0x063c
        L_0x0616:
            r6 = r26
        L_0x0618:
            r16 = r3
            goto L_0x0651
        L_0x061b:
            r0 = move-exception
            goto L_0x063a
        L_0x061d:
            r0 = move-exception
            r16 = r3
            r22 = r4
            r21 = r5
            r23 = r6
            goto L_0x0664
        L_0x0627:
            r0 = move-exception
            r6 = r26
            r22 = r4
            r21 = r5
            r23 = r16
            goto L_0x063c
        L_0x0631:
            r0 = move-exception
            r22 = r4
            r21 = r5
            r17 = r6
            r23 = r16
        L_0x063a:
            r6 = r26
        L_0x063c:
            r16 = r3
            goto L_0x0666
        L_0x063f:
            r21 = r2
            r22 = r4
            r20 = r5
            r23 = r16
            r15 = r17
            r2 = r27
            r16 = r3
            r17 = r6
            r6 = r26
        L_0x0651:
            r1 = 0
            goto L_0x066c
        L_0x0653:
            r0 = move-exception
            r21 = r2
            r22 = r4
            r20 = r5
            r23 = r16
            r15 = r17
            r2 = r27
            r16 = r3
            r17 = r6
        L_0x0664:
            r6 = r26
        L_0x0666:
            r1 = 0
        L_0x0667:
            boolean[] r3 = new boolean[r1]
            com.original.tase.Logger.d(r0, r3)
        L_0x066c:
            r1 = r25
            r26 = r6
            r3 = r16
            r6 = r17
            r5 = r20
            r2 = r21
            r4 = r22
            r16 = r23
            r17 = r15
            goto L_0x0219
        L_0x0680:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.Sezonlukdizi.D(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }
}

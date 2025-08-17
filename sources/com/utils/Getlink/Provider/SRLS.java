package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class SRLS extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37430e = Utils.getProvider(22);

    private boolean J(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("sample") || lowerCase.contains("uploadkadeh") || lowerCase.contains("wordpress") || lowerCase.contains("crazy4tv") || lowerCase.contains("imdb.com") || lowerCase.contains("youtube") || lowerCase.contains("userboard") || lowerCase.contains("kumpulbagi") || lowerCase.contains("mexashare") || lowerCase.contains("myvideolink.xyz") || lowerCase.contains("myvideolinks.xyz") || lowerCase.contains("costaction") || lowerCase.contains("crazydl") || lowerCase.contains(".rar") || lowerCase.contains(".avi") || lowerCase.contains(".flv") || lowerCase.contains("ul.to") || lowerCase.contains("safelinking") || lowerCase.contains("linx.") || lowerCase.contains("upload.so") || lowerCase.contains(".zip") || lowerCase.contains("go4up") || lowerCase.contains("adf.ly") || lowerCase.contains(".jpg") || lowerCase.contains(".jpeg") || lowerCase.contains(".png") || lowerCase.contains(".txt") || lowerCase.contains("file-upload.") || lowerCase.contains(".subs") || lowerCase.contains(".7z") || lowerCase.contains(".iso")) {
            return false;
        }
        return true;
    }

    public String A() {
        return "SRLS";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            K(movieInfo, observableEmitter);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            K(movieInfo, observableEmitter);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0164, code lost:
        if (com.original.tase.helper.TitleHelper.f(r3.replaceAll("(?i)(.*)([2-9]0\\d{2}|1[5-9]\\d{2})\\s+(S\\d+\\s*E\\d+)(.*)", "$1$3$4")).startsWith(com.original.tase.helper.TitleHelper.f(r12 + r13.toLowerCase())) != false) goto L_0x0166;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x019f A[Catch:{ all -> 0x0230 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K(com.movie.data.model.MovieInfo r23, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r24) {
        /*
            r22 = this;
            r6 = r22
            r7 = r23
            java.lang.String r8 = "a"
            java.lang.Integer r0 = r23.getType()
            int r0 = r0.intValue()
            r9 = 0
            r10 = 1
            if (r0 != r10) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            com.original.tase.helper.DirectoryIndexHelper r0 = new com.original.tase.helper.DirectoryIndexHelper
            r0.<init>()
            java.lang.String r12 = r23.getName()
            if (r11 == 0) goto L_0x0029
            java.lang.Integer r0 = r23.getYear()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0056
        L_0x0029:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "S"
            r0.append(r1)
            java.lang.String r1 = r7.session
            int r1 = java.lang.Integer.parseInt(r1)
            java.lang.String r1 = com.original.tase.utils.Utils.i(r1)
            r0.append(r1)
            java.lang.String r1 = "E"
            r0.append(r1)
            java.lang.String r1 = r7.eps
            int r1 = java.lang.Integer.parseInt(r1)
            java.lang.String r1 = com.original.tase.utils.Utils.i(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0056:
            r13 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ": "
            java.lang.String r2 = " "
            java.lang.String r1 = r12.replace(r1, r2)
            r0.append(r1)
            r0.append(r2)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            boolean[] r1 = new boolean[r9]
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "Accept"
            java.lang.String r3 = "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
            r1.put(r2, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.f37430e
            r2.append(r3)
            java.lang.String r3 = "/"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Referer"
            r1.put(r3, r2)
            java.lang.String r2 = r6.f37430e
            java.lang.String r3 = "http://"
            java.lang.String r14 = ""
            java.lang.String r2 = r2.replace(r3, r14)
            java.lang.String r3 = "https://"
            java.lang.String r2 = r2.replace(r3, r14)
            java.lang.String r3 = "Host"
            r1.put(r3, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.f37430e
            r2.append(r3)
            java.lang.String r3 = "/?s=%s&submit=Find"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r10]
            r3[r9] = r0
            java.lang.String r0 = java.lang.String.format(r2, r3)
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r3 = new java.util.Map[r10]
            r3[r9] = r1
            java.lang.String r1 = r2.m(r0, r3)
            java.lang.String r2 = "Attention Required! | Cloudflare"
            boolean r2 = r1.contains(r2)
            if (r2 == 0) goto L_0x00ec
            java.lang.String r1 = "Need Verify Recaptcha"
            com.original.tase.Logger.b(r1, r0)
            java.lang.String r1 = com.utils.Getlink.Provider.BaseProvider.i(r0)
            com.utils.Utils.e(r0, r1)
            return
        L_0x00ec:
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r1)
            java.lang.String r1 = "div#contentArea"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.lang.String r1 = "div.post"
            org.jsoup.select.Elements r0 = r0.g(r1)
            java.util.Iterator r15 = r0.iterator()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.original.tase.helper.DirectoryIndexHelper r4 = new com.original.tase.helper.DirectoryIndexHelper
            r4.<init>()
        L_0x010a:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x023f
            java.lang.Object r0 = r15.next()     // Catch:{ all -> 0x0230 }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ all -> 0x0230 }
            java.lang.String r1 = "div.postHeader"
            org.jsoup.nodes.Element r1 = r0.r0(r1)     // Catch:{ all -> 0x0230 }
            org.jsoup.nodes.Element r1 = r1.r0(r8)     // Catch:{ all -> 0x0230 }
            java.lang.String r2 = r1.v0()     // Catch:{ all -> 0x0230 }
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0230 }
            if (r3 == 0) goto L_0x013a
            java.lang.String r2 = "title"
            java.lang.String r2 = r1.c(r2)     // Catch:{ all -> 0x0131 }
            goto L_0x013a
        L_0x0131:
        L_0x0132:
            r21 = r4
            r17 = r5
            r19 = 0
            goto L_0x0237
        L_0x013a:
            r3 = r2
            if (r11 == 0) goto L_0x0168
            java.lang.String r1 = "(?i)(.*)([2-9]0\\d{2}|1[5-9]\\d{2})\\s+(S\\d+\\s*E\\d+)(.*)"
            java.lang.String r2 = "$1$3$4"
            java.lang.String r1 = r3.replaceAll(r1, r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = com.original.tase.helper.TitleHelper.f(r1)     // Catch:{ all -> 0x0131 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r2.<init>()     // Catch:{ all -> 0x0131 }
            r2.append(r12)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = r13.toLowerCase()     // Catch:{ all -> 0x0131 }
            r2.append(r10)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r2)     // Catch:{ all -> 0x0131 }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x019c
        L_0x0166:
            r1 = 1
            goto L_0x019d
        L_0x0168:
            java.lang.String r1 = r3.toLowerCase()     // Catch:{ all -> 0x0230 }
            java.lang.String r2 = r7.year     // Catch:{ all -> 0x0230 }
            java.lang.String r1 = r1.replace(r2, r14)     // Catch:{ all -> 0x0230 }
            java.lang.String r1 = com.original.tase.helper.TitleHelper.h(r1, r14)     // Catch:{ all -> 0x0230 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
            r2.<init>()     // Catch:{ all -> 0x0230 }
            java.lang.String r10 = r23.getName()     // Catch:{ all -> 0x0230 }
            java.lang.String r10 = r10.toLowerCase()     // Catch:{ all -> 0x0230 }
            r2.append(r10)     // Catch:{ all -> 0x0230 }
            java.lang.String r10 = r13.toLowerCase()     // Catch:{ all -> 0x0230 }
            r2.append(r10)     // Catch:{ all -> 0x0230 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0230 }
            java.lang.String r2 = com.original.tase.helper.TitleHelper.h(r2, r14)     // Catch:{ all -> 0x0230 }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x0230 }
            if (r1 == 0) goto L_0x019c
            goto L_0x0166
        L_0x019c:
            r1 = 0
        L_0x019d:
            if (r1 == 0) goto L_0x0132
            java.lang.String r1 = "div.postContent"
            org.jsoup.nodes.Element r0 = r0.r0(r1)     // Catch:{ all -> 0x0230 }
            org.jsoup.select.Elements r0 = r0.q0(r8)     // Catch:{ all -> 0x0230 }
            java.util.Iterator r10 = r0.iterator()     // Catch:{ all -> 0x0230 }
            java.lang.String r2 = "HQ"
            r0 = r2
        L_0x01b0:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x0230 }
            if (r1 == 0) goto L_0x0132
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x0230 }
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1     // Catch:{ all -> 0x0230 }
            java.lang.String r9 = "href"
            java.lang.String r9 = r1.c(r9)     // Catch:{ all -> 0x0230 }
            boolean r1 = r9.isEmpty()     // Catch:{ all -> 0x0230 }
            if (r1 != 0) goto L_0x021e
            boolean r1 = r6.J(r9)     // Catch:{ all -> 0x0230 }
            if (r1 == 0) goto L_0x021e
            boolean r1 = r5.contains(r9)     // Catch:{ all -> 0x0230 }
            if (r1 != 0) goto L_0x021e
            r5.add(r9)     // Catch:{ all -> 0x0230 }
            java.lang.String r1 = r22.A()     // Catch:{ all -> 0x0230 }
            if (r11 == 0) goto L_0x01e2
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r17 = r4.c(r3)     // Catch:{ all -> 0x0131 }
            goto L_0x01e6
        L_0x01e2:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r17 = r4.d(r9)     // Catch:{ all -> 0x0230 }
        L_0x01e6:
            if (r17 == 0) goto L_0x01fb
            java.lang.String r1 = r17.c()     // Catch:{ all -> 0x0131 }
            boolean r18 = r1.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0131 }
            if (r18 != 0) goto L_0x01f3
            r0 = r1
        L_0x01f3:
            java.lang.String r1 = r17.b()     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = r6.t(r1)     // Catch:{ all -> 0x0131 }
        L_0x01fb:
            r16 = r0
            r17 = r1
            r1 = 0
            boolean[] r0 = new boolean[r1]     // Catch:{ all -> 0x0230 }
            r18 = r0
            r0 = r22
            r19 = 0
            r1 = r24
            r20 = r2
            r2 = r9
            r9 = r3
            r3 = r16
            r21 = r4
            r4 = r17
            r17 = r5
            r5 = r18
            r0.x(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0236 }
            r0 = r16
            goto L_0x0227
        L_0x021e:
            r20 = r2
            r9 = r3
            r21 = r4
            r17 = r5
            r19 = 0
        L_0x0227:
            r3 = r9
            r5 = r17
            r2 = r20
            r4 = r21
            r9 = 0
            goto L_0x01b0
        L_0x0230:
            r21 = r4
            r17 = r5
            r19 = 0
        L_0x0236:
        L_0x0237:
            r5 = r17
            r4 = r21
            r9 = 0
            r10 = 1
            goto L_0x010a
        L_0x023f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.SRLS.K(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }
}

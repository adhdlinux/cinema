package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class OneEMovie extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37396e = "https://hdmovie2.codes";

    public String A() {
        return "OneLMovie";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v1 ?, r4v2 ?, r4v3 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r18, java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            r4 = 0
            java.util.Map[] r5 = new java.util.Map[r4]
            java.lang.String r3 = r3.m(r2, r5)
            java.lang.String r5 = "[\"']?player_api[\"']?\\s*:\\s*[\"']([^\"']+)"
            r6 = 1
            java.lang.String r5 = com.original.tase.utils.Regex.a(r3, r5, r6)
            java.lang.String r7 = "\\/"
            java.lang.String r8 = "/"
            java.lang.String r5 = r5.replace(r7, r8)
            boolean r9 = r5.isEmpty()
            if (r9 == 0) goto L_0x0027
            return
        L_0x0027:
            boolean r9 = r5.startsWith(r8)
            if (r9 == 0) goto L_0x003e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r0.f37396e
            r9.append(r10)
            r9.append(r5)
            java.lang.String r5 = r9.toString()
        L_0x003e:
            boolean r9 = r5.endsWith(r8)
            if (r9 != 0) goto L_0x0053
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
        L_0x0053:
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r9 = "div#playeroptions"
            org.jsoup.select.Elements r3 = r3.q0(r9)
            java.lang.String r9 = "li[id][class]"
            org.jsoup.select.Elements r3 = r3.g(r9)
            java.util.Iterator r3 = r3.iterator()
            java.util.HashMap r9 = com.original.Constants.c()
            java.lang.String r10 = "Referer"
            r9.put(r10, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
        L_0x0075:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x017b
            java.lang.Object r10 = r3.next()
            org.jsoup.nodes.Element r10 = (org.jsoup.nodes.Element) r10
            java.lang.String r11 = "data-post"
            java.lang.String r11 = r10.c(r11)
            java.lang.String r12 = "data-nume"
            java.lang.String r12 = r10.c(r12)
            java.lang.String r13 = "data-type"
            java.lang.String r10 = r10.c(r13)
            java.lang.String r13 = "trailer"
            boolean r13 = r12.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x009c
            goto L_0x0075
        L_0x009c:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r5)
            java.lang.String r14 = "%s/%s/%s"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r14 = 3
            java.lang.Object[] r14 = new java.lang.Object[r14]
            r14[r4] = r11
            r14[r6] = r10
            r10 = 2
            r14[r10] = r12
            java.lang.String r11 = java.lang.String.format(r13, r14)
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r13 = new java.util.Map[r6]
            r13[r4] = r9
            java.lang.String r11 = r12.m(r11, r13)
            java.lang.String r12 = "\\\""
            java.lang.String r13 = "\""
            java.lang.String r11 = r11.replace(r12, r13)
            java.lang.String r11 = r11.replace(r7, r8)
            java.lang.String r12 = "<iframe[^>]+src=['\"]([^'\"]+)['\"][^>]*>"
            java.lang.String r11 = com.original.tase.utils.Regex.a(r11, r12, r6)
            java.lang.String r12 = "//"
            boolean r13 = r11.startsWith(r12)
            java.lang.String r14 = "https:"
            if (r13 == 0) goto L_0x00f2
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
        L_0x00f2:
            boolean r13 = r11.isEmpty()
            if (r13 != 0) goto L_0x0177
            java.lang.String r13 = "referer"
            r2.put(r13, r11)
            boolean[] r13 = new boolean[r6]
            r13[r4] = r4
            java.lang.String r15 = "HD"
            r0.z(r1, r11, r15, r13)
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r4 = r0.f37396e
            java.lang.String r4 = r13.o(r11, r4)
            java.lang.String r13 = "sniff\\(['\"]\\w+['\"]\\s*,\\s*['\"](\\d+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]"
            java.lang.String r16 = com.original.tase.utils.Regex.a(r4, r13, r10)
            java.lang.String r4 = com.original.tase.utils.Regex.a(r4, r13, r6)
            boolean r13 = r16.isEmpty()
            if (r13 != 0) goto L_0x0177
            boolean r13 = r4.isEmpty()
            if (r13 != 0) goto L_0x0177
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r11 = com.utils.Getlink.Provider.BaseProvider.j(r11)
            r13.append(r11)
            java.lang.String r11 = "/m3u8/%s/%s/master.txt?s=1&cache=1"
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r13 = 0
            r10[r13] = r4
            r10[r6] = r16
            java.lang.String r4 = java.lang.String.format(r11, r10)
            boolean r10 = r4.startsWith(r12)
            if (r10 == 0) goto L_0x015b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r14)
            r10.append(r4)
            java.lang.String r4 = r10.toString()
        L_0x015b:
            com.original.tase.model.media.MediaSource r10 = new com.original.tase.model.media.MediaSource
            java.lang.String r11 = r17.A()
            java.lang.String r12 = "FastServer"
            r13 = 0
            r10.<init>(r11, r12, r13)
            r10.setStreamLink(r4)
            r10.setPlayHeader(r2)
            r10.setHLS(r6)
            r10.setQuality((java.lang.String) r15)
            r1.onNext(r10)
            goto L_0x0178
        L_0x0177:
            r13 = 0
        L_0x0178:
            r4 = 0
            goto L_0x0075
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.OneEMovie.J(io.reactivex.ObservableEmitter, java.lang.String):void");
    }

    public String K(MovieInfo movieInfo) {
        String replace = Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        String k2 = BaseProvider.k(HttpHelper.i().m(this.f37396e, new Map[0]), this.f37396e);
        Iterator it2 = Jsoup.b(HttpHelper.i().o(String.format(k2, new Object[]{replace}), this.f37396e)).q0("div.result-item").g("div.title").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("href");
            String h2 = TitleHelper.h(element.v0().toLowerCase(), "");
            if (h2.startsWith(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, ""))) {
                return c2;
            }
        }
        return "";
    }

    public String l(String str, String str2) {
        if (str.equals("streamango")) {
            return "https://streamango.com/embed/" + str2;
        } else if (str.equals("rapidvideo")) {
            return "https://www.rapidvideo.com/e/" + str2;
        } else if (str.equals("estream")) {
            return "https://estream.to/embed-" + str2 + ".html";
        } else if (str.equals("openload")) {
            return "https://openload.co/embed/" + str2;
        } else if (str.equals("vlid")) {
            return "https://vidlox.me/embed-" + str2 + ".html";
        } else if (str.equals("vzid")) {
            return "https://vidoza.net/embed-" + str2 + ".html";
        } else if (str.equals("vsid")) {
            return "https://verystream.com/e/" + str2;
        } else if (str.equals("fid")) {
            return "https://www.fembed.com/v/" + str2;
        } else if (!str.equals("vid")) {
            return "";
        } else {
            return "https://yandexcdn.com/player/embed_player.php?vid=" + str2;
        }
    }
}

package com.utils.Getlink.Provider;

import android.util.Base64;
import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class VidTv extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37480e = Utils.getProvider(48);

    /* renamed from: f  reason: collision with root package name */
    private String f37481f = "HD";

    /* renamed from: g  reason: collision with root package name */
    private String f37482g = "";

    /* renamed from: h  reason: collision with root package name */
    private HashMap f37483h = new HashMap();

    public String A() {
        return "VidTv";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        L(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        L(movieInfo, observableEmitter);
    }

    public String J(String str) {
        String c2 = Regex.c(str, "decode\\(\"([^\"]+)\"", 1, true);
        try {
            return new String(Base64.decode(c2, 0), "UTF-8");
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            try {
                return new String(Base64.decode(c2, 0));
            } catch (Exception e3) {
                Logger.d(e3, new boolean[0]);
                return "";
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        r0 = org.jsoup.Jsoup.b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String K(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.f37480e
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L_0x001a
            return r5
        L_0x001a:
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r1 = 0
            java.util.Map[] r2 = new java.util.Map[r1]
            java.lang.String r0 = r0.m(r5, r2)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x006d
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r2 = "div#media-player"
            org.jsoup.nodes.Element r2 = r0.r0(r2)
            if (r2 != 0) goto L_0x0038
            goto L_0x006d
        L_0x0038:
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r4.J(r2)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x005f
            org.jsoup.nodes.Document r2 = org.jsoup.Jsoup.b(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = "iframe[src]"
            org.jsoup.nodes.Element r2 = r2.r0(r3)     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x005f
            java.lang.String r3 = "src"
            java.lang.String r5 = r2.c(r3)     // Catch:{ Exception -> 0x0059 }
            return r5
        L_0x0059:
            r2 = move-exception
            boolean[] r1 = new boolean[r1]
            com.original.tase.Logger.d(r2, r1)
        L_0x005f:
            java.lang.String r1 = "a[href][target=\"_blank\"]"
            org.jsoup.nodes.Element r0 = r0.r0(r1)
            if (r0 == 0) goto L_0x006d
            java.lang.String r5 = "href"
            java.lang.String r5 = r0.c(r5)
        L_0x006d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.VidTv.K(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: org.jsoup.select.Elements} */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.util.AbstractCollection, java.util.AbstractList] */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void L(com.movie.data.model.MovieInfo r21, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            java.lang.String r3 = "entervideo.net"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r1.f37480e
            r4.append(r5)
            java.lang.String r5 = "/search-movies/"
            r4.append(r5)
            java.lang.String r5 = r21.getName()
            r6 = 0
            boolean[] r7 = new boolean[r6]
            java.lang.String r5 = com.original.tase.utils.Utils.k(r5, r7)
            java.lang.String r7 = "+"
            java.lang.String r8 = "%20"
            java.lang.String r5 = r5.replace(r7, r8)
            r4.append(r5)
            java.lang.String r5 = ".html"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r7 = "upgrade-insecure-requests"
            java.lang.String r8 = "1"
            r5.put(r7, r8)
            java.lang.String r7 = "cookie"
            java.lang.String r8 = "SL_G_WPT_TO=en; SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1"
            r5.put(r7, r8)
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            r8 = 1
            java.util.Map[] r9 = new java.util.Map[r8]
            r9[r6] = r5
            java.lang.String r4 = r7.m(r4, r9)
            java.lang.Integer r5 = r21.getType()
            int r5 = r5.intValue()
            if (r5 != r8) goto L_0x0062
            r5 = 1
            goto L_0x0063
        L_0x0062:
            r5 = 0
        L_0x0063:
            org.jsoup.nodes.Document r4 = org.jsoup.Jsoup.b(r4)
            java.lang.String r7 = "div#dle-content"
            org.jsoup.select.Elements r4 = r4.q0(r7)
            java.lang.String r7 = "div.itemInfo"
            org.jsoup.select.Elements r4 = r4.g(r7)
            java.util.Iterator r4 = r4.iterator()
        L_0x0077:
            boolean r7 = r4.hasNext()
            java.lang.String r9 = "href"
            java.lang.String r10 = "a[href]"
            java.lang.String r11 = ""
            if (r7 == 0) goto L_0x0130
            java.lang.Object r7 = r4.next()
            org.jsoup.nodes.Element r7 = (org.jsoup.nodes.Element) r7
            org.jsoup.nodes.Element r12 = r7.r0(r10)
            java.lang.String r13 = r12.c(r9)
            boolean r14 = r13.isEmpty()
            if (r14 != 0) goto L_0x0077
            java.lang.String r12 = r12.v0()
            java.lang.String r14 = "div.status-year"
            org.jsoup.nodes.Element r7 = r7.r0(r14)
            java.lang.String r7 = r7.v0()
            if (r5 == 0) goto L_0x00fd
            java.lang.String r14 = r21.getName()
            java.lang.String r14 = com.original.tase.helper.TitleHelper.d(r14)
            java.lang.String r12 = com.original.tase.helper.TitleHelper.d(r12)
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x0077
            java.lang.String r12 = r7.trim()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0131
            java.lang.String r12 = r7.trim()
            boolean r12 = com.original.tase.utils.Utils.o(r12)
            if (r12 == 0) goto L_0x0131
            java.lang.Integer r12 = r21.getYear()
            int r12 = r12.intValue()
            if (r12 <= 0) goto L_0x0131
            java.lang.String r12 = r7.trim()
            int r12 = java.lang.Integer.parseInt(r12)
            java.lang.Integer r14 = r21.getYear()
            int r14 = r14.intValue()
            if (r12 == r14) goto L_0x0131
            java.lang.String r7 = r7.trim()
            int r7 = java.lang.Integer.parseInt(r7)
            int r7 = r7 + r8
            java.lang.Integer r12 = r21.getYear()
            int r12 = r12.intValue()
            if (r7 != r12) goto L_0x0077
            goto L_0x0131
        L_0x00fd:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r14 = r21.getName()
            java.util.Locale r15 = java.util.Locale.ROOT
            java.lang.String r14 = r14.toLowerCase(r15)
            r7.append(r14)
            java.lang.String r14 = "season"
            r7.append(r14)
            java.lang.String r14 = r0.session
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = com.original.tase.helper.TitleHelper.h(r7, r11)
            java.lang.String r12 = r12.toLowerCase(r15)
            java.lang.String r12 = com.original.tase.helper.TitleHelper.h(r12, r11)
            boolean r7 = r7.equals(r12)
            if (r7 == 0) goto L_0x0077
            goto L_0x0131
        L_0x0130:
            r13 = r11
        L_0x0131:
            boolean r4 = r13.isEmpty()
            if (r4 == 0) goto L_0x0138
            return
        L_0x0138:
            java.lang.String r4 = "//"
            boolean r7 = r13.startsWith(r4)
            java.lang.String r12 = "http"
            java.lang.String r14 = "http:"
            java.lang.String r15 = "/"
            if (r7 == 0) goto L_0x0156
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r14)
            r7.append(r13)
            java.lang.String r13 = r7.toString()
            goto L_0x018b
        L_0x0156:
            boolean r7 = r13.startsWith(r15)
            if (r7 == 0) goto L_0x0171
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r1.f37480e
            r7.append(r8)
            r7.append(r11)
            r7.append(r13)
            java.lang.String r13 = r7.toString()
            goto L_0x018b
        L_0x0171:
            boolean r7 = r13.startsWith(r12)
            if (r7 != 0) goto L_0x018b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r1.f37480e
            r7.append(r8)
            r7.append(r15)
            r7.append(r13)
            java.lang.String r13 = r7.toString()
        L_0x018b:
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r8 = new java.util.Map[r6]
            java.lang.String r7 = r7.m(r13, r8)
            org.jsoup.nodes.Document r8 = org.jsoup.Jsoup.b(r7)
            if (r5 != 0) goto L_0x023b
            java.lang.String r5 = "div#details"
            org.jsoup.select.Elements r5 = r8.q0(r5)
            java.lang.String r6 = "a.episode.episode_series_link"
            org.jsoup.select.Elements r5 = r5.g(r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x01ab:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0235
            java.lang.Object r6 = r5.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r18 = r6.v0()
            r19 = r5
            java.lang.String r5 = r18.trim()
            r18 = r7
            java.lang.String r7 = r0.eps
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x022f
            java.lang.String r0 = r6.c(r9)
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x01e6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x01e4:
            r13 = r0
            goto L_0x021c
        L_0x01e6:
            boolean r4 = r0.startsWith(r15)
            if (r4 == 0) goto L_0x0201
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r1.f37480e
            r4.append(r5)
            r4.append(r11)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x01e4
        L_0x0201:
            boolean r4 = r0.startsWith(r12)
            if (r4 != 0) goto L_0x01e4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r1.f37480e
            r4.append(r5)
            r4.append(r15)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x01e4
        L_0x021c:
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r4 = 0
            java.util.Map[] r5 = new java.util.Map[r4]
            java.lang.String r0 = r0.m(r13, r5)
            org.jsoup.nodes.Document r4 = org.jsoup.Jsoup.b(r0)
            r7 = r0
            r8 = r4
            r0 = 1
            goto L_0x0238
        L_0x022f:
            r7 = r18
            r5 = r19
            goto L_0x01ab
        L_0x0235:
            r18 = r7
            r0 = 0
        L_0x0238:
            if (r0 != 0) goto L_0x023d
            return
        L_0x023b:
            r18 = r7
        L_0x023d:
            java.lang.String r0 = "decode\\(['\"]([^'\"]+)['\"]"
            r4 = 1
            java.lang.String r0 = com.original.tase.utils.Regex.a(r7, r0, r4)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x026c
            java.lang.String r0 = com.utils.Getlink.Provider.BaseProvider.d(r0)
            if (r0 == 0) goto L_0x026c
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x026c
            java.lang.String r5 = "<iframe[^>]+src=\"([^\"]+)\"[^>]*>"
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r5, r4)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x026c
            java.lang.String r5 = r1.f37481f
            boolean[] r6 = new boolean[r4]
            r4 = 0
            r6[r4] = r4
            r1.z(r2, r0, r5, r6)
        L_0x026c:
            java.lang.String r0 = "p.server_play"
            org.jsoup.select.Elements r4 = r8.q0(r0)
            java.lang.String r0 = "p.server_servername"
            org.jsoup.select.Elements r5 = r8.q0(r0)
            r6 = 0
        L_0x0279:
            int r0 = r4.size()
            if (r6 >= r0) goto L_0x03cf
            boolean r0 = r22.isDisposed()
            if (r0 == 0) goto L_0x0286
            return
        L_0x0286:
            java.lang.Object r0 = r4.get(r6)     // Catch:{ Exception -> 0x03bc }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ Exception -> 0x03bc }
            java.lang.Object r7 = r5.get(r6)     // Catch:{ Exception -> 0x03bc }
            org.jsoup.nodes.Element r7 = (org.jsoup.nodes.Element) r7     // Catch:{ Exception -> 0x03bc }
            org.jsoup.select.Elements r8 = r0.q0(r10)     // Catch:{ Exception -> 0x03bc }
            int r8 = r8.size()     // Catch:{ Exception -> 0x03bc }
            if (r8 <= 0) goto L_0x02a9
            org.jsoup.select.Elements r0 = r0.q0(r10)     // Catch:{ Exception -> 0x03bc }
            org.jsoup.nodes.Element r0 = r0.c()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r0 = r0.c(r9)     // Catch:{ Exception -> 0x03bc }
            goto L_0x02aa
        L_0x02a9:
            r0 = r11
        L_0x02aa:
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "^Server\\s*"
            java.lang.String r7 = r7.replaceAll(r8, r11)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "^server\\s*"
            java.lang.String r7 = r7.replaceAll(r8, r11)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "\\s*Link\\s+\\d+"
            java.lang.String r7 = r7.replaceAll(r8, r11)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "dailymotion"
            java.lang.String r12 = "idowatch.net"
            java.lang.String r7 = r7.replace(r8, r12)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "veoh"
            java.lang.String r7 = r7.replace(r8, r3)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "mega"
            java.lang.String r7 = r7.replace(r8, r3)     // Catch:{ Exception -> 0x03bc }
            boolean r8 = r0.isEmpty()     // Catch:{ Exception -> 0x03bc }
            if (r8 != 0) goto L_0x03b6
            boolean r8 = r0.startsWith(r15)     // Catch:{ Exception -> 0x03bc }
            if (r8 == 0) goto L_0x02f8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03bc }
            r8.<init>()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r12 = r1.f37480e     // Catch:{ Exception -> 0x03bc }
            r8.append(r12)     // Catch:{ Exception -> 0x03bc }
            r8.append(r11)     // Catch:{ Exception -> 0x03bc }
            r8.append(r0)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x03bc }
        L_0x02f8:
            java.lang.String r8 = "google"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x03bc }
            if (r7 == 0) goto L_0x03a3
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x03bc }
            r8 = 0
            java.util.Map[] r12 = new java.util.Map[r8]     // Catch:{ Exception -> 0x03bc }
            r7.m(r0, r12)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r0 = r1.f37480e     // Catch:{ Exception -> 0x03bc }
            java.lang.String r7 = "\\{\\s*link\\s*:\\s*\"([^\"]+)"
            r8 = 1
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r7, r8)     // Catch:{ Exception -> 0x03bc }
            boolean r7 = r0.isEmpty()     // Catch:{ Exception -> 0x03bc }
            if (r7 != 0) goto L_0x03b6
            java.util.HashMap r7 = com.original.Constants.c()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r8 = "Referer"
            r7.put(r8, r13)     // Catch:{ Exception -> 0x03bc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03bc }
            r8.<init>()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r12 = "link="
            r8.append(r12)     // Catch:{ Exception -> 0x03bc }
            r8.append(r0)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x03bc }
            com.original.tase.helper.http.HttpHelper r8 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x03bc }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03bc }
            r12.<init>()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r14 = r1.f37480e     // Catch:{ Exception -> 0x03bc }
            r12.append(r14)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r14 = "/media/plugins/gkpluginsphp.php"
            r12.append(r14)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x03bc }
            r16 = r3
            r14 = 1
            java.util.Map[] r3 = new java.util.Map[r14]     // Catch:{ Exception -> 0x03a1 }
            r17 = 0
            r3[r17] = r7     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r0 = r8.l(r12, r0, r3)     // Catch:{ Exception -> 0x03a1 }
            java.util.HashMap r0 = com.original.tase.helper.GkPluginsHelper.a(r0)     // Catch:{ Exception -> 0x03a1 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x03a1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x03a1 }
        L_0x0363:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x03a1 }
            if (r3 == 0) goto L_0x03b8
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x03a1 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x03a1 }
            java.lang.Object r7 = r3.getKey()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x03a1 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x03a1 }
            com.original.tase.model.media.MediaSource r8 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r12 = r20.A()     // Catch:{ Exception -> 0x03a1 }
            boolean r18 = com.original.tase.helper.GoogleVideoHelper.d(r7)     // Catch:{ Exception -> 0x03a1 }
            if (r18 == 0) goto L_0x038a
            java.lang.String r18 = "GoogleVideo"
            goto L_0x038c
        L_0x038a:
            java.lang.String r18 = "CDN"
        L_0x038c:
            r21 = r4
            r14 = r18
            r4 = 0
            r8.<init>(r12, r14, r4)     // Catch:{ Exception -> 0x03b4 }
            r8.setStreamLink(r7)     // Catch:{ Exception -> 0x03b4 }
            r8.setQuality((java.lang.String) r3)     // Catch:{ Exception -> 0x03b4 }
            r2.onNext(r8)     // Catch:{ Exception -> 0x03b4 }
            r4 = r21
            r14 = 1
            goto L_0x0363
        L_0x03a1:
            r0 = move-exception
            goto L_0x03bf
        L_0x03a3:
            r16 = r3
            r21 = r4
            java.lang.String r0 = r1.K(r0)     // Catch:{ Exception -> 0x03b4 }
            java.lang.String r3 = "HD"
            r4 = 0
            boolean[] r7 = new boolean[r4]     // Catch:{ Exception -> 0x03b4 }
            r1.z(r2, r0, r3, r7)     // Catch:{ Exception -> 0x03b4 }
            goto L_0x03ba
        L_0x03b4:
            r0 = move-exception
            goto L_0x03c1
        L_0x03b6:
            r16 = r3
        L_0x03b8:
            r21 = r4
        L_0x03ba:
            r3 = 0
            goto L_0x03c7
        L_0x03bc:
            r0 = move-exception
            r16 = r3
        L_0x03bf:
            r21 = r4
        L_0x03c1:
            r3 = 0
            boolean[] r4 = new boolean[r3]
            com.original.tase.Logger.d(r0, r4)
        L_0x03c7:
            int r6 = r6 + 1
            r4 = r21
            r3 = r16
            goto L_0x0279
        L_0x03cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.VidTv.L(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }
}

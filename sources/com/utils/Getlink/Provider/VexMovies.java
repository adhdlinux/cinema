package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class VexMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37479e = Utils.getProvider(83);

    private String K(MovieInfo movieInfo) {
        String replace = movieInfo.getName().replace("Marvel's ", "").replace("DC's ", "");
        String replace2 = this.f37479e.replace("https://", "http://");
        String o2 = HttpHelper.i().o("https://google.ch/search?q=" + com.original.tase.utils.Utils.k(replace, new boolean[0]).replace("%20", "+") + "+site:" + replace2, "https://google.ch");
        com.original.tase.utils.Utils.k(replace + " site:" + replace2.replace("https://", "").replace("http://", ""), new boolean[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US");
        hashMap.put("Origin", "https://duckduckgo.com");
        String str = o2;
        hashMap.put("Referer", "https://duckduckgo.com/");
        hashMap.put("Upgrade-Insecure-Requests", "1");
        String o3 = HttpHelper.i().o("https://www.bing.com/search?q=" + com.original.tase.utils.Utils.k(replace, new boolean[0]).replace("%20", "+") + "+site:" + replace2, "https://www.bing.com");
        com.original.tase.utils.Utils.k(replace + " " + replace2.replace("https://", "").replace("http://", ""), new boolean[0]);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        hashMap2.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US");
        hashMap2.put("Host", "www.startpage.com");
        hashMap2.put("Origin", "https://www.startpage.com");
        hashMap2.put("Referer", "https://www.startpage.com/do/asearch");
        hashMap2.put("Upgrade-Insecure-Requests", "1");
        hashMap2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        arrayList.add(o3.replaceAll("(</?\\w{1,7}>)", ""));
        String str2 = "(" + TitleHelper.g(replace.replace("$", "\\$").replace("*", "\\*").replace("(", "\\(").replace(")", "\\)").replace("[", "\\[").replace("]", "\\]")) + ")";
        for (String f2 : arrayList) {
            Iterator it2 = Regex.f(f2, "href=['\"](.+?)['\"]", 1, true).get(0).iterator();
            while (true) {
                if (it2.hasNext()) {
                    String str3 = (String) it2.next();
                    try {
                        if (str3.startsWith(UriUtil.HTTP_SCHEME) && str3.contains("vexmovie") && !str3.contains("//translate.") && !str3.contains("startpage.com") && str3.replace("https://", "http://").contains(replace2) && !Regex.b(str3.trim().toLowerCase(), str2, 1, 2).isEmpty()) {
                            return str3;
                        }
                    } catch (Exception e2) {
                        Logger.d(e2, new boolean[0]);
                    }
                }
            }
        }
        return "";
    }

    public String A() {
        return "VexMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0711, code lost:
        if (r0.toLowerCase().contains("cdn") == false) goto L_0x0716;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0619 A[SYNTHETIC, Splitter:B:255:0x0619] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0641  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0663  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0672  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0689 A[SYNTHETIC, Splitter:B:289:0x0689] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x068e  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x069d A[SYNTHETIC, Splitter:B:295:0x069d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r30, com.movie.data.model.MovieInfo r31) {
        /*
            r29 = this;
            r1 = r29
            r2 = r30
            java.lang.String r3 = "megaup."
            java.lang.String r4 = "gphoto."
            java.lang.String r5 = "Referer"
            java.lang.String r6 = "consistent.stream"
            java.lang.String r7 = "\\\""
            java.lang.String r8 = "\""
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = r1.f37479e
            r0.append(r10)
            java.lang.String r10 = "/?s="
            r0.append(r10)
            java.lang.String r10 = r31.getName()
            r11 = 0
            boolean[] r12 = new boolean[r11]
            java.lang.String r10 = com.original.tase.utils.Utils.k(r10, r12)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r12 = r1.f37479e
            java.lang.String r0 = r0.o(r10, r12)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r12 = "div.item[id]"
            org.jsoup.select.Elements r0 = r0.q0(r12)
            java.util.Iterator r12 = r0.iterator()
        L_0x004e:
            boolean r0 = r12.hasNext()
            java.lang.String r13 = ""
            if (r0 == 0) goto L_0x00ce
            java.lang.Object r0 = r12.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r14 = "a[href]"
            org.jsoup.select.Elements r14 = r0.q0(r14)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r15 = "href"
            java.lang.String r14 = r14.a(r15)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r15 = "h2"
            org.jsoup.select.Elements r15 = r0.q0(r15)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r15 = r15.h()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r11 = "span.year"
            org.jsoup.select.Elements r0 = r0.q0(r11)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.g(r15)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r15 = r31.getName()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r15 = com.original.tase.helper.TitleHelper.g(r15)     // Catch:{ Exception -> 0x00c3 }
            boolean r11 = r11.equals(r15)     // Catch:{ Exception -> 0x00c3 }
            if (r11 == 0) goto L_0x00cc
            java.lang.String r11 = r0.trim()     // Catch:{ Exception -> 0x00c3 }
            boolean r11 = r11.isEmpty()     // Catch:{ Exception -> 0x00c3 }
            if (r11 != 0) goto L_0x00cc
            java.lang.String r11 = r0.trim()     // Catch:{ Exception -> 0x00c3 }
            boolean r11 = com.original.tase.utils.Utils.o(r11)     // Catch:{ Exception -> 0x00c3 }
            if (r11 == 0) goto L_0x00cc
            java.lang.Integer r11 = r31.getYear()     // Catch:{ Exception -> 0x00c3 }
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x00c3 }
            if (r11 <= 0) goto L_0x00cc
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00c3 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00c3 }
            java.lang.Integer r11 = r31.getYear()     // Catch:{ Exception -> 0x00c3 }
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x00c3 }
            if (r0 != r11) goto L_0x00cc
            goto L_0x00cf
        L_0x00c3:
            r0 = move-exception
            r11 = 0
            goto L_0x00c7
        L_0x00c6:
            r0 = move-exception
        L_0x00c7:
            boolean[] r13 = new boolean[r11]
            com.original.tase.Logger.d(r0, r13)
        L_0x00cc:
            r11 = 0
            goto L_0x004e
        L_0x00ce:
            r14 = r13
        L_0x00cf:
            boolean r0 = r14.isEmpty()
            java.lang.String r11 = "/"
            r15 = r31
            if (r0 == 0) goto L_0x0137
            java.lang.String r14 = r1.K(r15)
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x0135
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = "https://consistent.stream/titles/"
            r0.append(r14)
            java.lang.String r14 = r31.getName()
            java.lang.String r12 = "'"
            java.lang.String r14 = r14.replace(r12, r13)
            java.lang.String r14 = com.original.tase.helper.TitleHelper.g(r14)
            r0.append(r14)
            java.lang.String r14 = "-"
            r0.append(r14)
            java.lang.Integer r14 = r31.getYear()
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r9.add(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = r1.f37479e
            r0.append(r14)
            r0.append(r11)
            java.lang.String r14 = r31.getName()
            java.lang.String r12 = r14.replace(r12, r13)
            java.lang.String r12 = com.original.tase.helper.TitleHelper.g(r12)
            java.lang.String r12 = com.original.tase.helper.TitleHelper.g(r12)
            r0.append(r12)
            java.lang.String r14 = r0.toString()
        L_0x0135:
            r12 = 1
            goto L_0x0138
        L_0x0137:
            r12 = 0
        L_0x0138:
            boolean r0 = r14.isEmpty()
            java.lang.String r15 = "http"
            r18 = r3
            java.lang.String r3 = "http:"
            r19 = r4
            java.lang.String r4 = "//"
            if (r0 != 0) goto L_0x02f0
            boolean r0 = r14.startsWith(r4)
            if (r0 == 0) goto L_0x0160
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r20 = r5
            goto L_0x0196
        L_0x0160:
            boolean r0 = r14.startsWith(r11)
            if (r0 == 0) goto L_0x017a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r20 = r5
            java.lang.String r5 = r1.f37479e
            r0.append(r5)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            goto L_0x0196
        L_0x017a:
            r20 = r5
            boolean r0 = r14.startsWith(r15)
            if (r0 != 0) goto L_0x0196
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = r1.f37479e
            r0.append(r5)
            r0.append(r11)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
        L_0x0196:
            java.lang.String r0 = "(\\?print=(?:true|false))"
            java.lang.String r14 = r14.replaceAll(r0, r13)
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r21 = r7
            r5 = 0
            java.util.Map[] r7 = new java.util.Map[r5]
            java.lang.String r0 = r0.r(r14, r10, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x02f4
            java.lang.String r5 = "<title>Page not found"
            boolean r5 = r0.contains(r5)
            if (r5 != 0) goto L_0x02f4
            org.jsoup.nodes.Document r5 = org.jsoup.Jsoup.b(r0)
            java.lang.String r0 = "span.calidad2"
            org.jsoup.nodes.Element r0 = r5.r0(r0)     // Catch:{ Exception -> 0x01df }
            java.lang.String r0 = r0.v0()     // Catch:{ Exception -> 0x01df }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x01df }
            java.lang.String r7 = "cam"
            boolean r7 = r0.contains(r7)     // Catch:{ Exception -> 0x01df }
            if (r7 != 0) goto L_0x01dc
            java.lang.String r7 = "ts"
            boolean r0 = r0.contains(r7)     // Catch:{ Exception -> 0x01df }
            if (r0 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r0 = 0
            goto L_0x01dd
        L_0x01dc:
            r0 = 1
        L_0x01dd:
            r7 = r0
            goto L_0x01e7
        L_0x01df:
            r0 = move-exception
            r7 = 0
            boolean[] r10 = new boolean[r7]
            com.original.tase.Logger.d(r0, r10)
            r7 = 0
        L_0x01e7:
            if (r12 == 0) goto L_0x0270
            java.lang.String r0 = "p.meta"
            org.jsoup.nodes.Element r0 = r5.r0(r0)     // Catch:{ Exception -> 0x0265 }
            if (r0 == 0) goto L_0x026c
            java.lang.String r10 = "a[rel=\"tag\"]"
            org.jsoup.select.Elements r0 = r0.q0(r10)     // Catch:{ Exception -> 0x0265 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0265 }
        L_0x01fb:
            boolean r10 = r0.hasNext()     // Catch:{ Exception -> 0x0265 }
            if (r10 == 0) goto L_0x026c
            java.lang.Object r10 = r0.next()     // Catch:{ Exception -> 0x0265 }
            org.jsoup.nodes.Element r10 = (org.jsoup.nodes.Element) r10     // Catch:{ Exception -> 0x0265 }
            java.lang.String r10 = r10.v0()     // Catch:{ Exception -> 0x0265 }
            java.lang.String r10 = r10.trim()     // Catch:{ Exception -> 0x0265 }
            java.lang.String r12 = " "
            java.lang.String r10 = r10.replace(r12, r13)     // Catch:{ Exception -> 0x0265 }
            java.lang.String r12 = "\r"
            java.lang.String r10 = r10.replace(r12, r13)     // Catch:{ Exception -> 0x0265 }
            java.lang.String r12 = "\n"
            java.lang.String r10 = r10.replace(r12, r13)     // Catch:{ Exception -> 0x0265 }
            boolean r12 = r10.isEmpty()     // Catch:{ Exception -> 0x0265 }
            if (r12 != 0) goto L_0x023e
            boolean r12 = com.original.tase.utils.Utils.o(r10)     // Catch:{ Exception -> 0x0265 }
            if (r12 == 0) goto L_0x023e
            int r12 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x0265 }
            java.lang.Integer r22 = r31.getYear()     // Catch:{ Exception -> 0x0265 }
            r23 = r0
            int r0 = r22.intValue()     // Catch:{ Exception -> 0x0265 }
            if (r12 == r0) goto L_0x0262
            goto L_0x0240
        L_0x023e:
            r23 = r0
        L_0x0240:
            int r0 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x0265 }
            java.lang.Integer r12 = r31.getYear()     // Catch:{ Exception -> 0x0265 }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x0265 }
            r17 = 1
            int r12 = r12 + 1
            if (r0 == r12) goto L_0x0262
            int r0 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x0265 }
            java.lang.Integer r10 = r31.getYear()     // Catch:{ Exception -> 0x0265 }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x0265 }
            if (r0 != r10) goto L_0x0262
            r0 = 1
            goto L_0x026d
        L_0x0262:
            r0 = r23
            goto L_0x01fb
        L_0x0265:
            r0 = move-exception
            r10 = 0
            boolean[] r12 = new boolean[r10]
            com.original.tase.Logger.d(r0, r12)
        L_0x026c:
            r0 = 0
        L_0x026d:
            if (r0 != 0) goto L_0x0270
            return
        L_0x0270:
            java.lang.String r0 = "iframe[src]"
            org.jsoup.select.Elements r0 = r5.q0(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x027a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x02f5
            java.lang.Object r5 = r0.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            java.lang.String r10 = "src"
            java.lang.String r5 = r5.c(r10)
            java.lang.String r10 = r5.toLowerCase()
            java.lang.String r12 = "youtube.com/"
            boolean r10 = r10.contains(r12)
            if (r10 != 0) goto L_0x027a
            java.lang.String r10 = r5.toLowerCase()
            java.lang.String r12 = "youtu.be/"
            boolean r10 = r10.contains(r12)
            if (r10 != 0) goto L_0x027a
            boolean r10 = r5.startsWith(r4)
            if (r10 == 0) goto L_0x02ba
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r3)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            goto L_0x02ec
        L_0x02ba:
            boolean r10 = r5.startsWith(r11)
            if (r10 == 0) goto L_0x02d2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r1.f37479e
            r10.append(r12)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            goto L_0x02ec
        L_0x02d2:
            boolean r10 = r5.startsWith(r15)
            if (r10 != 0) goto L_0x02ec
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r1.f37479e
            r10.append(r12)
            r10.append(r11)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
        L_0x02ec:
            r9.add(r5)
            goto L_0x027a
        L_0x02f0:
            r20 = r5
            r21 = r7
        L_0x02f4:
            r7 = 0
        L_0x02f5:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x02fc
            return
        L_0x02fc:
            java.util.ArrayList r0 = com.original.tase.utils.Utils.l(r9)
            java.util.Iterator r5 = r0.iterator()
        L_0x0304:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x08df
            java.lang.Object r0 = r5.next()
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r0 = r9.toLowerCase()     // Catch:{ Exception -> 0x08a5 }
            boolean r0 = r0.contains(r6)     // Catch:{ Exception -> 0x08a5 }
            java.lang.String r10 = "HD"
            if (r0 != 0) goto L_0x0371
            r12 = 1
            boolean[] r0 = new boolean[r12]     // Catch:{ Exception -> 0x0354 }
            r12 = 0
            r0[r12] = r7     // Catch:{ Exception -> 0x0354 }
            r1.z(r2, r9, r10, r0)     // Catch:{ Exception -> 0x0354 }
            java.lang.String r0 = "/openload."
            boolean r0 = r9.contains(r0)     // Catch:{ Exception -> 0x0354 }
            if (r0 != 0) goto L_0x0371
            java.lang.String r0 = "/oload."
            boolean r0 = r9.contains(r0)     // Catch:{ Exception -> 0x0354 }
            if (r0 != 0) goto L_0x0371
            java.lang.String r0 = "/streamango."
            boolean r0 = r9.contains(r0)     // Catch:{ Exception -> 0x0354 }
            if (r0 != 0) goto L_0x0371
            java.lang.String r0 = "/streamcherry"
            boolean r0 = r9.contains(r0)     // Catch:{ Exception -> 0x0354 }
            if (r0 != 0) goto L_0x0371
            java.lang.String r0 = "/thevid."
            boolean r0 = r9.contains(r0)     // Catch:{ Exception -> 0x0354 }
            if (r0 != 0) goto L_0x0371
            java.lang.String r0 = "/thevideo."
            r9.contains(r0)     // Catch:{ Exception -> 0x0354 }
            goto L_0x0371
        L_0x0354:
            r0 = move-exception
            r24 = r4
            r31 = r5
            r23 = r7
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            r7 = r1
            r1 = r2
            r19 = r3
            r20 = r13
            r2 = 0
        L_0x036e:
            r3 = 1
            goto L_0x08c0
        L_0x0371:
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x08a5 }
            boolean r0 = r14.isEmpty()     // Catch:{ Exception -> 0x08a5 }
            r31 = r5
            java.lang.String r5 = "https://consistent.stream"
            if (r0 == 0) goto L_0x0381
            r1 = r5
            goto L_0x0382
        L_0x0381:
            r1 = r14
        L_0x0382:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x03a2, Exception -> 0x0388 }
            r0.<init>(r9)     // Catch:{ MalformedURLException -> 0x03a2, Exception -> 0x0388 }
            goto L_0x03a6
        L_0x0388:
            r0 = move-exception
            r1 = r2
            r24 = r4
            r23 = r7
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            r2 = 0
            r7 = r29
            r19 = r3
            r20 = r13
            goto L_0x036e
        L_0x03a2:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0890 }
        L_0x03a6:
            java.lang.String r0 = r12.o(r9, r1)     // Catch:{ Exception -> 0x0890 }
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0890 }
            if (r1 != 0) goto L_0x0876
            java.lang.String r1 = "<player[^>]+expire=\"([^\"]+)\"[^>]*>"
            r12 = 2
            r22 = r10
            r10 = 1
            java.lang.String r1 = com.original.tase.utils.Regex.b(r0, r1, r10, r12)     // Catch:{ Exception -> 0x0890 }
            java.lang.String r2 = "<player[^>]+video=\"([^\"]+)\"[^>]*>"
            java.lang.String r2 = com.original.tase.utils.Regex.b(r0, r2, r10, r12)     // Catch:{ Exception -> 0x0872 }
            r23 = r7
            java.lang.String r7 = "<player[^>]+hash=\"([^\"]+)\"[^>]*>"
            java.lang.String r0 = com.original.tase.utils.Regex.b(r0, r7, r10, r12)     // Catch:{ Exception -> 0x085e }
            boolean r7 = r2.isEmpty()     // Catch:{ Exception -> 0x085e }
            if (r7 != 0) goto L_0x084b
            boolean r7 = r0.isEmpty()     // Catch:{ Exception -> 0x085e }
            if (r7 != 0) goto L_0x084b
            java.lang.String r7 = "{\"expire\":\"%s\",\"video\":\"%s\",\"referrer\":\"%s\",\"key\":\"%s\" }"
            r10 = 4
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x085e }
            r16 = 0
            r10[r16] = r1     // Catch:{ Exception -> 0x085e }
            r1 = r21
            java.lang.String r2 = r2.replace(r8, r1)     // Catch:{ Exception -> 0x0834 }
            r17 = 1
            r10[r17] = r2     // Catch:{ Exception -> 0x0834 }
            boolean r2 = r14.isEmpty()     // Catch:{ Exception -> 0x0834 }
            if (r2 == 0) goto L_0x03ee
            goto L_0x03f1
        L_0x03ee:
            r14.replace(r8, r1)     // Catch:{ Exception -> 0x0834 }
        L_0x03f1:
            r10[r12] = r9     // Catch:{ Exception -> 0x0834 }
            java.lang.String r0 = r0.replace(r8, r1)     // Catch:{ Exception -> 0x0834 }
            r2 = 3
            r10[r2] = r0     // Catch:{ Exception -> 0x0834 }
            java.lang.String r0 = java.lang.String.format(r7, r10)     // Catch:{ Exception -> 0x0834 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0834 }
            r2.<init>()     // Catch:{ Exception -> 0x0834 }
            java.lang.String r7 = "Content-Type"
            java.lang.String r10 = "application/json;charset=UTF-8"
            r2.put(r7, r10)     // Catch:{ Exception -> 0x0834 }
            java.lang.String r7 = "Origin"
            r2.put(r7, r5)     // Catch:{ Exception -> 0x0834 }
            r7 = r20
            r2.put(r7, r9)     // Catch:{ Exception -> 0x0818 }
            java.lang.String r10 = "Host"
            java.lang.String r12 = "https://"
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0818 }
            java.lang.String r12 = "http://"
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0818 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0818 }
            r2.put(r10, r5)     // Catch:{ Exception -> 0x0818 }
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x0818 }
            java.lang.String r10 = "https://consistent.stream/api/getVideo"
            r20 = r13
            r12 = 1
            java.util.Map[] r13 = new java.util.Map[r12]     // Catch:{ Exception -> 0x080e }
            r12 = 0
            r13[r12] = r2     // Catch:{ Exception -> 0x080e }
            java.lang.String r0 = r5.q(r10, r0, r12, r13)     // Catch:{ Exception -> 0x080e }
            boolean r2 = r0.isEmpty()     // Catch:{ Exception -> 0x080e }
            if (r2 != 0) goto L_0x07f5
            java.lang.String r2 = "&quot;"
            java.lang.String r0 = r0.replace(r2, r8)     // Catch:{ Exception -> 0x080e }
            java.lang.String r2 = "&amp;"
            java.lang.String r5 = "&"
            java.lang.String r0 = r0.replace(r2, r5)     // Catch:{ Exception -> 0x080e }
            java.lang.String r0 = r0.replace(r1, r8)     // Catch:{ Exception -> 0x080e }
            java.lang.String r2 = "\\/"
            java.lang.String r0 = r0.replace(r2, r11)     // Catch:{ Exception -> 0x080e }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x080e }
            r2.<init>()     // Catch:{ Exception -> 0x080e }
            java.lang.String r5 = "Accept"
            java.lang.String r10 = "*/*"
            r2.put(r5, r10)     // Catch:{ Exception -> 0x080e }
            java.lang.String r5 = "Accept-Language"
            java.lang.String r10 = "en-US,en;q=0.9"
            r2.put(r5, r10)     // Catch:{ Exception -> 0x080e }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x080e }
            java.lang.String r5 = "User-Agent"
            java.lang.String r9 = com.original.Constants.C     // Catch:{ Exception -> 0x080e }
            r2.put(r5, r9)     // Catch:{ Exception -> 0x080e }
            java.lang.String r5 = "['\"]sources['\"].+?['\"]([^'\"]*//[^'\"]+?)['\"]"
            r9 = 1
            java.util.ArrayList r0 = com.original.tase.utils.Regex.f(r0, r5, r9, r9)     // Catch:{ Exception -> 0x080e }
            r5 = 0
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x080e }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x080e }
            java.util.ArrayList r0 = com.original.tase.utils.Utils.l(r0)     // Catch:{ Exception -> 0x080e }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ Exception -> 0x080e }
        L_0x048c:
            boolean r0 = r5.hasNext()     // Catch:{ Exception -> 0x080e }
            if (r0 == 0) goto L_0x07f5
            java.lang.Object r0 = r5.next()     // Catch:{ Exception -> 0x080e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x080e }
            boolean r9 = r0.isEmpty()     // Catch:{ Exception -> 0x07b8 }
            if (r9 != 0) goto L_0x079c
            boolean r9 = r0.startsWith(r4)     // Catch:{ Exception -> 0x07b8 }
            if (r9 == 0) goto L_0x04d3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04b4 }
            r9.<init>()     // Catch:{ Exception -> 0x04b4 }
            r9.append(r3)     // Catch:{ Exception -> 0x04b4 }
            r9.append(r0)     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x04b4 }
            goto L_0x0502
        L_0x04b4:
            r0 = move-exception
            r21 = r1
            r24 = r4
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r8 = r22
            r4 = 0
            r1 = r30
            r19 = r3
            r18 = r7
            r3 = 1
        L_0x04cf:
            r7 = r29
            goto L_0x07d5
        L_0x04d3:
            boolean r9 = r0.startsWith(r11)     // Catch:{ Exception -> 0x07b8 }
            if (r9 == 0) goto L_0x04eb
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04b4 }
            r9.<init>()     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r10 = "http://vexmovies.org"
            r9.append(r10)     // Catch:{ Exception -> 0x04b4 }
            r9.append(r0)     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x04b4 }
            goto L_0x0502
        L_0x04eb:
            boolean r9 = r0.startsWith(r15)     // Catch:{ Exception -> 0x07b8 }
            if (r9 != 0) goto L_0x0502
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04b4 }
            r9.<init>()     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r10 = "http://vexmovies.org/"
            r9.append(r10)     // Catch:{ Exception -> 0x04b4 }
            r9.append(r0)     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x04b4 }
        L_0x0502:
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x07b8 }
            java.lang.String r10 = "openload."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x07b8 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "oload."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "thevid"
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "streamango."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "streamcherry."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "silkplay."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "d0stream.com"
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "vidlox."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 != 0) goto L_0x0774
            java.lang.String r9 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = "uploadhaven."
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0756 }
            if (r9 == 0) goto L_0x0570
            goto L_0x0774
        L_0x0570:
            boolean r9 = com.original.tase.helper.GoogleVideoHelper.n(r0)     // Catch:{ Exception -> 0x0756 }
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x0756 }
            r12 = r19
            boolean r10 = r10.contains(r12)     // Catch:{ Exception -> 0x0742 }
            java.lang.String r13 = "flxserver"
            r21 = r1
            java.lang.String r1 = "flenix."
            r19 = r3
            java.lang.String r3 = "dfcdn."
            if (r10 != 0) goto L_0x0600
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e9 }
            boolean r10 = r10.contains(r3)     // Catch:{ Exception -> 0x05e9 }
            if (r10 != 0) goto L_0x0600
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e9 }
            r24 = r4
            java.lang.String r4 = "cloudfront"
            boolean r4 = r10.contains(r4)     // Catch:{ Exception -> 0x05e7 }
            if (r4 != 0) goto L_0x0602
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e7 }
            boolean r4 = r4.contains(r1)     // Catch:{ Exception -> 0x05e7 }
            if (r4 != 0) goto L_0x0602
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e7 }
            boolean r4 = r4.contains(r13)     // Catch:{ Exception -> 0x05e7 }
            if (r4 != 0) goto L_0x0602
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e7 }
            java.lang.String r10 = "flixserver"
            boolean r4 = r4.contains(r10)     // Catch:{ Exception -> 0x05e7 }
            if (r4 != 0) goto L_0x0602
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e7 }
            boolean r4 = r4.contains(r6)     // Catch:{ Exception -> 0x05e7 }
            if (r4 != 0) goto L_0x0602
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e7 }
            java.lang.String r10 = "cdnvideo"
            boolean r4 = r4.contains(r10)     // Catch:{ Exception -> 0x05e7 }
            if (r4 != 0) goto L_0x0602
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x05e7 }
            java.lang.String r10 = ".m3u8"
            boolean r4 = r4.contains(r10)     // Catch:{ Exception -> 0x05e7 }
            if (r4 == 0) goto L_0x05e5
            goto L_0x0602
        L_0x05e5:
            r4 = 0
            goto L_0x0603
        L_0x05e7:
            r0 = move-exception
            goto L_0x05ec
        L_0x05e9:
            r0 = move-exception
            r24 = r4
        L_0x05ec:
            r1 = r30
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r8 = r22
            r3 = 1
            r4 = 0
            r18 = r7
            goto L_0x04cf
        L_0x0600:
            r24 = r4
        L_0x0602:
            r4 = 1
        L_0x0603:
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x0734 }
            r25 = r5
            r5 = r18
            boolean r10 = r10.contains(r5)     // Catch:{ Exception -> 0x0728 }
            r18 = r7
            java.lang.String r7 = "/resolve/"
            r26 = r8
            java.lang.String r8 = "linkhost."
            if (r10 != 0) goto L_0x063e
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x0630 }
            boolean r10 = r10.contains(r8)     // Catch:{ Exception -> 0x0630 }
            if (r10 != 0) goto L_0x063e
            java.lang.String r10 = r0.toLowerCase()     // Catch:{ Exception -> 0x0630 }
            boolean r10 = r10.contains(r7)     // Catch:{ Exception -> 0x0630 }
            if (r10 == 0) goto L_0x062e
            goto L_0x063e
        L_0x062e:
            r10 = 0
            goto L_0x063f
        L_0x0630:
            r0 = move-exception
            r7 = r29
            r1 = r30
            r27 = r11
            r28 = r14
        L_0x0639:
            r8 = r22
            r3 = 1
            goto L_0x07d4
        L_0x063e:
            r10 = 1
        L_0x063f:
            if (r23 == 0) goto L_0x0663
            r27 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x065b }
            r11.<init>()     // Catch:{ Exception -> 0x065b }
            r28 = r14
            java.lang.String r14 = r29.A()     // Catch:{ Exception -> 0x0670 }
            r11.append(r14)     // Catch:{ Exception -> 0x0670 }
            java.lang.String r14 = " (CAM)"
            r11.append(r14)     // Catch:{ Exception -> 0x0670 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0670 }
            goto L_0x066b
        L_0x065b:
            r0 = move-exception
            r28 = r14
        L_0x065e:
            r7 = r29
            r1 = r30
            goto L_0x0639
        L_0x0663:
            r27 = r11
            r28 = r14
            java.lang.String r11 = r29.A()     // Catch:{ Exception -> 0x0724 }
        L_0x066b:
            if (r9 == 0) goto L_0x0672
            java.lang.String r4 = "GoogleVideo"
            goto L_0x067e
        L_0x0670:
            r0 = move-exception
            goto L_0x065e
        L_0x0672:
            if (r4 == 0) goto L_0x0677
            java.lang.String r4 = "CDN-FastServer"
            goto L_0x067e
        L_0x0677:
            if (r10 == 0) goto L_0x067c
            java.lang.String r4 = "CDN"
            goto L_0x067e
        L_0x067c:
            java.lang.String r4 = "CDN-SlowServer"
        L_0x067e:
            com.original.tase.model.media.MediaSource r10 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0724 }
            r14 = 0
            r10.<init>(r11, r4, r14)     // Catch:{ Exception -> 0x0724 }
            r10.setStreamLink(r0)     // Catch:{ Exception -> 0x0724 }
            if (r9 == 0) goto L_0x068e
            java.lang.String r4 = com.original.tase.helper.GoogleVideoHelper.h(r0)     // Catch:{ Exception -> 0x0670 }
            goto L_0x0690
        L_0x068e:
            r4 = r22
        L_0x0690:
            r10.setQuality((java.lang.String) r4)     // Catch:{ Exception -> 0x0724 }
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x0724 }
            boolean r4 = r4.contains(r12)     // Catch:{ Exception -> 0x0724 }
            if (r4 != 0) goto L_0x0713
            java.lang.String r4 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r3 = r4.contains(r3)     // Catch:{ Exception -> 0x0670 }
            if (r3 != 0) goto L_0x0713
            java.lang.String r3 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            java.lang.String r4 = "mentor."
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x0670 }
            if (r3 != 0) goto L_0x0713
            java.lang.String r3 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r1 = r3.contains(r1)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r1 = r1.contains(r13)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            java.lang.String r3 = "flixserver"
            boolean r1 = r1.contains(r3)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            java.lang.String r3 = ".m3u8"
            boolean r1 = r1.contains(r3)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r1 = r1.contains(r5)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r1 = r1.contains(r8)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r1 = r1.contains(r7)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            boolean r1 = r1.contains(r6)     // Catch:{ Exception -> 0x0670 }
            if (r1 != 0) goto L_0x0713
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0670 }
            java.lang.String r1 = "cdn"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0670 }
            if (r0 == 0) goto L_0x0716
        L_0x0713:
            r10.setPlayHeader(r2)     // Catch:{ Exception -> 0x0724 }
        L_0x0716:
            r1 = r30
            r1.onNext(r10)     // Catch:{ Exception -> 0x0722 }
            r3 = 1
            r7 = r29
            r8 = r22
            goto L_0x07da
        L_0x0722:
            r0 = move-exception
            goto L_0x076d
        L_0x0724:
            r0 = move-exception
            r1 = r30
            goto L_0x076d
        L_0x0728:
            r0 = move-exception
            r1 = r30
            r18 = r7
            r26 = r8
            r27 = r11
            r28 = r14
            goto L_0x076d
        L_0x0734:
            r0 = move-exception
            r1 = r30
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            goto L_0x076b
        L_0x0742:
            r0 = move-exception
            r21 = r1
            r19 = r3
            r24 = r4
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r1 = r30
            goto L_0x076b
        L_0x0756:
            r0 = move-exception
            r21 = r1
            r24 = r4
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r1 = r30
            r19 = r3
        L_0x076b:
            r18 = r7
        L_0x076d:
            r3 = 1
        L_0x076e:
            r7 = r29
            r8 = r22
            goto L_0x07d4
        L_0x0774:
            r21 = r1
            r24 = r4
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r1 = r30
            r19 = r3
            r18 = r7
            r3 = 1
            boolean[] r4 = new boolean[r3]     // Catch:{ Exception -> 0x079a }
            r7 = 0
            r4[r7] = r23     // Catch:{ Exception -> 0x079a }
            r7 = r29
            r8 = r22
            r7.z(r1, r0, r8, r4)     // Catch:{ Exception -> 0x0798 }
            goto L_0x07da
        L_0x0798:
            r0 = move-exception
            goto L_0x07d4
        L_0x079a:
            r0 = move-exception
            goto L_0x076e
        L_0x079c:
            r21 = r1
            r24 = r4
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r8 = r22
            r1 = r30
            r19 = r3
            r18 = r7
            r3 = 1
            r7 = r29
            goto L_0x07da
        L_0x07b8:
            r0 = move-exception
            r21 = r1
            r24 = r4
            r25 = r5
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r8 = r22
            r1 = r30
            r19 = r3
            r18 = r7
            r3 = 1
            r7 = r29
        L_0x07d4:
            r4 = 0
        L_0x07d5:
            boolean[] r9 = new boolean[r4]     // Catch:{ Exception -> 0x07f2 }
            com.original.tase.Logger.d(r0, r9)     // Catch:{ Exception -> 0x07f2 }
        L_0x07da:
            r22 = r8
            r7 = r18
            r3 = r19
            r1 = r21
            r4 = r24
            r8 = r26
            r11 = r27
            r14 = r28
            r18 = r5
            r19 = r12
            r5 = r25
            goto L_0x048c
        L_0x07f2:
            r0 = move-exception
            goto L_0x08bf
        L_0x07f5:
            r21 = r1
            r24 = r4
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r1 = r30
            r19 = r3
            r18 = r7
            r3 = 1
            r7 = r29
            goto L_0x088e
        L_0x080e:
            r0 = move-exception
            r21 = r1
            r24 = r4
            r26 = r8
            r27 = r11
            goto L_0x0823
        L_0x0818:
            r0 = move-exception
            r21 = r1
            r24 = r4
            r26 = r8
            r27 = r11
            r20 = r13
        L_0x0823:
            r28 = r14
            r5 = r18
            r12 = r19
            r1 = r30
            r19 = r3
            r18 = r7
            r3 = 1
            r7 = r29
            goto L_0x08bf
        L_0x0834:
            r0 = move-exception
            r7 = r29
            r21 = r1
            r24 = r4
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            r1 = r30
            goto L_0x08ba
        L_0x084b:
            r7 = r29
            r1 = r30
            r24 = r4
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            goto L_0x0889
        L_0x085e:
            r0 = move-exception
            r7 = r29
            r1 = r30
            r24 = r4
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            goto L_0x08ba
        L_0x0872:
            r0 = move-exception
            r1 = r30
            goto L_0x0892
        L_0x0876:
            r1 = r2
            r24 = r4
            r23 = r7
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            r7 = r29
        L_0x0889:
            r19 = r3
            r20 = r13
            r3 = 1
        L_0x088e:
            r2 = 0
            goto L_0x08c5
        L_0x0890:
            r0 = move-exception
            r1 = r2
        L_0x0892:
            r24 = r4
            r23 = r7
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            r7 = r29
            goto L_0x08ba
        L_0x08a5:
            r0 = move-exception
            r24 = r4
            r31 = r5
            r23 = r7
            r26 = r8
            r27 = r11
            r28 = r14
            r5 = r18
            r12 = r19
            r18 = r20
            r7 = r1
            r1 = r2
        L_0x08ba:
            r19 = r3
            r20 = r13
            r3 = 1
        L_0x08bf:
            r2 = 0
        L_0x08c0:
            boolean[] r4 = new boolean[r2]
            com.original.tase.Logger.d(r0, r4)
        L_0x08c5:
            r2 = r1
            r1 = r7
            r3 = r19
            r13 = r20
            r7 = r23
            r4 = r24
            r8 = r26
            r11 = r27
            r14 = r28
            r19 = r12
            r20 = r18
            r18 = r5
            r5 = r31
            goto L_0x0304
        L_0x08df:
            r7 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.VexMovies.J(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo):void");
    }
}

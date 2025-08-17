package com.utils.Getlink.Provider;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.search.SearchHelper;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class ScnSrc extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37431e = Utils.getProvider(96);

    /* renamed from: f  reason: collision with root package name */
    public HashMap f37432f;

    public ScnSrc() {
        HashMap hashMap = new HashMap();
        this.f37432f = hashMap;
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        this.f37432f.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.9,en;q=0.8");
        this.f37432f.put("Upgrade-Insecure-Requests", "1");
        this.f37432f.put("User-Agent", Constants.C);
    }

    private List<String> L(MovieInfo movieInfo, String str, String str2) {
        boolean z2;
        String str3;
        String str4;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str3 = "";
        } else {
            str3 = "S" + com.original.tase.utils.Utils.i(Integer.parseInt(str)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(str2));
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            str4 = TitleHelper.e(movieInfo.getName().replace("'", "")) + " " + movieInfo.getYear();
        } else {
            str4 = TitleHelper.e(movieInfo.getName().replace("'", "")) + " " + str3;
        }
        String.format("%s", new Object[]{com.original.tase.utils.Utils.k(movieInfo.getName().replace(": ", " ") + " " + movieInfo.year, new boolean[0]), com.original.tase.utils.Utils.k(String.valueOf(new Random().nextDouble()), new boolean[0])});
        String str5 = this.f37431e + "/?s=" + com.original.tase.utils.Utils.k(str4, new boolean[0]) + "&x=0&y=0";
        String m2 = HttpHelper.i().m(str5, this.f37432f);
        if (m2.contains("Attention Required! | Cloudflare")) {
            Logger.b("Need Verify Recaptcha", str5);
            Utils.e(str5, BaseProvider.i(str5));
        }
        if (m2.contains("403 Forbidden") || !m2.contains("post")) {
            m2 = HttpHelper.i().m(this.f37431e + "/?s=" + com.original.tase.utils.Utils.k(str4, new boolean[0]) + "&x=12&y=14", this.f37432f);
        }
        if (m2.contains("403 Forbidden") || !m2.contains("post")) {
            m2 = HttpHelper.i().m(this.f37431e + "/?s=" + com.original.tase.utils.Utils.k(str4, new boolean[0]), this.f37432f);
        }
        Iterator it2 = Jsoup.b(m2).q0("div.post").iterator();
        while (it2.hasNext()) {
            try {
                Element r02 = ((Element) it2.next()).r0("a[href][title]");
                if (r02 != null) {
                    String c2 = r02.c("href");
                    String replaceAll = r02.c("title").replaceAll("\\<[uibp]\\>", "").replaceAll("\\</[uibp]\\>", "");
                    String lowerCase = replaceAll.toLowerCase();
                    if (!z2 || (!lowerCase.contains(" cam") && !lowerCase.contains("cam ") && !lowerCase.contains("hdts ") && !lowerCase.contains(" hdts") && !lowerCase.contains(" ts ") && !lowerCase.contains(" telesync") && !lowerCase.contains("telesync ") && !lowerCase.contains("hdtc ") && !lowerCase.contains(" hdtc") && !lowerCase.contains(" tc ") && !lowerCase.contains(" telecine") && !lowerCase.contains("telecine "))) {
                        if (c2.startsWith("/")) {
                            c2 = this.f37431e + c2;
                        }
                        if (replaceAll.toLowerCase().startsWith("goto")) {
                            replaceAll = replaceAll.substring(4, replaceAll.length()).trim();
                        }
                        if (z2) {
                            if (TitleHelper.f(replaceAll).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName() + movieInfo.year)))) {
                                arrayList.add(c2);
                            }
                        } else if (TitleHelper.f(replaceAll).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName()))) && replaceAll.contains(str3)) {
                            arrayList.add(c2);
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
        }
        return arrayList;
    }

    private boolean M(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("sample") || lowerCase.contains("uploadkadeh") || lowerCase.contains("wordpress") || lowerCase.contains("crazy4tv") || lowerCase.contains("imdb.com") || lowerCase.contains("youtube") || lowerCase.contains("userboard") || lowerCase.contains("kumpulbagi") || lowerCase.contains("mexashare") || lowerCase.contains("myvideolink.xyz") || lowerCase.contains("myvideolinks.xyz") || lowerCase.contains("costaction") || lowerCase.contains("crazydl") || lowerCase.contains(".rar") || lowerCase.contains(".avi") || lowerCase.contains(".flv") || lowerCase.contains("ul.to") || lowerCase.contains("safelinking") || lowerCase.contains("linx.") || lowerCase.contains("upload.so") || lowerCase.contains(".zip") || lowerCase.contains("go4up") || lowerCase.contains("adf.ly") || lowerCase.contains(".jpg") || lowerCase.contains(".jpeg") || lowerCase.contains(".png") || lowerCase.contains(".txt") || lowerCase.contains("file-upload.") || lowerCase.contains(".subs") || lowerCase.contains(".7z") || lowerCase.contains(".iso")) {
            return false;
        }
        return true;
    }

    public String A() {
        return "ScnSrc";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            List<String> L = L(movieInfo, "-1", "-1");
            if (L.isEmpty()) {
                L = K(movieInfo, movieInfo.year);
            }
            if (L.isEmpty()) {
                String str = movieInfo.name;
                String str2 = movieInfo.year;
                L = SearchHelper.c(str, str2, str2, this.f37431e, "");
            }
            J(observableEmitter, movieInfo, L, "");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            String str = "S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.eps));
            List<String> L = L(movieInfo, movieInfo.session, movieInfo.eps);
            if (L.isEmpty()) {
                L = K(movieInfo, str);
            }
            if (L.isEmpty()) {
                L = SearchHelper.c(movieInfo.name, movieInfo.year, str, this.f37431e, "");
            }
            J(observableEmitter, movieInfo, L, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r2.equalsIgnoreCase("SD") != false) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r20, com.movie.data.model.MovieInfo r21, java.util.List<java.lang.String> r22, java.lang.String r23) {
        /*
            r19 = this;
            r7 = r19
            java.lang.Integer r0 = r21.getType()
            int r0 = r0.intValue()
            r8 = 1
            if (r0 != r8) goto L_0x0012
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            r9 = r0
            com.original.tase.helper.DirectoryIndexHelper r10 = new com.original.tase.helper.DirectoryIndexHelper
            r10.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r12 = r22.iterator()
            r13 = 0
            r0 = 0
        L_0x0024:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x015f
            java.lang.Object r1 = r12.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "http"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x0049
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.f37431e
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x0049:
            r14 = r1
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r2 = new java.util.Map[r8]
            java.util.HashMap r3 = r7.f37432f
            r2[r13] = r3
            java.lang.String r1 = r1.m(r14, r2)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r1)
            java.lang.String r2 = "div.comm_content"
            org.jsoup.select.Elements r15 = r1.q0(r2)
            r1 = r0
            r6 = 0
        L_0x0064:
            int r0 = r15.size()
            if (r6 >= r0) goto L_0x015c
            java.lang.Object r0 = r15.get(r6)     // Catch:{ all -> 0x014f }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ all -> 0x014f }
            java.lang.String r2 = "a[href]"
            org.jsoup.select.Elements r0 = r0.q0(r2)     // Catch:{ all -> 0x014f }
            java.util.Iterator r16 = r0.iterator()     // Catch:{ all -> 0x014f }
        L_0x007a:
            boolean r0 = r16.hasNext()     // Catch:{ all -> 0x014f }
            if (r0 == 0) goto L_0x014a
            java.lang.Object r0 = r16.next()     // Catch:{ all -> 0x013b }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ all -> 0x013b }
            java.lang.String r2 = "href"
            java.lang.String r3 = r0.c(r2)     // Catch:{ all -> 0x013b }
            if (r9 != 0) goto L_0x00a9
            java.lang.String r0 = "([s|S]\\d+[e|E]\\d+)"
            java.lang.String r0 = com.original.tase.utils.Regex.a(r3, r0, r8)     // Catch:{ all -> 0x013b }
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x013b }
            if (r2 != 0) goto L_0x00a9
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r23.toLowerCase()     // Catch:{ all -> 0x013b }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x013b }
            if (r0 != 0) goto L_0x00a9
            goto L_0x007a
        L_0x00a9:
            boolean r0 = r7.M(r3)     // Catch:{ all -> 0x013b }
            if (r0 == 0) goto L_0x0138
            boolean r0 = r11.contains(r3)     // Catch:{ all -> 0x013b }
            if (r0 != 0) goto L_0x0138
            r11.add(r3)     // Catch:{ all -> 0x013b }
            java.lang.String r0 = ""
            java.lang.String r2 = ".html"
            if (r9 == 0) goto L_0x00c7
            java.lang.String r0 = r14.replace(r2, r0)     // Catch:{ all -> 0x013b }
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r0 = r10.c(r0)     // Catch:{ all -> 0x013b }
            goto L_0x00cf
        L_0x00c7:
            java.lang.String r0 = r14.replace(r2, r0)     // Catch:{ all -> 0x013b }
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r0 = r10.d(r0)     // Catch:{ all -> 0x013b }
        L_0x00cf:
            java.lang.String r2 = r19.A()     // Catch:{ all -> 0x013b }
            java.lang.String r4 = "HQ"
            if (r0 == 0) goto L_0x00e5
            java.lang.String r2 = r0.c()     // Catch:{ all -> 0x013b }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x013b }
            java.lang.String r0 = r7.t(r0)     // Catch:{ all -> 0x013b }
            r5 = r0
            goto L_0x00e7
        L_0x00e5:
            r5 = r2
            r2 = r4
        L_0x00e7:
            boolean r0 = r2.equalsIgnoreCase(r4)     // Catch:{ all -> 0x013b }
            java.lang.String r8 = "SD"
            if (r0 != 0) goto L_0x00f5
            boolean r0 = r2.equalsIgnoreCase(r8)     // Catch:{ all -> 0x013b }
            if (r0 == 0) goto L_0x010b
        L_0x00f5:
            java.lang.String r0 = "1080"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x013b }
            if (r0 == 0) goto L_0x0100
            java.lang.String r0 = "1080p"
            goto L_0x010c
        L_0x0100:
            java.lang.String r0 = "720"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x013b }
            if (r0 == 0) goto L_0x010b
            java.lang.String r0 = "HD"
            goto L_0x010c
        L_0x010b:
            r0 = r2
        L_0x010c:
            boolean r2 = r0.equalsIgnoreCase(r4)     // Catch:{ all -> 0x013b }
            if (r2 != 0) goto L_0x0118
            boolean r2 = r0.equalsIgnoreCase(r8)     // Catch:{ all -> 0x013b }
            if (r2 == 0) goto L_0x011e
        L_0x0118:
            r2 = 40
            if (r1 >= r2) goto L_0x011e
            int r1 = r1 + 1
        L_0x011e:
            r8 = r1
            boolean[] r4 = new boolean[r13]     // Catch:{ all -> 0x0133 }
            r1 = r19
            r2 = r20
            r17 = r4
            r4 = r0
            r18 = r6
            r6 = r17
            r1.x(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0131 }
            r1 = r8
            goto L_0x0143
        L_0x0131:
            r0 = move-exception
            goto L_0x0136
        L_0x0133:
            r0 = move-exception
            r18 = r6
        L_0x0136:
            r1 = r8
            goto L_0x013e
        L_0x0138:
            r18 = r6
            goto L_0x0143
        L_0x013b:
            r0 = move-exception
            r18 = r6
        L_0x013e:
            boolean[] r2 = new boolean[r13]     // Catch:{ all -> 0x0148 }
            com.original.tase.Logger.d(r0, r2)     // Catch:{ all -> 0x0148 }
        L_0x0143:
            r6 = r18
            r8 = 1
            goto L_0x007a
        L_0x0148:
            r0 = move-exception
            goto L_0x0152
        L_0x014a:
            r18 = r6
            int r6 = r18 + 1
            goto L_0x0159
        L_0x014f:
            r0 = move-exception
            r18 = r6
        L_0x0152:
            boolean[] r2 = new boolean[r13]
            com.original.tase.Logger.d(r0, r2)
            r6 = r18
        L_0x0159:
            r8 = 1
            goto L_0x0064
        L_0x015c:
            r0 = r1
            goto L_0x0024
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.ScnSrc.J(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo, java.util.List, java.lang.String):void");
    }

    public List<String> K(MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        String str3;
        if (movieInfo.getSession().intValue() < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap<String, String> b2 = Constants.b();
        b2.put("referer", this.f37431e + "/");
        String m2 = HttpHelper.i().m(GlobalVariable.c().b().getCbflist().get("3"), b2);
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it2 = JsonParser.d(m2).c().m("results").b().iterator();
        while (it2.hasNext()) {
            JsonElement next = it2.next();
            String e2 = next.c().m("post_title").e();
            String e3 = next.c().m("post_name").e();
            next.c().m("domain").e();
            if (z2) {
                if (TitleHelper.f(e2.replaceAll("(?i)(.*)([2-9]0\\d{2}|1[5-9]\\d{2})\\s+(S\\d+\\s*E\\d+)(.*)", "$1$3$4")).startsWith(TitleHelper.f(movieInfo.getName() + str.toLowerCase()))) {
                    if (e3.startsWith("//")) {
                        str3 = "http:" + e3;
                    } else if (e3.startsWith("/")) {
                        str3 = this.f37431e + e3;
                    } else {
                        str3 = this.f37431e + "/" + e3;
                    }
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
            } else {
                if (TitleHelper.h(e2.toLowerCase().replace(movieInfo.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                    if (e3.startsWith("//")) {
                        str2 = "http:" + e3;
                    } else if (e3.startsWith("/")) {
                        str2 = this.f37431e + e3;
                    } else {
                        str2 = this.f37431e + "/" + e3;
                    }
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
        }
        return arrayList;
    }
}

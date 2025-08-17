package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.gson.JsonParser;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class FmovieCloud extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37321e = Utils.getProvider(43);

    public String A() {
        return "FmovieCloud";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            K(observableEmitter, movieInfo, L);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            K(observableEmitter, movieInfo, L);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J(MovieInfo movieInfo, String str, String str2) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            if (TitleHelper.f(str).equals(TitleHelper.f(movieInfo.name + " - Season " + movieInfo.session))) {
                if (str2.startsWith("/")) {
                    str2 = this.f37321e + str2;
                }
                if (Jsoup.b(HttpHelper.i().m(str2, new Map[0])).r0("div.jtip-top").toString().contains(movieInfo.sessionYear)) {
                    return true;
                }
            }
        } else if (TitleHelper.f(str).equals(TitleHelper.f(TitleHelper.e(movieInfo.getName())))) {
            if (str2.startsWith("/")) {
                str2 = this.f37321e + str2;
            }
            if (Jsoup.b(HttpHelper.i().m(str2, new Map[0])).r0("div.jtip-top").toString().contains(movieInfo.year)) {
                return true;
            }
        }
        return false;
    }

    public void K(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        String str3;
        String str4;
        String str5 = str;
        int i2 = 1;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!str5.endsWith("/")) {
            str5 = str5 + "/";
        }
        String str6 = str5 + "watching.html";
        ArrayList arrayList = Regex.f(str6, "-(\\d+)", 1, true).get(0);
        if (!arrayList.isEmpty()) {
            str2 = (String) arrayList.get(arrayList.size() - 1);
        } else {
            str2 = null;
        }
        HashMap<String, String> c2 = Constants.c();
        c2.put("Referer", str6);
        try {
            str3 = new JsonParser().a(HttpHelper.i().m(this.f37321e + "/ajax/movie_episodes/" + str2, c2)).c().m("html").e();
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            str3 = "";
        }
        Iterator it2 = Jsoup.b(str3).q0("div[id*=sv-]").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            element.c("id");
            String c3 = element.c("title");
            String c4 = element.c("data-id");
            element.c("data-server");
            if (!z2) {
                if (Regex.b(c3, "(Episode\\s+0*" + movieInfo.eps + "(?!\\d))", i2, 2).isEmpty()) {
                }
            } else {
                MovieInfo movieInfo2 = movieInfo;
            }
            if (!z2) {
                c3 = "HD";
            }
            HashMap<String, String> c5 = Constants.c();
            c5.put("referer", str6 + "?ep=" + c4);
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", Constants.C);
            Iterator it3 = it2;
            String m2 = HttpHelper.i().m(this.f37321e + "/ajax/movie_embed/" + c4, c5);
            if (!m2.isEmpty() && m2.trim().toLowerCase().contains("src")) {
                String replace = Regex.a(m2, "[\"']?src[\"']?\\s*:\\s*[\"']([^\"']+)", 1).replace("\\/", "/").replace("\\\\", "");
                if (!replace.isEmpty()) {
                    boolean n2 = GoogleVideoHelper.n(replace);
                    hashMap.put("Referer", str6 + "?ep=" + c4);
                    String A = A();
                    if (n2) {
                        str4 = "GoogleVideo";
                    } else {
                        str4 = "CDN-FastServer";
                    }
                    MediaSource mediaSource = new MediaSource(A, str4, o(c3));
                    mediaSource.setStreamLink(replace);
                    mediaSource.setPlayHeader(hashMap);
                    if (n2) {
                        c3 = GoogleVideoHelper.h(replace);
                    }
                    mediaSource.setQuality(c3);
                    observableEmitter.onNext(mediaSource);
                    it2 = it3;
                    i2 = 1;
                }
            }
            ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
            it2 = it3;
            i2 = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String L(com.movie.data.model.MovieInfo r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.name
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "(\\,|\\.|\\')"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replaceAll(r1, r2)
            java.lang.String r1 = "(\\\\\\|/| -|:|;|\\*|\\?|\"|\\'|<|>|\\|)"
            java.lang.String r3 = " "
            java.lang.String r0 = r0.replaceAll(r1, r3)
            java.lang.String r1 = "  "
            java.lang.String r0 = r0.replace(r1, r3)
            java.lang.String r1 = "+"
            java.lang.String r0 = r0.replace(r3, r1)
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r8.f37321e
            r3.append(r4)
            java.lang.String r4 = "/movie/search/"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 0
            java.util.Map[] r3 = new java.util.Map[r3]
            java.lang.String r0 = r1.m(r0, r3)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r1 = "div.movies-list"
            org.jsoup.select.Elements r0 = r0.q0(r1)
            java.lang.String r1 = "div.ml-item"
            org.jsoup.select.Elements r0 = r0.g(r1)
            java.lang.String r1 = "a"
            org.jsoup.select.Elements r0 = r0.g(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x005d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00c4
            java.lang.Object r1 = r0.next()
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
            java.lang.String r3 = "data-url"
            java.lang.String r3 = r1.c(r3)
            java.lang.String r4 = "title"
            java.lang.String r4 = r1.c(r4)
            java.lang.String r5 = r4.toLowerCase()
            java.lang.String r5 = com.original.tase.helper.TitleHelper.h(r5, r2)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r9.name
            java.lang.String r7 = r7.toLowerCase()
            r6.append(r7)
            java.lang.String r7 = r9.year
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = com.original.tase.helper.TitleHelper.h(r6, r2)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a4
            boolean r3 = r8.J(r9, r4, r3)
            if (r3 == 0) goto L_0x005d
        L_0x00a4:
            java.lang.String r9 = "href"
            java.lang.String r9 = r1.c(r9)
            java.lang.String r0 = "/"
            boolean r0 = r9.startsWith(r0)
            if (r0 == 0) goto L_0x00c3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.f37321e
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
        L_0x00c3:
            return r9
        L_0x00c4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.FmovieCloud.L(com.movie.data.model.MovieInfo):java.lang.String");
    }
}

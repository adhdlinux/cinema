package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
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

public class OneMovie extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37402e = Utils.getProvider(91);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str);
        hashMap.put("user-agent", Constants.C);
        String a2 = Regex.a(HttpHelper.i().m(str, hashMap), "\\(\\{\\s*url\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        HashMap<String, String> c2 = Constants.c();
        c2.put("referer", str);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(a2, c2)).q0("ul[class=episodios]").iterator();
        String g2 = HttpHelper.i().g(this.f37402e);
        if (!g2.isEmpty()) {
            hashMap.put("cookie", g2);
        }
        while (it2.hasNext()) {
            Iterator it3 = ((Element) it2.next()).q0("div[class=numerando]").iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Element element = (Element) it3.next();
                if (element.r0(a.f20042a).v0().equals(movieInfo.eps)) {
                    String c3 = element.r0(a.f20042a).c("onclick");
                    String substring = c3.substring(c3.indexOf(UriUtil.HTTP_SCHEME), c3.indexOf(",") - 1);
                    hashMap.put("referer", str);
                    String a3 = Jsoup.b(HttpHelper.i().m(substring, hashMap)).q0("iframe").a("src");
                    hashMap.put("referer", a3);
                    String a4 = Regex.a(HttpHelper.i().o(a3, substring), "<iframe.*src\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
                    if (a4 != null && !a4.isEmpty() && a4.contains(UriUtil.HTTP_SCHEME)) {
                        if (a4.contains("api")) {
                            hashMap.put("referer", a3);
                            hashMap.put("user-agent", Constants.C);
                            a4 = HttpHelper.d(a4, hashMap);
                        }
                        z(observableEmitter, a4, "HD", false);
                    }
                }
            }
        }
    }

    private void K(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        HashMap hashMap = new HashMap();
        if (str.startsWith("/")) {
            str = this.f37402e + str;
        }
        hashMap.put("referer", str);
        hashMap.put("user-agent", Constants.C);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(Regex.a(HttpHelper.i().o(str, this.f37402e + "/"), "\\(\\{\\s*url\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1), hashMap)).q0("ul[class=episodios]").iterator();
        String g2 = HttpHelper.i().g(this.f37402e);
        if (!g2.isEmpty()) {
            hashMap.put("cookie", g2);
        }
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0("div[class=numerando]");
            String v02 = r02.r0(a.f20042a).v0();
            String c2 = r02.r0(a.f20042a).c("onclick");
            String a2 = Jsoup.b(HttpHelper.i().m(c2.substring(c2.indexOf(UriUtil.HTTP_SCHEME), c2.indexOf(",") - 1), hashMap)).q0("iframe").a("src");
            String m2 = HttpHelper.i().m(a2, hashMap);
            ArrayList arrayList = new ArrayList();
            String a3 = Regex.a(m2, "href\\s*=\\s*['\"]([^'\"]*http+[^'\"]*)['\"]>", 1);
            if (!a3.isEmpty()) {
                arrayList.add(a3);
            }
            if (arrayList.size() == 0) {
                arrayList.addAll(Regex.f(m2, "file\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0));
            }
            if (arrayList.size() == 0) {
                arrayList.addAll(Regex.f(m2, "pageUrl*\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0));
            }
            if (arrayList.size() == 0) {
                arrayList.add(Regex.a(m2, "content*\\s*=\\s*['\"]([^'\"]*openload+[^'\"]*)['\"]", 1));
            }
            arrayList.add(Regex.a(m2, "<iframe.*src\\s*=\\s*['\"]([^'\"]+)['\"]", 1));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str2 = (String) it3.next();
                if (str2 != null && !str2.isEmpty() && str2.contains(UriUtil.HTTP_SCHEME)) {
                    if (str2.contains("api")) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("referer", a2);
                        hashMap2.put("user-agent", Constants.C);
                        str2 = HttpHelper.d(str2, hashMap2);
                    }
                    z(observableEmitter, str2, v02, false);
                }
            }
        }
    }

    private String L(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String k2 = BaseProvider.k(HttpHelper.i().m(this.f37402e, new Map[0]), this.f37402e);
        if (movieInfo.name.equalsIgnoreCase("Venom") && movieInfo.getYear().intValue() != 2018) {
            return "";
        }
        String replace = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(String.format(k2, new Object[]{replace}), new Map[0])).q0("div.item").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("oldtitle");
            if (c2.isEmpty()) {
                c2 = element.c("title");
            }
            if (c2.isEmpty()) {
                c2 = element.r0("h2").v0();
            }
            String c3 = element.c("href");
            if (!z2) {
                String lowerCase = c2.toLowerCase();
                if (lowerCase.equals(movieInfo.name.toLowerCase() + ": season " + movieInfo.session)) {
                    return c3;
                }
            } else if (c2.toLowerCase().equals(movieInfo.name.toLowerCase())) {
                return c3;
            }
        }
        String replace2 = TitleHelper.d(movieInfo.name).replace("-", "%20");
        HashMap<String, String> c4 = Constants.c();
        c4.put("referer", this.f37402e);
        HttpHelper i2 = HttpHelper.i();
        String m2 = i2.m(this.f37402e + "/wp-json/dooplay/search/?keyword=" + replace2 + "&nonce=ffec50ad43", c4);
        Iterator it3 = Regex.e(m2, "['\"]?url['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1, 2).get(0).iterator();
        Iterator it4 = Regex.e(m2, "['\"]?title['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1, 2).get(0).iterator();
        Iterator it5 = Regex.e(m2, "['\"]?date['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1, 2).get(0).iterator();
        while (it3.hasNext()) {
            String replace3 = ((String) it3.next()).replace("\\/", "/");
            String str = (String) it4.next();
            String str2 = (String) it5.next();
            if (!z2) {
                String lowerCase2 = str.toLowerCase();
                if (lowerCase2.equals(movieInfo.name.toLowerCase() + ": season " + movieInfo.session) && str2.equals(movieInfo.sessionYear)) {
                    return replace3;
                }
            } else if (str.toLowerCase().equals(movieInfo.name.toLowerCase()) && str2.equals(movieInfo.year)) {
                return replace3;
            }
        }
        return "";
    }

    public String A() {
        return "OneMovie";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            K(observableEmitter, L);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            J(observableEmitter, movieInfo, L);
        }
    }
}

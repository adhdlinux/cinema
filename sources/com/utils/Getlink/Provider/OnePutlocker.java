package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
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
import java.util.Locale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class OnePutlocker extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37403e = Utils.getProvider(104);

    private String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HttpHelper i2 = HttpHelper.i();
        String str = this.f37403e;
        i2.D(str, str);
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("Upgrade-Insecure-Requests", "1");
        hashMap.put("Referer", this.f37403e);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37403e + "/search/?keyword=" + com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+").toLowerCase(), hashMap)).q0("div.ml-item").iterator();
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0(a.f20042a);
            String c2 = r02.c("title");
            if (z2) {
                Locale locale = Locale.ROOT;
                if (TitleHelper.h(c2.toLowerCase(locale), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(locale), ""))) {
                    String c3 = r02.c("href");
                    if (!c3.startsWith("/")) {
                        return c3;
                    }
                    return this.f37403e + c3;
                }
            } else {
                Locale locale2 = Locale.ROOT;
                if (TitleHelper.h(c2.toLowerCase(locale2), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(locale2) + "season" + movieInfo.session, ""))) {
                    String c4 = r02.c("href");
                    if (!c4.startsWith("/")) {
                        return c4;
                    }
                    return this.f37403e + c4;
                }
            }
        }
        return "";
    }

    public String A() {
        return "OnePutlocker";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K, movieInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K, movieInfo);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", str);
        hashMap.put("user-agent", Constants.C);
        Document b2 = Jsoup.b(HttpHelper.i().m(str, hashMap));
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || Regex.a(b2.r0("div.mvic-info").toString(), "(\\d{4})\\s*</a", 1).equals(movieInfo.year)) {
            Iterator it2 = b2.q0("div.les-content").g("a[data-src]").iterator();
            new ArrayList();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (!z2) {
                    String c2 = element.c("title");
                    if (c2 != null && !c2.isEmpty()) {
                        if (!c2.toLowerCase(Locale.ROOT).equals("episode " + movieInfo.eps)) {
                        }
                    }
                }
                String c3 = element.c("data-src");
                String a2 = Regex.a(c3, "\\?id=(.*)", 1);
                if (!c3.isEmpty()) {
                    String a3 = Regex.a(HttpHelper.i().o(c3, this.f37403e + "/"), "\\s*location\\s*=\\s*['\"]([^'\"]+)['\"]\\s*\\+", 1);
                    if (!a3.isEmpty()) {
                        ArrayList<String> g2 = Regex.g(HttpHelper.i().m((a3 + a2).replace("playerw", "streamw"), Constants.c()), "link['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true);
                        for (int i2 = 0; i2 < g2.size(); i2++) {
                            z(observableEmitter, g2.get(i2).replace("\\/", "/"), "HD", false);
                        }
                    }
                }
            }
        }
    }
}

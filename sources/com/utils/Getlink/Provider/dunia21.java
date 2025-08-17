package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class dunia21 extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37515e = Utils.getProvider(88);

    private void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.o(str, this.f37515e + "/")).q0("div#load-sources").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("href");
            String a2 = Regex.a(element.toString(), "(\\d{3,4})", 1);
            if (a2.isEmpty()) {
                a2 = "HD";
            }
            String a3 = Regex.a(c2, "\\?url=(.*)", 1);
            if (!a3.isEmpty()) {
                String replace = com.original.tase.utils.Utils.b(a3).replace("filemoon.sx", "furher.in");
                HashMap hashMap = new HashMap();
                if (replace.contains("furher")) {
                    hashMap.put("Referer", BaseProvider.j(c2));
                } else {
                    hashMap.put("Referer", BaseProvider.j(replace));
                }
                MediaSource mediaSource = new MediaSource(A(), "CDN", false);
                mediaSource.setPlayHeader(hashMap);
                mediaSource.setStreamLink(replace);
                mediaSource.setQuality(a2);
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        HttpHelper.i().m(this.f37515e, new Map[0]);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37515e + "/search.php?s=" + com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+"), new Map[0])).q0("div[class=search-item]").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("href");
            String h2 = TitleHelper.h(element.c("title").toLowerCase(), "");
            if (h2.equals(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, ""))) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37515e + c2;
            }
        }
        return "";
    }

    public String A() {
        return "Dunia21";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String a2 = Utils.a();
        if (a2.toLowerCase().equals("id") || a2.toLowerCase().equals("idn")) {
            String K = K(movieInfo);
            if (!K.isEmpty()) {
                J(movieInfo, observableEmitter, K);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}

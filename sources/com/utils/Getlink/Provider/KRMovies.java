package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
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

public class KRMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37354e = Utils.getProvider(21);

    /* renamed from: f  reason: collision with root package name */
    String f37355f = "HD";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("upgrade-insecure-requests", "1");
        hashMap.put("referer", this.f37354e + "/");
        hashMap.put("user-agent", Constants.C);
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        if (!z2) {
            str = str + String.format("%s-%s/", new Object[]{movieInfo.session, movieInfo.eps});
        }
        String a2 = Regex.a(HttpHelper.i().m(str, hashMap), "['\"]?pl_url['\"]?\\s*[:=]\\s*['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            Iterator it2 = Jsoup.b(HttpHelper.i().m(a2, new Map[0])).q0("div.detail_page-servers").g("a[data-srv][data-id]").iterator();
            while (it2.hasNext()) {
                String c2 = ((Element) it2.next()).c("data-id");
                if (!c2.isEmpty()) {
                    String d2 = HttpHelper.d(c2, hashMap);
                    if (!d2.isEmpty()) {
                        z(observableEmitter, d2, "HD", false);
                    }
                }
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it2 = Jsoup.b(HttpHelper.i().m(String.format(this.f37354e + "/search?keyword=%s", new Object[]{com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0])}), new Map[0])).q0("div.film_list-wrap").g("div.film-detail").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0(a.f20042a).c("title");
            if (!c2.isEmpty()) {
                if (z2) {
                    String a2 = Regex.a(element.toString(), ">\\s*(\\d{4})\\s*<", 1);
                    if (TitleHelper.h(c2.toLowerCase(), "").contains(TitleHelper.h(movieInfo.getName().toLowerCase(), "")) && a2.equals(movieInfo.year)) {
                        return element.r0(a.f20042a).c("href");
                    }
                } else {
                    String a3 = Regex.a(element.toString(), "([sS][sS]\\s*\\d+)", 1);
                    if (TitleHelper.h(c2.toLowerCase(), "").contains(TitleHelper.h(movieInfo.getName().toLowerCase(), "")) && !a3.isEmpty()) {
                        return element.r0(a.f20042a).c("href");
                    }
                }
            }
        }
        return "";
    }

    public String A() {
        return "KRMovies";
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
}

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
import java.util.HashMap;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class MovieGL extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37384e = Utils.getProvider(66);

    /* renamed from: f  reason: collision with root package name */
    private String f37385f = "HD";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap<String, String> c2 = Constants.c();
        c2.put("User-Agent", Constants.C);
        String m2 = HttpHelper.i().m(str, c2);
        String a2 = Regex.a(m2, "data-streamkey['\"]?\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
        String a3 = Regex.a(m2, "data-nonce['\"]?\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
        if (!a2.isEmpty() && !a3.isEmpty()) {
            HttpHelper i2 = HttpHelper.i();
            Iterator<String> it2 = Regex.g(i2.l(this.f37384e + "/wp-admin/admin-ajax.php", String.format("action=ajax_getlinkstream&streamkey=%s&nonce=%s&imdbid=%s&tmdbid=", new Object[]{a2, a3, movieInfo.imdbIDStr}), c2).replace("\\/", "/"), "(?:streamsvr|hydrax|onestream|\\w+)['\"]:['\"]([^'\"]+)['\"]", 1, false).iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next.startsWith(UriUtil.HTTP_SCHEME)) {
                    z(observableEmitter, next, this.f37385f, false);
                }
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        movieInfo.getType().intValue();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        String replace = com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("%20", "+");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37384e + "/?s=" + replace.toLowerCase(), hashMap)).q0("div.ml-item").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("href");
            if (TitleHelper.h(element.c("title").toLowerCase(), "").equals(TitleHelper.h(movieInfo.getName().toLowerCase() + movieInfo.year, ""))) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37384e + c2;
            }
        }
        return "";
    }

    public String A() {
        return "MovieGL";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K + "-season-" + movieInfo.session + "-episode-" + movieInfo.eps);
        }
    }
}

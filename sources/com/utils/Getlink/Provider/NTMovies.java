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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class NTMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37390e = Utils.getProvider(36);

    /* renamed from: f  reason: collision with root package name */
    public String f37391f = "HD";

    public String A() {
        return "NTMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K, movieInfo);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        String o2 = HttpHelper.i().o(str + "/season/" + movieInfo.session + "/e/" + com.original.tase.utils.Utils.i(movieInfo.getEps().intValue()), str);
        Iterator it2 = Jsoup.b(o2).q0("ul.links").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            z(observableEmitter, ((Element) it2.next()).c("href"), "HD", false);
        }
        Iterator it3 = Regex.f(o2, "data-src\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0).iterator();
        while (it3.hasNext()) {
            z(observableEmitter, (String) it3.next(), "HD", false);
        }
    }

    public String K(MovieInfo movieInfo) {
        HashMap<String, String> c2 = Constants.c();
        c2.put("referer", this.f37390e + "/");
        HttpHelper i2 = HttpHelper.i();
        String m2 = i2.m(this.f37390e + "/serieslist", c2);
        Iterator it2 = Regex.f(m2, "['\"]?id['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true).get(0).iterator();
        Iterator it3 = Regex.f(m2, "['\"]?titulo['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true).get(0).iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            String str2 = (String) it2.next();
            if (str.toLowerCase().equals(movieInfo.name.toLowerCase())) {
                return this.f37390e + "/serie/" + str2 + "-" + TitleHelper.h(str.toLowerCase(), "-");
            }
        }
        return "";
    }
}

package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class AnimeShow extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37244e = (Utils.getProvider(85) + "/");

    public String A() {
        return "AnimeShow";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(movieInfo, K, observableEmitter, "1", false);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(movieInfo, K, observableEmitter, movieInfo.eps, false);
        }
    }

    public String J(MovieInfo movieInfo, String str, ObservableEmitter<? super MediaSource> observableEmitter, String str2, boolean z2) {
        movieInfo.getSession().intValue();
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("div[class=e_l_r]").iterator();
        while (it2.hasNext()) {
            String c2 = ((Element) it2.next()).r0(a.f20042a).c("href");
            if (!c2.isEmpty()) {
                if (!c2.contains("-episode-" + str2 + "/")) {
                    if (c2.contains("-episode-" + str2 + "-")) {
                    }
                }
                String a2 = Jsoup.b(HttpHelper.i().m(c2, new Map[0])).q0("iframe[class=embed-responsive-item]").a("src");
                if (!a2.isEmpty()) {
                    MediaSource mediaSource = new MediaSource(A(), "", false);
                    mediaSource.setStreamLink(a2);
                    mediaSource.setQuality("HQ");
                    observableEmitter.onNext(mediaSource);
                }
                if (c2.endsWith("/")) {
                    c2 = c2.substring(0, c2.length() - 1);
                }
                String str3 = c2 + "-mirror-2/";
                String a3 = Jsoup.b(HttpHelper.i().m(str3, new Map[0])).q0("iframe[class=embed-responsive-item]").a("src");
                if (!a3.isEmpty()) {
                    MediaSource mediaSource2 = new MediaSource(A(), "", false);
                    mediaSource2.setStreamLink(a3);
                    mediaSource2.setQuality("HD");
                    observableEmitter.onNext(mediaSource2);
                }
                return str3;
            }
        }
        return "";
    }

    public String K(MovieInfo movieInfo) {
        boolean z2;
        if (!f(movieInfo.genres)) {
            return "";
        }
        if (movieInfo.name.toLowerCase().equals("steins;gate") && movieInfo.getSessionYear().intValue() == 2018) {
            movieInfo.name += " 0";
        }
        if (movieInfo.getSession().intValue() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Boolean valueOf = Boolean.valueOf(z2);
        String replace = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37244e + "find.html?key=" + replace, new Map[0])).q0("div[class=genres_result]").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0("a[href]").c("href");
            if (c2.isEmpty()) {
                return "";
            }
            String v02 = element.r0("div[class=genres_result_dates]").v0();
            String v03 = element.r0("div[class=genres_result_title]").v0();
            if (valueOf.booleanValue()) {
                if (v03.equals(movieInfo.name + " Season " + movieInfo.session) || (movieInfo.name.equalsIgnoreCase(v03) && v02.contains(movieInfo.sessionYear))) {
                    return c2;
                }
            } else if (movieInfo.name.toLowerCase().equals(v03.toLowerCase()) && v02.contains(movieInfo.year)) {
                return c2;
            }
        }
        return "";
    }
}

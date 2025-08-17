package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.trakt5.TraktV2;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class CMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37274e = Utils.getProvider(49);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        String str2;
        String str3;
        String str4;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String a2 = Regex.a(HttpHelper.i().m(str, new Map[0]), "['\"]?data-id['\"]?\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            HashMap<String, String> c2 = Constants.c();
            c2.put("accept", "application/json, text/javascript, */*; q=0.01");
            c2.put("content-type", TraktV2.CONTENT_TYPE_JSON);
            c2.put("referer", str);
            if (!z2) {
                String a3 = Regex.a(HttpHelper.i().m(this.f37274e + "/ajax/season/list/" + a2, c2), String.format("<a[^>]+data-id=['\"]([^'\"]+)['\"][^>]*>\\s*[S|s]eason\\s*%s\\s*<", new Object[]{movieInfo.session}), 1);
                if (!a3.isEmpty()) {
                    Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37274e + "/ajax/season/episodes/" + a3, c2)).q0("li.nav-item").g(a.f20042a).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            str4 = "";
                            break;
                        }
                        Element element = (Element) it2.next();
                        if (!Regex.a(element.c("title"), String.format("([E|e]ps\\s*%s\\s*):", new Object[]{movieInfo.eps}), 1).isEmpty()) {
                            str4 = element.c("data-id");
                            break;
                        }
                    }
                    if (!str4.isEmpty()) {
                        str2 = HttpHelper.i().m(this.f37274e + "/ajax/episode/servers/" + str4, c2);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                str2 = HttpHelper.i().m(this.f37274e + "/ajax/episode/list/" + a2, c2);
            }
            Iterator it3 = Jsoup.b(str2).q0("li.nav-item").g(a.f20042a).iterator();
            while (it3.hasNext()) {
                Element element2 = (Element) it3.next();
                if (z2) {
                    str3 = element2.c("data-linkid");
                } else {
                    str3 = element2.c("data-id");
                }
                if (!str3.isEmpty()) {
                    String a4 = Regex.a(HttpHelper.i().m(this.f37274e + "/ajax/episode/sources/" + str3, c2), "['\"]?(?:url|src|link)['\"]?\\s*[=|:]\\s*['\"]([^'\"]+)['\"]", 1);
                    if (!a4.isEmpty()) {
                        MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                        mediaSource.setStreamLink(a4);
                        mediaSource.setPlayHeader(c2);
                        mediaSource.setQuality("HD");
                        observableEmitter.onNext(mediaSource);
                    }
                } else {
                    return;
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
        String replace = com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("+", "-");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37274e + "/search/" + replace, new Map[0])).q0("div.flw-item").g("div.film-detail").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0(a.f20042a).c("title");
            if (!c2.isEmpty()) {
                if (z2) {
                    String a2 = Regex.a(element.toString(), ">\\s*(\\d{4})\\s*<", 1);
                    if (TitleHelper.h(c2.toLowerCase(), "").contains(TitleHelper.h(movieInfo.getName().toLowerCase(), "")) && a2.equals(movieInfo.year)) {
                        String c3 = element.r0(a.f20042a).c("href");
                        if (!c3.startsWith("/")) {
                            return c3;
                        }
                        return this.f37274e + c3;
                    }
                } else {
                    String a3 = Regex.a(element.toString(), ">\\s*([sS]\\s*\\d+)\\s*<", 1);
                    if (TitleHelper.h(c2.toLowerCase(), "").contains(TitleHelper.h(movieInfo.getName().toLowerCase(), "")) && !a3.isEmpty()) {
                        String c4 = element.r0(a.f20042a).c("href");
                        if (!c4.startsWith("/")) {
                            return c4;
                        }
                        return this.f37274e + c4;
                    }
                }
            }
        }
        return "";
    }

    public String A() {
        return "CMovies";
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

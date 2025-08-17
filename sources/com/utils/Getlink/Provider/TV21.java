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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class TV21 extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37466e = Utils.getProvider(81);

    public String A() {
        return "TV21";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            J(observableEmitter, movieInfo, L);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            K(observableEmitter, movieInfo, L);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        movieInfo.getType().intValue();
        String a2 = Regex.a(HttpHelper.i().o(str, str), "data-id\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        ArrayList arrayList = new ArrayList();
        if (!a2.isEmpty()) {
            Iterator it2 = Jsoup.b(HttpHelper.i().o(this.f37466e + "/ajax/movie/episodes/" + a2, str)).q0("div.detail_page-servers").g("li.nav-item").iterator();
            while (it2.hasNext()) {
                try {
                    Element r02 = ((Element) it2.next()).r0(a.f20042a);
                    String c2 = r02.c("href");
                    String c3 = r02.c("data-linkid");
                    if (!c3.isEmpty()) {
                        if (c2.startsWith("/")) {
                            c2 = this.f37466e + c2;
                        }
                        HashMap<String, String> c4 = Constants.c();
                        c4.put("referer", c2);
                        String a3 = Regex.a(HttpHelper.i().m(this.f37466e + "/ajax/sources/" + c3, c4), "[\"']link[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
                        if (!a3.isEmpty()) {
                            if (a3.startsWith("//")) {
                                a3 = "https:" + a3;
                            }
                            if (!arrayList.contains(a3)) {
                                arrayList.add(a3);
                                if (HandleMore.a(a3)) {
                                    for (String streamLink : HandleMore.c(a3, str)) {
                                        MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                                        mediaSource.setStreamLink(streamLink);
                                        mediaSource.setQuality("HD");
                                        observableEmitter.onNext(mediaSource);
                                    }
                                } else if (HandleMore.b(a3)) {
                                    for (String streamLink2 : HandleMore.d(a3, str)) {
                                        MediaSource mediaSource2 = new MediaSource(A(), "CDN-FastServer", false);
                                        mediaSource2.setStreamLink(streamLink2);
                                        mediaSource2.setQuality("HD");
                                        observableEmitter.onNext(mediaSource2);
                                    }
                                } else {
                                    z(observableEmitter, a3, "HD", false);
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void K(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        movieInfo.getType().intValue();
        String a2 = Regex.a(HttpHelper.i().o(str, str), "data-id\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        ArrayList arrayList = new ArrayList();
        if (!a2.isEmpty()) {
            Iterator it2 = Jsoup.b(HttpHelper.i().o(this.f37466e + "/ajax/v2/tv/seasons/" + a2, str)).q0("div.slt-seasons-dropdown").g("a[data-id]").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                try {
                    Element element = (Element) it2.next();
                    if (TitleHelper.h(element.v0().toLowerCase(Locale.ROOT), "").equals(TitleHelper.h("season" + movieInfo.session, ""))) {
                        String c2 = element.c("data-id");
                        it2 = Jsoup.b(HttpHelper.i().o(this.f37466e + "/ajax/v2/season/episodes/" + c2, str)).q0("li.nav-item").iterator();
                        break;
                    }
                } catch (Throwable unused) {
                }
            }
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                try {
                    Element r02 = ((Element) it2.next()).r0(a.f20042a);
                    if (r02.c("title").startsWith("Eps " + movieInfo.eps + ":")) {
                        String c3 = r02.c("data-id");
                        it2 = Jsoup.b(HttpHelper.i().o(this.f37466e + "/ajax/v2/episode/servers/" + c3, str)).q0("li.nav-item").iterator();
                        break;
                    }
                } catch (Throwable unused2) {
                }
            }
            while (it2.hasNext()) {
                try {
                    Element r03 = ((Element) it2.next()).r0(a.f20042a);
                    r03.c("href");
                    String c4 = r03.c("data-id");
                    if (!c4.isEmpty()) {
                        HashMap<String, String> c5 = Constants.c();
                        c5.put("referer", str);
                        String a3 = Regex.a(HttpHelper.i().m(this.f37466e + "/ajax/sources/" + c4, c5), "[\"']link[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
                        if (!a3.isEmpty()) {
                            if (a3.startsWith("//")) {
                                a3 = "https:" + a3;
                            }
                            if (!arrayList.contains(a3)) {
                                arrayList.add(a3);
                                if (HandleMore.a(a3)) {
                                    for (String streamLink : HandleMore.c(a3, str)) {
                                        MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                                        mediaSource.setStreamLink(streamLink);
                                        mediaSource.setQuality("HD");
                                        observableEmitter.onNext(mediaSource);
                                    }
                                } else if (HandleMore.b(a3)) {
                                    for (String streamLink2 : HandleMore.d(a3, str)) {
                                        MediaSource mediaSource2 = new MediaSource(A(), "CDN-FastServer", false);
                                        mediaSource2.setStreamLink(streamLink2);
                                        mediaSource2.setQuality("HD");
                                        observableEmitter.onNext(mediaSource2);
                                    }
                                } else {
                                    z(observableEmitter, a3, "HD", false);
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public String L(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.o(this.f37466e + "/search/" + TitleHelper.h(movieInfo.name.toLowerCase(), "-"), this.f37466e + "/")).q0("div.film-detail").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0(a.f20042a).c("title");
            if (z2) {
                String a2 = Regex.a(element.toString(), "(\\d{4})\\s*<", 1);
                if (movieInfo.name.equalsIgnoreCase(c2) && movieInfo.year.equalsIgnoreCase(a2)) {
                    String c3 = element.r0(a.f20042a).c("href");
                    if (!c3.startsWith("/")) {
                        return c3;
                    }
                    return this.f37466e + c3;
                }
            } else {
                Locale locale = Locale.ROOT;
                if (TitleHelper.h(c2.toLowerCase(locale), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(locale), "")) && !element.r0("span.fdi-item").v0().isEmpty()) {
                    String c4 = element.r0(a.f20042a).c("href");
                    if (!c4.startsWith("/")) {
                        return c4;
                    }
                    return this.f37466e + c4;
                }
            }
        }
        return "";
    }
}

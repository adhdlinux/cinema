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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class WatchMovieHD extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37490e = Utils.getProvider(54);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f37491f = new HashMap();

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        String a2 = Regex.a(HttpHelper.i().o(str, str), "data-id\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        ArrayList arrayList = new ArrayList();
        if (!a2.isEmpty()) {
            Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37490e + "/ajax/movie/episodes/" + a2, this.f37491f)).q0("ul").g("li").iterator();
            while (it2.hasNext()) {
                try {
                    Element r02 = ((Element) it2.next()).r0(a.f20042a);
                    String c2 = r02.c("href");
                    String c3 = r02.c("data-id");
                    if (!c3.isEmpty()) {
                        boolean startsWith = c2.startsWith("/");
                        HashMap<String, String> c4 = Constants.c();
                        c4.put("referer", "https://flixtor.gg/");
                        String a3 = Regex.a(HttpHelper.i().m(this.f37490e + "/ajax/sources/" + c3, c4), "[\"']link[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
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

    public String A() {
        return "WatchMovieHD";
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
    }

    public String K(MovieInfo movieInfo) {
        this.f37491f.put("referer", "https://flixtor.gg/");
        this.f37491f.put("accept", "*/*");
        this.f37491f.put("upgrade-insecure-requests", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37490e + "/search/" + TitleHelper.h(movieInfo.name.toLowerCase(), "-"), this.f37491f)).q0("div.flw-item").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            Element r02 = element.r0(a.f20042a);
            String c2 = r02.c("href");
            String c3 = r02.c("title");
            String a2 = Regex.a(element.toString(), ">\\s*(\\d{4})\\s*<", 1);
            if (c3.equalsIgnoreCase(movieInfo.name) && movieInfo.year.equalsIgnoreCase(a2)) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37490e + c2;
            }
        }
        return "";
    }
}

package com.utils.Getlink.Provider;

import com.google.android.gms.cast.HlsSegmentFormat;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class ClickMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37283e = Utils.getProvider(116);

    /* renamed from: f  reason: collision with root package name */
    private String f37284f = "HD";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        boolean z3;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        if (this.f37284f.toLowerCase().contains(HlsSegmentFormat.TS) || this.f37284f.toLowerCase().contains("cam")) {
            this.f37284f = "CAM";
        }
        String m2 = HttpHelper.i().m(str, hashMap);
        if (!z2) {
            Iterator it2 = Jsoup.b(m2).q0("div#list-eps").g("a.btn-eps").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                Element element = (Element) it2.next();
                String v02 = element.v0();
                Locale locale = Locale.ROOT;
                if (!v02.toLowerCase(locale).equals("episode " + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.eps)))) {
                    if (!v02.toLowerCase(locale).equals("episode " + movieInfo.eps) && !v02.toLowerCase(locale).equals(movieInfo.eps)) {
                    }
                }
                String c2 = element.c("href");
                if (c2.startsWith("/")) {
                    m2 = HttpHelper.i().m(this.f37283e + c2, hashMap);
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                return;
            }
        }
        Iterator it3 = Jsoup.b(m2).q0("div.list-eps-link").g("a[data-file]").iterator();
        while (it3.hasNext()) {
            String c3 = ((Element) it3.next()).c("data-file");
            if (!c3.isEmpty()) {
                z(observableEmitter, c3, this.f37284f, false);
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        boolean z2 = true;
        if (movieInfo.getType().intValue() != 1) {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Upgrade-Insecure-Requests", "1");
        hashMap.put("Host", this.f37283e.replace("https://", "").replace("http://", ""));
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37283e + "/search/" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("+", "%20"), new Map[0])).q0("div.movies-list").g("div.ml-item").g("a[href]").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (z2) {
                this.f37284f = element.r0("span.mli-quality").v0();
            } else {
                this.f37284f = "HD";
            }
            String h2 = element.q0("span.mli-info").h();
            String c2 = element.c("href");
            if (z2) {
                Locale locale = Locale.ROOT;
                if (TitleHelper.h(h2.toLowerCase(locale), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(locale) + movieInfo.year, ""))) {
                    if (!c2.startsWith("/")) {
                        return c2;
                    }
                    return this.f37283e + c2;
                }
            } else {
                Locale locale2 = Locale.ROOT;
                if (TitleHelper.h(h2.toLowerCase(locale2), "").startsWith(TitleHelper.h(movieInfo.name.toLowerCase(locale2) + "season" + movieInfo.session, ""))) {
                    if (!c2.startsWith("/")) {
                        return c2;
                    }
                    return this.f37283e + c2;
                }
            }
        }
        return "";
    }

    public String A() {
        return "ClickMovies";
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
            J(observableEmitter, movieInfo, K);
        }
    }
}

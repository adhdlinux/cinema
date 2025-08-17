package com.utils.Getlink.Provider;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class WatchEpisodes extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37488e = Utils.getProvider(77);

    public String A() {
        return "WatchEpisodes";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        boolean z2;
        String str;
        JsonElement m2;
        String m3 = HttpHelper.i().m(this.f37488e + "/search/ajax_search?q=" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]), Constants.c());
        if (!m3.toLowerCase().contains("series")) {
            this.f37488e = "https://watchepisodes.unblocked.mx";
            m3 = HttpHelper.i().m(this.f37488e + "/search/ajax_search?q=" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]), Constants.c());
            if (!m3.toLowerCase().contains("series")) {
                this.f37488e = "https://watchepisodes.bypassed.org";
                m3 = HttpHelper.i().m(this.f37488e + "/search/ajax_search?q=" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]), Constants.c());
                if (!m3.toLowerCase().contains("series")) {
                    this.f37488e = "https://watchepisodes.bypassed.bz";
                    m3 = HttpHelper.i().m(this.f37488e + "/search/ajax_search?q=" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]), Constants.c());
                }
            }
        }
        JsonElement a2 = new JsonParser().a(m3);
        String str2 = "";
        if (a2 == null || !a2.i() || (m2 = a2.c().m("series")) == null || !m2.g()) {
            str = str2;
        } else {
            Iterator<JsonElement> it2 = m2.b().iterator();
            String str3 = str2;
            while (it2.hasNext()) {
                JsonElement next = it2.next();
                if (next.i()) {
                    JsonObject c2 = next.c();
                    JsonElement m4 = c2.m("label");
                    JsonElement m5 = c2.m("seo");
                    if (!(m4 == null || m4.h() || m4.e() == null || m5 == null || m5.h() || m5.e() == null || !TitleHelper.f(m4.e()).equals(TitleHelper.f(movieInfo.getName())))) {
                        str2 = this.f37488e + "/" + m5.e();
                        str3 = HttpHelper.i().m(str2, new Map[0]);
                        String b2 = Regex.b(str3, "<span>\\s*Year\\s*:\\s*</span>.*?<a[^>]*>\\s*(\\d{4})\\s*</a>", 1, 34);
                        if (b2.isEmpty() || !com.original.tase.utils.Utils.o(b2) || movieInfo.getSessionYear().intValue() <= 0 || Integer.parseInt(b2.trim()) == movieInfo.getSessionYear().intValue()) {
                            str = str2;
                            str2 = str3;
                            z2 = true;
                            break;
                        }
                    }
                }
            }
            str = str2;
            str2 = str3;
        }
        z2 = false;
        if (str.isEmpty() || str2.isEmpty() || !z2) {
            str2 = HttpHelper.i().m(this.f37488e + "/" + TitleHelper.g(movieInfo.getName()), new Map[0]);
        }
        if (!str2.isEmpty()) {
            String a3 = Regex.a(str2, "href=\"([^\"]*-[sS]" + com.original.tase.utils.Utils.i(movieInfo.getSession().intValue()) + "[eE]" + com.original.tase.utils.Utils.i(movieInfo.getEps().intValue()) + "(?!\\d)[^\"]*)", 1);
            if (a3.startsWith("/")) {
                a3 = this.f37488e + a3;
            }
            Iterator it3 = Jsoup.b(HttpHelper.i().m(a3, new Map[0])).q0("div[class*=\"ldr-item\"]").iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                Element element = (Element) it3.next();
                if (!observableEmitter.isDisposed()) {
                    Element r02 = element.r0("a[data-actuallink*=\"http\"]");
                    if (r02 != null) {
                        z(observableEmitter, r02.c("data-actuallink"), "HQ", new boolean[0]);
                    }
                    i2++;
                    if (i2 > 20) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }
}

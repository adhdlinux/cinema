package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GoGoAnime extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37326e = Utils.getProvider(102);

    /* renamed from: f  reason: collision with root package name */
    private String f37327f;

    /* renamed from: g  reason: collision with root package name */
    private String f37328g;

    public GoGoAnime() {
        String str = this.f37326e + "/";
        this.f37327f = str;
        this.f37328g = str;
    }

    public String A() {
        return "GoGoAnime";
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

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        boolean z3;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html, */*; q=0.01");
        hashMap.put("Origin", this.f37326e);
        hashMap.put("referer", this.f37328g);
        hashMap.put("user-agent", Constants.C);
        Document b2 = Jsoup.b(HttpHelper.i().m(str, hashMap));
        Element r02 = b2.r0("div[class=anime_info_episodes_next]");
        String c2 = r02.r0("input[id=movie_id]").c(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        String c3 = r02.r0("input[id=default_ep]").c(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        String c4 = r02.r0("input[id=alias_anime]").c(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Element r03 = b2.r0("div[class=anime_video_body]").r0("ul[id=episode_page]").r0(a.f20042a);
        Document b3 = Jsoup.b(HttpHelper.i().m("https://ajax.apimovie.xyz/ajax/load-list-episode?ep_start=" + r03.c("ep_start") + "&ep_end=" + r03.c("ep_end") + "&id=" + c2 + "&default_ep=" + c3 + "&alias=" + c4 + "##forceNoCache##", hashMap));
        if (z2) {
            str = b3.r0("ul[id=episode_related]").r0("a[href]").c("href");
            if (str.startsWith("/") || str.startsWith(" /")) {
                str = this.f37326e + str.replace(" /", "/");
            }
        } else {
            Iterator it2 = b3.q0("ul[id=episode_related]").g("a[href]").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                Element element = (Element) it2.next();
                String c5 = element.c("href");
                if (element.r0("div[class=name]").v0().equalsIgnoreCase("EP " + movieInfo.eps)) {
                    if (c5.startsWith("/") || c5.startsWith(" /")) {
                        c5 = this.f37326e + c5.replace(" /", "/");
                    }
                    str = c5;
                    z3 = true;
                } else {
                    str = c5;
                }
            }
            if (!z3) {
                return;
            }
        }
        Iterator it3 = Jsoup.b(HttpHelper.i().m(str, hashMap)).q0("div[class=anime_muti_link]").g("li").iterator();
        while (it3.hasNext()) {
            String c6 = ((Element) it3.next()).r0("a[data-video]").c("data-video");
            if (c6.startsWith("//")) {
                c6 = "https:" + c6;
            }
            z(observableEmitter, c6, "HD", false);
        }
    }

    public String K(MovieInfo movieInfo) {
        if (!f(movieInfo.genres)) {
            return "";
        }
        HttpHelper.i().m(this.f37326e, new Map[0]);
        String k2 = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]);
        this.f37328g = this.f37327f + "/search.html?keyword=" + k2;
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37327f);
        hashMap.put("Cookie", HttpHelper.i().g(this.f37326e));
        hashMap.put("user-agent", Constants.C);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37328g, hashMap)).q0("div[class=last_episodes]").g("li").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0(a.f20042a).c("href");
            String v02 = element.r0("p[class=name]").r0(a.f20042a).v0();
            String v03 = element.r0("p[class=released]").v0();
            String replaceAll = v02.replaceAll("([ ]*Movie.*[0-9]+)", "");
            String replaceAll2 = v02.replaceAll("([ ]*Movie.*[0-9].*(The)+)", ":");
            if ((replaceAll.equalsIgnoreCase(movieInfo.name) || replaceAll2.equalsIgnoreCase(movieInfo.name)) && v03.contains(movieInfo.year)) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37326e + c2;
            }
        }
        return "";
    }
}

package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Fmovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37322e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f37323f = Utils.getProvider(59);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String a2 = Regex.a(str, "\\w+-(\\d+)", 1);
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str + "?play=1");
        HttpHelper i2 = HttpHelper.i();
        try {
            Iterator it2 = Jsoup.b(new JSONObject(i2.m(this.f37323f + String.format("/ajax/film/servers/%s?play=1&ts=%s&_=646", new Object[]{a2, this.f37322e}), hashMap)).getString("html")).q0("div[data-type][data-id]").iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                String c2 = element.c("data-id");
                String c3 = element.r0("a[data-id]").c("data-id");
                if (c3.contains("html")) {
                    z(observableEmitter, c3, "HQ", new boolean[0]);
                } else {
                    HttpHelper i3 = HttpHelper.i();
                    String a3 = Regex.a(i3.m(this.f37323f + String.format("/ajax/episode/info?ts=%s&_=694&id=%s&server=%s", new Object[]{this.f37322e, c3, c2}), hashMap), "target['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
                    if (!a3.isEmpty()) {
                        z(observableEmitter, a3, "HD", false);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String A() {
        return "Fmovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    public String K(MovieInfo movieInfo) {
        movieInfo.getType().intValue();
        this.f37322e = Regex.a(HttpHelper.i().m(this.f37323f, new Map[0]), "data-ts=['\"]([^'\"]+)['\"]", 1);
        HashMap<String, String> c2 = Constants.c();
        String format = String.format(this.f37323f + "/ajax/film/search?ts=%s&_=694&sort=year:desc&keyword=%s", new Object[]{this.f37322e, TitleHelper.h(movieInfo.name, "+")});
        c2.put("referer", this.f37323f + "/");
        c2.put(TheTvdb.HEADER_ACCEPT, "application/json, text/javascript, */*; q=0.01");
        c2.put("upgrade-insecure-requests", "1");
        c2.put("user-agent", Constants.C);
        try {
            Iterator it2 = Jsoup.b(new JSONObject(HttpHelper.i().m(format, c2)).getString("html")).q0("div.info").iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                Element r02 = element.r0("a.name");
                Element r03 = element.r0("div.meta");
                String trim = r02.v0().trim();
                String a2 = Regex.a(r03.toString(), "(\\d{4})", 1);
                String h2 = TitleHelper.h(trim.toLowerCase() + a2, "");
                if (h2.equals(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, ""))) {
                    String c3 = r02.c("href");
                    if (!c3.startsWith("/")) {
                        return c3;
                    }
                    return this.f37323f + c3;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}

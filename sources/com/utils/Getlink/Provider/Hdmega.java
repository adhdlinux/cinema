package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.gson.Gson;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Hdmega extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37348e = Utils.getProvider(94);

    /* renamed from: f  reason: collision with root package name */
    private String f37349f = "";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f37350g = new HashMap();

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        String str3;
        String str4;
        String str5;
        this.f37350g.put("referer", this.f37349f);
        String m2 = HttpHelper.i().m(str, Constants.c());
        String a2 = Regex.a(m2, "location['\"]:['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            String str6 = this.f37348e + a2.replace("\\/", "/");
            String m3 = HttpHelper.i().m(str6, new Map[0]);
            String g2 = HttpHelper.i().g(this.f37348e);
            if (g2.isEmpty()) {
                str5 = Regex.a(m3, "csrf-token\"\\s*content=['\"]([^'\"]+)['\"]", 1);
            } else {
                str5 = Regex.a(g2, "_csrf=([0-9a-zA-Z%_-]+);", 1);
            }
            String y2 = Utils.y(str6, Regex.a(m3, "captcha\\.execute\\(['\"]([^'\"]+)['\"]", 1), str6);
            if (!y2.isEmpty()) {
                HttpHelper.i().l(str6, String.format("_csrf=%s&tk=%s", new Object[]{str5, y2}), new Map[0]);
                m2 = HttpHelper.i().m(str, Constants.c());
            } else {
                m2 = m3;
            }
        }
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            str2 = Regex.a(m2, String.format("episode\\s*:\\s*[\"']%s[\"']\\s*,\\s*id_episode\\s*:\\s*(\\d+)\\s*,\\s*season\\s*:\\s*[\"']%s[\"']", new Object[]{movieInfo.eps, movieInfo.session}), 1);
        } else {
            str2 = "";
        }
        String a3 = Regex.a(m2, "id_movie\\s*:\\s*(\\d+)", 1);
        Regex.a(m2, "key\\s*:\\s*[\"']([^\"']+)", 1);
        if (!z2) {
            a3 = Regex.a(m2, "id_show\\s*:\\s*(\\d+)", 1);
            String a4 = Regex.a(m2, "slug\\s*:\\s*[\"']([^\"']+)", 1);
            str3 = HttpHelper.i().m(this.f37348e + "/api/v1/security/show-access?slug=" + a4 + "&token=&step=2", this.f37350g);
        } else {
            str3 = HttpHelper.i().m(this.f37348e + "/api/v1/security/movie-access?id_movie=" + a3 + "&token=1&sk=&step=1", this.f37350g);
        }
        String a5 = Regex.a(str3, "expires[\"']\\s*:\\s*(\\d+)", 1);
        String a6 = Regex.a(str3, "accessToken[\"']\\s*:\\s*[\"']([^\"']+)", 1);
        if (z2) {
            str4 = HttpHelper.i().m(String.format(this.f37348e + "/manifests/movies/json/%s/%s/%s/master.m3u8", new Object[]{a3, a5, a6}), this.f37350g);
        } else if (!str2.isEmpty()) {
            str4 = HttpHelper.i().m(String.format(this.f37348e + "/manifests/shows/json/%s/%s/%s/master.m3u8", new Object[]{a6, a5, str2}), this.f37350g);
        } else {
            return;
        }
        Iterator<String> it2 = Regex.h(str4, "[\"'](\\d{3,4}(?:p|))[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", true).iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            String a7 = Regex.a(next, "[\"'](\\d{3,4}(?:p|))[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
            String a8 = Regex.a(next, "[\"'](\\d{3,4}(?:p|))[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 2);
            MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
            mediaSource.setStreamLink(a8);
            mediaSource.setQuality(a7);
            observableEmitter.onNext(mediaSource);
        }
    }

    private String K(MovieInfo movieInfo) {
        boolean z2;
        List<Result> list;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String lowerCase = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).toLowerCase();
        HashMap hashMap = this.f37350g;
        hashMap.put("referer", this.f37348e + "/");
        this.f37350g.put("upgrade-insecure-requests", "1");
        this.f37350g.put("user-Agent", Constants.C);
        if (z2) {
            this.f37349f = this.f37348e + "/api/v1/movies/do-search/?q=" + lowerCase;
        } else {
            this.f37349f = this.f37348e + "/api/v1/shows/do-search/?q=" + lowerCase;
        }
        String m2 = HttpHelper.i().m(this.f37349f, this.f37350g);
        HdMegaResponces hdMegaResponces = (HdMegaResponces) new Gson().l(m2, HdMegaResponces.class);
        if (!(hdMegaResponces == null || (list = hdMegaResponces.f37347a) == null)) {
            for (Result next : list) {
                String str = next.f37426a;
                String str2 = next.f37428c;
                if (z2) {
                    if (str.toLowerCase().equals(movieInfo.name.toLowerCase()) && str2.equals(movieInfo.year)) {
                        return this.f37348e + "/movies/play/" + next.f37427b;
                    }
                } else if (str.toLowerCase().equals(movieInfo.name.toLowerCase()) && str2.equals(movieInfo.year)) {
                    return this.f37348e + "/shows/play/" + next.f37427b;
                }
            }
        }
        Iterator it2 = Jsoup.b(m2).q0("div.col-xs-2").g("div.row").g("a[title][href]").iterator();
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0(a.f20042a);
            String c2 = r02.c("href");
            String c3 = r02.c("title");
            String a2 = Regex.a(c3, "\\((\\d+)\\)", 1);
            if (!z2) {
                String lowerCase2 = c3.toLowerCase();
                if (lowerCase2.equals(movieInfo.name.toLowerCase() + ": ...") && a2.contains(movieInfo.sessionYear)) {
                    if (c2.contains("season-" + movieInfo.getSession())) {
                        return c2;
                    }
                }
            } else if (c3.toLowerCase().startsWith(movieInfo.name.toLowerCase()) && a2.equals(movieInfo.year)) {
                return c2;
            }
        }
        return "";
    }

    public String A() {
        return "Hdmega";
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

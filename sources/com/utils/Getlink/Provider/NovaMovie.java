package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class NovaMovie extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37392e;

    /* renamed from: f  reason: collision with root package name */
    private String f37393f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f37394g;

    public NovaMovie() {
        String str = Utils.getProvider(92) + "/";
        this.f37392e = str;
        this.f37394g = str;
    }

    public String A() {
        return "NovaMovie";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (L.isEmpty()) {
            L = K(movieInfo);
            if (L.isEmpty()) {
                return;
            }
        }
        J(observableEmitter, L, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (L.isEmpty()) {
            L = K(movieInfo);
            if (L.isEmpty()) {
                return;
            }
        }
        J(observableEmitter, L, movieInfo);
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        boolean z3;
        String c2;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String str2 = str;
        HashMap<String, String> c3 = Constants.c();
        c3.put("origin", this.f37392e);
        c3.put("referer", str2);
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String m2 = HttpHelper.i().m(str2, c3);
        if (!z2) {
            Iterator it2 = Jsoup.b(m2).q0("div.epList").g(a.f20042a).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                Element element = (Element) it2.next();
                c2 = element.r0(a.f20042a).c("href");
                String trim = element.r0(a.f20042a).v0().trim();
                String trim2 = movieInfo.eps.trim();
                this.f37393f = "HD";
                if (trim.toLowerCase().equals("episode " + trim2) || trim.equals(trim2)) {
                    m2 = HttpHelper.i().m(c2, new Map[0]);
                    str2 = c2;
                    z3 = true;
                } else {
                    str2 = c2;
                }
            }
            m2 = HttpHelper.i().m(c2, new Map[0]);
            str2 = c2;
            z3 = true;
            if (!z3) {
                return;
            }
        } else {
            String v02 = Jsoup.b(m2).r0("span.quality").v0();
            if (!v02.isEmpty()) {
                this.f37393f = v02;
            }
        }
        String format = String.format("action=ajax_getlinkstream&streamkey=%s&nonce=%s&imdbid=%s&tmdbid=%s", new Object[]{Regex.a(m2, "data-streamkey=['\"]([^'\"]+)['\"]", 1), Regex.a(m2, "data-wpnonce=['\"]([^'\"]+)['\"]", 1), Regex.a(m2, "data-imdbid=['\"]([^'\"]+)['\"]", 1), Regex.a(m2, "data-tmdbid=['\"]([^'\"]+)['\"]", 1)});
        String replace = Regex.a(HttpHelper.i().l(this.f37392e + "wp-admin/admin-ajax.php", format, c3), "servers_iframe['\"]\\s*:\\s*[\\{]([^\\{]+)[\\}]", 1).replace("\\/", "/");
        if (!replace.isEmpty()) {
            ArrayList<String> g2 = Regex.g(replace, "[0-9a-zA-Z- \\[\\]\\(\\)]['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, false);
            this.f37393f = "HD";
            boolean contains = "HD".toLowerCase().contains("cam");
            Iterator<String> it3 = g2.iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                if (next.contains("novamovie.net") || next.contains("pkayprek")) {
                    if (next.startsWith("//")) {
                        next = "https:" + next;
                    }
                    c3.put("referer", str2);
                    String a2 = Jsoup.b(HttpHelper.i().m(next, c3)).q0("iframe").a("src");
                    if (!GoogleVideoHelper.d(a2) || a2.contains(".srt")) {
                        z(observableEmitter2, a2, this.f37393f, contains);
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("User-Agent", Constants.C);
                        MediaSource mediaSource = new MediaSource(A(), "GoogleVideo", contains);
                        mediaSource.setStreamLink(a2);
                        mediaSource.setPlayHeader(hashMap);
                        mediaSource.setQuality(this.f37393f);
                        observableEmitter2.onNext(mediaSource);
                    }
                } else {
                    z(observableEmitter2, next, this.f37393f, contains);
                }
            }
        }
    }

    public String K(MovieInfo movieInfo) {
        boolean z2 = true;
        if (movieInfo.getType().intValue() != 1) {
            z2 = false;
        }
        if (z2) {
            return this.f37392e + TitleHelper.h(movieInfo.name.toLowerCase() + " " + movieInfo.year, "-");
        }
        return this.f37392e + "series/" + TitleHelper.h(movieInfo.name.toLowerCase() + " season " + movieInfo.session, "-");
    }

    public String L(MovieInfo movieInfo) {
        boolean z2 = true;
        if (movieInfo.getType().intValue() != 1) {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        String str = this.f37392e + "?s=" + TitleHelper.h(movieInfo.name, "+");
        hashMap.put("referer", this.f37392e);
        hashMap.put("upgrade-insecure-requests", "1");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("div[class=ml-item]").iterator();
        this.f37394g = str;
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0(a.f20042a).c("href");
            String c3 = element.r0(a.f20042a).c("oldtitle");
            if (z2) {
                this.f37393f = element.q0(a.f20042a).g("span[class=mli-quality]").h();
                if (c3.toLowerCase().equals(movieInfo.name.toLowerCase() + " (" + movieInfo.year + ")")) {
                    return c2;
                }
            } else {
                this.f37393f = "HD";
                if (c3.toLowerCase().equals(movieInfo.name.toLowerCase() + " season " + movieInfo.session)) {
                    return c2;
                }
            }
        }
        return "";
    }
}

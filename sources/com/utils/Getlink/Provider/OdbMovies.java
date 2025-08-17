package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class OdbMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37395e = Utils.getProvider(108);

    public String A() {
        return "OdbMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(movieInfo, observableEmitter, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(movieInfo, observableEmitter, K);
        }
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        boolean z2;
        String str2;
        boolean z3;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String m2 = HttpHelper.i().m(str, new Map[0]);
        if (!z2) {
            String a2 = Regex.a(m2, "data-id\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
            String l2 = HttpHelper.i().l(this.f37395e + "/xhrr.php", String.format("s=%s&t=%s", new Object[]{movieInfo.session, a2}), new Map[0]);
            Iterator it2 = Jsoup.b(l2).q0("div.seho").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    m2 = l2;
                    z3 = false;
                    break;
                }
                Element element = (Element) it2.next();
                if (Regex.a(element.toString(), "sea['\"]>\\s*(?:0|)(\\d+)", 1).equals(movieInfo.eps)) {
                    str = element.r0(a.f20042a).c("href");
                    if (!str.isEmpty()) {
                        if (str.startsWith("/")) {
                            str = this.f37395e + str;
                        }
                        m2 = HttpHelper.i().m(str, new Map[0]);
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                return;
            }
        }
        String a3 = Regex.a(m2, ">var\\s*\\w+\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        if (a3.isEmpty()) {
            a3 = Regex.a(m2, "GET['\"]\\s*,\\s*['\"]([^'\"]+)&act=", 1);
        }
        if (a3.startsWith("/")) {
            a3 = this.f37395e + a3;
        }
        String a4 = Regex.a(HttpHelper.i().o(Regex.a(m2, "src\\s*=\\s*['\"](http.*netmin.*)['\"]", 1), str), "\\w+\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        String o2 = HttpHelper.i().o(a3 + "&act=gth", str);
        String a5 = Regex.a(HttpHelper.i().o(String.format(a3 + "&act=gte&p=%s&h=%s&io=%s", new Object[]{Regex.a(o2, "data-id\\s*=\\s*['\"]([^'\"]+)['\"]", 1), Regex.a(o2, "data-host\\s*=\\s*['\"]([^'\"]+)['\"]", 1), a4}), str), "<iframe\\s+src\\s*=\\s*\"([^\"]+)", 1);
        String j2 = BaseProvider.j(a5);
        HashMap hashMap = new HashMap();
        hashMap.put("Host", BaseProvider.i(a5));
        hashMap.put("Referer", BaseProvider.j(str) + "/");
        HttpHelper.i().m(a5, hashMap);
        String l3 = HttpHelper.i().l(a5, "qdf=1", hashMap);
        hashMap.put("Referer", a5);
        String a6 = Regex.a(l3, "tk\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        String a7 = Regex.a(l3, "vd\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        String o3 = HttpHelper.i().o(String.format(j2 + "/ajax?t=%s&id=%s", new Object[]{a6, a7}), a5);
        if (!a5.isEmpty()) {
            hashMap.put(TheTvdb.HEADER_ACCEPT, "*/*");
            hashMap.put("Accept-Encoding", "identity;q=1, *;q=0");
            hashMap.put("Referer", BaseProvider.j(a6) + "/");
            hashMap.put("Host", BaseProvider.i(o3));
            boolean n2 = GoogleVideoHelper.n(o3);
            String A = A();
            if (n2) {
                str2 = "GoogleVideo";
            } else {
                str2 = "CDN-FastServer";
            }
            MediaSource mediaSource = new MediaSource(A, str2, false);
            mediaSource.setStreamLink(o3);
            mediaSource.setPlayHeader(hashMap);
            mediaSource.setQuality("HD");
            observableEmitter.onNext(mediaSource);
        }
    }

    public String K(MovieInfo movieInfo) {
        boolean z2;
        String str;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String k2 = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37395e + "/");
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.l(this.f37395e + "/xhrr.php", "q=" + k2, hashMap)).q0("a[href]").iterator();
        if (!z2) {
            str = "div.it";
        } else {
            str = "div.im";
        }
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            Element r02 = element.r0(str);
            String c2 = element.c("href");
            if (r02.v0().trim().contains(movieInfo.name + " (" + movieInfo.year + ")")) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37395e + c2;
            }
        }
        return "";
    }
}

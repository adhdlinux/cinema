package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.utils.kotlin.KotlinHelper;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class MiraDeTodo extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37379e = Utils.getProvider(78);

    /* renamed from: f  reason: collision with root package name */
    private String f37380f = "Ij4aiaQXgluXQRs6";

    /* renamed from: g  reason: collision with root package name */
    private String f37381g = "8z5Ag5wgagfsOuhz";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        String str2;
        String str3;
        String str4 = str;
        MovieInfo movieInfo2 = movieInfo;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String a2 = Regex.a(HttpHelper.i().m(str4, new Map[0]), "['\"]?data-id['\"]?\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            String n2 = KotlinHelper.f37692a.n(a2, this.f37380f);
            HashMap<String, String> c2 = Constants.c();
            c2.put("accept", "application/json, text/javascript, */*; q=0.01");
            c2.put("referer", str4);
            String replace = HttpHelper.i().m(this.f37379e + "/ajax/episode/list/" + a2 + "?vrf=" + n2, c2).replace("\\", "");
            if (!z2) {
                Iterator it2 = Jsoup.b(replace).q0(String.format("ul[data-season=%s]", new Object[]{movieInfo2.session})).g("a[data-id]").iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str2 = "";
                        break;
                    }
                    Element element = (Element) it2.next();
                    if (element.c("data-num").equals(movieInfo2.eps)) {
                        str2 = element.c("data-id");
                        break;
                    }
                }
                c2.put("referer", str4 + String.format("/%s-%s", new Object[]{movieInfo2.session, movieInfo2.eps}));
            } else {
                str2 = Jsoup.b(replace).r0("a[data-id]").c("data-id");
            }
            if (!str2.isEmpty()) {
                Iterator it3 = Jsoup.b(HttpHelper.i().m(this.f37379e + "/ajax/server/list/" + str2 + "?vrf=" + KotlinHelper.f37692a.n(str2, this.f37380f), c2).replace("\\", "")).q0("ul.servers").g("li.server").iterator();
                while (it3.hasNext()) {
                    Element element2 = (Element) it3.next();
                    if (z2) {
                        str3 = element2.c("data-link-id");
                    } else {
                        str3 = element2.c("data-link-id");
                    }
                    if (!str3.isEmpty()) {
                        KotlinHelper.Companion companion = KotlinHelper.f37692a;
                        String m2 = companion.m(Regex.a(HttpHelper.i().m(this.f37379e + "/ajax/server/" + str3 + "?vrf=" + companion.n(str3, this.f37380f), c2).replace("\\", ""), "['\"]?(?:url|src|link)['\"]?\\s*[=|:]\\s*['\"]([^'\"]+)['\"]", 1), this.f37381g);
                        if (!m2.isEmpty()) {
                            MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                            mediaSource.setStreamLink(m2);
                            mediaSource.setPlayHeader(c2);
                            mediaSource.setQuality("HD");
                            observableEmitter.onNext(mediaSource);
                        } else {
                            ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                        }
                    } else {
                        return;
                    }
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
        String k2 = com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37379e + "/filter?keyword=" + k2, new Map[0])).q0("div.movies.items").g("div.meta").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.r0("a[href]").v0();
            if (!v02.isEmpty()) {
                if (z2) {
                    String a2 = Regex.a(element.toString(), ">\\s*(\\d{4})\\s*<", 1);
                    if (TitleHelper.h(v02.toLowerCase(), "").contains(TitleHelper.h(movieInfo.getName().toLowerCase(), "")) && a2.equals(movieInfo.year)) {
                        String c2 = element.r0(a.f20042a).c("href");
                        if (!c2.startsWith("/")) {
                            return c2;
                        }
                        return this.f37379e + c2;
                    }
                } else {
                    String a3 = Regex.a(element.toString(), ">\\s*([Ss][Ss]\\s*\\d+)\\s*<", 1);
                    if (TitleHelper.h(v02.toLowerCase(), "").contains(TitleHelper.h(movieInfo.getName().toLowerCase(), "")) && !a3.isEmpty()) {
                        String c3 = element.r0(a.f20042a).c("href");
                        if (!c3.startsWith("/")) {
                            return c3;
                        }
                        return this.f37379e + c3;
                    }
                }
            }
        }
        return "";
    }

    public String A() {
        return "MiraDeTodo";
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

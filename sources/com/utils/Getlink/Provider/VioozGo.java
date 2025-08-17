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
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class VioozGo extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37485e;

    /* renamed from: f  reason: collision with root package name */
    private String f37486f;

    public VioozGo() {
        String provider = Utils.getProvider(112);
        this.f37485e = provider;
        this.f37486f = provider;
    }

    public String A() {
        return "VioozGo";
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

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        String str3;
        String str4;
        MovieInfo movieInfo2 = movieInfo;
        String str5 = str;
        if (str5.startsWith("/")) {
            str5 = this.f37485e + str5;
        }
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37485e + "/");
        String m2 = HttpHelper.i().m(str5, hashMap);
        hashMap.put("referer", str5);
        String a2 = Regex.a(m2, "data-id\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
        String a3 = Regex.a(m2, "<strong>(\\w+)<\\/strong>", 1);
        if (a3.isEmpty()) {
            a3 = "HD";
        }
        hashMap.put("x-requested-with", "XMLHttpRequest");
        if (!z2) {
            Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37485e + "/ajax/tv/seasons/" + a2, hashMap)).q0("ul.ulclear.slcs-ul").g("li").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    a2 = "";
                    break;
                }
                Element element = (Element) it2.next();
                String a4 = element.q0(a.f20042a).a("title");
                if (!a4.isEmpty() && Regex.a(a4, "(?:S|s)eason\\s*(?::|)\\s*(\\d+)", 1).equalsIgnoreCase(movieInfo2.session)) {
                    a2 = Regex.a(element.toString(), "episodes\\((\\d+)\\)", 1);
                    break;
                }
            }
            if (!a2.isEmpty()) {
                str2 = "season";
            } else {
                return;
            }
        } else {
            str2 = "movie";
        }
        Iterator it3 = Jsoup.b(HttpHelper.i().m(this.f37485e + "/ajax/" + str2 + "/episodes/" + a2, hashMap)).q0("a[id][data-linkid]").iterator();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-agent", Constants.C);
        while (it3.hasNext()) {
            Element element2 = (Element) it3.next();
            String c2 = element2.c("data-linkid");
            if (z2 || Regex.a(element2.v0(), "(?:E|e)pisode\\s*(\\d+)\\s*", 1).equalsIgnoreCase(movieInfo2.eps)) {
                String m3 = HttpHelper.i().m(this.f37485e + "/ajax/get_link/" + c2, new Map[0]);
                if (m3.isEmpty() || m3.contains(MRAIDPresenter.ERROR)) {
                    m3 = HttpHelper.i().m(this.f37485e + "/ajax/get_link/" + c2, hashMap);
                }
                if (!m3.isEmpty()) {
                    ArrayList arrayList = Regex.f(m3, "['\"]file['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0);
                    if (arrayList.isEmpty()) {
                        arrayList = Regex.f(m3, "['\"]src['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0);
                    }
                    String a5 = Regex.a(m3, "['\"]link['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
                    if (!a5.isEmpty()) {
                        arrayList.add(a5);
                    }
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        String replace = it4.next().toString().replace("\\/", "/");
                        boolean n2 = GoogleVideoHelper.n(replace);
                        String A = A();
                        if (n2) {
                            str3 = "GoogleVideo";
                        } else {
                            str3 = "CDN-FastServer";
                        }
                        MediaSource mediaSource = new MediaSource(A, str3, false);
                        mediaSource.setStreamLink(replace);
                        if (n2) {
                            mediaSource.setPlayHeader(hashMap2);
                        }
                        if (n2) {
                            str4 = GoogleVideoHelper.h(replace);
                        } else {
                            str4 = a3;
                        }
                        mediaSource.setQuality(str4);
                        observableEmitter.onNext(mediaSource);
                    }
                }
                ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
            }
        }
    }

    public String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.o(this.f37485e + "/search/" + TitleHelper.h(movieInfo.name.toLowerCase(), "-"), this.f37485e + "/")).q0("div.film-detail").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.r0(a.f20042a).v0();
            if (z2) {
                String a2 = Regex.a(element.toString(), "<span\\s*class=\"fdi-item\">(\\d+)<\\/span>", 1);
                if (movieInfo.name.equalsIgnoreCase(v02) && movieInfo.year.equalsIgnoreCase(a2)) {
                    return element.r0(a.f20042a).c("href");
                }
            } else if (TitleHelper.f(v02).equalsIgnoreCase(TitleHelper.f(TitleHelper.e(movieInfo.getName()))) && element.r0(a.f20042a).c("href").contains("/tv/")) {
                return element.r0(a.f20042a).c("href");
            }
        }
        return "";
    }
}

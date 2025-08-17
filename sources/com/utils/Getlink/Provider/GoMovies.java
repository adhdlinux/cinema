package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class GoMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37331e = Utils.getProvider(103);

    /* renamed from: f  reason: collision with root package name */
    private String f37332f = (this.f37331e + "/");

    /* renamed from: g  reason: collision with root package name */
    private String f37333g = "HQ";

    /* renamed from: h  reason: collision with root package name */
    private String f37334h = "";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        boolean z3;
        String c2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str);
        hashMap.put("user-agent", Constants.C);
        try {
            str = Jsoup.b(HttpHelper.i().o(str, this.f37332f)).r0("div.ds_seriesplay.dsclear").r0(a.f20042a).c("href");
        } catch (Throwable unused) {
        }
        String m2 = HttpHelper.i().m(str, hashMap);
        if (!z2) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("referer", str + "watching.html");
            hashMap2.put("user-agent", Constants.C);
            Iterator it2 = Jsoup.b(m2).q0("div[class=les-content]").g(a.f20042a).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                Element element = (Element) it2.next();
                c2 = element.c("href");
                String lowerCase = element.v0().toLowerCase();
                if (lowerCase.contains("episode " + movieInfo.eps + " -")) {
                    break;
                }
                if (lowerCase.equalsIgnoreCase("episode " + movieInfo.eps)) {
                    break;
                }
                if (!lowerCase.contains(movieInfo.eps + " -")) {
                    if (!lowerCase.equals(movieInfo.eps)) {
                        if (com.original.tase.utils.Utils.j("000", movieInfo.getEps().intValue()).equals(lowerCase)) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            m2 = HttpHelper.i().m(c2, hashMap2);
            z3 = true;
            if (!z3) {
                return;
            }
        }
        String a2 = Regex.a(m2, "iframe\\s*src\\s*=\\s*[\"']([^\"']+[^\"'])[\"']", 1);
        String m3 = HttpHelper.i().m(a2, new Map[0]);
        String a3 = Regex.a(m3, "var\\s*tc\\s*=\\s*[\"']([^\"']+[^\"'])[\"']", 1);
        String a4 = Regex.a(m3, "url\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
        String a5 = Regex.a(m3, "[\"']_token[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate("function _tsd_tsd_ds(n){return _35qx74(_F94xF3(_99x233g(n.slice(2,13))))+\"13295763\"}function _99x233g(n){return n.split(\"\")}function _F94xF3(n){return n.reverse()}function _35qx74(n){return n.join(\"\")}function acb(){return _tsd_tsd_ds(\"####\")}acb();".replace("####", a3));
            if (evaluate == null) {
                create.close();
                return;
            }
            str2 = evaluate.toString();
            create.close();
            HashMap<String, String> c3 = Constants.c();
            c3.put("x-token", str2);
            c3.put("origin", BaseProvider.j(a4));
            c3.put("referer", a2.replace(BaseProvider.j(a2), BaseProvider.j(a4)));
            Iterator it3 = Regex.f(HttpHelper.i().l(a4, String.format("tokenCode=%s&_token=%s", new Object[]{a3, a5}), c3), "[\"']([^\"']+[^\"'])[\"']", 1, true).get(0).iterator();
            while (it3.hasNext()) {
                z(observableEmitter, (String) it3.next(), this.f37333g, true);
            }
        } catch (Throwable unused2) {
            create.close();
            str2 = "";
        }
    }

    private String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37331e);
        hashMap.put("user-agent", Constants.C);
        String str = this.f37332f + "search?s=" + TitleHelper.d(movieInfo.name).replace("-", "+");
        this.f37334h = str;
        HttpHelper.i().g(str);
        String m2 = HttpHelper.i().m(str, hashMap);
        if (m2.contains("Attention Required! | Cloudflare")) {
            Logger.b("Need Verify Recaptcha", str);
            Utils.e(str, BaseProvider.i(str));
            return "";
        }
        Iterator it2 = Jsoup.b(m2).q0("div.featuredItems.singleVideo").iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                Element r02 = element.r0(a.f20042a);
                String c2 = r02.c("href");
                String c3 = r02.c("title");
                this.f37333g = element.r0("span[class*=mli-quality]").v0();
                String a2 = Regex.a(element.toString(), "jt-info\\\">?\\r?\\n?\\s*(\\d+)?\\r?\\n?\\s*<", 1);
                if (c3.isEmpty()) {
                    c3 = element.r0("h4").v0();
                }
                if (!z2) {
                    if (c3.toLowerCase().contains(movieInfo.name.toLowerCase() + " - season " + movieInfo.session)) {
                        return c2;
                    }
                } else if (c3.equalsIgnoreCase(movieInfo.name) && a2.contains(movieInfo.year)) {
                    return c2;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public String A() {
        return "GoMovies";
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

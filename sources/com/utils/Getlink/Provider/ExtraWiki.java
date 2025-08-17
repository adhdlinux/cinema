package com.utils.Getlink.Provider;

import com.google.android.gms.common.internal.ImagesContract;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class ExtraWiki extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37310e = Utils.getProvider(26);

    /* renamed from: f  reason: collision with root package name */
    public String f37311f = "HQ";

    public String A() {
        return "ExtraWiki";
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

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String a2 = Regex.a(HttpHelper.i().m(str, new Map[0]), "<iframe[^>]+src=['\"]([^'\"]+)['\"][^>]*>", 1);
        if (!a2.isEmpty()) {
            HashMap<String, String> E = BaseProvider.E(HttpHelper.i().o(a2, str), BaseProvider.j(a2));
            String l2 = HttpHelper.i().l(E.get(ImagesContract.URL), E.get("body"), new Map[0]);
            ArrayList<String> g2 = Regex.g(l2, "link['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true);
            ArrayList<String> g3 = Regex.g(l2, "language['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true);
            for (int i2 = 0; i2 < g3.size(); i2++) {
                String replace = g2.get(i2).replace("\\/", "/");
                if (g3.get(i2).toLowerCase(Locale.ROOT).equals("english")) {
                    z(observableEmitter, replace, this.f37311f, false);
                } else {
                    String str2 = this.f37311f;
                    x(observableEmitter, replace, str2, A() + " (" + g3.get(i2) + ") ", false);
                }
            }
        }
    }

    public String K(MovieInfo movieInfo) {
        movieInfo.getType().intValue();
        String h2 = TitleHelper.h(movieInfo.name.toLowerCase(Locale.ROOT), "+");
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37310e);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37310e + "/search/" + h2, hashMap)).q0("div.ml-item").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.r0("span.mli-info").v0();
            String a2 = Regex.a(element.g0().replace("\r", "").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, ""), ">\\s*(\\d{4})", 1);
            Locale locale = Locale.ROOT;
            if (TitleHelper.h(v02.toLowerCase(locale), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(locale), "")) && a2.equals(movieInfo.year)) {
                String c2 = element.r0("a[href]").c("href");
                if (c2.startsWith("/")) {
                    c2 = this.f37310e + c2;
                }
                String a3 = Regex.a(v02, "(\\d{3,4}p)", 1);
                this.f37311f = a3;
                if (a3.isEmpty()) {
                    this.f37311f = "HD";
                }
                return c2;
            }
        }
        return "";
    }
}

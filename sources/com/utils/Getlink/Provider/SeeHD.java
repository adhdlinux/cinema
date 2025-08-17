package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SeeHD extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37433e = Utils.getProvider(70);

    public String A() {
        return "SeeHD";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        Logger.a(K);
        if (!K.isEmpty()) {
            J(movieInfo, observableEmitter, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        Logger.a(K);
        if (!K.isEmpty()) {
            J(movieInfo, observableEmitter, K);
        }
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        boolean z2;
        String m2 = HttpHelper.i().m(str, new Map[0]);
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String a2 = Regex.a(m2, "mov-desc['\"]>\\s*(\\d{4})", 1);
        if (!z2) {
            Document b2 = Jsoup.b(m2);
            Iterator<String> it2 = Regex.g(m2, String.format("rel=['\"]([^'\"]+)['\"]\\s*>[E|s]pisode\\s*1\\s*<", new Object[]{movieInfo.eps}), 1, true).iterator();
            while (it2.hasNext()) {
                Iterator<String> it3 = Regex.g(b2.r0("div." + it2.next()).w(), "loadVideo\\(['\"]([^'\"]+)['\"]", 1, false).iterator();
                while (it3.hasNext()) {
                    z(observableEmitter, it3.next(), "HD", new boolean[0]);
                }
            }
        } else if (movieInfo.year.equals(a2)) {
            Iterator<String> it4 = Regex.g(m2, "loadVideo\\(['\"]([^'\"]+)['\"]", 1, false).iterator();
            while (it4.hasNext()) {
                z(observableEmitter, it4.next(), "HD", new boolean[0]);
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
        String h2 = TitleHelper.h(movieInfo.name.toLowerCase(), "+");
        if (z2) {
            h2 = h2 + "+" + movieInfo.year;
        }
        String str = this.f37433e + "/";
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str);
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3");
        Iterator it2 = Jsoup.b(HttpHelper.i().l(str, "do=search&subaction=search&story=" + h2, hashMap)).q0("div#dle-content").g("div.mov.clearfix").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            Element r02 = element.r0("a.mov-t.nowrap");
            String v02 = r02.v0();
            if (z2) {
                if (!TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.getName().toLowerCase(), ""))) {
                    if (TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.getName().toLowerCase() + movieInfo.year, ""))) {
                    }
                }
                String c2 = r02.c("href");
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37433e + c2;
            }
            if (!TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.getName().toLowerCase(), ""))) {
                if (!TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.getName().toLowerCase() + movieInfo.year, ""))) {
                    continue;
                }
            }
            if (Regex.a(element.toString(), "[S|s]aison\\s*(\\d+)\\s*", 1).equals(movieInfo.session)) {
                String c3 = r02.c("href");
                if (!c3.startsWith("/")) {
                    return c3;
                }
                return this.f37433e + c3;
            }
        }
        return "";
    }
}

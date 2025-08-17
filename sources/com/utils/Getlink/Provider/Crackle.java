package com.utils.Getlink.Provider;

import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Crackle extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public HashMap f37288e;

    /* renamed from: f  reason: collision with root package name */
    private String f37289f = "";

    public Crackle() {
        HashMap hashMap = new HashMap();
        this.f37288e = hashMap;
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        this.f37288e.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US");
        this.f37288e.put("Upgrade-Insecure-Requests", "1");
        this.f37288e.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
    }

    private static String J() {
        String str = GlobalVariable.c().b().getCbflist().get("0");
        if (str == null || str.isEmpty()) {
            return "";
        }
        return str;
    }

    private void K(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str, String str2) {
        boolean z2;
        String str3;
        String str4;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str3 = TitleHelper.h(movieInfo.name + " " + movieInfo.year, "-").toLowerCase(Locale.ROOT);
        } else {
            str3 = TitleHelper.h(movieInfo.name + " season " + movieInfo.session + " episode " + movieInfo.eps, "-").toLowerCase(Locale.ROOT);
        }
        String a2 = Regex.a(HttpHelper.i().m(String.format(this.f37289f, new Object[]{""}), new Map[0]), String.format("a[^>]\\s*href=['\"]([^'\"]+)['\"]>%s", new Object[]{str3}), 1);
        if (!a2.isEmpty()) {
            if (a2.startsWith("//")) {
                str4 = "http:" + a2;
            } else if (a2.startsWith("/")) {
                str4 = this.f37289f + a2;
            } else {
                str4 = this.f37289f + "/" + a2;
            }
            Iterator it2 = Jsoup.b(HttpHelper.i().o(str4, this.f37289f + "/")).q0("tr").iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (!observableEmitter.isDisposed()) {
                    String element2 = element.toString();
                    String replace = Regex.a(element2, "e\\(['\"]([^'\"]+)['\"]", 1).replace("\\/", "/").replace("&amp;", "&");
                    if (replace.startsWith("//")) {
                        replace = "http:" + replace;
                    }
                    if (!replace.isEmpty()) {
                        String lowerCase = Regex.a(element2, "(\\d{3,4}p)", 1).trim().toLowerCase();
                        if (lowerCase.isEmpty()) {
                            lowerCase = "HD";
                        }
                        z(observableEmitter, replace, lowerCase, false);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public String A() {
        return "Crackle";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37289f = J();
        if (GlobalVariable.c().b().getAds() == null && BaseProvider.v()) {
            K(observableEmitter, movieInfo, "-1", "-1");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37289f = J();
        if (GlobalVariable.c().b().getAds() == null && BaseProvider.v()) {
            K(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
        }
    }
}

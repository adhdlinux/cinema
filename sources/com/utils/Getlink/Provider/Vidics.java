package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Vidics extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37484e = Utils.getProvider(40);

    public String A() {
        return "Vidics";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        boolean z2;
        Element r02;
        String str2;
        MovieInfo movieInfo2 = movieInfo;
        String replace = movieInfo.getName().replace("Marvel's ", "").replace("DC's ", "").replace("The 100", "The Hundred");
        if (!replace.equals("American Dad!")) {
            replace = TitleHelper.e(replace);
        }
        Document b2 = Jsoup.b(HttpHelper.i().m(this.f37484e + "/Category-FilmsAndTV/Genre-Any/Letter-Any/ByPopularity/1/Search-" + com.original.tase.utils.Utils.k(TitleHelper.g(replace), new boolean[0]) + ".htm", new Map[0]));
        String[] f2 = BaseResolver.f();
        if (RealDebridCredentialsHelper.d().isValid()) {
            f2 = com.original.tase.utils.Utils.p(f2, BaseResolver.e());
        }
        Iterator it2 = b2.q0("div.searchResult").iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = "";
                break;
            }
            Element element = (Element) it2.next();
            Element r03 = element.r0("a[href][itemprop=\"url\"]");
            Element r04 = element.r0("span[itemprop=\"name\"]");
            Element r05 = element.r0("span[itemprop=\"copyrightYear\"]");
            if (!(r03 == null || r04 == null)) {
                str = r03.c("href");
                String v02 = r04.v0();
                if (r05 != null) {
                    str2 = r05.v0();
                } else {
                    str2 = "";
                }
                if (str.trim().toLowerCase().contains("/serie/") && TitleHelper.f(movieInfo.getName()).equals(TitleHelper.f(v02))) {
                    if (str2.trim().isEmpty() || !com.original.tase.utils.Utils.o(str2.trim()) || movieInfo.getYear().intValue() <= 0 || Integer.parseInt(str2.trim()) == movieInfo.getYear().intValue()) {
                        break;
                    }
                }
            }
        }
        if (str.startsWith("//")) {
            str = "http:" + str;
        } else if (str.startsWith("/")) {
            str = this.f37484e + str;
        } else if (str.isEmpty()) {
            return;
        }
        String c2 = Regex.c(HttpHelper.i().m(str, new Map[0]), "href=\"(/Serie/[^\"]+-Season-" + movieInfo2.session + "-Episode-" + movieInfo2.eps + ")", 1, true);
        if (c2.startsWith("/")) {
            c2 = "https://www.vidics.to" + c2;
        } else if (c2.isEmpty()) {
            return;
        }
        Document b3 = Jsoup.b(HttpHelper.i().o(c2, str));
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", c2);
        hashMap.put("Host", this.f37484e.replace("https://", "").replace("http://", "").replace("/", ""));
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.6,en;q=0.4");
        Iterator it3 = b3.q0("div.lang").iterator();
        while (it3.hasNext()) {
            Element element2 = (Element) it3.next();
            if (Regex.c(element2.toString(), "title=\"Language\\s+Flag\\s+([^\"]*)\"", 1, true).trim().toLowerCase().equals("english")) {
                Iterator it4 = element2.q0("a.p1[href]").iterator();
                while (it4.hasNext()) {
                    Element element3 = (Element) it4.next();
                    if (!observableEmitter.isDisposed()) {
                        try {
                            String c3 = element3.c("href");
                            String trim = element3.v0().trim();
                            int length = f2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    z2 = false;
                                    break;
                                }
                                String str3 = f2[i2];
                                if (TitleHelper.f(trim).contains(TitleHelper.f(str3))) {
                                    break;
                                } else if (TitleHelper.f(str3).contains(TitleHelper.f(trim))) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            z2 = true;
                            if (z2) {
                                if (c3.startsWith("/")) {
                                    c3 = this.f37484e + c3;
                                }
                                String m2 = HttpHelper.i().m(c3, hashMap);
                                if (!m2.isEmpty() && (r02 = Jsoup.b(m2).r0("a.blue[href][target=\"_blank\"]")) != null) {
                                    try {
                                        z(observableEmitter, r02.c("href"), "HQ", new boolean[0]);
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                }
                            }
                            ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                        } catch (Exception e3) {
                            e = e3;
                            ObservableEmitter<? super MediaSource> observableEmitter3 = observableEmitter;
                            Logger.d(e, new boolean[0]);
                        }
                    } else {
                        return;
                    }
                }
                continue;
            }
            ObservableEmitter<? super MediaSource> observableEmitter4 = observableEmitter;
        }
    }
}

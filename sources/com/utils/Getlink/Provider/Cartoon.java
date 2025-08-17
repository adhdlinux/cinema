package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Cartoon extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37278e = Utils.getProvider(29);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        boolean z2;
        String str;
        MovieInfo movieInfo2 = movieInfo;
        if (f(movieInfo2.genres)) {
            if (movieInfo.getType().intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("user-agent", Constants.C);
            String lowerCase = com.original.tase.utils.Utils.k(movieInfo2.name, new boolean[0]).replace("%20", "+").toLowerCase();
            Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37278e + "/Search/?s=" + lowerCase, new Map[0])).q0("div.ml-item").iterator();
            String str2 = "";
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                String c2 = element.c("data-movie-id");
                if (!c2.isEmpty()) {
                    Element r02 = element.r0(a.f20042a);
                    if (z2) {
                        String a2 = Regex.a(r02.toString(), "<em>(.*)<\\/em>\\s*(\\d+)", 1);
                        String a3 = Regex.a(r02.toString(), "<em>(.*)<\\/em>\\s*(\\d+)", 2);
                        if (movieInfo2.name.equalsIgnoreCase(a2) && movieInfo2.year.equals(a3)) {
                            str = r02.c("href");
                        }
                    } else {
                        if (Regex.a(r02.toString(), "<\\/span>(.*)<span>", 1).replaceAll("<[^>]*>", "").toLowerCase().contains(movieInfo2.name.toLowerCase() + " season " + movieInfo2.session)) {
                            str = r02.c("href");
                        }
                    }
                    str2 = c2;
                    break;
                }
                str2 = c2;
            }
            str = "";
            if (!str.isEmpty()) {
                String str3 = str + "Episode-Movie?id=" + str2;
                if (!z2) {
                    String c3 = Jsoup.b(HttpHelper.i().o(str, this.f37278e + "/")).r0("div#mv-info").r0(a.f20042a).c("href");
                    Iterator it3 = Jsoup.b(HttpHelper.i().o(c3, str)).q0("div.les-content").g(a.f20042a).iterator();
                    str3 = c3;
                    while (true) {
                        if (!it3.hasNext()) {
                            str2 = "";
                            break;
                        }
                        str3 = ((Element) it3.next()).c("href");
                        if (str3.contains(com.original.tase.utils.Utils.j("000", movieInfo.getEps().intValue()))) {
                            str2 = Regex.a(str3, "id=(\\d+)", 1);
                            break;
                        }
                    }
                }
                Iterator it4 = Jsoup.b(HttpHelper.i().o(str3, str)).q0("select#selectServer").g("option").iterator();
                HashMap<String, String> c4 = Constants.c();
                c4.put("origin", this.f37278e);
                c4.put("referer", str3);
                while (it4.hasNext()) {
                    String a4 = Regex.a(((Element) it4.next()).toString(), "s=(\\w+)", 1);
                    String l2 = HttpHelper.i().l(this.f37278e + "/ajax/anime/load_episodes_v2?s=" + a4, "episode_id=" + str2, c4);
                    hashMap.put("referer", str3 + "&s=" + a4);
                    String a5 = Regex.a(l2, "src\\s*=\\\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
                    if (!a5.isEmpty()) {
                        MediaSource mediaSource = new MediaSource(A(), "", true);
                        mediaSource.setQuality("HD");
                        mediaSource.setStreamLink(a5);
                        mediaSource.setPlayHeader(hashMap);
                        observableEmitter.onNext(mediaSource);
                    } else {
                        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                    }
                }
            }
        }
    }

    public String A() {
        return "Cartoon";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }
}

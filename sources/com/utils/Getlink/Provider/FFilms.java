package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class FFilms extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37313e = Utils.getProvider(109);

    public String A() {
        return "FFilms";
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
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("div.table-responsive").g("td").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            String c2 = ((Element) it2.next()).c("href");
            String l2 = l(Regex.a(c2, "(fid|vid|vsid|vlid|vzid)(?:=)([0-9a-zA-Z]+)", 1), Regex.a(c2, "(fid|vid|vsid|vlid|vzid)(?:=)([0-9a-zA-Z]+)", 2));
            if (!l2.isEmpty()) {
                if (l2.startsWith("//")) {
                    l2 = "https:" + l2;
                }
                z(observableEmitter, l2, "HD", false);
            }
        }
    }

    public String K(MovieInfo movieInfo) {
        String replace = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        String k2 = BaseProvider.k(HttpHelper.i().m(this.f37313e, new Map[0]), this.f37313e);
        Iterator it2 = Jsoup.b(HttpHelper.i().o(String.format(k2, new Object[]{replace}), this.f37313e)).q0("figure.visual-thumbnail").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("href");
            String c3 = element.r0("img").c("title");
            if (c3.contains(movieInfo.name + " (" + movieInfo.year + ")")) {
                return c2;
            }
        }
        return "";
    }

    public String l(String str, String str2) {
        if (str.equals("streamango")) {
            return "https://streamango.com/embed/" + str2;
        } else if (str.equals("rapidvideo")) {
            return "https://www.rapidvideo.com/e/" + str2;
        } else if (str.equals("estream")) {
            return "https://estream.to/embed-" + str2 + ".html";
        } else if (str.equals("openload")) {
            return "https://openload.co/embed/" + str2;
        } else if (str.equals("vlid")) {
            return "https://vidlox.me/embed-" + str2 + ".html";
        } else if (str.equals("vzid")) {
            return "https://vidoza.net/embed-" + str2 + ".html";
        } else if (str.equals("vsid")) {
            return "https://verystream.com/e/" + str2;
        } else if (str.equals("fid")) {
            return "https://www.fembed.com/v/" + str2;
        } else if (!str.equals("vid")) {
            return "";
        } else {
            return "https://yandexcdn.com/player/embed_player.php?vid=" + str2;
        }
    }
}

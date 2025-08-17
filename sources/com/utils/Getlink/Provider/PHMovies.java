package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class PHMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37405e = Utils.getProvider(50);

    public String A() {
        return "PHMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        boolean z2;
        String str;
        if (movieInfo.name.equalsIgnoreCase("Marvel’s Iron Fist")) {
            movieInfo.name = "iron fist";
        }
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String replace = TitleHelper.g(movieInfo.name.toLowerCase()).replaceAll("(\\\\\\|/| -|:|;|\\*|\\?|\"|\\'|<|>|\\|)", " ").replace("  ", " ").replace(" ", "-");
        if (!z2) {
            str = replace + "-season-" + movieInfo.session + "-episode-" + movieInfo.eps;
        } else {
            str = replace + "-" + movieInfo.year;
        }
        new HashMap().put("user-agent", Constants.C);
        HttpHelper.i().m(this.f37405e, new Map[0]);
        HttpHelper i2 = HttpHelper.i();
        String o2 = i2.o(this.f37405e + "/" + str, this.f37405e + "/");
        if (!o2.contains("entry-title\">404<")) {
            Iterator it2 = Jsoup.b(o2).q0("div.anime_muti_link").g("li[data-video]").iterator();
            while (it2.hasNext()) {
                String c2 = ((Element) it2.next()).c("data-video");
                if (c2.startsWith("//")) {
                    c2 = "https:" + c2;
                }
                if (!c2.contains("vidnext.net/load.php")) {
                    z(observableEmitter, c2, "HD", false);
                }
            }
        }
    }
}

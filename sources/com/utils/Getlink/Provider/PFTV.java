package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import org.jsoup.Jsoup;

public class PFTV extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37404e = Utils.getProvider(73);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        try {
            String c2 = Jsoup.b(HttpHelper.i().o(str, this.f37404e)).r0("div.movieplay").r0("iframe").c("src");
            if (!c2.isEmpty()) {
                z(observableEmitter, c2, "HD", false);
            }
        } catch (Throwable unused) {
        }
    }

    public String A() {
        return "PFTV";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str = this.f37404e + "/" + TitleHelper.g(TitleHelper.e(movieInfo.name)) + "-" + movieInfo.year + "/";
        String b2 = Regex.b(HttpHelper.i().o(str, this.f37404e), "episode-date\\/\\d+\\/\"\\s+[0-9a-zA-Z-\"-=]+>\\d{4}", 1, 34);
        if (b2.isEmpty() || (com.original.tase.utils.Utils.o(b2) && b2.equals(movieInfo.year))) {
            J(observableEmitter, str);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str = this.f37404e + "/episode/" + TitleHelper.g(TitleHelper.e(movieInfo.name.replace("Marvel's ", "").replace("DC's ", ""))) + "-season-" + movieInfo.session + "-episode-" + movieInfo.eps + "/";
        String b2 = Regex.b(HttpHelper.i().o(str, this.f37404e), "release-year\\/\\d+\\/\"\\s+[0-9a-zA-Z-\"-=]+>\\d{4}", 1, 34);
        if (b2.isEmpty() || (com.original.tase.utils.Utils.o(b2) && b2.equals(movieInfo.year))) {
            J(observableEmitter, str);
        }
    }
}

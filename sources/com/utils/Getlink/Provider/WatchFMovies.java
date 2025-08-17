package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;

public class WatchFMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37489e = Utils.getProvider(47);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        boolean z2;
        BaseProvider.i(this.f37489e);
        String str = this.f37489e + "/api/films?id=" + movieInfo.imdbIDStr + "&idType=imdb";
        String str2 = this.f37489e + "/films?id=" + movieInfo.imdbIDStr;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            String format = String.format("&sa=%s&epi=%s", new Object[]{movieInfo.session, movieInfo.eps});
            str = (this.f37489e + "/api/series?id=" + movieInfo.imdbIDStr) + format + "&idType=imdb";
            str2 = this.f37489e + "/series?id=" + movieInfo.imdbIDStr + format;
        }
        Iterator<String> it2 = Regex.g(HttpHelper.i().o(str, str2), "link\\w+['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]", 1, false).iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (next.contains(UriUtil.HTTP_SCHEME)) {
                MediaSource mediaSource = new MediaSource(A(), "FR-FastServer", false);
                mediaSource.setStreamLink(next);
                mediaSource.setQuality("HD");
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    public String A() {
        return "WatchFMovies";
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

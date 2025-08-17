package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloudMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37285e = Utils.getProvider(51);

    /* renamed from: f  reason: collision with root package name */
    String f37286f = "HD";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        String str = this.f37285e + "/v3/movie/sources/" + movieInfo.tmdbID;
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str);
        String m2 = HttpHelper.i().m(str, new Map[0]);
        ArrayList<String> g2 = Regex.g(m2, "quality['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true);
        ArrayList<String> g3 = Regex.g(m2, "url['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true);
        for (int i2 = 0; i2 < g3.size(); i2++) {
            String str2 = g3.get(i2);
            String str3 = g2.get(i2);
            Logger.a(str2);
            MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", true);
            mediaSource.setPlayHeader(hashMap);
            if (str3 == null) {
                str3 = "HD";
            }
            mediaSource.setQuality(str3);
            mediaSource.setStreamLink(str2);
            observableEmitter.onNext(mediaSource);
        }
    }

    public String A() {
        return "CloudMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}

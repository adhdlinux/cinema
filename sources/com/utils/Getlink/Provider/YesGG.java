package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class YesGG extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37505e = Utils.getProvider(100);

    /* renamed from: f  reason: collision with root package name */
    private String f37506f = (this.f37505e + "/");

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("li[data-link]").iterator();
        while (it2.hasNext()) {
            String c2 = ((Element) it2.next()).c("data-link");
            if (!c2.isEmpty()) {
                if (c2.startsWith("//")) {
                    c2 = "https:" + c2;
                }
                z(observableEmitter, c2, "HD", false);
            }
        }
    }

    public String A() {
        return "YesGG";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(this.f37506f + "/set-movie-a/%s", new Object[]{movieInfo.imdbIDStr}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}

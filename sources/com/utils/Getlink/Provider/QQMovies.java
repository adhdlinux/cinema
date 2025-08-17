package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class QQMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37413e = "http://qqmovies.co";

    public String A() {
        return "QQMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(movieInfo, observableEmitter);
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        Iterator it2;
        String str;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String str2 = this.f37413e + "/watch/" + (TitleHelper.h(movieInfo.name.toLowerCase(), "-") + ".html");
        String o2 = HttpHelper.i().o(str2, this.f37413e);
        String a2 = Regex.a(o2, "<span[^>]+class=\"label label-primary\"[^>]*>(\\w+)<", 1);
        if (!z2) {
            o2 = HttpHelper.i().o(Regex.a(o2, "<a[^>]+href=\"([^\"]+)\"[^>]*>S" + Utils.i(Integer.parseInt(movieInfo.session)) + "E" + Utils.i(Integer.parseInt(movieInfo.eps)), 1), str2);
        }
        if (z2) {
            it2 = Jsoup.b(o2).q0("div.season").g(a.f20042a).iterator();
        } else {
            it2 = Jsoup.b(o2).q0("iframe.responsive-embed-item").iterator();
        }
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (z2) {
                str = Regex.a(HttpHelper.i().o(element.c("href"), str2), "<iframe[^>]+src=\"([^\"]+)\"[^>]*>", 1);
            } else {
                str = element.c("src");
            }
            String m2 = HttpHelper.i().m(str, new Map[0]);
            ArrayList arrayList = new ArrayList();
            String a3 = Regex.a(m2, "href\\s*=\\s*['\"]([^'\"]*http+[^'\"]*)['\"]>", 1);
            if (!a3.isEmpty()) {
                arrayList.add(a3);
            }
            if (arrayList.size() == 0) {
                arrayList.addAll(Regex.f(m2, "file\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0));
            }
            if (arrayList.size() == 0) {
                arrayList.addAll(Regex.f(m2, "pageUrl*\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0));
            }
            if (arrayList.size() == 0) {
                arrayList.add(Regex.a(m2, "content*\\s*=\\s*['\"]([^'\"]*openload+[^'\"]*)['\"]", 1));
            }
            arrayList.add(Regex.a(m2, "<iframe.*src\\s*=\\s*['\"]([^'\"]+)['\"]", 1));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str3 = (String) it3.next();
                if (str3 != null && !str3.isEmpty() && str3.contains(UriUtil.HTTP_SCHEME)) {
                    MediaSource mediaSource = new MediaSource(A(), a2, false);
                    mediaSource.setStreamLink(str3);
                    mediaSource.setQuality(a2);
                    observableEmitter.onNext(mediaSource);
                }
            }
        }
    }
}

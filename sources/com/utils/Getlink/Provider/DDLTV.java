package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
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

public class DDLTV extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37290e = Utils.getProvider(38);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        boolean z2;
        String str;
        String str2;
        String str3;
        String c2;
        MovieInfo movieInfo2 = movieInfo;
        int i2 = 1;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String str4 = this.f37290e;
        String str5 = "";
        if (z2) {
            str = (str4 + "/movies/") + movieInfo2.name.replace(":", str5) + " (" + movieInfo2.year + ")/";
        } else {
            str = (str4 + "/tvs/") + movieInfo2.name.replace(":", str5) + "/Season " + movieInfo2.session + "/";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("tr.file").g(a.f20042a).iterator();
        while (true) {
            str2 = "HD";
            if (!it2.hasNext()) {
                str3 = str2;
                break;
            }
            Element element = (Element) it2.next();
            String v02 = element.v0();
            c2 = element.c("href");
            if (z2) {
                str3 = Regex.a(v02, "(\\d{3,4})p", i2);
                break;
            }
            if (v02.toLowerCase().contains(String.format("s%se%s", new Object[]{com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)), com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps))}))) {
                str3 = Regex.a(v02, "(\\d{3,4})p", 1);
                break;
            }
            i2 = 1;
        }
        str5 = c2;
        if (str3.isEmpty()) {
            str3 = str2;
        }
        if (!str5.contains(UriUtil.HTTP_SCHEME)) {
            str5 = str + str5;
        }
        MediaSource mediaSource = new MediaSource(A(), "CDN", true);
        mediaSource.setPlayHeader(hashMap);
        if (!str3.isEmpty()) {
            str2 = str3;
        }
        mediaSource.setQuality(str2);
        mediaSource.setStreamLink(str5);
        observableEmitter.onNext(mediaSource);
    }

    public String A() {
        return "DDLTV";
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

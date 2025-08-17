package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Wawani extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37494e = Utils.getProvider(58);

    /* renamed from: f  reason: collision with root package name */
    String f37495f = "HD";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        String c2 = Jsoup.b(HttpHelper.i().m(str, hashMap)).r0("iframe").c("src");
        if (!c2.isEmpty()) {
            if (c2.startsWith("//")) {
                c2 = "https:" + c2;
            }
            Iterator it2 = n(c2, str).iterator();
            while (it2.hasNext()) {
                String obj = it2.next().toString();
                boolean n2 = GoogleVideoHelper.n(obj);
                String A = A();
                if (n2) {
                    str2 = "GoogleVideo";
                } else {
                    str2 = "CDN-FastServer";
                }
                MediaSource mediaSource = new MediaSource(A, str2, false);
                mediaSource.setStreamLink(obj);
                if (n2) {
                    mediaSource.setPlayHeader(hashMap);
                }
                if (n2) {
                    str3 = GoogleVideoHelper.h(obj);
                } else {
                    str3 = this.f37495f;
                }
                mediaSource.setQuality(str3);
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        boolean z2;
        if (!f(movieInfo.genres)) {
            return "";
        }
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            String h2 = TitleHelper.h(movieInfo.name.toLowerCase(), "-");
            return this.f37494e + "/videos/" + h2 + "-episode-1";
        }
        String h3 = TitleHelper.h(movieInfo.name + " Season " + movieInfo.session + " Episode " + movieInfo.eps, "-");
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37494e);
        sb.append("/search.html?keyword=");
        sb.append(h3);
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        try {
            Iterator it2 = Jsoup.b(HttpHelper.i().m(sb2, hashMap)).q0("div.wpb_wrapper").g("li.video-block").g(a.f20042a).iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                String c2 = element.c("href");
                if (TitleHelper.f(element.r0("div.name").v0()).startsWith(TitleHelper.f(h3))) {
                    if (c2.contains("-" + movieInfo.eps + "-")) {
                        if (!c2.startsWith("/")) {
                            return c2;
                        }
                        return this.f37494e + c2;
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(th, false);
        }
        return "";
    }

    public String A() {
        return "Wawani";
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
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K);
        }
    }
}

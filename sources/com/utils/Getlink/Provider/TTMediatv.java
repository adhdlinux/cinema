package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringEscapeUtils;

public class TTMediatv extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37463e = Utils.getProvider(42);

    public String A() {
        return "TTMediatv";
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
        Iterator it2 = Regex.f(HttpHelper.i().m(str, new Map[0]), "['\"]?url['\"]?\\s*:\\s*['\"]([^'\"]+)", 1, true).get(0).iterator();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        while (it2.hasNext()) {
            String a2 = StringEscapeUtils.a((String) it2.next());
            if (a2.contains("m3u8") || a2.contains("token")) {
                MediaSource mediaSource = new MediaSource(A(), "CDN", false);
                mediaSource.setStreamLink(a2);
                mediaSource.setPlayHeader(hashMap);
                mediaSource.setQuality("HD");
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    public String K(MovieInfo movieInfo) {
        String k2 = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]);
        HttpHelper.i().D("cookie", "");
        HttpHelper.i().m(this.f37463e, new Map[0]);
        HashMap hashMap = new HashMap();
        String g2 = HttpHelper.i().g(this.f37463e);
        hashMap.put("referer", this.f37463e + "/search/venom");
        if (!g2.isEmpty()) {
            hashMap.put("cookie", HttpHelper.i().g(this.f37463e));
        }
        HttpHelper i2 = HttpHelper.i();
        String m2 = i2.m(this.f37463e + "/oz/search/" + k2 + "?isKidsMode=false&useLinearHeader=true", hashMap);
        Iterator it2 = Regex.d(m2, "['\"]id['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1).get(0).iterator();
        Iterator it3 = Regex.d(m2, "['\"]title['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1).get(0).iterator();
        Iterator it4 = Regex.d(m2, "['\"]year['\"]\\s*:\\s*(\\d+)", 1).get(0).iterator();
        while (it3.hasNext()) {
            try {
                String obj = it3.next().toString();
                String obj2 = it2.next().toString();
                String obj3 = it4.next().toString();
                if (obj.equals(movieInfo.name) && movieInfo.year.equals(obj3)) {
                    return this.f37463e + "/movies/" + obj2 + "/" + TitleHelper.h(movieInfo.name.toLowerCase(), "_");
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }
}

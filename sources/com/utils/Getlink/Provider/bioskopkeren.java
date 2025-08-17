package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class bioskopkeren extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public static String f37514e = (Utils.getProvider(89) + "/");

    public String A() {
        return "Bioskopkeren";
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
        String str2;
        String str3;
        String str4 = str;
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", str4);
        hashMap.put("User-Agent", Constants.C);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str4, new Map[0])).q0("iframe[src]").iterator();
        while (it2.hasNext()) {
            String c2 = ((Element) it2.next()).c("src");
            if (!c2.isEmpty()) {
                try {
                    Iterator it3 = Jsoup.b(URLDecoder.decode(Jsoup.b(HttpHelper.i().m(c2, hashMap)).r0("script[language=javascript]").Z(), "UTF-8")).q0("script").iterator();
                    while (it3.hasNext()) {
                        String Z = ((Element) it3.next()).Z();
                        if (JsUnpacker.m30920(Z)) {
                            Iterator<String> it4 = JsUnpacker.m30918(Z).iterator();
                            while (it4.hasNext()) {
                                Iterator it5 = Regex.e(it4.next(), "['\"]?file['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1, 2).get(0).iterator();
                                ArrayList<MediaSource> arrayList = new ArrayList<>();
                                while (it5.hasNext()) {
                                    String str5 = (String) it5.next();
                                    if (!str5.contains("player") && !str5.contains("sub?") && !str5.contains(".srt")) {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("User-Agent", Constants.C);
                                        boolean n2 = GoogleVideoHelper.n(str5);
                                        String A = A();
                                        if (n2) {
                                            str2 = "GoogleVideo";
                                        } else {
                                            str2 = "CDN-FastServer";
                                        }
                                        MediaSource mediaSource = new MediaSource(A, str2, false);
                                        mediaSource.setStreamLink(str5);
                                        mediaSource.setPlayHeader(hashMap2);
                                        if (n2) {
                                            str3 = GoogleVideoHelper.h(str5);
                                        } else {
                                            str3 = "HD";
                                        }
                                        mediaSource.setQuality(str3);
                                        arrayList.add(mediaSource);
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    Collections.reverse(arrayList);
                                    for (MediaSource onNext : arrayList) {
                                        try {
                                            observableEmitter.onNext(onNext);
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                    }
                                }
                                ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                            }
                        }
                        ObservableEmitter<? super MediaSource> observableEmitter3 = observableEmitter;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ObservableEmitter<? super MediaSource> observableEmitter4 = observableEmitter;
                    Logger.d(th, new boolean[0]);
                }
            }
            ObservableEmitter<? super MediaSource> observableEmitter5 = observableEmitter;
        }
    }

    public String K(MovieInfo movieInfo) {
        String replace = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        String h2 = TitleHelper.h(movieInfo.name.toLowerCase(), "-");
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.m(f37514e + "?s=" + replace, new Map[0])).q0("div[class=moviefilm]").iterator();
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0(a.f20042a);
            String c2 = r02.c("href");
            String c3 = r02.r0("img").c("src");
            String lowerCase = c2.toLowerCase();
            if (!lowerCase.contains("nonton-" + h2 + "-" + movieInfo.year)) {
                String lowerCase2 = c2.toLowerCase();
                if (!lowerCase2.contains("movie-" + h2 + "-" + movieInfo.year)) {
                    String lowerCase3 = c2.toLowerCase();
                    if (!lowerCase3.contains("film-" + h2 + "-" + movieInfo.year)) {
                        String lowerCase4 = c2.toLowerCase();
                        if (!lowerCase4.contains("nonton-" + h2 + "-subtitle")) {
                            continue;
                        }
                    }
                }
            }
            if (c3.toLowerCase().contains(movieInfo.year)) {
                return c2;
            }
        }
        return "";
    }
}

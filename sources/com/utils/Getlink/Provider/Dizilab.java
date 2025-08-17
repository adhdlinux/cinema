package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.Http2Helper;
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

public class Dizilab extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private static String f37307e = Utils.getProvider(111);

    public String A() {
        return "Dizilab";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        String str2 = f37307e + "/dizi/" + TitleHelper.e(TitleHelper.g(movieInfo.getName().replace("Marvel's ", "").replace("DC's ", "")).replace("'", "-").replace("P.D.", "PD")) + "/sezon-" + movieInfo.session + "/bolum-" + movieInfo.eps + "/";
        HashMap hashMap = new HashMap();
        hashMap.put("cookie", "udys=" + DateTimeHelper.e() + ";");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str2, new Map[0])).q0("div.alternatives-for-this").g("div[data-link]").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("data-link");
            String c3 = element.c("data-hash");
            String c4 = element.c("data-querytype");
            com.original.tase.utils.Utils.k(c2, new boolean[0]);
            String a2 = Regex.a(HttpHelper.i().o(Regex.a(Http2Helper.b().c(f37307e + "/ajax/service", String.format("link=%s&hash=%s&querytype=%s&type=videoGet", new Object[]{com.original.tase.utils.Utils.k(c2, new boolean[0]), c3, c4}), hashMap), "[\"']?api_iframe[\"']?\\s*:\\s*[\"']([^\"']+)", 1).replace("\\/", "/").replace("\\\\", ""), str2), "<iframe[^>]+src=\"([^\"]+)\"[^>]*>", 1);
            if (a2 != null && !a2.isEmpty()) {
                if (GoogleVideoHelper.l(a2)) {
                    HashMap<String, String> g2 = GoogleVideoHelper.g(a2);
                    if (g2 != null && !g2.isEmpty()) {
                        for (Map.Entry next : g2.entrySet()) {
                            MediaSource mediaSource = new MediaSource(A(), "GoogleVideo", false);
                            mediaSource.setOriginalLink(a2);
                            mediaSource.setStreamLink((String) next.getKey());
                            if (((String) next.getValue()).isEmpty()) {
                                str = "1080p";
                            } else {
                                str = (String) next.getValue();
                            }
                            mediaSource.setQuality(str);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("User-Agent", Constants.C);
                            hashMap2.put("Cookie", GoogleVideoHelper.m(a2, (String) next.getKey()));
                            mediaSource.setPlayHeader(hashMap2);
                            observableEmitter.onNext(mediaSource);
                        }
                    }
                } else {
                    z(observableEmitter, a2, "HD", false);
                }
            }
        }
    }
}

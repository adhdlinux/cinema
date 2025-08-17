package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class MovieFileHD extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37383e = Utils.getProvider(115);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        String str2;
        String str3;
        HashMap<String, String> c2 = Constants.c();
        c2.put("origin", this.f37383e);
        c2.put("referer", this.f37383e + "/");
        String a2 = Regex.a(str, "movie_([0-9a-zA-Z]+)", 1);
        String m2 = HttpHelper.i().m(str, new Map[0]);
        Jsoup.b(m2).r0("div#divU").v0();
        String O = Utils.O();
        Iterator<String> it2 = Regex.g(m2, "InitPlayer\\((\\d+)\\)", 1, false).iterator();
        while (it2.hasNext()) {
            String format = String.format("pass=%s&param=&extra=%s&e2=1&server=%s", new Object[]{a2, O, it2.next()});
            String a3 = Regex.a(HttpHelper.i().l(this.f37383e + "/home/index/GetMInfoAjax", format, c2), "\\\\\"val\\\\\":\\\\\"([^'\"]+[^'\"])\\\\\"", 1);
            if (!a3.isEmpty()) {
                boolean n2 = GoogleVideoHelper.n(a3);
                String A = A();
                if (n2) {
                    str2 = "GoogleVideo";
                } else {
                    str2 = "CDN-FastServer";
                }
                MediaSource mediaSource = new MediaSource(A, str2, false);
                String replace = a3.replace("\\", "");
                if (!replace.contains(UriUtil.HTTP_SCHEME)) {
                    replace = this.f37383e + replace;
                }
                mediaSource.setStreamLink(replace);
                if (n2) {
                    mediaSource.setPlayHeader(c2);
                }
                if (n2) {
                    str3 = GoogleVideoHelper.h(replace);
                } else {
                    str3 = "1080";
                }
                mediaSource.setQuality(str3);
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        HashMap hashMap = new HashMap();
        String str = this.f37383e + "/search.html?keyword=" + com.original.tase.utils.Utils.k(movieInfo.getName().toLowerCase(), new boolean[0]).replace("+", "%20");
        hashMap.put("referer", this.f37383e + "/");
        String m2 = HttpHelper.i().m(str, hashMap);
        hashMap.put("referer", str);
        Iterator it2 = Jsoup.b(m2).q0("div.thumbnail.text-center").iterator();
        new ArrayList();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String a2 = Regex.a(element.toString(), "<h(?:\\d)><a.*href=['\"]([^'\"]+[^'\"])['\"]>(.+)<\\/a>", 2);
            String a3 = Regex.a(element.toString(), "<h(?:\\d)><a.*href=['\"]([^'\"]+[^'\"])['\"]>(.+)<\\/a>", 1);
            String a4 = Regex.a(element.toString(), "<div.*>\\r?\\n[\\s\\S]+(\\d{4})\\r?\\n[\\s\\S]+<\\/div", 1);
            if (a2.toLowerCase().equalsIgnoreCase(movieInfo.name.toLowerCase()) && a4.equalsIgnoreCase(movieInfo.year)) {
                if (!a3.startsWith("/")) {
                    return a3;
                }
                return this.f37383e + a3;
            }
        }
        return "";
    }

    public String A() {
        return "MovieFileHD";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}

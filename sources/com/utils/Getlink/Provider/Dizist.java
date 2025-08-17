package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Dizist extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37308e = Utils.getProvider(110);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f37309f = new HashMap();

    public String A() {
        return "Dizist";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        MovieInfo movieInfo2 = movieInfo;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String e2 = TitleHelper.e(TitleHelper.g(movieInfo.getName().replace("Marvel's ", "").replace("DC's ", "")).replace("'", "-").replace("P.D.", "PD"));
        String str2 = this.f37308e + "/" + e2 + "-" + movieInfo2.session + "-sezon-" + movieInfo2.eps + "-bolum-izle/";
        this.f37309f.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        this.f37309f.put("upgrade-insecure-requests", "1");
        this.f37309f.put("accept-language", "en-US;q=0.8,en;q=0.7");
        String str3 = "referer";
        this.f37309f.put(str3, this.f37308e + "/diziler/" + e2 + "/");
        int i2 = 1;
        char c2 = 0;
        Document b2 = Jsoup.b(HttpHelper.i().m(str2, this.f37309f));
        this.f37309f.put(str3, str2);
        Iterator it2 = b2.q0("div.span-nine.pull-left").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            String c3 = ((Element) it2.next()).c("href");
            if (c3.startsWith("//")) {
                c3 = "http:" + c3;
            } else if (c3.startsWith("/")) {
                c3 = this.f37308e + c3;
            }
            HttpHelper i3 = HttpHelper.i();
            Map[] mapArr = new Map[i2];
            mapArr[c2] = this.f37309f;
            String m2 = i3.m(c3, mapArr);
            this.f37309f.put(str3, c3);
            Iterator it3 = Jsoup.b(m2).q0("div.embed-responsive-item").iterator();
            while (it3.hasNext()) {
                Element element = (Element) it3.next();
                Iterator it4 = element.q0("iframe[src]").iterator();
                while (it4.hasNext()) {
                    String c4 = ((Element) it4.next()).c("src");
                    if (c4.startsWith("//")) {
                        c4 = "https:" + c4;
                    } else if (c4.startsWith("/")) {
                        c4 = this.f37308e + c4;
                    }
                    if (c4.contains("specialcdn")) {
                        Iterator it5 = Jsoup.b(HttpHelper.i().m(c4, new Map[0])).q0("source").iterator();
                        while (it5.hasNext()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("Referer", this.f37308e);
                            hashMap.put("User-Agent", Constants.C);
                            Element element2 = (Element) it5.next();
                            String c5 = element2.c("src");
                            String c6 = element2.c("label");
                            Iterator it6 = it2;
                            if (!c6.toLowerCase().contains("hd")) {
                                c6 = "HQ";
                            }
                            boolean contains = c5.contains(".fbcdn.");
                            Iterator it7 = it5;
                            String str4 = str3;
                            String A = A();
                            if (contains) {
                                str = "FB-CDN";
                            } else {
                                str = "CDN";
                            }
                            Iterator it8 = it3;
                            MediaSource mediaSource = new MediaSource(A, str, false);
                            mediaSource.setStreamLink(c5);
                            mediaSource.setQuality(c6);
                            if (!c5.contains(".fbcdn.")) {
                                mediaSource.setPlayHeader(hashMap);
                            }
                            observableEmitter2.onNext(mediaSource);
                            it2 = it6;
                            it5 = it7;
                            str3 = str4;
                            it3 = it8;
                        }
                    } else {
                        Iterator it9 = it2;
                        String str5 = str3;
                        Iterator it10 = it3;
                        z(observableEmitter2, c4, "HD", new boolean[0]);
                        String a2 = Regex.a(c4, "okru(?:\\?|\\&)e=(\\d+)(?:$|\\&)", 1);
                        if (!a2.isEmpty()) {
                            z(observableEmitter2, "https://www.ok.ru/video/" + a2, "HD", new boolean[0]);
                        }
                        if (c4.contains("/okru")) {
                            Iterator it11 = Jsoup.b(HttpHelper.i().o(c4, str2)).q0("div[data-module][data-options]").iterator();
                            while (it11.hasNext()) {
                                String c7 = Regex.c(((Element) it11.next()).c("data-options"), "['\"]([^'\"]*//[^'\"]+\\.ru/video/[^'\"]+)['\"]", 1, true);
                                if (!c7.isEmpty()) {
                                    z(observableEmitter2, c7, "HD", new boolean[0]);
                                }
                            }
                        }
                        it2 = it9;
                        str3 = str5;
                        it3 = it10;
                    }
                }
                Iterator it12 = it2;
                String str6 = str3;
                Iterator it13 = it3;
                String b3 = Regex.b(element.toString().replace("\\/", "/").replace("\\\"", "\""), "videoembed/([\\d-]+)", 1, 34);
                if (b3.isEmpty()) {
                    b3 = Regex.b(element.toString().replace("\\/", "/").replace("\\\"", "\""), "videoembed/(\\d+)", 1, 34);
                }
                if (!b3.isEmpty()) {
                    z(observableEmitter2, "https://www.ok.ru/video/" + b3, "HD", new boolean[0]);
                }
                it2 = it12;
                str3 = str6;
                it3 = it13;
                i2 = 1;
                c2 = 0;
            }
        }
    }
}

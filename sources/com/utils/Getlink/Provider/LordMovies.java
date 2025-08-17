package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.Http2Helper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.search.SearchHelper;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LordMovies extends BaseProvider {

    /* renamed from: h  reason: collision with root package name */
    public static String f37371h = "";

    /* renamed from: e  reason: collision with root package name */
    private String f37372e = Utils.getProvider(52);

    /* renamed from: f  reason: collision with root package name */
    private String f37373f = "HQ";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f37374g = new HashMap();

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        Iterator it2;
        Duktape create;
        boolean z3;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String m2 = HttpHelper.i().m(str, this.f37374g);
        if (this.f37373f.isEmpty()) {
            this.f37373f = "HQ";
        }
        if (z2) {
            it2 = Jsoup.b(m2).q0("tr.linkTr").iterator();
        } else {
            Elements q02 = Jsoup.b(m2).q0("div[class=season][id=season" + movieInfo.session + "]");
            Iterator it3 = q02.g("h3").iterator();
            Iterator it4 = q02.g("table.table.table-striped.tableLinks").iterator();
            while (true) {
                if (it3.hasNext() && it4.hasNext()) {
                    String obj = it4.next().toString();
                    if (((Element) it3.next()).v0().endsWith("Season " + movieInfo.session + " Serie " + movieInfo.eps)) {
                        it2 = Jsoup.b(obj).q0("td.linkTr").iterator();
                        z3 = true;
                        break;
                    }
                } else {
                    it2 = null;
                    z3 = false;
                }
            }
            if (!z3) {
                return;
            }
        }
        f37371h = Regex.a(m2, "<script>\\s*(function\\s*dec_.*\\}).+?\\r?\\n<\\/script>", 1);
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                String v02 = element.r0("td.linkHidden.linkHiddenFormat").v0();
                String str2 = f37371h + String.format("function abc()\n{\n    return dec_%s_0_0('%s');\n}\nabc();", new Object[]{Regex.a(element.toString(), "serverLink+(\\w+)", 1), element.r0("td.linkHidden.linkHiddenCode").v0()});
                create = Duktape.create();
                Object evaluate = create.evaluate(str2);
                create.close();
                if (!evaluate.toString().isEmpty()) {
                    String format = String.format(v02, new Object[]{evaluate.toString()});
                    if (format.startsWith("//")) {
                        format = "https:" + format;
                    }
                    if (!format.isEmpty()) {
                        if (GoogleVideoHelper.l(format)) {
                            HashMap<String, String> g2 = GoogleVideoHelper.g(format);
                            if (g2 != null) {
                                for (Map.Entry next : g2.entrySet()) {
                                    MediaSource mediaSource = new MediaSource(A(), "GoogleVideo", false);
                                    mediaSource.setOriginalLink(format);
                                    mediaSource.setStreamLink((String) next.getKey());
                                    mediaSource.setQuality((String) next.getValue());
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("User-Agent", Constants.C);
                                    hashMap.put("Cookie", GoogleVideoHelper.m(format, (String) next.getKey()));
                                    mediaSource.setPlayHeader(hashMap);
                                    observableEmitter.onNext(mediaSource);
                                }
                            }
                        } else if (HandleMore.a(format)) {
                            for (String streamLink : HandleMore.c(format, str)) {
                                MediaSource mediaSource2 = new MediaSource(A(), "CDN-FastServer", false);
                                mediaSource2.setStreamLink(streamLink);
                                mediaSource2.setQuality(this.f37373f);
                                observableEmitter.onNext(mediaSource2);
                            }
                        } else if (HandleMore.b(format)) {
                            for (String streamLink2 : HandleMore.d(format, str)) {
                                MediaSource mediaSource3 = new MediaSource(A(), "CDN-FastServer", false);
                                mediaSource3.setStreamLink(streamLink2);
                                mediaSource3.setQuality("HD");
                                observableEmitter.onNext(mediaSource3);
                            }
                        } else {
                            z(observableEmitter, format, "HD", false);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = this.f37374g;
        hashMap.put("referer", this.f37372e + "/");
        String k2 = BaseProvider.k(HttpHelper.i().m(this.f37372e, new Map[0]), this.f37372e);
        String replace = com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("%20", "+");
        String h2 = TitleHelper.h(movieInfo.name.toLowerCase(), "-");
        String format = String.format(k2, new Object[]{replace.toLowerCase()});
        String d2 = Http2Helper.b().d(format, this.f37374g);
        this.f37374g.put("referer", format);
        Iterator it2 = Jsoup.b(d2).q0("div.showEntities.showEntitiesMovie.showEntitiesNull").g("div[id*=movie-]").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.r0(a.f20042a).c("href");
            if (c2.isEmpty()) {
                c2 = element.r0("div.showRow.showRowImage.showRowImage").r0(a.f20042a).c("href");
            }
            this.f37373f = element.r0("div[class*=movieQuality]").v0();
            if (z2 || element.r0("div.movieTV") != null) {
                if (c2.contains("/watch-online-" + h2) && element.toString().contains(movieInfo.year)) {
                    if (!c2.startsWith("/")) {
                        return c2;
                    }
                    return this.f37372e + c2;
                }
            }
        }
        return "";
    }

    public String A() {
        return "LordMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (K.isEmpty()) {
            K = SearchHelper.e(movieInfo.name, movieInfo.year, "", this.f37372e, "");
        }
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (K.isEmpty()) {
            K = SearchHelper.e(movieInfo.name, movieInfo.year, "", this.f37372e, "");
        }
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K);
        }
    }
}

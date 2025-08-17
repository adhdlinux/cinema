package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Pubfilm extends BaseProvider {

    /* renamed from: h  reason: collision with root package name */
    private static String f37409h = J();

    /* renamed from: e  reason: collision with root package name */
    private String f37410e = Utils.getProvider(6);

    /* renamed from: f  reason: collision with root package name */
    private String f37411f = "HQ";

    /* renamed from: g  reason: collision with root package name */
    private boolean f37412g = false;

    private static String J() {
        String str = f37409h;
        if (str == null || str.isEmpty()) {
            f37409h = Constants.E + "provider/pfc.txt";
        }
        return f37409h;
    }

    private String K(String str) {
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate("function acb(){for(var result=\"####\";result.includes(\";eval\");)result=result.replace(/;eval/gi,\"\"),result=eval(result);return result}acb()".replace("####", str));
            if (evaluate != null) {
                String obj = evaluate.toString();
                create.close();
                return obj;
            }
        } catch (Throwable unused) {
        }
        create.close();
        return "";
    }

    private void L(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37410e + "/");
        String m2 = HttpHelper.i().m(str, hashMap);
        if (z2) {
            str2 = Regex.a(m2, "<a[^>]+href=['\"]([^'\"]+)['\"][^>]*>\\s*SERVER", 1);
            if (!str2.isEmpty() && str2.startsWith("//")) {
                str2 = "https:" + str2;
            }
        } else {
            str2 = Regex.a(m2, "<a[^>]+href=['\"]([^'\"]+)['\"][^>]*>(?:EPISODE|)\\s*" + movieInfo.eps, 1);
            if (str2.isEmpty() && str2.startsWith("//")) {
                str2 = "https:" + str2;
            }
        }
        String str3 = str2;
        if (!str3.isEmpty()) {
            M(observableEmitter, str, str3, BaseProvider.j(str3), this.f37412g);
        }
    }

    private void M(ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2, String str3, boolean z2) {
        String str4;
        String a2 = Regex.a(HttpHelper.i().o(str2, str), "(;eval\\(.+\\);)", 1);
        if (!a2.isEmpty()) {
            String K = K(a2);
            if (!K.isEmpty()) {
                String a3 = Regex.a(K, "=['\"]([^'\"]+[^'\"])['\"]", 1);
                if (!a3.isEmpty()) {
                    String m2 = HttpHelper.i().m((str2 + String.format("&ref=fmoviesto.to&ref2=vidcloud.net&ref3=fmovies.ru.com&token=%s", new Object[]{a3})).replace("get.php", "apikey_v3.php"), new Map[0]);
                    if (!m2.isEmpty()) {
                        String K2 = K(m2);
                        if (!K2.isEmpty()) {
                            Iterator it2 = Regex.f(K2, "['\"]source['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1, true).get(0).iterator();
                            while (it2.hasNext()) {
                                String replace = ((String) it2.next()).replace("\\/", "/");
                                if (replace.startsWith("//")) {
                                    replace = "https:" + replace;
                                }
                                if (replace.contains("vidcloud9.shop")) {
                                    String a4 = Regex.a(replace, "id=(\\w+)", 1);
                                    String format = String.format(BaseProvider.j(replace) + "/hls/%s/%s.playlist.m3u8", new Object[]{a4, a4});
                                    if (z2) {
                                        str4 = A() + " (CAM)";
                                    } else {
                                        str4 = A();
                                    }
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("User-Agent", Constants.C);
                                    hashMap.put("accept", "*/*");
                                    hashMap.put("referer", str);
                                    hashMap.put("Origin", BaseProvider.j(format));
                                    MediaSource mediaSource = new MediaSource(str4, "CDN-FastServer", false);
                                    mediaSource.setStreamLink(format);
                                    mediaSource.setPlayHeader(hashMap);
                                    mediaSource.setQuality("HD");
                                    observableEmitter.onNext(mediaSource);
                                } else {
                                    z(observableEmitter, replace, "HD", z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private String N(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String format = String.format(BaseProvider.k(HttpHelper.i().m(this.f37410e, new Map[0]), this.f37410e), new Object[]{com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+").toLowerCase()});
        HashMap<String, String> c2 = Constants.c();
        c2.put("origin", this.f37410e);
        c2.put("referer", format);
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37410e + "/");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(format, hashMap)).q0("div.pt-cv-ifield").g("div.pt-cv-mask").g("a[href]").iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                Element r02 = element.r0("span[style]");
                if (r02 != null) {
                    if (r02.v0().contains("CAM")) {
                        this.f37412g = true;
                    } else {
                        this.f37412g = false;
                        this.f37411f = "HD";
                    }
                    r02.E();
                }
                String c3 = element.c("href");
                String trim = element.v0().trim();
                if (z2) {
                    Locale locale = Locale.ROOT;
                    if (!TitleHelper.h(trim.toLowerCase(locale), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(locale), ""))) {
                        String h2 = TitleHelper.h(trim.toLowerCase(locale), "");
                        if (h2.equals(TitleHelper.h(movieInfo.name.toLowerCase(locale) + movieInfo.year, ""))) {
                        }
                    }
                    if (!c3.startsWith("/")) {
                        return c3;
                    }
                    return this.f37410e + c3;
                }
                Locale locale2 = Locale.ROOT;
                String h3 = TitleHelper.h(trim.toLowerCase(locale2), "");
                if (!h3.equals(TitleHelper.h(movieInfo.name.toLowerCase(locale2) + "season" + movieInfo.session, ""))) {
                    String h4 = TitleHelper.h(trim.toLowerCase(locale2), "");
                    if (h4.equals(TitleHelper.h(movieInfo.name.toLowerCase(locale2) + movieInfo.sessionYear + "season" + movieInfo.session, ""))) {
                    }
                }
                if (!c3.startsWith("/")) {
                    return c3;
                }
                return this.f37410e + c3;
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public String A() {
        return "Pubfilm";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String N = N(movieInfo);
        if (!N.isEmpty()) {
            L(observableEmitter, movieInfo, N);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String N = N(movieInfo);
        if (!N.isEmpty()) {
            L(observableEmitter, movieInfo, N);
        }
    }
}

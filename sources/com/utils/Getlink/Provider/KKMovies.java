package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.android.gms.common.internal.ImagesContract;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class KKMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37353e = Utils.getProvider(41);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        String str2;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        int i2 = 1;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String m2 = HttpHelper.i().m(str, new Map[0]);
        if (z2 || !m2.contains(">404<")) {
            Iterator it2 = Jsoup.b(m2).q0("div.embed_div").g("iframe[data-src]").iterator();
            HashMap hashMap = new HashMap();
            hashMap.put("user-agent", Constants.C);
            while (it2.hasNext()) {
                try {
                    String c2 = ((Element) it2.next()).c("data-src");
                    if (!c2.isEmpty()) {
                        if (c2.startsWith("//")) {
                            try {
                                c2 = "https:" + c2;
                            } catch (Throwable unused) {
                            }
                        }
                        String j2 = BaseProvider.j(c2);
                        if (j2.contains("tomatomatela.club")) {
                            String a2 = Regex.a(c2, "player\\.php\\?\\w+=(.*)", i2);
                            String B = HttpHelper.B(j2 + "/ir/rd.php", "url=" + a2, hashMap);
                            if (B == null || B.isEmpty() || B.contains("cuevana")) {
                                Map[] mapArr = new Map[i2];
                                mapArr[0] = hashMap;
                                String l2 = HttpHelper.i().l(j2 + "/ir/rd.php", "url=" + a2, mapArr);
                                Logger.a("http ------------");
                                HashMap<String, String> E = BaseProvider.E(l2, "https://api.cuevana3.me/ir");
                                if (!E.isEmpty()) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("user-agent", Constants.C);
                                    hashMap2.put("content-type", "application/x-www-form-urlencoded");
                                    hashMap2.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
                                    String B2 = HttpHelper.B(E.get(ImagesContract.URL).toString(), E.get("body").toString(), hashMap2);
                                    String str3 = B2.split("#")[i2];
                                    if (!str3.isEmpty()) {
                                        String replace = Regex.a(HttpHelper.i().m(BaseProvider.j(B2) + "/details.php?v=" + str3, new Map[0]), "file['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", i2).replace("\\/", "/");
                                        if (!replace.isEmpty()) {
                                            boolean n2 = GoogleVideoHelper.n(replace);
                                            if (n2) {
                                                String A = A();
                                                if (n2) {
                                                    str2 = "GoogleVideo";
                                                } else {
                                                    str2 = "CDN";
                                                }
                                                MediaSource mediaSource = new MediaSource(A, str2, false);
                                                if (n2) {
                                                    mediaSource.setPlayHeader(hashMap);
                                                }
                                                mediaSource.setStreamLink(replace);
                                                mediaSource.setQuality("HD");
                                                observableEmitter2.onNext(mediaSource);
                                            } else {
                                                boolean[] zArr = new boolean[i2];
                                                zArr[0] = false;
                                                z(observableEmitter2, replace, "HD", zArr);
                                            }
                                        }
                                    }
                                }
                            } else {
                                boolean[] zArr2 = new boolean[i2];
                                zArr2[0] = false;
                                z(observableEmitter2, B, "HD", zArr2);
                            }
                        } else if (c2.contains("fembed")) {
                            HttpHelper i3 = HttpHelper.i();
                            Map[] mapArr2 = new Map[i2];
                            mapArr2[0] = hashMap;
                            String a3 = Regex.a(Regex.a(i3.m(c2, mapArr2), "location.href=['\"]([^'\"]+)['\"]", i2), "index\\.php[?:/|]?\\w+=(.*)", i2);
                            HttpHelper i4 = HttpHelper.i();
                            StringBuilder sb = new StringBuilder();
                            try {
                                sb.append("h=");
                                sb.append(a3);
                                i2 = 1;
                                String replace2 = Regex.a(i4.l("https://api.cuevana3.me/fembed/api.php", sb.toString(), hashMap), "url['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1).replace("\\/", "/");
                                if (replace2 == null || replace2.isEmpty() || replace2.contains("cuevana")) {
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                    boolean[] zArr3 = new boolean[1];
                                    try {
                                        zArr3[0] = false;
                                        z(observableEmitter2, replace2, "HD", zArr3);
                                    } catch (Throwable unused2) {
                                    }
                                }
                            } catch (Throwable unused3) {
                                i2 = 1;
                            }
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        String replace = TitleHelper.g(movieInfo.name).replace("-", "+");
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.m(this.f37353e + "/search/" + replace, new Map[0])).q0("ul.MovieList").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.r0("h2.Title").v0();
            String v03 = element.r0("span.Year").v0();
            if (TitleHelper.f(v02).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName()))) && v03.equals(movieInfo.year)) {
                String c2 = element.c("href");
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37353e + c2;
            }
        }
        return "";
    }

    public String A() {
        return "KKMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Logger.a(this.f37353e);
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K, movieInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str = this.f37353e + "/episodio/" + TitleHelper.h(movieInfo.name.toLowerCase(Locale.ROOT), "-") + "-" + movieInfo.session + "x" + movieInfo.eps;
        if (!str.isEmpty()) {
            J(observableEmitter, str, movieInfo);
        }
    }
}

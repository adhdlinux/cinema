package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class BestFlix extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37257e;

    /* renamed from: f  reason: collision with root package name */
    private String f37258f;

    /* renamed from: g  reason: collision with root package name */
    private String f37259g = "HD";

    /* renamed from: h  reason: collision with root package name */
    private boolean f37260h = false;

    public BestFlix() {
        String provider = Utils.getProvider(55);
        this.f37257e = provider;
        this.f37258f = provider;
    }

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, hashMap)).q0("div.les-content").g("a[onclick]").iterator();
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String a2 = Regex.a(element.toString(), "getlink\\(['\"]([^'\"]+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]", 1);
            String a3 = Regex.a(element.toString(), "getlink\\(['\"]([^'\"]+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]", 2);
            String a4 = Regex.a(element.toString(), "getlink\\(['\"]([^'\"]+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]\\s*,\\s*['\"]([^'\"]+)['\"]", 3);
            String replace = Regex.a(HttpHelper.i().m(this.f37257e + String.format("/ajax/get-link.php?id=%s&type=%s&link=%s&season=undefined&episode=undefined", new Object[]{a2, a4, a3}), new Map[0]).replace("\\", ""), "<iframe[^>]+src=['\"]([^'\"]+)['\"][^>]*>", 1).replace("\\/", "/");
            if (replace.contains("torranforran.")) {
                replace = Regex.a(HttpHelper.i().m(replace, new Map[0]), "<iframe[^>]+src=['\"]([^'\"]+)['\"][^>]*>", 1).replace("\\/", "/");
            }
            if (replace.contains("/streaming.php")) {
                if (replace.startsWith("//")) {
                    replace = "https:" + replace;
                }
                Iterator it3 = n(replace, str).iterator();
                while (it3.hasNext()) {
                    String obj = it3.next().toString();
                    if (!arrayList.contains(obj)) {
                        arrayList.add(obj);
                        boolean n2 = GoogleVideoHelper.n(obj);
                        String A = A();
                        if (n2) {
                            str6 = "GoogleVideo";
                        } else {
                            str6 = "CDN-FastServer";
                        }
                        MediaSource mediaSource = new MediaSource(A, str6, false);
                        mediaSource.setStreamLink(obj);
                        if (n2) {
                            mediaSource.setPlayHeader(hashMap);
                        }
                        if (n2) {
                            str7 = GoogleVideoHelper.h(obj);
                        } else {
                            str7 = this.f37259g;
                        }
                        mediaSource.setQuality(str7);
                        observableEmitter.onNext(mediaSource);
                    }
                }
            } else if (HandleMore.b(replace)) {
                Iterator<String> it4 = HandleMore.d(replace, str).iterator();
                while (it4.hasNext()) {
                    String obj2 = it4.next().toString();
                    if (!arrayList.contains(obj2)) {
                        arrayList.add(obj2);
                        boolean n3 = GoogleVideoHelper.n(obj2);
                        String A2 = A();
                        if (n3) {
                            str4 = "GoogleVideo";
                        } else {
                            str4 = "CDN-FastServer";
                        }
                        MediaSource mediaSource2 = new MediaSource(A2, str4, false);
                        mediaSource2.setStreamLink(obj2);
                        if (n3) {
                            mediaSource2.setPlayHeader(hashMap);
                        }
                        if (n3) {
                            str5 = GoogleVideoHelper.h(obj2);
                        } else {
                            str5 = this.f37259g;
                        }
                        mediaSource2.setQuality(str5);
                        observableEmitter.onNext(mediaSource2);
                    }
                }
            } else if (HandleMore.a(replace)) {
                for (String obj3 : HandleMore.c(replace, str)) {
                    String obj4 = obj3.toString();
                    if (!arrayList.contains(obj4)) {
                        arrayList.add(obj4);
                        boolean n4 = GoogleVideoHelper.n(obj4);
                        String A3 = A();
                        if (n4) {
                            str2 = "GoogleVideo";
                        } else {
                            str2 = "CDN-FastServer";
                        }
                        MediaSource mediaSource3 = new MediaSource(A3, str2, false);
                        mediaSource3.setStreamLink(obj4);
                        if (n4) {
                            mediaSource3.setPlayHeader(hashMap);
                        }
                        if (n4) {
                            str3 = GoogleVideoHelper.h(obj4);
                        } else {
                            str3 = this.f37259g;
                        }
                        mediaSource3.setQuality(str3);
                        observableEmitter.onNext(mediaSource3);
                    }
                }
            }
        }
    }

    private void K(ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        String str9 = str;
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str9, hashMap)).q0("div.pas-list").g("li").iterator();
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            Element r02 = element.r0(a.f20042a);
            if (element.c("id").equals(str2)) {
                if (str9.startsWith("/")) {
                    str9 = this.f37257e + str9;
                }
                String c2 = r02.c("player-data");
                if (c2.contains("vidcloud.icu/streaming.php")) {
                    if (c2.startsWith("//")) {
                        c2 = "https:" + c2;
                    }
                    Iterator it3 = n(c2, str9).iterator();
                    while (it3.hasNext()) {
                        String obj = it3.next().toString();
                        if (!arrayList.contains(obj)) {
                            arrayList.add(obj);
                            boolean n2 = GoogleVideoHelper.n(obj);
                            String A = A();
                            if (n2) {
                                str7 = "GoogleVideo";
                            } else {
                                str7 = "CDN-FastServer";
                            }
                            MediaSource mediaSource = new MediaSource(A, str7, false);
                            mediaSource.setStreamLink(obj);
                            if (n2) {
                                mediaSource.setPlayHeader(hashMap);
                            }
                            if (n2) {
                                str8 = GoogleVideoHelper.h(obj);
                            } else {
                                str8 = this.f37259g;
                            }
                            mediaSource.setQuality(str8);
                            observableEmitter2.onNext(mediaSource);
                        }
                    }
                } else if (!c2.contains("vidcloud")) {
                    if (!arrayList.contains(c2)) {
                        z(observableEmitter2, c2, this.f37259g, false);
                    }
                } else if (HandleMore.b(c2)) {
                    Iterator<String> it4 = HandleMore.d(c2, str9).iterator();
                    while (it4.hasNext()) {
                        String obj2 = it4.next().toString();
                        if (!arrayList.contains(obj2)) {
                            arrayList.add(obj2);
                            boolean n3 = GoogleVideoHelper.n(obj2);
                            String A2 = A();
                            if (n3) {
                                str5 = "GoogleVideo";
                            } else {
                                str5 = "CDN-FastServer";
                            }
                            MediaSource mediaSource2 = new MediaSource(A2, str5, false);
                            mediaSource2.setStreamLink(obj2);
                            if (n3) {
                                mediaSource2.setPlayHeader(hashMap);
                            }
                            if (n3) {
                                str6 = GoogleVideoHelper.h(obj2);
                            } else {
                                str6 = this.f37259g;
                            }
                            mediaSource2.setQuality(str6);
                            observableEmitter2.onNext(mediaSource2);
                        }
                    }
                } else if (HandleMore.a(c2)) {
                    for (String obj3 : HandleMore.c(c2, str9)) {
                        String obj4 = obj3.toString();
                        if (!arrayList.contains(obj4)) {
                            arrayList.add(obj4);
                            boolean n4 = GoogleVideoHelper.n(obj4);
                            String A3 = A();
                            if (n4) {
                                str3 = "GoogleVideo";
                            } else {
                                str3 = "CDN-FastServer";
                            }
                            MediaSource mediaSource3 = new MediaSource(A3, str3, false);
                            mediaSource3.setStreamLink(obj4);
                            if (n4) {
                                mediaSource3.setPlayHeader(hashMap);
                            }
                            if (n4) {
                                str4 = GoogleVideoHelper.h(obj4);
                            } else {
                                str4 = this.f37259g;
                            }
                            mediaSource3.setQuality(str4);
                            observableEmitter2.onNext(mediaSource3);
                        }
                    }
                }
            }
        }
    }

    private String L(MovieInfo movieInfo) {
        boolean z2;
        String str;
        boolean z3;
        String str2;
        String str3;
        MovieInfo movieInfo2 = movieInfo;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String h2 = TitleHelper.h(movieInfo2.name.toLowerCase(), "-");
        HashMap hashMap = new HashMap();
        String str4 = "accept";
        hashMap.put(str4, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        hashMap.put("referer", this.f37257e + "/");
        hashMap.put("upgrade-insecure-requests", "1");
        hashMap.put("user-agent", Constants.C);
        String str5 = this.f37257e + "/search/" + com.original.tase.utils.Utils.k(movieInfo2.name, new boolean[0]).replace("%20", "+");
        String m2 = HttpHelper.i().m(str5, hashMap);
        Iterator it2 = Jsoup.b(m2).q0("div.ml-item").iterator();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str4, "*/*");
        hashMap2.put("origin", this.f37257e);
        hashMap2.put("referer", str5);
        String str6 = "?link_web=";
        if (!it2.hasNext()) {
            HttpHelper i2 = HttpHelper.i();
            StringBuilder sb = new StringBuilder();
            sb.append("https://api.ocloud.stream/series/movie/search/");
            sb.append(h2);
            sb.append(str6);
            sb.append(com.original.tase.utils.Utils.k(this.f37257e + "/", new boolean[0]));
            m2 = i2.m(sb.toString(), hashMap2);
            it2 = Jsoup.b(m2).q0("div.ml-item").iterator();
        }
        String str7 = movieInfo2.year;
        this.f37260h = false;
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0(a.f20042a);
            String c2 = r02.c("data-url");
            String c3 = r02.c("title");
            if (c3.isEmpty()) {
                c3 = r02.r0("h2").v0();
            }
            String str8 = str7;
            if (z2) {
                z3 = z2;
                if (c3.equals(movieInfo2.name)) {
                    if (!c2.isEmpty()) {
                        if (c2.startsWith("//")) {
                            c2 = "http:" + c2;
                        } else if (c2.startsWith("/")) {
                            c2 = this.f37257e + c2;
                        } else if (!c2.startsWith(UriUtil.HTTP_SCHEME)) {
                            c2 = this.f37257e + "/" + c2;
                        }
                        hashMap2.put(str4, "application/json, text/javascript, */*; q=0.01");
                        HttpHelper i3 = HttpHelper.i();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c2);
                        sb2.append(str6);
                        StringBuilder sb3 = new StringBuilder();
                        str = str4;
                        sb3.append(this.f37257e);
                        sb3.append("/");
                        str2 = str6;
                        sb2.append(com.original.tase.utils.Utils.k(sb3.toString(), new boolean[0]));
                        sb2.append("##forceNoCache##");
                        m2 = i3.m(sb2.toString(), hashMap2).replace("\\\"", "\"").replace("\\/", "/");
                        str3 = Regex.a(m2, "<div\\s+[^>]*class=\"jt-info\"[^>]*>\\s*(\\d{4})\\s*</div>", 1);
                        String a2 = Regex.a(m2, "<div\\s+[^>]*class=\"jtip-quality\"[^>]*>\\s*([\\w\\s]+)\\s*</div>", 1);
                        this.f37260h = o(a2);
                        Regex.a(a2, "(\\d+)", 1).isEmpty();
                    } else {
                        str = str4;
                        str2 = str6;
                        str3 = str8;
                    }
                    if (str3.equals(movieInfo2.year) || m2.isEmpty()) {
                        String c4 = r02.c("href");
                        if (c4.startsWith("//")) {
                            return "http:" + c4;
                        } else if (c4.startsWith("/")) {
                            return this.f37257e + c4;
                        } else if (c4.startsWith(UriUtil.HTTP_SCHEME)) {
                            return c4;
                        } else {
                            return this.f37257e + "/" + c4;
                        }
                    } else {
                        str8 = str3;
                    }
                } else {
                    str = str4;
                    str2 = str6;
                }
                if (c3.equals(movieInfo2.name + " (" + movieInfo2.year + ")")) {
                    String c5 = r02.c("href");
                    if (c5.startsWith("//")) {
                        return "http:" + c5;
                    } else if (c5.startsWith("/")) {
                        return this.f37257e + c5;
                    } else if (c5.startsWith(UriUtil.HTTP_SCHEME)) {
                        return c5;
                    } else {
                        return this.f37257e + "/" + c5;
                    }
                }
            } else {
                z3 = z2;
                str = str4;
                str2 = str6;
                if (TitleHelper.f(c3).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName() + "season" + movieInfo2.session)))) {
                    String c6 = r02.c("href");
                    if (c6.startsWith("//")) {
                        return "http:" + c6;
                    } else if (c6.startsWith("/")) {
                        return this.f37257e + c6;
                    } else if (c6.startsWith(UriUtil.HTTP_SCHEME)) {
                        return c6;
                    } else {
                        return this.f37257e + "/" + c6;
                    }
                }
            }
            str6 = str2;
            str7 = str8;
            z2 = z3;
            str4 = str;
        }
        return "";
    }

    private String M(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String replace = com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        HashMap<String, String> c2 = Constants.c();
        c2.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        c2.put("referer", this.f37257e + "/");
        c2.put("upgrade-insecure-requests", "1");
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.l(this.f37257e + "/ajax/search.php", "keyword=" + replace, c2).replace("\\", "")).q0("li").g("a.ss-title").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.v0();
            if (z2) {
                if (TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, "")) || TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.name.toLowerCase(), ""))) {
                    String c3 = element.c("href");
                    if (!c3.startsWith("/")) {
                        return c3;
                    }
                    return this.f37257e + c3;
                }
            } else {
                if (TitleHelper.h(v02.toLowerCase(), "").equals(TitleHelper.h(movieInfo.name.toLowerCase() + "season" + movieInfo.session, ""))) {
                    String c4 = element.c("href");
                    if (!c4.startsWith("/")) {
                        return c4;
                    }
                    return this.f37257e + c4;
                }
            }
        }
        return "";
    }

    public String A() {
        return "BestFlix";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo);
        if (M.isEmpty()) {
            M = L(movieInfo);
        }
        if (!M.isEmpty()) {
            Logger.a(M);
            J(observableEmitter, M);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            K(observableEmitter, L, movieInfo.eps);
        }
    }
}

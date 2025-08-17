package com.utils.Getlink.Provider;

import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GkPluginsHelper;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BestFilms extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37253e = Utils.getProvider(30);

    /* renamed from: f  reason: collision with root package name */
    private String f37254f = "HD";

    /* renamed from: g  reason: collision with root package name */
    private String f37255g = "";

    /* renamed from: h  reason: collision with root package name */
    private HashMap f37256h = new HashMap();

    public String A() {
        return "BestFilms";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        L(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        L(movieInfo, observableEmitter);
    }

    public String J(String str) {
        String c2 = Regex.c(str, "decode\\(\"([^\"]+)\"", 1, true);
        try {
            return new String(Base64.decode(c2, 0), "UTF-8");
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            try {
                return new String(Base64.decode(c2, 0));
            } catch (Exception e3) {
                Logger.d(e3, new boolean[0]);
                return "";
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        r0 = org.jsoup.Jsoup.b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String K(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.f37253e
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L_0x001a
            return r5
        L_0x001a:
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r1 = 0
            java.util.Map[] r2 = new java.util.Map[r1]
            java.lang.String r0 = r0.m(r5, r2)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x006d
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r2 = "div#media-player"
            org.jsoup.nodes.Element r2 = r0.r0(r2)
            if (r2 != 0) goto L_0x0038
            goto L_0x006d
        L_0x0038:
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r4.J(r2)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x005f
            org.jsoup.nodes.Document r2 = org.jsoup.Jsoup.b(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = "iframe[src]"
            org.jsoup.nodes.Element r2 = r2.r0(r3)     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x005f
            java.lang.String r3 = "src"
            java.lang.String r5 = r2.c(r3)     // Catch:{ Exception -> 0x0059 }
            return r5
        L_0x0059:
            r2 = move-exception
            boolean[] r1 = new boolean[r1]
            com.original.tase.Logger.d(r2, r1)
        L_0x005f:
            java.lang.String r1 = "a[href][target=\"_blank\"]"
            org.jsoup.nodes.Element r0 = r0.r0(r1)
            if (r0 == 0) goto L_0x006d
            java.lang.String r5 = "href"
            java.lang.String r5 = r0.c(r5)
        L_0x006d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.BestFilms.K(java.lang.String):java.lang.String");
    }

    public void L(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        String str;
        Iterator it2;
        String str2;
        String str3;
        String str4;
        boolean z3;
        MovieInfo movieInfo2 = movieInfo;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String str5 = "entervideo.net";
        String m2 = HttpHelper.i().m(this.f37253e + "/search-movies/" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]) + ".html", new Map[0]);
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it3 = Jsoup.b(m2).q0("div.ml-item").iterator();
        while (true) {
            if (!it3.hasNext()) {
                str = "";
                break;
            }
            Element element = (Element) it3.next();
            if (element.q0("a[href]").size() > 0) {
                str = element.q0("a[href]").c().c("href");
            } else {
                str = "";
            }
            String a2 = Regex.a(element.toString(), "onmouseover=\"([^\"]+)", 1);
            if (!a2.isEmpty() && !str.isEmpty()) {
                String a3 = Regex.a(a2, "<b>\\s*(?:<i>)?\\s*(.*?)\\s*(?:</i>)?\\s*</b>", 1);
                String a4 = Regex.a(a3, "(.*?)\\s+\\((\\d{4})\\)", 1);
                if (!a4.isEmpty()) {
                    a3 = a4;
                }
                String a5 = Regex.a(a2, "(.*?)\\s+\\((\\d{4})\\)", 2);
                if (a5.isEmpty()) {
                    a5 = Regex.a(a2, "\\s+(\\d{4})</b>", 1).trim();
                }
                if (a5.isEmpty()) {
                    a5 = Regex.a(a2, ">Release:\\s*(\\d{4})", 1).trim();
                }
                if (z2) {
                    if (TitleHelper.d(movieInfo.getName()).equals(TitleHelper.d(a3))) {
                        if (a5.trim().isEmpty() || !com.original.tase.utils.Utils.o(a5.trim()) || movieInfo.getYear().intValue() <= 0 || Integer.parseInt(a5.trim()) == movieInfo.getYear().intValue() || Integer.parseInt(a5.trim()) + 1 == movieInfo.getYear().intValue()) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    String name = movieInfo.getName();
                    Locale locale = Locale.ROOT;
                    sb.append(name.toLowerCase(locale));
                    sb.append("season");
                    sb.append(movieInfo2.session);
                    if (TitleHelper.h(sb.toString(), "").equals(TitleHelper.h(a3.toLowerCase(locale), ""))) {
                        break;
                    }
                }
            }
        }
        if (!str.isEmpty()) {
            if (str.startsWith("//")) {
                str = "http:" + str;
            } else if (str.startsWith("/")) {
                str = this.f37253e + "" + str;
            } else if (!str.startsWith(UriUtil.HTTP_SCHEME)) {
                str = this.f37253e + "/" + str;
            }
            Document b2 = Jsoup.b(HttpHelper.i().m(str, new Map[0]));
            if (!z2) {
                Iterator it4 = b2.q0("div#details").g("a.episode.episode_series_link").iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z3 = false;
                        break;
                    }
                    Element element2 = (Element) it4.next();
                    it2 = it4;
                    if (element2.v0().trim().equals(movieInfo2.eps)) {
                        String c2 = element2.c("href");
                        if (c2.startsWith("//")) {
                            c2 = "http:" + c2;
                        } else if (c2.startsWith("/")) {
                            c2 = this.f37253e + "" + c2;
                        } else if (!c2.startsWith(UriUtil.HTTP_SCHEME)) {
                            c2 = this.f37253e + "/" + c2;
                        }
                        str = c2;
                        b2 = Jsoup.b(HttpHelper.i().m(str, new Map[0]));
                        z3 = true;
                    } else {
                        it4 = it2;
                    }
                }
                if (!z3) {
                    return;
                }
            }
            Elements q02 = b2.q0("p.server_play");
            Elements q03 = b2.q0("p.server_servername");
            int i2 = 0;
            while (i2 < q02.size() && !observableEmitter.isDisposed()) {
                try {
                    Element element3 = (Element) q02.get(i2);
                    Element element4 = (Element) q03.get(i2);
                    if (element3.q0("a[href]").size() > 0) {
                        str3 = element3.q0("a[href]").c().c("href");
                    } else {
                        str3 = "";
                    }
                    String replace = element4.toString().replaceAll("^Server\\s*", "").replaceAll("^server\\s*", "").replaceAll("\\s*Link\\s+\\d+", "").toLowerCase().replace("dailymotion", "idowatch.net").replace("veoh", str5).replace("mega", str5);
                    if (!str3.isEmpty()) {
                        if (str3.startsWith("/")) {
                            str3 = this.f37253e + "" + str3;
                        }
                        if (replace.equals("google")) {
                            HttpHelper.i().m(str3, new Map[0]);
                            String a6 = Regex.a(this.f37253e, "\\{\\s*link\\s*:\\s*\"([^\"]+)", 1);
                            if (!a6.isEmpty()) {
                                HashMap<String, String> c3 = Constants.c();
                                c3.put("Referer", str);
                                String str6 = "link=" + a6;
                                str2 = str5;
                                try {
                                    for (Map.Entry next : GkPluginsHelper.a(HttpHelper.i().l(this.f37253e + "/media/plugins/gkpluginsphp.php", str6, c3)).entrySet()) {
                                        String str7 = (String) next.getKey();
                                        String str8 = (String) next.getValue();
                                        String A = A();
                                        if (GoogleVideoHelper.d(str7)) {
                                            str4 = "GoogleVideo";
                                        } else {
                                            str4 = "CDN";
                                        }
                                        String str9 = str4;
                                        it2 = q02;
                                        try {
                                            MediaSource mediaSource = new MediaSource(A, str9, false);
                                            mediaSource.setStreamLink(str7);
                                            mediaSource.setQuality(str8);
                                            observableEmitter2.onNext(mediaSource);
                                            q02 = it2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            Logger.d(e, new boolean[0]);
                                            i2++;
                                            str5 = str2;
                                            q02 = it2;
                                        }
                                    }
                                    it2 = q02;
                                } catch (Exception e3) {
                                    e = e3;
                                    it2 = q02;
                                    Logger.d(e, new boolean[0]);
                                    i2++;
                                    str5 = str2;
                                    q02 = it2;
                                }
                                i2++;
                                str5 = str2;
                                q02 = it2;
                            }
                        } else {
                            str2 = str5;
                            it2 = q02;
                            z(observableEmitter2, K(str3), "HD", new boolean[0]);
                            i2++;
                            str5 = str2;
                            q02 = it2;
                        }
                    }
                    str2 = str5;
                    it2 = q02;
                } catch (Exception e4) {
                    e = e4;
                    str2 = str5;
                    it2 = q02;
                    Logger.d(e, new boolean[0]);
                    i2++;
                    str5 = str2;
                    q02 = it2;
                }
                i2++;
                str5 = str2;
                q02 = it2;
            }
        }
    }
}

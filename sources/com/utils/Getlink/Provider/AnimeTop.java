package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AnimeTop extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String[] f37245e = Utils.getProvider(80).split(",");

    /* renamed from: f  reason: collision with root package name */
    public String f37246f;

    private void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        boolean z2;
        Iterator it2;
        boolean z3;
        String str2;
        AnimeTop animeTop;
        ObservableEmitter<? super MediaSource> observableEmitter2;
        AnimeTop animeTop2 = this;
        ObservableEmitter<? super MediaSource> observableEmitter3 = observableEmitter;
        String str3 = str;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String a2 = Regex.a(str3, "\\/.*\\.(\\w+)", 1);
        if (!a2.isEmpty()) {
            String str4 = "/";
            if (str3.startsWith(str4)) {
                str3 = animeTop2.f37246f + str3;
            }
            String g2 = DateTimeHelper.g();
            Document b2 = Jsoup.b(HttpHelper.i().o(animeTop2.f37246f + "/ajax/film/servers/" + a2 + "?ts=" + g2 + "&_=632", str3).replaceAll("(\r\n|\n)", ""));
            if (!z2) {
                it2 = b2.q0("li").g(a.f20042a).iterator();
            } else {
                it2 = null;
            }
            Iterator it3 = b2.q0("div[class*=server]").iterator();
            HashMap<String, String> c2 = Constants.c();
            c2.put("referer", str3);
            while (it3.hasNext()) {
                Element element = (Element) it3.next();
                String str5 = "\\n";
                String replace = element.c("data-id").replace("\\\"", "").replace(str5, "");
                Iterator it4 = it3;
                Iterator it5 = it2;
                String str6 = "/ajax/episode/info?ts=%s&_=%s&id=%s&server=%s";
                String str7 = "HD";
                String str8 = HlsSegmentFormat.TS;
                CharSequence charSequence = "\\/";
                String str9 = "0";
                String str10 = str4;
                String str11 = "['\"]target['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]";
                HashMap<String, String> hashMap = c2;
                if (z2) {
                    String replace2 = element.r0(a.f20042a).c("data-id").replace("\\\"", "").replace(str5, "");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("id", replace2);
                    linkedHashMap.put("server", replace);
                    linkedHashMap.put("update", str9);
                    linkedHashMap.put(str8, g2);
                    int L = animeTop2.L(linkedHashMap);
                    str2 = str10;
                    ObservableEmitter<? super MediaSource> observableEmitter4 = observableEmitter;
                    animeTop2.z(observableEmitter4, Regex.a(HttpHelper.i().m(String.format(animeTop2.f37246f + str6, new Object[]{g2, Integer.valueOf(L), replace2, replace}), hashMap), str11, 1).replace(charSequence, str2), str7, false);
                    z3 = z2;
                    observableEmitter2 = observableEmitter4;
                    animeTop = animeTop2;
                } else {
                    z3 = z2;
                    String str12 = str7;
                    String str13 = str10;
                    String str14 = str11;
                    while (true) {
                        while (it5.hasNext()) {
                            Element element2 = (Element) it5.next();
                            String str15 = str14;
                            String str16 = str6;
                            if (!movieInfo.eps.equalsIgnoreCase(element2.c("data-base").replace("\\\"", "").replace(str5, ""))) {
                                animeTop2 = this;
                                str6 = str16;
                                str14 = str15;
                            } else {
                                String replace3 = element2.r0(a.f20042a).c("data-id").replace("\\\"", "").replace(str5, "");
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                linkedHashMap2.put("id", replace3);
                                linkedHashMap2.put("server", replace);
                                linkedHashMap2.put("update", str9);
                                linkedHashMap2.put(str8, g2);
                                int L2 = L(linkedHashMap2);
                                String m2 = HttpHelper.i().m(String.format(this.f37246f + str16, new Object[]{g2, Integer.valueOf(L2), replace3, replace}), hashMap);
                                String str17 = str15;
                                z(observableEmitter, Regex.a(m2, str17, 1).replace(charSequence, str13), str12, false);
                                str14 = str17;
                                animeTop2 = this;
                                str6 = str16;
                                str9 = str9;
                                str8 = str8;
                                str5 = str5;
                            }
                        }
                        break;
                    }
                    observableEmitter2 = observableEmitter;
                    animeTop = animeTop2;
                    str2 = str13;
                }
                it3 = it4;
                ObservableEmitter<? super MediaSource> observableEmitter5 = observableEmitter2;
                animeTop2 = animeTop;
                str4 = str2;
                it2 = it5;
                z2 = z3;
                c2 = hashMap;
            }
            AnimeTop animeTop3 = animeTop2;
        }
    }

    private int K(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 += Character.codePointAt(str, i3) + i3;
        }
        return i2;
    }

    private int L(Map<String, String> map) {
        int i2;
        try {
            int K = K("f2d16d4e");
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getValue();
                String str2 = "f2d16d4e" + ((String) next.getKey());
                int i3 = 0;
                for (int i4 = 0; i4 < Math.max(str2.length(), str.length()); i4++) {
                    if (i4 < str.length()) {
                        i2 = i3 + Character.codePointAt(str, i4);
                    } else {
                        i2 = i3 + 0;
                    }
                    if (i4 < str2.length()) {
                        i3 = i2 + Character.codePointAt(str2, i4);
                    } else {
                        i3 = i2 + 0;
                    }
                }
                K += K(Integer.toHexString(i3));
            }
            return K;
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return -1;
        }
    }

    private String M(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it2 = Jsoup.b(HttpHelper.i().o(String.format(this.f37246f + "/search?keyword=%s", new Object[]{TitleHelper.h(movieInfo.name, "+")}), this.f37246f + "/")).q0("div.item").g("a[data-jtitle]").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.v0();
            if (z2) {
                if (TitleHelper.f(v02).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName())))) {
                    String c2 = element.c("href");
                    if (!c2.startsWith("/")) {
                        return c2;
                    }
                    return this.f37246f + c2;
                }
            } else if (movieInfo.getSession().intValue() != 1 || !TitleHelper.f(v02).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName())))) {
                if (TitleHelper.f(v02).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName() + " Season " + movieInfo.session)))) {
                    String c3 = element.c("href");
                    if (!c3.startsWith("/")) {
                        return c3;
                    }
                    return this.f37246f + c3;
                }
            } else {
                String c4 = element.c("href");
                if (!c4.startsWith("/")) {
                    return c4;
                }
                return this.f37246f + c4;
            }
        }
        return "";
    }

    public String A() {
        return "AnimeTop";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (f(movieInfo.genres)) {
            for (String str : this.f37245e) {
                this.f37246f = str;
                String M = M(movieInfo);
                if (!M.isEmpty()) {
                    J(movieInfo, observableEmitter, M);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (f(movieInfo.genres)) {
            for (String str : this.f37245e) {
                this.f37246f = str;
                String M = M(movieInfo);
                if (!M.isEmpty()) {
                    J(movieInfo, observableEmitter, M);
                }
            }
        }
    }
}

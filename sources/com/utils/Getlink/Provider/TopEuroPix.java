package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class TopEuroPix extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37469e = Utils.getProvider(114);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String str2;
        Iterator it2;
        Duktape duktape;
        String replace;
        String str3;
        Iterator it3;
        int i2;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String str4 = str;
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        String m2 = HttpHelper.i().m(str4, hashMap);
        Iterator it4 = Regex.f(m2, "src\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0).iterator();
        boolean z2 = false;
        while (it4.hasNext()) {
            String str5 = (String) it4.next();
            if (str5.startsWith("../svop")) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f37469e);
                it3 = it4;
                sb.append(str5.replace("..", ""));
                String sb2 = sb.toString();
                if (sb2.startsWith("//")) {
                    sb2 = "https:" + sb2;
                }
                try {
                    String m3 = HttpHelper.i().m(sb2, hashMap);
                    String c2 = Jsoup.b(m3).r0("iframe").c("src");
                    if (c2.isEmpty()) {
                        i2 = 1;
                        c2 = Regex.a(m3, "https:\\/\\/www.rapidvideo.com\\/e\\/\\w+", 1);
                    } else {
                        i2 = 1;
                    }
                    if (!c2.isEmpty()) {
                        boolean[] zArr = new boolean[i2];
                        zArr[0] = false;
                        z(observableEmitter2, c2, "HD", zArr);
                    }
                    z2 = true;
                } catch (Exception unused) {
                }
            } else {
                it3 = it4;
            }
            it4 = it3;
        }
        if (!z2) {
            String str6 = Regex.a(m2, "(function\\s*change\\(id\\).+?\\r?\\n[\\s\\S]+)+document.getElementById.*src\\s*=\\s*src;", 1) + "return src;}";
            String replace2 = Jsoup.b(m2).r0("div#changeserv").r0("script").c("src").replace("../", "/").replace("//", "/");
            HttpHelper i3 = HttpHelper.i();
            StringBuilder sb3 = new StringBuilder();
            String str7 = str6;
            sb3.append(this.f37469e);
            sb3.append(replace2);
            String a2 = Regex.a(i3.o(sb3.toString(), str4), "document.write\\(unescape\\(['\"](.*)['\"]\\)", 1);
            if (!a2.isEmpty()) {
                try {
                    str2 = URLDecoder.decode(a2, "UTF-8");
                } catch (UnsupportedEncodingException unused2) {
                    str2 = URLDecoder.decode(a2);
                }
                Iterator it5 = Jsoup.b(str2).q0("a[onclick]").iterator();
                Duktape create = Duktape.create();
                String str8 = str7;
                while (it5.hasNext()) {
                    try {
                        Element element = (Element) it5.next();
                        boolean o2 = o(element.r0("span#qual").v0());
                        it2 = it5;
                        try {
                            str8 = str8 + element.c("onclick") + ";";
                            try {
                                replace = create.evaluate(str8).toString().replace("../", "/");
                                if (replace.startsWith("//")) {
                                    try {
                                        replace = "https:" + replace;
                                    } catch (Throwable unused3) {
                                        duktape = create;
                                        it5 = it2;
                                        create = duktape;
                                    }
                                }
                                if (replace.startsWith("/")) {
                                    try {
                                        StringBuilder sb4 = new StringBuilder();
                                        duktape = create;
                                        try {
                                            sb4.append(this.f37469e);
                                            sb4.append(replace);
                                            replace = sb4.toString();
                                        } catch (Throwable unused4) {
                                        }
                                    } catch (Throwable unused5) {
                                        duktape = create;
                                        it5 = it2;
                                        create = duktape;
                                    }
                                } else {
                                    duktape = create;
                                }
                            } catch (Throwable unused6) {
                                duktape = create;
                                String str9 = str8;
                                it5 = it2;
                                create = duktape;
                            }
                            try {
                                if (g(replace)) {
                                    z(observableEmitter2, replace, "HD", o2);
                                } else if (!replace.contains("youtube")) {
                                    try {
                                        HttpHelper i4 = HttpHelper.i();
                                        str3 = str8;
                                        try {
                                            Map[] mapArr = new Map[1];
                                            try {
                                                mapArr[0] = hashMap;
                                                String m4 = i4.m(replace, mapArr);
                                                String c3 = Jsoup.b(m4).r0("iframe").c("src");
                                                if (c3.isEmpty()) {
                                                    try {
                                                        c3 = Regex.a(m4, "https:\\/\\/www.rapidvideo.com\\/e\\/\\w+", 1);
                                                    } catch (Throwable unused7) {
                                                    }
                                                }
                                                if (!c3.isEmpty()) {
                                                    boolean[] zArr2 = new boolean[1];
                                                    try {
                                                        zArr2[0] = o2;
                                                        z(observableEmitter2, c3, "HD", zArr2);
                                                    } catch (Throwable unused8) {
                                                    }
                                                    it5 = it2;
                                                    create = duktape;
                                                    str8 = str3;
                                                }
                                            } catch (Throwable unused9) {
                                                it5 = it2;
                                                create = duktape;
                                                str8 = str3;
                                            }
                                        } catch (Throwable unused10) {
                                            it5 = it2;
                                            create = duktape;
                                            str8 = str3;
                                        }
                                    } catch (Throwable unused11) {
                                        str3 = str8;
                                        it5 = it2;
                                        create = duktape;
                                        str8 = str3;
                                    }
                                    it5 = it2;
                                    create = duktape;
                                    str8 = str3;
                                }
                                str3 = str8;
                                it5 = it2;
                                create = duktape;
                                str8 = str3;
                            } catch (Throwable unused12) {
                                String str92 = str8;
                                it5 = it2;
                                create = duktape;
                            }
                        } catch (Throwable unused13) {
                            duktape = create;
                            it5 = it2;
                            create = duktape;
                        }
                    } catch (Throwable unused14) {
                        it2 = it5;
                        duktape = create;
                        it5 = it2;
                        create = duktape;
                    }
                }
            }
        }
    }

    private String K(MovieInfo movieInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37469e + "/search?search=" + com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("%20", "+"), hashMap).replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "")).q0("div.movsbox").g("figure").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String a2 = Regex.a(element.toString(), "<h3> (.*) </h3>", 1);
            String replace = element.r0(a.f20042a).c("href").replace("../", "/").replace("//", "/").replace("//", "/");
            String a3 = Regex.a(element.toString(), "\\((\\w+)\\)", 1);
            if (a3.isEmpty()) {
                a3 = replace;
            }
            if (a2.equalsIgnoreCase(movieInfo.name) && a3.contains(movieInfo.year) && replace.startsWith("/")) {
                return this.f37469e + replace;
            }
        }
        return "";
    }

    public String A() {
        return "TopEuroPix";
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
}

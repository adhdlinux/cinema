package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.google.android.gms.cast.MediaTrack;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TwoDDL extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37474e = Utils.getProvider(97);

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, String> f37475f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private String f37476g = Utils.getProvider(97);

    public TwoDDL() {
        this.f37475f.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        this.f37475f.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.9,en;q=0.8");
        HashMap<String, String> hashMap = this.f37475f;
        hashMap.put("Referer", this.f37476g + "/");
        this.f37475f.put("upgrade-insecure-requests", "1");
        this.f37475f.put("User-Agent", Constants.C);
    }

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str, String str2) {
        boolean z2;
        String str3;
        String str4;
        int i2;
        boolean z3;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String str5;
        Iterator it2;
        String str6;
        String str7;
        MovieInfo movieInfo2 = movieInfo;
        String str8 = "title";
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        if (z2) {
            str3 = "";
        } else {
            str3 = "S" + com.original.tase.utils.Utils.i(Integer.parseInt(str)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(str2));
        }
        String name = movieInfo.getName();
        if (z2) {
            str4 = "";
        } else {
            str4 = str3;
        }
        String replace = (name.replace("'", "") + " " + str4).replaceAll("(\\\\\\|/| -|:|;|\\*|\\?|\"|\\'|<|>|\\|)", " ").replace("  ", " ");
        String str9 = this.f37476g + "/search/" + com.original.tase.utils.Utils.k(replace.trim(), new boolean[0]);
        String m2 = HttpHelper.i().m(str9, this.f37475f);
        HashMap hashMap = new HashMap();
        Iterator it3 = Jsoup.b(m2).q0("div.wrap-main-content").g("a[href]").iterator();
        ArrayList arrayList = new ArrayList();
        while (it3.hasNext()) {
            try {
                Element element = (Element) it3.next();
                if (element != null) {
                    String c2 = element.c("href");
                    if (!arrayList.contains(c2)) {
                        arrayList.add(c2);
                        if (element.p(str8)) {
                            str7 = element.c(str8);
                        } else {
                            str7 = element.v0();
                        }
                        String replaceAll = str7.replaceAll("\\<[uibp]\\>", "").replaceAll("\\</[uibp]\\>", "");
                        String lowerCase = replaceAll.toLowerCase();
                        if (z2) {
                            str6 = str8;
                            try {
                                if (!lowerCase.contains(" cam") && !lowerCase.contains("cam ") && !lowerCase.contains("hdts ") && !lowerCase.contains(" hdts") && !lowerCase.contains(" ts ") && !lowerCase.contains(" telesync") && !lowerCase.contains("telesync ") && !lowerCase.contains("hdtc ") && !lowerCase.contains(" hdtc") && !lowerCase.contains(" tc ") && !lowerCase.contains(" telecine") && !lowerCase.contains("telecine ")) {
                                }
                            } catch (Exception e2) {
                                e = e2;
                                it2 = it3;
                                Logger.d(e, new boolean[0]);
                                it3 = it2;
                                str8 = str6;
                            }
                        } else {
                            str6 = str8;
                        }
                        if (c2.startsWith("//")) {
                            c2 = "http:" + c2;
                        } else if (c2.startsWith("/")) {
                            c2 = this.f37476g + c2;
                        }
                        if (replaceAll.toLowerCase().startsWith("goto")) {
                            replaceAll = replaceAll.substring(4, replaceAll.length()).trim();
                        }
                        if (z2) {
                            String f2 = TitleHelper.f(replaceAll);
                            StringBuilder sb = new StringBuilder();
                            it2 = it3;
                            try {
                                sb.append(TitleHelper.e(movieInfo.getName()));
                                sb.append(movieInfo2.year);
                                if (f2.startsWith(TitleHelper.f(sb.toString()))) {
                                    hashMap.put(c2, replaceAll);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                Logger.d(e, new boolean[0]);
                                it3 = it2;
                                str8 = str6;
                            }
                        } else {
                            it2 = it3;
                            if (TitleHelper.h(replaceAll.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str3.toLowerCase(), ""))) {
                                hashMap.put(c2, replaceAll);
                            }
                        }
                        it3 = it2;
                        str8 = str6;
                    }
                } else {
                    str6 = str8;
                }
                it2 = it3;
            } catch (Exception e4) {
                e = e4;
                str6 = str8;
                it2 = it3;
                Logger.d(e, new boolean[0]);
                it3 = it2;
                str8 = str6;
            }
            it3 = it2;
            str8 = str6;
        }
        if (!hashMap.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                try {
                    String str10 = (String) entry.getKey();
                    try {
                        Document b2 = Jsoup.b(HttpHelper.i().r(str10, str9, this.f37475f));
                        Iterator it4 = b2.q0("div.single-link").g(a.f20042a).iterator();
                        while (it4.hasNext()) {
                            String c3 = ((Element) it4.next()).c("href");
                            if (!c3.isEmpty()) {
                                hashMap2.put(c3, (String) entry.getValue());
                            }
                        }
                        Iterator it5 = b2.q0("div.multi-link").g(a.f20042a).iterator();
                        while (it5.hasNext()) {
                            String c4 = ((Element) it5.next()).c("href");
                            if (!c4.isEmpty()) {
                                hashMap2.put(c4, (String) entry.getValue());
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        Logger.d(e, new boolean[0]);
                    }
                } catch (Exception e6) {
                    e = e6;
                    Logger.d(e, new boolean[0]);
                }
            }
            if (!hashMap2.isEmpty()) {
                for (Map.Entry entry2 : hashMap2.entrySet()) {
                    try {
                        String str11 = (String) entry2.getKey();
                        String str12 = (String) entry2.getValue();
                        if (!str11.contains(".7z") && !str11.contains(".rar") && !str11.contains(".zip") && !str11.contains(".iso") && !str11.contains(".avi") && !str11.contains(".flv") && !str11.contains("imdb.")) {
                            String[] split = str12.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                            int length = split.length;
                            String str13 = "HQ";
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    z3 = false;
                                    break;
                                }
                                String lowerCase2 = split[i3].toLowerCase();
                                if (lowerCase2.endsWith("subs") || lowerCase2.endsWith("sub") || lowerCase2.endsWith("dubbed") || lowerCase2.endsWith(MediaTrack.ROLE_DUB) || lowerCase2.contains("dvdscr") || lowerCase2.contains("r5") || lowerCase2.contains("r6") || lowerCase2.contains("camrip") || lowerCase2.contains("tsrip") || lowerCase2.contains("hdcam") || lowerCase2.contains("hdts") || lowerCase2.contains("dvdcam") || lowerCase2.contains("dvdts") || lowerCase2.contains("cam") || lowerCase2.contains("telesync")) {
                                    break;
                                } else if (lowerCase2.contains(HlsSegmentFormat.TS)) {
                                    break;
                                } else {
                                    if (!lowerCase2.contains("1080p")) {
                                        if (!lowerCase2.equals("1080")) {
                                            if (lowerCase2.contains("720p") || lowerCase2.equals("720") || lowerCase2.contains("brrip") || lowerCase2.contains("bdrip") || lowerCase2.contains("hdrip") || lowerCase2.contains("web-dl")) {
                                                str13 = "HD";
                                                i3++;
                                            } else {
                                                i3++;
                                            }
                                        }
                                    }
                                    str13 = "1080p";
                                    i3++;
                                }
                            }
                            z3 = true;
                            if (!z3) {
                                String A = A();
                                if (z2) {
                                    parsedLinkModel = directoryIndexHelper.c(str12);
                                } else {
                                    parsedLinkModel = directoryIndexHelper.d(str12);
                                }
                                if (parsedLinkModel != null) {
                                    String c5 = parsedLinkModel.c();
                                    if (!c5.equalsIgnoreCase("HQ")) {
                                        str13 = c5;
                                    }
                                    str5 = t(parsedLinkModel.b());
                                } else {
                                    str5 = A;
                                }
                                i2 = 0;
                                try {
                                    x(observableEmitter, str11, str13, str5, new boolean[0]);
                                } catch (Exception e7) {
                                    e = e7;
                                    Logger.d(e, new boolean[i2]);
                                }
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i2 = 0;
                    }
                }
            }
        }
    }

    public String A() {
        return "TwoDDL";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, "-1", "-1");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
        }
    }
}

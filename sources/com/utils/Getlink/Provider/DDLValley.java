package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.google.android.gms.cast.MediaTrack;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.search.SearchHelper;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DDLValley extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f37291e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private String f37292f = Utils.getProvider(99);

    public DDLValley() {
        this.f37291e.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        this.f37291e.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.9,en;q=0.8");
        this.f37291e.put("Upgrade-Insecure-Requests", "1");
    }

    private void L(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str, String str2) {
        boolean z2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Element r02;
        Iterator it2;
        String str9;
        String str10;
        String str11;
        MovieInfo movieInfo2 = movieInfo;
        String str12 = "title";
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str3 = "";
        } else {
            str3 = "S" + com.original.tase.utils.Utils.i(Integer.parseInt(str)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(str2));
        }
        String name = movieInfo.getName();
        if (z2) {
            str4 = String.valueOf(movieInfo.getYear());
        } else {
            str4 = str3;
        }
        String replace = (name.replace("'", "") + " " + str4).replaceAll("(\\\\\\|/| -|:|;|\\*|\\?|\"|\\'|<|>|\\|)", " ").replace("  ", " ");
        HttpHelper.i().m(this.f37292f, new Map[0]);
        String str13 = this.f37292f + "/?s=" + com.original.tase.utils.Utils.k(replace, new boolean[0]);
        String r2 = HttpHelper.i().r(str13, this.f37292f + "/", this.f37291e);
        if (r2.contains("Attention Required! | Cloudflare")) {
            Logger.b("Need Verify Recaptcha", str13);
            Utils.e(str13, BaseProvider.i(str13));
        }
        List<String> arrayList = new ArrayList<>();
        Element r03 = Jsoup.b(r2).r0("div.pb.fl");
        String str14 = "href";
        if (r03 != null) {
            str5 = "div.pb.fl";
            Iterator it3 = r03.q0("h2").iterator();
            while (it3.hasNext()) {
                try {
                    it2 = it3;
                    try {
                        Element r04 = ((Element) it3.next()).r0("a[href]");
                        if (r04 != null) {
                            String c2 = r04.c(str14);
                            if (r04.p(str12)) {
                                str11 = r04.c(str12);
                            } else {
                                str11 = r04.v0();
                            }
                            String replaceAll = str11.replaceAll("\\<[uibp]\\>", "").replaceAll("\\</[uibp]\\>", "");
                            str10 = str12;
                            try {
                                String lowerCase = replaceAll.toLowerCase();
                                if (z2) {
                                    str9 = str14;
                                    try {
                                        if (!lowerCase.contains(" cam") && !lowerCase.contains("cam ") && !lowerCase.contains("hdts ") && !lowerCase.contains(" hdts") && !lowerCase.contains(" ts ") && !lowerCase.contains(" telesync") && !lowerCase.contains("telesync ") && !lowerCase.contains("hdtc ") && !lowerCase.contains(" hdtc") && !lowerCase.contains(" tc ") && !lowerCase.contains(" telecine") && !lowerCase.contains("telecine ")) {
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        Logger.d(e, new boolean[0]);
                                        it3 = it2;
                                        str12 = str10;
                                        str14 = str9;
                                    }
                                } else {
                                    str9 = str14;
                                }
                                if (c2.startsWith("//")) {
                                    c2 = "http:" + c2;
                                } else if (c2.startsWith("/")) {
                                    c2 = this.f37292f + c2;
                                }
                                if (replaceAll.toLowerCase().startsWith("goto")) {
                                    replaceAll = replaceAll.substring(4, replaceAll.length()).trim();
                                }
                                if (z2) {
                                    if (TitleHelper.h(name.toLowerCase(), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase(), "") + movieInfo2.year)) {
                                        arrayList.add(c2);
                                    }
                                } else {
                                    if (TitleHelper.h(replaceAll.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str3.toLowerCase(), ""))) {
                                        arrayList.add(c2);
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str9 = str14;
                                Logger.d(e, new boolean[0]);
                                it3 = it2;
                                str12 = str10;
                                str14 = str9;
                            }
                        } else {
                            str10 = str12;
                            str9 = str14;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str10 = str12;
                        str9 = str14;
                        Logger.d(e, new boolean[0]);
                        it3 = it2;
                        str12 = str10;
                        str14 = str9;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str10 = str12;
                    str9 = str14;
                    it2 = it3;
                    Logger.d(e, new boolean[0]);
                    it3 = it2;
                    str12 = str10;
                    str14 = str9;
                }
                it3 = it2;
                str12 = str10;
                str14 = str9;
            }
            str6 = str14;
        } else {
            str6 = str14;
            str5 = "div.pb.fl";
        }
        if (arrayList.isEmpty()) {
            arrayList = K(movieInfo2, str4);
        }
        if (arrayList.isEmpty()) {
            arrayList = SearchHelper.c(movieInfo2.name, movieInfo2.year, str4, this.f37292f, "");
        }
        if (!arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (String r3 : arrayList) {
                try {
                    Document b2 = Jsoup.b(HttpHelper.i().r(r3, str13, this.f37291e));
                    Element r05 = b2.r0("div.cont.cl");
                    str8 = str5;
                    if (r05 != null) {
                        try {
                            Element r06 = b2.r0(str8);
                            if (!(r06 == null || (r02 = r06.r0("h1")) == null)) {
                                String replaceAll2 = r02.v0().replaceAll("\\<[uibp]\\>", "").replaceAll("\\</[uibp]\\>", "");
                                Iterator it4 = r05.X().iterator();
                                while (it4.hasNext()) {
                                    Element element = (Element) it4.next();
                                    try {
                                        if (element.toString().contains("span") && element.toString().contains("info2")) {
                                            Iterator it5 = element.q0(a.f20042a).iterator();
                                            while (it5.hasNext()) {
                                                str7 = str6;
                                                try {
                                                    hashMap.put(((Element) it5.next()).c(str7), replaceAll2);
                                                    str6 = str7;
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    try {
                                                        Logger.d(e, new boolean[0]);
                                                        str6 = str7;
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                    }
                                                }
                                            }
                                        }
                                        str7 = str6;
                                    } catch (Exception e8) {
                                        e = e8;
                                        str7 = str6;
                                        Logger.d(e, new boolean[0]);
                                        str6 = str7;
                                    }
                                    str6 = str7;
                                }
                            }
                        } catch (Exception e9) {
                            e = e9;
                            str7 = str6;
                            Logger.d(e, new boolean[0]);
                            str5 = str8;
                            str6 = str7;
                        }
                    }
                    str7 = str6;
                } catch (Exception e10) {
                    e = e10;
                    str8 = str5;
                    str7 = str6;
                    Logger.d(e, new boolean[0]);
                    str5 = str8;
                    str6 = str7;
                }
                str5 = str8;
                str6 = str7;
            }
            if (!hashMap.isEmpty()) {
                J(observableEmitter, movieInfo2, str4, hashMap);
            }
        }
    }

    public String A() {
        return "DDLValley";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            L(observableEmitter, movieInfo, "-1", "-1");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            L(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str, Map<String, String> map) {
        boolean z2;
        boolean z3;
        boolean z4;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        int i2 = 1;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        for (Map.Entry next : map.entrySet()) {
            try {
                String str2 = (String) next.getKey();
                if (!str2.contains(UriUtil.HTTP_SCHEME)) {
                    str2 = this.f37292f + str2;
                }
                String str3 = str2;
                String str4 = (String) next.getValue();
                if (!str3.contains(".7z") && !str3.contains(".rar") && !str3.contains(".zip") && !str3.contains(".iso") && !str3.contains(".avi") && !str3.contains(".flv") && !str3.contains("imdb.")) {
                    if (!z2) {
                        if (str3.contains("/")) {
                            String[] split = str3.split("/");
                            if (split.length > 0) {
                                str4 = str4.replaceAll("(720p|1080p)", "") + " " + split[split.length - i2];
                            }
                        }
                    }
                    if (TitleHelper.f(movieInfo.getName()).equals(TitleHelper.f(str4.replaceAll("(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d+|3D)(\\.|\\)|\\]|\\s|)(.+|)", "")))) {
                        List list = Regex.d(str4, "[\\.|\\(|\\[|\\s]([2-9]0\\d{2}|1[5-9]\\d{2})[\\.|\\)|\\]|\\s]", i2).get(0);
                        if (!z2) {
                            list.addAll(Regex.d(str4, "[\\.|\\(|\\[|\\s](S\\d*E\\d*)[\\.|\\)|\\]|\\s]", i2).get(0));
                            list.addAll(Regex.d(str4, "[\\.|\\(|\\[|\\s](S\\d*)[\\.|\\)|\\]|\\s]", i2).get(0));
                        }
                        if (list.size() > 0) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    String str5 = str;
                                    z3 = false;
                                    break;
                                }
                                try {
                                    if (((String) it2.next()).toUpperCase().equals(str)) {
                                        z3 = true;
                                        break;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    Logger.d(e, new boolean[0]);
                                    i2 = 1;
                                }
                            }
                            if (z3) {
                                String[] split2 = str4.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                                int length = split2.length;
                                String str6 = "HQ";
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= length) {
                                        z4 = false;
                                        break;
                                    }
                                    String lowerCase = split2[i3].toLowerCase();
                                    if (lowerCase.endsWith("subs") || lowerCase.endsWith("sub") || lowerCase.endsWith("dubbed") || lowerCase.endsWith(MediaTrack.ROLE_DUB) || lowerCase.contains("dvdscr") || lowerCase.contains("r5") || lowerCase.contains("r6") || lowerCase.contains("camrip") || lowerCase.contains("tsrip") || lowerCase.contains("hdcam") || lowerCase.contains("hdts") || lowerCase.contains("dvdcam") || lowerCase.contains("dvdts") || lowerCase.contains("cam") || lowerCase.contains("telesync")) {
                                        break;
                                    } else if (lowerCase.contains(HlsSegmentFormat.TS)) {
                                        break;
                                    } else {
                                        if (!lowerCase.contains("1080p")) {
                                            if (!lowerCase.equals("1080")) {
                                                if (lowerCase.contains("720p") || lowerCase.equals("720") || lowerCase.contains("brrip") || lowerCase.contains("bdrip") || lowerCase.contains("hdrip") || lowerCase.contains("web-dl")) {
                                                    str6 = "HD";
                                                    i3++;
                                                } else {
                                                    i3++;
                                                }
                                            }
                                        }
                                        str6 = "1080p";
                                        i3++;
                                    }
                                }
                                z4 = true;
                                if (!z4) {
                                    String A = A();
                                    if (z2) {
                                        parsedLinkModel = directoryIndexHelper.c(str3);
                                    } else {
                                        parsedLinkModel = directoryIndexHelper.d(str3);
                                    }
                                    if (parsedLinkModel != null) {
                                        if (!parsedLinkModel.c().equalsIgnoreCase("HQ")) {
                                            str6 = parsedLinkModel.c();
                                        }
                                        A = t(parsedLinkModel.b());
                                    }
                                    x(observableEmitter, str3, str6, A, new boolean[0]);
                                }
                            }
                            i2 = 1;
                        }
                    }
                }
                String str7 = str;
            } catch (Exception e3) {
                e = e3;
                String str8 = str;
                Logger.d(e, new boolean[0]);
                i2 = 1;
            }
            i2 = 1;
        }
    }

    public List<String> K(MovieInfo movieInfo, String str) {
        boolean z2;
        String str2;
        String str3;
        if (movieInfo.getSession().intValue() < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap<String, String> b2 = Constants.b();
        b2.put("referer", this.f37292f + "/");
        String m2 = HttpHelper.i().m(GlobalVariable.c().b().getCbflist().get("4"), b2);
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it2 = JsonParser.d(m2).c().m("results").b().iterator();
        while (it2.hasNext()) {
            JsonElement next = it2.next();
            String e2 = next.c().m("post_title").e();
            String e3 = next.c().m("post_name").e();
            next.c().m("domain").e();
            if (z2) {
                if (TitleHelper.f(e2.replaceAll("(?i)(.*)([2-9]0\\d{2}|1[5-9]\\d{2})\\s+(S\\d+\\s*E\\d+)(.*)", "$1$3$4")).startsWith(TitleHelper.f(movieInfo.getName() + str.toLowerCase()))) {
                    if (e3.startsWith("//")) {
                        str3 = "http:" + e3;
                    } else if (e3.startsWith("/")) {
                        str3 = this.f37292f + e3;
                    } else {
                        str3 = this.f37292f + "/" + e3;
                    }
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
            } else {
                if (TitleHelper.h(e2.toLowerCase().replace(movieInfo.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                    if (e3.startsWith("//")) {
                        str2 = "http:" + e3;
                    } else if (e3.startsWith("/")) {
                        str2 = this.f37292f + e3;
                    } else {
                        str2 = this.f37292f + "/" + e3;
                    }
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
        }
        return arrayList;
    }
}

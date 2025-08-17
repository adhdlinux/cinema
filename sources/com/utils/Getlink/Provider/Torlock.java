package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.realdebrid.MagnetObject;
import com.original.tase.Logger;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.SeasonPack;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Torlock extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37470e = Utils.getProvider(10);

    public String A() {
        return "Torlock";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, true);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2) {
        String str;
        Iterator it2;
        String str2;
        boolean z3;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String str3;
        Iterator it3;
        MovieInfo movieInfo2 = movieInfo;
        String str4 = ".";
        boolean z4 = movieInfo.getType().intValue() == 1;
        if (z4) {
            str = " " + movieInfo2.year;
        } else if (z2) {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37470e);
        String str5 = "/";
        sb.append(str5);
        hashMap.put("referer", sb.toString());
        hashMap.put("upgrade-insecure-requests", "1");
        Iterator it4 = Jsoup.b(HttpHelper.i().m(this.f37470e + "/?qq=1&q=" + com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]).replace("%20", "+"), hashMap)).q0("div.table-responsive").g("tr").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        while (it4.hasNext()) {
            try {
                Element element = (Element) it4.next();
                Element r02 = element.r0("td").r0("a[href]");
                String c2 = r02.c("href");
                String v02 = r02.v0();
                it3 = it4;
                try {
                    if (c2.contains(UriUtil.HTTP_SCHEME)) {
                        it4 = it3;
                    } else {
                        if (c2.startsWith(str5)) {
                            StringBuilder sb2 = new StringBuilder();
                            str3 = str5;
                            try {
                                sb2.append(this.f37470e);
                                sb2.append(c2);
                                c2 = sb2.toString();
                            } catch (Throwable unused) {
                            }
                        } else {
                            str3 = str5;
                        }
                        if (z4) {
                            if (TitleHelper.h(v02.toLowerCase(), "").startsWith(TitleHelper.h(movieInfo2.name.toLowerCase() + str, ""))) {
                                hashMap2.put(c2, v02);
                            }
                        } else if (z2) {
                            SeasonPack c3 = SeasonPack.c(v02);
                            if (c3 != null) {
                                Logger.a(A() + v02 + c3.toString());
                                if (c3.b(movieInfo2, str)) {
                                    hashMap2.put(c2, v02);
                                }
                            }
                        } else {
                            if (TitleHelper.h(v02.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                                Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                                hashMap2.put(c2, v02);
                            }
                        }
                        movieInfo2 = movieInfo;
                        it4 = it3;
                        str5 = str3;
                    }
                } catch (Throwable unused2) {
                    str3 = str5;
                    movieInfo2 = movieInfo;
                    it4 = it3;
                    str5 = str3;
                }
            } catch (Throwable unused3) {
                it3 = it4;
                str3 = str5;
                movieInfo2 = movieInfo;
                it4 = it3;
                str5 = str3;
            }
        }
        new HashMap();
        Iterator it5 = hashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            try {
                String replace = TitleHelper.h((String) entry.getValue(), str4).replace("..", str4);
                String[] split = replace.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                String str6 = "HQ";
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        it2 = it5;
                        str2 = str4;
                        z3 = false;
                        break;
                    }
                    it2 = it5;
                    try {
                        String lowerCase = split[i2].toLowerCase();
                        str2 = str4;
                        try {
                            if (lowerCase.contains("dvdscr") || lowerCase.contains("camrip") || lowerCase.contains("tsrip") || lowerCase.contains("hdcam") || lowerCase.contains("hdtc") || lowerCase.contains("hdts") || lowerCase.contains("dvdcam") || lowerCase.contains("dvdts") || lowerCase.contains("cam") || lowerCase.contains("telesync")) {
                                break;
                            } else if (lowerCase.contains(HlsSegmentFormat.TS)) {
                                break;
                            } else {
                                if (!lowerCase.contains("1080p")) {
                                    if (!lowerCase.equals("1080")) {
                                        if (!lowerCase.contains("720p")) {
                                            if (!lowerCase.equals("720")) {
                                                if (lowerCase.contains("brrip") || lowerCase.contains("bdrip") || lowerCase.contains("hdrip") || lowerCase.contains("web-dl")) {
                                                    str6 = "HD";
                                                    i2++;
                                                    it5 = it2;
                                                    str4 = str2;
                                                } else {
                                                    i2++;
                                                    it5 = it2;
                                                    str4 = str2;
                                                }
                                            }
                                        }
                                        str6 = "720p";
                                        i2++;
                                        it5 = it2;
                                        str4 = str2;
                                    }
                                }
                                str6 = "1080p";
                                i2++;
                                it5 = it2;
                                str4 = str2;
                            }
                        } catch (Throwable unused4) {
                        }
                    } catch (Throwable unused5) {
                        str2 = str4;
                        it5 = it2;
                        str4 = str2;
                    }
                }
                z3 = true;
                String m2 = HttpHelper.i().m((String) entry.getKey(), new Map[0]);
                String A = A();
                if (z4) {
                    parsedLinkModel = directoryIndexHelper.c(replace);
                } else {
                    parsedLinkModel = directoryIndexHelper.d(replace);
                }
                if (parsedLinkModel != null) {
                    String c4 = parsedLinkModel.c();
                    if (!c4.equalsIgnoreCase("HQ")) {
                        str6 = c4;
                    }
                    A = u(parsedLinkModel.b(), true);
                }
                String lowerCase2 = Regex.a(m2, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                if (z3) {
                    str6 = "CAM-" + str6;
                }
                MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str6, A());
                if (z2) {
                    String a2 = Regex.a(m2, "Last Updated['\"]>\\s*(\\d+)\\s*<", 1);
                    String a3 = Regex.a(m2, "[lL]eeches['\"]>\\s*(\\d+)\\s*<", 1);
                    if (!a2.isEmpty() && !a3.isEmpty()) {
                        magnetObject.setLeeks(Integer.parseInt(a3.trim()));
                        magnetObject.setSeeds(Integer.parseInt(a2.trim()));
                    }
                }
                magnetObject.setFileName(replace);
                arrayList.add(magnetObject);
            } catch (Throwable unused6) {
                it2 = it5;
                str2 = str4;
                it5 = it2;
                str4 = str2;
            }
            it5 = it2;
            str4 = str2;
        }
        if (arrayList.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList);
            mediaSource.setStreamLink("magnet:Torlock");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

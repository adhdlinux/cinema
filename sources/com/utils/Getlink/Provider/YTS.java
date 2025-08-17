package com.utils.Getlink.Provider;

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

public class YTS extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37504e = Utils.getProvider(9);

    public String A() {
        return "YTS";
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
        ArrayList arrayList;
        boolean z3;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String lowerCase;
        ArrayList arrayList2;
        Iterator it3;
        MovieInfo movieInfo2 = movieInfo;
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
        hashMap.put("referer", this.f37504e + "/");
        hashMap.put("upgrade-insecure-requests", "1");
        Iterator it4 = Jsoup.b(HttpHelper.i().m(this.f37504e + "/search?q=" + com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]).replace("%20", "+"), hashMap)).q0("div.results").g("dl").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        while (it4.hasNext()) {
            try {
                Element element = (Element) it4.next();
                String v02 = element.r0("dt").r0("a[href]").v0();
                if (z4) {
                    String h2 = TitleHelper.h(v02.toLowerCase(), "");
                    it3 = it4;
                    try {
                        StringBuilder sb = new StringBuilder();
                        arrayList2 = arrayList3;
                        try {
                            sb.append(movieInfo2.name.toLowerCase());
                            sb.append(str);
                            if (h2.startsWith(TitleHelper.h(sb.toString(), ""))) {
                                hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), v02);
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        arrayList2 = arrayList3;
                        it4 = it3;
                        arrayList3 = arrayList2;
                    }
                } else {
                    it3 = it4;
                    arrayList2 = arrayList3;
                    if (z2) {
                        SeasonPack c2 = SeasonPack.c(v02);
                        if (c2 != null) {
                            Logger.a(A() + v02 + c2.toString());
                            if (c2.b(movieInfo2, str)) {
                                hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), v02);
                            }
                        }
                    } else {
                        if (TitleHelper.h(v02.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                            hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), v02);
                        }
                    }
                }
            } catch (Throwable unused3) {
                it3 = it4;
                arrayList2 = arrayList3;
                it4 = it3;
                arrayList3 = arrayList2;
            }
            it4 = it3;
            arrayList3 = arrayList2;
        }
        ArrayList arrayList4 = arrayList3;
        new HashMap();
        Iterator it5 = hashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            try {
                String replace = TitleHelper.h((String) entry.getValue(), ".").replace("..", ".");
                String[] split = replace.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                String str2 = "HQ";
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        it2 = it5;
                        z3 = false;
                        break;
                    }
                    try {
                        lowerCase = split[i2].toLowerCase();
                        it2 = it5;
                    } catch (Throwable unused4) {
                        it2 = it5;
                        arrayList = arrayList4;
                        arrayList4 = arrayList;
                        it5 = it2;
                    }
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
                                                str2 = "HD";
                                                i2++;
                                                it5 = it2;
                                            } else {
                                                i2++;
                                                it5 = it2;
                                            }
                                        }
                                    }
                                    str2 = "720p";
                                    i2++;
                                    it5 = it2;
                                }
                            }
                            str2 = "1080p";
                            i2++;
                            it5 = it2;
                        }
                    } catch (Throwable unused5) {
                        arrayList = arrayList4;
                        arrayList4 = arrayList;
                        it5 = it2;
                    }
                }
                z3 = true;
                try {
                    String str3 = (String) entry.getKey();
                    String A = A();
                    if (z4) {
                        parsedLinkModel = directoryIndexHelper.c(replace);
                    } else {
                        parsedLinkModel = directoryIndexHelper.d(replace);
                    }
                    if (parsedLinkModel != null) {
                        String c3 = parsedLinkModel.c();
                        if (!c3.equalsIgnoreCase("HQ")) {
                            str2 = c3;
                        }
                        A = u(parsedLinkModel.b(), true);
                    }
                    String lowerCase2 = Regex.a(str3, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                    if (z3) {
                        str2 = "CAM-" + str2;
                    }
                    MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str2, A());
                    if (z2) {
                        String a2 = Regex.a(str3, "Last Updated['\"]>\\s*(\\d+)\\s*<", 1);
                        String a3 = Regex.a(str3, "[lL]eeches['\"]>\\s*(\\d+)\\s*<", 1);
                        if (!a2.isEmpty() && !a3.isEmpty()) {
                            magnetObject.setLeeks(Integer.parseInt(a3.trim()));
                            magnetObject.setSeeds(Integer.parseInt(a2.trim()));
                        }
                    }
                    magnetObject.setFileName(replace);
                    arrayList = arrayList4;
                    try {
                        arrayList.add(magnetObject);
                    } catch (Throwable unused6) {
                    }
                } catch (Throwable unused7) {
                    arrayList = arrayList4;
                    arrayList4 = arrayList;
                    it5 = it2;
                }
            } catch (Throwable unused8) {
                it2 = it5;
                arrayList = arrayList4;
                arrayList4 = arrayList;
                it5 = it2;
            }
            arrayList4 = arrayList;
            it5 = it2;
        }
        ArrayList arrayList5 = arrayList4;
        if (arrayList5.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList5);
            mediaSource.setStreamLink("magnet:YTS");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

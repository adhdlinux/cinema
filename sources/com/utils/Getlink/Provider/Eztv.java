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

public class Eztv extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37312e = Utils.getProvider(16);

    public String A() {
        return "Eztv";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2) {
        boolean z3;
        String str;
        Iterator it2;
        String str2;
        ArrayList arrayList;
        boolean z4;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String lowerCase;
        String str3;
        MovieInfo movieInfo2 = movieInfo;
        if (movieInfo.getType().intValue() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str = " " + movieInfo2.year;
        } else if (z2) {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("upgrade-insecure-requests", "1");
        hashMap.put("accept-language", "en-US;q=0.9,en;q=0.8");
        hashMap.put("cookie", "layout=def_wlinks;");
        String k2 = com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]);
        String m2 = HttpHelper.i().m(this.f37312e + "/search/" + TitleHelper.h(k2, "-"), hashMap);
        Iterator it3 = Jsoup.b(m2).q0("tr.forum_header_border").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        while (it3.hasNext()) {
            Element element = (Element) it3.next();
            Element r02 = element.r0("a.magnet[title]");
            String c2 = r02.c("href");
            Iterator it4 = it3;
            String c3 = r02.c("title");
            ArrayList arrayList3 = arrayList2;
            if (z3) {
                String h2 = TitleHelper.h(c3.toLowerCase(), "");
                StringBuilder sb = new StringBuilder();
                str3 = m2;
                sb.append(TitleHelper.h(movieInfo.getName().toLowerCase(), ""));
                sb.append(movieInfo2.year);
                if (h2.startsWith(sb.toString())) {
                    hashMap2.put(Regex.a(r02.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), c3);
                }
            } else {
                str3 = m2;
                if (z2) {
                    SeasonPack c4 = SeasonPack.c(c3);
                    if (c4 != null) {
                        Logger.a(A() + c3 + c4.toString());
                        if (c4.b(movieInfo2, str)) {
                            c2.startsWith("/");
                            Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                            hashMap2.put(element.toString(), c3);
                        }
                    }
                } else {
                    if (TitleHelper.h(c3.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                        hashMap2.put(Regex.a(r02.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), c3);
                    }
                }
            }
            it3 = it4;
            arrayList2 = arrayList3;
            m2 = str3;
        }
        String str4 = m2;
        ArrayList arrayList4 = arrayList2;
        new HashMap();
        Iterator it5 = hashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            try {
                String replace = TitleHelper.h((String) entry.getValue(), ".").replace("..", ".");
                String[] split = replace.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                String str5 = "HQ";
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        it2 = it5;
                        z4 = false;
                        break;
                    }
                    try {
                        lowerCase = split[i2].toLowerCase();
                        it2 = it5;
                    } catch (Throwable unused) {
                        it2 = it5;
                        arrayList = arrayList4;
                        str2 = str4;
                        arrayList4 = arrayList;
                        str4 = str2;
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
                                                str5 = "HD";
                                                i2++;
                                                it5 = it2;
                                            } else {
                                                i2++;
                                                it5 = it2;
                                            }
                                        }
                                    }
                                    str5 = "720p";
                                    i2++;
                                    it5 = it2;
                                }
                            }
                            str5 = "1080p";
                            i2++;
                            it5 = it2;
                        }
                    } catch (Throwable unused2) {
                        arrayList = arrayList4;
                        str2 = str4;
                        arrayList4 = arrayList;
                        str4 = str2;
                        it5 = it2;
                    }
                }
                z4 = true;
                try {
                    String str6 = (String) entry.getKey();
                    String A = A();
                    if (z3) {
                        parsedLinkModel = directoryIndexHelper.c(replace);
                    } else {
                        parsedLinkModel = directoryIndexHelper.d(replace);
                    }
                    if (parsedLinkModel != null) {
                        String c5 = parsedLinkModel.c();
                        if (!c5.equalsIgnoreCase("HQ")) {
                            str5 = c5;
                        }
                        A = u(parsedLinkModel.b(), true);
                    }
                    String lowerCase2 = Regex.a(str6, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                    if (z4) {
                        str5 = "CAM-" + str5;
                    }
                    MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str5, A());
                    magnetObject.setFileName(replace);
                    if (z2) {
                        str2 = str4;
                        try {
                            String a2 = Regex.a(str2, "green['\"]>\\s*(\\d+)\\s*<", 1);
                            if (!a2.isEmpty()) {
                                magnetObject.setSeeds(Integer.parseInt(a2.trim()));
                            }
                        } catch (Throwable unused3) {
                            arrayList = arrayList4;
                        }
                    } else {
                        str2 = str4;
                    }
                    arrayList = arrayList4;
                    try {
                        arrayList.add(magnetObject);
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable unused5) {
                    arrayList = arrayList4;
                    str2 = str4;
                    arrayList4 = arrayList;
                    str4 = str2;
                    it5 = it2;
                }
            } catch (Throwable unused6) {
                it2 = it5;
                arrayList = arrayList4;
                str2 = str4;
                arrayList4 = arrayList;
                str4 = str2;
                it5 = it2;
            }
            arrayList4 = arrayList;
            str4 = str2;
            it5 = it2;
        }
        ArrayList arrayList5 = arrayList4;
        if (arrayList5.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList5);
            mediaSource.setStreamLink("magnet:Eztv");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

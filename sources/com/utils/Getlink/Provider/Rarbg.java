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
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Rarbg extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37414e = Utils.getProvider(17);

    public String A() {
        return "KickassTorrents";
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
        DirectoryIndexHelper directoryIndexHelper;
        ArrayList arrayList;
        boolean z3;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        Iterator it3;
        boolean z4;
        DirectoryIndexHelper directoryIndexHelper2;
        ArrayList arrayList2;
        MovieInfo movieInfo2 = movieInfo;
        boolean z5 = movieInfo.getType().intValue() == 1;
        if (z5) {
            str = " " + movieInfo2.year;
        } else if (z2) {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.9,en;q=0.8");
        hashMap.put("upgrade-insecure-requests", "1");
        String replace = TitleHelper.h(movieInfo2.name + str, "+").replace("+", "%20");
        hashMap.put("cookie", HttpHelper.i().g(this.f37414e));
        String str2 = this.f37414e + "/search/?search=" + replace;
        Iterator it4 = Jsoup.b(HttpHelper.i().m(str2, hashMap)).q0("tbody").g("a[title]").iterator();
        DirectoryIndexHelper directoryIndexHelper3 = new DirectoryIndexHelper();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        while (it4.hasNext()) {
            Element element = (Element) it4.next();
            String c2 = element.c("href");
            String v02 = element.v0();
            if (v02.isEmpty()) {
                it3 = it4;
                v02 = element.c("title");
            } else {
                it3 = it4;
            }
            String str3 = v02;
            if (str3.isEmpty()) {
                it4 = it3;
            } else {
                if (z5) {
                    arrayList2 = arrayList3;
                    String h2 = TitleHelper.h(str3.toLowerCase(), "");
                    directoryIndexHelper2 = directoryIndexHelper3;
                    StringBuilder sb = new StringBuilder();
                    z4 = z5;
                    sb.append(movieInfo2.name.toLowerCase());
                    sb.append(str);
                    if (h2.startsWith(TitleHelper.h(sb.toString(), ""))) {
                        if (c2.startsWith("/")) {
                            c2 = this.f37414e + c2;
                        }
                        hashMap2.put(c2, str3);
                    }
                } else {
                    z4 = z5;
                    directoryIndexHelper2 = directoryIndexHelper3;
                    arrayList2 = arrayList3;
                    if (z2) {
                        SeasonPack c3 = SeasonPack.c(str3);
                        if (c3 != null) {
                            Logger.a(A() + str3 + c3.toString());
                            if (c3.b(movieInfo2, str)) {
                                if (c2.startsWith("/")) {
                                    c2 = this.f37414e + c2;
                                }
                                hashMap2.put(c2, str3);
                            }
                        }
                    } else {
                        if (TitleHelper.h(str3.toLowerCase(), "").replace(movieInfo2.year, "").replace("  ", " ").startsWith(TitleHelper.h(movieInfo2.name.toLowerCase() + str.toLowerCase(), ""))) {
                            if (c2.startsWith("/")) {
                                c2 = this.f37414e + c2;
                            }
                            hashMap2.put(c2, str3);
                        }
                    }
                }
                arrayList3 = arrayList2;
                it4 = it3;
                directoryIndexHelper3 = directoryIndexHelper2;
                z5 = z4;
            }
        }
        boolean z6 = z5;
        DirectoryIndexHelper directoryIndexHelper4 = directoryIndexHelper3;
        ArrayList arrayList4 = arrayList3;
        new HashMap();
        Iterator it5 = hashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            try {
                String o2 = HttpHelper.i().o((String) entry.getKey(), str2);
                String a2 = Regex.a(o2, "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                if (!a2.isEmpty()) {
                    String replace2 = TitleHelper.h((String) entry.getValue(), ".").replace("..", ".");
                    String[] split = replace2.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                    int length = split.length;
                    String str4 = "HQ";
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            it2 = it5;
                            z3 = false;
                            break;
                        }
                        try {
                            String lowerCase = split[i2].toLowerCase();
                            it2 = it5;
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
                                                        str4 = "HD";
                                                        i2++;
                                                        it5 = it2;
                                                    } else {
                                                        i2++;
                                                        it5 = it2;
                                                    }
                                                }
                                            }
                                            str4 = "720p";
                                            i2++;
                                            it5 = it2;
                                        }
                                    }
                                    str4 = "1080p";
                                    i2++;
                                    it5 = it2;
                                }
                            } catch (Throwable unused) {
                                arrayList = arrayList4;
                                directoryIndexHelper = directoryIndexHelper4;
                                arrayList4 = arrayList;
                                directoryIndexHelper4 = directoryIndexHelper;
                                it5 = it2;
                            }
                        } catch (Throwable unused2) {
                            it2 = it5;
                            arrayList = arrayList4;
                            directoryIndexHelper = directoryIndexHelper4;
                            arrayList4 = arrayList;
                            directoryIndexHelper4 = directoryIndexHelper;
                            it5 = it2;
                        }
                    }
                    z3 = true;
                    try {
                        String A = A();
                        if (z6) {
                            directoryIndexHelper = directoryIndexHelper4;
                            try {
                                parsedLinkModel = directoryIndexHelper.c(replace2);
                            } catch (Throwable unused3) {
                                arrayList = arrayList4;
                            }
                        } else {
                            directoryIndexHelper = directoryIndexHelper4;
                            try {
                                parsedLinkModel = directoryIndexHelper.d(replace2);
                            } catch (Throwable unused4) {
                                arrayList = arrayList4;
                            }
                        }
                        if (parsedLinkModel != null) {
                            String c4 = parsedLinkModel.c();
                            if (!c4.equalsIgnoreCase("HQ")) {
                                str4 = c4;
                            }
                            A = u(parsedLinkModel.b(), true);
                        }
                        String lowerCase2 = Regex.a(a2, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                        if (z3) {
                            str4 = "CAM-" + str4;
                        }
                        MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str4, A());
                        magnetObject.setFileName(replace2);
                        if (z2) {
                            String a3 = Regex.a(o2, "[sS]eeders\\s*:\\s*(\\d+)\\s*", 1);
                            String a4 = Regex.a(o2, "[lL]eechers\\s*:\\s*(\\d+)\\s*", 1);
                            if (!a3.isEmpty() && !a4.isEmpty()) {
                                magnetObject.setLeeks(Integer.parseInt(a4.trim()));
                                magnetObject.setSeeds(Integer.parseInt(a3.trim()));
                            }
                        }
                        arrayList = arrayList4;
                        try {
                            arrayList.add(magnetObject);
                        } catch (Throwable unused5) {
                        }
                    } catch (Throwable unused6) {
                        arrayList = arrayList4;
                        directoryIndexHelper = directoryIndexHelper4;
                        arrayList4 = arrayList;
                        directoryIndexHelper4 = directoryIndexHelper;
                        it5 = it2;
                    }
                    arrayList4 = arrayList;
                    directoryIndexHelper4 = directoryIndexHelper;
                    it5 = it2;
                }
            } catch (Throwable unused7) {
                it2 = it5;
                arrayList = arrayList4;
                directoryIndexHelper = directoryIndexHelper4;
                arrayList4 = arrayList;
                directoryIndexHelper4 = directoryIndexHelper;
                it5 = it2;
            }
        }
        ArrayList arrayList5 = arrayList4;
        if (arrayList5.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList5);
            mediaSource.setStreamLink("magnet:KickassTorrents");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return 1;
    }
}

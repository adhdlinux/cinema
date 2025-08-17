package com.utils.Getlink.Provider;

import com.google.android.gms.cast.HlsSegmentFormat;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.realdebrid.MagnetObject;
import com.original.tase.Logger;
import com.original.tase.helper.DateTimeHelper;
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

public class Torrentgalaxy extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37473e = Utils.getProvider(8);

    public String A() {
        return "Torrentgalaxy";
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
        String str2;
        Iterator it2;
        ArrayList arrayList;
        boolean z3;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        ArrayList arrayList2;
        Iterator it3;
        String str3;
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
        hashMap.put("referer", this.f37473e + "/");
        hashMap.put("upgrade-insecure-requests", "1");
        String str4 = this.f37473e + "/torrents.php?search=" + com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]);
        String m2 = HttpHelper.i().m(str4, hashMap);
        String a2 = Regex.a(m2, "POST['\"]\\s*\\,\\s*['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            if (a2.startsWith("/")) {
                str3 = this.f37473e + a2;
            } else {
                str3 = this.f37473e + "/" + a2;
            }
            HttpHelper i2 = HttpHelper.i();
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            str2 = str;
            sb.append(DateTimeHelper.e());
            i2.l(sb.toString(), "fash=" + com.original.tase.utils.Utils.d(32), new Map[0]);
            m2 = HttpHelper.i().m(str4, hashMap);
        } else {
            str2 = str;
        }
        Iterator it4 = Jsoup.b(m2).q0("div.tgxtable").g("div.tgxtablerow.txlight").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        while (it4.hasNext()) {
            try {
                Element element = (Element) it4.next();
                String v02 = element.r0("a[class=txlight][title][href]").v0();
                if (z4) {
                    it3 = it4;
                    try {
                        String h2 = TitleHelper.h(v02.toLowerCase(), "");
                        String str5 = v02;
                        StringBuilder sb2 = new StringBuilder();
                        String str6 = str2;
                        try {
                            sb2.append(movieInfo.getName().toLowerCase());
                            sb2.append(movieInfo2.year);
                            if (h2.startsWith(TitleHelper.h(sb2.toString(), ""))) {
                                hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), str5);
                            }
                        } catch (Throwable unused) {
                        }
                        arrayList2 = arrayList3;
                        str2 = str6;
                    } catch (Throwable unused2) {
                        String str7 = str2;
                    }
                    movieInfo2 = movieInfo;
                    it4 = it3;
                    arrayList3 = arrayList2;
                } else {
                    it3 = it4;
                    String str8 = v02;
                    String str9 = str2;
                    if (z2) {
                        try {
                            SeasonPack c2 = SeasonPack.c(str8);
                            if (c2 != null) {
                                Logger.a(A() + str8 + c2.toString());
                                str2 = str9;
                                try {
                                    if (c2.b(movieInfo2, str2)) {
                                        hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), str8);
                                    }
                                } catch (Throwable unused3) {
                                }
                            } else {
                                str2 = str9;
                            }
                        } catch (Throwable unused4) {
                            str2 = str9;
                        }
                        arrayList2 = arrayList3;
                        movieInfo2 = movieInfo;
                        it4 = it3;
                        arrayList3 = arrayList2;
                    } else {
                        str2 = str9;
                        try {
                            arrayList2 = arrayList3;
                            try {
                                if (TitleHelper.h(str8.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str2.toLowerCase(), ""))) {
                                    hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), str8);
                                }
                            } catch (Throwable unused5) {
                            }
                        } catch (Throwable unused6) {
                            arrayList2 = arrayList3;
                            movieInfo2 = movieInfo;
                            it4 = it3;
                            arrayList3 = arrayList2;
                        }
                        movieInfo2 = movieInfo;
                        it4 = it3;
                        arrayList3 = arrayList2;
                    }
                }
            } catch (Throwable unused7) {
                it3 = it4;
                arrayList2 = arrayList3;
                movieInfo2 = movieInfo;
                it4 = it3;
                arrayList3 = arrayList2;
            }
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
                String str10 = "HQ";
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        it2 = it5;
                        z3 = false;
                        break;
                    }
                    try {
                        String lowerCase = split[i3].toLowerCase();
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
                                                    str10 = "HD";
                                                    i3++;
                                                    it5 = it2;
                                                } else {
                                                    i3++;
                                                    it5 = it2;
                                                }
                                            }
                                        }
                                        str10 = "720p";
                                        i3++;
                                        it5 = it2;
                                    }
                                }
                                str10 = "1080p";
                                i3++;
                                it5 = it2;
                            }
                        } catch (Throwable unused8) {
                            arrayList = arrayList4;
                            arrayList4 = arrayList;
                            it5 = it2;
                        }
                    } catch (Throwable unused9) {
                        it2 = it5;
                        arrayList = arrayList4;
                        arrayList4 = arrayList;
                        it5 = it2;
                    }
                }
                z3 = true;
                String str11 = (String) entry.getKey();
                String A = A();
                if (z4) {
                    parsedLinkModel = directoryIndexHelper.c(replace);
                } else {
                    parsedLinkModel = directoryIndexHelper.d(replace);
                }
                if (parsedLinkModel != null) {
                    String c3 = parsedLinkModel.c();
                    if (!c3.equalsIgnoreCase("HQ")) {
                        str10 = c3;
                    }
                    A = u(parsedLinkModel.b(), true);
                }
                String str12 = str10;
                String lowerCase2 = Regex.a(str11, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                if (z3) {
                    str12 = "CAM-" + str12;
                }
                try {
                    MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str12, A());
                    if (z2) {
                        String a3 = Regex.a(str11, "Seeders\\/Leechers['\"].*>(\\d+)<.*>(\\d+)<", 1);
                        String a4 = Regex.a(str11, "Seeders\\/Leechers['\"].*>(\\d+)<.*>(\\d+)<", 2);
                        if (!a3.isEmpty() && !a4.isEmpty()) {
                            magnetObject.setLeeks(Integer.parseInt(a4.trim()));
                            magnetObject.setSeeds(Integer.parseInt(a3.trim()));
                        }
                    }
                    magnetObject.setFileName(replace);
                    arrayList = arrayList4;
                    try {
                        arrayList.add(magnetObject);
                    } catch (Throwable unused10) {
                    }
                } catch (Throwable unused11) {
                    arrayList = arrayList4;
                    arrayList4 = arrayList;
                    it5 = it2;
                }
            } catch (Throwable unused12) {
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
            mediaSource.setStreamLink("magnet:Torrentgalaxy");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
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

public class KickassTorrents extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37356e = Utils.getProvider(15);

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
        String str2;
        boolean z4;
        MovieInfo movieInfo2 = movieInfo;
        String str3 = "720p";
        boolean z5 = movieInfo.getType().intValue() == 1;
        if (z5) {
            str = " " + movieInfo2.year;
        } else if (z2) {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("referer", this.f37356e + "/");
        hashMap.put("upgrade-insecure-requests", "1");
        String str4 = this.f37356e + "/usearch/" + com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]).replace("+", "%20");
        Iterator it3 = Jsoup.b(HttpHelper.i().o(str4, this.f37356e + "/")).q0("div.torrentname").iterator();
        DirectoryIndexHelper directoryIndexHelper2 = new DirectoryIndexHelper();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        while (it3.hasNext()) {
            Iterator it4 = it3;
            Element element = (Element) it3.next();
            ArrayList arrayList3 = arrayList2;
            DirectoryIndexHelper directoryIndexHelper3 = directoryIndexHelper2;
            String c2 = element.r0(a.f20042a).c("href");
            String h2 = TitleHelper.h(c2.toLowerCase(), "");
            if (z5) {
                if (h2.startsWith(TitleHelper.h(movieInfo2.name.toLowerCase() + str, ""))) {
                    if (c2.startsWith("/")) {
                        c2 = this.f37356e + c2;
                    }
                    hashMap2.put(c2, h2);
                }
            } else {
                if (z2) {
                    SeasonPack c3 = SeasonPack.c(h2);
                    if (c3 != null) {
                        z4 = z5;
                        StringBuilder sb = new StringBuilder();
                        str2 = str3;
                        sb.append(A());
                        sb.append(h2);
                        sb.append(c3.toString());
                        Logger.a(sb.toString());
                        if (c3.b(movieInfo2, str)) {
                            if (c2.startsWith("/")) {
                                c2 = this.f37356e + c2;
                            }
                            Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                            hashMap2.put(c2, h2);
                        }
                    }
                } else {
                    str2 = str3;
                    z4 = z5;
                    if (h2.replace(movieInfo2.year, "").replace("  ", " ").contains(TitleHelper.h(movieInfo2.name.toLowerCase() + str.toLowerCase(), " "))) {
                        if (c2.startsWith("/")) {
                            c2 = this.f37356e + c2;
                        }
                        hashMap2.put(c2, h2);
                    }
                }
                arrayList2 = arrayList3;
                it3 = it4;
                directoryIndexHelper2 = directoryIndexHelper3;
                z5 = z4;
                str3 = str2;
            }
            str2 = str3;
            z4 = z5;
            arrayList2 = arrayList3;
            it3 = it4;
            directoryIndexHelper2 = directoryIndexHelper3;
            z5 = z4;
            str3 = str2;
        }
        String str5 = str3;
        boolean z6 = z5;
        DirectoryIndexHelper directoryIndexHelper4 = directoryIndexHelper2;
        ArrayList arrayList4 = arrayList2;
        new HashMap();
        Iterator it5 = hashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            try {
                String o2 = HttpHelper.i().o((String) entry.getKey(), str4);
                String a2 = Regex.a(o2, "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                if (!a2.isEmpty()) {
                    String replace = TitleHelper.h((String) entry.getValue(), ".").replace("..", ".");
                    String[] split = replace.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                    int length = split.length;
                    String str6 = "HQ";
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
                                    if (lowerCase.contains("1080p") || lowerCase.equals("1080")) {
                                        str6 = "1080p";
                                    } else {
                                        String str7 = str5;
                                        try {
                                            if (!lowerCase.contains(str7)) {
                                                str5 = str7;
                                                if (!lowerCase.equals("720")) {
                                                    if (lowerCase.contains("brrip") || lowerCase.contains("bdrip") || lowerCase.contains("hdrip") || lowerCase.contains("web-dl")) {
                                                        str6 = "HD";
                                                    }
                                                }
                                            } else {
                                                str5 = str7;
                                            }
                                            str6 = str5;
                                        } catch (Throwable unused) {
                                            str5 = str7;
                                            arrayList = arrayList4;
                                            directoryIndexHelper = directoryIndexHelper4;
                                            arrayList4 = arrayList;
                                            directoryIndexHelper4 = directoryIndexHelper;
                                            it5 = it2;
                                        }
                                    }
                                    i2++;
                                    it5 = it2;
                                }
                            } catch (Throwable unused2) {
                                arrayList = arrayList4;
                                directoryIndexHelper = directoryIndexHelper4;
                                arrayList4 = arrayList;
                                directoryIndexHelper4 = directoryIndexHelper;
                                it5 = it2;
                            }
                        } catch (Throwable unused3) {
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
                                parsedLinkModel = directoryIndexHelper.c(replace);
                            } catch (Throwable unused4) {
                                arrayList = arrayList4;
                            }
                        } else {
                            directoryIndexHelper = directoryIndexHelper4;
                            try {
                                parsedLinkModel = directoryIndexHelper.d(replace);
                            } catch (Throwable unused5) {
                                arrayList = arrayList4;
                            }
                        }
                        if (parsedLinkModel != null) {
                            String c4 = parsedLinkModel.c();
                            if (!c4.equalsIgnoreCase("HQ")) {
                                str6 = c4;
                            }
                            A = u(parsedLinkModel.b(), true);
                        }
                        String lowerCase2 = Regex.a(a2, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                        if (z3) {
                            str6 = "CAM-" + str6;
                        }
                        MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str6, A());
                        magnetObject.setFileName(replace);
                        if (z2) {
                            String a3 = Regex.a(o2, "[sS]eeders\\s*:\\s*<strong>(\\d+)", 1);
                            String a4 = Regex.a(o2, "[lL]eechers\\s*:\\s*<strong>(\\d+)", 1);
                            if (!a3.isEmpty() && !a4.isEmpty()) {
                                magnetObject.setLeeks(Integer.parseInt(a4.trim()));
                                magnetObject.setSeeds(Integer.parseInt(a3.trim()));
                            }
                        }
                        arrayList = arrayList4;
                        try {
                            arrayList.add(magnetObject);
                        } catch (Throwable unused6) {
                        }
                    } catch (Throwable unused7) {
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
            } catch (Throwable unused8) {
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
        return this.f37249a;
    }
}

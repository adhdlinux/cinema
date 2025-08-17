package com.utils.Getlink.Provider;

import com.google.android.gms.cast.HlsSegmentFormat;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.realdebrid.MagnetObject;
import com.original.Constants;
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

public class T1337x extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37461e = Utils.getProvider(34);

    /* renamed from: f  reason: collision with root package name */
    private String f37462f = "";

    public String A() {
        return "T1337x";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, false);
        }
    }

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, true);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(observableEmitter, movieInfo, false);
        }
    }

    public String J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, boolean z2) {
        String str;
        Iterator it2;
        String str2;
        boolean z3;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String str3;
        String str4;
        String str5;
        T1337x t1337x = this;
        MovieInfo movieInfo2 = movieInfo;
        if (t1337x.f37462f.isEmpty()) {
            t1337x.f37462f = HttpHelper.i().m(Constants.E + "provider/1337x.to.txt", new Map[0]);
        }
        boolean z4 = movieInfo.getType().intValue() == 1;
        if (z4) {
            str = " " + movieInfo2.year;
        } else if (z2) {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        String format = String.format(t1337x.f37461e + t1337x.f37462f, new Object[]{com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0])});
        Iterator it3 = Jsoup.b(HttpHelper.i().o(format, t1337x.f37461e + "/")).q0("tbody").g("tr").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        HashMap hashMap = new HashMap();
        while (it3.hasNext()) {
            Element element = (Element) it3.next();
            Element r02 = element.r0("a[href*=/torrent]");
            String v02 = r02.v0();
            String c2 = r02.c("href");
            if (z4) {
                if (TitleHelper.h(v02.toLowerCase(), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase(), "") + movieInfo2.year)) {
                    hashMap.put(c2, v02);
                }
            } else if (z2) {
                SeasonPack c3 = SeasonPack.c(v02);
                if (c3 != null) {
                    Logger.a(A() + v02 + c3.toString());
                    if (c3.b(movieInfo2, str)) {
                        Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                        hashMap.put(c2, v02);
                    }
                }
            } else {
                if (TitleHelper.h(v02.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                    hashMap.put(c2, v02);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it4 = hashMap.entrySet().iterator();
        String str6 = "HQ";
        while (it4.hasNext()) {
            Map.Entry entry = (Map.Entry) it4.next();
            try {
                String str7 = (String) entry.getKey();
                if (str7.startsWith("/")) {
                    try {
                        str7 = t1337x.f37461e + str7;
                    } catch (Throwable unused) {
                        it2 = it4;
                    }
                }
                String o2 = HttpHelper.i().o(str7, t1337x.f37461e + "/");
                String str8 = (String) entry.getValue();
                String[] split = str8.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        it2 = it4;
                        str2 = str6;
                        z3 = false;
                        break;
                    }
                    try {
                        it2 = it4;
                        try {
                            String lowerCase = split[i2].toLowerCase();
                            str2 = str6;
                            if (lowerCase.contains("dvdscr") || lowerCase.contains("camrip") || lowerCase.contains("tsrip") || lowerCase.contains("hdcam") || lowerCase.contains("hdtc") || lowerCase.contains("hdts") || lowerCase.contains("dvdcam") || lowerCase.contains("dvdts") || lowerCase.contains("cam") || lowerCase.contains("telesync")) {
                                break;
                            } else if (lowerCase.contains(HlsSegmentFormat.TS)) {
                                break;
                            } else {
                                if (!lowerCase.contains("1080p")) {
                                    if (!lowerCase.equals("1080")) {
                                        if (!lowerCase.contains("720p")) {
                                            if (!lowerCase.equals("720")) {
                                                if (!lowerCase.contains("brrip") && !lowerCase.contains("bdrip") && !lowerCase.contains("hdrip")) {
                                                    if (!lowerCase.contains("web-dl")) {
                                                        str6 = str2;
                                                        i2++;
                                                        it4 = it2;
                                                    }
                                                }
                                                str6 = "HD";
                                                i2++;
                                                it4 = it2;
                                            }
                                        }
                                        str6 = "720p";
                                        i2++;
                                        it4 = it2;
                                    }
                                }
                                str6 = "1080p";
                                i2++;
                                it4 = it2;
                            }
                        } catch (Throwable unused2) {
                            String str9 = str6;
                            t1337x = this;
                            it4 = it2;
                        }
                    } catch (Throwable unused3) {
                        str6 = str2;
                    }
                }
                z3 = true;
                String a2 = Regex.a(o2, "href\\s*=\\s*['\"](magnet.*)\\s*onclick.['\"]", 1);
                String A = A();
                if (z4) {
                    parsedLinkModel = directoryIndexHelper.c(str8);
                } else {
                    parsedLinkModel = directoryIndexHelper.d(str8);
                }
                if (parsedLinkModel != null) {
                    str3 = parsedLinkModel.c();
                    if (str3.equalsIgnoreCase("HQ")) {
                        str3 = str2;
                    }
                    try {
                        str4 = t1337x.u(parsedLinkModel.b(), true);
                    } catch (Throwable unused4) {
                    }
                } else {
                    str4 = A;
                    str3 = str2;
                }
                String lowerCase2 = Regex.a(a2, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                if (z3) {
                    str5 = "CAM-" + str3;
                } else {
                    str5 = str3;
                }
                MagnetObject magnetObject = new MagnetObject(str4, lowerCase2, str5, A());
                magnetObject.setFileName(str8);
                if (z2) {
                    String a3 = Regex.a(o2, "[sS]eeds['\"]\\s*>\\s*(\\d+)", 1);
                    String a4 = Regex.a(o2, "[lL]eeches['\"]\\s*>\\s*(\\d+)", 1);
                    if (!a3.isEmpty() && !a4.isEmpty()) {
                        magnetObject.setLeeks(Integer.parseInt(a4.trim()));
                        magnetObject.setSeeds(Integer.parseInt(a3.trim()));
                    }
                }
                arrayList.add(magnetObject);
                str6 = str3;
            } catch (Throwable unused5) {
                it2 = it4;
            }
            t1337x = this;
            it4 = it2;
        }
        if (arrayList.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "Torrent", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList);
            mediaSource.setStreamLink("magnet:1337");
            observableEmitter.onNext(mediaSource);
        }
        return "";
    }

    public int m() {
        return this.f37249a;
    }
}

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

public class Torrent4k extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37471e = Utils.getProvider(23);

    public String A() {
        return "Torrent4k";
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
        boolean z3;
        String str;
        Iterator it2;
        boolean z4;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String str2;
        MovieInfo movieInfo2 = movieInfo;
        if (movieInfo.getType().intValue() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str = " " + movieInfo2.year;
        } else if (z2) {
            str = " s" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " s" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "e" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        Iterator it3 = Jsoup.b(HttpHelper.i().m(this.f37471e + "/search_results.php?search=" + com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]) + "&cat=0&incldead=0&inclexternal=0&lang=0&sort=size&order=desc", new Map[0])).q0("tbody").g("tr.t-row").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        HashMap hashMap = new HashMap();
        while (it3.hasNext()) {
            Element element = (Element) it3.next();
            try {
                String replaceAll = element.r0("td.ttable_col2").r0("a[title][href]").c("title").replaceAll("\\(|\\)", "");
                if (z3) {
                    if (TitleHelper.h(replaceAll.toLowerCase(), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase(), "") + movieInfo2.year)) {
                        hashMap.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), replaceAll);
                    }
                } else if (z2) {
                    SeasonPack c2 = SeasonPack.c(replaceAll);
                    if (c2 != null) {
                        Logger.a(A() + replaceAll + c2.toString());
                        if (c2.b(movieInfo2, str)) {
                            hashMap.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), replaceAll);
                        }
                    }
                } else {
                    if (TitleHelper.h(replaceAll.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                        hashMap.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), replaceAll);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator it4 = hashMap.entrySet().iterator();
        String str3 = "HQ";
        while (it4.hasNext()) {
            Map.Entry entry = (Map.Entry) it4.next();
            try {
                String str4 = (String) entry.getValue();
                String[] split = str4.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        it2 = it4;
                        z4 = false;
                        break;
                    }
                    String lowerCase = split[i2].toLowerCase();
                    it2 = it4;
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
                                                str3 = "HD";
                                                i2++;
                                                it4 = it2;
                                            } else {
                                                i2++;
                                                it4 = it2;
                                            }
                                        }
                                    }
                                    str3 = "720p";
                                    i2++;
                                    it4 = it2;
                                }
                            }
                            str3 = "1080p";
                            i2++;
                            it4 = it2;
                        }
                    } catch (Throwable unused2) {
                    }
                }
                z4 = true;
                String str5 = (String) entry.getKey();
                String A = A();
                if (z3) {
                    parsedLinkModel = directoryIndexHelper.c(str4);
                } else {
                    parsedLinkModel = directoryIndexHelper.d(str4);
                }
                if (parsedLinkModel != null) {
                    String c3 = parsedLinkModel.c();
                    if (!c3.equalsIgnoreCase("HQ")) {
                        str3 = c3;
                    }
                    A = u(parsedLinkModel.b(), true);
                }
                String lowerCase2 = Regex.a(str5, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                if (z4) {
                    str2 = "CAM-" + str3;
                } else {
                    str2 = str3;
                }
                MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str2, A());
                magnetObject.setFileName(str4);
                arrayList.add(magnetObject);
            } catch (Throwable unused3) {
                it2 = it4;
            }
            it4 = it2;
        }
        if (arrayList.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "Torrent", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList);
            mediaSource.setStreamLink("magnet:Torrent4k");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

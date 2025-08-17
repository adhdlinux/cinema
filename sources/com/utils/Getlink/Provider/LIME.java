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
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class LIME extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37370e = Utils.getProvider(20);

    public String A() {
        return "LIME";
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
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2) {
        boolean z3;
        String str;
        Iterator it2;
        boolean z4;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String str2;
        MovieInfo movieInfo2 = movieInfo;
        int i2 = 1;
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
        String k2 = com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("Referer", this.f37370e + "/search/" + k2);
        hashMap.put("Upgrade-Insecure-Requests", "1");
        Iterator it3 = Jsoup.b(HttpHelper.i().m(this.f37370e + "/search/0/0/000/10/" + k2, hashMap)).q0("div#index").g("tbody").g("tr").iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        HashMap hashMap2 = new HashMap();
        while (it3.hasNext()) {
            Element element = (Element) it3.next();
            try {
                String v02 = element.q0("td").g(a.f20042a).d().v0();
                String replace = v02.replace(Regex.a(v02, "(.*\\s*\\/\\s*)", i2), "");
                if (!z2) {
                    if (TitleHelper.h(replace.toLowerCase(), "").contains(TitleHelper.h(movieInfo2.name.toLowerCase() + str, ""))) {
                        hashMap2.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), replace);
                    }
                } else {
                    SeasonPack c2 = SeasonPack.c(replace);
                    if (c2 != null) {
                        Logger.a(A() + replace + c2.toString());
                        if (c2.b(movieInfo2, str)) {
                            Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1);
                            hashMap2.put(element.toString(), replace);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            i2 = 1;
        }
        new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator it4 = hashMap2.entrySet().iterator();
        String str3 = "HQ";
        while (it4.hasNext()) {
            Map.Entry entry = (Map.Entry) it4.next();
            try {
                String str4 = (String) entry.getValue();
                String[] split = str4.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        it2 = it4;
                        z4 = false;
                        break;
                    }
                    String lowerCase = split[i3].toLowerCase();
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
                                                i3++;
                                                it4 = it2;
                                            } else {
                                                i3++;
                                                it4 = it2;
                                            }
                                        }
                                    }
                                    str3 = "720p";
                                    i3++;
                                    it4 = it2;
                                }
                            }
                            str3 = "1080p";
                            i3++;
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
                if (z2) {
                    String replace2 = str5.replace("&nbsp;", "");
                    String a2 = Regex.a(replace2, "alt=['\"]S['\"]>\\s*(\\d+)\\s*", 1);
                    String a3 = Regex.a(replace2, "alt=['\"]L['\"]>.*(\\d+)\\s*", 1);
                    if (!a2.isEmpty() && !a3.isEmpty()) {
                        magnetObject.setLeeks(Integer.parseInt(a3.trim()));
                        magnetObject.setSeeds(Integer.parseInt(a2.trim()));
                    }
                }
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
            mediaSource.setStreamLink("magnet:LIME");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

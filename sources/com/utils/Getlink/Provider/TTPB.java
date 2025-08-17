package com.utils.Getlink.Provider;

import com.google.android.gms.cast.HlsSegmentFormat;
import com.movie.FreeMoviesApp;
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
import com.vungle.ads.internal.protos.Sdk$SDKError;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TTPB extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String[] f37464e;

    /* renamed from: f  reason: collision with root package name */
    public String f37465f;

    public TTPB() {
        String[] split = Utils.getProvider(35).split(",");
        this.f37464e = split;
        this.f37465f = split[0];
    }

    public String A() {
        return "TTPB";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, true, false);
        }
    }

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false, true);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false, false);
        }
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2, boolean z3) {
        boolean z4;
        String str;
        int i2;
        Iterator it2;
        ArrayList arrayList;
        boolean z5;
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        String lowerCase;
        List list;
        ArrayList arrayList2;
        List list2;
        MovieInfo movieInfo2 = movieInfo;
        int i3 = 1;
        if (FreeMoviesApp.p().getBoolean("pref_use_unblock" + A(), false)) {
            this.f37465f = this.f37464e[1];
        }
        if (movieInfo.getType().intValue() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            str = " " + movieInfo2.year;
        } else if (z3) {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session));
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo2.eps));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("referer", this.f37465f + "/");
        hashMap.put("upgrade-insecure-requests", "1");
        Object[] objArr = new Object[2];
        objArr[0] = com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]).replace("+", "%20");
        if (z2) {
            i2 = 201;
        } else {
            i2 = Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE;
        }
        objArr[1] = Integer.valueOf(i2);
        ArrayList<ArrayList<String>> d2 = Regex.d(HttpHelper.i().m(String.format("https://apibay.org/q.php?q=%s&cat=0", objArr), new Map[0]), "name['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]\\s*\\,\\s*['\"]info_hash['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 2);
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        ArrayList arrayList3 = new ArrayList();
        List list3 = d2.get(0);
        List list4 = d2.get(1);
        HashMap hashMap2 = new HashMap();
        int i4 = 0;
        while (i4 < list3.size()) {
            String str2 = (String) list4.get(i4);
            if (str2.isEmpty()) {
                list = list4;
                arrayList2 = arrayList3;
                list2 = list3;
            } else {
                list = list4;
                Object[] objArr2 = new Object[i3];
                objArr2[0] = str2;
                String format = String.format("magnet:?xt=urn:btih:%s", objArr2);
                String str3 = (String) list3.get(i4);
                if (z4) {
                    String h2 = TitleHelper.h(str3.toLowerCase(), "");
                    list2 = list3;
                    StringBuilder sb = new StringBuilder();
                    arrayList2 = arrayList3;
                    sb.append(TitleHelper.h(movieInfo.getName().toLowerCase(), ""));
                    sb.append(movieInfo2.year);
                    if (h2.startsWith(sb.toString())) {
                        hashMap2.put(format, str3);
                    }
                } else {
                    arrayList2 = arrayList3;
                    list2 = list3;
                    if (z3) {
                        SeasonPack c2 = SeasonPack.c(str3);
                        if (c2 != null) {
                            Logger.a(A() + str3 + c2.toString());
                            if (c2.b(movieInfo2, str)) {
                                hashMap2.put(format, str3);
                            }
                        }
                    } else {
                        if (TitleHelper.h(str3.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                            hashMap2.put(format, str3);
                        }
                    }
                }
            }
            i4++;
            list4 = list;
            list3 = list2;
            arrayList3 = arrayList2;
            i3 = 1;
        }
        ArrayList arrayList4 = arrayList3;
        new HashMap();
        Iterator it3 = hashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            try {
                String replace = TitleHelper.h((String) entry.getValue(), ".").replace("..", ".");
                String[] split = replace.toUpperCase().replaceAll("(.+)(\\.|\\(|\\[|\\s)([2-9]0\\d{2}|1[5-9]\\d{2}|S\\d*E\\d*|S\\d*)(\\.|\\)|\\]|\\s)", "").split("\\.|\\(|\\)|\\[|\\]|\\s|\\-");
                int length = split.length;
                String str4 = "HQ";
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        it2 = it3;
                        z5 = false;
                        break;
                    }
                    try {
                        lowerCase = split[i5].toLowerCase();
                        it2 = it3;
                    } catch (Throwable unused) {
                        it2 = it3;
                        arrayList = arrayList4;
                        arrayList4 = arrayList;
                        it3 = it2;
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
                                                str4 = "HD";
                                                i5++;
                                                it3 = it2;
                                            } else {
                                                i5++;
                                                it3 = it2;
                                            }
                                        }
                                    }
                                    str4 = "720p";
                                    i5++;
                                    it3 = it2;
                                }
                            }
                            str4 = "1080p";
                            i5++;
                            it3 = it2;
                        }
                    } catch (Throwable unused2) {
                        arrayList = arrayList4;
                        arrayList4 = arrayList;
                        it3 = it2;
                    }
                }
                z5 = true;
                String str5 = (String) entry.getKey();
                String A = A();
                if (z4) {
                    parsedLinkModel = directoryIndexHelper.c(replace);
                } else {
                    parsedLinkModel = directoryIndexHelper.d(replace);
                }
                if (parsedLinkModel != null) {
                    String c3 = parsedLinkModel.c();
                    if (!c3.equalsIgnoreCase("HQ")) {
                        str4 = c3;
                    }
                    A = u(parsedLinkModel.b(), true);
                }
                String lowerCase2 = Regex.a(str5, "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
                if (z5) {
                    str4 = "CAM-" + str4;
                }
                try {
                    MagnetObject magnetObject = new MagnetObject(A, lowerCase2, str4, A());
                    magnetObject.setFileName(replace);
                    if (z3) {
                        ArrayList<ArrayList<String>> f2 = Regex.f(str5, "right['\"]>(\\d*)", 1, true);
                        if (!f2.isEmpty() && f2.get(0).size() > 1) {
                            String str6 = (String) f2.get(0).get(0);
                            String str7 = (String) f2.get(0).get(1);
                            if (!str6.isEmpty() && !str7.isEmpty()) {
                                magnetObject.setLeeks(Integer.parseInt(str7.trim()));
                                magnetObject.setSeeds(Integer.parseInt(str6.trim()));
                            }
                        }
                    }
                    arrayList = arrayList4;
                    try {
                        arrayList.add(magnetObject);
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    arrayList = arrayList4;
                    arrayList4 = arrayList;
                    it3 = it2;
                }
            } catch (Throwable unused5) {
                it2 = it3;
                arrayList = arrayList4;
                arrayList4 = arrayList;
                it3 = it2;
            }
            arrayList4 = arrayList;
            it3 = it2;
        }
        ArrayList arrayList5 = arrayList4;
        if (arrayList5.size() > 0) {
            MediaSource mediaSource = new MediaSource(A(), "", false);
            mediaSource.setTorrent(true);
            mediaSource.setMagnetObjects(arrayList5);
            mediaSource.setStreamLink("magnet:TTPB");
            observableEmitter.onNext(mediaSource);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

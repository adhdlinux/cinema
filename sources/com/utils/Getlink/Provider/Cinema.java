package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Cinema extends BaseProvider {

    /* renamed from: h  reason: collision with root package name */
    private static String[] f37279h = {"s3.svdl.ir", "dl.yoozdl", "dl1.yoozdl", "dl2.yoozdl", "dl3.yoozdl", "s1.0music", "178.216.250.167", "dl2.upload08", "dl3.upload08", "avadl.uploadt", "dl5.dlb3d", "dl4.dlb3d", "dl3.dlb3d", "dl2.dlb3d", "dl.dlb3d", "geryon.feralhosting", "ns502618.ip-192-99-8", "dl.muvie", "portal.ekniazi", "seedbox37", "5.9.40.180", "163.172.6.218", "s1.tinydl.info", "dl2.heyserver.in"};

    /* renamed from: e  reason: collision with root package name */
    private String f37280e = Utils.getProvider(53);

    /* renamed from: f  reason: collision with root package name */
    private String f37281f = "";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f37282g = new HashMap();

    public String A() {
        return "Cinema";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!Utils.f37609b) {
            J(observableEmitter, movieInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!Utils.f37609b) {
            J(observableEmitter, movieInfo);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        String str;
        boolean z2 = true;
        if (movieInfo.getType().intValue() != 1) {
            z2 = false;
        }
        if (z2) {
            str = " " + movieInfo.year;
        } else {
            str = " S" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.session)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.eps));
        }
        String h2 = TitleHelper.h(movieInfo.name + str, "+");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(M(h2));
        L(arrayList, h2);
        K(observableEmitter, arrayList, movieInfo, str);
    }

    public void K(ObservableEmitter<? super MediaSource> observableEmitter, ArrayList arrayList, MovieInfo movieInfo, String str) {
        boolean z2;
        boolean z3;
        MovieInfo movieInfo2 = movieInfo;
        String str2 = str;
        int i2 = 0;
        boolean z4 = true;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (!observableEmitter.isDisposed()) {
                String str3 = (String) next;
                String m2 = HttpHelper.i().m(str3, new Map[i2]);
                String h2 = TitleHelper.h(movieInfo2.name + str2, ".");
                Iterator it3 = Regex.f(m2, "['\"]([^'\"]+(mka|mkv|mp4|avi))['\"]", z4 ? 1 : 0, z4).get(i2).iterator();
                if (it3.hasNext()) {
                    Iterator it4 = Regex.f(m2, "href=['\"]([^'\"]*" + h2 + "[^'\"]*)['\"]", z4, z4).get(i2).iterator();
                    if (!it4.hasNext()) {
                        it4 = Regex.f(m2, "href=['\"]([^'\"]*" + h2.toLowerCase() + "[^'\"]*)['\"]", z4, z4).get(0).iterator();
                    }
                    if (!z2) {
                        if (!it4.hasNext()) {
                            h2 = TitleHelper.h(movieInfo2.name + " " + movieInfo2.year + str2, ".");
                            StringBuilder sb = new StringBuilder();
                            sb.append("href=['\"]([^'\"]*");
                            sb.append(h2);
                            sb.append("[^'\"]*)['\"]");
                            it4 = Regex.f(m2, sb.toString(), 1, true).get(0).iterator();
                        }
                        if (!it4.hasNext()) {
                            h2 = TitleHelper.h(movieInfo2.name + " " + movieInfo2.year + str2, ".");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("href=['\"]([^'\"]*");
                            sb2.append(h2.toLowerCase());
                            sb2.append("[^'\"]*)['\"]");
                            it4 = Regex.f(m2, sb2.toString(), 1, true).get(0).iterator();
                        }
                    }
                    if (!it4.hasNext()) {
                        z3 = true;
                    } else {
                        it3 = it4;
                        z3 = false;
                    }
                    while (it3.hasNext()) {
                        String str4 = (String) it3.next();
                        if (str4.isEmpty() || str4.toLowerCase().contains("trailer") || !TitleHelper.f(str4).contains(TitleHelper.f(TitleHelper.e(h2)))) {
                            ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                        } else {
                            if (z3) {
                                str4 = "http://" + str4;
                            } else if (!str4.startsWith(UriUtil.HTTP_SCHEME)) {
                                str4 = str3 + str4;
                            }
                            String a2 = Regex.a(str4, "(?<=\\//)(.*?)(?=\\.)", 1);
                            if (!a2.isEmpty()) {
                                a2 = a2.substring(0, 1).toUpperCase() + a2.substring(1);
                            }
                            if (a2.isEmpty()) {
                                a2 = A();
                            }
                            DirectoryIndexHelper.ParsedLinkModel c2 = directoryIndexHelper.c(str4);
                            String str5 = "HQ";
                            if (c2 != null) {
                                String c3 = c2.c();
                                if (!c3.equalsIgnoreCase(str5)) {
                                    str5 = c3;
                                }
                                a2 = t(c2.b());
                            }
                            MediaSource mediaSource = new MediaSource(a2, "CDN", false);
                            mediaSource.setStreamLink(str4);
                            mediaSource.setPlayHeader(hashMap);
                            mediaSource.setQuality(str5);
                            observableEmitter.onNext(mediaSource);
                        }
                        MovieInfo movieInfo3 = movieInfo;
                    }
                    ObservableEmitter<? super MediaSource> observableEmitter3 = observableEmitter;
                    movieInfo2 = movieInfo;
                    i2 = 0;
                    z4 = true;
                }
            } else {
                return;
            }
        }
    }

    public ArrayList L(ArrayList arrayList, String str) {
        HttpHelper.i().m("https://www.bing.com", new Map[0]);
        Iterator it2 = Jsoup.b(HttpHelper.i().o("https://www.bing.com/search?q=intitle%3Aindex+of+" + str, "https://www.bing.com")).q0("h2").iterator();
        while (it2.hasNext()) {
            try {
                String c2 = ((Element) it2.next()).r0(a.f20042a).c("href");
                if (!c2.contains("bing.com") && !c2.contains("imdb.com") && !c2.contains("youtube.com") && !c2.isEmpty() && !arrayList.contains(c2)) {
                    arrayList.add(c2);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public ArrayList M(String str) {
        ArrayList arrayList = new ArrayList();
        String G = Utils.G();
        String k2 = com.original.tase.utils.Utils.k(G + "/search?q=intitle:\"index+of\"+" + str, new boolean[0]);
        HttpHelper i2 = HttpHelper.i();
        Iterator it2 = Jsoup.b(i2.m(k2 + "##forceNoCache##", new Map[0])).q0("div[class=r]").iterator();
        if (it2.hasNext()) {
            while (it2.hasNext()) {
                try {
                    String c2 = ((Element) it2.next()).r0(a.f20042a).c("href");
                    if (!c2.isEmpty() && !c2.contains("google.com") && !c2.contains("imdb.com") && !c2.contains("youtube.com") && !arrayList.contains(c2)) {
                        arrayList.add(c2);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }
}

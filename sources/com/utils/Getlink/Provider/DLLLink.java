package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.SeasonPack;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class DLLLink extends BaseProvider {

    /* renamed from: f  reason: collision with root package name */
    private static ScnSrc f37293f = new ScnSrc();

    /* renamed from: g  reason: collision with root package name */
    private static DDLValley f37294g = new DDLValley();

    /* renamed from: e  reason: collision with root package name */
    private String f37295e = Utils.getProvider(7);

    private void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, boolean z2) {
        boolean z3;
        String str;
        MovieInfo movieInfo2 = movieInfo;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
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
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37295e + "/search/?s=" + com.original.tase.utils.Utils.k(movieInfo2.name + str, new boolean[0]) + "&cat=all", new Map[0])).q0("div.pl-body").g("div.p-c-title").iterator();
        new DirectoryIndexHelper();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            try {
                Element r02 = element.r0("a[href]");
                String c2 = r02.c("href");
                String replaceAll = r02.v0().replaceAll("\\(|\\)", "");
                if (z3) {
                    if (TitleHelper.f(replaceAll).startsWith(TitleHelper.f(TitleHelper.e(movieInfo.getName()) + movieInfo2.year))) {
                        String replace = c2.replace(BaseProvider.j(c2), "").replace("\\/", "");
                        if (!arrayList.contains(replace)) {
                            arrayList.add(replace);
                            hashMap.put(replace, replaceAll);
                        }
                    }
                } else if (z2) {
                    SeasonPack c3 = SeasonPack.c(replaceAll);
                    if (c3 != null) {
                        Logger.a(A() + replaceAll + c3.toString());
                        if (c3.b(movieInfo2, str)) {
                            hashMap.put(Regex.a(element.toString(), "href\\s*=\\s*['\"](magnet.*?[^'\"]+)['\"]?", 1), replaceAll);
                        }
                    }
                } else {
                    if (TitleHelper.h(replaceAll.toLowerCase().replace(movieInfo2.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str.toLowerCase(), ""))) {
                        String replace2 = c2.replace(BaseProvider.j(c2), "").replace("\\/", "");
                        if (!arrayList.contains(replace2)) {
                            arrayList.add(replace2);
                            hashMap.put(replace2, replaceAll);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        new HashMap();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry key : hashMap.entrySet()) {
            try {
                arrayList2.add((String) key.getKey());
            } catch (Throwable unused2) {
            }
        }
        if (!arrayList2.isEmpty()) {
            f37293f.J(observableEmitter2, movieInfo2, arrayList2, str);
        }
        if (!hashMap.isEmpty()) {
            f37294g.J(observableEmitter2, movieInfo2, str.trim(), hashMap);
        }
    }

    public String A() {
        return "PrimeWire";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    public int m() {
        return this.f37249a;
    }
}

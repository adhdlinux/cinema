package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.crypto.Sha1Cryptor;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.search.SearchHelper;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class DaxivMovies extends BaseProvider {

    /* renamed from: h  reason: collision with root package name */
    public static String f37296h = Deobfuscator$app$ProductionRelease.a(-214279926788292L);

    /* renamed from: i  reason: collision with root package name */
    private static String f37297i = Deobfuscator$app$ProductionRelease.a(-214275631820996L);

    /* renamed from: j  reason: collision with root package name */
    private static String f37298j = Deobfuscator$app$ProductionRelease.a(-214271336853700L);

    /* renamed from: e  reason: collision with root package name */
    public String f37299e = Utils.getProvider(60);

    /* renamed from: f  reason: collision with root package name */
    private String f37300f = Deobfuscator$app$ProductionRelease.a(-216594914160836L);

    /* renamed from: g  reason: collision with root package name */
    private int f37301g = 2;

    private static String J() {
        String str = f37296h;
        if (str == null || str.isEmpty()) {
            f37296h = Constants.E + Deobfuscator$app$ProductionRelease.a(-214387300970692L);
        }
        return f37296h;
    }

    private void L(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        Object[] objArr;
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-216539079585988L), Constants.C);
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            String a2 = Regex.a(str, Deobfuscator$app$ProductionRelease.a(-216526194684100L), 1);
            if (!a2.isEmpty()) {
                str = str.replace(a2 + Deobfuscator$app$ProductionRelease.a(-216165417431236L), a2 + Deobfuscator$app$ProductionRelease.a(-216191187235012L));
            }
            str = String.format(str.replace(Deobfuscator$app$ProductionRelease.a(-216182597300420L), Deobfuscator$app$ProductionRelease.a(-216148237562052L)) + Deobfuscator$app$ProductionRelease.a(-216113877823684L), new Object[]{movieInfo.session, movieInfo.eps});
        }
        String a3 = Regex.a(HttpHelper.i().m(str, hashMap), Deobfuscator$app$ProductionRelease.a(-216294266450116L), 1);
        if (!a3.isEmpty() && (objArr = (Object[]) K(a3)) != null) {
            int length = objArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = (String) objArr[i2];
                if (!observableEmitter.isDisposed()) {
                    z(observableEmitter, Regex.a(HttpHelper.i().o(String.format(this.f37299e + Deobfuscator$app$ProductionRelease.a(-214924171882692L), new Object[]{str2}), str), Deobfuscator$app$ProductionRelease.a(-214821092667588L), 1), Deobfuscator$app$ProductionRelease.a(-214679358746820L), false);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private String M(MovieInfo movieInfo) {
        String str = movieInfo.imdbIDStr;
        String format = String.format(BaseProvider.k(HttpHelper.i().m(this.f37299e, new Map[0]), this.f37299e), new Object[]{str});
        if (f37297i.isEmpty()) {
            f37297i = HttpHelper.i().m(Constants.E + Deobfuscator$app$ProductionRelease.a(-214666473844932L), new Map[0]);
        }
        if (!f37297i.isEmpty()) {
            format = format + f37297i;
        }
        if (f37298j.isEmpty()) {
            f37298j = HttpHelper.i().m(Constants.E + Deobfuscator$app$ProductionRelease.a(-214602049335492L), new Map[0]);
        }
        if (!f37298j.isEmpty()) {
            format = format + Sha1Cryptor.b(str + f37298j).substring(0, 10);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-215362258546884L), Deobfuscator$app$ProductionRelease.a(-215332193775812L));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-213687221301444L), this.f37299e + Deobfuscator$app$ProductionRelease.a(-213652861563076L));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-213678631366852L), Deobfuscator$app$ProductionRelease.a(-213841840124100L));
        Iterator it2 = Jsoup.b(HttpHelper.i().m(format, hashMap)).q0(Deobfuscator$app$ProductionRelease.a(-213798890451140L)).g(Deobfuscator$app$ProductionRelease.a(-213433818230980L)).iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                String c2 = element.c(Deobfuscator$app$ProductionRelease.a(-213395163525316L));
                String c3 = element.c(Deobfuscator$app$ProductionRelease.a(-213373688688836L));
                this.f37300f = Deobfuscator$app$ProductionRelease.a(-213313559146692L);
                if (TitleHelper.h(c3.toLowerCase(), Deobfuscator$app$ProductionRelease.a(-213335033983172L)).equals(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, Deobfuscator$app$ProductionRelease.a(-213330739015876L)))) {
                    if (!c2.startsWith(Deobfuscator$app$ProductionRelease.a(-213326444048580L))) {
                        return c2;
                    }
                    return this.f37299e + c2;
                }
            } catch (Throwable unused) {
            }
        }
        return Deobfuscator$app$ProductionRelease.a(-213558372282564L);
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-214365826134212L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo);
        if (M.isEmpty()) {
            String str = movieInfo.name;
            String str2 = movieInfo.year;
            M = SearchHelper.a(str, str2, str2, this.f37299e, Deobfuscator$app$ProductionRelease.a(-216547669520580L));
        }
        if (!M.isEmpty()) {
            L(observableEmitter, M, movieInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo);
        if (M.isEmpty()) {
            String str = movieInfo.name;
            String str2 = movieInfo.year;
            M = SearchHelper.a(str, str2, str2, this.f37299e, Deobfuscator$app$ProductionRelease.a(-216543374553284L));
        }
        if (!M.isEmpty()) {
            L(observableEmitter, M, movieInfo);
        }
    }

    public Object K(String str) {
        int i2;
        String m2 = HttpHelper.i().m(J(), new Map[0]);
        String replaceAll = m2.replaceAll(Deobfuscator$app$ProductionRelease.a(-213554077315268L), str);
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate(replaceAll);
            if (evaluate != null) {
                create.close();
                return evaluate;
            }
        } catch (Throwable unused) {
            i2 *= 2;
        }
        create.close();
        return null;
    }
}

package com.utils.Getlink.Provider;

import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Hd4movies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public HashMap f37343e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f37344f = Deobfuscator$app$ProductionRelease.a(-245611713212612L);

    public Hd4movies() {
        this.f37343e.put(Deobfuscator$app$ProductionRelease.a(-245607418245316L), Deobfuscator$app$ProductionRelease.a(-245302475567300L));
        this.f37343e.put(Deobfuscator$app$ProductionRelease.a(-246032620007620L), Deobfuscator$app$ProductionRelease.a(-246238778437828L));
        this.f37343e.put(Deobfuscator$app$ProductionRelease.a(-246247368372420L), Deobfuscator$app$ProductionRelease.a(-245826461577412L));
        this.f37343e.put(Deobfuscator$app$ProductionRelease.a(-245817871642820L), Deobfuscator$app$ProductionRelease.a(-245804986740932L));
    }

    private static String J() {
        String str = GlobalVariable.c().b().getCbflist().get(Deobfuscator$app$ProductionRelease.a(-244177194135748L));
        if (str == null || str.isEmpty()) {
            return Deobfuscator$app$ProductionRelease.a(-244168604201156L);
        }
        return str;
    }

    private void K(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str, String str2) {
        boolean z2;
        String str3;
        String str4;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str3 = TitleHelper.h(movieInfo.name + Deobfuscator$app$ProductionRelease.a(-244095589757124L) + movieInfo.year, Deobfuscator$app$ProductionRelease.a(-244121359560900L)).toLowerCase(Locale.ROOT);
        } else {
            str3 = TitleHelper.h(movieInfo.name + Deobfuscator$app$ProductionRelease.a(-244112769626308L) + movieInfo.session + Deobfuscator$app$ProductionRelease.a(-244314633089220L) + movieInfo.eps, Deobfuscator$app$ProductionRelease.a(-244271683416260L)).toLowerCase(Locale.ROOT);
        }
        String a2 = Regex.a(HttpHelper.i().m(String.format(this.f37344f, new Object[]{str3}), new Map[0]), String.format(Deobfuscator$app$ProductionRelease.a(-244297453220036L), new Object[]{str3}), 1);
        if (!a2.isEmpty()) {
            if (a2.startsWith(Deobfuscator$app$ProductionRelease.a(-244980353020100L))) {
                str4 = Deobfuscator$app$ProductionRelease.a(-244933108379844L) + a2;
            } else if (a2.startsWith(Deobfuscator$app$ProductionRelease.a(-244941698314436L))) {
                str4 = this.f37344f + a2;
            } else {
                str4 = this.f37344f + Deobfuscator$app$ProductionRelease.a(-245173626548420L) + a2;
            }
            Iterator it2 = Jsoup.b(HttpHelper.i().o(str4, this.f37344f + Deobfuscator$app$ProductionRelease.a(-245165036613828L))).q0(Deobfuscator$app$ProductionRelease.a(-245190806417604L)).iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (!observableEmitter.isDisposed()) {
                    String element2 = element.toString();
                    String replace = Regex.a(element2, Deobfuscator$app$ProductionRelease.a(-245177921515716L), 1).replace(Deobfuscator$app$ProductionRelease.a(-245057662431428L), Deobfuscator$app$ProductionRelease.a(-245079137267908L)).replace(Deobfuscator$app$ProductionRelease.a(-244761309688004L), Deobfuscator$app$ProductionRelease.a(-244769899622596L));
                    if (replace.startsWith(Deobfuscator$app$ProductionRelease.a(-244726949949636L))) {
                        replace = Deobfuscator$app$ProductionRelease.a(-244714065047748L) + replace;
                    }
                    if (!replace.isEmpty()) {
                        String lowerCase = Regex.a(element2, Deobfuscator$app$ProductionRelease.a(-244688295243972L), 1).trim().toLowerCase();
                        if (lowerCase.isEmpty()) {
                            lowerCase = Deobfuscator$app$ProductionRelease.a(-244675410342084L);
                        }
                        z(observableEmitter, replace, lowerCase, false);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-244138539430084L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37344f = J();
        if (GlobalVariable.c().b().getAds() == null && BaseProvider.v()) {
            K(observableEmitter, movieInfo, Deobfuscator$app$ProductionRelease.a(-244164309233860L), Deobfuscator$app$ProductionRelease.a(-244185784070340L));
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37344f = J();
        if (GlobalVariable.c().b().getAds() == null && BaseProvider.v()) {
            K(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
        }
    }
}

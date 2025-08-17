package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;

public class GoFilms4u extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37324e = Utils.getProvider(93);

    /* renamed from: f  reason: collision with root package name */
    private String f37325f = Deobfuscator$app$ProductionRelease.a(-217518332129476L);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-217621411344580L), this.f37324e + Deobfuscator$app$ProductionRelease.a(-217587051606212L));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-217269224026308L), Constants.C);
        String a2 = Regex.a(HttpHelper.i().m(str, hashMap), Deobfuscator$app$ProductionRelease.a(-217256339124420L), 1);
        if (!a2.isEmpty()) {
            String d2 = BaseProvider.d(com.original.tase.utils.Utils.q(a2));
            if (!d2.isEmpty()) {
                Iterator<String> it2 = Regex.g(d2, Deobfuscator$app$ProductionRelease.a(-217329353568452L), 1, true).iterator();
                while (it2.hasNext()) {
                    String a3 = Regex.a(HttpHelper.i().m(this.f37324e + Deobfuscator$app$ProductionRelease.a(-215787460309188L) + it2.next(), hashMap), Deobfuscator$app$ProductionRelease.a(-216027978477764L), 1);
                    if (!a3.isEmpty()) {
                        String a4 = Regex.a(a3, Deobfuscator$app$ProductionRelease.a(-215577006911684L), 1);
                        String a5 = Regex.a(a3, Deobfuscator$app$ProductionRelease.a(-215761690505412L), 1);
                        if (!a4.isEmpty() && !a5.isEmpty()) {
                            String str2 = Deobfuscator$app$ProductionRelease.a(-216444590305476L) + a4 + a5;
                            MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-216405935599812L), false);
                            mediaSource.setStreamLink(str2);
                            mediaSource.setPlayHeader(hashMap);
                            mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-216341511090372L));
                            observableEmitter.onNext(mediaSource);
                        }
                    }
                }
            }
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-216362985926852L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-217479677423812L), new Object[]{this.f37324e, Long.valueOf(movieInfo.tmdbID)}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-217677245919428L), new Object[]{this.f37324e, Long.valueOf(movieInfo.tmdbID), movieInfo.session, movieInfo.eps}));
    }
}

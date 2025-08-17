package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;

public class Hd3movies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37342e = Utils.getProvider(62);

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-186568797794500L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!movieInfo.imdbIDStr.isEmpty()) {
            z(observableEmitter, String.format(Deobfuscator$app$ProductionRelease.a(-186878035439812L), new Object[]{this.f37342e, movieInfo.imdbIDStr}), Deobfuscator$app$ProductionRelease.a(-186792136093892L), false);
            return;
        }
        z(observableEmitter, String.format(Deobfuscator$app$ProductionRelease.a(-186813610930372L), new Object[]{Long.valueOf(movieInfo.tmdbID)}), Deobfuscator$app$ProductionRelease.a(-186452833677508L), false);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!movieInfo.imdbIDStr.isEmpty()) {
            z(observableEmitter, String.format(Deobfuscator$app$ProductionRelease.a(-186439948775620L), new Object[]{this.f37342e, movieInfo.imdbIDStr, movieInfo.session, movieInfo.eps}), Deobfuscator$app$ProductionRelease.a(-186396999102660L), false);
            return;
        }
        z(observableEmitter, String.format(Deobfuscator$app$ProductionRelease.a(-186624632369348L), new Object[]{Long.valueOf(movieInfo.tmdbID), movieInfo.session, movieInfo.eps}), Deobfuscator$app$ProductionRelease.a(-186547322958020L), false);
    }
}

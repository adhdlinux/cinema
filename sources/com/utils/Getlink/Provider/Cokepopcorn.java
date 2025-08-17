package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class Cokepopcorn extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37287e = Utils.getProvider(86);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-185074149175492L), Deobfuscator$app$ProductionRelease.a(-185039789437124L));
        MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-185237357932740L), false);
        mediaSource.setStreamLink(str);
        mediaSource.setResolved(true);
        mediaSource.setPlayHeader(hashMap);
        mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-185172933423300L));
        observableEmitter.onNext(mediaSource);
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-184799271268548L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-186525848121540L), new Object[]{this.f37287e, Long.valueOf(movieInfo.tmdbID)}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-185194408259780L), new Object[]{this.f37287e, Long.valueOf(movieInfo.tmdbID), movieInfo.session, com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.eps))}));
    }
}

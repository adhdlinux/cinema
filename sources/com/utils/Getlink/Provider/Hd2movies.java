package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.List;

public class Hd2movies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37341e = Utils.getProvider(63);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo) {
        boolean z2;
        String str = this.f37341e + Deobfuscator$app$ProductionRelease.a(-231421141266628L) + movieInfo.imdbIDStr;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            str = (this.f37341e + Deobfuscator$app$ProductionRelease.a(-231386781528260L) + movieInfo.imdbIDStr) + String.format(Deobfuscator$app$ProductionRelease.a(-231378191593668L), new Object[]{movieInfo.session, movieInfo.eps});
        }
        List<String> c2 = HandleMore.c(str, str);
        HashMap hashMap = HandleMore.f37340a;
        for (String streamLink : c2) {
            MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-231330946953412L), false);
            mediaSource.setStreamLink(streamLink);
            mediaSource.setPlayHeader(hashMap);
            mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-230991644537028L));
            observableEmitter.onNext(mediaSource);
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-230944399896772L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo);
    }
}

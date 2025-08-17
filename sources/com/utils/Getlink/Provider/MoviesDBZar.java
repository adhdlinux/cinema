package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class MoviesDBZar extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37386e = Utils.getProvider(31);

    private void J(String str, ObservableEmitter<? super MediaSource> observableEmitter) {
        z(observableEmitter, str, "HD", false);
    }

    public String A() {
        return "MoviesDBZar";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(String.format("%s/player.php?imdb=%s", new Object[]{this.f37386e, movieInfo.imdbIDStr}), observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(String.format("%s/player.php?type=series&imdb=%s&season=%s&episode=%s", new Object[]{this.f37386e, movieInfo.imdbIDStr, movieInfo.session, movieInfo.eps}), observableEmitter);
    }
}

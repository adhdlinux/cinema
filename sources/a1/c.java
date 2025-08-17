package a1;

import com.movie.data.repository.trakt.TraktRepositoryImpl;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class c implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TraktRepositoryImpl f29265a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29266b;

    public /* synthetic */ c(TraktRepositoryImpl traktRepositoryImpl, String str) {
        this.f29265a = traktRepositoryImpl;
        this.f29266b = str;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.f29265a.k(this.f29266b, observableEmitter);
    }
}

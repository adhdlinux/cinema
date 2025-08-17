package l1;

import com.movie.data.model.MovieInfo;
import com.utils.subtitle.services.SubServiceBase;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f41296b;

    public /* synthetic */ b(MovieInfo movieInfo) {
        this.f41296b = movieInfo;
    }

    public final Object apply(Object obj) {
        return ((SubServiceBase) obj).k(this.f41296b).subscribeOn(Schedulers.c()).filter(new c()).onErrorResumeNext(Observable.empty());
    }
}

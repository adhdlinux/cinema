package z0;

import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TMDBRepositoryImpl f41484b;

    public /* synthetic */ n(TMDBRepositoryImpl tMDBRepositoryImpl) {
        this.f41484b = tMDBRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return this.f41484b.L((TvTMDB.ResultsBean) obj);
    }
}

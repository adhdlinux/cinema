package z0;

import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TMDBRepositoryImpl f41481b;

    public /* synthetic */ j(TMDBRepositoryImpl tMDBRepositoryImpl) {
        this.f41481b = tMDBRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return this.f41481b.R((List) obj);
    }
}

package z0;

import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {
    public final Object apply(Object obj) {
        return TMDBRepositoryImpl.y(((TvTMDB) obj).getResults(), true);
    }
}

package z0;

import com.movie.data.model.tmvdb.SearchTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class p implements Function {
    public final Object apply(Object obj) {
        return TMDBRepositoryImpl.x(((SearchTMDB) obj).getResults());
    }
}

package z0;

import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class v implements Function {
    public final Object apply(Object obj) {
        return TMDBRepositoryImpl.w(((MovieTMDB) obj).getResults(), false);
    }
}

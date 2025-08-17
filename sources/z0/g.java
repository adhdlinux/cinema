package z0;

import com.movie.data.model.cinema.Video;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {
    public final Object apply(Object obj) {
        return TMDBRepositoryImpl.e0((Video.Response) obj);
    }
}

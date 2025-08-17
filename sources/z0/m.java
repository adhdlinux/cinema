package z0;

import com.movie.data.model.tmvdb.GenreTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f41483b;

    public /* synthetic */ m(List list) {
        this.f41483b = list;
    }

    public final Object apply(Object obj) {
        return TMDBRepositoryImpl.P(this.f41483b, (GenreTMDB) obj);
    }
}

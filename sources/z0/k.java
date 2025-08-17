package z0;

import com.movie.data.model.tmvdb.GenreTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f41482b;

    public /* synthetic */ k(List list) {
        this.f41482b = list;
    }

    public final Object apply(Object obj) {
        return TMDBRepositoryImpl.O(this.f41482b, (GenreTMDB) obj);
    }
}

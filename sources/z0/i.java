package z0;

import com.database.entitys.CategoryEntity;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TMDBRepositoryImpl f41479b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CategoryEntity.Type f41480c;

    public /* synthetic */ i(TMDBRepositoryImpl tMDBRepositoryImpl, CategoryEntity.Type type) {
        this.f41479b = tMDBRepositoryImpl;
        this.f41480c = type;
    }

    public final Object apply(Object obj) {
        return this.f41479b.Q(this.f41480c, (List) obj);
    }
}

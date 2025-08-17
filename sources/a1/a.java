package a1;

import com.database.entitys.CategoryEntity;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraktRepositoryImpl f29262b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CategoryEntity.Type f29263c;

    public /* synthetic */ a(TraktRepositoryImpl traktRepositoryImpl, CategoryEntity.Type type) {
        this.f29262b = traktRepositoryImpl;
        this.f29263c = type;
    }

    public final Object apply(Object obj) {
        return this.f29262b.i(this.f29263c, (List) obj);
    }
}

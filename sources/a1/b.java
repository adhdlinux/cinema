package a1;

import com.movie.data.repository.trakt.TraktRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraktRepositoryImpl f29264b;

    public /* synthetic */ b(TraktRepositoryImpl traktRepositoryImpl) {
        this.f29264b = traktRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return this.f29264b.j((List) obj);
    }
}

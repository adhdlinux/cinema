package k1;

import com.database.entitys.MovieEntity;
import com.movie.data.model.tmvdb.FindResult;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f40239b;

    public /* synthetic */ a(MovieEntity movieEntity) {
        this.f40239b = movieEntity;
    }

    public final void accept(Object obj) {
        this.f40239b.setTmdbID(((FindResult) obj).getTv_episode_results().get(0).getShow_id());
    }
}

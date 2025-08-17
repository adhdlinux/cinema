package k1;

import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieInfo;
import com.utils.seriesguide.ExampleExtensionService;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExampleExtensionService f40240b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f40241c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f40242d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f40243e;

    public /* synthetic */ b(ExampleExtensionService exampleExtensionService, MovieInfo movieInfo, MovieEntity movieEntity, int i2) {
        this.f40240b = exampleExtensionService;
        this.f40241c = movieInfo;
        this.f40242d = movieEntity;
        this.f40243e = i2;
    }

    public final void accept(Object obj) {
        this.f40240b.L(this.f40241c, this.f40242d, this.f40243e, (Throwable) obj);
    }
}

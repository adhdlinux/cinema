package k1;

import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieInfo;
import com.utils.seriesguide.ExampleExtensionService;
import io.reactivex.functions.Action;

public final /* synthetic */ class c implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExampleExtensionService f40244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f40245c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f40246d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f40247e;

    public /* synthetic */ c(ExampleExtensionService exampleExtensionService, MovieInfo movieInfo, MovieEntity movieEntity, int i2) {
        this.f40244b = exampleExtensionService;
        this.f40245c = movieInfo;
        this.f40246d = movieEntity;
        this.f40247e = i2;
    }

    public final void run() {
        this.f40244b.M(this.f40245c, this.f40246d, this.f40247e);
    }
}

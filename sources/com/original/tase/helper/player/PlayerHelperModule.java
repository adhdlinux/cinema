package com.original.tase.helper.player;

import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Module
public final class PlayerHelperModule {
    @Singleton
    @Provides
    @Named("ExpandedControlsActivity")
    public final PlayerHelper a(MoviesHelper moviesHelper) {
        Intrinsics.f(moviesHelper, "moviesHelper");
        return new PlayerHelper(moviesHelper);
    }

    @Singleton
    @Provides
    @Named("MovieDetailsActivity")
    public final PlayerHelper b(MoviesHelper moviesHelper) {
        Intrinsics.f(moviesHelper, "moviesHelper");
        return new PlayerHelper(moviesHelper);
    }

    @Singleton
    @Provides
    @Named("EpisodeActivity")
    public final PlayerHelper c(MoviesHelper moviesHelper) {
        Intrinsics.f(moviesHelper, "moviesHelper");
        return new PlayerHelper(moviesHelper);
    }

    @Singleton
    @Provides
    @Named("MainActivity")
    public final PlayerHelper d(MoviesHelper moviesHelper) {
        Intrinsics.f(moviesHelper, "moviesHelper");
        return new PlayerHelper(moviesHelper);
    }

    @Singleton
    @Provides
    @Named("SourceActivity")
    public final PlayerHelper e(MoviesHelper moviesHelper) {
        Intrinsics.f(moviesHelper, "moviesHelper");
        return new PlayerHelper(moviesHelper);
    }
}

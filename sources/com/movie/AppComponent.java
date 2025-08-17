package com.movie;

import com.database.DatabaseModule;
import com.database.MvDatabase;
import com.google.gson.Gson;
import com.movie.data.api.ApiModule;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.imdb.IMDBModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.api.realdebrid.RealDebridModule;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.api.tmdb.TMDBModule;
import com.movie.data.api.tvdb.TvdbModule;
import com.movie.data.api.tvmaze.TVMazeApi;
import com.movie.data.api.tvmaze.TVMazeModule;
import com.movie.data.repository.RepositoryModule;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.player.PlayerHelperModule;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleModule;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.Component;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {AppModule.class, TMDBModule.class, TVMazeModule.class, RepositoryModule.class, ApiModule.class, DatabaseModule.class, RealDebridModule.class, OpenSubtitleModule.class, MoviesHelper.class, IMDBModule.class, TvdbModule.class, PlayerHelperModule.class})
public interface AppComponent {
    MvDatabase a();

    RealDebridApi b();

    MoviesHelper c();

    @Named("MainActivity")
    PlayerHelper d();

    MoviesApi e();

    TMDBRepositoryImpl f();

    TMDBApi g();

    @Named("EpisodeActivity")
    PlayerHelper h();

    TraktRepositoryImpl i();

    @Named("SourceActivity")
    PlayerHelper j();

    OpenSubtitleV1Api k();

    Gson l();

    TheTvdb m();

    @Named("ExpandedControlsActivity")
    PlayerHelper n();

    IMDBApi o();

    OkHttpClient p();

    @Named("MovieDetailsActivity")
    PlayerHelper q();

    TVMazeApi r();

    @Named("RealDebrid")
    OkHttpClient s();

    void t(FreeMoviesApp freeMoviesApp);
}

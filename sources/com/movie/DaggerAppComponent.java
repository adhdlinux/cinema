package com.movie;

import android.app.Application;
import com.database.DatabaseModule;
import com.database.DatabaseModule_ProviderDemoDatabaseFactory;
import com.database.MvDatabase;
import com.google.gson.Gson;
import com.movie.data.api.ApiModule;
import com.movie.data.api.ApiModule_ProvideGlobalOkHttpClientFactory;
import com.movie.data.api.ApiModule_ProvideGsonFactory;
import com.movie.data.api.ApiModule_ProvideMoviesApiFactory;
import com.movie.data.api.ApiModule_ProvideOkHttpClientFactory;
import com.movie.data.api.ApiModule_ProvideRestAdapterFactory;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.imdb.IMDBModule;
import com.movie.data.api.imdb.IMDBModule_ProvideGsonFactory;
import com.movie.data.api.imdb.IMDBModule_ProvideIMDBApiFactory;
import com.movie.data.api.imdb.IMDBModule_ProvideOkHttpClientFactory;
import com.movie.data.api.imdb.IMDBModule_ProvideRestAdapterFactory;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.api.realdebrid.RealDebridModule;
import com.movie.data.api.realdebrid.RealDebridModule_ProvideGsonFactory;
import com.movie.data.api.realdebrid.RealDebridModule_ProvideOkHttpClientFactory;
import com.movie.data.api.realdebrid.RealDebridModule_ProvideRealDebridApiFactory;
import com.movie.data.api.realdebrid.RealDebridModule_ProvideRestAdapterFactory;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.api.tmdb.TMDBModule;
import com.movie.data.api.tmdb.TMDBModule_ProvideGsonFactory;
import com.movie.data.api.tmdb.TMDBModule_ProvideOkHttpClientFactory;
import com.movie.data.api.tmdb.TMDBModule_ProvideRestAdapterFactory;
import com.movie.data.api.tmdb.TMDBModule_ProvideTMDBApiFactory;
import com.movie.data.api.tvdb.TvdbModule;
import com.movie.data.api.tvdb.TvdbModule_ProvideTheTvdbFactory;
import com.movie.data.api.tvmaze.TVMazeApi;
import com.movie.data.api.tvmaze.TVMazeModule;
import com.movie.data.api.tvmaze.TVMazeModule_ProvideGsonFactory;
import com.movie.data.api.tvmaze.TVMazeModule_ProvideOkHttpClientFactory;
import com.movie.data.api.tvmaze.TVMazeModule_ProvideRestAdapterFactory;
import com.movie.data.api.tvmaze.TVMazeModule_ProvideTVMazeApiFactory;
import com.movie.data.repository.RepositoryModule;
import com.movie.data.repository.RepositoryModule_ProvideTmdbRepositoryFactory;
import com.movie.data.repository.RepositoryModule_ProvidesTraktRepositoryFactory;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.helper.MoviesHelper_ProviderMoviesHelperFactory;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.player.PlayerHelperModule;
import com.original.tase.helper.player.PlayerHelperModule_ProvideCastPlayHelperFactory;
import com.original.tase.helper.player.PlayerHelperModule_ProvideDetailsPlayHelperFactory;
import com.original.tase.helper.player.PlayerHelperModule_ProvideEpisodePlayHelperFactory;
import com.original.tase.helper.player.PlayerHelperModule_ProvideMainPlayHelperFactory;
import com.original.tase.helper.player.PlayerHelperModule_ProvideSourcePlayHelperFactory;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleModule;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleModule_ProvideOpenSubtitleApiFactory;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerAppComponent {

    private static final class AppComponentImpl implements AppComponent {
        private Provider<OpenSubtitleV1Api> A;

        /* renamed from: a  reason: collision with root package name */
        private final RepositoryModule f31846a;

        /* renamed from: b  reason: collision with root package name */
        private final ApiModule f31847b;

        /* renamed from: c  reason: collision with root package name */
        private final TMDBModule f31848c;

        /* renamed from: d  reason: collision with root package name */
        private final TVMazeModule f31849d;

        /* renamed from: e  reason: collision with root package name */
        private final RealDebridModule f31850e;

        /* renamed from: f  reason: collision with root package name */
        private final MoviesHelper f31851f;

        /* renamed from: g  reason: collision with root package name */
        private final IMDBModule f31852g;

        /* renamed from: h  reason: collision with root package name */
        private final TvdbModule f31853h;

        /* renamed from: i  reason: collision with root package name */
        private final AppComponentImpl f31854i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<Application> f31855j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<MvDatabase> f31856k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<OkHttpClient> f31857l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<Gson> f31858m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<Retrofit> f31859n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<OkHttpClient> f31860o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<Gson> f31861p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<Retrofit> f31862q;

        /* renamed from: r  reason: collision with root package name */
        private Provider<TMDBApi> f31863r;

        /* renamed from: s  reason: collision with root package name */
        private Provider<TMDBRepositoryImpl> f31864s;

        /* renamed from: t  reason: collision with root package name */
        private Provider<MoviesHelper> f31865t;

        /* renamed from: u  reason: collision with root package name */
        private Provider<PlayerHelper> f31866u;

        /* renamed from: v  reason: collision with root package name */
        private Provider<PlayerHelper> f31867v;

        /* renamed from: w  reason: collision with root package name */
        private Provider<PlayerHelper> f31868w;

        /* renamed from: x  reason: collision with root package name */
        private Provider<PlayerHelper> f31869x;

        /* renamed from: y  reason: collision with root package name */
        private Provider<PlayerHelper> f31870y;

        /* renamed from: z  reason: collision with root package name */
        private Provider<OkHttpClient> f31871z;

        private OkHttpClient A() {
            return IMDBModule_ProvideOkHttpClientFactory.a(this.f31852g, this.f31855j.get());
        }

        private Retrofit B() {
            return TMDBModule_ProvideRestAdapterFactory.c(this.f31848c, y(), TMDBModule_ProvideGsonFactory.c(this.f31848c));
        }

        private Retrofit C() {
            return TVMazeModule_ProvideRestAdapterFactory.a(this.f31849d, z(), TVMazeModule_ProvideGsonFactory.a(this.f31849d));
        }

        private Retrofit D() {
            return IMDBModule_ProvideRestAdapterFactory.a(this.f31852g, A(), IMDBModule_ProvideGsonFactory.a(this.f31852g));
        }

        private void v(AppModule appModule, TMDBModule tMDBModule, TVMazeModule tVMazeModule, RepositoryModule repositoryModule, ApiModule apiModule, DatabaseModule databaseModule, RealDebridModule realDebridModule, OpenSubtitleModule openSubtitleModule, MoviesHelper moviesHelper, IMDBModule iMDBModule, TvdbModule tvdbModule, PlayerHelperModule playerHelperModule) {
            Provider<Application> a2 = DoubleCheck.a(AppModule_ProvideApplicationFactory.a(appModule));
            this.f31855j = a2;
            this.f31856k = DoubleCheck.a(DatabaseModule_ProviderDemoDatabaseFactory.a(databaseModule, a2));
            this.f31857l = DoubleCheck.a(RealDebridModule_ProvideOkHttpClientFactory.a(realDebridModule, this.f31855j));
            RealDebridModule_ProvideGsonFactory a3 = RealDebridModule_ProvideGsonFactory.a(realDebridModule);
            this.f31858m = a3;
            this.f31859n = DoubleCheck.a(RealDebridModule_ProvideRestAdapterFactory.a(realDebridModule, this.f31857l, a3));
            this.f31860o = TMDBModule_ProvideOkHttpClientFactory.a(tMDBModule, this.f31855j);
            TMDBModule_ProvideGsonFactory a4 = TMDBModule_ProvideGsonFactory.a(tMDBModule);
            this.f31861p = a4;
            TMDBModule_ProvideRestAdapterFactory a5 = TMDBModule_ProvideRestAdapterFactory.a(tMDBModule, this.f31860o, a4);
            this.f31862q = a5;
            TMDBModule_ProvideTMDBApiFactory a6 = TMDBModule_ProvideTMDBApiFactory.a(tMDBModule, a5);
            this.f31863r = a6;
            RepositoryModule_ProvideTmdbRepositoryFactory a7 = RepositoryModule_ProvideTmdbRepositoryFactory.a(repositoryModule, a6, this.f31856k);
            this.f31864s = a7;
            MoviesHelper_ProviderMoviesHelperFactory a8 = MoviesHelper_ProviderMoviesHelperFactory.a(moviesHelper, a7, this.f31856k);
            this.f31865t = a8;
            this.f31866u = DoubleCheck.a(PlayerHelperModule_ProvideMainPlayHelperFactory.a(playerHelperModule, a8));
            this.f31867v = DoubleCheck.a(PlayerHelperModule_ProvideSourcePlayHelperFactory.a(playerHelperModule, this.f31865t));
            this.f31868w = DoubleCheck.a(PlayerHelperModule_ProvideDetailsPlayHelperFactory.a(playerHelperModule, this.f31865t));
            this.f31869x = DoubleCheck.a(PlayerHelperModule_ProvideEpisodePlayHelperFactory.a(playerHelperModule, this.f31865t));
            this.f31870y = DoubleCheck.a(PlayerHelperModule_ProvideCastPlayHelperFactory.a(playerHelperModule, this.f31865t));
            ApiModule_ProvideGlobalOkHttpClientFactory a9 = ApiModule_ProvideGlobalOkHttpClientFactory.a(apiModule, this.f31855j);
            this.f31871z = a9;
            this.A = DoubleCheck.a(OpenSubtitleModule_ProvideOpenSubtitleApiFactory.create(openSubtitleModule, a9));
        }

        private FreeMoviesApp w(FreeMoviesApp freeMoviesApp) {
            FreeMoviesApp_MembersInjector.a(freeMoviesApp, e());
            return freeMoviesApp;
        }

        private OkHttpClient x() {
            return ApiModule_ProvideOkHttpClientFactory.a(this.f31847b, this.f31855j.get());
        }

        private OkHttpClient y() {
            return TMDBModule_ProvideOkHttpClientFactory.c(this.f31848c, this.f31855j.get());
        }

        private OkHttpClient z() {
            return TVMazeModule_ProvideOkHttpClientFactory.a(this.f31849d, this.f31855j.get());
        }

        public MvDatabase a() {
            return this.f31856k.get();
        }

        public RealDebridApi b() {
            return RealDebridModule_ProvideRealDebridApiFactory.a(this.f31850e, this.f31859n.get());
        }

        public MoviesHelper c() {
            return MoviesHelper_ProviderMoviesHelperFactory.c(this.f31851f, f(), this.f31856k.get());
        }

        public PlayerHelper d() {
            return this.f31866u.get();
        }

        public MoviesApi e() {
            return ApiModule_ProvideMoviesApiFactory.a(this.f31847b, u());
        }

        public TMDBRepositoryImpl f() {
            return RepositoryModule_ProvideTmdbRepositoryFactory.c(this.f31846a, g(), this.f31856k.get());
        }

        public TMDBApi g() {
            return TMDBModule_ProvideTMDBApiFactory.c(this.f31848c, B());
        }

        public PlayerHelper h() {
            return this.f31869x.get();
        }

        public TraktRepositoryImpl i() {
            return RepositoryModule_ProvidesTraktRepositoryFactory.a(this.f31846a, this.f31856k.get());
        }

        public PlayerHelper j() {
            return this.f31867v.get();
        }

        public OpenSubtitleV1Api k() {
            return this.A.get();
        }

        public Gson l() {
            return ApiModule_ProvideGsonFactory.a(this.f31847b);
        }

        public TheTvdb m() {
            return TvdbModule_ProvideTheTvdbFactory.a(this.f31853h);
        }

        public PlayerHelper n() {
            return this.f31870y.get();
        }

        public IMDBApi o() {
            return IMDBModule_ProvideIMDBApiFactory.a(this.f31852g, D());
        }

        public OkHttpClient p() {
            return ApiModule_ProvideGlobalOkHttpClientFactory.c(this.f31847b, this.f31855j.get());
        }

        public PlayerHelper q() {
            return this.f31868w.get();
        }

        public TVMazeApi r() {
            return TVMazeModule_ProvideTVMazeApiFactory.a(this.f31849d, C());
        }

        public OkHttpClient s() {
            return this.f31857l.get();
        }

        public void t(FreeMoviesApp freeMoviesApp) {
            w(freeMoviesApp);
        }

        public Retrofit u() {
            return ApiModule_ProvideRestAdapterFactory.a(this.f31847b, x(), ApiModule_ProvideGsonFactory.a(this.f31847b));
        }

        private AppComponentImpl(AppModule appModule, TMDBModule tMDBModule, TVMazeModule tVMazeModule, RepositoryModule repositoryModule, ApiModule apiModule, DatabaseModule databaseModule, RealDebridModule realDebridModule, OpenSubtitleModule openSubtitleModule, MoviesHelper moviesHelper, IMDBModule iMDBModule, TvdbModule tvdbModule, PlayerHelperModule playerHelperModule) {
            this.f31854i = this;
            this.f31846a = repositoryModule;
            this.f31847b = apiModule;
            this.f31848c = tMDBModule;
            this.f31849d = tVMazeModule;
            this.f31850e = realDebridModule;
            this.f31851f = moviesHelper;
            this.f31852g = iMDBModule;
            this.f31853h = tvdbModule;
            v(appModule, tMDBModule, tVMazeModule, repositoryModule, apiModule, databaseModule, realDebridModule, openSubtitleModule, moviesHelper, iMDBModule, tvdbModule, playerHelperModule);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private AppModule f31872a;

        /* renamed from: b  reason: collision with root package name */
        private TMDBModule f31873b;

        /* renamed from: c  reason: collision with root package name */
        private TVMazeModule f31874c;

        /* renamed from: d  reason: collision with root package name */
        private RepositoryModule f31875d;

        /* renamed from: e  reason: collision with root package name */
        private ApiModule f31876e;

        /* renamed from: f  reason: collision with root package name */
        private DatabaseModule f31877f;

        /* renamed from: g  reason: collision with root package name */
        private RealDebridModule f31878g;

        /* renamed from: h  reason: collision with root package name */
        private OpenSubtitleModule f31879h;

        /* renamed from: i  reason: collision with root package name */
        private MoviesHelper f31880i;

        /* renamed from: j  reason: collision with root package name */
        private IMDBModule f31881j;

        /* renamed from: k  reason: collision with root package name */
        private TvdbModule f31882k;

        /* renamed from: l  reason: collision with root package name */
        private PlayerHelperModule f31883l;

        public Builder a(AppModule appModule) {
            this.f31872a = (AppModule) Preconditions.b(appModule);
            return this;
        }

        public AppComponent b() {
            Preconditions.a(this.f31872a, AppModule.class);
            if (this.f31873b == null) {
                this.f31873b = new TMDBModule();
            }
            if (this.f31874c == null) {
                this.f31874c = new TVMazeModule();
            }
            if (this.f31875d == null) {
                this.f31875d = new RepositoryModule();
            }
            if (this.f31876e == null) {
                this.f31876e = new ApiModule();
            }
            if (this.f31877f == null) {
                this.f31877f = new DatabaseModule();
            }
            if (this.f31878g == null) {
                this.f31878g = new RealDebridModule();
            }
            if (this.f31879h == null) {
                this.f31879h = new OpenSubtitleModule();
            }
            if (this.f31880i == null) {
                this.f31880i = new MoviesHelper();
            }
            if (this.f31881j == null) {
                this.f31881j = new IMDBModule();
            }
            if (this.f31882k == null) {
                this.f31882k = new TvdbModule();
            }
            if (this.f31883l == null) {
                this.f31883l = new PlayerHelperModule();
            }
            return new AppComponentImpl(this.f31872a, this.f31873b, this.f31874c, this.f31875d, this.f31876e, this.f31877f, this.f31878g, this.f31879h, this.f31880i, this.f31881j, this.f31882k, this.f31883l);
        }

        private Builder() {
        }
    }

    private DaggerAppComponent() {
    }

    public static Builder a() {
        return new Builder();
    }
}

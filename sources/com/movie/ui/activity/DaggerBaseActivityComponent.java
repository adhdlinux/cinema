package com.movie.ui.activity;

import com.database.MvDatabase;
import com.movie.AppComponent;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.api.tvmaze.TVMazeApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.activity.gamechallenge.GameChallenge;
import com.movie.ui.activity.gamechallenge.GameChallenge_MembersInjector;
import com.movie.ui.activity.payment.keyManager.KeyManager;
import com.movie.ui.activity.payment.keyManager.KeyManager_MembersInjector;
import com.movie.ui.activity.player.PlayerActivity;
import com.movie.ui.activity.player.PlayerActivity_MembersInjector;
import com.movie.ui.activity.shows.ShowActivity;
import com.movie.ui.activity.shows.ShowActivity_MembersInjector;
import com.movie.ui.activity.sources.SourceActivity;
import com.movie.ui.activity.sources.SourceActivity_MembersInjector;
import com.movie.ui.activity.sources.episodesPack.EpisodesActivity;
import com.movie.ui.activity.sources.episodesPack.EpisodesActivity_MembersInjector;
import com.movie.ui.activity.sources.seasonPack.SeasonPackActivity;
import com.movie.ui.activity.sources.seasonPack.SeasonPackActivity_MembersInjector;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.utils.ExpandedControlsActivity;
import com.utils.ExpandedControlsActivity_MembersInjector;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

public final class DaggerBaseActivityComponent {

    private static final class BaseActivityComponentImpl implements BaseActivityComponent {

        /* renamed from: a  reason: collision with root package name */
        private final AppComponent f32023a;

        /* renamed from: b  reason: collision with root package name */
        private final BaseActivityComponentImpl f32024b;

        private CalendarActivity n(CalendarActivity calendarActivity) {
            CalendarActivity_MembersInjector.f(calendarActivity, (TVMazeApi) Preconditions.c(this.f32023a.r()));
            CalendarActivity_MembersInjector.c(calendarActivity, (MvDatabase) Preconditions.c(this.f32023a.a()));
            CalendarActivity_MembersInjector.e(calendarActivity, (TMDBApi) Preconditions.c(this.f32023a.g()));
            CalendarActivity_MembersInjector.a(calendarActivity, (IMDBApi) Preconditions.c(this.f32023a.o()));
            CalendarActivity_MembersInjector.d(calendarActivity, (TheTvdb) Preconditions.c(this.f32023a.m()));
            CalendarActivity_MembersInjector.b(calendarActivity, (MoviesHelper) Preconditions.c(this.f32023a.c()));
            return calendarActivity;
        }

        private EpisodesActivity o(EpisodesActivity episodesActivity) {
            EpisodesActivity_MembersInjector.a(episodesActivity, (MoviesHelper) Preconditions.c(this.f32023a.c()));
            EpisodesActivity_MembersInjector.c(episodesActivity, (MvDatabase) Preconditions.c(this.f32023a.a()));
            EpisodesActivity_MembersInjector.e(episodesActivity, (RealDebridApi) Preconditions.c(this.f32023a.b()));
            EpisodesActivity_MembersInjector.b(episodesActivity, (MoviesApi) Preconditions.c(this.f32023a.e()));
            EpisodesActivity_MembersInjector.d(episodesActivity, (PlayerHelper) Preconditions.c(this.f32023a.h()));
            return episodesActivity;
        }

        private ExpandedControlsActivity p(ExpandedControlsActivity expandedControlsActivity) {
            ExpandedControlsActivity_MembersInjector.a(expandedControlsActivity, (PlayerHelper) Preconditions.c(this.f32023a.n()));
            return expandedControlsActivity;
        }

        private GameChallenge q(GameChallenge gameChallenge) {
            GameChallenge_MembersInjector.a(gameChallenge, (MoviesApi) Preconditions.c(this.f32023a.e()));
            return gameChallenge;
        }

        private KeyManager r(KeyManager keyManager) {
            KeyManager_MembersInjector.a(keyManager, (MoviesApi) Preconditions.c(this.f32023a.e()));
            return keyManager;
        }

        private MainActivity s(MainActivity mainActivity) {
            MainActivity_MembersInjector.d(mainActivity, (TMDBRepositoryImpl) Preconditions.c(this.f32023a.f()));
            MainActivity_MembersInjector.e(mainActivity, (TraktRepositoryImpl) Preconditions.c(this.f32023a.i()));
            MainActivity_MembersInjector.b(mainActivity, (MvDatabase) Preconditions.c(this.f32023a.a()));
            MainActivity_MembersInjector.a(mainActivity, (MoviesApi) Preconditions.c(this.f32023a.e()));
            MainActivity_MembersInjector.c(mainActivity, (PlayerHelper) Preconditions.c(this.f32023a.d()));
            return mainActivity;
        }

        private MemberActivationActivity t(MemberActivationActivity memberActivationActivity) {
            MemberActivationActivity_MembersInjector.a(memberActivationActivity, (MoviesApi) Preconditions.c(this.f32023a.e()));
            return memberActivationActivity;
        }

        private MovieDetailsActivity u(MovieDetailsActivity movieDetailsActivity) {
            MovieDetailsActivity_MembersInjector.c(movieDetailsActivity, (TMDBApi) Preconditions.c(this.f32023a.g()));
            MovieDetailsActivity_MembersInjector.a(movieDetailsActivity, (MoviesHelper) Preconditions.c(this.f32023a.c()));
            MovieDetailsActivity_MembersInjector.b(movieDetailsActivity, (PlayerHelper) Preconditions.c(this.f32023a.q()));
            return movieDetailsActivity;
        }

        private PlayerActivity v(PlayerActivity playerActivity) {
            PlayerActivity_MembersInjector.a(playerActivity, (OkHttpClient) Preconditions.c(this.f32023a.p()));
            return playerActivity;
        }

        private SeasonPackActivity w(SeasonPackActivity seasonPackActivity) {
            SeasonPackActivity_MembersInjector.a(seasonPackActivity, (MvDatabase) Preconditions.c(this.f32023a.a()));
            SeasonPackActivity_MembersInjector.b(seasonPackActivity, (RealDebridApi) Preconditions.c(this.f32023a.b()));
            return seasonPackActivity;
        }

        private ShowActivity x(ShowActivity showActivity) {
            ShowActivity_MembersInjector.b(showActivity, (MvDatabase) Preconditions.c(this.f32023a.a()));
            ShowActivity_MembersInjector.a(showActivity, (MoviesHelper) Preconditions.c(this.f32023a.c()));
            ShowActivity_MembersInjector.d(showActivity, (TMDBApi) Preconditions.c(this.f32023a.g()));
            ShowActivity_MembersInjector.c(showActivity, (TheTvdb) Preconditions.c(this.f32023a.m()));
            return showActivity;
        }

        private SourceActivity y(SourceActivity sourceActivity) {
            SourceActivity_MembersInjector.b(sourceActivity, (MoviesApi) Preconditions.c(this.f32023a.e()));
            SourceActivity_MembersInjector.a(sourceActivity, (MoviesHelper) Preconditions.c(this.f32023a.c()));
            SourceActivity_MembersInjector.c(sourceActivity, (MvDatabase) Preconditions.c(this.f32023a.a()));
            SourceActivity_MembersInjector.d(sourceActivity, (OpenSubtitleV1Api) Preconditions.c(this.f32023a.k()));
            SourceActivity_MembersInjector.e(sourceActivity, (PlayerHelper) Preconditions.c(this.f32023a.j()));
            SourceActivity_MembersInjector.f(sourceActivity, (OkHttpClient) Preconditions.c(this.f32023a.s()));
            return sourceActivity;
        }

        private TestCrappers z(TestCrappers testCrappers) {
            TestCrappers_MembersInjector.a(testCrappers, (IMDBApi) Preconditions.c(this.f32023a.o()));
            TestCrappers_MembersInjector.b(testCrappers, (TMDBApi) Preconditions.c(this.f32023a.g()));
            return testCrappers;
        }

        public void a(CalendarActivity calendarActivity) {
            n(calendarActivity);
        }

        public void b(MemberActivationActivity memberActivationActivity) {
            t(memberActivationActivity);
        }

        public void c(PlayerActivity playerActivity) {
            v(playerActivity);
        }

        public void d(ExpandedControlsActivity expandedControlsActivity) {
            p(expandedControlsActivity);
        }

        public void e(MovieDetailsActivity movieDetailsActivity) {
            u(movieDetailsActivity);
        }

        public void f(SeasonPackActivity seasonPackActivity) {
            w(seasonPackActivity);
        }

        public void g(EpisodesActivity episodesActivity) {
            o(episodesActivity);
        }

        public void h(ShowActivity showActivity) {
            x(showActivity);
        }

        public void i(KeyManager keyManager) {
            r(keyManager);
        }

        public void j(GameChallenge gameChallenge) {
            q(gameChallenge);
        }

        public void k(MainActivity mainActivity) {
            s(mainActivity);
        }

        public void l(SourceActivity sourceActivity) {
            y(sourceActivity);
        }

        public void m(TestCrappers testCrappers) {
            z(testCrappers);
        }

        private BaseActivityComponentImpl(AppComponent appComponent) {
            this.f32024b = this;
            this.f32023a = appComponent;
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private AppComponent f32025a;

        public Builder a(AppComponent appComponent) {
            this.f32025a = (AppComponent) Preconditions.b(appComponent);
            return this;
        }

        public BaseActivityComponent b() {
            Preconditions.a(this.f32025a, AppComponent.class);
            return new BaseActivityComponentImpl(this.f32025a);
        }

        private Builder() {
        }
    }

    private DaggerBaseActivityComponent() {
    }

    public static Builder a() {
        return new Builder();
    }
}

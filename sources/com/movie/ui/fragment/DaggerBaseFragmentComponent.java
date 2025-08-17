package com.movie.ui.fragment;

import com.database.MvDatabase;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.activity.payment.ChooseProductFragment;
import com.movie.ui.activity.payment.ChooseProductFragment_MembersInjector;
import com.movie.ui.activity.payment.PaymentProcessingFragment;
import com.movie.ui.activity.payment.PaymentProcessingFragment_MembersInjector;
import com.movie.ui.activity.payment.PaymentResultFragment;
import com.movie.ui.activity.payment.PaymentResultFragment_MembersInjector;
import com.movie.ui.activity.settings.CategoryListFragment;
import com.movie.ui.activity.settings.CategoryListFragment_MembersInjector;
import com.movie.ui.activity.settings.subfragment.GeneralFragment;
import com.movie.ui.activity.settings.subfragment.GeneralFragment_MembersInjector;
import com.movie.ui.activity.settings.subfragment.PremiumAccountFragment;
import com.movie.ui.activity.settings.subfragment.PremiumAccountFragment_MembersInjector;
import com.movie.ui.activity.settings.subfragment.SubtitleFragment;
import com.movie.ui.activity.settings.subfragment.SubtitleFragment_MembersInjector;
import com.movie.ui.activity.shows.episodes.bottomSheet.EpisodeBottomSheetFragment;
import com.movie.ui.activity.shows.episodes.bottomSheet.EpisodeBottomSheetFragment_MembersInjector;
import com.movie.ui.activity.shows.episodes.pageviewDialog.EpisodeDetailsFragment;
import com.movie.ui.activity.shows.episodes.pageviewDialog.PageViewDialog;
import com.movie.ui.activity.shows.episodes.pageviewDialog.PageViewDialog_MembersInjector;
import com.movie.ui.activity.shows.overview.OverviewFragment;
import com.movie.ui.activity.shows.overview.OverviewFragment_MembersInjector;
import com.movie.ui.activity.shows.seasons.SeasonFragment;
import com.movie.ui.activity.shows.seasons.SeasonFragment_MembersInjector;
import com.movie.ui.customdialog.AddMagnetDialog;
import com.movie.ui.customdialog.AddMagnetDialog_MembersInjector;
import com.movie.ui.fragment.favored.FavoredMoviesFragment;
import com.movie.ui.fragment.favored.FavoredMoviesFragment_MembersInjector;
import com.movie.ui.fragment.favored.FavoredPageFragment;
import com.movie.ui.fragment.history.HistoryFragment;
import com.movie.ui.fragment.history.HistoryFragment_MembersInjector;
import com.movie.ui.fragment.history.HistoryPageFragment;
import com.movie.ui.fragment.mylist.MyListFragment;
import com.movie.ui.fragment.mylist.MyListFragment_MembersInjector;
import com.movie.ui.fragment.mylist.UserListSelectionDialog;
import com.movie.ui.fragment.mylist.UserListSelectionDialog_MembersInjector;
import com.movie.ui.fragment.premium.FilesBottomSheetFragment;
import com.movie.ui.fragment.premium.FilesBottomSheetFragment_MembersInjector;
import com.movie.ui.fragment.premium.TorrentAdapterListFragment;
import com.movie.ui.fragment.premium.TorrentAdapterListFragment_MembersInjector;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import us.shandian.giga.ui.fragment.MissionsFragment;
import us.shandian.giga.ui.fragment.MissionsFragment_MembersInjector;

public final class DaggerBaseFragmentComponent {

    private static final class BaseFragmentComponentImpl implements BaseFragmentComponent {

        /* renamed from: a  reason: collision with root package name */
        private final AppComponent f33241a;

        /* renamed from: b  reason: collision with root package name */
        private final BaseFragmentComponentImpl f33242b;

        private BrowseMoviesFragment A(BrowseMoviesFragment browseMoviesFragment) {
            MoviesFragment_MembersInjector.c(browseMoviesFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            MoviesFragment_MembersInjector.d(browseMoviesFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            MoviesFragment_MembersInjector.e(browseMoviesFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            MoviesFragment_MembersInjector.g(browseMoviesFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            MoviesFragment_MembersInjector.a(browseMoviesFragment, (IMDBApi) Preconditions.c(this.f33241a.o()));
            MoviesFragment_MembersInjector.f(browseMoviesFragment, (TheTvdb) Preconditions.c(this.f33241a.m()));
            MoviesFragment_MembersInjector.b(browseMoviesFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            BrowseMoviesFragment_MembersInjector.a(browseMoviesFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            BrowseMoviesFragment_MembersInjector.b(browseMoviesFragment, (TraktRepositoryImpl) Preconditions.c(this.f33241a.i()));
            return browseMoviesFragment;
        }

        private CategoryListFragment B(CategoryListFragment categoryListFragment) {
            CategoryListFragment_MembersInjector.a(categoryListFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            CategoryListFragment_MembersInjector.b(categoryListFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            CategoryListFragment_MembersInjector.c(categoryListFragment, (TraktRepositoryImpl) Preconditions.c(this.f33241a.i()));
            return categoryListFragment;
        }

        private ChooseProductFragment C(ChooseProductFragment chooseProductFragment) {
            ChooseProductFragment_MembersInjector.a(chooseProductFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            return chooseProductFragment;
        }

        private EpisodeBottomSheetFragment D(EpisodeBottomSheetFragment episodeBottomSheetFragment) {
            EpisodeBottomSheetFragment_MembersInjector.a(episodeBottomSheetFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            EpisodeBottomSheetFragment_MembersInjector.b(episodeBottomSheetFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            EpisodeBottomSheetFragment_MembersInjector.c(episodeBottomSheetFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            return episodeBottomSheetFragment;
        }

        private FavoredMoviesFragment E(FavoredMoviesFragment favoredMoviesFragment) {
            MoviesFragment_MembersInjector.c(favoredMoviesFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            MoviesFragment_MembersInjector.d(favoredMoviesFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            MoviesFragment_MembersInjector.e(favoredMoviesFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            MoviesFragment_MembersInjector.g(favoredMoviesFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            MoviesFragment_MembersInjector.a(favoredMoviesFragment, (IMDBApi) Preconditions.c(this.f33241a.o()));
            MoviesFragment_MembersInjector.f(favoredMoviesFragment, (TheTvdb) Preconditions.c(this.f33241a.m()));
            MoviesFragment_MembersInjector.b(favoredMoviesFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            FavoredMoviesFragment_MembersInjector.a(favoredMoviesFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            FavoredMoviesFragment_MembersInjector.b(favoredMoviesFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            return favoredMoviesFragment;
        }

        private FilesBottomSheetFragment F(FilesBottomSheetFragment filesBottomSheetFragment) {
            FilesBottomSheetFragment_MembersInjector.a(filesBottomSheetFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            FilesBottomSheetFragment_MembersInjector.e(filesBottomSheetFragment, (RealDebridApi) Preconditions.c(this.f33241a.b()));
            FilesBottomSheetFragment_MembersInjector.b(filesBottomSheetFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            FilesBottomSheetFragment_MembersInjector.d(filesBottomSheetFragment, (PlayerHelper) Preconditions.c(this.f33241a.d()));
            FilesBottomSheetFragment_MembersInjector.c(filesBottomSheetFragment, (OpenSubtitleV1Api) Preconditions.c(this.f33241a.k()));
            return filesBottomSheetFragment;
        }

        private GeneralFragment G(GeneralFragment generalFragment) {
            GeneralFragment_MembersInjector.a(generalFragment, (PlayerHelper) Preconditions.c(this.f33241a.d()));
            return generalFragment;
        }

        private HistoryFragment H(HistoryFragment historyFragment) {
            MoviesFragment_MembersInjector.c(historyFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            MoviesFragment_MembersInjector.d(historyFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            MoviesFragment_MembersInjector.e(historyFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            MoviesFragment_MembersInjector.g(historyFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            MoviesFragment_MembersInjector.a(historyFragment, (IMDBApi) Preconditions.c(this.f33241a.o()));
            MoviesFragment_MembersInjector.f(historyFragment, (TheTvdb) Preconditions.c(this.f33241a.m()));
            MoviesFragment_MembersInjector.b(historyFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            HistoryFragment_MembersInjector.a(historyFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            HistoryFragment_MembersInjector.b(historyFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            return historyFragment;
        }

        private MissionsFragment I(MissionsFragment missionsFragment) {
            MissionsFragment_MembersInjector.a(missionsFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            MissionsFragment_MembersInjector.b(missionsFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            MissionsFragment_MembersInjector.c(missionsFragment, (PlayerHelper) Preconditions.c(this.f33241a.d()));
            return missionsFragment;
        }

        private MovieFragment J(MovieFragment movieFragment) {
            MovieFragment_MembersInjector.e(movieFragment, (OpenSubtitleV1Api) Preconditions.c(this.f33241a.k()));
            MovieFragment_MembersInjector.b(movieFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            MovieFragment_MembersInjector.d(movieFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            MovieFragment_MembersInjector.c(movieFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            MovieFragment_MembersInjector.h(movieFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            MovieFragment_MembersInjector.a(movieFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            MovieFragment_MembersInjector.g(movieFragment, (OkHttpClient) Preconditions.c(this.f33241a.s()));
            MovieFragment_MembersInjector.f(movieFragment, (PlayerHelper) Preconditions.c(this.f33241a.q()));
            return movieFragment;
        }

        private MyListFragment K(MyListFragment myListFragment) {
            MyListFragment_MembersInjector.a(myListFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            MyListFragment_MembersInjector.b(myListFragment, (TraktRepositoryImpl) Preconditions.c(this.f33241a.i()));
            return myListFragment;
        }

        private OverviewFragment L(OverviewFragment overviewFragment) {
            OverviewFragment_MembersInjector.d(overviewFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            OverviewFragment_MembersInjector.b(overviewFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            OverviewFragment_MembersInjector.c(overviewFragment, (TheTvdb) Preconditions.c(this.f33241a.m()));
            OverviewFragment_MembersInjector.a(overviewFragment, (MoviesHelper) Preconditions.c(this.f33241a.c()));
            return overviewFragment;
        }

        private PageViewDialog M(PageViewDialog pageViewDialog) {
            PageViewDialog_MembersInjector.a(pageViewDialog, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            PageViewDialog_MembersInjector.b(pageViewDialog, (MvDatabase) Preconditions.c(this.f33241a.a()));
            PageViewDialog_MembersInjector.c(pageViewDialog, (TMDBApi) Preconditions.c(this.f33241a.g()));
            return pageViewDialog;
        }

        private PaymentProcessingFragment N(PaymentProcessingFragment paymentProcessingFragment) {
            PaymentProcessingFragment_MembersInjector.a(paymentProcessingFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            return paymentProcessingFragment;
        }

        private PaymentResultFragment O(PaymentResultFragment paymentResultFragment) {
            PaymentResultFragment_MembersInjector.a(paymentResultFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            return paymentResultFragment;
        }

        private PremiumAccountFragment P(PremiumAccountFragment premiumAccountFragment) {
            PremiumAccountFragment_MembersInjector.b(premiumAccountFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            PremiumAccountFragment_MembersInjector.d(premiumAccountFragment, (RealDebridApi) Preconditions.c(this.f33241a.b()));
            PremiumAccountFragment_MembersInjector.a(premiumAccountFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            PremiumAccountFragment_MembersInjector.c(premiumAccountFragment, (OpenSubtitleV1Api) Preconditions.c(this.f33241a.k()));
            return premiumAccountFragment;
        }

        private SeasonFragment Q(SeasonFragment seasonFragment) {
            SeasonFragment_MembersInjector.a(seasonFragment, (TMDBRepositoryImpl) Preconditions.c(this.f33241a.f()));
            SeasonFragment_MembersInjector.d(seasonFragment, (TheTvdb) Preconditions.c(this.f33241a.m()));
            SeasonFragment_MembersInjector.c(seasonFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            SeasonFragment_MembersInjector.e(seasonFragment, (TMDBApi) Preconditions.c(this.f33241a.g()));
            SeasonFragment_MembersInjector.b(seasonFragment, (MoviesApi) Preconditions.c(this.f33241a.e()));
            return seasonFragment;
        }

        private SubtitleFragment R(SubtitleFragment subtitleFragment) {
            SubtitleFragment_MembersInjector.b(subtitleFragment, (OpenSubtitleV1Api) Preconditions.c(this.f33241a.k()));
            SubtitleFragment_MembersInjector.a(subtitleFragment, (Gson) Preconditions.c(this.f33241a.l()));
            return subtitleFragment;
        }

        private TorrentAdapterListFragment S(TorrentAdapterListFragment torrentAdapterListFragment) {
            TorrentAdapterListFragment_MembersInjector.a(torrentAdapterListFragment, (MvDatabase) Preconditions.c(this.f33241a.a()));
            TorrentAdapterListFragment_MembersInjector.b(torrentAdapterListFragment, (RealDebridApi) Preconditions.c(this.f33241a.b()));
            return torrentAdapterListFragment;
        }

        private TorrentManagerFragment T(TorrentManagerFragment torrentManagerFragment) {
            TorrentManagerFragment_MembersInjector.a(torrentManagerFragment, (RealDebridApi) Preconditions.c(this.f33241a.b()));
            return torrentManagerFragment;
        }

        private UserListSelectionDialog U(UserListSelectionDialog userListSelectionDialog) {
            UserListSelectionDialog_MembersInjector.b(userListSelectionDialog, (TraktRepositoryImpl) Preconditions.c(this.f33241a.i()));
            UserListSelectionDialog_MembersInjector.a(userListSelectionDialog, (MvDatabase) Preconditions.c(this.f33241a.a()));
            return userListSelectionDialog;
        }

        private AddMagnetDialog z(AddMagnetDialog addMagnetDialog) {
            AddMagnetDialog_MembersInjector.b(addMagnetDialog, (RealDebridApi) Preconditions.c(this.f33241a.b()));
            AddMagnetDialog_MembersInjector.a(addMagnetDialog, (MvDatabase) Preconditions.c(this.f33241a.a()));
            return addMagnetDialog;
        }

        public void a(OverviewFragment overviewFragment) {
            L(overviewFragment);
        }

        public void b(PremiumAccountFragment premiumAccountFragment) {
            P(premiumAccountFragment);
        }

        public void c(MovieFragment movieFragment) {
            J(movieFragment);
        }

        public void d(MyListFragment myListFragment) {
            K(myListFragment);
        }

        public void e(MissionsFragment missionsFragment) {
            I(missionsFragment);
        }

        public void f(FavoredPageFragment favoredPageFragment) {
        }

        public void g(TorrentManagerFragment torrentManagerFragment) {
            T(torrentManagerFragment);
        }

        public void h(PageViewDialog pageViewDialog) {
            M(pageViewDialog);
        }

        public void i(UserListSelectionDialog userListSelectionDialog) {
            U(userListSelectionDialog);
        }

        public void j(CategoryListFragment categoryListFragment) {
            B(categoryListFragment);
        }

        public void k(HistoryPageFragment historyPageFragment) {
        }

        public void l(GeneralFragment generalFragment) {
            G(generalFragment);
        }

        public void m(PaymentResultFragment paymentResultFragment) {
            O(paymentResultFragment);
        }

        public void n(TorrentAdapterListFragment torrentAdapterListFragment) {
            S(torrentAdapterListFragment);
        }

        public void o(FavoredMoviesFragment favoredMoviesFragment) {
            E(favoredMoviesFragment);
        }

        public void p(HistoryFragment historyFragment) {
            H(historyFragment);
        }

        public void q(EpisodeBottomSheetFragment episodeBottomSheetFragment) {
            D(episodeBottomSheetFragment);
        }

        public void r(SubtitleFragment subtitleFragment) {
            R(subtitleFragment);
        }

        public void s(FilesBottomSheetFragment filesBottomSheetFragment) {
            F(filesBottomSheetFragment);
        }

        public void t(SeasonFragment seasonFragment) {
            Q(seasonFragment);
        }

        public void u(ChooseProductFragment chooseProductFragment) {
            C(chooseProductFragment);
        }

        public void v(EpisodeDetailsFragment episodeDetailsFragment) {
        }

        public void w(AddMagnetDialog addMagnetDialog) {
            z(addMagnetDialog);
        }

        public void x(BrowseMoviesFragment browseMoviesFragment) {
            A(browseMoviesFragment);
        }

        public void y(PaymentProcessingFragment paymentProcessingFragment) {
            N(paymentProcessingFragment);
        }

        private BaseFragmentComponentImpl(AppComponent appComponent) {
            this.f33242b = this;
            this.f33241a = appComponent;
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private AppComponent f33243a;

        public Builder a(AppComponent appComponent) {
            this.f33243a = (AppComponent) Preconditions.b(appComponent);
            return this;
        }

        public BaseFragmentComponent b() {
            Preconditions.a(this.f33243a, AppComponent.class);
            return new BaseFragmentComponentImpl(this.f33243a);
        }

        private Builder() {
        }
    }

    private DaggerBaseFragmentComponent() {
    }

    public static Builder a() {
        return new Builder();
    }
}

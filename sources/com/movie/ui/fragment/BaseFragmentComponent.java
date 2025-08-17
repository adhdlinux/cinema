package com.movie.ui.fragment;

import com.movie.AppComponent;
import com.movie.ui.activity.payment.ChooseProductFragment;
import com.movie.ui.activity.payment.PaymentProcessingFragment;
import com.movie.ui.activity.payment.PaymentResultFragment;
import com.movie.ui.activity.settings.CategoryListFragment;
import com.movie.ui.activity.settings.subfragment.GeneralFragment;
import com.movie.ui.activity.settings.subfragment.PremiumAccountFragment;
import com.movie.ui.activity.settings.subfragment.SubtitleFragment;
import com.movie.ui.activity.shows.episodes.bottomSheet.EpisodeBottomSheetFragment;
import com.movie.ui.activity.shows.episodes.pageviewDialog.EpisodeDetailsFragment;
import com.movie.ui.activity.shows.episodes.pageviewDialog.PageViewDialog;
import com.movie.ui.activity.shows.overview.OverviewFragment;
import com.movie.ui.activity.shows.seasons.SeasonFragment;
import com.movie.ui.customdialog.AddMagnetDialog;
import com.movie.ui.fragment.favored.FavoredMoviesFragment;
import com.movie.ui.fragment.favored.FavoredPageFragment;
import com.movie.ui.fragment.history.HistoryFragment;
import com.movie.ui.fragment.history.HistoryPageFragment;
import com.movie.ui.fragment.mylist.MyListFragment;
import com.movie.ui.fragment.mylist.UserListSelectionDialog;
import com.movie.ui.fragment.premium.FilesBottomSheetFragment;
import com.movie.ui.fragment.premium.TorrentAdapterListFragment;
import dagger.Component;
import us.shandian.giga.ui.fragment.MissionsFragment;

@Component(dependencies = {AppComponent.class})
public interface BaseFragmentComponent {
    void a(OverviewFragment overviewFragment);

    void b(PremiumAccountFragment premiumAccountFragment);

    void c(MovieFragment movieFragment);

    void d(MyListFragment myListFragment);

    void e(MissionsFragment missionsFragment);

    void f(FavoredPageFragment favoredPageFragment);

    void g(TorrentManagerFragment torrentManagerFragment);

    void h(PageViewDialog pageViewDialog);

    void i(UserListSelectionDialog userListSelectionDialog);

    void j(CategoryListFragment categoryListFragment);

    void k(HistoryPageFragment historyPageFragment);

    void l(GeneralFragment generalFragment);

    void m(PaymentResultFragment paymentResultFragment);

    void n(TorrentAdapterListFragment torrentAdapterListFragment);

    void o(FavoredMoviesFragment favoredMoviesFragment);

    void p(HistoryFragment historyFragment);

    void q(EpisodeBottomSheetFragment episodeBottomSheetFragment);

    void r(SubtitleFragment subtitleFragment);

    void s(FilesBottomSheetFragment filesBottomSheetFragment);

    void t(SeasonFragment seasonFragment);

    void u(ChooseProductFragment chooseProductFragment);

    void v(EpisodeDetailsFragment episodeDetailsFragment);

    void w(AddMagnetDialog addMagnetDialog);

    void x(BrowseMoviesFragment browseMoviesFragment);

    void y(PaymentProcessingFragment paymentProcessingFragment);
}

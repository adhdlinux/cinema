package com.movie.ui.activity;

import com.movie.AppComponent;
import com.movie.ui.activity.gamechallenge.GameChallenge;
import com.movie.ui.activity.payment.keyManager.KeyManager;
import com.movie.ui.activity.player.PlayerActivity;
import com.movie.ui.activity.shows.ShowActivity;
import com.movie.ui.activity.sources.SourceActivity;
import com.movie.ui.activity.sources.episodesPack.EpisodesActivity;
import com.movie.ui.activity.sources.seasonPack.SeasonPackActivity;
import com.utils.ExpandedControlsActivity;
import dagger.Component;

@Component(dependencies = {AppComponent.class})
public interface BaseActivityComponent {
    void a(CalendarActivity calendarActivity);

    void b(MemberActivationActivity memberActivationActivity);

    void c(PlayerActivity playerActivity);

    void d(ExpandedControlsActivity expandedControlsActivity);

    void e(MovieDetailsActivity movieDetailsActivity);

    void f(SeasonPackActivity seasonPackActivity);

    void g(EpisodesActivity episodesActivity);

    void h(ShowActivity showActivity);

    void i(KeyManager keyManager);

    void j(GameChallenge gameChallenge);

    void k(MainActivity mainActivity);

    void l(SourceActivity sourceActivity);

    void m(TestCrappers testCrappers);
}

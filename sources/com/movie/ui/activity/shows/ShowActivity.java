package com.movie.ui.activity.shows;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.ads.videoreward.AdsManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.database.MvDatabase;
import com.database.entitys.CategoryEntity;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.tmvdb.ExternalID;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.activity.MovieDetailsActivity;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.activity.shows.episodes.bottomSheet.EpisodeBottomSheetFragment;
import com.movie.ui.activity.shows.episodes.pageviewDialog.PageViewDialog;
import com.movie.ui.activity.shows.overview.OverviewFragment;
import com.movie.ui.activity.shows.seasons.SeasonFragment;
import com.movie.ui.activity.sources.SourceActivity;
import com.movie.ui.fragment.BrowseMoviesFragment;
import com.movie.ui.fragment.MoviesFragment;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.widget.glidepalette.BitmapPalette;
import com.movie.ui.widget.glidepalette.GlidePalette;
import com.original.tase.utils.DeviceUtils;
import com.utils.PosterCacheHelper;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import javax.inject.Inject;

public class ShowActivity extends BaseActivity implements EpisodeBottomSheetFragment.OnListFragmentInteractionListener, PageViewDialog.OnListFragmentInteractionListener, SeasonFragment.OnListFragmentInteractionListener, OverviewFragment.OnFragmentInteractionListener, MoviesFragment.Listener {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    MvDatabase f32670b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    MoviesHelper f32671c;
    @BindView(2131362046)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    TMDBApi f32672d;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    TheTvdb f32673e;

    /* renamed from: f  reason: collision with root package name */
    CompositeDisposable f32674f;

    /* renamed from: g  reason: collision with root package name */
    private MovieEntity f32675g;
    @BindView(2131362828)
    ImageView imageView;
    @BindView(2131362645)
    CoordinatorLayout root_view;
    @BindView(2131362752)
    TabLayout tabLayout;
    @BindView(2131362826)
    Toolbar toolbar;
    @BindView(2131362919)
    ViewPager viewPager;

    public static class ShowPagerAdapter extends FragmentStatePagerAdapter {

        /* renamed from: j  reason: collision with root package name */
        private MovieEntity f32679j;

        /* renamed from: k  reason: collision with root package name */
        SeasonFragment f32680k;

        /* renamed from: l  reason: collision with root package name */
        OverviewFragment f32681l;

        /* renamed from: m  reason: collision with root package name */
        BrowseMoviesFragment f32682m;

        /* renamed from: n  reason: collision with root package name */
        CompositeDisposable f32683n = this.f32683n;

        public ShowPagerAdapter(FragmentManager fragmentManager, MovieEntity movieEntity) {
            super(fragmentManager);
            this.f32679j = movieEntity;
        }

        public Fragment a(int i2) {
            return b(i2);
        }

        public Fragment b(int i2) {
            if (i2 == 0) {
                if (this.f32680k == null) {
                    this.f32680k = SeasonFragment.l0(1, this.f32679j);
                }
                return this.f32680k;
            } else if (i2 == 1) {
                if (this.f32681l == null) {
                    this.f32681l = OverviewFragment.Q(this.f32679j);
                }
                return this.f32681l;
            } else if (i2 != 2) {
                OverviewFragment overviewFragment = new OverviewFragment();
                overviewFragment.setArguments(new Bundle());
                return overviewFragment;
            } else {
                if (this.f32682m == null) {
                    this.f32682m = BrowseMoviesFragment.e0(new CategoryEntity(CategoryEntity.Source.TMDB, CategoryEntity.Type.Show, Integer.valueOf((int) this.f32679j.getTmdbID()), CategoryEntity.SourceType.Related, "Recommendations"));
                }
                return this.f32682m;
            }
        }

        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int i2) {
            return "OBJECT " + (i2 + 1);
        }
    }

    /* access modifiers changed from: private */
    public void G(Palette.Swatch swatch) {
        if (swatch != null) {
            this.tabLayout.setBackgroundColor(swatch.e());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(View view, Throwable th) throws Exception {
        H(th.getMessage(), view);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void J(MovieEntity movieEntity, ExternalID externalID) throws Exception {
        movieEntity.setTvdbID((long) externalID.getTvdb_id());
        movieEntity.setImdbIDStr(externalID.getImdb_id());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(MovieEntity movieEntity, Throwable th) throws Exception {
        this.viewPager.setAdapter(new ShowPagerAdapter(getSupportFragmentManager(), movieEntity));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(MovieEntity movieEntity) throws Exception {
        this.viewPager.setAdapter(new ShowPagerAdapter(getSupportFragmentManager(), movieEntity));
    }

    private void N(MovieEntity movieEntity) {
        if (movieEntity.getBackdrop_path() == null || Utils.X(this) == 2) {
            this.imageView.setVisibility(8);
            return;
        }
        this.imageView.setVisibility(0);
        RequestBuilder<Drawable> x02 = Glide.v(this).h(movieEntity.getBackdrop_path()).a(((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).c()).x0(new DrawableTransitionOptions().e());
        boolean z2 = FreeMoviesApp.p().getBoolean("pref_change_bg_color", true);
        if (!FreeMoviesApp.s() && z2) {
            x02.s0(GlidePalette.h(movieEntity.getBackdrop_path()).g(new BitmapPalette.CallBack() {
                public void a(Palette palette) {
                    ShowActivity.this.G(palette.f());
                }
            }));
        }
        x02.q0(this.imageView);
    }

    private void P(MovieEntity movieEntity) {
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.c(tabLayout2.w().o("Seasons"));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.c(tabLayout3.w().o("Overview"));
        TabLayout tabLayout4 = this.tabLayout;
        tabLayout4.c(tabLayout4.w().o("Recommendations"));
        this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void c(int i2) {
                ShowActivity.this.tabLayout.v(i2).i();
            }
        });
        this.tabLayout.b(new TabLayout.BaseOnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
                ShowActivity.this.viewPager.setCurrentItem(tab.e());
            }

            public void b(TabLayout.Tab tab) {
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        if (movieEntity.getBackdrop_path() == null || movieEntity.getBackdrop_path().isEmpty()) {
            movieEntity.setBackdrop_path(PosterCacheHelper.d().b(movieEntity.getTmdbID(), movieEntity.getTvdbID(), movieEntity.getImdbIDStr()));
        }
        N(movieEntity);
        if (movieEntity.getTvdbID() > 0) {
            this.viewPager.setAdapter(new ShowPagerAdapter(getSupportFragmentManager(), movieEntity));
        } else {
            this.f32674f.b(this.f32672d.getTVExternalID(movieEntity.getTmdbID()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(movieEntity), new d(this, movieEntity), new e(this, movieEntity)));
        }
    }

    /* access modifiers changed from: package-private */
    public void M(View view, int i2, int i3, boolean z2, boolean z3) {
        TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
        tvWatchedEpisode.m(i3);
        tvWatchedEpisode.q(i2);
        tvWatchedEpisode.s(this.f32675g.getTmdbID());
        tvWatchedEpisode.o(this.f32675g.getImdbIDStr());
        tvWatchedEpisode.u(this.f32675g.getTvdbID());
        tvWatchedEpisode.t(this.f32675g.getTraktID());
        this.f32674f.b(this.f32671c.l(this.f32675g, tvWatchedEpisode, z2, z3).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(this, view), new b(this, view)));
    }

    /* renamed from: O */
    public void H(String str, View view) {
        Snackbar w2 = Snackbar.w(view, str, 0);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) w2.k().getLayoutParams();
        layoutParams.bottomMargin = 0;
        w2.k().setLayoutParams(layoutParams);
        w2.s();
    }

    public void a(View view, int i2, int i3) {
        M(view, i2, i3, true, true);
    }

    public void b(View view, int i2, int i3) {
        M(view, i2, i3, false, true);
    }

    public void c(SeasonEntity seasonEntity, ArrayList<EpisodeItem> arrayList) {
        FragmentTransaction n2 = getSupportFragmentManager().n();
        Fragment i02 = getSupportFragmentManager().i0("fragment_edit_name");
        if (i02 != null) {
            n2.o(i02);
        }
        n2.g((String) null);
        PageViewDialog O = PageViewDialog.O("Some Title", this.f32675g, seasonEntity, arrayList);
        O.P(this);
        O.show(n2, "fragment_edit_name");
    }

    public void h(String str) {
        H(str, this.root_view);
    }

    public void m(MovieEntity movieEntity, View view) {
        if (movieEntity.getTV().booleanValue()) {
            Intent intent = new Intent(this, ShowActivity.class);
            intent.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", movieEntity);
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(this, MovieDetailsActivity.class);
            intent2.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", movieEntity);
            startActivity(intent2);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_show);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.t(true);
        }
        this.f32675g = (MovieEntity) getIntent().getParcelableExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE");
        this.f32674f = new CompositeDisposable();
        P(this.f32675g);
        this.toolbar.setTitle((CharSequence) this.f32675g.getName());
        this.collapsingToolbarLayout.setTitle(this.f32675g.getName());
        if (!DeviceUtils.b() && !DeviceUtils.a()) {
            AdsManager.d().o((ViewGroup) findViewById(R.id.adView));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_show, menu);
        MenuItem findItem = menu.findItem(R.id.menu_favorite);
        if (this.f32675g.getCollected_at() == null) {
            findItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_border));
            return true;
        }
        findItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_full));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32674f.dispose();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z2;
        if (menuItem.getItemId() == R.id.menu_favorite) {
            MoviesHelper moviesHelper = this.f32671c;
            MovieEntity movieEntity = this.f32675g;
            if (movieEntity.getCollected_at() == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            moviesHelper.m(this, movieEntity, z2);
            if (this.f32675g.getCollected_at() == null) {
                menuItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_border));
            } else {
                menuItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_full));
            }
            return true;
        }
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }

    public void p(String str) {
        H(str, this.root_view);
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().h(this);
    }

    public void u(EpisodeItem episodeItem, SeasonEntity seasonEntity) {
        String str;
        String str2;
        Utils.i0(this, "This function will take a few seconds");
        episodeItem.f32695c = Boolean.TRUE;
        Intent intent = new Intent(this, SourceActivity.class);
        intent.putExtra("Movie", this.f32675g);
        if (this.f32675g.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = this.f32675g.getRealeaseDate().split("-")[0];
        }
        String name = this.f32675g.getName();
        String str3 = "" + seasonEntity.j();
        String str4 = "" + episodeItem.f32694b;
        if (seasonEntity.c() == null) {
            str2 = "1970";
        } else {
            str2 = seasonEntity.c().split("-")[0];
        }
        MovieInfo movieInfo = new MovieInfo(name, str, str3, str4, str2, this.f32675g.getGenres());
        movieInfo.imdbIDStr = this.f32675g.getImdbIDStr();
        movieInfo.tmdbID = this.f32675g.getTmdbID();
        movieInfo.epsCount = episodeItem.f32698f.intValue();
        intent.putExtra("MovieInfo", movieInfo);
        startActivity(intent);
    }
}

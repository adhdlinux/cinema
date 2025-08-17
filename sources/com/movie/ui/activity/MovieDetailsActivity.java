package com.movie.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.palette.graphics.Palette;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.database.entitys.MovieEntity;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.CastStateListener;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.ui.fragment.MovieFragment;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.widget.glidepalette.BitmapPalette;
import com.movie.ui.widget.glidepalette.GlidePalette;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.http.HttpHelper;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.PosterCacheHelper;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Named;

public final class MovieDetailsActivity extends BaseActivity {
    @BindView(2131361911)
    AppBarLayout appBarLayout;

    /* renamed from: b  reason: collision with root package name */
    private MovieEntity f32125b;

    /* renamed from: c  reason: collision with root package name */
    private SessionManagerListener f32126c = null;
    @BindView(2131362046)
    CollapsingToolbarLayout collapsingToolbarLayout;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CastSession f32127d = null;

    /* renamed from: e  reason: collision with root package name */
    private CastContext f32128e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public IntroductoryOverlay f32129f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public MenuItem f32130g;

    /* renamed from: h  reason: collision with root package name */
    private CastStateListener f32131h;

    /* renamed from: i  reason: collision with root package name */
    private AdView f32132i = null;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    TMDBApi f32133j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    MoviesHelper f32134k;

    /* renamed from: l  reason: collision with root package name */
    CompositeDisposable f32135l;
    @Inject
    @Named("MovieDetailsActivity")

    /* renamed from: m  reason: collision with root package name */
    PlayerHelper f32136m;
    @BindView(2131362828)
    ImageView toolbar_image;
    @BindView(2131362872)
    TextView tv_genres_duration;

    /* access modifiers changed from: private */
    public void J(Palette.Swatch swatch) {
        if (FreeMoviesApp.p().getBoolean("pref_change_bg_color", true) && swatch != null) {
            getWindow().getDecorView().setBackgroundColor(swatch.e());
            TextView textView = this.tv_genres_duration;
            if (textView != null) {
                textView.setBackgroundColor(swatch.e());
                this.tv_genres_duration.setTextColor(swatch.f());
            }
        }
    }

    private void K(String str) {
        Glide.v(this).h(str).a(((RequestOptions) ((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).h(R.color.list_dropdown_foreground_selected)).c()).x0(new DrawableTransitionOptions().e()).s0(GlidePalette.h(str).g(new BitmapPalette.CallBack() {
            public void a(Palette palette) {
                MovieDetailsActivity.this.J(palette.f());
            }
        })).q0(this.toolbar_image);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(boolean z2, MovieTMDB.ResultsBean resultsBean) throws Exception {
        this.f32125b.setDuration(resultsBean.getRuntime() * 60 * 1000);
        this.tv_genres_duration.setText(Utils.n0(this.f32125b.getGenres(), ".", new StringBuilder(30)) + " - " + (resultsBean.getRuntime() / 60) + "hr " + (resultsBean.getRuntime() % 60) + "min");
        PosterCacheHelper.d().g((long) resultsBean.getId(), -1, resultsBean.getImdb_id(), resultsBean.getPoster_path(), resultsBean.getBackdrop_path());
        if (!z2) {
            this.f32125b.setBackdrop_path(resultsBean.getBackdrop_path());
            K(this.f32125b.getBackdrop_path());
        }
        if (!(resultsBean.getExternal_ids() == null || resultsBean.getExternal_ids().getImdb_id() == null)) {
            this.f32125b.setImdbIDStr(resultsBean.getExternal_ids().getImdb_id());
        }
        MovieFragment a12 = MovieFragment.a1(this.f32125b);
        a12.e1(this.appBarLayout);
        getSupportFragmentManager().n().q(R.id.movie_details_container, a12, "fragment_movie").h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(Throwable th) throws Exception {
        MovieFragment a12 = MovieFragment.a1(this.f32125b);
        a12.e1(this.appBarLayout);
        getSupportFragmentManager().n().q(R.id.movie_details_container, a12, "fragment_movie").h();
    }

    private void O() {
        this.f32126c = new SessionManagerListener<CastSession>() {
            private void a(CastSession castSession) {
                CastSession unused = MovieDetailsActivity.this.f32127d = castSession;
                Utils.h0(MovieDetailsActivity.this, R.string.cast_connected);
            }

            private void b() {
                CastSession unused = MovieDetailsActivity.this.f32127d = null;
                Utils.h0(MovieDetailsActivity.this, R.string.cast_disconnected);
                MovieDetailsActivity.this.invalidateOptionsMenu();
            }

            /* renamed from: c */
            public void onSessionEnded(CastSession castSession, int i2) {
                b();
            }

            /* renamed from: d */
            public void onSessionEnding(CastSession castSession) {
            }

            /* renamed from: e */
            public void onSessionResumeFailed(CastSession castSession, int i2) {
                b();
            }

            /* renamed from: f */
            public void onSessionResumed(CastSession castSession, boolean z2) {
                a(castSession);
            }

            /* renamed from: g */
            public void onSessionResuming(CastSession castSession, String str) {
            }

            /* renamed from: h */
            public void onSessionStartFailed(CastSession castSession, int i2) {
                b();
            }

            /* renamed from: i */
            public void onSessionStarted(CastSession castSession, String str) {
                a(castSession);
            }

            /* renamed from: j */
            public void onSessionStarting(CastSession castSession) {
            }

            /* renamed from: k */
            public void onSessionSuspended(CastSession castSession, int i2) {
            }
        };
    }

    /* access modifiers changed from: private */
    public void P() {
        IntroductoryOverlay introductoryOverlay = this.f32129f;
        if (introductoryOverlay != null) {
            introductoryOverlay.remove();
        }
        MenuItem menuItem = this.f32130g;
        if (menuItem != null && menuItem.isVisible()) {
            new Handler().post(new Runnable() {
                public void run() {
                    MovieDetailsActivity movieDetailsActivity = MovieDetailsActivity.this;
                    IntroductoryOverlay unused = movieDetailsActivity.f32129f = new IntroductoryOverlay.Builder((Activity) movieDetailsActivity, movieDetailsActivity.f32130g).setTitleText(MovieDetailsActivity.this.getString(R.string.introducing_cast)).setOverlayColor(R.color.theme_primary).setSingleTime().setOnOverlayDismissedListener(new IntroductoryOverlay.OnOverlayDismissedListener() {
                        public void onOverlayDismissed() {
                            IntroductoryOverlay unused = MovieDetailsActivity.this.f32129f = null;
                        }
                    }).build();
                    MovieDetailsActivity.this.f32129f.show();
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        CastContext castContext = this.f32128e;
        if (castContext == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (castContext.onDispatchVolumeKeyEventBeforeJellyBean(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32136m.H(this);
        setContentView(R.layout.activity_movie_details);
        if (RealDebridCredentialsHelper.d().isValid()) {
            Utils.f37608a = 250;
        }
        boolean z2 = false;
        boolean z3 = FreeMoviesApp.p().getBoolean("pref_show_debrid_only", false);
        boolean z4 = FreeMoviesApp.p().getBoolean("pref_low_profilev2", false);
        if (!z3 && !z4) {
            Utils.f37608a = 1000;
        }
        this.f32135l = new CompositeDisposable();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (bundle != null) {
                this.f32125b = (MovieEntity) bundle.getParcelable("movie");
            } else if (extras.getBoolean("isFromAnotherApp")) {
                this.f32125b = (MovieEntity) new Gson().l(extras.getString("com.freeapp.freemovies.extras.EXTRA_MOVIE"), MovieEntity.class);
            } else {
                this.f32125b = (MovieEntity) getIntent().getParcelableExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE");
            }
            Toolbar toolbar = this.mToolbar;
            if (toolbar != null) {
                ViewCompat.z0(toolbar, getResources().getDimension(R.dimen.toolbar_elevation));
                this.mToolbar.setNavigationOnClickListener(new d0(this));
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.s(0, 8);
                    supportActionBar.r(true);
                    supportActionBar.t(true);
                }
                this.collapsingToolbarLayout.setTitle(this.f32125b.getName());
            }
            if (Utils.f0()) {
                try {
                    O();
                    CastContext sharedInstance = CastContext.getSharedInstance(this);
                    this.f32128e = sharedInstance;
                    this.f32127d = sharedInstance.getSessionManager().getCurrentCastSession();
                    this.f32131h = new CastStateListener() {
                        public void onCastStateChanged(int i2) {
                            if (i2 != 1) {
                                MovieDetailsActivity.this.P();
                            }
                        }
                    };
                } catch (Exception unused) {
                    this.f32128e = null;
                }
            }
            if (this.f32125b.getBackdrop_path() != null && !this.f32125b.getBackdrop_path().isEmpty()) {
                z2 = true;
            }
            if (this.f32125b.getBackdrop_path() == null || this.f32125b.getBackdrop_path().isEmpty()) {
                String b2 = PosterCacheHelper.d().b(this.f32125b.getTmdbID(), this.f32125b.getTvdbID(), this.f32125b.getImdbIDStr());
                if (b2 != null) {
                    Glide.v(this).h(b2).a(((RequestOptions) ((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).h(R.color.list_dropdown_foreground_selected)).c()).x0(new DrawableTransitionOptions().e()).q0(this.toolbar_image);
                }
            } else if (z2) {
                K(this.f32125b.getBackdrop_path());
            }
            this.f32135l.b(this.f32133j.getMovieDetails(this.f32125b.getTmdbID(), (String) null).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e0(this, z2), new f0(this)));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_movie_details, menu);
        this.f32130g = CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), menu, R.id.media_route_menu_item);
        P();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32135l.dispose();
        BaseProvider.G();
        this.f32136m.z();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        CastContext castContext;
        if (Utils.f0() && (castContext = this.f32128e) != null) {
            castContext.getSessionManager().removeSessionManagerListener(this.f32126c, CastSession.class);
            this.f32128e.removeCastStateListener(this.f32131h);
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        CastContext castContext;
        if (Utils.f0() && (castContext = this.f32128e) != null) {
            castContext.getSessionManager().addSessionManagerListener(this.f32126c, CastSession.class);
            this.f32128e.addCastStateListener(this.f32131h);
            CastSession castSession = this.f32127d;
            if (castSession == null || !castSession.isConnected()) {
                Log.i("MOVIES_TAG", "CAST SESSION RESUME DIS_CONNECTED");
            } else {
                Log.i("MOVIES_TAG", "CAST SESSION RESUME CONNECTED");
            }
        }
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        bundle.putParcelable("movie", this.f32125b);
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        HttpHelper.i().z(HttpHelper.f33895d);
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().e(this);
    }
}

package com.movie.ui.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.movie.FreeMoviesApp;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.adapter.MoviesAdapter;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.widget.AnimatorStateView;
import com.movie.ui.widget.BetterViewAnimator;
import com.movie.ui.widget.MultiSwipeRefreshLayout;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import javax.inject.Inject;

public abstract class MoviesFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, MultiSwipeRefreshLayout.CanChildScrollUpCallback, MoviesAdapter.OnMovieClickListener {
    @Inject

    /* renamed from: d  reason: collision with root package name */
    TMDBRepositoryImpl f33293d;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    MoviesApi f33294e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    MvDatabase f33295f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public TMDBApi f33296g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    public IMDBApi f33297h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public TheTvdb f33298i;

    /* renamed from: j  reason: collision with root package name */
    public TraktRepositoryImpl f33299j = null;

    /* renamed from: k  reason: collision with root package name */
    private int f33300k = 5;

    /* renamed from: l  reason: collision with root package name */
    private int f33301l = 3;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    protected MoviesHelper f33302m;
    @BindView(2131362411)
    RecyclerView mRecyclerView;
    @BindView(2131362470)
    public MultiSwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(2131362409)
    public BetterViewAnimator mViewAnimator;
    @BindView(2131362910)
    public AnimatorStateView mViewError;

    /* renamed from: n  reason: collision with root package name */
    protected Listener f33303n;

    /* renamed from: o  reason: collision with root package name */
    protected MoviesAdapter f33304o;

    /* renamed from: p  reason: collision with root package name */
    protected GridLayoutManager f33305p;

    /* renamed from: q  reason: collision with root package name */
    protected CompositeDisposable f33306q;

    /* renamed from: r  reason: collision with root package name */
    protected int f33307r = -1;

    /* renamed from: s  reason: collision with root package name */
    public Toolbar f33308s;

    public interface Listener {
        void m(MovieEntity movieEntity, View view);
    }

    private void L() {
        this.mSwipeRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.swipe_progress_colors));
        this.mSwipeRefreshLayout.setOnRefreshListener(this);
        this.mSwipeRefreshLayout.setCanChildScrollUpCallback(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(View view, MovieEntity movieEntity) throws Exception {
        this.f33303n.m(movieEntity, view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(MovieEntity movieEntity, View view, Throwable th) throws Exception {
        this.f33303n.m(movieEntity, view);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O(MovieEntity movieEntity, View view) {
    }

    /* access modifiers changed from: protected */
    public void K() {
        this.f33300k = Integer.parseInt(String.valueOf(Utils.U().get(FreeMoviesApp.p().getString("pref_column_in_main", "Large"))));
        this.f33305p = new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.movies_columns));
        int X = Utils.X(getActivity());
        if (X == 2 || X == 0) {
            this.f33305p.s(this.f33300k);
        } else {
            this.f33305p.s(this.f33301l);
        }
        this.f33305p.setOrientation(1);
        this.f33305p.t(new GridLayoutManager.SpanSizeLookup() {
            public int f(int i2) {
                int k2 = MoviesFragment.this.f33305p.k();
                int itemViewType = MoviesFragment.this.f33304o.getItemViewType(i2);
                if (itemViewType == 2) {
                    return 1;
                }
                if (itemViewType != 3) {
                    return k2;
                }
                return 3;
            }
        });
        this.mRecyclerView.setLayoutManager(this.f33305p);
        this.mRecyclerView.setAdapter(this.f33304o);
        int i2 = this.f33307r;
        if (i2 != -1) {
            this.mRecyclerView.scrollToPosition(i2);
        }
    }

    public boolean n() {
        BetterViewAnimator betterViewAnimator;
        RecyclerView recyclerView = this.mRecyclerView;
        if ((recyclerView == null || !ViewCompat.e(recyclerView, -1)) && ((betterViewAnimator = this.mViewAnimator) == null || betterViewAnimator.getDisplayedChildId() != R.id.view_loading)) {
            return false;
        }
        return true;
    }

    public void onAttach(Activity activity) {
        if (activity instanceof Listener) {
            super.onAttach(activity);
            this.f33303n = (Listener) activity;
            return;
        }
        throw new IllegalStateException("Activity must implement MoviesFragment.Listener.");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int parseInt = Integer.parseInt(String.valueOf(Utils.U().get(FreeMoviesApp.p().getString("pref_column_in_main", "Large"))));
        this.f33300k = parseInt;
        int i2 = configuration.orientation;
        if (i2 == 2) {
            this.f33305p.s(parseInt);
        } else if (i2 == 1) {
            this.f33305p.s(this.f33301l);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_movies, viewGroup, false);
    }

    public void onDestroyView() {
        this.f33306q.dispose();
        MultiSwipeRefreshLayout multiSwipeRefreshLayout = this.mSwipeRefreshLayout;
        if (multiSwipeRefreshLayout != null) {
            multiSwipeRefreshLayout.setRefreshing(false);
            this.mSwipeRefreshLayout.destroyDrawingCache();
            this.mSwipeRefreshLayout.clearAnimation();
        }
        super.onDestroyView();
    }

    public void onDetach() {
        this.f33303n = new r0();
        this.f33304o.p(MoviesAdapter.OnMovieClickListener.B0);
        super.onDetach();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("state_selected_position", this.f33307r);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33306q = new CompositeDisposable();
        int i2 = -1;
        if (bundle != null) {
            i2 = bundle.getInt("state_selected_position", -1);
        }
        this.f33307r = i2;
        MoviesAdapter moviesAdapter = new MoviesAdapter(this, new ArrayList());
        this.f33304o = moviesAdapter;
        moviesAdapter.p(this);
        this.f33299j = new TraktRepositoryImpl(this.f33295f);
        L();
        K();
    }

    public void p(final MovieEntity movieEntity, View view, int i2) {
        this.f33307r = i2;
        if (movieEntity instanceof MovieEntity) {
            this.f33306q.b(Observable.create(new ObservableOnSubscribe<MovieEntity>() {
                public void subscribe(ObservableEmitter<MovieEntity> observableEmitter) throws Exception {
                    MovieEntity l2 = MoviesFragment.this.f33295f.A().l(movieEntity.getTmdbID(), movieEntity.getImdbIDStr(), movieEntity.getTraktID(), movieEntity.getTvdbID());
                    if (l2 != null) {
                        observableEmitter.onNext(l2);
                    } else {
                        observableEmitter.onNext(movieEntity);
                    }
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new s0(this, view), new t0(this, movieEntity, view)));
        }
    }
}

package com.movie.ui.fragment.favored;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.MoviesFragment;
import com.original.tase.RxBus;
import com.original.tase.api.TraktUserApi;
import com.original.tase.event.trakt.TrackSyncFaild;
import com.original.tase.event.trakt.TraktSyncSuccess;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public final class FavoredMoviesFragment extends MoviesFragment {

    /* renamed from: t  reason: collision with root package name */
    private CompositeDisposable f33330t = null;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    MvDatabase f33331u;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    TMDBApi f33332v;

    /* renamed from: w  reason: collision with root package name */
    private int f33333w = 0;

    /* renamed from: x  reason: collision with root package name */
    private int f33334x = 0;

    /* access modifiers changed from: private */
    public static /* synthetic */ void V(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(List list) throws Exception {
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.f33304o.l(list);
        this.mViewAnimator.setDisplayedChildId(T());
        int i2 = this.f33334x;
        if (i2 == -1) {
            this.f33304o.q(true);
        } else if (i2 == 1) {
            this.f33304o.q(false);
        }
        this.f33304o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(Throwable th) throws Exception {
        Timber.e(th, "Favored movies loading failed", new Object[0]);
        this.mViewAnimator.setDisplayedChildId(R.id.view_empty);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Y() throws Exception {
    }

    public static FavoredMoviesFragment Z(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("sortField", i2);
        FavoredMoviesFragment favoredMoviesFragment = new FavoredMoviesFragment();
        favoredMoviesFragment.setArguments(bundle);
        return favoredMoviesFragment;
    }

    private void a0(int i2) {
        if (!this.mSwipeRefreshLayout.isRefreshing()) {
            this.mViewAnimator.setDisplayedChildId(R.id.view_loading);
        }
        this.f33330t.b(U(i2).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new b(this), new c()));
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().o(this);
    }

    /* access modifiers changed from: protected */
    public final int T() {
        return this.f33304o.getItemCount() > 0 ? R.id.movies_recycler_view : R.id.view_empty;
    }

    public Observable<List<MovieEntity>> U(int i2) {
        if (i2 == 1) {
            return new Observable<List<MovieEntity>>() {
                /* access modifiers changed from: protected */
                public void subscribeActual(Observer<? super List<MovieEntity>> observer) {
                    observer.onNext(FavoredMoviesFragment.this.f33331u.A().j(false));
                    observer.onComplete();
                }
            }.subscribeOn(Schedulers.c());
        }
        if (i2 != 2) {
            return new Observable<List<MovieEntity>>() {
                /* access modifiers changed from: protected */
                public void subscribeActual(Observer<? super List<MovieEntity>> observer) {
                    observer.onNext(FavoredMoviesFragment.this.f33331u.A().n());
                    observer.onComplete();
                }
            }.subscribeOn(Schedulers.c());
        }
        return new Observable<List<MovieEntity>>() {
            /* access modifiers changed from: protected */
            public void subscribeActual(Observer<? super List<MovieEntity>> observer) {
                observer.onNext(FavoredMoviesFragment.this.f33331u.A().j(true));
                observer.onComplete();
            }
        }.subscribeOn(Schedulers.c());
    }

    public void b0() {
        a0(this.f33333w);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f33226c = false;
        this.f33333w = getArguments().getInt("sortField");
        this.f33334x = FreeMoviesApp.p().getInt("pref_sortFavored", 0);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_favorites, menu);
        menu.findItem(R.id.sync_trakt).setVisible(TraktCredentialsHelper.b().isValid());
        menu.findItem(R.id.active_source).setVisible(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.sync_trakt) {
            switch (itemId) {
                case R.id.favorite_menu_sort_az:
                    this.f33304o.q(true);
                    this.f33334x = -1;
                    break;
                case R.id.favorite_menu_sort_lastest:
                    this.f33334x = 0;
                    a0(this.f33333w);
                    break;
                case R.id.favorite_menu_sort_za:
                    this.f33304o.q(false);
                    this.f33334x = 1;
                    a0(this.f33333w);
                    break;
            }
        } else {
            TraktUserApi.M().l0(FreeMoviesApp.m(getActivity()).n(), getActivity(), this.f33331u);
        }
        FreeMoviesApp.p().edit().putInt("pref_sortFavored", this.f33334x).apply();
        return super.onOptionsItemSelected(menuItem);
    }

    public void onRefresh() {
        if (TraktCredentialsHelper.b().isValid()) {
            TraktUserApi.M().l0(FreeMoviesApp.m(getActivity()).n(), getActivity(), this.f33331u);
        }
    }

    public void onStart() {
        super.onStart();
        this.f33330t = new CompositeDisposable();
        setHasOptionsMenu(true);
        a0(this.f33333w);
        this.f33330t.b(RxBus.a().c().subscribe(new Consumer<Object>() {
            public void accept(Object obj) throws Exception {
                if (obj instanceof TraktSyncSuccess) {
                    FavoredMoviesFragment.this.b0();
                } else if (obj instanceof TrackSyncFaild) {
                    FavoredMoviesFragment.this.b0();
                }
            }
        }, new d()));
    }

    public void onStop() {
        this.f33330t.dispose();
        super.onStop();
    }
}

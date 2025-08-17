package com.movie.ui.fragment.history;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.MoviesFragment;
import com.movie.ui.widget.AnimatorStateView;
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

public final class HistoryFragment extends MoviesFragment {

    /* renamed from: t  reason: collision with root package name */
    private CompositeDisposable f33349t = null;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    MvDatabase f33350u;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    TMDBApi f33351v;

    /* renamed from: w  reason: collision with root package name */
    int f33352w = 0;

    /* access modifiers changed from: private */
    public static /* synthetic */ void W(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(List list) throws Exception {
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.f33304o.l(list);
        this.mViewAnimator.setDisplayedChildId(U());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(Throwable th) throws Exception {
        Timber.e(th, "Favored movies loading failed", new Object[0]);
        AnimatorStateView animatorStateView = (AnimatorStateView) this.mViewAnimator.findViewById(R.id.view_empty);
        if (animatorStateView != null) {
            animatorStateView.setMessageText("Your history is empty");
        }
        this.mViewAnimator.setDisplayedChildId(R.id.view_empty);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Z() throws Exception {
    }

    public static HistoryFragment a0(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("sortField", i2);
        HistoryFragment historyFragment = new HistoryFragment();
        historyFragment.setArguments(bundle);
        return historyFragment;
    }

    /* access modifiers changed from: private */
    public void b0() {
        if (!this.mSwipeRefreshLayout.isRefreshing()) {
            this.f33304o.d();
        }
        this.mViewAnimator.setDisplayedChildId(R.id.view_loading);
        this.f33349t.b(V().observeOn(AndroidSchedulers.a()).subscribe(new a(this), new b(this), new c()));
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().p(this);
    }

    /* access modifiers changed from: protected */
    public final int U() {
        return this.f33304o.getItemCount() > 0 ? R.id.movies_recycler_view : R.id.view_empty;
    }

    public Observable<List<MovieEntity>> V() {
        final String string = FreeMoviesApp.p().getString("pref_limit_history_size", "Unlimited");
        return new Observable<List<MovieEntity>>() {
            /* access modifiers changed from: protected */
            public void subscribeActual(Observer<? super List<MovieEntity>> observer) {
                if (string.equals("Unlimited")) {
                    HistoryFragment historyFragment = HistoryFragment.this;
                    int i2 = historyFragment.f33352w;
                    if (i2 == 0) {
                        observer.onNext(historyFragment.f33350u.A().d(Boolean.TRUE));
                    } else if (i2 == 1) {
                        observer.onNext(historyFragment.f33350u.A().d(Boolean.FALSE));
                    } else if (i2 == 2) {
                        observer.onNext(historyFragment.f33350u.A().e());
                    }
                } else {
                    HistoryFragment historyFragment2 = HistoryFragment.this;
                    int i3 = historyFragment2.f33352w;
                    if (i3 == 0) {
                        observer.onNext(historyFragment2.f33350u.A().c(Boolean.TRUE, Integer.valueOf(string).intValue()));
                    } else if (i3 == 1) {
                        observer.onNext(historyFragment2.f33350u.A().c(Boolean.FALSE, Integer.valueOf(string).intValue()));
                    } else if (i3 == 2) {
                        observer.onNext(historyFragment2.f33350u.A().r(Integer.valueOf(string).intValue()));
                    }
                }
                observer.onComplete();
            }
        }.subscribeOn(Schedulers.c());
    }

    public void c0() {
        b0();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f33226c = false;
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.findItem(R.id.active_source).setVisible(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onRefresh() {
        if (TraktCredentialsHelper.b().isValid()) {
            TraktUserApi.M().m0(this.f33306q, getActivity(), this.f33350u);
        }
    }

    public void onResume() {
        super.onResume();
        b0();
    }

    public void onStart() {
        super.onStart();
        this.f33352w = getArguments().getInt("sortField");
        this.f33226c = false;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f33349t = compositeDisposable;
        compositeDisposable.b(RxBus.a().c().subscribe(new Consumer<Object>() {
            public void accept(Object obj) throws Exception {
                if (obj instanceof TraktSyncSuccess) {
                    HistoryFragment.this.b0();
                } else if (obj instanceof TrackSyncFaild) {
                    AnimatorStateView animatorStateView = (AnimatorStateView) HistoryFragment.this.mViewAnimator.findViewById(R.id.view_empty);
                    if (animatorStateView != null) {
                        animatorStateView.setMessageText("Your history is empty");
                    }
                    HistoryFragment.this.mViewAnimator.setDisplayedChildId(R.id.view_empty);
                }
            }
        }, new d()));
    }

    public void onStop() {
        this.f33349t.dispose();
        super.onStop();
    }
}

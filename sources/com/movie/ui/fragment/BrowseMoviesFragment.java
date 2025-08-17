package com.movie.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import com.database.entitys.CategoryEntity;
import com.database.entitys.MovieEntity;
import com.movie.AppComponent;
import com.movie.data.api.GlobalVariable;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktListException;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.listener.EndlessScrollListener;
import com.movie.ui.widget.BetterViewAnimator;
import com.movie.ui.widget.MultiSwipeRefreshLayout;
import com.original.tase.I18N;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.joda.time.DateTime;
import retrofit2.HttpException;
import timber.log.Timber;

public final class BrowseMoviesFragment extends MoviesFragment implements EndlessScrollListener.OnLoadMoreCallback {
    @Inject
    TMDBRepositoryImpl A;
    @Inject
    TraktRepositoryImpl B;
    private CategoryEntity C;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f33227t = -1;

    /* renamed from: u  reason: collision with root package name */
    private String f33228u = "DVD_THISWEEK";

    /* renamed from: v  reason: collision with root package name */
    private EndlessScrollListener f33229v;

    /* renamed from: w  reason: collision with root package name */
    private BehaviorSubject<Observable<List<MovieEntity>>> f33230w = BehaviorSubject.d();

    /* renamed from: x  reason: collision with root package name */
    private int f33231x = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f33232y = false;

    /* renamed from: z  reason: collision with root package name */
    private int f33233z = 0;

    /* renamed from: com.movie.ui.fragment.BrowseMoviesFragment$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33238a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33239b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f33240c;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|(3:39|40|42)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009d */
        static {
            /*
                com.database.entitys.CategoryEntity$SourceType[] r0 = com.database.entitys.CategoryEntity.SourceType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33240c = r0
                r1 = 1
                com.database.entitys.CategoryEntity$SourceType r2 = com.database.entitys.CategoryEntity.SourceType.Genre     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f33240c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.database.entitys.CategoryEntity$SourceType r3 = com.database.entitys.CategoryEntity.SourceType.Generic     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f33240c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.database.entitys.CategoryEntity$SourceType r4 = com.database.entitys.CategoryEntity.SourceType.Search     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f33240c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.database.entitys.CategoryEntity$SourceType r5 = com.database.entitys.CategoryEntity.SourceType.Related     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f33240c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.database.entitys.CategoryEntity$SourceType r6 = com.database.entitys.CategoryEntity.SourceType.FeatureList     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = f33240c     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.database.entitys.CategoryEntity$SourceType r6 = com.database.entitys.CategoryEntity.SourceType.UserList     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.database.entitys.CategoryEntity$Type[] r5 = com.database.entitys.CategoryEntity.Type.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f33239b = r5
                com.database.entitys.CategoryEntity$Type r6 = com.database.entitys.CategoryEntity.Type.Movie     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r5 = f33239b     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.database.entitys.CategoryEntity$Type r6 = com.database.entitys.CategoryEntity.Type.Show     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r5 = f33239b     // Catch:{ NoSuchFieldError -> 0x006e }
                com.database.entitys.CategoryEntity$Type r6 = com.database.entitys.CategoryEntity.Type.MIX     // Catch:{ NoSuchFieldError -> 0x006e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.database.entitys.CategoryEntity$Source[] r5 = com.database.entitys.CategoryEntity.Source.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f33238a = r5
                com.database.entitys.CategoryEntity$Source r6 = com.database.entitys.CategoryEntity.Source.TMDB     // Catch:{ NoSuchFieldError -> 0x007f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r1 = f33238a     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.database.entitys.CategoryEntity$Source r5 = com.database.entitys.CategoryEntity.Source.TRAKT     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r0 = f33238a     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.database.entitys.CategoryEntity$Source r1 = com.database.entitys.CategoryEntity.Source.TVDB     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f33238a     // Catch:{ NoSuchFieldError -> 0x009d }
                com.database.entitys.CategoryEntity$Source r1 = com.database.entitys.CategoryEntity.Source.IMDB     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                int[] r0 = f33238a     // Catch:{ NoSuchFieldError -> 0x00a7 }
                com.database.entitys.CategoryEntity$Source r1 = com.database.entitys.CategoryEntity.Source.LOCAL     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.BrowseMoviesFragment.AnonymousClass8.<clinit>():void");
        }
    }

    private boolean T(long j2) {
        for (Integer intValue : GlobalVariable.c().b().getFringing_movie()) {
            if (((long) intValue.intValue()) == j2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(List list) throws Exception {
        this.mSwipeRefreshLayout.setRefreshing(false);
        int i2 = this.f33231x + 1;
        this.f33231x = i2;
        if (this.f33233z > i2) {
            this.f33233z = i2;
        }
        Timber.b(String.format("Page %d is loaded, %d new items", new Object[]{Integer.valueOf(i2), Integer.valueOf(list.size())}), new Object[0]);
        if (this.f33231x == 1) {
            this.f33304o.d();
        }
        this.f33304o.m(true ^ list.isEmpty());
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!T(((MovieEntity) list.get(i3)).getTmdbID())) {
                this.f33304o.c((MovieEntity) list.get(i3));
            }
        }
        this.mViewAnimator.setDisplayedChildId(R.id.movies_recycler_view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(Throwable th) throws Exception {
        Timber.e(th, "Movies loading failed.", new Object[0]);
        this.mSwipeRefreshLayout.setRefreshing(false);
        if (this.mViewAnimator.getDisplayedChildId() == R.id.movies_recycler_view) {
            this.f33304o.m(false);
        } else {
            this.mViewAnimator.setDisplayedChildId(R.id.view_error);
        }
        if (th instanceof HttpException) {
            this.mViewError.setMessageText(th.getMessage());
        } else if (th instanceof UnknownHostException) {
            this.mViewError.setMessageText(th.getMessage());
        } else if (th instanceof TraktListException) {
            this.mViewError.setMessageText(th.getMessage());
        } else {
            this.mViewError.setMessageText("Something went wrong.");
        }
    }

    public static BrowseMoviesFragment e0(CategoryEntity categoryEntity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("category", categoryEntity);
        BrowseMoviesFragment browseMoviesFragment = new BrowseMoviesFragment();
        browseMoviesFragment.setArguments(bundle);
        browseMoviesFragment.f33227t = -1;
        return browseMoviesFragment;
    }

    private void f0(int i2) {
        Timber.b(String.format("Page %d is loading.", new Object[]{Integer.valueOf(i2)}), new Object[0]);
        CategoryEntity categoryEntity = this.C;
        if (categoryEntity != null) {
            int i3 = AnonymousClass8.f33238a[categoryEntity.getSource().ordinal()];
            if (i3 == 1) {
                this.f33230w.onNext(W(this.C, i2));
            } else if (i3 == 2) {
                this.f33230w.onNext(X(this.C, i2));
            }
        }
    }

    private void g0(GridLayoutManager gridLayoutManager, int i2) {
        EndlessScrollListener endlessScrollListener = this.f33229v;
        if (endlessScrollListener != null) {
            this.mRecyclerView.removeOnScrollListener(endlessScrollListener);
        }
        EndlessScrollListener f2 = EndlessScrollListener.a(gridLayoutManager, 10, i2).f(this);
        this.f33229v = f2;
        this.mRecyclerView.addOnScrollListener(f2);
    }

    private void j0() {
        Timber.b("Subscribing to items", new Object[0]);
        this.f33306q.b(Observable.concat(this.f33230w).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new b(this)));
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().x(this);
    }

    /* access modifiers changed from: protected */
    public void K() {
        super.K();
        this.f33231x = 0;
        g0(this.f33305p, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean S(CategoryEntity categoryEntity) {
        if (categoryEntity.getSource() == CategoryEntity.Source.TMDB && categoryEntity.getSourceType() == CategoryEntity.SourceType.Genre) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> W(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33239b[categoryEntity.getType().ordinal()];
        if (i3 == 1) {
            return a0(categoryEntity, i2);
        }
        if (i3 == 2) {
            return c0(categoryEntity, i2);
        }
        if (i3 != 3) {
            return Observable.empty();
        }
        return Y(categoryEntity, i2);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> X(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33239b[categoryEntity.getType().ordinal()];
        if (i3 == 1) {
            return b0(categoryEntity, i2);
        }
        if (i3 == 2) {
            return d0(categoryEntity, i2);
        }
        if (i3 != 3) {
            return Observable.empty();
        }
        return Z(categoryEntity, i2);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> Y(CategoryEntity categoryEntity, int i2) {
        if (AnonymousClass8.f33240c[categoryEntity.getSourceType().ordinal()] != 5) {
            return Observable.empty();
        }
        return this.A.E(i2, categoryEntity.getId().intValue(), this.f33227t);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> Z(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33240c[categoryEntity.getSourceType().ordinal()];
        if (i3 == 5) {
            return this.B.l(categoryEntity, i2);
        }
        if (i3 != 6) {
            return Observable.empty();
        }
        return this.B.o(categoryEntity, i2);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> a0(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33240c[categoryEntity.getSourceType().ordinal()];
        if (i3 == 1) {
            return this.A.B(categoryEntity.getId().intValue(), i2, this.f33227t);
        }
        if (i3 == 2) {
            return this.A.f0(categoryEntity, i2);
        }
        if (i3 == 3) {
            return this.A.j0(categoryEntity.getName(), i2);
        }
        if (i3 != 4) {
            return Observable.empty();
        }
        return this.A.H((long) categoryEntity.getId().intValue(), i2);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> b0(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33240c[categoryEntity.getSourceType().ordinal()];
        if (i3 == 2) {
            return this.B.m(categoryEntity, i2);
        }
        if (i3 != 3) {
            return Observable.empty();
        }
        return this.B.p(categoryEntity.getName(), i2);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> c0(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33240c[categoryEntity.getSourceType().ordinal()];
        if (i3 == 1) {
            return this.A.D(categoryEntity.getId().intValue(), i2, this.f33227t);
        }
        if (i3 == 2) {
            return this.A.f0(categoryEntity, i2);
        }
        if (i3 == 3) {
            return this.A.j0(categoryEntity.getName(), i2);
        }
        if (i3 != 4) {
            return Observable.empty();
        }
        return this.A.J((long) categoryEntity.getId().intValue(), i2);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<MovieEntity>> d0(CategoryEntity categoryEntity, int i2) {
        int i3 = AnonymousClass8.f33240c[categoryEntity.getSourceType().ordinal()];
        if (i3 == 2) {
            return this.B.m(categoryEntity, i2);
        }
        if (i3 != 3) {
            return Observable.empty();
        }
        return this.B.p(categoryEntity.getName(), i2);
    }

    public final void h0() {
        MultiSwipeRefreshLayout multiSwipeRefreshLayout = this.mSwipeRefreshLayout;
        if (multiSwipeRefreshLayout != null && !multiSwipeRefreshLayout.isRefreshing()) {
            this.mViewAnimator.setDisplayedChildId(R.id.view_loading);
        }
        this.f33307r = -1;
        GridLayoutManager gridLayoutManager = this.f33305p;
        this.f33231x = 0;
        g0(gridLayoutManager, 0);
        this.f33231x = 0;
        f0(1);
    }

    public void i0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("No filter");
        for (int year = DateTime.now().getYear(); year >= 1850; year--) {
            arrayList.add(String.valueOf(year));
        }
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), 17367046, arrayList);
        new AlertDialog.Builder(getActivity()).setTitle(I18N.a(R.string.year_filter)).a(arrayAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                int i3;
                try {
                    i3 = Integer.parseInt((String) arrayAdapter.getItem(i2));
                } catch (Exception unused) {
                    i3 = -1;
                }
                int unused2 = BrowseMoviesFragment.this.f33227t = i3;
                BrowseMoviesFragment.this.h0();
            }
        }).l(I18N.a(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).i(I18N.a(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).q();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_browse_movie, menu);
        menu.findItem(R.id.browse_movie_fillter).setVisible(S(this.C));
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.C.getSourceType() == CategoryEntity.SourceType.Search) {
            Toolbar toolbar = this.f33308s;
            toolbar.setTitle((CharSequence) "Results of : " + this.C.getName());
            return;
        }
        this.C = (CategoryEntity) getArguments().getParcelable("category");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.browse_movie_fillter) {
            i0();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onRefresh() {
        h0();
        if (this.C.getSourceType() == CategoryEntity.SourceType.Search) {
            this.mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("state_current_page", this.f33231x);
        bundle.putBoolean("state_is_loading", this.f33232y);
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i2;
        super.onViewCreated(view, bundle);
        this.f33308s = (Toolbar) getActivity().findViewById(R.id.toolbar);
        this.C = (CategoryEntity) getArguments().getParcelable("category");
        this.f33304o.m(true);
        BetterViewAnimator betterViewAnimator = this.mViewAnimator;
        if (this.f33231x == 0) {
            i2 = R.id.view_loading;
        } else {
            i2 = R.id.movies_recycler_view;
        }
        betterViewAnimator.setDisplayedChildId(i2);
        j0();
        if (bundle != null) {
            this.f33231x = bundle.getInt("state_current_page", 0);
            this.f33232y = bundle.getBoolean("state_is_loading", true);
            Timber.b(String.format("Restoring state: pages 1-%d, was loading - %s", new Object[]{Integer.valueOf(this.f33231x), Boolean.valueOf(this.f33232y)}), new Object[0]);
            return;
        }
        h0();
    }

    public void z(int i2, int i3) {
        if (this.f33304o.h()) {
            f0(i2);
        }
    }
}

package com.movie.ui.activity.shows.seasons;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.activity.sources.seasonPack.SeasonPackActivity;
import com.movie.ui.customdialog.AddMagnetDialog;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.widget.AnimatorStateView;
import com.original.tase.api.TraktUserApi;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.thetvdb.entities.Episode;
import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import retrofit2.Response;

public class SeasonFragment extends BaseFragment {

    /* renamed from: d  reason: collision with root package name */
    private int f32776d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MovieEntity f32777e;

    /* renamed from: f  reason: collision with root package name */
    private OnListFragmentInteractionListener f32778f;

    /* renamed from: g  reason: collision with root package name */
    GridLayoutManager f32779g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    TMDBRepositoryImpl f32780h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    TheTvdb f32781i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    MvDatabase f32782j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    TMDBApi f32783k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    MoviesApi f32784l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f32785m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public CompositeDisposable f32786n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public List<SeasonEntity> f32787o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public List<TvWatchedEpisode> f32788p;
    @BindView(2131362351)
    ProgressBar progressBar;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<EpisodeItem> f32789q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f32790r = false;
    @BindView(2131362334)
    RecyclerView recyclerView;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public List<SeasonEntity> f32791s = new ArrayList();
    @BindView(2131362909)
    AnimatorStateView viewEmty;

    public interface OnListFragmentInteractionListener {
        void c(SeasonEntity seasonEntity, ArrayList<EpisodeItem> arrayList);

        void h(String str);

        void p(String str);
    }

    private SeasonEntity Y(int i2) {
        for (SeasonEntity next : this.f32791s) {
            if (next.j() == i2) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(String str) throws Exception {
        if (this.recyclerView.getAdapter() == null) {
            this.recyclerView.setAdapter(new SeasonRecyclerViewAdapter(this.f32787o, this.f32788p, this.f32778f));
        } else {
            SeasonRecyclerViewAdapter seasonRecyclerViewAdapter = (SeasonRecyclerViewAdapter) this.recyclerView.getAdapter();
            seasonRecyclerViewAdapter.j(this.f32789q);
            seasonRecyclerViewAdapter.k(this.f32787o);
            seasonRecyclerViewAdapter.l(this.f32788p);
        }
        this.recyclerView.getAdapter().notifyDataSetChanged();
        this.f32778f.p(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(Throwable th) throws Exception {
        this.f32778f.p(th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(String str) throws Exception {
        this.recyclerView.setAdapter(new SeasonRecyclerViewAdapter(this.f32787o, this.f32788p, this.f32789q, this.f32778f));
        this.recyclerView.getAdapter().notifyDataSetChanged();
        this.f32778f.h(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(Throwable th) throws Exception {
        this.f32778f.h(th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(EpisodesResponse episodesResponse) throws Exception {
        new ArrayList();
        if (this.f32789q == null) {
            this.f32789q = new ArrayList<>();
        }
        if (this.f32787o == null) {
            this.f32787o = new ArrayList();
        }
        for (Episode next : episodesResponse.data) {
            TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
            tvWatchedEpisode.m(next.airedEpisodeNumber.intValue());
            tvWatchedEpisode.q(next.airedSeason.intValue());
            boolean z2 = false;
            boolean z3 = false;
            for (TvWatchedEpisode next2 : this.f32788p) {
                if (next2.f() == next.airedSeason.intValue() && next2.c() == next.airedEpisodeNumber.intValue()) {
                    z3 = true;
                }
            }
            Integer num = next.airedEpisodeNumber;
            Boolean valueOf = Boolean.valueOf(z3);
            String str = next.episodeName;
            Integer num2 = next.airedEpisodeNumber;
            this.f32789q.add(new EpisodeItem(num, valueOf, str, num2, "http://thetvdb.com/banners/" + next.filename, next.overview, true, "TVDB", next.airedSeason, next.firstAired));
            for (SeasonEntity next3 : this.f32787o) {
                if (next3.e() == next.airedSeason.intValue()) {
                    next3.l(next3.d() + 1);
                    z2 = true;
                }
            }
            if (!z2) {
                SeasonEntity seasonEntity = new SeasonEntity();
                seasonEntity.m(next.airedSeason.intValue());
                seasonEntity.r(next.airedSeason.intValue());
                seasonEntity.o("Season " + next.airedSeason);
                seasonEntity.p("unknow");
                seasonEntity.l(1);
                SeasonEntity Y = Y(seasonEntity.j());
                if (Y != null) {
                    seasonEntity.q(Y.i());
                    seasonEntity.p(Y.h());
                    seasonEntity.k(Y.c());
                    seasonEntity.n(Y.f());
                }
                this.f32787o.add(seasonEntity);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(Observer observer, Throwable th) throws Exception {
        observer.onNext(this.f32787o);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(Observer observer) throws Exception {
        observer.onNext(this.f32787o);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(MovieEntity movieEntity, Observer observer) {
        this.f32786n.b(n0((int) movieEntity.getTvdbID(), 1).observeOn(Schedulers.c()).concatMap(new j()).subscribe(new k(this), new l(this, observer), new b(this, observer)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(List list) throws Exception {
        this.f32787o = list;
        this.progressBar.setVisibility(8);
        Iterator it2 = list.iterator();
        Boolean valueOf = Boolean.valueOf(FreeMoviesApp.p().getBoolean("pref_show_special_season", false));
        while (it2.hasNext()) {
            if (((SeasonEntity) it2.next()).j() < 1 && !valueOf.booleanValue()) {
                it2.remove();
            }
        }
        if (this.f32790r) {
            Collections.sort(this.f32787o);
        } else {
            Collections.reverse(this.f32787o);
        }
        this.recyclerView.setAdapter(new SeasonRecyclerViewAdapter(this.f32787o, this.f32788p, this.f32789q, this.f32778f));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(Throwable th) throws Exception {
        this.viewEmty.setVisibility(0);
        this.viewEmty.setMessageText(th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource k0(int i2, int i3, EpisodesResponse episodesResponse) throws Exception {
        if (episodesResponse.links.last.intValue() > i2) {
            return Observable.just(episodesResponse).concatWith(n0(i3, episodesResponse.links.next.intValue()));
        }
        return Observable.just(episodesResponse);
    }

    public static SeasonFragment l0(int i2, MovieEntity movieEntity) {
        SeasonFragment seasonFragment = new SeasonFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_movie", movieEntity);
        seasonFragment.f32776d = i2;
        seasonFragment.setArguments(bundle);
        return seasonFragment;
    }

    private void m0(final MovieEntity movieEntity, final boolean z2) {
        this.progressBar.setVisibility(0);
        this.f32786n.b(Observable.create(new ObservableOnSubscribe<List<SeasonEntity>>() {
            /* access modifiers changed from: private */
            public /* synthetic */ void c(boolean z2, ObservableEmitter observableEmitter, List list) throws Exception {
                if (list.size() > 0) {
                    SeasonFragment.this.f32791s.clear();
                    SeasonFragment.this.f32791s.addAll(list);
                    if (!z2) {
                        observableEmitter.onNext(list);
                    }
                }
                observableEmitter.onComplete();
            }

            public void subscribe(ObservableEmitter<List<SeasonEntity>> observableEmitter) throws Exception {
                SeasonFragment seasonFragment = SeasonFragment.this;
                List unused = seasonFragment.f32788p = seasonFragment.f32782j.E().j(movieEntity.getTmdbID(), movieEntity.getImdbIDStr(), movieEntity.getTraktID(), movieEntity.getTvdbID());
                SeasonFragment.this.f32786n.b(SeasonFragment.this.f32780h.C(movieEntity.getTmdbID()).subscribeOn(Schedulers.c()).subscribe(new m(this, z2, observableEmitter), new n(observableEmitter)));
            }
        }).subscribeOn(Schedulers.c()).switchIfEmpty(new g(this, movieEntity)).observeOn(AndroidSchedulers.a()).subscribe(new h(this), new i(this)));
    }

    private Observable<EpisodesResponse> n0(int i2, final int i3) {
        return Observable.create(new ObservableOnSubscribe<EpisodesResponse>() {
            public void subscribe(ObservableEmitter<EpisodesResponse> observableEmitter) throws Exception {
                Response<EpisodesResponse> execute = SeasonFragment.this.f32781i.series().episodes((int) SeasonFragment.this.f32777e.getTvdbID(), Integer.valueOf(i3), "en").execute();
                if (execute.isSuccessful()) {
                    observableEmitter.onNext(execute.body());
                }
                observableEmitter.onComplete();
            }
        }).concatMap(new c(this, i3, i2));
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().t(this);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            this.f32778f = (OnListFragmentInteractionListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 2) {
            this.f32779g.s(this.f32776d * 2);
        } else if (i2 == 1) {
            this.f32779g.s(this.f32776d);
        }
    }

    public boolean onContextItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 121:
                this.f32786n.b(Observable.create(new ObservableOnSubscribe<String>() {
                    public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 1; i2 <= ((SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId())).d(); i2++) {
                                TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
                                tvWatchedEpisode.m(i2);
                                tvWatchedEpisode.q(((SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId())).j());
                                tvWatchedEpisode.s(SeasonFragment.this.f32777e.getTmdbID());
                                tvWatchedEpisode.o(SeasonFragment.this.f32777e.getImdbIDStr());
                                tvWatchedEpisode.u(SeasonFragment.this.f32777e.getTvdbID());
                                tvWatchedEpisode.t(SeasonFragment.this.f32777e.getTraktID());
                                DateTimeHelper.f(DateTimeHelper.i(((SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId())).c()));
                                arrayList.add(tvWatchedEpisode);
                            }
                            SeasonFragment.this.f32777e.setWatched_at(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
                            SeasonFragment.this.f32782j.A().b(SeasonFragment.this.f32777e);
                            SeasonFragment.this.f32782j.E().l((TvWatchedEpisode[]) arrayList.toArray(new TvWatchedEpisode[arrayList.size()]));
                            SeasonFragment seasonFragment = SeasonFragment.this;
                            List unused = seasonFragment.f32788p = seasonFragment.f32782j.E().j(SeasonFragment.this.f32777e.getTmdbID(), SeasonFragment.this.f32777e.getImdbIDStr(), SeasonFragment.this.f32777e.getTraktID(), SeasonFragment.this.f32777e.getTvdbID());
                            observableEmitter.onNext("Add season to history success");
                        } catch (Exception unused2) {
                            observableEmitter.onNext("Add season to history fail");
                        }
                        try {
                            if (TraktCredentialsHelper.b().isValid()) {
                                TraktUserApi.M().t0(SeasonFragment.this.f32777e, (SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId()), true);
                            }
                            observableEmitter.onNext("Add season to trakt success");
                        } catch (Exception unused3) {
                            observableEmitter.onNext("Add season to trakt fail");
                        }
                        observableEmitter.onComplete();
                    }
                }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new d(this)));
                return true;
            case 122:
                this.f32786n.b(Observable.create(new ObservableOnSubscribe<String>() {
                    public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 1; i2 <= ((SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId())).d(); i2++) {
                                TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
                                tvWatchedEpisode.m(i2);
                                tvWatchedEpisode.q(((SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId())).j());
                                tvWatchedEpisode.s(SeasonFragment.this.f32777e.getTmdbID());
                                tvWatchedEpisode.o(SeasonFragment.this.f32777e.getImdbIDStr());
                                tvWatchedEpisode.u(SeasonFragment.this.f32777e.getTvdbID());
                                tvWatchedEpisode.t(SeasonFragment.this.f32777e.getTraktID());
                                arrayList.add(tvWatchedEpisode);
                            }
                            SeasonFragment.this.f32782j.E().b((TvWatchedEpisode[]) arrayList.toArray(new TvWatchedEpisode[arrayList.size()]));
                            List<TvWatchedEpisode> j2 = SeasonFragment.this.f32782j.E().j(SeasonFragment.this.f32777e.getTmdbID(), SeasonFragment.this.f32777e.getImdbIDStr(), SeasonFragment.this.f32777e.getTraktID(), SeasonFragment.this.f32777e.getTvdbID());
                            if (j2 == null || j2.size() == 0) {
                                SeasonFragment.this.f32777e.setWatched_at((OffsetDateTime) null);
                                SeasonFragment.this.f32782j.A().g(SeasonFragment.this.f32777e);
                            }
                            SeasonFragment seasonFragment = SeasonFragment.this;
                            List unused = seasonFragment.f32788p = seasonFragment.f32782j.E().j(SeasonFragment.this.f32777e.getTmdbID(), SeasonFragment.this.f32777e.getImdbIDStr(), SeasonFragment.this.f32777e.getTraktID(), SeasonFragment.this.f32777e.getTvdbID());
                            observableEmitter.onNext("Remove season from history success");
                        } catch (Exception unused2) {
                            observableEmitter.onNext("Remove season from history fail");
                        }
                        try {
                            if (TraktCredentialsHelper.b().isValid()) {
                                TraktUserApi.M().t0(SeasonFragment.this.f32777e, (SeasonEntity) SeasonFragment.this.f32787o.get(menuItem.getGroupId()), false);
                            }
                            observableEmitter.onNext("Remove season from trakt success");
                        } catch (Exception unused3) {
                            observableEmitter.onNext("Remove season from trakt fail");
                        }
                        observableEmitter.onComplete();
                    }
                }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(this), new f(this)));
                return true;
            case 123:
                break;
            case 124:
                Utils.i0(getActivity(), "comming soon!!!");
                Intent intent = new Intent(getActivity(), SeasonPackActivity.class);
                intent.putExtra("MovieEntity", this.f32777e);
                intent.putExtra("seasonEntity", this.f32787o.get(menuItem.getGroupId()));
                startActivity(intent);
                break;
            default:
                return super.onContextItemSelected(menuItem);
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f32790r = FreeMoviesApp.p().getBoolean("pre_season_inc_sort", false);
        this.f32785m = FreeMoviesApp.p().getBoolean("pre_force_tv_db", false);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z2;
        menuInflater.inflate(R.menu.menu_season_fragment, menu);
        MenuItem findItem = menu.findItem(R.id.forceTVDB);
        if (this.f32785m) {
            findItem.setIcon(getResources().getDrawable(R.drawable.tvdb_focus));
        } else {
            findItem.setIcon(getResources().getDrawable(R.drawable.tvdb));
        }
        MenuItem findItem2 = menu.findItem(R.id.magnet);
        if (RealDebridCredentialsHelper.d().isValid() || AllDebridCredentialsHelper.b().isValid() || PremiumizeCredentialsHelper.b().isValid()) {
            z2 = true;
        } else {
            z2 = false;
        }
        findItem2.setVisible(z2);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_season_list, viewGroup, false);
    }

    public void onDestroy() {
        this.f32786n.dispose();
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        this.f32778f = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.resorting) {
            boolean z2 = !this.f32790r;
            this.f32790r = z2;
            List<SeasonEntity> list = this.f32787o;
            if (list != null) {
                if (z2) {
                    Collections.sort(list);
                } else {
                    Collections.reverse(list);
                }
                this.recyclerView.getAdapter().notifyDataSetChanged();
            }
            FreeMoviesApp.p().edit().putBoolean("pre_season_inc_sort", this.f32790r).apply();
            return true;
        } else if (menuItem.getItemId() == R.id.forceTVDB) {
            boolean z3 = !this.f32785m;
            this.f32785m = z3;
            if (z3) {
                menuItem.setTitle("Switch to TMDB");
                menuItem.setIcon(getResources().getDrawable(R.drawable.tvdb_focus));
            } else {
                menuItem.setTitle("Switch to TVDB");
                menuItem.setIcon(getResources().getDrawable(R.drawable.tvdb));
            }
            List<SeasonEntity> list2 = this.f32787o;
            if (list2 != null) {
                list2.clear();
            }
            ArrayList<EpisodeItem> arrayList = this.f32789q;
            if (arrayList != null) {
                arrayList.clear();
            }
            List<TvWatchedEpisode> list3 = this.f32788p;
            if (list3 != null) {
                list3.clear();
            }
            m0(this.f32777e, this.f32785m);
            FreeMoviesApp.p().edit().putBoolean("pre_force_tv_db", this.f32785m).apply();
            return true;
        } else {
            if (menuItem.getItemId() == R.id.magnet) {
                AddMagnetDialog O0 = AddMagnetDialog.O0(this.f32777e, (MovieInfo) null);
                FragmentTransaction n2 = getChildFragmentManager().n();
                Fragment i02 = getChildFragmentManager().i0("fragment_add_magnet");
                if (i02 != null) {
                    n2.o(i02);
                }
                n2.g((String) null);
                O0.show(n2, "fragment_add_magnet");
            }
            return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f32779g = new GridLayoutManager(view.getContext(), this.f32776d);
        int X = Utils.X(getActivity());
        if (X == 2) {
            this.f32779g.s(this.f32776d * 2);
        } else if (X == 1) {
            this.f32779g.s(this.f32776d);
        }
        this.recyclerView.setLayoutManager(this.f32779g);
        this.f32786n = new CompositeDisposable();
        MovieEntity movieEntity = (MovieEntity) getArguments().getParcelable("arg_movie");
        this.f32777e = movieEntity;
        m0(movieEntity, this.f32785m);
    }
}

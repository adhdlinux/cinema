package com.movie.ui.activity.shows.episodes.pageviewDialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.movie.FreeMoviesApp;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.tmvdb.ExternalID;
import com.movie.data.model.tmvdb.SeasonTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.activity.shows.episodes.pageviewDialog.EpisodeDetailsFragment;
import com.movie.ui.activity.sources.SourceActivity;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.widget.SlidingTabLayout;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.thetvdb.entities.Episode;
import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Response;

public class PageViewDialog extends DialogFragment implements EpisodeDetailsFragment.EpisodeListener {

    /* renamed from: b  reason: collision with root package name */
    OnListFragmentInteractionListener f32742b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    TMDBRepositoryImpl f32743c;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MvDatabase f32744d;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    TMDBApi f32745e;

    /* renamed from: f  reason: collision with root package name */
    TheTvdb f32746f = new TheTvdb("6UMSCJSYNU96S28F");

    /* renamed from: g  reason: collision with root package name */
    ArrayList<EpisodeItem> f32747g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private Unbinder f32748h;

    /* renamed from: i  reason: collision with root package name */
    private CompositeDisposable f32749i;
    @BindView(2131361799)
    ImageButton imgBtnrevertIndex;

    /* renamed from: j  reason: collision with root package name */
    private BehaviorSubject<Observable<List<EpisodeItem>>> f32750j = BehaviorSubject.d();

    /* renamed from: k  reason: collision with root package name */
    private SeasonEntity f32751k;

    /* renamed from: l  reason: collision with root package name */
    private MovieEntity f32752l;
    @BindView(2131362348)
    ProgressBar loading;

    /* renamed from: m  reason: collision with root package name */
    private EpisodePagerAdapter f32753m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f32754n = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f32755o = true;
    @BindView(2131362752)
    SlidingTabLayout tabLayout;
    @BindView(2131362919)
    ViewPager viewPager;

    public interface OnListFragmentInteractionListener {
        void a(View view, int i2, int i3);

        void b(View view, int i2, int i3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(List list) throws Exception {
        Q(list, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List M(List list) throws Exception {
        try {
            ArrayList<EpisodeItem> arrayList = new ArrayList<>();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(new EpisodeItem((SeasonTMDB.EpisodesBean) it2.next(), false, this.f32751k.d(), "TMDB"));
            }
            List<TvWatchedEpisode> h2 = this.f32744d.E().h(this.f32752l.getTmdbID(), this.f32752l.getImdbIDStr(), this.f32752l.getTraktID(), this.f32752l.getTvdbID(), this.f32751k.j());
            for (EpisodeItem episodeItem : arrayList) {
                for (TvWatchedEpisode next : h2) {
                    if (episodeItem.f32694b.intValue() == next.c()) {
                        episodeItem.f32695c = Boolean.TRUE;
                        episodeItem.f32697e = next.e();
                    }
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List N(ExternalID externalID) throws Exception {
        try {
            ArrayList<EpisodeItem> arrayList = new ArrayList<>();
            Response<EpisodesResponse> execute = this.f32746f.series().episodesQuery(externalID.getTvdb_id(), (Integer) null, Integer.valueOf(this.f32751k.j()), (Integer) null, (Integer) null, (Double) null, (String) null, (String) null, 1, "en").execute();
            if (execute.isSuccessful()) {
                for (Episode episodeItem : execute.body().data) {
                    arrayList.add(new EpisodeItem(episodeItem, false, this.f32751k.d(), "TVDB"));
                }
                List<TvWatchedEpisode> h2 = this.f32744d.E().h(this.f32752l.getTmdbID(), this.f32752l.getImdbIDStr(), this.f32752l.getTraktID(), this.f32752l.getTvdbID(), this.f32751k.j());
                for (EpisodeItem episodeItem2 : arrayList) {
                    for (TvWatchedEpisode next : h2) {
                        if (episodeItem2.f32694b.intValue() == next.c()) {
                            episodeItem2.f32695c = Boolean.TRUE;
                            episodeItem2.f32697e = next.e();
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static PageViewDialog O(String str, MovieEntity movieEntity, SeasonEntity seasonEntity, ArrayList<EpisodeItem> arrayList) {
        PageViewDialog pageViewDialog = new PageViewDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putParcelable("movie", movieEntity);
        bundle.putParcelable("season", seasonEntity);
        bundle.putParcelableArrayList("episodeList", arrayList);
        pageViewDialog.setArguments(bundle);
        return pageViewDialog;
    }

    private void Q(List<EpisodeItem> list, boolean z2) {
        boolean z3;
        ArrayList<EpisodeItem> arrayList = list;
        if (FreeMoviesApp.p().getBoolean("pref_show_aried_eps_only2", true)) {
            arrayList = J(list);
        }
        this.imgBtnrevertIndex.setVisibility(0);
        if (this.f32755o) {
            Collections.sort(arrayList);
        } else {
            Collections.reverse(arrayList);
        }
        if (this.f32747g.size() == 0) {
            this.f32747g.addAll(arrayList);
            EpisodePagerAdapter episodePagerAdapter = new EpisodePagerAdapter(getActivity(), getChildFragmentManager(), this.f32747g, this.f32751k.j());
            this.f32753m = episodePagerAdapter;
            episodePagerAdapter.b(this);
            this.viewPager.setAdapter(this.f32753m);
            this.tabLayout.setViewPager(this.viewPager);
            this.viewPager.setCurrentItem(0, false);
        } else {
            for (EpisodeItem next : arrayList) {
                Iterator<EpisodeItem> it2 = this.f32747g.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (next.f32694b == it2.next().f32694b) {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (!z3) {
                    this.f32747g.add(next);
                }
            }
            this.f32753m.notifyDataSetChanged();
        }
        int size = this.f32747g.size() - 1;
        while (true) {
            if (size < 0) {
                size = 0;
                break;
            } else if (!this.f32747g.get(size).f32695c.booleanValue()) {
                size--;
            } else if (!z2 && this.f32747g.size() > 0) {
                this.viewPager.setCurrentItem(size + 1);
            }
        }
        this.loading.setVisibility(8);
        this.tabLayout.setVisibility(0);
        this.viewPager.setVisibility(0);
        if (size == 0) {
            this.imgBtnrevertIndex.setFocusable(true);
            this.imgBtnrevertIndex.setFocusableInTouchMode(true);
            this.imgBtnrevertIndex.requestFocus();
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<EpisodeItem> J(List<EpisodeItem> list) {
        ArrayList<EpisodeItem> arrayList = new ArrayList<>();
        for (EpisodeItem next : list) {
            if (next.f32702j) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361799})
    public void OnImgBtnrevertIndexClick() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f32747g);
        this.f32747g.clear();
        this.f32755o = !this.f32755o;
        Q(arrayList, true);
    }

    public void P(OnListFragmentInteractionListener onListFragmentInteractionListener) {
        this.f32742b = onListFragmentInteractionListener;
    }

    public void l(EpisodeItem episodeItem, boolean z2) {
        OnListFragmentInteractionListener onListFragmentInteractionListener = this.f32742b;
        if (onListFragmentInteractionListener == null) {
            return;
        }
        if (z2) {
            onListFragmentInteractionListener.a(getView(), this.f32751k.j(), episodeItem.f32694b.intValue());
        } else {
            onListFragmentInteractionListener.b(getView(), this.f32751k.j(), episodeItem.f32694b.intValue());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getDialog().getWindow().getAttributes().windowAnimations = 2131951627;
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (Utils.X(getActivity()) == 1) {
            getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.7d));
        } else {
            int i2 = getResources().getDisplayMetrics().heightPixels;
            getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.7d), i2);
        }
        setHasOptionsMenu(true);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m((Activity) context).l()).b().h(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_pageview_episode, viewGroup, false);
        this.f32748h = ButterKnife.bind((Object) this, inflate);
        this.f32749i = new CompositeDisposable();
        return inflate;
    }

    public void onDestroyView() {
        this.f32748h.unbind();
        this.f32749i.dispose();
        super.onDestroyView();
    }

    public void onPause() {
        this.f32749i.dispose();
        super.onPause();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getArguments().getString("title", "Enter Name");
        this.f32752l = (MovieEntity) getArguments().getParcelable("movie");
        this.f32751k = (SeasonEntity) getArguments().getParcelable("season");
        ArrayList parcelableArrayList = getArguments().getParcelableArrayList("episodeList");
        this.tabLayout.i(R.layout.tabstrip_item_transparent, R.id.textViewTabStripItem);
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            this.f32749i.b(Observable.concat(this.f32750j).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new b()));
            this.f32750j.onNext(this.f32743c.I(this.f32752l.getTmdbID(), this.f32751k.j()).subscribeOn(Schedulers.c()).map(new c(this)));
            this.f32750j.onNext(this.f32745e.getTVExternalID(this.f32752l.getTmdbID()).subscribeOn(Schedulers.c()).map(new d(this)));
            return;
        }
        Q(parcelableArrayList, false);
    }

    public void r(EpisodeItem episodeItem) {
        String str;
        String str2;
        episodeItem.f32695c = Boolean.TRUE;
        this.f32752l.setPosition(episodeItem.f32697e);
        Intent intent = new Intent(getActivity(), SourceActivity.class);
        intent.putExtra("Movie", this.f32752l);
        if (this.f32752l.getRealeaseDate() == null || this.f32752l.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = this.f32752l.getRealeaseDate().split("-")[0];
        }
        String name = this.f32752l.getName();
        String str3 = "" + this.f32751k.j();
        String str4 = "" + episodeItem.f32694b;
        if (this.f32751k.c() == null) {
            str2 = "1970";
        } else {
            str2 = this.f32751k.c().split("-")[0];
        }
        MovieInfo movieInfo = new MovieInfo(name, str, str3, str4, str2, this.f32752l.getGenres());
        movieInfo.imdbIDStr = this.f32752l.getImdbIDStr();
        movieInfo.tmdbID = this.f32752l.getTmdbID();
        movieInfo.epsCount = episodeItem.f32698f.intValue();
        intent.putExtra("MovieInfo", movieInfo);
        startActivity(intent);
    }
}

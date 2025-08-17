package com.movie.ui.activity.shows.episodes.bottomSheet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.movie.FreeMoviesApp;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.tmvdb.ExternalID;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.thetvdb.entities.Episode;
import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Response;

public class EpisodeBottomSheetFragment extends BottomSheetDialogFragment {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    TMDBRepositoryImpl f32705b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    MvDatabase f32706c;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    TMDBApi f32707d;

    /* renamed from: e  reason: collision with root package name */
    TheTvdb f32708e = new TheTvdb("6UMSCJSYNU96S28F");

    /* renamed from: f  reason: collision with root package name */
    LinearLayoutManager f32709f = null;

    /* renamed from: g  reason: collision with root package name */
    private Unbinder f32710g;

    /* renamed from: h  reason: collision with root package name */
    private OnListFragmentInteractionListener f32711h;

    /* renamed from: i  reason: collision with root package name */
    private CompositeDisposable f32712i;

    /* renamed from: j  reason: collision with root package name */
    private SeasonEntity f32713j;

    /* renamed from: k  reason: collision with root package name */
    private MovieEntity f32714k;

    /* renamed from: l  reason: collision with root package name */
    private EpisodesRecyclerViewAdapter f32715l;
    @BindView(2131362348)
    ProgressBar loading;
    @BindView(2131362648)
    RecyclerView rvList;

    public interface OnListFragmentInteractionListener {
        void a(View view, int i2, int i3);

        void b(View view, int i2, int i3);

        void u(EpisodeItem episodeItem, SeasonEntity seasonEntity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List I(ExternalID externalID) throws Exception {
        ArrayList<EpisodeItem> arrayList = new ArrayList<>();
        Response<EpisodesResponse> execute = this.f32708e.series().episodesQuery(externalID.getTvdb_id(), (Integer) null, Integer.valueOf(this.f32713j.j()), (Integer) null, (Integer) null, (Double) null, (String) null, (String) null, 1, "en").execute();
        if (execute.isSuccessful()) {
            for (Episode episodeItem : execute.body().data) {
                arrayList.add(new EpisodeItem(episodeItem, false, this.f32713j.d(), "TVDB"));
            }
            List<TvWatchedEpisode> h2 = this.f32706c.E().h(this.f32714k.getTmdbID(), this.f32714k.getImdbIDStr(), this.f32714k.getTraktID(), this.f32714k.getTvdbID(), this.f32713j.j());
            for (EpisodeItem episodeItem2 : arrayList) {
                for (TvWatchedEpisode c2 : h2) {
                    if (episodeItem2.f32694b.intValue() == c2.c()) {
                        episodeItem2.f32695c = Boolean.TRUE;
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(List list) throws Exception {
        EpisodesRecyclerViewAdapter episodesRecyclerViewAdapter = new EpisodesRecyclerViewAdapter(this, list, this.f32711h, this.f32713j);
        this.f32715l = episodesRecyclerViewAdapter;
        this.rvList.setAdapter(episodesRecyclerViewAdapter);
        this.loading.setVisibility(8);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            this.f32711h = (OnListFragmentInteractionListener) context;
            DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m((Activity) context).l()).b().q(this);
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.episode_bottom_sheet, viewGroup, false);
        this.f32710g = ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onDestroyView() {
        this.f32710g.unbind();
        this.f32712i.dispose();
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        this.f32711h = null;
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f32712i = new CompositeDisposable();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                BottomSheetBehavior I = BottomSheetBehavior.I((FrameLayout) ((BottomSheetDialog) EpisodeBottomSheetFragment.this.getDialog()).findViewById(R.id.design_bottom_sheet));
                I.S(3);
                I.Q(0);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        this.f32709f = linearLayoutManager;
        this.rvList.setLayoutManager(linearLayoutManager);
        this.loading.setVisibility(0);
        this.f32712i.b(this.f32707d.getTVExternalID(this.f32714k.getTmdbID()).subscribeOn(Schedulers.c()).map(new a(this)).observeOn(AndroidSchedulers.a()).subscribe(new b(this), new c()));
    }
}

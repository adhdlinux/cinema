package com.movie.ui.activity.shows.overview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.ads.videoreward.AdsManager;
import com.database.entitys.MovieEntity;
import com.movie.AppComponent;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.helper.MoviesHelper;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.thetvdb.entities.Series;
import com.uwetrottmann.thetvdb.entities.SeriesResponse;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import retrofit2.Response;

public class OverviewFragment extends BaseFragment {
    @BindView(2131361882)
    FrameLayout adView;
    @BindView(2131362053)
    LinearLayout content;

    /* renamed from: d  reason: collision with root package name */
    private OnFragmentInteractionListener f32763d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MovieEntity f32764e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    TMDBApi f32765f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    TMDBRepositoryImpl f32766g;

    /* renamed from: h  reason: collision with root package name */
    CompositeDisposable f32767h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    TheTvdb f32768i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    MoviesHelper f32769j;
    @BindView(2131362348)
    ProgressBar loading;
    @BindView(2131362858)
    TextView tvName;
    @BindView(2131362861)
    TextView tvOverview;
    @BindView(2131362058)
    TextView tvRating;
    @BindView(2131362875)
    TextView tvtime;

    public interface OnFragmentInteractionListener {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(TvTMDB.ResultsBean resultsBean) throws Exception {
        MovieEntity convert = resultsBean.convert();
        this.tvName.setText(convert.getName());
        this.tvtime.setText(String.format("Release : %s - %s", new Object[]{convert.getRealeaseDate(), resultsBean.getStatus()}));
        R(convert.getOverview());
        TextView textView = this.tvRating;
        textView.setText("Rating : " + Utils.r0(convert.getVote().doubleValue(), 2));
        this.content.setVisibility(0);
        this.loading.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(Throwable th) throws Exception {
        S();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Series series) throws Exception {
        double d2;
        this.tvName.setText(series.seriesName);
        TextView textView = this.tvtime;
        textView.setText("Release : " + series.firstAired);
        R(series.overview);
        TextView textView2 = this.tvRating;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating : ");
        Double d3 = series.siteRating;
        if (d3 == null) {
            d2 = 0.0d;
        } else {
            d2 = d3.doubleValue();
        }
        sb.append(Utils.r0(d2, 2));
        textView2.setText(sb.toString());
        this.content.setVisibility(0);
        this.loading.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(Throwable th) throws Exception {
        double d2;
        this.tvName.setText(this.f32764e.getName());
        TextView textView = this.tvtime;
        textView.setText("Release : " + this.f32764e.getRealeaseDate());
        R(this.f32764e.getOverview());
        TextView textView2 = this.tvRating;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating : ");
        if (this.f32764e.getVote() == null) {
            d2 = 0.0d;
        } else {
            d2 = this.f32764e.getVote().doubleValue();
        }
        sb.append(Utils.r0(d2, 2));
        textView2.setText(sb.toString());
        this.content.setVisibility(0);
        this.loading.setVisibility(8);
    }

    public static OverviewFragment Q(MovieEntity movieEntity) {
        OverviewFragment overviewFragment = new OverviewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_movie", movieEntity);
        overviewFragment.setArguments(bundle);
        return overviewFragment;
    }

    private void S() {
        this.f32767h.b(Observable.create(new ObservableOnSubscribe<Series>() {
            public void subscribe(ObservableEmitter<Series> observableEmitter) throws Exception {
                Response<SeriesResponse> execute = OverviewFragment.this.f32768i.series().series((int) OverviewFragment.this.f32764e.getTvdbID(), "en").execute();
                if (execute.isSuccessful()) {
                    observableEmitter.onNext(execute.body().data);
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(this), new d(this)));
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().a(this);
    }

    /* access modifiers changed from: package-private */
    public void R(String str) {
        this.tvOverview.setText(str);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            this.f32763d = (OnFragmentInteractionListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_overview, viewGroup, false);
    }

    public void onDestroyView() {
        this.f32767h.dispose();
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        this.f32763d = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AdsManager.d().r(this.adView);
        this.loading.setVisibility(0);
        this.f32764e = (MovieEntity) getArguments().getParcelable("arg_movie");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f32767h = compositeDisposable;
        compositeDisposable.b(this.f32765f.getTVDetails((long) ((int) this.f32764e.getTmdbID()), "en").subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new b(this)));
    }
}

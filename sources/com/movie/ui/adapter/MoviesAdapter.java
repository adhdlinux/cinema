package com.movie.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.database.entitys.MovieEntity;
import com.movie.FreeMoviesApp;
import com.movie.data.api.imdb.IMDBUtils;
import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.ui.fragment.MoviesFragment;
import com.movie.ui.widget.glidepalette.BitmapPalette;
import com.movie.ui.widget.glidepalette.GlidePalette;
import com.original.tase.Logger;
import com.utils.PosterCacheHelper;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.entities.SeriesImageQueryResultResponse;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Response;

public final class MoviesAdapter extends EndlessAdapter<MovieEntity, MovieHolder> {
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final Fragment f33089t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public OnMovieClickListener f33090u;

    /* renamed from: v  reason: collision with root package name */
    CompositeDisposable f33091v;

    final class MovieHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        Disposable f33094j = null;

        /* renamed from: k  reason: collision with root package name */
        private final StringBuilder f33095k = new StringBuilder(30);

        /* renamed from: l  reason: collision with root package name */
        private long f33096l = 0;

        /* renamed from: m  reason: collision with root package name */
        private String f33097m = "";
        @BindColor(2131100164)
        int mColorBackground;
        @BindColor(2131099701)
        int mColorSubtitle;
        @BindColor(2131099706)
        int mColorTitle;
        @BindView(2131362394)
        View mContentContainer;
        @BindView(2131362395)
        View mFooterView;
        @BindView(2131362396)
        TextView mGenresView;
        @BindView(2131362397)
        ImageView mImageView;
        @BindString(2131886791)
        String mTextStart;
        @BindView(2131362398)
        TextView mTitleView;
        @BindView(2131362856)
        TextView mTvView;
        @BindView(2131362399)
        TextView mYearView;

        /* renamed from: n  reason: collision with root package name */
        private long f33098n = 0;

        /* renamed from: o  reason: collision with root package name */
        private long f33099o = 0;
        @BindView(2131362925)
        ProgressBar watchedPercent;

        private class HolderImage {

            /* renamed from: a  reason: collision with root package name */
            public String f33107a;

            /* renamed from: b  reason: collision with root package name */
            public String f33108b;

            /* renamed from: c  reason: collision with root package name */
            public String f33109c;

            /* renamed from: d  reason: collision with root package name */
            public String f33110d;

            public HolderImage(String str, String str2, String str3, String str4) {
                this.f33107a = str;
                this.f33108b = str2;
                this.f33109c = str3;
                this.f33110d = str4;
            }
        }

        public MovieHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void A(MovieEntity movieEntity, Observer observer) {
            if (movieEntity.getTV().booleanValue() && movieEntity.getTvdbID() > 0) {
                try {
                    Response<SeriesImageQueryResultResponse> execute = ((MoviesFragment) MoviesAdapter.this.f33089t).f33298i.series().imagesQuery((int) movieEntity.getTvdbID(), "poster", (String) null, (String) null, "en").execute();
                    if (execute.isSuccessful()) {
                        observer.onNext(new HolderImage("http://thetvdb.com/banners/" + execute.body().data.get(0).fileName, "", "", ""));
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ HolderImage B(String str, ResponseBody responseBody) throws Exception {
            return new HolderImage(IMDBUtils.a(str, responseBody, true).getPoster_path(), "", "", "");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void C(Observer observer, HolderImage holderImage) throws Exception {
            observer.onNext(holderImage);
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void E(MovieEntity movieEntity, Observer observer) {
            if (movieEntity.getImdbIDStr() == null || movieEntity.getImdbIDStr().isEmpty()) {
                observer.onComplete();
                return;
            }
            String imdbIDStr = movieEntity.getImdbIDStr();
            MoviesAdapter moviesAdapter = MoviesAdapter.this;
            moviesAdapter.f33091v.b(((MoviesFragment) moviesAdapter.f33089t).f33297h.search(imdbIDStr).map(new n(this, imdbIDStr)).subscribeOn(Schedulers.c()).subscribe(new o(observer), new p(observer)));
        }

        private void F(MovieEntity movieEntity) {
            if (this.f33096l != movieEntity.getTmdbID()) {
                this.f33096l = movieEntity.getTmdbID();
                this.mFooterView.setBackgroundColor(this.mColorBackground);
                this.mTitleView.setTextColor(this.mColorTitle);
                this.mGenresView.setTextColor(this.mColorSubtitle);
                this.mImageView.setImageDrawable((Drawable) null);
                this.watchedPercent.setVisibility(8);
            }
        }

        /* access modifiers changed from: private */
        public void o(Palette.Swatch swatch) {
            if (swatch != null) {
                this.mFooterView.setBackgroundColor(swatch.e());
                this.mTitleView.setTextColor(swatch.b());
                this.mGenresView.setTextColor(swatch.f());
            }
        }

        private void q(final MovieEntity movieEntity) {
            RequestBuilder<Drawable> x02 = Glide.u(MoviesAdapter.this.f33089t).h(movieEntity.getPoster_path()).a(((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).c()).s0(new RequestListener<Drawable>() {
                /* renamed from: a */
                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z2) {
                    return false;
                }

                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z2) {
                    PosterCacheHelper.d().a(movieEntity.getTmdbID(), movieEntity.getTvdbID(), movieEntity.getImdbIDStr());
                    return false;
                }
            }).x0(new DrawableTransitionOptions().e());
            if (!FreeMoviesApp.s()) {
                x02.s0(GlidePalette.h(movieEntity.getPoster_path()).g(new BitmapPalette.CallBack() {
                    public void a(Palette palette) {
                        MovieHolder.this.o(palette.f());
                    }
                }));
            }
            x02.q0(this.mImageView);
            this.mGenresView.setText(Utils.n0(movieEntity.getGenres(), ", ", this.f33095k));
            this.mYearView.setText(movieEntity.getRealeaseDate());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(MovieEntity movieEntity, View view) {
            MoviesAdapter.this.f33090u.p(movieEntity, view, getAdapterPosition());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(Observer observer, TvTMDB.ResultsBean resultsBean) throws Exception {
            String str;
            if (resultsBean.getPoster_path() != null && !resultsBean.getBackdrop_path().isEmpty()) {
                if (resultsBean.getGenres().size() > 0) {
                    str = resultsBean.getGenres().get(0).getName();
                } else {
                    str = "";
                }
                observer.onNext(new HolderImage(resultsBean.getPoster_path(), resultsBean.getBackdrop_path(), resultsBean.getFirst_air_date(), str));
            }
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(MovieEntity movieEntity, HolderImage holderImage) throws Exception {
            String str;
            String str2;
            movieEntity.setPoster_path(holderImage.f33107a);
            movieEntity.setBackdrop_path(holderImage.f33108b);
            movieEntity.setRealeaseDate(holderImage.f33109c);
            String str3 = holderImage.f33110d;
            if (str3 != null) {
                movieEntity.setGenres(Arrays.asList(str3.split(",")));
            }
            PosterCacheHelper d2 = PosterCacheHelper.d();
            long tmdbID = movieEntity.getTmdbID();
            long tvdbID = movieEntity.getTvdbID();
            String imdbIDStr = movieEntity.getImdbIDStr();
            String str4 = holderImage.f33107a;
            String str5 = holderImage.f33108b;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            d2.g(tmdbID, tvdbID, imdbIDStr, str4, str);
            long tmdbID2 = movieEntity.getTmdbID();
            long tvdbID2 = movieEntity.getTvdbID();
            String imdbIDStr2 = movieEntity.getImdbIDStr();
            String str6 = holderImage.f33109c;
            String str7 = holderImage.f33110d;
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            d2.h(tmdbID2, tvdbID2, imdbIDStr2, str6, str2);
            q(movieEntity);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(Throwable th) throws Exception {
            this.mImageView.setAlpha(127);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(Observer observer, MovieTMDB.ResultsBean resultsBean) throws Exception {
            String str;
            if (resultsBean.getPoster_path() != null && !resultsBean.getPoster_path().isEmpty()) {
                if (resultsBean.getGenres().size() > 0) {
                    str = resultsBean.getGenres().get(0).getName();
                } else {
                    str = "";
                }
                observer.onNext(new HolderImage(resultsBean.getPoster_path(), resultsBean.getBackdrop_path(), resultsBean.getRelease_date(), str));
            }
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(MovieEntity movieEntity, Observer observer) {
            if (movieEntity.getTmdbID() <= 0) {
                observer.onComplete();
            } else if (movieEntity.getTV().booleanValue()) {
                MoviesAdapter moviesAdapter = MoviesAdapter.this;
                moviesAdapter.f33091v.b(((MoviesFragment) moviesAdapter.f33089t).f33296g.getTvDetails(movieEntity.getTmdbID()).subscribeOn(Schedulers.c()).subscribe(new v(this, observer), new w(observer)));
            } else {
                MoviesAdapter moviesAdapter2 = MoviesAdapter.this;
                moviesAdapter2.f33091v.b(((MoviesFragment) moviesAdapter2.f33089t).f33296g.getMovieDetails(this.f33096l, (String) null).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new x(this, observer), new y(observer)));
            }
        }

        public void p(MovieEntity movieEntity) {
            Disposable disposable = this.f33094j;
            if (disposable != null && !disposable.isDisposed()) {
                MoviesAdapter.this.f33091v.a(this.f33094j);
            }
            this.mContentContainer.setOnClickListener(new m(this, movieEntity));
            this.mTitleView.setText(movieEntity.getName());
            this.mGenresView.setText(Utils.n0(movieEntity.getGenres(), ", ", this.f33095k));
            this.mYearView.setText(movieEntity.getRealeaseDate());
            F(movieEntity);
            Disposable r2 = r(movieEntity, this.mImageView);
            this.f33094j = r2;
            MoviesAdapter.this.f33091v.b(r2);
            if (movieEntity.getTV().booleanValue()) {
                int numberSeason = movieEntity.getNumberSeason();
                String format = String.format(" %02d ", new Object[]{Integer.valueOf(numberSeason)});
                if (numberSeason <= 0) {
                    format = "TV";
                }
                this.mTvView.setText(format);
                this.mTvView.setVisibility(0);
            } else {
                this.mTvView.setVisibility(4);
            }
            this.mContentContainer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z2) {
                    if (z2) {
                        MovieHolder.this.mImageView.setAlpha(0.5f);
                    } else {
                        MovieHolder.this.mImageView.setAlpha(1.0f);
                    }
                }
            });
            if (movieEntity.getPosition() > 0 && movieEntity.getDuration() > 0) {
                this.watchedPercent.setVisibility(0);
                this.watchedPercent.setProgress((int) ((movieEntity.getPosition() * 100) / movieEntity.getDuration()));
            }
        }

        public Disposable r(final MovieEntity movieEntity, ImageView imageView) {
            if (movieEntity.getTmdbID() == 849042) {
                Logger.a("log");
            }
            return Observable.create(new ObservableOnSubscribe<HolderImage>() {
                public void subscribe(ObservableEmitter<HolderImage> observableEmitter) throws Exception {
                    if (movieEntity.getPoster_path() == null) {
                        PosterCacheHelper d2 = PosterCacheHelper.d();
                        String e2 = d2.e(movieEntity.getTmdbID(), movieEntity.getTvdbID(), movieEntity.getImdbIDStr());
                        String b2 = d2.b(movieEntity.getTmdbID(), movieEntity.getTvdbID(), movieEntity.getImdbIDStr());
                        String f2 = d2.f(movieEntity.getTmdbID(), movieEntity.getTvdbID(), movieEntity.getImdbIDStr());
                        String c2 = d2.c(movieEntity.getTmdbID(), movieEntity.getTvdbID(), movieEntity.getImdbIDStr());
                        if (e2 != null && !e2.isEmpty()) {
                            observableEmitter.onNext(new HolderImage(e2, b2, f2, c2));
                        }
                    } else {
                        observableEmitter.onNext(new HolderImage(movieEntity.getPoster_path(), movieEntity.getBackdrop_path(), movieEntity.getRealeaseDate(), TextUtils.join(",", movieEntity.getGenres())));
                    }
                    observableEmitter.onComplete();
                }
            }).switchIfEmpty(new q(this, movieEntity)).switchIfEmpty(new r(this, movieEntity)).switchIfEmpty(new s(this, movieEntity)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new t(this, movieEntity), new u(this));
        }
    }

    public final class MovieHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private MovieHolder f33112a;

        public MovieHolder_ViewBinding(MovieHolder movieHolder, View view) {
            this.f33112a = movieHolder;
            movieHolder.mContentContainer = butterknife.internal.Utils.findRequiredView(view, R.id.movie_item_container, "field 'mContentContainer'");
            movieHolder.mImageView = (ImageView) butterknife.internal.Utils.findRequiredViewAsType(view, R.id.movie_item_image, "field 'mImageView'", ImageView.class);
            Class cls = TextView.class;
            movieHolder.mTvView = (TextView) butterknife.internal.Utils.findRequiredViewAsType(view, R.id.tvMV, "field 'mTvView'", cls);
            movieHolder.mTitleView = (TextView) butterknife.internal.Utils.findRequiredViewAsType(view, R.id.movie_item_title, "field 'mTitleView'", cls);
            movieHolder.mGenresView = (TextView) butterknife.internal.Utils.findRequiredViewAsType(view, R.id.movie_item_genres, "field 'mGenresView'", cls);
            movieHolder.mYearView = (TextView) butterknife.internal.Utils.findRequiredViewAsType(view, R.id.movie_item_year, "field 'mYearView'", cls);
            movieHolder.watchedPercent = (ProgressBar) butterknife.internal.Utils.findRequiredViewAsType(view, R.id.watched_percent, "field 'watchedPercent'", ProgressBar.class);
            movieHolder.mFooterView = butterknife.internal.Utils.findRequiredView(view, R.id.movie_item_footer, "field 'mFooterView'");
            Context context = view.getContext();
            Resources resources = context.getResources();
            movieHolder.mColorBackground = ContextCompat.getColor(context, R.color.theme_primary);
            movieHolder.mColorTitle = ContextCompat.getColor(context, R.color.body_text_white);
            movieHolder.mColorSubtitle = ContextCompat.getColor(context, R.color.body_text_1_inverse);
            movieHolder.mTextStart = resources.getString(R.string.text_star);
        }

        public void unbind() {
            MovieHolder movieHolder = this.f33112a;
            if (movieHolder != null) {
                this.f33112a = null;
                movieHolder.mContentContainer = null;
                movieHolder.mImageView = null;
                movieHolder.mTvView = null;
                movieHolder.mTitleView = null;
                movieHolder.mGenresView = null;
                movieHolder.mYearView = null;
                movieHolder.watchedPercent = null;
                movieHolder.mFooterView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface OnMovieClickListener {
        public static final OnMovieClickListener B0 = new OnMovieClickListener() {
            public void p(MovieEntity movieEntity, View view, int i2) {
            }
        };

        void p(MovieEntity movieEntity, View view, int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MoviesAdapter(Fragment fragment, List<MovieEntity> list) {
        super(fragment.getActivity(), list == null ? new ArrayList<>() : list);
        this.f33090u = OnMovieClickListener.B0;
        this.f33091v = null;
        this.f33089t = fragment;
        setHasStableIds(true);
        this.f33091v = new CompositeDisposable();
    }

    public long getItemId(int i2) {
        if (i(i2)) {
            return -1;
        }
        return ((MovieEntity) f(i2)).getTmdbID();
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ViewHolder j(ViewGroup viewGroup) {
        return new MovieHolder(this.f33059n.inflate(R.layout.item_movie, viewGroup, false));
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ViewHolder k(ViewGroup viewGroup) {
        return new MovieHolder(this.f33059n.inflate(R.layout.item_movie, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (getItemViewType(i2) == 2) {
            ((MovieHolder) viewHolder).p((MovieEntity) this.f33060o.get(i2));
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f33091v.dispose();
    }

    public void p(OnMovieClickListener onMovieClickListener) {
        this.f33090u = onMovieClickListener;
    }

    public void q(final boolean z2) {
        Collections.sort(this.f33060o, new Comparator<MovieEntity>() {
            /* renamed from: a */
            public int compare(MovieEntity movieEntity, MovieEntity movieEntity2) {
                if (z2) {
                    return movieEntity.getName().compareToIgnoreCase(movieEntity2.getName());
                }
                return movieEntity2.getName().compareToIgnoreCase(movieEntity.getName());
            }
        });
        notifyDataSetChanged();
    }
}

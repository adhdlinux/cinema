package com.movie.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.movie.data.api.imdb.IMDBUtils;
import com.movie.data.model.CalendarItem;
import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.ui.activity.CalendarActivity;
import com.movie.ui.widget.AspectLockedImageView;
import com.utils.PosterCacheHelper;
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
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Response;

public final class CalendarAdapter extends EndlessAdapter<CalendarItem, MovieHolder> {
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final CalendarActivity f33045t;

    /* renamed from: u  reason: collision with root package name */
    CompositeDisposable f33046u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public OnCalendarClickListener f33047v;

    final class MovieHolder extends RecyclerView.ViewHolder {
        @BindView(2131361986)
        CardView calendar_container;
        @BindView(2131362133)
        AspectLockedImageView epi_cover;

        /* renamed from: j  reason: collision with root package name */
        private final StringBuilder f33048j = new StringBuilder(30);

        /* renamed from: k  reason: collision with root package name */
        Disposable f33049k = null;

        /* renamed from: l  reason: collision with root package name */
        private long f33050l;
        @BindView(2131362851)
        TextView tvEpiName;
        @BindView(2131362861)
        TextView tvOverview;
        @BindView(2131362867)
        TextView tvTitle;
        @BindView(2131362924)
        CheckBox watched;

        private class HolderImage {

            /* renamed from: a  reason: collision with root package name */
            public String f33055a;

            /* renamed from: b  reason: collision with root package name */
            public String f33056b;

            public HolderImage(String str, String str2) {
                this.f33055a = str;
                this.f33056b = str2;
            }
        }

        public MovieHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void A(CalendarItem calendarItem, Observer observer) {
            String str = calendarItem.imdbID;
            if (str == null || str.isEmpty()) {
                observer.onComplete();
                return;
            }
            String str2 = calendarItem.imdbID;
            CalendarAdapter calendarAdapter = CalendarAdapter.this;
            calendarAdapter.f33046u.b(calendarAdapter.f33045t.f32002g.search(str2).map(new l(this, str2)).subscribeOn(Schedulers.c()).subscribe(new b(observer), new c(observer)));
        }

        private void n(CalendarItem calendarItem) {
            if (calendarItem.poster != null) {
                Glide.v(CalendarAdapter.this.f33045t).h(calendarItem.poster).a(((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).c()).x0(new DrawableTransitionOptions().e()).q0(this.epi_cover);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(CalendarItem calendarItem, View view) {
            CalendarAdapter.this.f33047v.j(calendarItem, view, getAdapterPosition());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(CalendarItem calendarItem, View view) {
            CalendarAdapter.this.f33047v.j(calendarItem, view, getAdapterPosition());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(CalendarItem calendarItem, HolderImage holderImage) throws Exception {
            calendarItem.poster = holderImage.f33055a;
            calendarItem.backdrop = holderImage.f33056b;
            PosterCacheHelper.d().g(calendarItem.tmdbID, calendarItem.tvdnID, calendarItem.imdbID, holderImage.f33055a, holderImage.f33056b);
            n(calendarItem);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void s(Throwable th) throws Exception {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(Observer observer, TvTMDB.ResultsBean resultsBean) throws Exception {
            if (resultsBean.getPoster_path() != null && !resultsBean.getBackdrop_path().isEmpty()) {
                observer.onNext(new HolderImage(resultsBean.getPoster_path(), resultsBean.getBackdrop_path()));
            }
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(CalendarItem calendarItem, Observer observer) {
            if (calendarItem.tmdbID > 0) {
                CalendarAdapter calendarAdapter = CalendarAdapter.this;
                calendarAdapter.f33046u.b(calendarAdapter.f33045t.f32001f.getTvDetails(calendarItem.tmdbID).subscribeOn(Schedulers.c()).subscribe(new j(this, observer), new k(observer)));
                return;
            }
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(CalendarItem calendarItem, Observer observer) {
            if (calendarItem.tvdnID > 0) {
                try {
                    Response<SeriesImageQueryResultResponse> execute = CalendarAdapter.this.f33045t.f32003h.series().imagesQuery((int) calendarItem.tvdnID, "poster", (String) null, (String) null, "en").execute();
                    if (execute.isSuccessful()) {
                        observer.onNext(new HolderImage("http://thetvdb.com/banners/" + execute.body().data.get(0).fileName, ""));
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            observer.onComplete();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ HolderImage x(String str, ResponseBody responseBody) throws Exception {
            return new HolderImage(IMDBUtils.a(str, responseBody, true).getPoster_path(), "");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void y(Observer observer, HolderImage holderImage) throws Exception {
            observer.onNext(holderImage);
            observer.onComplete();
        }

        public void m(CalendarItem calendarItem) {
            Disposable disposable = this.f33049k;
            if (disposable != null && !disposable.isDisposed()) {
                CalendarAdapter.this.f33046u.a(this.f33049k);
            }
            this.calendar_container.setOnClickListener(new a(this, calendarItem));
            this.epi_cover.setOnClickListener(new d(this, calendarItem));
            this.tvTitle.setText(calendarItem.showName);
            TextView textView = this.tvEpiName;
            textView.setText(calendarItem.season + "x" + calendarItem.episode + " " + calendarItem.episodeName);
            this.tvOverview.setText(calendarItem.airTime);
            this.epi_cover.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z2) {
                    if (z2) {
                        MovieHolder.this.epi_cover.setAlpha(0.5f);
                    } else {
                        MovieHolder.this.epi_cover.setAlpha(1.0f);
                    }
                }
            });
            long j2 = this.f33050l;
            long j3 = calendarItem.tmdbID;
            if (j2 != j3) {
                this.f33050l = j3;
                this.epi_cover.setImageDrawable((Drawable) null);
            }
            String str = calendarItem.poster;
            if (str == null || str.isEmpty()) {
                CalendarAdapter.this.f33046u.b(o(calendarItem, this.epi_cover));
            } else {
                n(calendarItem);
            }
        }

        public Disposable o(final CalendarItem calendarItem, ImageView imageView) {
            return Observable.create(new ObservableOnSubscribe<HolderImage>() {
                public void subscribe(ObservableEmitter<HolderImage> observableEmitter) throws Exception {
                    CalendarItem calendarItem = calendarItem;
                    String str = calendarItem.poster;
                    if (str == null) {
                        PosterCacheHelper d2 = PosterCacheHelper.d();
                        CalendarItem calendarItem2 = calendarItem;
                        String e2 = d2.e(calendarItem2.tmdbID, calendarItem2.tvdnID, calendarItem2.imdbID);
                        CalendarItem calendarItem3 = calendarItem;
                        String b2 = d2.b(calendarItem3.tmdbID, calendarItem3.tvdnID, calendarItem3.imdbID);
                        if (e2 != null && !e2.isEmpty()) {
                            observableEmitter.onNext(new HolderImage(e2, b2));
                        }
                    } else {
                        observableEmitter.onNext(new HolderImage(str, calendarItem.backdrop));
                    }
                    observableEmitter.onComplete();
                }
            }).switchIfEmpty(new e(this, calendarItem)).switchIfEmpty(new f(this, calendarItem)).switchIfEmpty(new g(this, calendarItem)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new h(this, calendarItem), new i());
        }
    }

    public final class MovieHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private MovieHolder f33058a;

        public MovieHolder_ViewBinding(MovieHolder movieHolder, View view) {
            this.f33058a = movieHolder;
            movieHolder.epi_cover = (AspectLockedImageView) Utils.findRequiredViewAsType(view, R.id.epi_cover, "field 'epi_cover'", AspectLockedImageView.class);
            Class cls = TextView.class;
            movieHolder.tvOverview = (TextView) Utils.findRequiredViewAsType(view, R.id.tvOverview, "field 'tvOverview'", cls);
            movieHolder.tvEpiName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvEpiName, "field 'tvEpiName'", cls);
            movieHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTabTitle, "field 'tvTitle'", cls);
            movieHolder.watched = (CheckBox) Utils.findRequiredViewAsType(view, R.id.watched, "field 'watched'", CheckBox.class);
            movieHolder.calendar_container = (CardView) Utils.findRequiredViewAsType(view, R.id.calendar_container, "field 'calendar_container'", CardView.class);
        }

        public void unbind() {
            MovieHolder movieHolder = this.f33058a;
            if (movieHolder != null) {
                this.f33058a = null;
                movieHolder.epi_cover = null;
                movieHolder.tvOverview = null;
                movieHolder.tvEpiName = null;
                movieHolder.tvTitle = null;
                movieHolder.watched = null;
                movieHolder.calendar_container = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface OnCalendarClickListener {
        public static final OnCalendarClickListener A0 = new OnCalendarClickListener() {
            public void j(CalendarItem calendarItem, View view, int i2) {
            }
        };

        void j(CalendarItem calendarItem, View view, int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalendarAdapter(CalendarActivity calendarActivity, List<CalendarItem> list) {
        super(calendarActivity, list == null ? new ArrayList<>() : list);
        this.f33046u = null;
        this.f33047v = OnCalendarClickListener.A0;
        this.f33045t = calendarActivity;
        setHasStableIds(true);
        this.f33046u = new CompositeDisposable();
    }

    public long getItemId(int i2) {
        if (i(i2)) {
            return -1;
        }
        return (long) ((CalendarItem) f(i2)).episode;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ViewHolder j(ViewGroup viewGroup) {
        return new MovieHolder(this.f33059n.inflate(R.layout.calendar_item, viewGroup, false));
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ViewHolder k(ViewGroup viewGroup) {
        return new MovieHolder(this.f33059n.inflate(R.layout.calendar_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (getItemViewType(i2) == 2) {
            ((MovieHolder) viewHolder).m((CalendarItem) this.f33060o.get(i2));
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f33046u.dispose();
    }

    public void p(OnCalendarClickListener onCalendarClickListener) {
        this.f33047v = onCalendarClickListener;
    }
}

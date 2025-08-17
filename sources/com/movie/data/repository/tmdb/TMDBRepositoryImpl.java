package com.movie.data.repository.tmdb;

import android.util.SparseArray;
import com.database.MvDatabase;
import com.database.entitys.CategoryEntity;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.TmdbGenres;
import com.movie.data.model.cinema.Genre;
import com.movie.data.model.cinema.Movie;
import com.movie.data.model.cinema.Video;
import com.movie.data.model.tmvdb.GenreTMDB;
import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.data.model.tmvdb.SearchTMDB;
import com.movie.data.model.tmvdb.SeasonTMDB;
import com.movie.data.model.tmvdb.TvTMDB;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.functions.Func2;
import z0.a;
import z0.b;
import z0.c;
import z0.d;
import z0.e;
import z0.f;
import z0.g;
import z0.h;
import z0.i;
import z0.j;
import z0.k;
import z0.l;
import z0.m;
import z0.n;
import z0.o;
import z0.p;
import z0.q;
import z0.r;
import z0.s;
import z0.t;
import z0.u;
import z0.v;

public final class TMDBRepositoryImpl {

    /* renamed from: c  reason: collision with root package name */
    private static Func2<List<Movie>, Map<Integer, Genre>, List<Movie>> f31953c = new o();

    /* renamed from: a  reason: collision with root package name */
    private final TMDBApi f31954a;

    /* renamed from: b  reason: collision with root package name */
    private final MvDatabase f31955b;

    /* renamed from: com.movie.data.repository.tmdb.TMDBRepositoryImpl$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31958a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.database.entitys.CategoryEntity$Type[] r0 = com.database.entitys.CategoryEntity.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31958a = r0
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.Movie     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31958a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.Show     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31958a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.Episode     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31958a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.MIX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.data.repository.tmdb.TMDBRepositoryImpl.AnonymousClass3.<clinit>():void");
        }
    }

    public TMDBRepositoryImpl(TMDBApi tMDBApi, MvDatabase mvDatabase) {
        this.f31954a = tMDBApi;
        this.f31955b = mvDatabase;
    }

    /* access modifiers changed from: private */
    public List<CategoryEntity> G(CategoryEntity.Type type) {
        ArrayList arrayList = new ArrayList();
        int i2 = AnonymousClass3.f31958a[type.ordinal()];
        if (i2 == 1) {
            CategoryEntity.Source source = CategoryEntity.Source.TMDB;
            Integer valueOf = Integer.valueOf(CategoryEntity.Generic.Popular.getValue());
            CategoryEntity.SourceType sourceType = CategoryEntity.SourceType.Generic;
            arrayList.add(new CategoryEntity(source, type, valueOf, sourceType, "Popular"));
            CategoryEntity.Source source2 = source;
            CategoryEntity.Type type2 = type;
            CategoryEntity.SourceType sourceType2 = sourceType;
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.NowPLaying.getValue()), sourceType2, "Now playing"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.Upcomming.getValue()), sourceType2, "Upcoming"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.TopRated.getValue()), sourceType2, "Top rated"));
        } else if (i2 == 2) {
            CategoryEntity.Source source3 = CategoryEntity.Source.TMDB;
            Integer valueOf2 = Integer.valueOf(CategoryEntity.Generic.Popular.getValue());
            CategoryEntity.SourceType sourceType3 = CategoryEntity.SourceType.Generic;
            arrayList.add(new CategoryEntity(source3, type, valueOf2, sourceType3, "Popular"));
            CategoryEntity.Source source4 = source3;
            CategoryEntity.Type type3 = type;
            CategoryEntity.SourceType sourceType4 = sourceType3;
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.AiringToday.getValue()), sourceType4, "Airing today"));
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.OnTv.getValue()), sourceType4, "On TV"));
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.TopRated.getValue()), sourceType4, "Top rated"));
        } else if (i2 == 4) {
            CategoryEntity.Source source5 = CategoryEntity.Source.TMDB;
            CategoryEntity.SourceType sourceType5 = CategoryEntity.SourceType.FeatureList;
            arrayList.add(new CategoryEntity(source5, type, 2739, sourceType5, "Disney+"));
            CategoryEntity.Source source6 = source5;
            CategoryEntity.Type type4 = type;
            CategoryEntity.SourceType sourceType6 = sourceType5;
            arrayList.add(new CategoryEntity(source6, type4, Integer.valueOf(Sdk$SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE), sourceType6, "Netflix™"));
            arrayList.add(new CategoryEntity(source6, type4, 1024, sourceType6, "Amazon™"));
            arrayList.add(new CategoryEntity(source6, type4, 453, sourceType6, "Hulu™"));
            arrayList.add(new CategoryEntity(source6, type4, 4883, sourceType6, "Discovery+"));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List L(TvTMDB.ResultsBean resultsBean) throws Exception {
        MovieEntity z2 = z(resultsBean);
        this.f31955b.A().i(z2.getNumberSeason(), z2.getTmdbID(), z2.getImdbIDStr(), z2.getTraktID(), z2.getTvdbID());
        return A(resultsBean.getSeasons(), resultsBean.getLast_episode_to_air());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O(List list, GenreTMDB genreTMDB) throws Exception {
        for (GenreTMDB.GenresBean next : genreTMDB.getGenres()) {
            list.add(new CategoryEntity(CategoryEntity.Source.TMDB, CategoryEntity.Type.Movie, Integer.valueOf(next.getId()), CategoryEntity.SourceType.Genre, next.getName()));
        }
        return list;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List P(List list, GenreTMDB genreTMDB) throws Exception {
        for (GenreTMDB.GenresBean next : genreTMDB.getGenres()) {
            list.add(new CategoryEntity(CategoryEntity.Source.TMDB, CategoryEntity.Type.Show, Integer.valueOf(next.getId()), CategoryEntity.SourceType.Genre, next.getName()));
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource Q(CategoryEntity.Type type, List list) throws Exception {
        if (type == CategoryEntity.Type.Movie) {
            return this.f31954a.movieGenres().map(new k(list));
        }
        if (type == CategoryEntity.Type.Show) {
            return this.f31954a.tvGenres().map(new m(list));
        }
        return Observable.just(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List R(List list) throws Exception {
        this.f31955b.w().a((CategoryEntity[]) list.toArray(new CategoryEntity[list.size()]));
        return list;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Video.Response e0(Video.Response response) throws Exception {
        return response;
    }

    public static void g0(MovieEntity movieEntity, MovieTMDB.ResultsBean resultsBean, SparseArray<String> sparseArray) {
        if (sparseArray != null) {
            ArrayList arrayList = new ArrayList();
            for (Integer intValue : resultsBean.getGenre_ids()) {
                int intValue2 = intValue.intValue();
                if (sparseArray.get(intValue2) != null) {
                    arrayList.add(sparseArray.get(intValue2));
                }
            }
            movieEntity.setGenres(arrayList);
        }
    }

    public static void h0(MovieEntity movieEntity, SearchTMDB.ResultsBean resultsBean, SparseArray<String> sparseArray) {
        if (sparseArray != null && resultsBean.getGenre_ids() != null) {
            ArrayList arrayList = new ArrayList();
            for (Integer intValue : resultsBean.getGenre_ids()) {
                int intValue2 = intValue.intValue();
                if (sparseArray.get(intValue2) != null) {
                    arrayList.add(sparseArray.get(intValue2));
                }
            }
            movieEntity.setGenres(arrayList);
        }
    }

    public static void i0(MovieEntity movieEntity, TvTMDB.ResultsBean resultsBean, SparseArray<String> sparseArray) {
        if (sparseArray != null) {
            ArrayList arrayList = new ArrayList();
            if (resultsBean.getGenre_ids() != null) {
                for (Integer intValue : resultsBean.getGenre_ids()) {
                    int intValue2 = intValue.intValue();
                    if (sparseArray.get(intValue2) != null) {
                        arrayList.add(sparseArray.get(intValue2));
                    }
                }
            } else if (resultsBean.getGenres() != null) {
                for (TvTMDB.ResultsBean.GenresBean next : resultsBean.getGenres()) {
                    if (sparseArray.get(next.getId()) != null) {
                        arrayList.add(next.getName());
                    }
                }
            }
            movieEntity.setGenres(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public static List<MovieEntity> w(List<MovieTMDB.ResultsBean> list, boolean z2) {
        ArrayList arrayList = new ArrayList();
        for (MovieTMDB.ResultsBean next : list) {
            MovieEntity convert = next.convert();
            convert.setTV(Boolean.valueOf(z2));
            if (convert.getTV().booleanValue()) {
                g0(convert, next, TmdbGenres.getTVCategory());
            } else {
                g0(convert, next, TmdbGenres.getMVCategory());
            }
            arrayList.add(convert);
        }
        return arrayList;
    }

    public static List<MovieEntity> x(List<SearchTMDB.ResultsBean> list) {
        ArrayList arrayList = new ArrayList();
        for (SearchTMDB.ResultsBean next : list) {
            MovieEntity convert = next.convert();
            if (convert != null) {
                if (convert.getTV().booleanValue()) {
                    h0(convert, next, TmdbGenres.getTVCategory());
                } else {
                    h0(convert, next, TmdbGenres.getMVCategory());
                }
                arrayList.add(convert);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static List<MovieEntity> y(List<TvTMDB.ResultsBean> list, boolean z2) {
        ArrayList arrayList = new ArrayList();
        for (TvTMDB.ResultsBean next : list) {
            MovieEntity convert = next.convert();
            convert.setTV(Boolean.valueOf(z2));
            if (convert.getTV().booleanValue()) {
                i0(convert, next, TmdbGenres.getTVCategory());
            } else {
                i0(convert, next, TmdbGenres.getMVCategory());
            }
            arrayList.add(convert);
        }
        return arrayList;
    }

    private static MovieEntity z(TvTMDB.ResultsBean resultsBean) {
        MovieEntity convert = resultsBean.convert();
        convert.setTV(Boolean.TRUE);
        convert.setNumberSeason(resultsBean.getNumber_of_seasons());
        if (convert.getTV().booleanValue()) {
            i0(convert, resultsBean, TmdbGenres.getTVCategory());
        } else {
            i0(convert, resultsBean, TmdbGenres.getMVCategory());
        }
        return convert;
    }

    public List<SeasonEntity> A(List<TvTMDB.ResultsBean.SeasonsBean> list, TvTMDB.ResultsBean.LastEpisodeToAirBean lastEpisodeToAirBean) {
        ArrayList arrayList = new ArrayList();
        for (TvTMDB.ResultsBean.SeasonsBean next : list) {
            SeasonEntity convert = next.convert();
            if (convert.j() == lastEpisodeToAirBean.getSeason_number()) {
                convert.n(lastEpisodeToAirBean.getEpisode_number());
            } else {
                convert.n(next.getEpisode_count());
            }
            arrayList.add(convert);
        }
        return arrayList;
    }

    public Observable<List<MovieEntity>> B(int i2, int i3, int i4) {
        Integer num;
        String str = null;
        if (i4 == -1) {
            num = null;
        } else {
            num = Integer.valueOf(i4);
        }
        TMDBApi tMDBApi = this.f31954a;
        if (i2 != -1) {
            str = String.valueOf(i2);
        }
        return tMDBApi.discoverMovies("popularity.desc", i3, str, num).map(new e()).subscribeOn(Schedulers.c());
    }

    public Observable<List<SeasonEntity>> C(long j2) {
        return this.f31954a.getTVDetails(j2, (String) null).map(new n(this));
    }

    public Observable<List<MovieEntity>> D(int i2, int i3, int i4) {
        Integer num;
        String str = null;
        if (i4 == -1) {
            num = null;
        } else {
            num = Integer.valueOf(i4);
        }
        TMDBApi tMDBApi = this.f31954a;
        if (i2 != -1) {
            str = String.valueOf(i2);
        }
        return tMDBApi.discoverTvShows("popularity.desc", i3, str, num).map(new d()).subscribeOn(Schedulers.c());
    }

    public Observable<List<MovieEntity>> E(int i2, int i3, int i4) {
        Integer num;
        String str = null;
        if (i4 == -1) {
            num = null;
        } else {
            num = Integer.valueOf(i4);
        }
        TMDBApi tMDBApi = this.f31954a;
        if (i3 != -1) {
            str = String.valueOf(i3);
        }
        return tMDBApi.discoverTvShowsNetwork("popularity.desc", i2, str, num).map(new f()).subscribeOn(Schedulers.c());
    }

    public Observable<List<CategoryEntity>> F(final CategoryEntity.Type type) {
        return Observable.create(new ObservableOnSubscribe<List<CategoryEntity>>() {
            public void subscribe(ObservableEmitter<List<CategoryEntity>> observableEmitter) throws Exception {
                observableEmitter.onNext(TMDBRepositoryImpl.this.G(type));
            }
        }).flatMap(new i(this, type)).map(new j(this));
    }

    public Observable<List<MovieEntity>> H(long j2, int i2) {
        return this.f31954a.getMVRecomendation(j2, i2).map(new a()).subscribeOn(Schedulers.c());
    }

    public Observable<List<SeasonTMDB.EpisodesBean>> I(long j2, int i2) {
        return this.f31954a.getSeasonDetails(j2, i2).map(new h()).subscribeOn(Schedulers.c());
    }

    public Observable<List<MovieEntity>> J(long j2, int i2) {
        return this.f31954a.getTVRecomendation(j2, i2).map(new l()).subscribeOn(Schedulers.c());
    }

    public Observable<List<MovieEntity>> f0(CategoryEntity categoryEntity, int i2) {
        if (categoryEntity.getType() == CategoryEntity.Type.Show) {
            if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Popular.getValue()) {
                return this.f31954a.getShowPopular(i2).map(new q()).subscribeOn(Schedulers.c());
            }
            if (categoryEntity.getId().intValue() == CategoryEntity.Generic.AiringToday.getValue()) {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                return this.f31954a.getShowAringToday(i2, format, format).map(new r()).subscribeOn(Schedulers.c());
            } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.OnTv.getValue()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String format2 = simpleDateFormat.format(new Date());
                Calendar instance = Calendar.getInstance();
                instance.add(6, 7);
                return this.f31954a.getShowOnTheAir(i2, format2, simpleDateFormat.format(instance.getTime())).map(new s()).subscribeOn(Schedulers.c());
            } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.TopRated.getValue()) {
                return this.f31954a.getShowTopRated(i2).map(new t()).subscribeOn(Schedulers.c());
            }
        } else if (categoryEntity.getType() == CategoryEntity.Type.Movie) {
            if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Popular.getValue()) {
                return this.f31954a.getMoviePopular(i2).map(new u()).subscribeOn(Schedulers.c());
            }
            if (categoryEntity.getId().intValue() == CategoryEntity.Generic.NowPLaying.getValue()) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String format3 = simpleDateFormat2.format(new Date());
                Calendar instance2 = Calendar.getInstance();
                instance2.add(6, -7);
                return this.f31954a.getMovieNowPLaying(i2, simpleDateFormat2.format(instance2.getTime()), format3).map(new v()).subscribeOn(Schedulers.c());
            } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.TopRated.getValue()) {
                return this.f31954a.getMovieTopRated(i2).map(new b()).subscribeOn(Schedulers.c());
            } else {
                if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Upcomming.getValue()) {
                    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    String format4 = simpleDateFormat3.format(new Date());
                    Calendar instance3 = Calendar.getInstance();
                    instance3.add(6, 21);
                    return this.f31954a.getMovieUpComming(i2, format4, simpleDateFormat3.format(instance3.getTime())).map(new c()).subscribeOn(Schedulers.c());
                }
            }
        }
        return Observable.empty();
    }

    public Observable<List<MovieEntity>> j0(String str, int i2) {
        return this.f31954a.discoverMoviesByQuery(str, i2).map(new p()).subscribeOn(Schedulers.c());
    }

    public Observable<Video.Response> k0(long j2) {
        return this.f31954a.videos(j2).map(new g());
    }
}

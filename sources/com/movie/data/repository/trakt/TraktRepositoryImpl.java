package com.movie.data.repository.trakt;

import a1.a;
import a1.b;
import a1.c;
import com.database.MvDatabase;
import com.database.entitys.CategoryEntity;
import com.database.entitys.MovieEntity;
import com.database.entitys.UserListEntity;
import com.movie.data.api.trakt.TraktV2Cachced;
import com.movie.data.model.trakt.AnticipatedMovie;
import com.movie.data.model.trakt.AnticipatedShow;
import com.movie.data.model.trakt.BoxOffice;
import com.movie.data.model.trakt.FeatureListResultItem;
import com.movie.data.model.trakt.ListItemItem;
import com.movie.data.model.trakt.MostWatchedAndCollectedMovie;
import com.movie.data.model.trakt.MostWatchedAndCollectedShow;
import com.movie.data.model.trakt.RecommendedMovie;
import com.movie.data.model.trakt.RecommendedShow;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.trakt.TraktHelper;
import com.uwetrottmann.trakt5.entities.ListEntry;
import com.uwetrottmann.trakt5.entities.Movie;
import com.uwetrottmann.trakt5.entities.SearchResult;
import com.uwetrottmann.trakt5.entities.Show;
import com.uwetrottmann.trakt5.entities.TraktList;
import com.uwetrottmann.trakt5.entities.TrendingMovie;
import com.uwetrottmann.trakt5.entities.TrendingShow;
import com.uwetrottmann.trakt5.entities.UserSlug;
import com.uwetrottmann.trakt5.enums.Extended;
import com.uwetrottmann.trakt5.enums.ListPrivacy;
import com.uwetrottmann.trakt5.services.Movies;
import com.uwetrottmann.trakt5.services.Shows;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.joda.time.DateTime;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import retrofit2.Response;

public class TraktRepositoryImpl {

    /* renamed from: a  reason: collision with root package name */
    TraktV2Cachced f31960a = null;

    /* renamed from: b  reason: collision with root package name */
    Shows f31961b = null;

    /* renamed from: c  reason: collision with root package name */
    Movies f31962c = null;

    /* renamed from: d  reason: collision with root package name */
    MvDatabase f31963d;

    /* renamed from: com.movie.data.repository.trakt.TraktRepositoryImpl$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31967a;

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
                f31967a = r0
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.Movie     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31967a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.Show     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31967a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.Episode     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31967a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.database.entitys.CategoryEntity$Type r1 = com.database.entitys.CategoryEntity.Type.MIX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.data.repository.trakt.TraktRepositoryImpl.AnonymousClass10.<clinit>():void");
        }
    }

    public TraktRepositoryImpl(MvDatabase mvDatabase) {
        TraktV2Cachced traktV2Cachced = (TraktV2Cachced) TraktHelper.a();
        this.f31960a = traktV2Cachced;
        this.f31961b = traktV2Cachced.shows();
        this.f31962c = this.f31960a.movies();
        this.f31963d = mvDatabase;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource i(CategoryEntity.Type type, final List list) throws Exception {
        if (type == CategoryEntity.Type.MIX) {
            return Observable.create(new ObservableOnSubscribe<List<CategoryEntity>>() {
                public void subscribe(ObservableEmitter<List<CategoryEntity>> observableEmitter) throws Exception {
                    Response<List<FeatureListResultItem>> execute = TraktRepositoryImpl.this.f31960a.a().popularFeatureList(1, 100).execute();
                    if (execute.isSuccessful() && execute.body() != null) {
                        for (FeatureListResultItem featureListResultItem : execute.body()) {
                            list.add(new CategoryEntity(CategoryEntity.Source.TRAKT, CategoryEntity.Type.MIX, Integer.valueOf(featureListResultItem.getList().getIds().getTrakt()), CategoryEntity.SourceType.FeatureList, featureListResultItem.getList().getName()));
                        }
                        observableEmitter.onNext(list);
                        observableEmitter.onComplete();
                    }
                }
            });
        }
        return Observable.just(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List j(List list) throws Exception {
        this.f31963d.w().a((CategoryEntity[]) list.toArray(new CategoryEntity[list.size()]));
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(String str, ObservableEmitter observableEmitter) throws Exception {
        String str2;
        ArrayList arrayList = new ArrayList();
        Response<List<TraktList>> execute = this.f31960a.users().lists(UserSlug.fromUsername(str)).execute();
        if (execute.isSuccessful()) {
            if (execute.body() != null) {
                for (TraktList traktList : execute.body()) {
                    String str3 = traktList.name;
                    String valueOf = String.valueOf(traktList.ids.trakt);
                    ListPrivacy listPrivacy = traktList.privacy;
                    if (listPrivacy == null) {
                        str2 = "link";
                    } else {
                        str2 = listPrivacy.name();
                    }
                    arrayList.add(new UserListEntity(str3, valueOf, str, str2));
                }
            }
            observableEmitter.onNext(arrayList);
            return;
        }
        throw new Exception("Ensure you have a valid Trakt username and try again.");
    }

    public MovieEntity d(Movie movie) {
        long j2;
        String str;
        double d2;
        if (movie == null || movie.ids == null) {
            return null;
        }
        MovieEntity movieEntity = new MovieEntity();
        Integer num = movie.ids.tmdb;
        long j3 = 0;
        if (num != null) {
            j2 = (long) num.intValue();
        } else {
            j2 = 0;
        }
        movieEntity.setTmdbID(j2);
        movieEntity.setImdbIDStr(movie.ids.imdb);
        Integer num2 = movie.ids.trakt;
        if (num2 != null) {
            j3 = (long) num2.intValue();
        }
        movieEntity.setTraktID(j3);
        movieEntity.setGenres(movie.genres);
        movieEntity.setName(movie.title);
        movieEntity.setOverview(movie.overview);
        LocalDate localDate = movie.released;
        if (localDate != null) {
            str = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            str = String.valueOf(movie.year) + "-1-1";
        }
        movieEntity.setRealeaseDate(str);
        movieEntity.setTV(Boolean.FALSE);
        Double d3 = movie.rating;
        if (d3 != null) {
            d2 = d3.doubleValue();
        } else {
            d2 = 0.0d;
        }
        movieEntity.setVote(Double.valueOf(d2));
        return movieEntity;
    }

    public MovieEntity e(Show show) {
        long j2;
        String str;
        double d2;
        if (show == null || show.ids == null) {
            return null;
        }
        MovieEntity movieEntity = new MovieEntity();
        Integer num = show.ids.tmdb;
        long j3 = 0;
        if (num != null) {
            j2 = (long) num.intValue();
        } else {
            j2 = 0;
        }
        movieEntity.setTmdbID(j2);
        movieEntity.setImdbIDStr(show.ids.imdb);
        movieEntity.setTraktID((long) show.ids.trakt.intValue());
        Integer num2 = show.ids.tvdb;
        if (num2 != null) {
            j3 = (long) num2.intValue();
        }
        movieEntity.setTvdbID(j3);
        movieEntity.setGenres(show.genres);
        movieEntity.setName(show.title);
        movieEntity.setOverview(show.overview);
        OffsetDateTime offsetDateTime = show.first_aired;
        if (offsetDateTime != null) {
            str = DateTimeHelper.h(new DateTime(offsetDateTime.toInstant().toEpochMilli()));
        } else {
            str = "1970-1-1";
        }
        movieEntity.setRealeaseDate(str);
        movieEntity.setTV(Boolean.TRUE);
        Double d3 = show.rating;
        if (d3 != null) {
            d2 = d3.doubleValue();
        } else {
            d2 = 0.0d;
        }
        movieEntity.setVote(Double.valueOf(d2));
        return movieEntity;
    }

    public boolean f(String str, String str2) throws IOException {
        return this.f31960a.users().deleteList(UserSlug.fromUsername(str), str2).execute().isSuccessful();
    }

    public Observable<List<CategoryEntity>> g(final CategoryEntity.Type type) {
        return Observable.create(new ObservableOnSubscribe<List<CategoryEntity>>() {
            public void subscribe(ObservableEmitter<List<CategoryEntity>> observableEmitter) throws Exception {
                observableEmitter.onNext(TraktRepositoryImpl.this.h(type));
            }
        }).flatMap(new a(this, type)).map(new b(this));
    }

    /* access modifiers changed from: package-private */
    public List<CategoryEntity> h(CategoryEntity.Type type) {
        ArrayList arrayList = new ArrayList();
        int i2 = AnonymousClass10.f31967a[type.ordinal()];
        if (i2 == 1) {
            CategoryEntity.Source source = CategoryEntity.Source.TRAKT;
            Integer valueOf = Integer.valueOf(CategoryEntity.Generic.Trending.getValue());
            CategoryEntity.SourceType sourceType = CategoryEntity.SourceType.Generic;
            arrayList.add(new CategoryEntity(source, type, valueOf, sourceType, "Trending"));
            CategoryEntity.Source source2 = source;
            CategoryEntity.Type type2 = type;
            CategoryEntity.SourceType sourceType2 = sourceType;
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.Popular.getValue()), sourceType2, "Popular"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.Recommmended.getValue()), sourceType2, "The most Recommmended"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.Watched.getValue()), sourceType2, "The most Watched"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.Collected.getValue()), sourceType2, "The most Collected"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.Anticipated.getValue()), sourceType2, "The most Anticipated"));
            arrayList.add(new CategoryEntity(source2, type2, Integer.valueOf(CategoryEntity.Generic.BoxOffice.getValue()), sourceType2, "The weekend Box Office"));
        } else if (i2 == 2) {
            CategoryEntity.Source source3 = CategoryEntity.Source.TRAKT;
            Integer valueOf2 = Integer.valueOf(CategoryEntity.Generic.Trending.getValue());
            CategoryEntity.SourceType sourceType3 = CategoryEntity.SourceType.Generic;
            arrayList.add(new CategoryEntity(source3, type, valueOf2, sourceType3, "Trending"));
            CategoryEntity.Source source4 = source3;
            CategoryEntity.Type type3 = type;
            CategoryEntity.SourceType sourceType4 = sourceType3;
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.Popular.getValue()), sourceType4, "Popular"));
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.Watched.getValue()), sourceType4, "The most Watched"));
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.Collected.getValue()), sourceType4, "The most Collected"));
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.Recommmended.getValue()), sourceType4, "The most Recommmended"));
            arrayList.add(new CategoryEntity(source4, type3, Integer.valueOf(CategoryEntity.Generic.Anticipated.getValue()), sourceType4, "The most Anticipated"));
        }
        return arrayList;
    }

    public Observable<List<MovieEntity>> l(final CategoryEntity categoryEntity, final int i2) {
        return Observable.create(new ObservableOnSubscribe<List<MovieEntity>>() {
            public void subscribe(ObservableEmitter<List<MovieEntity>> observableEmitter) throws Exception {
                Response<List<ListItemItem>> execute = TraktRepositoryImpl.this.f31960a.a().featureListItems(String.valueOf(categoryEntity.getId()), i2, 20).execute();
                if (!execute.isSuccessful() || execute.body() == null) {
                    throw new TraktListException("This Trakt list might be set to private. To view and share your list, ensure it's set to public in your Trakt lists settings." + execute.message());
                }
                ArrayList arrayList = new ArrayList();
                for (ListItemItem listItemItem : execute.body()) {
                    if (listItemItem.getShow() != null) {
                        arrayList.add(TraktRepositoryImpl.this.e(listItemItem.getShow()));
                    }
                    if (listItemItem.getMovie() != null) {
                        arrayList.add(TraktRepositoryImpl.this.d(listItemItem.getMovie()));
                    }
                }
                observableEmitter.onNext(arrayList);
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }

    public Observable<List<MovieEntity>> m(final CategoryEntity categoryEntity, final int i2) {
        return Observable.create(new ObservableOnSubscribe<List<MovieEntity>>() {
            public void subscribe(ObservableEmitter<List<MovieEntity>> observableEmitter) throws Exception {
                if (categoryEntity.getType() == CategoryEntity.Type.Show) {
                    if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Trending.getValue()) {
                        Response<List<TrendingShow>> execute = TraktRepositoryImpl.this.f31961b.trending(Integer.valueOf(i2), 20, Extended.FULL).execute();
                        if (execute.isSuccessful() && execute.body() != null) {
                            ArrayList arrayList = new ArrayList();
                            for (TrendingShow trendingShow : execute.body()) {
                                arrayList.add(TraktRepositoryImpl.this.e(trendingShow.show));
                            }
                            observableEmitter.onNext(arrayList);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Popular.getValue()) {
                        Response<List<Show>> execute2 = TraktRepositoryImpl.this.f31961b.popular(Integer.valueOf(i2), 20, Extended.FULL).execute();
                        if (execute2.isSuccessful() && execute2.body() != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Show e2 : execute2.body()) {
                                arrayList2.add(TraktRepositoryImpl.this.e(e2));
                            }
                            observableEmitter.onNext(arrayList2);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Recommmended.getValue()) {
                        Response<List<RecommendedShow>> execute3 = TraktRepositoryImpl.this.f31960a.a().recommendedShow(i2, 20).execute();
                        if (execute3.isSuccessful() && execute3.body() != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (RecommendedShow show : execute3.body()) {
                                arrayList3.add(TraktRepositoryImpl.this.e(show.getShow()));
                            }
                            observableEmitter.onNext(arrayList3);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Watched.getValue()) {
                        Response<List<MostWatchedAndCollectedShow>> execute4 = TraktRepositoryImpl.this.f31960a.a().mostWatchedShow(i2, 20).execute();
                        if (execute4.isSuccessful() && execute4.body() != null) {
                            ArrayList arrayList4 = new ArrayList();
                            for (MostWatchedAndCollectedShow show2 : execute4.body()) {
                                arrayList4.add(TraktRepositoryImpl.this.e(show2.getShow()));
                            }
                            observableEmitter.onNext(arrayList4);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Collected.getValue()) {
                        Response<List<MostWatchedAndCollectedShow>> execute5 = TraktRepositoryImpl.this.f31960a.a().mostCollectedShow(i2, 20).execute();
                        if (execute5.isSuccessful() && execute5.body() != null) {
                            ArrayList arrayList5 = new ArrayList();
                            for (MostWatchedAndCollectedShow show3 : execute5.body()) {
                                arrayList5.add(TraktRepositoryImpl.this.e(show3.getShow()));
                            }
                            observableEmitter.onNext(arrayList5);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Anticipated.getValue()) {
                        Response<List<AnticipatedShow>> execute6 = TraktRepositoryImpl.this.f31960a.a().anticipatedShows(i2, 20).execute();
                        if (execute6.isSuccessful() && execute6.body() != null) {
                            ArrayList arrayList6 = new ArrayList();
                            for (AnticipatedShow show4 : execute6.body()) {
                                arrayList6.add(TraktRepositoryImpl.this.e(show4.getShow()));
                            }
                            observableEmitter.onNext(arrayList6);
                        }
                    }
                } else if (categoryEntity.getType() == CategoryEntity.Type.Movie) {
                    if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Trending.getValue()) {
                        Response<List<TrendingMovie>> execute7 = TraktRepositoryImpl.this.f31960a.movies().trending(Integer.valueOf(i2), 20, Extended.FULL).execute();
                        if (execute7.isSuccessful() && execute7.body() != null) {
                            ArrayList arrayList7 = new ArrayList();
                            for (TrendingMovie trendingMovie : execute7.body()) {
                                arrayList7.add(TraktRepositoryImpl.this.d(trendingMovie.movie));
                            }
                            observableEmitter.onNext(arrayList7);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Popular.getValue()) {
                        Response<List<Movie>> execute8 = TraktRepositoryImpl.this.f31960a.movies().popular(Integer.valueOf(i2), 20, Extended.FULL).execute();
                        if (execute8.isSuccessful() && execute8.body() != null) {
                            ArrayList arrayList8 = new ArrayList();
                            for (Movie d2 : execute8.body()) {
                                arrayList8.add(TraktRepositoryImpl.this.d(d2));
                            }
                            observableEmitter.onNext(arrayList8);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Recommmended.getValue()) {
                        Response<List<RecommendedMovie>> execute9 = TraktRepositoryImpl.this.f31960a.a().recommendedMovie(i2, 20).execute();
                        if (execute9.isSuccessful() && execute9.body() != null) {
                            ArrayList arrayList9 = new ArrayList();
                            for (RecommendedMovie movie : execute9.body()) {
                                arrayList9.add(TraktRepositoryImpl.this.d(movie.getMovie()));
                            }
                            observableEmitter.onNext(arrayList9);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Watched.getValue()) {
                        Response<List<MostWatchedAndCollectedMovie>> execute10 = TraktRepositoryImpl.this.f31960a.a().mostWatchedMovie(i2, 20).execute();
                        if (execute10.isSuccessful() && execute10.body() != null) {
                            ArrayList arrayList10 = new ArrayList();
                            for (MostWatchedAndCollectedMovie movie2 : execute10.body()) {
                                arrayList10.add(TraktRepositoryImpl.this.d(movie2.getMovie()));
                            }
                            observableEmitter.onNext(arrayList10);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Collected.getValue()) {
                        Response<List<MostWatchedAndCollectedMovie>> execute11 = TraktRepositoryImpl.this.f31960a.a().mostCollectedMovie(i2, 20).execute();
                        if (execute11.isSuccessful() && execute11.body() != null) {
                            ArrayList arrayList11 = new ArrayList();
                            for (MostWatchedAndCollectedMovie movie3 : execute11.body()) {
                                arrayList11.add(TraktRepositoryImpl.this.d(movie3.getMovie()));
                            }
                            observableEmitter.onNext(arrayList11);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.Anticipated.getValue()) {
                        Response<List<AnticipatedMovie>> execute12 = TraktRepositoryImpl.this.f31960a.a().anticipatedMovies(i2, 20).execute();
                        if (execute12.isSuccessful() && execute12.body() != null) {
                            ArrayList arrayList12 = new ArrayList();
                            for (AnticipatedMovie movie4 : execute12.body()) {
                                arrayList12.add(TraktRepositoryImpl.this.d(movie4.getMovie()));
                            }
                            observableEmitter.onNext(arrayList12);
                        }
                    } else if (categoryEntity.getId().intValue() == CategoryEntity.Generic.BoxOffice.getValue()) {
                        Response<List<BoxOffice>> execute13 = TraktRepositoryImpl.this.f31960a.a().boxOffice(i2, 20).execute();
                        if (execute13.isSuccessful() && execute13.body() != null) {
                            ArrayList arrayList13 = new ArrayList();
                            for (BoxOffice movie5 : execute13.body()) {
                                arrayList13.add(TraktRepositoryImpl.this.d(movie5.getMovie()));
                            }
                            observableEmitter.onNext(arrayList13);
                        }
                    }
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }

    public Observable<List<UserListEntity>> n(String str) {
        return Observable.create(new c(this, str));
    }

    public Observable<List<MovieEntity>> o(final CategoryEntity categoryEntity, final int i2) {
        return Observable.create(new ObservableOnSubscribe<List<MovieEntity>>() {
            /* access modifiers changed from: private */
            public static /* synthetic */ int c(ListEntry listEntry, ListEntry listEntry2) {
                return listEntry.rank.intValue() > listEntry2.rank.intValue() ? -1 : 1;
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ int d(ListEntry listEntry, ListEntry listEntry2) {
                return listEntry.listed_at.toEpochSecond() < listEntry2.listed_at.toEpochSecond() ? -1 : 1;
            }

            public void subscribe(ObservableEmitter<List<MovieEntity>> observableEmitter) throws Exception {
                String str;
                if (i2 > 1) {
                    observableEmitter.onNext(new ArrayList());
                } else {
                    String str2 = categoryEntity.extras.get("userName");
                    if (categoryEntity.extras.containsKey("sort_by")) {
                        str = categoryEntity.extras.get("sort_by");
                    } else {
                        str = "added";
                    }
                    String valueOf = String.valueOf(categoryEntity.getId());
                    if (str2 != null) {
                        if (categoryEntity.getId().intValue() <= 0) {
                            valueOf = categoryEntity.extras.get("listSlug");
                        }
                        Response<List<ListEntry>> execute = TraktRepositoryImpl.this.f31960a.users().listItems(UserSlug.fromUsername(str2), valueOf, Extended.FULL).execute();
                        if (execute.isSuccessful() && execute.body() != null) {
                            List<ListEntry> body = execute.body();
                            if (Objects.equals(str, "rank")) {
                                Collections.sort(body, new a());
                            } else {
                                Collections.sort(body, new b());
                            }
                            ArrayList arrayList = new ArrayList();
                            for (ListEntry listEntry : body) {
                                Show show = listEntry.show;
                                if (show != null) {
                                    arrayList.add(TraktRepositoryImpl.this.e(show));
                                }
                                Movie movie = listEntry.movie;
                                if (movie != null) {
                                    arrayList.add(TraktRepositoryImpl.this.d(movie));
                                }
                            }
                            observableEmitter.onNext(arrayList);
                        } else if (execute.code() == 401) {
                            throw new TraktListException("401 Unauthorized Access");
                        } else {
                            throw new TraktListException("This Trakt list might be set to private. To view and share your list, ensure it's set to public in your Trakt lists settings." + execute.message());
                        }
                    } else {
                        throw new Exception("Ensure you have a valid Trakt username and try again.");
                    }
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }

    public Observable<List<MovieEntity>> p(final String str, final int i2) {
        return Observable.create(new ObservableOnSubscribe<List<MovieEntity>>() {
            public void subscribe(ObservableEmitter<List<MovieEntity>> observableEmitter) throws Exception {
                MovieEntity movieEntity;
                Response<List<SearchResult>> execute = TraktRepositoryImpl.this.f31960a.a().searchAll("movie,show", str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Extended) null, Integer.valueOf(i2), 20).execute();
                if (execute.isSuccessful()) {
                    ArrayList arrayList = new ArrayList();
                    if (execute.body() != null) {
                        for (SearchResult searchResult : execute.body()) {
                            Movie movie = searchResult.movie;
                            if (movie != null) {
                                movieEntity = TraktRepositoryImpl.this.d(movie);
                            } else {
                                Show show = searchResult.show;
                                if (show != null) {
                                    movieEntity = TraktRepositoryImpl.this.e(show);
                                } else {
                                    movieEntity = null;
                                }
                            }
                            if (movieEntity != null) {
                                arrayList.add(movieEntity);
                            }
                        }
                    }
                    observableEmitter.onNext(arrayList);
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }
}

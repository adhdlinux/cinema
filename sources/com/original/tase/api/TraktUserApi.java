package com.original.tase.api;

import android.app.Activity;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.original.tase.Logger;
import com.original.tase.RxBus;
import com.original.tase.event.trakt.TrackSyncFaild;
import com.original.tase.event.trakt.TraktSyncSuccess;
import com.original.tase.event.trakt.TraktSyncType;
import com.original.tase.event.trakt.TraktWaitingToVerifyEvent;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.original.tase.helper.trakt.TraktHelper;
import com.original.tase.model.trakt.TraktCredentialsInfo;
import com.original.tase.model.trakt.TraktGetDeviceCodeResult;
import com.original.tase.model.trakt.TraktGetTokenResult;
import com.original.tase.model.trakt.TraktUserInfo;
import com.utils.Utils;
import com.uwetrottmann.trakt5.TraktV2;
import com.uwetrottmann.trakt5.entities.BaseEpisode;
import com.uwetrottmann.trakt5.entities.BaseMovie;
import com.uwetrottmann.trakt5.entities.BaseSeason;
import com.uwetrottmann.trakt5.entities.BaseShow;
import com.uwetrottmann.trakt5.entities.CalendarShowEntry;
import com.uwetrottmann.trakt5.entities.MovieIds;
import com.uwetrottmann.trakt5.entities.ShowIds;
import com.uwetrottmann.trakt5.entities.SyncEpisode;
import com.uwetrottmann.trakt5.entities.SyncItems;
import com.uwetrottmann.trakt5.entities.SyncMovie;
import com.uwetrottmann.trakt5.entities.SyncResponse;
import com.uwetrottmann.trakt5.entities.SyncSeason;
import com.uwetrottmann.trakt5.entities.SyncShow;
import com.uwetrottmann.trakt5.entities.UserSlug;
import com.uwetrottmann.trakt5.enums.Extended;
import com.uwetrottmann.trakt5.services.Sync;
import com.yoku.marumovie.R;
import d1.a;
import d1.b;
import d1.c;
import d1.d;
import d1.e;
import d1.f;
import d1.g;
import d1.h;
import d1.i;
import d1.j;
import d1.k;
import d1.l;
import d1.m;
import d1.n;
import d1.o;
import d1.p;
import d1.q;
import d1.r;
import d1.s;
import d1.t;
import d1.u;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import retrofit2.Call;

public class TraktUserApi {

    /* renamed from: b  reason: collision with root package name */
    private static volatile TraktUserApi f33771b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Hashtable<String, String> f33772a;

    private TraktUserApi() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        this.f33772a = hashtable;
        hashtable.put(TraktV2.HEADER_CONTENT_TYPE, TraktV2.CONTENT_TYPE_JSON);
        hashtable.put(TraktV2.HEADER_TRAKT_API_KEY, "9d67bbba437a1e94273db1f54b56fb84ff616b66db7e47c309bc19ccdf954c89");
        hashtable.put(TraktV2.HEADER_TRAKT_API_VERSION, String.valueOf(2));
        TraktCredentialsInfo b2 = TraktCredentialsHelper.b();
        if (b2.isValid()) {
            hashtable.put("Authorization", "Bearer " + b2.getAccessToken());
        }
    }

    public static MovieEntity A(BaseShow baseShow) {
        String str;
        long j2;
        long j3;
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(baseShow.show.title);
        OffsetDateTime offsetDateTime = baseShow.show.first_aired;
        if (offsetDateTime != null) {
            str = offsetDateTime.toString();
        } else {
            str = "1970-1-1";
        }
        movieEntity.setRealeaseDate(str);
        movieEntity.setGenres(baseShow.show.genres);
        movieEntity.setTV(Boolean.TRUE);
        Integer num = baseShow.show.ids.tmdb;
        long j4 = 0;
        if (num != null) {
            j2 = (long) num.intValue();
        } else {
            j2 = 0;
        }
        movieEntity.setTmdbID(j2);
        movieEntity.setImdbIDStr(baseShow.show.ids.imdb);
        Integer num2 = baseShow.show.ids.trakt;
        if (num2 != null) {
            j3 = (long) num2.intValue();
        } else {
            j3 = 0;
        }
        movieEntity.setTraktID(j3);
        Integer num3 = baseShow.show.ids.tvdb;
        if (num3 != null) {
            j4 = (long) num3.intValue();
        }
        movieEntity.setTvdbID(j4);
        movieEntity.setVote(baseShow.show.rating);
        movieEntity.setOverview(baseShow.show.overview);
        OffsetDateTime offsetDateTime2 = baseShow.last_watched_at;
        if (offsetDateTime2 != null) {
            movieEntity.setWatched_at(offsetDateTime2);
        }
        OffsetDateTime offsetDateTime3 = baseShow.last_collected_at;
        if (offsetDateTime3 != null) {
            movieEntity.setCollected_at(offsetDateTime3);
        }
        return movieEntity;
    }

    public static TraktUserApi M() {
        if (f33771b == null) {
            synchronized (TraktUserApi.class) {
                f33771b = new TraktUserApi();
            }
        }
        return f33771b;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List N(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(z((BaseMovie) it2.next()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean O(MvDatabase mvDatabase, String str, List list) throws Exception {
        boolean z2;
        List<MovieEntity> j2 = mvDatabase.A().j(false);
        ArrayList arrayList = new ArrayList();
        if (str.equals("Merge")) {
            for (MovieEntity next : j2) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (x(next, (MovieEntity) it2.next())) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
                o0(arrayList);
            }
        }
        mvDatabase.A().b((MovieEntity[]) list.toArray(new MovieEntity[list.size()]));
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List P(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(A((BaseShow) it2.next()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean Q(MvDatabase mvDatabase, String str, List list) throws Exception {
        boolean z2;
        List<MovieEntity> j2 = mvDatabase.A().j(true);
        ArrayList arrayList = new ArrayList();
        if (str.equals("Merge")) {
            for (MovieEntity next : j2) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (x(next, (MovieEntity) it2.next())) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
                p0(arrayList, mvDatabase);
            }
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            MovieEntity movieEntity = (MovieEntity) it3.next();
            try {
                mvDatabase.A().b(movieEntity);
            } catch (Exception e2) {
                System.out.println(e2.fillInStackTrace());
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean R(MvDatabase mvDatabase, String str, List list) throws Exception {
        List<MovieEntity> d2 = mvDatabase.A().d(Boolean.FALSE);
        if (str.equals("Merge")) {
            ArrayList arrayList = new ArrayList();
            for (MovieEntity next : d2) {
                Iterator it2 = list.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    if (x(next, (MovieEntity) it2.next())) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
            }
            s0(arrayList, true);
        } else {
            for (MovieEntity watched_at : d2) {
                watched_at.setWatched_at((OffsetDateTime) null);
            }
            mvDatabase.A().b((MovieEntity[]) d2.toArray(new MovieEntity[d2.size()]));
        }
        mvDatabase.A().b((MovieEntity[]) list.toArray(new MovieEntity[list.size()]));
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void S(Activity activity, Throwable th) throws Exception {
        Utils.h0(activity, R.string.failed_sync_trakt);
        RxBus.a().b(new TrackSyncFaild(TraktSyncType.ALL));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void X(Activity activity, Boolean bool) throws Exception {
        Utils.h0(activity, R.string.sucess_sync_trakt);
        RxBus.a().b(new TraktSyncSuccess(TraktSyncType.ALL));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a0(Boolean bool) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b0(Activity activity, Throwable th) throws Exception {
        Utils.h0(activity, R.string.failed_sync_trakt);
        RxBus.a().b(new TrackSyncFaild(TraktSyncType.FAVORITES));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c0(Activity activity) throws Exception {
        Utils.h0(activity, R.string.sucess_sync_trakt);
        RxBus.a().b(new TraktSyncSuccess(TraktSyncType.FAVORITES));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f0(Boolean bool) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g0(Activity activity, Throwable th) throws Exception {
        Utils.h0(activity, R.string.failed_sync_trakt);
        RxBus.a().b(new TrackSyncFaild(TraktSyncType.HISTORY));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h0(Activity activity) throws Exception {
        Utils.h0(activity, R.string.sucess_sync_trakt);
        RxBus.a().b(new TraktSyncSuccess(TraktSyncType.HISTORY));
    }

    public static MovieEntity z(BaseMovie baseMovie) {
        String str;
        long j2;
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(baseMovie.movie.title);
        LocalDate localDate = baseMovie.movie.released;
        if (localDate != null) {
            str = localDate.toString();
        } else {
            str = "1970-1-1";
        }
        movieEntity.setRealeaseDate(str);
        movieEntity.setGenres(baseMovie.movie.genres);
        movieEntity.setTV(Boolean.FALSE);
        Integer num = baseMovie.movie.ids.tmdb;
        long j3 = 0;
        if (num != null) {
            j2 = (long) num.intValue();
        } else {
            j2 = 0;
        }
        movieEntity.setTmdbID(j2);
        movieEntity.setImdbIDStr(baseMovie.movie.ids.imdb);
        Integer num2 = baseMovie.movie.ids.trakt;
        if (num2 != null) {
            j3 = (long) num2.intValue();
        }
        movieEntity.setTraktID(j3);
        movieEntity.setVote(baseMovie.movie.rating);
        movieEntity.setOverview(baseMovie.movie.overview);
        Integer num3 = baseMovie.movie.runtime;
        if (num3 != null) {
            movieEntity.setDuration((long) (num3.intValue() * 60 * 1000));
        }
        OffsetDateTime offsetDateTime = baseMovie.last_watched_at;
        if (offsetDateTime != null) {
            movieEntity.setWatched_at(offsetDateTime);
        }
        OffsetDateTime offsetDateTime2 = baseMovie.collected_at;
        if (offsetDateTime2 != null) {
            movieEntity.setCollected_at(offsetDateTime2);
        }
        return movieEntity;
    }

    public List<CalendarShowEntry> B(String str) throws IOException {
        return TraktHelper.a().calendars().shows(str, 1).execute().body();
    }

    public Observable<Boolean> C(MvDatabase mvDatabase, String str) {
        return Observable.create(new ObservableOnSubscribe<List<BaseMovie>>() {
            public void subscribe(ObservableEmitter<List<BaseMovie>> observableEmitter) throws Exception {
                List<BaseMovie> E = TraktUserApi.M().E();
                if (E != null) {
                    observableEmitter.onNext(E);
                }
                observableEmitter.onComplete();
            }
        }).map(new k()).subscribeOn(Schedulers.c()).map(new m(this, mvDatabase, str));
    }

    public Observable<Boolean> D(MvDatabase mvDatabase, String str) {
        return Observable.create(new ObservableOnSubscribe<List<BaseShow>>() {
            public void subscribe(ObservableEmitter<List<BaseShow>> observableEmitter) throws Exception {
                List<BaseShow> H = TraktUserApi.M().H();
                if (H != null) {
                    observableEmitter.onNext(H);
                }
                observableEmitter.onComplete();
            }
        }).map(new c()).map(new d(this, mvDatabase, str)).subscribeOn(Schedulers.c());
    }

    public List<BaseMovie> E() throws IOException {
        return TraktHelper.a().sync().collectionMovies(Extended.FULL).execute().body();
    }

    public Observable<Boolean> F(MvDatabase mvDatabase, String str) {
        return Observable.create(new ObservableOnSubscribe<List<MovieEntity>>() {
            public void subscribe(ObservableEmitter<List<MovieEntity>> observableEmitter) throws Exception {
                List<BaseMovie> J = TraktUserApi.M().J();
                if (J != null) {
                    ArrayList arrayList = new ArrayList();
                    for (BaseMovie z2 : J) {
                        arrayList.add(TraktUserApi.z(z2));
                    }
                    observableEmitter.onNext(arrayList);
                }
                observableEmitter.onComplete();
            }
        }).map(new j(this, mvDatabase, str)).subscribeOn(Schedulers.c());
    }

    public List<CalendarShowEntry> G(String str) throws IOException {
        return TraktHelper.a().calendars().myShows(str, 1).execute().body();
    }

    public List<BaseShow> H() throws IOException {
        return TraktHelper.a().sync().collectionShows(Extended.FULL).execute().body();
    }

    public Observable<Boolean> I(final MvDatabase mvDatabase, final String str) {
        return Observable.create(new ObservableOnSubscribe<List<BaseShow>>() {
            public void subscribe(ObservableEmitter<List<BaseShow>> observableEmitter) throws Exception {
                List<BaseShow> K = TraktUserApi.M().K();
                if (K != null) {
                    observableEmitter.onNext(K);
                }
                observableEmitter.onComplete();
            }
        }).map(new Function<List<BaseShow>, Boolean>() {
            /* renamed from: a */
            public Boolean apply(List<BaseShow> list) throws Exception {
                long j2;
                long j3;
                ArrayList arrayList = new ArrayList();
                ArrayList<TvWatchedEpisode> arrayList2 = new ArrayList<>();
                for (BaseShow next : list) {
                    arrayList.add(TraktUserApi.A(next));
                    for (BaseSeason next2 : next.seasons) {
                        for (BaseEpisode baseEpisode : next2.episodes) {
                            TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
                            tvWatchedEpisode.m(baseEpisode.number.intValue());
                            tvWatchedEpisode.q(next2.number.intValue());
                            Integer num = next.show.ids.tmdb;
                            long j4 = 0;
                            if (num != null) {
                                j2 = (long) num.intValue();
                            } else {
                                j2 = 0;
                            }
                            tvWatchedEpisode.s(j2);
                            tvWatchedEpisode.o(next.show.ids.imdb);
                            Integer num2 = next.show.ids.tvdb;
                            if (num2 != null) {
                                j3 = (long) num2.intValue();
                            } else {
                                j3 = 0;
                            }
                            tvWatchedEpisode.u(j3);
                            Integer num3 = next.show.ids.trakt;
                            if (num3 != null) {
                                j4 = (long) num3.intValue();
                            }
                            tvWatchedEpisode.t(j4);
                            arrayList2.add(tvWatchedEpisode);
                        }
                    }
                }
                List<TvWatchedEpisode> k2 = mvDatabase.E().k();
                if (str.contains("Merge")) {
                    ArrayList arrayList3 = new ArrayList();
                    for (TvWatchedEpisode next3 : k2) {
                        boolean z2 = false;
                        for (TvWatchedEpisode y2 : arrayList2) {
                            if (TraktUserApi.this.y(next3, y2)) {
                                z2 = true;
                            }
                        }
                        if (!z2) {
                            arrayList3.add(next3);
                        }
                    }
                    TraktUserApi.this.n0(arrayList3, true, mvDatabase);
                }
                mvDatabase.A().b((MovieEntity[]) arrayList.toArray(new MovieEntity[arrayList.size()]));
                mvDatabase.E().l((TvWatchedEpisode[]) arrayList2.toArray(new TvWatchedEpisode[arrayList2.size()]));
                return Boolean.TRUE;
            }
        }).subscribeOn(Schedulers.c());
    }

    public List<BaseMovie> J() throws IOException {
        return TraktHelper.a().users().watchedMovies(UserSlug.ME, Extended.FULL).execute().body();
    }

    public List<BaseShow> K() throws IOException {
        return TraktHelper.a().users().watchedShows(UserSlug.ME, Extended.FULL).execute().body();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0053 A[EDGE_INSN: B:82:0x0053->B:13:0x0053 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.uwetrottmann.trakt5.entities.SyncShow> L(java.util.List<com.database.entitys.TvWatchedEpisode> r14, com.database.MvDatabase r15) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r14.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x00c4
            java.lang.Object r2 = r1.next()
            com.database.entitys.TvWatchedEpisode r2 = (com.database.entitys.TvWatchedEpisode) r2
            java.util.Iterator r4 = r0.iterator()
        L_0x001a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0053
            java.lang.Object r5 = r4.next()
            com.uwetrottmann.trakt5.entities.SyncShow r5 = (com.uwetrottmann.trakt5.entities.SyncShow) r5
            com.uwetrottmann.trakt5.entities.ShowIds r6 = r5.ids
            java.lang.String r6 = r6.imdb
            java.lang.String r7 = r2.d()
            if (r6 == r7) goto L_0x0052
            com.uwetrottmann.trakt5.entities.ShowIds r6 = r5.ids
            java.lang.Integer r6 = r6.tmdb
            int r6 = r6.intValue()
            long r6 = (long) r6
            long r8 = r2.h()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0052
            com.uwetrottmann.trakt5.entities.ShowIds r6 = r5.ids
            java.lang.Integer r6 = r6.tvdb
            int r6 = r6.intValue()
            long r6 = (long) r6
            long r8 = r2.j()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x001a
        L_0x0052:
            r3 = r5
        L_0x0053:
            if (r3 != 0) goto L_0x0009
            com.uwetrottmann.trakt5.entities.ShowIds r3 = new com.uwetrottmann.trakt5.entities.ShowIds
            r3.<init>()
            java.lang.String r4 = r2.d()
            r3.imdb = r4
            long r4 = r2.h()
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0075
            long r4 = r2.h()
            int r5 = (int) r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r3.tmdb = r4
        L_0x0075:
            long r4 = r2.j()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0088
            long r4 = r2.j()
            int r2 = (int) r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.tvdb = r2
        L_0x0088:
            com.uwetrottmann.trakt5.entities.SyncShow r2 = new com.uwetrottmann.trakt5.entities.SyncShow
            r2.<init>()
            com.uwetrottmann.trakt5.entities.SyncShow r2 = r2.id(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r2.seasons = r4
            com.database.daos.MovieDAO r5 = r15.A()     // Catch:{ Exception -> 0x00bf }
            java.lang.Integer r4 = r3.tmdb     // Catch:{ Exception -> 0x00bf }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00bf }
            long r6 = (long) r4     // Catch:{ Exception -> 0x00bf }
            java.lang.String r8 = r3.imdb     // Catch:{ Exception -> 0x00bf }
            java.lang.Integer r4 = r3.trakt     // Catch:{ Exception -> 0x00bf }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00bf }
            long r9 = (long) r4     // Catch:{ Exception -> 0x00bf }
            java.lang.Integer r3 = r3.tvdb     // Catch:{ Exception -> 0x00bf }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00bf }
            long r11 = (long) r3     // Catch:{ Exception -> 0x00bf }
            com.database.entitys.MovieEntity r3 = r5.l(r6, r8, r9, r11)     // Catch:{ Exception -> 0x00bf }
            if (r3 == 0) goto L_0x00bf
            org.threeten.bp.OffsetDateTime r3 = r3.getCollected_at()     // Catch:{ Exception -> 0x00bf }
            r2.collected_at = r3     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            r0.add(r2)
            goto L_0x0009
        L_0x00c4:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r15 = r14.iterator()
        L_0x00cd:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0154
            java.lang.Object r1 = r15.next()
            com.database.entitys.TvWatchedEpisode r1 = (com.database.entitys.TvWatchedEpisode) r1
            java.util.Iterator r2 = r0.iterator()
        L_0x00dd:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0116
            java.lang.Object r4 = r2.next()
            com.uwetrottmann.trakt5.entities.SyncShow r4 = (com.uwetrottmann.trakt5.entities.SyncShow) r4
            com.uwetrottmann.trakt5.entities.ShowIds r5 = r4.ids
            java.lang.String r5 = r5.imdb
            java.lang.String r6 = r1.d()
            if (r5 == r6) goto L_0x0117
            com.uwetrottmann.trakt5.entities.ShowIds r5 = r4.ids
            java.lang.Integer r5 = r5.tmdb
            int r5 = r5.intValue()
            long r5 = (long) r5
            long r7 = r1.h()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0117
            com.uwetrottmann.trakt5.entities.ShowIds r5 = r4.ids
            java.lang.Integer r5 = r5.tvdb
            int r5 = r5.intValue()
            long r5 = (long) r5
            long r7 = r1.j()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00dd
            goto L_0x0117
        L_0x0116:
            r4 = r3
        L_0x0117:
            java.util.List<com.uwetrottmann.trakt5.entities.SyncSeason> r2 = r4.seasons
            java.util.Iterator r2 = r2.iterator()
        L_0x011d:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0136
            java.lang.Object r5 = r2.next()
            com.uwetrottmann.trakt5.entities.SyncSeason r5 = (com.uwetrottmann.trakt5.entities.SyncSeason) r5
            java.lang.Integer r6 = r5.number
            int r6 = r6.intValue()
            int r7 = r1.f()
            if (r6 != r7) goto L_0x011d
            goto L_0x0137
        L_0x0136:
            r5 = r3
        L_0x0137:
            if (r5 != 0) goto L_0x00cd
            com.uwetrottmann.trakt5.entities.SyncSeason r2 = new com.uwetrottmann.trakt5.entities.SyncSeason
            r2.<init>()
            int r1 = r1.f()
            com.uwetrottmann.trakt5.entities.SyncSeason r1 = r2.number(r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.episodes = r2
            java.util.List<com.uwetrottmann.trakt5.entities.SyncSeason> r2 = r4.seasons
            r2.add(r1)
            goto L_0x00cd
        L_0x0154:
            java.util.Iterator r14 = r14.iterator()
        L_0x0158:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x01f8
            java.lang.Object r15 = r14.next()
            com.database.entitys.TvWatchedEpisode r15 = (com.database.entitys.TvWatchedEpisode) r15
            java.util.Iterator r1 = r0.iterator()
        L_0x0168:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01a1
            java.lang.Object r2 = r1.next()
            com.uwetrottmann.trakt5.entities.SyncShow r2 = (com.uwetrottmann.trakt5.entities.SyncShow) r2
            com.uwetrottmann.trakt5.entities.ShowIds r4 = r2.ids
            java.lang.String r4 = r4.imdb
            java.lang.String r5 = r15.d()
            if (r4 == r5) goto L_0x01a2
            com.uwetrottmann.trakt5.entities.ShowIds r4 = r2.ids
            java.lang.Integer r4 = r4.tmdb
            int r4 = r4.intValue()
            long r4 = (long) r4
            long r6 = r15.h()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a2
            com.uwetrottmann.trakt5.entities.ShowIds r4 = r2.ids
            java.lang.Integer r4 = r4.tvdb
            int r4 = r4.intValue()
            long r4 = (long) r4
            long r6 = r15.j()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0168
            goto L_0x01a2
        L_0x01a1:
            r2 = r3
        L_0x01a2:
            java.util.List<com.uwetrottmann.trakt5.entities.SyncSeason> r1 = r2.seasons
            java.util.Iterator r1 = r1.iterator()
        L_0x01a8:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01c1
            java.lang.Object r2 = r1.next()
            com.uwetrottmann.trakt5.entities.SyncSeason r2 = (com.uwetrottmann.trakt5.entities.SyncSeason) r2
            java.lang.Integer r4 = r2.number
            int r4 = r4.intValue()
            int r5 = r15.f()
            if (r4 != r5) goto L_0x01a8
            goto L_0x01c2
        L_0x01c1:
            r2 = r3
        L_0x01c2:
            java.util.List<com.uwetrottmann.trakt5.entities.SyncEpisode> r1 = r2.episodes
            java.util.Iterator r1 = r1.iterator()
        L_0x01c8:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01e1
            java.lang.Object r4 = r1.next()
            com.uwetrottmann.trakt5.entities.SyncEpisode r4 = (com.uwetrottmann.trakt5.entities.SyncEpisode) r4
            java.lang.Integer r5 = r4.number
            int r5 = r5.intValue()
            int r6 = r15.c()
            if (r5 != r6) goto L_0x01c8
            goto L_0x01e2
        L_0x01e1:
            r4 = r3
        L_0x01e2:
            if (r4 != 0) goto L_0x0158
            java.util.List<com.uwetrottmann.trakt5.entities.SyncEpisode> r1 = r2.episodes
            com.uwetrottmann.trakt5.entities.SyncEpisode r2 = new com.uwetrottmann.trakt5.entities.SyncEpisode
            r2.<init>()
            int r15 = r15.c()
            com.uwetrottmann.trakt5.entities.SyncEpisode r15 = r2.number(r15)
            r1.add(r15)
            goto L_0x0158
        L_0x01f8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.api.TraktUserApi.L(java.util.List, com.database.MvDatabase):java.util.List");
    }

    public Observable<Boolean> i0() {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                TraktGetTokenResult traktGetTokenResult;
                if (TraktCredentialsHelper.b().isValid()) {
                    observableEmitter.onNext(Boolean.TRUE);
                    observableEmitter.onComplete();
                    return;
                }
                HttpHelper i2 = HttpHelper.i();
                String q2 = i2.q("https://api.trakt.tv/oauth/device/code", "{\"client_id\":\"" + com.original.tase.utils.Utils.k(TraktHelper.f34019a, new boolean[0]) + "\"}", false, TraktUserApi.this.f33772a);
                if (q2.isEmpty()) {
                    observableEmitter.onNext(Boolean.FALSE);
                    observableEmitter.onComplete();
                    return;
                }
                TraktGetDeviceCodeResult traktGetDeviceCodeResult = (TraktGetDeviceCodeResult) new Gson().l(q2, TraktGetDeviceCodeResult.class);
                String verification_url = traktGetDeviceCodeResult.getVerification_url();
                String user_code = traktGetDeviceCodeResult.getUser_code();
                String device_code = traktGetDeviceCodeResult.getDevice_code();
                int expires_in = traktGetDeviceCodeResult.getExpires_in();
                int interval = traktGetDeviceCodeResult.getInterval();
                RxBus.a().b(new TraktWaitingToVerifyEvent(verification_url, user_code));
                int i3 = 0;
                while (true) {
                    traktGetTokenResult = null;
                    if (i3 >= expires_in || observableEmitter.isDisposed()) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        if (((float) i3) % ((float) interval) == 0.0f) {
                            HttpHelper i4 = HttpHelper.i();
                            String q3 = i4.q("https://api.trakt.tv/oauth/device/token", "{\"client_id\":\"" + com.original.tase.utils.Utils.k(TraktHelper.f34019a, new boolean[0]) + "\",\"client_secret\":\"" + com.original.tase.utils.Utils.k(TraktHelper.f34020b, new boolean[0]) + "\",\"code\":\"" + com.original.tase.utils.Utils.k(device_code, new boolean[0]) + "\"}", false, TraktUserApi.this.f33772a);
                            if (q3.contains("access_token")) {
                                traktGetTokenResult = (TraktGetTokenResult) new Gson().l(q3, TraktGetTokenResult.class);
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        Logger.d(th, new boolean[0]);
                    }
                    i3++;
                }
                if (traktGetTokenResult == null || traktGetTokenResult.getAccess_token() == null || traktGetTokenResult.getAccess_token().isEmpty()) {
                    observableEmitter.onNext(Boolean.FALSE);
                    observableEmitter.onComplete();
                    return;
                }
                String access_token = traktGetTokenResult.getAccess_token();
                Hashtable v2 = TraktUserApi.this.f33772a;
                v2.put("Authorization", "Bearer " + access_token);
                TraktCredentialsInfo traktCredentialsInfo = new TraktCredentialsInfo();
                traktCredentialsInfo.setAccessToken(access_token);
                traktCredentialsInfo.setRefreshToken(traktGetTokenResult.getRefresh_token());
                try {
                    traktCredentialsInfo.setUser(((TraktUserInfo) new Gson().l(HttpHelper.i().m("https://api.trakt.tv/users/me", TraktUserApi.this.f33772a), TraktUserInfo.class)).getUsername());
                } catch (Throwable th2) {
                    Logger.c(th2, "Unable to get trakt user info", new boolean[0]);
                }
                TraktCredentialsHelper.c(traktCredentialsInfo);
                observableEmitter.onNext(Boolean.TRUE);
                observableEmitter.onComplete();
            }
        });
    }

    public void j0(MovieEntity movieEntity) throws IOException {
        if (movieEntity.getTV().booleanValue()) {
            SyncShow syncShow = new SyncShow();
            syncShow.ids = ShowIds.tmdb((int) movieEntity.getTmdbID());
            TraktHelper.a().sync().deleteItemsFromCollection(new SyncItems().shows(syncShow)).execute();
            return;
        }
        SyncMovie syncMovie = new SyncMovie();
        syncMovie.ids = MovieIds.tmdb((int) movieEntity.getTmdbID());
        TraktHelper.a().sync().deleteItemsFromCollection(new SyncItems().movies(syncMovie)).execute();
    }

    public void k0(CompositeDisposable compositeDisposable, Activity activity, final MvDatabase mvDatabase) {
        Utils.h0(activity, R.string.sync_trakt_begin);
        final String string = FreeMoviesApp.p().getString("pref_trakt_sync_mode", "Merge");
        compositeDisposable.b(Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                int i2;
                if (!string.equals("Merge")) {
                    i2 = mvDatabase.A().a();
                } else {
                    i2 = 0;
                }
                mvDatabase.F().c("me");
                observableEmitter.onNext(Integer.valueOf(i2));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).flatMap(new q(mvDatabase, string)).flatMap(new r(mvDatabase, string)).flatMap(new s(mvDatabase, string)).flatMap(new t(mvDatabase, string)).observeOn(AndroidSchedulers.a()).subscribe(new u(activity), new b(activity)));
    }

    public void l0(CompositeDisposable compositeDisposable, Activity activity, final MvDatabase mvDatabase) {
        Utils.h0(activity, R.string.sync_trakt_begin);
        final String string = FreeMoviesApp.p().getString("pref_trakt_sync_mode", "Merge");
        compositeDisposable.b(Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                int i2;
                if (!string.equals("Merge")) {
                    i2 = mvDatabase.A().f();
                } else {
                    i2 = 0;
                }
                observableEmitter.onNext(Integer.valueOf(i2));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).flatMap(new a(mvDatabase, string)).flatMap(new l(mvDatabase, string)).observeOn(AndroidSchedulers.a()).subscribe(new n(), new o(activity), new p(activity)));
    }

    public void m0(CompositeDisposable compositeDisposable, Activity activity, final MvDatabase mvDatabase) {
        Utils.h0(activity, R.string.sync_trakt_begin);
        final String string = FreeMoviesApp.p().getString("pref_trakt_sync_mode", "Merge");
        compositeDisposable.b(Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                int i2;
                if (!string.equals("Merge")) {
                    i2 = mvDatabase.A().o();
                    mvDatabase.E().a();
                } else {
                    i2 = 0;
                }
                observableEmitter.onNext(Integer.valueOf(i2));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).flatMap(new e(mvDatabase, string)).flatMap(new f(mvDatabase, string)).observeOn(AndroidSchedulers.a()).subscribe(new g(), new h(activity), new i(activity)));
    }

    public void n0(List<TvWatchedEpisode> list, boolean z2, MvDatabase mvDatabase) throws IOException {
        SyncItems syncItems = new SyncItems();
        syncItems.shows(L(list, mvDatabase));
        Sync sync = TraktHelper.a().sync();
        if (z2) {
            sync.addItemsToWatchedHistory(syncItems).execute();
        } else {
            sync.deleteItemsFromWatchedHistory(syncItems).execute();
        }
    }

    public void o0(List<MovieEntity> list) {
        ArrayList arrayList = new ArrayList();
        SyncItems syncItems = new SyncItems();
        for (MovieEntity next : list) {
            MovieIds movieIds = new MovieIds();
            if (next.getImdbIDStr() != null) {
                movieIds.imdb = next.getImdbIDStr();
            }
            if (next.getTmdbID() > 0) {
                movieIds.tmdb = Integer.valueOf((int) next.getTmdbID());
            }
            SyncMovie id = new SyncMovie().id(movieIds);
            id.collected_at = next.getCollected_at();
            arrayList.add(id);
        }
        syncItems.movies((List<SyncMovie>) arrayList);
        TraktHelper.a().sync().addItemsToCollection(syncItems);
    }

    public void p0(List<MovieEntity> list, MvDatabase mvDatabase) {
        ArrayList arrayList = new ArrayList();
        SyncItems syncItems = new SyncItems();
        for (MovieEntity next : list) {
            ShowIds showIds = new ShowIds();
            if (next.getImdbIDStr() != null) {
                showIds.imdb = next.getImdbIDStr();
            }
            if (next.getTmdbID() > 0) {
                showIds.tmdb = Integer.valueOf((int) next.getTmdbID());
            }
            if (next.getTvdbID() > 0) {
                showIds.tvdb = Integer.valueOf((int) next.getTvdbID());
            }
            new SyncShow().id(showIds).collected_at = next.getCollected_at();
            arrayList.addAll(L(mvDatabase.E().j(next.getTmdbID(), next.getImdbIDStr(), next.getTraktID(), next.getTvdbID()), mvDatabase));
        }
        syncItems.shows((List<SyncShow>) arrayList);
        TraktHelper.a().sync().addItemsToCollection(syncItems);
    }

    public void q0(MovieEntity movieEntity, boolean z2) throws IOException {
        Call<SyncResponse> call;
        MovieIds movieIds = new MovieIds();
        movieIds.imdb = movieEntity.getImdbIDStr();
        movieIds.tmdb = Integer.valueOf((int) movieEntity.getTmdbID());
        SyncMovie id = new SyncMovie().id(movieIds);
        id.watched_at = movieEntity.getWatched_at();
        SyncItems syncItems = new SyncItems();
        syncItems.movies(id);
        Sync sync = TraktHelper.a().sync();
        if (z2) {
            call = sync.addItemsToWatchedHistory(syncItems);
        } else {
            call = sync.deleteItemsFromWatchedHistory(syncItems);
        }
        call.execute();
    }

    public void r0(MovieEntity movieEntity, int i2, int i3, boolean z2) throws IOException {
        Call<SyncResponse> call;
        ShowIds showIds = new ShowIds();
        showIds.imdb = movieEntity.getImdbIDStr();
        if (movieEntity.getTmdbID() > 0) {
            showIds.tmdb = Integer.valueOf((int) movieEntity.getTmdbID());
        }
        if (movieEntity.getTvdbID() > 0) {
            showIds.tvdb = Integer.valueOf((int) movieEntity.getTvdbID());
        }
        SyncShow id = new SyncShow().id(showIds);
        id.watched_at = movieEntity.getWatched_at();
        id.seasons(new SyncSeason().number(i2).episodes(new SyncEpisode().number(i3)));
        SyncItems syncItems = new SyncItems();
        syncItems.shows(id);
        Sync sync = TraktHelper.a().sync();
        if (z2) {
            call = sync.addItemsToWatchedHistory(syncItems);
        } else {
            call = sync.deleteItemsFromWatchedHistory(syncItems);
        }
        call.execute();
    }

    public void s0(List<MovieEntity> list, boolean z2) throws IOException {
        Call<SyncResponse> call;
        ArrayList arrayList = new ArrayList();
        SyncItems syncItems = new SyncItems();
        for (MovieEntity next : list) {
            MovieIds movieIds = new MovieIds();
            movieIds.imdb = next.getImdbIDStr();
            movieIds.tmdb = Integer.valueOf((int) next.getTmdbID());
            SyncMovie id = new SyncMovie().id(movieIds);
            id.watched_at = next.getWatched_at();
            arrayList.add(id);
        }
        syncItems.movies((List<SyncMovie>) arrayList);
        Sync sync = TraktHelper.a().sync();
        if (z2) {
            call = sync.addItemsToWatchedHistory(syncItems);
        } else {
            call = sync.deleteItemsFromWatchedHistory(syncItems);
        }
        call.execute();
    }

    public void t0(MovieEntity movieEntity, SeasonEntity seasonEntity, boolean z2) throws IOException {
        Call<SyncResponse> call;
        ShowIds showIds = new ShowIds();
        showIds.imdb = movieEntity.getImdbIDStr();
        showIds.tmdb = Integer.valueOf((int) movieEntity.getTmdbID());
        SyncShow id = new SyncShow().id(showIds);
        SyncSeason number = new SyncSeason().number(seasonEntity.j());
        number.episodes = new ArrayList();
        for (int i2 = 1; i2 <= seasonEntity.d(); i2++) {
            SyncEpisode syncEpisode = new SyncEpisode();
            syncEpisode.season = Integer.valueOf(seasonEntity.j());
            syncEpisode.number = Integer.valueOf(i2);
            number.episodes.add(syncEpisode);
        }
        id.seasons(number);
        SyncItems syncItems = new SyncItems();
        syncItems.shows(id);
        Sync sync = TraktHelper.a().sync();
        if (z2) {
            call = sync.addItemsToWatchedHistory(syncItems);
        } else {
            call = sync.deleteItemsFromWatchedHistory(syncItems);
        }
        call.execute();
    }

    public void w(MovieEntity movieEntity) throws IOException {
        if (movieEntity.getTV().booleanValue()) {
            SyncShow syncShow = new SyncShow();
            syncShow.ids = ShowIds.tmdb((int) movieEntity.getTmdbID());
            syncShow.collected_at = movieEntity.getCollected_at();
            TraktHelper.a().sync().addItemsToCollection(new SyncItems().shows(syncShow)).execute();
            return;
        }
        SyncMovie syncMovie = new SyncMovie();
        syncMovie.collected_at = movieEntity.getCollected_at();
        syncMovie.ids = MovieIds.tmdb((int) movieEntity.getTmdbID());
        TraktHelper.a().sync().addItemsToCollection(new SyncItems().movies(syncMovie)).execute();
    }

    /* access modifiers changed from: package-private */
    public boolean x(MovieEntity movieEntity, MovieEntity movieEntity2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (movieEntity == null || movieEntity2 == null) {
            return false;
        }
        if (movieEntity.getTmdbID() <= 0 || movieEntity2.getTmdbID() <= 0 || movieEntity.getTmdbID() != movieEntity2.getTmdbID()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (movieEntity.getImdbIDStr() == null || movieEntity2.getImdbIDStr() == null) {
            z3 = false;
        } else {
            z3 = movieEntity.getImdbIDStr().equals(movieEntity2.getImdbIDStr());
        }
        if (movieEntity.getTvdbID() <= 0 || movieEntity2.getTvdbID() <= 0 || movieEntity.getTvdbID() != movieEntity2.getTvdbID()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (movieEntity.getTraktID() <= 0 || movieEntity2.getTraktID() <= 0 || movieEntity.getTraktID() != movieEntity2.getTraktID()) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5 || z3 || z4 || z2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean y(TvWatchedEpisode tvWatchedEpisode, TvWatchedEpisode tvWatchedEpisode2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (tvWatchedEpisode == null || tvWatchedEpisode2 == null) {
            return false;
        }
        if (tvWatchedEpisode.h() <= 0 || tvWatchedEpisode2.h() <= 0 || tvWatchedEpisode.h() != tvWatchedEpisode2.h()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (tvWatchedEpisode.d() == null || tvWatchedEpisode2.d() == null) {
            z3 = false;
        } else {
            z3 = tvWatchedEpisode.d().equals(tvWatchedEpisode2.d());
        }
        if (tvWatchedEpisode.j() <= 0 || tvWatchedEpisode2.j() <= 0 || tvWatchedEpisode.j() != tvWatchedEpisode2.j()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (tvWatchedEpisode.i() <= 0 || tvWatchedEpisode2.i() <= 0 || tvWatchedEpisode.i() != tvWatchedEpisode2.i()) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5 || z3 || z4 || z2) {
            return true;
        }
        return false;
    }
}

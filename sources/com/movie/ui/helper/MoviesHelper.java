package com.movie.ui.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.TvWatchedEpisode;
import com.movie.FreeMoviesApp;
import com.movie.data.model.cinema.Video;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.original.tase.api.TraktUserApi;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import timber.log.Timber;

@Module
public class MoviesHelper {

    /* renamed from: a  reason: collision with root package name */
    TMDBRepositoryImpl f33602a;

    /* renamed from: b  reason: collision with root package name */
    MvDatabase f33603b;

    public Observable<String> c(final MovieEntity movieEntity) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                movieEntity.setWatched_at((OffsetDateTime) null);
                MoviesHelper.this.f33603b.A().g(movieEntity);
                observableEmitter.onNext("Remote from history");
                TraktUserApi.M().q0(movieEntity, false);
                observableEmitter.onNext("Sent to trakt successfully");
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }

    public Observable<MovieEntity> d(long j2, String str, long j3, long j4) {
        final long j5 = j2;
        final String str2 = str;
        final long j6 = j3;
        final long j7 = j4;
        return Observable.create(new ObservableOnSubscribe<MovieEntity>() {
            public void subscribe(ObservableEmitter<MovieEntity> observableEmitter) throws Exception {
                observableEmitter.onNext(MoviesHelper.this.f33603b.A().l(j5, str2, j6, j7));
                observableEmitter.onComplete();
            }
        });
    }

    public Observable<MovieEntity> e(long j2, String str, long j3, long j4) {
        final long j5 = j2;
        final String str2 = str;
        final long j6 = j3;
        final long j7 = j4;
        return Observable.create(new ObservableOnSubscribe<MovieEntity>() {
            public void subscribe(ObservableEmitter<MovieEntity> observableEmitter) throws Exception {
                MovieEntity l2 = MoviesHelper.this.f33603b.A().l(j5, str2, j6, j7);
                if (l2 != null) {
                    observableEmitter.onNext(l2);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public Observable<TvWatchedEpisode> f(long j2, String str, long j3, long j4, int i2, int i3) {
        final long j5 = j2;
        final String str2 = str;
        final long j6 = j3;
        final long j7 = j4;
        final int i4 = i2;
        final int i5 = i3;
        return Observable.create(new ObservableOnSubscribe<TvWatchedEpisode>() {
            public void subscribe(ObservableEmitter<TvWatchedEpisode> observableEmitter) throws Exception {
                List<TvWatchedEpisode> e2 = MoviesHelper.this.f33603b.E().e(j5, str2, j6, j7, i4, i5);
                if (e2 != null && e2.size() > 0) {
                    observableEmitter.onNext(e2.get(0));
                }
                observableEmitter.onComplete();
            }
        });
    }

    public void i(Activity activity, Video video) {
        if (video.getSite().equals("YouTube")) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getKey())));
            return;
        }
        Timber.g("Unsupported video format", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    @Inject
    @Provides
    public MoviesHelper j(TMDBRepositoryImpl tMDBRepositoryImpl, MvDatabase mvDatabase) {
        MoviesHelper moviesHelper = new MoviesHelper();
        moviesHelper.f33602a = tMDBRepositoryImpl;
        moviesHelper.f33603b = mvDatabase;
        return moviesHelper;
    }

    public Observable<String> k(final MovieEntity movieEntity, boolean z2) {
        FreeMoviesApp.p().edit().putInt("is_last_tv_seen", 1).apply();
        int i2 = FreeMoviesApp.p().getInt("pref_mark_saving_percent", 1) * 60 * 1000;
        if (!z2 && movieEntity.getPosition() < ((long) i2)) {
            return Observable.just("");
        }
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        movieEntity.setCreatedDate(OffsetDateTime.now((ZoneId) zoneOffset));
        movieEntity.setWatched_at(OffsetDateTime.now((ZoneId) zoneOffset));
        return Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                boolean z2 = false;
                try {
                    MoviesHelper.this.f33603b.A().b(movieEntity);
                    observableEmitter.onNext("Save to history successfully");
                } catch (Exception unused) {
                    observableEmitter.onNext("Fail to save to history");
                }
                if (TraktCredentialsHelper.b().isValid()) {
                    try {
                        TraktUserApi M = TraktUserApi.M();
                        MovieEntity movieEntity = movieEntity;
                        if (movieEntity.getWatched_at() != null) {
                            z2 = true;
                        }
                        M.q0(movieEntity, z2);
                        observableEmitter.onNext("Sent to trakt successfully");
                    } catch (Exception unused2) {
                        observableEmitter.onNext("Fail to send to trakt");
                    }
                }
                observableEmitter.onComplete();
            }
        });
    }

    public Observable<String> l(final MovieEntity movieEntity, final TvWatchedEpisode tvWatchedEpisode, final boolean z2, boolean z3) {
        OffsetDateTime offsetDateTime;
        FreeMoviesApp.p().edit().putInt("is_last_tv_seen", 0).apply();
        if (z2) {
            offsetDateTime = OffsetDateTime.now((ZoneId) ZoneOffset.UTC);
        } else {
            offsetDateTime = null;
        }
        movieEntity.setWatched_at(offsetDateTime);
        int i2 = FreeMoviesApp.p().getInt("pref_mark_saving_percent", 1) * 60 * 1000;
        if (!z3 && tvWatchedEpisode.e() < ((long) i2)) {
            return Observable.just("");
        }
        movieEntity.setCreatedDate(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
        return Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("Save episode to history");
                try {
                    MoviesHelper.this.f33603b.A().b(movieEntity);
                    MoviesHelper.this.f33603b.E().l(tvWatchedEpisode);
                    if (!z2) {
                        MoviesHelper.this.f33603b.E().d(tvWatchedEpisode.h(), tvWatchedEpisode.d(), tvWatchedEpisode.i(), tvWatchedEpisode.j(), tvWatchedEpisode.f(), tvWatchedEpisode.c());
                        observableEmitter.onNext("remove episode from history successfully");
                    } else {
                        observableEmitter.onNext("Save episode to history successfully");
                    }
                } catch (Exception unused) {
                    observableEmitter.onNext("Fail to save show to history");
                }
                if (TraktCredentialsHelper.b().isValid()) {
                    try {
                        TraktUserApi.M().r0(movieEntity, tvWatchedEpisode.f(), tvWatchedEpisode.c(), z2);
                        observableEmitter.onNext("Sent to trakt successfully");
                    } catch (Exception unused2) {
                        observableEmitter.onNext("Fail to send to trakt");
                    }
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c());
    }

    public Disposable m(Activity activity, final MovieEntity movieEntity, final boolean z2) {
        OffsetDateTime offsetDateTime;
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        movieEntity.setCreatedDate(OffsetDateTime.now((ZoneId) zoneOffset));
        if (z2) {
            offsetDateTime = OffsetDateTime.now((ZoneId) zoneOffset);
        } else {
            offsetDateTime = null;
        }
        movieEntity.setCollected_at(offsetDateTime);
        return Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                String str;
                try {
                    if (z2) {
                        MoviesHelper.this.f33603b.A().b(movieEntity);
                    } else {
                        MoviesHelper.this.f33603b.A().g(movieEntity);
                    }
                    if (z2) {
                        str = "Saved to favorites";
                    } else {
                        str = "Removed from favorites";
                    }
                    observableEmitter.onNext(str);
                    if (TraktCredentialsHelper.b().isValid()) {
                        if (movieEntity.getCollected_at() != null) {
                            TraktUserApi.M().w(movieEntity);
                        } else {
                            TraktUserApi.M().j0(movieEntity);
                        }
                        observableEmitter.onNext("Send to trakt collections success");
                    }
                } catch (Exception unused) {
                    observableEmitter.onNext("Send to trakt collections failed");
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(activity), new b(activity));
    }
}

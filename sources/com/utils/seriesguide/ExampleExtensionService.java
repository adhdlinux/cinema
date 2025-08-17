package com.utils.seriesguide;

import android.content.Intent;
import com.battlelancer.seriesguide.api.Action;
import com.battlelancer.seriesguide.api.Episode;
import com.battlelancer.seriesguide.api.Movie;
import com.battlelancer.seriesguide.api.SeriesGuideExtension;
import com.database.entitys.MovieEntity;
import com.google.gson.Gson;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.tmvdb.FindResult;
import com.movie.ui.activity.MovieDetailsActivity;
import com.movie.ui.activity.sources.SourceActivity;
import com.original.tase.Logger;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import k1.a;
import k1.b;
import k1.c;
import org.joda.time.DateTime;

public class ExampleExtensionService extends SeriesGuideExtension {
    public ExampleExtensionService() {
        super("ExampleExtension");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(MovieInfo movieInfo, MovieEntity movieEntity, int i2, Throwable th) throws Exception {
        String v2 = new Gson().v(movieInfo, MovieInfo.class);
        String v3 = new Gson().v(movieEntity, MovieEntity.class);
        Intent intent = new Intent(this, SourceActivity.class);
        intent.putExtra("MovieInfo", v2);
        intent.putExtra("isFromAnotherApp", true);
        intent.putExtra("Movie", v3);
        B(new Action.Builder("Play Show on Cinema HD", i2).b(intent).a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(MovieInfo movieInfo, MovieEntity movieEntity, int i2) throws Exception {
        String v2 = new Gson().v(movieInfo, MovieInfo.class);
        String v3 = new Gson().v(movieEntity, MovieEntity.class);
        Intent intent = new Intent(this, SourceActivity.class);
        intent.putExtra("MovieInfo", v2);
        intent.putExtra("isFromAnotherApp", true);
        intent.putExtra("Movie", v3);
        B(new Action.Builder("Play Show on Cinema HD", i2).b(intent).a());
    }

    /* access modifiers changed from: protected */
    public void x(int i2, final Episode episode) {
        String str;
        Logger.b("ExampleExtensionService", "onRequest: episode " + episode.s().toString());
        Utils.a98c();
        String o2 = episode.o();
        if (o2 != null && !o2.isEmpty() && o2.length() >= 4) {
            o2 = o2.trim().substring(0, 4);
            if (!o2.contains("-")) {
                com.original.tase.utils.Utils.o(o2);
            }
        }
        String str2 = o2;
        String q2 = episode.q();
        String a2 = Regex.a(q2, "(.*?)\\s+\\(\\d{4}\\)", 1);
        if (!a2.isEmpty()) {
            str = a2;
        } else {
            str = q2;
        }
        MovieInfo movieInfo = new MovieInfo(str, str2, String.valueOf(episode.n()), String.valueOf(episode.m()), "-1");
        try {
            if (episode.p() != null && !episode.p().isEmpty()) {
                String lowerCase = episode.p().toLowerCase();
                if (!lowerCase.startsWith("tt")) {
                    lowerCase = "tt" + lowerCase;
                }
                movieInfo.imdbIDStr = lowerCase;
            }
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
        }
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(episode.q());
        movieEntity.setNumberSeason(episode.n().intValue());
        movieEntity.setRealeaseDate(episode.o());
        movieEntity.setTmdbID(0);
        movieEntity.setTvdbID((long) episode.r().intValue());
        movieEntity.setImdbIDStr(episode.l());
        movieEntity.setTV(Boolean.TRUE);
        Observable.create(new ObservableOnSubscribe<FindResult>() {
            public void subscribe(ObservableEmitter<FindResult> observableEmitter) throws Exception {
                FindResult s2 = Utils.s(episode.l());
                if (s2 != null) {
                    observableEmitter.onNext(s2);
                }
                observableEmitter.onComplete();
            }
        }).observeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(movieEntity), new b(this, movieInfo, movieEntity, i2), new c(this, movieInfo, movieEntity, i2));
    }

    /* access modifiers changed from: protected */
    public void y(int i2, Movie movie) {
        Utils.a98c();
        Date g2 = movie.g();
        if (g2 != null) {
            try {
                Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
                if (instance != null) {
                    instance.setTime(g2);
                    instance.get(1);
                } else {
                    g2.getYear();
                }
            } catch (Exception e2) {
                Logger.d(e2, new boolean[0]);
            }
        }
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTV(Boolean.FALSE);
        movieEntity.setTmdbID((long) movie.i().intValue());
        movieEntity.setImdbIDStr(movie.f());
        movieEntity.setRealeaseDate(DateTimeHelper.h(new DateTime((Object) movie.g())));
        movieEntity.setName(movie.h());
        movieEntity.setOverview(movie.h());
        String v2 = new Gson().v(movieEntity, MovieEntity.class);
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("com.freeapp.freemovies.extras.EXTRA_MOVIE", v2);
        intent.putExtra("isFromAnotherApp", true);
        B(new Action.Builder("Play Movie on Cinema HDMovies", i2).b(intent).a());
    }
}

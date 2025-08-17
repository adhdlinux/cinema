package com.extension;

import android.net.Uri;
import android.os.Bundle;
import com.database.entitys.MovieEntity;
import com.domain.api.provider.StreamProvider;
import com.google.gson.Gson;
import com.movie.data.model.MovieInfo;
import com.utils.Utils;
import timber.log.Timber;

public class CinemaProvider extends StreamProvider {
    public void d(long j2, Bundle bundle) {
        String str;
        String string = bundle.getString("com.features.extension.appkey_title");
        String string2 = bundle.getString("com.features.extension.appkey_type");
        String string3 = bundle.getString("com.features.extension.appkey_release_year");
        if (string3.isEmpty()) {
            str = "";
        } else {
            str = string3.split("-")[0];
        }
        String str2 = str;
        Timber.f("title=" + string + " type=" + string2, new Object[0]);
        Utils.a98c();
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(string);
        movieEntity.setTmdbID((long) bundle.getInt("com.features.extension.appkey_tmdb_id"));
        movieEntity.setImdbIDStr(bundle.getString("com.features.extension.appkey_imdb_id"));
        string2.hashCode();
        Class<MovieEntity> cls = MovieEntity.class;
        if (string2.equals("EPISODE")) {
            int i2 = bundle.getInt("com.features.extension.appkey_season");
            int i3 = bundle.getInt("com.features.extension.appkey_episode");
            movieEntity.setNumberSeason(i2);
            movieEntity.setNumberSeason(i2);
            movieEntity.setTV(Boolean.TRUE);
            MovieInfo movieInfo = new MovieInfo(string, str2, String.valueOf(i2), String.valueOf(i3), "-1");
            new Gson().v(movieInfo, MovieInfo.class);
            new Gson().v(movieEntity, cls);
            CinemaWorker.f19368e.a(getContext(), movieEntity, movieInfo);
        } else if (string2.equals("MOVIE")) {
            movieEntity.setTV(Boolean.FALSE);
            new Gson().v(movieEntity, cls);
            MovieInfo movieInfo2 = new MovieInfo(movieEntity.getName(), str2, "", "", "", movieEntity.getGenres());
            movieInfo2.setImdbIDStr(movieEntity.getImdbIDStr());
            CinemaWorker.f19368e.a(getContext(), movieEntity, movieInfo2);
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        super.onCreate();
        return true;
    }
}

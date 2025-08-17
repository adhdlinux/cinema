package com.movie.data.api.imdb;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class IMDBModule_ProvideGsonFactory implements Provider {
    public static Gson a(IMDBModule iMDBModule) {
        return (Gson) Preconditions.d(iMDBModule.b());
    }
}

package com.movie.data.api;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiModule_ProvideGsonFactory implements Provider {
    public static Gson a(ApiModule apiModule) {
        return (Gson) Preconditions.d(apiModule.d());
    }
}

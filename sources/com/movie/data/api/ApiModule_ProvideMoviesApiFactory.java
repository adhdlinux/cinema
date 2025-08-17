package com.movie.data.api;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ApiModule_ProvideMoviesApiFactory implements Provider {
    public static MoviesApi a(ApiModule apiModule, Retrofit retrofit) {
        return (MoviesApi) Preconditions.d(apiModule.e(retrofit));
    }
}

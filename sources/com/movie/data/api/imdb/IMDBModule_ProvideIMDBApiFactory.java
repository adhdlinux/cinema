package com.movie.data.api.imdb;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class IMDBModule_ProvideIMDBApiFactory implements Provider {
    public static IMDBApi a(IMDBModule iMDBModule, Retrofit retrofit) {
        return (IMDBApi) Preconditions.d(iMDBModule.c(retrofit));
    }
}

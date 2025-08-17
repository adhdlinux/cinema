package com.movie.data.api.realdebrid;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class RealDebridModule_ProvideRealDebridApiFactory implements Provider {
    public static RealDebridApi a(RealDebridModule realDebridModule, Retrofit retrofit) {
        return (RealDebridApi) Preconditions.d(realDebridModule.d(retrofit));
    }
}

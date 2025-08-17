package com.movie.data.api.tvmaze;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class TVMazeModule_ProvideTVMazeApiFactory implements Provider {
    public static TVMazeApi a(TVMazeModule tVMazeModule, Retrofit retrofit) {
        return (TVMazeApi) Preconditions.d(tVMazeModule.e(retrofit));
    }
}

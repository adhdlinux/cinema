package com.movie.data.api.tvmaze;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class TVMazeModule_ProvideGsonFactory implements Provider {
    public static Gson a(TVMazeModule tVMazeModule) {
        return (Gson) Preconditions.d(tVMazeModule.b());
    }
}

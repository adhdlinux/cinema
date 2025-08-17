package com.movie;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class FreeMoviesApp_MembersInjector implements MembersInjector<FreeMoviesApp> {
    public static void a(FreeMoviesApp freeMoviesApp, MoviesApi moviesApi) {
        freeMoviesApp.f31888d = moviesApi;
    }
}

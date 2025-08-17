package com.movie.ui.activity.gamechallenge;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class GameChallenge_MembersInjector implements MembersInjector<GameChallenge> {
    public static void a(GameChallenge gameChallenge, MoviesApi moviesApi) {
        gameChallenge.f32225c = moviesApi;
    }
}

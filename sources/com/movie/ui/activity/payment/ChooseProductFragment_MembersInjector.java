package com.movie.ui.activity.payment;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class ChooseProductFragment_MembersInjector implements MembersInjector<ChooseProductFragment> {
    public static void a(ChooseProductFragment chooseProductFragment, MoviesApi moviesApi) {
        chooseProductFragment.f32257d = moviesApi;
    }
}

package com.movie.ui.activity;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class MemberActivationActivity_MembersInjector implements MembersInjector<MemberActivationActivity> {
    public static void a(MemberActivationActivity memberActivationActivity, MoviesApi moviesApi) {
        memberActivationActivity.f32086d = moviesApi;
    }
}

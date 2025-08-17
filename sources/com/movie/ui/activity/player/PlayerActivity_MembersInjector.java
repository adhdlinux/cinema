package com.movie.ui.activity.player;

import dagger.MembersInjector;
import okhttp3.OkHttpClient;

public final class PlayerActivity_MembersInjector implements MembersInjector<PlayerActivity> {
    public static void a(PlayerActivity playerActivity, OkHttpClient okHttpClient) {
        playerActivity.f32389z = okHttpClient;
    }
}

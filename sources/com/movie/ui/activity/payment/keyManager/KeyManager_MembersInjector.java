package com.movie.ui.activity.payment.keyManager;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class KeyManager_MembersInjector implements MembersInjector<KeyManager> {
    public static void a(KeyManager keyManager, MoviesApi moviesApi) {
        keyManager.f32329c = moviesApi;
    }
}

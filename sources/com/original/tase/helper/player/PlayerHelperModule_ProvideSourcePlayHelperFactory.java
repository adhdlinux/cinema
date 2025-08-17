package com.original.tase.helper.player;

import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PlayerHelperModule_ProvideSourcePlayHelperFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerHelperModule f34016a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MoviesHelper> f34017b;

    public PlayerHelperModule_ProvideSourcePlayHelperFactory(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        this.f34016a = playerHelperModule;
        this.f34017b = provider;
    }

    public static PlayerHelperModule_ProvideSourcePlayHelperFactory a(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        return new PlayerHelperModule_ProvideSourcePlayHelperFactory(playerHelperModule, provider);
    }

    public static PlayerHelper c(PlayerHelperModule playerHelperModule, MoviesHelper moviesHelper) {
        return (PlayerHelper) Preconditions.d(playerHelperModule.e(moviesHelper));
    }

    /* renamed from: b */
    public PlayerHelper get() {
        return c(this.f34016a, this.f34017b.get());
    }
}

package com.original.tase.helper.player;

import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PlayerHelperModule_ProvideMainPlayHelperFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerHelperModule f34014a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MoviesHelper> f34015b;

    public PlayerHelperModule_ProvideMainPlayHelperFactory(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        this.f34014a = playerHelperModule;
        this.f34015b = provider;
    }

    public static PlayerHelperModule_ProvideMainPlayHelperFactory a(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        return new PlayerHelperModule_ProvideMainPlayHelperFactory(playerHelperModule, provider);
    }

    public static PlayerHelper c(PlayerHelperModule playerHelperModule, MoviesHelper moviesHelper) {
        return (PlayerHelper) Preconditions.d(playerHelperModule.d(moviesHelper));
    }

    /* renamed from: b */
    public PlayerHelper get() {
        return c(this.f34014a, this.f34015b.get());
    }
}

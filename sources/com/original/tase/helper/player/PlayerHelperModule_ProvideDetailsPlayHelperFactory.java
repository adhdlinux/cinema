package com.original.tase.helper.player;

import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PlayerHelperModule_ProvideDetailsPlayHelperFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerHelperModule f34010a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MoviesHelper> f34011b;

    public PlayerHelperModule_ProvideDetailsPlayHelperFactory(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        this.f34010a = playerHelperModule;
        this.f34011b = provider;
    }

    public static PlayerHelperModule_ProvideDetailsPlayHelperFactory a(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        return new PlayerHelperModule_ProvideDetailsPlayHelperFactory(playerHelperModule, provider);
    }

    public static PlayerHelper c(PlayerHelperModule playerHelperModule, MoviesHelper moviesHelper) {
        return (PlayerHelper) Preconditions.d(playerHelperModule.b(moviesHelper));
    }

    /* renamed from: b */
    public PlayerHelper get() {
        return c(this.f34010a, this.f34011b.get());
    }
}

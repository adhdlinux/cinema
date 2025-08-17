package com.original.tase.helper.player;

import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PlayerHelperModule_ProvideCastPlayHelperFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerHelperModule f34008a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MoviesHelper> f34009b;

    public PlayerHelperModule_ProvideCastPlayHelperFactory(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        this.f34008a = playerHelperModule;
        this.f34009b = provider;
    }

    public static PlayerHelperModule_ProvideCastPlayHelperFactory a(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        return new PlayerHelperModule_ProvideCastPlayHelperFactory(playerHelperModule, provider);
    }

    public static PlayerHelper c(PlayerHelperModule playerHelperModule, MoviesHelper moviesHelper) {
        return (PlayerHelper) Preconditions.d(playerHelperModule.a(moviesHelper));
    }

    /* renamed from: b */
    public PlayerHelper get() {
        return c(this.f34008a, this.f34009b.get());
    }
}

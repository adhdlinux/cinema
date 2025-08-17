package com.original.tase.helper.player;

import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PlayerHelperModule_ProvideEpisodePlayHelperFactory implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerHelperModule f34012a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MoviesHelper> f34013b;

    public PlayerHelperModule_ProvideEpisodePlayHelperFactory(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        this.f34012a = playerHelperModule;
        this.f34013b = provider;
    }

    public static PlayerHelperModule_ProvideEpisodePlayHelperFactory a(PlayerHelperModule playerHelperModule, Provider<MoviesHelper> provider) {
        return new PlayerHelperModule_ProvideEpisodePlayHelperFactory(playerHelperModule, provider);
    }

    public static PlayerHelper c(PlayerHelperModule playerHelperModule, MoviesHelper moviesHelper) {
        return (PlayerHelper) Preconditions.d(playerHelperModule.c(moviesHelper));
    }

    /* renamed from: b */
    public PlayerHelper get() {
        return c(this.f34012a, this.f34013b.get());
    }
}

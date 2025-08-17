package com.movie.data.api.tvdb;

import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class TvdbModule_ProvideTheTvdbFactory implements Provider {
    public static TheTvdb a(TvdbModule tvdbModule) {
        return (TheTvdb) Preconditions.d(tvdbModule.a());
    }
}

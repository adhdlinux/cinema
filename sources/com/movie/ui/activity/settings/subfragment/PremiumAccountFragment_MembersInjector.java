package com.movie.ui.activity.settings.subfragment;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import dagger.MembersInjector;

public final class PremiumAccountFragment_MembersInjector implements MembersInjector<PremiumAccountFragment> {
    public static void a(PremiumAccountFragment premiumAccountFragment, MoviesApi moviesApi) {
        premiumAccountFragment.moviesApi = moviesApi;
    }

    public static void b(PremiumAccountFragment premiumAccountFragment, MvDatabase mvDatabase) {
        premiumAccountFragment.mvDatabase = mvDatabase;
    }

    public static void c(PremiumAccountFragment premiumAccountFragment, OpenSubtitleV1Api openSubtitleV1Api) {
        premiumAccountFragment.openSubtitleV1Api = openSubtitleV1Api;
    }

    public static void d(PremiumAccountFragment premiumAccountFragment, RealDebridApi realDebridApi) {
        premiumAccountFragment.realDebridApi = realDebridApi;
    }
}

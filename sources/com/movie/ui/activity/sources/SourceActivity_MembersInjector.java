package com.movie.ui.activity.sources;

import com.database.MvDatabase;
import com.movie.data.api.MoviesApi;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import dagger.MembersInjector;
import javax.inject.Named;
import okhttp3.OkHttpClient;

public final class SourceActivity_MembersInjector implements MembersInjector<SourceActivity> {
    public static void a(SourceActivity sourceActivity, MoviesHelper moviesHelper) {
        sourceActivity.f32860s = moviesHelper;
    }

    public static void b(SourceActivity sourceActivity, MoviesApi moviesApi) {
        sourceActivity.f32859r = moviesApi;
    }

    public static void c(SourceActivity sourceActivity, MvDatabase mvDatabase) {
        sourceActivity.f32861t = mvDatabase;
    }

    public static void d(SourceActivity sourceActivity, OpenSubtitleV1Api openSubtitleV1Api) {
        sourceActivity.f32862u = openSubtitleV1Api;
    }

    @Named("SourceActivity")
    public static void e(SourceActivity sourceActivity, PlayerHelper playerHelper) {
        sourceActivity.f32864w = playerHelper;
    }

    @Named("RealDebrid")
    public static void f(SourceActivity sourceActivity, OkHttpClient okHttpClient) {
        sourceActivity.K = okHttpClient;
    }
}

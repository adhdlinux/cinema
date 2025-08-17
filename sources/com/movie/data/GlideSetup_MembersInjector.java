package com.movie.data;

import dagger.MembersInjector;
import okhttp3.OkHttpClient;

public final class GlideSetup_MembersInjector implements MembersInjector<GlideSetup> {
    public static void a(GlideSetup glideSetup, OkHttpClient okHttpClient) {
        glideSetup.f31898a = okHttpClient;
    }
}

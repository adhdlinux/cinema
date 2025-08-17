package com.utils.subtitle.services.openSubtitle;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class OpenSubtitleModule_ProvideOpenSubtitleApiFactory implements Provider {
    private final OpenSubtitleModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public OpenSubtitleModule_ProvideOpenSubtitleApiFactory(OpenSubtitleModule openSubtitleModule, Provider<OkHttpClient> provider) {
        this.module = openSubtitleModule;
        this.okHttpClientProvider = provider;
    }

    public static OpenSubtitleModule_ProvideOpenSubtitleApiFactory create(OpenSubtitleModule openSubtitleModule, Provider<OkHttpClient> provider) {
        return new OpenSubtitleModule_ProvideOpenSubtitleApiFactory(openSubtitleModule, provider);
    }

    public static OpenSubtitleV1Api provideOpenSubtitleApi(OpenSubtitleModule openSubtitleModule, OkHttpClient okHttpClient) {
        return (OpenSubtitleV1Api) Preconditions.d(openSubtitleModule.provideOpenSubtitleApi(okHttpClient));
    }

    public OpenSubtitleV1Api get() {
        return provideOpenSubtitleApi(this.module, this.okHttpClientProvider.get());
    }
}

package com.movie.data;

import com.movie.AppComponent;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

public final class DaggerGlideSetupComponent {

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private AppComponent f31895a;

        public Builder a(AppComponent appComponent) {
            this.f31895a = (AppComponent) Preconditions.b(appComponent);
            return this;
        }

        public GlideSetupComponent b() {
            Preconditions.a(this.f31895a, AppComponent.class);
            return new GlideSetupComponentImpl(this.f31895a);
        }

        private Builder() {
        }
    }

    private static final class GlideSetupComponentImpl implements GlideSetupComponent {

        /* renamed from: a  reason: collision with root package name */
        private final AppComponent f31896a;

        /* renamed from: b  reason: collision with root package name */
        private final GlideSetupComponentImpl f31897b;

        private GlideSetup b(GlideSetup glideSetup) {
            GlideSetup_MembersInjector.a(glideSetup, (OkHttpClient) Preconditions.c(this.f31896a.p()));
            return glideSetup;
        }

        public void a(GlideSetup glideSetup) {
            b(glideSetup);
        }

        private GlideSetupComponentImpl(AppComponent appComponent) {
            this.f31897b = this;
            this.f31896a = appComponent;
        }
    }

    private DaggerGlideSetupComponent() {
    }

    public static Builder a() {
        return new Builder();
    }
}

package com.movie.data;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.bumptech.glide.module.GlideModule;
import com.movie.FreeMoviesApp;
import com.utils.ImageUtils;
import java.io.InputStream;
import javax.inject.Inject;
import okhttp3.OkHttpClient;

public final class GlideSetup implements GlideModule {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    OkHttpClient f31898a;

    private static class ImageLoader extends BaseGlideUrlLoader<String> {

        public static class Factory implements ModelLoaderFactory<String, InputStream> {
            public void a() {
            }

            public ModelLoader<String, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
                return new ImageLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
            }
        }

        ImageLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
            super(modelLoader);
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public String f(String str, int i2, int i3, Options options) {
            return ImageUtils.a(str, i2);
        }

        /* renamed from: h */
        public boolean a(String str) {
            return true;
        }
    }

    public void a(Context context, GlideBuilder glideBuilder) {
    }

    public void b(Context context, Glide glide, Registry registry) {
        DaggerGlideSetupComponent.a().a(FreeMoviesApp.m(context).l()).b().a(this);
        Class<InputStream> cls = InputStream.class;
        registry.r(String.class, cls, new ImageLoader.Factory());
        registry.r(GlideUrl.class, cls, new OkHttpUrlLoader.Factory(this.f31898a));
    }
}

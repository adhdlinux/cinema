package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Call.Factory f16278a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: b  reason: collision with root package name */
        private static volatile Call.Factory f16279b;

        /* renamed from: a  reason: collision with root package name */
        private final Call.Factory f16280a;

        public Factory() {
            this(b());
        }

        private static Call.Factory b() {
            if (f16279b == null) {
                synchronized (Factory.class) {
                    if (f16279b == null) {
                        f16279b = new OkHttpClient();
                    }
                }
            }
            return f16279b;
        }

        public void a() {
        }

        public ModelLoader<GlideUrl, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.f16280a);
        }

        public Factory(Call.Factory factory) {
            this.f16280a = factory;
        }
    }

    public OkHttpUrlLoader(Call.Factory factory) {
        this.f16278a = factory;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(GlideUrl glideUrl, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(glideUrl, new OkHttpStreamFetcher(this.f16278a, glideUrl));
    }

    /* renamed from: d */
    public boolean a(GlideUrl glideUrl) {
        return true;
    }
}

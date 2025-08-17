package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final Option<Integer> f16769b = Option.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    private final ModelCache<GlideUrl, GlideUrl> f16770a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ModelCache<GlideUrl, GlideUrl> f16771a = new ModelCache<>(500);

        public void a() {
        }

        public ModelLoader<GlideUrl, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f16771a);
        }
    }

    public HttpGlideUrlLoader() {
        this((ModelCache<GlideUrl, GlideUrl>) null);
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(GlideUrl glideUrl, int i2, int i3, Options options) {
        ModelCache<GlideUrl, GlideUrl> modelCache = this.f16770a;
        if (modelCache != null) {
            GlideUrl a2 = modelCache.a(glideUrl, 0, 0);
            if (a2 == null) {
                this.f16770a.b(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = a2;
            }
        }
        return new ModelLoader.LoadData<>(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.c(f16769b)).intValue()));
    }

    /* renamed from: d */
    public boolean a(GlideUrl glideUrl) {
        return true;
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.f16770a = modelCache;
    }
}

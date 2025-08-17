package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.facebook.common.util.UriUtil;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpUriLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f16772b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{UriUtil.HTTP_SCHEME, UriUtil.HTTPS_SCHEME})));

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, InputStream> f16773a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        public void a() {
        }

        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f16773a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(Uri uri, int i2, int i3, Options options) {
        return this.f16773a.b(new GlideUrl(uri.toString()), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return f16772b.contains(uri.getScheme());
    }
}

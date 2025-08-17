package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.facebook.common.util.UriUtil;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f16765b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{UriUtil.HTTP_SCHEME, UriUtil.HTTPS_SCHEME})));

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, Data> f16766a;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        public void a() {
        }

        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.f16766a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(Uri uri, int i2, int i3, Options options) {
        return this.f16766a.b(new GlideUrl(uri.toString()), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return f16765b.contains(uri.getScheme());
    }
}

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16776a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16777a;

        public Factory(Context context) {
            this.f16777a = context;
        }

        public void a() {
        }

        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f16777a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f16776a = context.getApplicationContext();
    }

    private boolean e(Options options) {
        Long l2 = (Long) options.c(VideoDecoder.f16891d);
        if (l2 == null || l2.longValue() != -1) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(Uri uri, int i2, int i3, Options options) {
        if (!MediaStoreUtil.d(i2, i3) || !e(options)) {
            return null;
        }
        return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.g(this.f16776a, uri));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return MediaStoreUtil.c(uri);
    }
}

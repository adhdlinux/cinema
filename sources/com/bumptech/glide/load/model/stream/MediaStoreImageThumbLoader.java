package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16774a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16775a;

        public Factory(Context context) {
            this.f16775a = context;
        }

        public void a() {
        }

        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.f16775a);
        }
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f16774a = context.getApplicationContext();
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(Uri uri, int i2, int i3, Options options) {
        if (MediaStoreUtil.d(i2, i3)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.f(this.f16774a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return MediaStoreUtil.a(uri);
    }
}

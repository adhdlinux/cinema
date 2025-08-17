package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final int f16674c = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f16675a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetFetcherFactory<Data> f16676b;

    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> b(AssetManager assetManager, String str);
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f16677a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f16677a = assetManager;
        }

        public void a() {
        }

        public DataFetcher<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        public ModelLoader<Uri, ParcelFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f16677a, this);
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f16678a;

        public StreamFactory(AssetManager assetManager) {
            this.f16678a = assetManager;
        }

        public void a() {
        }

        public DataFetcher<InputStream> b(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f16678a, this);
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.f16675a = assetManager;
        this.f16676b = assetFetcherFactory;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(Uri uri, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.f16676b.b(this.f16675a, uri.toString().substring(f16674c)));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}

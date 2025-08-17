package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<Uri, Data> f16749a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f16750b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16751a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f16751a = resources;
        }

        public void a() {
        }

        public ModelLoader<Integer, AssetFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16751a, multiModelLoaderFactory.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16752a;

        public FileDescriptorFactory(Resources resources) {
            this.f16752a = resources;
        }

        public void a() {
        }

        public ModelLoader<Integer, ParcelFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16752a, multiModelLoaderFactory.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16753a;

        public StreamFactory(Resources resources) {
            this.f16753a = resources;
        }

        public void a() {
        }

        public ModelLoader<Integer, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16753a, multiModelLoaderFactory.d(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f16754a;

        public UriFactory(Resources resources) {
            this.f16754a = resources;
        }

        public void a() {
        }

        public ModelLoader<Integer, Uri> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16754a, UnitModelLoader.c());
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f16750b = resources;
        this.f16749a = modelLoader;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f16750b.getResourcePackageName(num.intValue()) + '/' + this.f16750b.getResourceTypeName(num.intValue()) + '/' + this.f16750b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(Integer num, int i2, int i3, Options options) {
        Uri d2 = d(num);
        if (d2 == null) {
            return null;
        }
        return this.f16749a.b(d2, i2, i3, options);
    }

    /* renamed from: e */
    public boolean a(Integer num) {
        return true;
    }
}

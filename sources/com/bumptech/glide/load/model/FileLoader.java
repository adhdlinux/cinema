package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final FileOpener<Data> f16691a;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final FileOpener<Data> f16692a;

        public Factory(FileOpener<Data> fileOpener) {
            this.f16692a = fileOpener;
        }

        public final void a() {
        }

        public final ModelLoader<File, Data> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f16692a);
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new FileOpener<ParcelFileDescriptor>() {
                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                /* renamed from: d */
                public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                /* renamed from: e */
                public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
            });
        }
    }

    private static final class FileFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final File f16693b;

        /* renamed from: c  reason: collision with root package name */
        private final FileOpener<Data> f16694c;

        /* renamed from: d  reason: collision with root package name */
        private Data f16695d;

        FileFetcher(File file, FileOpener<Data> fileOpener) {
            this.f16693b = file;
            this.f16694c = fileOpener;
        }

        public Class<Data> a() {
            return this.f16694c.a();
        }

        public void b() {
            Data data = this.f16695d;
            if (data != null) {
                try {
                    this.f16694c.b(data);
                } catch (IOException unused) {
                }
            }
        }

        public void cancel() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data c2 = this.f16694c.c(this.f16693b);
                this.f16695d = c2;
                dataCallback.f(c2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                dataCallback.c(e2);
            }
        }
    }

    public interface FileOpener<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new FileOpener<InputStream>() {
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                /* renamed from: d */
                public void b(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                /* renamed from: e */
                public InputStream c(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.f16691a = fileOpener;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(File file, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new FileFetcher(file, this.f16691a));
    }

    /* renamed from: d */
    public boolean a(File file) {
        return true;
    }
}

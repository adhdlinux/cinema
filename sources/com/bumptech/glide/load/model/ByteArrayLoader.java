package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final Converter<Data> f16679a;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        public void a() {
        }

        public ModelLoader<byte[], ByteBuffer> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() {
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                /* renamed from: c */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    public interface Converter<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class Fetcher<Data> implements DataFetcher<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f16681b;

        /* renamed from: c  reason: collision with root package name */
        private final Converter<Data> f16682c;

        Fetcher(byte[] bArr, Converter<Data> converter) {
            this.f16681b = bArr;
            this.f16682c = converter;
        }

        public Class<Data> a() {
            return this.f16682c.a();
        }

        public void b() {
        }

        public void cancel() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.f(this.f16682c.b(this.f16681b));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        public void a() {
        }

        public ModelLoader<byte[], InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() {
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                /* renamed from: c */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.f16679a = converter;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(byte[] bArr, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(bArr), new Fetcher(bArr, this.f16679a));
    }

    /* renamed from: d */
    public boolean a(byte[] bArr) {
        return true;
    }
}

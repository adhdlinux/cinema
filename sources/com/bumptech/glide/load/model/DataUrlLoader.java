package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final DataDecoder<Data> f16685a;

    public interface DataDecoder<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final String f16686b;

        /* renamed from: c  reason: collision with root package name */
        private final DataDecoder<Data> f16687c;

        /* renamed from: d  reason: collision with root package name */
        private Data f16688d;

        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.f16686b = str;
            this.f16687c = dataDecoder;
        }

        public Class<Data> a() {
            return this.f16687c.a();
        }

        public void b() {
            try {
                this.f16687c.b(this.f16688d);
            } catch (IOException unused) {
            }
        }

        public void cancel() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data decode = this.f16687c.decode(this.f16686b);
                this.f16688d = decode;
                dataCallback.f(decode);
            } catch (IllegalArgumentException e2) {
                dataCallback.c(e2);
            }
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final DataDecoder<InputStream> f16689a = new DataDecoder<InputStream>() {
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: d */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        };

        public void a() {
        }

        public ModelLoader<Model, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f16689a);
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f16685a = dataDecoder;
    }

    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    public ModelLoader.LoadData<Data> b(Model model, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.f16685a));
    }
}

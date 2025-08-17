package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    private static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {

        /* renamed from: b  reason: collision with root package name */
        private final File f16684b;

        ByteBufferFetcher(File file) {
            this.f16684b = file;
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public void b() {
        }

        public void cancel() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.f(ByteBufferUtil.a(this.f16684b));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                dataCallback.c(e2);
            }
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public void a() {
        }

        public ModelLoader<File, ByteBuffer> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    /* renamed from: c */
    public ModelLoader.LoadData<ByteBuffer> b(File file, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new ByteBufferFetcher(file));
    }

    /* renamed from: d */
    public boolean a(File file) {
        return true;
    }
}

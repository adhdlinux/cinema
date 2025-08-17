package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    private final Encoder<DataType> f16381a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f16382b;

    /* renamed from: c  reason: collision with root package name */
    private final Options f16383c;

    DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f16381a = encoder;
        this.f16382b = datatype;
        this.f16383c = options;
    }

    public boolean a(File file) {
        return this.f16381a.a(this.f16382b, file, this.f16383c);
    }
}

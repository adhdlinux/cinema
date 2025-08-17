package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f16544a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f16545b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f16546c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16547d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools$Pool<List<Throwable>> pools$Pool) {
        this.f16544a = cls;
        this.f16545b = pools$Pool;
        this.f16546c = (List) Preconditions.c(list);
        this.f16547d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<Transcode> b(DataRewinder<Data> dataRewinder, Options options, int i2, int i3, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f16546c.size();
        Resource<Transcode> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                resource = ((DecodePath) this.f16546c.get(i4)).a(dataRewinder, i2, i3, options, decodeCallback);
            } catch (GlideException e2) {
                list2.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f16547d, (List<Throwable>) new ArrayList(list2));
    }

    public Resource<Transcode> a(DataRewinder<Data> dataRewinder, Options options, int i2, int i3, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List list = (List) Preconditions.d(this.f16545b.acquire());
        try {
            return b(dataRewinder, options, i2, i3, decodeCallback, list);
        } finally {
            this.f16545b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f16546c.toArray()) + '}';
    }
}

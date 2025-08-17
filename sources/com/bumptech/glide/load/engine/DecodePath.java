package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f16449a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f16450b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<ResourceType, Transcode> f16451c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f16452d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16453e;

    interface DecodeCallback<ResourceType> {
        Resource<ResourceType> a(Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools$Pool<List<Throwable>> pools$Pool) {
        this.f16449a = cls;
        this.f16450b = list;
        this.f16451c = resourceTranscoder;
        this.f16452d = pools$Pool;
        this.f16453e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<ResourceType> b(DataRewinder<DataType> dataRewinder, int i2, int i3, Options options) throws GlideException {
        List list = (List) Preconditions.d(this.f16452d.acquire());
        try {
            return c(dataRewinder, i2, i3, options, list);
        } finally {
            this.f16452d.release(list);
        }
    }

    private Resource<ResourceType> c(DataRewinder<DataType> dataRewinder, int i2, int i3, Options options, List<Throwable> list) throws GlideException {
        int size = this.f16450b.size();
        Resource<ResourceType> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.f16450b.get(i4);
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resource = resourceDecoder.b(dataRewinder.a(), i2, i3, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e2);
                }
                list.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f16453e, (List<Throwable>) new ArrayList(list));
    }

    public Resource<Transcode> a(DataRewinder<DataType> dataRewinder, int i2, int i3, Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.f16451c.a(decodeCallback.a(b(dataRewinder, i2, i3, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f16449a + ", decoders=" + this.f16450b + ", transcoder=" + this.f16451c + '}';
    }
}

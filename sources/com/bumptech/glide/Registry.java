package com.bumptech.glide;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoaderRegistry f16152a;

    /* renamed from: b  reason: collision with root package name */
    private final EncoderRegistry f16153b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceDecoderRegistry f16154c;

    /* renamed from: d  reason: collision with root package name */
    private final ResourceEncoderRegistry f16155d;

    /* renamed from: e  reason: collision with root package name */
    private final DataRewinderRegistry f16156e;

    /* renamed from: f  reason: collision with root package name */
    private final TranscoderRegistry f16157f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageHeaderParserRegistry f16158g;

    /* renamed from: h  reason: collision with root package name */
    private final ModelToResourceClassCache f16159h = new ModelToResourceClassCache();

    /* renamed from: i  reason: collision with root package name */
    private final LoadPathCache f16160i = new LoadPathCache();

    /* renamed from: j  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f16161j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m2, List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools$Pool<List<Throwable>> e2 = FactoryPools.e();
        this.f16161j = e2;
        this.f16152a = new ModelLoaderRegistry(e2);
        this.f16153b = new EncoderRegistry();
        this.f16154c = new ResourceDecoderRegistry();
        this.f16155d = new ResourceEncoderRegistry();
        this.f16156e = new DataRewinderRegistry();
        this.f16157f = new TranscoderRegistry();
        this.f16158g = new ImageHeaderParserRegistry();
        s(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f16154c.d(cls, cls2)) {
            for (Class next2 : this.f16157f.b(next, cls3)) {
                arrayList.add(new DecodePath(cls, next, next2, this.f16154c.b(cls, next), this.f16157f.a(next, next2), this.f16161j));
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, Encoder<Data> encoder) {
        this.f16153b.a(cls, encoder);
        return this;
    }

    public <TResource> Registry b(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.f16155d.a(cls, resourceEncoder);
        return this;
    }

    public <Data, TResource> Registry c(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        e("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    public <Model, Data> Registry d(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f16152a.a(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f16154c.a(str, resourceDecoder, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b2 = this.f16158g.b();
        if (!b2.isEmpty()) {
            return b2;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> a2 = this.f16160i.a(cls, cls2, cls3);
        if (this.f16160i.c(a2)) {
            return null;
        }
        if (a2 == null) {
            List<DecodePath<Data, TResource, Transcode>> f2 = f(cls, cls2, cls3);
            if (f2.isEmpty()) {
                a2 = null;
            } else {
                a2 = new LoadPath<>(cls, cls2, cls3, f2, this.f16161j);
            }
            this.f16160i.d(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public <Model> List<ModelLoader<Model, ?>> i(Model model) {
        return this.f16152a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f16159h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> d2 : this.f16152a.c(cls)) {
                for (Class next : this.f16154c.d(d2, cls2)) {
                    if (!this.f16157f.b(next, cls3).isEmpty() && !a2.contains(next)) {
                        a2.add(next);
                    }
                }
            }
            this.f16159h.b(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <X> ResourceEncoder<X> k(Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> b2 = this.f16155d.b(resource.a());
        if (b2 != null) {
            return b2;
        }
        throw new NoResultEncoderAvailableException(resource.a());
    }

    public <X> DataRewinder<X> l(X x2) {
        return this.f16156e.a(x2);
    }

    public <X> Encoder<X> m(X x2) throws NoSourceEncoderAvailableException {
        Encoder<X> b2 = this.f16153b.b(x2.getClass());
        if (b2 != null) {
            return b2;
        }
        throw new NoSourceEncoderAvailableException(x2.getClass());
    }

    public boolean n(Resource<?> resource) {
        return this.f16155d.b(resource.a()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.f16158g.a(imageHeaderParser);
        return this;
    }

    public Registry p(DataRewinder.Factory<?> factory) {
        this.f16156e.b(factory);
        return this;
    }

    public <TResource, Transcode> Registry q(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f16157f.c(cls, cls2, resourceTranscoder);
        return this;
    }

    public <Model, Data> Registry r(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f16152a.f(cls, cls2, modelLoaderFactory);
        return this;
    }

    public final Registry s(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f16154c.e(arrayList);
        return this;
    }
}

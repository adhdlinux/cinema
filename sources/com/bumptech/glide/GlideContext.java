package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

public class GlideContext extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    static final TransitionOptions<?, ?> f16131k = new GenericTransitionOptions();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f16132a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f16133b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageViewTargetFactory f16134c;

    /* renamed from: d  reason: collision with root package name */
    private final Glide.RequestOptionsFactory f16135d;

    /* renamed from: e  reason: collision with root package name */
    private final List<RequestListener<Object>> f16136e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f16137f;

    /* renamed from: g  reason: collision with root package name */
    private final Engine f16138g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16139h;

    /* renamed from: i  reason: collision with root package name */
    private final int f16140i;

    /* renamed from: j  reason: collision with root package name */
    private RequestOptions f16141j;

    public GlideContext(Context context, ArrayPool arrayPool, Registry registry, ImageViewTargetFactory imageViewTargetFactory, Glide.RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, Engine engine, boolean z2, int i2) {
        super(context.getApplicationContext());
        this.f16132a = arrayPool;
        this.f16133b = registry;
        this.f16134c = imageViewTargetFactory;
        this.f16135d = requestOptionsFactory;
        this.f16136e = list;
        this.f16137f = map;
        this.f16138g = engine;
        this.f16139h = z2;
        this.f16140i = i2;
    }

    public <X> ViewTarget<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f16134c.a(imageView, cls);
    }

    public ArrayPool b() {
        return this.f16132a;
    }

    public List<RequestListener<Object>> c() {
        return this.f16136e;
    }

    public synchronized RequestOptions d() {
        if (this.f16141j == null) {
            this.f16141j = (RequestOptions) this.f16135d.build().K();
        }
        return this.f16141j;
    }

    public <T> TransitionOptions<?, T> e(Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = this.f16137f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry next : this.f16137f.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) next.getValue();
                }
            }
        }
        if (transitionOptions == null) {
            return f16131k;
        }
        return transitionOptions;
    }

    public Engine f() {
        return this.f16138g;
    }

    public int g() {
        return this.f16140i;
    }

    public Registry h() {
        return this.f16133b;
    }

    public boolean i() {
        return this.f16139h;
    }
}

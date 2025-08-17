package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class DecodeHelper<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader.LoadData<?>> f16384a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<Key> f16385b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private GlideContext f16386c;

    /* renamed from: d  reason: collision with root package name */
    private Object f16387d;

    /* renamed from: e  reason: collision with root package name */
    private int f16388e;

    /* renamed from: f  reason: collision with root package name */
    private int f16389f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f16390g;

    /* renamed from: h  reason: collision with root package name */
    private DecodeJob.DiskCacheProvider f16391h;

    /* renamed from: i  reason: collision with root package name */
    private Options f16392i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f16393j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f16394k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16395l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16396m;

    /* renamed from: n  reason: collision with root package name */
    private Key f16397n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f16398o;

    /* renamed from: p  reason: collision with root package name */
    private DiskCacheStrategy f16399p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16400q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16401r;

    DecodeHelper() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f16386c = null;
        this.f16387d = null;
        this.f16397n = null;
        this.f16390g = null;
        this.f16394k = null;
        this.f16392i = null;
        this.f16398o = null;
        this.f16393j = null;
        this.f16399p = null;
        this.f16384a.clear();
        this.f16395l = false;
        this.f16385b.clear();
        this.f16396m = false;
    }

    /* access modifiers changed from: package-private */
    public ArrayPool b() {
        return this.f16386c.b();
    }

    /* access modifiers changed from: package-private */
    public List<Key> c() {
        if (!this.f16396m) {
            this.f16396m = true;
            this.f16385b.clear();
            List<ModelLoader.LoadData<?>> g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData loadData = g2.get(i2);
                if (!this.f16385b.contains(loadData.f16724a)) {
                    this.f16385b.add(loadData.f16724a);
                }
                for (int i3 = 0; i3 < loadData.f16725b.size(); i3++) {
                    if (!this.f16385b.contains(loadData.f16725b.get(i3))) {
                        this.f16385b.add(loadData.f16725b.get(i3));
                    }
                }
            }
        }
        return this.f16385b;
    }

    /* access modifiers changed from: package-private */
    public DiskCache d() {
        return this.f16391h.a();
    }

    /* access modifiers changed from: package-private */
    public DiskCacheStrategy e() {
        return this.f16399p;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f16389f;
    }

    /* access modifiers changed from: package-private */
    public List<ModelLoader.LoadData<?>> g() {
        if (!this.f16395l) {
            this.f16395l = true;
            this.f16384a.clear();
            List i2 = this.f16386c.h().i(this.f16387d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.LoadData b2 = ((ModelLoader) i2.get(i3)).b(this.f16387d, this.f16388e, this.f16389f, this.f16392i);
                if (b2 != null) {
                    this.f16384a.add(b2);
                }
            }
        }
        return this.f16384a;
    }

    /* access modifiers changed from: package-private */
    public <Data> LoadPath<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f16386c.h().h(cls, this.f16390g, this.f16394k);
    }

    /* access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f16387d.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<ModelLoader<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f16386c.h().i(file);
    }

    /* access modifiers changed from: package-private */
    public Options k() {
        return this.f16392i;
    }

    /* access modifiers changed from: package-private */
    public Priority l() {
        return this.f16398o;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f16386c.h().j(this.f16387d.getClass(), this.f16390g, this.f16394k);
    }

    /* access modifiers changed from: package-private */
    public <Z> ResourceEncoder<Z> n(Resource<Z> resource) {
        return this.f16386c.h().k(resource);
    }

    /* access modifiers changed from: package-private */
    public Key o() {
        return this.f16397n;
    }

    /* access modifiers changed from: package-private */
    public <X> Encoder<X> p(X x2) throws Registry.NoSourceEncoderAvailableException {
        return this.f16386c.h().m(x2);
    }

    /* access modifiers changed from: package-private */
    public Class<?> q() {
        return this.f16394k;
    }

    /* access modifiers changed from: package-private */
    public <Z> Transformation<Z> r(Class<Z> cls) {
        Transformation<Z> transformation = this.f16393j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it2 = this.f16393j.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f16393j.isEmpty() || !this.f16400q) {
            return UnitTransformation.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f16388e;
    }

    /* access modifiers changed from: package-private */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public <R> void u(GlideContext glideContext, Object obj, Key key, int i2, int i3, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z2, boolean z3, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.f16386c = glideContext;
        this.f16387d = obj;
        this.f16397n = key;
        this.f16388e = i2;
        this.f16389f = i3;
        this.f16399p = diskCacheStrategy;
        this.f16390g = cls;
        this.f16391h = diskCacheProvider;
        this.f16394k = cls2;
        this.f16398o = priority;
        this.f16392i = options;
        this.f16393j = map;
        this.f16400q = z2;
        this.f16401r = z3;
    }

    /* access modifiers changed from: package-private */
    public boolean v(Resource<?> resource) {
        return this.f16386c.h().n(resource);
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.f16401r;
    }

    /* access modifiers changed from: package-private */
    public boolean x(Key key) {
        List<ModelLoader.LoadData<?>> g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g2.get(i2).f16724a.equals(key)) {
                return true;
            }
        }
        return false;
    }
}

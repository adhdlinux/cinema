package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, InputStream> f16767a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelCache<Model, GlideUrl> f16768b;

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    private static List<Key> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String glideUrl : collection) {
            arrayList.add(new GlideUrl(glideUrl));
        }
        return arrayList;
    }

    public ModelLoader.LoadData<InputStream> b(Model model, int i2, int i3, Options options) {
        GlideUrl glideUrl;
        ModelCache<Model, GlideUrl> modelCache = this.f16768b;
        if (modelCache != null) {
            glideUrl = modelCache.a(model, i2, i3);
        } else {
            glideUrl = null;
        }
        if (glideUrl == null) {
            String f2 = f(model, i2, i3, options);
            if (TextUtils.isEmpty(f2)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(f2, e(model, i2, i3, options));
            ModelCache<Model, GlideUrl> modelCache2 = this.f16768b;
            if (modelCache2 != null) {
                modelCache2.b(model, i2, i3, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List<String> d2 = d(model, i2, i3, options);
        ModelLoader.LoadData<InputStream> b2 = this.f16767a.b(glideUrl, i2, i3, options);
        if (b2 == null || d2.isEmpty()) {
            return b2;
        }
        return new ModelLoader.LoadData<>(b2.f16724a, c(d2), b2.f16726c);
    }

    /* access modifiers changed from: protected */
    public List<String> d(Model model, int i2, int i3, Options options) {
        return Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    public Headers e(Model model, int i2, int i3, Options options) {
        return Headers.f16704b;
    }

    /* access modifiers changed from: protected */
    public abstract String f(Model model, int i2, int i3, Options options);

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<Model, GlideUrl> modelCache) {
        this.f16767a = modelLoader;
        this.f16768b = modelCache;
    }
}

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

final class Jobs {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f16542a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f16543b = new HashMap();

    Jobs() {
    }

    private Map<Key, EngineJob<?>> b(boolean z2) {
        return z2 ? this.f16543b : this.f16542a;
    }

    /* access modifiers changed from: package-private */
    public EngineJob<?> a(Key key, boolean z2) {
        return b(z2).get(key);
    }

    /* access modifiers changed from: package-private */
    public void c(Key key, EngineJob<?> engineJob) {
        b(engineJob.n()).put(key, engineJob);
    }

    /* access modifiers changed from: package-private */
    public void d(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> b2 = b(engineJob.n());
        if (engineJob.equals(b2.get(key))) {
            b2.remove(key);
        }
    }
}

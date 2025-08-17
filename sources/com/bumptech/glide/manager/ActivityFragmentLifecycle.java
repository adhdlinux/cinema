package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a  reason: collision with root package name */
    private final Set<LifecycleListener> f16969a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f16970b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16971c;

    ActivityFragmentLifecycle() {
    }

    public void a(LifecycleListener lifecycleListener) {
        this.f16969a.remove(lifecycleListener);
    }

    public void b(LifecycleListener lifecycleListener) {
        this.f16969a.add(lifecycleListener);
        if (this.f16971c) {
            lifecycleListener.onDestroy();
        } else if (this.f16970b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f16971c = true;
        for (T onDestroy : Util.i(this.f16969a)) {
            onDestroy.onDestroy();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f16970b = true;
        for (T onStart : Util.i(this.f16969a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f16970b = false;
        for (T onStop : Util.i(this.f16969a)) {
            onStop.onStop();
        }
    }
}

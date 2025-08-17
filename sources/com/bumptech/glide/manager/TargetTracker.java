package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {

    /* renamed from: b  reason: collision with root package name */
    private final Set<Target<?>> f17004b = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.f17004b.clear();
    }

    public List<Target<?>> b() {
        return Util.i(this.f17004b);
    }

    public void c(Target<?> target) {
        this.f17004b.add(target);
    }

    public void d(Target<?> target) {
        this.f17004b.remove(target);
    }

    public void onDestroy() {
        for (T onDestroy : Util.i(this.f17004b)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : Util.i(this.f17004b)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : Util.i(this.f17004b)) {
            onStop.onStop();
        }
    }
}

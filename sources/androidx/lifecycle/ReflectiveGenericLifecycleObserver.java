package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    private final Object f3717b;

    /* renamed from: c  reason: collision with root package name */
    private final ClassesInfoCache.CallbackInfo f3718c;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3717b = obj;
        this.f3718c = ClassesInfoCache.f3649c.c(obj.getClass());
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f3718c.a(lifecycleOwner, event, this.f3717b);
    }
}

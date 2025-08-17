package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    private final GeneratedAdapter f3754b;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f3754b = generatedAdapter;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f3754b.a(lifecycleOwner, event, false, (MethodCallsLogger) null);
        this.f3754b.a(lifecycleOwner, event, true, (MethodCallsLogger) null);
    }
}

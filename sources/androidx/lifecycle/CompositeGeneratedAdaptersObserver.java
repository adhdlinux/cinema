package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    private final GeneratedAdapter[] f3656b;

    CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.f3656b = generatedAdapterArr;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter a2 : this.f3656b) {
            a2.a(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter a3 : this.f3656b) {
            a3.a(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}

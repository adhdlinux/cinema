package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public class ServiceLifecycleDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleRegistry f3748a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3749b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private DispatchRunnable f3750c;

    static class DispatchRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final LifecycleRegistry f3751b;

        /* renamed from: c  reason: collision with root package name */
        final Lifecycle.Event f3752c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3753d = false;

        DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.f3751b = lifecycleRegistry;
            this.f3752c = event;
        }

        public void run() {
            if (!this.f3753d) {
                this.f3751b.h(this.f3752c);
                this.f3753d = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        this.f3748a = new LifecycleRegistry(lifecycleOwner);
    }

    private void f(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.f3750c;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.f3748a, event);
        this.f3750c = dispatchRunnable2;
        this.f3749b.postAtFrontOfQueue(dispatchRunnable2);
    }

    public Lifecycle a() {
        return this.f3748a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}

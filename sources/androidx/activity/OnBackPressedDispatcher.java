package androidx.activity;

import android.annotation.SuppressLint;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f33a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<OnBackPressedCallback> f34b;

    /* renamed from: c  reason: collision with root package name */
    private Consumer<Boolean> f35c;

    /* renamed from: d  reason: collision with root package name */
    private OnBackInvokedCallback f36d;

    /* renamed from: e  reason: collision with root package name */
    private OnBackInvokedDispatcher f37e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38f;

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedCallback a(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new g(runnable);
        }

        static void b(Object obj, int i2, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) obj2);
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* renamed from: b  reason: collision with root package name */
        private final Lifecycle f39b;

        /* renamed from: c  reason: collision with root package name */
        private final OnBackPressedCallback f40c;

        /* renamed from: d  reason: collision with root package name */
        private Cancellable f41d;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            this.f39b = lifecycle;
            this.f40c = onBackPressedCallback;
            lifecycle.a(this);
        }

        public void cancel() {
            this.f39b.c(this);
            this.f40c.e(this);
            Cancellable cancellable = this.f41d;
            if (cancellable != null) {
                cancellable.cancel();
                this.f41d = null;
            }
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f41d = OnBackPressedDispatcher.this.c(this.f40c);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.f41d;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    private class OnBackPressedCancellable implements Cancellable {

        /* renamed from: b  reason: collision with root package name */
        private final OnBackPressedCallback f43b;

        OnBackPressedCancellable(OnBackPressedCallback onBackPressedCallback) {
            this.f43b = onBackPressedCallback;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f34b.remove(this.f43b);
            this.f43b.e(this);
            if (BuildCompat.d()) {
                this.f43b.g((Consumer<Boolean>) null);
                OnBackPressedDispatcher.this.h();
            }
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(Boolean bool) {
        if (BuildCompat.d()) {
            h();
        }
    }

    @SuppressLint({"LambdaLast"})
    public void b(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
            if (BuildCompat.d()) {
                h();
                onBackPressedCallback.g(this.f35c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Cancellable c(OnBackPressedCallback onBackPressedCallback) {
        this.f34b.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedCallback);
        onBackPressedCallback.a(onBackPressedCancellable);
        if (BuildCompat.d()) {
            h();
            onBackPressedCallback.g(this.f35c);
        }
        return onBackPressedCancellable;
    }

    public boolean d() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f34b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().c()) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f34b.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f33a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void g(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.f37e = onBackInvokedDispatcher;
        h();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        boolean d2 = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f37e;
        if (onBackInvokedDispatcher == null) {
            return;
        }
        if (d2 && !this.f38f) {
            Api33Impl.b(onBackInvokedDispatcher, 0, this.f36d);
            this.f38f = true;
        } else if (!d2 && this.f38f) {
            Api33Impl.c(onBackInvokedDispatcher, this.f36d);
            this.f38f = false;
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f34b = new ArrayDeque<>();
        this.f38f = false;
        this.f33a = runnable;
        if (BuildCompat.d()) {
            this.f35c = new e(this);
            this.f36d = Api33Impl.a(new f(this));
        }
    }
}

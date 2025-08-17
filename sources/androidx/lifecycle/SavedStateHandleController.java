package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

final class SavedStateHandleController implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    private final String f3728b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3729c = false;

    /* renamed from: d  reason: collision with root package name */
    private final SavedStateHandle f3730d;

    SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.f3728b = str;
        this.f3730d = savedStateHandle;
    }

    /* access modifiers changed from: package-private */
    public void g(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.f3729c) {
            this.f3729c = true;
            lifecycle.a(this);
            savedStateRegistry.h(this.f3728b, this.f3730d.d());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* access modifiers changed from: package-private */
    public SavedStateHandle h() {
        return this.f3730d;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f3729c;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3729c = false;
            lifecycleOwner.getLifecycle().c(this);
        }
    }
}

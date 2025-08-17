package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateHandlesProvider f3727b;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        Intrinsics.f(savedStateHandlesProvider, "provider");
        this.f3727b = savedStateHandlesProvider;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        boolean z2;
        Intrinsics.f(lifecycleOwner, "source");
        Intrinsics.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            lifecycleOwner.getLifecycle().c(this);
            this.f3727b.d();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}

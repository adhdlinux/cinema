package q;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f21906b;

    public /* synthetic */ a(SavedStateRegistry savedStateRegistry) {
        this.f21906b = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.d(this.f21906b, lifecycleOwner, event);
    }
}

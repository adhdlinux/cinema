package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class o implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f2902b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f2903c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f2904d;

    public /* synthetic */ o(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f2902b = menuHostHelper;
        this.f2903c = state;
        this.f2904d = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f2902b.g(this.f2903c, this.f2904d, lifecycleOwner, event);
    }
}

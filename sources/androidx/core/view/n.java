package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class n implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f2899b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f2900c;

    public /* synthetic */ n(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f2899b = menuHostHelper;
        this.f2900c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f2899b.f(this.f2900c, lifecycleOwner, event);
    }
}

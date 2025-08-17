package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* renamed from: b  reason: collision with root package name */
    private final Fragment f3609b;

    /* renamed from: c  reason: collision with root package name */
    private final ViewModelStore f3610c;

    /* renamed from: d  reason: collision with root package name */
    private LifecycleRegistry f3611d = null;

    /* renamed from: e  reason: collision with root package name */
    private SavedStateRegistryController f3612e = null;

    FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.f3609b = fragment;
        this.f3610c = viewModelStore;
    }

    /* access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.f3611d.h(event);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f3611d == null) {
            this.f3611d = new LifecycleRegistry(this);
            this.f3612e = SavedStateRegistryController.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f3611d != null;
    }

    /* access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f3612e.d(bundle);
    }

    /* access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f3612e.e(bundle);
    }

    /* access modifiers changed from: package-private */
    public void f(Lifecycle.State state) {
        this.f3611d.o(state);
    }

    public /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public Lifecycle getLifecycle() {
        b();
        return this.f3611d;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f3612e.b();
    }

    public ViewModelStore getViewModelStore() {
        b();
        return this.f3610c;
    }
}

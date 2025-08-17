package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

public final class SavedStateHandleSupport {

    /* renamed from: a  reason: collision with root package name */
    public static final CreationExtras.Key<SavedStateRegistryOwner> f3731a = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();

    /* renamed from: b  reason: collision with root package name */
    public static final CreationExtras.Key<ViewModelStoreOwner> f3732b = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();

    /* renamed from: c  reason: collision with root package name */
    public static final CreationExtras.Key<Bundle> f3733c = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();

    public static final SavedStateHandle a(CreationExtras creationExtras) {
        Intrinsics.f(creationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.a(f3731a);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.a(f3732b);
            if (viewModelStoreOwner != null) {
                Bundle bundle = (Bundle) creationExtras.a(f3733c);
                String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f3768c);
                if (str != null) {
                    return b(savedStateRegistryOwner, viewModelStoreOwner, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle b(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, String str, Bundle bundle) {
        SavedStateHandlesProvider d2 = d(savedStateRegistryOwner);
        SavedStateHandlesVM e2 = e(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = e2.f().get(str);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        SavedStateHandle a2 = SavedStateHandle.f3720f.a(d2.a(str), bundle);
        e2.f().put(str, a2);
        return a2;
    }

    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void c(T t2) {
        boolean z2;
        Intrinsics.f(t2, "<this>");
        Lifecycle.State b2 = t2.getLifecycle().b();
        Intrinsics.e(b2, "lifecycle.currentState");
        if (b2 == Lifecycle.State.INITIALIZED || b2 == Lifecycle.State.CREATED) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (t2.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t2.getSavedStateRegistry(), (ViewModelStoreOwner) t2);
            t2.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t2.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(SavedStateRegistryOwner savedStateRegistryOwner) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        Intrinsics.f(savedStateRegistryOwner, "<this>");
        SavedStateRegistry.SavedStateProvider c2 = savedStateRegistryOwner.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if (c2 instanceof SavedStateHandlesProvider) {
            savedStateHandlesProvider = (SavedStateHandlesProvider) c2;
        } else {
            savedStateHandlesProvider = null;
        }
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM e(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.f(viewModelStoreOwner, "<this>");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        Class cls = SavedStateHandlesVM.class;
        initializerViewModelFactoryBuilder.a(Reflection.b(cls), SavedStateHandleSupport$savedStateHandlesVM$1$1.f3734f);
        return (SavedStateHandlesVM) new ViewModelProvider(viewModelStoreOwner, initializerViewModelFactoryBuilder.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", cls);
    }
}

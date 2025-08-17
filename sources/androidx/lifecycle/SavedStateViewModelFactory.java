package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;

public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    private Application f3741a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewModelProvider.Factory f3742b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3743c;

    /* renamed from: d  reason: collision with root package name */
    private Lifecycle f3744d;

    /* renamed from: e  reason: collision with root package name */
    private SavedStateRegistry f3745e;

    public SavedStateViewModelFactory() {
        this.f3742b = new ViewModelProvider.AndroidViewModelFactory();
    }

    public <T extends ViewModel> T a(Class<T> cls, CreationExtras creationExtras) {
        Constructor<T> constructor;
        Intrinsics.f(cls, "modelClass");
        Intrinsics.f(creationExtras, "extras");
        String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f3768c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (creationExtras.a(SavedStateHandleSupport.f3731a) != null && creationExtras.a(SavedStateHandleSupport.f3732b) != null) {
            Application application = (Application) creationExtras.a(ViewModelProvider.AndroidViewModelFactory.f3763g);
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                constructor = SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.f3747b);
            } else {
                constructor = SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.f3746a);
            }
            if (constructor == null) {
                return this.f3742b.a(cls, creationExtras);
            }
            if (!isAssignableFrom || application == null) {
                return SavedStateViewModelFactoryKt.d(cls, constructor, SavedStateHandleSupport.a(creationExtras));
            }
            return SavedStateViewModelFactoryKt.d(cls, constructor, application, SavedStateHandleSupport.a(creationExtras));
        } else if (this.f3744d != null) {
            return d(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public <T extends ViewModel> T b(Class<T> cls) {
        Intrinsics.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public void c(ViewModel viewModel) {
        Intrinsics.f(viewModel, "viewModel");
        Lifecycle lifecycle = this.f3744d;
        if (lifecycle != null) {
            LegacySavedStateHandleController.a(viewModel, this.f3745e, lifecycle);
        }
    }

    public final <T extends ViewModel> T d(String str, Class<T> cls) {
        Constructor<T> constructor;
        T t2;
        Application application;
        Intrinsics.f(str, "key");
        Intrinsics.f(cls, "modelClass");
        if (this.f3744d != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || this.f3741a == null) {
                constructor = SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.f3747b);
            } else {
                constructor = SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.f3746a);
            }
            if (constructor != null) {
                SavedStateHandleController b2 = LegacySavedStateHandleController.b(this.f3745e, this.f3744d, str, this.f3743c);
                if (!isAssignableFrom || (application = this.f3741a) == null) {
                    SavedStateHandle h2 = b2.h();
                    Intrinsics.e(h2, "controller.handle");
                    t2 = SavedStateViewModelFactoryKt.d(cls, constructor, h2);
                } else {
                    Intrinsics.c(application);
                    SavedStateHandle h3 = b2.h();
                    Intrinsics.e(h3, "controller.handle");
                    t2 = SavedStateViewModelFactoryKt.d(cls, constructor, application, h3);
                }
                t2.e("androidx.lifecycle.savedstate.vm.tag", b2);
                return t2;
            } else if (this.f3741a != null) {
                return this.f3742b.b(cls);
            } else {
                return ViewModelProvider.NewInstanceFactory.f3766a.a().b(cls);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.f(savedStateRegistryOwner, "owner");
        this.f3745e = savedStateRegistryOwner.getSavedStateRegistry();
        this.f3744d = savedStateRegistryOwner.getLifecycle();
        this.f3743c = bundle;
        this.f3741a = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.f3761e.a(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.f3742b = androidViewModelFactory;
    }
}

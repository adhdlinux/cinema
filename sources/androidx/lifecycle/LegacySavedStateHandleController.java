package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

class LegacySavedStateHandleController {

    static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        OnRecreation() {
        }

        public void a(SavedStateRegistryOwner savedStateRegistryOwner) {
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                for (String b2 : viewModelStore.c()) {
                    LegacySavedStateHandleController.a(viewModelStore.b(b2), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.i(OnRecreation.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
    }

    private LegacySavedStateHandleController() {
    }

    static void a(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.i()) {
            savedStateHandleController.g(savedStateRegistry, lifecycle);
            c(savedStateRegistry, lifecycle);
        }
    }

    static SavedStateHandleController b(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.c(savedStateRegistry.b(str), bundle));
        savedStateHandleController.g(savedStateRegistry, lifecycle);
        c(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private static void c(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State b2 = lifecycle.b();
        if (b2 == Lifecycle.State.INITIALIZED || b2.a(Lifecycle.State.STARTED)) {
            savedStateRegistry.i(OnRecreation.class);
        } else {
            lifecycle.a(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.c(this);
                        savedStateRegistry.i(OnRecreation.class);
                    }
                }
            });
        }
    }
}

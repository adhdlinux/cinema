package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Recreator implements LifecycleEventObserver {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f11559c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistryOwner f11560b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Set<String> f11561a = new LinkedHashSet();

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            Intrinsics.f(savedStateRegistry, "registry");
            savedStateRegistry.h("androidx.savedstate.Restarter", this);
        }

        public final void a(String str) {
            Intrinsics.f(str, "className");
            this.f11561a.add(str);
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f11561a));
            return bundle;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.f(savedStateRegistryOwner, "owner");
        this.f11560b = savedStateRegistryOwner;
    }

    private final void g(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            Intrinsics.e(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    Intrinsics.e(newInstance, "{\n                constr…wInstance()\n            }");
                    ((SavedStateRegistry.AutoRecreated) newInstance).a(this.f11560b);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.f(lifecycleOwner, "source");
        Intrinsics.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().c(this);
            Bundle b2 = this.f11560b.getSavedStateRegistry().b("androidx.savedstate.Restarter");
            if (b2 != null) {
                ArrayList<String> stringArrayList = b2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String g2 : stringArrayList) {
                        g(g2);
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}

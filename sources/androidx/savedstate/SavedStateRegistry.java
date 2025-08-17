package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q.a;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: g  reason: collision with root package name */
    private static final Companion f11562g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SafeIterableMap<String, SavedStateProvider> f11563a = new SafeIterableMap<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f11564b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f11565c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11566d;

    /* renamed from: e  reason: collision with root package name */
    private Recreator.SavedStateProvider f11567e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11568f = true;

    public interface AutoRecreated {
        void a(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface SavedStateProvider {
        Bundle b();
    }

    /* access modifiers changed from: private */
    public static final void d(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.f(savedStateRegistry, "this$0");
        Intrinsics.f(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistry.f11568f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistry.f11568f = false;
        }
    }

    public final Bundle b(String str) {
        Bundle bundle;
        Intrinsics.f(str, "key");
        if (this.f11566d) {
            Bundle bundle2 = this.f11565c;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(str);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.f11565c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f11565c;
            boolean z2 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z2 = true;
            }
            if (!z2) {
                this.f11565c = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final SavedStateProvider c(String str) {
        Intrinsics.f(str, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it2 = this.f11563a.iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            Intrinsics.e(next, "components");
            SavedStateProvider savedStateProvider = (SavedStateProvider) next.getValue();
            if (Intrinsics.a((String) next.getKey(), str)) {
                return savedStateProvider;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        Intrinsics.f(lifecycle, "lifecycle");
        if (!this.f11564b) {
            lifecycle.a(new a(this));
            this.f11564b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void f(Bundle bundle) {
        Bundle bundle2;
        if (!this.f11564b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.f11566d) {
            if (bundle != null) {
                bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            } else {
                bundle2 = null;
            }
            this.f11565c = bundle2;
            this.f11566d = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    public final void g(Bundle bundle) {
        Intrinsics.f(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f11565c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.IteratorWithAdditions c2 = this.f11563a.c();
        Intrinsics.e(c2, "this.components.iteratorWithAdditions()");
        while (c2.hasNext()) {
            Map.Entry entry = (Map.Entry) c2.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).b());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }

    public final void h(String str, SavedStateProvider savedStateProvider) {
        boolean z2;
        Intrinsics.f(str, "key");
        Intrinsics.f(savedStateProvider, "provider");
        if (this.f11563a.g(str, savedStateProvider) == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends AutoRecreated> cls) {
        Intrinsics.f(cls, "clazz");
        if (this.f11568f) {
            Recreator.SavedStateProvider savedStateProvider = this.f11567e;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.f11567e = savedStateProvider;
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.SavedStateProvider savedStateProvider2 = this.f11567e;
                if (savedStateProvider2 != null) {
                    String name = cls.getName();
                    Intrinsics.e(name, "clazz.name");
                    savedStateProvider2.a(name);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }
}

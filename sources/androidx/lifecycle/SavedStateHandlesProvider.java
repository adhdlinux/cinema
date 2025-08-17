package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistry f3735a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3736b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3737c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f3738d;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.f(savedStateRegistry, "savedStateRegistry");
        Intrinsics.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f3735a = savedStateRegistry;
        this.f3738d = LazyKt__LazyJVMKt.b(new SavedStateHandlesProvider$viewModel$2(viewModelStoreOwner));
    }

    private final SavedStateHandlesVM c() {
        return (SavedStateHandlesVM) this.f3738d.getValue();
    }

    public final Bundle a(String str) {
        Bundle bundle;
        Intrinsics.f(str, "key");
        d();
        Bundle bundle2 = this.f3737c;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(str);
        } else {
            bundle = null;
        }
        Bundle bundle3 = this.f3737c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f3737c;
        boolean z2 = false;
        if (bundle4 != null && bundle4.isEmpty()) {
            z2 = true;
        }
        if (z2) {
            this.f3737c = null;
        }
        return bundle;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3737c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry next : c().f().entrySet()) {
            String str = (String) next.getKey();
            Bundle b2 = ((SavedStateHandle) next.getValue()).d().b();
            if (!Intrinsics.a(b2, Bundle.EMPTY)) {
                bundle.putBundle(str, b2);
            }
        }
        this.f3736b = false;
        return bundle;
    }

    public final void d() {
        if (!this.f3736b) {
            this.f3737c = this.f3735a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.f3736b = true;
            c();
        }
    }
}

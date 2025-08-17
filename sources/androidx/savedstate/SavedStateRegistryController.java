package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class SavedStateRegistryController {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f11569d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistryOwner f11570a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f11571b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11572c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SavedStateRegistryController a(SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.f(savedStateRegistryOwner, "owner");
            return new SavedStateRegistryController(savedStateRegistryOwner, (DefaultConstructorMarker) null);
        }
    }

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.f11570a = savedStateRegistryOwner;
        this.f11571b = new SavedStateRegistry();
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(savedStateRegistryOwner);
    }

    public static final SavedStateRegistryController a(SavedStateRegistryOwner savedStateRegistryOwner) {
        return f11569d.a(savedStateRegistryOwner);
    }

    public final SavedStateRegistry b() {
        return this.f11571b;
    }

    public final void c() {
        boolean z2;
        Lifecycle lifecycle = this.f11570a.getLifecycle();
        Intrinsics.e(lifecycle, "owner.lifecycle");
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            lifecycle.a(new Recreator(this.f11570a));
            this.f11571b.e(lifecycle);
            this.f11572c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void d(Bundle bundle) {
        if (!this.f11572c) {
            c();
        }
        Lifecycle lifecycle = this.f11570a.getLifecycle();
        Intrinsics.e(lifecycle, "owner.lifecycle");
        if (!lifecycle.b().a(Lifecycle.State.STARTED)) {
            this.f11571b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        Intrinsics.f(bundle, "outBundle");
        this.f11571b.g(bundle);
    }
}

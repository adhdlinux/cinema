package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;

final class BundleApi18ImplKt {

    /* renamed from: a  reason: collision with root package name */
    public static final BundleApi18ImplKt f2608a = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(str, "key");
        bundle.putBinder(str, iBinder);
    }
}

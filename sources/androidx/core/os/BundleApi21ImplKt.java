package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import kotlin.jvm.internal.Intrinsics;

final class BundleApi21ImplKt {

    /* renamed from: a  reason: collision with root package name */
    public static final BundleApi21ImplKt f2609a = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    public static final void a(Bundle bundle, String str, Size size) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(str, "key");
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}

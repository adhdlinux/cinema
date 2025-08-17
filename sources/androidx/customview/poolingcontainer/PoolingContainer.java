package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import kotlin.jvm.internal.Intrinsics;

public final class PoolingContainer {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2993a = R$id.pooling_container_listener_holder_tag;

    /* renamed from: b  reason: collision with root package name */
    private static final int f2994b = R$id.is_pooling_container_tag;

    public static final void a(View view) {
        Intrinsics.f(view, "<this>");
        for (View c2 : ViewKt.a(view)) {
            c(c2).a();
        }
    }

    public static final void b(ViewGroup viewGroup) {
        Intrinsics.f(viewGroup, "<this>");
        for (View c2 : ViewGroupKt.a(viewGroup)) {
            c(c2).a();
        }
    }

    private static final PoolingContainerListenerHolder c(View view) {
        int i2 = f2993a;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i2);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i2, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final void d(View view, boolean z2) {
        Intrinsics.f(view, "<this>");
        view.setTag(f2994b, Boolean.valueOf(z2));
    }
}

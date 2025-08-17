package androidx.customview.poolingcontainer;

import java.util.ArrayList;

final class PoolingContainerListenerHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<PoolingContainerListener> f2995a = new ArrayList<>();

    public final void a() {
        for (int h2 = CollectionsKt__CollectionsKt.h(this.f2995a); -1 < h2; h2--) {
            this.f2995a.get(h2).a();
        }
    }
}

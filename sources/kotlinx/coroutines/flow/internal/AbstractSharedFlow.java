package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* renamed from: a  reason: collision with root package name */
    private S[] f40715a;

    /* access modifiers changed from: protected */
    public final S[] b() {
        return this.f40715a;
    }
}

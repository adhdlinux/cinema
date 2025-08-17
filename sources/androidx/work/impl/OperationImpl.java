package androidx.work.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

public class OperationImpl implements Operation {

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Operation.State> f12243c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private final SettableFuture<Operation.State.SUCCESS> f12244d = SettableFuture.s();

    public OperationImpl() {
        a(Operation.f12195b);
    }

    public void a(Operation.State state) {
        this.f12243c.l(state);
        if (state instanceof Operation.State.SUCCESS) {
            this.f12244d.o((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            this.f12244d.p(((Operation.State.FAILURE) state).a());
        }
    }
}

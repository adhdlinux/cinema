package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public final class JobSupport$addLastAtomic$$inlined$addLastIf$1 extends LockFreeLinkedListNode.CondAddOp {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ JobSupport f40666d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Object f40667e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobSupport$addLastAtomic$$inlined$addLastIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
        super(lockFreeLinkedListNode);
        this.f40666d = jobSupport;
        this.f40667e = obj;
    }

    /* renamed from: f */
    public Object d(LockFreeLinkedListNode lockFreeLinkedListNode) {
        boolean z2;
        if (this.f40666d.O() == this.f40667e) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return null;
        }
        return LockFreeLinkedListKt.a();
    }
}

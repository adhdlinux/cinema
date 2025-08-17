package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugStringsKt;

public class LockFreeLinkedListNode {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f40746b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40747c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40748d;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f40749b;

        /* renamed from: c  reason: collision with root package name */
        public LockFreeLinkedListNode f40750c;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f40749b = lockFreeLinkedListNode;
        }

        /* renamed from: e */
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z2;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                lockFreeLinkedListNode2 = this.f40749b;
            } else {
                lockFreeLinkedListNode2 = this.f40750c;
            }
            if (lockFreeLinkedListNode2 != null && a.a(LockFreeLinkedListNode.f40746b, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z2) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f40749b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f40750c;
                Intrinsics.c(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.i(lockFreeLinkedListNode4);
            }
        }
    }

    static {
        Class<LockFreeLinkedListNode> cls = LockFreeLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        f40746b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f40747c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        f40748d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (androidx.concurrent.futures.a.a(r4, r3, r2, ((kotlinx.coroutines.internal.Removed) r5).f40767a) != false) goto L_0x0045;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.internal.LockFreeLinkedListNode g(kotlinx.coroutines.internal.OpDescriptor r9) {
        /*
            r8 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f40747c
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L_0x000a:
            r3 = r1
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f40746b
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L_0x0020
            if (r0 != r2) goto L_0x0016
            return r2
        L_0x0016:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f40747c
            boolean r0 = androidx.concurrent.futures.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L_0x001f
            goto L_0x0000
        L_0x001f:
            return r2
        L_0x0020:
            boolean r6 = r8.m()
            if (r6 == 0) goto L_0x0027
            return r1
        L_0x0027:
            if (r5 != r9) goto L_0x002a
            return r2
        L_0x002a:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r6 == 0) goto L_0x0034
            kotlinx.coroutines.internal.OpDescriptor r5 = (kotlinx.coroutines.internal.OpDescriptor) r5
            r5.a(r2)
            goto L_0x0000
        L_0x0034:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.Removed
            if (r6 == 0) goto L_0x0050
            if (r3 == 0) goto L_0x0047
            kotlinx.coroutines.internal.Removed r5 = (kotlinx.coroutines.internal.Removed) r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.f40767a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L_0x0045
            goto L_0x0000
        L_0x0045:
            r2 = r3
            goto L_0x000a
        L_0x0047:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f40747c
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L_0x000b
        L_0x0050:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.Intrinsics.d(r5, r3)
            r3 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.g(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode h(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.m()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f40747c.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    /* access modifiers changed from: private */
    public final void i(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40747c;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (j() != lockFreeLinkedListNode) {
                return;
            }
        } while (!a.a(f40747c, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (m()) {
            lockFreeLinkedListNode.g((OpDescriptor) null);
        }
    }

    private final Removed p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40748d;
        Removed removed = (Removed) atomicReferenceFieldUpdater.get(this);
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        atomicReferenceFieldUpdater.lazySet(this, removed2);
        return removed2;
    }

    public final boolean f(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f40747c.lazySet(lockFreeLinkedListNode, this);
        f40746b.lazySet(lockFreeLinkedListNode, this);
        while (j() == this) {
            if (a.a(f40746b, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.i(this);
                return true;
            }
        }
        return false;
    }

    public final Object j() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40746b;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode k() {
        return LockFreeLinkedListKt.b(j());
    }

    public final LockFreeLinkedListNode l() {
        LockFreeLinkedListNode g2 = g((OpDescriptor) null);
        return g2 == null ? h((LockFreeLinkedListNode) f40747c.get(this)) : g2;
    }

    public boolean m() {
        return j() instanceof Removed;
    }

    public boolean n() {
        return o() == null;
    }

    public final LockFreeLinkedListNode o() {
        Object j2;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            j2 = j();
            if (j2 instanceof Removed) {
                return ((Removed) j2).f40767a;
            }
            if (j2 == this) {
                return (LockFreeLinkedListNode) j2;
            }
            Intrinsics.d(j2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) j2;
        } while (!a.a(f40746b, this, j2, lockFreeLinkedListNode.p()));
        lockFreeLinkedListNode.g((OpDescriptor) null);
        return null;
    }

    public final int q(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        f40747c.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40746b;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.f40750c = lockFreeLinkedListNode2;
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        if (condAddOp.a(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + DebugStringsKt.b(this);
    }
}

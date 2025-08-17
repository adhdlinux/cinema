package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40722b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40723c;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        Class<ConcurrentLinkedListNode> cls = ConcurrentLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        f40722b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f40723c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public ConcurrentLinkedListNode(N n2) {
        this._prev = n2;
    }

    private final N c() {
        N g2 = g();
        while (g2 != null && g2.h()) {
            g2 = (ConcurrentLinkedListNode) f40723c.get(g2);
        }
        return g2;
    }

    private final N d() {
        N e2;
        N e3 = e();
        Intrinsics.c(e3);
        while (e3.h() && (e2 = e3.e()) != null) {
            e3 = e2;
        }
        return e3;
    }

    /* access modifiers changed from: private */
    public final Object f() {
        return f40722b.get(this);
    }

    public final void b() {
        f40723c.lazySet(this, (Object) null);
    }

    public final N e() {
        N a2 = f();
        if (a2 == ConcurrentLinkedListKt.f40721a) {
            return null;
        }
        return (ConcurrentLinkedListNode) a2;
    }

    public final N g() {
        return (ConcurrentLinkedListNode) f40723c.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final void j() {
        Object obj;
        ConcurrentLinkedListNode concurrentLinkedListNode;
        if (!i()) {
            while (true) {
                ConcurrentLinkedListNode c2 = c();
                ConcurrentLinkedListNode d2 = d();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40723c;
                do {
                    obj = atomicReferenceFieldUpdater.get(d2);
                    if (((ConcurrentLinkedListNode) obj) == null) {
                        concurrentLinkedListNode = null;
                    } else {
                        concurrentLinkedListNode = c2;
                    }
                } while (!a.a(atomicReferenceFieldUpdater, d2, obj, concurrentLinkedListNode));
                if (c2 != null) {
                    f40722b.set(c2, d2);
                }
                if ((!d2.h() || d2.i()) && (c2 == null || !c2.h())) {
                    return;
                }
            }
        }
    }

    public final boolean k(N n2) {
        return a.a(f40722b, this, (Object) null, n2);
    }
}

package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f39919b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f39920c = new AtomicReference<>();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {

        /* renamed from: b  reason: collision with root package name */
        private E f39921b;

        LinkedQueueNode() {
        }

        public E a() {
            E b2 = b();
            e((Object) null);
            return b2;
        }

        public E b() {
            return this.f39921b;
        }

        public LinkedQueueNode<E> c() {
            return (LinkedQueueNode) get();
        }

        public void d(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void e(E e2) {
            this.f39921b = e2;
        }

        LinkedQueueNode(E e2) {
            e(e2);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        e(linkedQueueNode);
        f(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> a() {
        return this.f39920c.get();
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> c() {
        return this.f39920c.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.queue.MpscLinkedQueue.clear():void");
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> d() {
        return this.f39919b.get();
    }

    /* access modifiers changed from: package-private */
    public void e(LinkedQueueNode<T> linkedQueueNode) {
        this.f39920c.lazySet(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> f(LinkedQueueNode<T> linkedQueueNode) {
        return this.f39919b.getAndSet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return c() == d();
    }

    public boolean offer(T t2) {
        if (t2 != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t2);
            f(linkedQueueNode).d(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        LinkedQueueNode c2;
        LinkedQueueNode a2 = a();
        LinkedQueueNode c3 = a2.c();
        if (c3 != null) {
            T a3 = c3.a();
            e(c3);
            return a3;
        } else if (a2 == d()) {
            return null;
        } else {
            do {
                c2 = a2.c();
            } while (c2 == null);
            T a4 = c2.a();
            e(c2);
            return a4;
        }
    }
}

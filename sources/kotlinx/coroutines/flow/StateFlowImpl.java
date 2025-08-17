package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40710c = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: b  reason: collision with root package name */
    private int f40711b;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r8 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r0 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r3 >= r0) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        if (r4 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        r4.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8 = r6.f40711b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0043, code lost:
        if (r8 != r7) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
        r6.f40711b = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r7 = b();
        r0 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0051, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean c(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f40710c     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r0.get(r6)     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r7 == 0) goto L_0x0012
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r1, r7)     // Catch:{ all -> 0x005e }
            if (r7 != 0) goto L_0x0012
            monitor-exit(r6)
            return r2
        L_0x0012:
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r1, r8)     // Catch:{ all -> 0x005e }
            r1 = 1
            if (r7 == 0) goto L_0x001b
            monitor-exit(r6)
            return r1
        L_0x001b:
            r0.set(r6, r8)     // Catch:{ all -> 0x005e }
            int r7 = r6.f40711b     // Catch:{ all -> 0x005e }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x0058
            int r7 = r7 + r1
            r6.f40711b = r7     // Catch:{ all -> 0x005e }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r8 = r6.b()     // Catch:{ all -> 0x005e }
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x005e }
            monitor-exit(r6)
        L_0x002e:
            kotlinx.coroutines.flow.StateFlowSlot[] r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8
            if (r8 == 0) goto L_0x0040
            int r0 = r8.length
            r3 = 0
        L_0x0034:
            if (r3 >= r0) goto L_0x0040
            r4 = r8[r3]
            if (r4 == 0) goto L_0x003d
            r4.a()
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x0040:
            monitor-enter(r6)
            int r8 = r6.f40711b     // Catch:{ all -> 0x0055 }
            if (r8 != r7) goto L_0x004a
            int r7 = r7 + r1
            r6.f40711b = r7     // Catch:{ all -> 0x0055 }
            monitor-exit(r6)
            return r1
        L_0x004a:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r6.b()     // Catch:{ all -> 0x0055 }
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0055 }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x002e
        L_0x0055:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0058:
            int r7 = r7 + 2
            r6.f40711b = r7     // Catch:{ all -> 0x005e }
            monitor-exit(r6)
            return r1
        L_0x005e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.c(java.lang.Object, java.lang.Object):boolean");
    }

    public boolean a(T t2, T t3) {
        if (t2 == null) {
            t2 = NullSurrogateKt.f40716a;
        }
        if (t3 == null) {
            t3 = NullSurrogateKt.f40716a;
        }
        return c(t2, t3);
    }

    public T getValue() {
        T t2 = NullSurrogateKt.f40716a;
        T t3 = f40710c.get(this);
        if (t3 == t2) {
            return null;
        }
        return t3;
    }

    public void setValue(T t2) {
        if (t2 == null) {
            t2 = NullSurrogateKt.f40716a;
        }
        c((Object) null, t2);
    }
}

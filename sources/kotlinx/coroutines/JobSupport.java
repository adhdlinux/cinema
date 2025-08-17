package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;

public class JobSupport implements Job, ChildJob, ParentJob {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40664b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40665c;
    private volatile Object _parentHandle;
    private volatile Object _state;

    private static final class ChildCompletion extends JobNode {

        /* renamed from: f  reason: collision with root package name */
        private final JobSupport f40668f;

        /* renamed from: g  reason: collision with root package name */
        private final Finishing f40669g;

        /* renamed from: h  reason: collision with root package name */
        private final ChildHandleNode f40670h;

        /* renamed from: i  reason: collision with root package name */
        private final Object f40671i;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.f40668f = jobSupport;
            this.f40669g = finishing;
            this.f40670h = childHandleNode;
            this.f40671i = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            r((Throwable) obj);
            return Unit.f40298a;
        }

        public void r(Throwable th) {
            this.f40668f.A(this.f40669g, this.f40670h, this.f40671i);
        }
    }

    private static final class Finishing implements Incomplete {

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f40672c;

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f40673d;

        /* renamed from: e  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f40674e;
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: b  reason: collision with root package name */
        private final NodeList f40675b;

        static {
            Class<Finishing> cls = Finishing.class;
            f40672c = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting");
            Class<Object> cls2 = Object.class;
            f40673d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause");
            f40674e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder");
        }

        public Finishing(NodeList nodeList, boolean z2, Throwable th) {
            this.f40675b = nodeList;
            this._isCompleting = z2 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return f40674e.get(this);
        }

        private final void k(Object obj) {
            f40674e.set(this, obj);
        }

        public NodeList a() {
            return this.f40675b;
        }

        public final void b(Throwable th) {
            Throwable e2 = e();
            if (e2 == null) {
                l(th);
            } else if (th != e2) {
                Object d2 = d();
                if (d2 == null) {
                    k(th);
                } else if (d2 instanceof Throwable) {
                    if (th != d2) {
                        ArrayList<Throwable> c2 = c();
                        c2.add(d2);
                        c2.add(th);
                        k(c2);
                    }
                } else if (d2 instanceof ArrayList) {
                    ((ArrayList) d2).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d2).toString());
                }
            }
        }

        public final Throwable e() {
            return (Throwable) f40673d.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            if (f40672c.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final boolean h() {
            return d() == JobSupportKt.f40680e;
        }

        public final List<Throwable> i(Throwable th) {
            ArrayList<Throwable> arrayList;
            Object d2 = d();
            if (d2 == null) {
                arrayList = c();
            } else if (d2 instanceof Throwable) {
                ArrayList<Throwable> c2 = c();
                c2.add(d2);
                arrayList = c2;
            } else if (d2 instanceof ArrayList) {
                arrayList = (ArrayList) d2;
            } else {
                throw new IllegalStateException(("State is " + d2).toString());
            }
            Throwable e2 = e();
            if (e2 != null) {
                arrayList.add(0, e2);
            }
            if (th != null && !Intrinsics.a(th, e2)) {
                arrayList.add(th);
            }
            k(JobSupportKt.f40680e);
            return arrayList;
        }

        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z2) {
            f40672c.set(this, z2 ? 1 : 0);
        }

        public final void l(Throwable th) {
            f40673d.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    static {
        Class<JobSupport> cls = JobSupport.class;
        Class<Object> cls2 = Object.class;
        f40664b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        f40665c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public JobSupport(boolean z2) {
        Empty empty;
        if (z2) {
            empty = JobSupportKt.f40682g;
        } else {
            empty = JobSupportKt.f40681f;
        }
        this._state = empty;
    }

    /* access modifiers changed from: private */
    public final void A(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode Y = Y(childHandleNode);
        if (Y == null || !t0(finishing, Y, obj)) {
            n(E(finishing, obj));
        }
    }

    private final Throwable C(Object obj) {
        boolean z2;
        if (obj == null) {
            z2 = true;
        } else {
            z2 = obj instanceof Throwable;
        }
        if (z2) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(w(), (Throwable) null, this);
            }
            return th;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).H();
    }

    private final Object E(Finishing finishing, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th;
        boolean f2;
        Throwable I;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.f40605a;
        } else {
            th = null;
        }
        synchronized (finishing) {
            f2 = finishing.f();
            List<Throwable> i2 = finishing.i(th);
            I = I(finishing, i2);
            if (I != null) {
                m(I, i2);
            }
        }
        boolean z2 = false;
        if (!(I == null || I == th)) {
            obj = new CompletedExceptionally(I, false, 2, (DefaultConstructorMarker) null);
        }
        if (I != null) {
            if (u(I) || P(I)) {
                z2 = true;
            }
            if (z2) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((CompletedExceptionally) obj).b();
            }
        }
        if (!f2) {
            b0(I);
        }
        c0(obj);
        a.a(f40664b, this, finishing, JobSupportKt.g(obj));
        y(finishing, obj);
        return obj;
    }

    private final ChildHandleNode F(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList a2 = incomplete.a();
        if (a2 != null) {
            return Y(a2);
        }
        return null;
    }

    private final Throwable G(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f40605a;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable I(kotlinx.coroutines.JobSupport.Finishing r6, java.util.List<? extends java.lang.Throwable> r7) {
        /*
            r5 = this;
            boolean r0 = r7.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r6 = r6.f()
            if (r6 == 0) goto L_0x0017
            kotlinx.coroutines.JobCancellationException r6 = new kotlinx.coroutines.JobCancellationException
            java.lang.String r7 = r5.w()
            r6.<init>(r7, r1, r5)
            return r6
        L_0x0017:
            return r1
        L_0x0018:
            r6 = r7
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r0 = r6.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r0.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r4 = r4 instanceof java.util.concurrent.CancellationException
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x001f
            goto L_0x0034
        L_0x0033:
            r2 = r1
        L_0x0034:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == 0) goto L_0x0039
            return r2
        L_0x0039:
            r0 = 0
            java.lang.Object r7 = r7.get(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r2 = r7 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r2 == 0) goto L_0x0066
            java.util.Iterator r6 = r6.iterator()
        L_0x0048:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r6.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == r7) goto L_0x005d
            boolean r4 = r4 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r4 == 0) goto L_0x005d
            r4 = 1
            goto L_0x005e
        L_0x005d:
            r4 = 0
        L_0x005e:
            if (r4 == 0) goto L_0x0048
            r1 = r2
        L_0x0061:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0066
            return r1
        L_0x0066:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.I(kotlinx.coroutines.JobSupport$Finishing, java.util.List):java.lang.Throwable");
    }

    private final NodeList M(Incomplete incomplete) {
        NodeList a2 = incomplete.a();
        if (a2 != null) {
            return a2;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            f0((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        Z(((kotlinx.coroutines.JobSupport.Finishing) r2).a(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return kotlinx.coroutines.JobSupportKt.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object U(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.O()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r3 == 0) goto L_0x0051
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.h()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f40679d     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.f()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.C(r7)     // Catch:{ all -> 0x004e }
        L_0x002b:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x004e }
            r7.b(r1)     // Catch:{ all -> 0x004e }
        L_0x0031:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x004e }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x004e }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r7 = r2.a()
            r6.Z(r7, r0)
        L_0x0049:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f40676a
            return r7
        L_0x004e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0051:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x005b
            java.lang.Throwable r1 = r6.C(r7)
        L_0x005b:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x006f
            boolean r2 = r6.q0(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f40676a
            return r7
        L_0x006f:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.r0(r2, r3)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.f40676a
            if (r3 == r4) goto L_0x0087
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.JobSupportKt.f40678c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a2:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f40679d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.U(java.lang.Object):java.lang.Object");
    }

    private final JobNode W(Function1<? super Throwable, Unit> function1, boolean z2) {
        JobNode jobNode = null;
        if (z2) {
            if (function1 instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            if (function1 instanceof JobNode) {
                jobNode = (JobNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.t(this);
        return jobNode;
    }

    private final ChildHandleNode Y(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.m()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.l();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
            if (!lockFreeLinkedListNode.m()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void Z(NodeList nodeList, Throwable th) {
        b0(th);
        Object j2 = nodeList.j();
        Intrinsics.d(j2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) j2; !Intrinsics.a(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.k()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.r(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f40298a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Q(completionHandlerException);
        }
        u(th);
    }

    private final void a0(NodeList nodeList, Throwable th) {
        Object j2 = nodeList.j();
        Intrinsics.d(j2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) j2; !Intrinsics.a(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.k()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.r(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f40298a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Q(completionHandlerException);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e0(kotlinx.coroutines.Empty r3) {
        /*
            r2 = this;
            kotlinx.coroutines.NodeList r0 = new kotlinx.coroutines.NodeList
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.InactiveNodeList r1 = new kotlinx.coroutines.InactiveNodeList
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f40664b
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.e0(kotlinx.coroutines.Empty):void");
    }

    private final void f0(JobNode jobNode) {
        jobNode.f(new NodeList());
        a.a(f40664b, this, jobNode, jobNode.k());
    }

    private final int i0(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!a.a(f40664b, this, obj, JobSupportKt.f40682g)) {
                return -1;
            }
            d0();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!a.a(f40664b, this, obj, ((InactiveNodeList) obj).a())) {
                return -1;
            }
            d0();
            return 1;
        }
    }

    private final String k0(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.f()) {
                return "Cancelling";
            }
            if (finishing.g()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof Incomplete) {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof CompletedExceptionally) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    private final boolean l(Object obj, NodeList nodeList, JobNode jobNode) {
        int q2;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, this, obj);
        do {
            q2 = nodeList.l().q(jobNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (q2 == 1) {
                return true;
            }
        } while (q2 != 2);
        return false;
    }

    private final void m(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            for (Throwable th2 : list) {
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    ExceptionsKt__ExceptionsKt.a(th, th2);
                }
            }
        }
    }

    public static /* synthetic */ CancellationException n0(JobSupport jobSupport, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return jobSupport.l0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean p0(Incomplete incomplete, Object obj) {
        if (!a.a(f40664b, this, incomplete, JobSupportKt.g(obj))) {
            return false;
        }
        b0((Throwable) null);
        c0(obj);
        y(incomplete, obj);
        return true;
    }

    private final boolean q0(Incomplete incomplete, Throwable th) {
        NodeList M = M(incomplete);
        if (M == null) {
            return false;
        }
        if (!a.a(f40664b, this, incomplete, new Finishing(M, false, th))) {
            return false;
        }
        Z(M, th);
        return true;
    }

    private final Object r0(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.f40676a;
        }
        if ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) {
            return s0((Incomplete) obj, obj2);
        }
        if (p0((Incomplete) obj, obj2)) {
            return obj2;
        }
        return JobSupportKt.f40678c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        if (r2 == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
        Z(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        r9 = F(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0077, code lost:
        if (r9 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007d, code lost:
        if (t0(r1, r9, r10) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0081, code lost:
        return kotlinx.coroutines.JobSupportKt.f40677b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0086, code lost:
        return E(r1, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object s0(kotlinx.coroutines.Incomplete r9, java.lang.Object r10) {
        /*
            r8 = this;
            kotlinx.coroutines.NodeList r0 = r8.M(r9)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.f40678c
            return r9
        L_0x000b:
            boolean r1 = r9 instanceof kotlinx.coroutines.JobSupport.Finishing
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r9
            kotlinx.coroutines.JobSupport$Finishing r1 = (kotlinx.coroutines.JobSupport.Finishing) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$Finishing r1 = new kotlinx.coroutines.JobSupport$Finishing
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            monitor-enter(r1)
            boolean r5 = r1.g()     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x002f
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.f40676a     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            return r9
        L_0x002f:
            r5 = 1
            r1.j(r5)     // Catch:{ all -> 0x0087 }
            if (r1 == r9) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f40664b     // Catch:{ all -> 0x0087 }
            boolean r6 = androidx.concurrent.futures.a.a(r6, r8, r9, r1)     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x0043
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.f40678c     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            return r9
        L_0x0043:
            boolean r6 = r1.f()     // Catch:{ all -> 0x0087 }
            boolean r7 = r10 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x0087 }
            if (r7 == 0) goto L_0x004f
            r7 = r10
            kotlinx.coroutines.CompletedExceptionally r7 = (kotlinx.coroutines.CompletedExceptionally) r7     // Catch:{ all -> 0x0087 }
            goto L_0x0050
        L_0x004f:
            r7 = r2
        L_0x0050:
            if (r7 == 0) goto L_0x0057
            java.lang.Throwable r7 = r7.f40605a     // Catch:{ all -> 0x0087 }
            r1.b(r7)     // Catch:{ all -> 0x0087 }
        L_0x0057:
            java.lang.Throwable r7 = r1.e()     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x005e
            r3 = 1
        L_0x005e:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0087 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0069
            r2 = r7
        L_0x0069:
            r4.f40429b = r2     // Catch:{ all -> 0x0087 }
            kotlin.Unit r3 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0073
            r8.Z(r0, r2)
        L_0x0073:
            kotlinx.coroutines.ChildHandleNode r9 = r8.F(r9)
            if (r9 == 0) goto L_0x0082
            boolean r9 = r8.t0(r1, r9, r10)
            if (r9 == 0) goto L_0x0082
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.JobSupportKt.f40677b
            return r9
        L_0x0082:
            java.lang.Object r9 = r8.E(r1, r10)
            return r9
        L_0x0087:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.s0(kotlinx.coroutines.Incomplete, java.lang.Object):java.lang.Object");
    }

    private final Object t(Object obj) {
        Object r02;
        do {
            Object O = O();
            if (!(O instanceof Incomplete) || ((O instanceof Finishing) && ((Finishing) O).g())) {
                return JobSupportKt.f40676a;
            }
            r02 = r0(O, new CompletedExceptionally(C(obj), false, 2, (DefaultConstructorMarker) null));
        } while (r02 == JobSupportKt.f40678c);
        return r02;
    }

    private final boolean t0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.d(childHandleNode.f40598f, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, (Object) null) == NonDisposableHandle.f40684b) {
            childHandleNode = Y(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean u(Throwable th) {
        if (T()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        ChildHandle N = N();
        if (N == null || N == NonDisposableHandle.f40684b) {
            return z2;
        }
        if (N.b(th) || z2) {
            return true;
        }
        return false;
    }

    private final void y(Incomplete incomplete, Object obj) {
        CompletedExceptionally completedExceptionally;
        ChildHandle N = N();
        if (N != null) {
            N.dispose();
            h0(NonDisposableHandle.f40684b);
        }
        Throwable th = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.f40605a;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).r(th);
            } catch (Throwable th2) {
                Q(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList a2 = incomplete.a();
            if (a2 != null) {
                a0(a2, th);
            }
        }
    }

    public CancellationException H() {
        Throwable th;
        Object O = O();
        CancellationException cancellationException = null;
        if (O instanceof Finishing) {
            th = ((Finishing) O).e();
        } else if (O instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) O).f40605a;
        } else if (!(O instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + O).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + k0(O), th, this);
    }

    public boolean J() {
        return true;
    }

    public boolean K() {
        return false;
    }

    public void L(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(w(), (Throwable) null, this);
        }
        r(cancellationException);
    }

    public final ChildHandle N() {
        return (ChildHandle) f40665c.get(this);
    }

    public final Object O() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40664b;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean P(Throwable th) {
        return false;
    }

    public void Q(Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public final void R(Job job) {
        if (job == null) {
            h0(NonDisposableHandle.f40684b);
            return;
        }
        job.start();
        ChildHandle m02 = job.m0(this);
        h0(m02);
        if (S()) {
            m02.dispose();
            h0(NonDisposableHandle.f40684b);
        }
    }

    public final boolean S() {
        return !(O() instanceof Incomplete);
    }

    /* access modifiers changed from: protected */
    public boolean T() {
        return false;
    }

    public final Object V(Object obj) {
        Object r02;
        do {
            r02 = r0(O(), obj);
            if (r02 == JobSupportKt.f40676a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, G(obj));
            }
        } while (r02 == JobSupportKt.f40678c);
        return r02;
    }

    public String X() {
        return DebugStringsKt.a(this);
    }

    /* access modifiers changed from: protected */
    public void b0(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void c0(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void d0() {
    }

    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return Job.DefaultImpls.b(this, r2, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g0(kotlinx.coroutines.JobNode r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.O()
            boolean r1 = r0 instanceof kotlinx.coroutines.JobNode
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f40664b
            kotlinx.coroutines.Empty r2 = kotlinx.coroutines.JobSupportKt.f40682g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            kotlinx.coroutines.NodeList r0 = r0.a()
            if (r0 == 0) goto L_0x0027
            r4.n()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.g0(kotlinx.coroutines.JobNode):void");
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.c(this, key);
    }

    public final CoroutineContext.Key<?> getKey() {
        return Job.E0;
    }

    public final void h0(ChildHandle childHandle) {
        f40665c.set(this, childHandle);
    }

    public boolean isActive() {
        Object O = O();
        if (!(O instanceof Incomplete) || !((Incomplete) O).isActive()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final CancellationException l0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = w();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public final ChildHandle m0(ChildJob childJob) {
        DisposableHandle d2 = Job.DefaultImpls.d(this, true, false, new ChildHandleNode(childJob), 2, (Object) null);
        Intrinsics.d(d2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) d2;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.e(this, key);
    }

    /* access modifiers changed from: protected */
    public void n(Object obj) {
    }

    public final boolean o(Throwable th) {
        return p(th);
    }

    public final String o0() {
        return X() + '{' + k0(O()) + '}';
    }

    public final boolean p(Object obj) {
        Object a2 = JobSupportKt.f40676a;
        if (K() && (a2 = t(obj)) == JobSupportKt.f40677b) {
            return true;
        }
        if (a2 == JobSupportKt.f40676a) {
            a2 = U(obj);
        }
        if (a2 == JobSupportKt.f40676a || a2 == JobSupportKt.f40677b) {
            return true;
        }
        if (a2 == JobSupportKt.f40679d) {
            return false;
        }
        n(a2);
        return true;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.f(this, coroutineContext);
    }

    public final DisposableHandle q(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        CompletedExceptionally completedExceptionally;
        JobNode W = W(function1, z2);
        while (true) {
            Object O = O();
            if (O instanceof Empty) {
                Empty empty = (Empty) O;
                if (!empty.isActive()) {
                    e0(empty);
                } else if (a.a(f40664b, this, O, W)) {
                    return W;
                }
            } else {
                Throwable th = null;
                if (O instanceof Incomplete) {
                    NodeList a2 = ((Incomplete) O).a();
                    if (a2 == null) {
                        Intrinsics.d(O, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        f0((JobNode) O);
                    } else {
                        DisposableHandle disposableHandle = NonDisposableHandle.f40684b;
                        if (z2 && (O instanceof Finishing)) {
                            synchronized (O) {
                                th = ((Finishing) O).e();
                                if (th == null || ((function1 instanceof ChildHandleNode) && !((Finishing) O).g())) {
                                    if (l(O, a2, W)) {
                                        if (th == null) {
                                            return W;
                                        }
                                        disposableHandle = W;
                                    }
                                }
                                Unit unit = Unit.f40298a;
                            }
                        }
                        if (th != null) {
                            if (z3) {
                                function1.invoke(th);
                            }
                            return disposableHandle;
                        } else if (l(O, a2, W)) {
                            return W;
                        }
                    }
                } else {
                    if (z3) {
                        if (O instanceof CompletedExceptionally) {
                            completedExceptionally = (CompletedExceptionally) O;
                        } else {
                            completedExceptionally = null;
                        }
                        if (completedExceptionally != null) {
                            th = completedExceptionally.f40605a;
                        }
                        function1.invoke(th);
                    }
                    return NonDisposableHandle.f40684b;
                }
            }
        }
    }

    public void r(Throwable th) {
        p(th);
    }

    public final CancellationException s() {
        Object O = O();
        if (O instanceof Finishing) {
            Throwable e2 = ((Finishing) O).e();
            if (e2 != null) {
                CancellationException l02 = l0(e2, DebugStringsKt.a(this) + " is cancelling");
                if (l02 != null) {
                    return l02;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (O instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (O instanceof CompletedExceptionally) {
            return n0(this, ((CompletedExceptionally) O).f40605a, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(DebugStringsKt.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public final boolean start() {
        int i02;
        do {
            i02 = i0(O());
            if (i02 == 0) {
                return false;
            }
        } while (i02 != 1);
        return true;
    }

    public String toString() {
        return o0() + '@' + DebugStringsKt.b(this);
    }

    public final void v(ParentJob parentJob) {
        p(parentJob);
    }

    /* access modifiers changed from: protected */
    public String w() {
        return "Job was cancelled";
    }

    public boolean x(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!p(th) || !J()) {
            return false;
        }
        return true;
    }

    public final DisposableHandle z(Function1<? super Throwable, Unit> function1) {
        return q(false, true, function1);
    }
}

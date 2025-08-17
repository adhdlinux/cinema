package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Task<TResult> {

    /* renamed from: i  reason: collision with root package name */
    public static final ExecutorService f12787i = BoltsExecutors.a();

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f12788j = BoltsExecutors.b();

    /* renamed from: k  reason: collision with root package name */
    public static final Executor f12789k = AndroidExecutors.c();

    /* renamed from: l  reason: collision with root package name */
    private static Task<?> f12790l = new Task<>((Object) null);

    /* renamed from: m  reason: collision with root package name */
    private static Task<Boolean> f12791m = new Task<>(Boolean.TRUE);

    /* renamed from: n  reason: collision with root package name */
    private static Task<Boolean> f12792n = new Task<>(Boolean.FALSE);

    /* renamed from: o  reason: collision with root package name */
    private static Task<?> f12793o = new Task<>(true);

    /* renamed from: a  reason: collision with root package name */
    private final Object f12794a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f12795b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12796c;

    /* renamed from: d  reason: collision with root package name */
    private TResult f12797d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f12798e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12799f;

    /* renamed from: g  reason: collision with root package name */
    private UnobservedErrorNotifier f12800g;

    /* renamed from: h  reason: collision with root package name */
    private List<Continuation<TResult, Void>> f12801h = new ArrayList();

    public interface UnobservedExceptionHandler {
    }

    Task() {
    }

    public static <TResult> Task<TResult> c(Callable<TResult> callable, Executor executor) {
        return d(callable, executor, (CancellationToken) null);
    }

    public static <TResult> Task<TResult> d(Callable<TResult> callable, Executor executor, CancellationToken cancellationToken) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable(cancellationToken, taskCompletionSource, callable) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ TaskCompletionSource f12817b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Callable f12818c;

                {
                    this.f12817b = r2;
                    this.f12818c = r3;
                }

                public void run() {
                    try {
                        this.f12817b.d(this.f12818c.call());
                    } catch (CancellationException unused) {
                        this.f12817b.b();
                    } catch (Exception e2) {
                        this.f12817b.c(e2);
                    }
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.c(new ExecutorException(e2));
        }
        return taskCompletionSource.a();
    }

    /* access modifiers changed from: private */
    public static <TContinuationResult, TResult> void e(TaskCompletionSource<TContinuationResult> taskCompletionSource, Continuation<TResult, Task<TContinuationResult>> continuation, Task<TResult> task, Executor executor, CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable(cancellationToken, taskCompletionSource, continuation, task) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ TaskCompletionSource f12813b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Continuation f12814c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Task f12815d;

                {
                    this.f12813b = r2;
                    this.f12814c = r3;
                    this.f12815d = r4;
                }

                public void run() {
                    try {
                        Task task = (Task) this.f12814c.then(this.f12815d);
                        if (task == null) {
                            this.f12813b.d(null);
                        } else {
                            task.g(new Continuation<TContinuationResult, Void>() {
                                /* renamed from: a */
                                public Void then(Task<TContinuationResult> task) {
                                    AnonymousClass15.this.getClass();
                                    if (task.p()) {
                                        AnonymousClass15.this.f12813b.b();
                                        return null;
                                    } else if (task.r()) {
                                        AnonymousClass15.this.f12813b.c(task.m());
                                        return null;
                                    } else {
                                        AnonymousClass15.this.f12813b.d(task.n());
                                        return null;
                                    }
                                }
                            });
                        }
                    } catch (CancellationException unused) {
                        this.f12813b.b();
                    } catch (Exception e2) {
                        this.f12813b.c(e2);
                    }
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.c(new ExecutorException(e2));
        }
    }

    /* access modifiers changed from: private */
    public static <TContinuationResult, TResult> void f(TaskCompletionSource<TContinuationResult> taskCompletionSource, Continuation<TResult, TContinuationResult> continuation, Task<TResult> task, Executor executor, CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable(cancellationToken, taskCompletionSource, continuation, task) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ TaskCompletionSource f12810b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Continuation f12811c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Task f12812d;

                {
                    this.f12810b = r2;
                    this.f12811c = r3;
                    this.f12812d = r4;
                }

                public void run() {
                    try {
                        this.f12810b.d(this.f12811c.then(this.f12812d));
                    } catch (CancellationException unused) {
                        this.f12810b.b();
                    } catch (Exception e2) {
                        this.f12810b.c(e2);
                    }
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.c(new ExecutorException(e2));
        }
    }

    public static <TResult> Task<TResult> k(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.c(exc);
        return taskCompletionSource.a();
    }

    public static <TResult> Task<TResult> l(TResult tresult) {
        if (tresult == null) {
            return f12790l;
        }
        if (!(tresult instanceof Boolean)) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.d(tresult);
            return taskCompletionSource.a();
        } else if (((Boolean) tresult).booleanValue()) {
            return f12791m;
        } else {
            return f12792n;
        }
    }

    public static UnobservedExceptionHandler o() {
        return null;
    }

    private void s() {
        synchronized (this.f12794a) {
            for (Continuation then : this.f12801h) {
                try {
                    then.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f12801h = null;
        }
    }

    public <TContinuationResult> Task<TContinuationResult> g(Continuation<TResult, TContinuationResult> continuation) {
        return h(continuation, f12788j, (CancellationToken) null);
    }

    public <TContinuationResult> Task<TContinuationResult> h(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        boolean q2;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f12794a) {
            q2 = q();
            if (!q2) {
                this.f12801h.add(new Continuation<TResult, Void>(taskCompletionSource, continuation, executor, cancellationToken) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ TaskCompletionSource f12802a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ Continuation f12803b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ Executor f12804c;

                    {
                        this.f12802a = r2;
                        this.f12803b = r3;
                        this.f12804c = r4;
                    }

                    /* renamed from: a */
                    public Void then(Task<TResult> task) {
                        Task.f(this.f12802a, this.f12803b, task, this.f12804c, (CancellationToken) null);
                        return null;
                    }
                });
            }
        }
        if (q2) {
            f(taskCompletionSource, continuation, this, executor, cancellationToken);
        }
        return taskCompletionSource.a();
    }

    public <TContinuationResult> Task<TContinuationResult> i(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return j(continuation, f12788j, (CancellationToken) null);
    }

    public <TContinuationResult> Task<TContinuationResult> j(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        boolean q2;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f12794a) {
            q2 = q();
            if (!q2) {
                this.f12801h.add(new Continuation<TResult, Void>(taskCompletionSource, continuation, executor, cancellationToken) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ TaskCompletionSource f12806a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ Continuation f12807b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ Executor f12808c;

                    {
                        this.f12806a = r2;
                        this.f12807b = r3;
                        this.f12808c = r4;
                    }

                    /* renamed from: a */
                    public Void then(Task<TResult> task) {
                        Task.e(this.f12806a, this.f12807b, task, this.f12808c, (CancellationToken) null);
                        return null;
                    }
                });
            }
        }
        if (q2) {
            e(taskCompletionSource, continuation, this, executor, cancellationToken);
        }
        return taskCompletionSource.a();
    }

    public Exception m() {
        Exception exc;
        synchronized (this.f12794a) {
            if (this.f12798e != null) {
                this.f12799f = true;
                UnobservedErrorNotifier unobservedErrorNotifier = this.f12800g;
                if (unobservedErrorNotifier != null) {
                    unobservedErrorNotifier.a();
                    this.f12800g = null;
                }
            }
            exc = this.f12798e;
        }
        return exc;
    }

    public TResult n() {
        TResult tresult;
        synchronized (this.f12794a) {
            tresult = this.f12797d;
        }
        return tresult;
    }

    public boolean p() {
        boolean z2;
        synchronized (this.f12794a) {
            z2 = this.f12796c;
        }
        return z2;
    }

    public boolean q() {
        boolean z2;
        synchronized (this.f12794a) {
            z2 = this.f12795b;
        }
        return z2;
    }

    public boolean r() {
        boolean z2;
        synchronized (this.f12794a) {
            if (m() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        synchronized (this.f12794a) {
            if (this.f12795b) {
                return false;
            }
            this.f12795b = true;
            this.f12796c = true;
            this.f12794a.notifyAll();
            s();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean u(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f12794a
            monitor-enter(r0)
            boolean r1 = r3.f12795b     // Catch:{ all -> 0x0022 }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r2
        L_0x000a:
            r1 = 1
            r3.f12795b = r1     // Catch:{ all -> 0x0022 }
            r3.f12798e = r4     // Catch:{ all -> 0x0022 }
            r3.f12799f = r2     // Catch:{ all -> 0x0022 }
            java.lang.Object r4 = r3.f12794a     // Catch:{ all -> 0x0022 }
            r4.notifyAll()     // Catch:{ all -> 0x0022 }
            r3.s()     // Catch:{ all -> 0x0022 }
            boolean r4 = r3.f12799f     // Catch:{ all -> 0x0022 }
            if (r4 != 0) goto L_0x0020
            o()     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.Task.u(java.lang.Exception):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean v(TResult tresult) {
        synchronized (this.f12794a) {
            if (this.f12795b) {
                return false;
            }
            this.f12795b = true;
            this.f12797d = tresult;
            this.f12794a.notifyAll();
            s();
            return true;
        }
    }

    private Task(TResult tresult) {
        v(tresult);
    }

    private Task(boolean z2) {
        if (z2) {
            t();
        } else {
            v((Object) null);
        }
    }
}

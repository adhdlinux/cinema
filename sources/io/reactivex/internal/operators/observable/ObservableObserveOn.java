package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Scheduler f39274c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39275d;

    /* renamed from: e  reason: collision with root package name */
    final int f39276e;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39277b;

        /* renamed from: c  reason: collision with root package name */
        final Scheduler.Worker f39278c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f39279d;

        /* renamed from: e  reason: collision with root package name */
        final int f39280e;

        /* renamed from: f  reason: collision with root package name */
        SimpleQueue<T> f39281f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f39282g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f39283h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f39284i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39285j;

        /* renamed from: k  reason: collision with root package name */
        int f39286k;

        /* renamed from: l  reason: collision with root package name */
        boolean f39287l;

        ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean z2, int i2) {
            this.f39277b = observer;
            this.f39278c = worker;
            this.f39279d = z2;
            this.f39280e = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z2, boolean z3, Observer<? super T> observer) {
            if (this.f39285j) {
                this.f39281f.clear();
                return true;
            } else if (!z2) {
                return false;
            } else {
                Throwable th = this.f39283h;
                if (this.f39279d) {
                    if (!z3) {
                        return false;
                    }
                    this.f39285j = true;
                    if (th != null) {
                        observer.onError(th);
                    } else {
                        observer.onComplete();
                    }
                    this.f39278c.dispose();
                    return true;
                } else if (th != null) {
                    this.f39285j = true;
                    this.f39281f.clear();
                    observer.onError(th);
                    this.f39278c.dispose();
                    return true;
                } else if (!z3) {
                    return false;
                } else {
                    this.f39285j = true;
                    observer.onComplete();
                    this.f39278c.dispose();
                    return true;
                }
            }
        }

        public int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f39287l = true;
            return 2;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            int i2 = 1;
            while (!this.f39285j) {
                boolean z2 = this.f39284i;
                Throwable th = this.f39283h;
                if (this.f39279d || !z2 || th == null) {
                    this.f39277b.onNext(null);
                    if (z2) {
                        this.f39285j = true;
                        Throwable th2 = this.f39283h;
                        if (th2 != null) {
                            this.f39277b.onError(th2);
                        } else {
                            this.f39277b.onComplete();
                        }
                        this.f39278c.dispose();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    this.f39285j = true;
                    this.f39277b.onError(this.f39283h);
                    this.f39278c.dispose();
                    return;
                }
            }
        }

        public void clear() {
            this.f39281f.clear();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z2;
            SimpleQueue<T> simpleQueue = this.f39281f;
            Observer<? super T> observer = this.f39277b;
            int i2 = 1;
            while (!a(this.f39284i, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z3 = this.f39284i;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!a(z3, z2, observer)) {
                            if (z2) {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f39285j = true;
                        this.f39282g.dispose();
                        simpleQueue.clear();
                        observer.onError(th);
                        this.f39278c.dispose();
                        return;
                    }
                }
            }
        }

        public void dispose() {
            if (!this.f39285j) {
                this.f39285j = true;
                this.f39282g.dispose();
                this.f39278c.dispose();
                if (getAndIncrement() == 0) {
                    this.f39281f.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (getAndIncrement() == 0) {
                this.f39278c.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f39285j;
        }

        public boolean isEmpty() {
            return this.f39281f.isEmpty();
        }

        public void onComplete() {
            if (!this.f39284i) {
                this.f39284i = true;
                e();
            }
        }

        public void onError(Throwable th) {
            if (this.f39284i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39283h = th;
            this.f39284i = true;
            e();
        }

        public void onNext(T t2) {
            if (!this.f39284i) {
                if (this.f39286k != 2) {
                    this.f39281f.offer(t2);
                }
                e();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39282g, disposable)) {
                this.f39282g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int b2 = queueDisposable.b(7);
                    if (b2 == 1) {
                        this.f39286k = b2;
                        this.f39281f = queueDisposable;
                        this.f39284i = true;
                        this.f39277b.onSubscribe(this);
                        e();
                        return;
                    } else if (b2 == 2) {
                        this.f39286k = b2;
                        this.f39281f = queueDisposable;
                        this.f39277b.onSubscribe(this);
                        return;
                    }
                }
                this.f39281f = new SpscLinkedArrayQueue(this.f39280e);
                this.f39277b.onSubscribe(this);
            }
        }

        public T poll() throws Exception {
            return this.f39281f.poll();
        }

        public void run() {
            if (this.f39287l) {
                c();
            } else {
                d();
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z2, int i2) {
        super(observableSource);
        this.f39274c = scheduler;
        this.f39275d = z2;
        this.f39276e = i2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.f39274c;
        if (scheduler instanceof TrampolineScheduler) {
            this.f38612b.subscribe(observer);
            return;
        }
        this.f38612b.subscribe(new ObserveOnObserver(observer, scheduler.a(), this.f39275d, this.f39276e));
    }
}

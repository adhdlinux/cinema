package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import com.facebook.common.time.Clock;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    final long f39802c;

    /* renamed from: d  reason: collision with root package name */
    final long f39803d;

    /* renamed from: e  reason: collision with root package name */
    final TimeUnit f39804e;

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f39805f;

    /* renamed from: g  reason: collision with root package name */
    final long f39806g;

    /* renamed from: h  reason: collision with root package name */
    final int f39807h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f39808i;

    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        final long f39809h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f39810i;

        /* renamed from: j  reason: collision with root package name */
        final Scheduler f39811j;

        /* renamed from: k  reason: collision with root package name */
        final int f39812k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f39813l;

        /* renamed from: m  reason: collision with root package name */
        final long f39814m;

        /* renamed from: n  reason: collision with root package name */
        final Scheduler.Worker f39815n;

        /* renamed from: o  reason: collision with root package name */
        long f39816o;

        /* renamed from: p  reason: collision with root package name */
        long f39817p;

        /* renamed from: q  reason: collision with root package name */
        Disposable f39818q;

        /* renamed from: r  reason: collision with root package name */
        UnicastSubject<T> f39819r;

        /* renamed from: s  reason: collision with root package name */
        volatile boolean f39820s;

        /* renamed from: t  reason: collision with root package name */
        final AtomicReference<Disposable> f39821t = new AtomicReference<>();

        static final class ConsumerIndexHolder implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final long f39822b;

            /* renamed from: c  reason: collision with root package name */
            final WindowExactBoundedObserver<?> f39823c;

            ConsumerIndexHolder(long j2, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.f39822b = j2;
                this.f39823c = windowExactBoundedObserver;
            }

            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.f39823c;
                if (!windowExactBoundedObserver.f38417e) {
                    windowExactBoundedObserver.f38416d.offer(this);
                } else {
                    windowExactBoundedObserver.f39820s = true;
                    windowExactBoundedObserver.l();
                }
                if (windowExactBoundedObserver.f()) {
                    windowExactBoundedObserver.m();
                }
            }
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, long j3, boolean z2) {
            super(observer, new MpscLinkedQueue());
            this.f39809h = j2;
            this.f39810i = timeUnit;
            this.f39811j = scheduler;
            this.f39812k = i2;
            this.f39814m = j3;
            this.f39813l = z2;
            if (z2) {
                this.f39815n = scheduler.a();
            } else {
                this.f39815n = null;
            }
        }

        public void dispose() {
            this.f38417e = true;
        }

        public boolean isDisposed() {
            return this.f38417e;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            DisposableHelper.a(this.f39821t);
            Scheduler.Worker worker = this.f39815n;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void m() {
            boolean z2;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f38416d;
            Observer<? super V> observer = this.f38415c;
            UnicastSubject<T> unicastSubject = this.f39819r;
            int i2 = 1;
            while (!this.f39820s) {
                boolean z3 = this.f38418f;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = poll instanceof ConsumerIndexHolder;
                if (z3 && (z2 || z4)) {
                    this.f39819r = null;
                    mpscLinkedQueue.clear();
                    l();
                    Throwable th = this.f38419g;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                } else if (z2) {
                    i2 = b(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z4) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (this.f39813l || this.f39817p == consumerIndexHolder.f39822b) {
                        unicastSubject.onComplete();
                        this.f39816o = 0;
                        unicastSubject = UnicastSubject.d(this.f39812k);
                        this.f39819r = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.g(poll));
                    long j2 = this.f39816o + 1;
                    if (j2 >= this.f39814m) {
                        this.f39817p++;
                        this.f39816o = 0;
                        unicastSubject.onComplete();
                        unicastSubject = UnicastSubject.d(this.f39812k);
                        this.f39819r = unicastSubject;
                        this.f38415c.onNext(unicastSubject);
                        if (this.f39813l) {
                            Disposable disposable = this.f39821t.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.f39815n;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.f39817p, this);
                            long j3 = this.f39809h;
                            Disposable d2 = worker.d(consumerIndexHolder2, j3, j3, this.f39810i);
                            if (!f.a(this.f39821t, disposable, d2)) {
                                d2.dispose();
                            }
                        }
                    } else {
                        this.f39816o = j2;
                    }
                }
            }
            this.f39818q.dispose();
            mpscLinkedQueue.clear();
            l();
        }

        public void onComplete() {
            this.f38418f = true;
            if (f()) {
                m();
            }
            this.f38415c.onComplete();
            l();
        }

        public void onError(Throwable th) {
            this.f38419g = th;
            this.f38418f = true;
            if (f()) {
                m();
            }
            this.f38415c.onError(th);
            l();
        }

        public void onNext(T t2) {
            if (!this.f39820s) {
                if (g()) {
                    UnicastSubject<T> unicastSubject = this.f39819r;
                    unicastSubject.onNext(t2);
                    long j2 = this.f39816o + 1;
                    if (j2 >= this.f39814m) {
                        this.f39817p++;
                        this.f39816o = 0;
                        unicastSubject.onComplete();
                        UnicastSubject<T> d2 = UnicastSubject.d(this.f39812k);
                        this.f39819r = d2;
                        this.f38415c.onNext(d2);
                        if (this.f39813l) {
                            this.f39821t.get().dispose();
                            Scheduler.Worker worker = this.f39815n;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f39817p, this);
                            long j3 = this.f39809h;
                            DisposableHelper.c(this.f39821t, worker.d(consumerIndexHolder, j3, j3, this.f39810i));
                        }
                    } else {
                        this.f39816o = j2;
                    }
                    if (b(-1) == 0) {
                        return;
                    }
                } else {
                    this.f38416d.offer(NotificationLite.j(t2));
                    if (!f()) {
                        return;
                    }
                }
                m();
            }
        }

        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.h(this.f39818q, disposable)) {
                this.f39818q = disposable;
                Observer<? super V> observer = this.f38415c;
                observer.onSubscribe(this);
                if (!this.f38417e) {
                    UnicastSubject<T> d2 = UnicastSubject.d(this.f39812k);
                    this.f39819r = d2;
                    observer.onNext(d2);
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f39817p, this);
                    if (this.f39813l) {
                        Scheduler.Worker worker = this.f39815n;
                        long j2 = this.f39809h;
                        disposable2 = worker.d(consumerIndexHolder, j2, j2, this.f39810i);
                    } else {
                        Scheduler scheduler = this.f39811j;
                        long j3 = this.f39809h;
                        disposable2 = scheduler.e(consumerIndexHolder, j3, j3, this.f39810i);
                    }
                    DisposableHelper.c(this.f39821t, disposable2);
                }
            }
        }
    }

    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* renamed from: p  reason: collision with root package name */
        static final Object f39824p = new Object();

        /* renamed from: h  reason: collision with root package name */
        final long f39825h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f39826i;

        /* renamed from: j  reason: collision with root package name */
        final Scheduler f39827j;

        /* renamed from: k  reason: collision with root package name */
        final int f39828k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f39829l;

        /* renamed from: m  reason: collision with root package name */
        UnicastSubject<T> f39830m;

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<Disposable> f39831n = new AtomicReference<>();

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f39832o;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(observer, new MpscLinkedQueue());
            this.f39825h = j2;
            this.f39826i = timeUnit;
            this.f39827j = scheduler;
            this.f39828k = i2;
        }

        public void dispose() {
            this.f38417e = true;
        }

        public boolean isDisposed() {
            return this.f38417e;
        }

        /* access modifiers changed from: package-private */
        public void j() {
            DisposableHelper.a(this.f39831n);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f38416d;
            Observer<? super V> observer = this.f38415c;
            UnicastSubject<T> unicastSubject = this.f39830m;
            int i2 = 1;
            while (true) {
                boolean z2 = this.f39832o;
                boolean z3 = this.f38418f;
                Object poll = mpscLinkedQueue.poll();
                if (!z3 || !(poll == null || poll == f39824p)) {
                    if (poll == null) {
                        i2 = b(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll == f39824p) {
                        unicastSubject.onComplete();
                        if (!z2) {
                            unicastSubject = UnicastSubject.d(this.f39828k);
                            this.f39830m = unicastSubject;
                            observer.onNext(unicastSubject);
                        } else {
                            this.f39829l.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.g(poll));
                    }
                }
            }
            this.f39830m = null;
            mpscLinkedQueue.clear();
            j();
            Throwable th = this.f38419g;
            if (th != null) {
                unicastSubject.onError(th);
            } else {
                unicastSubject.onComplete();
            }
        }

        public void onComplete() {
            this.f38418f = true;
            if (f()) {
                k();
            }
            j();
            this.f38415c.onComplete();
        }

        public void onError(Throwable th) {
            this.f38419g = th;
            this.f38418f = true;
            if (f()) {
                k();
            }
            j();
            this.f38415c.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39832o) {
                if (g()) {
                    this.f39830m.onNext(t2);
                    if (b(-1) == 0) {
                        return;
                    }
                } else {
                    this.f38416d.offer(NotificationLite.j(t2));
                    if (!f()) {
                        return;
                    }
                }
                k();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39829l, disposable)) {
                this.f39829l = disposable;
                this.f39830m = UnicastSubject.d(this.f39828k);
                Observer<? super V> observer = this.f38415c;
                observer.onSubscribe(this);
                observer.onNext(this.f39830m);
                if (!this.f38417e) {
                    Scheduler scheduler = this.f39827j;
                    long j2 = this.f39825h;
                    DisposableHelper.c(this.f39831n, scheduler.e(this, j2, j2, this.f39826i));
                }
            }
        }

        public void run() {
            if (this.f38417e) {
                this.f39832o = true;
                j();
            }
            this.f38416d.offer(f39824p);
            if (f()) {
                k();
            }
        }
    }

    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* renamed from: h  reason: collision with root package name */
        final long f39833h;

        /* renamed from: i  reason: collision with root package name */
        final long f39834i;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f39835j;

        /* renamed from: k  reason: collision with root package name */
        final Scheduler.Worker f39836k;

        /* renamed from: l  reason: collision with root package name */
        final int f39837l;

        /* renamed from: m  reason: collision with root package name */
        final List<UnicastSubject<T>> f39838m = new LinkedList();

        /* renamed from: n  reason: collision with root package name */
        Disposable f39839n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f39840o;

        final class CompletionTask implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final UnicastSubject<T> f39841b;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.f39841b = unicastSubject;
            }

            public void run() {
                WindowSkipObserver.this.j(this.f39841b);
            }
        }

        static final class SubjectWork<T> {

            /* renamed from: a  reason: collision with root package name */
            final UnicastSubject<T> f39843a;

            /* renamed from: b  reason: collision with root package name */
            final boolean f39844b;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z2) {
                this.f39843a = unicastSubject;
                this.f39844b = z2;
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(observer, new MpscLinkedQueue());
            this.f39833h = j2;
            this.f39834i = j3;
            this.f39835j = timeUnit;
            this.f39836k = worker;
            this.f39837l = i2;
        }

        public void dispose() {
            this.f38417e = true;
        }

        public boolean isDisposed() {
            return this.f38417e;
        }

        /* access modifiers changed from: package-private */
        public void j(UnicastSubject<T> unicastSubject) {
            this.f38416d.offer(new SubjectWork(unicastSubject, false));
            if (f()) {
                l();
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f39836k.dispose();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            boolean z2;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f38416d;
            Observer<? super V> observer = this.f38415c;
            List<UnicastSubject<T>> list = this.f39838m;
            int i2 = 1;
            while (!this.f39840o) {
                boolean z3 = this.f38418f;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = poll instanceof SubjectWork;
                if (z3 && (z2 || z4)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.f38419g;
                    if (th != null) {
                        for (UnicastSubject<T> onError : list) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    k();
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = b(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z4) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.f39844b) {
                        list.remove(subjectWork.f39843a);
                        subjectWork.f39843a.onComplete();
                        if (list.isEmpty() && this.f38417e) {
                            this.f39840o = true;
                        }
                    } else if (!this.f38417e) {
                        UnicastSubject d2 = UnicastSubject.d(this.f39837l);
                        list.add(d2);
                        observer.onNext(d2);
                        this.f39836k.c(new CompletionTask(d2), this.f39833h, this.f39835j);
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.f39839n.dispose();
            k();
            mpscLinkedQueue.clear();
            list.clear();
        }

        public void onComplete() {
            this.f38418f = true;
            if (f()) {
                l();
            }
            this.f38415c.onComplete();
            k();
        }

        public void onError(Throwable th) {
            this.f38419g = th;
            this.f38418f = true;
            if (f()) {
                l();
            }
            this.f38415c.onError(th);
            k();
        }

        public void onNext(T t2) {
            if (g()) {
                for (UnicastSubject<T> onNext : this.f39838m) {
                    onNext.onNext(t2);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f38416d.offer(t2);
                if (!f()) {
                    return;
                }
            }
            l();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39839n, disposable)) {
                this.f39839n = disposable;
                this.f38415c.onSubscribe(this);
                if (!this.f38417e) {
                    UnicastSubject d2 = UnicastSubject.d(this.f39837l);
                    this.f39838m.add(d2);
                    this.f38415c.onNext(d2);
                    this.f39836k.c(new CompletionTask(d2), this.f39833h, this.f39835j);
                    Scheduler.Worker worker = this.f39836k;
                    long j2 = this.f39834i;
                    worker.d(this, j2, j2, this.f39835j);
                }
            }
        }

        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.d(this.f39837l), true);
            if (!this.f38417e) {
                this.f38416d.offer(subjectWork);
            }
            if (f()) {
                l();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, long j4, int i2, boolean z2) {
        super(observableSource);
        this.f39802c = j2;
        this.f39803d = j3;
        this.f39804e = timeUnit;
        this.f39805f = scheduler;
        this.f39806g = j4;
        this.f39807h = i2;
        this.f39808i = z2;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j2 = this.f39802c;
        long j3 = this.f39803d;
        if (j2 == j3) {
            long j4 = this.f39806g;
            if (j4 == Clock.MAX_TIME) {
                this.f38612b.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.f39802c, this.f39804e, this.f39805f, this.f39807h));
            } else {
                this.f38612b.subscribe(new WindowExactBoundedObserver(serializedObserver, j2, this.f39804e, this.f39805f, this.f39807h, j4, this.f39808i));
            }
        } else {
            this.f38612b.subscribe(new WindowSkipObserver(serializedObserver, j2, j3, this.f39804e, this.f39805f.a(), this.f39807h));
        }
    }
}

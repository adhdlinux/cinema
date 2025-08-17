package io.reactivex.internal.operators.mixed;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    final Observable<T> f38572b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f38573c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f38574d;

    static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        static final SwitchMapInnerObserver f38575i = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);

        /* renamed from: b  reason: collision with root package name */
        final CompletableObserver f38576b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f38577c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f38578d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f38579e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<SwitchMapInnerObserver> f38580f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f38581g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f38582h;

        static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: b  reason: collision with root package name */
            final SwitchMapCompletableObserver<?> f38583b;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f38583b = switchMapCompletableObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                this.f38583b.b(this);
            }

            public void onError(Throwable th) {
                this.f38583b.c(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z2) {
            this.f38576b = completableObserver;
            this.f38577c = function;
            this.f38578d = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f38580f;
            SwitchMapInnerObserver switchMapInnerObserver = f38575i;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (f.a(this.f38580f, switchMapInnerObserver, (Object) null) && this.f38581g) {
                Throwable b2 = this.f38579e.b();
                if (b2 == null) {
                    this.f38576b.onComplete();
                } else {
                    this.f38576b.onError(b2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!f.a(this.f38580f, switchMapInnerObserver, (Object) null) || !this.f38579e.a(th)) {
                RxJavaPlugins.s(th);
            } else if (!this.f38578d) {
                dispose();
                Throwable b2 = this.f38579e.b();
                if (b2 != ExceptionHelper.f40066a) {
                    this.f38576b.onError(b2);
                }
            } else if (this.f38581g) {
                this.f38576b.onError(this.f38579e.b());
            }
        }

        public void dispose() {
            this.f38582h.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f38580f.get() == f38575i;
        }

        public void onComplete() {
            this.f38581g = true;
            if (this.f38580f.get() == null) {
                Throwable b2 = this.f38579e.b();
                if (b2 == null) {
                    this.f38576b.onComplete();
                } else {
                    this.f38576b.onError(b2);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.f38579e.a(th)) {
                RxJavaPlugins.s(th);
            } else if (this.f38578d) {
                onComplete();
            } else {
                a();
                Throwable b2 = this.f38579e.b();
                if (b2 != ExceptionHelper.f40066a) {
                    this.f38576b.onError(b2);
                }
            }
        }

        public void onNext(T t2) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f38577c.apply(t2), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f38580f.get();
                    if (switchMapInnerObserver == f38575i) {
                        return;
                    }
                } while (!f.a(this.f38580f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.a(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f38582h.dispose();
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38582h, disposable)) {
                this.f38582h = disposable;
                this.f38576b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z2) {
        this.f38572b = observable;
        this.f38573c = function;
        this.f38574d = z2;
    }

    /* access modifiers changed from: protected */
    public void c(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f38572b, this.f38573c, completableObserver)) {
            this.f38572b.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f38573c, this.f38574d));
        }
    }
}

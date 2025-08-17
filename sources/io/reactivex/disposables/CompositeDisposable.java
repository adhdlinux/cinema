package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: b  reason: collision with root package name */
    OpenHashSet<Disposable> f38326b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f38327c;

    public boolean a(Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    public boolean b(Disposable disposable) {
        ObjectHelper.e(disposable, "disposable is null");
        if (!this.f38327c) {
            synchronized (this) {
                if (!this.f38327c) {
                    OpenHashSet<Disposable> openHashSet = this.f38326b;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.f38326b = openHashSet;
                    }
                    openHashSet.a(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(io.reactivex.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposables is null"
            io.reactivex.internal.functions.ObjectHelper.e(r3, r0)
            boolean r0 = r2.f38327c
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f38327c     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> r0 = r2.f38326b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.e(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.c(io.reactivex.disposables.Disposable):boolean");
    }

    public void d() {
        if (!this.f38327c) {
            synchronized (this) {
                if (!this.f38327c) {
                    OpenHashSet<Disposable> openHashSet = this.f38326b;
                    this.f38326b = null;
                    e(openHashSet);
                }
            }
        }
    }

    public void dispose() {
        if (!this.f38327c) {
            synchronized (this) {
                if (!this.f38327c) {
                    this.f38327c = true;
                    OpenHashSet<Disposable> openHashSet = this.f38326b;
                    this.f38326b = null;
                    e(openHashSet);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            for (Object obj : openHashSet.b()) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.d((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f() {
        /*
            r2 = this;
            boolean r0 = r2.f38327c
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.f38327c     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x000d:
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> r0 = r2.f38326b     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            int r1 = r0.g()     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.f():int");
    }

    public boolean isDisposed() {
        return this.f38327c;
    }
}

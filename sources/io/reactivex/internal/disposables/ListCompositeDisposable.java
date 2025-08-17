package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: b  reason: collision with root package name */
    List<Disposable> f38338b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f38339c;

    public boolean a(Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    public boolean b(Disposable disposable) {
        ObjectHelper.e(disposable, "d is null");
        if (!this.f38339c) {
            synchronized (this) {
                if (!this.f38339c) {
                    List list = this.f38338b;
                    if (list == null) {
                        list = new LinkedList();
                        this.f38338b = list;
                    }
                    list.add(disposable);
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
            java.lang.String r0 = "Disposable item is null"
            io.reactivex.internal.functions.ObjectHelper.e(r3, r0)
            boolean r0 = r2.f38339c
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f38339c     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<io.reactivex.disposables.Disposable> r0 = r2.f38338b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.ListCompositeDisposable.c(io.reactivex.disposables.Disposable):boolean");
    }

    /* access modifiers changed from: package-private */
    public void d(List<Disposable> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (Disposable dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
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

    public void dispose() {
        if (!this.f38339c) {
            synchronized (this) {
                if (!this.f38339c) {
                    this.f38339c = true;
                    List<Disposable> list = this.f38338b;
                    this.f38338b = null;
                    d(list);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f38339c;
    }
}

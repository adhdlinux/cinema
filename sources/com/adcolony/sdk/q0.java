package com.adcolony.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class q0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Callable<T>> f13343a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f13344b = false;

    interface a<T> extends Callable<T> {
        T a();
    }

    q0() {
    }

    /* access modifiers changed from: package-private */
    public List<T> a() {
        return b(-1);
    }

    /* access modifiers changed from: package-private */
    public List<T> b(long j2) {
        List<Future<T>> list;
        this.f13344b = true;
        ArrayList arrayList = new ArrayList();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(this.f13343a.size());
        ArrayList arrayList2 = new ArrayList();
        if (j2 > 0) {
            try {
                list = newFixedThreadPool.invokeAll(this.f13343a, j2, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
            }
        } else {
            list = newFixedThreadPool.invokeAll(this.f13343a);
        }
        arrayList2.addAll(list);
        newFixedThreadPool.shutdownNow();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            Future future = (Future) arrayList2.get(i2);
            if (!future.isCancelled()) {
                try {
                    arrayList.add(future.get());
                } catch (Exception unused2) {
                }
            } else if (this.f13343a.get(i2) instanceof a) {
                arrayList.add(((a) this.f13343a.get(i2)).a());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void c(Callable<T> callable) {
        if (!this.f13344b) {
            this.f13343a.add(callable);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f13343a.isEmpty();
    }
}

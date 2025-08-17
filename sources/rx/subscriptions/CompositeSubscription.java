package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {

    /* renamed from: b  reason: collision with root package name */
    private Set<Subscription> f42175b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42176c = false;

    private static void b(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            Exceptions.a(arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        r2.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (r0 == false) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rx.Subscription r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f42176c     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0015
            java.util.Set<rx.Subscription> r0 = r1.f42175b     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0015
        L_0x000a:
            boolean r0 = r0.remove(r2)     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0014
            r2.unsubscribe()
        L_0x0014:
            return
        L_0x0015:
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.a(rx.Subscription):void");
    }

    public synchronized boolean isUnsubscribed() {
        return this.f42176c;
    }

    public void unsubscribe() {
        synchronized (this) {
            if (!this.f42176c) {
                this.f42176c = true;
                b(this.f42175b);
            }
        }
    }
}

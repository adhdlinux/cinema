package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class SubscriptionList implements Subscription {

    /* renamed from: b  reason: collision with root package name */
    private List<Subscription> f42094b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42095c = false;

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

    public void a(Subscription subscription) {
        synchronized (this) {
            if (!this.f42095c) {
                if (this.f42094b == null) {
                    this.f42094b = new LinkedList();
                }
                this.f42094b.add(subscription);
                subscription = null;
            }
        }
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public synchronized boolean isUnsubscribed() {
        return this.f42095c;
    }

    public void unsubscribe() {
        synchronized (this) {
            if (!this.f42095c) {
                this.f42095c = true;
                List<Subscription> list = this.f42094b;
                this.f42094b = null;
                b(list);
            }
        }
    }
}

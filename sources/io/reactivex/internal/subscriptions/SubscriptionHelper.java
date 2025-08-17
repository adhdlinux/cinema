package io.reactivex.internal.subscriptions;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static boolean a(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void b(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j2) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j2);
        } else if (f(j2)) {
            BackpressureHelper.a(atomicLong, j2);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean c(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!e(atomicReference, subscription)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        subscription.request(andSet);
        return true;
    }

    public static void d() {
        RxJavaPlugins.s(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean e(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.e(subscription, "s is null");
        if (f.a(atomicReference, (Object) null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        d();
        return false;
    }

    public static boolean f(long j2) {
        if (j2 > 0) {
            return true;
        }
        RxJavaPlugins.s(new IllegalArgumentException("n > 0 required but it was " + j2));
        return false;
    }

    public static boolean g(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.s(new NullPointerException("next is null"));
            return false;
        } else if (subscription == null) {
            return true;
        } else {
            subscription2.cancel();
            d();
            return false;
        }
    }

    public void cancel() {
    }

    public void request(long j2) {
    }
}

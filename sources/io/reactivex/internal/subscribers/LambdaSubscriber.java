package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Consumer<? super T> f40041b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Throwable> f40042c;

    /* renamed from: d  reason: collision with root package name */
    final Action f40043d;

    /* renamed from: e  reason: collision with root package name */
    final Consumer<? super Subscription> f40044e;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.f40041b = consumer;
        this.f40042c = consumer2;
        this.f40043d = action;
        this.f40044e = consumer3;
    }

    public void a(Subscription subscription) {
        if (SubscriptionHelper.e(this, subscription)) {
            try {
                this.f40044e.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    public void cancel() {
        SubscriptionHelper.a(this);
    }

    public void dispose() {
        cancel();
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f40043d.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    public void onError(Throwable th) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f40042c.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.s(th);
        }
    }

    public void onNext(T t2) {
        if (!isDisposed()) {
            try {
                this.f40041b.accept(t2);
            } catch (Throwable th) {
                Exceptions.b(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }
    }

    public void request(long j2) {
        ((Subscription) get()).request(j2);
    }
}

package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T> implements Publisher<T> {

    /* renamed from: b  reason: collision with root package name */
    static final int f38296b = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int b() {
        return f38296b;
    }

    public static <T> Flowable<T> c(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        ObjectHelper.e(flowableOnSubscribe, "source is null");
        ObjectHelper.e(backpressureStrategy, "mode is null");
        return RxJavaPlugins.l(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    public final void a(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            n((FlowableSubscriber) subscriber);
            return;
        }
        ObjectHelper.e(subscriber, "s is null");
        n(new StrictSubscriber(subscriber));
    }

    public final <R> Flowable<R> d(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return e(function, false, Integer.MAX_VALUE);
    }

    public final <R> Flowable<R> e(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2, int i2) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i2, "maxConcurrency");
        return RxJavaPlugins.l(new FlowableFlatMapMaybe(this, function, z2, i2));
    }

    public final Flowable<T> f(Scheduler scheduler) {
        return g(scheduler, false, b());
    }

    public final Flowable<T> g(Scheduler scheduler, boolean z2, int i2) {
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.f(i2, "bufferSize");
        return RxJavaPlugins.l(new FlowableObserveOn(this, scheduler, z2, i2));
    }

    public final Flowable<T> h() {
        return i(b(), false, true);
    }

    public final Flowable<T> i(int i2, boolean z2, boolean z3) {
        ObjectHelper.f(i2, "capacity");
        return RxJavaPlugins.l(new FlowableOnBackpressureBuffer(this, i2, z3, z2, Functions.f38342c));
    }

    public final Flowable<T> j() {
        return RxJavaPlugins.l(new FlowableOnBackpressureDrop(this));
    }

    public final Flowable<T> k() {
        return RxJavaPlugins.l(new FlowableOnBackpressureLatest(this));
    }

    public final Disposable l(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return m(consumer, consumer2, Functions.f38342c, FlowableInternalHelper$RequestMax.INSTANCE);
    }

    public final Disposable m(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        ObjectHelper.e(consumer, "onNext is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ObjectHelper.e(consumer3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, consumer3);
        n(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void n(FlowableSubscriber<? super T> flowableSubscriber) {
        ObjectHelper.e(flowableSubscriber, "s is null");
        try {
            Subscriber<? super Object> A = RxJavaPlugins.A(this, flowableSubscriber);
            ObjectHelper.e(A, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            o(A);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void o(Subscriber<? super T> subscriber);

    public final Flowable<T> p(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return q(scheduler, !(this instanceof FlowableCreate));
    }

    public final Flowable<T> q(Scheduler scheduler, boolean z2) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.l(new FlowableSubscribeOn(this, scheduler, z2));
    }

    public final Flowable<T> r(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.l(new FlowableUnsubscribeOn(this, scheduler));
    }
}

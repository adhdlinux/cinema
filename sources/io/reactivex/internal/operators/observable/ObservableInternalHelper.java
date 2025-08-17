package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final Observable<T> f39158b;

        /* renamed from: c  reason: collision with root package name */
        private final int f39159c;

        BufferedReplayCallable(Observable<T> observable, int i2) {
            this.f39158b = observable;
            this.f39159c = i2;
        }

        /* renamed from: b */
        public ConnectableObservable<T> call() {
            return this.f39158b.replay(this.f39159c);
        }
    }

    static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final Observable<T> f39160b;

        /* renamed from: c  reason: collision with root package name */
        private final int f39161c;

        /* renamed from: d  reason: collision with root package name */
        private final long f39162d;

        /* renamed from: e  reason: collision with root package name */
        private final TimeUnit f39163e;

        /* renamed from: f  reason: collision with root package name */
        private final Scheduler f39164f;

        BufferedTimedReplayCallable(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.f39160b = observable;
            this.f39161c = i2;
            this.f39162d = j2;
            this.f39163e = timeUnit;
            this.f39164f = scheduler;
        }

        /* renamed from: b */
        public ConnectableObservable<T> call() {
            return this.f39160b.replay(this.f39161c, this.f39162d, this.f39163e, this.f39164f);
        }
    }

    static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends Iterable<? extends U>> f39165b;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.f39165b = function;
        }

        /* renamed from: a */
        public ObservableSource<U> apply(T t2) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.e(this.f39165b.apply(t2), "The mapper returned a null Iterable"));
        }
    }

    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {

        /* renamed from: b  reason: collision with root package name */
        private final BiFunction<? super T, ? super U, ? extends R> f39166b;

        /* renamed from: c  reason: collision with root package name */
        private final T f39167c;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t2) {
            this.f39166b = biFunction;
            this.f39167c = t2;
        }

        public R apply(U u2) throws Exception {
            return this.f39166b.apply(this.f39167c, u2);
        }
    }

    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {

        /* renamed from: b  reason: collision with root package name */
        private final BiFunction<? super T, ? super U, ? extends R> f39168b;

        /* renamed from: c  reason: collision with root package name */
        private final Function<? super T, ? extends ObservableSource<? extends U>> f39169c;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.f39168b = biFunction;
            this.f39169c = function;
        }

        /* renamed from: a */
        public ObservableSource<R> apply(T t2) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.e(this.f39169c.apply(t2), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.f39168b, t2));
        }
    }

    static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {

        /* renamed from: b  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<U>> f39170b;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.f39170b = function;
        }

        /* renamed from: a */
        public ObservableSource<T> apply(T t2) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.e(this.f39170b.apply(t2), "The itemDelay returned a null ObservableSource"), 1).map(Functions.l(t2)).defaultIfEmpty(t2);
        }
    }

    static final class ObserverOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        final Observer<T> f39171b;

        ObserverOnComplete(Observer<T> observer) {
            this.f39171b = observer;
        }

        public void run() throws Exception {
            this.f39171b.onComplete();
        }
    }

    static final class ObserverOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<T> f39172b;

        ObserverOnError(Observer<T> observer) {
            this.f39172b = observer;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.f39172b.onError(th);
        }
    }

    static final class ObserverOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<T> f39173b;

        ObserverOnNext(Observer<T> observer) {
            this.f39173b = observer;
        }

        public void accept(T t2) throws Exception {
            this.f39173b.onNext(t2);
        }
    }

    static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final Observable<T> f39174b;

        ReplayCallable(Observable<T> observable) {
            this.f39174b = observable;
        }

        /* renamed from: b */
        public ConnectableObservable<T> call() {
            return this.f39174b.replay();
        }
    }

    static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> f39175b;

        /* renamed from: c  reason: collision with root package name */
        private final Scheduler f39176c;

        ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.f39175b = function;
            this.f39176c = scheduler;
        }

        /* renamed from: a */
        public ObservableSource<R> apply(Observable<T> observable) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.e(this.f39175b.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.f39176c);
        }
    }

    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final BiConsumer<S, Emitter<T>> f39177a;

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f39177a = biConsumer;
        }

        /* renamed from: a */
        public S apply(S s2, Emitter<T> emitter) throws Exception {
            this.f39177a.accept(s2, emitter);
            return s2;
        }
    }

    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final Consumer<Emitter<T>> f39178a;

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f39178a = consumer;
        }

        /* renamed from: a */
        public S apply(S s2, Emitter<T> emitter) throws Exception {
            this.f39178a.accept(emitter);
            return s2;
        }
    }

    static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final Observable<T> f39179b;

        /* renamed from: c  reason: collision with root package name */
        private final long f39180c;

        /* renamed from: d  reason: collision with root package name */
        private final TimeUnit f39181d;

        /* renamed from: e  reason: collision with root package name */
        private final Scheduler f39182e;

        TimedReplayCallable(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.f39179b = observable;
            this.f39180c = j2;
            this.f39181d = timeUnit;
            this.f39182e = scheduler;
        }

        /* renamed from: b */
        public ConnectableObservable<T> call() {
            return this.f39179b.replay(this.f39180c, this.f39181d, this.f39182e);
        }
    }

    static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super Object[], ? extends R> f39183b;

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.f39183b = function;
        }

        /* renamed from: a */
        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return Observable.zipIterable(list, this.f39183b, false, Observable.bufferSize());
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> a(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> b(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> c(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action d(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> e(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> f(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Callable<ConnectableObservable<T>> g(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T> Callable<ConnectableObservable<T>> h(Observable<T> observable, int i2) {
        return new BufferedReplayCallable(observable, i2);
    }

    public static <T> Callable<ConnectableObservable<T>> i(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i2, j2, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> j(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j2, timeUnit, scheduler);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> k(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> l(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> n(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }
}

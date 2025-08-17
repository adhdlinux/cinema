package io.reactivex.internal.functions;

import com.facebook.common.time.Clock;
import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions {

    /* renamed from: a  reason: collision with root package name */
    static final Function<Object, Object> f38340a = new Identity();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f38341b = new EmptyRunnable();

    /* renamed from: c  reason: collision with root package name */
    public static final Action f38342c = new EmptyAction();

    /* renamed from: d  reason: collision with root package name */
    static final Consumer<Object> f38343d = new EmptyConsumer();

    /* renamed from: e  reason: collision with root package name */
    public static final Consumer<Throwable> f38344e = new ErrorConsumer();

    /* renamed from: f  reason: collision with root package name */
    public static final Consumer<Throwable> f38345f = new OnErrorMissingConsumer();

    /* renamed from: g  reason: collision with root package name */
    public static final LongConsumer f38346g = new EmptyLongConsumer();

    /* renamed from: h  reason: collision with root package name */
    static final Predicate<Object> f38347h = new TruePredicate();

    /* renamed from: i  reason: collision with root package name */
    static final Predicate<Object> f38348i = new FalsePredicate();

    /* renamed from: j  reason: collision with root package name */
    static final Callable<Object> f38349j = new NullCallable();

    /* renamed from: k  reason: collision with root package name */
    static final Comparator<Object> f38350k = new NaturalObjectComparator();

    /* renamed from: l  reason: collision with root package name */
    public static final Consumer<Subscription> f38351l = new MaxRequestSubscription();

    static final class ActionConsumer<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Action f38352b;

        ActionConsumer(Action action) {
            this.f38352b = action;
        }

        public void accept(T t2) throws Exception {
            this.f38352b.run();
        }
    }

    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        final BiFunction<? super T1, ? super T2, ? extends R> f38353b;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f38353b = biFunction;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f38353b.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        Array3Func(Function3<T1, T2, T3, R> function3) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 3) {
                throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            throw null;
        }
    }

    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {
        Array4Func(Function4<T1, T2, T3, T4, R> function4) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            throw null;
        }
    }

    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            throw null;
        }
    }

    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            throw null;
        }
    }

    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            throw null;
        }
    }

    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            Object obj8 = objArr[7];
            throw null;
        }
    }

    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            Object obj8 = objArr[7];
            Object obj9 = objArr[8];
            throw null;
        }
    }

    static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {

        /* renamed from: b  reason: collision with root package name */
        final int f38354b;

        ArrayListCapacityCallable(int i2) {
            this.f38354b = i2;
        }

        /* renamed from: b */
        public List<T> call() throws Exception {
            return new ArrayList(this.f38354b);
        }
    }

    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
        }

        public boolean test(T t2) throws Exception {
            throw null;
        }
    }

    static final class CastToClass<T, U> implements Function<T, U> {

        /* renamed from: b  reason: collision with root package name */
        final Class<U> f38355b;

        CastToClass(Class<U> cls) {
            this.f38355b = cls;
        }

        public U apply(T t2) throws Exception {
            return this.f38355b.cast(t2);
        }
    }

    static final class ClassFilter<T, U> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        final Class<U> f38356b;

        ClassFilter(Class<U> cls) {
            this.f38356b = cls;
        }

        public boolean test(T t2) throws Exception {
            return this.f38356b.isInstance(t2);
        }
    }

    static final class EmptyAction implements Action {
        EmptyAction() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        EmptyConsumer() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class EqualsPredicate<T> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        final T f38357b;

        EqualsPredicate(T t2) {
            this.f38357b = t2;
        }

        public boolean test(T t2) throws Exception {
            return ObjectHelper.c(t2, this.f38357b);
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.s(th);
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        FalsePredicate() {
        }

        public boolean test(Object obj) {
            return false;
        }
    }

    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        /* renamed from: b */
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    static final class Identity implements Function<Object, Object> {
        Identity() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class JustValue<T, U> implements Callable<U>, Function<T, U> {

        /* renamed from: b  reason: collision with root package name */
        final U f38360b;

        JustValue(U u2) {
            this.f38360b = u2;
        }

        public U apply(T t2) throws Exception {
            return this.f38360b;
        }

        public U call() throws Exception {
            return this.f38360b;
        }
    }

    static final class ListSorter<T> implements Function<List<T>, List<T>> {

        /* renamed from: b  reason: collision with root package name */
        final Comparator<? super T> f38361b;

        ListSorter(Comparator<? super T> comparator) {
            this.f38361b = comparator;
        }

        /* renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f38361b);
            return list;
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        /* renamed from: a */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Clock.MAX_TIME);
        }
    }

    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class NotificationOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        final Consumer<? super Notification<T>> f38364b;

        NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.f38364b = consumer;
        }

        public void run() throws Exception {
            this.f38364b.accept(Notification.a());
        }
    }

    static final class NotificationOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        final Consumer<? super Notification<T>> f38365b;

        NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.f38365b = consumer;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.f38365b.accept(Notification.b(th));
        }
    }

    static final class NotificationOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Consumer<? super Notification<T>> f38366b;

        NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.f38366b = consumer;
        }

        public void accept(T t2) throws Exception {
            this.f38366b.accept(Notification.c(t2));
        }
    }

    static final class NullCallable implements Callable<Object> {
        NullCallable() {
        }

        public Object call() {
            return null;
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.s(new OnErrorNotImplementedException(th));
        }
    }

    static final class TimestampFunction<T> implements Function<T, Timed<T>> {

        /* renamed from: b  reason: collision with root package name */
        final TimeUnit f38367b;

        /* renamed from: c  reason: collision with root package name */
        final Scheduler f38368c;

        TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.f38367b = timeUnit;
            this.f38368c = scheduler;
        }

        /* renamed from: a */
        public Timed<T> apply(T t2) throws Exception {
            return new Timed<>(t2, this.f38368c.b(this.f38367b), this.f38367b);
        }
    }

    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super T, ? extends K> f38369a;

        ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.f38369a = function;
        }

        /* renamed from: a */
        public void accept(Map<K, T> map, T t2) throws Exception {
            map.put(this.f38369a.apply(t2), t2);
        }
    }

    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super T, ? extends V> f38370a;

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends K> f38371b;

        ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.f38370a = function;
            this.f38371b = function2;
        }

        /* renamed from: a */
        public void accept(Map<K, V> map, T t2) throws Exception {
            map.put(this.f38371b.apply(t2), this.f38370a.apply(t2));
        }
    }

    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super K, ? extends Collection<? super V>> f38372a;

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends V> f38373b;

        /* renamed from: c  reason: collision with root package name */
        private final Function<? super T, ? extends K> f38374c;

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.f38372a = function;
            this.f38373b = function2;
            this.f38374c = function3;
        }

        /* renamed from: a */
        public void accept(Map<K, Collection<V>> map, T t2) throws Exception {
            Object apply = this.f38374c.apply(t2);
            Collection collection = map.get(apply);
            if (collection == null) {
                collection = (Collection) this.f38372a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f38373b.apply(t2));
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        TruePredicate() {
        }

        public boolean test(Object obj) {
            return true;
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> A(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.e(function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> B(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.e(function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> C(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.e(function9, "f is null");
        return new Array9Func(function9);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> D(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> E(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> F(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    public static <T> Consumer<T> a(Action action) {
        return new ActionConsumer(action);
    }

    public static <T> Predicate<T> b() {
        return f38348i;
    }

    public static <T> Predicate<T> c() {
        return f38347h;
    }

    public static <T, U> Function<T, U> d(Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Callable<List<T>> e(int i2) {
        return new ArrayListCapacityCallable(i2);
    }

    public static <T> Callable<Set<T>> f() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> g() {
        return f38343d;
    }

    public static <T> Predicate<T> h(T t2) {
        return new EqualsPredicate(t2);
    }

    public static <T> Function<T, T> i() {
        return f38340a;
    }

    public static <T, U> Predicate<T> j(Class<U> cls) {
        return new ClassFilter(cls);
    }

    public static <T> Callable<T> k(T t2) {
        return new JustValue(t2);
    }

    public static <T, U> Function<T, U> l(U u2) {
        return new JustValue(u2);
    }

    public static <T> Function<List<T>, List<T>> m(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> n() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> o() {
        return f38350k;
    }

    public static <T> Action p(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<Throwable> q(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Consumer<T> r(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Callable<T> s() {
        return f38349j;
    }

    public static <T> Predicate<T> t(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> u(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static <T1, T2, R> Function<Object[], R> v(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.e(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> w(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.e(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> x(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.e(function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> y(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.e(function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> z(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.e(function6, "f is null");
        return new Array6Func(function6);
    }
}

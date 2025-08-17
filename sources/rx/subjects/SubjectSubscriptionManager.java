package rx.subjects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;

final class SubjectSubscriptionManager<T> implements Observable.OnSubscribe<T> {

    /* renamed from: i  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater<SubjectSubscriptionManager, State> f42158i;

    /* renamed from: j  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater<SubjectSubscriptionManager, Object> f42159j;

    /* renamed from: b  reason: collision with root package name */
    volatile State<T> f42160b = State.f42169e;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f42161c;

    /* renamed from: d  reason: collision with root package name */
    boolean f42162d = true;

    /* renamed from: e  reason: collision with root package name */
    Action1<SubjectObserver<T>> f42163e = Actions.a();

    /* renamed from: f  reason: collision with root package name */
    Action1<SubjectObserver<T>> f42164f = Actions.a();

    /* renamed from: g  reason: collision with root package name */
    Action1<SubjectObserver<T>> f42165g = Actions.a();

    /* renamed from: h  reason: collision with root package name */
    public final NotificationLite<T> f42166h = NotificationLite.a();

    protected static final class State<T> {

        /* renamed from: c  reason: collision with root package name */
        static final SubjectObserver[] f42167c;

        /* renamed from: d  reason: collision with root package name */
        static final State f42168d;

        /* renamed from: e  reason: collision with root package name */
        static final State f42169e;

        /* renamed from: a  reason: collision with root package name */
        final boolean f42170a;

        /* renamed from: b  reason: collision with root package name */
        final SubjectObserver[] f42171b;

        static {
            SubjectObserver[] subjectObserverArr = new SubjectObserver[0];
            f42167c = subjectObserverArr;
            f42168d = new State(true, subjectObserverArr);
            f42169e = new State(false, subjectObserverArr);
        }

        public State(boolean z2, SubjectObserver[] subjectObserverArr) {
            this.f42170a = z2;
            this.f42171b = subjectObserverArr;
        }
    }

    protected static final class SubjectObserver<T> implements Observer<T> {
    }

    static {
        Class<SubjectSubscriptionManager> cls = SubjectSubscriptionManager.class;
        f42158i = AtomicReferenceFieldUpdater.newUpdater(cls, State.class, "b");
        f42159j = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "c");
    }

    SubjectSubscriptionManager() {
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] a() {
        return this.f42160b.f42171b;
    }
}

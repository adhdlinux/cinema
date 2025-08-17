package rx.subjects;

import rx.Observable;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

public final class PublishSubject<T> extends Subject<T, T> {

    /* renamed from: e  reason: collision with root package name */
    final SubjectSubscriptionManager<T> f42155e;

    /* renamed from: f  reason: collision with root package name */
    private final NotificationLite<T> f42156f = NotificationLite.a();

    protected PublishSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.f42155e = subjectSubscriptionManager;
    }

    public static <T> PublishSubject<T> k() {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.f42165g = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
        };
        return new PublishSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    public void onNext(T t2) {
        SubjectSubscriptionManager.SubjectObserver[] a2 = this.f42155e.a();
        if (a2.length > 0) {
            SubjectSubscriptionManager.SubjectObserver subjectObserver = a2[0];
            throw null;
        }
    }
}

package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;

public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        final Disposable f40071b;

        DisposableNotification(Disposable disposable) {
            this.f40071b = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f40071b + "]";
        }
    }

    static final class ErrorNotification implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        final Throwable f40072b;

        ErrorNotification(Throwable th) {
            this.f40072b = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.c(this.f40072b, ((ErrorNotification) obj).f40072b);
            }
            return false;
        }

        public int hashCode() {
            return this.f40072b.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f40072b + "]";
        }
    }

    public static <T> boolean a(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f40072b);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean b(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f40072b);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).f40071b);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static Object c() {
        return COMPLETE;
    }

    public static Object d(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object e(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Throwable f(Object obj) {
        return ((ErrorNotification) obj).f40072b;
    }

    public static <T> T g(Object obj) {
        return obj;
    }

    public static boolean h(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean i(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static <T> Object j(T t2) {
        return t2;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}

package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Notification<Object> f38297b = new Notification<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    final Object f38298a;

    private Notification(Object obj) {
        this.f38298a = obj;
    }

    public static <T> Notification<T> a() {
        return f38297b;
    }

    public static <T> Notification<T> b(Throwable th) {
        ObjectHelper.e(th, "error is null");
        return new Notification<>(NotificationLite.e(th));
    }

    public static <T> Notification<T> c(T t2) {
        ObjectHelper.e(t2, "value is null");
        return new Notification<>(t2);
    }

    public Throwable d() {
        Object obj = this.f38298a;
        if (NotificationLite.i(obj)) {
            return NotificationLite.f(obj);
        }
        return null;
    }

    public T e() {
        Object obj = this.f38298a;
        if (obj == null || NotificationLite.i(obj)) {
            return null;
        }
        return this.f38298a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.c(this.f38298a, ((Notification) obj).f38298a);
        }
        return false;
    }

    public boolean f() {
        return this.f38298a == null;
    }

    public boolean g() {
        return NotificationLite.i(this.f38298a);
    }

    public boolean h() {
        Object obj = this.f38298a;
        if (obj == null || NotificationLite.i(obj)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f38298a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f38298a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.i(obj)) {
            return "OnErrorNotification[" + NotificationLite.f(obj) + "]";
        }
        return "OnNextNotification[" + this.f38298a + "]";
    }
}

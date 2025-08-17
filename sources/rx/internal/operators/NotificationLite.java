package rx.internal.operators;

import java.io.Serializable;

public final class NotificationLite<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final NotificationLite f42075a = new NotificationLite();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f42076b = new Serializable() {
        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Object f42077c = new Serializable() {
        public String toString() {
            return "Notification=>NULL";
        }
    };

    private NotificationLite() {
    }

    public static <T> NotificationLite<T> a() {
        return f42075a;
    }
}

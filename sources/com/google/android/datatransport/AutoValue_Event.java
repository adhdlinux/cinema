package com.google.android.datatransport;

final class AutoValue_Event<T> extends Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f22258a;

    /* renamed from: b  reason: collision with root package name */
    private final T f22259b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f22260c;

    AutoValue_Event(Integer num, T t2, Priority priority) {
        this.f22258a = num;
        if (t2 != null) {
            this.f22259b = t2;
            if (priority != null) {
                this.f22260c = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer a() {
        return this.f22258a;
    }

    public T b() {
        return this.f22259b;
    }

    public Priority c() {
        return this.f22260c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f22258a;
        if (num != null ? num.equals(event.a()) : event.a() == null) {
            if (!this.f22259b.equals(event.b()) || !this.f22260c.equals(event.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        Integer num = this.f22258a;
        if (num == null) {
            i2 = 0;
        } else {
            i2 = num.hashCode();
        }
        return ((((i2 ^ 1000003) * 1000003) ^ this.f22259b.hashCode()) * 1000003) ^ this.f22260c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f22258a + ", payload=" + this.f22259b + ", priority=" + this.f22260c + "}";
    }
}

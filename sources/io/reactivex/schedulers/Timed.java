package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f40135a;

    /* renamed from: b  reason: collision with root package name */
    final long f40136b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f40137c;

    public Timed(T t2, long j2, TimeUnit timeUnit) {
        this.f40135a = t2;
        this.f40136b = j2;
        this.f40137c = (TimeUnit) ObjectHelper.e(timeUnit, "unit is null");
    }

    public long a() {
        return this.f40136b;
    }

    public T b() {
        return this.f40135a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.c(this.f40135a, timed.f40135a) || this.f40136b != timed.f40136b || !ObjectHelper.c(this.f40137c, timed.f40137c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        T t2 = this.f40135a;
        if (t2 != null) {
            i2 = t2.hashCode();
        } else {
            i2 = 0;
        }
        long j2 = this.f40136b;
        return (((i2 * 31) + ((int) (j2 ^ (j2 >>> 31)))) * 31) + this.f40137c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f40136b + ", unit=" + this.f40137c + ", value=" + this.f40135a + "]";
    }
}

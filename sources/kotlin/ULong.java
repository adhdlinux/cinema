package kotlin;

import b0.y;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ULong implements Comparable<ULong> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40287c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final long f40288b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ ULong(long j2) {
        this.f40288b = j2;
    }

    public static final /* synthetic */ ULong a(long j2) {
        return new ULong(j2);
    }

    public static long b(long j2) {
        return j2;
    }

    public static boolean c(long j2, Object obj) {
        return (obj instanceof ULong) && j2 == ((ULong) obj).f();
    }

    public static int d(long j2) {
        return y.a(j2);
    }

    public static String e(long j2) {
        return UnsignedKt.c(j2);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.b(f(), ((ULong) obj).f());
    }

    public boolean equals(Object obj) {
        return c(this.f40288b, obj);
    }

    public final /* synthetic */ long f() {
        return this.f40288b;
    }

    public int hashCode() {
        return d(this.f40288b);
    }

    public String toString() {
        return e(this.f40288b);
    }
}

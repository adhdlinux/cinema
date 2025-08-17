package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class UInt implements Comparable<UInt> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40282c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f40283b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UInt(int i2) {
        this.f40283b = i2;
    }

    public static final /* synthetic */ UInt a(int i2) {
        return new UInt(i2);
    }

    public static int b(int i2) {
        return i2;
    }

    public static boolean c(int i2, Object obj) {
        return (obj instanceof UInt) && i2 == ((UInt) obj).f();
    }

    public static int d(int i2) {
        return i2;
    }

    public static String e(int i2) {
        return String.valueOf(((long) i2) & 4294967295L);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.a(f(), ((UInt) obj).f());
    }

    public boolean equals(Object obj) {
        return c(this.f40283b, obj);
    }

    public final /* synthetic */ int f() {
        return this.f40283b;
    }

    public int hashCode() {
        return d(this.f40283b);
    }

    public String toString() {
        return e(this.f40283b);
    }
}

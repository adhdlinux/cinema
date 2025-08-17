package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class UShort implements Comparable<UShort> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40293c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final short f40294b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UShort(short s2) {
        this.f40294b = s2;
    }

    public static final /* synthetic */ UShort a(short s2) {
        return new UShort(s2);
    }

    public static short b(short s2) {
        return s2;
    }

    public static boolean c(short s2, Object obj) {
        return (obj instanceof UShort) && s2 == ((UShort) obj).f();
    }

    public static int d(short s2) {
        return s2;
    }

    public static String e(short s2) {
        return String.valueOf(s2 & 65535);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.h(f() & 65535, ((UShort) obj).f() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f40294b, obj);
    }

    public final /* synthetic */ short f() {
        return this.f40294b;
    }

    public int hashCode() {
        return d(this.f40294b);
    }

    public String toString() {
        return e(this.f40294b);
    }
}

package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class UByte implements Comparable<UByte> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40277c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final byte f40278b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UByte(byte b2) {
        this.f40278b = b2;
    }

    public static final /* synthetic */ UByte a(byte b2) {
        return new UByte(b2);
    }

    public static byte b(byte b2) {
        return b2;
    }

    public static boolean c(byte b2, Object obj) {
        return (obj instanceof UByte) && b2 == ((UByte) obj).f();
    }

    public static int d(byte b2) {
        return b2;
    }

    public static String e(byte b2) {
        return String.valueOf(b2 & 255);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.h(f() & 255, ((UByte) obj).f() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f40278b, obj);
    }

    public final /* synthetic */ byte f() {
        return this.f40278b;
    }

    public int hashCode() {
        return d(this.f40278b);
    }

    public String toString() {
        return e(this.f40278b);
    }
}

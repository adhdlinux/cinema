package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Result<T> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40263c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final Object f40264b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Failure implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f40265b;

        public Failure(Throwable th) {
            Intrinsics.f(th, "exception");
            this.f40265b = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.a(this.f40265b, ((Failure) obj).f40265b);
        }

        public int hashCode() {
            return this.f40265b.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f40265b + ')';
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.f40264b = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    public static <T> Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.a(obj, ((Result) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return Intrinsics.a(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f40265b;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof Failure;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof Failure);
    }

    public static String i(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f40264b, obj);
    }

    public int hashCode() {
        return f(this.f40264b);
    }

    public final /* synthetic */ Object j() {
        return this.f40264b;
    }

    public String toString() {
        return i(this.f40264b);
    }
}

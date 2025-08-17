package androidx.core.util;

public class Pair<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f2721a;

    /* renamed from: b  reason: collision with root package name */
    public final S f2722b;

    public Pair(F f2, S s2) {
        this.f2721a = f2;
        this.f2722b = s2;
    }

    public static <A, B> Pair<A, B> a(A a2, B b2) {
        return new Pair<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.a(pair.f2721a, this.f2721a) || !ObjectsCompat.a(pair.f2722b, this.f2722b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f2 = this.f2721a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s2 = this.f2722b;
        if (s2 != null) {
            i2 = s2.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "Pair{" + this.f2721a + " " + this.f2722b + "}";
    }
}

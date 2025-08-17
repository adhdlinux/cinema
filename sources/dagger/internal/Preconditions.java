package dagger.internal;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> void a(T t2, Class<T> cls) {
        if (t2 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T b(T t2) {
        t2.getClass();
        return t2;
    }

    public static <T> T c(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable component method");
    }

    public static <T> T d(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}

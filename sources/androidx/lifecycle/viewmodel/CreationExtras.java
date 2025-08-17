package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public abstract class CreationExtras {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key<?>, Object> f3773a = new LinkedHashMap();

    public static final class Empty extends CreationExtras {

        /* renamed from: b  reason: collision with root package name */
        public static final Empty f3774b = new Empty();

        private Empty() {
        }

        public <T> T a(Key<T> key) {
            Intrinsics.f(key, "key");
            return null;
        }
    }

    public interface Key<T> {
    }

    public abstract <T> T a(Key<T> key);

    public final Map<Key<?>, Object> b() {
        return this.f3773a;
    }
}

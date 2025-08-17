package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class DescriptorSchemaCache {

    /* renamed from: a  reason: collision with root package name */
    private final Map<SerialDescriptor, Map<Key<Object>, Object>> f41211a = CreateMapForCacheKt.a(1);

    public static final class Key<T> {
    }

    public final <T> T a(SerialDescriptor serialDescriptor, Key<T> key) {
        T t2;
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(key, "key");
        Map map = this.f41211a.get(serialDescriptor);
        if (map != null) {
            t2 = map.get(key);
        } else {
            t2 = null;
        }
        if (t2 == null) {
            return null;
        }
        return t2;
    }

    public final <T> T b(SerialDescriptor serialDescriptor, Key<T> key, Function0<? extends T> function0) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(key, "key");
        Intrinsics.f(function0, "defaultValue");
        T a2 = a(serialDescriptor, key);
        if (a2 != null) {
            return a2;
        }
        T invoke = function0.invoke();
        c(serialDescriptor, key, invoke);
        return invoke;
    }

    public final <T> void c(SerialDescriptor serialDescriptor, Key<T> key, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(key, "key");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Map<SerialDescriptor, Map<Key<Object>, Object>> map = this.f41211a;
        Map<Key<Object>, Object> map2 = map.get(serialDescriptor);
        if (map2 == null) {
            map2 = CreateMapForCacheKt.a(1);
            map.put(serialDescriptor, map2);
        }
        map2.put(key, t2);
    }
}

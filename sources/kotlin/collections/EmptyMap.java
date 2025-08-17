package kotlin.collections;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

final class EmptyMap implements Map, Serializable, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    public static final EmptyMap f40320b = new EmptyMap();

    private EmptyMap() {
    }

    public boolean a(Void voidR) {
        Intrinsics.f(voidR, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return false;
    }

    /* renamed from: b */
    public Void get(Object obj) {
        return null;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return a((Void) obj);
    }

    public Set<Map.Entry> d() {
        return EmptySet.f40321b;
    }

    public Set<Object> e() {
        return EmptySet.f40321b;
    }

    public final /* bridge */ Set<Map.Entry> entrySet() {
        return d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public int f() {
        return 0;
    }

    public Collection g() {
        return EmptyList.f40319b;
    }

    /* renamed from: h */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public final /* bridge */ Set<Object> keySet() {
        return e();
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return f();
    }

    public String toString() {
        return JsonUtils.EMPTY_JSON;
    }

    public final /* bridge */ Collection values() {
        return g();
    }
}

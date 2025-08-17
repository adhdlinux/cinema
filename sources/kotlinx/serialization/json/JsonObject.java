package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.Serializable;

@Serializable(with = JsonObjectSerializer.class)
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f41172d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, JsonElement> f41173c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonObject(Map<String, ? extends JsonElement> map) {
        super((DefaultConstructorMarker) null);
        Intrinsics.f(map, "content");
        this.f41173c = map;
    }

    public boolean a(String str) {
        Intrinsics.f(str, "key");
        return this.f41173c.containsKey(str);
    }

    public boolean b(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return this.f41173c.containsValue(jsonElement);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return a((String) obj);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        return b((JsonElement) obj);
    }

    public JsonElement d(String str) {
        Intrinsics.f(str, "key");
        return this.f41173c.get(str);
    }

    public Set<Map.Entry<String, JsonElement>> e() {
        return this.f41173c.entrySet();
    }

    public final /* bridge */ Set<Map.Entry<String, JsonElement>> entrySet() {
        return e();
    }

    public boolean equals(Object obj) {
        return Intrinsics.a(this.f41173c, obj);
    }

    public Set<String> g() {
        return this.f41173c.keySet();
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return d((String) obj);
    }

    public int h() {
        return this.f41173c.size();
    }

    public int hashCode() {
        return this.f41173c.hashCode();
    }

    public Collection<JsonElement> i() {
        return this.f41173c.values();
    }

    public boolean isEmpty() {
        return this.f41173c.isEmpty();
    }

    /* renamed from: j */
    public JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ Set<String> keySet() {
        return g();
    }

    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return h();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.J(this.f41173c.entrySet(), ",", "{", "}", 0, (CharSequence) null, JsonObject$toString$1.f41174f, 24, (Object) null);
    }

    public final /* bridge */ Collection<JsonElement> values() {
        return i();
    }
}

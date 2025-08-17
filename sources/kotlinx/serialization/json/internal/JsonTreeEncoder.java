package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

class JsonTreeEncoder extends AbstractJsonTreeEncoder {

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, JsonElement> f41230f = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(function1, "nodeConsumer");
    }

    public <T> void i(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(serializationStrategy, "serializer");
        if (t2 != null || this.f41193d.f()) {
            super.i(serialDescriptor, i2, serializationStrategy, t2);
        }
    }

    public JsonElement v0() {
        return new JsonObject(this.f41230f);
    }

    public void w0(String str, JsonElement jsonElement) {
        Intrinsics.f(str, "key");
        Intrinsics.f(jsonElement, "element");
        this.f41230f.put(str, jsonElement);
    }

    /* access modifiers changed from: protected */
    public final Map<String, JsonElement> x0() {
        return this.f41230f;
    }
}

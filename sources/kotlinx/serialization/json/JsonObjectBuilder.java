package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class JsonObjectBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, JsonElement> f41175a = new LinkedHashMap();

    public final JsonObject a() {
        return new JsonObject(this.f41175a);
    }

    public final JsonElement b(String str, JsonElement jsonElement) {
        Intrinsics.f(str, "key");
        Intrinsics.f(jsonElement, "element");
        return this.f41175a.put(str, jsonElement);
    }
}

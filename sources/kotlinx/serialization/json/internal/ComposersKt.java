package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

public final class ComposersKt {
    public static final Composer a(JsonWriter jsonWriter, Json json) {
        Intrinsics.f(jsonWriter, "sb");
        Intrinsics.f(json, "json");
        if (json.e().h()) {
            return new ComposerWithPrettyPrint(jsonWriter, json);
        }
        return new Composer(jsonWriter);
    }
}

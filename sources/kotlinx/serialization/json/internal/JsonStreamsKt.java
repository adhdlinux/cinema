package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;

public final class JsonStreamsKt {
    public static final <T> void a(Json json, JsonWriter jsonWriter, SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(jsonWriter, "writer");
        Intrinsics.f(serializationStrategy, "serializer");
        new StreamingJsonEncoder(jsonWriter, json, WriteMode.OBJ, new JsonEncoder[WriteMode.values().length]).e(serializationStrategy, t2);
    }
}

package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

public final class JsonEncodingException extends JsonException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonEncodingException(String str) {
        super(str);
        Intrinsics.f(str, "message");
    }
}

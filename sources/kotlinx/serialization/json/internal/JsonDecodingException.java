package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

public final class JsonDecodingException extends JsonException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonDecodingException(String str) {
        super(str);
        Intrinsics.f(str, "message");
    }
}

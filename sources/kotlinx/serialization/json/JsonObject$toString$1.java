package kotlinx.serialization.json;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.StringOpsKt;

final class JsonObject$toString$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends JsonElement>, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    public static final JsonObject$toString$1 f41174f = new JsonObject$toString$1();

    JsonObject$toString$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(Map.Entry<String, ? extends JsonElement> entry) {
        Intrinsics.f(entry, "<name for destructuring parameter 0>");
        StringBuilder sb = new StringBuilder();
        StringOpsKt.c(sb, entry.getKey());
        sb.append(':');
        sb.append((JsonElement) entry.getValue());
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

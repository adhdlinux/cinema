package kotlinx.serialization.json;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

final class JsonNull$$cachedSerializer$delegate$1 extends Lambda implements Function0<KSerializer<Object>> {

    /* renamed from: f  reason: collision with root package name */
    public static final JsonNull$$cachedSerializer$delegate$1 f41169f = new JsonNull$$cachedSerializer$delegate$1();

    JsonNull$$cachedSerializer$delegate$1() {
        super(0);
    }

    /* renamed from: b */
    public final KSerializer<Object> invoke() {
        return JsonNullSerializer.f41170a;
    }
}

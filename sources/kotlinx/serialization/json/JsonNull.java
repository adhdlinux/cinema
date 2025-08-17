package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = JsonNullSerializer.class)
public final class JsonNull extends JsonPrimitive {

    /* renamed from: d  reason: collision with root package name */
    public static final JsonNull f41166d = new JsonNull();

    /* renamed from: e  reason: collision with root package name */
    private static final String f41167e = "null";

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ Lazy<KSerializer<Object>> f41168f = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, JsonNull$$cachedSerializer$delegate$1.f41169f);

    private JsonNull() {
        super((DefaultConstructorMarker) null);
    }

    public String a() {
        return f41167e;
    }
}

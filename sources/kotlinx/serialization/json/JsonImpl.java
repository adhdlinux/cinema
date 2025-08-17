package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.PolymorphismValidator;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

final class JsonImpl extends Json {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonImpl(JsonConfiguration jsonConfiguration, SerializersModule serializersModule) {
        super(jsonConfiguration, serializersModule, (DefaultConstructorMarker) null);
        Intrinsics.f(jsonConfiguration, "configuration");
        Intrinsics.f(serializersModule, "module");
        g();
    }

    private final void g() {
        if (!Intrinsics.a(a(), SerializersModuleBuildersKt.a())) {
            a().a(new PolymorphismValidator(e().k(), e().c()));
        }
    }
}

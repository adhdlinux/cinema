package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonElement;

final class AbstractJsonTreeEncoder$beginStructure$consumer$1 extends Lambda implements Function1<JsonElement, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ AbstractJsonTreeEncoder f41195f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractJsonTreeEncoder$beginStructure$consumer$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        super(1);
        this.f41195f = abstractJsonTreeEncoder;
    }

    public final void a(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "node");
        AbstractJsonTreeEncoder abstractJsonTreeEncoder = this.f41195f;
        abstractJsonTreeEncoder.w0(AbstractJsonTreeEncoder.h0(abstractJsonTreeEncoder), jsonElement);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((JsonElement) obj);
        return Unit.f40298a;
    }
}

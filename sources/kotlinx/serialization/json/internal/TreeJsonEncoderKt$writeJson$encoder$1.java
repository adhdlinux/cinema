package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.json.JsonElement;

final class TreeJsonEncoderKt$writeJson$encoder$1 extends Lambda implements Function1<JsonElement, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<JsonElement> f41279f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TreeJsonEncoderKt$writeJson$encoder$1(Ref$ObjectRef<JsonElement> ref$ObjectRef) {
        super(1);
        this.f41279f = ref$ObjectRef;
    }

    public final void a(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "it");
        this.f41279f.f40429b = jsonElement;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((JsonElement) obj);
        return Unit.f40298a;
    }
}

package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

final class SerializersModuleCollector$contextual$1 extends Lambda implements Function1<List<? extends KSerializer<?>>, KSerializer<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ KSerializer<T> f41294f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SerializersModuleCollector$contextual$1(KSerializer<T> kSerializer) {
        super(1);
        this.f41294f = kSerializer;
    }

    /* renamed from: a */
    public final KSerializer<?> invoke(List<? extends KSerializer<?>> list) {
        Intrinsics.f(list, "it");
        return this.f41294f;
    }
}

package kotlinx.serialization.json.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<SerialDescriptor, Integer, Boolean> {
    JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean a(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "p0");
        return Boolean.valueOf(((JsonElementMarker) this.receiver).e(serialDescriptor, i2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((SerialDescriptor) obj, ((Number) obj2).intValue());
    }
}

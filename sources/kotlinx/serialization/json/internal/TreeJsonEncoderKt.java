package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

public final class TreeJsonEncoderKt {
    /* access modifiers changed from: private */
    public static final boolean b(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.d() instanceof PrimitiveKind) || serialDescriptor.d() == SerialKind.ENUM.f40938a;
    }

    public static final <T> JsonElement c(Json json, T t2, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(serializationStrategy, "serializer");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        new JsonTreeEncoder(json, new TreeJsonEncoderKt$writeJson$encoder$1(ref$ObjectRef)).e(serializationStrategy, t2);
        T t3 = ref$ObjectRef.f40429b;
        if (t3 != null) {
            return (JsonElement) t3;
        }
        Intrinsics.x("result");
        return null;
    }
}

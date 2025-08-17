package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* synthetic */ class JsonTreeDecoder$elementName$alternativeNamesMap$1 extends FunctionReferenceImpl implements Function0<Map<String, ? extends Integer>> {
    JsonTreeDecoder$elementName$alternativeNamesMap$1(Object obj) {
        super(0, obj, JsonNamesMapKt.class, "buildAlternativeNamesMap", "buildAlternativeNamesMap(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", 1);
    }

    /* renamed from: g */
    public final Map<String, Integer> invoke() {
        return JsonNamesMapKt.a((SerialDescriptor) this.receiver);
    }
}

package kotlinx.serialization.json;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class JsonElementSerializersKt {
    public static final JsonDecoder d(Decoder decoder) {
        JsonDecoder jsonDecoder;
        Intrinsics.f(decoder, "<this>");
        if (decoder instanceof JsonDecoder) {
            jsonDecoder = (JsonDecoder) decoder;
        } else {
            jsonDecoder = null;
        }
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.b(decoder.getClass()));
    }

    public static final JsonEncoder e(Encoder encoder) {
        JsonEncoder jsonEncoder;
        Intrinsics.f(encoder, "<this>");
        if (encoder instanceof JsonEncoder) {
            jsonEncoder = (JsonEncoder) encoder;
        } else {
            jsonEncoder = null;
        }
        if (jsonEncoder != null) {
            return jsonEncoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.b(encoder.getClass()));
    }

    /* access modifiers changed from: private */
    public static final SerialDescriptor f(Function0<? extends SerialDescriptor> function0) {
        return new JsonElementSerializersKt$defer$1(function0);
    }

    /* access modifiers changed from: private */
    public static final void g(Decoder decoder) {
        d(decoder);
    }

    /* access modifiers changed from: private */
    public static final void h(Encoder encoder) {
        e(encoder);
    }
}

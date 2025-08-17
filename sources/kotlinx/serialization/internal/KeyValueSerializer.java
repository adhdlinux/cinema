package kotlinx.serialization.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<K> f41008a;

    /* renamed from: b  reason: collision with root package name */
    private final KSerializer<V> f41009b;

    private KeyValueSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.f41008a = kSerializer;
        this.f41009b = kSerializer2;
    }

    public /* synthetic */ KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    /* access modifiers changed from: protected */
    public abstract K a(R r2);

    /* access modifiers changed from: protected */
    public abstract V b(R r2);

    /* access modifiers changed from: protected */
    public abstract R c(K k2, V v2);

    public R deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        CompositeDecoder b2 = decoder.b(getDescriptor());
        if (b2.p()) {
            CompositeDecoder compositeDecoder = b2;
            return c(CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, this.f41008a, (Object) null, 8, (Object) null), CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, this.f41009b, (Object) null, 8, (Object) null));
        }
        Object a2 = TuplesKt.f41093a;
        Object a3 = TuplesKt.f41093a;
        while (true) {
            int o2 = b2.o(getDescriptor());
            if (o2 == -1) {
                b2.c(getDescriptor());
                if (a2 == TuplesKt.f41093a) {
                    throw new SerializationException("Element 'key' is missing");
                } else if (a3 != TuplesKt.f41093a) {
                    return c(a2, a3);
                } else {
                    throw new SerializationException("Element 'value' is missing");
                }
            } else if (o2 == 0) {
                a2 = CompositeDecoder.DefaultImpls.c(b2, getDescriptor(), 0, this.f41008a, (Object) null, 8, (Object) null);
            } else if (o2 == 1) {
                a3 = CompositeDecoder.DefaultImpls.c(b2, getDescriptor(), 1, this.f41009b, (Object) null, 8, (Object) null);
            } else {
                throw new SerializationException("Invalid index: " + o2);
            }
        }
    }

    public void serialize(Encoder encoder, R r2) {
        Intrinsics.f(encoder, "encoder");
        CompositeEncoder b2 = encoder.b(getDescriptor());
        b2.C(getDescriptor(), 0, this.f41008a, a(r2));
        b2.C(getDescriptor(), 1, this.f41009b, b(r2));
        b2.c(getDescriptor());
    }
}

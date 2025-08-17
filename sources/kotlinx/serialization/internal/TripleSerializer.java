package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final KSerializer<A> f41088a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final KSerializer<B> f41089b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final KSerializer<C> f41090c;

    /* renamed from: d  reason: collision with root package name */
    private final SerialDescriptor f41091d = SerialDescriptorsKt.b("kotlin.Triple", new SerialDescriptor[0], new TripleSerializer$descriptor$1(this));

    public TripleSerializer(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        Intrinsics.f(kSerializer, "aSerializer");
        Intrinsics.f(kSerializer2, "bSerializer");
        Intrinsics.f(kSerializer3, "cSerializer");
        this.f41088a = kSerializer;
        this.f41089b = kSerializer2;
        this.f41090c = kSerializer3;
    }

    private final Triple<A, B, C> d(CompositeDecoder compositeDecoder) {
        Object c2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, this.f41088a, (Object) null, 8, (Object) null);
        Object c3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, this.f41089b, (Object) null, 8, (Object) null);
        Object c4 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 2, this.f41090c, (Object) null, 8, (Object) null);
        compositeDecoder.c(getDescriptor());
        return new Triple<>(c2, c3, c4);
    }

    private final Triple<A, B, C> e(CompositeDecoder compositeDecoder) {
        Object a2 = TuplesKt.f41093a;
        Object a3 = TuplesKt.f41093a;
        Object a4 = TuplesKt.f41093a;
        while (true) {
            int o2 = compositeDecoder.o(getDescriptor());
            if (o2 == -1) {
                compositeDecoder.c(getDescriptor());
                if (a2 == TuplesKt.f41093a) {
                    throw new SerializationException("Element 'first' is missing");
                } else if (a3 == TuplesKt.f41093a) {
                    throw new SerializationException("Element 'second' is missing");
                } else if (a4 != TuplesKt.f41093a) {
                    return new Triple<>(a2, a3, a4);
                } else {
                    throw new SerializationException("Element 'third' is missing");
                }
            } else if (o2 == 0) {
                a2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, this.f41088a, (Object) null, 8, (Object) null);
            } else if (o2 == 1) {
                a3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, this.f41089b, (Object) null, 8, (Object) null);
            } else if (o2 == 2) {
                a4 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 2, this.f41090c, (Object) null, 8, (Object) null);
            } else {
                throw new SerializationException("Unexpected index " + o2);
            }
        }
    }

    /* renamed from: f */
    public Triple<A, B, C> deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        CompositeDecoder b2 = decoder.b(getDescriptor());
        if (b2.p()) {
            return d(b2);
        }
        return e(b2);
    }

    /* renamed from: g */
    public void serialize(Encoder encoder, Triple<? extends A, ? extends B, ? extends C> triple) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(triple, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        CompositeEncoder b2 = encoder.b(getDescriptor());
        b2.C(getDescriptor(), 0, this.f41088a, triple.a());
        b2.C(getDescriptor(), 1, this.f41089b, triple.b());
        b2.C(getDescriptor(), 2, this.f41090c, triple.c());
        b2.c(getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f41091d;
    }
}

package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

public final class RtbRequest$$serializer implements GeneratedSerializer<RtbRequest> {
    public static final RtbRequest$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        RtbRequest$$serializer rtbRequest$$serializer = new RtbRequest$$serializer();
        INSTANCE = rtbRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbRequest", rtbRequest$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("sdk_user_agent", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RtbRequest$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(StringSerializer.f41077a)};
    }

    public RtbRequest deserialize(Decoder decoder) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        int i2 = 1;
        if (b2.p()) {
            obj = b2.n(descriptor2, 0, StringSerializer.f41077a, null);
        } else {
            obj = null;
            int i3 = 0;
            while (i2 != 0) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    i2 = 0;
                } else if (o2 == 0) {
                    obj = b2.n(descriptor2, 0, StringSerializer.f41077a, obj);
                    i3 |= 1;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
        }
        b2.c(descriptor2);
        return new RtbRequest(i2, (String) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, RtbRequest rtbRequest) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(rtbRequest, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        RtbRequest.write$Self(rtbRequest, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

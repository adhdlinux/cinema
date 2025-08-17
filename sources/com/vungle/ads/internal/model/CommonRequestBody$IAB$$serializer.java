package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.CommonRequestBody;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

public final class CommonRequestBody$IAB$$serializer implements GeneratedSerializer<CommonRequestBody.IAB> {
    public static final CommonRequestBody$IAB$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CommonRequestBody$IAB$$serializer commonRequestBody$IAB$$serializer = new CommonRequestBody$IAB$$serializer();
        INSTANCE = commonRequestBody$IAB$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.IAB", commonRequestBody$IAB$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("tcf", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$IAB$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f41077a};
    }

    public CommonRequestBody.IAB deserialize(Decoder decoder) {
        String str;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        int i2 = 1;
        if (b2.p()) {
            str = b2.m(descriptor2, 0);
        } else {
            str = null;
            int i3 = 0;
            while (i2 != 0) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    i2 = 0;
                } else if (o2 == 0) {
                    str = b2.m(descriptor2, 0);
                    i3 |= 1;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
        }
        b2.c(descriptor2);
        return new CommonRequestBody.IAB(i2, str, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CommonRequestBody.IAB iab) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(iab, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        CommonRequestBody.IAB.write$Self(iab, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

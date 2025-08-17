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

public final class CommonRequestBody$CCPA$$serializer implements GeneratedSerializer<CommonRequestBody.CCPA> {
    public static final CommonRequestBody$CCPA$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CommonRequestBody$CCPA$$serializer commonRequestBody$CCPA$$serializer = new CommonRequestBody$CCPA$$serializer();
        INSTANCE = commonRequestBody$CCPA$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.CCPA", commonRequestBody$CCPA$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("status", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$CCPA$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f41077a};
    }

    public CommonRequestBody.CCPA deserialize(Decoder decoder) {
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
        return new CommonRequestBody.CCPA(i2, str, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CommonRequestBody.CCPA ccpa) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(ccpa, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        CommonRequestBody.CCPA.write$Self(ccpa, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

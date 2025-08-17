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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class CommonRequestBody$AdSizeParam$$serializer implements GeneratedSerializer<CommonRequestBody.AdSizeParam> {
    public static final CommonRequestBody$AdSizeParam$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CommonRequestBody$AdSizeParam$$serializer commonRequestBody$AdSizeParam$$serializer = new CommonRequestBody$AdSizeParam$$serializer();
        INSTANCE = commonRequestBody$AdSizeParam$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.AdSizeParam", commonRequestBody$AdSizeParam$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("w", false);
        pluginGeneratedSerialDescriptor.l("h", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$AdSizeParam$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.f41006a;
        return new KSerializer[]{intSerializer, intSerializer};
    }

    public CommonRequestBody.AdSizeParam deserialize(Decoder decoder) {
        int i2;
        int i3;
        int i4;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            i4 = b2.i(descriptor2, 0);
            i3 = b2.i(descriptor2, 1);
            i2 = 3;
        } else {
            i4 = 0;
            int i5 = 0;
            int i6 = 0;
            boolean z2 = true;
            while (z2) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    z2 = false;
                } else if (o2 == 0) {
                    i4 = b2.i(descriptor2, 0);
                    i6 |= 1;
                } else if (o2 == 1) {
                    i5 = b2.i(descriptor2, 1);
                    i6 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i3 = i5;
            i2 = i6;
        }
        b2.c(descriptor2);
        return new CommonRequestBody.AdSizeParam(i2, i4, i3, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CommonRequestBody.AdSizeParam adSizeParam) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(adSizeParam, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        CommonRequestBody.AdSizeParam.write$Self(adSizeParam, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.AdPayload;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class AdPayload$AdSizeInfo$$serializer implements GeneratedSerializer<AdPayload.AdSizeInfo> {
    public static final AdPayload$AdSizeInfo$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$AdSizeInfo$$serializer adPayload$AdSizeInfo$$serializer = new AdPayload$AdSizeInfo$$serializer();
        INSTANCE = adPayload$AdSizeInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.AdSizeInfo", adPayload$AdSizeInfo$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("w", true);
        pluginGeneratedSerialDescriptor.l("h", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$AdSizeInfo$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.f41006a;
        return new KSerializer[]{BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer)};
    }

    public AdPayload.AdSizeInfo deserialize(Decoder decoder) {
        Object obj;
        int i2;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            IntSerializer intSerializer = IntSerializer.f41006a;
            obj = b2.n(descriptor2, 0, intSerializer, null);
            obj2 = b2.n(descriptor2, 1, intSerializer, null);
            i2 = 3;
        } else {
            obj2 = null;
            Object obj3 = null;
            int i3 = 0;
            boolean z2 = true;
            while (z2) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    z2 = false;
                } else if (o2 == 0) {
                    obj3 = b2.n(descriptor2, 0, IntSerializer.f41006a, obj3);
                    i3 |= 1;
                } else if (o2 == 1) {
                    obj2 = b2.n(descriptor2, 1, IntSerializer.f41006a, obj2);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
            obj = obj3;
        }
        b2.c(descriptor2);
        return new AdPayload.AdSizeInfo(i2, (Integer) obj, (Integer) obj2, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.AdSizeInfo adSizeInfo) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(adSizeInfo, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.AdSizeInfo.write$Self(adSizeInfo, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

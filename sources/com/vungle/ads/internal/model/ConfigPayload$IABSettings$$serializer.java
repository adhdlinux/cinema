package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.ConfigPayload;
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

public final class ConfigPayload$IABSettings$$serializer implements GeneratedSerializer<ConfigPayload.IABSettings> {
    public static final ConfigPayload$IABSettings$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$IABSettings$$serializer configPayload$IABSettings$$serializer = new ConfigPayload$IABSettings$$serializer();
        INSTANCE = configPayload$IABSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.IABSettings", configPayload$IABSettings$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("tcf_status", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$IABSettings$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(IntSerializer.f41006a)};
    }

    public ConfigPayload.IABSettings deserialize(Decoder decoder) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        int i2 = 1;
        if (b2.p()) {
            obj = b2.n(descriptor2, 0, IntSerializer.f41006a, null);
        } else {
            obj = null;
            int i3 = 0;
            while (i2 != 0) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    i2 = 0;
                } else if (o2 == 0) {
                    obj = b2.n(descriptor2, 0, IntSerializer.f41006a, obj);
                    i3 |= 1;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
        }
        b2.c(descriptor2);
        return new ConfigPayload.IABSettings(i2, (Integer) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.IABSettings iABSettings) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(iABSettings, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.IABSettings.write$Self(iABSettings, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

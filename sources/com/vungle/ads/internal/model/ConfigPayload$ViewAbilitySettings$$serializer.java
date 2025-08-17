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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class ConfigPayload$ViewAbilitySettings$$serializer implements GeneratedSerializer<ConfigPayload.ViewAbilitySettings> {
    public static final ConfigPayload$ViewAbilitySettings$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$ViewAbilitySettings$$serializer configPayload$ViewAbilitySettings$$serializer = new ConfigPayload$ViewAbilitySettings$$serializer();
        INSTANCE = configPayload$ViewAbilitySettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.ViewAbilitySettings", configPayload$ViewAbilitySettings$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("om", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$ViewAbilitySettings$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(BooleanSerializer.f40947a)};
    }

    public ConfigPayload.ViewAbilitySettings deserialize(Decoder decoder) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        int i2 = 1;
        if (b2.p()) {
            obj = b2.n(descriptor2, 0, BooleanSerializer.f40947a, null);
        } else {
            obj = null;
            int i3 = 0;
            while (i2 != 0) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    i2 = 0;
                } else if (o2 == 0) {
                    obj = b2.n(descriptor2, 0, BooleanSerializer.f40947a, obj);
                    i3 |= 1;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
        }
        b2.c(descriptor2);
        return new ConfigPayload.ViewAbilitySettings(i2, (Boolean) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.ViewAbilitySettings viewAbilitySettings) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(viewAbilitySettings, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.ViewAbilitySettings.write$Self(viewAbilitySettings, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

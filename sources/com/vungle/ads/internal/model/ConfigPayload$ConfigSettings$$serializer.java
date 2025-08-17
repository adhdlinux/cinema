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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class ConfigPayload$ConfigSettings$$serializer implements GeneratedSerializer<ConfigPayload.ConfigSettings> {
    public static final ConfigPayload$ConfigSettings$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$ConfigSettings$$serializer configPayload$ConfigSettings$$serializer = new ConfigPayload$ConfigSettings$$serializer();
        INSTANCE = configPayload$ConfigSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.ConfigSettings", configPayload$ConfigSettings$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("refresh_interval", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$ConfigSettings$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(LongSerializer.f41017a)};
    }

    public ConfigPayload.ConfigSettings deserialize(Decoder decoder) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        int i2 = 1;
        if (b2.p()) {
            obj = b2.n(descriptor2, 0, LongSerializer.f41017a, null);
        } else {
            obj = null;
            int i3 = 0;
            while (i2 != 0) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    i2 = 0;
                } else if (o2 == 0) {
                    obj = b2.n(descriptor2, 0, LongSerializer.f41017a, obj);
                    i3 |= 1;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
        }
        b2.c(descriptor2);
        return new ConfigPayload.ConfigSettings(i2, (Long) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.ConfigSettings configSettings) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(configSettings, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.ConfigSettings.write$Self(configSettings, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

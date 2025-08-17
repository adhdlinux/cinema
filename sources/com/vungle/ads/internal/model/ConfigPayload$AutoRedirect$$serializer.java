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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class ConfigPayload$AutoRedirect$$serializer implements GeneratedSerializer<ConfigPayload.AutoRedirect> {
    public static final ConfigPayload$AutoRedirect$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$AutoRedirect$$serializer configPayload$AutoRedirect$$serializer = new ConfigPayload$AutoRedirect$$serializer();
        INSTANCE = configPayload$AutoRedirect$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.AutoRedirect", configPayload$AutoRedirect$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("allow_auto_redirect", true);
        pluginGeneratedSerialDescriptor.l("after_click_ms", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$AutoRedirect$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(BooleanSerializer.f40947a), BuiltinSerializersKt.s(LongSerializer.f41017a)};
    }

    public ConfigPayload.AutoRedirect deserialize(Decoder decoder) {
        int i2;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            obj2 = b2.n(descriptor2, 0, BooleanSerializer.f40947a, null);
            obj = b2.n(descriptor2, 1, LongSerializer.f41017a, null);
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
                    obj2 = b2.n(descriptor2, 0, BooleanSerializer.f40947a, obj2);
                    i3 |= 1;
                } else if (o2 == 1) {
                    obj3 = b2.n(descriptor2, 1, LongSerializer.f41017a, obj3);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            obj = obj3;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new ConfigPayload.AutoRedirect(i2, (Boolean) obj2, (Long) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.AutoRedirect autoRedirect) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(autoRedirect, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.AutoRedirect.write$Self(autoRedirect, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

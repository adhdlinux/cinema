package com.vungle.ads.internal.model;

import com.chartboost.sdk.privacy.model.GDPR;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class ConfigPayload$UserPrivacy$$serializer implements GeneratedSerializer<ConfigPayload.UserPrivacy> {
    public static final ConfigPayload$UserPrivacy$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$UserPrivacy$$serializer configPayload$UserPrivacy$$serializer = new ConfigPayload$UserPrivacy$$serializer();
        INSTANCE = configPayload$UserPrivacy$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.UserPrivacy", configPayload$UserPrivacy$$serializer, 2);
        pluginGeneratedSerialDescriptor.l(GDPR.GDPR_STANDARD, true);
        pluginGeneratedSerialDescriptor.l("iab", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$UserPrivacy$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(ConfigPayload$GDPRSettings$$serializer.INSTANCE), BuiltinSerializersKt.s(ConfigPayload$IABSettings$$serializer.INSTANCE)};
    }

    public ConfigPayload.UserPrivacy deserialize(Decoder decoder) {
        int i2;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            obj2 = b2.n(descriptor2, 0, ConfigPayload$GDPRSettings$$serializer.INSTANCE, null);
            obj = b2.n(descriptor2, 1, ConfigPayload$IABSettings$$serializer.INSTANCE, null);
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
                    obj2 = b2.n(descriptor2, 0, ConfigPayload$GDPRSettings$$serializer.INSTANCE, obj2);
                    i3 |= 1;
                } else if (o2 == 1) {
                    obj3 = b2.n(descriptor2, 1, ConfigPayload$IABSettings$$serializer.INSTANCE, obj3);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            obj = obj3;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new ConfigPayload.UserPrivacy(i2, (ConfigPayload.GDPRSettings) obj2, (ConfigPayload.IABSettings) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.UserPrivacy userPrivacy) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(userPrivacy, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.UserPrivacy.write$Self(userPrivacy, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

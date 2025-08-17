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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

public final class AdPayload$ViewAbility$$serializer implements GeneratedSerializer<AdPayload.ViewAbility> {
    public static final AdPayload$ViewAbility$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$ViewAbility$$serializer adPayload$ViewAbility$$serializer = new AdPayload$ViewAbility$$serializer();
        INSTANCE = adPayload$ViewAbility$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.ViewAbility", adPayload$ViewAbility$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("om", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$ViewAbility$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(AdPayload$ViewAbilityInfo$$serializer.INSTANCE)};
    }

    public AdPayload.ViewAbility deserialize(Decoder decoder) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        int i2 = 1;
        if (b2.p()) {
            obj = b2.n(descriptor2, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE, null);
        } else {
            obj = null;
            int i3 = 0;
            while (i2 != 0) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    i2 = 0;
                } else if (o2 == 0) {
                    obj = b2.n(descriptor2, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE, obj);
                    i3 |= 1;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            i2 = i3;
        }
        b2.c(descriptor2);
        return new AdPayload.ViewAbility(i2, (AdPayload.ViewAbilityInfo) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.ViewAbility viewAbility) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(viewAbility, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.ViewAbility.write$Self(viewAbility, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

public final class AdPayload$ViewAbilityInfo$$serializer implements GeneratedSerializer<AdPayload.ViewAbilityInfo> {
    public static final AdPayload$ViewAbilityInfo$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$ViewAbilityInfo$$serializer adPayload$ViewAbilityInfo$$serializer = new AdPayload$ViewAbilityInfo$$serializer();
        INSTANCE = adPayload$ViewAbilityInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.ViewAbilityInfo", adPayload$ViewAbilityInfo$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("is_enabled", true);
        pluginGeneratedSerialDescriptor.l("extra_vast", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$ViewAbilityInfo$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(BooleanSerializer.f40947a), BuiltinSerializersKt.s(StringSerializer.f41077a)};
    }

    public AdPayload.ViewAbilityInfo deserialize(Decoder decoder) {
        int i2;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            obj2 = b2.n(descriptor2, 0, BooleanSerializer.f40947a, null);
            obj = b2.n(descriptor2, 1, StringSerializer.f41077a, null);
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
                    obj3 = b2.n(descriptor2, 1, StringSerializer.f41077a, obj3);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            obj = obj3;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new AdPayload.ViewAbilityInfo(i2, (Boolean) obj2, (String) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.ViewAbilityInfo viewAbilityInfo) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(viewAbilityInfo, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.ViewAbilityInfo.write$Self(viewAbilityInfo, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

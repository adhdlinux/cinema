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
import kotlinx.serialization.internal.StringSerializer;

public final class AdPayload$PlacementAdUnit$$serializer implements GeneratedSerializer<AdPayload.PlacementAdUnit> {
    public static final AdPayload$PlacementAdUnit$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$PlacementAdUnit$$serializer adPayload$PlacementAdUnit$$serializer = new AdPayload$PlacementAdUnit$$serializer();
        INSTANCE = adPayload$PlacementAdUnit$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.PlacementAdUnit", adPayload$PlacementAdUnit$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("placement_reference_id", true);
        pluginGeneratedSerialDescriptor.l("ad_markup", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$PlacementAdUnit$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(StringSerializer.f41077a), BuiltinSerializersKt.s(AdPayload$AdUnit$$serializer.INSTANCE)};
    }

    public AdPayload.PlacementAdUnit deserialize(Decoder decoder) {
        int i2;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            obj2 = b2.n(descriptor2, 0, StringSerializer.f41077a, null);
            obj = b2.n(descriptor2, 1, AdPayload$AdUnit$$serializer.INSTANCE, null);
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
                    obj2 = b2.n(descriptor2, 0, StringSerializer.f41077a, obj2);
                    i3 |= 1;
                } else if (o2 == 1) {
                    obj3 = b2.n(descriptor2, 1, AdPayload$AdUnit$$serializer.INSTANCE, obj3);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            obj = obj3;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new AdPayload.PlacementAdUnit(i2, (String) obj2, (AdPayload.AdUnit) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.PlacementAdUnit placementAdUnit) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(placementAdUnit, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.PlacementAdUnit.write$Self(placementAdUnit, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

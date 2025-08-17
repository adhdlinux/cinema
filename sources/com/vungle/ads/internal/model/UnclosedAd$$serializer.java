package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

public final class UnclosedAd$$serializer implements GeneratedSerializer<UnclosedAd> {
    public static final UnclosedAd$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        UnclosedAd$$serializer unclosedAd$$serializer = new UnclosedAd$$serializer();
        INSTANCE = unclosedAd$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.UnclosedAd", unclosedAd$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("107", false);
        pluginGeneratedSerialDescriptor.l("101", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UnclosedAd$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{stringSerializer, stringSerializer};
    }

    public UnclosedAd deserialize(Decoder decoder) {
        int i2;
        String str;
        String str2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            str2 = b2.m(descriptor2, 0);
            str = b2.m(descriptor2, 1);
            i2 = 3;
        } else {
            str2 = null;
            String str3 = null;
            int i3 = 0;
            boolean z2 = true;
            while (z2) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    z2 = false;
                } else if (o2 == 0) {
                    str2 = b2.m(descriptor2, 0);
                    i3 |= 1;
                } else if (o2 == 1) {
                    str3 = b2.m(descriptor2, 1);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            str = str3;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new UnclosedAd(i2, str2, str, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, UnclosedAd unclosedAd) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(unclosedAd, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        UnclosedAd.write$Self(unclosedAd, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

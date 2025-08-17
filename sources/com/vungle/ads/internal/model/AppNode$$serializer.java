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

public final class AppNode$$serializer implements GeneratedSerializer<AppNode> {
    public static final AppNode$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AppNode$$serializer appNode$$serializer = new AppNode$$serializer();
        INSTANCE = appNode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AppNode", appNode$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("bundle", false);
        pluginGeneratedSerialDescriptor.l("ver", false);
        pluginGeneratedSerialDescriptor.l("id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AppNode$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer};
    }

    public AppNode deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        int i2;
        Decoder decoder2 = decoder;
        Intrinsics.f(decoder2, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder2.b(descriptor2);
        if (b2.p()) {
            String m2 = b2.m(descriptor2, 0);
            String m3 = b2.m(descriptor2, 1);
            str3 = m2;
            str = b2.m(descriptor2, 2);
            str2 = m3;
            i2 = 7;
        } else {
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i3 = 0;
            boolean z2 = true;
            while (z2) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    z2 = false;
                } else if (o2 == 0) {
                    str4 = b2.m(descriptor2, 0);
                    i3 |= 1;
                } else if (o2 == 1) {
                    str6 = b2.m(descriptor2, 1);
                    i3 |= 2;
                } else if (o2 == 2) {
                    str5 = b2.m(descriptor2, 2);
                    i3 |= 4;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            str3 = str4;
            str = str5;
            str2 = str6;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new AppNode(i2, str3, str2, str, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AppNode appNode) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(appNode, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AppNode.write$Self(appNode, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

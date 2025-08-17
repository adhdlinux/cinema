package com.vungle.ads.internal.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class GenericTpatRequest$$serializer implements GeneratedSerializer<GenericTpatRequest> {
    public static final GenericTpatRequest$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        GenericTpatRequest$$serializer genericTpatRequest$$serializer = new GenericTpatRequest$$serializer();
        INSTANCE = genericTpatRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.network.GenericTpatRequest", genericTpatRequest$$serializer, 4);
        pluginGeneratedSerialDescriptor.l("method", true);
        pluginGeneratedSerialDescriptor.l("headers", true);
        pluginGeneratedSerialDescriptor.l("body", true);
        pluginGeneratedSerialDescriptor.l("attempt", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GenericTpatRequest$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{HttpMethod$$serializer.INSTANCE, BuiltinSerializersKt.s(new LinkedHashMapSerializer(stringSerializer, stringSerializer)), BuiltinSerializersKt.s(stringSerializer), IntSerializer.f41006a};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.network.GenericTpatRequest deserialize(kotlinx.serialization.encoding.Decoder r15) {
        /*
            r14 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r15, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r14.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r15 = r15.b(r0)
            boolean r1 = r15.p()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x0038
            com.vungle.ads.internal.network.HttpMethod$$serializer r1 = com.vungle.ads.internal.network.HttpMethod$$serializer.INSTANCE
            java.lang.Object r1 = r15.y(r0, r5, r1, r6)
            kotlinx.serialization.internal.LinkedHashMapSerializer r5 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.f41077a
            r5.<init>(r7, r7)
            java.lang.Object r4 = r15.n(r0, r4, r5, r6)
            java.lang.Object r3 = r15.n(r0, r3, r7, r6)
            int r2 = r15.i(r0, r2)
            r5 = 15
            r7 = r2
            r9 = r3
            r3 = 15
            goto L_0x0083
        L_0x0038:
            r7 = r6
            r8 = r7
            r9 = r8
            r1 = 0
            r6 = 0
            r10 = 1
        L_0x003e:
            if (r10 == 0) goto L_0x007e
            int r11 = r15.o(r0)
            r12 = -1
            if (r11 == r12) goto L_0x007c
            if (r11 == 0) goto L_0x0073
            if (r11 == r4) goto L_0x0065
            if (r11 == r3) goto L_0x005c
            if (r11 != r2) goto L_0x0056
            int r1 = r15.i(r0, r2)
            r6 = r6 | 8
            goto L_0x003e
        L_0x0056:
            kotlinx.serialization.UnknownFieldException r15 = new kotlinx.serialization.UnknownFieldException
            r15.<init>((int) r11)
            throw r15
        L_0x005c:
            kotlinx.serialization.internal.StringSerializer r11 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r9 = r15.n(r0, r3, r11, r9)
            r6 = r6 | 4
            goto L_0x003e
        L_0x0065:
            kotlinx.serialization.internal.LinkedHashMapSerializer r11 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.f41077a
            r11.<init>(r12, r12)
            java.lang.Object r8 = r15.n(r0, r4, r11, r8)
            r6 = r6 | 2
            goto L_0x003e
        L_0x0073:
            com.vungle.ads.internal.network.HttpMethod$$serializer r11 = com.vungle.ads.internal.network.HttpMethod$$serializer.INSTANCE
            java.lang.Object r7 = r15.y(r0, r5, r11, r7)
            r6 = r6 | 1
            goto L_0x003e
        L_0x007c:
            r10 = 0
            goto L_0x003e
        L_0x007e:
            r3 = r6
            r4 = r8
            r13 = r7
            r7 = r1
            r1 = r13
        L_0x0083:
            r15.c(r0)
            com.vungle.ads.internal.network.GenericTpatRequest r15 = new com.vungle.ads.internal.network.GenericTpatRequest
            r0 = r1
            com.vungle.ads.internal.network.HttpMethod r0 = (com.vungle.ads.internal.network.HttpMethod) r0
            r5 = r4
            java.util.Map r5 = (java.util.Map) r5
            r6 = r9
            java.lang.String r6 = (java.lang.String) r6
            r8 = 0
            r2 = r15
            r4 = r0
            r2.<init>((int) r3, (com.vungle.ads.internal.network.HttpMethod) r4, (java.util.Map) r5, (java.lang.String) r6, (int) r7, (kotlinx.serialization.internal.SerializationConstructorMarker) r8)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.GenericTpatRequest$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.network.GenericTpatRequest");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, GenericTpatRequest genericTpatRequest) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(genericTpatRequest, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        GenericTpatRequest.write$Self(genericTpatRequest, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

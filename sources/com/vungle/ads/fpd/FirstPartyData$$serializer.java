package com.vungle.ads.fpd;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class FirstPartyData$$serializer implements GeneratedSerializer<FirstPartyData> {
    public static final FirstPartyData$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        FirstPartyData$$serializer firstPartyData$$serializer = new FirstPartyData$$serializer();
        INSTANCE = firstPartyData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.FirstPartyData", firstPartyData$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("session_context", true);
        pluginGeneratedSerialDescriptor.l("demographic", true);
        pluginGeneratedSerialDescriptor.l("location", true);
        pluginGeneratedSerialDescriptor.l("revenue", true);
        pluginGeneratedSerialDescriptor.l("custom_data", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FirstPartyData$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(SessionContext$$serializer.INSTANCE), BuiltinSerializersKt.s(Demographic$$serializer.INSTANCE), BuiltinSerializersKt.s(Location$$serializer.INSTANCE), BuiltinSerializersKt.s(Revenue$$serializer.INSTANCE), BuiltinSerializersKt.s(new LinkedHashMapSerializer(stringSerializer, stringSerializer))};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.fpd.FirstPartyData deserialize(kotlinx.serialization.encoding.Decoder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r17.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x0044
            com.vungle.ads.fpd.SessionContext$$serializer r2 = com.vungle.ads.fpd.SessionContext$$serializer.INSTANCE
            java.lang.Object r2 = r0.n(r1, r7, r2, r8)
            com.vungle.ads.fpd.Demographic$$serializer r7 = com.vungle.ads.fpd.Demographic$$serializer.INSTANCE
            java.lang.Object r6 = r0.n(r1, r6, r7, r8)
            com.vungle.ads.fpd.Location$$serializer r7 = com.vungle.ads.fpd.Location$$serializer.INSTANCE
            java.lang.Object r5 = r0.n(r1, r5, r7, r8)
            com.vungle.ads.fpd.Revenue$$serializer r7 = com.vungle.ads.fpd.Revenue$$serializer.INSTANCE
            java.lang.Object r3 = r0.n(r1, r3, r7, r8)
            kotlinx.serialization.internal.LinkedHashMapSerializer r7 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.f41077a
            r7.<init>(r9, r9)
            java.lang.Object r4 = r0.n(r1, r4, r7, r8)
            r7 = 31
            r8 = 31
            goto L_0x00a0
        L_0x0044:
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r2 = 0
            r13 = 1
        L_0x004a:
            if (r13 == 0) goto L_0x0097
            int r14 = r0.o(r1)
            r15 = -1
            if (r14 == r15) goto L_0x0095
            if (r14 == 0) goto L_0x008c
            if (r14 == r6) goto L_0x0083
            if (r14 == r5) goto L_0x007a
            if (r14 == r3) goto L_0x0071
            if (r14 != r4) goto L_0x006b
            kotlinx.serialization.internal.LinkedHashMapSerializer r14 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.f41077a
            r14.<init>(r15, r15)
            java.lang.Object r12 = r0.n(r1, r4, r14, r12)
            r2 = r2 | 16
            goto L_0x004a
        L_0x006b:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x0071:
            com.vungle.ads.fpd.Revenue$$serializer r14 = com.vungle.ads.fpd.Revenue$$serializer.INSTANCE
            java.lang.Object r11 = r0.n(r1, r3, r14, r11)
            r2 = r2 | 8
            goto L_0x004a
        L_0x007a:
            com.vungle.ads.fpd.Location$$serializer r14 = com.vungle.ads.fpd.Location$$serializer.INSTANCE
            java.lang.Object r10 = r0.n(r1, r5, r14, r10)
            r2 = r2 | 4
            goto L_0x004a
        L_0x0083:
            com.vungle.ads.fpd.Demographic$$serializer r14 = com.vungle.ads.fpd.Demographic$$serializer.INSTANCE
            java.lang.Object r9 = r0.n(r1, r6, r14, r9)
            r2 = r2 | 2
            goto L_0x004a
        L_0x008c:
            com.vungle.ads.fpd.SessionContext$$serializer r14 = com.vungle.ads.fpd.SessionContext$$serializer.INSTANCE
            java.lang.Object r8 = r0.n(r1, r7, r14, r8)
            r2 = r2 | 1
            goto L_0x004a
        L_0x0095:
            r13 = 0
            goto L_0x004a
        L_0x0097:
            r6 = r9
            r5 = r10
            r3 = r11
            r4 = r12
            r16 = r8
            r8 = r2
            r2 = r16
        L_0x00a0:
            r0.c(r1)
            com.vungle.ads.fpd.FirstPartyData r0 = new com.vungle.ads.fpd.FirstPartyData
            r9 = r2
            com.vungle.ads.fpd.SessionContext r9 = (com.vungle.ads.fpd.SessionContext) r9
            r10 = r6
            com.vungle.ads.fpd.Demographic r10 = (com.vungle.ads.fpd.Demographic) r10
            r11 = r5
            com.vungle.ads.fpd.Location r11 = (com.vungle.ads.fpd.Location) r11
            r12 = r3
            com.vungle.ads.fpd.Revenue r12 = (com.vungle.ads.fpd.Revenue) r12
            r13 = r4
            java.util.Map r13 = (java.util.Map) r13
            r14 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.fpd.FirstPartyData$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.fpd.FirstPartyData");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, FirstPartyData firstPartyData) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(firstPartyData, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        FirstPartyData.write$Self(firstPartyData, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

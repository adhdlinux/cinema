package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.unity3d.ads.metadata.MediationMetaData;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class BidPayload$$serializer implements GeneratedSerializer<BidPayload> {
    public static final BidPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        BidPayload$$serializer bidPayload$$serializer = new BidPayload$$serializer();
        INSTANCE = bidPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.BidPayload", bidPayload$$serializer, 4);
        pluginGeneratedSerialDescriptor.l(MediationMetaData.KEY_VERSION, true);
        pluginGeneratedSerialDescriptor.l("adunit", true);
        pluginGeneratedSerialDescriptor.l("impression", true);
        pluginGeneratedSerialDescriptor.l("ad", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BidPayload$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(IntSerializer.f41006a), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(new ArrayListSerializer(stringSerializer)), BuiltinSerializersKt.s(AdPayload$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.BidPayload deserialize(kotlinx.serialization.encoding.Decoder r15) {
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
            kotlinx.serialization.internal.IntSerializer r1 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r1 = r15.n(r0, r5, r1, r6)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r4 = r15.n(r0, r4, r5, r6)
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            r7.<init>(r5)
            java.lang.Object r3 = r15.n(r0, r3, r7, r6)
            com.vungle.ads.internal.model.AdPayload$$serializer r5 = com.vungle.ads.internal.model.AdPayload$$serializer.INSTANCE
            java.lang.Object r2 = r15.n(r0, r2, r5, r6)
            r5 = 15
            r6 = 15
            goto L_0x0085
        L_0x0038:
            r7 = r6
            r8 = r7
            r9 = r8
            r1 = 0
            r10 = 1
        L_0x003d:
            if (r10 == 0) goto L_0x007f
            int r11 = r15.o(r0)
            r12 = -1
            if (r11 == r12) goto L_0x007d
            if (r11 == 0) goto L_0x0074
            if (r11 == r4) goto L_0x006b
            if (r11 == r3) goto L_0x005d
            if (r11 != r2) goto L_0x0057
            com.vungle.ads.internal.model.AdPayload$$serializer r11 = com.vungle.ads.internal.model.AdPayload$$serializer.INSTANCE
            java.lang.Object r9 = r15.n(r0, r2, r11, r9)
            r1 = r1 | 8
            goto L_0x003d
        L_0x0057:
            kotlinx.serialization.UnknownFieldException r15 = new kotlinx.serialization.UnknownFieldException
            r15.<init>((int) r11)
            throw r15
        L_0x005d:
            kotlinx.serialization.internal.ArrayListSerializer r11 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.f41077a
            r11.<init>(r12)
            java.lang.Object r8 = r15.n(r0, r3, r11, r8)
            r1 = r1 | 4
            goto L_0x003d
        L_0x006b:
            kotlinx.serialization.internal.StringSerializer r11 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r7 = r15.n(r0, r4, r11, r7)
            r1 = r1 | 2
            goto L_0x003d
        L_0x0074:
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r6 = r15.n(r0, r5, r11, r6)
            r1 = r1 | 1
            goto L_0x003d
        L_0x007d:
            r10 = 0
            goto L_0x003d
        L_0x007f:
            r4 = r7
            r3 = r8
            r2 = r9
            r13 = r6
            r6 = r1
            r1 = r13
        L_0x0085:
            r15.c(r0)
            com.vungle.ads.internal.model.BidPayload r15 = new com.vungle.ads.internal.model.BidPayload
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            r9 = r3
            java.util.List r9 = (java.util.List) r9
            r10 = r2
            com.vungle.ads.internal.model.AdPayload r10 = (com.vungle.ads.internal.model.AdPayload) r10
            r11 = 0
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.BidPayload$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.BidPayload");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, BidPayload bidPayload) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(bidPayload, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        BidPayload.write$Self(bidPayload, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

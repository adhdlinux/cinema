package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class AdPayload$$serializer implements GeneratedSerializer<AdPayload> {
    public static final AdPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$$serializer adPayload$$serializer = new AdPayload$$serializer();
        INSTANCE = adPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload", adPayload$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("ads", true);
        pluginGeneratedSerialDescriptor.l("config", true);
        pluginGeneratedSerialDescriptor.l("mraidFiles", true);
        pluginGeneratedSerialDescriptor.l("incentivizedTextSettings", true);
        pluginGeneratedSerialDescriptor.l("assetsFullyDownloaded", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        KClass b2 = Reflection.b(ConcurrentHashMap.class);
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE)), BuiltinSerializersKt.s(ConfigPayload$$serializer.INSTANCE), new ContextualSerializer(b2, (KSerializer) null, new KSerializer[]{stringSerializer, stringSerializer}), new LinkedHashMapSerializer(stringSerializer, stringSerializer), BooleanSerializer.f40947a};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.AdPayload deserialize(kotlinx.serialization.encoding.Decoder r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r18.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            java.lang.Class<java.util.concurrent.ConcurrentHashMap> r3 = java.util.concurrent.ConcurrentHashMap.class
            r4 = 3
            r5 = 4
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 == 0) goto L_0x0055
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer r10 = com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer.INSTANCE
            r2.<init>(r10)
            java.lang.Object r2 = r0.n(r1, r8, r2, r9)
            com.vungle.ads.internal.model.ConfigPayload$$serializer r10 = com.vungle.ads.internal.model.ConfigPayload$$serializer.INSTANCE
            java.lang.Object r10 = r0.n(r1, r7, r10, r9)
            kotlinx.serialization.ContextualSerializer r11 = new kotlinx.serialization.ContextualSerializer
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.b(r3)
            kotlinx.serialization.KSerializer[] r12 = new kotlinx.serialization.KSerializer[r6]
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.f41077a
            r12[r8] = r13
            r12[r7] = r13
            r11.<init>(r3, r9, r12)
            java.lang.Object r3 = r0.y(r1, r6, r11, r9)
            kotlinx.serialization.internal.LinkedHashMapSerializer r6 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            r6.<init>(r13, r13)
            java.lang.Object r4 = r0.y(r1, r4, r6, r9)
            boolean r5 = r0.C(r1, r5)
            r6 = 31
            r11 = r5
            goto L_0x00d1
        L_0x0055:
            r2 = r9
            r10 = r2
            r11 = r10
            r14 = r11
            r12 = 0
            r13 = 0
            r15 = 1
        L_0x005c:
            if (r15 == 0) goto L_0x00cc
            int r9 = r0.o(r1)
            r8 = -1
            if (r9 == r8) goto L_0x00c8
            if (r9 == 0) goto L_0x00b5
            if (r9 == r7) goto L_0x00a7
            if (r9 == r6) goto L_0x008c
            if (r9 == r4) goto L_0x007c
            if (r9 != r5) goto L_0x0076
            boolean r12 = r0.C(r1, r5)
            r13 = r13 | 16
            goto L_0x0089
        L_0x0076:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x007c:
            kotlinx.serialization.internal.LinkedHashMapSerializer r8 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.f41077a
            r8.<init>(r9, r9)
            java.lang.Object r11 = r0.y(r1, r4, r8, r11)
            r13 = r13 | 8
        L_0x0089:
            r8 = 0
            r9 = 0
            goto L_0x005c
        L_0x008c:
            kotlinx.serialization.ContextualSerializer r8 = new kotlinx.serialization.ContextualSerializer
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.b(r3)
            kotlinx.serialization.KSerializer[] r4 = new kotlinx.serialization.KSerializer[r6]
            kotlinx.serialization.internal.StringSerializer r17 = kotlinx.serialization.internal.StringSerializer.f41077a
            r16 = 0
            r4[r16] = r17
            r4[r7] = r17
            r5 = 0
            r8.<init>(r9, r5, r4)
            java.lang.Object r10 = r0.y(r1, r6, r8, r10)
            r13 = r13 | 4
            goto L_0x00b0
        L_0x00a7:
            r5 = 0
            com.vungle.ads.internal.model.ConfigPayload$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$$serializer.INSTANCE
            java.lang.Object r14 = r0.n(r1, r7, r4, r14)
            r13 = r13 | 2
        L_0x00b0:
            r9 = r5
            r4 = 3
            r5 = 4
            r8 = 0
            goto L_0x005c
        L_0x00b5:
            r5 = 0
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer r8 = com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer.INSTANCE
            r4.<init>(r8)
            r8 = 0
            java.lang.Object r2 = r0.n(r1, r8, r4, r2)
            r13 = r13 | 1
            r9 = r5
            r4 = 3
            r5 = 4
            goto L_0x005c
        L_0x00c8:
            r8 = 0
            r9 = 0
            r15 = 0
            goto L_0x005c
        L_0x00cc:
            r3 = r10
            r4 = r11
            r11 = r12
            r6 = r13
            r10 = r14
        L_0x00d1:
            r0.c(r1)
            com.vungle.ads.internal.model.AdPayload r0 = new com.vungle.ads.internal.model.AdPayload
            r7 = r2
            java.util.List r7 = (java.util.List) r7
            r8 = r10
            com.vungle.ads.internal.model.ConfigPayload r8 = (com.vungle.ads.internal.model.ConfigPayload) r8
            r9 = r3
            java.util.concurrent.ConcurrentHashMap r9 = (java.util.concurrent.ConcurrentHashMap) r9
            r10 = r4
            java.util.Map r10 = (java.util.Map) r10
            r12 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.AdPayload");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload adPayload) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(adPayload, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.write$Self(adPayload, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

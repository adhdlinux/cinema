package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.ConfigPayload;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class ConfigPayload$GDPRSettings$$serializer implements GeneratedSerializer<ConfigPayload.GDPRSettings> {
    public static final ConfigPayload$GDPRSettings$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$GDPRSettings$$serializer configPayload$GDPRSettings$$serializer = new ConfigPayload$GDPRSettings$$serializer();
        INSTANCE = configPayload$GDPRSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.GDPRSettings", configPayload$GDPRSettings$$serializer, 6);
        pluginGeneratedSerialDescriptor.l("is_country_data_protected", true);
        pluginGeneratedSerialDescriptor.l("consent_title", true);
        pluginGeneratedSerialDescriptor.l("consent_message", true);
        pluginGeneratedSerialDescriptor.l("consent_message_version", true);
        pluginGeneratedSerialDescriptor.l("button_accept", true);
        pluginGeneratedSerialDescriptor.l("button_deny", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$GDPRSettings$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(BooleanSerializer.f40947a), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.ConfigPayload.GDPRSettings deserialize(kotlinx.serialization.encoding.Decoder r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r18.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 5
            r4 = 3
            r5 = 4
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 == 0) goto L_0x003e
            kotlinx.serialization.internal.BooleanSerializer r2 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            java.lang.Object r2 = r0.n(r1, r8, r2, r9)
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r7 = r0.n(r1, r7, r8, r9)
            java.lang.Object r6 = r0.n(r1, r6, r8, r9)
            java.lang.Object r4 = r0.n(r1, r4, r8, r9)
            java.lang.Object r5 = r0.n(r1, r5, r8, r9)
            java.lang.Object r3 = r0.n(r1, r3, r8, r9)
            r8 = 63
            r9 = 63
            goto L_0x009c
        L_0x003e:
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r2 = 0
            r15 = 1
        L_0x0045:
            if (r15 == 0) goto L_0x0092
            int r8 = r0.o(r1)
            switch(r8) {
                case -1: goto L_0x008d;
                case 0: goto L_0x0081;
                case 1: goto L_0x0078;
                case 2: goto L_0x006f;
                case 3: goto L_0x0066;
                case 4: goto L_0x005d;
                case 5: goto L_0x0054;
                default: goto L_0x004e;
            }
        L_0x004e:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r8)
            throw r0
        L_0x0054:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r14 = r0.n(r1, r3, r8, r14)
            r2 = r2 | 32
            goto L_0x008b
        L_0x005d:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r13 = r0.n(r1, r5, r8, r13)
            r2 = r2 | 16
            goto L_0x008b
        L_0x0066:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r12 = r0.n(r1, r4, r8, r12)
            r2 = r2 | 8
            goto L_0x008b
        L_0x006f:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r11 = r0.n(r1, r6, r8, r11)
            r2 = r2 | 4
            goto L_0x008b
        L_0x0078:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r10 = r0.n(r1, r7, r8, r10)
            r2 = r2 | 2
            goto L_0x008b
        L_0x0081:
            kotlinx.serialization.internal.BooleanSerializer r8 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r3 = 0
            java.lang.Object r9 = r0.n(r1, r3, r8, r9)
            r2 = r2 | 1
            r3 = 5
        L_0x008b:
            r8 = 0
            goto L_0x0045
        L_0x008d:
            r3 = 0
            r3 = 5
            r8 = 0
            r15 = 0
            goto L_0x0045
        L_0x0092:
            r7 = r10
            r6 = r11
            r4 = r12
            r5 = r13
            r3 = r14
            r17 = r9
            r9 = r2
            r2 = r17
        L_0x009c:
            r0.c(r1)
            com.vungle.ads.internal.model.ConfigPayload$GDPRSettings r0 = new com.vungle.ads.internal.model.ConfigPayload$GDPRSettings
            r10 = r2
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            r12 = r6
            java.lang.String r12 = (java.lang.String) r12
            r13 = r4
            java.lang.String r13 = (java.lang.String) r13
            r14 = r5
            java.lang.String r14 = (java.lang.String) r14
            r15 = r3
            java.lang.String r15 = (java.lang.String) r15
            r16 = 0
            r8 = r0
            r8.<init>((int) r9, (java.lang.Boolean) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (kotlinx.serialization.internal.SerializationConstructorMarker) r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload$GDPRSettings$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.ConfigPayload$GDPRSettings");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.GDPRSettings gDPRSettings) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(gDPRSettings, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.GDPRSettings.write$Self(gDPRSettings, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

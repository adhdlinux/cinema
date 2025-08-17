package com.vungle.ads.fpd;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class SessionContext$$serializer implements GeneratedSerializer<SessionContext> {
    public static final SessionContext$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        SessionContext$$serializer sessionContext$$serializer = new SessionContext$$serializer();
        INSTANCE = sessionContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.SessionContext", sessionContext$$serializer, 12);
        pluginGeneratedSerialDescriptor.l("level_percentile", true);
        pluginGeneratedSerialDescriptor.l("page", true);
        pluginGeneratedSerialDescriptor.l("time_spent", true);
        pluginGeneratedSerialDescriptor.l("signup_date", true);
        pluginGeneratedSerialDescriptor.l("user_score_percentile", true);
        pluginGeneratedSerialDescriptor.l("user_id", true);
        pluginGeneratedSerialDescriptor.l("friends", true);
        pluginGeneratedSerialDescriptor.l("user_level_percentile", true);
        pluginGeneratedSerialDescriptor.l("health_percentile", true);
        pluginGeneratedSerialDescriptor.l("session_start_time", true);
        pluginGeneratedSerialDescriptor.l("session_duration", true);
        pluginGeneratedSerialDescriptor.l("in_game_purchases_usd", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionContext$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        FloatSerializer floatSerializer = FloatSerializer.f40997a;
        StringSerializer stringSerializer = StringSerializer.f41077a;
        IntSerializer intSerializer = IntSerializer.f41006a;
        return new KSerializer[]{BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(new ArrayListSerializer(stringSerializer)), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(floatSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.fpd.SessionContext deserialize(kotlinx.serialization.encoding.Decoder r28) {
        /*
            r27 = this;
            r0 = r28
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r27.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r6 = 7
            r7 = 6
            r8 = 5
            r9 = 3
            r10 = 8
            r11 = 4
            r12 = 2
            r13 = 1
            r14 = 0
            r15 = 0
            if (r2 == 0) goto L_0x006a
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            java.lang.Object r14 = r0.n(r1, r14, r2, r15)
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r13 = r0.n(r1, r13, r3, r15)
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r12 = r0.n(r1, r12, r4, r15)
            java.lang.Object r9 = r0.n(r1, r9, r4, r15)
            java.lang.Object r11 = r0.n(r1, r11, r2, r15)
            java.lang.Object r8 = r0.n(r1, r8, r3, r15)
            kotlinx.serialization.internal.ArrayListSerializer r5 = new kotlinx.serialization.internal.ArrayListSerializer
            r5.<init>(r3)
            java.lang.Object r3 = r0.n(r1, r7, r5, r15)
            java.lang.Object r5 = r0.n(r1, r6, r2, r15)
            java.lang.Object r6 = r0.n(r1, r10, r2, r15)
            r7 = 9
            java.lang.Object r7 = r0.n(r1, r7, r4, r15)
            r10 = 10
            java.lang.Object r4 = r0.n(r1, r10, r4, r15)
            r10 = 11
            java.lang.Object r2 = r0.n(r1, r10, r2, r15)
            r10 = 4095(0xfff, float:5.738E-42)
            r26 = r13
            r13 = r11
            r11 = 4095(0xfff, float:5.738E-42)
            goto L_0x0156
        L_0x006a:
            r2 = 11
            r4 = r15
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r3 = 0
            r25 = 1
        L_0x007a:
            if (r25 == 0) goto L_0x014a
            int r2 = r0.o(r1)
            switch(r2) {
                case -1: goto L_0x013f;
                case 0: goto L_0x0129;
                case 1: goto L_0x011a;
                case 2: goto L_0x010d;
                case 3: goto L_0x0100;
                case 4: goto L_0x00f3;
                case 5: goto L_0x00e6;
                case 6: goto L_0x00d4;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00b7;
                case 9: goto L_0x00a7;
                case 10: goto L_0x0097;
                case 11: goto L_0x0089;
                default: goto L_0x0083;
            }
        L_0x0083:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r2)
            throw r0
        L_0x0089:
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r26 = r15
            r15 = 11
            java.lang.Object r10 = r0.n(r1, r15, r2, r10)
            r3 = r3 | 2048(0x800, float:2.87E-42)
            goto L_0x0126
        L_0x0097:
            r26 = r15
            r15 = 11
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r15 = 10
            java.lang.Object r6 = r0.n(r1, r15, r2, r6)
            r3 = r3 | 1024(0x400, float:1.435E-42)
            goto L_0x0126
        L_0x00a7:
            r26 = r15
            r15 = 10
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r15 = 9
            java.lang.Object r7 = r0.n(r1, r15, r2, r7)
            r3 = r3 | 512(0x200, float:7.175E-43)
            goto L_0x0126
        L_0x00b7:
            r26 = r15
            r15 = 9
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r15 = 8
            java.lang.Object r8 = r0.n(r1, r15, r2, r8)
            r3 = r3 | 256(0x100, float:3.59E-43)
            goto L_0x0126
        L_0x00c6:
            r26 = r15
            r15 = 8
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r15 = 7
            java.lang.Object r11 = r0.n(r1, r15, r2, r11)
            r3 = r3 | 128(0x80, float:1.794E-43)
            goto L_0x0126
        L_0x00d4:
            r26 = r15
            r15 = 7
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.f41077a
            r2.<init>(r15)
            r15 = 6
            java.lang.Object r9 = r0.n(r1, r15, r2, r9)
            r3 = r3 | 64
            goto L_0x0126
        L_0x00e6:
            r26 = r15
            r15 = 6
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r15 = 5
            java.lang.Object r12 = r0.n(r1, r15, r2, r12)
            r3 = r3 | 32
            goto L_0x0126
        L_0x00f3:
            r26 = r15
            r15 = 5
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r15 = 4
            java.lang.Object r13 = r0.n(r1, r15, r2, r13)
            r3 = r3 | 16
            goto L_0x0126
        L_0x0100:
            r26 = r15
            r15 = 4
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r15 = 3
            java.lang.Object r14 = r0.n(r1, r15, r2, r14)
            r3 = r3 | 8
            goto L_0x0126
        L_0x010d:
            r26 = r15
            r15 = 3
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r15 = 2
            java.lang.Object r5 = r0.n(r1, r15, r2, r5)
            r3 = r3 | 4
            goto L_0x0126
        L_0x011a:
            r26 = r15
            r15 = 2
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r15 = 1
            java.lang.Object r4 = r0.n(r1, r15, r2, r4)
            r3 = r3 | 2
        L_0x0126:
            r15 = r26
            goto L_0x013b
        L_0x0129:
            r26 = r15
            r15 = 1
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r15 = r26
            r26 = r4
            r4 = 0
            java.lang.Object r15 = r0.n(r1, r4, r2, r15)
            r3 = r3 | 1
            r4 = r26
        L_0x013b:
            r2 = 11
            goto L_0x007a
        L_0x013f:
            r26 = r4
            r4 = 0
            r4 = r26
            r2 = 11
            r25 = 0
            goto L_0x007a
        L_0x014a:
            r26 = r4
            r4 = r6
            r6 = r8
            r2 = r10
            r8 = r12
            r12 = r5
            r5 = r11
            r11 = r3
            r3 = r9
            r9 = r14
            r14 = r15
        L_0x0156:
            r0.c(r1)
            com.vungle.ads.fpd.SessionContext r0 = new com.vungle.ads.fpd.SessionContext
            r1 = r14
            java.lang.Float r1 = (java.lang.Float) r1
            r14 = r26
            java.lang.String r14 = (java.lang.String) r14
            r15 = r12
            java.lang.Integer r15 = (java.lang.Integer) r15
            java.lang.Integer r9 = (java.lang.Integer) r9
            r16 = r13
            java.lang.Float r16 = (java.lang.Float) r16
            r17 = r8
            java.lang.String r17 = (java.lang.String) r17
            r18 = r3
            java.util.List r18 = (java.util.List) r18
            r19 = r5
            java.lang.Float r19 = (java.lang.Float) r19
            r20 = r6
            java.lang.Float r20 = (java.lang.Float) r20
            r21 = r7
            java.lang.Integer r21 = (java.lang.Integer) r21
            r22 = r4
            java.lang.Integer r22 = (java.lang.Integer) r22
            r23 = r2
            java.lang.Float r23 = (java.lang.Float) r23
            r24 = 0
            r10 = r0
            r12 = r1
            r13 = r14
            r14 = r15
            r15 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.fpd.SessionContext$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.fpd.SessionContext");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, SessionContext sessionContext) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(sessionContext, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        SessionContext.write$Self(sessionContext, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

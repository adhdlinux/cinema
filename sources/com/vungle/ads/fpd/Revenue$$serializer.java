package com.vungle.ads.fpd;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class Revenue$$serializer implements GeneratedSerializer<Revenue> {
    public static final Revenue$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        Revenue$$serializer revenue$$serializer = new Revenue$$serializer();
        INSTANCE = revenue$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Revenue", revenue$$serializer, 17);
        pluginGeneratedSerialDescriptor.l("total_earnings_usd", true);
        pluginGeneratedSerialDescriptor.l("earnings_by_placement_usd", true);
        pluginGeneratedSerialDescriptor.l("top_n_adomain", true);
        pluginGeneratedSerialDescriptor.l("is_user_a_purchaser", true);
        pluginGeneratedSerialDescriptor.l("is_user_a_subscriber", true);
        pluginGeneratedSerialDescriptor.l("last_7_days_total_spend_usd", true);
        pluginGeneratedSerialDescriptor.l("last_7_days_median_spend_usd", true);
        pluginGeneratedSerialDescriptor.l("last_7_days_mean_spend_usd", true);
        pluginGeneratedSerialDescriptor.l("last_30_days_total_spend_usd", true);
        pluginGeneratedSerialDescriptor.l("last_30_days_median_spend_usd", true);
        pluginGeneratedSerialDescriptor.l("last_30_days_mean_spend_usd", true);
        pluginGeneratedSerialDescriptor.l("last_7_days_user_pltv_usd", true);
        pluginGeneratedSerialDescriptor.l("last_7_days_user_ltv_usd", true);
        pluginGeneratedSerialDescriptor.l("last_30_days_user_pltv_usd", true);
        pluginGeneratedSerialDescriptor.l("last_30_days_user_ltv_usd", true);
        pluginGeneratedSerialDescriptor.l("last_7_days_placement_fill_rate", true);
        pluginGeneratedSerialDescriptor.l("last_30_days_placement_fill_rate", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Revenue$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        FloatSerializer floatSerializer = FloatSerializer.f40997a;
        BooleanSerializer booleanSerializer = BooleanSerializer.f40947a;
        return new KSerializer[]{BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(new ArrayListSerializer(StringSerializer.f41077a)), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer), BuiltinSerializersKt.s(floatSerializer)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x023b, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x023d, code lost:
        r8 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x029c, code lost:
        r35 = r2;
        r2 = r22;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.fpd.Revenue deserialize(kotlinx.serialization.encoding.Decoder r42) {
        /*
            r41 = this;
            r0 = r42
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r41.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r9 = 9
            r10 = 7
            r11 = 6
            r12 = 5
            r13 = 3
            r15 = 8
            r14 = 4
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x0098
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.f40997a
            java.lang.Object r5 = r0.n(r1, r5, r2, r6)
            java.lang.Object r4 = r0.n(r1, r4, r2, r6)
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            r7.<init>(r8)
            java.lang.Object r3 = r0.n(r1, r3, r7, r6)
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            java.lang.Object r8 = r0.n(r1, r13, r7, r6)
            java.lang.Object r7 = r0.n(r1, r14, r7, r6)
            java.lang.Object r12 = r0.n(r1, r12, r2, r6)
            java.lang.Object r11 = r0.n(r1, r11, r2, r6)
            java.lang.Object r10 = r0.n(r1, r10, r2, r6)
            java.lang.Object r13 = r0.n(r1, r15, r2, r6)
            java.lang.Object r9 = r0.n(r1, r9, r2, r6)
            r14 = 10
            java.lang.Object r14 = r0.n(r1, r14, r2, r6)
            r15 = 11
            java.lang.Object r15 = r0.n(r1, r15, r2, r6)
            r20 = r3
            r3 = 12
            java.lang.Object r3 = r0.n(r1, r3, r2, r6)
            r19 = r3
            r3 = 13
            java.lang.Object r3 = r0.n(r1, r3, r2, r6)
            r18 = r3
            r3 = 14
            java.lang.Object r3 = r0.n(r1, r3, r2, r6)
            r17 = r3
            r3 = 15
            java.lang.Object r3 = r0.n(r1, r3, r2, r6)
            r16 = r5
            r5 = 16
            java.lang.Object r2 = r0.n(r1, r5, r2, r6)
            r5 = 131071(0x1ffff, float:1.8367E-40)
            r6 = r8
            r5 = r16
            r21 = 131071(0x1ffff, float:1.8367E-40)
            r8 = r4
            r4 = r3
            r3 = r20
            goto L_0x02ce
        L_0x0098:
            r2 = 0
            r5 = 16
            r2 = r6
            r3 = r2
            r4 = r3
            r7 = r4
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r31 = r15
            r32 = r31
            r33 = r32
            r34 = r33
            r35 = r34
            r6 = 0
            r36 = 1
        L_0x00b4:
            if (r36 == 0) goto L_0x02a2
            int r5 = r0.o(r1)
            switch(r5) {
                case -1: goto L_0x0283;
                case 0: goto L_0x0262;
                case 1: goto L_0x0240;
                case 2: goto L_0x0220;
                case 3: goto L_0x0209;
                case 4: goto L_0x01f2;
                case 5: goto L_0x01db;
                case 6: goto L_0x01c3;
                case 7: goto L_0x01aa;
                case 8: goto L_0x0190;
                case 9: goto L_0x0176;
                case 10: goto L_0x015c;
                case 11: goto L_0x0142;
                case 12: goto L_0x0122;
                case 13: goto L_0x0104;
                case 14: goto L_0x00e8;
                case 15: goto L_0x00d2;
                case 16: goto L_0x00c3;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r5)
            throw r0
        L_0x00c3:
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r38 = r8
            r8 = 16
            java.lang.Object r7 = r0.n(r1, r8, r5, r7)
            r5 = 65536(0x10000, float:9.18355E-41)
            r6 = r6 | r5
            goto L_0x023d
        L_0x00d2:
            r38 = r8
            r8 = 16
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r16 = r7
            r8 = r34
            r7 = 15
            java.lang.Object r34 = r0.n(r1, r7, r5, r8)
            r5 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 | r5
            goto L_0x023b
        L_0x00e8:
            r16 = r7
            r38 = r8
            r8 = r34
            r7 = 15
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r17 = r8
            r7 = r33
            r8 = 14
            java.lang.Object r33 = r0.n(r1, r8, r5, r7)
            r6 = r6 | 16384(0x4000, float:2.2959E-41)
            r7 = r16
            r34 = r17
            goto L_0x023d
        L_0x0104:
            r16 = r7
            r38 = r8
            r7 = r33
            r17 = r34
            r8 = 14
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r18 = r7
            r8 = r32
            r7 = 13
            java.lang.Object r32 = r0.n(r1, r7, r5, r8)
            r6 = r6 | 8192(0x2000, float:1.14794E-41)
            r7 = r16
            r33 = r18
            goto L_0x023d
        L_0x0122:
            r16 = r7
            r38 = r8
            r8 = r32
            r18 = r33
            r17 = r34
            r7 = 13
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r19 = r8
            r7 = r31
            r8 = 12
            java.lang.Object r31 = r0.n(r1, r8, r5, r7)
            r6 = r6 | 4096(0x1000, float:5.74E-42)
            r7 = r16
            r32 = r19
            goto L_0x023d
        L_0x0142:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 12
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 11
            java.lang.Object r9 = r0.n(r1, r8, r5, r9)
            r6 = r6 | 2048(0x800, float:2.87E-42)
            goto L_0x023b
        L_0x015c:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 11
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 10
            java.lang.Object r15 = r0.n(r1, r8, r5, r15)
            r6 = r6 | 1024(0x400, float:1.435E-42)
            goto L_0x023b
        L_0x0176:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 10
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 9
            java.lang.Object r10 = r0.n(r1, r8, r5, r10)
            r6 = r6 | 512(0x200, float:7.175E-43)
            goto L_0x023b
        L_0x0190:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 9
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 8
            java.lang.Object r11 = r0.n(r1, r8, r5, r11)
            r6 = r6 | 256(0x100, float:3.59E-43)
            goto L_0x023b
        L_0x01aa:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 8
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 7
            java.lang.Object r12 = r0.n(r1, r8, r5, r12)
            r6 = r6 | 128(0x80, float:1.794E-43)
            goto L_0x023b
        L_0x01c3:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 7
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 6
            java.lang.Object r14 = r0.n(r1, r8, r5, r14)
            r6 = r6 | 64
            goto L_0x023b
        L_0x01db:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 6
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r8 = 5
            java.lang.Object r13 = r0.n(r1, r8, r5, r13)
            r6 = r6 | 32
            goto L_0x023b
        L_0x01f2:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 5
            kotlinx.serialization.internal.BooleanSerializer r5 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r8 = 4
            java.lang.Object r3 = r0.n(r1, r8, r5, r3)
            r6 = r6 | 16
            goto L_0x023b
        L_0x0209:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 4
            kotlinx.serialization.internal.BooleanSerializer r5 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r8 = 3
            java.lang.Object r4 = r0.n(r1, r8, r5, r4)
            r6 = r6 | 8
            goto L_0x023b
        L_0x0220:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 3
            kotlinx.serialization.internal.ArrayListSerializer r5 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            r5.<init>(r8)
            r8 = 2
            java.lang.Object r2 = r0.n(r1, r8, r5, r2)
            r6 = r6 | 4
        L_0x023b:
            r7 = r16
        L_0x023d:
            r8 = r38
            goto L_0x025e
        L_0x0240:
            r16 = r7
            r38 = r8
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r8 = 2
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r22 = r2
            r8 = r38
            r2 = 1
            java.lang.Object r8 = r0.n(r1, r2, r5, r8)
            r6 = r6 | 2
            r7 = r16
            r2 = r22
        L_0x025e:
            r5 = 16
            goto L_0x00b4
        L_0x0262:
            r22 = r2
            r16 = r7
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r2 = 1
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.f40997a
            r2 = r35
            r35 = r3
            r3 = 0
            java.lang.Object r2 = r0.n(r1, r3, r5, r2)
            r6 = r6 | 1
            r7 = r16
            r3 = r35
            r5 = 16
            goto L_0x029c
        L_0x0283:
            r22 = r2
            r16 = r7
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r2 = r35
            r35 = r3
            r3 = 0
            r7 = r16
            r3 = r35
            r5 = 16
            r36 = 0
        L_0x029c:
            r35 = r2
            r2 = r22
            goto L_0x00b4
        L_0x02a2:
            r22 = r2
            r16 = r7
            r7 = r31
            r19 = r32
            r18 = r33
            r17 = r34
            r2 = r35
            r35 = r3
            r5 = r2
            r21 = r6
            r2 = r16
            r3 = r22
            r6 = r4
            r4 = r17
            r17 = r18
            r18 = r19
            r19 = r7
            r7 = r35
            r40 = r15
            r15 = r9
            r9 = r10
            r10 = r12
            r12 = r13
            r13 = r11
            r11 = r14
            r14 = r40
        L_0x02ce:
            r0.c(r1)
            com.vungle.ads.fpd.Revenue r0 = new com.vungle.ads.fpd.Revenue
            r20 = r0
            r22 = r5
            java.lang.Float r22 = (java.lang.Float) r22
            r23 = r8
            java.lang.Float r23 = (java.lang.Float) r23
            r24 = r3
            java.util.List r24 = (java.util.List) r24
            r25 = r6
            java.lang.Boolean r25 = (java.lang.Boolean) r25
            r26 = r7
            java.lang.Boolean r26 = (java.lang.Boolean) r26
            r27 = r12
            java.lang.Float r27 = (java.lang.Float) r27
            r28 = r11
            java.lang.Float r28 = (java.lang.Float) r28
            r29 = r10
            java.lang.Float r29 = (java.lang.Float) r29
            r30 = r13
            java.lang.Float r30 = (java.lang.Float) r30
            r31 = r9
            java.lang.Float r31 = (java.lang.Float) r31
            r32 = r14
            java.lang.Float r32 = (java.lang.Float) r32
            r33 = r15
            java.lang.Float r33 = (java.lang.Float) r33
            r34 = r19
            java.lang.Float r34 = (java.lang.Float) r34
            r35 = r18
            java.lang.Float r35 = (java.lang.Float) r35
            r36 = r17
            java.lang.Float r36 = (java.lang.Float) r36
            r37 = r4
            java.lang.Float r37 = (java.lang.Float) r37
            r38 = r2
            java.lang.Float r38 = (java.lang.Float) r38
            r39 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.fpd.Revenue$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.fpd.Revenue");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Revenue revenue) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(revenue, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        Revenue.write$Self(revenue, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

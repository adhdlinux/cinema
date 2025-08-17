package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class ConfigPayload$$serializer implements GeneratedSerializer<ConfigPayload> {
    public static final ConfigPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$$serializer configPayload$$serializer = new ConfigPayload$$serializer();
        INSTANCE = configPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload", configPayload$$serializer, 19);
        pluginGeneratedSerialDescriptor.l("reuse_assets", true);
        pluginGeneratedSerialDescriptor.l("config", true);
        pluginGeneratedSerialDescriptor.l("endpoints", true);
        pluginGeneratedSerialDescriptor.l("log_metrics", true);
        pluginGeneratedSerialDescriptor.l("placements", true);
        pluginGeneratedSerialDescriptor.l("user", true);
        pluginGeneratedSerialDescriptor.l("viewability", true);
        pluginGeneratedSerialDescriptor.l("config_extension", true);
        pluginGeneratedSerialDescriptor.l("disable_ad_id", true);
        pluginGeneratedSerialDescriptor.l("ri_enabled", true);
        pluginGeneratedSerialDescriptor.l("session_timeout", true);
        pluginGeneratedSerialDescriptor.l("wait_for_connectivity_for_tpat", true);
        pluginGeneratedSerialDescriptor.l("sdk_session_timeout", true);
        pluginGeneratedSerialDescriptor.l("cacheable_assets_required", true);
        pluginGeneratedSerialDescriptor.l("signals_disabled", true);
        pluginGeneratedSerialDescriptor.l("fpd_enabled", true);
        pluginGeneratedSerialDescriptor.l("rta_debugging", true);
        pluginGeneratedSerialDescriptor.l("config_last_validated_ts", true);
        pluginGeneratedSerialDescriptor.l("auto_redirect", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.f40947a;
        IntSerializer intSerializer = IntSerializer.f41006a;
        return new KSerializer[]{BuiltinSerializersKt.s(ConfigPayload$CleverCache$$serializer.INSTANCE), BuiltinSerializersKt.s(ConfigPayload$ConfigSettings$$serializer.INSTANCE), BuiltinSerializersKt.s(ConfigPayload$Endpoints$$serializer.INSTANCE), BuiltinSerializersKt.s(ConfigPayload$LogMetricsSettings$$serializer.INSTANCE), BuiltinSerializersKt.s(new ArrayListSerializer(Placement$$serializer.INSTANCE)), BuiltinSerializersKt.s(ConfigPayload$UserPrivacy$$serializer.INSTANCE), BuiltinSerializersKt.s(ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE), BuiltinSerializersKt.s(StringSerializer.f41077a), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(LongSerializer.f41017a), BuiltinSerializersKt.s(ConfigPayload$AutoRedirect$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x02d6, code lost:
        r9 = r16;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x02d8, code lost:
        r2 = r42;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x031e, code lost:
        r3 = r42;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00df, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.ConfigPayload deserialize(kotlinx.serialization.encoding.Decoder r47) {
        /*
            r46 = this;
            r0 = r47
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r46.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r10 = 10
            r11 = 9
            r12 = 7
            r13 = 6
            r14 = 5
            r15 = 3
            r4 = 8
            r3 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x00bf
            com.vungle.ads.internal.model.ConfigPayload$CleverCache$$serializer r2 = com.vungle.ads.internal.model.ConfigPayload$CleverCache$$serializer.INSTANCE
            java.lang.Object r2 = r0.n(r1, r7, r2, r8)
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer.INSTANCE
            java.lang.Object r6 = r0.n(r1, r6, r7, r8)
            com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer.INSTANCE
            java.lang.Object r5 = r0.n(r1, r5, r7, r8)
            com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer.INSTANCE
            java.lang.Object r7 = r0.n(r1, r15, r7, r8)
            kotlinx.serialization.internal.ArrayListSerializer r15 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.Placement$$serializer r9 = com.vungle.ads.internal.model.Placement$$serializer.INSTANCE
            r15.<init>(r9)
            java.lang.Object r3 = r0.n(r1, r3, r15, r8)
            com.vungle.ads.internal.model.ConfigPayload$UserPrivacy$$serializer r9 = com.vungle.ads.internal.model.ConfigPayload$UserPrivacy$$serializer.INSTANCE
            java.lang.Object r9 = r0.n(r1, r14, r9, r8)
            com.vungle.ads.internal.model.ConfigPayload$ViewAbilitySettings$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE
            java.lang.Object r13 = r0.n(r1, r13, r14, r8)
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r12 = r0.n(r1, r12, r14, r8)
            kotlinx.serialization.internal.BooleanSerializer r14 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            java.lang.Object r4 = r0.n(r1, r4, r14, r8)
            java.lang.Object r11 = r0.n(r1, r11, r14, r8)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r10 = r0.n(r1, r10, r15, r8)
            r23 = r2
            r2 = 11
            java.lang.Object r2 = r0.n(r1, r2, r14, r8)
            r22 = r2
            r2 = 12
            java.lang.Object r2 = r0.n(r1, r2, r15, r8)
            r15 = 13
            java.lang.Object r15 = r0.n(r1, r15, r14, r8)
            r20 = r2
            r2 = 14
            java.lang.Object r2 = r0.n(r1, r2, r14, r8)
            r19 = r2
            r2 = 15
            java.lang.Object r2 = r0.n(r1, r2, r14, r8)
            r18 = r2
            r2 = 16
            java.lang.Object r2 = r0.n(r1, r2, r14, r8)
            kotlinx.serialization.internal.LongSerializer r14 = kotlinx.serialization.internal.LongSerializer.f41017a
            r17 = r2
            r2 = 17
            java.lang.Object r2 = r0.n(r1, r2, r14, r8)
            com.vungle.ads.internal.model.ConfigPayload$AutoRedirect$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$AutoRedirect$$serializer.INSTANCE
            r16 = r7
            r7 = 18
            java.lang.Object r7 = r0.n(r1, r7, r14, r8)
            r8 = 524287(0x7ffff, float:7.34683E-40)
            r21 = r15
            r24 = 524287(0x7ffff, float:7.34683E-40)
            r15 = r3
            r3 = r2
            r2 = r23
            r45 = r16
            r16 = r7
            r7 = r45
            goto L_0x0373
        L_0x00bf:
            r2 = 0
            r7 = 18
            r2 = r8
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r33 = r15
            r34 = r33
            r35 = r34
            r36 = r35
            r37 = r36
            r38 = r37
            r39 = r38
            r8 = 0
            r40 = 1
        L_0x00df:
            if (r40 == 0) goto L_0x0345
            int r7 = r0.o(r1)
            switch(r7) {
                case -1: goto L_0x0324;
                case 0: goto L_0x02fc;
                case 1: goto L_0x02db;
                case 2: goto L_0x02bc;
                case 3: goto L_0x02a1;
                case 4: goto L_0x0281;
                case 5: goto L_0x0266;
                case 6: goto L_0x024a;
                case 7: goto L_0x022d;
                case 8: goto L_0x020f;
                case 9: goto L_0x01f1;
                case 10: goto L_0x01d3;
                case 11: goto L_0x01b5;
                case 12: goto L_0x0191;
                case 13: goto L_0x016f;
                case 14: goto L_0x014f;
                case 15: goto L_0x012f;
                case 16: goto L_0x0112;
                case 17: goto L_0x00fd;
                case 18: goto L_0x00ee;
                default: goto L_0x00e8;
            }
        L_0x00e8:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r7)
            throw r0
        L_0x00ee:
            com.vungle.ads.internal.model.ConfigPayload$AutoRedirect$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$AutoRedirect$$serializer.INSTANCE
            r42 = r2
            r2 = 18
            java.lang.Object r9 = r0.n(r1, r2, r7, r9)
            r7 = 262144(0x40000, float:3.67342E-40)
            r8 = r8 | r7
            goto L_0x02d8
        L_0x00fd:
            r42 = r2
            r2 = 18
            kotlinx.serialization.internal.LongSerializer r7 = kotlinx.serialization.internal.LongSerializer.f41017a
            r16 = r9
            r2 = r38
            r9 = 17
            java.lang.Object r38 = r0.n(r1, r9, r7, r2)
            r2 = 131072(0x20000, float:1.83671E-40)
            r8 = r8 | r2
            goto L_0x02d6
        L_0x0112:
            r42 = r2
            r16 = r9
            r2 = r38
            r9 = 17
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r17 = r2
            r9 = r37
            r2 = 16
            java.lang.Object r37 = r0.n(r1, r2, r7, r9)
            r7 = 65536(0x10000, float:9.18355E-41)
            r8 = r8 | r7
            r9 = r16
            r38 = r17
            goto L_0x02d8
        L_0x012f:
            r42 = r2
            r16 = r9
            r9 = r37
            r17 = r38
            r2 = 16
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r18 = r9
            r2 = r36
            r9 = 15
            java.lang.Object r36 = r0.n(r1, r9, r7, r2)
            r2 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 | r2
            r9 = r16
            r37 = r18
            goto L_0x02d8
        L_0x014f:
            r42 = r2
            r16 = r9
            r2 = r36
            r18 = r37
            r17 = r38
            r9 = 15
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r19 = r2
            r9 = r35
            r2 = 14
            java.lang.Object r35 = r0.n(r1, r2, r7, r9)
            r8 = r8 | 16384(0x4000, float:2.2959E-41)
            r9 = r16
            r36 = r19
            goto L_0x02d8
        L_0x016f:
            r42 = r2
            r16 = r9
            r9 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 14
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r20 = r9
            r2 = r34
            r9 = 13
            java.lang.Object r34 = r0.n(r1, r9, r7, r2)
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
            r9 = r16
            r35 = r20
            goto L_0x02d8
        L_0x0191:
            r42 = r2
            r16 = r9
            r2 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r9 = 13
            kotlinx.serialization.internal.IntSerializer r7 = kotlinx.serialization.internal.IntSerializer.f41006a
            r21 = r2
            r9 = r33
            r2 = 12
            java.lang.Object r33 = r0.n(r1, r2, r7, r9)
            r8 = r8 | 4096(0x1000, float:5.74E-42)
            r9 = r16
            r34 = r21
            goto L_0x02d8
        L_0x01b5:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 12
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r2 = 11
            java.lang.Object r10 = r0.n(r1, r2, r7, r10)
            r8 = r8 | 2048(0x800, float:2.87E-42)
            goto L_0x02d6
        L_0x01d3:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 11
            kotlinx.serialization.internal.IntSerializer r7 = kotlinx.serialization.internal.IntSerializer.f41006a
            r2 = 10
            java.lang.Object r11 = r0.n(r1, r2, r7, r11)
            r8 = r8 | 1024(0x400, float:1.435E-42)
            goto L_0x02d6
        L_0x01f1:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 10
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r2 = 9
            java.lang.Object r4 = r0.n(r1, r2, r7, r4)
            r8 = r8 | 512(0x200, float:7.175E-43)
            goto L_0x02d6
        L_0x020f:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 9
            kotlinx.serialization.internal.BooleanSerializer r7 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r2 = 8
            java.lang.Object r12 = r0.n(r1, r2, r7, r12)
            r8 = r8 | 256(0x100, float:3.59E-43)
            goto L_0x02d6
        L_0x022d:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 8
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.f41077a
            r2 = 7
            java.lang.Object r13 = r0.n(r1, r2, r7, r13)
            r8 = r8 | 128(0x80, float:1.794E-43)
            goto L_0x02d6
        L_0x024a:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 7
            com.vungle.ads.internal.model.ConfigPayload$ViewAbilitySettings$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE
            r2 = 6
            java.lang.Object r14 = r0.n(r1, r2, r7, r14)
            r8 = r8 | 64
            goto L_0x02d6
        L_0x0266:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 6
            com.vungle.ads.internal.model.ConfigPayload$UserPrivacy$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$UserPrivacy$$serializer.INSTANCE
            r2 = 5
            java.lang.Object r3 = r0.n(r1, r2, r7, r3)
            r8 = r8 | 32
            goto L_0x02d6
        L_0x0281:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 5
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.Placement$$serializer r2 = com.vungle.ads.internal.model.Placement$$serializer.INSTANCE
            r7.<init>(r2)
            r2 = 4
            java.lang.Object r15 = r0.n(r1, r2, r7, r15)
            r8 = r8 | 16
            goto L_0x02d6
        L_0x02a1:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 4
            com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer.INSTANCE
            r2 = 3
            java.lang.Object r5 = r0.n(r1, r2, r7, r5)
            r8 = r8 | 8
            goto L_0x02d6
        L_0x02bc:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 3
            com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer.INSTANCE
            r2 = 2
            java.lang.Object r6 = r0.n(r1, r2, r7, r6)
            r8 = r8 | 4
        L_0x02d6:
            r9 = r16
        L_0x02d8:
            r2 = r42
            goto L_0x0320
        L_0x02db:
            r42 = r2
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r2 = 2
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer.INSTANCE
            r2 = r42
            r42 = r3
            r3 = 1
            java.lang.Object r2 = r0.n(r1, r3, r7, r2)
            r8 = r8 | 2
            r9 = r16
            goto L_0x031e
        L_0x02fc:
            r42 = r3
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r3 = 1
            com.vungle.ads.internal.model.ConfigPayload$CleverCache$$serializer r7 = com.vungle.ads.internal.model.ConfigPayload$CleverCache$$serializer.INSTANCE
            r23 = r2
            r3 = r39
            r2 = 0
            java.lang.Object r39 = r0.n(r1, r2, r7, r3)
            r8 = r8 | 1
            r9 = r16
            r2 = r23
        L_0x031e:
            r3 = r42
        L_0x0320:
            r7 = 18
            goto L_0x00df
        L_0x0324:
            r23 = r2
            r42 = r3
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r3 = r39
            r2 = 0
            r9 = r16
            r2 = r23
            r3 = r42
            r7 = 18
            r40 = 0
            goto L_0x00df
        L_0x0345:
            r23 = r2
            r42 = r3
            r16 = r9
            r9 = r33
            r21 = r34
            r20 = r35
            r19 = r36
            r18 = r37
            r17 = r38
            r3 = r39
            r2 = r3
            r7 = r5
            r5 = r6
            r24 = r8
            r22 = r10
            r10 = r11
            r3 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r6 = r23
            r11 = r4
            r20 = r9
            r4 = r12
            r12 = r13
            r13 = r14
            r9 = r42
        L_0x0373:
            r0.c(r1)
            com.vungle.ads.internal.model.ConfigPayload r0 = new com.vungle.ads.internal.model.ConfigPayload
            r23 = r0
            r25 = r2
            com.vungle.ads.internal.model.ConfigPayload$CleverCache r25 = (com.vungle.ads.internal.model.ConfigPayload.CleverCache) r25
            r26 = r6
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings r26 = (com.vungle.ads.internal.model.ConfigPayload.ConfigSettings) r26
            r27 = r5
            com.vungle.ads.internal.model.ConfigPayload$Endpoints r27 = (com.vungle.ads.internal.model.ConfigPayload.Endpoints) r27
            r28 = r7
            com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings r28 = (com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings) r28
            r29 = r15
            java.util.List r29 = (java.util.List) r29
            r30 = r9
            com.vungle.ads.internal.model.ConfigPayload$UserPrivacy r30 = (com.vungle.ads.internal.model.ConfigPayload.UserPrivacy) r30
            r31 = r13
            com.vungle.ads.internal.model.ConfigPayload$ViewAbilitySettings r31 = (com.vungle.ads.internal.model.ConfigPayload.ViewAbilitySettings) r31
            r32 = r12
            java.lang.String r32 = (java.lang.String) r32
            r33 = r4
            java.lang.Boolean r33 = (java.lang.Boolean) r33
            r34 = r11
            java.lang.Boolean r34 = (java.lang.Boolean) r34
            r35 = r10
            java.lang.Integer r35 = (java.lang.Integer) r35
            r36 = r22
            java.lang.Boolean r36 = (java.lang.Boolean) r36
            r37 = r20
            java.lang.Integer r37 = (java.lang.Integer) r37
            r38 = r21
            java.lang.Boolean r38 = (java.lang.Boolean) r38
            r39 = r19
            java.lang.Boolean r39 = (java.lang.Boolean) r39
            r40 = r18
            java.lang.Boolean r40 = (java.lang.Boolean) r40
            r41 = r17
            java.lang.Boolean r41 = (java.lang.Boolean) r41
            r42 = r3
            java.lang.Long r42 = (java.lang.Long) r42
            r43 = r16
            com.vungle.ads.internal.model.ConfigPayload$AutoRedirect r43 = (com.vungle.ads.internal.model.ConfigPayload.AutoRedirect) r43
            r44 = 0
            r23.<init>((int) r24, (com.vungle.ads.internal.model.ConfigPayload.CleverCache) r25, (com.vungle.ads.internal.model.ConfigPayload.ConfigSettings) r26, (com.vungle.ads.internal.model.ConfigPayload.Endpoints) r27, (com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings) r28, (java.util.List) r29, (com.vungle.ads.internal.model.ConfigPayload.UserPrivacy) r30, (com.vungle.ads.internal.model.ConfigPayload.ViewAbilitySettings) r31, (java.lang.String) r32, (java.lang.Boolean) r33, (java.lang.Boolean) r34, (java.lang.Integer) r35, (java.lang.Boolean) r36, (java.lang.Integer) r37, (java.lang.Boolean) r38, (java.lang.Boolean) r39, (java.lang.Boolean) r40, (java.lang.Boolean) r41, (java.lang.Long) r42, (com.vungle.ads.internal.model.ConfigPayload.AutoRedirect) r43, (kotlinx.serialization.internal.SerializationConstructorMarker) r44)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.ConfigPayload");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload configPayload) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(configPayload, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.write$Self(configPayload, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

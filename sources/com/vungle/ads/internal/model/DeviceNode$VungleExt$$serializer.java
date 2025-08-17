package com.vungle.ads.internal.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.DeviceNode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class DeviceNode$VungleExt$$serializer implements GeneratedSerializer<DeviceNode.VungleExt> {
    public static final DeviceNode$VungleExt$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        DeviceNode$VungleExt$$serializer deviceNode$VungleExt$$serializer = new DeviceNode$VungleExt$$serializer();
        INSTANCE = deviceNode$VungleExt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode.VungleExt", deviceNode$VungleExt$$serializer, 18);
        pluginGeneratedSerialDescriptor.l("is_google_play_services_available", true);
        pluginGeneratedSerialDescriptor.l("app_set_id", true);
        pluginGeneratedSerialDescriptor.l("app_set_id_scope", true);
        pluginGeneratedSerialDescriptor.l("battery_level", true);
        pluginGeneratedSerialDescriptor.l("battery_state", true);
        pluginGeneratedSerialDescriptor.l("battery_saver_enabled", true);
        pluginGeneratedSerialDescriptor.l("connection_type", true);
        pluginGeneratedSerialDescriptor.l("connection_type_detail", true);
        pluginGeneratedSerialDescriptor.l(Constants.LOCALE, true);
        pluginGeneratedSerialDescriptor.l("language", true);
        pluginGeneratedSerialDescriptor.l("time_zone", true);
        pluginGeneratedSerialDescriptor.l("volume_level", true);
        pluginGeneratedSerialDescriptor.l("sound_enabled", true);
        pluginGeneratedSerialDescriptor.l("is_tv", true);
        pluginGeneratedSerialDescriptor.l("sd_card_available", true);
        pluginGeneratedSerialDescriptor.l("is_sideload_enabled", true);
        pluginGeneratedSerialDescriptor.l("gaid", true);
        pluginGeneratedSerialDescriptor.l("amazon_advertising_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$VungleExt$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.f40947a;
        StringSerializer stringSerializer = StringSerializer.f41077a;
        IntSerializer intSerializer = IntSerializer.f41006a;
        FloatSerializer floatSerializer = FloatSerializer.f40997a;
        return new KSerializer[]{booleanSerializer, BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(intSerializer), floatSerializer, BuiltinSerializersKt.s(stringSerializer), intSerializer, BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), floatSerializer, intSerializer, booleanSerializer, intSerializer, booleanSerializer, BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x01d5, code lost:
        r3 = r19;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x01d7, code lost:
        r4 = 17;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0227, code lost:
        r24 = r4;
        r4 = 17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cc, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cc, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cc, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.DeviceNode.VungleExt deserialize(kotlinx.serialization.encoding.Decoder r37) {
        /*
            r36 = this;
            r0 = r37
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r36.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r9 = 10
            r10 = 9
            r11 = 7
            r12 = 6
            r13 = 5
            r14 = 3
            r3 = 8
            r15 = 4
            r4 = 2
            r5 = 1
            r6 = 0
            r7 = 0
            if (r2 == 0) goto L_0x00ab
            boolean r2 = r0.C(r1, r6)
            kotlinx.serialization.internal.StringSerializer r6 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r5 = r0.n(r1, r5, r6, r7)
            kotlinx.serialization.internal.IntSerializer r8 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r4 = r0.n(r1, r4, r8, r7)
            float r8 = r0.u(r1, r14)
            java.lang.Object r14 = r0.n(r1, r15, r6, r7)
            int r13 = r0.i(r1, r13)
            java.lang.Object r12 = r0.n(r1, r12, r6, r7)
            java.lang.Object r11 = r0.n(r1, r11, r6, r7)
            java.lang.Object r3 = r0.n(r1, r3, r6, r7)
            java.lang.Object r10 = r0.n(r1, r10, r6, r7)
            java.lang.Object r9 = r0.n(r1, r9, r6, r7)
            r15 = 11
            float r15 = r0.u(r1, r15)
            r7 = 12
            int r7 = r0.i(r1, r7)
            r20 = r2
            r2 = 13
            boolean r2 = r0.C(r1, r2)
            r19 = r2
            r2 = 14
            int r2 = r0.i(r1, r2)
            r18 = r2
            r2 = 15
            boolean r2 = r0.C(r1, r2)
            r17 = r2
            r16 = r5
            r2 = 16
            r5 = 0
            java.lang.Object r2 = r0.n(r1, r2, r6, r5)
            r21 = r4
            r4 = 17
            java.lang.Object r4 = r0.n(r1, r4, r6, r5)
            r5 = 262143(0x3ffff, float:3.6734E-40)
            r5 = r4
            r31 = r7
            r32 = r8
            r6 = r10
            r7 = r12
            r24 = r14
            r23 = r15
            r27 = r17
            r26 = r18
            r25 = r19
            r12 = r20
            r4 = r21
            r15 = r11
            r17 = r13
            r11 = 262143(0x3ffff, float:3.6734E-40)
            goto L_0x0249
        L_0x00ab:
            r5 = r7
            r2 = 2
            r4 = 17
            r7 = 1
            r8 = 0
            r2 = r5
            r3 = r2
            r7 = r3
            r10 = r7
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r24 = r15
            r5 = 0
            r8 = 0
            r22 = 0
            r23 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 1
        L_0x00cc:
            if (r35 == 0) goto L_0x022d
            int r9 = r0.o(r1)
            switch(r9) {
                case -1: goto L_0x0216;
                case 0: goto L_0x01fd;
                case 1: goto L_0x01dd;
                case 2: goto L_0x01c5;
                case 3: goto L_0x01b6;
                case 4: goto L_0x01a5;
                case 5: goto L_0x0196;
                case 6: goto L_0x0185;
                case 7: goto L_0x0173;
                case 8: goto L_0x0160;
                case 9: goto L_0x014c;
                case 10: goto L_0x013a;
                case 11: goto L_0x012c;
                case 12: goto L_0x011e;
                case 13: goto L_0x010e;
                case 14: goto L_0x0102;
                case 15: goto L_0x00f3;
                case 16: goto L_0x00e6;
                case 17: goto L_0x00db;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x00db:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r10 = r0.n(r1, r4, r9, r10)
            r9 = 131072(0x20000, float:1.83671E-40)
            r6 = r6 | r9
            goto L_0x01d9
        L_0x00e6:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.f41077a
            r4 = 16
            java.lang.Object r3 = r0.n(r1, r4, r9, r3)
            r9 = 65536(0x10000, float:9.18355E-41)
            r6 = r6 | r9
            goto L_0x01d7
        L_0x00f3:
            r4 = 16
            r9 = 15
            boolean r23 = r0.C(r1, r9)
            r16 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 | r16
            goto L_0x01d7
        L_0x0102:
            r4 = 14
            r9 = 15
            int r22 = r0.i(r1, r4)
            r6 = r6 | 16384(0x4000, float:2.2959E-41)
            goto L_0x01d7
        L_0x010e:
            r4 = 14
            r8 = 13
            r9 = 15
            boolean r17 = r0.C(r1, r8)
            r6 = r6 | 8192(0x2000, float:1.14794E-41)
            r8 = r17
            goto L_0x01d7
        L_0x011e:
            r4 = 12
            r9 = 15
            r17 = 13
            int r31 = r0.i(r1, r4)
            r6 = r6 | 4096(0x1000, float:5.74E-42)
            goto L_0x01d7
        L_0x012c:
            r4 = 11
            r9 = 15
            r17 = 13
            float r34 = r0.u(r1, r4)
            r6 = r6 | 2048(0x800, float:2.87E-42)
            goto L_0x01d7
        L_0x013a:
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.f41077a
            r19 = r3
            r3 = 10
            java.lang.Object r11 = r0.n(r1, r3, r4, r11)
            r6 = r6 | 1024(0x400, float:1.435E-42)
            goto L_0x01d5
        L_0x014c:
            r19 = r3
            r3 = 10
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 9
            java.lang.Object r12 = r0.n(r1, r3, r4, r12)
            r6 = r6 | 512(0x200, float:7.175E-43)
            goto L_0x01d5
        L_0x0160:
            r19 = r3
            r3 = 9
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 8
            java.lang.Object r13 = r0.n(r1, r3, r4, r13)
            r6 = r6 | 256(0x100, float:3.59E-43)
            goto L_0x01d5
        L_0x0173:
            r19 = r3
            r3 = 8
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 7
            java.lang.Object r15 = r0.n(r1, r3, r4, r15)
            r6 = r6 | 128(0x80, float:1.794E-43)
            goto L_0x01d5
        L_0x0185:
            r19 = r3
            r3 = 7
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 6
            java.lang.Object r14 = r0.n(r1, r3, r4, r14)
            r6 = r6 | 64
            goto L_0x01d5
        L_0x0196:
            r19 = r3
            r3 = 6
            r4 = 5
            r9 = 15
            r17 = 13
            int r33 = r0.i(r1, r4)
            r6 = r6 | 32
            goto L_0x01d5
        L_0x01a5:
            r19 = r3
            r4 = 5
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            r4 = 4
            java.lang.Object r2 = r0.n(r1, r4, r3, r2)
            r6 = r6 | 16
            goto L_0x01d5
        L_0x01b6:
            r19 = r3
            r3 = 3
            r4 = 4
            r9 = 15
            r17 = 13
            float r32 = r0.u(r1, r3)
            r6 = r6 | 8
            goto L_0x01d5
        L_0x01c5:
            r19 = r3
            r4 = 4
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.IntSerializer r3 = kotlinx.serialization.internal.IntSerializer.f41006a
            r4 = 2
            java.lang.Object r7 = r0.n(r1, r4, r3, r7)
            r6 = r6 | 4
        L_0x01d5:
            r3 = r19
        L_0x01d7:
            r4 = 17
        L_0x01d9:
            r9 = 10
            goto L_0x00cc
        L_0x01dd:
            r19 = r3
            r4 = 2
            r9 = 15
            r17 = 13
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            r4 = r24
            r24 = r2
            r2 = 1
            java.lang.Object r3 = r0.n(r1, r2, r3, r4)
            r6 = r6 | 2
            r2 = r24
            r4 = 17
            r9 = 10
            r24 = r3
            r3 = r19
            goto L_0x00cc
        L_0x01fd:
            r19 = r3
            r4 = r24
            r3 = 0
            r9 = 15
            r17 = 13
            r24 = r2
            r2 = 1
            boolean r5 = r0.C(r1, r3)
            r6 = r6 | 1
            r3 = r19
            r2 = r24
            r9 = 10
            goto L_0x0227
        L_0x0216:
            r19 = r3
            r4 = r24
            r3 = 0
            r9 = 15
            r17 = 13
            r24 = r2
            r3 = r19
            r9 = 10
            r35 = 0
        L_0x0227:
            r24 = r4
            r4 = 17
            goto L_0x00cc
        L_0x022d:
            r19 = r3
            r4 = r24
            r24 = r2
            r16 = r4
            r4 = r7
            r25 = r8
            r9 = r11
            r3 = r13
            r7 = r14
            r2 = r19
            r26 = r22
            r27 = r23
            r17 = r33
            r23 = r34
            r11 = r6
            r6 = r12
            r12 = r5
            r5 = r10
        L_0x0249:
            r0.c(r1)
            com.vungle.ads.internal.model.DeviceNode$VungleExt r0 = new com.vungle.ads.internal.model.DeviceNode$VungleExt
            r10 = r0
            r13 = r16
            java.lang.String r13 = (java.lang.String) r13
            r14 = r4
            java.lang.Integer r14 = (java.lang.Integer) r14
            r16 = r24
            java.lang.String r16 = (java.lang.String) r16
            r18 = r7
            java.lang.String r18 = (java.lang.String) r18
            r19 = r15
            java.lang.String r19 = (java.lang.String) r19
            r20 = r3
            java.lang.String r20 = (java.lang.String) r20
            r21 = r6
            java.lang.String r21 = (java.lang.String) r21
            r22 = r9
            java.lang.String r22 = (java.lang.String) r22
            r28 = r2
            java.lang.String r28 = (java.lang.String) r28
            r29 = r5
            java.lang.String r29 = (java.lang.String) r29
            r30 = 0
            r15 = r32
            r24 = r31
            r10.<init>((int) r11, (boolean) r12, (java.lang.String) r13, (java.lang.Integer) r14, (float) r15, (java.lang.String) r16, (int) r17, (java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (java.lang.String) r22, (float) r23, (int) r24, (boolean) r25, (int) r26, (boolean) r27, (java.lang.String) r28, (java.lang.String) r29, (kotlinx.serialization.internal.SerializationConstructorMarker) r30)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode$VungleExt$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.DeviceNode$VungleExt");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, DeviceNode.VungleExt vungleExt) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(vungleExt, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        DeviceNode.VungleExt.write$Self(vungleExt, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

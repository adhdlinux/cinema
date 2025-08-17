package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class DeviceNode$$serializer implements GeneratedSerializer<DeviceNode> {
    public static final DeviceNode$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        DeviceNode$$serializer deviceNode$$serializer = new DeviceNode$$serializer();
        INSTANCE = deviceNode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode", deviceNode$$serializer, 11);
        pluginGeneratedSerialDescriptor.l("make", false);
        pluginGeneratedSerialDescriptor.l("model", false);
        pluginGeneratedSerialDescriptor.l("osv", false);
        pluginGeneratedSerialDescriptor.l("carrier", true);
        pluginGeneratedSerialDescriptor.l("os", false);
        pluginGeneratedSerialDescriptor.l("w", false);
        pluginGeneratedSerialDescriptor.l("h", false);
        pluginGeneratedSerialDescriptor.l("ua", true);
        pluginGeneratedSerialDescriptor.l("ifa", true);
        pluginGeneratedSerialDescriptor.l("lmt", true);
        pluginGeneratedSerialDescriptor.l("ext", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        IntSerializer intSerializer = IntSerializer.f41006a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.s(stringSerializer), stringSerializer, intSerializer, intSerializer, BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(DeviceNode$VungleExt$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ed, code lost:
        r3 = 10;
        r4 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.DeviceNode deserialize(kotlinx.serialization.encoding.Decoder r24) {
        /*
            r23 = this;
            r0 = r24
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r23.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 10
            r4 = 9
            r5 = 7
            r6 = 6
            r7 = 5
            r8 = 3
            r9 = 8
            r10 = 4
            r11 = 2
            r12 = 1
            r13 = 0
            r14 = 0
            if (r2 == 0) goto L_0x0065
            java.lang.String r2 = r0.m(r1, r13)
            java.lang.String r12 = r0.m(r1, r12)
            java.lang.String r11 = r0.m(r1, r11)
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r8 = r0.n(r1, r8, r13, r14)
            java.lang.String r10 = r0.m(r1, r10)
            int r7 = r0.i(r1, r7)
            int r6 = r0.i(r1, r6)
            java.lang.Object r5 = r0.n(r1, r5, r13, r14)
            java.lang.Object r9 = r0.n(r1, r9, r13, r14)
            kotlinx.serialization.internal.IntSerializer r13 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r4 = r0.n(r1, r4, r13, r14)
            com.vungle.ads.internal.model.DeviceNode$VungleExt$$serializer r13 = com.vungle.ads.internal.model.DeviceNode$VungleExt$$serializer.INSTANCE
            java.lang.Object r3 = r0.n(r1, r3, r13, r14)
            r13 = 2047(0x7ff, float:2.868E-42)
            r16 = r6
            r15 = r7
            r14 = r10
            r17 = r12
            r10 = r2
            r12 = r11
            r11 = r9
            r9 = 2047(0x7ff, float:2.868E-42)
            goto L_0x0108
        L_0x0065:
            r8 = r14
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r2 = 0
            r14 = 0
            r15 = 0
            r22 = 1
        L_0x0077:
            if (r22 == 0) goto L_0x00fa
            int r7 = r0.o(r1)
            switch(r7) {
                case -1: goto L_0x00f2;
                case 0: goto L_0x00e4;
                case 1: goto L_0x00da;
                case 2: goto L_0x00d0;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00b2;
                case 6: goto L_0x00aa;
                case 7: goto L_0x00a1;
                case 8: goto L_0x0098;
                case 9: goto L_0x008f;
                case 10: goto L_0x0086;
                default: goto L_0x0080;
            }
        L_0x0080:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r7)
            throw r0
        L_0x0086:
            com.vungle.ads.internal.model.DeviceNode$VungleExt$$serializer r7 = com.vungle.ads.internal.model.DeviceNode$VungleExt$$serializer.INSTANCE
            java.lang.Object r10 = r0.n(r1, r3, r7, r10)
            r15 = r15 | 1024(0x400, float:1.435E-42)
            goto L_0x00b0
        L_0x008f:
            kotlinx.serialization.internal.IntSerializer r7 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r8 = r0.n(r1, r4, r7, r8)
            r15 = r15 | 512(0x200, float:7.175E-43)
            goto L_0x00b0
        L_0x0098:
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r11 = r0.n(r1, r9, r7, r11)
            r15 = r15 | 256(0x100, float:3.59E-43)
            goto L_0x00b0
        L_0x00a1:
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r12 = r0.n(r1, r5, r7, r12)
            r15 = r15 | 128(0x80, float:1.794E-43)
            goto L_0x00b0
        L_0x00aa:
            int r2 = r0.i(r1, r6)
            r15 = r15 | 64
        L_0x00b0:
            r7 = 5
            goto L_0x0077
        L_0x00b2:
            r7 = 5
            int r14 = r0.i(r1, r7)
            r15 = r15 | 32
            goto L_0x0077
        L_0x00ba:
            r3 = 4
            r7 = 5
            java.lang.String r19 = r0.m(r1, r3)
            r15 = r15 | 16
            r3 = 10
            goto L_0x0077
        L_0x00c5:
            r7 = 5
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            r4 = 3
            java.lang.Object r13 = r0.n(r1, r4, r3, r13)
            r15 = r15 | 8
            goto L_0x00ed
        L_0x00d0:
            r3 = 2
            r4 = 3
            r7 = 5
            java.lang.String r18 = r0.m(r1, r3)
            r15 = r15 | 4
            goto L_0x00ed
        L_0x00da:
            r3 = 1
            r4 = 3
            r7 = 5
            java.lang.String r17 = r0.m(r1, r3)
            r15 = r15 | 2
            goto L_0x00ed
        L_0x00e4:
            r3 = 0
            r4 = 3
            r7 = 5
            java.lang.String r16 = r0.m(r1, r3)
            r15 = r15 | 1
        L_0x00ed:
            r3 = 10
            r4 = 9
            goto L_0x0077
        L_0x00f2:
            r3 = 0
            r7 = 5
            r3 = 10
            r22 = 0
            goto L_0x0077
        L_0x00fa:
            r4 = r8
            r3 = r10
            r5 = r12
            r8 = r13
            r9 = r15
            r10 = r16
            r12 = r18
            r16 = r2
            r15 = r14
            r14 = r19
        L_0x0108:
            r0.c(r1)
            com.vungle.ads.internal.model.DeviceNode r0 = new com.vungle.ads.internal.model.DeviceNode
            r13 = r8
            java.lang.String r13 = (java.lang.String) r13
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            r18 = r11
            java.lang.String r18 = (java.lang.String) r18
            r19 = r4
            java.lang.Integer r19 = (java.lang.Integer) r19
            r20 = r3
            com.vungle.ads.internal.model.DeviceNode$VungleExt r20 = (com.vungle.ads.internal.model.DeviceNode.VungleExt) r20
            r21 = 0
            r8 = r0
            r11 = r17
            r17 = r1
            r8.<init>((int) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (int) r15, (int) r16, (java.lang.String) r17, (java.lang.String) r18, (java.lang.Integer) r19, (com.vungle.ads.internal.model.DeviceNode.VungleExt) r20, (kotlinx.serialization.internal.SerializationConstructorMarker) r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.DeviceNode");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, DeviceNode deviceNode) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(deviceNode, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        DeviceNode.write$Self(deviceNode, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

package com.vungle.ads.internal.signals;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class SignaledAd$$serializer implements GeneratedSerializer<SignaledAd> {
    public static final SignaledAd$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        SignaledAd$$serializer signaledAd$$serializer = new SignaledAd$$serializer();
        INSTANCE = signaledAd$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.signals.SignaledAd", signaledAd$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("500", true);
        pluginGeneratedSerialDescriptor.l("109", false);
        pluginGeneratedSerialDescriptor.l("107", true);
        pluginGeneratedSerialDescriptor.l("110", true);
        pluginGeneratedSerialDescriptor.l("108", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SignaledAd$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        LongSerializer longSerializer = LongSerializer.f41017a;
        return new KSerializer[]{BuiltinSerializersKt.s(stringSerializer), longSerializer, BuiltinSerializersKt.s(stringSerializer), longSerializer, IntSerializer.f41006a};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.signals.SignaledAd deserialize(kotlinx.serialization.encoding.Decoder r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r18.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x003b
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r7 = r0.n(r1, r7, r2, r8)
            long r9 = r0.f(r1, r6)
            java.lang.Object r2 = r0.n(r1, r5, r2, r8)
            long r5 = r0.f(r1, r3)
            int r3 = r0.i(r1, r4)
            r4 = 31
            r11 = r3
            r3 = r7
            r16 = r5
            r6 = r9
            r9 = r16
            goto L_0x0094
        L_0x003b:
            r9 = 0
            r11 = r8
            r12 = r11
            r13 = r9
            r2 = 0
            r8 = 0
            r15 = 1
        L_0x0043:
            if (r15 == 0) goto L_0x008f
            int r7 = r0.o(r1)
            r4 = -1
            if (r7 == r4) goto L_0x0089
            if (r7 == 0) goto L_0x007c
            if (r7 == r6) goto L_0x0074
            r4 = 4
            if (r7 == r5) goto L_0x006b
            if (r7 == r3) goto L_0x0064
            if (r7 != r4) goto L_0x005e
            int r2 = r0.i(r1, r4)
            r8 = r8 | 16
            goto L_0x0087
        L_0x005e:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r7)
            throw r0
        L_0x0064:
            long r9 = r0.f(r1, r3)
            r8 = r8 | 8
            goto L_0x0087
        L_0x006b:
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r12 = r0.n(r1, r5, r7, r12)
            r8 = r8 | 4
            goto L_0x0087
        L_0x0074:
            r4 = 4
            long r13 = r0.f(r1, r6)
            r8 = r8 | 2
            goto L_0x0087
        L_0x007c:
            r4 = 4
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 0
            java.lang.Object r11 = r0.n(r1, r3, r7, r11)
            r8 = r8 | 1
            r3 = 3
        L_0x0087:
            r7 = 0
            goto L_0x0043
        L_0x0089:
            r3 = 0
            r4 = 4
            r3 = 3
            r7 = 0
            r15 = 0
            goto L_0x0043
        L_0x008f:
            r4 = r8
            r3 = r11
            r6 = r13
            r11 = r2
            r2 = r12
        L_0x0094:
            r0.c(r1)
            com.vungle.ads.internal.signals.SignaledAd r0 = new com.vungle.ads.internal.signals.SignaledAd
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            r12 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r8, r9, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.signals.SignaledAd$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.signals.SignaledAd");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, SignaledAd signaledAd) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(signaledAd, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        SignaledAd.write$Self(signaledAd, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

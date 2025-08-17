package com.vungle.ads.fpd;

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

public final class Demographic$$serializer implements GeneratedSerializer<Demographic> {
    public static final Demographic$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        Demographic$$serializer demographic$$serializer = new Demographic$$serializer();
        INSTANCE = demographic$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Demographic", demographic$$serializer, 4);
        pluginGeneratedSerialDescriptor.l("age_range", true);
        pluginGeneratedSerialDescriptor.l("length_of_residence", true);
        pluginGeneratedSerialDescriptor.l("median_home_value_usd", true);
        pluginGeneratedSerialDescriptor.l("monthly_housing_payment_usd", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Demographic$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.f41006a;
        return new KSerializer[]{BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.fpd.Demographic deserialize(kotlinx.serialization.encoding.Decoder r14) {
        /*
            r13 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r13.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r14 = r14.b(r0)
            boolean r1 = r14.p()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x0030
            kotlinx.serialization.internal.IntSerializer r1 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r5 = r14.n(r0, r5, r1, r6)
            java.lang.Object r4 = r14.n(r0, r4, r1, r6)
            java.lang.Object r3 = r14.n(r0, r3, r1, r6)
            java.lang.Object r1 = r14.n(r0, r2, r1, r6)
            r2 = 15
            r8 = r3
            r3 = 15
            goto L_0x0076
        L_0x0030:
            r7 = r6
            r8 = r7
            r9 = r8
            r1 = 0
            r10 = 1
        L_0x0035:
            if (r10 == 0) goto L_0x0072
            int r11 = r14.o(r0)
            r12 = -1
            if (r11 == r12) goto L_0x0070
            if (r11 == 0) goto L_0x0067
            if (r11 == r4) goto L_0x005e
            if (r11 == r3) goto L_0x0055
            if (r11 != r2) goto L_0x004f
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r9 = r14.n(r0, r2, r11, r9)
            r1 = r1 | 8
            goto L_0x0035
        L_0x004f:
            kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
            r14.<init>((int) r11)
            throw r14
        L_0x0055:
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r8 = r14.n(r0, r3, r11, r8)
            r1 = r1 | 4
            goto L_0x0035
        L_0x005e:
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r7 = r14.n(r0, r4, r11, r7)
            r1 = r1 | 2
            goto L_0x0035
        L_0x0067:
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r6 = r14.n(r0, r5, r11, r6)
            r1 = r1 | 1
            goto L_0x0035
        L_0x0070:
            r10 = 0
            goto L_0x0035
        L_0x0072:
            r3 = r1
            r5 = r6
            r4 = r7
            r1 = r9
        L_0x0076:
            r14.c(r0)
            com.vungle.ads.fpd.Demographic r14 = new com.vungle.ads.fpd.Demographic
            r0 = r5
            java.lang.Integer r0 = (java.lang.Integer) r0
            r5 = r4
            java.lang.Integer r5 = (java.lang.Integer) r5
            r6 = r8
            java.lang.Integer r6 = (java.lang.Integer) r6
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            r8 = 0
            r2 = r14
            r4 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.fpd.Demographic$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.fpd.Demographic");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Demographic demographic) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(demographic, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        Demographic.write$Self(demographic, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
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

public final class Placement$$serializer implements GeneratedSerializer<Placement> {
    public static final Placement$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        Placement$$serializer placement$$serializer = new Placement$$serializer();
        INSTANCE = placement$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.Placement", placement$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("placement_ref_id", false);
        pluginGeneratedSerialDescriptor.l("is_hb", true);
        pluginGeneratedSerialDescriptor.l("type", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Placement$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{stringSerializer, BooleanSerializer.f40947a, BuiltinSerializersKt.s(stringSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.Placement deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x002c
            java.lang.String r2 = r0.m(r1, r5)
            boolean r4 = r0.C(r1, r4)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r3 = r0.n(r1, r3, r5, r6)
            r5 = 7
            r12 = r2
            r13 = r4
            r11 = 7
            goto L_0x0063
        L_0x002c:
            r7 = r6
            r8 = r7
            r2 = 0
            r6 = 0
            r9 = 1
        L_0x0031:
            if (r9 == 0) goto L_0x005f
            int r10 = r0.o(r1)
            r11 = -1
            if (r10 == r11) goto L_0x005d
            if (r10 == 0) goto L_0x0056
            if (r10 == r4) goto L_0x004f
            if (r10 != r3) goto L_0x0049
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r8 = r0.n(r1, r3, r10, r8)
            r6 = r6 | 4
            goto L_0x0031
        L_0x0049:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r10)
            throw r0
        L_0x004f:
            boolean r2 = r0.C(r1, r4)
            r6 = r6 | 2
            goto L_0x0031
        L_0x0056:
            java.lang.String r7 = r0.m(r1, r5)
            r6 = r6 | 1
            goto L_0x0031
        L_0x005d:
            r9 = 0
            goto L_0x0031
        L_0x005f:
            r13 = r2
            r11 = r6
            r12 = r7
            r3 = r8
        L_0x0063:
            r0.c(r1)
            com.vungle.ads.internal.model.Placement r0 = new com.vungle.ads.internal.model.Placement
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            r15 = 0
            r10 = r0
            r10.<init>((int) r11, (java.lang.String) r12, (boolean) r13, (java.lang.String) r14, (kotlinx.serialization.internal.SerializationConstructorMarker) r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.Placement$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.Placement");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Placement placement) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(placement, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        Placement.write$Self(placement, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

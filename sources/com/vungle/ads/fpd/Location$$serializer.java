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
import kotlinx.serialization.internal.StringSerializer;

public final class Location$$serializer implements GeneratedSerializer<Location> {
    public static final Location$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        Location$$serializer location$$serializer = new Location$$serializer();
        INSTANCE = location$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Location", location$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("country", true);
        pluginGeneratedSerialDescriptor.l("region_state", true);
        pluginGeneratedSerialDescriptor.l("dma", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Location$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(IntSerializer.f41006a)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.fpd.Location deserialize(kotlinx.serialization.encoding.Decoder r12) {
        /*
            r11 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r11.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r12 = r12.b(r0)
            boolean r1 = r12.p()
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x002b
            kotlinx.serialization.internal.StringSerializer r1 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r4 = r12.n(r0, r4, r1, r5)
            java.lang.Object r1 = r12.n(r0, r3, r1, r5)
            kotlinx.serialization.internal.IntSerializer r3 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r2 = r12.n(r0, r2, r3, r5)
            r3 = 7
            r5 = r4
            r4 = 7
            goto L_0x0064
        L_0x002b:
            r6 = r5
            r7 = r6
            r1 = 0
            r8 = 1
        L_0x002f:
            if (r8 == 0) goto L_0x0061
            int r9 = r12.o(r0)
            r10 = -1
            if (r9 == r10) goto L_0x005f
            if (r9 == 0) goto L_0x0056
            if (r9 == r3) goto L_0x004d
            if (r9 != r2) goto L_0x0047
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r7 = r12.n(r0, r2, r9, r7)
            r1 = r1 | 4
            goto L_0x002f
        L_0x0047:
            kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
            r12.<init>((int) r9)
            throw r12
        L_0x004d:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r6 = r12.n(r0, r3, r9, r6)
            r1 = r1 | 2
            goto L_0x002f
        L_0x0056:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r5 = r12.n(r0, r4, r9, r5)
            r1 = r1 | 1
            goto L_0x002f
        L_0x005f:
            r8 = 0
            goto L_0x002f
        L_0x0061:
            r4 = r1
            r1 = r6
            r2 = r7
        L_0x0064:
            r12.c(r0)
            com.vungle.ads.fpd.Location r12 = new com.vungle.ads.fpd.Location
            java.lang.String r5 = (java.lang.String) r5
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            r7 = r2
            java.lang.Integer r7 = (java.lang.Integer) r7
            r8 = 0
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.fpd.Location$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.fpd.Location");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Location location) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(location, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        Location.write$Self(location, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

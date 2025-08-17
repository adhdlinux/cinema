package com.vungle.ads.internal.model;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.AdPayload;
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

public final class AdPayload$CacheableReplacement$$serializer implements GeneratedSerializer<AdPayload.CacheableReplacement> {
    public static final AdPayload$CacheableReplacement$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$CacheableReplacement$$serializer adPayload$CacheableReplacement$$serializer = new AdPayload$CacheableReplacement$$serializer();
        INSTANCE = adPayload$CacheableReplacement$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.CacheableReplacement", adPayload$CacheableReplacement$$serializer, 3);
        pluginGeneratedSerialDescriptor.l(ImagesContract.URL, true);
        pluginGeneratedSerialDescriptor.l("extension", true);
        pluginGeneratedSerialDescriptor.l("required", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$CacheableReplacement$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(BooleanSerializer.f40947a)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.AdPayload.CacheableReplacement deserialize(kotlinx.serialization.encoding.Decoder r12) {
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
            kotlinx.serialization.internal.BooleanSerializer r3 = kotlinx.serialization.internal.BooleanSerializer.f40947a
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
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.f40947a
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
            com.vungle.ads.internal.model.AdPayload$CacheableReplacement r12 = new com.vungle.ads.internal.model.AdPayload$CacheableReplacement
            java.lang.String r5 = (java.lang.String) r5
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            r7 = r2
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            r8 = 0
            r3 = r12
            r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.Boolean) r7, (kotlinx.serialization.internal.SerializationConstructorMarker) r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$CacheableReplacement$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.AdPayload$CacheableReplacement");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.CacheableReplacement cacheableReplacement) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(cacheableReplacement, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.CacheableReplacement.write$Self(cacheableReplacement, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.ConfigPayload;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class ConfigPayload$Endpoints$$serializer implements GeneratedSerializer<ConfigPayload.Endpoints> {
    public static final ConfigPayload$Endpoints$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$Endpoints$$serializer configPayload$Endpoints$$serializer = new ConfigPayload$Endpoints$$serializer();
        INSTANCE = configPayload$Endpoints$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.Endpoints", configPayload$Endpoints$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("ads", true);
        pluginGeneratedSerialDescriptor.l("ri", true);
        pluginGeneratedSerialDescriptor.l("error_logs", true);
        pluginGeneratedSerialDescriptor.l("metrics", true);
        pluginGeneratedSerialDescriptor.l("mraid_js", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$Endpoints$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.ConfigPayload.Endpoints deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x0037
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r7 = r0.n(r1, r7, r2, r8)
            java.lang.Object r6 = r0.n(r1, r6, r2, r8)
            java.lang.Object r5 = r0.n(r1, r5, r2, r8)
            java.lang.Object r3 = r0.n(r1, r3, r2, r8)
            java.lang.Object r2 = r0.n(r1, r4, r2, r8)
            r4 = 31
            r10 = r5
            r5 = 31
            goto L_0x008a
        L_0x0037:
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r2 = 0
            r13 = 1
        L_0x003d:
            if (r13 == 0) goto L_0x0085
            int r14 = r0.o(r1)
            r15 = -1
            if (r14 == r15) goto L_0x0083
            if (r14 == 0) goto L_0x007a
            if (r14 == r6) goto L_0x0071
            if (r14 == r5) goto L_0x0068
            if (r14 == r3) goto L_0x005f
            if (r14 != r4) goto L_0x0059
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r12 = r0.n(r1, r4, r14, r12)
            r2 = r2 | 16
            goto L_0x003d
        L_0x0059:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x005f:
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r11 = r0.n(r1, r3, r14, r11)
            r2 = r2 | 8
            goto L_0x003d
        L_0x0068:
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r10 = r0.n(r1, r5, r14, r10)
            r2 = r2 | 4
            goto L_0x003d
        L_0x0071:
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r9 = r0.n(r1, r6, r14, r9)
            r2 = r2 | 2
            goto L_0x003d
        L_0x007a:
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r8 = r0.n(r1, r7, r14, r8)
            r2 = r2 | 1
            goto L_0x003d
        L_0x0083:
            r13 = 0
            goto L_0x003d
        L_0x0085:
            r5 = r2
            r7 = r8
            r6 = r9
            r3 = r11
            r2 = r12
        L_0x008a:
            r0.c(r1)
            com.vungle.ads.internal.model.ConfigPayload$Endpoints r0 = new com.vungle.ads.internal.model.ConfigPayload$Endpoints
            r1 = r7
            java.lang.String r1 = (java.lang.String) r1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            r8 = r10
            java.lang.String r8 = (java.lang.String) r8
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            r11 = 0
            r4 = r0
            r6 = r1
            r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (kotlinx.serialization.internal.SerializationConstructorMarker) r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.ConfigPayload$Endpoints");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.Endpoints endpoints) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(endpoints, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.Endpoints.write$Self(endpoints, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

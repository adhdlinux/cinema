package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.CommonRequestBody;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class CommonRequestBody$RequestParam$$serializer implements GeneratedSerializer<CommonRequestBody.RequestParam> {
    public static final CommonRequestBody$RequestParam$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CommonRequestBody$RequestParam$$serializer commonRequestBody$RequestParam$$serializer = new CommonRequestBody$RequestParam$$serializer();
        INSTANCE = commonRequestBody$RequestParam$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.RequestParam", commonRequestBody$RequestParam$$serializer, 6);
        pluginGeneratedSerialDescriptor.l("placements", true);
        pluginGeneratedSerialDescriptor.l("ad_size", true);
        pluginGeneratedSerialDescriptor.l("ad_start_time", true);
        pluginGeneratedSerialDescriptor.l("app_id", true);
        pluginGeneratedSerialDescriptor.l("placement_reference_id", true);
        pluginGeneratedSerialDescriptor.l("user", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$RequestParam$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(new ArrayListSerializer(stringSerializer)), BuiltinSerializersKt.s(CommonRequestBody$AdSizeParam$$serializer.INSTANCE), BuiltinSerializersKt.s(LongSerializer.f41017a), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.CommonRequestBody.RequestParam deserialize(kotlinx.serialization.encoding.Decoder r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r18.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 5
            r4 = 3
            r5 = 4
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 == 0) goto L_0x0045
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.f41077a
            r2.<init>(r10)
            java.lang.Object r2 = r0.n(r1, r8, r2, r9)
            com.vungle.ads.internal.model.CommonRequestBody$AdSizeParam$$serializer r8 = com.vungle.ads.internal.model.CommonRequestBody$AdSizeParam$$serializer.INSTANCE
            java.lang.Object r7 = r0.n(r1, r7, r8, r9)
            kotlinx.serialization.internal.LongSerializer r8 = kotlinx.serialization.internal.LongSerializer.f41017a
            java.lang.Object r6 = r0.n(r1, r6, r8, r9)
            java.lang.Object r4 = r0.n(r1, r4, r10, r9)
            java.lang.Object r5 = r0.n(r1, r5, r10, r9)
            java.lang.Object r3 = r0.n(r1, r3, r10, r9)
            r8 = 63
            r9 = 63
            goto L_0x00a8
        L_0x0045:
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r2 = 0
            r15 = 1
        L_0x004c:
            if (r15 == 0) goto L_0x009e
            int r8 = r0.o(r1)
            switch(r8) {
                case -1: goto L_0x0099;
                case 0: goto L_0x0088;
                case 1: goto L_0x007f;
                case 2: goto L_0x0076;
                case 3: goto L_0x006d;
                case 4: goto L_0x0064;
                case 5: goto L_0x005b;
                default: goto L_0x0055;
            }
        L_0x0055:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r8)
            throw r0
        L_0x005b:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r14 = r0.n(r1, r3, r8, r14)
            r2 = r2 | 32
            goto L_0x0097
        L_0x0064:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r13 = r0.n(r1, r5, r8, r13)
            r2 = r2 | 16
            goto L_0x0097
        L_0x006d:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r12 = r0.n(r1, r4, r8, r12)
            r2 = r2 | 8
            goto L_0x0097
        L_0x0076:
            kotlinx.serialization.internal.LongSerializer r8 = kotlinx.serialization.internal.LongSerializer.f41017a
            java.lang.Object r11 = r0.n(r1, r6, r8, r11)
            r2 = r2 | 4
            goto L_0x0097
        L_0x007f:
            com.vungle.ads.internal.model.CommonRequestBody$AdSizeParam$$serializer r8 = com.vungle.ads.internal.model.CommonRequestBody$AdSizeParam$$serializer.INSTANCE
            java.lang.Object r10 = r0.n(r1, r7, r8, r10)
            r2 = r2 | 2
            goto L_0x0097
        L_0x0088:
            kotlinx.serialization.internal.ArrayListSerializer r8 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            r8.<init>(r3)
            r3 = 0
            java.lang.Object r9 = r0.n(r1, r3, r8, r9)
            r2 = r2 | 1
            r3 = 5
        L_0x0097:
            r8 = 0
            goto L_0x004c
        L_0x0099:
            r3 = 0
            r3 = 5
            r8 = 0
            r15 = 0
            goto L_0x004c
        L_0x009e:
            r7 = r10
            r6 = r11
            r4 = r12
            r5 = r13
            r3 = r14
            r17 = r9
            r9 = r2
            r2 = r17
        L_0x00a8:
            r0.c(r1)
            com.vungle.ads.internal.model.CommonRequestBody$RequestParam r0 = new com.vungle.ads.internal.model.CommonRequestBody$RequestParam
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            r11 = r7
            com.vungle.ads.internal.model.CommonRequestBody$AdSizeParam r11 = (com.vungle.ads.internal.model.CommonRequestBody.AdSizeParam) r11
            r12 = r6
            java.lang.Long r12 = (java.lang.Long) r12
            r13 = r4
            java.lang.String r13 = (java.lang.String) r13
            r14 = r5
            java.lang.String r14 = (java.lang.String) r14
            r15 = r3
            java.lang.String r15 = (java.lang.String) r15
            r16 = 0
            r8 = r0
            r8.<init>((int) r9, (java.util.List) r10, (com.vungle.ads.internal.model.CommonRequestBody.AdSizeParam) r11, (java.lang.Long) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (kotlinx.serialization.internal.SerializationConstructorMarker) r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.CommonRequestBody$RequestParam$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.CommonRequestBody$RequestParam");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CommonRequestBody.RequestParam requestParam) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(requestParam, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        CommonRequestBody.RequestParam.write$Self(requestParam, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

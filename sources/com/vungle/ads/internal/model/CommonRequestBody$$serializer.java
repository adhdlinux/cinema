package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.ui.AdActivity;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public final class CommonRequestBody$$serializer implements GeneratedSerializer<CommonRequestBody> {
    public static final CommonRequestBody$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CommonRequestBody$$serializer commonRequestBody$$serializer = new CommonRequestBody$$serializer();
        INSTANCE = commonRequestBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody", commonRequestBody$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("device", false);
        pluginGeneratedSerialDescriptor.l("app", true);
        pluginGeneratedSerialDescriptor.l("user", true);
        pluginGeneratedSerialDescriptor.l("ext", true);
        pluginGeneratedSerialDescriptor.l(AdActivity.REQUEST_KEY_EXTRA, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DeviceNode$$serializer.INSTANCE, BuiltinSerializersKt.s(AppNode$$serializer.INSTANCE), BuiltinSerializersKt.s(CommonRequestBody$User$$serializer.INSTANCE), BuiltinSerializersKt.s(CommonRequestBody$RequestExt$$serializer.INSTANCE), BuiltinSerializersKt.s(CommonRequestBody$RequestParam$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.CommonRequestBody deserialize(kotlinx.serialization.encoding.Decoder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r17.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x003f
            com.vungle.ads.internal.model.DeviceNode$$serializer r2 = com.vungle.ads.internal.model.DeviceNode$$serializer.INSTANCE
            java.lang.Object r2 = r0.y(r1, r7, r2, r8)
            com.vungle.ads.internal.model.AppNode$$serializer r7 = com.vungle.ads.internal.model.AppNode$$serializer.INSTANCE
            java.lang.Object r6 = r0.n(r1, r6, r7, r8)
            com.vungle.ads.internal.model.CommonRequestBody$User$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$User$$serializer.INSTANCE
            java.lang.Object r5 = r0.n(r1, r5, r7, r8)
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer.INSTANCE
            java.lang.Object r3 = r0.n(r1, r3, r7, r8)
            com.vungle.ads.internal.model.CommonRequestBody$RequestParam$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$RequestParam$$serializer.INSTANCE
            java.lang.Object r4 = r0.n(r1, r4, r7, r8)
            r7 = 31
            r8 = 31
            goto L_0x0096
        L_0x003f:
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r2 = 0
            r13 = 1
        L_0x0045:
            if (r13 == 0) goto L_0x008d
            int r14 = r0.o(r1)
            r15 = -1
            if (r14 == r15) goto L_0x008b
            if (r14 == 0) goto L_0x0082
            if (r14 == r6) goto L_0x0079
            if (r14 == r5) goto L_0x0070
            if (r14 == r3) goto L_0x0067
            if (r14 != r4) goto L_0x0061
            com.vungle.ads.internal.model.CommonRequestBody$RequestParam$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$RequestParam$$serializer.INSTANCE
            java.lang.Object r12 = r0.n(r1, r4, r14, r12)
            r2 = r2 | 16
            goto L_0x0045
        L_0x0061:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x0067:
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer.INSTANCE
            java.lang.Object r11 = r0.n(r1, r3, r14, r11)
            r2 = r2 | 8
            goto L_0x0045
        L_0x0070:
            com.vungle.ads.internal.model.CommonRequestBody$User$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$User$$serializer.INSTANCE
            java.lang.Object r10 = r0.n(r1, r5, r14, r10)
            r2 = r2 | 4
            goto L_0x0045
        L_0x0079:
            com.vungle.ads.internal.model.AppNode$$serializer r14 = com.vungle.ads.internal.model.AppNode$$serializer.INSTANCE
            java.lang.Object r9 = r0.n(r1, r6, r14, r9)
            r2 = r2 | 2
            goto L_0x0045
        L_0x0082:
            com.vungle.ads.internal.model.DeviceNode$$serializer r14 = com.vungle.ads.internal.model.DeviceNode$$serializer.INSTANCE
            java.lang.Object r8 = r0.y(r1, r7, r14, r8)
            r2 = r2 | 1
            goto L_0x0045
        L_0x008b:
            r13 = 0
            goto L_0x0045
        L_0x008d:
            r6 = r9
            r5 = r10
            r3 = r11
            r4 = r12
            r16 = r8
            r8 = r2
            r2 = r16
        L_0x0096:
            r0.c(r1)
            com.vungle.ads.internal.model.CommonRequestBody r0 = new com.vungle.ads.internal.model.CommonRequestBody
            r9 = r2
            com.vungle.ads.internal.model.DeviceNode r9 = (com.vungle.ads.internal.model.DeviceNode) r9
            r10 = r6
            com.vungle.ads.internal.model.AppNode r10 = (com.vungle.ads.internal.model.AppNode) r10
            r11 = r5
            com.vungle.ads.internal.model.CommonRequestBody$User r11 = (com.vungle.ads.internal.model.CommonRequestBody.User) r11
            r12 = r3
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt r12 = (com.vungle.ads.internal.model.CommonRequestBody.RequestExt) r12
            r13 = r4
            com.vungle.ads.internal.model.CommonRequestBody$RequestParam r13 = (com.vungle.ads.internal.model.CommonRequestBody.RequestParam) r13
            r14 = 0
            r7 = r0
            r7.<init>((int) r8, (com.vungle.ads.internal.model.DeviceNode) r9, (com.vungle.ads.internal.model.AppNode) r10, (com.vungle.ads.internal.model.CommonRequestBody.User) r11, (com.vungle.ads.internal.model.CommonRequestBody.RequestExt) r12, (com.vungle.ads.internal.model.CommonRequestBody.RequestParam) r13, (kotlinx.serialization.internal.SerializationConstructorMarker) r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.CommonRequestBody$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.CommonRequestBody");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CommonRequestBody commonRequestBody) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(commonRequestBody, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        CommonRequestBody.write$Self(commonRequestBody, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

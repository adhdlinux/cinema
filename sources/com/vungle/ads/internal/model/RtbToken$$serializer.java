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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public final class RtbToken$$serializer implements GeneratedSerializer<RtbToken> {
    public static final RtbToken$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        RtbToken$$serializer rtbToken$$serializer = new RtbToken$$serializer();
        INSTANCE = rtbToken$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbToken", rtbToken$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("device", false);
        pluginGeneratedSerialDescriptor.l("user", true);
        pluginGeneratedSerialDescriptor.l("ext", true);
        pluginGeneratedSerialDescriptor.l(AdActivity.REQUEST_KEY_EXTRA, true);
        pluginGeneratedSerialDescriptor.l("ordinal_view", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RtbToken$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DeviceNode$$serializer.INSTANCE, BuiltinSerializersKt.s(CommonRequestBody$User$$serializer.INSTANCE), BuiltinSerializersKt.s(CommonRequestBody$RequestExt$$serializer.INSTANCE), BuiltinSerializersKt.s(RtbRequest$$serializer.INSTANCE), IntSerializer.f41006a};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.RtbToken deserialize(kotlinx.serialization.encoding.Decoder r17) {
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
            if (r2 == 0) goto L_0x003e
            com.vungle.ads.internal.model.DeviceNode$$serializer r2 = com.vungle.ads.internal.model.DeviceNode$$serializer.INSTANCE
            java.lang.Object r2 = r0.y(r1, r7, r2, r8)
            com.vungle.ads.internal.model.CommonRequestBody$User$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$User$$serializer.INSTANCE
            java.lang.Object r6 = r0.n(r1, r6, r7, r8)
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer.INSTANCE
            java.lang.Object r5 = r0.n(r1, r5, r7, r8)
            com.vungle.ads.internal.model.RtbRequest$$serializer r7 = com.vungle.ads.internal.model.RtbRequest$$serializer.INSTANCE
            java.lang.Object r3 = r0.n(r1, r3, r7, r8)
            int r4 = r0.i(r1, r4)
            r7 = 31
            r10 = r4
            r11 = r5
            r5 = 31
            goto L_0x0090
        L_0x003e:
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r2 = 0
            r8 = 0
            r13 = 1
        L_0x0045:
            if (r13 == 0) goto L_0x008b
            int r14 = r0.o(r1)
            r15 = -1
            if (r14 == r15) goto L_0x0089
            if (r14 == 0) goto L_0x0080
            if (r14 == r6) goto L_0x0077
            if (r14 == r5) goto L_0x006e
            if (r14 == r3) goto L_0x0065
            if (r14 != r4) goto L_0x005f
            int r2 = r0.i(r1, r4)
            r8 = r8 | 16
            goto L_0x0045
        L_0x005f:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x0065:
            com.vungle.ads.internal.model.RtbRequest$$serializer r14 = com.vungle.ads.internal.model.RtbRequest$$serializer.INSTANCE
            java.lang.Object r12 = r0.n(r1, r3, r14, r12)
            r8 = r8 | 8
            goto L_0x0045
        L_0x006e:
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer.INSTANCE
            java.lang.Object r11 = r0.n(r1, r5, r14, r11)
            r8 = r8 | 4
            goto L_0x0045
        L_0x0077:
            com.vungle.ads.internal.model.CommonRequestBody$User$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$User$$serializer.INSTANCE
            java.lang.Object r10 = r0.n(r1, r6, r14, r10)
            r8 = r8 | 2
            goto L_0x0045
        L_0x0080:
            com.vungle.ads.internal.model.DeviceNode$$serializer r14 = com.vungle.ads.internal.model.DeviceNode$$serializer.INSTANCE
            java.lang.Object r9 = r0.y(r1, r7, r14, r9)
            r8 = r8 | 1
            goto L_0x0045
        L_0x0089:
            r13 = 0
            goto L_0x0045
        L_0x008b:
            r5 = r8
            r6 = r10
            r3 = r12
            r10 = r2
            r2 = r9
        L_0x0090:
            r0.c(r1)
            com.vungle.ads.internal.model.RtbToken r0 = new com.vungle.ads.internal.model.RtbToken
            r1 = r2
            com.vungle.ads.internal.model.DeviceNode r1 = (com.vungle.ads.internal.model.DeviceNode) r1
            r7 = r6
            com.vungle.ads.internal.model.CommonRequestBody$User r7 = (com.vungle.ads.internal.model.CommonRequestBody.User) r7
            r8 = r11
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt r8 = (com.vungle.ads.internal.model.CommonRequestBody.RequestExt) r8
            r9 = r3
            com.vungle.ads.internal.model.RtbRequest r9 = (com.vungle.ads.internal.model.RtbRequest) r9
            r11 = 0
            r4 = r0
            r6 = r1
            r4.<init>((int) r5, (com.vungle.ads.internal.model.DeviceNode) r6, (com.vungle.ads.internal.model.CommonRequestBody.User) r7, (com.vungle.ads.internal.model.CommonRequestBody.RequestExt) r8, (com.vungle.ads.internal.model.RtbRequest) r9, (int) r10, (kotlinx.serialization.internal.SerializationConstructorMarker) r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.RtbToken$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.RtbToken");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, RtbToken rtbToken) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(rtbToken, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        RtbToken.write$Self(rtbToken, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

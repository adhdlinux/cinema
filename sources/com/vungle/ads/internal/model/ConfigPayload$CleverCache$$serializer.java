package com.vungle.ads.internal.model;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.ConfigPayload;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public final class ConfigPayload$CleverCache$$serializer implements GeneratedSerializer<ConfigPayload.CleverCache> {
    public static final ConfigPayload$CleverCache$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ConfigPayload$CleverCache$$serializer configPayload$CleverCache$$serializer = new ConfigPayload$CleverCache$$serializer();
        INSTANCE = configPayload$CleverCache$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.CleverCache", configPayload$CleverCache$$serializer, 3);
        pluginGeneratedSerialDescriptor.l(ViewProps.ENABLED, true);
        pluginGeneratedSerialDescriptor.l("disk_size", true);
        pluginGeneratedSerialDescriptor.l("disk_percentage", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$CleverCache$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.s(BooleanSerializer.f40947a), BuiltinSerializersKt.s(LongSerializer.f41017a), BuiltinSerializersKt.s(IntSerializer.f41006a)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.ConfigPayload.CleverCache deserialize(kotlinx.serialization.encoding.Decoder r13) {
        /*
            r12 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r12.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r13 = r13.b(r0)
            boolean r1 = r13.p()
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x002c
            kotlinx.serialization.internal.BooleanSerializer r1 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            java.lang.Object r1 = r13.n(r0, r4, r1, r5)
            kotlinx.serialization.internal.LongSerializer r4 = kotlinx.serialization.internal.LongSerializer.f41017a
            java.lang.Object r3 = r13.n(r0, r3, r4, r5)
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r2 = r13.n(r0, r2, r4, r5)
            r4 = 7
            r5 = 7
            goto L_0x0067
        L_0x002c:
            r6 = r5
            r7 = r6
            r1 = 0
            r8 = 1
        L_0x0030:
            if (r8 == 0) goto L_0x0062
            int r9 = r13.o(r0)
            r10 = -1
            if (r9 == r10) goto L_0x0060
            if (r9 == 0) goto L_0x0057
            if (r9 == r3) goto L_0x004e
            if (r9 != r2) goto L_0x0048
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r7 = r13.n(r0, r2, r9, r7)
            r1 = r1 | 4
            goto L_0x0030
        L_0x0048:
            kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
            r13.<init>((int) r9)
            throw r13
        L_0x004e:
            kotlinx.serialization.internal.LongSerializer r9 = kotlinx.serialization.internal.LongSerializer.f41017a
            java.lang.Object r6 = r13.n(r0, r3, r9, r6)
            r1 = r1 | 2
            goto L_0x0030
        L_0x0057:
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            java.lang.Object r5 = r13.n(r0, r4, r9, r5)
            r1 = r1 | 1
            goto L_0x0030
        L_0x0060:
            r8 = 0
            goto L_0x0030
        L_0x0062:
            r3 = r6
            r2 = r7
            r11 = r5
            r5 = r1
            r1 = r11
        L_0x0067:
            r13.c(r0)
            com.vungle.ads.internal.model.ConfigPayload$CleverCache r13 = new com.vungle.ads.internal.model.ConfigPayload$CleverCache
            r6 = r1
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            r7 = r3
            java.lang.Long r7 = (java.lang.Long) r7
            r8 = r2
            java.lang.Integer r8 = (java.lang.Integer) r8
            r9 = 0
            r4 = r13
            r4.<init>((int) r5, (java.lang.Boolean) r6, (java.lang.Long) r7, (java.lang.Integer) r8, (kotlinx.serialization.internal.SerializationConstructorMarker) r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload$CleverCache$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.ConfigPayload$CleverCache");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ConfigPayload.CleverCache cleverCache) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(cleverCache, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        ConfigPayload.CleverCache.write$Self(cleverCache, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.CommonRequestBody;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

public final class CommonRequestBody$GDPR$$serializer implements GeneratedSerializer<CommonRequestBody.GDPR> {
    public static final CommonRequestBody$GDPR$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CommonRequestBody$GDPR$$serializer commonRequestBody$GDPR$$serializer = new CommonRequestBody$GDPR$$serializer();
        INSTANCE = commonRequestBody$GDPR$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.GDPR", commonRequestBody$GDPR$$serializer, 4);
        pluginGeneratedSerialDescriptor.l("consent_status", false);
        pluginGeneratedSerialDescriptor.l("consent_source", false);
        pluginGeneratedSerialDescriptor.l("consent_timestamp", false);
        pluginGeneratedSerialDescriptor.l("consent_message_version", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$GDPR$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{stringSerializer, stringSerializer, LongSerializer.f41017a, stringSerializer};
    }

    public CommonRequestBody.GDPR deserialize(Decoder decoder) {
        String str;
        long j2;
        String str2;
        String str3;
        int i2;
        Decoder decoder2 = decoder;
        Intrinsics.f(decoder2, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder2.b(descriptor2);
        if (b2.p()) {
            String m2 = b2.m(descriptor2, 0);
            String m3 = b2.m(descriptor2, 1);
            long f2 = b2.f(descriptor2, 2);
            str3 = m2;
            str = b2.m(descriptor2, 3);
            str2 = m3;
            j2 = f2;
            i2 = 15;
        } else {
            String str4 = null;
            String str5 = null;
            long j3 = 0;
            int i3 = 0;
            boolean z2 = true;
            String str6 = null;
            while (z2) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    z2 = false;
                } else if (o2 == 0) {
                    str4 = b2.m(descriptor2, 0);
                    i3 |= 1;
                } else if (o2 == 1) {
                    str5 = b2.m(descriptor2, 1);
                    i3 |= 2;
                } else if (o2 == 2) {
                    j3 = b2.f(descriptor2, 2);
                    i3 |= 4;
                } else if (o2 == 3) {
                    str6 = b2.m(descriptor2, 3);
                    i3 |= 8;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            str3 = str4;
            str = str6;
            i2 = i3;
            str2 = str5;
            j2 = j3;
        }
        b2.c(descriptor2);
        return new CommonRequestBody.GDPR(i2, str3, str2, j2, str, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CommonRequestBody.GDPR gdpr) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(gdpr, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        CommonRequestBody.GDPR.write$Self(gdpr, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

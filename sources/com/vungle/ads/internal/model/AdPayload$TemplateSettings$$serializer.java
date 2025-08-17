package com.vungle.ads.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.AdPayload;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

public final class AdPayload$TemplateSettings$$serializer implements GeneratedSerializer<AdPayload.TemplateSettings> {
    public static final AdPayload$TemplateSettings$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$TemplateSettings$$serializer adPayload$TemplateSettings$$serializer = new AdPayload$TemplateSettings$$serializer();
        INSTANCE = adPayload$TemplateSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.TemplateSettings", adPayload$TemplateSettings$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("normal_replacements", true);
        pluginGeneratedSerialDescriptor.l("cacheable_replacements", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$TemplateSettings$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        return new KSerializer[]{BuiltinSerializersKt.s(new LinkedHashMapSerializer(stringSerializer, stringSerializer)), BuiltinSerializersKt.s(new LinkedHashMapSerializer(stringSerializer, AdPayload$CacheableReplacement$$serializer.INSTANCE))};
    }

    public AdPayload.TemplateSettings deserialize(Decoder decoder) {
        int i2;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor2);
        if (b2.p()) {
            StringSerializer stringSerializer = StringSerializer.f41077a;
            obj2 = b2.n(descriptor2, 0, new LinkedHashMapSerializer(stringSerializer, stringSerializer), null);
            obj = b2.n(descriptor2, 1, new LinkedHashMapSerializer(stringSerializer, AdPayload$CacheableReplacement$$serializer.INSTANCE), null);
            i2 = 3;
        } else {
            obj2 = null;
            Object obj3 = null;
            int i3 = 0;
            boolean z2 = true;
            while (z2) {
                int o2 = b2.o(descriptor2);
                if (o2 == -1) {
                    z2 = false;
                } else if (o2 == 0) {
                    StringSerializer stringSerializer2 = StringSerializer.f41077a;
                    obj2 = b2.n(descriptor2, 0, new LinkedHashMapSerializer(stringSerializer2, stringSerializer2), obj2);
                    i3 |= 1;
                } else if (o2 == 1) {
                    obj3 = b2.n(descriptor2, 1, new LinkedHashMapSerializer(StringSerializer.f41077a, AdPayload$CacheableReplacement$$serializer.INSTANCE), obj3);
                    i3 |= 2;
                } else {
                    throw new UnknownFieldException(o2);
                }
            }
            obj = obj3;
            i2 = i3;
        }
        b2.c(descriptor2);
        return new AdPayload.TemplateSettings(i2, (Map) obj2, (Map) obj, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.TemplateSettings templateSettings) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(templateSettings, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.TemplateSettings.write$Self(templateSettings, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

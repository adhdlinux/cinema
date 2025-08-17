package com.vungle.ads.internal.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.GeneratedSerializer;

public final class HttpMethod$$serializer implements GeneratedSerializer<HttpMethod> {
    public static final HttpMethod$$serializer INSTANCE = new HttpMethod$$serializer();
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        EnumDescriptor enumDescriptor = new EnumDescriptor("com.vungle.ads.internal.network.HttpMethod", 2);
        enumDescriptor.l("GET", false);
        enumDescriptor.l("POST", false);
        descriptor = enumDescriptor;
    }

    private HttpMethod$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[0];
    }

    public HttpMethod deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return HttpMethod.values()[decoder.e(getDescriptor())];
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, HttpMethod httpMethod) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(httpMethod, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        encoder.k(getDescriptor(), httpMethod.ordinal());
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}

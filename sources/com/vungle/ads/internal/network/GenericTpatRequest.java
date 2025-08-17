package com.vungle.ads.internal.network;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
public final class GenericTpatRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int attempt;
    private final String body;
    private final Map<String, String> headers;
    private final HttpMethod method;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GenericTpatRequest> serializer() {
            return GenericTpatRequest$$serializer.INSTANCE;
        }
    }

    public GenericTpatRequest() {
        this((HttpMethod) null, (Map) null, (String) null, 0, 15, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ GenericTpatRequest(int i2, HttpMethod httpMethod, Map map, String str, int i3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, GenericTpatRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.method = (i2 & 1) == 0 ? HttpMethod.GET : httpMethod;
        if ((i2 & 2) == 0) {
            this.headers = null;
        } else {
            this.headers = map;
        }
        if ((i2 & 4) == 0) {
            this.body = null;
        } else {
            this.body = str;
        }
        if ((i2 & 8) == 0) {
            this.attempt = 0;
        } else {
            this.attempt = i3;
        }
    }

    public static /* synthetic */ GenericTpatRequest copy$default(GenericTpatRequest genericTpatRequest, HttpMethod httpMethod, Map<String, String> map, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            httpMethod = genericTpatRequest.method;
        }
        if ((i3 & 2) != 0) {
            map = genericTpatRequest.headers;
        }
        if ((i3 & 4) != 0) {
            str = genericTpatRequest.body;
        }
        if ((i3 & 8) != 0) {
            i2 = genericTpatRequest.attempt;
        }
        return genericTpatRequest.copy(httpMethod, map, str, i2);
    }

    public static final void write$Self(GenericTpatRequest genericTpatRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(genericTpatRequest, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z5 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && genericTpatRequest.method == HttpMethod.GET) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.C(serialDescriptor, 0, HttpMethod$$serializer.INSTANCE, genericTpatRequest.method);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && genericTpatRequest.headers == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            StringSerializer stringSerializer = StringSerializer.f41077a;
            compositeEncoder.i(serialDescriptor, 1, new LinkedHashMapSerializer(stringSerializer, stringSerializer), genericTpatRequest.headers);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && genericTpatRequest.body == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f41077a, genericTpatRequest.body);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || genericTpatRequest.attempt != 0) {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.w(serialDescriptor, 3, genericTpatRequest.attempt);
        }
    }

    public final HttpMethod component1() {
        return this.method;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    public final String component3() {
        return this.body;
    }

    public final int component4() {
        return this.attempt;
    }

    public final GenericTpatRequest copy(HttpMethod httpMethod, Map<String, String> map, String str, int i2) {
        Intrinsics.f(httpMethod, "method");
        return new GenericTpatRequest(httpMethod, map, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericTpatRequest)) {
            return false;
        }
        GenericTpatRequest genericTpatRequest = (GenericTpatRequest) obj;
        return this.method == genericTpatRequest.method && Intrinsics.a(this.headers, genericTpatRequest.headers) && Intrinsics.a(this.body, genericTpatRequest.body) && this.attempt == genericTpatRequest.attempt;
    }

    public final int getAttempt() {
        return this.attempt;
    }

    public final String getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        Map<String, String> map = this.headers;
        int i2 = 0;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.body;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((hashCode2 + i2) * 31) + this.attempt;
    }

    public final void setAttempt(int i2) {
        this.attempt = i2;
    }

    public String toString() {
        return "GenericTpatRequest(method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ", attempt=" + this.attempt + ')';
    }

    public GenericTpatRequest(HttpMethod httpMethod, Map<String, String> map, String str, int i2) {
        Intrinsics.f(httpMethod, "method");
        this.method = httpMethod;
        this.headers = map;
        this.body = str;
        this.attempt = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GenericTpatRequest(HttpMethod httpMethod, Map map, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? HttpMethod.GET : httpMethod, (i3 & 2) != 0 ? null : map, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? 0 : i2);
    }
}

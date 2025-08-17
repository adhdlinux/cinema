package com.vungle.ads.internal.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
public final class RtbRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String sdkUserAgent;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<RtbRequest> serializer() {
            return RtbRequest$$serializer.INSTANCE;
        }
    }

    public RtbRequest() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ RtbRequest(int i2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, RtbRequest$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.sdkUserAgent = null;
        } else {
            this.sdkUserAgent = str;
        }
    }

    public static /* synthetic */ RtbRequest copy$default(RtbRequest rtbRequest, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rtbRequest.sdkUserAgent;
        }
        return rtbRequest.copy(str);
    }

    public static /* synthetic */ void getSdkUserAgent$annotations() {
    }

    public static final void write$Self(RtbRequest rtbRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.f(rtbRequest, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z2 = true;
        if (!compositeEncoder.z(serialDescriptor, 0) && rtbRequest.sdkUserAgent == null) {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, rtbRequest.sdkUserAgent);
        }
    }

    public final String component1() {
        return this.sdkUserAgent;
    }

    public final RtbRequest copy(String str) {
        return new RtbRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RtbRequest) && Intrinsics.a(this.sdkUserAgent, ((RtbRequest) obj).sdkUserAgent);
    }

    public final String getSdkUserAgent() {
        return this.sdkUserAgent;
    }

    public int hashCode() {
        String str = this.sdkUserAgent;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "RtbRequest(sdkUserAgent=" + this.sdkUserAgent + ')';
    }

    public RtbRequest(String str) {
        this.sdkUserAgent = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RtbRequest(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }
}

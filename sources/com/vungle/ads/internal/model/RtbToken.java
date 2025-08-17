package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.CommonRequestBody;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Serializable
public final class RtbToken {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeviceNode device;
    private final CommonRequestBody.RequestExt ext;
    private final int ordinalView;
    private final RtbRequest request;
    private final CommonRequestBody.User user;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<RtbToken> serializer() {
            return RtbToken$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RtbToken(int i2, DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i3, SerializationConstructorMarker serializationConstructorMarker) {
        if (17 != (i2 & 17)) {
            PluginExceptionsKt.a(i2, 17, RtbToken$$serializer.INSTANCE.getDescriptor());
        }
        this.device = deviceNode;
        if ((i2 & 2) == 0) {
            this.user = null;
        } else {
            this.user = user2;
        }
        if ((i2 & 4) == 0) {
            this.ext = null;
        } else {
            this.ext = requestExt;
        }
        if ((i2 & 8) == 0) {
            this.request = null;
        } else {
            this.request = rtbRequest;
        }
        this.ordinalView = i3;
    }

    public static /* synthetic */ RtbToken copy$default(RtbToken rtbToken, DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            deviceNode = rtbToken.device;
        }
        if ((i3 & 2) != 0) {
            user2 = rtbToken.user;
        }
        CommonRequestBody.User user3 = user2;
        if ((i3 & 4) != 0) {
            requestExt = rtbToken.ext;
        }
        CommonRequestBody.RequestExt requestExt2 = requestExt;
        if ((i3 & 8) != 0) {
            rtbRequest = rtbToken.request;
        }
        RtbRequest rtbRequest2 = rtbRequest;
        if ((i3 & 16) != 0) {
            i2 = rtbToken.ordinalView;
        }
        return rtbToken.copy(deviceNode, user3, requestExt2, rtbRequest2, i2);
    }

    public static /* synthetic */ void getOrdinalView$annotations() {
    }

    public static final void write$Self(RtbToken rtbToken, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        Intrinsics.f(rtbToken, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z4 = false;
        compositeEncoder.C(serialDescriptor, 0, DeviceNode$$serializer.INSTANCE, rtbToken.device);
        if (!compositeEncoder.z(serialDescriptor, 1) && rtbToken.user == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 1, CommonRequestBody$User$$serializer.INSTANCE, rtbToken.user);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && rtbToken.ext == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 2, CommonRequestBody$RequestExt$$serializer.INSTANCE, rtbToken.ext);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || rtbToken.request != null) {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 3, RtbRequest$$serializer.INSTANCE, rtbToken.request);
        }
        compositeEncoder.w(serialDescriptor, 4, rtbToken.ordinalView);
    }

    public final DeviceNode component1() {
        return this.device;
    }

    public final CommonRequestBody.User component2() {
        return this.user;
    }

    public final CommonRequestBody.RequestExt component3() {
        return this.ext;
    }

    public final RtbRequest component4() {
        return this.request;
    }

    public final int component5() {
        return this.ordinalView;
    }

    public final RtbToken copy(DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2) {
        Intrinsics.f(deviceNode, "device");
        return new RtbToken(deviceNode, user2, requestExt, rtbRequest, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RtbToken)) {
            return false;
        }
        RtbToken rtbToken = (RtbToken) obj;
        return Intrinsics.a(this.device, rtbToken.device) && Intrinsics.a(this.user, rtbToken.user) && Intrinsics.a(this.ext, rtbToken.ext) && Intrinsics.a(this.request, rtbToken.request) && this.ordinalView == rtbToken.ordinalView;
    }

    public final DeviceNode getDevice() {
        return this.device;
    }

    public final CommonRequestBody.RequestExt getExt() {
        return this.ext;
    }

    public final int getOrdinalView() {
        return this.ordinalView;
    }

    public final RtbRequest getRequest() {
        return this.request;
    }

    public final CommonRequestBody.User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.device.hashCode() * 31;
        CommonRequestBody.User user2 = this.user;
        int i2 = 0;
        int hashCode2 = (hashCode + (user2 == null ? 0 : user2.hashCode())) * 31;
        CommonRequestBody.RequestExt requestExt = this.ext;
        int hashCode3 = (hashCode2 + (requestExt == null ? 0 : requestExt.hashCode())) * 31;
        RtbRequest rtbRequest = this.request;
        if (rtbRequest != null) {
            i2 = rtbRequest.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.ordinalView;
    }

    public String toString() {
        return "RtbToken(device=" + this.device + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ", ordinalView=" + this.ordinalView + ')';
    }

    public RtbToken(DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2) {
        Intrinsics.f(deviceNode, "device");
        this.device = deviceNode;
        this.user = user2;
        this.ext = requestExt;
        this.request = rtbRequest;
        this.ordinalView = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RtbToken(DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceNode, (i3 & 2) != 0 ? null : user2, (i3 & 4) != 0 ? null : requestExt, (i3 & 8) != 0 ? null : rtbRequest, i2);
    }
}

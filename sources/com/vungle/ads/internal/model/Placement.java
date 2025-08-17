package com.vungle.ads.internal.model;

import com.vungle.ads.internal.Constants;
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
public final class Placement {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean headerBidding;
    private final String referenceId;
    private final String type;
    private Long wakeupTime;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Placement> serializer() {
            return Placement$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Placement(int i2, String str, boolean z2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i2 & 1)) {
            PluginExceptionsKt.a(i2, 1, Placement$$serializer.INSTANCE.getDescriptor());
        }
        this.referenceId = str;
        if ((i2 & 2) == 0) {
            this.headerBidding = false;
        } else {
            this.headerBidding = z2;
        }
        if ((i2 & 4) == 0) {
            this.type = null;
        } else {
            this.type = str2;
        }
        this.wakeupTime = null;
    }

    public static /* synthetic */ Placement copy$default(Placement placement, String str, boolean z2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = placement.referenceId;
        }
        if ((i2 & 2) != 0) {
            z2 = placement.headerBidding;
        }
        if ((i2 & 4) != 0) {
            str2 = placement.type;
        }
        return placement.copy(str, z2, str2);
    }

    public static /* synthetic */ void getHeaderBidding$annotations() {
    }

    public static /* synthetic */ void getReferenceId$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public static /* synthetic */ void getWakeupTime$annotations() {
    }

    public static final void write$Self(Placement placement, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        Intrinsics.f(placement, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z3 = false;
        compositeEncoder.y(serialDescriptor, 0, placement.referenceId);
        if (!compositeEncoder.z(serialDescriptor, 1) && !placement.headerBidding) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.x(serialDescriptor, 1, placement.headerBidding);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || placement.type != null) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f41077a, placement.type);
        }
    }

    public final String component1() {
        return this.referenceId;
    }

    public final boolean component2() {
        return this.headerBidding;
    }

    public final String component3() {
        return this.type;
    }

    public final Placement copy(String str, boolean z2, String str2) {
        Intrinsics.f(str, "referenceId");
        return new Placement(str, z2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placement)) {
            return false;
        }
        Placement placement = (Placement) obj;
        return Intrinsics.a(this.referenceId, placement.referenceId) && this.headerBidding == placement.headerBidding && Intrinsics.a(this.type, placement.type);
    }

    public final boolean getHeaderBidding() {
        return this.headerBidding;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final String getType() {
        return this.type;
    }

    public final Long getWakeupTime() {
        return this.wakeupTime;
    }

    public int hashCode() {
        int hashCode = this.referenceId.hashCode() * 31;
        boolean z2 = this.headerBidding;
        if (z2) {
            z2 = true;
        }
        int i2 = (hashCode + (z2 ? 1 : 0)) * 31;
        String str = this.type;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isAppOpen() {
        return Intrinsics.a(this.type, Constants.PLACEMENT_TYPE_APP_OPEN);
    }

    public final boolean isBanner() {
        return Intrinsics.a(this.type, "banner");
    }

    public final boolean isInline() {
        return Intrinsics.a(this.type, "in_line");
    }

    public final boolean isInterstitial() {
        return Intrinsics.a(this.type, Constants.PLACEMENT_TYPE_INTERSTITIAL);
    }

    public final boolean isMREC() {
        return Intrinsics.a(this.type, "mrec");
    }

    public final boolean isNative() {
        return Intrinsics.a(this.type, "native");
    }

    public final boolean isRewardedVideo() {
        return Intrinsics.a(this.type, Constants.PLACEMENT_TYPE_REWARDED);
    }

    public final void setWakeupTime(Long l2) {
        this.wakeupTime = l2;
    }

    public final void snooze(long j2) {
        this.wakeupTime = Long.valueOf(System.currentTimeMillis() + (j2 * ((long) 1000)));
    }

    public String toString() {
        return "Placement(referenceId=" + this.referenceId + ", headerBidding=" + this.headerBidding + ", type=" + this.type + ')';
    }

    public Placement(String str, boolean z2, String str2) {
        Intrinsics.f(str, "referenceId");
        this.referenceId = str;
        this.headerBidding = z2;
        this.type = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Placement(String str, boolean z2, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : str2);
    }
}

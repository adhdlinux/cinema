package com.vungle.ads.fpd;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import com.vungle.ads.internal.util.RangeUtil;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;

@Serializable
public final class Revenue {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Float earningsByPlacementUSD;
    private Boolean isUserAPurchaser;
    private Boolean isUserASubscriber;
    private Float last30DaysMeanSpendUSD;
    private Float last30DaysMedianSpendUSD;
    private Float last30DaysPlacementFillRate;
    private Float last30DaysTotalSpendUSD;
    private Float last30DaysUserLtvUSD;
    private Float last30DaysUserPltvUSD;
    private Float last7DaysMeanSpendUSD;
    private Float last7DaysMedianSpendUSD;
    private Float last7DaysPlacementFillRate;
    private Float last7DaysTotalSpendUSD;
    private Float last7DaysUserLtvUSD;
    private Float last7DaysUserPltvUSD;
    private List<String> topNAdomain;
    private Float totalEarningsUSD;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Revenue> serializer() {
            return Revenue$$serializer.INSTANCE;
        }
    }

    public Revenue() {
    }

    private static /* synthetic */ void getEarningsByPlacementUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast30DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast7DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getTopNAdomain$annotations() {
    }

    private static /* synthetic */ void getTotalEarningsUSD$annotations() {
    }

    private static /* synthetic */ void isUserAPurchaser$annotations() {
    }

    private static /* synthetic */ void isUserASubscriber$annotations() {
    }

    public static final void write$Self(Revenue revenue, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Intrinsics.f(revenue, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z18 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && revenue.totalEarningsUSD == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, FloatSerializer.f40997a, revenue.totalEarningsUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && revenue.earningsByPlacementUSD == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, FloatSerializer.f40997a, revenue.earningsByPlacementUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && revenue.topNAdomain == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, new ArrayListSerializer(StringSerializer.f41077a), revenue.topNAdomain);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && revenue.isUserAPurchaser == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 3, BooleanSerializer.f40947a, revenue.isUserAPurchaser);
        }
        if (!compositeEncoder.z(serialDescriptor, 4) && revenue.isUserASubscriber == null) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            compositeEncoder.i(serialDescriptor, 4, BooleanSerializer.f40947a, revenue.isUserASubscriber);
        }
        if (!compositeEncoder.z(serialDescriptor, 5) && revenue.last7DaysTotalSpendUSD == null) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            compositeEncoder.i(serialDescriptor, 5, FloatSerializer.f40997a, revenue.last7DaysTotalSpendUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 6) && revenue.last7DaysMedianSpendUSD == null) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8) {
            compositeEncoder.i(serialDescriptor, 6, FloatSerializer.f40997a, revenue.last7DaysMedianSpendUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 7) && revenue.last7DaysMeanSpendUSD == null) {
            z9 = false;
        } else {
            z9 = true;
        }
        if (z9) {
            compositeEncoder.i(serialDescriptor, 7, FloatSerializer.f40997a, revenue.last7DaysMeanSpendUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && revenue.last30DaysTotalSpendUSD == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            compositeEncoder.i(serialDescriptor, 8, FloatSerializer.f40997a, revenue.last30DaysTotalSpendUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && revenue.last30DaysMedianSpendUSD == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.i(serialDescriptor, 9, FloatSerializer.f40997a, revenue.last30DaysMedianSpendUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 10) && revenue.last30DaysMeanSpendUSD == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.i(serialDescriptor, 10, FloatSerializer.f40997a, revenue.last30DaysMeanSpendUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 11) && revenue.last7DaysUserPltvUSD == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.i(serialDescriptor, 11, FloatSerializer.f40997a, revenue.last7DaysUserPltvUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 12) && revenue.last7DaysUserLtvUSD == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.i(serialDescriptor, 12, FloatSerializer.f40997a, revenue.last7DaysUserLtvUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 13) && revenue.last30DaysUserPltvUSD == null) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.i(serialDescriptor, 13, FloatSerializer.f40997a, revenue.last30DaysUserPltvUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 14) && revenue.last30DaysUserLtvUSD == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.i(serialDescriptor, 14, FloatSerializer.f40997a, revenue.last30DaysUserLtvUSD);
        }
        if (!compositeEncoder.z(serialDescriptor, 15) && revenue.last7DaysPlacementFillRate == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.i(serialDescriptor, 15, FloatSerializer.f40997a, revenue.last7DaysPlacementFillRate);
        }
        if (compositeEncoder.z(serialDescriptor, 16) || revenue.last30DaysPlacementFillRate != null) {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.i(serialDescriptor, 16, FloatSerializer.f40997a, revenue.last30DaysPlacementFillRate);
        }
    }

    public final Revenue setEarningsByPlacement(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.earningsByPlacementUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setIsUserAPurchaser(boolean z2) {
        this.isUserAPurchaser = Boolean.valueOf(z2);
        return this;
    }

    public final Revenue setIsUserASubscriber(boolean z2) {
        this.isUserASubscriber = Boolean.valueOf(z2);
        return this;
    }

    public final Revenue setLast30DaysMeanSpendUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMeanSpendUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast30DaysMedianSpendUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMedianSpendUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast30DaysPlacementFillRate(float f2) {
        if (RangeUtil.INSTANCE.isInRange(f2, 0.0f, 100.0f)) {
            this.last30DaysPlacementFillRate = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast30DaysTotalSpendUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysTotalSpendUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast30DaysUserLtvUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserLtvUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast30DaysUserPltvUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserPltvUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast7DaysMeanSpendUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMeanSpendUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast7DaysMedianSpendUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMedianSpendUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast7DaysPlacementFillRate(float f2) {
        if (RangeUtil.INSTANCE.isInRange(f2, 0.0f, 100.0f)) {
            this.last7DaysPlacementFillRate = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast7DaysTotalSpendUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysTotalSpendUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast7DaysUserLtvUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserLtvUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setLast7DaysUserPltvUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserPltvUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final Revenue setTopNAdomain(List<String> list) {
        this.topNAdomain = list != null ? CollectionsKt___CollectionsKt.c0(list) : null;
        return this;
    }

    public final Revenue setTotalEarningsUsd(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.totalEarningsUSD = Float.valueOf(f2);
        }
        return this;
    }

    public /* synthetic */ Revenue(int i2, Float f2, Float f3, List list, Boolean bool, Boolean bool2, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, Float f10, Float f11, Float f12, Float f13, Float f14, Float f15, SerializationConstructorMarker serializationConstructorMarker) {
        int i3 = i2;
        if ((i3 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, Revenue$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.totalEarningsUSD = null;
        } else {
            this.totalEarningsUSD = f2;
        }
        if ((i3 & 2) == 0) {
            this.earningsByPlacementUSD = null;
        } else {
            this.earningsByPlacementUSD = f3;
        }
        if ((i3 & 4) == 0) {
            this.topNAdomain = null;
        } else {
            this.topNAdomain = list;
        }
        if ((i3 & 8) == 0) {
            this.isUserAPurchaser = null;
        } else {
            this.isUserAPurchaser = bool;
        }
        if ((i3 & 16) == 0) {
            this.isUserASubscriber = null;
        } else {
            this.isUserASubscriber = bool2;
        }
        if ((i3 & 32) == 0) {
            this.last7DaysTotalSpendUSD = null;
        } else {
            this.last7DaysTotalSpendUSD = f4;
        }
        if ((i3 & 64) == 0) {
            this.last7DaysMedianSpendUSD = null;
        } else {
            this.last7DaysMedianSpendUSD = f5;
        }
        if ((i3 & 128) == 0) {
            this.last7DaysMeanSpendUSD = null;
        } else {
            this.last7DaysMeanSpendUSD = f6;
        }
        if ((i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0) {
            this.last30DaysTotalSpendUSD = null;
        } else {
            this.last30DaysTotalSpendUSD = f7;
        }
        if ((i3 & 512) == 0) {
            this.last30DaysMedianSpendUSD = null;
        } else {
            this.last30DaysMedianSpendUSD = f8;
        }
        if ((i3 & 1024) == 0) {
            this.last30DaysMeanSpendUSD = null;
        } else {
            this.last30DaysMeanSpendUSD = f9;
        }
        if ((i3 & 2048) == 0) {
            this.last7DaysUserPltvUSD = null;
        } else {
            this.last7DaysUserPltvUSD = f10;
        }
        if ((i3 & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0) {
            this.last7DaysUserLtvUSD = null;
        } else {
            this.last7DaysUserLtvUSD = f11;
        }
        if ((i3 & 8192) == 0) {
            this.last30DaysUserPltvUSD = null;
        } else {
            this.last30DaysUserPltvUSD = f12;
        }
        if ((i3 & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.last30DaysUserLtvUSD = null;
        } else {
            this.last30DaysUserLtvUSD = f13;
        }
        if ((32768 & i3) == 0) {
            this.last7DaysPlacementFillRate = null;
        } else {
            this.last7DaysPlacementFillRate = f14;
        }
        if ((i3 & 65536) == 0) {
            this.last30DaysPlacementFillRate = null;
        } else {
            this.last30DaysPlacementFillRate = f15;
        }
    }
}

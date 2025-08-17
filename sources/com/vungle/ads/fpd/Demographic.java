package com.vungle.ads.fpd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Serializable
public final class Demographic {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Integer ageRange;
    private Integer lengthOfResidence;
    private Integer medianHomeValueUSD;
    private Integer monthlyHousingPaymentUSD;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Demographic> serializer() {
            return Demographic$$serializer.INSTANCE;
        }
    }

    public Demographic() {
    }

    private static /* synthetic */ void getAgeRange$annotations() {
    }

    private static /* synthetic */ void getLengthOfResidence$annotations() {
    }

    private static /* synthetic */ void getMedianHomeValueUSD$annotations() {
    }

    private static /* synthetic */ void getMonthlyHousingPaymentUSD$annotations() {
    }

    public static final void write$Self(Demographic demographic, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(demographic, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z5 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && demographic.ageRange == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, IntSerializer.f41006a, demographic.ageRange);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && demographic.lengthOfResidence == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, IntSerializer.f41006a, demographic.lengthOfResidence);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && demographic.medianHomeValueUSD == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, IntSerializer.f41006a, demographic.medianHomeValueUSD);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || demographic.monthlyHousingPaymentUSD != null) {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 3, IntSerializer.f41006a, demographic.monthlyHousingPaymentUSD);
        }
    }

    public final Demographic setAgeRange(int i2) {
        this.ageRange = Integer.valueOf(AgeRange.Companion.fromAge$vungle_ads_release(i2).getId());
        return this;
    }

    public final Demographic setLengthOfResidence(int i2) {
        this.lengthOfResidence = Integer.valueOf(LengthOfResidence.Companion.fromYears$vungle_ads_release(i2).getId());
        return this;
    }

    public final Demographic setMedianHomeValueUSD(int i2) {
        this.medianHomeValueUSD = Integer.valueOf(MedianHomeValueUSD.Companion.fromPrice$vungle_ads_release(i2).getId());
        return this;
    }

    public final Demographic setMonthlyHousingCosts(int i2) {
        this.monthlyHousingPaymentUSD = Integer.valueOf(MonthlyHousingCosts.Companion.fromCost$vungle_ads_release(i2).getId());
        return this;
    }

    public /* synthetic */ Demographic(int i2, Integer num, Integer num2, Integer num3, Integer num4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, Demographic$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.ageRange = null;
        } else {
            this.ageRange = num;
        }
        if ((i2 & 2) == 0) {
            this.lengthOfResidence = null;
        } else {
            this.lengthOfResidence = num2;
        }
        if ((i2 & 4) == 0) {
            this.medianHomeValueUSD = null;
        } else {
            this.medianHomeValueUSD = num3;
        }
        if ((i2 & 8) == 0) {
            this.monthlyHousingPaymentUSD = null;
        } else {
            this.monthlyHousingPaymentUSD = num4;
        }
    }
}

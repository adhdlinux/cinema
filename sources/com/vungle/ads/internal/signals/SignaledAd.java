package com.vungle.ads.internal.signals;

import b0.y;
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
public final class SignaledAd {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private long adAvailabilityCallbackTime;
    private String eventId;
    private final Long lastAdLoadTime;
    private final long loadAdTime;
    private long playAdTime;
    private int screenOrientation;
    private String templateSignals;
    private long timeBetweenAdAvailabilityAndPlayAd;
    private final long timeSinceLastAdLoad;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SignaledAd> serializer() {
            return SignaledAd$$serializer.INSTANCE;
        }
    }

    public SignaledAd() {
        this((Long) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SignaledAd(int i2, String str, long j2, String str2, long j3, int i3, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i2 & 2)) {
            PluginExceptionsKt.a(i2, 2, SignaledAd$$serializer.INSTANCE.getDescriptor());
        }
        this.lastAdLoadTime = 0L;
        this.loadAdTime = 0;
        if ((i2 & 1) == 0) {
            this.templateSignals = null;
        } else {
            this.templateSignals = str;
        }
        this.timeSinceLastAdLoad = j2;
        if ((i2 & 4) == 0) {
            this.eventId = null;
        } else {
            this.eventId = str2;
        }
        if ((i2 & 8) == 0) {
            this.timeBetweenAdAvailabilityAndPlayAd = 0;
        } else {
            this.timeBetweenAdAvailabilityAndPlayAd = j3;
        }
        if ((i2 & 16) == 0) {
            this.screenOrientation = 0;
        } else {
            this.screenOrientation = i3;
        }
        this.adAvailabilityCallbackTime = 0;
        this.playAdTime = 0;
        this.timeSinceLastAdLoad = getTimeDifference(0L, 0);
    }

    public static /* synthetic */ SignaledAd copy$default(SignaledAd signaledAd, Long l2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l2 = signaledAd.lastAdLoadTime;
        }
        if ((i2 & 2) != 0) {
            j2 = signaledAd.loadAdTime;
        }
        return signaledAd.copy(l2, j2);
    }

    public static /* synthetic */ void getAdAvailabilityCallbackTime$annotations() {
    }

    public static /* synthetic */ void getEventId$annotations() {
    }

    public static /* synthetic */ void getLastAdLoadTime$annotations() {
    }

    public static /* synthetic */ void getLoadAdTime$annotations() {
    }

    public static /* synthetic */ void getPlayAdTime$annotations() {
    }

    public static /* synthetic */ void getScreenOrientation$annotations() {
    }

    public static /* synthetic */ void getTemplateSignals$annotations() {
    }

    public static /* synthetic */ void getTimeBetweenAdAvailabilityAndPlayAd$annotations() {
    }

    private final long getTimeDifference(Long l2, long j2) {
        if (l2 == null) {
            return -1;
        }
        long longValue = j2 - l2.longValue();
        if (longValue < 0) {
            return -1;
        }
        return longValue;
    }

    public static /* synthetic */ void getTimeSinceLastAdLoad$annotations() {
    }

    public static final void write$Self(SignaledAd signaledAd, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(signaledAd, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z5 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && signaledAd.templateSignals == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, signaledAd.templateSignals);
        }
        compositeEncoder.F(serialDescriptor, 1, signaledAd.timeSinceLastAdLoad);
        if (!compositeEncoder.z(serialDescriptor, 2) && signaledAd.eventId == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f41077a, signaledAd.eventId);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && signaledAd.timeBetweenAdAvailabilityAndPlayAd == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.F(serialDescriptor, 3, signaledAd.timeBetweenAdAvailabilityAndPlayAd);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || signaledAd.screenOrientation != 0) {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.w(serialDescriptor, 4, signaledAd.screenOrientation);
        }
    }

    public final void calculateTimeBetweenAdAvailabilityAndPlayAd() {
        this.timeBetweenAdAvailabilityAndPlayAd = getTimeDifference(Long.valueOf(this.adAvailabilityCallbackTime), this.playAdTime);
    }

    public final Long component1() {
        return this.lastAdLoadTime;
    }

    public final long component2() {
        return this.loadAdTime;
    }

    public final SignaledAd copy(Long l2, long j2) {
        return new SignaledAd(l2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignaledAd)) {
            return false;
        }
        SignaledAd signaledAd = (SignaledAd) obj;
        return Intrinsics.a(this.lastAdLoadTime, signaledAd.lastAdLoadTime) && this.loadAdTime == signaledAd.loadAdTime;
    }

    public final long getAdAvailabilityCallbackTime() {
        return this.adAvailabilityCallbackTime;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final Long getLastAdLoadTime() {
        return this.lastAdLoadTime;
    }

    public final long getLoadAdTime() {
        return this.loadAdTime;
    }

    public final long getPlayAdTime() {
        return this.playAdTime;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    public final String getTemplateSignals() {
        return this.templateSignals;
    }

    public final long getTimeBetweenAdAvailabilityAndPlayAd() {
        return this.timeBetweenAdAvailabilityAndPlayAd;
    }

    public final long getTimeSinceLastAdLoad() {
        return this.timeSinceLastAdLoad;
    }

    public int hashCode() {
        Long l2 = this.lastAdLoadTime;
        return ((l2 == null ? 0 : l2.hashCode()) * 31) + y.a(this.loadAdTime);
    }

    public final void setAdAvailabilityCallbackTime(long j2) {
        this.adAvailabilityCallbackTime = j2;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    public final void setPlayAdTime(long j2) {
        this.playAdTime = j2;
    }

    public final void setScreenOrientation(int i2) {
        this.screenOrientation = i2;
    }

    public final void setTemplateSignals(String str) {
        this.templateSignals = str;
    }

    public final void setTimeBetweenAdAvailabilityAndPlayAd(long j2) {
        this.timeBetweenAdAvailabilityAndPlayAd = j2;
    }

    public String toString() {
        return "SignaledAd(lastAdLoadTime=" + this.lastAdLoadTime + ", loadAdTime=" + this.loadAdTime + ')';
    }

    public SignaledAd(Long l2, long j2) {
        this.lastAdLoadTime = l2;
        this.loadAdTime = j2;
        this.timeSinceLastAdLoad = getTimeDifference(l2, j2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SignaledAd(Long l2, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : l2, (i2 & 2) != 0 ? 0 : j2);
    }
}

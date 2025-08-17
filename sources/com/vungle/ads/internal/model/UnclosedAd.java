package com.vungle.ads.internal.model;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Serializable
public final class UnclosedAd {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String eventId;
    private String sessionId;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UnclosedAd> serializer() {
            return UnclosedAd$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UnclosedAd(int i2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i2 & 1)) {
            PluginExceptionsKt.a(i2, 1, UnclosedAd$$serializer.INSTANCE.getDescriptor());
        }
        this.eventId = str;
        if ((i2 & 2) == 0) {
            this.sessionId = "";
        } else {
            this.sessionId = str2;
        }
    }

    public static /* synthetic */ UnclosedAd copy$default(UnclosedAd unclosedAd, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = unclosedAd.eventId;
        }
        if ((i2 & 2) != 0) {
            str2 = unclosedAd.sessionId;
        }
        return unclosedAd.copy(str, str2);
    }

    public static /* synthetic */ void getEventId$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    public static final void write$Self(UnclosedAd unclosedAd, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.f(unclosedAd, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z2 = false;
        compositeEncoder.y(serialDescriptor, 0, unclosedAd.eventId);
        if (compositeEncoder.z(serialDescriptor, 1) || !Intrinsics.a(unclosedAd.sessionId, "")) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.y(serialDescriptor, 1, unclosedAd.sessionId);
        }
    }

    public final String component1() {
        return this.eventId;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final UnclosedAd copy(String str, String str2) {
        Intrinsics.f(str, "eventId");
        Intrinsics.f(str2, JsonStorageKeyNames.SESSION_ID_KEY);
        return new UnclosedAd(str, str2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !Intrinsics.a(UnclosedAd.class, obj.getClass())) {
            return false;
        }
        UnclosedAd unclosedAd = (UnclosedAd) obj;
        if (!Intrinsics.a(this.eventId, unclosedAd.eventId) || !Intrinsics.a(this.sessionId, unclosedAd.sessionId)) {
            return false;
        }
        return true;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (this.eventId.hashCode() * 31) + this.sessionId.hashCode();
    }

    public final void setSessionId(String str) {
        Intrinsics.f(str, "<set-?>");
        this.sessionId = str;
    }

    public String toString() {
        return "UnclosedAd(eventId=" + this.eventId + ", sessionId=" + this.sessionId + ')';
    }

    public UnclosedAd(String str, String str2) {
        Intrinsics.f(str, "eventId");
        Intrinsics.f(str2, JsonStorageKeyNames.SESSION_ID_KEY);
        this.eventId = str;
        this.sessionId = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnclosedAd(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2);
    }
}

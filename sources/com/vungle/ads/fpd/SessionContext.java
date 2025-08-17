package com.vungle.ads.fpd;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.util.RangeUtil;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
public final class SessionContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private List<String> friends;
    private Float healthPercentile;
    private Float inGamePurchasesUSD;
    private Float levelPercentile;
    private String page;
    private Integer sessionDuration;
    private Integer sessionStartTime;
    private Integer signupDate;
    private Integer timeSpent;
    private String userID;
    private Float userLevelPercentile;
    private Float userScorePercentile;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SessionContext> serializer() {
            return SessionContext$$serializer.INSTANCE;
        }
    }

    public SessionContext() {
    }

    private static /* synthetic */ void getFriends$annotations() {
    }

    private static /* synthetic */ void getHealthPercentile$annotations() {
    }

    private static /* synthetic */ void getInGamePurchasesUSD$annotations() {
    }

    private static /* synthetic */ void getLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getPage$annotations() {
    }

    private static /* synthetic */ void getSessionDuration$annotations() {
    }

    private static /* synthetic */ void getSessionStartTime$annotations() {
    }

    private static /* synthetic */ void getSignupDate$annotations() {
    }

    private static /* synthetic */ void getTimeSpent$annotations() {
    }

    private static /* synthetic */ void getUserID$annotations() {
    }

    private static /* synthetic */ void getUserLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getUserScorePercentile$annotations() {
    }

    public static final void write$Self(SessionContext sessionContext, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
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
        Intrinsics.f(sessionContext, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z13 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && sessionContext.levelPercentile == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, FloatSerializer.f40997a, sessionContext.levelPercentile);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && sessionContext.page == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, sessionContext.page);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && sessionContext.timeSpent == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, IntSerializer.f41006a, sessionContext.timeSpent);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && sessionContext.signupDate == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 3, IntSerializer.f41006a, sessionContext.signupDate);
        }
        if (!compositeEncoder.z(serialDescriptor, 4) && sessionContext.userScorePercentile == null) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            compositeEncoder.i(serialDescriptor, 4, FloatSerializer.f40997a, sessionContext.userScorePercentile);
        }
        if (!compositeEncoder.z(serialDescriptor, 5) && sessionContext.userID == null) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            compositeEncoder.i(serialDescriptor, 5, StringSerializer.f41077a, sessionContext.userID);
        }
        if (!compositeEncoder.z(serialDescriptor, 6) && sessionContext.friends == null) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8) {
            compositeEncoder.i(serialDescriptor, 6, new ArrayListSerializer(StringSerializer.f41077a), sessionContext.friends);
        }
        if (!compositeEncoder.z(serialDescriptor, 7) && sessionContext.userLevelPercentile == null) {
            z9 = false;
        } else {
            z9 = true;
        }
        if (z9) {
            compositeEncoder.i(serialDescriptor, 7, FloatSerializer.f40997a, sessionContext.userLevelPercentile);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && sessionContext.healthPercentile == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            compositeEncoder.i(serialDescriptor, 8, FloatSerializer.f40997a, sessionContext.healthPercentile);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && sessionContext.sessionStartTime == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.i(serialDescriptor, 9, IntSerializer.f41006a, sessionContext.sessionStartTime);
        }
        if (!compositeEncoder.z(serialDescriptor, 10) && sessionContext.sessionDuration == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.i(serialDescriptor, 10, IntSerializer.f41006a, sessionContext.sessionDuration);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || sessionContext.inGamePurchasesUSD != null) {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.i(serialDescriptor, 11, FloatSerializer.f40997a, sessionContext.inGamePurchasesUSD);
        }
    }

    public final SessionContext setFriends(List<String> list) {
        this.friends = list != null ? CollectionsKt___CollectionsKt.c0(list) : null;
        return this;
    }

    public final SessionContext setHealthPercentile(float f2) {
        if (RangeUtil.INSTANCE.isInRange(f2, 0.0f, 100.0f)) {
            this.healthPercentile = Float.valueOf(f2);
        }
        return this;
    }

    public final SessionContext setInGamePurchasesUSD(float f2) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f2, 0.0f, 0.0f, 4, (Object) null)) {
            this.inGamePurchasesUSD = Float.valueOf(f2);
        }
        return this;
    }

    public final SessionContext setLevelPercentile(float f2) {
        if (RangeUtil.INSTANCE.isInRange(f2, 0.0f, 100.0f)) {
            this.levelPercentile = Float.valueOf(f2);
        }
        return this;
    }

    public final SessionContext setPage(String str) {
        Intrinsics.f(str, "page");
        this.page = str;
        return this;
    }

    public final SessionContext setSessionDuration(int i2) {
        this.sessionDuration = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setSessionStartTime(int i2) {
        this.sessionStartTime = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setSignupDate(int i2) {
        this.signupDate = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setTimeSpent(int i2) {
        this.timeSpent = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setUserID(String str) {
        Intrinsics.f(str, "userID");
        this.userID = str;
        return this;
    }

    public final SessionContext setUserLevelPercentile(float f2) {
        if (RangeUtil.INSTANCE.isInRange(f2, 0.0f, 100.0f)) {
            this.userLevelPercentile = Float.valueOf(f2);
        }
        return this;
    }

    public final SessionContext setUserScorePercentile(float f2) {
        if (RangeUtil.INSTANCE.isInRange(f2, 0.0f, 100.0f)) {
            this.userScorePercentile = Float.valueOf(f2);
        }
        return this;
    }

    public /* synthetic */ SessionContext(int i2, Float f2, String str, Integer num, Integer num2, Float f3, String str2, List list, Float f4, Float f5, Integer num3, Integer num4, Float f6, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, SessionContext$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.levelPercentile = null;
        } else {
            this.levelPercentile = f2;
        }
        if ((i2 & 2) == 0) {
            this.page = null;
        } else {
            this.page = str;
        }
        if ((i2 & 4) == 0) {
            this.timeSpent = null;
        } else {
            this.timeSpent = num;
        }
        if ((i2 & 8) == 0) {
            this.signupDate = null;
        } else {
            this.signupDate = num2;
        }
        if ((i2 & 16) == 0) {
            this.userScorePercentile = null;
        } else {
            this.userScorePercentile = f3;
        }
        if ((i2 & 32) == 0) {
            this.userID = null;
        } else {
            this.userID = str2;
        }
        if ((i2 & 64) == 0) {
            this.friends = null;
        } else {
            this.friends = list;
        }
        if ((i2 & 128) == 0) {
            this.userLevelPercentile = null;
        } else {
            this.userLevelPercentile = f4;
        }
        if ((i2 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0) {
            this.healthPercentile = null;
        } else {
            this.healthPercentile = f5;
        }
        if ((i2 & 512) == 0) {
            this.sessionStartTime = null;
        } else {
            this.sessionStartTime = num3;
        }
        if ((i2 & 1024) == 0) {
            this.sessionDuration = null;
        } else {
            this.sessionDuration = num4;
        }
        if ((i2 & 2048) == 0) {
            this.inGamePurchasesUSD = null;
        } else {
            this.inGamePurchasesUSD = f6;
        }
    }
}

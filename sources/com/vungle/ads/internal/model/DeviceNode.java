package com.vungle.ads.internal.model;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;

@Serializable
public final class DeviceNode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String carrier;
    private VungleExt ext;

    /* renamed from: h  reason: collision with root package name */
    private final int f37887h;
    private String ifa;
    private Integer lmt;
    private final String make;
    private final String model;
    private final String os;
    private final String osv;
    private String ua;

    /* renamed from: w  reason: collision with root package name */
    private final int f37888w;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DeviceNode> serializer() {
            return DeviceNode$$serializer.INSTANCE;
        }
    }

    @Serializable
    public static final class VungleExt {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String amazonAdvertisingId;
        private String appSetId;
        private Integer appSetIdScope;
        private float batteryLevel;
        private int batterySaverEnabled;
        private String batteryState;
        private String connectionType;
        private String connectionTypeDetail;
        private String gaid;
        private boolean isGooglePlayServicesAvailable;
        private boolean isSideloadEnabled;
        private boolean isTv;
        private String language;
        private String locale;
        private int sdCardAvailable;
        private int soundEnabled;
        private String timeZone;
        private float volumeLevel;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<VungleExt> serializer() {
                return DeviceNode$VungleExt$$serializer.INSTANCE;
            }
        }

        public VungleExt() {
            this(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, 262143, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ VungleExt(int i2, boolean z2, String str, Integer num, float f2, String str2, int i3, String str3, String str4, String str5, String str6, String str7, float f3, int i4, boolean z3, int i5, boolean z4, String str8, String str9, SerializationConstructorMarker serializationConstructorMarker) {
            int i6 = i2;
            if ((i6 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, DeviceNode$VungleExt$$serializer.INSTANCE.getDescriptor());
            }
            if ((i6 & 1) == 0) {
                this.isGooglePlayServicesAvailable = false;
            } else {
                this.isGooglePlayServicesAvailable = z2;
            }
            if ((i6 & 2) == 0) {
                this.appSetId = null;
            } else {
                this.appSetId = str;
            }
            if ((i6 & 4) == 0) {
                this.appSetIdScope = null;
            } else {
                this.appSetIdScope = num;
            }
            if ((i6 & 8) == 0) {
                this.batteryLevel = 0.0f;
            } else {
                this.batteryLevel = f2;
            }
            if ((i6 & 16) == 0) {
                this.batteryState = null;
            } else {
                this.batteryState = str2;
            }
            if ((i6 & 32) == 0) {
                this.batterySaverEnabled = 0;
            } else {
                this.batterySaverEnabled = i3;
            }
            if ((i6 & 64) == 0) {
                this.connectionType = null;
            } else {
                this.connectionType = str3;
            }
            if ((i6 & 128) == 0) {
                this.connectionTypeDetail = null;
            } else {
                this.connectionTypeDetail = str4;
            }
            if ((i6 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0) {
                this.locale = null;
            } else {
                this.locale = str5;
            }
            if ((i6 & 512) == 0) {
                this.language = null;
            } else {
                this.language = str6;
            }
            if ((i6 & 1024) == 0) {
                this.timeZone = null;
            } else {
                this.timeZone = str7;
            }
            if ((i6 & 2048) == 0) {
                this.volumeLevel = 0.0f;
            } else {
                this.volumeLevel = f3;
            }
            if ((i6 & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0) {
                this.soundEnabled = 1;
            } else {
                this.soundEnabled = i4;
            }
            if ((i6 & 8192) == 0) {
                this.isTv = false;
            } else {
                this.isTv = z3;
            }
            if ((i6 & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                this.sdCardAvailable = 1;
            } else {
                this.sdCardAvailable = i5;
            }
            if ((32768 & i6) == 0) {
                this.isSideloadEnabled = false;
            } else {
                this.isSideloadEnabled = z4;
            }
            if ((65536 & i6) == 0) {
                this.gaid = null;
            } else {
                this.gaid = str8;
            }
            if ((i6 & 131072) == 0) {
                this.amazonAdvertisingId = null;
            } else {
                this.amazonAdvertisingId = str9;
            }
        }

        public static /* synthetic */ VungleExt copy$default(VungleExt vungleExt, boolean z2, String str, Integer num, float f2, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f3, int i3, boolean z3, int i4, boolean z4, String str8, String str9, int i5, Object obj) {
            VungleExt vungleExt2 = vungleExt;
            int i6 = i5;
            return vungleExt.copy((i6 & 1) != 0 ? vungleExt2.isGooglePlayServicesAvailable : z2, (i6 & 2) != 0 ? vungleExt2.appSetId : str, (i6 & 4) != 0 ? vungleExt2.appSetIdScope : num, (i6 & 8) != 0 ? vungleExt2.batteryLevel : f2, (i6 & 16) != 0 ? vungleExt2.batteryState : str2, (i6 & 32) != 0 ? vungleExt2.batterySaverEnabled : i2, (i6 & 64) != 0 ? vungleExt2.connectionType : str3, (i6 & 128) != 0 ? vungleExt2.connectionTypeDetail : str4, (i6 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? vungleExt2.locale : str5, (i6 & 512) != 0 ? vungleExt2.language : str6, (i6 & 1024) != 0 ? vungleExt2.timeZone : str7, (i6 & 2048) != 0 ? vungleExt2.volumeLevel : f3, (i6 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? vungleExt2.soundEnabled : i3, (i6 & 8192) != 0 ? vungleExt2.isTv : z3, (i6 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? vungleExt2.sdCardAvailable : i4, (i6 & 32768) != 0 ? vungleExt2.isSideloadEnabled : z4, (i6 & 65536) != 0 ? vungleExt2.gaid : str8, (i6 & 131072) != 0 ? vungleExt2.amazonAdvertisingId : str9);
        }

        public static /* synthetic */ void getAmazonAdvertisingId$annotations() {
        }

        public static /* synthetic */ void getAppSetId$annotations() {
        }

        public static /* synthetic */ void getAppSetIdScope$annotations() {
        }

        public static /* synthetic */ void getBatteryLevel$annotations() {
        }

        public static /* synthetic */ void getBatterySaverEnabled$annotations() {
        }

        public static /* synthetic */ void getBatteryState$annotations() {
        }

        public static /* synthetic */ void getConnectionType$annotations() {
        }

        public static /* synthetic */ void getConnectionTypeDetail$annotations() {
        }

        public static /* synthetic */ void getGaid$annotations() {
        }

        public static /* synthetic */ void getLanguage$annotations() {
        }

        public static /* synthetic */ void getLocale$annotations() {
        }

        public static /* synthetic */ void getSdCardAvailable$annotations() {
        }

        public static /* synthetic */ void getSoundEnabled$annotations() {
        }

        public static /* synthetic */ void getTimeZone$annotations() {
        }

        public static /* synthetic */ void getVolumeLevel$annotations() {
        }

        public static /* synthetic */ void isGooglePlayServicesAvailable$annotations() {
        }

        public static /* synthetic */ void isSideloadEnabled$annotations() {
        }

        public static /* synthetic */ void isTv$annotations() {
        }

        public static final void write$Self(VungleExt vungleExt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
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
            boolean z18;
            Intrinsics.f(vungleExt, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z19 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && !vungleExt.isGooglePlayServicesAvailable) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.x(serialDescriptor, 0, vungleExt.isGooglePlayServicesAvailable);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && vungleExt.appSetId == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, vungleExt.appSetId);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && vungleExt.appSetIdScope == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, IntSerializer.f41006a, vungleExt.appSetIdScope);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && Intrinsics.a(Float.valueOf(vungleExt.batteryLevel), Float.valueOf(0.0f))) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                compositeEncoder.s(serialDescriptor, 3, vungleExt.batteryLevel);
            }
            if (!compositeEncoder.z(serialDescriptor, 4) && vungleExt.batteryState == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z6) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f41077a, vungleExt.batteryState);
            }
            if (!compositeEncoder.z(serialDescriptor, 5) && vungleExt.batterySaverEnabled == 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                compositeEncoder.w(serialDescriptor, 5, vungleExt.batterySaverEnabled);
            }
            if (!compositeEncoder.z(serialDescriptor, 6) && vungleExt.connectionType == null) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (z8) {
                compositeEncoder.i(serialDescriptor, 6, StringSerializer.f41077a, vungleExt.connectionType);
            }
            if (!compositeEncoder.z(serialDescriptor, 7) && vungleExt.connectionTypeDetail == null) {
                z9 = false;
            } else {
                z9 = true;
            }
            if (z9) {
                compositeEncoder.i(serialDescriptor, 7, StringSerializer.f41077a, vungleExt.connectionTypeDetail);
            }
            if (!compositeEncoder.z(serialDescriptor, 8) && vungleExt.locale == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                compositeEncoder.i(serialDescriptor, 8, StringSerializer.f41077a, vungleExt.locale);
            }
            if (!compositeEncoder.z(serialDescriptor, 9) && vungleExt.language == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                compositeEncoder.i(serialDescriptor, 9, StringSerializer.f41077a, vungleExt.language);
            }
            if (!compositeEncoder.z(serialDescriptor, 10) && vungleExt.timeZone == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                compositeEncoder.i(serialDescriptor, 10, StringSerializer.f41077a, vungleExt.timeZone);
            }
            if (!compositeEncoder.z(serialDescriptor, 11) && Intrinsics.a(Float.valueOf(vungleExt.volumeLevel), Float.valueOf(0.0f))) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                compositeEncoder.s(serialDescriptor, 11, vungleExt.volumeLevel);
            }
            if (!compositeEncoder.z(serialDescriptor, 12) && vungleExt.soundEnabled == 1) {
                z14 = false;
            } else {
                z14 = true;
            }
            if (z14) {
                compositeEncoder.w(serialDescriptor, 12, vungleExt.soundEnabled);
            }
            if (!compositeEncoder.z(serialDescriptor, 13) && !vungleExt.isTv) {
                z15 = false;
            } else {
                z15 = true;
            }
            if (z15) {
                compositeEncoder.x(serialDescriptor, 13, vungleExt.isTv);
            }
            if (!compositeEncoder.z(serialDescriptor, 14) && vungleExt.sdCardAvailable == 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                compositeEncoder.w(serialDescriptor, 14, vungleExt.sdCardAvailable);
            }
            if (!compositeEncoder.z(serialDescriptor, 15) && !vungleExt.isSideloadEnabled) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                compositeEncoder.x(serialDescriptor, 15, vungleExt.isSideloadEnabled);
            }
            if (!compositeEncoder.z(serialDescriptor, 16) && vungleExt.gaid == null) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                compositeEncoder.i(serialDescriptor, 16, StringSerializer.f41077a, vungleExt.gaid);
            }
            if (compositeEncoder.z(serialDescriptor, 17) || vungleExt.amazonAdvertisingId != null) {
                z19 = true;
            }
            if (z19) {
                compositeEncoder.i(serialDescriptor, 17, StringSerializer.f41077a, vungleExt.amazonAdvertisingId);
            }
        }

        public final boolean component1() {
            return this.isGooglePlayServicesAvailable;
        }

        public final String component10() {
            return this.language;
        }

        public final String component11() {
            return this.timeZone;
        }

        public final float component12() {
            return this.volumeLevel;
        }

        public final int component13() {
            return this.soundEnabled;
        }

        public final boolean component14() {
            return this.isTv;
        }

        public final int component15() {
            return this.sdCardAvailable;
        }

        public final boolean component16() {
            return this.isSideloadEnabled;
        }

        public final String component17() {
            return this.gaid;
        }

        public final String component18() {
            return this.amazonAdvertisingId;
        }

        public final String component2() {
            return this.appSetId;
        }

        public final Integer component3() {
            return this.appSetIdScope;
        }

        public final float component4() {
            return this.batteryLevel;
        }

        public final String component5() {
            return this.batteryState;
        }

        public final int component6() {
            return this.batterySaverEnabled;
        }

        public final String component7() {
            return this.connectionType;
        }

        public final String component8() {
            return this.connectionTypeDetail;
        }

        public final String component9() {
            return this.locale;
        }

        public final VungleExt copy(boolean z2, String str, Integer num, float f2, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f3, int i3, boolean z3, int i4, boolean z4, String str8, String str9) {
            return new VungleExt(z2, str, num, f2, str2, i2, str3, str4, str5, str6, str7, f3, i3, z3, i4, z4, str8, str9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VungleExt)) {
                return false;
            }
            VungleExt vungleExt = (VungleExt) obj;
            return this.isGooglePlayServicesAvailable == vungleExt.isGooglePlayServicesAvailable && Intrinsics.a(this.appSetId, vungleExt.appSetId) && Intrinsics.a(this.appSetIdScope, vungleExt.appSetIdScope) && Intrinsics.a(Float.valueOf(this.batteryLevel), Float.valueOf(vungleExt.batteryLevel)) && Intrinsics.a(this.batteryState, vungleExt.batteryState) && this.batterySaverEnabled == vungleExt.batterySaverEnabled && Intrinsics.a(this.connectionType, vungleExt.connectionType) && Intrinsics.a(this.connectionTypeDetail, vungleExt.connectionTypeDetail) && Intrinsics.a(this.locale, vungleExt.locale) && Intrinsics.a(this.language, vungleExt.language) && Intrinsics.a(this.timeZone, vungleExt.timeZone) && Intrinsics.a(Float.valueOf(this.volumeLevel), Float.valueOf(vungleExt.volumeLevel)) && this.soundEnabled == vungleExt.soundEnabled && this.isTv == vungleExt.isTv && this.sdCardAvailable == vungleExt.sdCardAvailable && this.isSideloadEnabled == vungleExt.isSideloadEnabled && Intrinsics.a(this.gaid, vungleExt.gaid) && Intrinsics.a(this.amazonAdvertisingId, vungleExt.amazonAdvertisingId);
        }

        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        public final String getAppSetId() {
            return this.appSetId;
        }

        public final Integer getAppSetIdScope() {
            return this.appSetIdScope;
        }

        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        public final String getBatteryState() {
            return this.batteryState;
        }

        public final String getConnectionType() {
            return this.connectionType;
        }

        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        public final String getGaid() {
            return this.gaid;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        public int hashCode() {
            boolean z2 = this.isGooglePlayServicesAvailable;
            boolean z3 = true;
            if (z2) {
                z2 = true;
            }
            int i2 = (z2 ? 1 : 0) * true;
            String str = this.appSetId;
            int i3 = 0;
            int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.appSetIdScope;
            int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Float.floatToIntBits(this.batteryLevel)) * 31;
            String str2 = this.batteryState;
            int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.batterySaverEnabled) * 31;
            String str3 = this.connectionType;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.connectionTypeDetail;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.language;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.timeZone;
            int hashCode8 = (((((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Float.floatToIntBits(this.volumeLevel)) * 31) + this.soundEnabled) * 31;
            boolean z4 = this.isTv;
            if (z4) {
                z4 = true;
            }
            int i4 = (((hashCode8 + (z4 ? 1 : 0)) * 31) + this.sdCardAvailable) * 31;
            boolean z5 = this.isSideloadEnabled;
            if (!z5) {
                z3 = z5;
            }
            int i5 = (i4 + (z3 ? 1 : 0)) * 31;
            String str8 = this.gaid;
            int hashCode9 = (i5 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.amazonAdvertisingId;
            if (str9 != null) {
                i3 = str9.hashCode();
            }
            return hashCode9 + i3;
        }

        public final boolean isGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        public final boolean isSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        public final boolean isTv() {
            return this.isTv;
        }

        public final void setAmazonAdvertisingId(String str) {
            this.amazonAdvertisingId = str;
        }

        public final void setAppSetId(String str) {
            this.appSetId = str;
        }

        public final void setAppSetIdScope(Integer num) {
            this.appSetIdScope = num;
        }

        public final void setBatteryLevel(float f2) {
            this.batteryLevel = f2;
        }

        public final void setBatterySaverEnabled(int i2) {
            this.batterySaverEnabled = i2;
        }

        public final void setBatteryState(String str) {
            this.batteryState = str;
        }

        public final void setConnectionType(String str) {
            this.connectionType = str;
        }

        public final void setConnectionTypeDetail(String str) {
            this.connectionTypeDetail = str;
        }

        public final void setGaid(String str) {
            this.gaid = str;
        }

        public final void setGooglePlayServicesAvailable(boolean z2) {
            this.isGooglePlayServicesAvailable = z2;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final void setLocale(String str) {
            this.locale = str;
        }

        public final void setSdCardAvailable(int i2) {
            this.sdCardAvailable = i2;
        }

        public final void setSideloadEnabled(boolean z2) {
            this.isSideloadEnabled = z2;
        }

        public final void setSoundEnabled(int i2) {
            this.soundEnabled = i2;
        }

        public final void setTimeZone(String str) {
            this.timeZone = str;
        }

        public final void setTv(boolean z2) {
            this.isTv = z2;
        }

        public final void setVolumeLevel(float f2) {
            this.volumeLevel = f2;
        }

        public String toString() {
            return "VungleExt(isGooglePlayServicesAvailable=" + this.isGooglePlayServicesAvailable + ", appSetId=" + this.appSetId + ", appSetIdScope=" + this.appSetIdScope + ", batteryLevel=" + this.batteryLevel + ", batteryState=" + this.batteryState + ", batterySaverEnabled=" + this.batterySaverEnabled + ", connectionType=" + this.connectionType + ", connectionTypeDetail=" + this.connectionTypeDetail + ", locale=" + this.locale + ", language=" + this.language + ", timeZone=" + this.timeZone + ", volumeLevel=" + this.volumeLevel + ", soundEnabled=" + this.soundEnabled + ", isTv=" + this.isTv + ", sdCardAvailable=" + this.sdCardAvailable + ", isSideloadEnabled=" + this.isSideloadEnabled + ", gaid=" + this.gaid + ", amazonAdvertisingId=" + this.amazonAdvertisingId + ')';
        }

        public VungleExt(boolean z2, String str, Integer num, float f2, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f3, int i3, boolean z3, int i4, boolean z4, String str8, String str9) {
            this.isGooglePlayServicesAvailable = z2;
            this.appSetId = str;
            this.appSetIdScope = num;
            this.batteryLevel = f2;
            this.batteryState = str2;
            this.batterySaverEnabled = i2;
            this.connectionType = str3;
            this.connectionTypeDetail = str4;
            this.locale = str5;
            this.language = str6;
            this.timeZone = str7;
            this.volumeLevel = f3;
            this.soundEnabled = i3;
            this.isTv = z3;
            this.sdCardAvailable = i4;
            this.isSideloadEnabled = z4;
            this.gaid = str8;
            this.amazonAdvertisingId = str9;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ VungleExt(boolean r20, java.lang.String r21, java.lang.Integer r22, float r23, java.lang.String r24, int r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, float r31, int r32, boolean r33, int r34, boolean r35, java.lang.String r36, java.lang.String r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
            /*
                r19 = this;
                r0 = r38
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0008
                r1 = 0
                goto L_0x000a
            L_0x0008:
                r1 = r20
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = 0
                goto L_0x0012
            L_0x0010:
                r3 = r21
            L_0x0012:
                r5 = r0 & 4
                if (r5 == 0) goto L_0x0018
                r5 = 0
                goto L_0x001a
            L_0x0018:
                r5 = r22
            L_0x001a:
                r6 = r0 & 8
                r7 = 0
                if (r6 == 0) goto L_0x0021
                r6 = 0
                goto L_0x0023
            L_0x0021:
                r6 = r23
            L_0x0023:
                r8 = r0 & 16
                if (r8 == 0) goto L_0x0029
                r8 = 0
                goto L_0x002b
            L_0x0029:
                r8 = r24
            L_0x002b:
                r9 = r0 & 32
                if (r9 == 0) goto L_0x0031
                r9 = 0
                goto L_0x0033
            L_0x0031:
                r9 = r25
            L_0x0033:
                r10 = r0 & 64
                if (r10 == 0) goto L_0x0039
                r10 = 0
                goto L_0x003b
            L_0x0039:
                r10 = r26
            L_0x003b:
                r11 = r0 & 128(0x80, float:1.794E-43)
                if (r11 == 0) goto L_0x0041
                r11 = 0
                goto L_0x0043
            L_0x0041:
                r11 = r27
            L_0x0043:
                r12 = r0 & 256(0x100, float:3.59E-43)
                if (r12 == 0) goto L_0x0049
                r12 = 0
                goto L_0x004b
            L_0x0049:
                r12 = r28
            L_0x004b:
                r13 = r0 & 512(0x200, float:7.175E-43)
                if (r13 == 0) goto L_0x0051
                r13 = 0
                goto L_0x0053
            L_0x0051:
                r13 = r29
            L_0x0053:
                r14 = r0 & 1024(0x400, float:1.435E-42)
                if (r14 == 0) goto L_0x0059
                r14 = 0
                goto L_0x005b
            L_0x0059:
                r14 = r30
            L_0x005b:
                r15 = r0 & 2048(0x800, float:2.87E-42)
                if (r15 == 0) goto L_0x0060
                goto L_0x0062
            L_0x0060:
                r7 = r31
            L_0x0062:
                r15 = r0 & 4096(0x1000, float:5.74E-42)
                r16 = 1
                if (r15 == 0) goto L_0x006a
                r15 = 1
                goto L_0x006c
            L_0x006a:
                r15 = r32
            L_0x006c:
                r2 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r2 == 0) goto L_0x0072
                r2 = 0
                goto L_0x0074
            L_0x0072:
                r2 = r33
            L_0x0074:
                r4 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r4 == 0) goto L_0x0079
                goto L_0x007b
            L_0x0079:
                r16 = r34
            L_0x007b:
                r4 = 32768(0x8000, float:4.5918E-41)
                r4 = r4 & r0
                if (r4 == 0) goto L_0x0083
                r4 = 0
                goto L_0x0085
            L_0x0083:
                r4 = r35
            L_0x0085:
                r17 = 65536(0x10000, float:9.18355E-41)
                r17 = r0 & r17
                if (r17 == 0) goto L_0x008e
                r17 = 0
                goto L_0x0090
            L_0x008e:
                r17 = r36
            L_0x0090:
                r18 = 131072(0x20000, float:1.83671E-40)
                r0 = r0 & r18
                if (r0 == 0) goto L_0x0098
                r0 = 0
                goto L_0x009a
            L_0x0098:
                r0 = r37
            L_0x009a:
                r20 = r19
                r21 = r1
                r22 = r3
                r23 = r5
                r24 = r6
                r25 = r8
                r26 = r9
                r27 = r10
                r28 = r11
                r29 = r12
                r30 = r13
                r31 = r14
                r32 = r7
                r33 = r15
                r34 = r2
                r35 = r16
                r36 = r4
                r37 = r17
                r38 = r0
                r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode.VungleExt.<init>(boolean, java.lang.String, java.lang.Integer, float, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, float, int, boolean, int, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public /* synthetic */ DeviceNode(int i2, String str, String str2, String str3, String str4, String str5, int i3, int i4, String str6, String str7, Integer num, VungleExt vungleExt, SerializationConstructorMarker serializationConstructorMarker) {
        if (119 != (i2 & 119)) {
            PluginExceptionsKt.a(i2, 119, DeviceNode$$serializer.INSTANCE.getDescriptor());
        }
        this.make = str;
        this.model = str2;
        this.osv = str3;
        if ((i2 & 8) == 0) {
            this.carrier = null;
        } else {
            this.carrier = str4;
        }
        this.os = str5;
        this.f37888w = i3;
        this.f37887h = i4;
        if ((i2 & 128) == 0) {
            this.ua = null;
        } else {
            this.ua = str6;
        }
        if ((i2 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0) {
            this.ifa = null;
        } else {
            this.ifa = str7;
        }
        if ((i2 & 512) == 0) {
            this.lmt = null;
        } else {
            this.lmt = num;
        }
        if ((i2 & 1024) == 0) {
            this.ext = null;
        } else {
            this.ext = vungleExt;
        }
    }

    public static /* synthetic */ DeviceNode copy$default(DeviceNode deviceNode, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, VungleExt vungleExt, int i4, Object obj) {
        DeviceNode deviceNode2 = deviceNode;
        int i5 = i4;
        return deviceNode.copy((i5 & 1) != 0 ? deviceNode2.make : str, (i5 & 2) != 0 ? deviceNode2.model : str2, (i5 & 4) != 0 ? deviceNode2.osv : str3, (i5 & 8) != 0 ? deviceNode2.carrier : str4, (i5 & 16) != 0 ? deviceNode2.os : str5, (i5 & 32) != 0 ? deviceNode2.f37888w : i2, (i5 & 64) != 0 ? deviceNode2.f37887h : i3, (i5 & 128) != 0 ? deviceNode2.ua : str6, (i5 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? deviceNode2.ifa : str7, (i5 & 512) != 0 ? deviceNode2.lmt : num, (i5 & 1024) != 0 ? deviceNode2.ext : vungleExt);
    }

    public static final void write$Self(DeviceNode deviceNode, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.f(deviceNode, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z6 = false;
        compositeEncoder.y(serialDescriptor, 0, deviceNode.make);
        compositeEncoder.y(serialDescriptor, 1, deviceNode.model);
        compositeEncoder.y(serialDescriptor, 2, deviceNode.osv);
        if (!compositeEncoder.z(serialDescriptor, 3) && deviceNode.carrier == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f41077a, deviceNode.carrier);
        }
        compositeEncoder.y(serialDescriptor, 4, deviceNode.os);
        compositeEncoder.w(serialDescriptor, 5, deviceNode.f37888w);
        compositeEncoder.w(serialDescriptor, 6, deviceNode.f37887h);
        if (!compositeEncoder.z(serialDescriptor, 7) && deviceNode.ua == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 7, StringSerializer.f41077a, deviceNode.ua);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && deviceNode.ifa == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 8, StringSerializer.f41077a, deviceNode.ifa);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && deviceNode.lmt == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 9, IntSerializer.f41006a, deviceNode.lmt);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || deviceNode.ext != null) {
            z6 = true;
        }
        if (z6) {
            compositeEncoder.i(serialDescriptor, 10, DeviceNode$VungleExt$$serializer.INSTANCE, deviceNode.ext);
        }
    }

    public final String component1() {
        return this.make;
    }

    public final Integer component10() {
        return this.lmt;
    }

    public final VungleExt component11() {
        return this.ext;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.osv;
    }

    public final String component4() {
        return this.carrier;
    }

    public final String component5() {
        return this.os;
    }

    public final int component6() {
        return this.f37888w;
    }

    public final int component7() {
        return this.f37887h;
    }

    public final String component8() {
        return this.ua;
    }

    public final String component9() {
        return this.ifa;
    }

    public final DeviceNode copy(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, VungleExt vungleExt) {
        Intrinsics.f(str, "make");
        Intrinsics.f(str2, "model");
        String str8 = str3;
        Intrinsics.f(str8, "osv");
        String str9 = str5;
        Intrinsics.f(str9, "os");
        return new DeviceNode(str, str2, str8, str4, str9, i2, i3, str6, str7, num, vungleExt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceNode)) {
            return false;
        }
        DeviceNode deviceNode = (DeviceNode) obj;
        return Intrinsics.a(this.make, deviceNode.make) && Intrinsics.a(this.model, deviceNode.model) && Intrinsics.a(this.osv, deviceNode.osv) && Intrinsics.a(this.carrier, deviceNode.carrier) && Intrinsics.a(this.os, deviceNode.os) && this.f37888w == deviceNode.f37888w && this.f37887h == deviceNode.f37887h && Intrinsics.a(this.ua, deviceNode.ua) && Intrinsics.a(this.ifa, deviceNode.ifa) && Intrinsics.a(this.lmt, deviceNode.lmt) && Intrinsics.a(this.ext, deviceNode.ext);
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final VungleExt getExt() {
        return this.ext;
    }

    public final int getH() {
        return this.f37887h;
    }

    public final String getIfa() {
        return this.ifa;
    }

    public final Integer getLmt() {
        return this.lmt;
    }

    public final String getMake() {
        return this.make;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getOsv() {
        return this.osv;
    }

    public final String getUa() {
        return this.ua;
    }

    public final int getW() {
        return this.f37888w;
    }

    public int hashCode() {
        int hashCode = ((((this.make.hashCode() * 31) + this.model.hashCode()) * 31) + this.osv.hashCode()) * 31;
        String str = this.carrier;
        int i2 = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.os.hashCode()) * 31) + this.f37888w) * 31) + this.f37887h) * 31;
        String str2 = this.ua;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ifa;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lmt;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        VungleExt vungleExt = this.ext;
        if (vungleExt != null) {
            i2 = vungleExt.hashCode();
        }
        return hashCode5 + i2;
    }

    public final void setExt(VungleExt vungleExt) {
        this.ext = vungleExt;
    }

    public final void setIfa(String str) {
        this.ifa = str;
    }

    public final void setLmt(Integer num) {
        this.lmt = num;
    }

    public final void setUa(String str) {
        this.ua = str;
    }

    public String toString() {
        return "DeviceNode(make=" + this.make + ", model=" + this.model + ", osv=" + this.osv + ", carrier=" + this.carrier + ", os=" + this.os + ", w=" + this.f37888w + ", h=" + this.f37887h + ", ua=" + this.ua + ", ifa=" + this.ifa + ", lmt=" + this.lmt + ", ext=" + this.ext + ')';
    }

    public DeviceNode(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, VungleExt vungleExt) {
        Intrinsics.f(str, "make");
        Intrinsics.f(str2, "model");
        Intrinsics.f(str3, "osv");
        Intrinsics.f(str5, "os");
        this.make = str;
        this.model = str2;
        this.osv = str3;
        this.carrier = str4;
        this.os = str5;
        this.f37888w = i2;
        this.f37887h = i3;
        this.ua = str6;
        this.ifa = str7;
        this.lmt = num;
        this.ext = vungleExt;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceNode(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, com.vungle.ads.internal.model.DeviceNode.VungleExt r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r19
        L_0x000b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0011
            r11 = r2
            goto L_0x0013
        L_0x0011:
            r11 = r23
        L_0x0013:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0019
            r12 = r2
            goto L_0x001b
        L_0x0019:
            r12 = r24
        L_0x001b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0021
            r13 = r2
            goto L_0x0023
        L_0x0021:
            r13 = r25
        L_0x0023:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0029
            r14 = r2
            goto L_0x002b
        L_0x0029:
            r14 = r26
        L_0x002b:
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r9 = r21
            r10 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.Integer, com.vungle.ads.internal.model.DeviceNode$VungleExt, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

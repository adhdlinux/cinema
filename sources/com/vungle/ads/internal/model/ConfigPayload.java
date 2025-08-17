package com.vungle.ads.internal.model;

import com.facebook.common.time.Clock;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;

@Serializable
public final class ConfigPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private AutoRedirect autoRedirect;
    private final CleverCache cleverCache;
    private final String configExtension;
    private Long configLastValidatedTimestamp;
    private final ConfigSettings configSettings;
    private final Boolean disableAdId;
    private final Endpoints endpoints;
    private final Boolean fpdEnabled;
    private final Boolean isCacheableAssetsRequired;
    private final Boolean isReportIncentivizedEnabled;
    private final LogMetricsSettings logMetricsSettings;
    private final List<Placement> placements;
    private final Boolean rtaDebugging;
    private final Integer sessionTimeout;
    private final Integer signalSessionTimeout;
    private final Boolean signalsDisabled;
    private final UserPrivacy userPrivacy;
    private final ViewAbilitySettings viewAbility;
    private final Boolean waitForConnectivityForTPAT;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ConfigPayload> serializer() {
            return ConfigPayload$$serializer.INSTANCE;
        }
    }

    @Serializable
    public static final class ConfigSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Long refreshTime;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ConfigSettings> serializer() {
                return ConfigPayload$ConfigSettings$$serializer.INSTANCE;
            }
        }

        public ConfigSettings() {
            this((Long) null, 1, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ ConfigSettings(int i2, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$ConfigSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.refreshTime = null;
            } else {
                this.refreshTime = l2;
            }
        }

        public static /* synthetic */ ConfigSettings copy$default(ConfigSettings configSettings, Long l2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                l2 = configSettings.refreshTime;
            }
            return configSettings.copy(l2);
        }

        public static /* synthetic */ void getRefreshTime$annotations() {
        }

        public static final void write$Self(ConfigSettings configSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(configSettings, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z2 = true;
            if (!compositeEncoder.z(serialDescriptor, 0) && configSettings.refreshTime == null) {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, LongSerializer.f41017a, configSettings.refreshTime);
            }
        }

        public final Long component1() {
            return this.refreshTime;
        }

        public final ConfigSettings copy(Long l2) {
            return new ConfigSettings(l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfigSettings) && Intrinsics.a(this.refreshTime, ((ConfigSettings) obj).refreshTime);
        }

        public final Long getRefreshTime() {
            return this.refreshTime;
        }

        public int hashCode() {
            Long l2 = this.refreshTime;
            if (l2 == null) {
                return 0;
            }
            return l2.hashCode();
        }

        public String toString() {
            return "ConfigSettings(refreshTime=" + this.refreshTime + ')';
        }

        public ConfigSettings(Long l2) {
            this.refreshTime = l2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ConfigSettings(Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : l2);
        }
    }

    @Serializable
    public static final class Endpoints {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String adsEndpoint;
        private final String errorLogsEndpoint;
        private final String metricsEndpoint;
        private final String mraidEndpoint;
        private final String riEndpoint;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Endpoints> serializer() {
                return ConfigPayload$Endpoints$$serializer.INSTANCE;
            }
        }

        public Endpoints() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Endpoints(int i2, String str, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$Endpoints$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.adsEndpoint = null;
            } else {
                this.adsEndpoint = str;
            }
            if ((i2 & 2) == 0) {
                this.riEndpoint = null;
            } else {
                this.riEndpoint = str2;
            }
            if ((i2 & 4) == 0) {
                this.errorLogsEndpoint = null;
            } else {
                this.errorLogsEndpoint = str3;
            }
            if ((i2 & 8) == 0) {
                this.metricsEndpoint = null;
            } else {
                this.metricsEndpoint = str4;
            }
            if ((i2 & 16) == 0) {
                this.mraidEndpoint = null;
            } else {
                this.mraidEndpoint = str5;
            }
        }

        public static /* synthetic */ Endpoints copy$default(Endpoints endpoints, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = endpoints.adsEndpoint;
            }
            if ((i2 & 2) != 0) {
                str2 = endpoints.riEndpoint;
            }
            String str6 = str2;
            if ((i2 & 4) != 0) {
                str3 = endpoints.errorLogsEndpoint;
            }
            String str7 = str3;
            if ((i2 & 8) != 0) {
                str4 = endpoints.metricsEndpoint;
            }
            String str8 = str4;
            if ((i2 & 16) != 0) {
                str5 = endpoints.mraidEndpoint;
            }
            return endpoints.copy(str, str6, str7, str8, str5);
        }

        public static /* synthetic */ void getAdsEndpoint$annotations() {
        }

        public static /* synthetic */ void getErrorLogsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMetricsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMraidEndpoint$annotations() {
        }

        public static /* synthetic */ void getRiEndpoint$annotations() {
        }

        public static final void write$Self(Endpoints endpoints, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            Intrinsics.f(endpoints, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z6 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && endpoints.adsEndpoint == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, endpoints.adsEndpoint);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && endpoints.riEndpoint == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, endpoints.riEndpoint);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && endpoints.errorLogsEndpoint == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, StringSerializer.f41077a, endpoints.errorLogsEndpoint);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && endpoints.metricsEndpoint == null) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                compositeEncoder.i(serialDescriptor, 3, StringSerializer.f41077a, endpoints.metricsEndpoint);
            }
            if (compositeEncoder.z(serialDescriptor, 4) || endpoints.mraidEndpoint != null) {
                z6 = true;
            }
            if (z6) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f41077a, endpoints.mraidEndpoint);
            }
        }

        public final String component1() {
            return this.adsEndpoint;
        }

        public final String component2() {
            return this.riEndpoint;
        }

        public final String component3() {
            return this.errorLogsEndpoint;
        }

        public final String component4() {
            return this.metricsEndpoint;
        }

        public final String component5() {
            return this.mraidEndpoint;
        }

        public final Endpoints copy(String str, String str2, String str3, String str4, String str5) {
            return new Endpoints(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Endpoints)) {
                return false;
            }
            Endpoints endpoints = (Endpoints) obj;
            return Intrinsics.a(this.adsEndpoint, endpoints.adsEndpoint) && Intrinsics.a(this.riEndpoint, endpoints.riEndpoint) && Intrinsics.a(this.errorLogsEndpoint, endpoints.errorLogsEndpoint) && Intrinsics.a(this.metricsEndpoint, endpoints.metricsEndpoint) && Intrinsics.a(this.mraidEndpoint, endpoints.mraidEndpoint);
        }

        public final String getAdsEndpoint() {
            return this.adsEndpoint;
        }

        public final String getErrorLogsEndpoint() {
            return this.errorLogsEndpoint;
        }

        public final String getMetricsEndpoint() {
            return this.metricsEndpoint;
        }

        public final String getMraidEndpoint() {
            return this.mraidEndpoint;
        }

        public final String getRiEndpoint() {
            return this.riEndpoint;
        }

        public int hashCode() {
            String str = this.adsEndpoint;
            int i2 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.riEndpoint;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.errorLogsEndpoint;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.metricsEndpoint;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.mraidEndpoint;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode4 + i2;
        }

        public String toString() {
            return "Endpoints(adsEndpoint=" + this.adsEndpoint + ", riEndpoint=" + this.riEndpoint + ", errorLogsEndpoint=" + this.errorLogsEndpoint + ", metricsEndpoint=" + this.metricsEndpoint + ", mraidEndpoint=" + this.mraidEndpoint + ')';
        }

        public Endpoints(String str, String str2, String str3, String str4, String str5) {
            this.adsEndpoint = str;
            this.riEndpoint = str2;
            this.errorLogsEndpoint = str3;
            this.metricsEndpoint = str4;
            this.mraidEndpoint = str5;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Endpoints(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r0
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r1
                r8 = r2
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload.Endpoints.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    @Serializable
    public static final class GDPRSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String buttonAccept;
        private final String buttonDeny;
        private final String consentMessage;
        private final String consentMessageVersion;
        private final String consentTitle;
        private final Boolean isCountryDataProtected;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<GDPRSettings> serializer() {
                return ConfigPayload$GDPRSettings$$serializer.INSTANCE;
            }
        }

        public GDPRSettings() {
            this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ GDPRSettings(int i2, Boolean bool, String str, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$GDPRSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.isCountryDataProtected = null;
            } else {
                this.isCountryDataProtected = bool;
            }
            if ((i2 & 2) == 0) {
                this.consentTitle = null;
            } else {
                this.consentTitle = str;
            }
            if ((i2 & 4) == 0) {
                this.consentMessage = null;
            } else {
                this.consentMessage = str2;
            }
            if ((i2 & 8) == 0) {
                this.consentMessageVersion = null;
            } else {
                this.consentMessageVersion = str3;
            }
            if ((i2 & 16) == 0) {
                this.buttonAccept = null;
            } else {
                this.buttonAccept = str4;
            }
            if ((i2 & 32) == 0) {
                this.buttonDeny = null;
            } else {
                this.buttonDeny = str5;
            }
        }

        public static /* synthetic */ GDPRSettings copy$default(GDPRSettings gDPRSettings, Boolean bool, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = gDPRSettings.isCountryDataProtected;
            }
            if ((i2 & 2) != 0) {
                str = gDPRSettings.consentTitle;
            }
            String str6 = str;
            if ((i2 & 4) != 0) {
                str2 = gDPRSettings.consentMessage;
            }
            String str7 = str2;
            if ((i2 & 8) != 0) {
                str3 = gDPRSettings.consentMessageVersion;
            }
            String str8 = str3;
            if ((i2 & 16) != 0) {
                str4 = gDPRSettings.buttonAccept;
            }
            String str9 = str4;
            if ((i2 & 32) != 0) {
                str5 = gDPRSettings.buttonDeny;
            }
            return gDPRSettings.copy(bool, str6, str7, str8, str9, str5);
        }

        public static /* synthetic */ void getButtonAccept$annotations() {
        }

        public static /* synthetic */ void getButtonDeny$annotations() {
        }

        public static /* synthetic */ void getConsentMessage$annotations() {
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentTitle$annotations() {
        }

        public static /* synthetic */ void isCountryDataProtected$annotations() {
        }

        public static final void write$Self(GDPRSettings gDPRSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            Intrinsics.f(gDPRSettings, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z7 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && gDPRSettings.isCountryDataProtected == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f40947a, gDPRSettings.isCountryDataProtected);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && gDPRSettings.consentTitle == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, gDPRSettings.consentTitle);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && gDPRSettings.consentMessage == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, StringSerializer.f41077a, gDPRSettings.consentMessage);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && gDPRSettings.consentMessageVersion == null) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                compositeEncoder.i(serialDescriptor, 3, StringSerializer.f41077a, gDPRSettings.consentMessageVersion);
            }
            if (!compositeEncoder.z(serialDescriptor, 4) && gDPRSettings.buttonAccept == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z6) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f41077a, gDPRSettings.buttonAccept);
            }
            if (compositeEncoder.z(serialDescriptor, 5) || gDPRSettings.buttonDeny != null) {
                z7 = true;
            }
            if (z7) {
                compositeEncoder.i(serialDescriptor, 5, StringSerializer.f41077a, gDPRSettings.buttonDeny);
            }
        }

        public final Boolean component1() {
            return this.isCountryDataProtected;
        }

        public final String component2() {
            return this.consentTitle;
        }

        public final String component3() {
            return this.consentMessage;
        }

        public final String component4() {
            return this.consentMessageVersion;
        }

        public final String component5() {
            return this.buttonAccept;
        }

        public final String component6() {
            return this.buttonDeny;
        }

        public final GDPRSettings copy(Boolean bool, String str, String str2, String str3, String str4, String str5) {
            return new GDPRSettings(bool, str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GDPRSettings)) {
                return false;
            }
            GDPRSettings gDPRSettings = (GDPRSettings) obj;
            return Intrinsics.a(this.isCountryDataProtected, gDPRSettings.isCountryDataProtected) && Intrinsics.a(this.consentTitle, gDPRSettings.consentTitle) && Intrinsics.a(this.consentMessage, gDPRSettings.consentMessage) && Intrinsics.a(this.consentMessageVersion, gDPRSettings.consentMessageVersion) && Intrinsics.a(this.buttonAccept, gDPRSettings.buttonAccept) && Intrinsics.a(this.buttonDeny, gDPRSettings.buttonDeny);
        }

        public final String getButtonAccept() {
            return this.buttonAccept;
        }

        public final String getButtonDeny() {
            return this.buttonDeny;
        }

        public final String getConsentMessage() {
            return this.consentMessage;
        }

        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        public final String getConsentTitle() {
            return this.consentTitle;
        }

        public int hashCode() {
            Boolean bool = this.isCountryDataProtected;
            int i2 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.consentTitle;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.consentMessage;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.consentMessageVersion;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.buttonAccept;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.buttonDeny;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode5 + i2;
        }

        public final Boolean isCountryDataProtected() {
            return this.isCountryDataProtected;
        }

        public String toString() {
            return "GDPRSettings(isCountryDataProtected=" + this.isCountryDataProtected + ", consentTitle=" + this.consentTitle + ", consentMessage=" + this.consentMessage + ", consentMessageVersion=" + this.consentMessageVersion + ", buttonAccept=" + this.buttonAccept + ", buttonDeny=" + this.buttonDeny + ')';
        }

        public GDPRSettings(Boolean bool, String str, String str2, String str3, String str4, String str5) {
            this.isCountryDataProtected = bool;
            this.consentTitle = str;
            this.consentMessage = str2;
            this.consentMessageVersion = str3;
            this.buttonAccept = str4;
            this.buttonDeny = str5;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ GDPRSettings(java.lang.Boolean r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r7
            L_0x000f:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r8
            L_0x0016:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload.GDPRSettings.<init>(java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    @Serializable
    public static final class IABSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Integer tcfStatus;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<IABSettings> serializer() {
                return ConfigPayload$IABSettings$$serializer.INSTANCE;
            }
        }

        public enum TcfStatus {
            ALLOW_ID(0),
            DISABLE_ID(1),
            LEGACY(2);
            
            public static final Companion Companion = null;
            /* access modifiers changed from: private */
            public static final Map<Integer, TcfStatus> rawValueMap = null;
            private final int rawValue;

            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final TcfStatus fromRawValue(Integer num) {
                    return (TcfStatus) TcfStatus.rawValueMap.get(num);
                }
            }

            static {
                int i2;
                Companion = new Companion((DefaultConstructorMarker) null);
                TcfStatus[] values = values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.b(MapsKt__MapsJVMKt.d(values.length), 16));
                for (TcfStatus tcfStatus : values) {
                    linkedHashMap.put(Integer.valueOf(tcfStatus.rawValue), tcfStatus);
                }
                rawValueMap = linkedHashMap;
            }

            private TcfStatus(int i2) {
                this.rawValue = i2;
            }

            public final int getRawValue() {
                return this.rawValue;
            }
        }

        public IABSettings() {
            this((Integer) null, 1, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ IABSettings(int i2, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$IABSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.tcfStatus = null;
            } else {
                this.tcfStatus = num;
            }
        }

        public static /* synthetic */ IABSettings copy$default(IABSettings iABSettings, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = iABSettings.tcfStatus;
            }
            return iABSettings.copy(num);
        }

        public static /* synthetic */ void getTcfStatus$annotations() {
        }

        public static final void write$Self(IABSettings iABSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(iABSettings, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z2 = true;
            if (!compositeEncoder.z(serialDescriptor, 0) && iABSettings.tcfStatus == null) {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, IntSerializer.f41006a, iABSettings.tcfStatus);
            }
        }

        public final Integer component1() {
            return this.tcfStatus;
        }

        public final IABSettings copy(Integer num) {
            return new IABSettings(num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IABSettings) && Intrinsics.a(this.tcfStatus, ((IABSettings) obj).tcfStatus);
        }

        public final Integer getTcfStatus() {
            return this.tcfStatus;
        }

        public int hashCode() {
            Integer num = this.tcfStatus;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "IABSettings(tcfStatus=" + this.tcfStatus + ')';
        }

        public IABSettings(Integer num) {
            this.tcfStatus = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ IABSettings(Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : num);
        }
    }

    @Serializable
    public static final class LogMetricsSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Integer errorLogLevel;
        private final Boolean metricsEnabled;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<LogMetricsSettings> serializer() {
                return ConfigPayload$LogMetricsSettings$$serializer.INSTANCE;
            }
        }

        public LogMetricsSettings() {
            this((Integer) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ LogMetricsSettings(int i2, Integer num, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.errorLogLevel = null;
            } else {
                this.errorLogLevel = num;
            }
            if ((i2 & 2) == 0) {
                this.metricsEnabled = null;
            } else {
                this.metricsEnabled = bool;
            }
        }

        public static /* synthetic */ LogMetricsSettings copy$default(LogMetricsSettings logMetricsSettings, Integer num, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = logMetricsSettings.errorLogLevel;
            }
            if ((i2 & 2) != 0) {
                bool = logMetricsSettings.metricsEnabled;
            }
            return logMetricsSettings.copy(num, bool);
        }

        public static /* synthetic */ void getErrorLogLevel$annotations() {
        }

        public static /* synthetic */ void getMetricsEnabled$annotations() {
        }

        public static final void write$Self(LogMetricsSettings logMetricsSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Intrinsics.f(logMetricsSettings, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && logMetricsSettings.errorLogLevel == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, IntSerializer.f41006a, logMetricsSettings.errorLogLevel);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || logMetricsSettings.metricsEnabled != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f40947a, logMetricsSettings.metricsEnabled);
            }
        }

        public final Integer component1() {
            return this.errorLogLevel;
        }

        public final Boolean component2() {
            return this.metricsEnabled;
        }

        public final LogMetricsSettings copy(Integer num, Boolean bool) {
            return new LogMetricsSettings(num, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogMetricsSettings)) {
                return false;
            }
            LogMetricsSettings logMetricsSettings = (LogMetricsSettings) obj;
            return Intrinsics.a(this.errorLogLevel, logMetricsSettings.errorLogLevel) && Intrinsics.a(this.metricsEnabled, logMetricsSettings.metricsEnabled);
        }

        public final Integer getErrorLogLevel() {
            return this.errorLogLevel;
        }

        public final Boolean getMetricsEnabled() {
            return this.metricsEnabled;
        }

        public int hashCode() {
            Integer num = this.errorLogLevel;
            int i2 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.metricsEnabled;
            if (bool != null) {
                i2 = bool.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "LogMetricsSettings(errorLogLevel=" + this.errorLogLevel + ", metricsEnabled=" + this.metricsEnabled + ')';
        }

        public LogMetricsSettings(Integer num, Boolean bool) {
            this.errorLogLevel = num;
            this.metricsEnabled = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LogMetricsSettings(Integer num, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : bool);
        }
    }

    @Serializable
    public static final class UserPrivacy {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final GDPRSettings gdpr;
        private final IABSettings iab;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<UserPrivacy> serializer() {
                return ConfigPayload$UserPrivacy$$serializer.INSTANCE;
            }
        }

        public UserPrivacy() {
            this((GDPRSettings) null, (IABSettings) null, 3, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ UserPrivacy(int i2, GDPRSettings gDPRSettings, IABSettings iABSettings, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$UserPrivacy$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = gDPRSettings;
            }
            if ((i2 & 2) == 0) {
                this.iab = null;
            } else {
                this.iab = iABSettings;
            }
        }

        public static /* synthetic */ UserPrivacy copy$default(UserPrivacy userPrivacy, GDPRSettings gDPRSettings, IABSettings iABSettings, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                gDPRSettings = userPrivacy.gdpr;
            }
            if ((i2 & 2) != 0) {
                iABSettings = userPrivacy.iab;
            }
            return userPrivacy.copy(gDPRSettings, iABSettings);
        }

        public static /* synthetic */ void getGdpr$annotations() {
        }

        public static /* synthetic */ void getIab$annotations() {
        }

        public static final void write$Self(UserPrivacy userPrivacy, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Intrinsics.f(userPrivacy, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && userPrivacy.gdpr == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, ConfigPayload$GDPRSettings$$serializer.INSTANCE, userPrivacy.gdpr);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || userPrivacy.iab != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, ConfigPayload$IABSettings$$serializer.INSTANCE, userPrivacy.iab);
            }
        }

        public final GDPRSettings component1() {
            return this.gdpr;
        }

        public final IABSettings component2() {
            return this.iab;
        }

        public final UserPrivacy copy(GDPRSettings gDPRSettings, IABSettings iABSettings) {
            return new UserPrivacy(gDPRSettings, iABSettings);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserPrivacy)) {
                return false;
            }
            UserPrivacy userPrivacy = (UserPrivacy) obj;
            return Intrinsics.a(this.gdpr, userPrivacy.gdpr) && Intrinsics.a(this.iab, userPrivacy.iab);
        }

        public final GDPRSettings getGdpr() {
            return this.gdpr;
        }

        public final IABSettings getIab() {
            return this.iab;
        }

        public int hashCode() {
            GDPRSettings gDPRSettings = this.gdpr;
            int i2 = 0;
            int hashCode = (gDPRSettings == null ? 0 : gDPRSettings.hashCode()) * 31;
            IABSettings iABSettings = this.iab;
            if (iABSettings != null) {
                i2 = iABSettings.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "UserPrivacy(gdpr=" + this.gdpr + ", iab=" + this.iab + ')';
        }

        public UserPrivacy(GDPRSettings gDPRSettings, IABSettings iABSettings) {
            this.gdpr = gDPRSettings;
            this.iab = iABSettings;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UserPrivacy(GDPRSettings gDPRSettings, IABSettings iABSettings, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : gDPRSettings, (i2 & 2) != 0 ? null : iABSettings);
        }
    }

    @Serializable
    public static final class ViewAbilitySettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Boolean om;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ViewAbilitySettings> serializer() {
                return ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE;
            }
        }

        public ViewAbilitySettings() {
            this((Boolean) null, 1, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ ViewAbilitySettings(int i2, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.om = null;
            } else {
                this.om = bool;
            }
        }

        public static /* synthetic */ ViewAbilitySettings copy$default(ViewAbilitySettings viewAbilitySettings, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = viewAbilitySettings.om;
            }
            return viewAbilitySettings.copy(bool);
        }

        public static /* synthetic */ void getOm$annotations() {
        }

        public static final void write$Self(ViewAbilitySettings viewAbilitySettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(viewAbilitySettings, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z2 = true;
            if (!compositeEncoder.z(serialDescriptor, 0) && viewAbilitySettings.om == null) {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f40947a, viewAbilitySettings.om);
            }
        }

        public final Boolean component1() {
            return this.om;
        }

        public final ViewAbilitySettings copy(Boolean bool) {
            return new ViewAbilitySettings(bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ViewAbilitySettings) && Intrinsics.a(this.om, ((ViewAbilitySettings) obj).om);
        }

        public final Boolean getOm() {
            return this.om;
        }

        public int hashCode() {
            Boolean bool = this.om;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "ViewAbilitySettings(om=" + this.om + ')';
        }

        public ViewAbilitySettings(Boolean bool) {
            this.om = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewAbilitySettings(Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : bool);
        }
    }

    public ConfigPayload() {
        this((CleverCache) null, (ConfigSettings) null, (Endpoints) null, (LogMetricsSettings) null, (List) null, (UserPrivacy) null, (ViewAbilitySettings) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Long) null, (AutoRedirect) null, 524287, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ConfigPayload(int i2, CleverCache cleverCache2, ConfigSettings configSettings2, Endpoints endpoints2, LogMetricsSettings logMetricsSettings2, List list, UserPrivacy userPrivacy2, ViewAbilitySettings viewAbilitySettings, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Long l2, AutoRedirect autoRedirect2, SerializationConstructorMarker serializationConstructorMarker) {
        int i3 = i2;
        if ((i3 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, ConfigPayload$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.cleverCache = null;
        } else {
            this.cleverCache = cleverCache2;
        }
        if ((i3 & 2) == 0) {
            this.configSettings = null;
        } else {
            this.configSettings = configSettings2;
        }
        if ((i3 & 4) == 0) {
            this.endpoints = null;
        } else {
            this.endpoints = endpoints2;
        }
        if ((i3 & 8) == 0) {
            this.logMetricsSettings = null;
        } else {
            this.logMetricsSettings = logMetricsSettings2;
        }
        if ((i3 & 16) == 0) {
            this.placements = null;
        } else {
            this.placements = list;
        }
        if ((i3 & 32) == 0) {
            this.userPrivacy = null;
        } else {
            this.userPrivacy = userPrivacy2;
        }
        if ((i3 & 64) == 0) {
            this.viewAbility = null;
        } else {
            this.viewAbility = viewAbilitySettings;
        }
        if ((i3 & 128) == 0) {
            this.configExtension = null;
        } else {
            this.configExtension = str;
        }
        this.disableAdId = (i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0 ? Boolean.TRUE : bool;
        if ((i3 & 512) == 0) {
            this.isReportIncentivizedEnabled = null;
        } else {
            this.isReportIncentivizedEnabled = bool2;
        }
        if ((i3 & 1024) == 0) {
            this.sessionTimeout = null;
        } else {
            this.sessionTimeout = num;
        }
        if ((i3 & 2048) == 0) {
            this.waitForConnectivityForTPAT = null;
        } else {
            this.waitForConnectivityForTPAT = bool3;
        }
        if ((i3 & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0) {
            this.signalSessionTimeout = null;
        } else {
            this.signalSessionTimeout = num2;
        }
        if ((i3 & 8192) == 0) {
            this.isCacheableAssetsRequired = null;
        } else {
            this.isCacheableAssetsRequired = bool4;
        }
        if ((i3 & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.signalsDisabled = null;
        } else {
            this.signalsDisabled = bool5;
        }
        if ((32768 & i3) == 0) {
            this.fpdEnabled = null;
        } else {
            this.fpdEnabled = bool6;
        }
        if ((65536 & i3) == 0) {
            this.rtaDebugging = null;
        } else {
            this.rtaDebugging = bool7;
        }
        if ((131072 & i3) == 0) {
            this.configLastValidatedTimestamp = null;
        } else {
            this.configLastValidatedTimestamp = l2;
        }
        if ((i3 & 262144) == 0) {
            this.autoRedirect = null;
        } else {
            this.autoRedirect = autoRedirect2;
        }
    }

    public static /* synthetic */ ConfigPayload copy$default(ConfigPayload configPayload, CleverCache cleverCache2, ConfigSettings configSettings2, Endpoints endpoints2, LogMetricsSettings logMetricsSettings2, List list, UserPrivacy userPrivacy2, ViewAbilitySettings viewAbilitySettings, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Long l2, AutoRedirect autoRedirect2, int i2, Object obj) {
        ConfigPayload configPayload2 = configPayload;
        int i3 = i2;
        return configPayload.copy((i3 & 1) != 0 ? configPayload2.cleverCache : cleverCache2, (i3 & 2) != 0 ? configPayload2.configSettings : configSettings2, (i3 & 4) != 0 ? configPayload2.endpoints : endpoints2, (i3 & 8) != 0 ? configPayload2.logMetricsSettings : logMetricsSettings2, (i3 & 16) != 0 ? configPayload2.placements : list, (i3 & 32) != 0 ? configPayload2.userPrivacy : userPrivacy2, (i3 & 64) != 0 ? configPayload2.viewAbility : viewAbilitySettings, (i3 & 128) != 0 ? configPayload2.configExtension : str, (i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? configPayload2.disableAdId : bool, (i3 & 512) != 0 ? configPayload2.isReportIncentivizedEnabled : bool2, (i3 & 1024) != 0 ? configPayload2.sessionTimeout : num, (i3 & 2048) != 0 ? configPayload2.waitForConnectivityForTPAT : bool3, (i3 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? configPayload2.signalSessionTimeout : num2, (i3 & 8192) != 0 ? configPayload2.isCacheableAssetsRequired : bool4, (i3 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? configPayload2.signalsDisabled : bool5, (i3 & 32768) != 0 ? configPayload2.fpdEnabled : bool6, (i3 & 65536) != 0 ? configPayload2.rtaDebugging : bool7, (i3 & 131072) != 0 ? configPayload2.configLastValidatedTimestamp : l2, (i3 & 262144) != 0 ? configPayload2.autoRedirect : autoRedirect2);
    }

    public static /* synthetic */ void getAutoRedirect$annotations() {
    }

    public static /* synthetic */ void getCleverCache$annotations() {
    }

    public static /* synthetic */ void getConfigExtension$annotations() {
    }

    public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
    }

    public static /* synthetic */ void getConfigSettings$annotations() {
    }

    public static /* synthetic */ void getDisableAdId$annotations() {
    }

    public static /* synthetic */ void getEndpoints$annotations() {
    }

    public static /* synthetic */ void getFpdEnabled$annotations() {
    }

    public static /* synthetic */ void getLogMetricsSettings$annotations() {
    }

    public static /* synthetic */ void getPlacements$annotations() {
    }

    public static /* synthetic */ void getRtaDebugging$annotations() {
    }

    public static /* synthetic */ void getSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalsDisabled$annotations() {
    }

    public static /* synthetic */ void getUserPrivacy$annotations() {
    }

    public static /* synthetic */ void getViewAbility$annotations() {
    }

    public static /* synthetic */ void getWaitForConnectivityForTPAT$annotations() {
    }

    public static /* synthetic */ void isCacheableAssetsRequired$annotations() {
    }

    public static /* synthetic */ void isReportIncentivizedEnabled$annotations() {
    }

    public static final void write$Self(ConfigPayload configPayload, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
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
        boolean z19;
        Intrinsics.f(configPayload, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z20 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && configPayload.cleverCache == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, ConfigPayload$CleverCache$$serializer.INSTANCE, configPayload.cleverCache);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && configPayload.configSettings == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE, configPayload.configSettings);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && configPayload.endpoints == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, ConfigPayload$Endpoints$$serializer.INSTANCE, configPayload.endpoints);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && configPayload.logMetricsSettings == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, configPayload.logMetricsSettings);
        }
        if (!compositeEncoder.z(serialDescriptor, 4) && configPayload.placements == null) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            compositeEncoder.i(serialDescriptor, 4, new ArrayListSerializer(Placement$$serializer.INSTANCE), configPayload.placements);
        }
        if (!compositeEncoder.z(serialDescriptor, 5) && configPayload.userPrivacy == null) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            compositeEncoder.i(serialDescriptor, 5, ConfigPayload$UserPrivacy$$serializer.INSTANCE, configPayload.userPrivacy);
        }
        if (!compositeEncoder.z(serialDescriptor, 6) && configPayload.viewAbility == null) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8) {
            compositeEncoder.i(serialDescriptor, 6, ConfigPayload$ViewAbilitySettings$$serializer.INSTANCE, configPayload.viewAbility);
        }
        if (!compositeEncoder.z(serialDescriptor, 7) && configPayload.configExtension == null) {
            z9 = false;
        } else {
            z9 = true;
        }
        if (z9) {
            compositeEncoder.i(serialDescriptor, 7, StringSerializer.f41077a, configPayload.configExtension);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && Intrinsics.a(configPayload.disableAdId, Boolean.TRUE)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            compositeEncoder.i(serialDescriptor, 8, BooleanSerializer.f40947a, configPayload.disableAdId);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && configPayload.isReportIncentivizedEnabled == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.i(serialDescriptor, 9, BooleanSerializer.f40947a, configPayload.isReportIncentivizedEnabled);
        }
        if (!compositeEncoder.z(serialDescriptor, 10) && configPayload.sessionTimeout == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.i(serialDescriptor, 10, IntSerializer.f41006a, configPayload.sessionTimeout);
        }
        if (!compositeEncoder.z(serialDescriptor, 11) && configPayload.waitForConnectivityForTPAT == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.i(serialDescriptor, 11, BooleanSerializer.f40947a, configPayload.waitForConnectivityForTPAT);
        }
        if (!compositeEncoder.z(serialDescriptor, 12) && configPayload.signalSessionTimeout == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.i(serialDescriptor, 12, IntSerializer.f41006a, configPayload.signalSessionTimeout);
        }
        if (!compositeEncoder.z(serialDescriptor, 13) && configPayload.isCacheableAssetsRequired == null) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.i(serialDescriptor, 13, BooleanSerializer.f40947a, configPayload.isCacheableAssetsRequired);
        }
        if (!compositeEncoder.z(serialDescriptor, 14) && configPayload.signalsDisabled == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.i(serialDescriptor, 14, BooleanSerializer.f40947a, configPayload.signalsDisabled);
        }
        if (!compositeEncoder.z(serialDescriptor, 15) && configPayload.fpdEnabled == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.i(serialDescriptor, 15, BooleanSerializer.f40947a, configPayload.fpdEnabled);
        }
        if (!compositeEncoder.z(serialDescriptor, 16) && configPayload.rtaDebugging == null) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.i(serialDescriptor, 16, BooleanSerializer.f40947a, configPayload.rtaDebugging);
        }
        if (!compositeEncoder.z(serialDescriptor, 17) && configPayload.configLastValidatedTimestamp == null) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19) {
            compositeEncoder.i(serialDescriptor, 17, LongSerializer.f41017a, configPayload.configLastValidatedTimestamp);
        }
        if (compositeEncoder.z(serialDescriptor, 18) || configPayload.autoRedirect != null) {
            z20 = true;
        }
        if (z20) {
            compositeEncoder.i(serialDescriptor, 18, ConfigPayload$AutoRedirect$$serializer.INSTANCE, configPayload.autoRedirect);
        }
    }

    public final CleverCache component1() {
        return this.cleverCache;
    }

    public final Boolean component10() {
        return this.isReportIncentivizedEnabled;
    }

    public final Integer component11() {
        return this.sessionTimeout;
    }

    public final Boolean component12() {
        return this.waitForConnectivityForTPAT;
    }

    public final Integer component13() {
        return this.signalSessionTimeout;
    }

    public final Boolean component14() {
        return this.isCacheableAssetsRequired;
    }

    public final Boolean component15() {
        return this.signalsDisabled;
    }

    public final Boolean component16() {
        return this.fpdEnabled;
    }

    public final Boolean component17() {
        return this.rtaDebugging;
    }

    public final Long component18() {
        return this.configLastValidatedTimestamp;
    }

    public final AutoRedirect component19() {
        return this.autoRedirect;
    }

    public final ConfigSettings component2() {
        return this.configSettings;
    }

    public final Endpoints component3() {
        return this.endpoints;
    }

    public final LogMetricsSettings component4() {
        return this.logMetricsSettings;
    }

    public final List<Placement> component5() {
        return this.placements;
    }

    public final UserPrivacy component6() {
        return this.userPrivacy;
    }

    public final ViewAbilitySettings component7() {
        return this.viewAbility;
    }

    public final String component8() {
        return this.configExtension;
    }

    public final Boolean component9() {
        return this.disableAdId;
    }

    public final ConfigPayload copy(CleverCache cleverCache2, ConfigSettings configSettings2, Endpoints endpoints2, LogMetricsSettings logMetricsSettings2, List<Placement> list, UserPrivacy userPrivacy2, ViewAbilitySettings viewAbilitySettings, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Long l2, AutoRedirect autoRedirect2) {
        return new ConfigPayload(cleverCache2, configSettings2, endpoints2, logMetricsSettings2, list, userPrivacy2, viewAbilitySettings, str, bool, bool2, num, bool3, num2, bool4, bool5, bool6, bool7, l2, autoRedirect2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigPayload)) {
            return false;
        }
        ConfigPayload configPayload = (ConfigPayload) obj;
        return Intrinsics.a(this.cleverCache, configPayload.cleverCache) && Intrinsics.a(this.configSettings, configPayload.configSettings) && Intrinsics.a(this.endpoints, configPayload.endpoints) && Intrinsics.a(this.logMetricsSettings, configPayload.logMetricsSettings) && Intrinsics.a(this.placements, configPayload.placements) && Intrinsics.a(this.userPrivacy, configPayload.userPrivacy) && Intrinsics.a(this.viewAbility, configPayload.viewAbility) && Intrinsics.a(this.configExtension, configPayload.configExtension) && Intrinsics.a(this.disableAdId, configPayload.disableAdId) && Intrinsics.a(this.isReportIncentivizedEnabled, configPayload.isReportIncentivizedEnabled) && Intrinsics.a(this.sessionTimeout, configPayload.sessionTimeout) && Intrinsics.a(this.waitForConnectivityForTPAT, configPayload.waitForConnectivityForTPAT) && Intrinsics.a(this.signalSessionTimeout, configPayload.signalSessionTimeout) && Intrinsics.a(this.isCacheableAssetsRequired, configPayload.isCacheableAssetsRequired) && Intrinsics.a(this.signalsDisabled, configPayload.signalsDisabled) && Intrinsics.a(this.fpdEnabled, configPayload.fpdEnabled) && Intrinsics.a(this.rtaDebugging, configPayload.rtaDebugging) && Intrinsics.a(this.configLastValidatedTimestamp, configPayload.configLastValidatedTimestamp) && Intrinsics.a(this.autoRedirect, configPayload.autoRedirect);
    }

    public final AutoRedirect getAutoRedirect() {
        return this.autoRedirect;
    }

    public final CleverCache getCleverCache() {
        return this.cleverCache;
    }

    public final String getConfigExtension() {
        return this.configExtension;
    }

    public final Long getConfigLastValidatedTimestamp() {
        return this.configLastValidatedTimestamp;
    }

    public final ConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    public final Boolean getDisableAdId() {
        return this.disableAdId;
    }

    public final Endpoints getEndpoints() {
        return this.endpoints;
    }

    public final Boolean getFpdEnabled() {
        return this.fpdEnabled;
    }

    public final LogMetricsSettings getLogMetricsSettings() {
        return this.logMetricsSettings;
    }

    public final List<Placement> getPlacements() {
        return this.placements;
    }

    public final Boolean getRtaDebugging() {
        return this.rtaDebugging;
    }

    public final Integer getSessionTimeout() {
        return this.sessionTimeout;
    }

    public final Integer getSignalSessionTimeout() {
        return this.signalSessionTimeout;
    }

    public final Boolean getSignalsDisabled() {
        return this.signalsDisabled;
    }

    public final UserPrivacy getUserPrivacy() {
        return this.userPrivacy;
    }

    public final ViewAbilitySettings getViewAbility() {
        return this.viewAbility;
    }

    public final Boolean getWaitForConnectivityForTPAT() {
        return this.waitForConnectivityForTPAT;
    }

    public int hashCode() {
        CleverCache cleverCache2 = this.cleverCache;
        int i2 = 0;
        int hashCode = (cleverCache2 == null ? 0 : cleverCache2.hashCode()) * 31;
        ConfigSettings configSettings2 = this.configSettings;
        int hashCode2 = (hashCode + (configSettings2 == null ? 0 : configSettings2.hashCode())) * 31;
        Endpoints endpoints2 = this.endpoints;
        int hashCode3 = (hashCode2 + (endpoints2 == null ? 0 : endpoints2.hashCode())) * 31;
        LogMetricsSettings logMetricsSettings2 = this.logMetricsSettings;
        int hashCode4 = (hashCode3 + (logMetricsSettings2 == null ? 0 : logMetricsSettings2.hashCode())) * 31;
        List<Placement> list = this.placements;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        UserPrivacy userPrivacy2 = this.userPrivacy;
        int hashCode6 = (hashCode5 + (userPrivacy2 == null ? 0 : userPrivacy2.hashCode())) * 31;
        ViewAbilitySettings viewAbilitySettings = this.viewAbility;
        int hashCode7 = (hashCode6 + (viewAbilitySettings == null ? 0 : viewAbilitySettings.hashCode())) * 31;
        String str = this.configExtension;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.disableAdId;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isReportIncentivizedEnabled;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.sessionTimeout;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool3 = this.waitForConnectivityForTPAT;
        int hashCode12 = (hashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num2 = this.signalSessionTimeout;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool4 = this.isCacheableAssetsRequired;
        int hashCode14 = (hashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.signalsDisabled;
        int hashCode15 = (hashCode14 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.fpdEnabled;
        int hashCode16 = (hashCode15 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.rtaDebugging;
        int hashCode17 = (hashCode16 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Long l2 = this.configLastValidatedTimestamp;
        int hashCode18 = (hashCode17 + (l2 == null ? 0 : l2.hashCode())) * 31;
        AutoRedirect autoRedirect2 = this.autoRedirect;
        if (autoRedirect2 != null) {
            i2 = autoRedirect2.hashCode();
        }
        return hashCode18 + i2;
    }

    public final Boolean isCacheableAssetsRequired() {
        return this.isCacheableAssetsRequired;
    }

    public final Boolean isReportIncentivizedEnabled() {
        return this.isReportIncentivizedEnabled;
    }

    public final void setAutoRedirect(AutoRedirect autoRedirect2) {
        this.autoRedirect = autoRedirect2;
    }

    public final void setConfigLastValidatedTimestamp(Long l2) {
        this.configLastValidatedTimestamp = l2;
    }

    public String toString() {
        return "ConfigPayload(cleverCache=" + this.cleverCache + ", configSettings=" + this.configSettings + ", endpoints=" + this.endpoints + ", logMetricsSettings=" + this.logMetricsSettings + ", placements=" + this.placements + ", userPrivacy=" + this.userPrivacy + ", viewAbility=" + this.viewAbility + ", configExtension=" + this.configExtension + ", disableAdId=" + this.disableAdId + ", isReportIncentivizedEnabled=" + this.isReportIncentivizedEnabled + ", sessionTimeout=" + this.sessionTimeout + ", waitForConnectivityForTPAT=" + this.waitForConnectivityForTPAT + ", signalSessionTimeout=" + this.signalSessionTimeout + ", isCacheableAssetsRequired=" + this.isCacheableAssetsRequired + ", signalsDisabled=" + this.signalsDisabled + ", fpdEnabled=" + this.fpdEnabled + ", rtaDebugging=" + this.rtaDebugging + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ", autoRedirect=" + this.autoRedirect + ')';
    }

    public ConfigPayload(CleverCache cleverCache2, ConfigSettings configSettings2, Endpoints endpoints2, LogMetricsSettings logMetricsSettings2, List<Placement> list, UserPrivacy userPrivacy2, ViewAbilitySettings viewAbilitySettings, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Long l2, AutoRedirect autoRedirect2) {
        this.cleverCache = cleverCache2;
        this.configSettings = configSettings2;
        this.endpoints = endpoints2;
        this.logMetricsSettings = logMetricsSettings2;
        this.placements = list;
        this.userPrivacy = userPrivacy2;
        this.viewAbility = viewAbilitySettings;
        this.configExtension = str;
        this.disableAdId = bool;
        this.isReportIncentivizedEnabled = bool2;
        this.sessionTimeout = num;
        this.waitForConnectivityForTPAT = bool3;
        this.signalSessionTimeout = num2;
        this.isCacheableAssetsRequired = bool4;
        this.signalsDisabled = bool5;
        this.fpdEnabled = bool6;
        this.rtaDebugging = bool7;
        this.configLastValidatedTimestamp = l2;
        this.autoRedirect = autoRedirect2;
    }

    @Serializable
    public static final class AutoRedirect {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Long afterClickDuration;
        private final Boolean allowAutoRedirect;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AutoRedirect> serializer() {
                return ConfigPayload$AutoRedirect$$serializer.INSTANCE;
            }
        }

        public AutoRedirect() {
            this((Boolean) null, (Long) null, 3, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ AutoRedirect(int i2, Boolean bool, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$AutoRedirect$$serializer.INSTANCE.getDescriptor());
            }
            this.allowAutoRedirect = (i2 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i2 & 2) == 0) {
                this.afterClickDuration = Long.valueOf(Clock.MAX_TIME);
            } else {
                this.afterClickDuration = l2;
            }
        }

        public static /* synthetic */ AutoRedirect copy$default(AutoRedirect autoRedirect, Boolean bool, Long l2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = autoRedirect.allowAutoRedirect;
            }
            if ((i2 & 2) != 0) {
                l2 = autoRedirect.afterClickDuration;
            }
            return autoRedirect.copy(bool, l2);
        }

        public static /* synthetic */ void getAfterClickDuration$annotations() {
        }

        public static /* synthetic */ void getAllowAutoRedirect$annotations() {
        }

        public static final void write$Self(AutoRedirect autoRedirect, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Long l2;
            Intrinsics.f(autoRedirect, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && Intrinsics.a(autoRedirect.allowAutoRedirect, Boolean.FALSE)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f40947a, autoRedirect.allowAutoRedirect);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || (l2 = autoRedirect.afterClickDuration) == null || l2.longValue() != Clock.MAX_TIME) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, LongSerializer.f41017a, autoRedirect.afterClickDuration);
            }
        }

        public final Boolean component1() {
            return this.allowAutoRedirect;
        }

        public final Long component2() {
            return this.afterClickDuration;
        }

        public final AutoRedirect copy(Boolean bool, Long l2) {
            return new AutoRedirect(bool, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AutoRedirect)) {
                return false;
            }
            AutoRedirect autoRedirect = (AutoRedirect) obj;
            return Intrinsics.a(this.allowAutoRedirect, autoRedirect.allowAutoRedirect) && Intrinsics.a(this.afterClickDuration, autoRedirect.afterClickDuration);
        }

        public final Long getAfterClickDuration() {
            return this.afterClickDuration;
        }

        public final Boolean getAllowAutoRedirect() {
            return this.allowAutoRedirect;
        }

        public int hashCode() {
            Boolean bool = this.allowAutoRedirect;
            int i2 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l2 = this.afterClickDuration;
            if (l2 != null) {
                i2 = l2.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "AutoRedirect(allowAutoRedirect=" + this.allowAutoRedirect + ", afterClickDuration=" + this.afterClickDuration + ')';
        }

        public AutoRedirect(Boolean bool, Long l2) {
            this.allowAutoRedirect = bool;
            this.afterClickDuration = l2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AutoRedirect(Boolean bool, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? Long.valueOf(Clock.MAX_TIME) : l2);
        }
    }

    @Serializable
    public static final class CleverCache {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Integer diskPercentage;
        private final Long diskSize;
        private final Boolean enabled;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CleverCache> serializer() {
                return ConfigPayload$CleverCache$$serializer.INSTANCE;
            }
        }

        public CleverCache() {
            this((Boolean) null, (Long) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ CleverCache(int i2, Boolean bool, Long l2, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, ConfigPayload$CleverCache$$serializer.INSTANCE.getDescriptor());
            }
            this.enabled = (i2 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i2 & 2) == 0) {
                this.diskSize = 1000L;
            } else {
                this.diskSize = l2;
            }
            if ((i2 & 4) == 0) {
                this.diskPercentage = 3;
            } else {
                this.diskPercentage = num;
            }
        }

        public static /* synthetic */ CleverCache copy$default(CleverCache cleverCache, Boolean bool, Long l2, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = cleverCache.enabled;
            }
            if ((i2 & 2) != 0) {
                l2 = cleverCache.diskSize;
            }
            if ((i2 & 4) != 0) {
                num = cleverCache.diskPercentage;
            }
            return cleverCache.copy(bool, l2, num);
        }

        public static /* synthetic */ void getDiskPercentage$annotations() {
        }

        public static /* synthetic */ void getDiskSize$annotations() {
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }

        public static final void write$Self(CleverCache cleverCache, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            Integer num;
            Long l2;
            Intrinsics.f(cleverCache, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z4 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && Intrinsics.a(cleverCache.enabled, Boolean.FALSE)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f40947a, cleverCache.enabled);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && (l2 = cleverCache.diskSize) != null && l2.longValue() == 1000) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, LongSerializer.f41017a, cleverCache.diskSize);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || (num = cleverCache.diskPercentage) == null || num.intValue() != 3) {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, IntSerializer.f41006a, cleverCache.diskPercentage);
            }
        }

        public final Boolean component1() {
            return this.enabled;
        }

        public final Long component2() {
            return this.diskSize;
        }

        public final Integer component3() {
            return this.diskPercentage;
        }

        public final CleverCache copy(Boolean bool, Long l2, Integer num) {
            return new CleverCache(bool, l2, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CleverCache)) {
                return false;
            }
            CleverCache cleverCache = (CleverCache) obj;
            return Intrinsics.a(this.enabled, cleverCache.enabled) && Intrinsics.a(this.diskSize, cleverCache.diskSize) && Intrinsics.a(this.diskPercentage, cleverCache.diskPercentage);
        }

        public final Integer getDiskPercentage() {
            return this.diskPercentage;
        }

        public final Long getDiskSize() {
            return this.diskSize;
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            Boolean bool = this.enabled;
            int i2 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l2 = this.diskSize;
            int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Integer num = this.diskPercentage;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            return "CleverCache(enabled=" + this.enabled + ", diskSize=" + this.diskSize + ", diskPercentage=" + this.diskPercentage + ')';
        }

        public CleverCache(Boolean bool, Long l2, Integer num) {
            this.enabled = bool;
            this.diskSize = l2;
            this.diskPercentage = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CleverCache(Boolean bool, Long l2, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? 1000L : l2, (i2 & 4) != 0 ? 3 : num);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConfigPayload(com.vungle.ads.internal.model.ConfigPayload.CleverCache r21, com.vungle.ads.internal.model.ConfigPayload.ConfigSettings r22, com.vungle.ads.internal.model.ConfigPayload.Endpoints r23, com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings r24, java.util.List r25, com.vungle.ads.internal.model.ConfigPayload.UserPrivacy r26, com.vungle.ads.internal.model.ConfigPayload.ViewAbilitySettings r27, java.lang.String r28, java.lang.Boolean r29, java.lang.Boolean r30, java.lang.Integer r31, java.lang.Boolean r32, java.lang.Integer r33, java.lang.Boolean r34, java.lang.Boolean r35, java.lang.Boolean r36, java.lang.Boolean r37, java.lang.Long r38, com.vungle.ads.internal.model.ConfigPayload.AutoRedirect r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r22
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r23
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r24
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r25
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r26
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r27
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r28
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            goto L_0x004b
        L_0x0049:
            r10 = r29
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = 0
            goto L_0x0053
        L_0x0051:
            r11 = r30
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = 0
            goto L_0x005b
        L_0x0059:
            r12 = r31
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = 0
            goto L_0x0063
        L_0x0061:
            r13 = r32
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = 0
            goto L_0x006b
        L_0x0069:
            r14 = r33
        L_0x006b:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0071
            r15 = 0
            goto L_0x0073
        L_0x0071:
            r15 = r34
        L_0x0073:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0079
            r2 = 0
            goto L_0x007b
        L_0x0079:
            r2 = r35
        L_0x007b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0085
            r16 = 0
            goto L_0x0087
        L_0x0085:
            r16 = r36
        L_0x0087:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0090
            r17 = 0
            goto L_0x0092
        L_0x0090:
            r17 = r37
        L_0x0092:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009b
            r18 = 0
            goto L_0x009d
        L_0x009b:
            r18 = r38
        L_0x009d:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00a5
            r0 = 0
            goto L_0x00a7
        L_0x00a5:
            r0 = r39
        L_0x00a7:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r2
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload.<init>(com.vungle.ads.internal.model.ConfigPayload$CleverCache, com.vungle.ads.internal.model.ConfigPayload$ConfigSettings, com.vungle.ads.internal.model.ConfigPayload$Endpoints, com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings, java.util.List, com.vungle.ads.internal.model.ConfigPayload$UserPrivacy, com.vungle.ads.internal.model.ConfigPayload$ViewAbilitySettings, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Long, com.vungle.ads.internal.model.ConfigPayload$AutoRedirect, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

package com.vungle.ads.internal.model;

import b0.y;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.fpd.FirstPartyData$$serializer;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
public final class CommonRequestBody {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AppNode app;
    private final DeviceNode device;
    private RequestExt ext;
    private RequestParam request;
    private final User user;

    @Serializable
    public static final class CCPA {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String status;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CCPA> serializer() {
                return CommonRequestBody$CCPA$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CCPA(int i2, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i2 & 1)) {
                PluginExceptionsKt.a(i2, 1, CommonRequestBody$CCPA$$serializer.INSTANCE.getDescriptor());
            }
            this.status = str;
        }

        public static /* synthetic */ CCPA copy$default(CCPA ccpa, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = ccpa.status;
            }
            return ccpa.copy(str);
        }

        public static final void write$Self(CCPA ccpa, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(ccpa, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            compositeEncoder.y(serialDescriptor, 0, ccpa.status);
        }

        public final String component1() {
            return this.status;
        }

        public final CCPA copy(String str) {
            Intrinsics.f(str, "status");
            return new CCPA(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CCPA) && Intrinsics.a(this.status, ((CCPA) obj).status);
        }

        public final String getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        public String toString() {
            return "CCPA(status=" + this.status + ')';
        }

        public CCPA(String str) {
            Intrinsics.f(str, "status");
            this.status = str;
        }
    }

    @Serializable
    public static final class COPPA {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Boolean isCoppa;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<COPPA> serializer() {
                return CommonRequestBody$COPPA$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ COPPA(int i2, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i2 & 1)) {
                PluginExceptionsKt.a(i2, 1, CommonRequestBody$COPPA$$serializer.INSTANCE.getDescriptor());
            }
            this.isCoppa = bool;
        }

        public static /* synthetic */ COPPA copy$default(COPPA coppa, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = coppa.isCoppa;
            }
            return coppa.copy(bool);
        }

        public static /* synthetic */ void isCoppa$annotations() {
        }

        public static final void write$Self(COPPA coppa, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(coppa, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f40947a, coppa.isCoppa);
        }

        public final Boolean component1() {
            return this.isCoppa;
        }

        public final COPPA copy(Boolean bool) {
            return new COPPA(bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof COPPA) && Intrinsics.a(this.isCoppa, ((COPPA) obj).isCoppa);
        }

        public int hashCode() {
            Boolean bool = this.isCoppa;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public final Boolean isCoppa() {
            return this.isCoppa;
        }

        public String toString() {
            return "COPPA(isCoppa=" + this.isCoppa + ')';
        }

        public COPPA(Boolean bool) {
            this.isCoppa = bool;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CommonRequestBody> serializer() {
            return CommonRequestBody$$serializer.INSTANCE;
        }
    }

    @Serializable
    public static final class GDPR {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String consentMessageVersion;
        private final String consentSource;
        private final String consentStatus;
        private final long consentTimestamp;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<GDPR> serializer() {
                return CommonRequestBody$GDPR$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ GDPR(int i2, String str, String str2, long j2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i2 & 15)) {
                PluginExceptionsKt.a(i2, 15, CommonRequestBody$GDPR$$serializer.INSTANCE.getDescriptor());
            }
            this.consentStatus = str;
            this.consentSource = str2;
            this.consentTimestamp = j2;
            this.consentMessageVersion = str3;
        }

        public static /* synthetic */ GDPR copy$default(GDPR gdpr, String str, String str2, long j2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = gdpr.consentStatus;
            }
            if ((i2 & 2) != 0) {
                str2 = gdpr.consentSource;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                j2 = gdpr.consentTimestamp;
            }
            long j3 = j2;
            if ((i2 & 8) != 0) {
                str3 = gdpr.consentMessageVersion;
            }
            return gdpr.copy(str, str4, j3, str3);
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentSource$annotations() {
        }

        public static /* synthetic */ void getConsentStatus$annotations() {
        }

        public static /* synthetic */ void getConsentTimestamp$annotations() {
        }

        public static final void write$Self(GDPR gdpr, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(gdpr, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            compositeEncoder.y(serialDescriptor, 0, gdpr.consentStatus);
            compositeEncoder.y(serialDescriptor, 1, gdpr.consentSource);
            compositeEncoder.F(serialDescriptor, 2, gdpr.consentTimestamp);
            compositeEncoder.y(serialDescriptor, 3, gdpr.consentMessageVersion);
        }

        public final String component1() {
            return this.consentStatus;
        }

        public final String component2() {
            return this.consentSource;
        }

        public final long component3() {
            return this.consentTimestamp;
        }

        public final String component4() {
            return this.consentMessageVersion;
        }

        public final GDPR copy(String str, String str2, long j2, String str3) {
            Intrinsics.f(str, "consentStatus");
            Intrinsics.f(str2, "consentSource");
            Intrinsics.f(str3, "consentMessageVersion");
            return new GDPR(str, str2, j2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GDPR)) {
                return false;
            }
            GDPR gdpr = (GDPR) obj;
            return Intrinsics.a(this.consentStatus, gdpr.consentStatus) && Intrinsics.a(this.consentSource, gdpr.consentSource) && this.consentTimestamp == gdpr.consentTimestamp && Intrinsics.a(this.consentMessageVersion, gdpr.consentMessageVersion);
        }

        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        public final String getConsentSource() {
            return this.consentSource;
        }

        public final String getConsentStatus() {
            return this.consentStatus;
        }

        public final long getConsentTimestamp() {
            return this.consentTimestamp;
        }

        public int hashCode() {
            return (((((this.consentStatus.hashCode() * 31) + this.consentSource.hashCode()) * 31) + y.a(this.consentTimestamp)) * 31) + this.consentMessageVersion.hashCode();
        }

        public String toString() {
            return "GDPR(consentStatus=" + this.consentStatus + ", consentSource=" + this.consentSource + ", consentTimestamp=" + this.consentTimestamp + ", consentMessageVersion=" + this.consentMessageVersion + ')';
        }

        public GDPR(String str, String str2, long j2, String str3) {
            Intrinsics.f(str, "consentStatus");
            Intrinsics.f(str2, "consentSource");
            Intrinsics.f(str3, "consentMessageVersion");
            this.consentStatus = str;
            this.consentSource = str2;
            this.consentTimestamp = j2;
            this.consentMessageVersion = str3;
        }
    }

    @Serializable
    public static final class IAB {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String tcf;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<IAB> serializer() {
                return CommonRequestBody$IAB$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IAB(int i2, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i2 & 1)) {
                PluginExceptionsKt.a(i2, 1, CommonRequestBody$IAB$$serializer.INSTANCE.getDescriptor());
            }
            this.tcf = str;
        }

        public static /* synthetic */ IAB copy$default(IAB iab, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = iab.tcf;
            }
            return iab.copy(str);
        }

        public static /* synthetic */ void getTcf$annotations() {
        }

        public static final void write$Self(IAB iab, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(iab, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            compositeEncoder.y(serialDescriptor, 0, iab.tcf);
        }

        public final String component1() {
            return this.tcf;
        }

        public final IAB copy(String str) {
            Intrinsics.f(str, "tcf");
            return new IAB(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IAB) && Intrinsics.a(this.tcf, ((IAB) obj).tcf);
        }

        public final String getTcf() {
            return this.tcf;
        }

        public int hashCode() {
            return this.tcf.hashCode();
        }

        public String toString() {
            return "IAB(tcf=" + this.tcf + ')';
        }

        public IAB(String str) {
            Intrinsics.f(str, "tcf");
            this.tcf = str;
        }
    }

    @Serializable
    public static final class RequestExt {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String configExtension;
        private final Long configLastValidatedTimestamp;
        private String signals;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<RequestExt> serializer() {
                return CommonRequestBody$RequestExt$$serializer.INSTANCE;
            }
        }

        public RequestExt() {
            this((String) null, (String) null, (Long) null, 7, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ RequestExt(int i2, String str, String str2, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, CommonRequestBody$RequestExt$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.configExtension = null;
            } else {
                this.configExtension = str;
            }
            if ((i2 & 2) == 0) {
                this.signals = null;
            } else {
                this.signals = str2;
            }
            if ((i2 & 4) == 0) {
                this.configLastValidatedTimestamp = null;
            } else {
                this.configLastValidatedTimestamp = l2;
            }
        }

        public static /* synthetic */ RequestExt copy$default(RequestExt requestExt, String str, String str2, Long l2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = requestExt.configExtension;
            }
            if ((i2 & 2) != 0) {
                str2 = requestExt.signals;
            }
            if ((i2 & 4) != 0) {
                l2 = requestExt.configLastValidatedTimestamp;
            }
            return requestExt.copy(str, str2, l2);
        }

        public static /* synthetic */ void getConfigExtension$annotations() {
        }

        public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
        }

        public static /* synthetic */ void getSignals$annotations() {
        }

        public static final void write$Self(RequestExt requestExt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            Intrinsics.f(requestExt, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z4 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && requestExt.configExtension == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, requestExt.configExtension);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && requestExt.signals == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, requestExt.signals);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || requestExt.configLastValidatedTimestamp != null) {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, LongSerializer.f41017a, requestExt.configLastValidatedTimestamp);
            }
        }

        public final String component1() {
            return this.configExtension;
        }

        public final String component2() {
            return this.signals;
        }

        public final Long component3() {
            return this.configLastValidatedTimestamp;
        }

        public final RequestExt copy(String str, String str2, Long l2) {
            return new RequestExt(str, str2, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestExt)) {
                return false;
            }
            RequestExt requestExt = (RequestExt) obj;
            return Intrinsics.a(this.configExtension, requestExt.configExtension) && Intrinsics.a(this.signals, requestExt.signals) && Intrinsics.a(this.configLastValidatedTimestamp, requestExt.configLastValidatedTimestamp);
        }

        public final String getConfigExtension() {
            return this.configExtension;
        }

        public final Long getConfigLastValidatedTimestamp() {
            return this.configLastValidatedTimestamp;
        }

        public final String getSignals() {
            return this.signals;
        }

        public int hashCode() {
            String str = this.configExtension;
            int i2 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.signals;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l2 = this.configLastValidatedTimestamp;
            if (l2 != null) {
                i2 = l2.hashCode();
            }
            return hashCode2 + i2;
        }

        public final void setSignals(String str) {
            this.signals = str;
        }

        public String toString() {
            return "RequestExt(configExtension=" + this.configExtension + ", signals=" + this.signals + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ')';
        }

        public RequestExt(String str, String str2, Long l2) {
            this.configExtension = str;
            this.signals = str2;
            this.configLastValidatedTimestamp = l2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RequestExt(String str, String str2, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : l2);
        }
    }

    @Serializable
    public static final class RequestParam {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private AdSizeParam adSize;
        private final Long adStartTime;
        private final String advAppId;
        private final String placementReferenceId;
        private final List<String> placements;
        private final String user;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<RequestParam> serializer() {
                return CommonRequestBody$RequestParam$$serializer.INSTANCE;
            }
        }

        public RequestParam() {
            this((List) null, (AdSizeParam) null, (Long) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ RequestParam(int i2, List list, AdSizeParam adSizeParam, Long l2, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, CommonRequestBody$RequestParam$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.placements = null;
            } else {
                this.placements = list;
            }
            if ((i2 & 2) == 0) {
                this.adSize = null;
            } else {
                this.adSize = adSizeParam;
            }
            if ((i2 & 4) == 0) {
                this.adStartTime = null;
            } else {
                this.adStartTime = l2;
            }
            if ((i2 & 8) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str;
            }
            if ((i2 & 16) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str2;
            }
            if ((i2 & 32) == 0) {
                this.user = null;
            } else {
                this.user = str3;
            }
        }

        public static /* synthetic */ RequestParam copy$default(RequestParam requestParam, List<String> list, AdSizeParam adSizeParam, Long l2, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = requestParam.placements;
            }
            if ((i2 & 2) != 0) {
                adSizeParam = requestParam.adSize;
            }
            AdSizeParam adSizeParam2 = adSizeParam;
            if ((i2 & 4) != 0) {
                l2 = requestParam.adStartTime;
            }
            Long l3 = l2;
            if ((i2 & 8) != 0) {
                str = requestParam.advAppId;
            }
            String str4 = str;
            if ((i2 & 16) != 0) {
                str2 = requestParam.placementReferenceId;
            }
            String str5 = str2;
            if ((i2 & 32) != 0) {
                str3 = requestParam.user;
            }
            return requestParam.copy(list, adSizeParam2, l3, str4, str5, str3);
        }

        public static /* synthetic */ void getAdSize$annotations() {
        }

        public static /* synthetic */ void getAdStartTime$annotations() {
        }

        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }

        public static final void write$Self(RequestParam requestParam, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            Intrinsics.f(requestParam, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z7 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && requestParam.placements == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, new ArrayListSerializer(StringSerializer.f41077a), requestParam.placements);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && requestParam.adSize == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, CommonRequestBody$AdSizeParam$$serializer.INSTANCE, requestParam.adSize);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && requestParam.adStartTime == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, LongSerializer.f41017a, requestParam.adStartTime);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && requestParam.advAppId == null) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                compositeEncoder.i(serialDescriptor, 3, StringSerializer.f41077a, requestParam.advAppId);
            }
            if (!compositeEncoder.z(serialDescriptor, 4) && requestParam.placementReferenceId == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z6) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f41077a, requestParam.placementReferenceId);
            }
            if (compositeEncoder.z(serialDescriptor, 5) || requestParam.user != null) {
                z7 = true;
            }
            if (z7) {
                compositeEncoder.i(serialDescriptor, 5, StringSerializer.f41077a, requestParam.user);
            }
        }

        public final List<String> component1() {
            return this.placements;
        }

        public final AdSizeParam component2() {
            return this.adSize;
        }

        public final Long component3() {
            return this.adStartTime;
        }

        public final String component4() {
            return this.advAppId;
        }

        public final String component5() {
            return this.placementReferenceId;
        }

        public final String component6() {
            return this.user;
        }

        public final RequestParam copy(List<String> list, AdSizeParam adSizeParam, Long l2, String str, String str2, String str3) {
            return new RequestParam(list, adSizeParam, l2, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestParam)) {
                return false;
            }
            RequestParam requestParam = (RequestParam) obj;
            return Intrinsics.a(this.placements, requestParam.placements) && Intrinsics.a(this.adSize, requestParam.adSize) && Intrinsics.a(this.adStartTime, requestParam.adStartTime) && Intrinsics.a(this.advAppId, requestParam.advAppId) && Intrinsics.a(this.placementReferenceId, requestParam.placementReferenceId) && Intrinsics.a(this.user, requestParam.user);
        }

        public final AdSizeParam getAdSize() {
            return this.adSize;
        }

        public final Long getAdStartTime() {
            return this.adStartTime;
        }

        public final String getAdvAppId() {
            return this.advAppId;
        }

        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        public final List<String> getPlacements() {
            return this.placements;
        }

        public final String getUser() {
            return this.user;
        }

        public int hashCode() {
            List<String> list = this.placements;
            int i2 = 0;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            AdSizeParam adSizeParam = this.adSize;
            int hashCode2 = (hashCode + (adSizeParam == null ? 0 : adSizeParam.hashCode())) * 31;
            Long l2 = this.adStartTime;
            int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str = this.advAppId;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.placementReferenceId;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.user;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode5 + i2;
        }

        public final void setAdSize(AdSizeParam adSizeParam) {
            this.adSize = adSizeParam;
        }

        public String toString() {
            return "RequestParam(placements=" + this.placements + ", adSize=" + this.adSize + ", adStartTime=" + this.adStartTime + ", advAppId=" + this.advAppId + ", placementReferenceId=" + this.placementReferenceId + ", user=" + this.user + ')';
        }

        public RequestParam(List<String> list, AdSizeParam adSizeParam, Long l2, String str, String str2, String str3) {
            this.placements = list;
            this.adSize = adSizeParam;
            this.adStartTime = l2;
            this.advAppId = str;
            this.placementReferenceId = str2;
            this.user = str3;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ RequestParam(java.util.List r6, com.vungle.ads.internal.model.CommonRequestBody.AdSizeParam r7, java.lang.Long r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.CommonRequestBody.RequestParam.<init>(java.util.List, com.vungle.ads.internal.model.CommonRequestBody$AdSizeParam, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    @Serializable
    public static final class User {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private CCPA ccpa;
        private COPPA coppa;
        private FirstPartyData fpd;
        private GDPR gdpr;
        private IAB iab;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<User> serializer() {
                return CommonRequestBody$User$$serializer.INSTANCE;
            }
        }

        public User() {
            this((GDPR) null, (CCPA) null, (COPPA) null, (FirstPartyData) null, (IAB) null, 31, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ User(int i2, GDPR gdpr2, CCPA ccpa2, COPPA coppa2, FirstPartyData firstPartyData, IAB iab2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, CommonRequestBody$User$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = gdpr2;
            }
            if ((i2 & 2) == 0) {
                this.ccpa = null;
            } else {
                this.ccpa = ccpa2;
            }
            if ((i2 & 4) == 0) {
                this.coppa = null;
            } else {
                this.coppa = coppa2;
            }
            if ((i2 & 8) == 0) {
                this.fpd = null;
            } else {
                this.fpd = firstPartyData;
            }
            if ((i2 & 16) == 0) {
                this.iab = null;
            } else {
                this.iab = iab2;
            }
        }

        public static /* synthetic */ User copy$default(User user, GDPR gdpr2, CCPA ccpa2, COPPA coppa2, FirstPartyData firstPartyData, IAB iab2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                gdpr2 = user.gdpr;
            }
            if ((i2 & 2) != 0) {
                ccpa2 = user.ccpa;
            }
            CCPA ccpa3 = ccpa2;
            if ((i2 & 4) != 0) {
                coppa2 = user.coppa;
            }
            COPPA coppa3 = coppa2;
            if ((i2 & 8) != 0) {
                firstPartyData = user.fpd;
            }
            FirstPartyData firstPartyData2 = firstPartyData;
            if ((i2 & 16) != 0) {
                iab2 = user.iab;
            }
            return user.copy(gdpr2, ccpa3, coppa3, firstPartyData2, iab2);
        }

        public static final void write$Self(User user, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            Intrinsics.f(user, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z6 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && user.gdpr == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, CommonRequestBody$GDPR$$serializer.INSTANCE, user.gdpr);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && user.ccpa == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, CommonRequestBody$CCPA$$serializer.INSTANCE, user.ccpa);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && user.coppa == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, CommonRequestBody$COPPA$$serializer.INSTANCE, user.coppa);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && user.fpd == null) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                compositeEncoder.i(serialDescriptor, 3, FirstPartyData$$serializer.INSTANCE, user.fpd);
            }
            if (compositeEncoder.z(serialDescriptor, 4) || user.iab != null) {
                z6 = true;
            }
            if (z6) {
                compositeEncoder.i(serialDescriptor, 4, CommonRequestBody$IAB$$serializer.INSTANCE, user.iab);
            }
        }

        public final GDPR component1() {
            return this.gdpr;
        }

        public final CCPA component2() {
            return this.ccpa;
        }

        public final COPPA component3() {
            return this.coppa;
        }

        public final FirstPartyData component4() {
            return this.fpd;
        }

        public final IAB component5() {
            return this.iab;
        }

        public final User copy(GDPR gdpr2, CCPA ccpa2, COPPA coppa2, FirstPartyData firstPartyData, IAB iab2) {
            return new User(gdpr2, ccpa2, coppa2, firstPartyData, iab2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            return Intrinsics.a(this.gdpr, user.gdpr) && Intrinsics.a(this.ccpa, user.ccpa) && Intrinsics.a(this.coppa, user.coppa) && Intrinsics.a(this.fpd, user.fpd) && Intrinsics.a(this.iab, user.iab);
        }

        public final CCPA getCcpa() {
            return this.ccpa;
        }

        public final COPPA getCoppa() {
            return this.coppa;
        }

        public final FirstPartyData getFpd() {
            return this.fpd;
        }

        public final GDPR getGdpr() {
            return this.gdpr;
        }

        public final IAB getIab() {
            return this.iab;
        }

        public int hashCode() {
            GDPR gdpr2 = this.gdpr;
            int i2 = 0;
            int hashCode = (gdpr2 == null ? 0 : gdpr2.hashCode()) * 31;
            CCPA ccpa2 = this.ccpa;
            int hashCode2 = (hashCode + (ccpa2 == null ? 0 : ccpa2.hashCode())) * 31;
            COPPA coppa2 = this.coppa;
            int hashCode3 = (hashCode2 + (coppa2 == null ? 0 : coppa2.hashCode())) * 31;
            FirstPartyData firstPartyData = this.fpd;
            int hashCode4 = (hashCode3 + (firstPartyData == null ? 0 : firstPartyData.hashCode())) * 31;
            IAB iab2 = this.iab;
            if (iab2 != null) {
                i2 = iab2.hashCode();
            }
            return hashCode4 + i2;
        }

        public final void setCcpa(CCPA ccpa2) {
            this.ccpa = ccpa2;
        }

        public final void setCoppa(COPPA coppa2) {
            this.coppa = coppa2;
        }

        public final void setFpd(FirstPartyData firstPartyData) {
            this.fpd = firstPartyData;
        }

        public final void setGdpr(GDPR gdpr2) {
            this.gdpr = gdpr2;
        }

        public final void setIab(IAB iab2) {
            this.iab = iab2;
        }

        public String toString() {
            return "User(gdpr=" + this.gdpr + ", ccpa=" + this.ccpa + ", coppa=" + this.coppa + ", fpd=" + this.fpd + ", iab=" + this.iab + ')';
        }

        public User(GDPR gdpr2, CCPA ccpa2, COPPA coppa2, FirstPartyData firstPartyData, IAB iab2) {
            this.gdpr = gdpr2;
            this.ccpa = ccpa2;
            this.coppa = coppa2;
            this.fpd = firstPartyData;
            this.iab = iab2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ User(com.vungle.ads.internal.model.CommonRequestBody.GDPR r5, com.vungle.ads.internal.model.CommonRequestBody.CCPA r6, com.vungle.ads.internal.model.CommonRequestBody.COPPA r7, com.vungle.ads.fpd.FirstPartyData r8, com.vungle.ads.internal.model.CommonRequestBody.IAB r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.CommonRequestBody.User.<init>(com.vungle.ads.internal.model.CommonRequestBody$GDPR, com.vungle.ads.internal.model.CommonRequestBody$CCPA, com.vungle.ads.internal.model.CommonRequestBody$COPPA, com.vungle.ads.fpd.FirstPartyData, com.vungle.ads.internal.model.CommonRequestBody$IAB, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public /* synthetic */ CommonRequestBody(int i2, DeviceNode deviceNode, AppNode appNode, User user2, RequestExt requestExt, RequestParam requestParam, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i2 & 1)) {
            PluginExceptionsKt.a(i2, 1, CommonRequestBody$$serializer.INSTANCE.getDescriptor());
        }
        this.device = deviceNode;
        if ((i2 & 2) == 0) {
            this.app = null;
        } else {
            this.app = appNode;
        }
        if ((i2 & 4) == 0) {
            this.user = null;
        } else {
            this.user = user2;
        }
        if ((i2 & 8) == 0) {
            this.ext = null;
        } else {
            this.ext = requestExt;
        }
        if ((i2 & 16) == 0) {
            this.request = null;
        } else {
            this.request = requestParam;
        }
    }

    public static /* synthetic */ CommonRequestBody copy$default(CommonRequestBody commonRequestBody, DeviceNode deviceNode, AppNode appNode, User user2, RequestExt requestExt, RequestParam requestParam, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deviceNode = commonRequestBody.device;
        }
        if ((i2 & 2) != 0) {
            appNode = commonRequestBody.app;
        }
        AppNode appNode2 = appNode;
        if ((i2 & 4) != 0) {
            user2 = commonRequestBody.user;
        }
        User user3 = user2;
        if ((i2 & 8) != 0) {
            requestExt = commonRequestBody.ext;
        }
        RequestExt requestExt2 = requestExt;
        if ((i2 & 16) != 0) {
            requestParam = commonRequestBody.request;
        }
        return commonRequestBody.copy(deviceNode, appNode2, user3, requestExt2, requestParam);
    }

    public static final void write$Self(CommonRequestBody commonRequestBody, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(commonRequestBody, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z5 = false;
        compositeEncoder.C(serialDescriptor, 0, DeviceNode$$serializer.INSTANCE, commonRequestBody.device);
        if (!compositeEncoder.z(serialDescriptor, 1) && commonRequestBody.app == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 1, AppNode$$serializer.INSTANCE, commonRequestBody.app);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && commonRequestBody.user == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 2, CommonRequestBody$User$$serializer.INSTANCE, commonRequestBody.user);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && commonRequestBody.ext == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 3, CommonRequestBody$RequestExt$$serializer.INSTANCE, commonRequestBody.ext);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || commonRequestBody.request != null) {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 4, CommonRequestBody$RequestParam$$serializer.INSTANCE, commonRequestBody.request);
        }
    }

    public final DeviceNode component1() {
        return this.device;
    }

    public final AppNode component2() {
        return this.app;
    }

    public final User component3() {
        return this.user;
    }

    public final RequestExt component4() {
        return this.ext;
    }

    public final RequestParam component5() {
        return this.request;
    }

    public final CommonRequestBody copy(DeviceNode deviceNode, AppNode appNode, User user2, RequestExt requestExt, RequestParam requestParam) {
        Intrinsics.f(deviceNode, "device");
        return new CommonRequestBody(deviceNode, appNode, user2, requestExt, requestParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonRequestBody)) {
            return false;
        }
        CommonRequestBody commonRequestBody = (CommonRequestBody) obj;
        return Intrinsics.a(this.device, commonRequestBody.device) && Intrinsics.a(this.app, commonRequestBody.app) && Intrinsics.a(this.user, commonRequestBody.user) && Intrinsics.a(this.ext, commonRequestBody.ext) && Intrinsics.a(this.request, commonRequestBody.request);
    }

    public final AppNode getApp() {
        return this.app;
    }

    public final DeviceNode getDevice() {
        return this.device;
    }

    public final RequestExt getExt() {
        return this.ext;
    }

    public final RequestParam getRequest() {
        return this.request;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.device.hashCode() * 31;
        AppNode appNode = this.app;
        int i2 = 0;
        int hashCode2 = (hashCode + (appNode == null ? 0 : appNode.hashCode())) * 31;
        User user2 = this.user;
        int hashCode3 = (hashCode2 + (user2 == null ? 0 : user2.hashCode())) * 31;
        RequestExt requestExt = this.ext;
        int hashCode4 = (hashCode3 + (requestExt == null ? 0 : requestExt.hashCode())) * 31;
        RequestParam requestParam = this.request;
        if (requestParam != null) {
            i2 = requestParam.hashCode();
        }
        return hashCode4 + i2;
    }

    public final void setExt(RequestExt requestExt) {
        this.ext = requestExt;
    }

    public final void setRequest(RequestParam requestParam) {
        this.request = requestParam;
    }

    public String toString() {
        return "CommonRequestBody(device=" + this.device + ", app=" + this.app + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ')';
    }

    @Serializable
    public static final class AdSizeParam {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int height;
        private final int width;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AdSizeParam> serializer() {
                return CommonRequestBody$AdSizeParam$$serializer.INSTANCE;
            }
        }

        public AdSizeParam(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }

        public static /* synthetic */ AdSizeParam copy$default(AdSizeParam adSizeParam, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = adSizeParam.width;
            }
            if ((i4 & 2) != 0) {
                i3 = adSizeParam.height;
            }
            return adSizeParam.copy(i2, i3);
        }

        public static /* synthetic */ void getHeight$annotations() {
        }

        public static /* synthetic */ void getWidth$annotations() {
        }

        public static final void write$Self(AdSizeParam adSizeParam, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(adSizeParam, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            compositeEncoder.w(serialDescriptor, 0, adSizeParam.width);
            compositeEncoder.w(serialDescriptor, 1, adSizeParam.height);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        public final AdSizeParam copy(int i2, int i3) {
            return new AdSizeParam(i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdSizeParam)) {
                return false;
            }
            AdSizeParam adSizeParam = (AdSizeParam) obj;
            return this.width == adSizeParam.width && this.height == adSizeParam.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (this.width * 31) + this.height;
        }

        public String toString() {
            return "AdSizeParam(width=" + this.width + ", height=" + this.height + ')';
        }

        public /* synthetic */ AdSizeParam(int i2, int i3, int i4, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i2 & 3)) {
                PluginExceptionsKt.a(i2, 3, CommonRequestBody$AdSizeParam$$serializer.INSTANCE.getDescriptor());
            }
            this.width = i3;
            this.height = i4;
        }
    }

    public CommonRequestBody(DeviceNode deviceNode, AppNode appNode, User user2, RequestExt requestExt, RequestParam requestParam) {
        Intrinsics.f(deviceNode, "device");
        this.device = deviceNode;
        this.app = appNode;
        this.user = user2;
        this.ext = requestExt;
        this.request = requestParam;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonRequestBody(DeviceNode deviceNode, AppNode appNode, User user2, RequestExt requestExt, RequestParam requestParam, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceNode, (i2 & 2) != 0 ? null : appNode, (i2 & 4) != 0 ? null : user2, (i2 & 8) != 0 ? null : requestExt, (i2 & 16) != 0 ? null : requestParam);
    }
}

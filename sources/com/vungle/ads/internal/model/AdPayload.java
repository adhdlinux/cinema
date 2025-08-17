package com.vungle.ads.internal.model;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import com.vungle.ads.AdConfig;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonTransformingSerializer;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

@Serializable
public final class AdPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FILE_SCHEME = "file://";
    public static final String INCENTIVIZED_BODY_TEXT = "INCENTIVIZED_BODY_TEXT";
    public static final String INCENTIVIZED_CLOSE_TEXT = "INCENTIVIZED_CLOSE_TEXT";
    public static final String INCENTIVIZED_CONTINUE_TEXT = "INCENTIVIZED_CONTINUE_TEXT";
    public static final String INCENTIVIZED_TITLE_TEXT = "INCENTIVIZED_TITLE_TEXT";
    public static final String KEY_TEMPLATE = "template";
    public static final String KEY_VM = "vmURL";
    public static final String TPAT_CLICK_COORDINATES_URLS = "video.clickCoordinates";
    private static final String UNKNOWN = "unknown";
    private AdConfig adConfig;
    private final List<PlacementAdUnit> ads;
    private File assetDirectory;
    private boolean assetsFullyDownloaded;
    private final ConfigPayload config;
    private Map<String, String> incentivizedTextSettings;
    private LogEntry logEntry;
    private ConcurrentHashMap<String, String> mraidFiles;

    @Serializable
    public static final class CacheableReplacement {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String extension;
        private final Boolean required;
        private final String url;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CacheableReplacement> serializer() {
                return AdPayload$CacheableReplacement$$serializer.INSTANCE;
            }
        }

        public CacheableReplacement() {
            this((String) null, (String) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ CacheableReplacement(int i2, String str, String str2, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$CacheableReplacement$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.url = null;
            } else {
                this.url = str;
            }
            if ((i2 & 2) == 0) {
                this.extension = null;
            } else {
                this.extension = str2;
            }
            if ((i2 & 4) == 0) {
                this.required = null;
            } else {
                this.required = bool;
            }
        }

        public static /* synthetic */ CacheableReplacement copy$default(CacheableReplacement cacheableReplacement, String str, String str2, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cacheableReplacement.url;
            }
            if ((i2 & 2) != 0) {
                str2 = cacheableReplacement.extension;
            }
            if ((i2 & 4) != 0) {
                bool = cacheableReplacement.required;
            }
            return cacheableReplacement.copy(str, str2, bool);
        }

        public static final void write$Self(CacheableReplacement cacheableReplacement, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            boolean z3;
            Intrinsics.f(cacheableReplacement, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z4 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && cacheableReplacement.url == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, cacheableReplacement.url);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && cacheableReplacement.extension == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, cacheableReplacement.extension);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || cacheableReplacement.required != null) {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, BooleanSerializer.f40947a, cacheableReplacement.required);
            }
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.extension;
        }

        public final Boolean component3() {
            return this.required;
        }

        public final CacheableReplacement copy(String str, String str2, Boolean bool) {
            return new CacheableReplacement(str, str2, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheableReplacement)) {
                return false;
            }
            CacheableReplacement cacheableReplacement = (CacheableReplacement) obj;
            return Intrinsics.a(this.url, cacheableReplacement.url) && Intrinsics.a(this.extension, cacheableReplacement.extension) && Intrinsics.a(this.required, cacheableReplacement.required);
        }

        public final String getExtension() {
            return this.extension;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            int i2 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.extension;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.required;
            if (bool != null) {
                i2 = bool.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            return "CacheableReplacement(url=" + this.url + ", extension=" + this.extension + ", required=" + this.required + ')';
        }

        public CacheableReplacement(String str, String str2, Boolean bool) {
            this.url = str;
            this.extension = str2;
            this.required = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CacheableReplacement(String str, String str2, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : bool);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AdPayload> serializer() {
            return AdPayload$$serializer.INSTANCE;
        }
    }

    @Serializable
    public static final class PlacementAdUnit {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final AdUnit adMarkup;
        private final String placementReferenceId;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<PlacementAdUnit> serializer() {
                return AdPayload$PlacementAdUnit$$serializer.INSTANCE;
            }
        }

        public PlacementAdUnit() {
            this((String) null, (AdUnit) null, 3, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ PlacementAdUnit(int i2, String str, AdUnit adUnit, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$PlacementAdUnit$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str;
            }
            if ((i2 & 2) == 0) {
                this.adMarkup = null;
            } else {
                this.adMarkup = adUnit;
            }
        }

        public static /* synthetic */ PlacementAdUnit copy$default(PlacementAdUnit placementAdUnit, String str, AdUnit adUnit, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = placementAdUnit.placementReferenceId;
            }
            if ((i2 & 2) != 0) {
                adUnit = placementAdUnit.adMarkup;
            }
            return placementAdUnit.copy(str, adUnit);
        }

        public static /* synthetic */ void getAdMarkup$annotations() {
        }

        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }

        public static final void write$Self(PlacementAdUnit placementAdUnit, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Intrinsics.f(placementAdUnit, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && placementAdUnit.placementReferenceId == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, placementAdUnit.placementReferenceId);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || placementAdUnit.adMarkup != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, AdPayload$AdUnit$$serializer.INSTANCE, placementAdUnit.adMarkup);
            }
        }

        public final String component1() {
            return this.placementReferenceId;
        }

        public final AdUnit component2() {
            return this.adMarkup;
        }

        public final PlacementAdUnit copy(String str, AdUnit adUnit) {
            return new PlacementAdUnit(str, adUnit);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlacementAdUnit)) {
                return false;
            }
            PlacementAdUnit placementAdUnit = (PlacementAdUnit) obj;
            return Intrinsics.a(this.placementReferenceId, placementAdUnit.placementReferenceId) && Intrinsics.a(this.adMarkup, placementAdUnit.adMarkup);
        }

        public final AdUnit getAdMarkup() {
            return this.adMarkup;
        }

        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        public int hashCode() {
            String str = this.placementReferenceId;
            int i2 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            AdUnit adUnit = this.adMarkup;
            if (adUnit != null) {
                i2 = adUnit.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "PlacementAdUnit(placementReferenceId=" + this.placementReferenceId + ", adMarkup=" + this.adMarkup + ')';
        }

        public PlacementAdUnit(String str, AdUnit adUnit) {
            this.placementReferenceId = str;
            this.adMarkup = adUnit;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PlacementAdUnit(String str, AdUnit adUnit, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : adUnit);
        }
    }

    @Serializable
    public static final class TemplateSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Map<String, CacheableReplacement> cacheableReplacements;
        private final Map<String, String> normalReplacements;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<TemplateSettings> serializer() {
                return AdPayload$TemplateSettings$$serializer.INSTANCE;
            }
        }

        public TemplateSettings() {
            this((Map) null, (Map) null, 3, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ TemplateSettings(int i2, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$TemplateSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.normalReplacements = null;
            } else {
                this.normalReplacements = map;
            }
            if ((i2 & 2) == 0) {
                this.cacheableReplacements = null;
            } else {
                this.cacheableReplacements = map2;
            }
        }

        public static /* synthetic */ TemplateSettings copy$default(TemplateSettings templateSettings, Map<String, String> map, Map<String, CacheableReplacement> map2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                map = templateSettings.normalReplacements;
            }
            if ((i2 & 2) != 0) {
                map2 = templateSettings.cacheableReplacements;
            }
            return templateSettings.copy(map, map2);
        }

        public static /* synthetic */ void getCacheableReplacements$annotations() {
        }

        public static /* synthetic */ void getNormalReplacements$annotations() {
        }

        public static final void write$Self(TemplateSettings templateSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Intrinsics.f(templateSettings, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && templateSettings.normalReplacements == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                StringSerializer stringSerializer = StringSerializer.f41077a;
                compositeEncoder.i(serialDescriptor, 0, new LinkedHashMapSerializer(stringSerializer, stringSerializer), templateSettings.normalReplacements);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || templateSettings.cacheableReplacements != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, new LinkedHashMapSerializer(StringSerializer.f41077a, AdPayload$CacheableReplacement$$serializer.INSTANCE), templateSettings.cacheableReplacements);
            }
        }

        public final Map<String, String> component1() {
            return this.normalReplacements;
        }

        public final Map<String, CacheableReplacement> component2() {
            return this.cacheableReplacements;
        }

        public final TemplateSettings copy(Map<String, String> map, Map<String, CacheableReplacement> map2) {
            return new TemplateSettings(map, map2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TemplateSettings)) {
                return false;
            }
            TemplateSettings templateSettings = (TemplateSettings) obj;
            return Intrinsics.a(this.normalReplacements, templateSettings.normalReplacements) && Intrinsics.a(this.cacheableReplacements, templateSettings.cacheableReplacements);
        }

        public final Map<String, CacheableReplacement> getCacheableReplacements() {
            return this.cacheableReplacements;
        }

        public final Map<String, String> getNormalReplacements() {
            return this.normalReplacements;
        }

        public int hashCode() {
            Map<String, String> map = this.normalReplacements;
            int i2 = 0;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            Map<String, CacheableReplacement> map2 = this.cacheableReplacements;
            if (map2 != null) {
                i2 = map2.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "TemplateSettings(normalReplacements=" + this.normalReplacements + ", cacheableReplacements=" + this.cacheableReplacements + ')';
        }

        public TemplateSettings(Map<String, String> map, Map<String, CacheableReplacement> map2) {
            this.normalReplacements = map;
            this.cacheableReplacements = map2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TemplateSettings(Map map, Map map2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : map, (i2 & 2) != 0 ? null : map2);
        }
    }

    public static final class TpatSerializer extends JsonTransformingSerializer<Map<String, ? extends List<? extends String>>> {
        public static final TpatSerializer INSTANCE = new TpatSerializer();

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private TpatSerializer() {
            /*
                r2 = this;
                kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.f40434a
                kotlinx.serialization.KSerializer r1 = kotlinx.serialization.builtins.BuiltinSerializersKt.G(r0)
                kotlinx.serialization.KSerializer r0 = kotlinx.serialization.builtins.BuiltinSerializersKt.G(r0)
                kotlinx.serialization.KSerializer r0 = kotlinx.serialization.builtins.BuiltinSerializersKt.h(r0)
                kotlinx.serialization.KSerializer r0 = kotlinx.serialization.builtins.BuiltinSerializersKt.k(r1, r0)
                r2.<init>(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload.TpatSerializer.<init>():void");
        }

        /* access modifiers changed from: protected */
        public JsonElement transformDeserialize(JsonElement jsonElement) {
            Intrinsics.f(jsonElement, "element");
            JsonObject k2 = JsonElementKt.k(jsonElement);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : k2.entrySet()) {
                if (!Intrinsics.a((String) entry.getKey(), "moat")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JsonObject(linkedHashMap);
        }
    }

    @Serializable
    public static final class ViewAbility {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ViewAbilityInfo om;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ViewAbility> serializer() {
                return AdPayload$ViewAbility$$serializer.INSTANCE;
            }
        }

        public ViewAbility() {
            this((ViewAbilityInfo) null, 1, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ ViewAbility(int i2, ViewAbilityInfo viewAbilityInfo, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$ViewAbility$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.om = null;
            } else {
                this.om = viewAbilityInfo;
            }
        }

        public static /* synthetic */ ViewAbility copy$default(ViewAbility viewAbility, ViewAbilityInfo viewAbilityInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                viewAbilityInfo = viewAbility.om;
            }
            return viewAbility.copy(viewAbilityInfo);
        }

        public static final void write$Self(ViewAbility viewAbility, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(viewAbility, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z2 = true;
            if (!compositeEncoder.z(serialDescriptor, 0) && viewAbility.om == null) {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE, viewAbility.om);
            }
        }

        public final ViewAbilityInfo component1() {
            return this.om;
        }

        public final ViewAbility copy(ViewAbilityInfo viewAbilityInfo) {
            return new ViewAbility(viewAbilityInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ViewAbility) && Intrinsics.a(this.om, ((ViewAbility) obj).om);
        }

        public final ViewAbilityInfo getOm() {
            return this.om;
        }

        public int hashCode() {
            ViewAbilityInfo viewAbilityInfo = this.om;
            if (viewAbilityInfo == null) {
                return 0;
            }
            return viewAbilityInfo.hashCode();
        }

        public String toString() {
            return "ViewAbility(om=" + this.om + ')';
        }

        public ViewAbility(ViewAbilityInfo viewAbilityInfo) {
            this.om = viewAbilityInfo;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewAbility(ViewAbilityInfo viewAbilityInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : viewAbilityInfo);
        }
    }

    @Serializable
    public static final class ViewAbilityInfo {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String extraVast;
        private final Boolean isEnabled;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ViewAbilityInfo> serializer() {
                return AdPayload$ViewAbilityInfo$$serializer.INSTANCE;
            }
        }

        public ViewAbilityInfo() {
            this((Boolean) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ ViewAbilityInfo(int i2, Boolean bool, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.isEnabled = null;
            } else {
                this.isEnabled = bool;
            }
            if ((i2 & 2) == 0) {
                this.extraVast = null;
            } else {
                this.extraVast = str;
            }
        }

        public static /* synthetic */ ViewAbilityInfo copy$default(ViewAbilityInfo viewAbilityInfo, Boolean bool, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = viewAbilityInfo.isEnabled;
            }
            if ((i2 & 2) != 0) {
                str = viewAbilityInfo.extraVast;
            }
            return viewAbilityInfo.copy(bool, str);
        }

        public static /* synthetic */ void getExtraVast$annotations() {
        }

        public static /* synthetic */ void isEnabled$annotations() {
        }

        public static final void write$Self(ViewAbilityInfo viewAbilityInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Intrinsics.f(viewAbilityInfo, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && viewAbilityInfo.isEnabled == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f40947a, viewAbilityInfo.isEnabled);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || viewAbilityInfo.extraVast != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, viewAbilityInfo.extraVast);
            }
        }

        public final Boolean component1() {
            return this.isEnabled;
        }

        public final String component2() {
            return this.extraVast;
        }

        public final ViewAbilityInfo copy(Boolean bool, String str) {
            return new ViewAbilityInfo(bool, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewAbilityInfo)) {
                return false;
            }
            ViewAbilityInfo viewAbilityInfo = (ViewAbilityInfo) obj;
            return Intrinsics.a(this.isEnabled, viewAbilityInfo.isEnabled) && Intrinsics.a(this.extraVast, viewAbilityInfo.extraVast);
        }

        public final String getExtraVast() {
            return this.extraVast;
        }

        public int hashCode() {
            Boolean bool = this.isEnabled;
            int i2 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.extraVast;
            if (str != null) {
                i2 = str.hashCode();
            }
            return hashCode + i2;
        }

        public final Boolean isEnabled() {
            return this.isEnabled;
        }

        public String toString() {
            return "ViewAbilityInfo(isEnabled=" + this.isEnabled + ", extraVast=" + this.extraVast + ')';
        }

        public ViewAbilityInfo(Boolean bool, String str) {
            this.isEnabled = bool;
            this.extraVast = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewAbilityInfo(Boolean bool, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? null : str);
        }
    }

    public AdPayload() {
        this((List) null, (ConfigPayload) null, 3, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ AdPayload(int i2, List list, ConfigPayload configPayload, ConcurrentHashMap concurrentHashMap, Map map, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, AdPayload$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.ads = null;
        } else {
            this.ads = list;
        }
        if ((i2 & 2) == 0) {
            this.config = null;
        } else {
            this.config = configPayload;
        }
        if ((i2 & 4) == 0) {
            this.mraidFiles = new ConcurrentHashMap<>();
        } else {
            this.mraidFiles = concurrentHashMap;
        }
        if ((i2 & 8) == 0) {
            this.incentivizedTextSettings = new HashMap();
        } else {
            this.incentivizedTextSettings = map;
        }
        if ((i2 & 16) == 0) {
            this.assetsFullyDownloaded = false;
        } else {
            this.assetsFullyDownloaded = z2;
        }
        this.adConfig = null;
        this.logEntry = null;
        this.assetDirectory = null;
    }

    private final String complexReplace(String str, String str2, String str3) {
        String quote = Pattern.quote(str2);
        Intrinsics.e(quote, "quote(oldValue)");
        return new Regex(quote).h(str, valueOrEmpty(str3));
    }

    private final PlacementAdUnit getAd() {
        List<PlacementAdUnit> list = this.ads;
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        return list.get(0);
    }

    public static /* synthetic */ void getAdConfig$annotations() {
    }

    private final AdUnit getAdMarkup() {
        PlacementAdUnit ad = getAd();
        if (ad != null) {
            return ad.getAdMarkup();
        }
        return null;
    }

    private static /* synthetic */ void getAds$annotations() {
    }

    public static /* synthetic */ void getAssetDirectory$annotations() {
    }

    private static /* synthetic */ void getConfig$annotations() {
    }

    public static /* synthetic */ void getIncentivizedTextSettings$annotations() {
    }

    public static /* synthetic */ void getLogEntry$vungle_ads_release$annotations() {
    }

    private static /* synthetic */ void getMraidFiles$annotations() {
    }

    public static /* synthetic */ List getTpatUrls$default(AdPayload adPayload, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        return adPayload.getTpatUrls(str, str2, str3);
    }

    private final String valueOrEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final void write$Self(AdPayload adPayload, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.f(adPayload, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z6 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && adPayload.ads == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE), adPayload.ads);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && adPayload.config == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, ConfigPayload$$serializer.INSTANCE, adPayload.config);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && Intrinsics.a(adPayload.mraidFiles, new ConcurrentHashMap())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            KClass b2 = Reflection.b(ConcurrentHashMap.class);
            StringSerializer stringSerializer = StringSerializer.f41077a;
            compositeEncoder.C(serialDescriptor, 2, new ContextualSerializer(b2, (KSerializer) null, new KSerializer[]{stringSerializer, stringSerializer}), adPayload.mraidFiles);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && Intrinsics.a(adPayload.incentivizedTextSettings, new HashMap())) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            StringSerializer stringSerializer2 = StringSerializer.f41077a;
            compositeEncoder.C(serialDescriptor, 3, new LinkedHashMapSerializer(stringSerializer2, stringSerializer2), adPayload.incentivizedTextSettings);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || adPayload.assetsFullyDownloaded) {
            z6 = true;
        }
        if (z6) {
            compositeEncoder.x(serialDescriptor, 4, adPayload.assetsFullyDownloaded);
        }
    }

    public final int adHeight() {
        AdSizeInfo adSizeInfo;
        Integer height;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (adSizeInfo = adMarkup.getAdSizeInfo()) == null || (height = adSizeInfo.getHeight()) == null) {
            return 0;
        }
        return height.intValue();
    }

    public final boolean adLoadOptimizationEnabled() {
        Boolean adLoadOptimizationEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (adLoadOptimizationEnabled = adMarkup.getAdLoadOptimizationEnabled()) == null) {
            return true;
        }
        return adLoadOptimizationEnabled.booleanValue();
    }

    public final AdUnit adUnit() {
        return getAdMarkup();
    }

    public final int adWidth() {
        AdSizeInfo adSizeInfo;
        Integer width;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (adSizeInfo = adMarkup.getAdSizeInfo()) == null || (width = adSizeInfo.getWidth()) == null) {
            return 0;
        }
        return width.intValue();
    }

    public final String advAppId() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdvAppId();
        }
        return null;
    }

    public final ConfigPayload config() {
        return this.config;
    }

    public final JsonObject createMRAIDArgs() {
        Map<String, String> mRAIDArgsInMap = getMRAIDArgsInMap();
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry next : mRAIDArgsInMap.entrySet()) {
            JsonElementBuildersKt.c(jsonObjectBuilder, (String) next.getKey(), (String) next.getValue());
        }
        return jsonObjectBuilder.a();
    }

    public final String eventId() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getId();
        }
        return null;
    }

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final String getAdSource() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdSource();
        }
        return null;
    }

    public final File getAssetDirectory() {
        return this.assetDirectory;
    }

    public final boolean getAssetsFullyDownloaded() {
        return this.assetsFullyDownloaded;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getCreativeId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getCreativeId() {
        /*
            r1 = this;
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = r1.getAdMarkup()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getCreativeId()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = "unknown"
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload.getCreativeId():java.lang.String");
    }

    public final List<AdAsset> getDownloadableAssets(File file) {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        boolean z2;
        boolean z3;
        String templateURL;
        String vmURL;
        File file2 = file;
        Intrinsics.f(file2, "dir");
        this.assetDirectory = file2;
        ArrayList arrayList = new ArrayList();
        if (!isNativeTemplateType()) {
            AdUnit adMarkup = getAdMarkup();
            if (adMarkup == null || (vmURL = adMarkup.getVmURL()) == null) {
                AdUnit adMarkup2 = getAdMarkup();
                if (!(adMarkup2 == null || (templateURL = adMarkup2.getTemplateURL()) == null || !FileUtility.INSTANCE.isValidUrl(templateURL))) {
                    String absolutePath = new File(file2, KEY_TEMPLATE).getAbsolutePath();
                    Intrinsics.e(absolutePath, "filePath");
                    arrayList.add(new AdAsset(KEY_TEMPLATE, templateURL, absolutePath, AdAsset.FileType.ZIP, true));
                }
            } else if (FileUtility.INSTANCE.isValidUrl(vmURL)) {
                String absolutePath2 = new File(file2, Constants.AD_INDEX_FILE_NAME).getAbsolutePath();
                Intrinsics.e(absolutePath2, "filePath");
                arrayList.add(new AdAsset(KEY_VM, vmURL, absolutePath2, AdAsset.FileType.ASSET, true));
            }
        }
        AdUnit adMarkup3 = getAdMarkup();
        if (!(adMarkup3 == null || (templateSettings = adMarkup3.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null)) {
            for (Map.Entry next : cacheableReplacements.entrySet()) {
                CacheableReplacement cacheableReplacement = (CacheableReplacement) next.getValue();
                if (cacheableReplacement.getUrl() != null) {
                    FileUtility fileUtility = FileUtility.INSTANCE;
                    if (fileUtility.isValidUrl(cacheableReplacement.getUrl())) {
                        Boolean required = cacheableReplacement.getRequired();
                        if (required != null) {
                            z2 = required.booleanValue();
                        } else {
                            z2 = false;
                        }
                        if (isNativeTemplateType() || !adLoadOptimizationEnabled()) {
                            z3 = true;
                        } else if (!ConfigManager.INSTANCE.isCacheableAssetsRequired()) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        String absolutePath3 = new File(file2, fileUtility.guessFileName(cacheableReplacement.getUrl(), cacheableReplacement.getExtension())).getAbsolutePath();
                        String url = cacheableReplacement.getUrl();
                        Intrinsics.e(absolutePath3, "filePath");
                        arrayList.add(new AdAsset((String) next.getKey(), url, absolutePath3, AdAsset.FileType.ASSET, z3));
                    }
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.t(arrayList, new AdPayload$getDownloadableAssets$$inlined$sortByDescending$1());
        }
        return arrayList;
    }

    public final Map<String, String> getIncentivizedTextSettings() {
        return this.incentivizedTextSettings;
    }

    public final LogEntry getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    public final Map<String, String> getMRAIDArgsInMap() {
        TemplateSettings templateSettings;
        TemplateSettings templateSettings2;
        Map<String, CacheableReplacement> cacheableReplacements;
        TemplateSettings templateSettings3;
        Map<String, String> normalReplacements;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            templateSettings = adMarkup.getTemplateSettings();
        } else {
            templateSettings = null;
        }
        if (templateSettings != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            AdUnit adMarkup2 = getAdMarkup();
            if (!(adMarkup2 == null || (templateSettings3 = adMarkup2.getTemplateSettings()) == null || (normalReplacements = templateSettings3.getNormalReplacements()) == null)) {
                linkedHashMap.putAll(normalReplacements);
            }
            AdUnit adMarkup3 = getAdMarkup();
            if (!(adMarkup3 == null || (templateSettings2 = adMarkup3.getTemplateSettings()) == null || (cacheableReplacements = templateSettings2.getCacheableReplacements()) == null)) {
                for (Map.Entry next : cacheableReplacements.entrySet()) {
                    String url = ((CacheableReplacement) next.getValue()).getUrl();
                    if (url != null) {
                        linkedHashMap.put(next.getKey(), url);
                    }
                }
            }
            if (!this.mraidFiles.isEmpty()) {
                linkedHashMap.putAll(this.mraidFiles);
            }
            if (!this.incentivizedTextSettings.isEmpty()) {
                linkedHashMap.putAll(this.incentivizedTextSettings);
            }
            return linkedHashMap;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!".toString());
    }

    public final int getShowCloseDelay(Boolean bool) {
        Integer showClose;
        Integer showCloseIncentivized;
        if (Intrinsics.a(bool, Boolean.TRUE)) {
            AdUnit adMarkup = getAdMarkup();
            if (adMarkup == null || (showCloseIncentivized = adMarkup.getShowCloseIncentivized()) == null) {
                return 0;
            }
            return showCloseIncentivized.intValue() * 1000;
        }
        AdUnit adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (showClose = adMarkup2.getShowClose()) == null) {
            return 0;
        }
        return showClose.intValue() * 1000;
    }

    public final List<String> getTpatUrls(String str, String str2, String str3) {
        boolean z2;
        List<String> list;
        ArrayList arrayList;
        Map<String, List<String>> tpat;
        Map<String, List<String>> tpat2;
        Intrinsics.f(str, "event");
        AdUnit adMarkup = getAdMarkup();
        boolean z3 = false;
        if (adMarkup == null || (tpat2 = adMarkup.getTpat()) == null || tpat2.containsKey(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            new TpatError(Sdk$SDKError.Reason.INVALID_TPAT_KEY, "Arbitrary tpat key: " + str).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return null;
        }
        AdUnit adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (tpat = adMarkup2.getTpat()) == null) {
            list = null;
        } else {
            list = tpat.get(str);
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z3 = true;
        }
        if (z3) {
            new TpatError(Sdk$SDKError.Reason.EMPTY_TPAT_ERROR, "Empty tpat key: " + str).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return null;
        }
        switch (str.hashCode()) {
            case -2125915830:
                if (str.equals(Constants.CHECKPOINT_0)) {
                    Iterable<String> iterable = list;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
                    for (String complexReplace : iterable) {
                        arrayList.add(complexReplace(complexReplace(complexReplace(complexReplace, Constants.REMOTE_PLAY_KEY, String.valueOf(!this.assetsFullyDownloaded)), Constants.NETWORK_OPERATOR_KEY, str2), Constants.DEVICE_VOLUME_KEY, str3));
                    }
                    break;
                } else {
                    return list;
                }
            case -747709511:
                if (str.equals(Constants.VIDEO_LENGTH)) {
                    Iterable<String> iterable2 = list;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable2, 10));
                    for (String complexReplace2 : iterable2) {
                        arrayList.add(complexReplace(complexReplace2, Constants.VIDEO_LENGTH_KEY, str2));
                    }
                    break;
                } else {
                    return list;
                }
            case -132489083:
                if (str.equals(Constants.AD_LOAD_DURATION)) {
                    Iterable<String> iterable3 = list;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable3, 10));
                    for (String complexReplace3 : iterable3) {
                        arrayList.add(complexReplace(complexReplace3, Constants.AD_LOAD_DURATION_KEY, str2));
                    }
                    break;
                } else {
                    return list;
                }
            case 1516630125:
                if (str.equals(Constants.AD_CLOSE)) {
                    Iterable<String> iterable4 = list;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable4, 10));
                    for (String complexReplace4 : iterable4) {
                        arrayList.add(complexReplace(complexReplace(complexReplace4, Constants.AD_DURATION_KEY, str2), Constants.DEVICE_VOLUME_KEY, str3));
                    }
                    break;
                } else {
                    return list;
                }
            case 1940309120:
                if (str.equals(Constants.DEEPLINK_CLICK)) {
                    Iterable<String> iterable5 = list;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable5, 10));
                    for (String complexReplace5 : iterable5) {
                        arrayList.add(complexReplace(complexReplace5, Constants.DEEPLINK_SUCCESS_KEY, str2));
                    }
                    break;
                } else {
                    return list;
                }
            default:
                return list;
        }
        return arrayList;
    }

    public final List<String> getWinNotifications() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getNotification();
        }
        return null;
    }

    public final boolean hasExpired() {
        Integer expiry;
        boolean z2;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (expiry = adMarkup.getExpiry()) == null) {
            return false;
        }
        if (((long) expiry.intValue()) < System.currentTimeMillis() / 1000) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public final boolean heartbeatEnabled() {
        Boolean templateHeartbeatCheck;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (templateHeartbeatCheck = adMarkup.getTemplateHeartbeatCheck()) == null) {
            return false;
        }
        return templateHeartbeatCheck.booleanValue();
    }

    public final boolean isClickCoordinatesTrackingEnabled() {
        Boolean clickCoordinatesEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (clickCoordinatesEnabled = adMarkup.getClickCoordinatesEnabled()) == null) {
            return false;
        }
        return clickCoordinatesEnabled.booleanValue();
    }

    public final boolean isCriticalAsset(String str) {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        String str2;
        Intrinsics.f(str, "failingUrl");
        if (!isNativeTemplateType()) {
            AdUnit adMarkup = getAdMarkup();
            if (adMarkup != null) {
                str2 = adMarkup.getTemplateURL();
            } else {
                str2 = null;
            }
            if (Intrinsics.a(str2, str)) {
                return true;
            }
        }
        AdUnit adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (templateSettings = adMarkup2.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : cacheableReplacements.entrySet()) {
            if (Intrinsics.a(((CacheableReplacement) next.getValue()).getUrl(), str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return !linkedHashMap.isEmpty();
    }

    public final boolean isNativeTemplateType() {
        return Intrinsics.a(templateType(), "native");
    }

    public final boolean omEnabled() {
        ViewAbility viewAbility;
        ViewAbilityInfo om;
        Boolean isEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (viewAbility = adMarkup.getViewAbility()) == null || (om = viewAbility.getOm()) == null || (isEnabled = om.isEnabled()) == null) {
            return false;
        }
        return isEnabled.booleanValue();
    }

    public final String placementId() {
        PlacementAdUnit ad = getAd();
        if (ad != null) {
            return ad.getPlacementReferenceId();
        }
        return null;
    }

    public final void setAdConfig(AdConfig adConfig2) {
        this.adConfig = adConfig2;
    }

    public final void setAssetFullyDownloaded() {
        this.assetsFullyDownloaded = true;
    }

    public final void setAssetsFullyDownloaded(boolean z2) {
        this.assetsFullyDownloaded = z2;
    }

    public final void setIncentivizedText(String str, String str2, String str3, String str4) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(str, "title");
        Intrinsics.f(str2, "body");
        Intrinsics.f(str3, "keepWatching");
        Intrinsics.f(str4, MRAIDPresenter.CLOSE);
        boolean z5 = true;
        if (str.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.incentivizedTextSettings.put(INCENTIVIZED_TITLE_TEXT, str);
        }
        if (str2.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this.incentivizedTextSettings.put(INCENTIVIZED_BODY_TEXT, str2);
        }
        if (str3.length() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CONTINUE_TEXT, str3);
        }
        if (str4.length() <= 0) {
            z5 = false;
        }
        if (z5) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CLOSE_TEXT, str4);
        }
    }

    public final void setIncentivizedTextSettings(Map<String, String> map) {
        Intrinsics.f(map, "<set-?>");
        this.incentivizedTextSettings = map;
    }

    public final void setLogEntry$vungle_ads_release(LogEntry logEntry2) {
        this.logEntry = logEntry2;
    }

    public final String templateType() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getTemplateType();
        }
        return null;
    }

    public final synchronized void updateAdAssetPath(AdAsset adAsset) {
        if (adAsset != null) {
            if (!Intrinsics.a(KEY_TEMPLATE, adAsset.getAdIdentifier())) {
                File file = new File(adAsset.getLocalPath());
                if (file.exists()) {
                    String adIdentifier = adAsset.getAdIdentifier();
                    ConcurrentHashMap<String, String> concurrentHashMap = this.mraidFiles;
                    String put = concurrentHashMap.put(adIdentifier, FILE_SCHEME + file.getPath());
                }
            }
        }
    }

    @Serializable
    public static final class AdSizeInfo {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Integer height;
        private final Integer width;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AdSizeInfo> serializer() {
                return AdPayload$AdSizeInfo$$serializer.INSTANCE;
            }
        }

        public AdSizeInfo() {
            this((Integer) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        }

        public AdSizeInfo(Integer num, Integer num2) {
            this.width = num;
            this.height = num2;
        }

        public static /* synthetic */ AdSizeInfo copy$default(AdSizeInfo adSizeInfo, Integer num, Integer num2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = adSizeInfo.width;
            }
            if ((i2 & 2) != 0) {
                num2 = adSizeInfo.height;
            }
            return adSizeInfo.copy(num, num2);
        }

        public static /* synthetic */ void getHeight$annotations() {
        }

        public static /* synthetic */ void getWidth$annotations() {
        }

        public static final void write$Self(AdSizeInfo adSizeInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z2;
            Integer num;
            Integer num2;
            Intrinsics.f(adSizeInfo, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && (num2 = adSizeInfo.width) != null && num2.intValue() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, IntSerializer.f41006a, adSizeInfo.width);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || (num = adSizeInfo.height) == null || num.intValue() != 0) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, IntSerializer.f41006a, adSizeInfo.height);
            }
        }

        public final Integer component1() {
            return this.width;
        }

        public final Integer component2() {
            return this.height;
        }

        public final AdSizeInfo copy(Integer num, Integer num2) {
            return new AdSizeInfo(num, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdSizeInfo)) {
                return false;
            }
            AdSizeInfo adSizeInfo = (AdSizeInfo) obj;
            return Intrinsics.a(this.width, adSizeInfo.width) && Intrinsics.a(this.height, adSizeInfo.height);
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public int hashCode() {
            Integer num = this.width;
            int i2 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.height;
            if (num2 != null) {
                i2 = num2.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "AdSizeInfo(width=" + this.width + ", height=" + this.height + ')';
        }

        public /* synthetic */ AdSizeInfo(int i2, Integer num, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$AdSizeInfo$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.width = 0;
            } else {
                this.width = num;
            }
            if ((i2 & 2) == 0) {
                this.height = 0;
            } else {
                this.height = num2;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AdSizeInfo(Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? 0 : num2);
        }
    }

    public AdPayload(List<PlacementAdUnit> list, ConfigPayload configPayload) {
        this.ads = list;
        this.config = configPayload;
        this.mraidFiles = new ConcurrentHashMap<>();
        this.incentivizedTextSettings = new HashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdPayload(List list, ConfigPayload configPayload, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : configPayload);
    }

    @Serializable
    public static final class AdUnit {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Boolean adLoadOptimizationEnabled;
        private final String adMarketId;
        private final AdSizeInfo adSizeInfo;
        private final String adSource;
        private final String adType;
        private final String advAppId;
        private final Boolean clickCoordinatesEnabled;
        private final String creativeId;
        private final String deeplinkUrl;
        private final Integer errorCode;
        private final Integer expiry;
        private final String id;
        private final String info;
        private final List<String> loadAdUrls;
        private final List<String> notification;
        private final Integer showClose;
        private final Integer showCloseIncentivized;
        private final Integer sleep;
        private final Boolean templateHeartbeatCheck;
        private final TemplateSettings templateSettings;
        private final String templateType;
        private final String templateURL;
        private final Map<String, List<String>> tpat;
        private final ViewAbility viewAbility;
        private final String vmURL;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AdUnit> serializer() {
                return AdPayload$AdUnit$$serializer.INSTANCE;
            }
        }

        public AdUnit() {
            this((String) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (Integer) null, (Integer) null, (Map) null, (String) null, (String) null, (List) null, (List) null, (ViewAbility) null, (String) null, (String) null, (TemplateSettings) null, (String) null, (String) null, (Integer) null, (Integer) null, (AdSizeInfo) null, 33554431, (DefaultConstructorMarker) null);
        }

        public AdUnit(String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Integer num2, Integer num3, Map<String, ? extends List<String>> map, String str6, String str7, List<String> list, List<String> list2, ViewAbility viewAbility2, String str8, String str9, TemplateSettings templateSettings2, String str10, String str11, Integer num4, Integer num5, AdSizeInfo adSizeInfo2) {
            this.id = str;
            this.adType = str2;
            this.adSource = str3;
            this.expiry = num;
            this.deeplinkUrl = str4;
            this.clickCoordinatesEnabled = bool;
            this.adLoadOptimizationEnabled = bool2;
            this.templateHeartbeatCheck = bool3;
            this.info = str5;
            this.sleep = num2;
            this.errorCode = num3;
            this.tpat = map;
            this.vmURL = str6;
            this.adMarketId = str7;
            this.notification = list;
            this.loadAdUrls = list2;
            this.viewAbility = viewAbility2;
            this.templateURL = str8;
            this.templateType = str9;
            this.templateSettings = templateSettings2;
            this.creativeId = str10;
            this.advAppId = str11;
            this.showClose = num4;
            this.showCloseIncentivized = num5;
            this.adSizeInfo = adSizeInfo2;
        }

        public static /* synthetic */ AdUnit copy$default(AdUnit adUnit, String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Integer num2, Integer num3, Map map, String str6, String str7, List list, List list2, ViewAbility viewAbility2, String str8, String str9, TemplateSettings templateSettings2, String str10, String str11, Integer num4, Integer num5, AdSizeInfo adSizeInfo2, int i2, Object obj) {
            AdUnit adUnit2 = adUnit;
            int i3 = i2;
            return adUnit.copy((i3 & 1) != 0 ? adUnit2.id : str, (i3 & 2) != 0 ? adUnit2.adType : str2, (i3 & 4) != 0 ? adUnit2.adSource : str3, (i3 & 8) != 0 ? adUnit2.expiry : num, (i3 & 16) != 0 ? adUnit2.deeplinkUrl : str4, (i3 & 32) != 0 ? adUnit2.clickCoordinatesEnabled : bool, (i3 & 64) != 0 ? adUnit2.adLoadOptimizationEnabled : bool2, (i3 & 128) != 0 ? adUnit2.templateHeartbeatCheck : bool3, (i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? adUnit2.info : str5, (i3 & 512) != 0 ? adUnit2.sleep : num2, (i3 & 1024) != 0 ? adUnit2.errorCode : num3, (i3 & 2048) != 0 ? adUnit2.tpat : map, (i3 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? adUnit2.vmURL : str6, (i3 & 8192) != 0 ? adUnit2.adMarketId : str7, (i3 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? adUnit2.notification : list, (i3 & 32768) != 0 ? adUnit2.loadAdUrls : list2, (i3 & 65536) != 0 ? adUnit2.viewAbility : viewAbility2, (i3 & 131072) != 0 ? adUnit2.templateURL : str8, (i3 & 262144) != 0 ? adUnit2.templateType : str9, (i3 & ImageMetadata.LENS_APERTURE) != 0 ? adUnit2.templateSettings : templateSettings2, (i3 & 1048576) != 0 ? adUnit2.creativeId : str10, (i3 & 2097152) != 0 ? adUnit2.advAppId : str11, (i3 & 4194304) != 0 ? adUnit2.showClose : num4, (i3 & 8388608) != 0 ? adUnit2.showCloseIncentivized : num5, (i3 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? adUnit2.adSizeInfo : adSizeInfo2);
        }

        public static /* synthetic */ void getAdLoadOptimizationEnabled$annotations() {
        }

        public static /* synthetic */ void getAdMarketId$annotations() {
        }

        public static /* synthetic */ void getAdSizeInfo$annotations() {
        }

        public static /* synthetic */ void getAdSource$annotations() {
        }

        public static /* synthetic */ void getAdType$annotations() {
        }

        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        public static /* synthetic */ void getClickCoordinatesEnabled$annotations() {
        }

        public static /* synthetic */ void getCreativeId$annotations() {
        }

        public static /* synthetic */ void getDeeplinkUrl$annotations() {
        }

        public static /* synthetic */ void getErrorCode$annotations() {
        }

        public static /* synthetic */ void getExpiry$annotations() {
        }

        public static /* synthetic */ void getId$annotations() {
        }

        public static /* synthetic */ void getInfo$annotations() {
        }

        public static /* synthetic */ void getLoadAdUrls$annotations() {
        }

        public static /* synthetic */ void getNotification$annotations() {
        }

        public static /* synthetic */ void getShowClose$annotations() {
        }

        public static /* synthetic */ void getShowCloseIncentivized$annotations() {
        }

        public static /* synthetic */ void getSleep$annotations() {
        }

        public static /* synthetic */ void getTemplateHeartbeatCheck$annotations() {
        }

        public static /* synthetic */ void getTemplateSettings$annotations() {
        }

        public static /* synthetic */ void getTemplateType$annotations() {
        }

        public static /* synthetic */ void getTemplateURL$annotations() {
        }

        @Serializable(with = TpatSerializer.class)
        public static /* synthetic */ void getTpat$annotations() {
        }

        public static /* synthetic */ void getViewAbility$annotations() {
        }

        public static /* synthetic */ void getVmURL$annotations() {
        }

        public static final void write$Self(AdUnit adUnit, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
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
            boolean z20;
            boolean z21;
            boolean z22;
            boolean z23;
            boolean z24;
            boolean z25;
            Integer num;
            Integer num2;
            Intrinsics.f(adUnit, "self");
            Intrinsics.f(compositeEncoder, "output");
            Intrinsics.f(serialDescriptor, "serialDesc");
            boolean z26 = false;
            if (!compositeEncoder.z(serialDescriptor, 0) && adUnit.id == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, adUnit.id);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && adUnit.adType == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, adUnit.adType);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && adUnit.adSource == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.i(serialDescriptor, 2, StringSerializer.f41077a, adUnit.adSource);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && adUnit.expiry == null) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                compositeEncoder.i(serialDescriptor, 3, IntSerializer.f41006a, adUnit.expiry);
            }
            if (!compositeEncoder.z(serialDescriptor, 4) && adUnit.deeplinkUrl == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z6) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f41077a, adUnit.deeplinkUrl);
            }
            if (!compositeEncoder.z(serialDescriptor, 5) && adUnit.clickCoordinatesEnabled == null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                compositeEncoder.i(serialDescriptor, 5, BooleanSerializer.f40947a, adUnit.clickCoordinatesEnabled);
            }
            if (!compositeEncoder.z(serialDescriptor, 6) && adUnit.adLoadOptimizationEnabled == null) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (z8) {
                compositeEncoder.i(serialDescriptor, 6, BooleanSerializer.f40947a, adUnit.adLoadOptimizationEnabled);
            }
            if (!compositeEncoder.z(serialDescriptor, 7) && adUnit.templateHeartbeatCheck == null) {
                z9 = false;
            } else {
                z9 = true;
            }
            if (z9) {
                compositeEncoder.i(serialDescriptor, 7, BooleanSerializer.f40947a, adUnit.templateHeartbeatCheck);
            }
            if (!compositeEncoder.z(serialDescriptor, 8) && adUnit.info == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                compositeEncoder.i(serialDescriptor, 8, StringSerializer.f41077a, adUnit.info);
            }
            if (!compositeEncoder.z(serialDescriptor, 9) && adUnit.sleep == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                compositeEncoder.i(serialDescriptor, 9, IntSerializer.f41006a, adUnit.sleep);
            }
            if (!compositeEncoder.z(serialDescriptor, 10) && adUnit.errorCode == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                compositeEncoder.i(serialDescriptor, 10, IntSerializer.f41006a, adUnit.errorCode);
            }
            if (!compositeEncoder.z(serialDescriptor, 11) && adUnit.tpat == null) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                compositeEncoder.i(serialDescriptor, 11, TpatSerializer.INSTANCE, adUnit.tpat);
            }
            if (!compositeEncoder.z(serialDescriptor, 12) && adUnit.vmURL == null) {
                z14 = false;
            } else {
                z14 = true;
            }
            if (z14) {
                compositeEncoder.i(serialDescriptor, 12, StringSerializer.f41077a, adUnit.vmURL);
            }
            if (!compositeEncoder.z(serialDescriptor, 13) && adUnit.adMarketId == null) {
                z15 = false;
            } else {
                z15 = true;
            }
            if (z15) {
                compositeEncoder.i(serialDescriptor, 13, StringSerializer.f41077a, adUnit.adMarketId);
            }
            if (!compositeEncoder.z(serialDescriptor, 14) && adUnit.notification == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                compositeEncoder.i(serialDescriptor, 14, new ArrayListSerializer(StringSerializer.f41077a), adUnit.notification);
            }
            if (!compositeEncoder.z(serialDescriptor, 15) && adUnit.loadAdUrls == null) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                compositeEncoder.i(serialDescriptor, 15, new ArrayListSerializer(StringSerializer.f41077a), adUnit.loadAdUrls);
            }
            if (!compositeEncoder.z(serialDescriptor, 16) && adUnit.viewAbility == null) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                compositeEncoder.i(serialDescriptor, 16, AdPayload$ViewAbility$$serializer.INSTANCE, adUnit.viewAbility);
            }
            if (!compositeEncoder.z(serialDescriptor, 17) && adUnit.templateURL == null) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                compositeEncoder.i(serialDescriptor, 17, StringSerializer.f41077a, adUnit.templateURL);
            }
            if (!compositeEncoder.z(serialDescriptor, 18) && adUnit.templateType == null) {
                z20 = false;
            } else {
                z20 = true;
            }
            if (z20) {
                compositeEncoder.i(serialDescriptor, 18, StringSerializer.f41077a, adUnit.templateType);
            }
            if (!compositeEncoder.z(serialDescriptor, 19) && adUnit.templateSettings == null) {
                z21 = false;
            } else {
                z21 = true;
            }
            if (z21) {
                compositeEncoder.i(serialDescriptor, 19, AdPayload$TemplateSettings$$serializer.INSTANCE, adUnit.templateSettings);
            }
            if (!compositeEncoder.z(serialDescriptor, 20) && adUnit.creativeId == null) {
                z22 = false;
            } else {
                z22 = true;
            }
            if (z22) {
                compositeEncoder.i(serialDescriptor, 20, StringSerializer.f41077a, adUnit.creativeId);
            }
            if (!compositeEncoder.z(serialDescriptor, 21) && adUnit.advAppId == null) {
                z23 = false;
            } else {
                z23 = true;
            }
            if (z23) {
                compositeEncoder.i(serialDescriptor, 21, StringSerializer.f41077a, adUnit.advAppId);
            }
            if (!compositeEncoder.z(serialDescriptor, 22) && (num2 = adUnit.showClose) != null && num2.intValue() == 0) {
                z24 = false;
            } else {
                z24 = true;
            }
            if (z24) {
                compositeEncoder.i(serialDescriptor, 22, IntSerializer.f41006a, adUnit.showClose);
            }
            if (!compositeEncoder.z(serialDescriptor, 23) && (num = adUnit.showCloseIncentivized) != null && num.intValue() == 0) {
                z25 = false;
            } else {
                z25 = true;
            }
            if (z25) {
                compositeEncoder.i(serialDescriptor, 23, IntSerializer.f41006a, adUnit.showCloseIncentivized);
            }
            if (compositeEncoder.z(serialDescriptor, 24) || adUnit.adSizeInfo != null) {
                z26 = true;
            }
            if (z26) {
                compositeEncoder.i(serialDescriptor, 24, AdPayload$AdSizeInfo$$serializer.INSTANCE, adUnit.adSizeInfo);
            }
        }

        public final String component1() {
            return this.id;
        }

        public final Integer component10() {
            return this.sleep;
        }

        public final Integer component11() {
            return this.errorCode;
        }

        public final Map<String, List<String>> component12() {
            return this.tpat;
        }

        public final String component13() {
            return this.vmURL;
        }

        public final String component14() {
            return this.adMarketId;
        }

        public final List<String> component15() {
            return this.notification;
        }

        public final List<String> component16() {
            return this.loadAdUrls;
        }

        public final ViewAbility component17() {
            return this.viewAbility;
        }

        public final String component18() {
            return this.templateURL;
        }

        public final String component19() {
            return this.templateType;
        }

        public final String component2() {
            return this.adType;
        }

        public final TemplateSettings component20() {
            return this.templateSettings;
        }

        public final String component21() {
            return this.creativeId;
        }

        public final String component22() {
            return this.advAppId;
        }

        public final Integer component23() {
            return this.showClose;
        }

        public final Integer component24() {
            return this.showCloseIncentivized;
        }

        public final AdSizeInfo component25() {
            return this.adSizeInfo;
        }

        public final String component3() {
            return this.adSource;
        }

        public final Integer component4() {
            return this.expiry;
        }

        public final String component5() {
            return this.deeplinkUrl;
        }

        public final Boolean component6() {
            return this.clickCoordinatesEnabled;
        }

        public final Boolean component7() {
            return this.adLoadOptimizationEnabled;
        }

        public final Boolean component8() {
            return this.templateHeartbeatCheck;
        }

        public final String component9() {
            return this.info;
        }

        public final AdUnit copy(String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Integer num2, Integer num3, Map<String, ? extends List<String>> map, String str6, String str7, List<String> list, List<String> list2, ViewAbility viewAbility2, String str8, String str9, TemplateSettings templateSettings2, String str10, String str11, Integer num4, Integer num5, AdSizeInfo adSizeInfo2) {
            return new AdUnit(str, str2, str3, num, str4, bool, bool2, bool3, str5, num2, num3, map, str6, str7, list, list2, viewAbility2, str8, str9, templateSettings2, str10, str11, num4, num5, adSizeInfo2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdUnit)) {
                return false;
            }
            AdUnit adUnit = (AdUnit) obj;
            return Intrinsics.a(this.id, adUnit.id) && Intrinsics.a(this.adType, adUnit.adType) && Intrinsics.a(this.adSource, adUnit.adSource) && Intrinsics.a(this.expiry, adUnit.expiry) && Intrinsics.a(this.deeplinkUrl, adUnit.deeplinkUrl) && Intrinsics.a(this.clickCoordinatesEnabled, adUnit.clickCoordinatesEnabled) && Intrinsics.a(this.adLoadOptimizationEnabled, adUnit.adLoadOptimizationEnabled) && Intrinsics.a(this.templateHeartbeatCheck, adUnit.templateHeartbeatCheck) && Intrinsics.a(this.info, adUnit.info) && Intrinsics.a(this.sleep, adUnit.sleep) && Intrinsics.a(this.errorCode, adUnit.errorCode) && Intrinsics.a(this.tpat, adUnit.tpat) && Intrinsics.a(this.vmURL, adUnit.vmURL) && Intrinsics.a(this.adMarketId, adUnit.adMarketId) && Intrinsics.a(this.notification, adUnit.notification) && Intrinsics.a(this.loadAdUrls, adUnit.loadAdUrls) && Intrinsics.a(this.viewAbility, adUnit.viewAbility) && Intrinsics.a(this.templateURL, adUnit.templateURL) && Intrinsics.a(this.templateType, adUnit.templateType) && Intrinsics.a(this.templateSettings, adUnit.templateSettings) && Intrinsics.a(this.creativeId, adUnit.creativeId) && Intrinsics.a(this.advAppId, adUnit.advAppId) && Intrinsics.a(this.showClose, adUnit.showClose) && Intrinsics.a(this.showCloseIncentivized, adUnit.showCloseIncentivized) && Intrinsics.a(this.adSizeInfo, adUnit.adSizeInfo);
        }

        public final Boolean getAdLoadOptimizationEnabled() {
            return this.adLoadOptimizationEnabled;
        }

        public final String getAdMarketId() {
            return this.adMarketId;
        }

        public final AdSizeInfo getAdSizeInfo() {
            return this.adSizeInfo;
        }

        public final String getAdSource() {
            return this.adSource;
        }

        public final String getAdType() {
            return this.adType;
        }

        public final String getAdvAppId() {
            return this.advAppId;
        }

        public final Boolean getClickCoordinatesEnabled() {
            return this.clickCoordinatesEnabled;
        }

        public final String getCreativeId() {
            return this.creativeId;
        }

        public final String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final Integer getExpiry() {
            return this.expiry;
        }

        public final String getId() {
            return this.id;
        }

        public final String getInfo() {
            return this.info;
        }

        public final List<String> getLoadAdUrls() {
            return this.loadAdUrls;
        }

        public final List<String> getNotification() {
            return this.notification;
        }

        public final Integer getShowClose() {
            return this.showClose;
        }

        public final Integer getShowCloseIncentivized() {
            return this.showCloseIncentivized;
        }

        public final Integer getSleep() {
            return this.sleep;
        }

        public final Boolean getTemplateHeartbeatCheck() {
            return this.templateHeartbeatCheck;
        }

        public final TemplateSettings getTemplateSettings() {
            return this.templateSettings;
        }

        public final String getTemplateType() {
            return this.templateType;
        }

        public final String getTemplateURL() {
            return this.templateURL;
        }

        public final Map<String, List<String>> getTpat() {
            return this.tpat;
        }

        public final ViewAbility getViewAbility() {
            return this.viewAbility;
        }

        public final String getVmURL() {
            return this.vmURL;
        }

        public int hashCode() {
            String str = this.id;
            int i2 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.adType;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.adSource;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.expiry;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.deeplinkUrl;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Boolean bool = this.clickCoordinatesEnabled;
            int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.adLoadOptimizationEnabled;
            int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.templateHeartbeatCheck;
            int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str5 = this.info;
            int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num2 = this.sleep;
            int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.errorCode;
            int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Map<String, List<String>> map = this.tpat;
            int hashCode12 = (hashCode11 + (map == null ? 0 : map.hashCode())) * 31;
            String str6 = this.vmURL;
            int hashCode13 = (hashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.adMarketId;
            int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
            List<String> list = this.notification;
            int hashCode15 = (hashCode14 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.loadAdUrls;
            int hashCode16 = (hashCode15 + (list2 == null ? 0 : list2.hashCode())) * 31;
            ViewAbility viewAbility2 = this.viewAbility;
            int hashCode17 = (hashCode16 + (viewAbility2 == null ? 0 : viewAbility2.hashCode())) * 31;
            String str8 = this.templateURL;
            int hashCode18 = (hashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.templateType;
            int hashCode19 = (hashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
            TemplateSettings templateSettings2 = this.templateSettings;
            int hashCode20 = (hashCode19 + (templateSettings2 == null ? 0 : templateSettings2.hashCode())) * 31;
            String str10 = this.creativeId;
            int hashCode21 = (hashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.advAppId;
            int hashCode22 = (hashCode21 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Integer num4 = this.showClose;
            int hashCode23 = (hashCode22 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.showCloseIncentivized;
            int hashCode24 = (hashCode23 + (num5 == null ? 0 : num5.hashCode())) * 31;
            AdSizeInfo adSizeInfo2 = this.adSizeInfo;
            if (adSizeInfo2 != null) {
                i2 = adSizeInfo2.hashCode();
            }
            return hashCode24 + i2;
        }

        public String toString() {
            return "AdUnit(id=" + this.id + ", adType=" + this.adType + ", adSource=" + this.adSource + ", expiry=" + this.expiry + ", deeplinkUrl=" + this.deeplinkUrl + ", clickCoordinatesEnabled=" + this.clickCoordinatesEnabled + ", adLoadOptimizationEnabled=" + this.adLoadOptimizationEnabled + ", templateHeartbeatCheck=" + this.templateHeartbeatCheck + ", info=" + this.info + ", sleep=" + this.sleep + ", errorCode=" + this.errorCode + ", tpat=" + this.tpat + ", vmURL=" + this.vmURL + ", adMarketId=" + this.adMarketId + ", notification=" + this.notification + ", loadAdUrls=" + this.loadAdUrls + ", viewAbility=" + this.viewAbility + ", templateURL=" + this.templateURL + ", templateType=" + this.templateType + ", templateSettings=" + this.templateSettings + ", creativeId=" + this.creativeId + ", advAppId=" + this.advAppId + ", showClose=" + this.showClose + ", showCloseIncentivized=" + this.showCloseIncentivized + ", adSizeInfo=" + this.adSizeInfo + ')';
        }

        public /* synthetic */ AdUnit(int i2, String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Integer num2, Integer num3, @Serializable(with = TpatSerializer.class) Map map, String str6, String str7, List list, List list2, ViewAbility viewAbility2, String str8, String str9, TemplateSettings templateSettings2, String str10, String str11, Integer num4, Integer num5, AdSizeInfo adSizeInfo2, SerializationConstructorMarker serializationConstructorMarker) {
            int i3 = i2;
            if ((i3 & 0) != 0) {
                PluginExceptionsKt.a(i2, 0, AdPayload$AdUnit$$serializer.INSTANCE.getDescriptor());
            }
            if ((i3 & 1) == 0) {
                this.id = null;
            } else {
                this.id = str;
            }
            if ((i3 & 2) == 0) {
                this.adType = null;
            } else {
                this.adType = str2;
            }
            if ((i3 & 4) == 0) {
                this.adSource = null;
            } else {
                this.adSource = str3;
            }
            if ((i3 & 8) == 0) {
                this.expiry = null;
            } else {
                this.expiry = num;
            }
            if ((i3 & 16) == 0) {
                this.deeplinkUrl = null;
            } else {
                this.deeplinkUrl = str4;
            }
            if ((i3 & 32) == 0) {
                this.clickCoordinatesEnabled = null;
            } else {
                this.clickCoordinatesEnabled = bool;
            }
            if ((i3 & 64) == 0) {
                this.adLoadOptimizationEnabled = null;
            } else {
                this.adLoadOptimizationEnabled = bool2;
            }
            if ((i3 & 128) == 0) {
                this.templateHeartbeatCheck = null;
            } else {
                this.templateHeartbeatCheck = bool3;
            }
            if ((i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0) {
                this.info = null;
            } else {
                this.info = str5;
            }
            if ((i3 & 512) == 0) {
                this.sleep = null;
            } else {
                this.sleep = num2;
            }
            if ((i3 & 1024) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num3;
            }
            if ((i3 & 2048) == 0) {
                this.tpat = null;
            } else {
                this.tpat = map;
            }
            if ((i3 & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0) {
                this.vmURL = null;
            } else {
                this.vmURL = str6;
            }
            if ((i3 & 8192) == 0) {
                this.adMarketId = null;
            } else {
                this.adMarketId = str7;
            }
            if ((i3 & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                this.notification = null;
            } else {
                this.notification = list;
            }
            if ((32768 & i3) == 0) {
                this.loadAdUrls = null;
            } else {
                this.loadAdUrls = list2;
            }
            if ((65536 & i3) == 0) {
                this.viewAbility = null;
            } else {
                this.viewAbility = viewAbility2;
            }
            if ((131072 & i3) == 0) {
                this.templateURL = null;
            } else {
                this.templateURL = str8;
            }
            if ((262144 & i3) == 0) {
                this.templateType = null;
            } else {
                this.templateType = str9;
            }
            if ((524288 & i3) == 0) {
                this.templateSettings = null;
            } else {
                this.templateSettings = templateSettings2;
            }
            if ((1048576 & i3) == 0) {
                this.creativeId = null;
            } else {
                this.creativeId = str10;
            }
            if ((2097152 & i3) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str11;
            }
            if ((4194304 & i3) == 0) {
                this.showClose = 0;
            } else {
                this.showClose = num4;
            }
            if ((8388608 & i3) == 0) {
                this.showCloseIncentivized = 0;
            } else {
                this.showCloseIncentivized = num5;
            }
            if ((i3 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) == 0) {
                this.adSizeInfo = null;
            } else {
                this.adSizeInfo = adSizeInfo2;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ AdUnit(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.Integer r30, java.lang.String r31, java.lang.Boolean r32, java.lang.Boolean r33, java.lang.Boolean r34, java.lang.String r35, java.lang.Integer r36, java.lang.Integer r37, java.util.Map r38, java.lang.String r39, java.lang.String r40, java.util.List r41, java.util.List r42, com.vungle.ads.internal.model.AdPayload.ViewAbility r43, java.lang.String r44, java.lang.String r45, com.vungle.ads.internal.model.AdPayload.TemplateSettings r46, java.lang.String r47, java.lang.String r48, java.lang.Integer r49, java.lang.Integer r50, com.vungle.ads.internal.model.AdPayload.AdSizeInfo r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
            /*
                r26 = this;
                r0 = r52
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0008
                r1 = 0
                goto L_0x000a
            L_0x0008:
                r1 = r27
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = 0
                goto L_0x0012
            L_0x0010:
                r3 = r28
            L_0x0012:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0018
                r4 = 0
                goto L_0x001a
            L_0x0018:
                r4 = r29
            L_0x001a:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x0020
                r5 = 0
                goto L_0x0022
            L_0x0020:
                r5 = r30
            L_0x0022:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0028
                r6 = 0
                goto L_0x002a
            L_0x0028:
                r6 = r31
            L_0x002a:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0030
                r7 = 0
                goto L_0x0032
            L_0x0030:
                r7 = r32
            L_0x0032:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0038
                r8 = 0
                goto L_0x003a
            L_0x0038:
                r8 = r33
            L_0x003a:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x0040
                r9 = 0
                goto L_0x0042
            L_0x0040:
                r9 = r34
            L_0x0042:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0048
                r10 = 0
                goto L_0x004a
            L_0x0048:
                r10 = r35
            L_0x004a:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x0050
                r11 = 0
                goto L_0x0052
            L_0x0050:
                r11 = r36
            L_0x0052:
                r12 = r0 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L_0x0058
                r12 = 0
                goto L_0x005a
            L_0x0058:
                r12 = r37
            L_0x005a:
                r13 = r0 & 2048(0x800, float:2.87E-42)
                if (r13 == 0) goto L_0x0060
                r13 = 0
                goto L_0x0062
            L_0x0060:
                r13 = r38
            L_0x0062:
                r14 = r0 & 4096(0x1000, float:5.74E-42)
                if (r14 == 0) goto L_0x0068
                r14 = 0
                goto L_0x006a
            L_0x0068:
                r14 = r39
            L_0x006a:
                r15 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r15 == 0) goto L_0x0070
                r15 = 0
                goto L_0x0072
            L_0x0070:
                r15 = r40
            L_0x0072:
                r2 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r2 == 0) goto L_0x0078
                r2 = 0
                goto L_0x007a
            L_0x0078:
                r2 = r41
            L_0x007a:
                r16 = 32768(0x8000, float:4.5918E-41)
                r16 = r0 & r16
                if (r16 == 0) goto L_0x0084
                r16 = 0
                goto L_0x0086
            L_0x0084:
                r16 = r42
            L_0x0086:
                r17 = 65536(0x10000, float:9.18355E-41)
                r17 = r0 & r17
                if (r17 == 0) goto L_0x008f
                r17 = 0
                goto L_0x0091
            L_0x008f:
                r17 = r43
            L_0x0091:
                r18 = 131072(0x20000, float:1.83671E-40)
                r18 = r0 & r18
                if (r18 == 0) goto L_0x009a
                r18 = 0
                goto L_0x009c
            L_0x009a:
                r18 = r44
            L_0x009c:
                r19 = 262144(0x40000, float:3.67342E-40)
                r19 = r0 & r19
                if (r19 == 0) goto L_0x00a5
                r19 = 0
                goto L_0x00a7
            L_0x00a5:
                r19 = r45
            L_0x00a7:
                r20 = 524288(0x80000, float:7.34684E-40)
                r20 = r0 & r20
                if (r20 == 0) goto L_0x00b0
                r20 = 0
                goto L_0x00b2
            L_0x00b0:
                r20 = r46
            L_0x00b2:
                r21 = 1048576(0x100000, float:1.469368E-39)
                r21 = r0 & r21
                if (r21 == 0) goto L_0x00bb
                r21 = 0
                goto L_0x00bd
            L_0x00bb:
                r21 = r47
            L_0x00bd:
                r22 = 2097152(0x200000, float:2.938736E-39)
                r22 = r0 & r22
                if (r22 == 0) goto L_0x00c6
                r22 = 0
                goto L_0x00c8
            L_0x00c6:
                r22 = r48
            L_0x00c8:
                r23 = 4194304(0x400000, float:5.877472E-39)
                r23 = r0 & r23
                r24 = 0
                if (r23 == 0) goto L_0x00d5
                java.lang.Integer r23 = java.lang.Integer.valueOf(r24)
                goto L_0x00d7
            L_0x00d5:
                r23 = r49
            L_0x00d7:
                r25 = 8388608(0x800000, float:1.17549435E-38)
                r25 = r0 & r25
                if (r25 == 0) goto L_0x00e2
                java.lang.Integer r24 = java.lang.Integer.valueOf(r24)
                goto L_0x00e4
            L_0x00e2:
                r24 = r50
            L_0x00e4:
                r25 = 16777216(0x1000000, float:2.3509887E-38)
                r0 = r0 & r25
                if (r0 == 0) goto L_0x00ec
                r0 = 0
                goto L_0x00ee
            L_0x00ec:
                r0 = r51
            L_0x00ee:
                r27 = r26
                r28 = r1
                r29 = r3
                r30 = r4
                r31 = r5
                r32 = r6
                r33 = r7
                r34 = r8
                r35 = r9
                r36 = r10
                r37 = r11
                r38 = r12
                r39 = r13
                r40 = r14
                r41 = r15
                r42 = r2
                r43 = r16
                r44 = r17
                r45 = r18
                r46 = r19
                r47 = r20
                r48 = r21
                r49 = r22
                r50 = r23
                r51 = r24
                r52 = r0
                r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload.AdUnit.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.Map, java.lang.String, java.lang.String, java.util.List, java.util.List, com.vungle.ads.internal.model.AdPayload$ViewAbility, java.lang.String, java.lang.String, com.vungle.ads.internal.model.AdPayload$TemplateSettings, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, com.vungle.ads.internal.model.AdPayload$AdSizeInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}

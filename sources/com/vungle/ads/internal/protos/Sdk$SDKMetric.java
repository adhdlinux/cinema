package com.vungle.ads.internal.protos;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Sdk$SDKMetric extends GeneratedMessageLite<Sdk$SDKMetric, Builder> implements Sdk$SDKMetricOrBuilder {
    public static final int ADSOURCE_FIELD_NUMBER = 16;
    public static final int CONNECTIONTYPEDETAIL_FIELD_NUMBER = 9;
    public static final int CONNECTIONTYPE_FIELD_NUMBER = 8;
    public static final int CREATIVEID_FIELD_NUMBER = 11;
    /* access modifiers changed from: private */
    public static final Sdk$SDKMetric DEFAULT_INSTANCE;
    public static final int EVENTID_FIELD_NUMBER = 12;
    public static final int ISHBPLACEMENT_FIELD_NUMBER = 14;
    public static final int ISLOWDATAMODEENABLED_FIELD_NUMBER = 201;
    public static final int MAKE_FIELD_NUMBER = 4;
    public static final int META_FIELD_NUMBER = 3;
    public static final int MODEL_FIELD_NUMBER = 5;
    public static final int OSVERSION_FIELD_NUMBER = 7;
    public static final int OS_FIELD_NUMBER = 6;
    private static volatile Parser<Sdk$SDKMetric> PARSER = null;
    public static final int PLACEMENTREFERENCEID_FIELD_NUMBER = 10;
    public static final int PLACEMENTTYPE_FIELD_NUMBER = 15;
    public static final int SESSIONID_FIELD_NUMBER = 13;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String adSource_ = "";
    private String connectionTypeDetail_ = "";
    private String connectionType_ = "";
    private String creativeId_ = "";
    private String eventId_ = "";
    private long isHbPlacement_;
    private boolean isLowDataModeEnabled_;
    private String make_ = "";
    private String meta_ = "";
    private String model_ = "";
    private String osVersion_ = "";
    private String os_ = "";
    private String placementReferenceId_ = "";
    private String placementType_ = "";
    private String sessionId_ = "";
    private int type_;
    private long value_;

    public static final class Builder extends GeneratedMessageLite.Builder<Sdk$SDKMetric, Builder> implements Sdk$SDKMetricOrBuilder {
        /* synthetic */ Builder(Sdk$1 sdk$1) {
            this();
        }

        public Builder clearAdSource() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearAdSource();
            return this;
        }

        public Builder clearConnectionType() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearConnectionType();
            return this;
        }

        public Builder clearConnectionTypeDetail() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearConnectionTypeDetail();
            return this;
        }

        public Builder clearCreativeId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearCreativeId();
            return this;
        }

        public Builder clearEventId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearEventId();
            return this;
        }

        public Builder clearIsHbPlacement() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearIsHbPlacement();
            return this;
        }

        public Builder clearIsLowDataModeEnabled() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearIsLowDataModeEnabled();
            return this;
        }

        public Builder clearMake() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearMake();
            return this;
        }

        public Builder clearMeta() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearMeta();
            return this;
        }

        public Builder clearModel() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearModel();
            return this;
        }

        public Builder clearOs() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearOs();
            return this;
        }

        public Builder clearOsVersion() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearOsVersion();
            return this;
        }

        public Builder clearPlacementReferenceId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearPlacementReferenceId();
            return this;
        }

        public Builder clearPlacementType() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearPlacementType();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearSessionId();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearType();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).clearValue();
            return this;
        }

        public String getAdSource() {
            return ((Sdk$SDKMetric) this.instance).getAdSource();
        }

        public ByteString getAdSourceBytes() {
            return ((Sdk$SDKMetric) this.instance).getAdSourceBytes();
        }

        public String getConnectionType() {
            return ((Sdk$SDKMetric) this.instance).getConnectionType();
        }

        public ByteString getConnectionTypeBytes() {
            return ((Sdk$SDKMetric) this.instance).getConnectionTypeBytes();
        }

        public String getConnectionTypeDetail() {
            return ((Sdk$SDKMetric) this.instance).getConnectionTypeDetail();
        }

        public ByteString getConnectionTypeDetailBytes() {
            return ((Sdk$SDKMetric) this.instance).getConnectionTypeDetailBytes();
        }

        public String getCreativeId() {
            return ((Sdk$SDKMetric) this.instance).getCreativeId();
        }

        public ByteString getCreativeIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getCreativeIdBytes();
        }

        public String getEventId() {
            return ((Sdk$SDKMetric) this.instance).getEventId();
        }

        public ByteString getEventIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getEventIdBytes();
        }

        public long getIsHbPlacement() {
            return ((Sdk$SDKMetric) this.instance).getIsHbPlacement();
        }

        public boolean getIsLowDataModeEnabled() {
            return ((Sdk$SDKMetric) this.instance).getIsLowDataModeEnabled();
        }

        public String getMake() {
            return ((Sdk$SDKMetric) this.instance).getMake();
        }

        public ByteString getMakeBytes() {
            return ((Sdk$SDKMetric) this.instance).getMakeBytes();
        }

        public String getMeta() {
            return ((Sdk$SDKMetric) this.instance).getMeta();
        }

        public ByteString getMetaBytes() {
            return ((Sdk$SDKMetric) this.instance).getMetaBytes();
        }

        public String getModel() {
            return ((Sdk$SDKMetric) this.instance).getModel();
        }

        public ByteString getModelBytes() {
            return ((Sdk$SDKMetric) this.instance).getModelBytes();
        }

        public String getOs() {
            return ((Sdk$SDKMetric) this.instance).getOs();
        }

        public ByteString getOsBytes() {
            return ((Sdk$SDKMetric) this.instance).getOsBytes();
        }

        public String getOsVersion() {
            return ((Sdk$SDKMetric) this.instance).getOsVersion();
        }

        public ByteString getOsVersionBytes() {
            return ((Sdk$SDKMetric) this.instance).getOsVersionBytes();
        }

        public String getPlacementReferenceId() {
            return ((Sdk$SDKMetric) this.instance).getPlacementReferenceId();
        }

        public ByteString getPlacementReferenceIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getPlacementReferenceIdBytes();
        }

        public String getPlacementType() {
            return ((Sdk$SDKMetric) this.instance).getPlacementType();
        }

        public ByteString getPlacementTypeBytes() {
            return ((Sdk$SDKMetric) this.instance).getPlacementTypeBytes();
        }

        public String getSessionId() {
            return ((Sdk$SDKMetric) this.instance).getSessionId();
        }

        public ByteString getSessionIdBytes() {
            return ((Sdk$SDKMetric) this.instance).getSessionIdBytes();
        }

        public SDKMetricType getType() {
            return ((Sdk$SDKMetric) this.instance).getType();
        }

        public int getTypeValue() {
            return ((Sdk$SDKMetric) this.instance).getTypeValue();
        }

        public long getValue() {
            return ((Sdk$SDKMetric) this.instance).getValue();
        }

        public Builder setAdSource(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setAdSource(str);
            return this;
        }

        public Builder setAdSourceBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setAdSourceBytes(byteString);
            return this;
        }

        public Builder setConnectionType(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionType(str);
            return this;
        }

        public Builder setConnectionTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionTypeBytes(byteString);
            return this;
        }

        public Builder setConnectionTypeDetail(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionTypeDetail(str);
            return this;
        }

        public Builder setConnectionTypeDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setConnectionTypeDetailBytes(byteString);
            return this;
        }

        public Builder setCreativeId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setCreativeId(str);
            return this;
        }

        public Builder setCreativeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setCreativeIdBytes(byteString);
            return this;
        }

        public Builder setEventId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setEventId(str);
            return this;
        }

        public Builder setEventIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public Builder setIsHbPlacement(long j2) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setIsHbPlacement(j2);
            return this;
        }

        public Builder setIsLowDataModeEnabled(boolean z2) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setIsLowDataModeEnabled(z2);
            return this;
        }

        public Builder setMake(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMake(str);
            return this;
        }

        public Builder setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMakeBytes(byteString);
            return this;
        }

        public Builder setMeta(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMeta(str);
            return this;
        }

        public Builder setMetaBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setMetaBytes(byteString);
            return this;
        }

        public Builder setModel(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setModel(str);
            return this;
        }

        public Builder setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setModelBytes(byteString);
            return this;
        }

        public Builder setOs(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOs(str);
            return this;
        }

        public Builder setOsBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOsBytes(byteString);
            return this;
        }

        public Builder setOsVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOsVersion(str);
            return this;
        }

        public Builder setOsVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setOsVersionBytes(byteString);
            return this;
        }

        public Builder setPlacementReferenceId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setPlacementReferenceId(str);
            return this;
        }

        public Builder setPlacementReferenceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setPlacementReferenceIdBytes(byteString);
            return this;
        }

        public Builder setPlacementType(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setPlacementType(str);
            return this;
        }

        public Builder setPlacementTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setPlacementTypeBytes(byteString);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setType(SDKMetricType sDKMetricType) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setType(sDKMetricType);
            return this;
        }

        public Builder setTypeValue(int i2) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setTypeValue(i2);
            return this;
        }

        public Builder setValue(long j2) {
            copyOnWrite();
            ((Sdk$SDKMetric) this.instance).setValue(j2);
            return this;
        }

        private Builder() {
            super(Sdk$SDKMetric.DEFAULT_INSTANCE);
        }
    }

    public enum SDKMetricType implements Internal.EnumLite {
        UNKNOWN_METRIC_TYPE(0),
        AD_REQUEST_TO_RESPONSE_DURATION_MS(1),
        AD_RESPONSE_TO_SHOW_DURATION_MS(2),
        AD_SHOW_TO_DISPLAY_DURATION_MS(3),
        AD_DISPLAY_TO_CLICK_DURATION_MS(4),
        IOS_STORE_KIT_LOAD_TIME_MS(5),
        INIT_REQUEST_TO_RESPONSE_DURATION_MS(6),
        ASSET_DOWNLOAD_DURATION_MS(7),
        LOCAL_ASSETS_USED(8),
        REMOTE_ASSETS_USED(9),
        TEMPLATE_DOWNLOAD_DURATION_MS(10),
        AD_REQUEST_TO_CALLBACK_DURATION_MS(11),
        AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS(12),
        ASSET_FILE_SIZE(13),
        USER_AGENT_LOAD_DURATION_MS(14),
        TEMPLATE_ZIP_SIZE(15),
        CACHED_ASSETS_USED(16),
        LOAD_AD_API(17),
        TPAT_FIRED(18),
        TPAT_SUCCESS(19),
        WIN_NOTIF_FIRED(20),
        WIN_NOTIF_SUCCESS(21),
        AD_EXPIRED_BEFORE_PLAY(22),
        PLAY_AD_API(23),
        AD_LOAD_FAIL(24),
        VIEW_NOT_VISIBLE_ON_PLAY(25),
        MRAID_DOWNLOAD_JS_RETRY_SUCCESS(26),
        OMSDK_DOWNLOAD_JS_RETRY_SUCCESS(27),
        PRIVACY_URL_OPENED(28),
        NOTIFICATION_REDIRECT(29),
        AD_PLAY_RESET_ON_DEINIT(30),
        TEMPLATE_HTML_SIZE(31),
        CONFIG_LOADED_FROM_INIT(32),
        CONFIG_LOADED_FROM_AD_LOAD(33),
        CONFIG_LOADED_FROM_ADM_LOAD(34),
        AD_SHOW_TO_PRESENT_DURATION_MS(35),
        AD_SHOW_TO_FAIL_DURATION_MS(36),
        AD_PRESENT_TO_DISPLAY_DURATION_MS(37),
        BID_TOKEN_REQUESTED(38),
        BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS(39),
        BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS(40),
        AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS(41),
        AD_SHOW_TO_CLOSE_DURATION_MS(42),
        AD_LOAD_TO_CALLBACK_DURATION_MS(43),
        AD_LOAD_TO_CALLBACK_ADO_DURATION_MS(44),
        SDK_INIT_API(45),
        AD_START_EVENT(46),
        AD_CLICK_EVENT(47),
        AD_SHOW_TO_VALIDATION_DURATION_MS(48),
        AD_VALIDATION_TO_PRESENT_DURATION_MS(49),
        AD_LEAVE_APPLICATION(50),
        AD_REWARD_USER(51),
        AD_REQUIRED_DOWNLOAD_DURATION_MS(52),
        AD_OPTIONAL_DOWNLOAD_DURATION_MS(53),
        SKOVERLAY_PRESENTED_FOR_AD(2000),
        SAFARI_PRESENTED_FOR_AD(2001),
        STORE_KIT_PRESENTED_FOR_AD(2002),
        STORE_KIT_NOT_READY(2003),
        LAUNCH_STORE_KIT_REQUEST(2004),
        LAUNCH_SKOVERLAY_REQUEST(2005),
        LAUNCH_SAFARI_REQUEST(2006),
        IDFV_RESTRICTED(2007),
        NOTIFICATION_WAIT_FOR_CONNECTIVITY(2008),
        IDFV_VALUE_CHANGED(2009),
        AD_WILL_CLOSE(AD_WILL_CLOSE_VALUE),
        HARDWARE_ACCELERATE_DISABLED(3001),
        BANNER_AUTO_REDIRECT(3002),
        UNRECOGNIZED(-1);
        
        public static final int AD_CLICK_EVENT_VALUE = 47;
        public static final int AD_DISPLAY_TO_CLICK_DURATION_MS_VALUE = 4;
        @Deprecated
        public static final int AD_EXPIRED_BEFORE_PLAY_VALUE = 22;
        public static final int AD_LEAVE_APPLICATION_VALUE = 50;
        public static final int AD_LOAD_FAIL_VALUE = 24;
        public static final int AD_LOAD_TO_CALLBACK_ADO_DURATION_MS_VALUE = 44;
        public static final int AD_LOAD_TO_CALLBACK_DURATION_MS_VALUE = 43;
        public static final int AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS_VALUE = 41;
        public static final int AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE = 53;
        public static final int AD_PLAY_RESET_ON_DEINIT_VALUE = 30;
        public static final int AD_PRESENT_TO_DISPLAY_DURATION_MS_VALUE = 37;
        public static final int AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS_VALUE = 12;
        public static final int AD_REQUEST_TO_CALLBACK_DURATION_MS_VALUE = 11;
        public static final int AD_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 1;
        public static final int AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE = 52;
        public static final int AD_RESPONSE_TO_SHOW_DURATION_MS_VALUE = 2;
        public static final int AD_REWARD_USER_VALUE = 51;
        public static final int AD_SHOW_TO_CLOSE_DURATION_MS_VALUE = 42;
        public static final int AD_SHOW_TO_DISPLAY_DURATION_MS_VALUE = 3;
        public static final int AD_SHOW_TO_FAIL_DURATION_MS_VALUE = 36;
        @Deprecated
        public static final int AD_SHOW_TO_PRESENT_DURATION_MS_VALUE = 35;
        public static final int AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE = 48;
        public static final int AD_START_EVENT_VALUE = 46;
        public static final int AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE = 49;
        public static final int AD_WILL_CLOSE_VALUE = 2010;
        public static final int ASSET_DOWNLOAD_DURATION_MS_VALUE = 7;
        public static final int ASSET_FILE_SIZE_VALUE = 13;
        public static final int BANNER_AUTO_REDIRECT_VALUE = 3002;
        public static final int BID_TOKEN_REQUESTED_VALUE = 38;
        public static final int BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS_VALUE = 40;
        public static final int BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 39;
        public static final int CACHED_ASSETS_USED_VALUE = 16;
        public static final int CONFIG_LOADED_FROM_ADM_LOAD_VALUE = 34;
        public static final int CONFIG_LOADED_FROM_AD_LOAD_VALUE = 33;
        public static final int CONFIG_LOADED_FROM_INIT_VALUE = 32;
        public static final int HARDWARE_ACCELERATE_DISABLED_VALUE = 3001;
        public static final int IDFV_RESTRICTED_VALUE = 2007;
        public static final int IDFV_VALUE_CHANGED_VALUE = 2009;
        public static final int INIT_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 6;
        public static final int IOS_STORE_KIT_LOAD_TIME_MS_VALUE = 5;
        public static final int LAUNCH_SAFARI_REQUEST_VALUE = 2006;
        public static final int LAUNCH_SKOVERLAY_REQUEST_VALUE = 2005;
        public static final int LAUNCH_STORE_KIT_REQUEST_VALUE = 2004;
        public static final int LOAD_AD_API_VALUE = 17;
        public static final int LOCAL_ASSETS_USED_VALUE = 8;
        public static final int MRAID_DOWNLOAD_JS_RETRY_SUCCESS_VALUE = 26;
        public static final int NOTIFICATION_REDIRECT_VALUE = 29;
        public static final int NOTIFICATION_WAIT_FOR_CONNECTIVITY_VALUE = 2008;
        public static final int OMSDK_DOWNLOAD_JS_RETRY_SUCCESS_VALUE = 27;
        public static final int PLAY_AD_API_VALUE = 23;
        public static final int PRIVACY_URL_OPENED_VALUE = 28;
        public static final int REMOTE_ASSETS_USED_VALUE = 9;
        public static final int SAFARI_PRESENTED_FOR_AD_VALUE = 2001;
        public static final int SDK_INIT_API_VALUE = 45;
        public static final int SKOVERLAY_PRESENTED_FOR_AD_VALUE = 2000;
        public static final int STORE_KIT_NOT_READY_VALUE = 2003;
        public static final int STORE_KIT_PRESENTED_FOR_AD_VALUE = 2002;
        public static final int TEMPLATE_DOWNLOAD_DURATION_MS_VALUE = 10;
        public static final int TEMPLATE_HTML_SIZE_VALUE = 31;
        public static final int TEMPLATE_ZIP_SIZE_VALUE = 15;
        public static final int TPAT_FIRED_VALUE = 18;
        public static final int TPAT_SUCCESS_VALUE = 19;
        public static final int UNKNOWN_METRIC_TYPE_VALUE = 0;
        public static final int USER_AGENT_LOAD_DURATION_MS_VALUE = 14;
        public static final int VIEW_NOT_VISIBLE_ON_PLAY_VALUE = 25;
        public static final int WIN_NOTIF_FIRED_VALUE = 20;
        public static final int WIN_NOTIF_SUCCESS_VALUE = 21;
        private static final Internal.EnumLiteMap<SDKMetricType> internalValueMap = null;
        private final int value;

        private static final class SDKMetricTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new SDKMetricTypeVerifier();
            }

            private SDKMetricTypeVerifier() {
            }

            public boolean isInRange(int i2) {
                return SDKMetricType.forNumber(i2) != null;
            }
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<SDKMetricType>() {
                public SDKMetricType findValueByNumber(int i2) {
                    return SDKMetricType.forNumber(i2);
                }
            };
        }

        private SDKMetricType(int i2) {
            this.value = i2;
        }

        public static SDKMetricType forNumber(int i2) {
            if (i2 == 3001) {
                return HARDWARE_ACCELERATE_DISABLED;
            }
            if (i2 == 3002) {
                return BANNER_AUTO_REDIRECT;
            }
            switch (i2) {
                case 0:
                    return UNKNOWN_METRIC_TYPE;
                case 1:
                    return AD_REQUEST_TO_RESPONSE_DURATION_MS;
                case 2:
                    return AD_RESPONSE_TO_SHOW_DURATION_MS;
                case 3:
                    return AD_SHOW_TO_DISPLAY_DURATION_MS;
                case 4:
                    return AD_DISPLAY_TO_CLICK_DURATION_MS;
                case 5:
                    return IOS_STORE_KIT_LOAD_TIME_MS;
                case 6:
                    return INIT_REQUEST_TO_RESPONSE_DURATION_MS;
                case 7:
                    return ASSET_DOWNLOAD_DURATION_MS;
                case 8:
                    return LOCAL_ASSETS_USED;
                case 9:
                    return REMOTE_ASSETS_USED;
                case 10:
                    return TEMPLATE_DOWNLOAD_DURATION_MS;
                case 11:
                    return AD_REQUEST_TO_CALLBACK_DURATION_MS;
                case 12:
                    return AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS;
                case 13:
                    return ASSET_FILE_SIZE;
                case 14:
                    return USER_AGENT_LOAD_DURATION_MS;
                case 15:
                    return TEMPLATE_ZIP_SIZE;
                case 16:
                    return CACHED_ASSETS_USED;
                case 17:
                    return LOAD_AD_API;
                case 18:
                    return TPAT_FIRED;
                case 19:
                    return TPAT_SUCCESS;
                case 20:
                    return WIN_NOTIF_FIRED;
                case 21:
                    return WIN_NOTIF_SUCCESS;
                case 22:
                    return AD_EXPIRED_BEFORE_PLAY;
                case 23:
                    return PLAY_AD_API;
                case 24:
                    return AD_LOAD_FAIL;
                case 25:
                    return VIEW_NOT_VISIBLE_ON_PLAY;
                case 26:
                    return MRAID_DOWNLOAD_JS_RETRY_SUCCESS;
                case 27:
                    return OMSDK_DOWNLOAD_JS_RETRY_SUCCESS;
                case 28:
                    return PRIVACY_URL_OPENED;
                case 29:
                    return NOTIFICATION_REDIRECT;
                case 30:
                    return AD_PLAY_RESET_ON_DEINIT;
                case 31:
                    return TEMPLATE_HTML_SIZE;
                case 32:
                    return CONFIG_LOADED_FROM_INIT;
                case 33:
                    return CONFIG_LOADED_FROM_AD_LOAD;
                case 34:
                    return CONFIG_LOADED_FROM_ADM_LOAD;
                case 35:
                    return AD_SHOW_TO_PRESENT_DURATION_MS;
                case 36:
                    return AD_SHOW_TO_FAIL_DURATION_MS;
                case 37:
                    return AD_PRESENT_TO_DISPLAY_DURATION_MS;
                case 38:
                    return BID_TOKEN_REQUESTED;
                case 39:
                    return BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS;
                case 40:
                    return BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS;
                case 41:
                    return AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS;
                case 42:
                    return AD_SHOW_TO_CLOSE_DURATION_MS;
                case 43:
                    return AD_LOAD_TO_CALLBACK_DURATION_MS;
                case 44:
                    return AD_LOAD_TO_CALLBACK_ADO_DURATION_MS;
                case 45:
                    return SDK_INIT_API;
                case 46:
                    return AD_START_EVENT;
                case 47:
                    return AD_CLICK_EVENT;
                case 48:
                    return AD_SHOW_TO_VALIDATION_DURATION_MS;
                case 49:
                    return AD_VALIDATION_TO_PRESENT_DURATION_MS;
                case 50:
                    return AD_LEAVE_APPLICATION;
                case 51:
                    return AD_REWARD_USER;
                case 52:
                    return AD_REQUIRED_DOWNLOAD_DURATION_MS;
                case 53:
                    return AD_OPTIONAL_DOWNLOAD_DURATION_MS;
                default:
                    switch (i2) {
                        case 2000:
                            return SKOVERLAY_PRESENTED_FOR_AD;
                        case 2001:
                            return SAFARI_PRESENTED_FOR_AD;
                        case 2002:
                            return STORE_KIT_PRESENTED_FOR_AD;
                        case 2003:
                            return STORE_KIT_NOT_READY;
                        case 2004:
                            return LAUNCH_STORE_KIT_REQUEST;
                        case 2005:
                            return LAUNCH_SKOVERLAY_REQUEST;
                        case 2006:
                            return LAUNCH_SAFARI_REQUEST;
                        case 2007:
                            return IDFV_RESTRICTED;
                        case 2008:
                            return NOTIFICATION_WAIT_FOR_CONNECTIVITY;
                        case 2009:
                            return IDFV_VALUE_CHANGED;
                        case AD_WILL_CLOSE_VALUE:
                            return AD_WILL_CLOSE;
                        default:
                            return null;
                    }
            }
        }

        public static Internal.EnumLiteMap<SDKMetricType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return SDKMetricTypeVerifier.INSTANCE;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static SDKMetricType valueOf(int i2) {
            return forNumber(i2);
        }
    }

    static {
        Sdk$SDKMetric sdk$SDKMetric = new Sdk$SDKMetric();
        DEFAULT_INSTANCE = sdk$SDKMetric;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKMetric.class, sdk$SDKMetric);
    }

    private Sdk$SDKMetric() {
    }

    /* access modifiers changed from: private */
    public void clearAdSource() {
        this.adSource_ = getDefaultInstance().getAdSource();
    }

    /* access modifiers changed from: private */
    public void clearConnectionType() {
        this.connectionType_ = getDefaultInstance().getConnectionType();
    }

    /* access modifiers changed from: private */
    public void clearConnectionTypeDetail() {
        this.connectionTypeDetail_ = getDefaultInstance().getConnectionTypeDetail();
    }

    /* access modifiers changed from: private */
    public void clearCreativeId() {
        this.creativeId_ = getDefaultInstance().getCreativeId();
    }

    /* access modifiers changed from: private */
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* access modifiers changed from: private */
    public void clearIsHbPlacement() {
        this.isHbPlacement_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearIsLowDataModeEnabled() {
        this.isLowDataModeEnabled_ = false;
    }

    /* access modifiers changed from: private */
    public void clearMake() {
        this.make_ = getDefaultInstance().getMake();
    }

    /* access modifiers changed from: private */
    public void clearMeta() {
        this.meta_ = getDefaultInstance().getMeta();
    }

    /* access modifiers changed from: private */
    public void clearModel() {
        this.model_ = getDefaultInstance().getModel();
    }

    /* access modifiers changed from: private */
    public void clearOs() {
        this.os_ = getDefaultInstance().getOs();
    }

    /* access modifiers changed from: private */
    public void clearOsVersion() {
        this.osVersion_ = getDefaultInstance().getOsVersion();
    }

    /* access modifiers changed from: private */
    public void clearPlacementReferenceId() {
        this.placementReferenceId_ = getDefaultInstance().getPlacementReferenceId();
    }

    /* access modifiers changed from: private */
    public void clearPlacementType() {
        this.placementType_ = getDefaultInstance().getPlacementType();
    }

    /* access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0;
    }

    public static Sdk$SDKMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$SDKMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$SDKMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setAdSource(String str) {
        str.getClass();
        this.adSource_ = str;
    }

    /* access modifiers changed from: private */
    public void setAdSourceBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.adSource_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setConnectionType(String str) {
        str.getClass();
        this.connectionType_ = str;
    }

    /* access modifiers changed from: private */
    public void setConnectionTypeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.connectionType_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setConnectionTypeDetail(String str) {
        str.getClass();
        this.connectionTypeDetail_ = str;
    }

    /* access modifiers changed from: private */
    public void setConnectionTypeDetailBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.connectionTypeDetail_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setCreativeId(String str) {
        str.getClass();
        this.creativeId_ = str;
    }

    /* access modifiers changed from: private */
    public void setCreativeIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.creativeId_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setEventId(String str) {
        str.getClass();
        this.eventId_ = str;
    }

    /* access modifiers changed from: private */
    public void setEventIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.eventId_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setIsHbPlacement(long j2) {
        this.isHbPlacement_ = j2;
    }

    /* access modifiers changed from: private */
    public void setIsLowDataModeEnabled(boolean z2) {
        this.isLowDataModeEnabled_ = z2;
    }

    /* access modifiers changed from: private */
    public void setMake(String str) {
        str.getClass();
        this.make_ = str;
    }

    /* access modifiers changed from: private */
    public void setMakeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.make_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setMeta(String str) {
        str.getClass();
        this.meta_ = str;
    }

    /* access modifiers changed from: private */
    public void setMetaBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.meta_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setModel(String str) {
        str.getClass();
        this.model_ = str;
    }

    /* access modifiers changed from: private */
    public void setModelBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.model_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setOs(String str) {
        str.getClass();
        this.os_ = str;
    }

    /* access modifiers changed from: private */
    public void setOsBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.os_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setOsVersion(String str) {
        str.getClass();
        this.osVersion_ = str;
    }

    /* access modifiers changed from: private */
    public void setOsVersionBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.osVersion_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setPlacementReferenceId(String str) {
        str.getClass();
        this.placementReferenceId_ = str;
    }

    /* access modifiers changed from: private */
    public void setPlacementReferenceIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.placementReferenceId_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setPlacementType(String str) {
        str.getClass();
        this.placementType_ = str;
    }

    /* access modifiers changed from: private */
    public void setPlacementTypeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.placementType_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setType(SDKMetricType sDKMetricType) {
        this.type_ = sDKMetricType.getNumber();
    }

    /* access modifiers changed from: private */
    public void setTypeValue(int i2) {
        this.type_ = i2;
    }

    /* access modifiers changed from: private */
    public void setValue(long j2) {
        this.value_ = j2;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Sdk$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKMetric();
            case 2:
                return new Builder((Sdk$1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0000\u0001É\u0011\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002\u000fȈ\u0010ȈÉ\u0007", new Object[]{"type_", "value_", "meta_", "make_", "model_", "os_", "osVersion_", "connectionType_", "connectionTypeDetail_", "placementReferenceId_", "creativeId_", "eventId_", "sessionId_", "isHbPlacement_", "placementType_", "adSource_", "isLowDataModeEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$SDKMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (Sdk$SDKMetric.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getAdSource() {
        return this.adSource_;
    }

    public ByteString getAdSourceBytes() {
        return ByteString.copyFromUtf8(this.adSource_);
    }

    public String getConnectionType() {
        return this.connectionType_;
    }

    public ByteString getConnectionTypeBytes() {
        return ByteString.copyFromUtf8(this.connectionType_);
    }

    public String getConnectionTypeDetail() {
        return this.connectionTypeDetail_;
    }

    public ByteString getConnectionTypeDetailBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetail_);
    }

    public String getCreativeId() {
        return this.creativeId_;
    }

    public ByteString getCreativeIdBytes() {
        return ByteString.copyFromUtf8(this.creativeId_);
    }

    public String getEventId() {
        return this.eventId_;
    }

    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    public long getIsHbPlacement() {
        return this.isHbPlacement_;
    }

    public boolean getIsLowDataModeEnabled() {
        return this.isLowDataModeEnabled_;
    }

    public String getMake() {
        return this.make_;
    }

    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    public String getMeta() {
        return this.meta_;
    }

    public ByteString getMetaBytes() {
        return ByteString.copyFromUtf8(this.meta_);
    }

    public String getModel() {
        return this.model_;
    }

    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    public String getOs() {
        return this.os_;
    }

    public ByteString getOsBytes() {
        return ByteString.copyFromUtf8(this.os_);
    }

    public String getOsVersion() {
        return this.osVersion_;
    }

    public ByteString getOsVersionBytes() {
        return ByteString.copyFromUtf8(this.osVersion_);
    }

    public String getPlacementReferenceId() {
        return this.placementReferenceId_;
    }

    public ByteString getPlacementReferenceIdBytes() {
        return ByteString.copyFromUtf8(this.placementReferenceId_);
    }

    public String getPlacementType() {
        return this.placementType_;
    }

    public ByteString getPlacementTypeBytes() {
        return ByteString.copyFromUtf8(this.placementType_);
    }

    public String getSessionId() {
        return this.sessionId_;
    }

    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public SDKMetricType getType() {
        SDKMetricType forNumber = SDKMetricType.forNumber(this.type_);
        if (forNumber == null) {
            return SDKMetricType.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public long getValue() {
        return this.value_;
    }

    public static Builder newBuilder(Sdk$SDKMetric sdk$SDKMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(sdk$SDKMetric);
    }

    public static Sdk$SDKMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKMetric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKMetric parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$SDKMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}

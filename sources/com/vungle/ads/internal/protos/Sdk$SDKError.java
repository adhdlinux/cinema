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

public final class Sdk$SDKError extends GeneratedMessageLite<Sdk$SDKError, Builder> implements Sdk$SDKErrorOrBuilder {
    public static final int ADSOURCE_FIELD_NUMBER = 16;
    public static final int AT_FIELD_NUMBER = 1;
    public static final int CONNECTIONTYPEDETAILANDROID_FIELD_NUMBER = 101;
    public static final int CONNECTIONTYPEDETAIL_FIELD_NUMBER = 10;
    public static final int CONNECTIONTYPE_FIELD_NUMBER = 9;
    public static final int CREATIVEID_FIELD_NUMBER = 12;
    /* access modifiers changed from: private */
    public static final Sdk$SDKError DEFAULT_INSTANCE;
    public static final int EVENTID_FIELD_NUMBER = 4;
    public static final int ISHBPLACEMENT_FIELD_NUMBER = 14;
    public static final int ISLOWDATAMODEENABLED_FIELD_NUMBER = 201;
    public static final int MAKE_FIELD_NUMBER = 5;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    public static final int MODEL_FIELD_NUMBER = 6;
    public static final int OSVERSION_FIELD_NUMBER = 8;
    public static final int OS_FIELD_NUMBER = 7;
    private static volatile Parser<Sdk$SDKError> PARSER = null;
    public static final int PLACEMENTREFERENCEID_FIELD_NUMBER = 11;
    public static final int PLACEMENTTYPE_FIELD_NUMBER = 15;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SESSIONID_FIELD_NUMBER = 13;
    private String adSource_ = "";
    private long at_;
    private String connectionTypeDetailAndroid_ = "";
    private String connectionTypeDetail_ = "";
    private String connectionType_ = "";
    private String creativeId_ = "";
    private String eventId_ = "";
    private long isHbPlacement_;
    private boolean isLowDataModeEnabled_;
    private String make_ = "";
    private String message_ = "";
    private String model_ = "";
    private String osVersion_ = "";
    private String os_ = "";
    private String placementReferenceId_ = "";
    private String placementType_ = "";
    private int reason_;
    private String sessionId_ = "";

    public static final class Builder extends GeneratedMessageLite.Builder<Sdk$SDKError, Builder> implements Sdk$SDKErrorOrBuilder {
        /* synthetic */ Builder(Sdk$1 sdk$1) {
            this();
        }

        public Builder clearAdSource() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearAdSource();
            return this;
        }

        public Builder clearAt() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearAt();
            return this;
        }

        public Builder clearConnectionType() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearConnectionType();
            return this;
        }

        public Builder clearConnectionTypeDetail() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearConnectionTypeDetail();
            return this;
        }

        public Builder clearConnectionTypeDetailAndroid() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearConnectionTypeDetailAndroid();
            return this;
        }

        public Builder clearCreativeId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearCreativeId();
            return this;
        }

        public Builder clearEventId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearEventId();
            return this;
        }

        public Builder clearIsHbPlacement() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearIsHbPlacement();
            return this;
        }

        public Builder clearIsLowDataModeEnabled() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearIsLowDataModeEnabled();
            return this;
        }

        public Builder clearMake() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearMake();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearMessage();
            return this;
        }

        public Builder clearModel() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearModel();
            return this;
        }

        public Builder clearOs() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearOs();
            return this;
        }

        public Builder clearOsVersion() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearOsVersion();
            return this;
        }

        public Builder clearPlacementReferenceId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearPlacementReferenceId();
            return this;
        }

        public Builder clearPlacementType() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearPlacementType();
            return this;
        }

        public Builder clearReason() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearReason();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).clearSessionId();
            return this;
        }

        public String getAdSource() {
            return ((Sdk$SDKError) this.instance).getAdSource();
        }

        public ByteString getAdSourceBytes() {
            return ((Sdk$SDKError) this.instance).getAdSourceBytes();
        }

        public long getAt() {
            return ((Sdk$SDKError) this.instance).getAt();
        }

        public String getConnectionType() {
            return ((Sdk$SDKError) this.instance).getConnectionType();
        }

        public ByteString getConnectionTypeBytes() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeBytes();
        }

        public String getConnectionTypeDetail() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetail();
        }

        public String getConnectionTypeDetailAndroid() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetailAndroid();
        }

        public ByteString getConnectionTypeDetailAndroidBytes() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetailAndroidBytes();
        }

        public ByteString getConnectionTypeDetailBytes() {
            return ((Sdk$SDKError) this.instance).getConnectionTypeDetailBytes();
        }

        public String getCreativeId() {
            return ((Sdk$SDKError) this.instance).getCreativeId();
        }

        public ByteString getCreativeIdBytes() {
            return ((Sdk$SDKError) this.instance).getCreativeIdBytes();
        }

        public String getEventId() {
            return ((Sdk$SDKError) this.instance).getEventId();
        }

        public ByteString getEventIdBytes() {
            return ((Sdk$SDKError) this.instance).getEventIdBytes();
        }

        public long getIsHbPlacement() {
            return ((Sdk$SDKError) this.instance).getIsHbPlacement();
        }

        public boolean getIsLowDataModeEnabled() {
            return ((Sdk$SDKError) this.instance).getIsLowDataModeEnabled();
        }

        public String getMake() {
            return ((Sdk$SDKError) this.instance).getMake();
        }

        public ByteString getMakeBytes() {
            return ((Sdk$SDKError) this.instance).getMakeBytes();
        }

        public String getMessage() {
            return ((Sdk$SDKError) this.instance).getMessage();
        }

        public ByteString getMessageBytes() {
            return ((Sdk$SDKError) this.instance).getMessageBytes();
        }

        public String getModel() {
            return ((Sdk$SDKError) this.instance).getModel();
        }

        public ByteString getModelBytes() {
            return ((Sdk$SDKError) this.instance).getModelBytes();
        }

        public String getOs() {
            return ((Sdk$SDKError) this.instance).getOs();
        }

        public ByteString getOsBytes() {
            return ((Sdk$SDKError) this.instance).getOsBytes();
        }

        public String getOsVersion() {
            return ((Sdk$SDKError) this.instance).getOsVersion();
        }

        public ByteString getOsVersionBytes() {
            return ((Sdk$SDKError) this.instance).getOsVersionBytes();
        }

        public String getPlacementReferenceId() {
            return ((Sdk$SDKError) this.instance).getPlacementReferenceId();
        }

        public ByteString getPlacementReferenceIdBytes() {
            return ((Sdk$SDKError) this.instance).getPlacementReferenceIdBytes();
        }

        public String getPlacementType() {
            return ((Sdk$SDKError) this.instance).getPlacementType();
        }

        public ByteString getPlacementTypeBytes() {
            return ((Sdk$SDKError) this.instance).getPlacementTypeBytes();
        }

        public Reason getReason() {
            return ((Sdk$SDKError) this.instance).getReason();
        }

        public int getReasonValue() {
            return ((Sdk$SDKError) this.instance).getReasonValue();
        }

        public String getSessionId() {
            return ((Sdk$SDKError) this.instance).getSessionId();
        }

        public ByteString getSessionIdBytes() {
            return ((Sdk$SDKError) this.instance).getSessionIdBytes();
        }

        public Builder setAdSource(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setAdSource(str);
            return this;
        }

        public Builder setAdSourceBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setAdSourceBytes(byteString);
            return this;
        }

        public Builder setAt(long j2) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setAt(j2);
            return this;
        }

        public Builder setConnectionType(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionType(str);
            return this;
        }

        public Builder setConnectionTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeBytes(byteString);
            return this;
        }

        public Builder setConnectionTypeDetail(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetail(str);
            return this;
        }

        public Builder setConnectionTypeDetailAndroid(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetailAndroid(str);
            return this;
        }

        public Builder setConnectionTypeDetailAndroidBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetailAndroidBytes(byteString);
            return this;
        }

        public Builder setConnectionTypeDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setConnectionTypeDetailBytes(byteString);
            return this;
        }

        public Builder setCreativeId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setCreativeId(str);
            return this;
        }

        public Builder setCreativeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setCreativeIdBytes(byteString);
            return this;
        }

        public Builder setEventId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setEventId(str);
            return this;
        }

        public Builder setEventIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public Builder setIsHbPlacement(long j2) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setIsHbPlacement(j2);
            return this;
        }

        public Builder setIsLowDataModeEnabled(boolean z2) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setIsLowDataModeEnabled(z2);
            return this;
        }

        public Builder setMake(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMake(str);
            return this;
        }

        public Builder setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMakeBytes(byteString);
            return this;
        }

        public Builder setMessage(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMessage(str);
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setMessageBytes(byteString);
            return this;
        }

        public Builder setModel(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setModel(str);
            return this;
        }

        public Builder setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setModelBytes(byteString);
            return this;
        }

        public Builder setOs(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOs(str);
            return this;
        }

        public Builder setOsBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOsBytes(byteString);
            return this;
        }

        public Builder setOsVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOsVersion(str);
            return this;
        }

        public Builder setOsVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setOsVersionBytes(byteString);
            return this;
        }

        public Builder setPlacementReferenceId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setPlacementReferenceId(str);
            return this;
        }

        public Builder setPlacementReferenceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setPlacementReferenceIdBytes(byteString);
            return this;
        }

        public Builder setPlacementType(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setPlacementType(str);
            return this;
        }

        public Builder setPlacementTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setPlacementTypeBytes(byteString);
            return this;
        }

        public Builder setReason(Reason reason) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setReason(reason);
            return this;
        }

        public Builder setReasonValue(int i2) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setReasonValue(i2);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(Sdk$SDKError.DEFAULT_INSTANCE);
        }
    }

    public enum Reason implements Internal.EnumLite {
        UNKNOWN_ERROR(0),
        INVALID_APP_ID(2),
        CURRENTLY_INITIALIZING(3),
        ALREADY_INITIALIZED(4),
        SDK_NOT_INITIALIZED(6),
        USER_AGENT_ERROR(7),
        API_REQUEST_ERROR(101),
        API_RESPONSE_DATA_ERROR(102),
        API_RESPONSE_DECODE_ERROR(103),
        API_FAILED_STATUS_CODE(104),
        INVALID_TEMPLATE_URL(105),
        INVALID_REQUEST_BUILDER_ERROR(106),
        TEMPLATE_UNZIP_ERROR(109),
        INVALID_CTA_URL(110),
        INVALID_ASSET_URL(111),
        ASSET_REQUEST_ERROR(112),
        ASSET_RESPONSE_DATA_ERROR(113),
        ASSET_WRITE_ERROR(114),
        INVALID_INDEX_URL(115),
        GZIP_ENCODE_ERROR(116),
        ASSET_FAILED_STATUS_CODE(117),
        PROTOBUF_SERIALIZATION_ERROR(118),
        JSON_ENCODE_ERROR(119),
        TPAT_ERROR(121),
        INVALID_ADS_ENDPOINT(122),
        INVALID_RI_ENDPOINT(123),
        INVALID_LOG_ERROR_ENDPOINT(124),
        INVALID_METRICS_ENDPOINT(125),
        ASSET_FAILED_INSUFFICIENT_SPACE(126),
        ASSET_FAILED_MAX_SPACE_EXCEEDED(127),
        INVALID_TPAT_KEY(128),
        EMPTY_TPAT_ERROR(EMPTY_TPAT_ERROR_VALUE),
        MRAID_DOWNLOAD_JS_ERROR(MRAID_DOWNLOAD_JS_ERROR_VALUE),
        MRAID_JS_WRITE_FAILED(MRAID_JS_WRITE_FAILED_VALUE),
        OMSDK_DOWNLOAD_JS_ERROR(OMSDK_DOWNLOAD_JS_ERROR_VALUE),
        OMSDK_JS_WRITE_FAILED(OMSDK_JS_WRITE_FAILED_VALUE),
        STORE_REGION_CODE_ERROR(STORE_REGION_CODE_ERROR_VALUE),
        INVALID_CONFIG_RESPONSE(INVALID_CONFIG_RESPONSE_VALUE),
        PRIVACY_URL_ERROR(PRIVACY_URL_ERROR_VALUE),
        TPAT_RETRY_FAILED(TPAT_RETRY_FAILED_VALUE),
        CONFIG_REFRESH_FAILED(CONFIG_REFRESH_FAILED_VALUE),
        INVALID_EVENT_ID_ERROR(200),
        INVALID_PLACEMENT_ID(201),
        AD_CONSUMED(202),
        AD_IS_LOADING(203),
        AD_ALREADY_LOADED(204),
        AD_IS_PLAYING(AD_IS_PLAYING_VALUE),
        AD_ALREADY_FAILED(AD_ALREADY_FAILED_VALUE),
        PLACEMENT_AD_TYPE_MISMATCH(PLACEMENT_AD_TYPE_MISMATCH_VALUE),
        INVALID_BID_PAYLOAD(208),
        INVALID_JSON_BID_PAYLOAD(INVALID_JSON_BID_PAYLOAD_VALUE),
        AD_NOT_LOADED(AD_NOT_LOADED_VALUE),
        PLACEMENT_SLEEP(PLACEMENT_SLEEP_VALUE),
        INVALID_ADUNIT_BID_PAYLOAD(INVALID_ADUNIT_BID_PAYLOAD_VALUE),
        INVALID_GZIP_BID_PAYLOAD(INVALID_GZIP_BID_PAYLOAD_VALUE),
        AD_RESPONSE_EMPTY(215),
        AD_RESPONSE_INVALID_TEMPLATE_TYPE(216),
        AD_RESPONSE_TIMED_OUT(217),
        MRAID_JS_DOES_NOT_EXIST(218),
        MRAID_JS_COPY_FAILED(MRAID_JS_COPY_FAILED_VALUE),
        AD_RESPONSE_RETRY_AFTER(AD_RESPONSE_RETRY_AFTER_VALUE),
        AD_LOAD_FAIL_RETRY_AFTER(AD_LOAD_FAIL_RETRY_AFTER_VALUE),
        INVALID_WATERFALL_PLACEMENT_ID(INVALID_WATERFALL_PLACEMENT_ID_VALUE),
        STALE_CACHED_RESPONSE(STALE_CACHED_RESPONSE_VALUE),
        AD_NO_FILL(AD_NO_FILL_VALUE),
        AD_LOAD_TOO_FREQUENTLY(AD_LOAD_TOO_FREQUENTLY_VALUE),
        AD_SERVER_ERROR(AD_SERVER_ERROR_VALUE),
        AD_PUBLISHER_MISMATCH(AD_PUBLISHER_MISMATCH_VALUE),
        AD_INTERNAL_INTEGRATION_ERROR(AD_INTERNAL_INTEGRATION_ERROR_VALUE),
        CONFIG_NOT_FOUND_ERROR(CONFIG_NOT_FOUND_ERROR_VALUE),
        MRAID_ERROR(301),
        INVALID_IFA_STATUS(INVALID_IFA_STATUS_VALUE),
        AD_EXPIRED(AD_EXPIRED_VALUE),
        MRAID_BRIDGE_ERROR(MRAID_BRIDGE_ERROR_VALUE),
        AD_EXPIRED_ON_PLAY(307),
        AD_WIN_NOTIFICATION_ERROR(308),
        ASSET_FAILED_TO_DELETE(ASSET_FAILED_TO_DELETE_VALUE),
        AD_HTML_FAILED_TO_LOAD(AD_HTML_FAILED_TO_LOAD_VALUE),
        MRAID_JS_CALL_EMPTY(311),
        DEEPLINK_OPEN_FAILED(312),
        EVALUATE_JAVASCRIPT_FAILED(313),
        LINK_COMMAND_OPEN_FAILED(314),
        JSON_PARAMS_ENCODE_ERROR(315),
        GENERATE_JSON_DATA_ERROR(316),
        AD_CLOSED_TEMPLATE_ERROR(AD_CLOSED_TEMPLATE_ERROR_VALUE),
        AD_CLOSED_MISSING_HEARTBEAT(AD_CLOSED_MISSING_HEARTBEAT_VALUE),
        SILENT_MODE_MONITOR_ERROR(SILENT_MODE_MONITOR_ERROR_VALUE),
        WEBVIEW_ERROR(WEBVIEW_ERROR_VALUE),
        CONCURRENT_PLAYBACK_UNSUPPORTED(400),
        BANNER_VIEW_INVALID_SIZE(500),
        NATIVE_ASSET_ERROR(600),
        WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE(2000),
        WEB_VIEW_FAILED_NAVIGATION(2001),
        STORE_KIT_LOAD_ERROR(2002),
        OMSDK_COPY_ERROR(2003),
        STORE_OVERLAY_LOAD_ERROR(2004),
        REACHABILITY_INITIALIZATION_FAILED(2005),
        UNKNOWN_RADIO_ACCESS_TECHNOLOGY(2006),
        STORE_KIT_PRESENTATION_ERROR(2007),
        STORE_OVERLAY_PRESENTATION_ERROR(2008),
        INVALID_PLAY_PARAMETER(2009),
        OUT_OF_MEMORY(3001),
        UNRECOGNIZED(-1);
        
        public static final int AD_ALREADY_FAILED_VALUE = 206;
        public static final int AD_ALREADY_LOADED_VALUE = 204;
        public static final int AD_CLOSED_MISSING_HEARTBEAT_VALUE = 318;
        public static final int AD_CLOSED_TEMPLATE_ERROR_VALUE = 317;
        public static final int AD_CONSUMED_VALUE = 202;
        public static final int AD_EXPIRED_ON_PLAY_VALUE = 307;
        public static final int AD_EXPIRED_VALUE = 304;
        public static final int AD_HTML_FAILED_TO_LOAD_VALUE = 310;
        public static final int AD_INTERNAL_INTEGRATION_ERROR_VALUE = 30002;
        public static final int AD_IS_LOADING_VALUE = 203;
        public static final int AD_IS_PLAYING_VALUE = 205;
        public static final int AD_LOAD_FAIL_RETRY_AFTER_VALUE = 221;
        public static final int AD_LOAD_TOO_FREQUENTLY_VALUE = 10002;
        public static final int AD_NOT_LOADED_VALUE = 210;
        public static final int AD_NO_FILL_VALUE = 10001;
        public static final int AD_PUBLISHER_MISMATCH_VALUE = 30001;
        public static final int AD_RESPONSE_EMPTY_VALUE = 215;
        public static final int AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE = 216;
        public static final int AD_RESPONSE_RETRY_AFTER_VALUE = 220;
        public static final int AD_RESPONSE_TIMED_OUT_VALUE = 217;
        public static final int AD_SERVER_ERROR_VALUE = 20001;
        public static final int AD_WIN_NOTIFICATION_ERROR_VALUE = 308;
        public static final int ALREADY_INITIALIZED_VALUE = 4;
        public static final int API_FAILED_STATUS_CODE_VALUE = 104;
        public static final int API_REQUEST_ERROR_VALUE = 101;
        public static final int API_RESPONSE_DATA_ERROR_VALUE = 102;
        public static final int API_RESPONSE_DECODE_ERROR_VALUE = 103;
        public static final int ASSET_FAILED_INSUFFICIENT_SPACE_VALUE = 126;
        public static final int ASSET_FAILED_MAX_SPACE_EXCEEDED_VALUE = 127;
        public static final int ASSET_FAILED_STATUS_CODE_VALUE = 117;
        public static final int ASSET_FAILED_TO_DELETE_VALUE = 309;
        public static final int ASSET_REQUEST_ERROR_VALUE = 112;
        public static final int ASSET_RESPONSE_DATA_ERROR_VALUE = 113;
        public static final int ASSET_WRITE_ERROR_VALUE = 114;
        public static final int BANNER_VIEW_INVALID_SIZE_VALUE = 500;
        public static final int CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE = 400;
        public static final int CONFIG_NOT_FOUND_ERROR_VALUE = 30003;
        public static final int CONFIG_REFRESH_FAILED_VALUE = 138;
        public static final int CURRENTLY_INITIALIZING_VALUE = 3;
        public static final int DEEPLINK_OPEN_FAILED_VALUE = 312;
        public static final int EMPTY_TPAT_ERROR_VALUE = 129;
        public static final int EVALUATE_JAVASCRIPT_FAILED_VALUE = 313;
        public static final int GENERATE_JSON_DATA_ERROR_VALUE = 316;
        public static final int GZIP_ENCODE_ERROR_VALUE = 116;
        public static final int INVALID_ADS_ENDPOINT_VALUE = 122;
        public static final int INVALID_ADUNIT_BID_PAYLOAD_VALUE = 213;
        public static final int INVALID_APP_ID_VALUE = 2;
        public static final int INVALID_ASSET_URL_VALUE = 111;
        public static final int INVALID_BID_PAYLOAD_VALUE = 208;
        public static final int INVALID_CONFIG_RESPONSE_VALUE = 135;
        public static final int INVALID_CTA_URL_VALUE = 110;
        public static final int INVALID_EVENT_ID_ERROR_VALUE = 200;
        public static final int INVALID_GZIP_BID_PAYLOAD_VALUE = 214;
        public static final int INVALID_IFA_STATUS_VALUE = 302;
        public static final int INVALID_INDEX_URL_VALUE = 115;
        public static final int INVALID_JSON_BID_PAYLOAD_VALUE = 209;
        public static final int INVALID_LOG_ERROR_ENDPOINT_VALUE = 124;
        public static final int INVALID_METRICS_ENDPOINT_VALUE = 125;
        public static final int INVALID_PLACEMENT_ID_VALUE = 201;
        public static final int INVALID_PLAY_PARAMETER_VALUE = 2009;
        public static final int INVALID_REQUEST_BUILDER_ERROR_VALUE = 106;
        public static final int INVALID_RI_ENDPOINT_VALUE = 123;
        public static final int INVALID_TEMPLATE_URL_VALUE = 105;
        public static final int INVALID_TPAT_KEY_VALUE = 128;
        public static final int INVALID_WATERFALL_PLACEMENT_ID_VALUE = 222;
        public static final int JSON_ENCODE_ERROR_VALUE = 119;
        public static final int JSON_PARAMS_ENCODE_ERROR_VALUE = 315;
        public static final int LINK_COMMAND_OPEN_FAILED_VALUE = 314;
        public static final int MRAID_BRIDGE_ERROR_VALUE = 305;
        public static final int MRAID_DOWNLOAD_JS_ERROR_VALUE = 130;
        public static final int MRAID_ERROR_VALUE = 301;
        public static final int MRAID_JS_CALL_EMPTY_VALUE = 311;
        public static final int MRAID_JS_COPY_FAILED_VALUE = 219;
        public static final int MRAID_JS_DOES_NOT_EXIST_VALUE = 218;
        public static final int MRAID_JS_WRITE_FAILED_VALUE = 131;
        public static final int NATIVE_ASSET_ERROR_VALUE = 600;
        public static final int OMSDK_COPY_ERROR_VALUE = 2003;
        public static final int OMSDK_DOWNLOAD_JS_ERROR_VALUE = 132;
        public static final int OMSDK_JS_WRITE_FAILED_VALUE = 133;
        public static final int OUT_OF_MEMORY_VALUE = 3001;
        public static final int PLACEMENT_AD_TYPE_MISMATCH_VALUE = 207;
        public static final int PLACEMENT_SLEEP_VALUE = 212;
        public static final int PRIVACY_URL_ERROR_VALUE = 136;
        public static final int PROTOBUF_SERIALIZATION_ERROR_VALUE = 118;
        public static final int REACHABILITY_INITIALIZATION_FAILED_VALUE = 2005;
        public static final int SDK_NOT_INITIALIZED_VALUE = 6;
        public static final int SILENT_MODE_MONITOR_ERROR_VALUE = 319;
        public static final int STALE_CACHED_RESPONSE_VALUE = 223;
        public static final int STORE_KIT_LOAD_ERROR_VALUE = 2002;
        public static final int STORE_KIT_PRESENTATION_ERROR_VALUE = 2007;
        public static final int STORE_OVERLAY_LOAD_ERROR_VALUE = 2004;
        public static final int STORE_OVERLAY_PRESENTATION_ERROR_VALUE = 2008;
        public static final int STORE_REGION_CODE_ERROR_VALUE = 134;
        public static final int TEMPLATE_UNZIP_ERROR_VALUE = 109;
        public static final int TPAT_ERROR_VALUE = 121;
        public static final int TPAT_RETRY_FAILED_VALUE = 137;
        public static final int UNKNOWN_ERROR_VALUE = 0;
        public static final int UNKNOWN_RADIO_ACCESS_TECHNOLOGY_VALUE = 2006;
        public static final int USER_AGENT_ERROR_VALUE = 7;
        public static final int WEBVIEW_ERROR_VALUE = 320;
        public static final int WEB_VIEW_FAILED_NAVIGATION_VALUE = 2001;
        public static final int WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE_VALUE = 2000;
        private static final Internal.EnumLiteMap<Reason> internalValueMap = null;
        private final int value;

        private static final class ReasonVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new ReasonVerifier();
            }

            private ReasonVerifier() {
            }

            public boolean isInRange(int i2) {
                return Reason.forNumber(i2) != null;
            }
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<Reason>() {
                public Reason findValueByNumber(int i2) {
                    return Reason.forNumber(i2);
                }
            };
        }

        private Reason(int i2) {
            this.value = i2;
        }

        public static Reason forNumber(int i2) {
            if (i2 != 0) {
                if (i2 == 2) {
                    return INVALID_APP_ID;
                }
                if (i2 == 3) {
                    return CURRENTLY_INITIALIZING;
                }
                if (i2 == 4) {
                    return ALREADY_INITIALIZED;
                }
                if (i2 == 6) {
                    return SDK_NOT_INITIALIZED;
                }
                if (i2 == 7) {
                    return USER_AGENT_ERROR;
                }
                if (i2 == 301) {
                    return MRAID_ERROR;
                }
                if (i2 == 302) {
                    return INVALID_IFA_STATUS;
                }
                if (i2 == 304) {
                    return AD_EXPIRED;
                }
                if (i2 == 305) {
                    return MRAID_BRIDGE_ERROR;
                }
                switch (i2) {
                    case 0:
                        break;
                    case 121:
                        return TPAT_ERROR;
                    case 122:
                        return INVALID_ADS_ENDPOINT;
                    case 123:
                        return INVALID_RI_ENDPOINT;
                    case 124:
                        return INVALID_LOG_ERROR_ENDPOINT;
                    case 125:
                        return INVALID_METRICS_ENDPOINT;
                    case 126:
                        return ASSET_FAILED_INSUFFICIENT_SPACE;
                    case 127:
                        return ASSET_FAILED_MAX_SPACE_EXCEEDED;
                    case 128:
                        return INVALID_TPAT_KEY;
                    case EMPTY_TPAT_ERROR_VALUE:
                        return EMPTY_TPAT_ERROR;
                    case MRAID_DOWNLOAD_JS_ERROR_VALUE:
                        return MRAID_DOWNLOAD_JS_ERROR;
                    case MRAID_JS_WRITE_FAILED_VALUE:
                        return MRAID_JS_WRITE_FAILED;
                    case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                        return OMSDK_DOWNLOAD_JS_ERROR;
                    case OMSDK_JS_WRITE_FAILED_VALUE:
                        return OMSDK_JS_WRITE_FAILED;
                    case STORE_REGION_CODE_ERROR_VALUE:
                        return STORE_REGION_CODE_ERROR;
                    case INVALID_CONFIG_RESPONSE_VALUE:
                        return INVALID_CONFIG_RESPONSE;
                    case PRIVACY_URL_ERROR_VALUE:
                        return PRIVACY_URL_ERROR;
                    case TPAT_RETRY_FAILED_VALUE:
                        return TPAT_RETRY_FAILED;
                    case CONFIG_REFRESH_FAILED_VALUE:
                        return CONFIG_REFRESH_FAILED;
                    case 400:
                        return CONCURRENT_PLAYBACK_UNSUPPORTED;
                    case 500:
                        return BANNER_VIEW_INVALID_SIZE;
                    case 600:
                        return NATIVE_ASSET_ERROR;
                    case 2000:
                        return WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE;
                    case 2001:
                        return WEB_VIEW_FAILED_NAVIGATION;
                    case 2002:
                        return STORE_KIT_LOAD_ERROR;
                    case 2003:
                        return OMSDK_COPY_ERROR;
                    case 2004:
                        return STORE_OVERLAY_LOAD_ERROR;
                    case 2005:
                        return REACHABILITY_INITIALIZATION_FAILED;
                    case 2006:
                        return UNKNOWN_RADIO_ACCESS_TECHNOLOGY;
                    case 2007:
                        return STORE_KIT_PRESENTATION_ERROR;
                    case 2008:
                        return STORE_OVERLAY_PRESENTATION_ERROR;
                    case 2009:
                        return INVALID_PLAY_PARAMETER;
                    case 3001:
                        return OUT_OF_MEMORY;
                    case AD_NO_FILL_VALUE:
                        return AD_NO_FILL;
                    case AD_LOAD_TOO_FREQUENTLY_VALUE:
                        return AD_LOAD_TOO_FREQUENTLY;
                    case AD_SERVER_ERROR_VALUE:
                        return AD_SERVER_ERROR;
                    case AD_PUBLISHER_MISMATCH_VALUE:
                        return AD_PUBLISHER_MISMATCH;
                    case AD_INTERNAL_INTEGRATION_ERROR_VALUE:
                        return AD_INTERNAL_INTEGRATION_ERROR;
                    case CONFIG_NOT_FOUND_ERROR_VALUE:
                        return CONFIG_NOT_FOUND_ERROR;
                    default:
                        switch (i2) {
                            case 101:
                                return API_REQUEST_ERROR;
                            case 102:
                                return API_RESPONSE_DATA_ERROR;
                            case 103:
                                return API_RESPONSE_DECODE_ERROR;
                            case 104:
                                return API_FAILED_STATUS_CODE;
                            case 105:
                                return INVALID_TEMPLATE_URL;
                            case 106:
                                return INVALID_REQUEST_BUILDER_ERROR;
                            default:
                                switch (i2) {
                                    case 109:
                                        return TEMPLATE_UNZIP_ERROR;
                                    case 110:
                                        return INVALID_CTA_URL;
                                    case 111:
                                        return INVALID_ASSET_URL;
                                    case 112:
                                        return ASSET_REQUEST_ERROR;
                                    case 113:
                                        return ASSET_RESPONSE_DATA_ERROR;
                                    case 114:
                                        return ASSET_WRITE_ERROR;
                                    case 115:
                                        return INVALID_INDEX_URL;
                                    case 116:
                                        return GZIP_ENCODE_ERROR;
                                    case 117:
                                        return ASSET_FAILED_STATUS_CODE;
                                    case 118:
                                        return PROTOBUF_SERIALIZATION_ERROR;
                                    case 119:
                                        return JSON_ENCODE_ERROR;
                                    default:
                                        switch (i2) {
                                            case 200:
                                                return INVALID_EVENT_ID_ERROR;
                                            case 201:
                                                return INVALID_PLACEMENT_ID;
                                            case 202:
                                                return AD_CONSUMED;
                                            case 203:
                                                return AD_IS_LOADING;
                                            case 204:
                                                return AD_ALREADY_LOADED;
                                            case AD_IS_PLAYING_VALUE:
                                                return AD_IS_PLAYING;
                                            case AD_ALREADY_FAILED_VALUE:
                                                return AD_ALREADY_FAILED;
                                            case PLACEMENT_AD_TYPE_MISMATCH_VALUE:
                                                return PLACEMENT_AD_TYPE_MISMATCH;
                                            case 208:
                                                return INVALID_BID_PAYLOAD;
                                            case INVALID_JSON_BID_PAYLOAD_VALUE:
                                                return INVALID_JSON_BID_PAYLOAD;
                                            case AD_NOT_LOADED_VALUE:
                                                return AD_NOT_LOADED;
                                            default:
                                                switch (i2) {
                                                    case PLACEMENT_SLEEP_VALUE:
                                                        return PLACEMENT_SLEEP;
                                                    case INVALID_ADUNIT_BID_PAYLOAD_VALUE:
                                                        return INVALID_ADUNIT_BID_PAYLOAD;
                                                    case INVALID_GZIP_BID_PAYLOAD_VALUE:
                                                        return INVALID_GZIP_BID_PAYLOAD;
                                                    case 215:
                                                        return AD_RESPONSE_EMPTY;
                                                    case 216:
                                                        return AD_RESPONSE_INVALID_TEMPLATE_TYPE;
                                                    case 217:
                                                        return AD_RESPONSE_TIMED_OUT;
                                                    case 218:
                                                        return MRAID_JS_DOES_NOT_EXIST;
                                                    case MRAID_JS_COPY_FAILED_VALUE:
                                                        return MRAID_JS_COPY_FAILED;
                                                    case AD_RESPONSE_RETRY_AFTER_VALUE:
                                                        return AD_RESPONSE_RETRY_AFTER;
                                                    case AD_LOAD_FAIL_RETRY_AFTER_VALUE:
                                                        return AD_LOAD_FAIL_RETRY_AFTER;
                                                    case INVALID_WATERFALL_PLACEMENT_ID_VALUE:
                                                        return INVALID_WATERFALL_PLACEMENT_ID;
                                                    case STALE_CACHED_RESPONSE_VALUE:
                                                        return STALE_CACHED_RESPONSE;
                                                    default:
                                                        switch (i2) {
                                                            case 307:
                                                                return AD_EXPIRED_ON_PLAY;
                                                            case 308:
                                                                return AD_WIN_NOTIFICATION_ERROR;
                                                            case ASSET_FAILED_TO_DELETE_VALUE:
                                                                return ASSET_FAILED_TO_DELETE;
                                                            case AD_HTML_FAILED_TO_LOAD_VALUE:
                                                                return AD_HTML_FAILED_TO_LOAD;
                                                            case 311:
                                                                return MRAID_JS_CALL_EMPTY;
                                                            case 312:
                                                                return DEEPLINK_OPEN_FAILED;
                                                            case 313:
                                                                return EVALUATE_JAVASCRIPT_FAILED;
                                                            case 314:
                                                                return LINK_COMMAND_OPEN_FAILED;
                                                            case 315:
                                                                return JSON_PARAMS_ENCODE_ERROR;
                                                            case 316:
                                                                return GENERATE_JSON_DATA_ERROR;
                                                            case AD_CLOSED_TEMPLATE_ERROR_VALUE:
                                                                return AD_CLOSED_TEMPLATE_ERROR;
                                                            case AD_CLOSED_MISSING_HEARTBEAT_VALUE:
                                                                return AD_CLOSED_MISSING_HEARTBEAT;
                                                            case SILENT_MODE_MONITOR_ERROR_VALUE:
                                                                return SILENT_MODE_MONITOR_ERROR;
                                                            case WEBVIEW_ERROR_VALUE:
                                                                return WEBVIEW_ERROR;
                                                            default:
                                                                return null;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            }
            return UNKNOWN_ERROR;
        }

        public static Internal.EnumLiteMap<Reason> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ReasonVerifier.INSTANCE;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Reason valueOf(int i2) {
            return forNumber(i2);
        }
    }

    static {
        Sdk$SDKError sdk$SDKError = new Sdk$SDKError();
        DEFAULT_INSTANCE = sdk$SDKError;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKError.class, sdk$SDKError);
    }

    private Sdk$SDKError() {
    }

    /* access modifiers changed from: private */
    public void clearAdSource() {
        this.adSource_ = getDefaultInstance().getAdSource();
    }

    /* access modifiers changed from: private */
    public void clearAt() {
        this.at_ = 0;
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
    public void clearConnectionTypeDetailAndroid() {
        this.connectionTypeDetailAndroid_ = getDefaultInstance().getConnectionTypeDetailAndroid();
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
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
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
    public void clearReason() {
        this.reason_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    public static Sdk$SDKError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$SDKError parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKError parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$SDKError> parser() {
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
    public void setAt(long j2) {
        this.at_ = j2;
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
    public void setConnectionTypeDetailAndroid(String str) {
        str.getClass();
        this.connectionTypeDetailAndroid_ = str;
    }

    /* access modifiers changed from: private */
    public void setConnectionTypeDetailAndroidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.connectionTypeDetailAndroid_ = byteString.toStringUtf8();
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
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
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
    public void setReason(Reason reason) {
        this.reason_ = reason.getNumber();
    }

    /* access modifiers changed from: private */
    public void setReasonValue(int i2) {
        this.reason_ = i2;
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

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Sdk$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKError();
            case 2:
                return new Builder((Sdk$1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0012\u0000\u0000\u0001É\u0012\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002\u000fȈ\u0010ȈeȈÉ\u0007", new Object[]{"at_", "reason_", "message_", "eventId_", "make_", "model_", "os_", "osVersion_", "connectionType_", "connectionTypeDetail_", "placementReferenceId_", "creativeId_", "sessionId_", "isHbPlacement_", "placementType_", "adSource_", "connectionTypeDetailAndroid_", "isLowDataModeEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$SDKError> parser = PARSER;
                if (parser == null) {
                    synchronized (Sdk$SDKError.class) {
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

    public long getAt() {
        return this.at_;
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

    public String getConnectionTypeDetailAndroid() {
        return this.connectionTypeDetailAndroid_;
    }

    public ByteString getConnectionTypeDetailAndroidBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetailAndroid_);
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

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
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

    public Reason getReason() {
        Reason forNumber = Reason.forNumber(this.reason_);
        if (forNumber == null) {
            return Reason.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public String getSessionId() {
        return this.sessionId_;
    }

    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public static Builder newBuilder(Sdk$SDKError sdk$SDKError) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(sdk$SDKError);
    }

    public static Sdk$SDKError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKError parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$SDKError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}

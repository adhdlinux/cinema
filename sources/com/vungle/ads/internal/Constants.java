package com.vungle.ads.internal;

public final class Constants {
    public static final String AD_CLOSE = "ad.close";
    public static final String AD_DURATION_KEY = "{{{dur}}}";
    public static final String AD_INDEX_FILE_NAME = "index.html";
    public static final String AD_LOAD_DURATION = "ad.loadDuration";
    public static final String AD_LOAD_DURATION_KEY = "{{{time_dl}}}";
    public static final String AD_MRAID_JS_FILE_NAME = "mraid.js";
    public static final String CHECKPOINT_0 = "checkpoint.0";
    public static final String CLICK_URL = "clickUrl";
    public static final String DEEPLINK_CLICK = "deeplink.click";
    public static final String DEEPLINK_SUCCESS_KEY = "{{{is_success}}}";
    public static final String DEFAULT_ADS_ENDPOINT = "https://adx.ads.vungle.com/api/ads";
    public static final String DEFAULT_ERROR_LOGS_ENDPOINT = "https://logs.ads.vungle.com/sdk/error_logs";
    public static final String DEFAULT_METRICS_ENDPOINT = "https://logs.ads.vungle.com/sdk/metrics";
    public static final String DEVICE_VOLUME_KEY = "{{{vol}}}";
    public static final Constants INSTANCE = new Constants();
    public static final String KEY_MAIN_VIDEO = "MAIN_VIDEO";
    public static final String MRAID_JS_FILE_NAME = "mraid.min.js";
    public static final String NETWORK_OPERATOR_KEY = "{{{carrier}}}";
    public static final String PLACEMENT_TYPE_APP_OPEN = "appopen";
    public static final String PLACEMENT_TYPE_BANNER = "banner";
    public static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";
    public static final String PLACEMENT_TYPE_IN_LINE = "in_line";
    public static final String PLACEMENT_TYPE_MREC = "mrec";
    public static final String PLACEMENT_TYPE_NATIVE = "native";
    public static final String PLACEMENT_TYPE_REWARDED = "rewarded";
    public static final String REMOTE_PLAY_KEY = "{{{remote_play}}}";
    public static final String SESSION_ID = "{{{session_id}}}";
    public static final String TEMPLATE_TYPE_BANNER = "banner";
    public static final String TEMPLATE_TYPE_FULLSCREEN = "fullscreen";
    public static final String TEMPLATE_TYPE_IN_LINE = "in_line";
    public static final String TEMPLATE_TYPE_MREC = "mrec";
    public static final String TEMPLATE_TYPE_NATIVE = "native";
    public static final int TIMEOUT = 60;
    public static final String VIDEO_LENGTH = "video.length";
    public static final String VIDEO_LENGTH_KEY = "{{{vlen}}}";

    private Constants() {
    }
}

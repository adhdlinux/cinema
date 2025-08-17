package com.applovin.impl.sdk.c;

import android.net.Uri;
import com.applovin.impl.a.m;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.google.android.gms.common.ConnectionResult;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class b<T> implements Comparable {
    public static final b<Boolean> W;
    public static final b<String> X = a("device_id", "");
    public static final b<Boolean> Y;
    public static final b<String> Z = a("device_token", "");

    /* renamed from: a  reason: collision with root package name */
    private static final List<?> f15205a;
    public static final b<Long> aA;
    public static final b<Long> aB;
    public static final b<Long> aC;
    public static final b<Long> aD;
    public static final b<Long> aE;
    public static final b<Long> aF;
    public static final b<String> aG = a("text_alert_consent_title", "Make this App Better and Stay Free!");
    public static final b<String> aH = a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");
    public static final b<String> aI = a("text_alert_consent_yes_option", "I Agree");
    public static final b<String> aJ = a("text_alert_consent_no_option", "Cancel");
    public static final b<Long> aK;
    public static final b<Integer> aL = a("ttc_max_click_distance_dp", 10);
    public static final b<Integer> aM = a("ttc_acrsv2a", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN.ordinal()));
    public static final b<Integer> aN = a("ttc_edge_buffer_dp", 0);
    public static final b<String> aO = a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");
    public static final b<String> aP = a("fetch_settings_endpoint", "https://ms.applovin.com/");
    public static final b<String> aQ = a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");
    public static final b<String> aR = a("adserver_endpoint", "https://a.applovin.com/");
    public static final b<String> aS = a("adserver_backup_endpoint", "https://a.applvn.com/");
    public static final b<String> aT = a("api_endpoint", "https://d.applovin.com/");
    public static final b<String> aU = a("api_backup_endpoint", "https://d.applvn.com/");
    public static final b<String> aV = a("event_tracking_endpoint_v2", "https://rt.applovin.com/");
    public static final b<String> aW = a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");
    public static final b<String> aX = a("fetch_variables_endpoint", "https://ms.applovin.com/");
    public static final b<String> aY = a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");
    public static final b<String> aZ = a("anr_postback_endpoint", "https://ms.applovin.com/1.0/sdk/error");
    public static final b<Long> aa = a("publisher_id", 0L);
    public static final b<Boolean> ab;
    public static final b<String> ac = a("sc", "");
    public static final b<String> ad = a("sc2", "");
    public static final b<String> ae = a("sc3", "");
    public static final b<String> af = a("server_installed_at", "");
    public static final b<Boolean> ag;
    public static final b<Boolean> ah;
    public static final b<Boolean> ai;
    public static final b<Boolean> aj;
    public static final b<Long> ak = a("sicd_ms", 0L);
    public static final b<Integer> al = a("logcat_max_line_size", 1000);
    public static final b<Integer> am = a("stps", 16);
    public static final b<Boolean> an;
    public static final b<Boolean> ao;
    public static final b<Integer> ap = a("network_thread_count", 4);
    public static final b<Boolean> aq;
    public static final b<String> ar = a("omsdk_partner_name", "applovin");
    public static final b<Boolean> as;
    public static final b<String> at = a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");
    public static final b<Boolean> au;
    public static final b<Long> av = a("consent_dialog_show_from_alert_delay_ms", 450L);
    public static final b<Boolean> aw;
    public static final b<Boolean> ax;
    public static final b<Boolean> ay;
    public static final b<Boolean> az;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, b<?>> f15206b = new HashMap(512);
    public static final b<String> bA = a("text_incent_nonvideo_warning_title", "Attention!");
    public static final b<String> bB = a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");
    public static final b<String> bC = a("text_incent_nonvideo_warning_close_option", "Close");
    public static final b<String> bD = a("text_incent_nonvideo_warning_continue_option", "Keep Playing");
    public static final b<Boolean> bE;
    public static final b<Integer> bF = a("close_button_touch_area", 0);
    public static final b<Integer> bG = a("close_button_outside_touch_area", 0);
    public static final b<Boolean> bH;
    public static final b<Long> bI;
    public static final b<Integer> bJ = a("viewability_adview_banner_min_width", Integer.valueOf(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE));
    public static final b<Integer> bK = a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));
    public static final b<Integer> bL;
    public static final b<Integer> bM;
    public static final b<Integer> bN = a("viewability_adview_leader_min_width", 728);
    public static final b<Integer> bO = a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));
    public static final b<Integer> bP = a("viewability_adview_native_min_width", 0);
    public static final b<Integer> bQ = a("viewability_adview_native_min_height", 0);
    public static final b<Float> bR = a("viewability_adview_min_alpha", Float.valueOf(10.0f));
    public static final b<Long> bS;
    public static final b<Long> bT = a("viewability_timer_interval_ms", 100L);
    public static final b<Integer> bU = a("expandable_close_button_size", 27);
    public static final b<Integer> bV = a("expandable_h_close_button_margin", 10);
    public static final b<Integer> bW = a("expandable_t_close_button_margin", 10);
    public static final b<Boolean> bX;
    public static final b<Integer> bY = a("expandable_close_button_touch_area", 0);
    public static final b<Boolean> bZ;
    public static final b<String> ba = a("token_type_prefixes_r", "4!");
    public static final b<String> bb = a("token_type_prefixes_arj", "json_v3!");
    public static final b<String> bc = a("top_level_events", "landing,paused,resumed,ref,rdf,checkout,iap");
    public static final b<String> bd;
    public static final b<Boolean> be;
    public static final b<Integer> bf = a("super_property_string_max_length", 1024);
    public static final b<Integer> bg = a("super_property_url_max_length", 1024);
    public static final b<Long> bh;
    public static final b<Boolean> bi;
    public static final b<Boolean> bj;
    public static final b<Long> bk = a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));
    public static final b<Integer> bl = a("cache_max_size_mb", -1);
    public static final b<String> bm = a("precache_delimiters", ")]',");
    public static final b<Boolean> bn;
    public static final b<Boolean> bo;
    public static final b<String> bp = a("resource_cache_prefix", "https://vid.applovin.com/,https://stage-vid.applovin.com/,https://pdn.applovin.com/,https://stage-pdn.applovin.com/,https://img.applovin.com/,https://stage-img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://stage-assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://stage-vid.applovin.com/,http://pdn.applovin.com/,http://stage-pdn.applovin.com/,http://img.applovin.com/,http://stage-img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://stage-assets.applovin.com/,http://cdnjs.cloudflare.com/,http://u.appl.vn/,https://u.appl.vn/,https://res.applovin.com/,https://res1.applovin.com/,https://res2.applovin.com/,https://res3.applovin.com/,http://res.applovin.com/,http://res1.applovin.com/,http://res2.applovin.com/,http://res3.applovin.com/");
    public static final b<String> bq = a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");
    public static final b<Boolean> br;
    public static final b<Integer> bs = a("vr_retry_count_v1", 1);
    public static final b<Integer> bt = a("cr_retry_count_v1", 1);
    public static final b<Boolean> bu;
    public static final b<String> bv = a("text_incent_warning_title", "Attention!");
    public static final b<String> bw = a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");
    public static final b<String> bx = a("text_incent_warning_close_option", "Close");
    public static final b<String> by = a("text_incent_warning_continue_option", "Keep Watching");
    public static final b<Boolean> bz;
    public static final b<Integer> cA = a("progress_bar_vertical_padding", -8);
    public static final b<Integer> cB = a("vs_buffer_indicator_size", 50);
    public static final b<Long> cC = a("set_poststitial_muted_initial_delay_ms", 500L);
    public static final b<Integer> cD = a("minepsv", -1);
    public static final b<Integer> cE = a("maxepsv", -1);
    public static final b<Boolean> cF;
    public static final b<Boolean> cG;
    public static final b<Integer> cH;
    public static final b<Integer> cI = a("submit_postback_retries", 4);
    public static final b<Integer> cJ = a("max_postback_attempts", 3);
    public static final b<Boolean> cK;
    public static final b<Integer> cL = a("max_persisted_postbacks", 100);
    public static final b<Boolean> cM;
    public static final b<Integer> cN;
    public static final b<Integer> cO;
    public static final b<Integer> cP;
    public static final b<Boolean> cQ;
    public static final b<Integer> cR;
    public static final b<Integer> cS = a("fetch_ad_retry_count_v1", 1);
    public static final b<Boolean> cT;
    public static final b<Boolean> cU;
    public static final b<Integer> cV = a("submit_data_retry_count_v1", 1);
    public static final b<Integer> cW = a("response_buffer_size", 16000);
    public static final b<Integer> cX;
    public static final b<Integer> cY = a("fetch_basic_settings_retry_count", 3);
    public static final b<Boolean> cZ;
    public static final b<String> ca = a("js_tag_schemes", "applovin,mopub");
    public static final b<String> cb = a("js_tag_load_success_hosts", "load,load_succeeded");
    public static final b<String> cc = a("js_tag_load_failure_hosts", "failLoad,load_failed");
    public static final b<Integer> cd = a("auxiliary_operations_threads", 3);
    public static final b<Integer> ce = a("caching_operations_threads", 8);
    public static final b<Long> cf;
    public static final b<Long> cg;
    public static final b<Boolean> ch;
    public static final b<Integer> ci = a("close_button_right_margin_video", 4);
    public static final b<Integer> cj = a("close_button_size_video", 30);
    public static final b<Integer> ck = a("close_button_top_margin_video", 8);
    public static final b<Long> cl = a("inter_display_delay", 200L);
    public static final b<Long> cm = a("maximum_close_button_delay_seconds", 999L);
    public static final b<Boolean> cn;
    public static final b<Boolean> co;
    public static final b<Boolean> cp;
    public static final b<Boolean> cq;
    public static final b<Boolean> cr;
    public static final b<Boolean> cs;
    public static final b<Boolean> ct;
    public static final b<Boolean> cu;
    public static final b<Integer> cv = a("mute_button_size", 32);
    public static final b<Integer> cw = a("mute_button_margin", 10);
    public static final b<Integer> cx = a("mute_button_gravity", 85);
    public static final b<Long> cy = a("progress_bar_step", 25L);
    public static final b<Integer> cz = a("progress_bar_scale", 10000);
    public static final b<Boolean> dA;
    public static final b<Boolean> dB;
    public static final b<Boolean> dC;
    public static final b<Boolean> dD;
    public static final b<Boolean> dE;
    public static final b<Boolean> dF;
    public static final b<Boolean> dG;
    public static final b<Boolean> dH;
    public static final b<Boolean> dI;
    public static final b<Boolean> dJ;
    public static final b<Boolean> dK;
    public static final b<Float> dL = a("volume_normalization_factor", Float.valueOf(6.6666665f));
    public static final b<Boolean> dM;
    public static final b<Boolean> dN;
    public static final b<Boolean> dO;
    public static final b<Boolean> dP;
    public static final b<Float> dQ = a("movement_degradation", Float.valueOf(0.75f));
    public static final b<Integer> dR = a("device_sensor_period_ms", 250);
    public static final b<Boolean> dS;
    public static final b<Boolean> dT;
    public static final b<Long> dU = a("anr_debug_thread_refresh_time_ms", -1L);
    public static final b<Integer> dV = a("fetch_basic_settings_delay_ms", Integer.valueOf(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED));
    public static final b<Boolean> dW;
    public static final b<Long> dX = a("lccdm", 10L);
    public static final b<Integer> dY = a("lmfd", 3);
    public static final b<Boolean> dZ;
    public static final b<Boolean> da;
    public static final b<Integer> db;
    public static final b<Integer> dc;
    public static final b<Boolean> dd;

    /* renamed from: de  reason: collision with root package name */
    public static final b<Boolean> f15207de;
    public static final b<Boolean> df;
    public static final b<Boolean> dg;
    public static final b<Long> dh;
    public static final b<Integer> di = a("communicator_request_retry_count", 3);
    public static final b<Long> dj;
    public static final b<Integer> dk = a("ad_session_minutes", 60);
    public static final b<Boolean> dl;
    public static final b<Long> dm = a("session_tracking_resumed_cooldown_minutes", 90L);
    public static final b<Long> dn = a("session_tracking_paused_cooldown_minutes", 90L);

    /* renamed from: do  reason: not valid java name */
    public static final b<Boolean> f0do;
    public static final b<Boolean> dp;
    public static final b<Boolean> dq;
    public static final b<Boolean> dr;
    public static final b<Boolean> ds;
    public static final b<Boolean> dt;
    public static final b<Boolean> du;
    public static final b<Boolean> dv;
    public static final b<Boolean> dw;
    public static final b<Boolean> dx;
    public static final b<Boolean> dy;
    public static final b<String> dz;
    public static final b<Boolean> eA;
    public static final b<Boolean> eB;
    public static final b<Boolean> eC;
    public static final b<Boolean> eD;
    public static final b<Boolean> eE;
    public static final b<Boolean> eF;
    public static final b<Boolean> eG;
    public static final b<Boolean> eH;
    public static final b<Boolean> eI;
    public static final b<Boolean> eJ;
    public static final b<Boolean> eK;
    public static final b<Boolean> eL;
    public static final b<Boolean> eM;
    public static final b<Boolean> eN;
    public static final b<Boolean> eO;
    public static final b<Boolean> eP;
    public static final b<Long> eQ = a("anr_trigger_millis", 4000L);
    public static final b<Long> eR = a("anr_touch_millis", 3000L);
    public static final b<Long> eS = a("anr_check_millis", 3000L);
    public static final b<Boolean> eT;
    public static final b<String> eU = a("config_consent_dialog_state", "unknown");
    public static final b<String> eV;
    public static final b<String> eW = a("c_sticky_topics", "user_engagement_sdk_init,adjust_init,safedk_init,discovery_init,max_ad_events,send_http_request,adapter_initialization_status,privacy_setting_updated,network_sdk_version_updated");
    public static final b<Boolean> eX;
    public static final b<Boolean> ea;
    public static final b<Integer> eb;
    public static final b<Integer> ec = a("submit_ad_stats_retry_count", 1);
    public static final b<Integer> ed = a("submit_ad_stats_max_count", 500);
    public static final b<Boolean> ee;
    public static final b<String> ef = a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");
    public static final b<String> eg = a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");
    public static final b<Integer> eh = a("vast_max_response_length", 640000);
    public static final b<Integer> ei = a("vast_max_wrapper_depth", 5);
    public static final b<String> ej = a("vast_unsupported_video_extensions", "ogv,flv");
    public static final b<String> ek = a("vast_unsupported_video_types", "video/ogg,video/x-flv");
    public static final b<Boolean> el;
    public static final b<Integer> em = a("vast_video_selection_policy", Integer.valueOf(m.a.MEDIUM.ordinal()));
    public static final b<Integer> en = a("vast_wrapper_resolution_retry_count_v1", 1);
    public static final b<Integer> eo;
    public static final b<Boolean> ep;
    public static final b<Boolean> eq;
    public static final b<Long> er = a("server_timestamp_ms", (Long) null);
    public static final b<Long> es = a("device_timestamp_ms", (Long) null);
    public static final b<Integer> et = a("gzip_min_length", 0);
    public static final b<Boolean> eu;
    public static final b<Boolean> ev;
    public static final b<Boolean> ew;
    public static final b<Boolean> ex;
    public static final b<Boolean> ey;
    public static final b<Boolean> ez;

    /* renamed from: c  reason: collision with root package name */
    private final String f15208c;

    /* renamed from: d  reason: collision with root package name */
    private final T f15209d;

    static {
        Class<Float> cls = Float.class;
        Class<Integer> cls2 = Integer.class;
        Class<Long> cls3 = Long.class;
        Class<String> cls4 = String.class;
        f15205a = Arrays.asList(new Class[]{Boolean.class, cls, cls2, cls3, cls4});
        Boolean bool = Boolean.FALSE;
        W = a("is_disabled", bool);
        Boolean bool2 = Boolean.TRUE;
        Y = a("rss", bool2);
        ab = a("is_verbose_logging", bool);
        ag = a("track_network_response_codes", bool);
        ah = a("submit_network_response_codes", bool);
        ai = a("clear_network_response_codes_on_request", bool2);
        aj = a("clear_completion_callback_on_failure", bool);
        an = a("ustp", bool);
        ao = a("exception_handler_enabled", bool2);
        aq = a("init_omsdk", bool2);
        as = a("publisher_can_show_consent_dialog", bool2);
        au = a("consent_dialog_immersive_mode_on", bool);
        aw = a("alert_consent_for_dialog_rejected", bool);
        ax = a("alert_consent_for_dialog_closed", bool);
        ay = a("alert_consent_for_dialog_closed_with_back_button", bool);
        az = a("alert_consent_after_init", bool);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        aA = a("alert_consent_after_init_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        aB = a("alert_consent_after_dialog_rejection_interval_ms", Long.valueOf(timeUnit.toMillis(30)));
        aC = a("alert_consent_after_dialog_close_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        aD = a("alert_consent_after_dialog_close_with_back_button_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        aE = a("alert_consent_after_cancel_interval_ms", Long.valueOf(timeUnit.toMillis(10)));
        aF = a("alert_consent_reschedule_interval_ms", Long.valueOf(timeUnit.toMillis(5)));
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        aK = a("ttc_max_click_duration_ms", Long.valueOf(timeUnit2.toMillis(1)));
        bd = a("valid_super_property_types", cls4.getName() + "," + cls2.getName() + "," + cls3.getName() + "," + Double.class.getName() + "," + cls.getName() + "," + Date.class.getName() + "," + Uri.class.getName() + "," + List.class.getName() + "," + Map.class.getName());
        be = a("persist_super_properties", bool2);
        bh = a("cached_advertising_info_ttl_ms", Long.valueOf(timeUnit.toMillis(10)));
        bi = a("use_per_format_cache_queues", bool2);
        bj = a("cache_cleanup_enabled", bool);
        bn = a("ad_resource_caching_enabled", bool2);
        bo = a("fail_ad_load_on_failed_video_cache", bool2);
        br = a("use_old_file_manager", bool);
        bu = a("incent_warning_enabled", bool);
        bz = a("incent_nonvideo_warning_enabled", bool);
        bE = a("check_webview_has_gesture", bool);
        bH = a("creative_debugger_enabled", bool);
        bI = a("viewability_adview_imp_delay_ms", Long.valueOf(timeUnit2.toMillis(1)));
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        bL = a("viewability_adview_mrec_min_width", Integer.valueOf(maxAdFormat.getSize().getWidth()));
        bM = a("viewability_adview_mrec_min_height", Integer.valueOf(maxAdFormat.getSize().getHeight()));
        bS = a("viewability_timer_min_visible_ms", Long.valueOf(timeUnit2.toMillis(1)));
        bX = a("expandable_lhs_close_button", bool);
        bZ = a("iaad", bool);
        cf = a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(timeUnit2.toMillis(10)));
        cg = a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(timeUnit.toMillis(2)));
        ch = a("lhs_close_button_video", bool);
        cn = a("respect_close_button", bool2);
        co = a("lhs_skip_button", bool2);
        cp = a("track_app_killed", bool);
        cq = a("mute_controls_enabled", bool);
        cr = a("allow_user_muting", bool2);
        cs = a("mute_videos", bool);
        ct = a("show_mute_by_default", bool);
        cu = a("mute_with_user_settings", bool2);
        cF = a("fasuic", bool2);
        cG = a("ssfwif", bool);
        cH = a("submit_postback_timeout", Integer.valueOf((int) timeUnit2.toMillis(10)));
        cK = a("fppopq", bool);
        cM = a("retry_on_all_errors", bool);
        cN = a("get_retry_delay_v1", Integer.valueOf((int) timeUnit2.toMillis(10)));
        cO = a("http_connection_timeout", Integer.valueOf((int) timeUnit2.toMillis(30)));
        cP = a("http_socket_timeout", Integer.valueOf((int) timeUnit2.toMillis(20)));
        cQ = a("force_ssl", bool);
        cR = a("fetch_ad_connection_timeout", Integer.valueOf((int) timeUnit2.toMillis(30)));
        cT = a("faer", bool);
        cU = a("faroae", bool);
        cX = a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) timeUnit2.toMillis(10)));
        cZ = a("fetch_basic_settings_on_reconnect", bool);
        da = a("skip_fetch_basic_settings_if_not_connected", bool);
        db = a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) timeUnit2.toMillis(2)));
        dc = a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) timeUnit2.toMillis(5)));
        dd = a("idflrwbe", bool);
        f15207de = a("falawpr", bool);
        df = a("sort_query_parameters", bool);
        dg = a("encode_amp_query_value", bool);
        dh = a("communicator_request_timeout_ms", Long.valueOf(timeUnit2.toMillis(10)));
        dj = a("communicator_request_retry_delay_ms", Long.valueOf(timeUnit2.toMillis(2)));
        dl = a("session_tracking_cooldown_on_event_fire", bool2);
        f0do = a("qq", bool);
        dp = a("qq1", bool2);
        dq = a("qq2", bool2);
        dr = a("qq3", bool2);
        ds = a("qq4", bool2);
        dt = a("qq5", bool2);
        du = a("qq6", bool2);
        dv = a("qq7", bool2);
        dw = a("qq8", bool2);
        dx = a("qq9", bool);
        dy = a("pui", bool2);
        Object obj = "";
        dz = a("plugin_version", obj);
        dA = a("hgn", bool);
        dB = a("cso", bool);
        dC = a("cfs", bool);
        dD = a("cmi", bool);
        dE = a("crat", bool);
        dF = a("cvs", bool);
        dG = a("caf", bool);
        dH = a("cf", bool);
        dI = a("cmtl", bool2);
        dJ = a("cnr", bool);
        dK = a("adr", bool);
        dM = a("system_user_agent_collection_enabled", bool);
        dN = a("user_agent_collection_enabled", bool);
        dO = a("collect_device_angle", bool);
        dP = a("collect_device_movement", bool);
        dS = a("dte", bool2);
        dT = a("idcw", bool);
        dW = a("cclia", bool2);
        dZ = a("is_track_ad_info", bool2);
        ea = a("submit_ad_stats_enabled", bool);
        eb = a("submit_ad_stats_connection_timeout", Integer.valueOf((int) timeUnit2.toMillis(30)));
        ee = a("asdm", bool);
        el = a("vast_validate_with_extension_if_no_video_type", bool2);
        eo = a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) timeUnit2.toMillis(30)));
        ep = a("ree", bool2);
        eq = a("btee", bool2);
        eu = a("gzip_encoding_default", bool);
        ev = a("fetch_settings_gzip", bool);
        ew = a("device_init_gzip", bool);
        ex = a("fetch_ad_gzip", bool);
        ey = a("event_tracking_gzip", bool);
        ez = a("submit_ad_stats_gzip", bool);
        eA = a("reward_postback_gzip", bool);
        eB = a("force_rerender", bool);
        eC = a("daostr", bool);
        eD = a("tctlaa", bool);
        eE = a("rwvdv", bool);
        eF = a("handle_render_process_gone", bool2);
        eG = a("comcr", bool2);
        eH = a("teorpc", bool);
        eI = a("rmpibt", bool);
        eJ = a("spbcioa", bool);
        eK = a("set_webview_render_process_client", bool);
        eL = a("disable_webview_hardware_acceleration", bool);
        eM = a("dsaovcf", bool);
        eN = a("daoar", bool);
        eO = a("use_uri_encode", bool);
        eP = a("anr_detection_enabled", bool);
        eT = a("frpcfn", bool);
        eV = a("country_code", obj);
        eX = a("communicator_enabled", bool2);
    }

    public b(String str, T t2) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t2 != null) {
            this.f15208c = str;
            this.f15209d = t2;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    protected static <T> b<T> a(String str, T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (f15205a.contains(t2.getClass())) {
            b<T> bVar = new b<>(str, t2);
            Map<String, b<?>> map = f15206b;
            if (!map.containsKey(str)) {
                map.put(str, bVar);
                return bVar;
            }
            throw new IllegalArgumentException("Setting has already been used: " + str);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + t2.getClass());
        }
    }

    public static Collection<b<?>> c() {
        return Collections.synchronizedCollection(f15206b.values());
    }

    public T a(Object obj) {
        return this.f15209d.getClass().cast(obj);
    }

    public String a() {
        return this.f15208c;
    }

    public T b() {
        return this.f15209d;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof b)) {
            return 0;
        }
        return this.f15208c.compareTo(((b) obj).a());
    }
}

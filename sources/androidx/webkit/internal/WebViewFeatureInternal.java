package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.StartupApiFeature;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.support_lib_boundary.util.Features;

public class WebViewFeatureInternal {
    public static final ApiFeature.M A = new ApiFeature.M(Features.WEB_MESSAGE_PORT_POST_MESSAGE, Features.WEB_MESSAGE_PORT_POST_MESSAGE);
    public static final ApiFeature.M B = new ApiFeature.M(Features.WEB_MESSAGE_PORT_CLOSE, Features.WEB_MESSAGE_PORT_CLOSE);
    public static final ApiFeature.NoFramework C = new ApiFeature.NoFramework(Features.WEB_MESSAGE_GET_MESSAGE_PAYLOAD, Features.WEB_MESSAGE_GET_MESSAGE_PAYLOAD);
    public static final ApiFeature.M D = new ApiFeature.M(Features.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK, Features.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK);
    public static final ApiFeature.M E = new ApiFeature.M(Features.CREATE_WEB_MESSAGE_CHANNEL, Features.CREATE_WEB_MESSAGE_CHANNEL);
    public static final ApiFeature.M F = new ApiFeature.M(Features.POST_WEB_MESSAGE, Features.POST_WEB_MESSAGE);
    public static final ApiFeature.M G = new ApiFeature.M(Features.WEB_MESSAGE_CALLBACK_ON_MESSAGE, Features.WEB_MESSAGE_CALLBACK_ON_MESSAGE);
    public static final ApiFeature.O H = new ApiFeature.O(Features.GET_WEB_VIEW_CLIENT, Features.GET_WEB_VIEW_CLIENT);
    public static final ApiFeature.O I = new ApiFeature.O(Features.GET_WEB_CHROME_CLIENT, Features.GET_WEB_CHROME_CLIENT);
    public static final ApiFeature.Q J = new ApiFeature.Q(Features.GET_WEB_VIEW_RENDERER, Features.GET_WEB_VIEW_RENDERER);
    public static final ApiFeature.Q K = new ApiFeature.Q(Features.WEB_VIEW_RENDERER_TERMINATE, Features.WEB_VIEW_RENDERER_TERMINATE);
    public static final ApiFeature.P L = new ApiFeature.P(Features.TRACING_CONTROLLER_BASIC_USAGE, Features.TRACING_CONTROLLER_BASIC_USAGE);
    public static final StartupApiFeature.P M = new StartupApiFeature.P("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
    public static final ApiFeature.Q N = new ApiFeature.Q(Features.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE, Features.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE);
    public static final ApiFeature.T O = new ApiFeature.T(Features.ALGORITHMIC_DARKENING, Features.ALGORITHMIC_DARKENING) {

        /* renamed from: d  reason: collision with root package name */
        private final Pattern f12105d = Pattern.compile("\\A\\d+");

        public boolean c() {
            boolean c2 = super.c();
            if (!c2 || Build.VERSION.SDK_INT >= 29) {
                return c2;
            }
            PackageInfo c3 = WebViewCompat.c();
            if (c3 == null) {
                return false;
            }
            Matcher matcher = this.f12105d.matcher(c3.versionName);
            if (!matcher.find() || Integer.parseInt(c3.versionName.substring(matcher.start(), matcher.end())) < 105) {
                return false;
            }
            return true;
        }
    };
    public static final ApiFeature.NoFramework P = new ApiFeature.NoFramework("PROXY_OVERRIDE", Features.PROXY_OVERRIDE);
    public static final ApiFeature.NoFramework Q = new ApiFeature.NoFramework(Features.SUPPRESS_ERROR_PAGE, Features.SUPPRESS_ERROR_PAGE);
    public static final ApiFeature.NoFramework R = new ApiFeature.NoFramework("MULTI_PROCESS", Features.MULTI_PROCESS_QUERY);
    public static final ApiFeature.Q S = new ApiFeature.Q(Features.FORCE_DARK, Features.FORCE_DARK);
    public static final ApiFeature.NoFramework T = new ApiFeature.NoFramework("FORCE_DARK_STRATEGY", Features.FORCE_DARK_BEHAVIOR);
    public static final ApiFeature.NoFramework U = new ApiFeature.NoFramework(Features.WEB_MESSAGE_LISTENER, Features.WEB_MESSAGE_LISTENER);
    public static final ApiFeature.NoFramework V = new ApiFeature.NoFramework("DOCUMENT_START_SCRIPT", Features.DOCUMENT_START_SCRIPT);
    public static final ApiFeature.NoFramework W = new ApiFeature.NoFramework(Features.PROXY_OVERRIDE_REVERSE_BYPASS, Features.PROXY_OVERRIDE_REVERSE_BYPASS);
    public static final ApiFeature.NoFramework X = new ApiFeature.NoFramework(Features.GET_VARIATIONS_HEADER, Features.GET_VARIATIONS_HEADER);
    public static final ApiFeature.NoFramework Y = new ApiFeature.NoFramework(Features.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY, Features.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY);
    public static final ApiFeature.NoFramework Z = new ApiFeature.NoFramework(Features.GET_COOKIE_INFO, Features.GET_COOKIE_INFO);

    /* renamed from: a  reason: collision with root package name */
    public static final ApiFeature.M f12078a = new ApiFeature.M(Features.VISUAL_STATE_CALLBACK, Features.VISUAL_STATE_CALLBACK);

    /* renamed from: a0  reason: collision with root package name */
    public static final ApiFeature.NoFramework f12079a0 = new ApiFeature.NoFramework(Features.REQUESTED_WITH_HEADER_ALLOW_LIST, Features.REQUESTED_WITH_HEADER_ALLOW_LIST);

    /* renamed from: b  reason: collision with root package name */
    public static final ApiFeature.M f12080b = new ApiFeature.M(Features.OFF_SCREEN_PRERASTER, Features.OFF_SCREEN_PRERASTER);

    /* renamed from: c  reason: collision with root package name */
    public static final ApiFeature.O f12081c = new ApiFeature.O(Features.SAFE_BROWSING_ENABLE, Features.SAFE_BROWSING_ENABLE);

    /* renamed from: d  reason: collision with root package name */
    public static final ApiFeature.N f12082d = new ApiFeature.N(Features.DISABLED_ACTION_MODE_MENU_ITEMS, Features.DISABLED_ACTION_MODE_MENU_ITEMS);

    /* renamed from: e  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12083e = new ApiFeature.O_MR1(Features.START_SAFE_BROWSING, Features.START_SAFE_BROWSING);
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12084f = new ApiFeature.O_MR1(Features.SAFE_BROWSING_WHITELIST, Features.SAFE_BROWSING_WHITELIST);
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12085g = new ApiFeature.O_MR1(Features.SAFE_BROWSING_WHITELIST, Features.SAFE_BROWSING_ALLOWLIST);

    /* renamed from: h  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12086h = new ApiFeature.O_MR1(Features.SAFE_BROWSING_ALLOWLIST, Features.SAFE_BROWSING_WHITELIST);

    /* renamed from: i  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12087i = new ApiFeature.O_MR1(Features.SAFE_BROWSING_ALLOWLIST, Features.SAFE_BROWSING_ALLOWLIST);

    /* renamed from: j  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12088j = new ApiFeature.O_MR1(Features.SAFE_BROWSING_PRIVACY_POLICY_URL, Features.SAFE_BROWSING_PRIVACY_POLICY_URL);

    /* renamed from: k  reason: collision with root package name */
    public static final ApiFeature.N f12089k = new ApiFeature.N(Features.SERVICE_WORKER_BASIC_USAGE, Features.SERVICE_WORKER_BASIC_USAGE);

    /* renamed from: l  reason: collision with root package name */
    public static final ApiFeature.N f12090l = new ApiFeature.N(Features.SERVICE_WORKER_CACHE_MODE, Features.SERVICE_WORKER_CACHE_MODE);

    /* renamed from: m  reason: collision with root package name */
    public static final ApiFeature.N f12091m = new ApiFeature.N(Features.SERVICE_WORKER_CONTENT_ACCESS, Features.SERVICE_WORKER_CONTENT_ACCESS);

    /* renamed from: n  reason: collision with root package name */
    public static final ApiFeature.N f12092n = new ApiFeature.N(Features.SERVICE_WORKER_FILE_ACCESS, Features.SERVICE_WORKER_FILE_ACCESS);

    /* renamed from: o  reason: collision with root package name */
    public static final ApiFeature.N f12093o = new ApiFeature.N(Features.SERVICE_WORKER_BLOCK_NETWORK_LOADS, Features.SERVICE_WORKER_BLOCK_NETWORK_LOADS);

    /* renamed from: p  reason: collision with root package name */
    public static final ApiFeature.N f12094p = new ApiFeature.N(Features.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST, Features.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST);

    /* renamed from: q  reason: collision with root package name */
    public static final ApiFeature.M f12095q = new ApiFeature.M(Features.RECEIVE_WEB_RESOURCE_ERROR, Features.RECEIVE_WEB_RESOURCE_ERROR);

    /* renamed from: r  reason: collision with root package name */
    public static final ApiFeature.M f12096r = new ApiFeature.M(Features.RECEIVE_HTTP_ERROR, Features.RECEIVE_HTTP_ERROR);

    /* renamed from: s  reason: collision with root package name */
    public static final ApiFeature.N f12097s = new ApiFeature.N(Features.SHOULD_OVERRIDE_WITH_REDIRECTS, Features.SHOULD_OVERRIDE_WITH_REDIRECTS);

    /* renamed from: t  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12098t = new ApiFeature.O_MR1(Features.SAFE_BROWSING_HIT, Features.SAFE_BROWSING_HIT);

    /* renamed from: u  reason: collision with root package name */
    public static final ApiFeature.N f12099u = new ApiFeature.N(Features.WEB_RESOURCE_REQUEST_IS_REDIRECT, Features.WEB_RESOURCE_REQUEST_IS_REDIRECT);

    /* renamed from: v  reason: collision with root package name */
    public static final ApiFeature.M f12100v = new ApiFeature.M(Features.WEB_RESOURCE_ERROR_GET_DESCRIPTION, Features.WEB_RESOURCE_ERROR_GET_DESCRIPTION);

    /* renamed from: w  reason: collision with root package name */
    public static final ApiFeature.M f12101w = new ApiFeature.M(Features.WEB_RESOURCE_ERROR_GET_CODE, Features.WEB_RESOURCE_ERROR_GET_CODE);

    /* renamed from: x  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12102x = new ApiFeature.O_MR1(Features.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY, Features.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY);

    /* renamed from: y  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12103y = new ApiFeature.O_MR1(Features.SAFE_BROWSING_RESPONSE_PROCEED, Features.SAFE_BROWSING_RESPONSE_PROCEED);

    /* renamed from: z  reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12104z = new ApiFeature.O_MR1(Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL, Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL);

    private WebViewFeatureInternal() {
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, ApiFeature.d());
    }

    public static <T extends ConditionallySupportedFeature> boolean c(String str, Collection<T> collection) {
        HashSet<ConditionallySupportedFeature> hashSet = new HashSet<>();
        for (T t2 : collection) {
            if (t2.a().equals(str)) {
                hashSet.add(t2);
            }
        }
        if (!hashSet.isEmpty()) {
            for (ConditionallySupportedFeature isSupported : hashSet) {
                if (isSupported.isSupported()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException("Unknown feature " + str);
    }
}

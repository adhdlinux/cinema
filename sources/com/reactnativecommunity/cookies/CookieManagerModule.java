package com.reactnativecommunity.cookies;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.net.HttpCookie;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CookieManagerModule extends ReactContextBaseJavaModule {
    private static final String CLEAR_BY_NAME_NOT_SUPPORTED = "Cannot remove a single cookie by name on Android";
    private static final String GET_ALL_NOT_SUPPORTED = "Get all cookies not supported for Android (iOS only)";
    private static final boolean HTTP_ONLY_SUPPORTED;
    private static final String INVALID_COOKIE_VALUES = "Unable to add cookie - invalid values";
    private static final String INVALID_DOMAINS = "Cookie URL host %s and domain %s mismatched. The cookie won't set correctly.";
    private static final String INVALID_URL_MISSING_HTTP = "Invalid URL: It may be missing a protocol (ex. http:// or https://).";
    private static final boolean USES_LEGACY_STORE = false;
    private CookieSyncManager mCookieSyncManager;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z2 = false;
        if (i2 >= 24) {
            z2 = true;
        }
        HTTP_ONLY_SUPPORTED = z2;
    }

    CookieManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCookieSyncManager = CookieSyncManager.createInstance(reactApplicationContext);
    }

    private DateFormat RFC1123dateFormatter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private void addCookies(String str, String str2, final Promise promise) {
        try {
            CookieManager cookieManager = getCookieManager();
            if (USES_LEGACY_STORE) {
                cookieManager.setCookie(str, str2);
                this.mCookieSyncManager.sync();
                promise.resolve(Boolean.TRUE);
                return;
            }
            cookieManager.setCookie(str, str2, new ValueCallback<Boolean>() {
                /* renamed from: a */
                public void onReceiveValue(Boolean bool) {
                    promise.resolve(bool);
                }
            });
            cookieManager.flush();
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    private WritableMap createCookieData(HttpCookie httpCookie) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("name", httpCookie.getName());
        createMap.putString(AppMeasurementSdk.ConditionalUserProperty.VALUE, httpCookie.getValue());
        createMap.putString("domain", httpCookie.getDomain());
        createMap.putString("path", httpCookie.getPath());
        createMap.putBoolean("secure", httpCookie.getSecure());
        if (HTTP_ONLY_SUPPORTED) {
            createMap.putBoolean("httpOnly", httpCookie.isHttpOnly());
        }
        long maxAge = httpCookie.getMaxAge();
        if (maxAge > 0) {
            String formatDate = formatDate(new Date(maxAge));
            if (!isEmpty(formatDate)) {
                createMap.putString("expires", formatDate);
            }
        }
        return createMap;
    }

    private WritableMap createCookieList(String str) throws Exception {
        WritableMap createMap = Arguments.createMap();
        if (!isEmpty(str)) {
            for (String parse : str.split(";")) {
                for (HttpCookie next : HttpCookie.parse(parse)) {
                    if (next != null) {
                        String name = next.getName();
                        String value = next.getValue();
                        if (!isEmpty(name) && !isEmpty(value)) {
                            createMap.putMap(name, createCookieData(next));
                        }
                    }
                }
            }
        }
        return createMap;
    }

    private DateFormat dateFormatter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private String formatDate(Date date) {
        return formatDate(date, false);
    }

    private CookieManager getCookieManager() throws Exception {
        try {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            return instance;
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private HttpCookie makeHTTPCookieObject(String str, ReadableMap readableMap) throws Exception {
        Date parseDate;
        try {
            String host = new URL(str).getHost();
            if (!isEmpty(host)) {
                HttpCookie httpCookie = new HttpCookie(readableMap.getString("name"), readableMap.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                if (!readableMap.hasKey("domain") || isEmpty(readableMap.getString("domain"))) {
                    httpCookie.setDomain(host);
                } else {
                    String string = readableMap.getString("domain");
                    if (string.startsWith(".")) {
                        string = string.substring(1);
                    }
                    if (host.contains(string) || host.equals(string)) {
                        httpCookie.setDomain(string);
                    } else {
                        throw new Exception(String.format(INVALID_DOMAINS, new Object[]{host, string}));
                    }
                }
                if (readableMap.hasKey("path") && !isEmpty(readableMap.getString("path"))) {
                    httpCookie.setPath(readableMap.getString("path"));
                }
                if (readableMap.hasKey("expires") && !isEmpty(readableMap.getString("expires")) && (parseDate = parseDate(readableMap.getString("expires"))) != null) {
                    httpCookie.setMaxAge(parseDate.getTime());
                }
                if (readableMap.hasKey("secure") && readableMap.getBoolean("secure")) {
                    httpCookie.setSecure(true);
                }
                if (HTTP_ONLY_SUPPORTED && readableMap.hasKey("httpOnly") && readableMap.getBoolean("httpOnly")) {
                    httpCookie.setHttpOnly(true);
                }
                return httpCookie;
            }
            throw new Exception(INVALID_URL_MISSING_HTTP);
        } catch (Exception unused) {
            throw new Exception(INVALID_URL_MISSING_HTTP);
        }
    }

    private Date parseDate(String str) {
        return parseDate(str, false);
    }

    private String toRFC6265string(HttpCookie httpCookie) {
        StringBuilder sb = new StringBuilder();
        sb.append(httpCookie.getName());
        sb.append('=');
        sb.append(httpCookie.getValue());
        if (!httpCookie.hasExpired()) {
            long maxAge = httpCookie.getMaxAge();
            if (maxAge > 0) {
                String formatDate = formatDate(new Date(maxAge), true);
                if (!isEmpty(formatDate)) {
                    sb.append("; expires=");
                    sb.append(formatDate);
                }
            }
        }
        if (!isEmpty(httpCookie.getDomain())) {
            sb.append("; domain=");
            sb.append(httpCookie.getDomain());
        }
        if (!isEmpty(httpCookie.getPath())) {
            sb.append("; path=");
            sb.append(httpCookie.getPath());
        }
        if (httpCookie.getSecure()) {
            sb.append("; secure");
        }
        if (HTTP_ONLY_SUPPORTED && httpCookie.isHttpOnly()) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    @ReactMethod
    public void clearAll(Boolean bool, final Promise promise) {
        try {
            CookieManager cookieManager = getCookieManager();
            if (USES_LEGACY_STORE) {
                cookieManager.removeAllCookie();
                cookieManager.removeSessionCookie();
                this.mCookieSyncManager.sync();
                promise.resolve(Boolean.TRUE);
                return;
            }
            cookieManager.removeAllCookies(new ValueCallback<Boolean>() {
                /* renamed from: a */
                public void onReceiveValue(Boolean bool) {
                    promise.resolve(bool);
                }
            });
            cookieManager.flush();
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void clearByName(String str, String str2, Boolean bool, Promise promise) {
        promise.reject((Throwable) new Exception(CLEAR_BY_NAME_NOT_SUPPORTED));
    }

    @ReactMethod
    public void flush(Promise promise) {
        try {
            getCookieManager().flush();
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void get(String str, Boolean bool, Promise promise) {
        if (isEmpty(str)) {
            promise.reject((Throwable) new Exception(INVALID_URL_MISSING_HTTP));
            return;
        }
        try {
            promise.resolve(createCookieList(getCookieManager().getCookie(str)));
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void getAll(Boolean bool, Promise promise) {
        promise.reject((Throwable) new Exception(GET_ALL_NOT_SUPPORTED));
    }

    @ReactMethod
    public void getFromResponse(String str, Promise promise) throws URISyntaxException, IOException {
        promise.resolve(str);
    }

    public String getName() {
        return "RNCookieManagerAndroid";
    }

    @ReactMethod
    public void removeSessionCookies(final Promise promise) {
        try {
            getCookieManager().removeSessionCookies(new ValueCallback<Boolean>() {
                /* renamed from: a */
                public void onReceiveValue(Boolean bool) {
                    promise.resolve(bool);
                }
            });
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void set(String str, ReadableMap readableMap, Boolean bool, Promise promise) {
        try {
            String rFC6265string = toRFC6265string(makeHTTPCookieObject(str, readableMap));
            if (rFC6265string == null) {
                promise.reject((Throwable) new Exception(INVALID_COOKIE_VALUES));
            } else {
                addCookies(str, rFC6265string, promise);
            }
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void setFromResponse(String str, String str2, Promise promise) {
        if (str2 == null) {
            promise.reject((Throwable) new Exception(INVALID_COOKIE_VALUES));
        } else {
            addCookies(str, str2, promise);
        }
    }

    private String formatDate(Date date, boolean z2) {
        DateFormat dateFormat;
        if (z2) {
            try {
                dateFormat = RFC1123dateFormatter();
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message == null) {
                    message = "Unable to format date";
                }
                Log.i("Cookies", message);
                return null;
            }
        } else {
            dateFormat = dateFormatter();
        }
        return dateFormat.format(date);
    }

    private Date parseDate(String str, boolean z2) {
        DateFormat dateFormat;
        if (z2) {
            try {
                dateFormat = RFC1123dateFormatter();
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message == null) {
                    message = "Unable to parse date";
                }
                Log.i("Cookies", message);
                return null;
            }
        } else {
            dateFormat = dateFormatter();
        }
        return dateFormat.parse(str);
    }
}

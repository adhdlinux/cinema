package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler2) {
        Intrinsics.f(cookieHandler2, "cookieHandler");
        this.cookieHandler = cookieHandler2;
    }

    private final List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int delimiterOffset = Util.delimiterOffset(str, ";,", i2, length);
            int delimiterOffset2 = Util.delimiterOffset(str, '=', i2, delimiterOffset);
            String trimSubstring = Util.trimSubstring(str, i2, delimiterOffset2);
            if (!StringsKt__StringsJVMKt.G(trimSubstring, "$", false, 2, (Object) null)) {
                if (delimiterOffset2 < delimiterOffset) {
                    str2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str2 = "";
                }
                if (StringsKt__StringsJVMKt.G(str2, "\"", false, 2, (Object) null) && StringsKt__StringsJVMKt.s(str2, "\"", false, 2, (Object) null)) {
                    str2 = str2.substring(1, str2.length() - 1);
                    Intrinsics.e(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(new Cookie.Builder().name(trimSubstring).value(str2).domain(httpUrl.host()).build());
            }
            i2 = delimiterOffset + 1;
        }
        return arrayList;
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Intrinsics.f(httpUrl, ImagesContract.URL);
        try {
            Map<String, List<String>> map = this.cookieHandler.get(httpUrl.uri(), MapsKt__MapsKt.g());
            Intrinsics.e(map, "cookieHeaders");
            ArrayList arrayList = null;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                List<String> list = (List) next.getValue();
                if (StringsKt__StringsJVMKt.t("Cookie", str, true) || StringsKt__StringsJVMKt.t("Cookie2", str, true)) {
                    Intrinsics.e(list, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    if (!list.isEmpty()) {
                        for (String str2 : list) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            Intrinsics.e(str2, "header");
                            arrayList.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str2));
                        }
                    }
                }
            }
            if (arrayList == null) {
                return CollectionsKt__CollectionsKt.f();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.e(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        } catch (IOException e2) {
            Platform platform = Platform.Companion.get();
            StringBuilder sb = new StringBuilder();
            sb.append("Loading cookies failed for ");
            HttpUrl resolve = httpUrl.resolve("/...");
            Intrinsics.c(resolve);
            sb.append(resolve);
            platform.log(sb.toString(), 5, e2);
            return CollectionsKt__CollectionsKt.f();
        }
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics.f(httpUrl, ImagesContract.URL);
        Intrinsics.f(list, "cookies");
        ArrayList arrayList = new ArrayList();
        for (Cookie cookieToString : list) {
            arrayList.add(Internal.cookieToString(cookieToString, true));
        }
        try {
            this.cookieHandler.put(httpUrl.uri(), MapsKt__MapsJVMKt.e(TuplesKt.a("Set-Cookie", arrayList)));
        } catch (IOException e2) {
            Platform platform = Platform.Companion.get();
            StringBuilder sb = new StringBuilder();
            sb.append("Saving cookies failed for ");
            HttpUrl resolve = httpUrl.resolve("/...");
            Intrinsics.c(resolve);
            sb.append(resolve);
            platform.log(sb.toString(), 5, e2);
        }
    }
}

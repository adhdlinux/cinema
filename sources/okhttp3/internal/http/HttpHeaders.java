package okhttp3.internal.http;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.f41331e;
        QUOTED_STRING_DELIMITERS = companion.d("\"\\");
        TOKEN_DELIMITERS = companion.d("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        Intrinsics.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        Intrinsics.f(headers, "<this>");
        Intrinsics.f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (StringsKt__StringsJVMKt.t(str, headers.name(i2), true)) {
                try {
                    readChallengeHeader(new Buffer().w(headers.value(i2)), arrayList);
                } catch (EOFException e2) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e2);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        Intrinsics.f(response, "<this>");
        if (Intrinsics.a(response.request().method(), "HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1 && !StringsKt__StringsJVMKt.t("chunked", Response.header$default(response, "Transfer-Encoding", (String) null, 2, (Object) null), true)) {
            return false;
        }
        return true;
    }

    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) throws EOFException {
        String readToken;
        int skipAll;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    skipCommasAndWhitespace(buffer);
                    str2 = readToken(buffer);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                readToken = readToken(buffer);
                if (readToken != null) {
                    skipAll = Util.skipAll(buffer, (byte) 61);
                    boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                    if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !buffer.V())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int skipAll2 = skipAll + Util.skipAll(buffer, (byte) 61);
                        while (true) {
                            if (readToken == null) {
                                readToken = readToken(buffer);
                                if (skipCommasAndWhitespace(buffer)) {
                                    continue;
                                    break;
                                }
                                skipAll2 = Util.skipAll(buffer, (byte) 61);
                            }
                            if (skipAll2 == 0) {
                                continue;
                                break;
                            } else if (skipAll2 <= 1 && !skipCommasAndWhitespace(buffer)) {
                                if (startsWith(buffer, (byte) 34)) {
                                    str = readQuotedString(buffer);
                                } else {
                                    str = readToken(buffer);
                                }
                                if (str == null || ((String) linkedHashMap.put(readToken, str)) != null) {
                                    return;
                                }
                                if (skipCommasAndWhitespace(buffer) || buffer.V()) {
                                    readToken = null;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new Challenge(str2, (Map<String, String>) linkedHashMap));
                        str2 = readToken;
                    }
                } else if (buffer.V()) {
                    list.add(new Challenge(str2, (Map<String, String>) MapsKt__MapsKt.g()));
                    return;
                } else {
                    return;
                }
            }
            Map singletonMap = Collections.singletonMap((Object) null, readToken + StringsKt__StringsJVMKt.y("=", skipAll));
            Intrinsics.e(singletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str2, (Map<String, String>) singletonMap));
        }
    }

    private static final String readQuotedString(Buffer buffer) throws EOFException {
        boolean z2;
        if (buffer.readByte() == 34) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long E = buffer.E(QUOTED_STRING_DELIMITERS);
                if (E == -1) {
                    return null;
                }
                if (buffer.z(E) == 34) {
                    buffer2.write(buffer, E);
                    buffer.readByte();
                    return buffer2.f0();
                } else if (buffer.size() == E + 1) {
                    return null;
                } else {
                    buffer2.write(buffer, E);
                    buffer.readByte();
                    buffer2.write(buffer, 1);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String readToken(Buffer buffer) {
        long E = buffer.E(TOKEN_DELIMITERS);
        if (E == -1) {
            E = buffer.size();
        }
        if (E != 0) {
            return buffer.r0(E);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        Intrinsics.f(cookieJar, "<this>");
        Intrinsics.f(httpUrl, ImagesContract.URL);
        Intrinsics.f(headers, "headers");
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.Companion.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z2 = false;
        while (!buffer.V()) {
            byte z3 = buffer.z(0);
            boolean z4 = true;
            if (z3 != 44) {
                if (!(z3 == 32 || z3 == 9)) {
                    z4 = false;
                }
                if (!z4) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z2 = true;
            }
        }
        return z2;
    }

    private static final boolean startsWith(Buffer buffer, byte b2) {
        return !buffer.V() && buffer.z(0) == b2;
    }
}

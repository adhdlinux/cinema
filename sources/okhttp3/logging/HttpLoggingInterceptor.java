package okhttp3.logging;

import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.common.time.Clock;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final Logger DEFAULT = new HttpLoggingInterceptor$Logger$Companion$DEFAULT$1();

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this((Logger) null, 1, (DefaultConstructorMarker) null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        Intrinsics.g(logger2, "logger");
        this.logger = logger2;
        this.headersToRedact = SetsKt__SetsKt.b();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str == null || StringsKt__StringsJVMKt.t(str, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, true) || StringsKt__StringsJVMKt.t(str, "gzip", true)) {
            return false;
        }
        return true;
    }

    private final void logHeader(Headers headers, int i2) {
        String str;
        if (this.headersToRedact.contains(headers.name(i2))) {
            str = "██";
        } else {
            str = headers.value(i2);
        }
        Logger logger2 = this.logger;
        logger2.log(headers.name(i2) + ": " + str);
    }

    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m358deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        boolean z3;
        String str;
        String str2;
        boolean z4;
        String str3;
        String str4;
        String str5;
        Charset charset;
        Throwable th;
        Charset charset2;
        Interceptor.Chain chain2 = chain;
        Intrinsics.g(chain2, "chain");
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        if (level2 == Level.BODY) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || level2 == Level.HEADERS) {
            z3 = true;
        } else {
            z3 = false;
        }
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection != null) {
            str = " " + connection.protocol();
        } else {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (!z3 && body != null) {
            sb2 = sb2 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb2);
        if (z3) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get(TraktV2.HEADER_CONTENT_TYPE) == null) {
                    this.logger.log("Content-Type: " + contentType);
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                logHeader(headers, i2);
            }
            if (!z2 || body == null) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.contentType();
                if (contentType2 == null || (charset2 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                    Intrinsics.b(charset2, "UTF_8");
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.a0(charset2));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain2.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            if (body2 == null) {
                Intrinsics.r();
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str2 = contentLength + "-byte";
            } else {
                str2 = "unknown-length";
            }
            Logger logger2 = this.logger;
            String str6 = "-byte body)";
            StringBuilder sb3 = new StringBuilder();
            long j2 = contentLength;
            sb3.append("<-- ");
            sb3.append(proceed.code());
            if (proceed.message().length() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                str3 = "-byte body omitted)";
                str4 = "";
            } else {
                String message = proceed.message();
                StringBuilder sb4 = new StringBuilder();
                str3 = "-byte body omitted)";
                sb4.append(String.valueOf(' '));
                sb4.append(message);
                str4 = sb4.toString();
            }
            sb3.append(str4);
            sb3.append(' ');
            sb3.append(proceed.request().url());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            if (!z3) {
                str5 = ", " + str2 + " body";
            } else {
                str5 = "";
            }
            sb3.append(str5);
            sb3.append(')');
            logger2.log(sb3.toString());
            if (z3) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    logHeader(headers2, i3);
                }
                if (!z2 || !HttpHeaders.promisesBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Clock.MAX_TIME);
                    Buffer c2 = source.c();
                    Long l2 = null;
                    if (StringsKt__StringsJVMKt.t("gzip", headers2.get("Content-Encoding"), true)) {
                        Long valueOf = Long.valueOf(c2.size());
                        GzipSource gzipSource = new GzipSource(c2.clone());
                        try {
                            c2 = new Buffer();
                            c2.y(gzipSource);
                            CloseableKt.a(gzipSource, (Throwable) null);
                            l2 = valueOf;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            CloseableKt.a(gzipSource, th);
                            throw th3;
                        }
                    }
                    MediaType contentType3 = body2.contentType();
                    if (contentType3 == null || (charset = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                        Intrinsics.b(charset, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(c2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + c2.size() + str3);
                        return proceed;
                    }
                    if (j2 != 0) {
                        this.logger.log("");
                        this.logger.log(c2.clone().a0(charset));
                    }
                    if (l2 != null) {
                        this.logger.log("<-- END HTTP (" + c2.size() + "-byte, " + l2 + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + c2.size() + str6);
                    }
                }
            }
            return proceed;
        } catch (Exception e2) {
            Exception exc = e2;
            this.logger.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    public final void level(Level level2) {
        Intrinsics.g(level2, "<set-?>");
        this.level = level2;
    }

    public final void redactHeader(String str) {
        Intrinsics.g(str, "name");
        TreeSet treeSet = new TreeSet(StringsKt__StringsJVMKt.u(StringCompanionObject.f40434a));
        boolean unused = CollectionsKt__MutableCollectionsKt.u(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        Intrinsics.g(level2, AppLovinEventTypes.USER_COMPLETED_LEVEL);
        this.level = level2;
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Logger.DEFAULT : logger2);
    }
}

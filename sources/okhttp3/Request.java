package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.ui.AdActivity;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    requestBody = Util.EMPTY_REQUEST;
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public Builder addHeader(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder cacheControl(CacheControl cacheControl) {
            boolean z2;
            Intrinsics.f(cacheControl, "cacheControl");
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        public final Builder delete() {
            return delete$default(this, (RequestBody) null, 1, (Object) null);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
        }

        public Builder header(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            Intrinsics.f(headers2, "headers");
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            boolean z2;
            Intrinsics.f(str, "method");
            if (str.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (requestBody == null) {
                    if (!(true ^ HttpMethod.requiresRequestBody(str))) {
                        throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(str)) {
                    throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public Builder patch(RequestBody requestBody) {
            Intrinsics.f(requestBody, "body");
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            Intrinsics.f(requestBody, "body");
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            Intrinsics.f(requestBody, "body");
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            Intrinsics.f(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            Intrinsics.f(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            Intrinsics.f(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            Intrinsics.f(httpUrl, ImagesContract.URL);
            this.url = httpUrl;
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, T t2) {
            Intrinsics.f(cls, "type");
            if (t2 == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                Object cast = cls.cast(t2);
                Intrinsics.c(cast);
                map.put(cls, cast);
            }
            return this;
        }

        public Builder url(String str) {
            Intrinsics.f(str, ImagesContract.URL);
            if (StringsKt__StringsJVMKt.E(str, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String substring = str.substring(3);
                Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                str = sb.toString();
            } else if (StringsKt__StringsJVMKt.E(str, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String substring2 = str.substring(4);
                Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(substring2);
                str = sb2.toString();
            }
            return url(HttpUrl.Companion.get(str));
        }

        public Builder(Request request) {
            Map<Class<?>, Object> map;
            Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = MapsKt__MapsKt.w(request.getTags$okhttp());
            }
            this.tags = map;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url2) {
            Intrinsics.f(url2, ImagesContract.URL);
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url3 = url2.toString();
            Intrinsics.e(url3, "url.toString()");
            return url(companion.get(url3));
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers2, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        Intrinsics.f(httpUrl, ImagesContract.URL);
        Intrinsics.f(str, "method");
        Intrinsics.f(headers2, "headers");
        Intrinsics.f(map, "tags");
        this.url = httpUrl;
        this.method = str;
        this.headers = headers2;
        this.body = requestBody;
        this.tags = map;
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final RequestBody m336deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m337deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m338deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method  reason: not valid java name */
    public final String m339deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m340deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        Intrinsics.f(str, "name");
        return this.headers.get(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i2 = 0;
            for (Object next : this.headers) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.o();
                }
                Pair pair = (Pair) next;
                String str = (String) pair.a();
                String str2 = (String) pair.b();
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i2 = i3;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String str) {
        Intrinsics.f(str, "name");
        return this.headers.values(str);
    }

    public final <T> T tag(Class<? extends T> cls) {
        Intrinsics.f(cls, "type");
        return cls.cast(this.tags.get(cls));
    }
}

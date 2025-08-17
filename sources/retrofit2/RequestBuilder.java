package retrofit2;

import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final Headers.Builder headersBuilder;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();
    private HttpUrl.Builder urlBuilder;

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z2;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        if (z3) {
            this.formBuilder = new FormBody.Builder();
        } else if (z4) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String canonicalizeForPath(String str, boolean z2) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z2 && (codePointAt == 47 || codePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.L0(str, 0, i2);
                canonicalizeForPath(buffer, str, i2, length, z2);
                return buffer.f0();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public void addFormField(String str, String str2, boolean z2) {
        if (z2) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeader(String str, String str2, boolean z2) {
        if (TraktV2.HEADER_CONTENT_TYPE.equalsIgnoreCase(str)) {
            try {
                this.contentType = MediaType.get(str2);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        } else if (z2) {
            this.headersBuilder.addUnsafeNonAscii(str, str2);
        } else {
            this.headersBuilder.add(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeaders(Headers headers) {
        this.headersBuilder.addAll(headers);
    }

    /* access modifiers changed from: package-private */
    public void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    /* access modifiers changed from: package-private */
    public void addPathParam(String str, String str2, boolean z2) {
        if (this.relativeUrl != null) {
            String canonicalizeForPath = canonicalizeForPath(str2, z2);
            String str3 = this.relativeUrl;
            String replace = str3.replace("{" + str + "}", canonicalizeForPath);
            if (!PATH_TRAVERSAL.matcher(replace).matches()) {
                this.relativeUrl = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void addQueryParam(String str, String str2, boolean z2) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.baseUrl.newBuilder(str3);
            this.urlBuilder = newBuilder;
            if (newBuilder != null) {
                this.relativeUrl = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        if (z2) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void addTag(Class<T> cls, T t2) {
        this.requestBuilder.tag(cls, t2);
    }

    /* access modifiers changed from: package-private */
    public Request.Builder get() {
        HttpUrl httpUrl;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            httpUrl = builder.build();
        } else {
            httpUrl = this.baseUrl.resolve(this.relativeUrl);
            if (httpUrl == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.build();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                this.headersBuilder.add(TraktV2.HEADER_CONTENT_TYPE, mediaType.toString());
            }
        }
        return this.requestBuilder.url(httpUrl).headers(this.headersBuilder.build()).method(this.method, contentTypeOverridingRequestBody);
    }

    /* access modifiers changed from: package-private */
    public void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    /* access modifiers changed from: package-private */
    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    /* access modifiers changed from: package-private */
    public void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    private static void canonicalizeForPath(Buffer buffer, String str, int i2, int i3, boolean z2) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z2 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z2 && (codePointAt == 47 || codePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.M0(codePointAt);
                    while (!buffer2.V()) {
                        byte readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte(cArr[(readByte >> 4) & 15]);
                        buffer.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    buffer.M0(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }
}

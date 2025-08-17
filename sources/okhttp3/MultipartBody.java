package okhttp3;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength = -1;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public Builder(String str) {
            Intrinsics.f(str, "boundary");
            this.boundary = ByteString.f41331e.d(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        public final Builder addPart(RequestBody requestBody) {
            Intrinsics.f(requestBody, "body");
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final Builder setType(MediaType mediaType) {
            Intrinsics.f(mediaType, "type");
            if (Intrinsics.a(mediaType.type(), "multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            Intrinsics.f(str, "name");
            Intrinsics.f(requestBody, "body");
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            Intrinsics.f(requestBody, "body");
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        public final Builder addPart(Part part) {
            Intrinsics.f(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L_0x0011
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.e(r1, r2)
            L_0x0011:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.Builder.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder sb, String str) {
            Intrinsics.f(sb, "<this>");
            Intrinsics.f(str, "key");
            sb.append('\"');
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == 10) {
                    sb.append("%0A");
                } else if (charAt == 13) {
                    sb.append("%0D");
                } else if (charAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(charAt);
                }
            }
            sb.append('\"');
        }
    }

    public static final class Part {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final RequestBody body;
        private final Headers headers;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Part create(RequestBody requestBody) {
                Intrinsics.f(requestBody, "body");
                return create((Headers) null, requestBody);
            }

            public final Part createFormData(String str, String str2) {
                Intrinsics.f(str, "name");
                Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                return createFormData(str, (String) null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            public final Part create(Headers headers, RequestBody requestBody) {
                Intrinsics.f(requestBody, "body");
                boolean z2 = true;
                if ((headers != null ? headers.get(TraktV2.HEADER_CONTENT_TYPE) : null) == null) {
                    if ((headers != null ? headers.get("Content-Length") : null) != null) {
                        z2 = false;
                    }
                    if (z2) {
                        return new Part(headers, requestBody, (DefaultConstructorMarker) null);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }

            public final Part createFormData(String str, String str2, RequestBody requestBody) {
                Intrinsics.f(str, "name");
                Intrinsics.f(requestBody, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str2);
                }
                String sb2 = sb.toString();
                Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb2).build(), requestBody);
            }
        }

        private Part(Headers headers2, RequestBody requestBody) {
            this.headers = headers2;
            this.body = requestBody;
        }

        public /* synthetic */ Part(Headers headers2, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
            this(headers2, requestBody);
        }

        public static final Part create(Headers headers2, RequestBody requestBody) {
            return Companion.create(headers2, requestBody);
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }

        /* renamed from: -deprecated_body  reason: not valid java name */
        public final RequestBody m306deprecated_body() {
            return this.body;
        }

        /* renamed from: -deprecated_headers  reason: not valid java name */
        public final Headers m307deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        Intrinsics.f(byteString, "boundaryByteString");
        Intrinsics.f(mediaType, "type");
        Intrinsics.f(list, "parts");
        this.boundaryByteString = byteString;
        this.type = mediaType;
        this.parts = list;
        MediaType.Companion companion = MediaType.Companion;
        this.contentType = companion.get(mediaType + "; boundary=" + boundary());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long writeOrCountBytes(okio.BufferedSink r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            okio.Buffer r13 = new okio.Buffer
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<okhttp3.MultipartBody$Part> r1 = r12.parts
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00ae
            java.util.List<okhttp3.MultipartBody$Part> r6 = r12.parts
            java.lang.Object r6 = r6.get(r5)
            okhttp3.MultipartBody$Part r6 = (okhttp3.MultipartBody.Part) r6
            okhttp3.Headers r7 = r6.headers()
            okhttp3.RequestBody r6 = r6.body()
            kotlin.jvm.internal.Intrinsics.c(r13)
            byte[] r8 = DASHDASH
            r13.write(r8)
            okio.ByteString r8 = r12.boundaryByteString
            r13.h0(r8)
            byte[] r8 = CRLF
            r13.write(r8)
            if (r7 == 0) goto L_0x005f
            int r8 = r7.size()
            r9 = 0
        L_0x003f:
            if (r9 >= r8) goto L_0x005f
            java.lang.String r10 = r7.name(r9)
            okio.BufferedSink r10 = r13.w(r10)
            byte[] r11 = COLONSPACE
            okio.BufferedSink r10 = r10.write(r11)
            java.lang.String r11 = r7.value(r9)
            okio.BufferedSink r10 = r10.w(r11)
            byte[] r11 = CRLF
            r10.write(r11)
            int r9 = r9 + 1
            goto L_0x003f
        L_0x005f:
            okhttp3.MediaType r7 = r6.contentType()
            if (r7 == 0) goto L_0x0078
            java.lang.String r8 = "Content-Type: "
            okio.BufferedSink r8 = r13.w(r8)
            java.lang.String r7 = r7.toString()
            okio.BufferedSink r7 = r8.w(r7)
            byte[] r8 = CRLF
            r7.write(r8)
        L_0x0078:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0092
            java.lang.String r9 = "Content-Length: "
            okio.BufferedSink r9 = r13.w(r9)
            okio.BufferedSink r9 = r9.O(r7)
            byte[] r10 = CRLF
            r9.write(r10)
            goto L_0x009b
        L_0x0092:
            if (r14 == 0) goto L_0x009b
            kotlin.jvm.internal.Intrinsics.c(r0)
            r0.a()
            return r9
        L_0x009b:
            byte[] r9 = CRLF
            r13.write(r9)
            if (r14 == 0) goto L_0x00a4
            long r3 = r3 + r7
            goto L_0x00a7
        L_0x00a4:
            r6.writeTo(r13)
        L_0x00a7:
            r13.write(r9)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00ae:
            kotlin.jvm.internal.Intrinsics.c(r13)
            byte[] r1 = DASHDASH
            r13.write(r1)
            okio.ByteString r2 = r12.boundaryByteString
            r13.h0(r2)
            r13.write(r1)
            byte[] r1 = CRLF
            r13.write(r1)
            if (r14 == 0) goto L_0x00d0
            kotlin.jvm.internal.Intrinsics.c(r0)
            long r13 = r0.size()
            long r3 = r3 + r13
            r0.a()
        L_0x00d0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.writeOrCountBytes(okio.BufferedSink, boolean):long");
    }

    /* renamed from: -deprecated_boundary  reason: not valid java name */
    public final String m302deprecated_boundary() {
        return boundary();
    }

    /* renamed from: -deprecated_parts  reason: not valid java name */
    public final List<Part> m303deprecated_parts() {
        return this.parts;
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m304deprecated_size() {
        return size();
    }

    /* renamed from: -deprecated_type  reason: not valid java name */
    public final MediaType m305deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.y();
    }

    public long contentLength() throws IOException {
        long j2 = this.contentLength;
        if (j2 != -1) {
            return j2;
        }
        long writeOrCountBytes = writeOrCountBytes((BufferedSink) null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i2) {
        return this.parts.get(i2);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.f(bufferedSink, "sink");
        writeOrCountBytes(bufferedSink, false);
    }
}

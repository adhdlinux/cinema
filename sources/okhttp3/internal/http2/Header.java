package okhttp3.internal.http2;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

public final class Header {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ByteString.Companion companion = ByteString.f41331e;
        PSEUDO_PREFIX = companion.d(":");
        RESPONSE_STATUS = companion.d(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = companion.d(TARGET_METHOD_UTF8);
        TARGET_PATH = companion.d(TARGET_PATH_UTF8);
        TARGET_SCHEME = companion.d(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = companion.d(TARGET_AUTHORITY_UTF8);
    }

    public Header(ByteString byteString, ByteString byteString2) {
        Intrinsics.f(byteString, "name");
        Intrinsics.f(byteString2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + byteString2.size();
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            byteString = header.name;
        }
        if ((i2 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString byteString, ByteString byteString2) {
        Intrinsics.f(byteString, "name");
        Intrinsics.f(byteString2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return new Header(byteString, byteString2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.a(this.name, header.name) && Intrinsics.a(this.value, header.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.y() + ": " + this.value.y();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Header(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            okio.ByteString$Companion r0 = okio.ByteString.f41331e
            okio.ByteString r2 = r0.d(r2)
            okio.ByteString r3 = r0.d(r3)
            r1.<init>((okio.ByteString) r2, (okio.ByteString) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Header.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.f41331e.d(str));
        Intrinsics.f(byteString, "name");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }
}

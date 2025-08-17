package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.Response;

public final class StatusLine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatusLine get(Response response) {
            Intrinsics.f(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws IOException {
            int i2;
            Protocol protocol;
            String str2;
            Intrinsics.f(str, "statusLine");
            if (StringsKt__StringsJVMKt.G(str, "HTTP/1.", false, 2, (Object) null)) {
                i2 = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (StringsKt__StringsJVMKt.G(str, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                i2 = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i3 = i2 + 3;
            if (str.length() >= i3) {
                try {
                    String substring = str.substring(i2, i3);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (str.length() <= i3) {
                        str2 = "";
                    } else if (str.charAt(i3) == ' ') {
                        str2 = str.substring(i2 + 4);
                        Intrinsics.e(str2, "this as java.lang.String).substring(startIndex)");
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new StatusLine(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
    }

    public StatusLine(Protocol protocol2, int i2, String str) {
        Intrinsics.f(protocol2, "protocol");
        Intrinsics.f(str, "message");
        this.protocol = protocol2;
        this.code = i2;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

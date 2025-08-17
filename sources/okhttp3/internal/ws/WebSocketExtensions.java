package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;

public final class WebSocketExtensions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebSocketExtensions parse(Headers headers) throws IOException {
            String str;
            Headers headers2 = headers;
            Intrinsics.f(headers2, "responseHeaders");
            int size = headers.size();
            boolean z2 = false;
            Integer num = null;
            boolean z3 = false;
            Integer num2 = null;
            boolean z4 = false;
            boolean z5 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (StringsKt__StringsJVMKt.t(headers2.name(i2), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String value = headers2.value(i2);
                    int i3 = 0;
                    while (i3 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i3, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i3, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i3, delimiterOffset);
                        int i4 = delimiterOffset + 1;
                        if (StringsKt__StringsJVMKt.t(trimSubstring, "permessage-deflate", true)) {
                            if (z2) {
                                z5 = true;
                            }
                            i3 = i4;
                            while (i3 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i3, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i3, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i3, delimiterOffset3);
                                if (delimiterOffset3 < delimiterOffset2) {
                                    str = StringsKt__StringsKt.o0(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"");
                                } else {
                                    str = null;
                                }
                                i3 = delimiterOffset2 + 1;
                                if (StringsKt__StringsJVMKt.t(trimSubstring2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z5 = true;
                                    }
                                    if (str != null) {
                                        num = StringsKt__StringNumberConversionsKt.k(str);
                                    } else {
                                        num = null;
                                    }
                                    if (num != null) {
                                    }
                                } else if (StringsKt__StringsJVMKt.t(trimSubstring2, "client_no_context_takeover", true)) {
                                    if (z3) {
                                        z5 = true;
                                    }
                                    if (str != null) {
                                        z5 = true;
                                    }
                                    z3 = true;
                                } else if (StringsKt__StringsJVMKt.t(trimSubstring2, "server_max_window_bits", true)) {
                                    if (num2 != null) {
                                        z5 = true;
                                    }
                                    if (str != null) {
                                        num2 = StringsKt__StringNumberConversionsKt.k(str);
                                    } else {
                                        num2 = null;
                                    }
                                    if (num2 != null) {
                                    }
                                } else if (StringsKt__StringsJVMKt.t(trimSubstring2, "server_no_context_takeover", true)) {
                                    if (z4) {
                                        z5 = true;
                                    }
                                    if (str != null) {
                                        z5 = true;
                                    }
                                    z4 = true;
                                }
                                z5 = true;
                            }
                            z2 = true;
                        } else {
                            i3 = i4;
                            z5 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z2, num, z3, num2, z4, z5);
        }
    }

    public WebSocketExtensions() {
        this(false, (Integer) null, false, (Integer) null, false, false, 63, (DefaultConstructorMarker) null);
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.perMessageDeflate = z2;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z3;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z4;
        this.unknownValues = z5;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = webSocketExtensions.perMessageDeflate;
        }
        if ((i2 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i2 & 4) != 0) {
            z3 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z6 = z3;
        if ((i2 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i2 & 16) != 0) {
            z4 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z7 = z4;
        if ((i2 & 32) != 0) {
            z5 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z2, num3, z6, num4, z7, z5);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        return new WebSocketExtensions(z2, num, z3, num2, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z2 = this.perMessageDeflate;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int i2 = (z2 ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i3 = 0;
        int hashCode = (i2 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z4 = this.clientNoContextTakeover;
        if (z4) {
            z4 = true;
        }
        int i4 = (hashCode + (z4 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        int i5 = (i4 + i3) * 31;
        boolean z5 = this.serverNoContextTakeover;
        if (z5) {
            z5 = true;
        }
        int i6 = (i5 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.unknownValues;
        if (!z6) {
            z3 = z6;
        }
        return i6 + (z3 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z2) {
        if (z2) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r6, java.lang.Integer r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = 0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r3 = 0
            goto L_0x0017
        L_0x0016:
            r3 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = 0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r1
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

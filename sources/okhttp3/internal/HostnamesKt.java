package okhttp3.internal;

import com.facebook.imageutils.JfifUtil;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Intrinsics.h(charAt, 31) <= 0 || Intrinsics.h(charAt, 127) >= 0 || StringsKt__StringsKt.V(" #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (Intrinsics.h(charAt, 48) < 0 || Intrinsics.h(charAt, 57) > 0) {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        if (i5 == i4 + 4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        if (r13 == 16) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0098, code lost:
        if (r14 != -1) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ac, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A[LOOP:0: B:1:0x000e->B:36:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[EDGE_INSN: B:44:0x0095->B:37:0x0095 ?: BREAK  
    EDGE_INSN: B:50:0x0095->B:37:0x0095 ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            r6 = r18
            r7 = r20
            r8 = 16
            byte[] r9 = new byte[r8]
            r11 = -1
            r12 = r19
            r13 = 0
            r14 = -1
            r15 = -1
        L_0x000e:
            r16 = 0
            if (r12 >= r7) goto L_0x0096
            if (r13 != r8) goto L_0x0015
            return r16
        L_0x0015:
            int r5 = r12 + 2
            if (r5 > r7) goto L_0x0038
            java.lang.String r1 = "::"
            r3 = 0
            r4 = 4
            r17 = 0
            r0 = r18
            r2 = r12
            r10 = r5
            r5 = r17
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.F(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0038
            if (r14 == r11) goto L_0x002e
            return r16
        L_0x002e:
            int r13 = r13 + 2
            if (r10 != r7) goto L_0x0035
            r14 = r13
            goto L_0x0096
        L_0x0035:
            r15 = r10
            r14 = r13
            goto L_0x0067
        L_0x0038:
            if (r13 == 0) goto L_0x0066
            java.lang.String r1 = ":"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.F(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x004b
            int r12 = r12 + 1
            goto L_0x0066
        L_0x004b:
            java.lang.String r1 = "."
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.F(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0065
            int r0 = r13 + -2
            boolean r0 = decodeIpv4Suffix(r6, r15, r7, r9, r0)
            if (r0 != 0) goto L_0x0062
            return r16
        L_0x0062:
            int r13 = r13 + 2
            goto L_0x0096
        L_0x0065:
            return r16
        L_0x0066:
            r15 = r12
        L_0x0067:
            r12 = r15
            r0 = 0
        L_0x0069:
            if (r12 >= r7) goto L_0x007b
            char r1 = r6.charAt(r12)
            int r1 = okhttp3.internal.Util.parseHexDigit(r1)
            if (r1 == r11) goto L_0x007b
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L_0x0069
        L_0x007b:
            int r1 = r12 - r15
            if (r1 == 0) goto L_0x0095
            r2 = 4
            if (r1 <= r2) goto L_0x0083
            goto L_0x0095
        L_0x0083:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto L_0x000e
        L_0x0095:
            return r16
        L_0x0096:
            if (r13 == r8) goto L_0x00a8
            if (r14 != r11) goto L_0x009b
            return r16
        L_0x009b:
            int r0 = r13 - r14
            int r1 = 16 - r0
            java.lang.System.arraycopy(r9, r14, r9, r1, r0)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            java.util.Arrays.fill(r9, r14, r8, r0)
        L_0x00a8:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        Buffer buffer = new Buffer();
        while (i3 < bArr.length) {
            if (i3 == i2) {
                buffer.writeByte(58);
                i3 += i5;
                if (i3 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i3 > 0) {
                    buffer.writeByte(58);
                }
                buffer.b0((long) ((Util.and(bArr[i3], (int) JfifUtil.MARKER_FIRST_BYTE) << 8) | Util.and(bArr[i3 + 1], (int) JfifUtil.MARKER_FIRST_BYTE)));
                i3 += 2;
            }
        }
        return buffer.f0();
    }

    public static final String toCanonicalHost(String str) {
        InetAddress inetAddress;
        Intrinsics.f(str, "<this>");
        boolean z2 = false;
        if (StringsKt__StringsKt.L(str, ":", false, 2, (Object) null)) {
            if (!StringsKt__StringsJVMKt.G(str, "[", false, 2, (Object) null) || !StringsKt__StringsJVMKt.s(str, "]", false, 2, (Object) null)) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.e(address, "address");
                return inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return inetAddress.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.e(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.e(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    z2 = true;
                }
                if (!z2 && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}

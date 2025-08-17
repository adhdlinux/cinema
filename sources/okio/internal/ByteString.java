package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* renamed from: okio.internal.-ByteString  reason: invalid class name */
public final class ByteString {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f41393a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0044 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0159 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x007a A[EDGE_INSN: B:262:0x007a->B:51:0x007a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x00ce A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x01fc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x020f
            byte r7 = r0[r4]
            r8 = 160(0xa0, float:2.24E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 32
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x0082
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0042
            if (r7 == r11) goto L_0x0042
            if (r7 < 0) goto L_0x0030
            if (r7 >= r10) goto L_0x0030
            r6 = 1
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r6 != 0) goto L_0x003f
            if (r9 > r7) goto L_0x0039
            if (r7 >= r8) goto L_0x0039
            r6 = 1
            goto L_0x003a
        L_0x0039:
            r6 = 0
        L_0x003a:
            if (r6 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r6 = 0
            goto L_0x0040
        L_0x003f:
            r6 = 1
        L_0x0040:
            if (r6 != 0) goto L_0x0044
        L_0x0042:
            if (r7 != r12) goto L_0x0045
        L_0x0044:
            return r16
        L_0x0045:
            if (r7 >= r14) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0049:
            r6 = 2
        L_0x004a:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x004d:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r4 = r4 + 1
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x005c
            return r5
        L_0x005c:
            if (r7 == r13) goto L_0x0078
            if (r7 == r11) goto L_0x0078
            if (r7 < 0) goto L_0x0066
            if (r7 >= r10) goto L_0x0066
            r6 = 1
            goto L_0x0067
        L_0x0066:
            r6 = 0
        L_0x0067:
            if (r6 != 0) goto L_0x0075
            if (r9 > r7) goto L_0x006f
            if (r7 >= r8) goto L_0x006f
            r6 = 1
            goto L_0x0070
        L_0x006f:
            r6 = 0
        L_0x0070:
            if (r6 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r6 = 0
            goto L_0x0076
        L_0x0075:
            r6 = 1
        L_0x0076:
            if (r6 != 0) goto L_0x007a
        L_0x0078:
            if (r7 != r12) goto L_0x007b
        L_0x007a:
            return r16
        L_0x007b:
            if (r7 >= r14) goto L_0x007f
            r6 = 1
            goto L_0x0080
        L_0x007f:
            r6 = 2
        L_0x0080:
            int r5 = r5 + r6
            goto L_0x004d
        L_0x0082:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00de
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x0091
            if (r6 != r1) goto L_0x0090
            return r5
        L_0x0090:
            return r16
        L_0x0091:
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x0099
            r15 = 1
            goto L_0x009a
        L_0x0099:
            r15 = 0
        L_0x009a:
            if (r15 != 0) goto L_0x00a0
            if (r6 != r1) goto L_0x009f
            return r5
        L_0x009f:
            return r16
        L_0x00a0:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x00ab
            if (r6 != r1) goto L_0x00aa
            return r5
        L_0x00aa:
            return r16
        L_0x00ab:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00b0
            return r5
        L_0x00b0:
            if (r3 == r13) goto L_0x00cc
            if (r3 == r11) goto L_0x00cc
            if (r3 < 0) goto L_0x00ba
            if (r3 >= r10) goto L_0x00ba
            r6 = 1
            goto L_0x00bb
        L_0x00ba:
            r6 = 0
        L_0x00bb:
            if (r6 != 0) goto L_0x00c9
            if (r9 > r3) goto L_0x00c3
            if (r3 >= r8) goto L_0x00c3
            r6 = 1
            goto L_0x00c4
        L_0x00c3:
            r6 = 0
        L_0x00c4:
            if (r6 == 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r6 = 0
            goto L_0x00ca
        L_0x00c9:
            r6 = 1
        L_0x00ca:
            if (r6 != 0) goto L_0x00ce
        L_0x00cc:
            if (r3 != r12) goto L_0x00cf
        L_0x00ce:
            return r16
        L_0x00cf:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00d5
            r15 = 1
            goto L_0x00d6
        L_0x00d5:
            r15 = 2
        L_0x00d6:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.f40298a
            int r4 = r4 + 2
        L_0x00db:
            r6 = r7
            goto L_0x0008
        L_0x00de:
            int r3 = r7 >> 4
            r12 = 57344(0xe000, float:8.0356E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 != r15) goto L_0x0168
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x00f0
            if (r6 != r1) goto L_0x00ef
            return r5
        L_0x00ef:
            return r16
        L_0x00f0:
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x00fa
            r9 = 1
            goto L_0x00fb
        L_0x00fa:
            r9 = 0
        L_0x00fb:
            if (r9 != 0) goto L_0x0101
            if (r6 != r1) goto L_0x0100
            return r5
        L_0x0100:
            return r16
        L_0x0101:
            byte r3 = r0[r3]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x0109
            r9 = 1
            goto L_0x010a
        L_0x0109:
            r9 = 0
        L_0x010a:
            if (r9 != 0) goto L_0x0110
            if (r6 != r1) goto L_0x010f
            return r5
        L_0x010f:
            return r16
        L_0x0110:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x0122
            if (r6 != r1) goto L_0x0121
            return r5
        L_0x0121:
            return r16
        L_0x0122:
            if (r8 > r3) goto L_0x0128
            if (r3 >= r12) goto L_0x0128
            r7 = 1
            goto L_0x0129
        L_0x0128:
            r7 = 0
        L_0x0129:
            if (r7 == 0) goto L_0x012f
            if (r6 != r1) goto L_0x012e
            return r5
        L_0x012e:
            return r16
        L_0x012f:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x0134
            return r5
        L_0x0134:
            if (r3 == r13) goto L_0x0154
            if (r3 == r11) goto L_0x0154
            if (r3 < 0) goto L_0x013e
            if (r3 >= r10) goto L_0x013e
            r6 = 1
            goto L_0x013f
        L_0x013e:
            r6 = 0
        L_0x013f:
            if (r6 != 0) goto L_0x0151
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x014b
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x014b
            r6 = 1
            goto L_0x014c
        L_0x014b:
            r6 = 0
        L_0x014c:
            if (r6 == 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r6 = 0
            goto L_0x0152
        L_0x0151:
            r6 = 1
        L_0x0152:
            if (r6 != 0) goto L_0x0159
        L_0x0154:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x015a
        L_0x0159:
            return r16
        L_0x015a:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0160
            r15 = 1
            goto L_0x0161
        L_0x0160:
            r15 = 2
        L_0x0161:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.f40298a
            int r4 = r4 + 3
            goto L_0x00db
        L_0x0168:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x020b
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x0174
            if (r6 != r1) goto L_0x0173
            return r5
        L_0x0173:
            return r16
        L_0x0174:
            int r9 = r4 + 1
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x017e
            r15 = 1
            goto L_0x017f
        L_0x017e:
            r15 = 0
        L_0x017f:
            if (r15 != 0) goto L_0x0185
            if (r6 != r1) goto L_0x0184
            return r5
        L_0x0184:
            return r16
        L_0x0185:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x018f
            r10 = 1
            goto L_0x0190
        L_0x018f:
            r10 = 0
        L_0x0190:
            if (r10 != 0) goto L_0x0196
            if (r6 != r1) goto L_0x0195
            return r5
        L_0x0195:
            return r16
        L_0x0196:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x019e
            r10 = 1
            goto L_0x019f
        L_0x019e:
            r10 = 0
        L_0x019f:
            if (r10 != 0) goto L_0x01a5
            if (r6 != r1) goto L_0x01a4
            return r5
        L_0x01a4:
            return r16
        L_0x01a5:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r9 = r9 << 12
            r3 = r3 ^ r9
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x01bb
            if (r6 != r1) goto L_0x01ba
            return r5
        L_0x01ba:
            return r16
        L_0x01bb:
            if (r8 > r3) goto L_0x01c1
            if (r3 >= r12) goto L_0x01c1
            r7 = 1
            goto L_0x01c2
        L_0x01c1:
            r7 = 0
        L_0x01c2:
            if (r7 == 0) goto L_0x01c8
            if (r6 != r1) goto L_0x01c7
            return r5
        L_0x01c7:
            return r16
        L_0x01c8:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01d0
            if (r6 != r1) goto L_0x01cf
            return r5
        L_0x01cf:
            return r16
        L_0x01d0:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01d5
            return r5
        L_0x01d5:
            if (r3 == r13) goto L_0x01f7
            if (r3 == r11) goto L_0x01f7
            if (r3 < 0) goto L_0x01e1
            r6 = 32
            if (r3 >= r6) goto L_0x01e1
            r6 = 1
            goto L_0x01e2
        L_0x01e1:
            r6 = 0
        L_0x01e2:
            if (r6 != 0) goto L_0x01f4
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x01ee
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x01ee
            r6 = 1
            goto L_0x01ef
        L_0x01ee:
            r6 = 0
        L_0x01ef:
            if (r6 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r6 = 0
            goto L_0x01f5
        L_0x01f4:
            r6 = 1
        L_0x01f5:
            if (r6 != 0) goto L_0x01fc
        L_0x01f7:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x01fd
        L_0x01fc:
            return r16
        L_0x01fd:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0203
            r15 = 1
            goto L_0x0204
        L_0x0203:
            r15 = 2
        L_0x0204:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.f40298a
            int r4 = r4 + 4
            goto L_0x00db
        L_0x020b:
            if (r6 != r1) goto L_0x020e
            return r5
        L_0x020e:
            return r16
        L_0x020f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteString.c(byte[], int):int");
    }

    public static final void d(okio.ByteString byteString, Buffer buffer, int i2, int i3) {
        Intrinsics.f(byteString, "<this>");
        Intrinsics.f(buffer, "buffer");
        buffer.write(byteString.g(), i2, i3);
    }

    /* access modifiers changed from: private */
    public static final int e(char c2) {
        boolean z2 = true;
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (!('a' <= c2 && c2 < 'g')) {
            c3 = 'A';
            if ('A' > c2 || c2 >= 'G') {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static final char[] f() {
        return f41393a;
    }
}

package com.startapp;

import com.startapp.hf;
import java.nio.charset.Charset;

public class gf extends hf {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f34595e = {13, 10};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f34596f = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f34597g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f34598h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: i  reason: collision with root package name */
    public final byte[] f34599i;

    /* renamed from: j  reason: collision with root package name */
    public final byte[] f34600j;

    /* renamed from: k  reason: collision with root package name */
    public final int f34601k;

    public gf(int i2, byte[] bArr, boolean z2) {
        super(3, 4, i2, bArr.length);
        byte[] bArr2;
        if (!a(bArr)) {
            if (i2 > 0) {
                this.f34601k = bArr.length + 4;
                byte[] bArr3 = new byte[bArr.length];
                this.f34600j = bArr3;
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            } else {
                this.f34601k = 4;
                this.f34600j = null;
            }
            if (z2) {
                bArr2 = f34597g;
            } else {
                bArr2 = f34596f;
            }
            this.f34599i = bArr2;
            return;
        }
        String a2 = p.a(bArr);
        throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + a2 + "]");
    }

    public static String b(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            gf gfVar = new gf(0, f34595e, false);
            long length = ((long) (((bArr.length + 3) - 1) / 3)) * ((long) 4);
            int i2 = gfVar.f34662c;
            if (i2 > 0) {
                long j2 = (long) i2;
                length += (((length + j2) - 1) / j2) * ((long) gfVar.f34663d);
            }
            if (length > ((long) Integer.MAX_VALUE)) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + length + ") than the specified maximum size of " + Integer.MAX_VALUE);
            } else if (bArr.length != 0) {
                hf.a aVar = new hf.a();
                gfVar.a(bArr, 0, bArr.length, aVar);
                gfVar.a(bArr, 0, -1, aVar);
                int i3 = aVar.f34666c - aVar.f34667d;
                byte[] bArr2 = new byte[i3];
                if (aVar.f34665b != null) {
                    int min = Math.min(i3, i3);
                    System.arraycopy(aVar.f34665b, aVar.f34667d, bArr2, 0, min);
                    int i4 = aVar.f34667d + min;
                    aVar.f34667d = i4;
                    if (i4 >= aVar.f34666c) {
                        aVar.f34665b = null;
                    }
                }
                bArr = bArr2;
            }
        }
        Charset charset = Cif.f34709a;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r10, int r11, int r12, com.startapp.hf.a r13) {
        /*
            r9 = this;
            boolean r0 = r13.f34668e
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r12 >= 0) goto L_0x00b5
            r13.f34668e = r1
            int r10 = r13.f34670g
            if (r10 != 0) goto L_0x0014
            int r10 = r9.f34662c
            if (r10 != 0) goto L_0x0014
            return
        L_0x0014:
            int r10 = r9.f34601k
            byte[] r10 = r9.a(r10, r13)
            int r11 = r13.f34666c
            int r12 = r13.f34670g
            if (r12 == 0) goto L_0x0097
            r2 = 61
            if (r12 == r1) goto L_0x006f
            r1 = 2
            if (r12 != r1) goto L_0x0056
            int r12 = r11 + 1
            byte[] r3 = r9.f34599i
            int r4 = r13.f34664a
            int r5 = r4 >> 10
            r5 = r5 & 63
            byte r5 = r3[r5]
            r10[r11] = r5
            int r5 = r12 + 1
            int r6 = r4 >> 4
            r6 = r6 & 63
            byte r6 = r3[r6]
            r10[r12] = r6
            int r12 = r5 + 1
            r13.f34666c = r12
            int r1 = r4 << 2
            r1 = r1 & 63
            byte r1 = r3[r1]
            r10[r5] = r1
            byte[] r1 = f34596f
            if (r3 != r1) goto L_0x0097
            int r1 = r12 + 1
            r13.f34666c = r1
            r10[r12] = r2
            goto L_0x0097
        L_0x0056:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Impossible modulus "
            r11.append(r12)
            int r12 = r13.f34670g
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x006f:
            int r12 = r11 + 1
            byte[] r1 = r9.f34599i
            int r3 = r13.f34664a
            int r4 = r3 >> 2
            r4 = r4 & 63
            byte r4 = r1[r4]
            r10[r11] = r4
            int r4 = r12 + 1
            r13.f34666c = r4
            int r3 = r3 << 4
            r3 = r3 & 63
            byte r3 = r1[r3]
            r10[r12] = r3
            byte[] r12 = f34596f
            if (r1 != r12) goto L_0x0097
            int r12 = r4 + 1
            r10[r4] = r2
            int r1 = r12 + 1
            r13.f34666c = r1
            r10[r12] = r2
        L_0x0097:
            int r12 = r13.f34669f
            int r1 = r13.f34666c
            int r11 = r1 - r11
            int r12 = r12 + r11
            r13.f34669f = r12
            int r11 = r9.f34662c
            if (r11 <= 0) goto L_0x0122
            if (r12 <= 0) goto L_0x0122
            byte[] r11 = r9.f34600j
            int r12 = r11.length
            java.lang.System.arraycopy(r11, r0, r10, r1, r12)
            int r10 = r13.f34666c
            byte[] r11 = r9.f34600j
            int r11 = r11.length
            int r10 = r10 + r11
            r13.f34666c = r10
            goto L_0x0122
        L_0x00b5:
            r2 = 0
        L_0x00b6:
            if (r2 >= r12) goto L_0x0122
            int r3 = r9.f34601k
            byte[] r3 = r9.a(r3, r13)
            int r4 = r13.f34670g
            int r4 = r4 + r1
            int r4 = r4 % 3
            r13.f34670g = r4
            int r5 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x00cd
            int r11 = r11 + 256
        L_0x00cd:
            int r6 = r13.f34664a
            int r6 = r6 << 8
            int r6 = r6 + r11
            r13.f34664a = r6
            if (r4 != 0) goto L_0x011e
            int r11 = r13.f34666c
            int r4 = r11 + 1
            byte[] r7 = r9.f34599i
            int r8 = r6 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r4 + 1
            int r8 = r6 >> 12
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r4] = r8
            int r4 = r11 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r4 + 1
            r13.f34666c = r11
            r6 = r6 & 63
            byte r6 = r7[r6]
            r3[r4] = r6
            int r4 = r13.f34669f
            int r4 = r4 + 4
            r13.f34669f = r4
            int r6 = r9.f34662c
            if (r6 <= 0) goto L_0x011e
            if (r6 > r4) goto L_0x011e
            byte[] r4 = r9.f34600j
            int r6 = r4.length
            java.lang.System.arraycopy(r4, r0, r3, r11, r6)
            int r11 = r13.f34666c
            byte[] r3 = r9.f34600j
            int r3 = r3.length
            int r11 = r11 + r3
            r13.f34666c = r11
            r13.f34669f = r0
        L_0x011e:
            int r2 = r2 + 1
            r11 = r5
            goto L_0x00b6
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.gf.a(byte[], int, int, com.startapp.hf$a):void");
    }
}

package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f28866a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28867b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28868c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28869d;

    /* renamed from: e  reason: collision with root package name */
    public final float f28870e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28871f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28872g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28873h;

    /* renamed from: i  reason: collision with root package name */
    public final String f28874i;

    private HevcConfig(List<byte[]> list, int i2, int i3, int i4, float f2, String str, int i5, int i6, int i7) {
        this.f28866a = list;
        this.f28867b = i2;
        this.f28868c = i3;
        this.f28869d = i4;
        this.f28870e = f2;
        this.f28874i = str;
        this.f28871f = i5;
        this.f28872g = i6;
        this.f28873h = i7;
    }

    public static HevcConfig a(ParsableByteArray parsableByteArray) throws ParserException {
        List list;
        int i2;
        int i3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        try {
            parsableByteArray2.V(21);
            int H = parsableByteArray.H() & 3;
            int H2 = parsableByteArray.H();
            int f2 = parsableByteArray.f();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < H2; i6++) {
                parsableByteArray2.V(1);
                int N = parsableByteArray.N();
                for (int i7 = 0; i7 < N; i7++) {
                    int N2 = parsableByteArray.N();
                    i5 += N2 + 4;
                    parsableByteArray2.V(N2);
                }
            }
            parsableByteArray2.U(f2);
            byte[] bArr = new byte[i5];
            String str = null;
            int i8 = 0;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            float f3 = 1.0f;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            while (i8 < H2) {
                int H3 = parsableByteArray.H() & 63;
                int N3 = parsableByteArray.N();
                int i15 = 0;
                while (i15 < N3) {
                    int N4 = parsableByteArray.N();
                    byte[] bArr2 = NalUnitUtil.f28716a;
                    int i16 = H2;
                    System.arraycopy(bArr2, i4, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), bArr, length, N4);
                    if (H3 == 33 && i15 == 0) {
                        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(bArr, length, length + N4);
                        int i17 = h2.f28727h;
                        i11 = h2.f28728i;
                        int i18 = h2.f28730k;
                        int i19 = h2.f28731l;
                        int i20 = h2.f28732m;
                        float f4 = h2.f28729j;
                        i3 = H3;
                        i2 = N3;
                        i10 = i17;
                        i14 = i20;
                        str = CodecSpecificDataUtil.c(h2.f28720a, h2.f28721b, h2.f28722c, h2.f28723d, h2.f28724e, h2.f28725f);
                        int i21 = i18;
                        i13 = i19;
                        f3 = f4;
                        i12 = i21;
                    } else {
                        i3 = H3;
                        i2 = N3;
                    }
                    i9 = length + N4;
                    parsableByteArray2.V(N4);
                    i15++;
                    H2 = i16;
                    H3 = i3;
                    N3 = i2;
                    i4 = 0;
                }
                int i22 = H2;
                i8++;
                i4 = 0;
            }
            if (i5 == 0) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(bArr);
            }
            return new HevcConfig(list, H + 1, i10, i11, f3, str, i12, i13, i14);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a("Error parsing HEVC config", e2);
        }
    }
}

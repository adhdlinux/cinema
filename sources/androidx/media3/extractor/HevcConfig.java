package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f8038a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8039b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8040c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8041d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8042e;

    /* renamed from: f  reason: collision with root package name */
    public final int f8043f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8044g;

    /* renamed from: h  reason: collision with root package name */
    public final int f8045h;

    /* renamed from: i  reason: collision with root package name */
    public final int f8046i;

    /* renamed from: j  reason: collision with root package name */
    public final float f8047j;

    /* renamed from: k  reason: collision with root package name */
    public final int f8048k;

    /* renamed from: l  reason: collision with root package name */
    public final String f8049l;

    private HevcConfig(List<byte[]> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f2, int i10, String str) {
        this.f8038a = list;
        this.f8039b = i2;
        this.f8040c = i3;
        this.f8041d = i4;
        this.f8042e = i5;
        this.f8043f = i6;
        this.f8044g = i7;
        this.f8045h = i8;
        this.f8046i = i9;
        this.f8047j = f2;
        this.f8048k = i10;
        this.f8049l = str;
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
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            float f3 = 1.0f;
            int i17 = -1;
            while (i8 < H2) {
                int H3 = parsableByteArray.H() & 63;
                int N3 = parsableByteArray.N();
                int i18 = 0;
                while (i18 < N3) {
                    int N4 = parsableByteArray.N();
                    byte[] bArr2 = NalUnitUtil.f4748a;
                    int i19 = H2;
                    System.arraycopy(bArr2, i4, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), bArr, length, N4);
                    if (H3 == 33 && i18 == 0) {
                        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(bArr, length, length + N4);
                        int i20 = h2.f4762k;
                        i11 = h2.f4763l;
                        i12 = h2.f4757f + 8;
                        i13 = h2.f4758g + 8;
                        int i21 = h2.f4766o;
                        int i22 = h2.f4767p;
                        int i23 = h2.f4768q;
                        float f4 = h2.f4764m;
                        int i24 = h2.f4765n;
                        i3 = H3;
                        i2 = N3;
                        i10 = i20;
                        str = CodecSpecificDataUtil.c(h2.f4752a, h2.f4753b, h2.f4754c, h2.f4755d, h2.f4759h, h2.f4760i);
                        int i25 = i23;
                        i15 = i22;
                        i14 = i21;
                        i17 = i24;
                        f3 = f4;
                        i16 = i25;
                    } else {
                        i3 = H3;
                        i2 = N3;
                    }
                    i9 = length + N4;
                    parsableByteArray2.V(N4);
                    i18++;
                    H2 = i19;
                    H3 = i3;
                    N3 = i2;
                    i4 = 0;
                }
                int i26 = H2;
                i8++;
                i4 = 0;
            }
            if (i5 == 0) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(bArr);
            }
            return new HevcConfig(list, H + 1, i10, i11, i12, i13, i14, i15, i16, f3, i17, str);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a("Error parsing HEVC config", e2);
        }
    }
}

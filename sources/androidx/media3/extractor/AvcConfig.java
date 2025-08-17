package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f7917a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7918b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7919c;

    /* renamed from: d  reason: collision with root package name */
    public final int f7920d;

    /* renamed from: e  reason: collision with root package name */
    public final int f7921e;

    /* renamed from: f  reason: collision with root package name */
    public final int f7922f;

    /* renamed from: g  reason: collision with root package name */
    public final int f7923g;

    /* renamed from: h  reason: collision with root package name */
    public final int f7924h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7925i;

    /* renamed from: j  reason: collision with root package name */
    public final int f7926j;

    /* renamed from: k  reason: collision with root package name */
    public final float f7927k;

    /* renamed from: l  reason: collision with root package name */
    public final String f7928l;

    private AvcConfig(List<byte[]> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f2, String str) {
        this.f7917a = list;
        this.f7918b = i2;
        this.f7919c = i3;
        this.f7920d = i4;
        this.f7921e = i5;
        this.f7922f = i6;
        this.f7923g = i7;
        this.f7924h = i8;
        this.f7925i = i9;
        this.f7926j = i10;
        this.f7927k = f2;
        this.f7928l = str;
    }

    private static byte[] a(ParsableByteArray parsableByteArray) {
        int N = parsableByteArray.N();
        int f2 = parsableByteArray.f();
        parsableByteArray.V(N);
        return CodecSpecificDataUtil.d(parsableByteArray.e(), f2, N);
    }

    public static AvcConfig b(ParsableByteArray parsableByteArray) throws ParserException {
        String str;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        try {
            parsableByteArray.V(4);
            int H = (parsableByteArray.H() & 3) + 1;
            if (H != 3) {
                ArrayList arrayList = new ArrayList();
                int H2 = parsableByteArray.H() & 31;
                for (int i10 = 0; i10 < H2; i10++) {
                    arrayList.add(a(parsableByteArray));
                }
                int H3 = parsableByteArray.H();
                for (int i11 = 0; i11 < H3; i11++) {
                    arrayList.add(a(parsableByteArray));
                }
                if (H2 > 0) {
                    NalUnitUtil.SpsData l2 = NalUnitUtil.l((byte[]) arrayList.get(0), H, ((byte[]) arrayList.get(0)).length);
                    int i12 = l2.f4777f;
                    int i13 = l2.f4778g;
                    int i14 = l2.f4788q;
                    int i15 = l2.f4789r;
                    int i16 = l2.f4790s;
                    int i17 = l2.f4791t;
                    float f3 = l2.f4779h;
                    str = CodecSpecificDataUtil.a(l2.f4772a, l2.f4773b, l2.f4774c);
                    i3 = i16;
                    i2 = i17;
                    f2 = f3;
                    i6 = l2.f4781j + 8;
                    i5 = i14;
                    i4 = i15;
                    i9 = i12;
                    i8 = i13;
                    i7 = l2.f4780i + 8;
                } else {
                    str = null;
                    i9 = -1;
                    i8 = -1;
                    i7 = -1;
                    i6 = -1;
                    i5 = -1;
                    i4 = -1;
                    i3 = -1;
                    i2 = 16;
                    f2 = 1.0f;
                }
                return new AvcConfig(arrayList, H, i9, i8, i7, i6, i5, i4, i3, i2, f2, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a("Error parsing AVC config", e2);
        }
    }
}

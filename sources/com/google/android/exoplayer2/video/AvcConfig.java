package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f28832a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28833b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28834c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28835d;

    /* renamed from: e  reason: collision with root package name */
    public final float f28836e;

    /* renamed from: f  reason: collision with root package name */
    public final String f28837f;

    private AvcConfig(List<byte[]> list, int i2, int i3, int i4, float f2, String str) {
        this.f28832a = list;
        this.f28833b = i2;
        this.f28834c = i3;
        this.f28835d = i4;
        this.f28836e = f2;
        this.f28837f = str;
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
        try {
            parsableByteArray.V(4);
            int H = (parsableByteArray.H() & 3) + 1;
            if (H != 3) {
                ArrayList arrayList = new ArrayList();
                int H2 = parsableByteArray.H() & 31;
                for (int i4 = 0; i4 < H2; i4++) {
                    arrayList.add(a(parsableByteArray));
                }
                int H3 = parsableByteArray.H();
                for (int i5 = 0; i5 < H3; i5++) {
                    arrayList.add(a(parsableByteArray));
                }
                if (H2 > 0) {
                    NalUnitUtil.SpsData l2 = NalUnitUtil.l((byte[]) arrayList.get(0), H, ((byte[]) arrayList.get(0)).length);
                    int i6 = l2.f28741f;
                    int i7 = l2.f28742g;
                    float f3 = l2.f28743h;
                    str = CodecSpecificDataUtil.a(l2.f28736a, l2.f28737b, l2.f28738c);
                    i3 = i6;
                    i2 = i7;
                    f2 = f3;
                } else {
                    str = null;
                    i3 = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new AvcConfig(arrayList, H, i3, i2, f2, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a("Error parsing AVC config", e2);
        }
    }
}

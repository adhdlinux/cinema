package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.util.ArrayList;
import java.util.zip.Inflater;

final class ProjectionDecoder {
    private ProjectionDecoder() {
    }

    public static Projection a(byte[] bArr, int i2) {
        ArrayList<Projection.Mesh> arrayList;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            if (c(parsableByteArray)) {
                arrayList = f(parsableByteArray);
            } else {
                arrayList = e(parsableByteArray);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new Projection(arrayList.get(0), i2);
        }
        if (size != 2) {
            return null;
        }
        return new Projection(arrayList.get(0), arrayList.get(1), i2);
    }

    private static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >> 1);
    }

    private static boolean c(ParsableByteArray parsableByteArray) {
        parsableByteArray.V(4);
        int q2 = parsableByteArray.q();
        parsableByteArray.U(0);
        if (q2 == 1886547818) {
            return true;
        }
        return false;
    }

    private static Projection.Mesh d(ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        if (q2 > 10000) {
            return null;
        }
        float[] fArr = new float[q2];
        for (int i2 = 0; i2 < q2; i2++) {
            fArr[i2] = parsableByteArray.p();
        }
        int q3 = parsableByteArray.q();
        if (q3 > 32000) {
            return null;
        }
        double d2 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(((double) q2) * 2.0d) / log);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.e());
        int i3 = 8;
        parsableBitArray.p(parsableByteArray.f() * 8);
        float[] fArr2 = new float[(q3 * 5)];
        int i4 = 5;
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < q3) {
            int i7 = 0;
            while (i7 < i4) {
                int b2 = iArr[i7] + b(parsableBitArray.h(ceil));
                if (b2 >= q2 || b2 < 0) {
                    return null;
                }
                fArr2[i6] = fArr[b2];
                iArr[i7] = b2;
                i7++;
                i6++;
                i4 = 5;
            }
            i5++;
            i4 = 5;
        }
        parsableBitArray.p((parsableBitArray.e() + 7) & -8);
        int i8 = 32;
        int h2 = parsableBitArray.h(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[h2];
        int i9 = 0;
        while (i9 < h2) {
            int h3 = parsableBitArray.h(i3);
            int h4 = parsableBitArray.h(i3);
            int h5 = parsableBitArray.h(i8);
            if (h5 > 128000) {
                return null;
            }
            int i10 = h3;
            int ceil2 = (int) Math.ceil(Math.log(((double) q3) * d2) / log);
            float[] fArr3 = new float[(h5 * 3)];
            float[] fArr4 = new float[(h5 * 2)];
            int i11 = 0;
            for (int i12 = 0; i12 < h5; i12++) {
                i11 += b(parsableBitArray.h(ceil2));
                if (i11 < 0 || i11 >= q3) {
                    return null;
                }
                int i13 = i12 * 3;
                int i14 = i11 * 5;
                fArr3[i13] = fArr2[i14];
                fArr3[i13 + 1] = fArr2[i14 + 1];
                fArr3[i13 + 2] = fArr2[i14 + 2];
                int i15 = i12 * 2;
                fArr4[i15] = fArr2[i14 + 3];
                fArr4[i15 + 1] = fArr2[i14 + 4];
            }
            subMeshArr[i9] = new Projection.SubMesh(i10, fArr3, fArr4, h4);
            i9++;
            i8 = 32;
            d2 = 2.0d;
            i3 = 8;
        }
        return new Projection.Mesh(subMeshArr);
    }

    private static ArrayList<Projection.Mesh> e(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.H() != 0) {
            return null;
        }
        parsableByteArray.V(7);
        int q2 = parsableByteArray.q();
        if (q2 == 1684433976) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.t0(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (q2 != 1918990112) {
            return null;
        }
        return g(parsableByteArray);
    }

    private static ArrayList<Projection.Mesh> f(ParsableByteArray parsableByteArray) {
        int q2;
        parsableByteArray.V(8);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2 && (q2 = parsableByteArray.q() + f2) > f2 && q2 <= g2) {
            int q3 = parsableByteArray.q();
            if (q3 == 2037673328 || q3 == 1836279920) {
                parsableByteArray.T(q2);
                return e(parsableByteArray);
            }
            parsableByteArray.U(q2);
            f2 = q2;
        }
        return null;
    }

    private static ArrayList<Projection.Mesh> g(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.Mesh> arrayList = new ArrayList<>();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2) {
            int q2 = parsableByteArray.q() + f2;
            if (q2 <= f2 || q2 > g2) {
                return null;
            }
            if (parsableByteArray.q() == 1835365224) {
                Projection.Mesh d2 = d(parsableByteArray);
                if (d2 == null) {
                    return null;
                }
                arrayList.add(d2);
            }
            parsableByteArray.U(q2);
            f2 = q2;
        }
        return arrayList;
    }
}

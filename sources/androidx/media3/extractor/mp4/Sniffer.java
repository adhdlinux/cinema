package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;
import java.io.IOException;

final class Sniffer {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f8659a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private Sniffer() {
    }

    private static boolean a(int i2, boolean z2) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        if (i2 == 1751476579 && z2) {
            return true;
        }
        for (int i3 : f8659a) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static SniffFailure b(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, true, false);
    }

    private static SniffFailure c(ExtractorInput extractorInput, boolean z2, boolean z3) throws IOException {
        boolean z4;
        int i2;
        long j2;
        boolean z5;
        int[] iArr;
        ExtractorInput extractorInput2 = extractorInput;
        boolean z6 = z3;
        long length = extractorInput.getLength();
        long j3 = 4096;
        long j4 = -1;
        int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i3 != 0 && length <= 4096) {
            j3 = length;
        }
        int i4 = (int) j3;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i5 = 0;
        int i6 = 0;
        boolean z7 = false;
        while (true) {
            if (i6 >= i4) {
                break;
            }
            parsableByteArray.Q(8);
            if (!extractorInput2.c(parsableByteArray.e(), i5, 8, true)) {
                break;
            }
            long J = parsableByteArray.J();
            int q2 = parsableByteArray.q();
            if (J == 1) {
                extractorInput2.m(parsableByteArray.e(), 8, 8);
                i2 = 16;
                parsableByteArray.T(16);
                j2 = parsableByteArray.A();
            } else {
                if (J == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j4) {
                        J = (length2 - extractorInput.g()) + ((long) 8);
                    }
                }
                j2 = J;
                i2 = 8;
            }
            long j5 = (long) i2;
            if (j2 < j5) {
                return new AtomSizeTooSmallSniffFailure(q2, j2, i2);
            }
            i6 += i2;
            if (q2 == 1836019574) {
                i4 += (int) j2;
                if (i3 != 0 && ((long) i4) > length) {
                    i4 = (int) length;
                }
                j4 = -1;
            } else if (q2 == 1836019558 || q2 == 1836475768) {
                z4 = true;
            } else {
                long j6 = length;
                if (q2 == 1835295092) {
                    z7 = true;
                }
                int i7 = i6;
                if ((((long) i6) + j2) - j5 >= ((long) i4)) {
                    break;
                }
                int i8 = (int) (j2 - j5);
                i6 = i7 + i8;
                if (q2 == 1718909296) {
                    if (i8 < 8) {
                        return new AtomSizeTooSmallSniffFailure(q2, (long) i8, 8);
                    }
                    parsableByteArray.Q(i8);
                    extractorInput2.m(parsableByteArray.e(), 0, i8);
                    int q3 = parsableByteArray.q();
                    if (a(q3, z6)) {
                        z7 = true;
                    }
                    parsableByteArray.V(4);
                    int a2 = parsableByteArray.a() / 4;
                    if (!z7 && a2 > 0) {
                        iArr = new int[a2];
                        int i9 = 0;
                        while (true) {
                            if (i9 >= a2) {
                                z5 = z7;
                                break;
                            }
                            int q4 = parsableByteArray.q();
                            iArr[i9] = q4;
                            if (a(q4, z6)) {
                                z5 = true;
                                break;
                            }
                            i9++;
                        }
                    } else {
                        z5 = z7;
                        iArr = null;
                    }
                    if (!z5) {
                        return new UnsupportedBrandsSniffFailure(q3, iArr);
                    }
                    z7 = z5;
                } else if (i8 != 0) {
                    extractorInput2.h(i8);
                }
                length = j6;
                j4 = -1;
                i5 = 0;
            }
        }
        z4 = false;
        if (!z7) {
            return NoDeclaredBrandSniffFailure.f8646a;
        }
        if (z2 == z4) {
            return null;
        }
        if (z4) {
            return IncorrectFragmentationSniffFailure.f8612b;
        }
        return IncorrectFragmentationSniffFailure.f8613c;
    }

    public static SniffFailure d(ExtractorInput extractorInput, boolean z2) throws IOException {
        return c(extractorInput, false, z2);
    }
}

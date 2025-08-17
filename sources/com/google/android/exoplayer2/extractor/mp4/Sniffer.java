package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f24658a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private Sniffer() {
    }

    private static boolean a(int i2, boolean z2) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        if (i2 == 1751476579 && z2) {
            return true;
        }
        for (int i3 : f24658a) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, true, false);
    }

    private static boolean c(ExtractorInput extractorInput, boolean z2, boolean z3) throws IOException {
        boolean z4;
        boolean z5;
        int i2;
        ExtractorInput extractorInput2 = extractorInput;
        long length = extractorInput.getLength();
        long j2 = 4096;
        long j3 = -1;
        int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i3 != 0 && length <= 4096) {
            j2 = length;
        }
        int i4 = (int) j2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z6 = false;
        int i5 = 0;
        boolean z7 = false;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            parsableByteArray.Q(8);
            if (!extractorInput2.c(parsableByteArray.e(), z6 ? 1 : 0, 8, true)) {
                break;
            }
            long J = parsableByteArray.J();
            int q2 = parsableByteArray.q();
            if (J == 1) {
                extractorInput2.m(parsableByteArray.e(), 8, 8);
                parsableByteArray.T(16);
                J = parsableByteArray.A();
                i2 = 16;
            } else {
                if (J == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j3) {
                        J = (length2 - extractorInput.g()) + ((long) 8);
                    }
                }
                i2 = 8;
            }
            long j4 = (long) i2;
            if (J < j4) {
                return z6;
            }
            i5 += i2;
            if (q2 == 1836019574) {
                i4 += (int) J;
                if (i3 != 0 && ((long) i4) > length) {
                    i4 = (int) length;
                }
                j3 = -1;
            } else if (q2 == 1836019558 || q2 == 1836475768) {
                z4 = true;
                z5 = true;
            } else {
                int i6 = i3;
                int i7 = i5;
                if ((((long) i5) + J) - j4 >= ((long) i4)) {
                    break;
                }
                int i8 = (int) (J - j4);
                i5 = i7 + i8;
                if (q2 != 1718909296) {
                    boolean z8 = z3;
                    if (i8 != 0) {
                        extractorInput2.h(i8);
                    }
                } else if (i8 < 8) {
                    return false;
                } else {
                    parsableByteArray.Q(i8);
                    extractorInput2.m(parsableByteArray.e(), 0, i8);
                    int i9 = i8 / 4;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= i9) {
                            boolean z9 = z3;
                            break;
                        }
                        if (i10 == 1) {
                            parsableByteArray.V(4);
                            boolean z10 = z3;
                        } else if (a(parsableByteArray.q(), z3)) {
                            z7 = true;
                            break;
                        }
                        i10++;
                    }
                    if (!z7) {
                        return false;
                    }
                }
                i3 = i6;
                j3 = -1;
                z6 = false;
            }
        }
        z4 = true;
        z5 = false;
        if (!z7 || z2 != z5) {
            return false;
        }
        return z4;
    }

    public static boolean d(ExtractorInput extractorInput, boolean z2) throws IOException {
        return c(extractorInput, false, z2);
    }
}

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class CeaUtil {
    private CeaUtil() {
    }

    public static void a(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int i2;
        boolean z2;
        while (true) {
            boolean z3 = true;
            if (parsableByteArray.a() > 1) {
                int c2 = c(parsableByteArray);
                int c3 = c(parsableByteArray);
                int f2 = parsableByteArray.f() + c3;
                if (c3 == -1 || c3 > parsableByteArray.a()) {
                    Log.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    f2 = parsableByteArray.g();
                } else if (c2 == 4 && c3 >= 8) {
                    int H = parsableByteArray.H();
                    int N = parsableByteArray.N();
                    if (N == 49) {
                        i2 = parsableByteArray.q();
                    } else {
                        i2 = 0;
                    }
                    int H2 = parsableByteArray.H();
                    if (N == 47) {
                        parsableByteArray.V(1);
                    }
                    if (H == 181 && ((N == 49 || N == 47) && H2 == 3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (N == 49) {
                        if (i2 != 1195456820) {
                            z3 = false;
                        }
                        z2 &= z3;
                    }
                    if (z2) {
                        b(j2, parsableByteArray, trackOutputArr);
                    }
                }
                parsableByteArray.U(f2);
            } else {
                return;
            }
        }
    }

    public static void b(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        boolean z2;
        int H = parsableByteArray.H();
        if ((H & 64) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            parsableByteArray.V(1);
            int i2 = (H & 31) * 3;
            int f2 = parsableByteArray.f();
            for (TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.U(f2);
                trackOutput.c(parsableByteArray, i2);
                if (j2 != -9223372036854775807L) {
                    trackOutput.e(j2, 1, i2, 0, (TrackOutput.CryptoData) null);
                }
            }
        }
    }

    private static int c(ParsableByteArray parsableByteArray) {
        int i2 = 0;
        while (parsableByteArray.a() != 0) {
            int H = parsableByteArray.H();
            i2 += H;
            if (H != 255) {
                return i2;
            }
        }
        return -1;
    }
}

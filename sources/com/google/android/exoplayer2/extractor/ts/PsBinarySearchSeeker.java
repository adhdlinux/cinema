package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class PsBinarySearchSeeker extends BinarySearchSeeker {

    private static final class PsScrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a  reason: collision with root package name */
        private final TimestampAdjuster f25039a;

        /* renamed from: b  reason: collision with root package name */
        private final ParsableByteArray f25040b;

        private BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j2, long j3) {
            int i2 = -1;
            long j4 = -9223372036854775807L;
            int i3 = -1;
            while (parsableByteArray.a() >= 4) {
                if (PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f()) != 442) {
                    parsableByteArray.V(1);
                } else {
                    parsableByteArray.V(4);
                    long l2 = PsDurationReader.l(parsableByteArray);
                    if (l2 != -9223372036854775807L) {
                        long b2 = this.f25039a.b(l2);
                        if (b2 > j2) {
                            if (j4 == -9223372036854775807L) {
                                return BinarySearchSeeker.TimestampSearchResult.d(b2, j3);
                            }
                            return BinarySearchSeeker.TimestampSearchResult.e(j3 + ((long) i3));
                        } else if (100000 + b2 > j2) {
                            return BinarySearchSeeker.TimestampSearchResult.e(j3 + ((long) parsableByteArray.f()));
                        } else {
                            i3 = parsableByteArray.f();
                            j4 = b2;
                        }
                    }
                    d(parsableByteArray);
                    i2 = parsableByteArray.f();
                }
            }
            if (j4 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.f(j4, j3 + ((long) i2));
            }
            return BinarySearchSeeker.TimestampSearchResult.f24158d;
        }

        private static void d(ParsableByteArray parsableByteArray) {
            int g2 = parsableByteArray.g();
            if (parsableByteArray.a() < 10) {
                parsableByteArray.U(g2);
                return;
            }
            parsableByteArray.V(9);
            int H = parsableByteArray.H() & 7;
            if (parsableByteArray.a() < H) {
                parsableByteArray.U(g2);
                return;
            }
            parsableByteArray.V(H);
            if (parsableByteArray.a() < 4) {
                parsableByteArray.U(g2);
                return;
            }
            if (PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f()) == 443) {
                parsableByteArray.V(4);
                int N = parsableByteArray.N();
                if (parsableByteArray.a() < N) {
                    parsableByteArray.U(g2);
                    return;
                }
                parsableByteArray.V(N);
            }
            while (parsableByteArray.a() >= 4 && (r1 = PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                parsableByteArray.V(4);
                if (parsableByteArray.a() < 2) {
                    parsableByteArray.U(g2);
                    return;
                } else {
                    parsableByteArray.U(Math.min(parsableByteArray.g(), parsableByteArray.f() + parsableByteArray.N()));
                }
            }
        }

        public void a() {
            this.f25040b.R(Util.f28813f);
        }

        public BinarySearchSeeker.TimestampSearchResult b(ExtractorInput extractorInput, long j2) throws IOException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min(20000, extractorInput.getLength() - position);
            this.f25040b.Q(min);
            extractorInput.m(this.f25040b.e(), 0, min);
            return c(this.f25040b, j2, position);
        }

        private PsScrSeeker(TimestampAdjuster timestampAdjuster) {
            this.f25039a = timestampAdjuster;
            this.f25040b = new ParsableByteArray();
        }
    }

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j2, long j3) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster), j2, 0, j2 + 1, 0, j3, 188, 1000);
    }

    /* access modifiers changed from: private */
    public static int k(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}

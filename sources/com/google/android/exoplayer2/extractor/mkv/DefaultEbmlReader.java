package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class DefaultEbmlReader implements EbmlReader {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24415a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<MasterElement> f24416b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final VarintReader f24417c = new VarintReader();

    /* renamed from: d  reason: collision with root package name */
    private EbmlProcessor f24418d;

    /* renamed from: e  reason: collision with root package name */
    private int f24419e;

    /* renamed from: f  reason: collision with root package name */
    private int f24420f;

    /* renamed from: g  reason: collision with root package name */
    private long f24421g;

    private static final class MasterElement {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f24422a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f24423b;

        private MasterElement(int i2, long j2) {
            this.f24422a = i2;
            this.f24423b = j2;
        }
    }

    @RequiresNonNull({"processor"})
    private long c(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        while (true) {
            extractorInput.m(this.f24415a, 0, 4);
            int c2 = VarintReader.c(this.f24415a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) VarintReader.a(this.f24415a, c2, false);
                if (this.f24418d.e(a2)) {
                    extractorInput.k(c2);
                    return (long) a2;
                }
            }
            extractorInput.k(1);
        }
    }

    private double d(ExtractorInput extractorInput, int i2) throws IOException {
        long e2 = e(extractorInput, i2);
        if (i2 == 4) {
            return (double) Float.intBitsToFloat((int) e2);
        }
        return Double.longBitsToDouble(e2);
    }

    private long e(ExtractorInput extractorInput, int i2) throws IOException {
        extractorInput.readFully(this.f24415a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.f24415a[i3] & 255));
        }
        return j2;
    }

    private static String f(ExtractorInput extractorInput, int i2) throws IOException {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        extractorInput.readFully(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    public boolean a(ExtractorInput extractorInput) throws IOException {
        Assertions.i(this.f24418d);
        while (true) {
            MasterElement peek = this.f24416b.peek();
            if (peek == null || extractorInput.getPosition() < peek.f24423b) {
                if (this.f24419e == 0) {
                    long d2 = this.f24417c.d(extractorInput, true, false, 4);
                    if (d2 == -2) {
                        d2 = c(extractorInput);
                    }
                    if (d2 == -1) {
                        return false;
                    }
                    this.f24420f = (int) d2;
                    this.f24419e = 1;
                }
                if (this.f24419e == 1) {
                    this.f24421g = this.f24417c.d(extractorInput, false, true, 8);
                    this.f24419e = 2;
                }
                int d3 = this.f24418d.d(this.f24420f);
                if (d3 == 0) {
                    extractorInput.k((int) this.f24421g);
                    this.f24419e = 0;
                } else if (d3 == 1) {
                    long position = extractorInput.getPosition();
                    this.f24416b.push(new MasterElement(this.f24420f, this.f24421g + position));
                    this.f24418d.g(this.f24420f, position, this.f24421g);
                    this.f24419e = 0;
                    return true;
                } else if (d3 == 2) {
                    long j2 = this.f24421g;
                    if (j2 <= 8) {
                        this.f24418d.c(this.f24420f, e(extractorInput, (int) j2));
                        this.f24419e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid integer size: " + this.f24421g, (Throwable) null);
                } else if (d3 == 3) {
                    long j3 = this.f24421g;
                    if (j3 <= 2147483647L) {
                        this.f24418d.f(this.f24420f, f(extractorInput, (int) j3));
                        this.f24419e = 0;
                        return true;
                    }
                    throw ParserException.a("String element size: " + this.f24421g, (Throwable) null);
                } else if (d3 == 4) {
                    this.f24418d.h(this.f24420f, (int) this.f24421g, extractorInput);
                    this.f24419e = 0;
                    return true;
                } else if (d3 == 5) {
                    long j4 = this.f24421g;
                    if (j4 == 4 || j4 == 8) {
                        this.f24418d.b(this.f24420f, d(extractorInput, (int) j4));
                        this.f24419e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid float size: " + this.f24421g, (Throwable) null);
                } else {
                    throw ParserException.a("Invalid element type " + d3, (Throwable) null);
                }
            } else {
                this.f24418d.a(this.f24416b.pop().f24422a);
                return true;
            }
        }
    }

    public void b(EbmlProcessor ebmlProcessor) {
        this.f24418d = ebmlProcessor;
    }

    public void reset() {
        this.f24419e = 0;
        this.f24416b.clear();
        this.f24417c.e();
    }
}

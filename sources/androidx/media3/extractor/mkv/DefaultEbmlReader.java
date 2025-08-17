package androidx.media3.extractor.mkv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class DefaultEbmlReader implements EbmlReader {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f8395a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<MasterElement> f8396b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final VarintReader f8397c = new VarintReader();

    /* renamed from: d  reason: collision with root package name */
    private EbmlProcessor f8398d;

    /* renamed from: e  reason: collision with root package name */
    private int f8399e;

    /* renamed from: f  reason: collision with root package name */
    private int f8400f;

    /* renamed from: g  reason: collision with root package name */
    private long f8401g;

    private static final class MasterElement {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f8402a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f8403b;

        private MasterElement(int i2, long j2) {
            this.f8402a = i2;
            this.f8403b = j2;
        }
    }

    @RequiresNonNull({"processor"})
    private long c(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        while (true) {
            extractorInput.m(this.f8395a, 0, 4);
            int c2 = VarintReader.c(this.f8395a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) VarintReader.a(this.f8395a, c2, false);
                if (this.f8398d.e(a2)) {
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
        extractorInput.readFully(this.f8395a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.f8395a[i3] & 255));
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
        Assertions.j(this.f8398d);
        while (true) {
            MasterElement peek = this.f8396b.peek();
            if (peek == null || extractorInput.getPosition() < peek.f8403b) {
                if (this.f8399e == 0) {
                    long d2 = this.f8397c.d(extractorInput, true, false, 4);
                    if (d2 == -2) {
                        d2 = c(extractorInput);
                    }
                    if (d2 == -1) {
                        return false;
                    }
                    this.f8400f = (int) d2;
                    this.f8399e = 1;
                }
                if (this.f8399e == 1) {
                    this.f8401g = this.f8397c.d(extractorInput, false, true, 8);
                    this.f8399e = 2;
                }
                int d3 = this.f8398d.d(this.f8400f);
                if (d3 == 0) {
                    extractorInput.k((int) this.f8401g);
                    this.f8399e = 0;
                } else if (d3 == 1) {
                    long position = extractorInput.getPosition();
                    this.f8396b.push(new MasterElement(this.f8400f, this.f8401g + position));
                    this.f8398d.g(this.f8400f, position, this.f8401g);
                    this.f8399e = 0;
                    return true;
                } else if (d3 == 2) {
                    long j2 = this.f8401g;
                    if (j2 <= 8) {
                        this.f8398d.c(this.f8400f, e(extractorInput, (int) j2));
                        this.f8399e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid integer size: " + this.f8401g, (Throwable) null);
                } else if (d3 == 3) {
                    long j3 = this.f8401g;
                    if (j3 <= 2147483647L) {
                        this.f8398d.f(this.f8400f, f(extractorInput, (int) j3));
                        this.f8399e = 0;
                        return true;
                    }
                    throw ParserException.a("String element size: " + this.f8401g, (Throwable) null);
                } else if (d3 == 4) {
                    this.f8398d.h(this.f8400f, (int) this.f8401g, extractorInput);
                    this.f8399e = 0;
                    return true;
                } else if (d3 == 5) {
                    long j4 = this.f8401g;
                    if (j4 == 4 || j4 == 8) {
                        this.f8398d.b(this.f8400f, d(extractorInput, (int) j4));
                        this.f8399e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid float size: " + this.f8401g, (Throwable) null);
                } else {
                    throw ParserException.a("Invalid element type " + d3, (Throwable) null);
                }
            } else {
                this.f8398d.a(this.f8396b.pop().f8402a);
                return true;
            }
        }
    }

    public void b(EbmlProcessor ebmlProcessor) {
        this.f8398d = ebmlProcessor;
    }

    public void reset() {
        this.f8399e = 0;
        this.f8396b.clear();
        this.f8397c.e();
    }
}

package androidx.media3.exoplayer.source;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import com.startapp.y1;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {

    /* renamed from: a  reason: collision with root package name */
    private final Allocator f7072a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7073b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f7074c = new ParsableByteArray(32);

    /* renamed from: d  reason: collision with root package name */
    private AllocationNode f7075d;

    /* renamed from: e  reason: collision with root package name */
    private AllocationNode f7076e;

    /* renamed from: f  reason: collision with root package name */
    private AllocationNode f7077f;

    /* renamed from: g  reason: collision with root package name */
    private long f7078g;

    private static final class AllocationNode implements Allocator.AllocationNode {

        /* renamed from: a  reason: collision with root package name */
        public long f7079a;

        /* renamed from: b  reason: collision with root package name */
        public long f7080b;

        /* renamed from: c  reason: collision with root package name */
        public Allocation f7081c;

        /* renamed from: d  reason: collision with root package name */
        public AllocationNode f7082d;

        public AllocationNode(long j2, int i2) {
            d(j2, i2);
        }

        public Allocation a() {
            return (Allocation) Assertions.f(this.f7081c);
        }

        public AllocationNode b() {
            this.f7081c = null;
            AllocationNode allocationNode = this.f7082d;
            this.f7082d = null;
            return allocationNode;
        }

        public void c(Allocation allocation, AllocationNode allocationNode) {
            this.f7081c = allocation;
            this.f7082d = allocationNode;
        }

        public void d(long j2, int i2) {
            boolean z2;
            if (this.f7081c == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            this.f7079a = j2;
            this.f7080b = j2 + ((long) i2);
        }

        public int e(long j2) {
            return ((int) (j2 - this.f7079a)) + this.f7081c.f7481b;
        }

        public Allocator.AllocationNode next() {
            AllocationNode allocationNode = this.f7082d;
            if (allocationNode == null || allocationNode.f7081c == null) {
                return null;
            }
            return allocationNode;
        }
    }

    public SampleDataQueue(Allocator allocator) {
        this.f7072a = allocator;
        int c2 = allocator.c();
        this.f7073b = c2;
        AllocationNode allocationNode = new AllocationNode(0, c2);
        this.f7075d = allocationNode;
        this.f7076e = allocationNode;
        this.f7077f = allocationNode;
    }

    private void a(AllocationNode allocationNode) {
        if (allocationNode.f7081c != null) {
            this.f7072a.d(allocationNode);
            allocationNode.b();
        }
    }

    private static AllocationNode d(AllocationNode allocationNode, long j2) {
        while (j2 >= allocationNode.f7080b) {
            allocationNode = allocationNode.f7082d;
        }
        return allocationNode;
    }

    private void g(int i2) {
        long j2 = this.f7078g + ((long) i2);
        this.f7078g = j2;
        AllocationNode allocationNode = this.f7077f;
        if (j2 == allocationNode.f7080b) {
            this.f7077f = allocationNode.f7082d;
        }
    }

    private int h(int i2) {
        AllocationNode allocationNode = this.f7077f;
        if (allocationNode.f7081c == null) {
            allocationNode.c(this.f7072a.a(), new AllocationNode(this.f7077f.f7080b, this.f7073b));
        }
        return Math.min(i2, (int) (this.f7077f.f7080b - this.f7078g));
    }

    private static AllocationNode i(AllocationNode allocationNode, long j2, ByteBuffer byteBuffer, int i2) {
        AllocationNode d2 = d(allocationNode, j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (d2.f7080b - j2));
            byteBuffer.put(d2.f7081c.f7480a, d2.e(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == d2.f7080b) {
                d2 = d2.f7082d;
            }
        }
        return d2;
    }

    private static AllocationNode j(AllocationNode allocationNode, long j2, byte[] bArr, int i2) {
        AllocationNode d2 = d(allocationNode, j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (d2.f7080b - j2));
            System.arraycopy(d2.f7081c.f7480a, d2.e(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            if (j2 == d2.f7080b) {
                d2 = d2.f7082d;
            }
        }
        return d2;
    }

    private static AllocationNode k(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        boolean z2;
        int i2;
        SampleQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long j2 = sampleExtrasHolder2.f7110b;
        parsableByteArray2.Q(1);
        AllocationNode j3 = j(allocationNode, j2, parsableByteArray.e(), 1);
        long j4 = j2 + 1;
        byte b2 = parsableByteArray.e()[0];
        if ((b2 & y1.f36938c) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        byte b3 = b2 & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer.f5066c;
        byte[] bArr = cryptoInfo.f5053a;
        if (bArr == null) {
            cryptoInfo.f5053a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        AllocationNode j5 = j(j3, j4, cryptoInfo.f5053a, b3);
        long j6 = j4 + ((long) b3);
        if (z2) {
            parsableByteArray2.Q(2);
            j5 = j(j5, j6, parsableByteArray.e(), 2);
            j6 += 2;
            i2 = parsableByteArray.N();
        } else {
            i2 = 1;
        }
        int[] iArr = cryptoInfo.f5056d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.f5057e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z2) {
            int i3 = i2 * 6;
            parsableByteArray2.Q(i3);
            j5 = j(j5, j6, parsableByteArray.e(), i3);
            j6 += (long) i3;
            parsableByteArray2.U(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = parsableByteArray.N();
                iArr4[i4] = parsableByteArray.L();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.f7109a - ((int) (j6 - sampleExtrasHolder2.f7110b));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.i(sampleExtrasHolder2.f7111c);
        cryptoInfo.c(i2, iArr2, iArr4, cryptoData.f8087b, cryptoInfo.f5053a, cryptoData.f8086a, cryptoData.f8088c, cryptoData.f8089d);
        long j7 = sampleExtrasHolder2.f7110b;
        int i5 = (int) (j6 - j7);
        sampleExtrasHolder2.f7110b = j7 + ((long) i5);
        sampleExtrasHolder2.f7109a -= i5;
        return j5;
    }

    private static AllocationNode l(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.h()) {
            allocationNode = k(allocationNode, decoderInputBuffer, sampleExtrasHolder, parsableByteArray);
        }
        if (decoderInputBuffer.hasSupplementalData()) {
            parsableByteArray.Q(4);
            AllocationNode j2 = j(allocationNode, sampleExtrasHolder.f7110b, parsableByteArray.e(), 4);
            int L = parsableByteArray.L();
            sampleExtrasHolder.f7110b += 4;
            sampleExtrasHolder.f7109a -= 4;
            decoderInputBuffer.f(L);
            AllocationNode i2 = i(j2, sampleExtrasHolder.f7110b, decoderInputBuffer.f5067d, L);
            sampleExtrasHolder.f7110b += (long) L;
            int i3 = sampleExtrasHolder.f7109a - L;
            sampleExtrasHolder.f7109a = i3;
            decoderInputBuffer.j(i3);
            return i(i2, sampleExtrasHolder.f7110b, decoderInputBuffer.f5070g, sampleExtrasHolder.f7109a);
        }
        decoderInputBuffer.f(sampleExtrasHolder.f7109a);
        return i(allocationNode, sampleExtrasHolder.f7110b, decoderInputBuffer.f5067d, sampleExtrasHolder.f7109a);
    }

    public void b(long j2) {
        AllocationNode allocationNode;
        if (j2 != -1) {
            while (true) {
                allocationNode = this.f7075d;
                if (j2 < allocationNode.f7080b) {
                    break;
                }
                this.f7072a.e(allocationNode.f7081c);
                this.f7075d = this.f7075d.b();
            }
            if (this.f7076e.f7079a < allocationNode.f7079a) {
                this.f7076e = allocationNode;
            }
        }
    }

    public void c(long j2) {
        boolean z2;
        if (j2 <= this.f7078g) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f7078g = j2;
        if (j2 != 0) {
            AllocationNode allocationNode = this.f7075d;
            if (j2 != allocationNode.f7079a) {
                while (this.f7078g > allocationNode.f7080b) {
                    allocationNode = allocationNode.f7082d;
                }
                AllocationNode allocationNode2 = (AllocationNode) Assertions.f(allocationNode.f7082d);
                a(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.f7080b, this.f7073b);
                allocationNode.f7082d = allocationNode3;
                if (this.f7078g == allocationNode.f7080b) {
                    allocationNode = allocationNode3;
                }
                this.f7077f = allocationNode;
                if (this.f7076e == allocationNode2) {
                    this.f7076e = allocationNode3;
                    return;
                }
                return;
            }
        }
        a(this.f7075d);
        AllocationNode allocationNode4 = new AllocationNode(this.f7078g, this.f7073b);
        this.f7075d = allocationNode4;
        this.f7076e = allocationNode4;
        this.f7077f = allocationNode4;
    }

    public long e() {
        return this.f7078g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        l(this.f7076e, decoderInputBuffer, sampleExtrasHolder, this.f7074c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.f7076e = l(this.f7076e, decoderInputBuffer, sampleExtrasHolder, this.f7074c);
    }

    public void n() {
        a(this.f7075d);
        this.f7075d.d(0, this.f7073b);
        AllocationNode allocationNode = this.f7075d;
        this.f7076e = allocationNode;
        this.f7077f = allocationNode;
        this.f7078g = 0;
        this.f7072a.b();
    }

    public void o() {
        this.f7076e = this.f7075d;
    }

    public int p(DataReader dataReader, int i2, boolean z2) throws IOException {
        int h2 = h(i2);
        AllocationNode allocationNode = this.f7077f;
        int read = dataReader.read(allocationNode.f7081c.f7480a, allocationNode.e(this.f7078g), h2);
        if (read != -1) {
            g(read);
            return read;
        } else if (z2) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void q(ParsableByteArray parsableByteArray, int i2) {
        while (i2 > 0) {
            int h2 = h(i2);
            AllocationNode allocationNode = this.f7077f;
            parsableByteArray.l(allocationNode.f7081c.f7480a, allocationNode.e(this.f7078g), h2);
            i2 -= h2;
            g(h2);
        }
    }
}

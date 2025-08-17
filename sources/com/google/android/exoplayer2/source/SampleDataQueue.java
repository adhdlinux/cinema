package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.startapp.y1;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {

    /* renamed from: a  reason: collision with root package name */
    private final Allocator f25901a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25902b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f25903c = new ParsableByteArray(32);

    /* renamed from: d  reason: collision with root package name */
    private AllocationNode f25904d;

    /* renamed from: e  reason: collision with root package name */
    private AllocationNode f25905e;

    /* renamed from: f  reason: collision with root package name */
    private AllocationNode f25906f;

    /* renamed from: g  reason: collision with root package name */
    private long f25907g;

    private static final class AllocationNode implements Allocator.AllocationNode {

        /* renamed from: a  reason: collision with root package name */
        public long f25908a;

        /* renamed from: b  reason: collision with root package name */
        public long f25909b;

        /* renamed from: c  reason: collision with root package name */
        public Allocation f25910c;

        /* renamed from: d  reason: collision with root package name */
        public AllocationNode f25911d;

        public AllocationNode(long j2, int i2) {
            d(j2, i2);
        }

        public Allocation a() {
            return (Allocation) Assertions.e(this.f25910c);
        }

        public AllocationNode b() {
            this.f25910c = null;
            AllocationNode allocationNode = this.f25911d;
            this.f25911d = null;
            return allocationNode;
        }

        public void c(Allocation allocation, AllocationNode allocationNode) {
            this.f25910c = allocation;
            this.f25911d = allocationNode;
        }

        public void d(long j2, int i2) {
            boolean z2;
            if (this.f25910c == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            this.f25908a = j2;
            this.f25909b = j2 + ((long) i2);
        }

        public int e(long j2) {
            return ((int) (j2 - this.f25908a)) + this.f25910c.f28308b;
        }

        public Allocator.AllocationNode next() {
            AllocationNode allocationNode = this.f25911d;
            if (allocationNode == null || allocationNode.f25910c == null) {
                return null;
            }
            return allocationNode;
        }
    }

    public SampleDataQueue(Allocator allocator) {
        this.f25901a = allocator;
        int c2 = allocator.c();
        this.f25902b = c2;
        AllocationNode allocationNode = new AllocationNode(0, c2);
        this.f25904d = allocationNode;
        this.f25905e = allocationNode;
        this.f25906f = allocationNode;
    }

    private void a(AllocationNode allocationNode) {
        if (allocationNode.f25910c != null) {
            this.f25901a.d(allocationNode);
            allocationNode.b();
        }
    }

    private static AllocationNode d(AllocationNode allocationNode, long j2) {
        while (j2 >= allocationNode.f25909b) {
            allocationNode = allocationNode.f25911d;
        }
        return allocationNode;
    }

    private void g(int i2) {
        long j2 = this.f25907g + ((long) i2);
        this.f25907g = j2;
        AllocationNode allocationNode = this.f25906f;
        if (j2 == allocationNode.f25909b) {
            this.f25906f = allocationNode.f25911d;
        }
    }

    private int h(int i2) {
        AllocationNode allocationNode = this.f25906f;
        if (allocationNode.f25910c == null) {
            allocationNode.c(this.f25901a.a(), new AllocationNode(this.f25906f.f25909b, this.f25902b));
        }
        return Math.min(i2, (int) (this.f25906f.f25909b - this.f25907g));
    }

    private static AllocationNode i(AllocationNode allocationNode, long j2, ByteBuffer byteBuffer, int i2) {
        AllocationNode d2 = d(allocationNode, j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (d2.f25909b - j2));
            byteBuffer.put(d2.f25910c.f28307a, d2.e(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == d2.f25909b) {
                d2 = d2.f25911d;
            }
        }
        return d2;
    }

    private static AllocationNode j(AllocationNode allocationNode, long j2, byte[] bArr, int i2) {
        AllocationNode d2 = d(allocationNode, j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (d2.f25909b - j2));
            System.arraycopy(d2.f25910c.f28307a, d2.e(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            if (j2 == d2.f25909b) {
                d2 = d2.f25911d;
            }
        }
        return d2;
    }

    private static AllocationNode k(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        boolean z2;
        int i2;
        SampleQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long j2 = sampleExtrasHolder2.f25939b;
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
        CryptoInfo cryptoInfo = decoderInputBuffer.f23960c;
        byte[] bArr = cryptoInfo.f23936a;
        if (bArr == null) {
            cryptoInfo.f23936a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        AllocationNode j5 = j(j3, j4, cryptoInfo.f23936a, b3);
        long j6 = j4 + ((long) b3);
        if (z2) {
            parsableByteArray2.Q(2);
            j5 = j(j5, j6, parsableByteArray.e(), 2);
            j6 += 2;
            i2 = parsableByteArray.N();
        } else {
            i2 = 1;
        }
        int[] iArr = cryptoInfo.f23939d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.f23940e;
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
            iArr4[0] = sampleExtrasHolder2.f25938a - ((int) (j6 - sampleExtrasHolder2.f25939b));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.j(sampleExtrasHolder2.f25940c);
        cryptoInfo.c(i2, iArr2, iArr4, cryptoData.f24240b, cryptoInfo.f23936a, cryptoData.f24239a, cryptoData.f24241c, cryptoData.f24242d);
        long j7 = sampleExtrasHolder2.f25939b;
        int i5 = (int) (j6 - j7);
        sampleExtrasHolder2.f25939b = j7 + ((long) i5);
        sampleExtrasHolder2.f25938a -= i5;
        return j5;
    }

    private static AllocationNode l(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.s()) {
            allocationNode = k(allocationNode, decoderInputBuffer, sampleExtrasHolder, parsableByteArray);
        }
        if (decoderInputBuffer.i()) {
            parsableByteArray.Q(4);
            AllocationNode j2 = j(allocationNode, sampleExtrasHolder.f25939b, parsableByteArray.e(), 4);
            int L = parsableByteArray.L();
            sampleExtrasHolder.f25939b += 4;
            sampleExtrasHolder.f25938a -= 4;
            decoderInputBuffer.q(L);
            AllocationNode i2 = i(j2, sampleExtrasHolder.f25939b, decoderInputBuffer.f23961d, L);
            sampleExtrasHolder.f25939b += (long) L;
            int i3 = sampleExtrasHolder.f25938a - L;
            sampleExtrasHolder.f25938a = i3;
            decoderInputBuffer.u(i3);
            return i(i2, sampleExtrasHolder.f25939b, decoderInputBuffer.f23964g, sampleExtrasHolder.f25938a);
        }
        decoderInputBuffer.q(sampleExtrasHolder.f25938a);
        return i(allocationNode, sampleExtrasHolder.f25939b, decoderInputBuffer.f23961d, sampleExtrasHolder.f25938a);
    }

    public void b(long j2) {
        AllocationNode allocationNode;
        if (j2 != -1) {
            while (true) {
                allocationNode = this.f25904d;
                if (j2 < allocationNode.f25909b) {
                    break;
                }
                this.f25901a.e(allocationNode.f25910c);
                this.f25904d = this.f25904d.b();
            }
            if (this.f25905e.f25908a < allocationNode.f25908a) {
                this.f25905e = allocationNode;
            }
        }
    }

    public void c(long j2) {
        boolean z2;
        if (j2 <= this.f25907g) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f25907g = j2;
        if (j2 != 0) {
            AllocationNode allocationNode = this.f25904d;
            if (j2 != allocationNode.f25908a) {
                while (this.f25907g > allocationNode.f25909b) {
                    allocationNode = allocationNode.f25911d;
                }
                AllocationNode allocationNode2 = (AllocationNode) Assertions.e(allocationNode.f25911d);
                a(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.f25909b, this.f25902b);
                allocationNode.f25911d = allocationNode3;
                if (this.f25907g == allocationNode.f25909b) {
                    allocationNode = allocationNode3;
                }
                this.f25906f = allocationNode;
                if (this.f25905e == allocationNode2) {
                    this.f25905e = allocationNode3;
                    return;
                }
                return;
            }
        }
        a(this.f25904d);
        AllocationNode allocationNode4 = new AllocationNode(this.f25907g, this.f25902b);
        this.f25904d = allocationNode4;
        this.f25905e = allocationNode4;
        this.f25906f = allocationNode4;
    }

    public long e() {
        return this.f25907g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        l(this.f25905e, decoderInputBuffer, sampleExtrasHolder, this.f25903c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.f25905e = l(this.f25905e, decoderInputBuffer, sampleExtrasHolder, this.f25903c);
    }

    public void n() {
        a(this.f25904d);
        this.f25904d.d(0, this.f25902b);
        AllocationNode allocationNode = this.f25904d;
        this.f25905e = allocationNode;
        this.f25906f = allocationNode;
        this.f25907g = 0;
        this.f25901a.b();
    }

    public void o() {
        this.f25905e = this.f25904d;
    }

    public int p(DataReader dataReader, int i2, boolean z2) throws IOException {
        int h2 = h(i2);
        AllocationNode allocationNode = this.f25906f;
        int read = dataReader.read(allocationNode.f25910c.f28307a, allocationNode.e(this.f25907g), h2);
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
            AllocationNode allocationNode = this.f25906f;
            parsableByteArray.l(allocationNode.f25910c.f28307a, allocationNode.e(this.f25907g), h2);
            i2 -= h2;
            g(h2);
        }
    }
}

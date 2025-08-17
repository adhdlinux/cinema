package com.startapp.simple.bloomfilter.algo;

import com.google.protobuf.CodedOutputStream;
import java.io.Serializable;

public class OpenBitSet implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f36530a = true;
    private static final long serialVersionUID = -901334831550831262L;
    private final long[][] bits;
    private final int pageCount;
    private int wlen;

    public OpenBitSet(long j2) {
        int i2;
        int a2 = a(j2);
        this.wlen = a2;
        int i3 = a2 % CodedOutputStream.DEFAULT_BUFFER_SIZE;
        int i4 = a2 / CodedOutputStream.DEFAULT_BUFFER_SIZE;
        if (i3 == 0) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        int i5 = i2 + i4;
        this.pageCount = i5;
        if (i5 <= 100) {
            this.bits = new long[i5][];
            for (int i6 = 0; i6 < i4; i6++) {
                this.bits[i6] = new long[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            }
            if (i3 != 0) {
                long[][] jArr = this.bits;
                jArr[jArr.length - 1] = new long[i3];
                return;
            }
            return;
        }
        throw new RuntimeException("HighPageCountException pageCount = " + i5);
    }

    public int a() {
        return this.wlen;
    }

    public final int a(long j2) {
        return (int) (((j2 - 1) >>> 6) + 1);
    }

    public void b(long j2) {
        int i2 = (int) (j2 >> 6);
        int i3 = this.wlen;
        if (i2 >= i3) {
            int i4 = (int) ((((j2 + 1) - 1) >>> 6) + 1);
            if (f36530a || i4 <= i3) {
                this.wlen = i2 + 1;
            } else {
                throw new AssertionError("Growing of paged bitset is not supported");
            }
        }
        long[] jArr = this.bits[i2 / CodedOutputStream.DEFAULT_BUFFER_SIZE];
        int i5 = i2 % CodedOutputStream.DEFAULT_BUFFER_SIZE;
        jArr[i5] = (1 << (((int) j2) & 63)) | jArr[i5];
    }

    public long c() {
        return ((long) this.wlen) << 6;
    }

    public long[] a(int i2) {
        return this.bits[i2];
    }

    public int b() {
        return this.pageCount;
    }
}

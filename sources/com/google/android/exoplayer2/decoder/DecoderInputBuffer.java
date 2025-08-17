package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DecoderInputBuffer extends Buffer {

    /* renamed from: c  reason: collision with root package name */
    public final CryptoInfo f23960c;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f23961d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23962e;

    /* renamed from: f  reason: collision with root package name */
    public long f23963f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f23964g;

    /* renamed from: h  reason: collision with root package name */
    private final int f23965h;

    /* renamed from: i  reason: collision with root package name */
    private final int f23966i;

    public static final class InsufficientCapacityException extends IllegalStateException {

        /* renamed from: b  reason: collision with root package name */
        public final int f23967b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23968c;

        public InsufficientCapacityException(int i2, int i3) {
            super("Buffer too small (" + i2 + " < " + i3 + ")");
            this.f23967b = i2;
            this.f23968c = i3;
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i2) {
        this(i2, 0);
    }

    private ByteBuffer p(int i2) {
        int i3;
        int i4 = this.f23965h;
        if (i4 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i4 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f23961d;
        if (byteBuffer == null) {
            i3 = 0;
        } else {
            i3 = byteBuffer.capacity();
        }
        throw new InsufficientCapacityException(i3, i2);
    }

    public static DecoderInputBuffer t() {
        return new DecoderInputBuffer(0);
    }

    public void f() {
        super.f();
        ByteBuffer byteBuffer = this.f23961d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f23964g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f23962e = false;
    }

    @EnsuresNonNull({"data"})
    public void q(int i2) {
        int i3 = i2 + this.f23966i;
        ByteBuffer byteBuffer = this.f23961d;
        if (byteBuffer == null) {
            this.f23961d = p(i3);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i4 = i3 + position;
        if (capacity >= i4) {
            this.f23961d = byteBuffer;
            return;
        }
        ByteBuffer p2 = p(i4);
        p2.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            p2.put(byteBuffer);
        }
        this.f23961d = p2;
    }

    public final void r() {
        ByteBuffer byteBuffer = this.f23961d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f23964g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean s() {
        return h(1073741824);
    }

    @EnsuresNonNull({"supplementalData"})
    public void u(int i2) {
        ByteBuffer byteBuffer = this.f23964g;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.f23964g = ByteBuffer.allocate(i2);
        } else {
            this.f23964g.clear();
        }
    }

    public DecoderInputBuffer(int i2, int i3) {
        this.f23960c = new CryptoInfo();
        this.f23965h = i2;
        this.f23966i = i3;
    }
}

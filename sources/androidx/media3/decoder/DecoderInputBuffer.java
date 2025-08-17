package androidx.media3.decoder;

import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DecoderInputBuffer extends Buffer {

    /* renamed from: b  reason: collision with root package name */
    public Format f5065b;

    /* renamed from: c  reason: collision with root package name */
    public final CryptoInfo f5066c;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f5067d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5068e;

    /* renamed from: f  reason: collision with root package name */
    public long f5069f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f5070g;

    /* renamed from: h  reason: collision with root package name */
    private final int f5071h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5072i;

    public static final class InsufficientCapacityException extends IllegalStateException {

        /* renamed from: b  reason: collision with root package name */
        public final int f5073b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5074c;

        public InsufficientCapacityException(int i2, int i3) {
            super("Buffer too small (" + i2 + " < " + i3 + ")");
            this.f5073b = i2;
            this.f5074c = i3;
        }
    }

    static {
        MediaLibraryInfo.a("media3.decoder");
    }

    public DecoderInputBuffer(int i2) {
        this(i2, 0);
    }

    private ByteBuffer e(int i2) {
        int i3;
        int i4 = this.f5071h;
        if (i4 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i4 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f5067d;
        if (byteBuffer == null) {
            i3 = 0;
        } else {
            i3 = byteBuffer.capacity();
        }
        throw new InsufficientCapacityException(i3, i2);
    }

    public static DecoderInputBuffer i() {
        return new DecoderInputBuffer(0);
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f5067d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f5070g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f5068e = false;
    }

    @EnsuresNonNull({"data"})
    public void f(int i2) {
        int i3 = i2 + this.f5072i;
        ByteBuffer byteBuffer = this.f5067d;
        if (byteBuffer == null) {
            this.f5067d = e(i3);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i4 = i3 + position;
        if (capacity >= i4) {
            this.f5067d = byteBuffer;
            return;
        }
        ByteBuffer e2 = e(i4);
        e2.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            e2.put(byteBuffer);
        }
        this.f5067d = e2;
    }

    public final void g() {
        ByteBuffer byteBuffer = this.f5067d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f5070g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean h() {
        return getFlag(1073741824);
    }

    @EnsuresNonNull({"supplementalData"})
    public void j(int i2) {
        ByteBuffer byteBuffer = this.f5070g;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.f5070g = ByteBuffer.allocate(i2);
        } else {
            this.f5070g.clear();
        }
    }

    public DecoderInputBuffer(int i2, int i3) {
        this.f5066c = new CryptoInfo();
        this.f5071h = i2;
        this.f5072i = i3;
    }
}

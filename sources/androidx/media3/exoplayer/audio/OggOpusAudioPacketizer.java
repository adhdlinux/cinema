package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.extractor.OpusUtil;
import com.facebook.imageutils.JfifUtil;
import com.google.common.primitives.UnsignedBytes;
import com.startapp.y1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class OggOpusAudioPacketizer {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f5826d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, y1.f36938c, -69, 0, 0, 0, 0, 0};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f5827e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f5828a = AudioProcessor.f4498a;

    /* renamed from: b  reason: collision with root package name */
    private int f5829b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f5830c = 0;

    private ByteBuffer b(ByteBuffer byteBuffer, byte[] bArr) {
        int i2;
        int i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        byte[] bArr2 = bArr;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i4 = limit - position;
        int i5 = (i4 + JfifUtil.MARKER_FIRST_BYTE) / JfifUtil.MARKER_FIRST_BYTE;
        int i6 = i5 + 27 + i4;
        if (this.f5829b == 2) {
            if (bArr2 != null) {
                i3 = bArr2.length + 28;
            } else {
                i3 = f5826d.length;
            }
            i6 += f5827e.length + i3;
            i2 = i3;
        } else {
            i2 = 0;
        }
        ByteBuffer c2 = c(i6);
        if (this.f5829b == 2) {
            if (bArr2 != null) {
                e(c2, bArr2);
            } else {
                c2.put(f5826d);
            }
            c2.put(f5827e);
        }
        int j2 = this.f5830c + OpusUtil.j(byteBuffer);
        this.f5830c = j2;
        ByteBuffer byteBuffer3 = c2;
        f(c2, (long) j2, this.f5829b, i5, false);
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 >= 255) {
                byteBuffer3.put((byte) -1);
                i4 -= 255;
            } else {
                byteBuffer3.put((byte) i4);
                i4 = 0;
            }
        }
        while (position < limit) {
            byteBuffer3.put(byteBuffer2.get(position));
            position++;
        }
        byteBuffer2.position(byteBuffer.limit());
        byteBuffer3.flip();
        if (this.f5829b == 2) {
            byte[] array = byteBuffer3.array();
            byte[] bArr3 = f5827e;
            byteBuffer3.putInt(i2 + bArr3.length + 22, Util.x(array, byteBuffer3.arrayOffset() + i2 + bArr3.length, byteBuffer3.limit() - byteBuffer3.position(), 0));
        } else {
            byteBuffer3.putInt(22, Util.x(byteBuffer3.array(), byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0));
        }
        this.f5829b++;
        return byteBuffer3;
    }

    private ByteBuffer c(int i2) {
        if (this.f5828a.capacity() < i2) {
            this.f5828a = ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f5828a.clear();
        }
        return this.f5828a;
    }

    private void e(ByteBuffer byteBuffer, byte[] bArr) {
        f(byteBuffer, 0, 0, 1, true);
        byteBuffer.put(UnsignedBytes.a((long) bArr.length));
        byteBuffer.put(bArr);
        byteBuffer.putInt(22, Util.x(byteBuffer.array(), byteBuffer.arrayOffset(), bArr.length + 28, 0));
        byteBuffer.position(bArr.length + 28);
    }

    private void f(ByteBuffer byteBuffer, long j2, int i2, int i3, boolean z2) {
        byte b2;
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        if (z2) {
            b2 = 2;
        } else {
            b2 = 0;
        }
        byteBuffer.put(b2);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i2);
        byteBuffer.putInt(0);
        byteBuffer.put(UnsignedBytes.a((long) i3));
    }

    public void a(DecoderInputBuffer decoderInputBuffer, List<byte[]> list) {
        byte[] bArr;
        Assertions.f(decoderInputBuffer.f5067d);
        if (decoderInputBuffer.f5067d.limit() - decoderInputBuffer.f5067d.position() != 0) {
            if (this.f5829b == 2 && (list.size() == 1 || list.size() == 3)) {
                bArr = list.get(0);
            } else {
                bArr = null;
            }
            this.f5828a = b(decoderInputBuffer.f5067d, bArr);
            decoderInputBuffer.clear();
            decoderInputBuffer.f(this.f5828a.remaining());
            decoderInputBuffer.f5067d.put(this.f5828a);
            decoderInputBuffer.g();
        }
    }

    public void d() {
        this.f5828a = AudioProcessor.f4498a;
        this.f5830c = 0;
        this.f5829b = 2;
    }
}

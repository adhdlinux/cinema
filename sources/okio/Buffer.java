package okio;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.y1;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: b  reason: collision with root package name */
    public Segment f41320b;

    /* renamed from: c  reason: collision with root package name */
    private long f41321c;

    public static final class UnsafeCursor implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public Buffer f41322b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41323c;

        /* renamed from: d  reason: collision with root package name */
        private Segment f41324d;

        /* renamed from: e  reason: collision with root package name */
        public long f41325e = -1;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f41326f;

        /* renamed from: g  reason: collision with root package name */
        public int f41327g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f41328h = -1;

        public final Segment a() {
            return this.f41324d;
        }

        public void close() {
            boolean z2;
            if (this.f41322b != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f41322b = null;
                q((Segment) null);
                this.f41325e = -1;
                this.f41326f = null;
                this.f41327g = -1;
                this.f41328h = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int f() {
            boolean z2;
            long j2;
            long j3 = this.f41325e;
            Buffer buffer = this.f41322b;
            Intrinsics.c(buffer);
            if (j3 != buffer.size()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                long j4 = this.f41325e;
                if (j4 == -1) {
                    j2 = 0;
                } else {
                    j2 = j4 + ((long) (this.f41328h - this.f41327g));
                }
                return k(j2);
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long i(long j2) {
            boolean z2;
            long j3 = j2;
            Buffer buffer = this.f41322b;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.f41323c) {
                long size = buffer.size();
                int i2 = 1;
                int i3 = (j3 > size ? 1 : (j3 == size ? 0 : -1));
                if (i3 <= 0) {
                    if (j3 >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        long j4 = size - j3;
                        while (true) {
                            if (j4 <= 0) {
                                break;
                            }
                            Segment segment = buffer.f41320b;
                            Intrinsics.c(segment);
                            Segment segment2 = segment.f41383g;
                            Intrinsics.c(segment2);
                            int i4 = segment2.f41379c;
                            long j5 = (long) (i4 - segment2.f41378b);
                            if (j5 > j4) {
                                segment2.f41379c = i4 - ((int) j4);
                                break;
                            }
                            buffer.f41320b = segment2.b();
                            SegmentPool.b(segment2);
                            j4 -= j5;
                        }
                        q((Segment) null);
                        this.f41325e = j3;
                        this.f41326f = null;
                        this.f41327g = -1;
                        this.f41328h = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j3).toString());
                    }
                } else if (i3 > 0) {
                    long j6 = j3 - size;
                    boolean z3 = true;
                    while (j6 > 0) {
                        Segment w02 = buffer.w0(i2);
                        int min = (int) Math.min(j6, (long) (8192 - w02.f41379c));
                        w02.f41379c += min;
                        j6 -= (long) min;
                        if (z3) {
                            q(w02);
                            this.f41325e = size;
                            this.f41326f = w02.f41377a;
                            int i5 = w02.f41379c;
                            this.f41327g = i5 - min;
                            this.f41328h = i5;
                            i2 = 1;
                            z3 = false;
                        } else {
                            i2 = 1;
                        }
                    }
                }
                buffer.t0(j3);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int k(long j2) {
            Segment segment;
            Buffer buffer = this.f41322b;
            if (buffer != null) {
                int i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
                if (i2 < 0 || j2 > buffer.size()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j2 + " > size=" + buffer.size());
                } else if (i2 == 0 || j2 == buffer.size()) {
                    q((Segment) null);
                    this.f41325e = j2;
                    this.f41326f = null;
                    this.f41327g = -1;
                    this.f41328h = -1;
                    return -1;
                } else {
                    long size = buffer.size();
                    Segment segment2 = buffer.f41320b;
                    long j3 = 0;
                    if (a() != null) {
                        long j4 = this.f41325e;
                        int i3 = this.f41327g;
                        Segment a2 = a();
                        Intrinsics.c(a2);
                        long j5 = j4 - ((long) (i3 - a2.f41378b));
                        if (j5 > j2) {
                            segment = segment2;
                            segment2 = a();
                            size = j5;
                        } else {
                            segment = a();
                            j3 = j5;
                        }
                    } else {
                        segment = segment2;
                    }
                    if (size - j2 > j2 - j3) {
                        while (true) {
                            Intrinsics.c(segment);
                            int i4 = segment.f41379c;
                            int i5 = segment.f41378b;
                            if (j2 < ((long) (i4 - i5)) + j3) {
                                break;
                            }
                            j3 += (long) (i4 - i5);
                            segment = segment.f41382f;
                        }
                    } else {
                        while (size > j2) {
                            Intrinsics.c(segment2);
                            segment2 = segment2.f41383g;
                            Intrinsics.c(segment2);
                            size -= (long) (segment2.f41379c - segment2.f41378b);
                        }
                        j3 = size;
                        segment = segment2;
                    }
                    if (this.f41323c) {
                        Intrinsics.c(segment);
                        if (segment.f41380d) {
                            Segment f2 = segment.f();
                            if (buffer.f41320b == segment) {
                                buffer.f41320b = f2;
                            }
                            segment = segment.c(f2);
                            Segment segment3 = segment.f41383g;
                            Intrinsics.c(segment3);
                            segment3.b();
                        }
                    }
                    q(segment);
                    this.f41325e = j2;
                    Intrinsics.c(segment);
                    this.f41326f = segment.f41377a;
                    int i6 = segment.f41378b + ((int) (j2 - j3));
                    this.f41327g = i6;
                    int i7 = segment.f41379c;
                    this.f41328h = i7;
                    return i7 - i6;
                }
            } else {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
        }

        public final void q(Segment segment) {
            this.f41324d = segment;
        }
    }

    public static /* synthetic */ UnsafeCursor m0(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = SegmentedByteString.d();
        }
        return buffer.j0(unsafeCursor);
    }

    public long A(byte b2, long j2, long j3) {
        Segment segment;
        int i2;
        long j4;
        boolean z2 = false;
        long j5 = 0;
        if (0 <= j2 && j2 <= j3) {
            z2 = true;
        }
        if (z2) {
            if (j3 > size()) {
                j3 = size();
            }
            if (j2 == j3 || (segment = this.f41320b) == null) {
                return -1;
            }
            if (size() - j2 < j2) {
                j4 = size();
                while (j4 > j2) {
                    segment = segment.f41383g;
                    Intrinsics.c(segment);
                    j4 -= (long) (segment.f41379c - segment.f41378b);
                }
                while (j4 < j3) {
                    byte[] bArr = segment.f41377a;
                    int min = (int) Math.min((long) segment.f41379c, (((long) segment.f41378b) + j3) - j4);
                    i2 = (int) ((((long) segment.f41378b) + j2) - j4);
                    while (i2 < min) {
                        if (bArr[i2] != b2) {
                            i2++;
                        }
                    }
                    j4 += (long) (segment.f41379c - segment.f41378b);
                    segment = segment.f41382f;
                    Intrinsics.c(segment);
                    j2 = j4;
                }
                return -1;
            }
            while (true) {
                long j6 = ((long) (segment.f41379c - segment.f41378b)) + j5;
                if (j6 > j2) {
                    break;
                }
                segment = segment.f41382f;
                Intrinsics.c(segment);
                j5 = j6;
            }
            while (j4 < j3) {
                byte[] bArr2 = segment.f41377a;
                int min2 = (int) Math.min((long) segment.f41379c, (((long) segment.f41378b) + j3) - j4);
                int i3 = (int) ((((long) segment.f41378b) + j2) - j4);
                while (i2 < min2) {
                    if (bArr2[i2] != b2) {
                        i3 = i2 + 1;
                    }
                }
                j5 = j4 + ((long) (segment.f41379c - segment.f41378b));
                segment = segment.f41382f;
                Intrinsics.c(segment);
                j2 = j5;
            }
            return -1;
            return ((long) (i2 - segment.f41378b)) + j4;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
    }

    /* renamed from: A0 */
    public Buffer write(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "source");
        long j2 = (long) i3;
        SegmentedByteString.b((long) bArr.length, (long) i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment w02 = w0(1);
            int min = Math.min(i4 - i2, 8192 - w02.f41379c);
            int i5 = i2 + min;
            byte[] unused = ArraysKt___ArraysJvmKt.e(bArr, w02.f41377a, w02.f41379c, i2, i5);
            w02.f41379c += min;
            i2 = i5;
        }
        t0(size() + j2);
        return this;
    }

    public long B(ByteString byteString) throws IOException {
        Intrinsics.f(byteString, "bytes");
        return D(byteString, 0);
    }

    /* renamed from: B0 */
    public Buffer writeByte(int i2) {
        Segment w02 = w0(1);
        byte[] bArr = w02.f41377a;
        int i3 = w02.f41379c;
        w02.f41379c = i3 + 1;
        bArr[i3] = (byte) i2;
        t0(size() + 1);
        return this;
    }

    /* renamed from: C0 */
    public Buffer O(long j2) {
        boolean z2;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            return writeByte(48);
        }
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return w("-9223372036854775808");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (j2 < 100000000) {
            if (j2 < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                if (j2 < 100) {
                    if (j2 >= 10) {
                        i3 = 2;
                    }
                } else if (j2 < 1000) {
                    i3 = 3;
                } else {
                    i3 = 4;
                }
            } else if (j2 < 1000000) {
                if (j2 < 100000) {
                    i3 = 5;
                } else {
                    i3 = 6;
                }
            } else if (j2 < 10000000) {
                i3 = 7;
            } else {
                i3 = 8;
            }
        } else if (j2 < 1000000000000L) {
            if (j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                if (j2 < 1000000000) {
                    i3 = 9;
                } else {
                    i3 = 10;
                }
            } else if (j2 < 100000000000L) {
                i3 = 11;
            } else {
                i3 = 12;
            }
        } else if (j2 < 1000000000000000L) {
            if (j2 < 10000000000000L) {
                i3 = 13;
            } else if (j2 < 100000000000000L) {
                i3 = 14;
            } else {
                i3 = 15;
            }
        } else if (j2 < 100000000000000000L) {
            if (j2 < 10000000000000000L) {
                i3 = 16;
            } else {
                i3 = 17;
            }
        } else if (j2 < 1000000000000000000L) {
            i3 = 18;
        } else {
            i3 = 19;
        }
        if (z2) {
            i3++;
        }
        Segment w02 = w0(i3);
        byte[] bArr = w02.f41377a;
        int i4 = w02.f41379c + i3;
        while (j2 != 0) {
            long j3 = (long) 10;
            i4--;
            bArr[i4] = okio.internal.Buffer.b()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z2) {
            bArr[i4 - 1] = 45;
        }
        w02.f41379c += i3;
        t0(size() + ((long) i3));
        return this;
    }

    public long D(ByteString byteString, long j2) throws IOException {
        boolean z2;
        boolean z3;
        long j3 = j2;
        Intrinsics.f(byteString, "bytes");
        if (byteString.size() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            long j4 = 0;
            if (j3 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                Segment segment = this.f41320b;
                if (segment != null) {
                    if (size() - j3 < j3) {
                        long size = size();
                        while (size > j3) {
                            segment = segment.f41383g;
                            Intrinsics.c(segment);
                            size -= (long) (segment.f41379c - segment.f41378b);
                        }
                        byte[] l2 = byteString.l();
                        byte b2 = l2[0];
                        int size2 = byteString.size();
                        long size3 = (size() - ((long) size2)) + 1;
                        while (size < size3) {
                            byte[] bArr = segment.f41377a;
                            long j5 = size;
                            int min = (int) Math.min((long) segment.f41379c, (((long) segment.f41378b) + size3) - size);
                            long j6 = ((long) segment.f41378b) + j3;
                            long j7 = j5;
                            for (int i2 = (int) (j6 - j7); i2 < min; i2++) {
                                if (bArr[i2] == b2 && okio.internal.Buffer.c(segment, i2 + 1, l2, 1, size2)) {
                                    return ((long) (i2 - segment.f41378b)) + j7;
                                }
                            }
                            size = j7 + ((long) (segment.f41379c - segment.f41378b));
                            segment = segment.f41382f;
                            Intrinsics.c(segment);
                            j3 = size;
                        }
                    } else {
                        while (true) {
                            long j8 = ((long) (segment.f41379c - segment.f41378b)) + j4;
                            if (j8 > j3) {
                                break;
                            }
                            segment = segment.f41382f;
                            Intrinsics.c(segment);
                            j4 = j8;
                        }
                        byte[] l3 = byteString.l();
                        byte b3 = l3[0];
                        int size4 = byteString.size();
                        long size5 = (size() - ((long) size4)) + 1;
                        while (j4 < size5) {
                            byte[] bArr2 = segment.f41377a;
                            long j9 = size5;
                            int min2 = (int) Math.min((long) segment.f41379c, (((long) segment.f41378b) + size5) - j4);
                            for (int i3 = (int) ((((long) segment.f41378b) + j3) - j4); i3 < min2; i3++) {
                                if (bArr2[i3] == b3) {
                                    if (okio.internal.Buffer.c(segment, i3 + 1, l3, 1, size4)) {
                                        return ((long) (i3 - segment.f41378b)) + j4;
                                    }
                                }
                            }
                            j4 += (long) (segment.f41379c - segment.f41378b);
                            segment = segment.f41382f;
                            Intrinsics.c(segment);
                            j3 = j4;
                            size5 = j9;
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    /* renamed from: D0 */
    public Buffer b0(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment w02 = w0(i2);
        byte[] bArr = w02.f41377a;
        int i3 = w02.f41379c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = okio.internal.Buffer.b()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        w02.f41379c += i2;
        t0(size() + ((long) i2));
        return this;
    }

    public long E(ByteString byteString) {
        Intrinsics.f(byteString, "targetBytes");
        return H(byteString, 0);
    }

    /* renamed from: E0 */
    public Buffer writeInt(int i2) {
        Segment w02 = w0(4);
        byte[] bArr = w02.f41377a;
        int i3 = w02.f41379c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & JfifUtil.MARKER_FIRST_BYTE);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        bArr[i6] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
        w02.f41379c = i6 + 1;
        t0(size() + 4);
        return this;
    }

    public String F() throws EOFException {
        return t(Clock.MAX_TIME);
    }

    public Buffer F0(int i2) {
        return writeInt(SegmentedByteString.h(i2));
    }

    public byte[] G(long j2) throws EOFException {
        boolean z2;
        if (j2 < 0 || j2 > 2147483647L) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        } else if (size() >= j2) {
            byte[] bArr = new byte[((int) j2)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public Buffer G0(long j2) {
        Segment w02 = w0(8);
        byte[] bArr = w02.f41377a;
        int i2 = w02.f41379c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j2 >>> 56) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j2 >>> 48) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j2 >>> 40) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j2 >>> 32) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j2 >>> 24) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j2 >>> 16) & 255));
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((int) ((j2 >>> 8) & 255));
        bArr[i9] = (byte) ((int) (j2 & 255));
        w02.f41379c = i9 + 1;
        t0(size() + 8);
        return this;
    }

    public long H(ByteString byteString, long j2) {
        boolean z2;
        int i2;
        long j3;
        int i3;
        int i4;
        Intrinsics.f(byteString, "targetBytes");
        long j4 = 0;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Segment segment = this.f41320b;
            if (segment == null) {
                return -1;
            }
            if (size() - j2 < j2) {
                j3 = size();
                while (j3 > j2) {
                    segment = segment.f41383g;
                    Intrinsics.c(segment);
                    j3 -= (long) (segment.f41379c - segment.f41378b);
                }
                if (byteString.size() == 2) {
                    byte f2 = byteString.f(0);
                    byte f3 = byteString.f(1);
                    while (j3 < size()) {
                        byte[] bArr = segment.f41377a;
                        i2 = (int) ((((long) segment.f41378b) + j2) - j3);
                        int i5 = segment.f41379c;
                        while (i2 < i5) {
                            byte b2 = bArr[i2];
                            if (!(b2 == f2 || b2 == f3)) {
                                i2++;
                            }
                        }
                        j3 += (long) (segment.f41379c - segment.f41378b);
                        segment = segment.f41382f;
                        Intrinsics.c(segment);
                        j2 = j3;
                    }
                    return -1;
                }
                byte[] l2 = byteString.l();
                while (j3 < size()) {
                    byte[] bArr2 = segment.f41377a;
                    i4 = (int) ((((long) segment.f41378b) + j2) - j3);
                    int i6 = segment.f41379c;
                    while (i4 < i6) {
                        byte b3 = bArr2[i4];
                        for (byte b4 : l2) {
                            if (b3 == b4) {
                                i3 = segment.f41378b;
                                return ((long) (i2 - i3)) + j3;
                            }
                        }
                        i4++;
                    }
                    j3 += (long) (segment.f41379c - segment.f41378b);
                    segment = segment.f41382f;
                    Intrinsics.c(segment);
                    j2 = j3;
                }
                return -1;
            }
            while (true) {
                long j5 = ((long) (segment.f41379c - segment.f41378b)) + j4;
                if (j5 > j2) {
                    break;
                }
                segment = segment.f41382f;
                Intrinsics.c(segment);
                j4 = j5;
            }
            if (byteString.size() == 2) {
                byte f4 = byteString.f(0);
                byte f5 = byteString.f(1);
                while (j3 < size()) {
                    byte[] bArr3 = segment.f41377a;
                    int i7 = (int) ((((long) segment.f41378b) + j2) - j3);
                    int i8 = segment.f41379c;
                    while (i2 < i8) {
                        byte b5 = bArr3[i2];
                        if (!(b5 == f4 || b5 == f5)) {
                            i7 = i2 + 1;
                        }
                    }
                    j4 = j3 + ((long) (segment.f41379c - segment.f41378b));
                    segment = segment.f41382f;
                    Intrinsics.c(segment);
                    j2 = j4;
                }
                return -1;
            }
            byte[] l3 = byteString.l();
            while (j3 < size()) {
                byte[] bArr4 = segment.f41377a;
                int i9 = (int) ((((long) segment.f41378b) + j2) - j3);
                int i10 = segment.f41379c;
                while (i4 < i10) {
                    byte b6 = bArr4[i4];
                    for (byte b7 : l3) {
                        if (b6 == b7) {
                            i3 = segment.f41378b;
                            return ((long) (i2 - i3)) + j3;
                        }
                    }
                    i9 = i4 + 1;
                }
                j4 = j3 + ((long) (segment.f41379c - segment.f41378b));
                segment = segment.f41382f;
                Intrinsics.c(segment);
                j2 = j4;
            }
            return -1;
            i3 = segment.f41378b;
            return ((long) (i2 - i3)) + j3;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
    }

    /* renamed from: H0 */
    public Buffer writeShort(int i2) {
        Segment w02 = w0(2);
        byte[] bArr = w02.f41377a;
        int i3 = w02.f41379c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        bArr[i4] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
        w02.f41379c = i4 + 1;
        t0(size() + 2);
        return this;
    }

    public Buffer I0(String str, int i2, int i3, Charset charset) {
        boolean z2;
        boolean z3;
        Intrinsics.f(str, "string");
        Intrinsics.f(charset, "charset");
        boolean z4 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (i3 >= i2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (i3 > str.length()) {
                    z4 = false;
                }
                if (!z4) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
                } else if (Intrinsics.a(charset, Charsets.f40513b)) {
                    return L0(str, i2, i3);
                } else {
                    String substring = str.substring(i2, i3);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    byte[] bytes = substring.getBytes(charset);
                    Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
    }

    public Buffer J0(String str, Charset charset) {
        Intrinsics.f(str, "string");
        Intrinsics.f(charset, "charset");
        return I0(str, 0, str.length(), charset);
    }

    /* renamed from: K0 */
    public Buffer w(String str) {
        Intrinsics.f(str, "string");
        return L0(str, 0, str.length());
    }

    public boolean L(long j2, ByteString byteString, int i2, int i3) {
        Intrinsics.f(byteString, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || size() - j2 < ((long) i3) || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (z(((long) i4) + j2) != byteString.f(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public Buffer L0(String str, int i2, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        char c2;
        boolean z5;
        char charAt;
        Intrinsics.f(str, "string");
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (i3 >= i2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (i3 <= str.length()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    while (i2 < i3) {
                        char charAt2 = str.charAt(i2);
                        if (charAt2 < 128) {
                            Segment w02 = w0(1);
                            byte[] bArr = w02.f41377a;
                            int i4 = w02.f41379c - i2;
                            int min = Math.min(i3, 8192 - i4);
                            int i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt2;
                            while (true) {
                                i2 = i5;
                                if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                                    int i6 = w02.f41379c;
                                    int i7 = (i4 + i2) - i6;
                                    w02.f41379c = i6 + i7;
                                    t0(size() + ((long) i7));
                                } else {
                                    i5 = i2 + 1;
                                    bArr[i2 + i4] = (byte) charAt;
                                }
                            }
                            int i62 = w02.f41379c;
                            int i72 = (i4 + i2) - i62;
                            w02.f41379c = i62 + i72;
                            t0(size() + ((long) i72));
                        } else {
                            if (charAt2 < 2048) {
                                Segment w03 = w0(2);
                                byte[] bArr2 = w03.f41377a;
                                int i8 = w03.f41379c;
                                bArr2[i8] = (byte) ((charAt2 >> 6) | JfifUtil.MARKER_SOFn);
                                bArr2[i8 + 1] = (byte) ((charAt2 & '?') | 128);
                                w03.f41379c = i8 + 2;
                                t0(size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment w04 = w0(3);
                                byte[] bArr3 = w04.f41377a;
                                int i9 = w04.f41379c;
                                bArr3[i9] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i9 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i9 + 2] = (byte) ((charAt2 & '?') | 128);
                                w04.f41379c = i9 + 3;
                                t0(size() + 3);
                            } else {
                                int i10 = i2 + 1;
                                if (i10 < i3) {
                                    c2 = str.charAt(i10);
                                } else {
                                    c2 = 0;
                                }
                                if (charAt2 <= 56319) {
                                    if (56320 > c2 || c2 >= 57344) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        int i11 = (((charAt2 & 1023) << 10) | (c2 & 1023)) + 0;
                                        Segment w05 = w0(4);
                                        byte[] bArr4 = w05.f41377a;
                                        int i12 = w05.f41379c;
                                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                                        w05.f41379c = i12 + 4;
                                        t0(size() + 4);
                                        i2 += 2;
                                    }
                                }
                                writeByte(63);
                                i2 = i10;
                            }
                            i2++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
    }

    public Buffer M0(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            Segment w02 = w0(2);
            byte[] bArr = w02.f41377a;
            int i3 = w02.f41379c;
            bArr[i3] = (byte) ((i2 >> 6) | JfifUtil.MARKER_SOFn);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            w02.f41379c = i3 + 2;
            t0(size() + 2);
        } else {
            boolean z2 = false;
            if (55296 <= i2 && i2 < 57344) {
                z2 = true;
            }
            if (z2) {
                writeByte(63);
            } else if (i2 < 65536) {
                Segment w03 = w0(3);
                byte[] bArr2 = w03.f41377a;
                int i4 = w03.f41379c;
                bArr2[i4] = (byte) ((i2 >> 12) | 224);
                bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
                bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
                w03.f41379c = i4 + 3;
                t0(size() + 3);
            } else if (i2 <= 1114111) {
                Segment w04 = w0(4);
                byte[] bArr3 = w04.f41377a;
                int i5 = w04.f41379c;
                bArr3[i5] = (byte) ((i2 >> 18) | 240);
                bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
                bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
                bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
                w04.f41379c = i5 + 4;
                t0(size() + 4);
            } else {
                throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.k(i2));
            }
        }
        return this;
    }

    public void N(long j2) throws EOFException {
        if (this.f41321c < j2) {
            throw new EOFException();
        }
    }

    public ByteString Q(long j2) throws EOFException {
        boolean z2;
        if (j2 < 0 || j2 > 2147483647L) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        } else if (size() < j2) {
            throw new EOFException();
        } else if (j2 < 4096) {
            return new ByteString(G(j2));
        } else {
            ByteString v02 = v0((int) j2);
            skip(j2);
            return v02;
        }
    }

    public byte[] U() {
        return G(size());
    }

    public boolean V() {
        return this.f41321c == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a5, code lost:
        if (r2 == false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a7, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a9, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        if (r1 >= r14) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if (size() == 0) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        if (r2 == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e0, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.j(z(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e6, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e7, code lost:
        if (r2 == false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long W() throws java.io.EOFException {
        /*
            r19 = this;
            r0 = r19
            long r1 = r19.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00ec
            r1 = 0
            r5 = -7
            r8 = r3
            r6 = r5
            r2 = 0
            r5 = 0
        L_0x0013:
            okio.Segment r10 = r0.f41320b
            kotlin.jvm.internal.Intrinsics.c(r10)
            byte[] r11 = r10.f41377a
            int r12 = r10.f41378b
            int r13 = r10.f41379c
        L_0x001e:
            if (r12 >= r13) goto L_0x0083
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x0071
            r14 = 57
            if (r15 > r14) goto L_0x0071
            int r14 = 48 - r15
            r16 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x0044
            if (r18 != 0) goto L_0x003d
            long r3 = (long) r14
            int r16 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x003d
            goto L_0x0044
        L_0x003d:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x007b
        L_0x0044:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.O(r8)
            okio.Buffer r1 = r1.writeByte(r15)
            if (r2 != 0) goto L_0x0056
            r1.readByte()
        L_0x0056:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.f0()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0071:
            r3 = 45
            if (r15 != r3) goto L_0x0082
            if (r1 != 0) goto L_0x0082
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x007b:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = 0
            goto L_0x001e
        L_0x0082:
            r5 = 1
        L_0x0083:
            if (r12 != r13) goto L_0x008f
            okio.Segment r3 = r10.b()
            r0.f41320b = r3
            okio.SegmentPool.b(r10)
            goto L_0x0091
        L_0x008f:
            r10.f41378b = r12
        L_0x0091:
            if (r5 != 0) goto L_0x009c
            okio.Segment r3 = r0.f41320b
            if (r3 != 0) goto L_0x0098
            goto L_0x009c
        L_0x0098:
            r3 = 0
            goto L_0x0013
        L_0x009c:
            long r3 = r19.size()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.t0(r3)
            if (r2 == 0) goto L_0x00a9
            r14 = 2
            goto L_0x00aa
        L_0x00a9:
            r14 = 1
        L_0x00aa:
            if (r1 >= r14) goto L_0x00e7
            long r3 = r19.size()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00e1
            if (r2 == 0) goto L_0x00bb
            java.lang.String r1 = "Expected a digit"
            goto L_0x00bd
        L_0x00bb:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00bd:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = 0
            byte r1 = r0.z(r4)
            java.lang.String r1 = okio.SegmentedByteString.j(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00e1:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00e7:
            if (r2 == 0) goto L_0x00ea
            goto L_0x00eb
        L_0x00ea:
            long r8 = -r8
        L_0x00eb:
            return r8
        L_0x00ec:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.W():long");
    }

    public final void a() {
        skip(size());
    }

    public String a0(Charset charset) {
        Intrinsics.f(charset, "charset");
        return q0(this.f41321c, charset);
    }

    public Buffer c() {
        return this;
    }

    public ByteString c0() {
        return Q(size());
    }

    public void close() {
    }

    public InputStream d() {
        return new Buffer$inputStream$1(this);
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0009
            goto L_0x0081
        L_0x0009:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0011
        L_0x000e:
            r2 = 0
            goto L_0x0081
        L_0x0011:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0020
            goto L_0x000e
        L_0x0020:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002b
            goto L_0x0081
        L_0x002b:
            okio.Segment r3 = r0.f41320b
            kotlin.jvm.internal.Intrinsics.c(r3)
            okio.Segment r1 = r1.f41320b
            kotlin.jvm.internal.Intrinsics.c(r1)
            int r5 = r3.f41378b
            int r6 = r1.f41378b
            r9 = r7
        L_0x003a:
            long r11 = r18.size()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r3.f41379c
            int r11 = r11 - r5
            int r12 = r1.f41379c
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x004e:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0069
            byte[] r15 = r3.f41377a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f41377a
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0061
            goto L_0x000e
        L_0x0061:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x004e
        L_0x0069:
            int r13 = r3.f41379c
            if (r5 != r13) goto L_0x0074
            okio.Segment r3 = r3.f41382f
            kotlin.jvm.internal.Intrinsics.c(r3)
            int r5 = r3.f41378b
        L_0x0074:
            int r13 = r1.f41379c
            if (r6 != r13) goto L_0x007f
            okio.Segment r1 = r1.f41382f
            kotlin.jvm.internal.Intrinsics.c(r1)
            int r6 = r1.f41378b
        L_0x007f:
            long r9 = r9 + r11
            goto L_0x003a
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    /* renamed from: f */
    public Buffer clone() {
        return k();
    }

    public String f0() {
        return q0(this.f41321c, Charsets.f40513b);
    }

    public void flush() {
    }

    public int hashCode() {
        Segment segment = this.f41320b;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.f41379c;
            for (int i4 = segment.f41378b; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.f41377a[i4];
            }
            segment = segment.f41382f;
            Intrinsics.c(segment);
        } while (segment != this.f41320b);
        return i2;
    }

    public final long i() {
        long size = size();
        if (size == 0) {
            return 0;
        }
        Segment segment = this.f41320b;
        Intrinsics.c(segment);
        Segment segment2 = segment.f41383g;
        Intrinsics.c(segment2);
        int i2 = segment2.f41379c;
        if (i2 < 8192 && segment2.f41381e) {
            size -= (long) (i2 - segment2.f41378b);
        }
        return size;
    }

    public long i0(Sink sink) throws IOException {
        Intrinsics.f(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public boolean isOpen() {
        return true;
    }

    public final UnsafeCursor j0(UnsafeCursor unsafeCursor) {
        Intrinsics.f(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.a(this, unsafeCursor);
    }

    public final Buffer k() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.f41320b;
            Intrinsics.c(segment);
            Segment d2 = segment.d();
            buffer.f41320b = d2;
            d2.f41383g = d2;
            d2.f41382f = d2;
            for (Segment segment2 = segment.f41382f; segment2 != segment; segment2 = segment2.f41382f) {
                Segment segment3 = d2.f41383g;
                Intrinsics.c(segment3);
                Intrinsics.c(segment2);
                segment3.c(segment2.d());
            }
            buffer.t0(size());
        }
        return buffer;
    }

    public OutputStream k0() {
        return new Buffer$outputStream$1(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        if (r8 != r9) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        r15.f41320b = r6.b();
        okio.SegmentPool.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r6.f41378b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (r1 != false) goto L_0x00aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long l0() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b4
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000d:
            okio.Segment r6 = r15.f41320b
            kotlin.jvm.internal.Intrinsics.c(r6)
            byte[] r7 = r6.f41377a
            int r8 = r6.f41378b
            int r9 = r6.f41379c
        L_0x0018:
            if (r8 >= r9) goto L_0x0096
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0027
            r11 = 57
            if (r10 > r11) goto L_0x0027
            int r11 = r10 + -48
            goto L_0x003f
        L_0x0027:
            r11 = 97
            if (r10 < r11) goto L_0x0034
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0034
            int r11 = r10 + -97
        L_0x0031:
            int r11 = r11 + 10
            goto L_0x003f
        L_0x0034:
            r11 = 65
            if (r10 < r11) goto L_0x0077
            r11 = 70
            if (r10 > r11) goto L_0x0077
            int r11 = r10 + -65
            goto L_0x0031
        L_0x003f:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004f
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x004f:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.b0(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.f0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0077:
            if (r0 == 0) goto L_0x007b
            r1 = 1
            goto L_0x0096
        L_0x007b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.SegmentedByteString.j(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0096:
            if (r8 != r9) goto L_0x00a2
            okio.Segment r7 = r6.b()
            r15.f41320b = r7
            okio.SegmentPool.b(r6)
            goto L_0x00a4
        L_0x00a2:
            r6.f41378b = r8
        L_0x00a4:
            if (r1 != 0) goto L_0x00aa
            okio.Segment r6 = r15.f41320b
            if (r6 != 0) goto L_0x000d
        L_0x00aa:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.t0(r1)
            return r4
        L_0x00b4:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.l0():long");
    }

    public int n0(Options options) {
        Intrinsics.f(options, "options");
        int f2 = okio.internal.Buffer.f(this, options, false, 2, (Object) null);
        if (f2 == -1) {
            return -1;
        }
        skip((long) options.e()[f2].size());
        return f2;
    }

    public int o0() throws EOFException {
        return SegmentedByteString.h(readInt());
    }

    public void p(Buffer buffer, long j2) throws EOFException {
        Intrinsics.f(buffer, "sink");
        if (size() >= j2) {
            buffer.write(this, j2);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    public short p0() throws EOFException {
        return SegmentedByteString.i(readShort());
    }

    public BufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    public final Buffer q(Buffer buffer, long j2, long j3) {
        Intrinsics.f(buffer, "out");
        SegmentedByteString.b(size(), j2, j3);
        if (j3 != 0) {
            buffer.t0(buffer.size() + j3);
            Segment segment = this.f41320b;
            while (true) {
                Intrinsics.c(segment);
                int i2 = segment.f41379c;
                int i3 = segment.f41378b;
                if (j2 < ((long) (i2 - i3))) {
                    break;
                }
                j2 -= (long) (i2 - i3);
                segment = segment.f41382f;
            }
            while (j3 > 0) {
                Intrinsics.c(segment);
                Segment d2 = segment.d();
                int i4 = d2.f41378b + ((int) j2);
                d2.f41378b = i4;
                d2.f41379c = Math.min(i4 + ((int) j3), d2.f41379c);
                Segment segment2 = buffer.f41320b;
                if (segment2 == null) {
                    d2.f41383g = d2;
                    d2.f41382f = d2;
                    buffer.f41320b = d2;
                } else {
                    Intrinsics.c(segment2);
                    Segment segment3 = segment2.f41383g;
                    Intrinsics.c(segment3);
                    segment3.c(d2);
                }
                j3 -= (long) (d2.f41379c - d2.f41378b);
                segment = segment.f41382f;
                j2 = 0;
            }
        }
        return this;
    }

    public String q0(long j2, Charset charset) throws EOFException {
        boolean z2;
        Intrinsics.f(charset, "charset");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0 || j2 > 2147483647L) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        } else if (this.f41321c < j2) {
            throw new EOFException();
        } else if (i2 == 0) {
            return "";
        } else {
            Segment segment = this.f41320b;
            Intrinsics.c(segment);
            int i3 = segment.f41378b;
            if (((long) i3) + j2 > ((long) segment.f41379c)) {
                return new String(G(j2), charset);
            }
            int i4 = (int) j2;
            String str = new String(segment.f41377a, i3, i4, charset);
            int i5 = segment.f41378b + i4;
            segment.f41378b = i5;
            this.f41321c -= j2;
            if (i5 == segment.f41379c) {
                this.f41320b = segment.b();
                SegmentPool.b(segment);
            }
            return str;
        }
    }

    public String r0(long j2) throws EOFException {
        return q0(j2, Charsets.f40513b);
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.f(byteBuffer, "sink");
        Segment segment = this.f41320b;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.f41379c - segment.f41378b);
        byteBuffer.put(segment.f41377a, segment.f41378b, min);
        int i2 = segment.f41378b + min;
        segment.f41378b = i2;
        this.f41321c -= (long) min;
        if (i2 == segment.f41379c) {
            this.f41320b = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.f41320b;
            Intrinsics.c(segment);
            int i2 = segment.f41378b;
            int i3 = segment.f41379c;
            int i4 = i2 + 1;
            byte b2 = segment.f41377a[i2];
            t0(size() - 1);
            if (i4 == i3) {
                this.f41320b = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f41378b = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    public void readFully(byte[] bArr) throws EOFException {
        Intrinsics.f(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read != -1) {
                i2 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.f41320b;
            Intrinsics.c(segment);
            int i2 = segment.f41378b;
            int i3 = segment.f41379c;
            if (((long) (i3 - i2)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f41377a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            t0(size() - 4);
            if (i7 == i3) {
                this.f41320b = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f41378b = i7;
            }
            return b4;
        }
        throw new EOFException();
    }

    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.f41320b;
            Intrinsics.c(segment);
            int i2 = segment.f41378b;
            int i3 = segment.f41379c;
            if (((long) (i3 - i2)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.f41377a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 48) | ((((long) bArr[i5]) & 255) << 40);
            int i7 = i6 + 1;
            long j3 = ((((long) bArr[i6]) & 255) << 32) | j2;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            long j4 = j3 | ((((long) bArr[i7]) & 255) << 24) | ((((long) bArr[i8]) & 255) << 16);
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j5 = j4 | ((((long) bArr[i9]) & 255) << 8) | (((long) bArr[i10]) & 255);
            t0(size() - 8);
            if (i11 == i3) {
                this.f41320b = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f41378b = i11;
            }
            return j5;
        }
        throw new EOFException();
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.f41320b;
            Intrinsics.c(segment);
            int i2 = segment.f41378b;
            int i3 = segment.f41379c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f41377a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            t0(size() - 2);
            if (i5 == i3) {
                this.f41320b = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f41378b = i5;
            }
            return (short) b2;
        }
        throw new EOFException();
    }

    public boolean request(long j2) {
        return this.f41321c >= j2;
    }

    /* renamed from: s */
    public Buffer h() {
        return this;
    }

    public int s0() throws EOFException {
        byte b2;
        int i2;
        byte b3;
        if (size() != 0) {
            byte z2 = z(0);
            boolean z3 = false;
            if ((z2 & y1.f36938c) == 0) {
                b3 = z2 & Byte.MAX_VALUE;
                i2 = 1;
                b2 = 0;
            } else if ((z2 & 224) == 192) {
                b3 = z2 & 31;
                i2 = 2;
                b2 = y1.f36938c;
            } else if ((z2 & 240) == 224) {
                b3 = z2 & 15;
                i2 = 3;
                b2 = 2048;
            } else if ((z2 & 248) == 240) {
                b3 = z2 & 7;
                i2 = 4;
                b2 = 65536;
            } else {
                skip(1);
                return 65533;
            }
            long j2 = (long) i2;
            if (size() >= j2) {
                int i3 = 1;
                while (i3 < i2) {
                    long j3 = (long) i3;
                    byte z4 = z(j3);
                    if ((z4 & 192) == 128) {
                        b3 = (b3 << 6) | (z4 & 63);
                        i3++;
                    } else {
                        skip(j3);
                        return 65533;
                    }
                }
                skip(j2);
                if (b3 > 1114111) {
                    return 65533;
                }
                if (55296 <= b3 && b3 < 57344) {
                    z3 = true;
                }
                if (!z3 && b3 >= b2) {
                    return b3;
                }
                return 65533;
            }
            throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed 0x" + SegmentedByteString.j(z2) + ')');
        }
        throw new EOFException();
    }

    public final long size() {
        return this.f41321c;
    }

    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            Segment segment = this.f41320b;
            if (segment != null) {
                int min = (int) Math.min(j2, (long) (segment.f41379c - segment.f41378b));
                long j3 = (long) min;
                t0(size() - j3);
                j2 -= j3;
                int i2 = segment.f41378b + min;
                segment.f41378b = i2;
                if (i2 == segment.f41379c) {
                    this.f41320b = segment.b();
                    SegmentPool.b(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public String t(long j2) throws EOFException {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            long j3 = Clock.MAX_TIME;
            if (j2 != Clock.MAX_TIME) {
                j3 = j2 + 1;
            }
            long A = A((byte) 10, 0, j3);
            if (A != -1) {
                return okio.internal.Buffer.d(this, A);
            }
            if (j3 < size() && z(j3 - 1) == 13 && z(j3) == 10) {
                return okio.internal.Buffer.d(this, j3);
            }
            Buffer buffer = new Buffer();
            q(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j2) + " content=" + buffer.c0().k() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    public final void t0(long j2) {
        this.f41321c = j2;
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return u0().toString();
    }

    public final ByteString u0() {
        boolean z2;
        if (size() <= 2147483647L) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return v0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    /* renamed from: v */
    public Buffer r() {
        return this;
    }

    public final ByteString v0(int i2) {
        if (i2 == 0) {
            return ByteString.f41332f;
        }
        SegmentedByteString.b(size(), 0, (long) i2);
        Segment segment = this.f41320b;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Intrinsics.c(segment);
            int i6 = segment.f41379c;
            int i7 = segment.f41378b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.f41382f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[(i5 * 2)];
        Segment segment2 = this.f41320b;
        int i8 = 0;
        while (i3 < i2) {
            Intrinsics.c(segment2);
            bArr[i8] = segment2.f41377a;
            i3 += segment2.f41379c - segment2.f41378b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = segment2.f41378b;
            segment2.f41380d = true;
            i8++;
            segment2 = segment2.f41382f;
        }
        return new C0062SegmentedByteString(bArr, iArr);
    }

    public final Segment w0(int i2) {
        boolean z2 = true;
        if (i2 < 1 || i2 > 8192) {
            z2 = false;
        }
        if (z2) {
            Segment segment = this.f41320b;
            if (segment == null) {
                Segment c2 = SegmentPool.c();
                this.f41320b = c2;
                c2.f41383g = c2;
                c2.f41382f = c2;
                return c2;
            }
            Intrinsics.c(segment);
            Segment segment2 = segment.f41383g;
            Intrinsics.c(segment2);
            if (segment2.f41379c + i2 > 8192 || !segment2.f41381e) {
                return segment2.c(SegmentPool.c());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public boolean x(long j2, ByteString byteString) {
        Intrinsics.f(byteString, "bytes");
        return L(j2, byteString, 0, byteString.size());
    }

    /* renamed from: x0 */
    public Buffer h0(ByteString byteString) {
        Intrinsics.f(byteString, "byteString");
        byteString.z(this, 0, byteString.size());
        return this;
    }

    public long y(Source source) throws IOException {
        Intrinsics.f(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    public Buffer y0(Source source, long j2) throws IOException {
        Intrinsics.f(source, "source");
        while (j2 > 0) {
            long read = source.read(this, j2);
            if (read != -1) {
                j2 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public final byte z(long j2) {
        SegmentedByteString.b(size(), j2, 1);
        Segment segment = this.f41320b;
        if (segment == null) {
            Intrinsics.c((Object) null);
            throw null;
        } else if (size() - j2 < j2) {
            long size = size();
            while (size > j2) {
                segment = segment.f41383g;
                Intrinsics.c(segment);
                size -= (long) (segment.f41379c - segment.f41378b);
            }
            Intrinsics.c(segment);
            return segment.f41377a[(int) ((((long) segment.f41378b) + j2) - size)];
        } else {
            long j3 = 0;
            while (true) {
                long j4 = ((long) (segment.f41379c - segment.f41378b)) + j3;
                if (j4 <= j2) {
                    segment = segment.f41382f;
                    Intrinsics.c(segment);
                    j3 = j4;
                } else {
                    Intrinsics.c(segment);
                    return segment.f41377a[(int) ((((long) segment.f41378b) + j2) - j3)];
                }
            }
        }
    }

    /* renamed from: z0 */
    public Buffer write(byte[] bArr) {
        Intrinsics.f(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.f(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i2 = remaining;
        while (i2 > 0) {
            Segment w02 = w0(1);
            int min = Math.min(i2, 8192 - w02.f41379c);
            byteBuffer.get(w02.f41377a, w02.f41379c, min);
            i2 -= min;
            w02.f41379c += min;
        }
        this.f41321c += (long) remaining;
        return remaining;
    }

    public int read(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "sink");
        SegmentedByteString.b((long) bArr.length, (long) i2, (long) i3);
        Segment segment = this.f41320b;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i3, segment.f41379c - segment.f41378b);
        byte[] bArr2 = segment.f41377a;
        int i4 = segment.f41378b;
        byte[] unused = ArraysKt___ArraysJvmKt.e(bArr2, bArr, i2, i4, i4 + min);
        segment.f41378b += min;
        t0(size() - ((long) min));
        if (segment.f41378b == segment.f41379c) {
            this.f41320b = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }

    public void write(Buffer buffer, long j2) {
        Segment segment;
        Intrinsics.f(buffer, "source");
        if (buffer != this) {
            SegmentedByteString.b(buffer.size(), 0, j2);
            while (j2 > 0) {
                Segment segment2 = buffer.f41320b;
                Intrinsics.c(segment2);
                int i2 = segment2.f41379c;
                Segment segment3 = buffer.f41320b;
                Intrinsics.c(segment3);
                if (j2 < ((long) (i2 - segment3.f41378b))) {
                    Segment segment4 = this.f41320b;
                    if (segment4 != null) {
                        Intrinsics.c(segment4);
                        segment = segment4.f41383g;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.f41381e) {
                        if ((((long) segment.f41379c) + j2) - ((long) (segment.f41380d ? 0 : segment.f41378b)) <= 8192) {
                            Segment segment5 = buffer.f41320b;
                            Intrinsics.c(segment5);
                            segment5.g(segment, (int) j2);
                            buffer.t0(buffer.size() - j2);
                            t0(size() + j2);
                            return;
                        }
                    }
                    Segment segment6 = buffer.f41320b;
                    Intrinsics.c(segment6);
                    buffer.f41320b = segment6.e((int) j2);
                }
                Segment segment7 = buffer.f41320b;
                Intrinsics.c(segment7);
                long j3 = (long) (segment7.f41379c - segment7.f41378b);
                buffer.f41320b = segment7.b();
                Segment segment8 = this.f41320b;
                if (segment8 == null) {
                    this.f41320b = segment7;
                    segment7.f41383g = segment7;
                    segment7.f41382f = segment7;
                } else {
                    Intrinsics.c(segment8);
                    Segment segment9 = segment8.f41383g;
                    Intrinsics.c(segment9);
                    segment9.c(segment7).a();
                }
                buffer.t0(buffer.size() - j3);
                t0(size() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public long read(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j2 > size()) {
                j2 = size();
            }
            buffer.write(this, j2);
            return j2;
        }
    }
}

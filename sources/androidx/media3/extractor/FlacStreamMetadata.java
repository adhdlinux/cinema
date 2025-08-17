package androidx.media3.extractor;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import com.startapp.y1;
import java.util.Collections;
import java.util.List;

public final class FlacStreamMetadata {

    /* renamed from: a  reason: collision with root package name */
    public final int f8019a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8020b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8021c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8022d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8023e;

    /* renamed from: f  reason: collision with root package name */
    public final int f8024f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8025g;

    /* renamed from: h  reason: collision with root package name */
    public final int f8026h;

    /* renamed from: i  reason: collision with root package name */
    public final int f8027i;

    /* renamed from: j  reason: collision with root package name */
    public final long f8028j;

    /* renamed from: k  reason: collision with root package name */
    public final SeekTable f8029k;

    /* renamed from: l  reason: collision with root package name */
    private final Metadata f8030l;

    public static class SeekTable {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f8031a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f8032b;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.f8031a = jArr;
            this.f8032b = jArr2;
        }
    }

    public FlacStreamMetadata(byte[] bArr, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.p(i2 * 8);
        this.f8019a = parsableBitArray.h(16);
        this.f8020b = parsableBitArray.h(16);
        this.f8021c = parsableBitArray.h(24);
        this.f8022d = parsableBitArray.h(24);
        int h2 = parsableBitArray.h(20);
        this.f8023e = h2;
        this.f8024f = j(h2);
        this.f8025g = parsableBitArray.h(3) + 1;
        int h3 = parsableBitArray.h(5) + 1;
        this.f8026h = h3;
        this.f8027i = e(h3);
        this.f8028j = parsableBitArray.j(36);
        this.f8029k = null;
        this.f8030l = null;
    }

    private static int e(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 != 20) {
            return i2 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int j(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public FlacStreamMetadata a(List<PictureFrame> list) {
        return new FlacStreamMetadata(this.f8019a, this.f8020b, this.f8021c, this.f8022d, this.f8023e, this.f8025g, this.f8026h, this.f8028j, this.f8029k, h(new Metadata((List<? extends Metadata.Entry>) list)));
    }

    public FlacStreamMetadata b(SeekTable seekTable) {
        return new FlacStreamMetadata(this.f8019a, this.f8020b, this.f8021c, this.f8022d, this.f8023e, this.f8025g, this.f8026h, this.f8028j, seekTable, this.f8030l);
    }

    public FlacStreamMetadata c(List<String> list) {
        return new FlacStreamMetadata(this.f8019a, this.f8020b, this.f8021c, this.f8022d, this.f8023e, this.f8025g, this.f8026h, this.f8028j, this.f8029k, h(VorbisUtil.d(list)));
    }

    public long d() {
        long j2;
        long j3;
        long j4;
        int i2 = this.f8022d;
        if (i2 > 0) {
            j3 = (((long) i2) + ((long) this.f8021c)) / 2;
            j4 = 1;
        } else {
            int i3 = this.f8019a;
            if (i3 != this.f8020b || i3 <= 0) {
                j2 = 4096;
            } else {
                j2 = (long) i3;
            }
            j3 = ((j2 * ((long) this.f8025g)) * ((long) this.f8026h)) / 8;
            j4 = 64;
        }
        return j3 + j4;
    }

    public long f() {
        long j2 = this.f8028j;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / ((long) this.f8023e);
    }

    public Format g(byte[] bArr, Metadata metadata) {
        bArr[4] = y1.f36938c;
        int i2 = this.f8022d;
        if (i2 <= 0) {
            i2 = -1;
        }
        return new Format.Builder().o0("audio/flac").f0(i2).N(this.f8025g).p0(this.f8023e).i0(Util.g0(this.f8026h)).b0(Collections.singletonList(bArr)).h0(h(metadata)).K();
    }

    public Metadata h(Metadata metadata) {
        Metadata metadata2 = this.f8030l;
        return metadata2 == null ? metadata : metadata2.c(metadata);
    }

    public long i(long j2) {
        return Util.q((j2 * ((long) this.f8023e)) / 1000000, 0, this.f8028j - 1);
    }

    private FlacStreamMetadata(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, SeekTable seekTable, Metadata metadata) {
        this.f8019a = i2;
        this.f8020b = i3;
        this.f8021c = i4;
        this.f8022d = i5;
        this.f8023e = i6;
        this.f8024f = j(i6);
        this.f8025g = i7;
        this.f8026h = i8;
        this.f8027i = e(i8);
        this.f8028j = j2;
        this.f8029k = seekTable;
        this.f8030l = metadata;
    }
}

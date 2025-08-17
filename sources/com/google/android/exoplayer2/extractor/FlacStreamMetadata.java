package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.startapp.y1;
import java.util.Collections;
import java.util.List;

public final class FlacStreamMetadata {

    /* renamed from: a  reason: collision with root package name */
    public final int f24208a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24209b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24210c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24211d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24212e;

    /* renamed from: f  reason: collision with root package name */
    public final int f24213f;

    /* renamed from: g  reason: collision with root package name */
    public final int f24214g;

    /* renamed from: h  reason: collision with root package name */
    public final int f24215h;

    /* renamed from: i  reason: collision with root package name */
    public final int f24216i;

    /* renamed from: j  reason: collision with root package name */
    public final long f24217j;

    /* renamed from: k  reason: collision with root package name */
    public final SeekTable f24218k;

    /* renamed from: l  reason: collision with root package name */
    private final Metadata f24219l;

    public static class SeekTable {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f24220a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f24221b;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.f24220a = jArr;
            this.f24221b = jArr2;
        }
    }

    public FlacStreamMetadata(byte[] bArr, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.p(i2 * 8);
        this.f24208a = parsableBitArray.h(16);
        this.f24209b = parsableBitArray.h(16);
        this.f24210c = parsableBitArray.h(24);
        this.f24211d = parsableBitArray.h(24);
        int h2 = parsableBitArray.h(20);
        this.f24212e = h2;
        this.f24213f = j(h2);
        this.f24214g = parsableBitArray.h(3) + 1;
        int h3 = parsableBitArray.h(5) + 1;
        this.f24215h = h3;
        this.f24216i = e(h3);
        this.f24217j = parsableBitArray.j(36);
        this.f24218k = null;
        this.f24219l = null;
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
        return new FlacStreamMetadata(this.f24208a, this.f24209b, this.f24210c, this.f24211d, this.f24212e, this.f24214g, this.f24215h, this.f24217j, this.f24218k, h(new Metadata((List<? extends Metadata.Entry>) list)));
    }

    public FlacStreamMetadata b(SeekTable seekTable) {
        return new FlacStreamMetadata(this.f24208a, this.f24209b, this.f24210c, this.f24211d, this.f24212e, this.f24214g, this.f24215h, this.f24217j, seekTable, this.f24219l);
    }

    public FlacStreamMetadata c(List<String> list) {
        return new FlacStreamMetadata(this.f24208a, this.f24209b, this.f24210c, this.f24211d, this.f24212e, this.f24214g, this.f24215h, this.f24217j, this.f24218k, h(VorbisUtil.c(list)));
    }

    public long d() {
        long j2;
        long j3;
        long j4;
        int i2 = this.f24211d;
        if (i2 > 0) {
            j3 = (((long) i2) + ((long) this.f24210c)) / 2;
            j4 = 1;
        } else {
            int i3 = this.f24208a;
            if (i3 != this.f24209b || i3 <= 0) {
                j2 = 4096;
            } else {
                j2 = (long) i3;
            }
            j3 = ((j2 * ((long) this.f24214g)) * ((long) this.f24215h)) / 8;
            j4 = 64;
        }
        return j3 + j4;
    }

    public long f() {
        long j2 = this.f24217j;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / ((long) this.f24212e);
    }

    public Format g(byte[] bArr, Metadata metadata) {
        bArr[4] = y1.f36938c;
        int i2 = this.f24211d;
        if (i2 <= 0) {
            i2 = -1;
        }
        return new Format.Builder().g0("audio/flac").Y(i2).J(this.f24214g).h0(this.f24212e).V(Collections.singletonList(bArr)).Z(h(metadata)).G();
    }

    public Metadata h(Metadata metadata) {
        Metadata metadata2 = this.f24219l;
        return metadata2 == null ? metadata : metadata2.c(metadata);
    }

    public long i(long j2) {
        return Util.r((j2 * ((long) this.f24212e)) / 1000000, 0, this.f24217j - 1);
    }

    private FlacStreamMetadata(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, SeekTable seekTable, Metadata metadata) {
        this.f24208a = i2;
        this.f24209b = i3;
        this.f24210c = i4;
        this.f24211d = i5;
        this.f24212e = i6;
        this.f24213f = j(i6);
        this.f24214g = i7;
        this.f24215h = i8;
        this.f24216i = e(i8);
        this.f24217j = j2;
        this.f24218k = seekTable;
        this.f24219l = metadata;
    }
}

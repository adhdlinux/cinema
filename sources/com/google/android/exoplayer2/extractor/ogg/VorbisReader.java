package com.google.android.exoplayer2.extractor.ogg;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class VorbisReader extends StreamReader {

    /* renamed from: n  reason: collision with root package name */
    private VorbisSetup f24759n;

    /* renamed from: o  reason: collision with root package name */
    private int f24760o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24761p;

    /* renamed from: q  reason: collision with root package name */
    private VorbisUtil.VorbisIdHeader f24762q;

    /* renamed from: r  reason: collision with root package name */
    private VorbisUtil.CommentHeader f24763r;

    static final class VorbisSetup {

        /* renamed from: a  reason: collision with root package name */
        public final VorbisUtil.VorbisIdHeader f24764a;

        /* renamed from: b  reason: collision with root package name */
        public final VorbisUtil.CommentHeader f24765b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f24766c;

        /* renamed from: d  reason: collision with root package name */
        public final VorbisUtil.Mode[] f24767d;

        /* renamed from: e  reason: collision with root package name */
        public final int f24768e;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i2) {
            this.f24764a = vorbisIdHeader;
            this.f24765b = commentHeader;
            this.f24766c = bArr;
            this.f24767d = modeArr;
            this.f24768e = i2;
        }
    }

    VorbisReader() {
    }

    static void n(ParsableByteArray parsableByteArray, long j2) {
        if (parsableByteArray.b() < parsableByteArray.g() + 4) {
            parsableByteArray.R(Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g() + 4));
        } else {
            parsableByteArray.T(parsableByteArray.g() + 4);
        }
        byte[] e2 = parsableByteArray.e();
        e2[parsableByteArray.g() - 4] = (byte) ((int) (j2 & 255));
        e2[parsableByteArray.g() - 3] = (byte) ((int) ((j2 >>> 8) & 255));
        e2[parsableByteArray.g() - 2] = (byte) ((int) ((j2 >>> 16) & 255));
        e2[parsableByteArray.g() - 1] = (byte) ((int) ((j2 >>> 24) & 255));
    }

    private static int o(byte b2, VorbisSetup vorbisSetup) {
        if (!vorbisSetup.f24767d[p(b2, vorbisSetup.f24768e, 1)].f24262a) {
            return vorbisSetup.f24764a.f24272g;
        }
        return vorbisSetup.f24764a.f24273h;
    }

    static int p(byte b2, int i2, int i3) {
        return (b2 >> i3) & (JfifUtil.MARKER_FIRST_BYTE >>> (8 - i2));
    }

    public static boolean r(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.m(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void e(long j2) {
        boolean z2;
        super.e(j2);
        int i2 = 0;
        if (j2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f24761p = z2;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f24762q;
        if (vorbisIdHeader != null) {
            i2 = vorbisIdHeader.f24272g;
        }
        this.f24760o = i2;
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        int i2 = 0;
        if ((parsableByteArray.e()[0] & 1) == 1) {
            return -1;
        }
        int o2 = o(parsableByteArray.e()[0], (VorbisSetup) Assertions.i(this.f24759n));
        if (this.f24761p) {
            i2 = (this.f24760o + o2) / 4;
        }
        long j2 = (long) i2;
        n(parsableByteArray, j2);
        this.f24761p = true;
        this.f24760o = o2;
        return j2;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean i(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws IOException {
        if (this.f24759n != null) {
            Assertions.e(setupData.f24757a);
            return false;
        }
        VorbisSetup q2 = q(parsableByteArray);
        this.f24759n = q2;
        if (q2 == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = q2.f24764a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader.f24275j);
        arrayList.add(q2.f24766c);
        setupData.f24757a = new Format.Builder().g0("audio/vorbis").I(vorbisIdHeader.f24270e).b0(vorbisIdHeader.f24269d).J(vorbisIdHeader.f24267b).h0(vorbisIdHeader.f24268c).V(arrayList).Z(VorbisUtil.c(ImmutableList.o(q2.f24765b.f24260b))).G();
        return true;
    }

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f24759n = null;
            this.f24762q = null;
            this.f24763r = null;
        }
        this.f24760o = 0;
        this.f24761p = false;
    }

    /* access modifiers changed from: package-private */
    public VorbisSetup q(ParsableByteArray parsableByteArray) throws IOException {
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f24762q;
        if (vorbisIdHeader == null) {
            this.f24762q = VorbisUtil.k(parsableByteArray);
            return null;
        }
        VorbisUtil.CommentHeader commentHeader = this.f24763r;
        if (commentHeader == null) {
            this.f24763r = VorbisUtil.i(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.g()];
        System.arraycopy(parsableByteArray.e(), 0, bArr, 0, parsableByteArray.g());
        VorbisUtil.Mode[] l2 = VorbisUtil.l(parsableByteArray, vorbisIdHeader.f24267b);
        return new VorbisSetup(vorbisIdHeader, commentHeader, bArr, l2, VorbisUtil.a(l2.length - 1));
    }
}

package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.facebook.imageutils.JfifUtil;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class VorbisReader extends StreamReader {

    /* renamed from: n  reason: collision with root package name */
    private VorbisSetup f8762n;

    /* renamed from: o  reason: collision with root package name */
    private int f8763o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8764p;

    /* renamed from: q  reason: collision with root package name */
    private VorbisUtil.VorbisIdHeader f8765q;

    /* renamed from: r  reason: collision with root package name */
    private VorbisUtil.CommentHeader f8766r;

    static final class VorbisSetup {

        /* renamed from: a  reason: collision with root package name */
        public final VorbisUtil.VorbisIdHeader f8767a;

        /* renamed from: b  reason: collision with root package name */
        public final VorbisUtil.CommentHeader f8768b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f8769c;

        /* renamed from: d  reason: collision with root package name */
        public final VorbisUtil.Mode[] f8770d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8771e;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i2) {
            this.f8767a = vorbisIdHeader;
            this.f8768b = commentHeader;
            this.f8769c = bArr;
            this.f8770d = modeArr;
            this.f8771e = i2;
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
        if (!vorbisSetup.f8770d[p(b2, vorbisSetup.f8771e, 1)].f8104a) {
            return vorbisSetup.f8767a.f8114g;
        }
        return vorbisSetup.f8767a.f8115h;
    }

    static int p(byte b2, int i2, int i3) {
        return (b2 >> i3) & (JfifUtil.MARKER_FIRST_BYTE >>> (8 - i2));
    }

    public static boolean r(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.o(1, parsableByteArray, true);
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
        this.f8764p = z2;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f8765q;
        if (vorbisIdHeader != null) {
            i2 = vorbisIdHeader.f8114g;
        }
        this.f8763o = i2;
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        int i2 = 0;
        if ((parsableByteArray.e()[0] & 1) == 1) {
            return -1;
        }
        int o2 = o(parsableByteArray.e()[0], (VorbisSetup) Assertions.j(this.f8762n));
        if (this.f8764p) {
            i2 = (this.f8763o + o2) / 4;
        }
        long j2 = (long) i2;
        n(parsableByteArray, j2);
        this.f8764p = true;
        this.f8763o = o2;
        return j2;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean h(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws IOException {
        if (this.f8762n != null) {
            Assertions.f(setupData.f8760a);
            return false;
        }
        VorbisSetup q2 = q(parsableByteArray);
        this.f8762n = q2;
        if (q2 == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = q2.f8767a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader.f8117j);
        arrayList.add(q2.f8769c);
        setupData.f8760a = new Format.Builder().o0("audio/vorbis").M(vorbisIdHeader.f8112e).j0(vorbisIdHeader.f8111d).N(vorbisIdHeader.f8109b).p0(vorbisIdHeader.f8110c).b0(arrayList).h0(VorbisUtil.d(ImmutableList.o(q2.f8768b.f8102b))).K();
        return true;
    }

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f8762n = null;
            this.f8765q = null;
            this.f8766r = null;
        }
        this.f8763o = 0;
        this.f8764p = false;
    }

    /* access modifiers changed from: package-private */
    public VorbisSetup q(ParsableByteArray parsableByteArray) throws IOException {
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f8765q;
        if (vorbisIdHeader == null) {
            this.f8765q = VorbisUtil.l(parsableByteArray);
            return null;
        }
        VorbisUtil.CommentHeader commentHeader = this.f8766r;
        if (commentHeader == null) {
            this.f8766r = VorbisUtil.j(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.g()];
        System.arraycopy(parsableByteArray.e(), 0, bArr, 0, parsableByteArray.g());
        VorbisUtil.Mode[] m2 = VorbisUtil.m(parsableByteArray, vorbisIdHeader.f8109b);
        return new VorbisSetup(vorbisIdHeader, commentHeader, bArr, m2, VorbisUtil.b(m2.length - 1));
    }
}

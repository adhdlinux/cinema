package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.image.ImageDecoder;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import e.x;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class ImageRenderer extends BaseRenderer {
    private int A = 0;
    private int B = 1;
    private Format C;
    private ImageDecoder D;
    private DecoderInputBuffer E;
    private ImageOutput F;
    private Bitmap G;
    private boolean H;
    private TileInfo I;
    private TileInfo J;
    private int K;

    /* renamed from: s  reason: collision with root package name */
    private final ImageDecoder.Factory f6608s;

    /* renamed from: t  reason: collision with root package name */
    private final DecoderInputBuffer f6609t = DecoderInputBuffer.i();

    /* renamed from: u  reason: collision with root package name */
    private final ArrayDeque<OutputStreamInfo> f6610u = new ArrayDeque<>();

    /* renamed from: v  reason: collision with root package name */
    private boolean f6611v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f6612w;

    /* renamed from: x  reason: collision with root package name */
    private OutputStreamInfo f6613x = OutputStreamInfo.f6616c;

    /* renamed from: y  reason: collision with root package name */
    private long f6614y = -9223372036854775807L;

    /* renamed from: z  reason: collision with root package name */
    private long f6615z = -9223372036854775807L;

    private static final class OutputStreamInfo {

        /* renamed from: c  reason: collision with root package name */
        public static final OutputStreamInfo f6616c = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L);

        /* renamed from: a  reason: collision with root package name */
        public final long f6617a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6618b;

        public OutputStreamInfo(long j2, long j3) {
            this.f6617a = j2;
            this.f6618b = j3;
        }
    }

    private static class TileInfo {

        /* renamed from: a  reason: collision with root package name */
        private final int f6619a;

        /* renamed from: b  reason: collision with root package name */
        private final long f6620b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f6621c;

        public TileInfo(int i2, long j2) {
            this.f6619a = i2;
            this.f6620b = j2;
        }

        public long a() {
            return this.f6620b;
        }

        public Bitmap b() {
            return this.f6621c;
        }

        public int c() {
            return this.f6619a;
        }

        public boolean d() {
            return this.f6621c != null;
        }

        public void e(Bitmap bitmap) {
            this.f6621c = bitmap;
        }
    }

    public ImageRenderer(ImageDecoder.Factory factory, ImageOutput imageOutput) {
        super(4);
        this.f6608s = factory;
        this.F = g0(imageOutput);
    }

    private boolean c0(Format format) {
        int c2 = this.f6608s.c(format);
        if (c2 == x.a(4) || c2 == x.a(3)) {
            return true;
        }
        return false;
    }

    private Bitmap d0(int i2) {
        Assertions.j(this.G);
        int width = this.G.getWidth() / ((Format) Assertions.j(this.C)).I;
        int height = this.G.getHeight() / ((Format) Assertions.j(this.C)).J;
        int i3 = this.C.I;
        return Bitmap.createBitmap(this.G, (i2 % i3) * width, (i2 / i3) * height, width, height);
    }

    private boolean e0(long j2, long j3) throws ImageDecoderException, ExoPlaybackException {
        boolean z2;
        Bitmap bitmap;
        if (this.G != null && this.I == null) {
            return false;
        }
        if (this.B == 0 && getState() != 2) {
            return false;
        }
        if (this.G == null) {
            Assertions.j(this.D);
            ImageOutputBuffer a2 = this.D.a();
            if (a2 == null) {
                return false;
            }
            if (((ImageOutputBuffer) Assertions.j(a2)).isEndOfStream()) {
                if (this.A == 3) {
                    n0();
                    Assertions.j(this.C);
                    h0();
                } else {
                    ((ImageOutputBuffer) Assertions.j(a2)).release();
                    if (this.f6610u.isEmpty()) {
                        this.f6612w = true;
                    }
                }
                return false;
            }
            Assertions.k(a2.f6607b, "Non-EOS buffer came back from the decoder without bitmap.");
            this.G = a2.f6607b;
            ((ImageOutputBuffer) Assertions.j(a2)).release();
        }
        if (!this.H || this.G == null || this.I == null) {
            return false;
        }
        Assertions.j(this.C);
        Format format = this.C;
        int i2 = format.I;
        if ((i2 == 1 && format.J == 1) || i2 == -1 || format.J == -1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!this.I.d()) {
            TileInfo tileInfo = this.I;
            if (z2) {
                bitmap = d0(tileInfo.c());
            } else {
                bitmap = (Bitmap) Assertions.j(this.G);
            }
            tileInfo.e(bitmap);
        }
        if (!m0(j2, j3, (Bitmap) Assertions.j(this.I.b()), this.I.a())) {
            return false;
        }
        l0(((TileInfo) Assertions.j(this.I)).a());
        this.B = 3;
        if (!z2 || ((TileInfo) Assertions.j(this.I)).c() == (((Format) Assertions.j(this.C)).J * ((Format) Assertions.j(this.C)).I) - 1) {
            this.G = null;
        }
        this.I = this.J;
        this.J = null;
        return true;
    }

    private boolean f0(long j2) throws ImageDecoderException {
        boolean z2;
        if (this.H && this.I != null) {
            return false;
        }
        FormatHolder I2 = I();
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder == null || this.A == 3 || this.f6611v) {
            return false;
        }
        if (this.E == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) imageDecoder.d();
            this.E = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.A == 2) {
            Assertions.j(this.E);
            this.E.setFlags(4);
            ((ImageDecoder) Assertions.j(this.D)).f(this.E);
            this.E = null;
            this.A = 3;
            return false;
        }
        int Z = Z(I2, this.E, 0);
        if (Z == -5) {
            this.C = (Format) Assertions.j(I2.f5385b);
            this.A = 2;
            return true;
        } else if (Z == -4) {
            this.E.g();
            if (((ByteBuffer) Assertions.j(this.E.f5067d)).remaining() > 0 || ((DecoderInputBuffer) Assertions.j(this.E)).isEndOfStream()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                ((ImageDecoder) Assertions.j(this.D)).f((DecoderInputBuffer) Assertions.j(this.E));
                this.K = 0;
            }
            k0(j2, (DecoderInputBuffer) Assertions.j(this.E));
            if (((DecoderInputBuffer) Assertions.j(this.E)).isEndOfStream()) {
                this.f6611v = true;
                this.E = null;
                return false;
            }
            this.f6615z = Math.max(this.f6615z, ((DecoderInputBuffer) Assertions.j(this.E)).f5069f);
            if (z2) {
                this.E = null;
            } else {
                ((DecoderInputBuffer) Assertions.j(this.E)).clear();
            }
            return !this.H;
        } else if (Z == -3) {
            return false;
        } else {
            throw new IllegalStateException();
        }
    }

    private static ImageOutput g0(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.f6606a : imageOutput;
    }

    @RequiresNonNull({"inputFormat"})
    @EnsuresNonNull({"decoder"})
    private void h0() throws ExoPlaybackException {
        if (c0(this.C)) {
            ImageDecoder imageDecoder = this.D;
            if (imageDecoder != null) {
                imageDecoder.release();
            }
            this.D = this.f6608s.a();
            return;
        }
        throw E(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.C, 4005);
    }

    private boolean i0(TileInfo tileInfo) {
        if (((Format) Assertions.j(this.C)).I == -1 || this.C.J == -1 || tileInfo.c() == (((Format) Assertions.j(this.C)).J * this.C.I) - 1) {
            return true;
        }
        return false;
    }

    private void j0(int i2) {
        this.B = Math.min(this.B, i2);
    }

    private void k0(long j2, DecoderInputBuffer decoderInputBuffer) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (decoderInputBuffer.isEndOfStream()) {
            this.H = true;
            return;
        }
        TileInfo tileInfo = new TileInfo(this.K, decoderInputBuffer.f5069f);
        this.J = tileInfo;
        this.K++;
        if (!this.H) {
            long a2 = tileInfo.a();
            if (a2 - NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS > j2 || j2 > NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS + a2) {
                z2 = false;
            } else {
                z2 = true;
            }
            TileInfo tileInfo2 = this.I;
            if (tileInfo2 == null || tileInfo2.a() > j2 || j2 >= a2) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean i02 = i0((TileInfo) Assertions.j(this.J));
            if (!z2 && !z3 && !i02) {
                z4 = false;
            }
            this.H = z4;
            if (z3 && !z2) {
                return;
            }
        }
        this.I = this.J;
        this.J = null;
    }

    private void l0(long j2) {
        this.f6614y = j2;
        while (!this.f6610u.isEmpty() && j2 >= this.f6610u.peek().f6617a) {
            this.f6613x = this.f6610u.removeFirst();
        }
    }

    private void n0() {
        this.E = null;
        this.A = 0;
        this.f6615z = -9223372036854775807L;
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder != null) {
            imageDecoder.release();
            this.D = null;
        }
    }

    private void o0(ImageOutput imageOutput) {
        this.F = g0(imageOutput);
    }

    private boolean p0() {
        boolean z2;
        if (getState() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i2 = this.B;
        if (i2 == 0) {
            return z2;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.C = null;
        this.f6613x = OutputStreamInfo.f6616c;
        this.f6610u.clear();
        n0();
        this.F.a();
    }

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
        this.B = z3 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) throws ExoPlaybackException {
        j0(1);
        this.f6612w = false;
        this.f6611v = false;
        this.G = null;
        this.I = null;
        this.J = null;
        this.H = false;
        this.E = null;
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder != null) {
            imageDecoder.flush();
        }
        this.f6610u.clear();
    }

    /* access modifiers changed from: protected */
    public void S() {
        n0();
    }

    /* access modifiers changed from: protected */
    public void U() {
        n0();
        j0(1);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r2 >= r5) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X(androidx.media3.common.Format[] r5, long r6, long r8, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r10) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r4 = this;
            super.X(r5, r6, r8, r10)
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r5 = r4.f6613x
            long r5 = r5.f6618b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            java.util.ArrayDeque<androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo> r5 = r4.f6610u
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0029
            long r5 = r4.f6615z
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            long r2 = r4.f6614y
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0029
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0029
            goto L_0x0036
        L_0x0029:
            java.util.ArrayDeque<androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo> r5 = r4.f6610u
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            long r0 = r4.f6615z
            r6.<init>(r0, r8)
            r5.add(r6)
            goto L_0x003d
        L_0x0036:
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r5 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            r5.<init>(r0, r8)
            r4.f6613x = r5
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.X(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    public boolean a() {
        return this.f6612w;
    }

    public int c(Format format) {
        return this.f6608s.c(format);
    }

    public void f(long j2, long j3) throws ExoPlaybackException {
        if (!this.f6612w) {
            if (this.C == null) {
                FormatHolder I2 = I();
                this.f6609t.clear();
                int Z = Z(I2, this.f6609t, 2);
                if (Z == -5) {
                    this.C = (Format) Assertions.j(I2.f5385b);
                    h0();
                } else if (Z == -4) {
                    Assertions.h(this.f6609t.isEndOfStream());
                    this.f6611v = true;
                    this.f6612w = true;
                    return;
                } else {
                    return;
                }
            }
            try {
                TraceUtil.a("drainAndFeedDecoder");
                while (e0(j2, j3)) {
                }
                while (f0(j2)) {
                }
                TraceUtil.b();
            } catch (ImageDecoderException e2) {
                throw E(e2, (Format) null, 4003);
            }
        }
    }

    public String getName() {
        return "ImageRenderer";
    }

    public boolean isReady() {
        int i2 = this.B;
        return i2 == 3 || (i2 == 0 && this.H);
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        ImageOutput imageOutput;
        if (i2 != 15) {
            super.j(i2, obj);
            return;
        }
        if (obj instanceof ImageOutput) {
            imageOutput = (ImageOutput) obj;
        } else {
            imageOutput = null;
        }
        o0(imageOutput);
    }

    /* access modifiers changed from: protected */
    public boolean m0(long j2, long j3, Bitmap bitmap, long j4) throws ExoPlaybackException {
        long j5 = j4 - j2;
        if (!p0() && j5 >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            return false;
        }
        this.F.onImageAvailable(j4 - this.f6613x.f6618b, bitmap);
        return true;
    }
}

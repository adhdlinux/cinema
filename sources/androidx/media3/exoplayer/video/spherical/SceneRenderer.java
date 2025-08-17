package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Http2;

final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f7835b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f7836c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    private final ProjectionRenderer f7837d = new ProjectionRenderer();

    /* renamed from: e  reason: collision with root package name */
    private final FrameRotationQueue f7838e = new FrameRotationQueue();

    /* renamed from: f  reason: collision with root package name */
    private final TimedValueQueue<Long> f7839f = new TimedValueQueue<>();

    /* renamed from: g  reason: collision with root package name */
    private final TimedValueQueue<Projection> f7840g = new TimedValueQueue<>();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f7841h = new float[16];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f7842i = new float[16];

    /* renamed from: j  reason: collision with root package name */
    private int f7843j;

    /* renamed from: k  reason: collision with root package name */
    private SurfaceTexture f7844k;

    /* renamed from: l  reason: collision with root package name */
    private volatile int f7845l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f7846m = -1;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f7847n;

    /* access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f7835b.set(true);
    }

    private void i(byte[] bArr, int i2, long j2) {
        Projection projection;
        byte[] bArr2 = this.f7847n;
        int i3 = this.f7846m;
        this.f7847n = bArr;
        if (i2 == -1) {
            i2 = this.f7845l;
        }
        this.f7846m = i2;
        if (i3 != i2 || !Arrays.equals(bArr2, this.f7847n)) {
            byte[] bArr3 = this.f7847n;
            if (bArr3 != null) {
                projection = ProjectionDecoder.a(bArr3, this.f7846m);
            } else {
                projection = null;
            }
            if (projection == null || !ProjectionRenderer.c(projection)) {
                projection = Projection.b(this.f7846m);
            }
            this.f7840g.a(j2, projection);
        }
    }

    public void b(long j2, float[] fArr) {
        this.f7838e.e(j2, fArr);
    }

    public void c() {
        this.f7839f.c();
        this.f7838e.d();
        this.f7836c.set(true);
    }

    public void d(float[] fArr, boolean z2) {
        GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e2) {
            Log.d("SceneRenderer", "Failed to draw a frame", e2);
        }
        if (this.f7835b.compareAndSet(true, false)) {
            ((SurfaceTexture) Assertions.f(this.f7844k)).updateTexImage();
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e3) {
                Log.d("SceneRenderer", "Failed to draw a frame", e3);
            }
            if (this.f7836c.compareAndSet(true, false)) {
                GlUtil.k(this.f7841h);
            }
            long timestamp = this.f7844k.getTimestamp();
            Long g2 = this.f7839f.g(timestamp);
            if (g2 != null) {
                this.f7838e.c(this.f7841h, g2.longValue());
            }
            Projection j2 = this.f7840g.j(timestamp);
            if (j2 != null) {
                this.f7837d.d(j2);
            }
        }
        Matrix.multiplyMM(this.f7842i, 0, fArr, 0, this.f7841h, 0);
        this.f7837d.a(this.f7843j, this.f7842i, z2);
    }

    public void e(long j2, long j3, Format format, MediaFormat mediaFormat) {
        this.f7839f.a(j3, Long.valueOf(j2));
        i(format.f4026y, format.f4027z, j3);
    }

    public SurfaceTexture f() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.f7837d.b();
            GlUtil.b();
            this.f7843j = GlUtil.f();
        } catch (GlUtil.GlException e2) {
            Log.d("SceneRenderer", "Failed to initialize the renderer", e2);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f7843j);
        this.f7844k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new a(this));
        return this.f7844k;
    }

    public void h(int i2) {
        this.f7845l = i2;
    }
}

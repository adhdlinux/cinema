package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Http2;

final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f29009b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f29010c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    private final ProjectionRenderer f29011d = new ProjectionRenderer();

    /* renamed from: e  reason: collision with root package name */
    private final FrameRotationQueue f29012e = new FrameRotationQueue();

    /* renamed from: f  reason: collision with root package name */
    private final TimedValueQueue<Long> f29013f = new TimedValueQueue<>();

    /* renamed from: g  reason: collision with root package name */
    private final TimedValueQueue<Projection> f29014g = new TimedValueQueue<>();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f29015h = new float[16];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f29016i = new float[16];

    /* renamed from: j  reason: collision with root package name */
    private int f29017j;

    /* renamed from: k  reason: collision with root package name */
    private SurfaceTexture f29018k;

    /* renamed from: l  reason: collision with root package name */
    private volatile int f29019l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f29020m = -1;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f29021n;

    /* access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f29009b.set(true);
    }

    private void i(byte[] bArr, int i2, long j2) {
        Projection projection;
        byte[] bArr2 = this.f29021n;
        int i3 = this.f29020m;
        this.f29021n = bArr;
        if (i2 == -1) {
            i2 = this.f29019l;
        }
        this.f29020m = i2;
        if (i3 != i2 || !Arrays.equals(bArr2, this.f29021n)) {
            byte[] bArr3 = this.f29021n;
            if (bArr3 != null) {
                projection = ProjectionDecoder.a(bArr3, this.f29020m);
            } else {
                projection = null;
            }
            if (projection == null || !ProjectionRenderer.c(projection)) {
                projection = Projection.b(this.f29020m);
            }
            this.f29014g.a(j2, projection);
        }
    }

    public void b(long j2, float[] fArr) {
        this.f29012e.e(j2, fArr);
    }

    public void c() {
        this.f29013f.c();
        this.f29012e.d();
        this.f29010c.set(true);
    }

    public void d(float[] fArr, boolean z2) {
        GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e2) {
            Log.d("SceneRenderer", "Failed to draw a frame", e2);
        }
        if (this.f29009b.compareAndSet(true, false)) {
            ((SurfaceTexture) Assertions.e(this.f29018k)).updateTexImage();
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e3) {
                Log.d("SceneRenderer", "Failed to draw a frame", e3);
            }
            if (this.f29010c.compareAndSet(true, false)) {
                GlUtil.j(this.f29015h);
            }
            long timestamp = this.f29018k.getTimestamp();
            Long g2 = this.f29013f.g(timestamp);
            if (g2 != null) {
                this.f29012e.c(this.f29015h, g2.longValue());
            }
            Projection j2 = this.f29014g.j(timestamp);
            if (j2 != null) {
                this.f29011d.d(j2);
            }
        }
        Matrix.multiplyMM(this.f29016i, 0, fArr, 0, this.f29015h, 0);
        this.f29011d.a(this.f29017j, this.f29016i, z2);
    }

    public void e(long j2, long j3, Format format, MediaFormat mediaFormat) {
        this.f29013f.a(j3, Long.valueOf(j2));
        i(format.f23081w, format.f23082x, j3);
    }

    public SurfaceTexture f() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.f29011d.b();
            GlUtil.b();
            this.f29017j = GlUtil.f();
        } catch (GlUtil.GlException e2) {
            Log.d("SceneRenderer", "Failed to initialize the renderer", e2);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f29017j);
        this.f29018k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new a(this));
        return this.f29018k;
    }

    public void h(int i2) {
        this.f29019l = i2;
    }
}

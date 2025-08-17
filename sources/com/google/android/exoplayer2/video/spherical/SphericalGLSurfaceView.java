package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.OrientationListener;
import com.google.android.exoplayer2.video.spherical.TouchTracker;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f29022n = 0;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<VideoSurfaceListener> f29023b;

    /* renamed from: c  reason: collision with root package name */
    private final SensorManager f29024c;

    /* renamed from: d  reason: collision with root package name */
    private final Sensor f29025d;

    /* renamed from: e  reason: collision with root package name */
    private final OrientationListener f29026e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f29027f;

    /* renamed from: g  reason: collision with root package name */
    private final TouchTracker f29028g;

    /* renamed from: h  reason: collision with root package name */
    private final SceneRenderer f29029h;

    /* renamed from: i  reason: collision with root package name */
    private SurfaceTexture f29030i;

    /* renamed from: j  reason: collision with root package name */
    private Surface f29031j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29032k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f29033l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f29034m;

    final class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {

        /* renamed from: b  reason: collision with root package name */
        private final SceneRenderer f29035b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f29036c = new float[16];

        /* renamed from: d  reason: collision with root package name */
        private final float[] f29037d = new float[16];

        /* renamed from: e  reason: collision with root package name */
        private final float[] f29038e;

        /* renamed from: f  reason: collision with root package name */
        private final float[] f29039f;

        /* renamed from: g  reason: collision with root package name */
        private final float[] f29040g;

        /* renamed from: h  reason: collision with root package name */
        private float f29041h;

        /* renamed from: i  reason: collision with root package name */
        private float f29042i;

        /* renamed from: j  reason: collision with root package name */
        private final float[] f29043j;

        /* renamed from: k  reason: collision with root package name */
        private final float[] f29044k;

        public Renderer(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.f29038e = fArr;
            float[] fArr2 = new float[16];
            this.f29039f = fArr2;
            float[] fArr3 = new float[16];
            this.f29040g = fArr3;
            this.f29043j = new float[16];
            this.f29044k = new float[16];
            this.f29035b = sceneRenderer;
            GlUtil.j(fArr);
            GlUtil.j(fArr2);
            GlUtil.j(fArr3);
            this.f29042i = 3.1415927f;
        }

        private float c(float f2) {
            boolean z2;
            if (f2 > 1.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f2))) * 2.0d);
            }
            return 90.0f;
        }

        private void d() {
            Matrix.setRotateM(this.f29039f, 0, -this.f29041h, (float) Math.cos((double) this.f29042i), (float) Math.sin((double) this.f29042i), 0.0f);
        }

        public synchronized void a(float[] fArr, float f2) {
            float[] fArr2 = this.f29038e;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f29042i = -f2;
            d();
        }

        public synchronized void b(PointF pointF) {
            this.f29041h = pointF.y;
            d();
            Matrix.setRotateM(this.f29040g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f29044k, 0, this.f29038e, 0, this.f29040g, 0);
                Matrix.multiplyMM(this.f29043j, 0, this.f29039f, 0, this.f29044k, 0);
            }
            Matrix.multiplyMM(this.f29037d, 0, this.f29036c, 0, this.f29043j, 0);
            this.f29035b.d(this.f29037d, false);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = ((float) i2) / ((float) i3);
            Matrix.perspectiveM(this.f29036c, 0, c(f2), f2, 0.1f, 100.0f);
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.g(this.f29035b.f());
        }
    }

    public interface VideoSurfaceListener {
        void r(Surface surface);

        void u(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        Surface surface = this.f29031j;
        if (surface != null) {
            Iterator<VideoSurfaceListener> it2 = this.f29023b.iterator();
            while (it2.hasNext()) {
                it2.next().r(surface);
            }
        }
        h(this.f29030i, surface);
        this.f29030i = null;
        this.f29031j = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f29030i;
        Surface surface = this.f29031j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f29030i = surfaceTexture;
        this.f29031j = surface2;
        Iterator<VideoSurfaceListener> it2 = this.f29023b.iterator();
        while (it2.hasNext()) {
            it2.next().u(surface2);
        }
        h(surfaceTexture2, surface);
    }

    /* access modifiers changed from: private */
    public void g(SurfaceTexture surfaceTexture) {
        this.f29027f.post(new b(this, surfaceTexture));
    }

    private static void h(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void j() {
        boolean z2;
        if (!this.f29032k || !this.f29033l) {
            z2 = false;
        } else {
            z2 = true;
        }
        Sensor sensor = this.f29025d;
        if (sensor != null && z2 != this.f29034m) {
            if (z2) {
                this.f29024c.registerListener(this.f29026e, sensor, 0);
            } else {
                this.f29024c.unregisterListener(this.f29026e);
            }
            this.f29034m = z2;
        }
    }

    public void d(VideoSurfaceListener videoSurfaceListener) {
        this.f29023b.add(videoSurfaceListener);
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f29029h;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f29029h;
    }

    public Surface getVideoSurface() {
        return this.f29031j;
    }

    public void i(VideoSurfaceListener videoSurfaceListener) {
        this.f29023b.remove(videoSurfaceListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29027f.post(new c(this));
    }

    public void onPause() {
        this.f29033l = false;
        j();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f29033l = true;
        j();
    }

    public void setDefaultStereoMode(int i2) {
        this.f29029h.h(i2);
    }

    public void setUseSensorRotation(boolean z2) {
        this.f29032k = z2;
        j();
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29023b = new CopyOnWriteArrayList<>();
        this.f29027f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) Assertions.e(context.getSystemService("sensor"));
        this.f29024c = sensorManager;
        Sensor defaultSensor = Util.f28808a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f29025d = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.f29029h = sceneRenderer;
        Renderer renderer = new Renderer(sceneRenderer);
        TouchTracker touchTracker = new TouchTracker(context, renderer, 25.0f);
        this.f29028g = touchTracker;
        this.f29026e = new OrientationListener(((WindowManager) Assertions.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker, renderer);
        this.f29032k = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker);
    }
}

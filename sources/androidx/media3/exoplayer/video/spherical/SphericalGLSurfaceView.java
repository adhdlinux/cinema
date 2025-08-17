package androidx.media3.exoplayer.video.spherical;

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
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.OrientationListener;
import androidx.media3.exoplayer.video.spherical.TouchTracker;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f7848n = 0;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<VideoSurfaceListener> f7849b;

    /* renamed from: c  reason: collision with root package name */
    private final SensorManager f7850c;

    /* renamed from: d  reason: collision with root package name */
    private final Sensor f7851d;

    /* renamed from: e  reason: collision with root package name */
    private final OrientationListener f7852e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f7853f;

    /* renamed from: g  reason: collision with root package name */
    private final TouchTracker f7854g;

    /* renamed from: h  reason: collision with root package name */
    private final SceneRenderer f7855h;

    /* renamed from: i  reason: collision with root package name */
    private SurfaceTexture f7856i;

    /* renamed from: j  reason: collision with root package name */
    private Surface f7857j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7858k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7859l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7860m;

    final class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {

        /* renamed from: b  reason: collision with root package name */
        private final SceneRenderer f7861b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f7862c = new float[16];

        /* renamed from: d  reason: collision with root package name */
        private final float[] f7863d = new float[16];

        /* renamed from: e  reason: collision with root package name */
        private final float[] f7864e;

        /* renamed from: f  reason: collision with root package name */
        private final float[] f7865f;

        /* renamed from: g  reason: collision with root package name */
        private final float[] f7866g;

        /* renamed from: h  reason: collision with root package name */
        private float f7867h;

        /* renamed from: i  reason: collision with root package name */
        private float f7868i;

        /* renamed from: j  reason: collision with root package name */
        private final float[] f7869j;

        /* renamed from: k  reason: collision with root package name */
        private final float[] f7870k;

        public Renderer(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.f7864e = fArr;
            float[] fArr2 = new float[16];
            this.f7865f = fArr2;
            float[] fArr3 = new float[16];
            this.f7866g = fArr3;
            this.f7869j = new float[16];
            this.f7870k = new float[16];
            this.f7861b = sceneRenderer;
            GlUtil.k(fArr);
            GlUtil.k(fArr2);
            GlUtil.k(fArr3);
            this.f7868i = 3.1415927f;
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
            Matrix.setRotateM(this.f7865f, 0, -this.f7867h, (float) Math.cos((double) this.f7868i), (float) Math.sin((double) this.f7868i), 0.0f);
        }

        public synchronized void a(float[] fArr, float f2) {
            float[] fArr2 = this.f7864e;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f7868i = -f2;
            d();
        }

        public synchronized void b(PointF pointF) {
            this.f7867h = pointF.y;
            d();
            Matrix.setRotateM(this.f7866g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f7870k, 0, this.f7864e, 0, this.f7866g, 0);
                Matrix.multiplyMM(this.f7869j, 0, this.f7865f, 0, this.f7870k, 0);
            }
            Matrix.multiplyMM(this.f7863d, 0, this.f7862c, 0, this.f7869j, 0);
            this.f7861b.d(this.f7863d, false);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = ((float) i2) / ((float) i3);
            Matrix.perspectiveM(this.f7862c, 0, c(f2), f2, 0.1f, 100.0f);
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.g(this.f7861b.f());
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
        Surface surface = this.f7857j;
        if (surface != null) {
            Iterator<VideoSurfaceListener> it2 = this.f7849b.iterator();
            while (it2.hasNext()) {
                it2.next().r(surface);
            }
        }
        h(this.f7856i, surface);
        this.f7856i = null;
        this.f7857j = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f7856i;
        Surface surface = this.f7857j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f7856i = surfaceTexture;
        this.f7857j = surface2;
        Iterator<VideoSurfaceListener> it2 = this.f7849b.iterator();
        while (it2.hasNext()) {
            it2.next().u(surface2);
        }
        h(surfaceTexture2, surface);
    }

    /* access modifiers changed from: private */
    public void g(SurfaceTexture surfaceTexture) {
        this.f7853f.post(new b(this, surfaceTexture));
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
        if (!this.f7858k || !this.f7859l) {
            z2 = false;
        } else {
            z2 = true;
        }
        Sensor sensor = this.f7851d;
        if (sensor != null && z2 != this.f7860m) {
            if (z2) {
                this.f7850c.registerListener(this.f7852e, sensor, 0);
            } else {
                this.f7850c.unregisterListener(this.f7852e);
            }
            this.f7860m = z2;
        }
    }

    public void d(VideoSurfaceListener videoSurfaceListener) {
        this.f7849b.add(videoSurfaceListener);
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f7855h;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f7855h;
    }

    public Surface getVideoSurface() {
        return this.f7857j;
    }

    public void i(VideoSurfaceListener videoSurfaceListener) {
        this.f7849b.remove(videoSurfaceListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7853f.post(new c(this));
    }

    public void onPause() {
        this.f7859l = false;
        j();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f7859l = true;
        j();
    }

    public void setDefaultStereoMode(int i2) {
        this.f7855h.h(i2);
    }

    public void setUseSensorRotation(boolean z2) {
        this.f7858k = z2;
        j();
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7849b = new CopyOnWriteArrayList<>();
        this.f7853f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) Assertions.f(context.getSystemService("sensor"));
        this.f7850c = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.f7851d = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.f7855h = sceneRenderer;
        Renderer renderer = new Renderer(sceneRenderer);
        TouchTracker touchTracker = new TouchTracker(context, renderer, 25.0f);
        this.f7854g = touchTracker;
        this.f7852e = new OrientationListener(((WindowManager) Assertions.f((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker, renderer);
        this.f7858k = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker);
    }
}

package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.vungle.ads.internal.protos.Sdk$SDKError;

final class OrientationListener implements SensorEventListener {

    /* renamed from: b  reason: collision with root package name */
    private final float[] f7801b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f7802c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f7803d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private final float[] f7804e = new float[3];

    /* renamed from: f  reason: collision with root package name */
    private final Display f7805f;

    /* renamed from: g  reason: collision with root package name */
    private final Listener[] f7806g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7807h;

    public interface Listener {
        void a(float[] fArr, float f2);
    }

    public OrientationListener(Display display, Listener... listenerArr) {
        this.f7805f = display;
        this.f7806g = listenerArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, this.f7802c);
        SensorManager.getOrientation(this.f7802c, this.f7804e);
        return this.f7804e[2];
    }

    private void b(float[] fArr, float f2) {
        for (Listener a2 : this.f7806g) {
            a2.a(fArr, f2);
        }
    }

    private void c(float[] fArr) {
        if (!this.f7807h) {
            FrameRotationQueue.a(this.f7803d, fArr);
            this.f7807h = true;
        }
        float[] fArr2 = this.f7802c;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f7802c, 0, this.f7803d, 0);
    }

    private void d(float[] fArr, int i2) {
        if (i2 != 0) {
            int i3 = Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
            int i4 = 1;
            if (i2 == 1) {
                i3 = 2;
                i4 = Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
            } else if (i2 == 2) {
                i4 = Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
            } else if (i2 == 3) {
                i3 = Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.f7802c;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f7802c, i3, i4, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f7801b, sensorEvent.values);
        d(this.f7801b, this.f7805f.getRotation());
        float a2 = a(this.f7801b);
        e(this.f7801b);
        c(this.f7801b);
        b(this.f7801b, a2);
    }
}

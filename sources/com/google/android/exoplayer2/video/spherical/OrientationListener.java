package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.vungle.ads.internal.protos.Sdk$SDKError;

final class OrientationListener implements SensorEventListener {

    /* renamed from: b  reason: collision with root package name */
    private final float[] f28975b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f28976c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f28977d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private final float[] f28978e = new float[3];

    /* renamed from: f  reason: collision with root package name */
    private final Display f28979f;

    /* renamed from: g  reason: collision with root package name */
    private final Listener[] f28980g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28981h;

    public interface Listener {
        void a(float[] fArr, float f2);
    }

    public OrientationListener(Display display, Listener... listenerArr) {
        this.f28979f = display;
        this.f28980g = listenerArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, this.f28976c);
        SensorManager.getOrientation(this.f28976c, this.f28978e);
        return this.f28978e[2];
    }

    private void b(float[] fArr, float f2) {
        for (Listener a2 : this.f28980g) {
            a2.a(fArr, f2);
        }
    }

    private void c(float[] fArr) {
        if (!this.f28981h) {
            FrameRotationQueue.a(this.f28977d, fArr);
            this.f28981h = true;
        }
        float[] fArr2 = this.f28976c;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f28976c, 0, this.f28977d, 0);
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
            float[] fArr2 = this.f28976c;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f28976c, i3, i4, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f28975b, sensorEvent.values);
        d(this.f28975b, this.f28979f.getRotation());
        float a2 = a(this.f28975b);
        e(this.f28975b);
        c(this.f28975b);
        b(this.f28975b, a2);
    }
}

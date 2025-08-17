package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;

final class zzcbx implements SensorEventListener {
    private final SensorManager zza;
    private final Object zzb = new Object();
    private final Display zzc;
    private final float[] zzd = new float[9];
    private final float[] zze = new float[9];
    private float[] zzf;
    private Handler zzg;
    private zzcbw zzh;

    zzcbx(Context context) {
        this.zza = (SensorManager) context.getSystemService("sensor");
        this.zzc = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzb) {
                if (this.zzf == null) {
                    this.zzf = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzd, fArr);
            int rotation = this.zzc.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.zzd, 2, Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, this.zze);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.zzd, Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, this.zze);
            } else if (rotation != 3) {
                System.arraycopy(this.zzd, 0, this.zze, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.zzd, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 1, this.zze);
            }
            float[] fArr2 = this.zze;
            float f2 = fArr2[1];
            fArr2[1] = fArr2[3];
            fArr2[3] = f2;
            float f3 = fArr2[2];
            fArr2[2] = fArr2[6];
            fArr2[6] = f3;
            float f4 = fArr2[5];
            fArr2[5] = fArr2[7];
            fArr2[7] = f4;
            synchronized (this.zzb) {
                System.arraycopy(this.zze, 0, this.zzf, 0, 9);
            }
            zzcbw zzcbw = this.zzh;
            if (zzcbw != null) {
                zzcbw.zza();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcbw zzcbw) {
        this.zzh = zzcbw;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (this.zzg == null) {
            Sensor defaultSensor = this.zza.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzbzr.zzg("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            zzfmd zzfmd = new zzfmd(handlerThread.getLooper());
            this.zzg = zzfmd;
            if (!this.zza.registerListener(this, defaultSensor, 0, zzfmd)) {
                zzbzr.zzg("SensorManager.registerListener failed.");
                zzc();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zzg != null) {
            this.zza.unregisterListener(this);
            this.zzg.post(new zzcbv(this));
            this.zzg = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(float[] fArr) {
        synchronized (this.zzb) {
            float[] fArr2 = this.zzf;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, 9);
            return true;
        }
    }
}

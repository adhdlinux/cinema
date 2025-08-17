package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

final class zzyv extends HandlerThread implements Handler.Callback {
    private zzee zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzyx zze;

    public zzyv() {
        super("ExoPlayer:PlaceholderSurface");
    }

    public final boolean handleMessage(Message message) {
        boolean z2;
        int i2 = message.what;
        if (i2 == 1) {
            try {
                int i3 = message.arg1;
                zzee zzee = this.zza;
                zzee.getClass();
                zzee.zzb(i3);
                SurfaceTexture zza2 = this.zza.zza();
                if (i3 != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.zze = new zzyx(this, zza2, z2, (zzyw) null);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e2) {
                zzer.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                this.zzd = e2;
                synchronized (this) {
                    notify();
                }
            } catch (zzef e3) {
                zzer.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                this.zzd = new IllegalStateException(e3);
                synchronized (this) {
                    notify();
                }
            } catch (Error e4) {
                try {
                    zzer.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                    this.zzc = e4;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
            return true;
        } else if (i2 != 2) {
            return true;
        } else {
            try {
                zzee zzee2 = this.zza;
                zzee2.getClass();
                zzee2.zzc();
            } catch (Throwable th2) {
                quit();
                throw th2;
            }
            quit();
            return true;
        }
    }

    public final zzyx zza(int i2) {
        boolean z2;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzee(this.zzb, (zzed) null);
        synchronized (this) {
            z2 = false;
            this.zzb.obtainMessage(1, i2, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzyx zzyx = this.zze;
                zzyx.getClass();
                return zzyx;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

final class zzze implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzze zzb = new zzze();
    public volatile long zza = -9223372036854775807L;
    private final Handler zzc;
    private final HandlerThread zzd;
    private Choreographer zze;
    private int zzf;

    private zzze() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.zzd = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.zzc = handler;
        handler.sendEmptyMessage(0);
    }

    public static zzze zza() {
        return zzb;
    }

    public final void doFrame(long j2) {
        this.zza = j2;
        Choreographer choreographer = this.zze;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            try {
                this.zze = Choreographer.getInstance();
            } catch (RuntimeException e2) {
                zzer.zzg("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e2);
            }
            return true;
        } else if (i2 == 1) {
            Choreographer choreographer = this.zze;
            if (choreographer != null) {
                int i3 = this.zzf + 1;
                this.zzf = i3;
                if (i3 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            Choreographer choreographer2 = this.zze;
            if (choreographer2 != null) {
                int i4 = this.zzf - 1;
                this.zzf = i4;
                if (i4 == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.zza = -9223372036854775807L;
                }
            }
            return true;
        }
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }
}

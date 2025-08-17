package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

public final class zzsn implements zzrp {
    private final MediaCodec zza;
    private ByteBuffer[] zzb;
    private ByteBuffer[] zzc;

    /* synthetic */ zzsn(MediaCodec mediaCodec, zzsm zzsm) {
        this.zza = mediaCodec;
        if (zzfj.zza < 21) {
            this.zzb = mediaCodec.getInputBuffers();
            this.zzc = mediaCodec.getOutputBuffers();
        }
    }

    public final int zza() {
        return this.zza.dequeueInputBuffer(0);
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3) {
                if (zzfj.zza < 21) {
                    this.zzc = this.zza.getOutputBuffers();
                }
                dequeueOutputBuffer = -3;
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    public final ByteBuffer zzf(int i2) {
        if (zzfj.zza >= 21) {
            return this.zza.getInputBuffer(i2);
        }
        return this.zzb[i2];
    }

    public final ByteBuffer zzg(int i2) {
        if (zzfj.zza >= 21) {
            return this.zza.getOutputBuffer(i2);
        }
        return this.zzc[i2];
    }

    public final void zzi() {
        this.zza.flush();
    }

    public final void zzj(int i2, int i3, int i4, long j2, int i5) {
        this.zza.queueInputBuffer(i2, 0, i4, j2, i5);
    }

    public final void zzk(int i2, int i3, zzhm zzhm, long j2, int i4) {
        this.zza.queueSecureInputBuffer(i2, 0, zzhm.zza(), j2, 0);
    }

    public final void zzl() {
        this.zzb = null;
        this.zzc = null;
        this.zza.release();
    }

    public final void zzm(int i2, long j2) {
        this.zza.releaseOutputBuffer(i2, j2);
    }

    public final void zzn(int i2, boolean z2) {
        this.zza.releaseOutputBuffer(i2, z2);
    }

    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzq(int i2) {
        this.zza.setVideoScalingMode(i2);
    }

    public final boolean zzr() {
        return false;
    }
}

package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

final class zzrc implements zzrp {
    private final MediaCodec zza;
    private final zzri zzb;
    private final zzrg zzc;
    private boolean zzd;
    private int zze = 0;

    /* synthetic */ zzrc(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, zzrb zzrb) {
        this.zza = mediaCodec;
        this.zzb = new zzri(handlerThread);
        this.zzc = new zzrg(mediaCodec, handlerThread2);
    }

    static /* synthetic */ void zzh(zzrc zzrc, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        zzrc.zzb.zzf(zzrc.zza);
        int i3 = zzfj.zza;
        Trace.beginSection("configureCodec");
        zzrc.zza.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        Trace.endSection();
        zzrc.zzc.zzg();
        Trace.beginSection("startCodec");
        zzrc.zza.start();
        Trace.endSection();
        zzrc.zze = 1;
    }

    /* access modifiers changed from: private */
    public static String zzs(int i2, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    public final ByteBuffer zzf(int i2) {
        return this.zza.getInputBuffer(i2);
    }

    public final ByteBuffer zzg(int i2) {
        return this.zza.getOutputBuffer(i2);
    }

    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    public final void zzj(int i2, int i3, int i4, long j2, int i5) {
        this.zzc.zzd(i2, 0, i4, j2, i5);
    }

    public final void zzk(int i2, int i3, zzhm zzhm, long j2, int i4) {
        this.zzc.zze(i2, 0, zzhm, j2, 0);
    }

    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzf();
                this.zzb.zzg();
            }
            this.zze = 2;
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
        } catch (Throwable th) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th;
        }
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

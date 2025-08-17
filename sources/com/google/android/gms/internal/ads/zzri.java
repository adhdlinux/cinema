package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

final class zzri extends MediaCodec.Callback {
    private final Object zza = new Object();
    private final HandlerThread zzb;
    private Handler zzc;
    private final zzrm zzd;
    private final zzrm zze;
    private final ArrayDeque zzf;
    private final ArrayDeque zzg;
    private MediaFormat zzh;
    private MediaFormat zzi;
    private MediaCodec.CodecException zzj;
    private long zzk;
    private boolean zzl;
    private IllegalStateException zzm;

    zzri(HandlerThread handlerThread) {
        this.zzb = handlerThread;
        this.zzd = new zzrm();
        this.zze = new zzrm();
        this.zzf = new ArrayDeque();
        this.zzg = new ArrayDeque();
    }

    public static /* synthetic */ void zzd(zzri zzri) {
        synchronized (zzri.zza) {
            if (!zzri.zzl) {
                long j2 = zzri.zzk - 1;
                zzri.zzk = j2;
                int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i2 <= 0) {
                    if (i2 < 0) {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        synchronized (zzri.zza) {
                            zzri.zzm = illegalStateException;
                        }
                        return;
                    }
                    zzri.zzi();
                }
            }
        }
    }

    private final void zzh(MediaFormat mediaFormat) {
        this.zze.zzb(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzi() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        this.zzd.zzc();
        this.zze.zzc();
        this.zzf.clear();
        this.zzg.clear();
    }

    private final void zzj() {
        IllegalStateException illegalStateException = this.zzm;
        if (illegalStateException != null) {
            this.zzm = null;
            throw illegalStateException;
        }
    }

    private final void zzk() {
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
    }

    private final boolean zzl() {
        return this.zzk > 0 || this.zzl;
    }

    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        synchronized (this.zza) {
            this.zzd.zzb(i2);
        }
    }

    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzh(mediaFormat);
                this.zzi = null;
            }
            this.zze.zzb(i2);
            this.zzf.add(bufferInfo);
        }
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzh(mediaFormat);
            this.zzi = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            boolean r1 = r3.zzl()     // Catch:{ all -> 0x0023 }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return r2
        L_0x000c:
            r3.zzj()     // Catch:{ all -> 0x0023 }
            r3.zzk()     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzrm r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            boolean r1 = r1.zzd()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x001b
            goto L_0x0021
        L_0x001b:
            com.google.android.gms.internal.ads.zzrm r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            int r2 = r1.zza()     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return r2
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzri.zza():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zza
            monitor-enter(r0)
            boolean r1 = r9.zzl()     // Catch:{ all -> 0x004e }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r2
        L_0x000c:
            r9.zzj()     // Catch:{ all -> 0x004e }
            r9.zzk()     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.ads.zzrm r1 = r9.zze     // Catch:{ all -> 0x004e }
            boolean r1 = r1.zzd()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r2
        L_0x001c:
            com.google.android.gms.internal.ads.zzrm r1 = r9.zze     // Catch:{ all -> 0x004e }
            int r1 = r1.zza()     // Catch:{ all -> 0x004e }
            if (r1 < 0) goto L_0x003e
            android.media.MediaFormat r2 = r9.zzh     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.ads.zzdy.zzb(r2)     // Catch:{ all -> 0x004e }
            java.util.ArrayDeque r2 = r9.zzf     // Catch:{ all -> 0x004e }
            java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x004e }
            android.media.MediaCodec$BufferInfo r2 = (android.media.MediaCodec.BufferInfo) r2     // Catch:{ all -> 0x004e }
            int r4 = r2.offset     // Catch:{ all -> 0x004e }
            int r5 = r2.size     // Catch:{ all -> 0x004e }
            long r6 = r2.presentationTimeUs     // Catch:{ all -> 0x004e }
            int r8 = r2.flags     // Catch:{ all -> 0x004e }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x004e }
            goto L_0x004c
        L_0x003e:
            r10 = -2
            if (r1 != r10) goto L_0x004c
            java.util.ArrayDeque r1 = r9.zzg     // Catch:{ all -> 0x004e }
            java.lang.Object r1 = r1.remove()     // Catch:{ all -> 0x004e }
            android.media.MediaFormat r1 = (android.media.MediaFormat) r1     // Catch:{ all -> 0x004e }
            r9.zzh = r1     // Catch:{ all -> 0x004e }
            r1 = -2
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r1
        L_0x004e:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzri.zzb(android.media.MediaCodec$BufferInfo):int");
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzk++;
            Handler handler = this.zzc;
            int i2 = zzfj.zza;
            handler.post(new zzrh(this));
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        boolean z2;
        if (this.zzc == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg() {
        synchronized (this.zza) {
            this.zzl = true;
            this.zzb.quit();
            zzi();
        }
    }
}

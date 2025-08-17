package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.lang.reflect.Method;

final class zzpd {
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private boolean zzE;
    private long zzF;
    private long zzG;
    private final zzpc zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    private zzpb zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    public zzpd(zzpc zzpc) {
        this.zza = zzpc;
        int i2 = zzfj.zza;
        try {
            this.zzn = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
    }

    private final long zzl(long j2) {
        return (j2 * ((long) this.zzg)) / 1000000;
    }

    private final long zzm(long j2) {
        return (j2 * 1000000) / ((long) this.zzg);
    }

    private final long zzn() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.zzy;
        if (j2 != -9223372036854775807L) {
            return Math.min(this.zzB, this.zzA + zzl(zzfj.zzm((elapsedRealtime * 1000) - j2, this.zzj)));
        }
        if (elapsedRealtime - this.zzs >= 5) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                long j3 = 0;
                if (this.zzh) {
                    if (playState == 2) {
                        if (playbackHeadPosition == 0) {
                            this.zzv = this.zzt;
                        }
                        playState = 2;
                    }
                    playbackHeadPosition += this.zzv;
                }
                if (zzfj.zza <= 29) {
                    if (playbackHeadPosition != 0) {
                        j3 = playbackHeadPosition;
                    } else if (this.zzt > 0 && playState == 3) {
                        if (this.zzz == -9223372036854775807L) {
                            this.zzz = elapsedRealtime;
                        }
                    }
                    this.zzz = -9223372036854775807L;
                    playbackHeadPosition = j3;
                }
                if (this.zzt > playbackHeadPosition) {
                    this.zzu++;
                }
                this.zzt = playbackHeadPosition;
            }
            this.zzs = elapsedRealtime;
        }
        return this.zzt + (this.zzu << 32);
    }

    private final void zzo() {
        this.zzl = 0;
        this.zzx = 0;
        this.zzw = 0;
        this.zzm = 0;
        this.zzD = 0;
        this.zzG = 0;
        this.zzk = false;
    }

    public final int zza(long j2) {
        return this.zze - ((int) (j2 - (zzn() * ((long) this.zzd))));
    }

    public final long zzb(boolean z2) {
        long j2;
        Method method;
        zzpd zzpd = this;
        AudioTrack audioTrack = zzpd.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - zzpd.zzm >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                long zzm2 = zzpd.zzm(zzn());
                if (zzm2 != 0) {
                    zzpd.zzb[zzpd.zzw] = zzfj.zzn(zzm2, zzpd.zzj) - nanoTime;
                    zzpd.zzw = (zzpd.zzw + 1) % 10;
                    int i2 = zzpd.zzx;
                    if (i2 < 10) {
                        zzpd.zzx = i2 + 1;
                    }
                    zzpd.zzm = nanoTime;
                    zzpd.zzl = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = zzpd.zzx;
                        if (i3 >= i4) {
                            break;
                        }
                        zzpd.zzl += zzpd.zzb[i3] / ((long) i4);
                        i3++;
                    }
                }
            }
            if (!zzpd.zzh) {
                zzpb zzpb = zzpd.zzf;
                zzpb.getClass();
                if (zzpb.zzg(nanoTime)) {
                    long zzb2 = zzpb.zzb();
                    long zza2 = zzpb.zza();
                    long zzm3 = zzpd.zzm(zzn());
                    if (Math.abs(zzb2 - nanoTime) > 5000000) {
                        zzpu zzpu = (zzpu) zzpd.zza;
                        zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + zza2 + ", " + zzb2 + ", " + nanoTime + ", " + zzm3 + ", " + zzpu.zza.zzF() + ", " + zzpu.zza.zzG());
                        zzpb.zzd();
                    } else {
                        zzpb zzpb2 = zzpb;
                        if (Math.abs(zzpd.zzm(zza2) - zzm3) > 5000000) {
                            zzpu zzpu2 = (zzpu) zzpd.zza;
                            zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + zza2 + ", " + zzb2 + ", " + nanoTime + ", " + zzm3 + ", " + zzpu2.zza.zzF() + ", " + zzpu2.zza.zzG());
                            zzpb2.zzd();
                        } else {
                            zzpb2.zzc();
                        }
                    }
                    zzpd = this;
                }
                if (zzpd.zzq && (method = zzpd.zzn) != null && nanoTime - zzpd.zzr >= 500000) {
                    try {
                        AudioTrack audioTrack2 = zzpd.zzc;
                        audioTrack2.getClass();
                        int i5 = zzfj.zza;
                        long intValue = (long) ((Integer) method.invoke(audioTrack2, new Object[0])).intValue();
                        long j3 = zzpd.zzi;
                        Long.signum(intValue);
                        long j4 = (intValue * 1000) - j3;
                        zzpd.zzo = j4;
                        long max = Math.max(j4, 0);
                        zzpd.zzo = max;
                        if (max > 5000000) {
                            zzer.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + max);
                            zzpd.zzo = 0;
                        }
                    } catch (Exception unused) {
                        zzpd.zzn = null;
                    }
                    zzpd.zzr = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzpb zzpb3 = zzpd.zzf;
        zzpb3.getClass();
        boolean zzf2 = zzpb3.zzf();
        if (zzf2) {
            j2 = zzpd.zzm(zzpb3.zza()) + zzfj.zzm(nanoTime2 - zzpb3.zzb(), zzpd.zzj);
        } else {
            if (zzpd.zzx == 0) {
                j2 = zzpd.zzm(zzn());
            } else {
                j2 = zzfj.zzm(zzpd.zzl + nanoTime2, zzpd.zzj);
            }
            if (!z2) {
                j2 = Math.max(0, j2 - zzpd.zzo);
            }
        }
        if (zzpd.zzE != zzf2) {
            zzpd.zzG = zzpd.zzD;
            zzpd.zzF = zzpd.zzC;
        }
        long j5 = nanoTime2 - zzpd.zzG;
        if (j5 < 1000000) {
            long j6 = (j5 * 1000) / 1000000;
            j2 = ((j2 * j6) + ((1000 - j6) * (zzpd.zzF + zzfj.zzm(j5, zzpd.zzj)))) / 1000;
        }
        if (!zzpd.zzk) {
            long j7 = zzpd.zzC;
            if (j2 > j7) {
                zzpd.zzk = true;
                int i6 = zzfj.zza;
                long currentTimeMillis = System.currentTimeMillis() - zzfj.zzq(zzfj.zzn(zzfj.zzq(j2 - j7), zzpd.zzj));
                zzpz zzpz = ((zzpu) zzpd.zza).zza;
                if (zzpz.zzp != null) {
                    ((zzqe) zzpz.zzp).zza.zzc.zzr(currentTimeMillis);
                }
            }
        }
        zzpd.zzD = nanoTime2;
        zzpd.zzC = j2;
        zzpd.zzE = zzf2;
        return j2;
    }

    public final void zzc(long j2) {
        this.zzA = zzn();
        this.zzy = SystemClock.elapsedRealtime() * 1000;
        this.zzB = j2;
    }

    public final void zzd() {
        zzo();
        this.zzc = null;
        this.zzf = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r6
            r2.zze = r7
            com.google.android.gms.internal.ads.zzpb r0 = new com.google.android.gms.internal.ads.zzpb
            r0.<init>(r3)
            r2.zzf = r0
            int r3 = r3.getSampleRate()
            r2.zzg = r3
            r3 = 0
            if (r4 == 0) goto L_0x0025
            int r4 = com.google.android.gms.internal.ads.zzfj.zza
            r0 = 23
            if (r4 >= r0) goto L_0x0025
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L_0x0026
            r4 = 6
            if (r5 != r4) goto L_0x0025
            r5 = 6
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            r2.zzh = r0
            boolean r4 = com.google.android.gms.internal.ads.zzfj.zzD(r5)
            r2.zzq = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003c
            int r7 = r7 / r6
            long r4 = (long) r7
            long r4 = r2.zzm(r4)
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            r2.zzi = r4
            r4 = 0
            r2.zzt = r4
            r2.zzu = r4
            r2.zzv = r4
            r2.zzp = r3
            r2.zzy = r0
            r2.zzz = r0
            r2.zzr = r4
            r2.zzo = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzj = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.zze(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zzf() {
        zzpb zzpb = this.zzf;
        zzpb.getClass();
        zzpb.zze();
    }

    public final boolean zzg(long j2) {
        if (j2 > zzl(zzb(false))) {
            return true;
        }
        if (this.zzh) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzn() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public final boolean zzi(long j2) {
        return this.zzz != -9223372036854775807L && j2 > 0 && SystemClock.elapsedRealtime() - this.zzz >= 200;
    }

    public final boolean zzj(long j2) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzh) {
            if (playState == 2) {
                this.zzp = false;
                return false;
            } else if (playState == 1) {
                if (zzn() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z2 = this.zzp;
        boolean zzg2 = zzg(j2);
        this.zzp = zzg2;
        if (z2 && !zzg2 && playState != 1) {
            zzpc zzpc = this.zza;
            int i2 = this.zze;
            long zzq2 = zzfj.zzq(this.zzi);
            zzpu zzpu = (zzpu) zzpc;
            if (zzpu.zza.zzp != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                zzpz zzpz = zzpu.zza;
                ((zzqe) zzpz.zzp).zza.zzc.zzt(i2, zzq2, elapsedRealtime - zzpz.zzV);
            }
        }
        return true;
    }

    public final boolean zzk() {
        zzo();
        if (this.zzy != -9223372036854775807L) {
            return false;
        }
        zzpb zzpb = this.zzf;
        zzpb.getClass();
        zzpb.zze();
        return true;
    }
}

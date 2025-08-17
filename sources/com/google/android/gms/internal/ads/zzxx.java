package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
final class zzxx extends Handler implements Runnable {
    final /* synthetic */ zzyc zza;
    private final zzxy zzb;
    private final long zzc;
    private zzxu zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzxx(zzyc zzyc, Looper looper, zzxy zzxy, zzxu zzxu, int i2, long j2) {
        super(looper);
        this.zza = zzyc;
        this.zzb = zzxy;
        this.zzd = zzxu;
        this.zzc = j2;
    }

    private final void zzd() {
        this.zze = null;
        zzyc zzyc = this.zza;
        ExecutorService zzd2 = zzyc.zze;
        zzxx zzc2 = zzyc.zzf;
        zzc2.getClass();
        zzd2.execute(zzc2);
    }

    public final void handleMessage(Message message) {
        long j2;
        if (!this.zzi) {
            int i2 = message.what;
            if (i2 == 0) {
                zzd();
            } else if (i2 != 3) {
                this.zza.zzf = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - this.zzc;
                zzxu zzxu = this.zzd;
                zzxu.getClass();
                if (this.zzh) {
                    zzxu.zzI(this.zzb, elapsedRealtime, j3, false);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    try {
                        zzxu.zzJ(this.zzb, elapsedRealtime, j3);
                    } catch (RuntimeException e2) {
                        zzer.zzd("LoadTask", "Unexpected exception handling load completed", e2);
                        this.zza.zzg = new zzyb(e2);
                    }
                } else if (i3 == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.zze = iOException;
                    int i4 = this.zzf + 1;
                    this.zzf = i4;
                    zzxw zzt = zzxu.zzt(this.zzb, elapsedRealtime, j3, iOException, i4);
                    if (zzt.zza == 3) {
                        this.zza.zzg = this.zze;
                    } else if (zzt.zza != 2) {
                        if (zzt.zza == 1) {
                            this.zzf = 1;
                        }
                        if (zzt.zzb != -9223372036854775807L) {
                            j2 = zzt.zzb;
                        } else {
                            j2 = (long) Math.min((this.zzf - 1) * 1000, 5000);
                        }
                        zzc(j2);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z2;
        try {
            synchronized (this) {
                z2 = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z2) {
                int i2 = zzfj.zza;
                Trace.beginSection("load:" + this.zzb.getClass().getSimpleName());
                this.zzb.zzh();
                Trace.endSection();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e2) {
            if (!this.zzi) {
                obtainMessage(2, e2).sendToTarget();
            }
        } catch (Exception e3) {
            if (!this.zzi) {
                zzer.zzd("LoadTask", "Unexpected exception loading stream", e3);
                obtainMessage(2, new zzyb(e3)).sendToTarget();
            }
        } catch (OutOfMemoryError e4) {
            if (!this.zzi) {
                zzer.zzd("LoadTask", "OutOfMemory error loading stream", e4);
                obtainMessage(2, new zzyb(e4)).sendToTarget();
            }
        } catch (Error e5) {
            if (!this.zzi) {
                zzer.zzd("LoadTask", "Unexpected error loading stream", e5);
                obtainMessage(3, e5).sendToTarget();
            }
            throw e5;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void zza(boolean z2) {
        this.zzi = z2;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z2) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z2) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzxu zzxu = this.zzd;
            zzxu.getClass();
            zzxu.zzI(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i2) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i2) {
            throw iOException;
        }
    }

    public final void zzc(long j2) {
        boolean z2;
        if (this.zza.zzf == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        this.zza.zzf = this;
        if (j2 > 0) {
            sendEmptyMessageDelayed(0, j2);
        } else {
            zzd();
        }
    }
}

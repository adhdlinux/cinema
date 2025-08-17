package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzaql;
import com.google.android.gms.internal.ads.zzaqo;
import com.google.android.gms.internal.ads.zzaqr;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzfjb;
import com.google.android.gms.internal.ads.zzfkd;
import com.google.android.gms.internal.ads.zzfkx;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public final class zzi implements Runnable, zzaqo {
    protected boolean zza;
    final CountDownLatch zzb = new CountDownLatch(1);
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzfjb zzi;
    private Context zzj;
    private final Context zzk;
    private zzbzx zzl;
    private final zzbzx zzm;
    private final boolean zzn;
    private int zzo;

    public zzi(Context context, zzbzx zzbzx) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzbzx;
        this.zzm = zzbzx;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = newCachedThreadPool;
        boolean booleanValue = ((Boolean) zzba.zzc().zzb(zzbbm.zzcb)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfjb.zza(context, newCachedThreadPool, booleanValue);
        this.zzf = ((Boolean) zzba.zzc().zzb(zzbbm.zzbX)).booleanValue();
        this.zzg = ((Boolean) zzba.zzc().zzb(zzbbm.zzcc)).booleanValue();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzca)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzdd)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcW)).booleanValue()) {
            zzcae.zza.execute(this);
            return;
        }
        zzay.zzb();
        if (zzbzk.zzu()) {
            zzcae.zza.execute(this);
        } else {
            run();
        }
    }

    private final zzaqo zzj() {
        if (zzi() == 2) {
            return (zzaqo) this.zze.get();
        }
        return (zzaqo) this.zzd.get();
    }

    private final void zzm() {
        zzaqo zzj2 = zzj();
        if (!this.zzc.isEmpty() && zzj2 != null) {
            for (Object[] objArr : this.zzc) {
                int length = objArr.length;
                if (length == 1) {
                    zzj2.zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzj2.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzc.clear();
        }
    }

    private final void zzp(boolean z2) {
        this.zzd.set(zzaqr.zzu(this.zzl.zza, zzq(this.zzj), z2, this.zzo));
    }

    private static final Context zzq(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final void run() {
        boolean z2;
        long currentTimeMillis;
        try {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdd)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z3 = this.zzl.zzd;
            z2 = false;
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaT)).booleanValue() && z3) {
                z2 = true;
            }
            if (zzi() == 1) {
                zzp(z2);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzg(this, z2));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzaql zza2 = zzaql.zza(this.zzl.zza, zzq(this.zzj), z2, this.zzn);
                this.zze.set(zza2);
                if (this.zzg && !zza2.zzr()) {
                    this.zzo = 1;
                    zzp(z2);
                }
            }
        } catch (NullPointerException e2) {
            this.zzo = 1;
            zzp(z2);
            this.zzi.zzc(2031, System.currentTimeMillis() - currentTimeMillis, e2);
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zzb.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzaql.zza(this.zzm.zza, zzq(this.zzk), z2, this.zzn).zzp();
        } catch (NullPointerException e2) {
            this.zzi.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e2);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        Context context = this.zzj;
        zzfjb zzfjb = this.zzi;
        zzh zzh2 = new zzh(this);
        return new zzfkx(this.zzj, zzfkd.zzb(context, zzfjb), zzh2, ((Boolean) zzba.zzc().zzb(zzbbm.zzbY)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e2) {
            zzbzr.zzk("Interrupted during GADSignals creation.", e2);
            return false;
        }
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzaqo zzj2 = zzj();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjn)).booleanValue()) {
            zzt.zzp();
            zzs.zzF(view, 4, (MotionEvent) null);
        }
        if (zzj2 == null) {
            return "";
        }
        zzm();
        return zzj2.zzf(zzq(context), str, view, activity);
    }

    public final String zzg(Context context) {
        zzaqo zzj2;
        if (!zzd() || (zzj2 = zzj()) == null) {
            return "";
        }
        zzm();
        return zzj2.zzg(zzq(context));
    }

    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjm)).booleanValue()) {
            zzaqo zzj2 = zzj();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjn)).booleanValue()) {
                zzt.zzp();
                zzs.zzF(view, 2, (MotionEvent) null);
            }
            if (zzj2 != null) {
                return zzj2.zzh(context, view, activity);
            }
            return "";
        } else if (!zzd()) {
            return "";
        } else {
            zzaqo zzj3 = zzj();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjn)).booleanValue()) {
                zzt.zzp();
                zzs.zzF(view, 2, (MotionEvent) null);
            }
            if (zzj3 != null) {
                return zzj3.zzh(context, view, activity);
            }
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzaqo zzj2 = zzj();
        if (zzj2 != null) {
            zzm();
            zzj2.zzk(motionEvent);
            return;
        }
        this.zzc.add(new Object[]{motionEvent});
    }

    public final void zzl(int i2, int i3, int i4) {
        zzaqo zzj2 = zzj();
        if (zzj2 != null) {
            zzm();
            zzj2.zzl(i2, i3, i4);
            return;
        }
        this.zzc.add(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaqo zzj2;
        if (zzd() && (zzj2 = zzj()) != null) {
            zzj2.zzn(stackTraceElementArr);
        }
    }

    public final void zzo(View view) {
        zzaqo zzj2 = zzj();
        if (zzj2 != null) {
            zzj2.zzo(view);
        }
    }
}

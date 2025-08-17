package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class zzfjk implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfki zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfjb zzf;
    private final long zzg = System.currentTimeMillis();
    private final int zzh;

    public zzfjk(Context context, int i2, int i3, String str, String str2, String str3, zzfjb zzfjb) {
        this.zzb = str;
        this.zzh = i3;
        this.zzc = str2;
        this.zzf = zzfjb;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfki zzfki = new zzfki(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfki;
        this.zzd = new LinkedBlockingQueue();
        zzfki.checkAvailabilityAndConnect();
    }

    static zzfku zza() {
        return new zzfku((byte[]) null, 1);
    }

    private final void zze(int i2, long j2, Exception exc) {
        this.zzf.zzc(i2, System.currentTimeMillis() - j2, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzfkn zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzfku zzf2 = zzd2.zzf(new zzfks(1, this.zzh, this.zzb, this.zzc));
                zze(5011, this.zzg, (Exception) null);
                this.zzd.put(zzf2);
            } catch (Throwable th) {
                zzc();
                this.zze.quit();
                throw th;
            }
            zzc();
            this.zze.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i2) {
        try {
            zze(4011, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfku zzb(int i2) {
        zzfku zzfku;
        try {
            zzfku = (zzfku) this.zzd.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zze(2009, this.zzg, e2);
            zzfku = null;
        }
        zze(AuthApiStatusCodes.AUTH_TOKEN_ERROR, this.zzg, (Exception) null);
        if (zzfku != null) {
            if (zzfku.zzc == 7) {
                zzfjb.zzg(3);
            } else {
                zzfjb.zzg(2);
            }
        }
        if (zzfku == null) {
            return zza();
        }
        return zzfku;
    }

    public final void zzc() {
        zzfki zzfki = this.zza;
        if (zzfki == null) {
            return;
        }
        if (zzfki.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final zzfkn zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}

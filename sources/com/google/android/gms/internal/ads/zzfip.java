package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

public abstract class zzfip extends AsyncTask {
    private zzfiq zza;
    protected final zzfih zzd;

    public zzfip(zzfih zzfih) {
        this.zzd = zzfih;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfiq zzfiq = this.zza;
        if (zzfiq != null) {
            zzfiq.zza(this);
        }
    }

    public final void zzb(zzfiq zzfiq) {
        this.zza = zzfiq;
    }
}

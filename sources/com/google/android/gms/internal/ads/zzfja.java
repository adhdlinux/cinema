package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzfja implements Continuation {
    public final /* synthetic */ zzanc zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzfja(zzanc zzanc, int i2) {
        this.zza = zzanc;
        this.zzb = i2;
    }

    public final Object then(Task task) {
        zzanc zzanc = this.zza;
        int i2 = this.zzb;
        int i3 = zzfjb.zza;
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        zzflc zza2 = ((zzfld) task.getResult()).zza(((zzang) zzanc.zzal()).zzax());
        zza2.zza(i2);
        zza2.zzc();
        return Boolean.TRUE;
    }
}

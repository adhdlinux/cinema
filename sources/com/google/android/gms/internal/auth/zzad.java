package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class zzad extends zzah {
    final /* synthetic */ zzae zza;

    zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final void zzb(Account account) {
        Status status;
        zzae zzae = this.zza;
        if (account != null) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        zzae.setResult(new zzai(status, account));
    }
}

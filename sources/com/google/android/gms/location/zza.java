package com.google.android.gms.location;

import android.os.WorkSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zza {
    private long zza = Long.MIN_VALUE;

    public final zza zza(long j2) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "intervalMillis can't be negative.");
        this.zza = j2;
        return this;
    }

    public final zzb zzb() {
        boolean z2;
        if (this.zza != Long.MIN_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "Must set intervalMillis.");
        return new zzb(this.zza, true, (WorkSource) null, (String) null, (int[]) null, false, (String) null, 0, (String) null);
    }
}

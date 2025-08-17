package com.google.android.gms.internal.cast;

import android.view.Display;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.Status;

final class zzdl implements CastRemoteDisplay.CastRemoteDisplaySessionResult {
    private final Status zza;
    private final Display zzb;

    public zzdl(Display display) {
        this.zza = Status.RESULT_SUCCESS;
        this.zzb = display;
    }

    public zzdl(Status status) {
        this.zza = status;
        this.zzb = null;
    }

    public final Display getPresentationDisplay() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}

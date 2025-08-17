package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class zzaj implements DialogInterface.OnClickListener {
    public final /* synthetic */ AtomicInteger zza;

    public /* synthetic */ zzaj(AtomicInteger atomicInteger) {
        this.zza = atomicInteger;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.set(i2);
    }
}

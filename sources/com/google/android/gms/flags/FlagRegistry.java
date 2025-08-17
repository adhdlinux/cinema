package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.flags.Flag;
import java.util.ArrayList;
import java.util.Collection;

public class FlagRegistry {
    private final Collection<Flag> zza = new ArrayList();
    private final Collection<Flag.StringFlag> zzb = new ArrayList();
    private final Collection<Flag.StringFlag> zzc = new ArrayList();

    @KeepForSdk
    public static void initialize(Context context) {
        Singletons.zza().zzb(context);
    }

    public final void zza(Flag flag) {
        this.zza.add(flag);
    }
}

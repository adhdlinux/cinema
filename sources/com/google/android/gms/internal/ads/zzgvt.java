package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzgvt extends zzgvw {
    final Logger zza;

    public zzgvt(String str) {
        this.zza = Logger.getLogger(str);
    }

    public final void zza(String str) {
        this.zza.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}

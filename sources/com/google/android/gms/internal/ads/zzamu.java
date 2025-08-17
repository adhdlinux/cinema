package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzamu extends zzgvp {
    private static final zzgvw zza = zzgvw.zzb(zzamu.class);

    public zzamu(zzgvq zzgvq, zzamt zzamt) throws IOException {
        zzf(zzgvq, zzgvq.zzc(), zzamt);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}

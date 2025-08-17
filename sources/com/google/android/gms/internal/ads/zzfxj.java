package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

public final class zzfxj {
    private final OutputStream zza;

    private zzfxj(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzfxj zzb(OutputStream outputStream) {
        return new zzfxj(outputStream);
    }

    public final void zza(zzgkx zzgkx) throws IOException {
        try {
            zzgkx.zzaw(this.zza);
        } finally {
            this.zza.close();
        }
    }
}

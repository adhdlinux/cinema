package com.google.android.gms.internal.ads;

import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;

public final class zzaav implements zzabz {
    private final byte[] zza = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];

    public final /* synthetic */ int zze(zzt zzt, int i2, boolean z2) {
        return zzabx.zza(this, zzt, i2, z2);
    }

    public final int zzf(zzt zzt, int i2, boolean z2, int i3) throws IOException {
        int zza2 = zzt.zza(this.zza, 0, Math.min(CodedOutputStream.DEFAULT_BUFFER_SIZE, i2));
        if (zza2 != -1) {
            return zza2;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzk(zzam zzam) {
    }

    public final /* synthetic */ void zzq(zzfa zzfa, int i2) {
        zzabx.zzb(this, zzfa, i2);
    }

    public final void zzr(zzfa zzfa, int i2, int i3) {
        zzfa.zzG(i2);
    }

    public final void zzs(long j2, int i2, int i3, int i4, zzaby zzaby) {
    }
}

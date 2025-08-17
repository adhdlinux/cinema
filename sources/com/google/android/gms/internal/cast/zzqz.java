package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzqy;
import com.google.android.gms.internal.cast.zzqz;
import java.io.IOException;

public abstract class zzqz<MessageType extends zzqz<MessageType, BuilderType>, BuilderType extends zzqy<MessageType, BuilderType>> implements zztp {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zzp(zzua zzua) {
        throw null;
    }

    public final zzrm zzq() {
        try {
            int zzt = zzt();
            zzrm zzrm = zzrm.zzb;
            byte[] bArr = new byte[zzt];
            zzru zzz = zzru.zzz(bArr, 0, zzt);
            zzI(zzz);
            zzz.zzA();
            return new zzrj(bArr);
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e2);
        }
    }
}

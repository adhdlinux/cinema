package com.google.android.gms.internal.cast;

import com.google.android.datatransport.Transformer;
import java.io.IOException;

public final /* synthetic */ class zze implements Transformer {
    public static final /* synthetic */ zze zza = new zze();

    private /* synthetic */ zze() {
    }

    public final Object apply(Object obj) {
        zzmq zzmq = (zzmq) obj;
        try {
            int zzt = zzmq.zzt();
            byte[] bArr = new byte[zzt];
            zzru zzz = zzru.zzz(bArr, 0, zzt);
            zzmq.zzI(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e2) {
            String name = zzmq.getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e2);
        }
    }
}

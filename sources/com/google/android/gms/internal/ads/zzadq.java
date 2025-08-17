package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class zzadq {
    private final ByteArrayOutputStream zza;
    private final DataOutputStream zzb;

    public zzadq() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.zza = byteArrayOutputStream;
        this.zzb = new DataOutputStream(byteArrayOutputStream);
    }

    private static void zzb(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final byte[] zza(zzadp zzadp) {
        this.zza.reset();
        try {
            zzb(this.zzb, zzadp.zza);
            String str = zzadp.zzb;
            if (str == null) {
                str = "";
            }
            zzb(this.zzb, str);
            this.zzb.writeLong(zzadp.zzc);
            this.zzb.writeLong(zzadp.zzd);
            this.zzb.write(zzadp.zze);
            this.zzb.flush();
            return this.zza.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}

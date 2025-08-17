package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzamn extends ByteArrayOutputStream {
    private final zzamb zza;

    public zzamn(zzamb zzamb, int i2) {
        this.zza = zzamb;
        this.buf = zzamb.zzb(Math.max(i2, UserVerificationMethods.USER_VERIFY_HANDPRINT));
    }

    private final void zza(int i2) {
        int i3 = this.count;
        if (i3 + i2 > this.buf.length) {
            int i4 = i3 + i2;
            byte[] zzb = this.zza.zzb(i4 + i4);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zza.zza(this.buf);
            this.buf = zzb;
        }
    }

    public final void close() throws IOException {
        this.zza.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zza(this.buf);
    }

    public final synchronized void write(int i2) {
        zza(1);
        super.write(i2);
    }

    public final synchronized void write(byte[] bArr, int i2, int i3) {
        zza(i3);
        super.write(bArr, i2, i3);
    }
}

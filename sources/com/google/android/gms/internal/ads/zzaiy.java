package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Arrays;

final class zzaiy {
    public byte[] zza;
    public int zzb;
    private final int zzc;
    private boolean zzd;
    private boolean zze;

    public zzaiy(int i2, int i3) {
        this.zzc = i2;
        byte[] bArr = new byte[Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE];
        this.zza = bArr;
        bArr[2] = 1;
    }

    public final void zza(byte[] bArr, int i2, int i3) {
        if (this.zzd) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.zza;
            int length = bArr2.length;
            int i5 = this.zzb + i4;
            if (length < i5) {
                this.zza = Arrays.copyOf(bArr2, i5 + i5);
            }
            System.arraycopy(bArr, i2, this.zza, this.zzb, i4);
            this.zzb += i4;
        }
    }

    public final void zzb() {
        this.zzd = false;
        this.zze = false;
    }

    public final void zzc(int i2) {
        boolean z2 = true;
        zzdy.zzf(!this.zzd);
        if (i2 != this.zzc) {
            z2 = false;
        }
        this.zzd = z2;
        if (z2) {
            this.zzb = 3;
            this.zze = false;
        }
    }

    public final boolean zzd(int i2) {
        if (!this.zzd) {
            return false;
        }
        this.zzb -= i2;
        this.zzd = false;
        this.zze = true;
        return true;
    }

    public final boolean zze() {
        return this.zze;
    }
}

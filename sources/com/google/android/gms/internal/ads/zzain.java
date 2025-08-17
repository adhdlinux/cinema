package com.google.android.gms.internal.ads;

final class zzain {
    private final zzabz zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzain(zzabz zzabz) {
        this.zza = zzabz;
    }

    public final void zza(byte[] bArr, int i2, int i3) {
        if (this.zzc) {
            int i4 = this.zzf;
            int i5 = (i2 + 1) - i4;
            if (i5 < i3) {
                this.zzd = ((bArr[i5] & 192) >> 6) == 0;
                this.zzc = false;
                return;
            }
            this.zzf = i4 + (i3 - i2);
        }
    }

    public final void zzb(long j2, int i2, boolean z2) {
        if (this.zze == 182 && z2 && this.zzb) {
            long j3 = this.zzh;
            if (j3 != -9223372036854775807L) {
                boolean z3 = this.zzd;
                int i3 = (int) (j2 - this.zzg);
                this.zza.zzs(j3, z3 ? 1 : 0, i3, i2, (zzaby) null);
            }
        }
        if (this.zze != 179) {
            this.zzg = j2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(int r5, long r6) {
        /*
            r4 = this;
            r4.zze = r5
            r0 = 0
            r4.zzd = r0
            r1 = 1
            r2 = 182(0xb6, float:2.55E-43)
            if (r5 == r2) goto L_0x0013
            r3 = 179(0xb3, float:2.51E-43)
            if (r5 != r3) goto L_0x0011
            r5 = 179(0xb3, float:2.51E-43)
            goto L_0x0013
        L_0x0011:
            r3 = 0
            goto L_0x0014
        L_0x0013:
            r3 = 1
        L_0x0014:
            r4.zzb = r3
            if (r5 != r2) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            r4.zzc = r1
            r4.zzf = r0
            r4.zzh = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zzc(int, long):void");
    }

    public final void zzd() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }
}

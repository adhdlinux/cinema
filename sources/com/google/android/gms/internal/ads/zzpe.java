package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzpe extends zzds {
    private int[] zzd;
    private int[] zze;

    zzpe() {
    }

    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
        while (position < limit) {
            for (int i2 : iArr) {
                zzj.putShort(byteBuffer.getShort(i2 + i2 + position));
            }
            position += this.zzb.zze;
        }
        byteBuffer.position(limit);
        zzj.flip();
    }

    public final zzdp zzi(zzdp zzdp) throws zzdq {
        boolean z2;
        boolean z3;
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzdp.zza;
        }
        if (zzdp.zzd == 2) {
            if (zzdp.zzc != iArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i2 = 0;
            while (true) {
                int length = iArr.length;
                if (i2 < length) {
                    int i3 = iArr[i2];
                    if (i3 < zzdp.zzc) {
                        if (i3 != i2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z2 |= z3;
                        i2++;
                    } else {
                        throw new zzdq("Unhandled input format:", zzdp);
                    }
                } else if (z2) {
                    return new zzdp(zzdp.zzb, length, 2);
                } else {
                    return zzdp.zza;
                }
            }
        } else {
            throw new zzdq("Unhandled input format:", zzdp);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zze = this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}

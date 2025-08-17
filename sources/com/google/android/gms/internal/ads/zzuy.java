package com.google.android.gms.internal.ads;

import com.startapp.y1;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

final class zzuy {
    private final zzfa zza = new zzfa(32);
    private zzux zzb;
    private zzux zzc;
    private zzux zzd;
    private long zze;
    private final zzxp zzf;

    public zzuy(zzxp zzxp) {
        this.zzf = zzxp;
        zzux zzux = new zzux(0, 65536);
        this.zzb = zzux;
        this.zzc = zzux;
        this.zzd = zzux;
    }

    private final int zzi(int i2) {
        zzux zzux = this.zzd;
        if (zzux.zzc == null) {
            zzxi zzb2 = this.zzf.zzb();
            zzux zzux2 = new zzux(this.zzd.zzb, 65536);
            zzux.zzc = zzb2;
            zzux.zzd = zzux2;
        }
        return Math.min(i2, (int) (this.zzd.zzb - this.zze));
    }

    private static zzux zzj(zzux zzux, long j2) {
        while (j2 >= zzux.zzb) {
            zzux = zzux.zzd;
        }
        return zzux;
    }

    private static zzux zzk(zzux zzux, long j2, ByteBuffer byteBuffer, int i2) {
        zzux zzj = zzj(zzux, j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j2));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzux zzl(zzux zzux, long j2, byte[] bArr, int i2) {
        zzux zzj = zzj(zzux, j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (zzj.zzb - j2));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            if (j2 == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzux zzm(zzux zzux, zzhp zzhp, zzva zzva, zzfa zzfa) {
        zzux zzux2;
        boolean z2;
        int i2;
        zzhp zzhp2 = zzhp;
        zzva zzva2 = zzva;
        zzfa zzfa2 = zzfa;
        if (zzhp.zzl()) {
            long j2 = zzva2.zzb;
            zzfa2.zzC(1);
            zzux zzl = zzl(zzux, j2, zzfa.zzH(), 1);
            long j3 = j2 + 1;
            byte b2 = zzfa.zzH()[0];
            byte b3 = b2 & y1.f36938c;
            byte b4 = b2 & Byte.MAX_VALUE;
            zzhm zzhm = zzhp2.zza;
            byte[] bArr = zzhm.zza;
            if (bArr == null) {
                zzhm.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            if (b3 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzux2 = zzl(zzl, j3, zzhm.zza, b4);
            long j4 = j3 + ((long) b4);
            if (z2) {
                zzfa2.zzC(2);
                zzux2 = zzl(zzux2, j4, zzfa.zzH(), 2);
                j4 += 2;
                i2 = zzfa.zzo();
            } else {
                i2 = 1;
            }
            int[] iArr = zzhm.zzd;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhm.zze;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z2) {
                int i3 = i2 * 6;
                zzfa2.zzC(i3);
                zzux2 = zzl(zzux2, j4, zzfa.zzH(), i3);
                j4 += (long) i3;
                zzfa2.zzF(0);
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr2[i4] = zzfa.zzo();
                    iArr4[i4] = zzfa.zzn();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzva2.zza - ((int) (j4 - zzva2.zzb));
            }
            zzaby zzaby = zzva2.zzc;
            int i5 = zzfj.zza;
            zzhm.zzc(i2, iArr2, iArr4, zzaby.zzb, zzhm.zza, zzaby.zza, zzaby.zzc, zzaby.zzd);
            long j5 = zzva2.zzb;
            int i6 = (int) (j4 - j5);
            zzva2.zzb = j5 + ((long) i6);
            zzva2.zza -= i6;
        } else {
            zzux2 = zzux;
        }
        if (zzhp.zze()) {
            zzfa2.zzC(4);
            zzux zzl2 = zzl(zzux2, zzva2.zzb, zzfa.zzH(), 4);
            int zzn = zzfa.zzn();
            zzva2.zzb += 4;
            zzva2.zza -= 4;
            zzhp2.zzj(zzn);
            zzux zzk = zzk(zzl2, zzva2.zzb, zzhp2.zzb, zzn);
            zzva2.zzb += (long) zzn;
            int i7 = zzva2.zza - zzn;
            zzva2.zza = i7;
            ByteBuffer byteBuffer = zzhp2.zze;
            if (byteBuffer == null || byteBuffer.capacity() < i7) {
                zzhp2.zze = ByteBuffer.allocate(i7);
            } else {
                zzhp2.zze.clear();
            }
            return zzk(zzk, zzva2.zzb, zzhp2.zze, zzva2.zza);
        }
        zzhp2.zzj(zzva2.zza);
        return zzk(zzux2, zzva2.zzb, zzhp2.zzb, zzva2.zza);
    }

    private final void zzn(int i2) {
        long j2 = this.zze + ((long) i2);
        this.zze = j2;
        zzux zzux = this.zzd;
        if (j2 == zzux.zzb) {
            this.zzd = zzux.zzd;
        }
    }

    public final int zza(zzt zzt, int i2, boolean z2) throws IOException {
        int zzi = zzi(i2);
        zzux zzux = this.zzd;
        int zza2 = zzt.zza(zzux.zzc.zza, zzux.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzn(zza2);
            return zza2;
        } else if (z2) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j2) {
        zzux zzux;
        if (j2 != -1) {
            while (true) {
                zzux = this.zzb;
                if (j2 < zzux.zzb) {
                    break;
                }
                this.zzf.zzc(zzux.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzux.zza) {
                this.zzc = zzux;
            }
        }
    }

    public final void zzd(zzhp zzhp, zzva zzva) {
        zzm(this.zzc, zzhp, zzva, this.zza);
    }

    public final void zze(zzhp zzhp, zzva zzva) {
        this.zzc = zzm(this.zzc, zzhp, zzva, this.zza);
    }

    public final void zzf() {
        zzux zzux = this.zzb;
        if (zzux.zzc != null) {
            this.zzf.zzd(zzux);
            zzux.zzb();
        }
        this.zzb.zze(0, 65536);
        zzux zzux2 = this.zzb;
        this.zzc = zzux2;
        this.zzd = zzux2;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfa zzfa, int i2) {
        while (i2 > 0) {
            int zzi = zzi(i2);
            zzux zzux = this.zzd;
            zzfa.zzB(zzux.zzc.zza, zzux.zza(this.zze), zzi);
            i2 -= zzi;
            zzn(zzi);
        }
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

final class zzue implements zztm, zztl {
    private final zztm[] zza;
    private final IdentityHashMap zzb;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zztl zze;
    private zzvn zzf;
    private zztm[] zzg;
    private zzvh zzh;
    private final zzsz zzi;

    public zzue(zzsz zzsz, long[] jArr, zztm... zztmArr) {
        this.zzi = zzsz;
        this.zza = zztmArr;
        this.zzh = new zzsy(new zzvh[0]);
        this.zzb = new IdentityHashMap();
        this.zzg = new zztm[0];
        for (int i2 = 0; i2 < zztmArr.length; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                this.zza[i2] = new zzuc(zztmArr[i2], j2);
            }
        }
    }

    public final long zza(long j2, zzlm zzlm) {
        zztm zztm;
        zztm[] zztmArr = this.zzg;
        if (zztmArr.length > 0) {
            zztm = zztmArr[0];
        } else {
            zztm = this.zza[0];
        }
        return zztm.zza(j2, zzlm);
    }

    public final long zzb() {
        return this.zzh.zzb();
    }

    public final long zzc() {
        return this.zzh.zzc();
    }

    public final long zzd() {
        long j2 = -9223372036854775807L;
        for (zztm zztm : this.zzg) {
            long zzd2 = zztm.zzd();
            if (zzd2 != -9223372036854775807L) {
                if (j2 == -9223372036854775807L) {
                    zztm[] zztmArr = this.zzg;
                    int length = zztmArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zztm zztm2 = zztmArr[i2];
                        if (zztm2 == zztm) {
                            break;
                        } else if (zztm2.zze(zzd2) == zzd2) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j2 = zzd2;
                } else if (zzd2 != j2) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j2 == -9223372036854775807L || zztm.zze(j2) == j2)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j2;
    }

    public final long zze(long j2) {
        long zze2 = this.zzg[0].zze(j2);
        int i2 = 1;
        while (true) {
            zztm[] zztmArr = this.zzg;
            if (i2 >= zztmArr.length) {
                return zze2;
            }
            if (zztmArr[i2].zze(zze2) == zze2) {
                i2++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final long zzf(zzxa[] zzxaArr, boolean[] zArr, zzvf[] zzvfArr, boolean[] zArr2, long j2) {
        int length;
        Integer num;
        Integer num2;
        int i2;
        zzxa[] zzxaArr2 = zzxaArr;
        zzvf[] zzvfArr2 = zzvfArr;
        int length2 = zzxaArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i3 = 0;
        while (true) {
            length = zzxaArr2.length;
            num = 0;
            if (i3 >= length) {
                break;
            }
            zzvf zzvf = zzvfArr2[i3];
            if (zzvf != null) {
                num = (Integer) this.zzb.get(zzvf);
            }
            if (num == null) {
                i2 = -1;
            } else {
                i2 = num.intValue();
            }
            iArr[i3] = i2;
            zzxa zzxa = zzxaArr2[i3];
            if (zzxa != null) {
                String str = zzxa.zze().zzc;
                iArr2[i3] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i3] = -1;
            }
            i3++;
        }
        this.zzb.clear();
        zzvf[] zzvfArr3 = new zzvf[length];
        zzvf[] zzvfArr4 = new zzvf[length];
        zzxa[] zzxaArr3 = new zzxa[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < this.zza.length) {
            for (int i5 = 0; i5 < zzxaArr2.length; i5++) {
                if (iArr[i5] == i4) {
                    num2 = zzvfArr2[i5];
                } else {
                    num2 = num;
                }
                zzvfArr4[i5] = num2;
                if (iArr2[i5] == i4) {
                    zzxa zzxa2 = zzxaArr2[i5];
                    zzxa2.getClass();
                    zzcy zzcy = (zzcy) this.zzd.get(zzxa2.zze());
                    zzcy.getClass();
                    zzxaArr3[i5] = new zzub(zzxa2, zzcy);
                } else {
                    zzxaArr3[i5] = num;
                }
            }
            int i6 = i4;
            ArrayList arrayList2 = arrayList;
            zzvf[] zzvfArr5 = zzvfArr4;
            zzxa[] zzxaArr4 = zzxaArr3;
            long zzf2 = this.zza[i4].zzf(zzxaArr3, zArr, zzvfArr4, zArr2, j3);
            if (i6 == 0) {
                j3 = zzf2;
            } else if (zzf2 != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i7 = 0; i7 < zzxaArr2.length; i7++) {
                boolean z3 = true;
                if (iArr2[i7] == i6) {
                    zzvf zzvf2 = zzvfArr5[i7];
                    zzvf2.getClass();
                    zzvfArr3[i7] = zzvf2;
                    this.zzb.put(zzvf2, Integer.valueOf(i6));
                    z2 = true;
                } else if (iArr[i7] == i6) {
                    if (zzvfArr5[i7] != null) {
                        z3 = false;
                    }
                    zzdy.zzf(z3);
                }
            }
            if (z2) {
                arrayList2.add(this.zza[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzvfArr4 = zzvfArr5;
            zzxaArr3 = zzxaArr4;
            num = null;
        }
        System.arraycopy(zzvfArr3, 0, zzvfArr2, 0, length);
        zztm[] zztmArr = (zztm[]) arrayList.toArray(new zztm[0]);
        this.zzg = zztmArr;
        this.zzh = new zzsy(zztmArr);
        return j3;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvh) {
        zztm zztm = (zztm) zzvh;
        zztl zztl = this.zze;
        zztl.getClass();
        zztl.zzg(this);
    }

    public final zzvn zzh() {
        zzvn zzvn = this.zzf;
        zzvn.getClass();
        return zzvn;
    }

    public final void zzi(zztm zztm) {
        this.zzc.remove(zztm);
        if (this.zzc.isEmpty()) {
            int i2 = 0;
            for (zztm zzh2 : this.zza) {
                i2 += zzh2.zzh().zzc;
            }
            zzcy[] zzcyArr = new zzcy[i2];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                zztm[] zztmArr = this.zza;
                if (i3 < zztmArr.length) {
                    zzvn zzh3 = zztmArr[i3].zzh();
                    int i5 = zzh3.zzc;
                    int i6 = 0;
                    while (i6 < i5) {
                        zzcy zzb2 = zzh3.zzb(i6);
                        zzcy zzc2 = zzb2.zzc(i3 + ":" + zzb2.zzc);
                        this.zzd.put(zzc2, zzb2);
                        zzcyArr[i4] = zzc2;
                        i6++;
                        i4++;
                    }
                    i3++;
                } else {
                    this.zzf = new zzvn(zzcyArr);
                    zztl zztl = this.zze;
                    zztl.getClass();
                    zztl.zzi(this);
                    return;
                }
            }
        }
    }

    public final void zzj(long j2, boolean z2) {
        for (zztm zzj : this.zzg) {
            zzj.zzj(j2, false);
        }
    }

    public final void zzk() throws IOException {
        for (zztm zzk : this.zza) {
            zzk.zzk();
        }
    }

    public final void zzl(zztl zztl, long j2) {
        this.zze = zztl;
        Collections.addAll(this.zzc, this.zza);
        for (zztm zzl : this.zza) {
            zzl.zzl(this, j2);
        }
    }

    public final void zzm(long j2) {
        this.zzh.zzm(j2);
    }

    public final zztm zzn(int i2) {
        zztm zztm = this.zza[i2];
        if (zztm instanceof zzuc) {
            return ((zzuc) zztm).zza;
        }
        return zztm;
    }

    public final boolean zzo(long j2) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(j2);
        }
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zztm) this.zzc.get(i2)).zzo(j2);
        }
        return false;
    }

    public final boolean zzp() {
        return this.zzh.zzp();
    }
}

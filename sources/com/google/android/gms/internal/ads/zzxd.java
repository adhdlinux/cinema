package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

public abstract class zzxd extends zzxg {
    private zzxc zza;

    /* access modifiers changed from: protected */
    public abstract Pair zzb(zzxc zzxc, int[][][] iArr, int[] iArr2, zzto zzto, zzcw zzcw) throws zzih;

    public final zzxh zzo(zzlk[] zzlkArr, zzvn zzvn, zzto zzto, zzcw zzcw) throws zzih {
        boolean z2;
        boolean z3;
        zzfsc zzfsc;
        int[] iArr;
        boolean z4;
        zzvn zzvn2 = zzvn;
        int[] iArr2 = new int[3];
        zzcy[][] zzcyArr = new zzcy[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = zzvn2.zzc;
            zzcyArr[i2] = new zzcy[i3];
            iArr3[i2] = new int[i3][];
        }
        int i4 = 2;
        int[] iArr4 = new int[2];
        for (int i5 = 0; i5 < 2; i5++) {
            iArr4[i5] = zzlkArr[i5].zze();
        }
        int i6 = 0;
        while (i6 < zzvn2.zzc) {
            zzcy zzb = zzvn2.zzb(i6);
            int i7 = zzb.zzd;
            int i8 = 0;
            int i9 = 2;
            int i10 = 0;
            boolean z5 = true;
            while (i8 < i4) {
                zzlk zzlk = zzlkArr[i8];
                int i11 = 0;
                for (int i12 = 0; i12 <= 0; i12++) {
                    i11 = Math.max(i11, zzlk.zzR(zzb.zzb(i12)) & 7);
                }
                if (iArr2[i8] == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i11 > i10) {
                    z5 = z4;
                    i9 = i8;
                    i10 = i11;
                } else if (i11 == i10 && i7 == 5 && !z5 && z4) {
                    i9 = i8;
                    i10 = i11;
                    z5 = true;
                }
                i8++;
                i4 = 2;
            }
            if (i9 == i4) {
                iArr = new int[1];
            } else {
                zzlk zzlk2 = zzlkArr[i9];
                int[] iArr5 = new int[1];
                for (int i13 = 0; i13 <= 0; i13++) {
                    iArr5[i13] = zzlk2.zzR(zzb.zzb(i13));
                }
                iArr = iArr5;
            }
            int i14 = iArr2[i9];
            zzcyArr[i9][i14] = zzb;
            iArr3[i9][i14] = iArr;
            iArr2[i9] = i14 + 1;
            i6++;
            i4 = 2;
        }
        zzvn[] zzvnArr = new zzvn[i4];
        String[] strArr = new String[i4];
        int[] iArr6 = new int[i4];
        int i15 = 0;
        while (i15 < i4) {
            int i16 = iArr2[i15];
            zzvnArr[i15] = new zzvn((zzcy[]) zzfj.zzG(zzcyArr[i15], i16));
            iArr3[i15] = (int[][]) zzfj.zzG(iArr3[i15], i16);
            strArr[i15] = zzlkArr[i15].zzN();
            iArr6[i15] = zzlkArr[i15].zzb();
            i15++;
            i4 = 2;
        }
        int[] iArr7 = iArr4;
        int[][][] iArr8 = iArr3;
        zzxc zzxc = new zzxc(strArr, iArr6, zzvnArr, iArr7, iArr8, new zzvn((zzcy[]) zzfj.zzG(zzcyArr[2], iArr2[2])));
        Pair zzb2 = zzb(zzxc, iArr3, iArr4, zzto, zzcw);
        zzxe[] zzxeArr = (zzxe[]) zzb2.second;
        List[] listArr = new List[zzxeArr.length];
        for (int i17 = 0; i17 < zzxeArr.length; i17++) {
            zzxe zzxe = zzxeArr[i17];
            if (zzxe != null) {
                zzfsc = zzfsc.zzm(zzxe);
            } else {
                zzfsc = zzfsc.zzl();
            }
            listArr[i17] = zzfsc;
        }
        zzfrz zzfrz = new zzfrz();
        for (int i18 = 0; i18 < 2; i18++) {
            zzvn zzd = zzxc.zzd(i18);
            List list = listArr[i18];
            for (int i19 = 0; i19 < zzd.zzc; i19++) {
                zzcy zzb3 = zzd.zzb(i19);
                if (zzxc.zza(i18, i19, false) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i20 = zzb3.zzb;
                int[] iArr9 = new int[1];
                boolean[] zArr = new boolean[1];
                for (int i21 = 0; i21 <= 0; i21++) {
                    iArr9[i21] = zzxc.zzb(i18, i19, i21) & 7;
                    int i22 = 0;
                    while (true) {
                        if (i22 >= list.size()) {
                            z3 = false;
                            break;
                        }
                        zzxe zzxe2 = (zzxe) list.get(i22);
                        if (zzxe2.zze().equals(zzb3) && zzxe2.zzb(i21) != -1) {
                            z3 = true;
                            break;
                        }
                        i22++;
                    }
                    zArr[i21] = z3;
                }
                zzfrz.zzf(new zzdg(zzb3, z2, iArr9, zArr));
            }
        }
        zzvn zze = zzxc.zze();
        for (int i23 = 0; i23 < zze.zzc; i23++) {
            zzcy zzb4 = zze.zzb(i23);
            int i24 = zzb4.zzb;
            int[] iArr10 = new int[1];
            Arrays.fill(iArr10, 0);
            zzfrz.zzf(new zzdg(zzb4, false, iArr10, new boolean[1]));
        }
        return new zzxh((zzll[]) zzb2.first, (zzxa[]) zzb2.second, new zzdh(zzfrz.zzi()), zzxc);
    }

    public final void zzp(Object obj) {
        this.zza = (zzxc) obj;
    }
}

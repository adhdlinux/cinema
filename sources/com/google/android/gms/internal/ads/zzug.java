package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzug extends zzsx {
    private static final zzbp zza;
    private final zztq[] zzb;
    private final zzcw[] zzc;
    private final ArrayList zzd;
    private final Map zze;
    private final zzfsy zzf;
    private int zzg = -1;
    private long[][] zzh;
    private zzuf zzi;
    private final zzsz zzj;

    static {
        zzar zzar = new zzar();
        zzar.zza("MergingMediaSource");
        zza = zzar.zzc();
    }

    public zzug(boolean z2, boolean z3, zztq... zztqArr) {
        zzsz zzsz = new zzsz();
        this.zzb = zztqArr;
        this.zzj = zzsz;
        this.zzd = new ArrayList(Arrays.asList(zztqArr));
        this.zzc = new zzcw[zztqArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzftg.zzb(8).zzb(2).zza();
    }

    public final void zzF(zztm zztm) {
        zzue zzue = (zzue) zztm;
        int i2 = 0;
        while (true) {
            zztq[] zztqArr = this.zzb;
            if (i2 < zztqArr.length) {
                zztqArr[i2].zzF(zzue.zzn(i2));
                i2++;
            } else {
                return;
            }
        }
    }

    public final zztm zzH(zzto zzto, zzxp zzxp, long j2) {
        int length = this.zzb.length;
        zztm[] zztmArr = new zztm[length];
        int zza2 = this.zzc[0].zza(zzto.zza);
        for (int i2 = 0; i2 < length; i2++) {
            zztmArr[i2] = this.zzb[i2].zzH(zzto.zzc(this.zzc[i2].zzf(zza2)), zzxp, j2 - this.zzh[zza2][i2]);
        }
        return new zzue(this.zzj, this.zzh[zza2], zztmArr);
    }

    public final zzbp zzI() {
        zztq[] zztqArr = this.zzb;
        return zztqArr.length > 0 ? zztqArr[0].zzI() : zza;
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzhg zzhg) {
        super.zzn(zzhg);
        for (int i2 = 0; i2 < this.zzb.length; i2++) {
            zzA(Integer.valueOf(i2), this.zzb[i2]);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzto zzx(Object obj, zzto zzto) {
        if (((Integer) obj).intValue() == 0) {
            return zzto;
        }
        return null;
    }

    public final void zzy() throws IOException {
        zzuf zzuf = this.zzi;
        if (zzuf == null) {
            super.zzy();
            return;
        }
        throw zzuf;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzz(Object obj, zztq zztq, zzcw zzcw) {
        int i2;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i2 = zzcw.zzb();
                this.zzg = i2;
            } else {
                int zzb2 = zzcw.zzb();
                int i3 = this.zzg;
                if (zzb2 != i3) {
                    this.zzi = new zzuf(0);
                    return;
                }
                i2 = i3;
            }
            if (this.zzh.length == 0) {
                int[] iArr = new int[2];
                iArr[1] = this.zzc.length;
                iArr[0] = i2;
                this.zzh = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.zzd.remove(zztq);
            this.zzc[((Integer) obj).intValue()] = zzcw;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }
}

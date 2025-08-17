package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

public final class zzwk extends zzdc {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public final SparseArray zzg;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzh;

    @Deprecated
    public zzwk() {
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    private final void zzv() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
    }

    public final /* synthetic */ zzdc zze(int i2, int i3, boolean z2) {
        super.zze(i2, i3, true);
        return this;
    }

    public final zzwk zzo(int i2, boolean z2) {
        if (this.zzh.get(i2) == z2) {
            return this;
        }
        if (z2) {
            this.zzh.put(i2, true);
        } else {
            this.zzh.delete(i2);
        }
        return this;
    }

    public zzwk(Context context) {
        super.zzd(context);
        Point zzr = zzfj.zzr(context);
        zze(zzr.x, zzr.y, true);
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    /* synthetic */ zzwk(zzwm zzwm, zzwj zzwj) {
        super(zzwm);
        this.zza = zzwm.zzH;
        this.zzb = zzwm.zzJ;
        this.zzc = zzwm.zzL;
        this.zzd = zzwm.zzQ;
        this.zze = zzwm.zzR;
        this.zzf = zzwm.zzT;
        SparseArray zza2 = zzwm.zzam;
        SparseArray sparseArray = new SparseArray();
        for (int i2 = 0; i2 < zza2.size(); i2++) {
            sparseArray.put(zza2.keyAt(i2), new HashMap((Map) zza2.valueAt(i2)));
        }
        this.zzg = sparseArray;
        this.zzh = zzwm.zzan.clone();
    }
}

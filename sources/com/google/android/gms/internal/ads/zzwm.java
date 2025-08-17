package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.Map;

public final class zzwm extends zzdd {
    public static final zzwm zzE;
    @Deprecated
    public static final zzwm zzF;
    public static final zzn zzG = zzwi.zza;
    private static final String zzU = Integer.toString(1000, 36);
    private static final String zzV = Integer.toString(1001, 36);
    private static final String zzW = Integer.toString(1002, 36);
    private static final String zzX = Integer.toString(1003, 36);
    private static final String zzY = Integer.toString(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, 36);
    private static final String zzZ = Integer.toString(1005, 36);
    private static final String zzaa = Integer.toString(1006, 36);
    private static final String zzab = Integer.toString(1007, 36);
    private static final String zzac = Integer.toString(1008, 36);
    private static final String zzad = Integer.toString(1009, 36);
    private static final String zzae = Integer.toString(1010, 36);
    private static final String zzaf = Integer.toString(1011, 36);
    private static final String zzag = Integer.toString(1012, 36);
    private static final String zzah = Integer.toString(1013, 36);
    private static final String zzai = Integer.toString(1014, 36);
    private static final String zzaj = Integer.toString(1015, 36);
    private static final String zzak = Integer.toString(1016, 36);
    private static final String zzal = Integer.toString(1017, 36);
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    /* access modifiers changed from: private */
    public final SparseArray zzam;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzan;

    static {
        zzwm zzwm = new zzwm(new zzwk());
        zzE = zzwm;
        zzF = zzwm;
    }

    private zzwm(zzwk zzwk) {
        super(zzwk);
        this.zzH = zzwk.zza;
        this.zzI = false;
        this.zzJ = zzwk.zzb;
        this.zzK = false;
        this.zzL = zzwk.zzc;
        this.zzM = false;
        this.zzN = false;
        this.zzO = false;
        this.zzP = false;
        this.zzQ = zzwk.zzd;
        this.zzR = zzwk.zze;
        this.zzS = false;
        this.zzT = zzwk.zzf;
        this.zzam = zzwk.zzg;
        this.zzan = zzwk.zzh;
    }

    public static zzwm zzd(Context context) {
        return new zzwm(new zzwk(context));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzwm.class == obj.getClass()) {
            zzwm zzwm = (zzwm) obj;
            if (super.equals(zzwm) && this.zzH == zzwm.zzH && this.zzJ == zzwm.zzJ && this.zzL == zzwm.zzL && this.zzQ == zzwm.zzQ && this.zzR == zzwm.zzR && this.zzT == zzwm.zzT) {
                SparseBooleanArray sparseBooleanArray = this.zzan;
                SparseBooleanArray sparseBooleanArray2 = zzwm.zzan;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            SparseArray sparseArray = this.zzam;
                            SparseArray sparseArray2 = zzwm.zzam;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                int i3 = 0;
                                while (i3 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i3);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzvn zzvn = (zzvn) entry.getKey();
                                                if (map2.containsKey(zzvn)) {
                                                    if (!zzfj.zzC(entry.getValue(), map2.get(zzvn))) {
                                                    }
                                                }
                                            }
                                            i3++;
                                        }
                                    }
                                }
                                return true;
                            }
                        } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((super.hashCode() + 31) * 31) + (this.zzH ? 1 : 0)) * 961) + (this.zzJ ? 1 : 0)) * 961) + (this.zzL ? 1 : 0)) * 28629151) + (this.zzQ ? 1 : 0)) * 31) + (this.zzR ? 1 : 0)) * 961) + (this.zzT ? 1 : 0)) * 31;
    }

    public final zzwk zzc() {
        return new zzwk(this, (zzwj) null);
    }

    @Deprecated
    public final zzwo zze(int i2, zzvn zzvn) {
        Map map = (Map) this.zzam.get(i2);
        if (map != null) {
            return (zzwo) map.get(zzvn);
        }
        return null;
    }

    public final boolean zzf(int i2) {
        return this.zzan.get(i2);
    }

    @Deprecated
    public final boolean zzg(int i2, zzvn zzvn) {
        Map map = (Map) this.zzam.get(i2);
        if (map == null || !map.containsKey(zzvn)) {
            return false;
        }
        return true;
    }
}

package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

final class zzfrl extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    /* access modifiers changed from: private */
    public transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzfrl() {
        zzm(3);
    }

    static /* synthetic */ Object zzh(zzfrl zzfrl) {
        Object obj = zzfrl.zze;
        obj.getClass();
        return obj;
    }

    /* access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzq(Object obj) {
        if (zzo()) {
            return -1;
        }
        int zzb2 = zzfru.zzb(obj);
        int zzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzc2 = zzfrm.zzc(obj2, zzb2 & zzp);
        if (zzc2 != 0) {
            int i2 = ~zzp;
            int i3 = zzb2 & i2;
            do {
                int i4 = zzc2 - 1;
                int[] iArr = this.zza;
                iArr.getClass();
                int i5 = iArr[i4];
                if ((i5 & i2) == i3) {
                    Object[] objArr = this.zzb;
                    objArr.getClass();
                    if (zzfpc.zza(obj, objArr[i4])) {
                        return i4;
                    }
                }
                zzc2 = i5 & zzp;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzr(int i2, int i3, int i4, int i5) {
        int i6 = i3 - 1;
        Object zzd2 = zzfrm.zzd(i3);
        if (i5 != 0) {
            zzfrm.zze(zzd2, i4 & i6, i5 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        for (int i7 = 0; i7 <= i2; i7++) {
            int zzc2 = zzfrm.zzc(obj, i7);
            while (zzc2 != 0) {
                int i8 = zzc2 - 1;
                int i9 = iArr[i8];
                int i10 = ((~i2) & i9) | i7;
                int i11 = i10 & i6;
                int zzc3 = zzfrm.zzc(zzd2, i11);
                zzfrm.zze(zzd2, i11, zzc2);
                iArr[i8] = ((~i6) & i10) | (zzc3 & i6);
                zzc2 = i9 & i2;
            }
        }
        this.zze = zzd2;
        zzt(i6);
        return i6;
    }

    /* access modifiers changed from: private */
    public final Object zzs(Object obj) {
        if (zzo()) {
            return zzd;
        }
        int zzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        int zzb2 = zzfrm.zzb(obj, (Object) null, zzp, obj2, iArr, objArr, (Object[]) null);
        if (zzb2 == -1) {
            return zzd;
        }
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Object obj3 = objArr2[zzb2];
        zzn(zzb2, zzp);
        this.zzg--;
        zzl();
        return obj3;
    }

    private final void zzt(int i2) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i2)) & 31) | (this.zzf & -32);
    }

    public final void clear() {
        if (!zzo()) {
            zzl();
            Map zzj2 = zzj();
            if (zzj2 == null) {
                Object[] objArr = this.zzb;
                objArr.getClass();
                Arrays.fill(objArr, 0, this.zzg, (Object) null);
                Object[] objArr2 = this.zzc;
                objArr2.getClass();
                Arrays.fill(objArr2, 0, this.zzg, (Object) null);
                Object obj = this.zze;
                obj.getClass();
                if (obj instanceof byte[]) {
                    Arrays.fill((byte[]) obj, (byte) 0);
                } else if (obj instanceof short[]) {
                    Arrays.fill((short[]) obj, 0);
                } else {
                    Arrays.fill((int[]) obj, 0);
                }
                int[] iArr = this.zza;
                iArr.getClass();
                Arrays.fill(iArr, 0, this.zzg, 0);
                this.zzg = 0;
                return;
            }
            this.zzf = zzfuk.zzb(size(), 3, 1073741823);
            zzj2.clear();
            this.zze = null;
            this.zzg = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.containsKey(obj);
        }
        if (zzq(obj) == -1) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.zzg; i2++) {
            Object[] objArr = this.zzc;
            objArr.getClass();
            if (zzfpc.zza(obj, objArr[i2])) {
                return true;
            }
        }
        return false;
    }

    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzfrf zzfrf = new zzfrf(this);
        this.zzi = zzfrf;
        return zzfrf;
    }

    public final Object get(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.get(obj);
        }
        int zzq = zzq(obj);
        if (zzq == -1) {
            return null;
        }
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr[zzq];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfri zzfri = new zzfri(this);
        this.zzh = zzfri;
        return zzfri;
    }

    public final Object put(Object obj, Object obj2) {
        int min;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (zzo()) {
            zzfph.zzi(zzo(), "Arrays already allocated");
            int i2 = this.zzf;
            int max = Math.max(i2 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzfrm.zzd(max2);
            zzt(max2 - 1);
            this.zza = new int[i2];
            this.zzb = new Object[i2];
            this.zzc = new Object[i2];
        }
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.put(obj3, obj4);
        }
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int i3 = this.zzg;
        int i4 = i3 + 1;
        int zzb2 = zzfru.zzb(obj);
        int zzp = zzp();
        int i5 = zzb2 & zzp;
        Object obj5 = this.zze;
        obj5.getClass();
        int zzc2 = zzfrm.zzc(obj5, i5);
        if (zzc2 != 0) {
            int i6 = ~zzp;
            int i7 = zzb2 & i6;
            int i8 = 0;
            while (true) {
                int i9 = zzc2 - 1;
                int i10 = iArr[i9];
                int i11 = i10 & i6;
                if (i11 != i7 || !zzfpc.zza(obj3, objArr[i9])) {
                    int i12 = i10 & zzp;
                    i8++;
                    if (i12 != 0) {
                        zzc2 = i12;
                    } else if (i8 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            Object[] objArr3 = this.zzb;
                            objArr3.getClass();
                            Object obj6 = objArr3[zze2];
                            Object[] objArr4 = this.zzc;
                            objArr4.getClass();
                            linkedHashMap.put(obj6, objArr4[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzl();
                        return linkedHashMap.put(obj3, obj4);
                    } else if (i4 > zzp) {
                        zzp = zzr(zzp, zzfrm.zza(zzp), zzb2, i3);
                    } else {
                        iArr[i9] = (i4 & zzp) | i11;
                    }
                } else {
                    Object obj7 = objArr2[i9];
                    objArr2[i9] = obj4;
                    return obj7;
                }
            }
        } else if (i4 > zzp) {
            zzp = zzr(zzp, zzfrm.zza(zzp), zzb2, i3);
        } else {
            Object obj8 = this.zze;
            obj8.getClass();
            zzfrm.zze(obj8, i5, i4);
        }
        int[] iArr2 = this.zza;
        iArr2.getClass();
        int length = iArr2.length;
        if (i4 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            int[] iArr3 = this.zza;
            iArr3.getClass();
            this.zza = Arrays.copyOf(iArr3, min);
            Object[] objArr5 = this.zzb;
            objArr5.getClass();
            this.zzb = Arrays.copyOf(objArr5, min);
            Object[] objArr6 = this.zzc;
            objArr6.getClass();
            this.zzc = Arrays.copyOf(objArr6, min);
        }
        int[] iArr4 = this.zza;
        iArr4.getClass();
        iArr4[i3] = (~zzp) & zzb2;
        Object[] objArr7 = this.zzb;
        objArr7.getClass();
        objArr7[i3] = obj3;
        Object[] objArr8 = this.zzc;
        objArr8.getClass();
        objArr8[i3] = obj4;
        this.zzg = i4;
        zzl();
        return null;
    }

    public final Object remove(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.remove(obj);
        }
        Object zzs = zzs(obj);
        if (zzs == zzd) {
            return null;
        }
        return zzs;
    }

    public final int size() {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.size();
        }
        return this.zzg;
    }

    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzfrk zzfrk = new zzfrk(this);
        this.zzj = zzfrk;
        return zzfrk;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzf(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.zzg) {
            return i3;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final Map zzj() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        this.zzf += 32;
    }

    /* access modifiers changed from: package-private */
    public final void zzm(int i2) {
        this.zzf = zzfuk.zzb(8, 1, 1073741823);
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i2, int i3) {
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int size = size() - 1;
        if (i2 < size) {
            Object obj2 = objArr[size];
            objArr[i2] = obj2;
            objArr2[i2] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            iArr[i2] = iArr[size];
            iArr[size] = 0;
            int zzb2 = zzfru.zzb(obj2) & i3;
            int zzc2 = zzfrm.zzc(obj, zzb2);
            int i4 = size + 1;
            if (zzc2 != i4) {
                while (true) {
                    int i5 = zzc2 - 1;
                    int i6 = iArr[i5];
                    int i7 = i6 & i3;
                    if (i7 != i4) {
                        zzc2 = i7;
                    } else {
                        iArr[i5] = ((i2 + 1) & i3) | (i6 & (~i3));
                        return;
                    }
                }
            } else {
                zzfrm.zze(obj, zzb2, i2 + 1);
            }
        } else {
            objArr[i2] = null;
            objArr2[i2] = null;
            iArr[i2] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzo() {
        return this.zze == null;
    }

    zzfrl(int i2) {
        zzm(8);
    }
}

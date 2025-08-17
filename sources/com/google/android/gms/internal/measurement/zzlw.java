package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzlw {
    private static final Class zza;
    private static final zzml zzb = zzab(false);
    private static final zzml zzc = zzab(true);
    private static final zzml zzd = new zzmn();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzml zzA() {
        return zzc;
    }

    public static zzml zzB() {
        return zzd;
    }

    static Object zzC(int i2, List list, zzkg zzkg, Object obj, zzml zzml) {
        if (zzkg == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = ((Integer) list.get(i4)).intValue();
                if (zzkg.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    obj = zzD(i2, intValue, obj, zzml);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
                return obj;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Integer) it2.next()).intValue();
                if (!zzkg.zza(intValue2)) {
                    obj = zzD(i2, intValue2, obj, zzml);
                    it2.remove();
                }
            }
        }
        return obj;
    }

    static Object zzD(int i2, int i3, Object obj, zzml zzml) {
        if (obj == null) {
            obj = zzml.zze();
        }
        zzml.zzf(obj, i2, (long) i3);
        return obj;
    }

    static void zzE(zzjp zzjp, Object obj, Object obj2) {
        zzjp.zza(obj2);
        throw null;
    }

    static void zzF(zzml zzml, Object obj, Object obj2) {
        zzml.zzh(obj, zzml.zzd(zzml.zzc(obj), zzml.zzc(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzkc.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzc(i2, list, z2);
        }
    }

    public static void zzI(int i2, List list, zznd zznd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zze(i2, list);
        }
    }

    public static void zzJ(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzg(i2, list, z2);
        }
    }

    public static void zzK(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzj(i2, list, z2);
        }
    }

    public static void zzL(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzl(i2, list, z2);
        }
    }

    public static void zzM(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzn(i2, list, z2);
        }
    }

    public static void zzN(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzp(i2, list, z2);
        }
    }

    public static void zzO(int i2, List list, zznd zznd, zzlu zzlu) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((zzjk) zznd).zzq(i2, list.get(i3), zzlu);
            }
        }
    }

    public static void zzP(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzs(i2, list, z2);
        }
    }

    public static void zzQ(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzu(i2, list, z2);
        }
    }

    public static void zzR(int i2, List list, zznd zznd, zzlu zzlu) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((zzjk) zznd).zzv(i2, list.get(i3), zzlu);
            }
        }
    }

    public static void zzS(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzx(i2, list, z2);
        }
    }

    public static void zzT(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzz(i2, list, z2);
        }
    }

    public static void zzU(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzB(i2, list, z2);
        }
    }

    public static void zzV(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzD(i2, list, z2);
        }
    }

    public static void zzW(int i2, List list, zznd zznd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzG(i2, list);
        }
    }

    public static void zzX(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzI(i2, list, z2);
        }
    }

    public static void zzY(int i2, List list, zznd zznd, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzK(i2, list, z2);
        }
    }

    static boolean zzZ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjj.zzA(i2 << 3) + 1);
    }

    static void zzaa(zzle zzle, Object obj, Object obj2, long j2) {
        zzmv.zzs(obj, j2, zzle.zzb(zzmv.zzf(obj, j2), zzmv.zzf(obj2, j2)));
    }

    private static zzml zzab(boolean z2) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzml) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z2)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List list) {
        return list.size();
    }

    static int zzc(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjj.zzz(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzz += zzjj.zzt((zzjb) list.get(i3));
        }
        return zzz;
    }

    static int zzd(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjj.zzz(i2));
    }

    static int zze(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzjj.zzv(zzkd.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzjj.zzv(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzf(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjj.zzA(i2 << 3) + 4);
    }

    static int zzg(List list) {
        return list.size() * 4;
    }

    static int zzh(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjj.zzA(i2 << 3) + 8);
    }

    static int zzi(List list) {
        return list.size() * 8;
    }

    static int zzj(int i2, List list, zzlu zzlu) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzjj.zzu(i2, (zzlj) list.get(i4), zzlu);
        }
        return i3;
    }

    static int zzk(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjj.zzz(i2));
    }

    static int zzl(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzjj.zzv(zzkd.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzjj.zzv(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzm(int i2, List list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjj.zzz(i2));
    }

    static int zzn(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzjj.zzB(zzky.zza(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzjj.zzB(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzo(int i2, Object obj, zzlu zzlu) {
        if (!(obj instanceof zzkp)) {
            return zzjj.zzA(i2 << 3) + zzjj.zzx((zzlj) obj, zzlu);
        }
        int zzA = zzjj.zzA(i2 << 3);
        int zza2 = ((zzkp) obj).zza();
        return zzA + zzjj.zzA(zza2) + zza2;
    }

    static int zzp(int i2, List list, zzlu zzlu) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjj.zzz(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof zzkp) {
                i3 = zzjj.zzw((zzkp) obj);
            } else {
                i3 = zzjj.zzx((zzlj) obj, zzlu);
            }
            zzz += i3;
        }
        return zzz;
    }

    static int zzq(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjj.zzz(i2));
    }

    static int zzr(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i2 = 0;
            while (i3 < size) {
                int zze = zzkd.zze(i3);
                i2 += zzjj.zzA((zze >> 31) ^ (zze + zze));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                int intValue = ((Integer) list.get(i3)).intValue();
                i4 = i2 + zzjj.zzA((intValue >> 31) ^ (intValue + intValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzs(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjj.zzz(i2));
    }

    static int zzt(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            i2 = 0;
            while (i3 < size) {
                long zza2 = zzky.zza(i3);
                i2 += zzjj.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                long longValue = ((Long) list.get(i3)).longValue();
                i4 = i2 + zzjj.zzB((longValue >> 63) ^ (longValue + longValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzu(int i2, List list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjj.zzz(i2) * size;
        if (list instanceof zzkr) {
            zzkr zzkr = (zzkr) list;
            while (i5 < size) {
                Object zzf = zzkr.zzf(i5);
                if (zzf instanceof zzjb) {
                    i4 = zzjj.zzt((zzjb) zzf);
                } else {
                    i4 = zzjj.zzy((String) zzf);
                }
                zzz += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzjb) {
                    i3 = zzjj.zzt((zzjb) obj);
                } else {
                    i3 = zzjj.zzy((String) obj);
                }
                zzz += i3;
                i5++;
            }
        }
        return zzz;
    }

    static int zzv(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjj.zzz(i2));
    }

    static int zzw(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzjj.zzA(zzkd.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzjj.zzA(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzx(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjj.zzz(i2));
    }

    static int zzy(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzjj.zzB(zzky.zza(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzjj.zzB(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static zzml zzz() {
        return zzb;
    }
}

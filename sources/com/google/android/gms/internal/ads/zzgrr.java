package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgrr {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzgsg zzc;
    private static final zzgsg zzd = new zzgsi();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgsg zzgsg = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzgsg = (zzgsg) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzgsg;
    }

    static Object zzA(Object obj, int i2, List list, zzgpq zzgpq, Object obj2, zzgsg zzgsg) {
        if (zzgpq == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = ((Integer) list.get(i4)).intValue();
                if (zzgpq.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    obj2 = zzB(obj, i2, intValue, obj2, zzgsg);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
                return obj2;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Integer) it2.next()).intValue();
                if (!zzgpq.zza(intValue2)) {
                    obj2 = zzB(obj, i2, intValue2, obj2, zzgsg);
                    it2.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzB(Object obj, int i2, int i3, Object obj2, zzgsg zzgsg) {
        if (obj2 == null) {
            obj2 = zzgsg.zzc(obj);
        }
        zzgsg.zzl(obj2, i2, (long) i3);
        return obj2;
    }

    static void zzC(zzgsg zzgsg, Object obj, Object obj2) {
        zzgsg.zzo(obj, zzgsg.zze(zzgsg.zzd(obj), zzgsg.zzd(obj2)));
    }

    public static void zzD(Class cls) {
        Class cls2;
        if (!zzgpm.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzF(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzc(i2, list, z2);
        }
    }

    public static void zzG(int i2, List list, zzgou zzgou) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zze(i2, list);
        }
    }

    public static void zzH(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzg(i2, list, z2);
        }
    }

    public static void zzI(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzj(i2, list, z2);
        }
    }

    public static void zzJ(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzl(i2, list, z2);
        }
    }

    public static void zzK(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzn(i2, list, z2);
        }
    }

    public static void zzL(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzp(i2, list, z2);
        }
    }

    public static void zzM(int i2, List list, zzgou zzgou, zzgrp zzgrp) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzgou.zzq(i2, list.get(i3), zzgrp);
            }
        }
    }

    public static void zzN(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzs(i2, list, z2);
        }
    }

    public static void zzO(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzu(i2, list, z2);
        }
    }

    public static void zzP(int i2, List list, zzgou zzgou, zzgrp zzgrp) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzgou.zzv(i2, list.get(i3), zzgrp);
            }
        }
    }

    public static void zzQ(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzx(i2, list, z2);
        }
    }

    public static void zzR(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzz(i2, list, z2);
        }
    }

    public static void zzS(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzB(i2, list, z2);
        }
    }

    public static void zzT(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzD(i2, list, z2);
        }
    }

    public static void zzU(int i2, List list, zzgou zzgou) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzG(i2, list);
        }
    }

    public static void zzV(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzI(i2, list, z2);
        }
    }

    public static void zzW(int i2, List list, zzgou zzgou, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgou.zzK(i2, list, z2);
        }
    }

    static int zza(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgot.zzA(i2 << 3) + 1);
    }

    static int zzb(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzA = size * zzgot.zzA(i2 << 3);
        for (int i3 = 0; i3 < list.size(); i3++) {
            int zzd2 = ((zzgoe) list.get(i3)).zzd();
            zzA += zzgot.zzA(zzd2) + zzd2;
        }
        return zzA;
    }

    static int zzc(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzgot.zzA(i2 << 3));
    }

    static int zzd(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgot.zzx(zzgpn.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzgot.zzx(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zze(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgot.zzA(i2 << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgot.zzA(i2 << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i2, List list, zzgrp zzgrp) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzgot.zzw(i2, (zzgqw) list.get(i4), zzgrp);
        }
        return i3;
    }

    static int zzj(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzgot.zzA(i2 << 3));
    }

    static int zzk(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgot.zzx(zzgpn.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzgot.zzx(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzl(int i2, List list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzgot.zzA(i2 << 3));
    }

    static int zzm(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgot.zzB(zzgql.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzgot.zzB(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzn(int i2, Object obj, zzgrp zzgrp) {
        if (obj instanceof zzgqc) {
            int i3 = zzgot.zzf;
            int zza2 = ((zzgqc) obj).zza();
            return zzgot.zzA(i2 << 3) + zzgot.zzA(zza2) + zza2;
        }
        return zzgot.zzA(i2 << 3) + zzgot.zzy((zzgqw) obj, zzgrp);
    }

    static int zzo(int i2, List list, zzgrp zzgrp) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzA = zzgot.zzA(i2 << 3) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgqc) {
                int zza2 = ((zzgqc) obj).zza();
                zzA += zzgot.zzA(zza2) + zza2;
            } else {
                zzA += zzgot.zzy((zzgqw) obj, zzgrp);
            }
        }
        return zzA;
    }

    static int zzp(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzgot.zzA(i2 << 3));
    }

    static int zzq(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            i2 = 0;
            while (i3 < size) {
                int zze = zzgpn.zze(i3);
                i2 += zzgot.zzA((zze >> 31) ^ (zze + zze));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                int intValue = ((Integer) list.get(i3)).intValue();
                i4 = i2 + zzgot.zzA((intValue >> 31) ^ (intValue + intValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzr(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzgot.zzA(i2 << 3));
    }

    static int zzs(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            i2 = 0;
            while (i3 < size) {
                long zze = zzgql.zze(i3);
                i2 += zzgot.zzB((zze >> 63) ^ (zze + zze));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                long longValue = ((Long) list.get(i3)).longValue();
                i4 = i2 + zzgot.zzB((longValue >> 63) ^ (longValue + longValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzt(int i2, List list) {
        int zzz;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z2 = list instanceof zzgqe;
        int zzA = zzgot.zzA(i2 << 3) * size;
        if (z2) {
            zzgqe zzgqe = (zzgqe) list;
            while (i3 < size) {
                Object zzf = zzgqe.zzf(i3);
                if (zzf instanceof zzgoe) {
                    int zzd2 = ((zzgoe) zzf).zzd();
                    zzA += zzgot.zzA(zzd2) + zzd2;
                } else {
                    zzA += zzgot.zzz((String) zzf);
                }
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzgoe) {
                    int zzd3 = ((zzgoe) obj).zzd();
                    zzz = zzA + zzgot.zzA(zzd3) + zzd3;
                } else {
                    zzz = zzA + zzgot.zzz((String) obj);
                }
                i3++;
            }
        }
        return zzA;
    }

    static int zzu(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzgot.zzA(i2 << 3));
    }

    static int zzv(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgot.zzA(zzgpn.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzgot.zzA(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzw(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzgot.zzA(i2 << 3));
    }

    static int zzx(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgot.zzB(zzgql.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzgot.zzB(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static zzgsg zzy() {
        return zzc;
    }

    public static zzgsg zzz() {
        return zzd;
    }
}

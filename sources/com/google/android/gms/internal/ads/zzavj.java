package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;

public final class zzavj {
    static long zza(long j2, int i2) {
        if (i2 == 1) {
            return j2;
        }
        return ((i2 & 1) == 0 ? zza((j2 * j2) % 1073807359, i2 >> 1) : j2 * (zza((j2 * j2) % 1073807359, i2 >> 1) % 1073807359)) % 1073807359;
    }

    static String zzb(String[] strArr, int i2, int i3) {
        int i4 = i3 + i2;
        if (strArr.length < i4) {
            zzbzr.zzg("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i5 = i4 - 1;
            if (i2 < i5) {
                sb.append(strArr[i2]);
                sb.append(' ');
                i2++;
            } else {
                sb.append(strArr[i5]);
                return sb.toString();
            }
        }
    }

    public static void zzc(String[] strArr, int i2, int i3, PriorityQueue priorityQueue) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        int i4 = 6;
        if (length < 6) {
            zzd(i2, zze(strArr2, 0, length), zzb(strArr2, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr2, 0, 6);
        zzd(i2, zze, zzb(strArr2, 0, 6), 6, priorityQueue);
        int i5 = 1;
        while (true) {
            int length2 = strArr2.length;
            if (i5 < length2 - 5) {
                String zzb = zzb(strArr2, i5, i4);
                zze = ((((((zze + 1073807359) - ((zza(16785407, 5) * ((((long) zzavf.zza(strArr2[i5 - 1])) + 2147483647L) % 1073807359)) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzavf.zza(strArr2[i5 + 5])) + 2147483647L) % 1073807359)) % 1073807359;
                zzd(i2, zze, zzb, length2, priorityQueue);
                i5++;
                i4 = 6;
            } else {
                return;
            }
        }
    }

    static void zzd(int i2, long j2, String str, int i3, PriorityQueue priorityQueue) {
        zzavi zzavi = new zzavi(j2, str, i3);
        if ((priorityQueue.size() != i2 || (((zzavi) priorityQueue.peek()).zzc <= zzavi.zzc && ((zzavi) priorityQueue.peek()).zza <= zzavi.zza)) && !priorityQueue.contains(zzavi)) {
            priorityQueue.add(zzavi);
            if (priorityQueue.size() > i2) {
                priorityQueue.poll();
            }
        }
    }

    private static long zze(String[] strArr, int i2, int i3) {
        long zza = (((long) zzavf.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i4 = 1; i4 < i3; i4++) {
            zza = (((zza * 16785407) % 1073807359) + ((((long) zzavf.zza(strArr[i4])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}

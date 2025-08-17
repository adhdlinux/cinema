package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzadc extends zzade {
    private long zzb = -9223372036854775807L;
    private long[] zzc = new long[0];
    private long[] zzd = new long[0];

    public zzadc() {
        super(new zzaav());
    }

    private static Double zzg(zzfa zzfa) {
        return Double.valueOf(Double.longBitsToDouble(zzfa.zzr()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4, types: [int] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object zzh(com.google.android.gms.internal.ads.zzfa r4, int r5) {
        /*
            if (r5 == 0) goto L_0x007a
            r0 = 0
            r1 = 1
            if (r5 == r1) goto L_0x006e
            r1 = 2
            if (r5 == r1) goto L_0x0069
            r2 = 3
            if (r5 == r2) goto L_0x004d
            r2 = 8
            if (r5 == r2) goto L_0x0048
            r2 = 10
            if (r5 == r2) goto L_0x002c
            r0 = 11
            if (r5 == r0) goto L_0x001a
            r4 = 0
            return r4
        L_0x001a:
            java.util.Date r5 = new java.util.Date
            java.lang.Double r0 = zzg(r4)
            double r2 = r0.doubleValue()
            long r2 = (long) r2
            r5.<init>(r2)
            r4.zzG(r1)
            return r5
        L_0x002c:
            int r5 = r4.zzn()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r5)
        L_0x0035:
            if (r0 >= r5) goto L_0x0047
            int r2 = r4.zzk()
            java.lang.Object r2 = zzh(r4, r2)
            if (r2 == 0) goto L_0x0044
            r1.add(r2)
        L_0x0044:
            int r0 = r0 + 1
            goto L_0x0035
        L_0x0047:
            return r1
        L_0x0048:
            java.util.HashMap r4 = zzj(r4)
            return r4
        L_0x004d:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
        L_0x0052:
            java.lang.String r0 = zzi(r4)
            int r1 = r4.zzk()
            r2 = 9
            if (r1 != r2) goto L_0x005f
            return r5
        L_0x005f:
            java.lang.Object r1 = zzh(r4, r1)
            if (r1 == 0) goto L_0x0052
            r5.put(r0, r1)
            goto L_0x0052
        L_0x0069:
            java.lang.String r4 = zzi(r4)
            return r4
        L_0x006e:
            int r4 = r4.zzk()
            if (r4 != r1) goto L_0x0075
            r0 = 1
        L_0x0075:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            return r4
        L_0x007a:
            java.lang.Double r4 = zzg(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadc.zzh(com.google.android.gms.internal.ads.zzfa, int):java.lang.Object");
    }

    private static String zzi(zzfa zzfa) {
        int zzo = zzfa.zzo();
        int zzc2 = zzfa.zzc();
        zzfa.zzG(zzo);
        return new String(zzfa.zzH(), zzc2, zzo);
    }

    private static HashMap zzj(zzfa zzfa) {
        int zzn = zzfa.zzn();
        HashMap hashMap = new HashMap(zzn);
        for (int i2 = 0; i2 < zzn; i2++) {
            String zzi = zzi(zzfa);
            Object zzh = zzh(zzfa, zzfa.zzk());
            if (zzh != null) {
                hashMap.put(zzi, zzh);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfa zzfa) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfa zzfa, long j2) {
        if (zzfa.zzk() != 2 || !"onMetaData".equals(zzi(zzfa)) || zzfa.zza() == 0 || zzfa.zzk() != 8) {
            return false;
        }
        HashMap zzj = zzj(zzfa);
        Object obj = zzj.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.zzb = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = zzj.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.zzc = new long[size];
                this.zzd = new long[size];
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj5 = list.get(i2);
                    Object obj6 = list2.get(i2);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.zzc = new long[0];
                        this.zzd = new long[0];
                    } else {
                        this.zzc[i2] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i2] = ((Double) obj5).longValue();
                        i2++;
                    }
                }
                this.zzc = new long[0];
                this.zzd = new long[0];
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }
}

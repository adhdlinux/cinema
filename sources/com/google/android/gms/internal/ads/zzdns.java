package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzdns {
    private final Map zza = new HashMap();

    zzdns() {
    }

    public final synchronized zzdnr zza(String str) {
        return (zzdnr) this.zza.get(str);
    }

    public final zzdnr zzb(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzdnr zza2 = zza((String) it2.next());
            if (zza2 != null) {
                return zza2;
            }
        }
        return null;
    }

    public final String zzc(String str) {
        zzbqh zzbqh;
        zzdnr zza2 = zza(str);
        if (zza2 == null || (zzbqh = zza2.zzb) == null) {
            return "";
        }
        return zzbqh.toString();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r6, com.google.android.gms.internal.ads.zzfbd r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.containsKey(r6)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r5)
            return
        L_0x000b:
            com.google.android.gms.internal.ads.zzdnr r0 = new com.google.android.gms.internal.ads.zzdnr     // Catch:{ all -> 0x0046 }
            r1 = 0
            if (r7 != 0) goto L_0x0012
        L_0x0010:
            r2 = r1
            goto L_0x0019
        L_0x0012:
            com.google.android.gms.internal.ads.zzbqh r2 = r7.zze()     // Catch:{ zzfan -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            goto L_0x0010
        L_0x0019:
            if (r7 != 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            com.google.android.gms.internal.ads.zzbqh r1 = r7.zzf()     // Catch:{ zzfan -> 0x0020 }
        L_0x0020:
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zziP     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0046 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0046 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0046 }
            r4 = 1
            if (r3 != 0) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            r3 = 0
            if (r7 != 0) goto L_0x0039
        L_0x0037:
            r4 = 0
            goto L_0x003c
        L_0x0039:
            r7.zzC()     // Catch:{ zzfan -> 0x0037 }
        L_0x003c:
            r0.<init>(r6, r2, r1, r4)     // Catch:{ all -> 0x0046 }
            java.util.Map r7 = r5.zza     // Catch:{ all -> 0x0046 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r5)
            return
        L_0x0046:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdns.zzd(java.lang.String, com.google.android.gms.internal.ads.zzfbd):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze(String str, zzbpt zzbpt) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdnr(str, zzbpt.zzf(), zzbpt.zzg(), true));
            } catch (Throwable unused) {
            }
        }
    }
}

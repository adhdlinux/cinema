package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

final class zzgqg extends zzgqk {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgqg() {
        super((zzgqj) null);
    }

    /* synthetic */ zzgqg(zzgqf zzgqf) {
        super((zzgqj) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzgqd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.ads.zzgqd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.ads.zzgqd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List zzf(java.lang.Object r3, long r4, int r6) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzgsq.zzh(r3, r4)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002f
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgqe
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.internal.ads.zzgqd r0 = new com.google.android.gms.internal.ads.zzgqd
            r0.<init>((int) r6)
            goto L_0x002b
        L_0x0016:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgrd
            if (r1 == 0) goto L_0x0026
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgpv
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzgpv r0 = (com.google.android.gms.internal.ads.zzgpv) r0
            com.google.android.gms.internal.ads.zzgpv r6 = r0.zzd(r6)
            r0 = r6
            goto L_0x002b
        L_0x0026:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x002b:
            com.google.android.gms.internal.ads.zzgsq.zzv(r3, r4, r0)
            goto L_0x0087
        L_0x002f:
            java.lang.Class r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.ads.zzgsq.zzv(r3, r4, r1)
        L_0x004b:
            r0 = r1
            goto L_0x0087
        L_0x004d:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgsl
            if (r1 == 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzgqd r1 = new com.google.android.gms.internal.ads.zzgqd
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.ads.zzgsl r0 = (com.google.android.gms.internal.ads.zzgsl) r0
            int r6 = r1.size()
            r1.addAll(r6, r0)
            com.google.android.gms.internal.ads.zzgsq.zzv(r3, r4, r1)
            goto L_0x004b
        L_0x0068:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgrd
            if (r1 == 0) goto L_0x0087
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgpv
            if (r1 == 0) goto L_0x0087
            r1 = r0
            com.google.android.gms.internal.ads.zzgpv r1 = (com.google.android.gms.internal.ads.zzgpv) r1
            boolean r2 = r1.zzc()
            if (r2 == 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.ads.zzgpv r6 = r1.zzd(r0)
            com.google.android.gms.internal.ads.zzgsq.zzv(r3, r4, r6)
            return r6
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqg.zzf(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j2) {
        return zzf(obj, j2, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j2) {
        Object obj2;
        List list = (List) zzgsq.zzh(obj, j2);
        if (list instanceof zzgqe) {
            obj2 = ((zzgqe) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzgrd) || !(list instanceof zzgpv)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzgpv zzgpv = (zzgpv) list;
                if (zzgpv.zzc()) {
                    zzgpv.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzgsq.zzv(obj, j2, obj2);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j2) {
        List list = (List) zzgsq.zzh(obj2, j2);
        List zzf = zzf(obj, j2, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzgsq.zzv(obj, j2, list);
    }
}

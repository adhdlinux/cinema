package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzsr implements zzuh {
    private final zzabd zza;
    private zzaaw zzb;
    private zzaax zzc;

    public zzsr(zzabd zzabd) {
        this.zza = zzabd;
    }

    public final int zza(zzabs zzabs) throws IOException {
        zzaaw zzaaw = this.zzb;
        zzaaw.getClass();
        zzaax zzaax = this.zzc;
        zzaax.getClass();
        return zzaaw.zza(zzaax, zzabs);
    }

    public final long zzb() {
        zzaax zzaax = this.zzc;
        if (zzaax != null) {
            return zzaax.zzf();
        }
        return -1;
    }

    public final void zzc() {
        zzaaw zzaaw = this.zzb;
        if (zzaaw instanceof zzafx) {
            ((zzafx) zzaaw).zze();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r13v2, types: [int] */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0.zzf() != r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r0.zzf() != r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        r1 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzt r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzaaz r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaam r6 = new com.google.android.gms.internal.ads.zzaam
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzaaw r8 = r7.zzb
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.gms.internal.ads.zzabd r8 = r7.zza
            com.google.android.gms.internal.ads.zzaaw[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0021
            r8 = r8[r13]
            r7.zzb = r8
            goto L_0x00b6
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 >= r10) goto L_0x0071
            r1 = r8[r0]
            boolean r2 = r1.zzd(r6)     // Catch:{ EOFException -> 0x0057, all -> 0x0042 }
            if (r2 == 0) goto L_0x0035
            r7.zzb = r1     // Catch:{ EOFException -> 0x0057, all -> 0x0042 }
            com.google.android.gms.internal.ads.zzdy.zzf(r14)
            r6.zzj()
            goto L_0x0071
        L_0x0035:
            com.google.android.gms.internal.ads.zzaaw r1 = r7.zzb
            if (r1 != 0) goto L_0x0067
            long r1 = r6.zzf()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0042:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzaaw r9 = r7.zzb
            if (r9 != 0) goto L_0x004f
            long r9 = r6.zzf()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x0050
        L_0x004f:
            r13 = 1
        L_0x0050:
            com.google.android.gms.internal.ads.zzdy.zzf(r13)
            r6.zzj()
            throw r8
        L_0x0057:
            com.google.android.gms.internal.ads.zzaaw r1 = r7.zzb
            if (r1 != 0) goto L_0x0067
            long r1 = r6.zzf()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = 0
            goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            com.google.android.gms.internal.ads.zzdy.zzf(r1)
            r6.zzj()
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0071:
            com.google.android.gms.internal.ads.zzaaw r10 = r7.zzb
            if (r10 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzvo r10 = new com.google.android.gms.internal.ads.zzvo
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L_0x007c:
            int r12 = r8.length
            if (r13 >= r12) goto L_0x0098
            r14 = r8[r13]
            java.lang.Class r14 = r14.getClass()
            java.lang.String r14 = r14.getSimpleName()
            r11.append(r14)
            int r12 = r12 + -1
            if (r13 >= r12) goto L_0x0095
            java.lang.String r12 = ", "
            r11.append(r12)
        L_0x0095:
            int r13 = r13 + 1
            goto L_0x007c
        L_0x0098:
            java.lang.String r8 = r11.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>(r8, r9)
            throw r10
        L_0x00b6:
            com.google.android.gms.internal.ads.zzaaw r8 = r7.zzb
            r8.zzb(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsr.zzd(com.google.android.gms.internal.ads.zzt, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzaaz):void");
    }

    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    public final void zzf(long j2, long j3) {
        zzaaw zzaaw = this.zzb;
        zzaaw.getClass();
        zzaaw.zzc(j2, j3);
    }
}

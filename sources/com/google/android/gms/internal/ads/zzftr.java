package com.google.android.gms.internal.ads;

final class zzftr extends zzfsf {
    static final zzfsf zza = new zzftr((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzftr(Object obj, Object[] objArr, int i2) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzftr zzj(int r16, java.lang.Object[] r17, com.google.android.gms.internal.ads.zzfse r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            if (r0 != 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzfsf r0 = zza
            com.google.android.gms.internal.ads.zzftr r0 = (com.google.android.gms.internal.ads.zzftr) r0
            return r0
        L_0x000d:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x0025
            r0 = r1[r4]
            r0.getClass()
            r2 = r1[r5]
            r2.getClass()
            com.google.android.gms.internal.ads.zzfqz.zzb(r0, r2)
            com.google.android.gms.internal.ads.zzftr r0 = new com.google.android.gms.internal.ads.zzftr
            r0.<init>(r3, r1, r5)
            return r0
        L_0x0025:
            int r6 = r1.length
            int r6 = r6 >> r5
            java.lang.String r7 = "index"
            com.google.android.gms.internal.ads.zzfph.zzb(r0, r6, r7)
            int r6 = com.google.android.gms.internal.ads.zzfsh.zzh(r16)
            if (r0 != r5) goto L_0x0043
            r6 = r1[r4]
            r6.getClass()
            r8 = r1[r5]
            r8.getClass()
            com.google.android.gms.internal.ads.zzfqz.zzb(r6, r8)
        L_0x003f:
            r5 = 2
            r7 = 1
            goto L_0x018f
        L_0x0043:
            int r8 = r6 + -1
            r9 = 128(0x80, float:1.794E-43)
            r10 = 3
            r11 = -1
            if (r6 > r9) goto L_0x00b7
            byte[] r6 = new byte[r6]
            java.util.Arrays.fill(r6, r11)
            r9 = 0
            r11 = 0
        L_0x0052:
            if (r9 >= r0) goto L_0x00a3
            int r12 = r11 + r11
            int r13 = r9 + r9
            r14 = r1[r13]
            r14.getClass()
            r13 = r13 ^ r5
            r13 = r1[r13]
            r13.getClass()
            com.google.android.gms.internal.ads.zzfqz.zzb(r14, r13)
            int r15 = r14.hashCode()
            int r15 = com.google.android.gms.internal.ads.zzfru.zza(r15)
        L_0x006e:
            r15 = r15 & r8
            byte r7 = r6[r15]
            r5 = 255(0xff, float:3.57E-43)
            r7 = r7 & r5
            if (r7 != r5) goto L_0x0084
            byte r5 = (byte) r12
            r6[r15] = r5
            if (r11 >= r9) goto L_0x0081
            r1[r12] = r14
            r5 = r12 ^ 1
            r1[r5] = r13
        L_0x0081:
            int r11 = r11 + 1
            goto L_0x009b
        L_0x0084:
            r5 = r1[r7]
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x009f
            r3 = r7 ^ 1
            com.google.android.gms.internal.ads.zzfsd r5 = new com.google.android.gms.internal.ads.zzfsd
            r7 = r1[r3]
            r7.getClass()
            r5.<init>(r14, r13, r7)
            r1[r3] = r13
            r3 = r5
        L_0x009b:
            int r9 = r9 + 1
            r5 = 1
            goto L_0x0052
        L_0x009f:
            int r15 = r15 + 1
            r5 = 1
            goto L_0x006e
        L_0x00a3:
            if (r11 != r0) goto L_0x00a7
            r3 = r6
            goto L_0x003f
        L_0x00a7:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r4] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            r7 = 1
            r5[r7] = r6
            r6 = 2
            r5[r6] = r3
        L_0x00b5:
            r3 = r5
            goto L_0x003f
        L_0x00b7:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r6 > r5) goto L_0x0126
            short[] r5 = new short[r6]
            java.util.Arrays.fill(r5, r11)
            r6 = 0
            r7 = 0
        L_0x00c3:
            if (r6 >= r0) goto L_0x0114
            int r9 = r7 + r7
            int r11 = r6 + r6
            r12 = r1[r11]
            r12.getClass()
            r13 = 1
            r11 = r11 ^ r13
            r11 = r1[r11]
            r11.getClass()
            com.google.android.gms.internal.ads.zzfqz.zzb(r12, r11)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.ads.zzfru.zza(r13)
        L_0x00e0:
            r13 = r13 & r8
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x00f7
            short r14 = (short) r9
            r5[r13] = r14
            if (r7 >= r6) goto L_0x00f4
            r1[r9] = r12
            r9 = r9 ^ 1
            r1[r9] = r11
        L_0x00f4:
            int r7 = r7 + 1
            goto L_0x010e
        L_0x00f7:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0111
            r3 = r14 ^ 1
            com.google.android.gms.internal.ads.zzfsd r9 = new com.google.android.gms.internal.ads.zzfsd
            r13 = r1[r3]
            r13.getClass()
            r9.<init>(r12, r11, r13)
            r1[r3] = r11
            r3 = r9
        L_0x010e:
            int r6 = r6 + 1
            goto L_0x00c3
        L_0x0111:
            int r13 = r13 + 1
            goto L_0x00e0
        L_0x0114:
            if (r7 != r0) goto L_0x0117
            goto L_0x017e
        L_0x0117:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r7 = 1
            r6[r7] = r5
            r5 = 2
            r6[r5] = r3
            goto L_0x018e
        L_0x0126:
            r7 = 1
            int[] r5 = new int[r6]
            java.util.Arrays.fill(r5, r11)
            r6 = 0
            r9 = 0
        L_0x012e:
            if (r6 >= r0) goto L_0x017c
            int r12 = r9 + r9
            int r13 = r6 + r6
            r14 = r1[r13]
            r14.getClass()
            r13 = r13 ^ r7
            r7 = r1[r13]
            r7.getClass()
            com.google.android.gms.internal.ads.zzfqz.zzb(r14, r7)
            int r13 = r14.hashCode()
            int r13 = com.google.android.gms.internal.ads.zzfru.zza(r13)
        L_0x014a:
            r13 = r13 & r8
            r15 = r5[r13]
            if (r15 != r11) goto L_0x015c
            r5[r13] = r12
            if (r9 >= r6) goto L_0x0159
            r1[r12] = r14
            r12 = r12 ^ 1
            r1[r12] = r7
        L_0x0159:
            int r9 = r9 + 1
            goto L_0x0173
        L_0x015c:
            r11 = r1[r15]
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x0178
            r3 = r15 ^ 1
            com.google.android.gms.internal.ads.zzfsd r11 = new com.google.android.gms.internal.ads.zzfsd
            r12 = r1[r3]
            r12.getClass()
            r11.<init>(r14, r7, r12)
            r1[r3] = r7
            r3 = r11
        L_0x0173:
            int r6 = r6 + 1
            r7 = 1
            r11 = -1
            goto L_0x012e
        L_0x0178:
            int r13 = r13 + 1
            r11 = -1
            goto L_0x014a
        L_0x017c:
            if (r9 != r0) goto L_0x0180
        L_0x017e:
            goto L_0x00b5
        L_0x0180:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            r7 = 1
            r6[r7] = r5
            r5 = 2
            r6[r5] = r3
        L_0x018e:
            r3 = r6
        L_0x018f:
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01b6
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r0 = r3[r5]
            com.google.android.gms.internal.ads.zzfsd r0 = (com.google.android.gms.internal.ads.zzfsd) r0
            if (r2 == 0) goto L_0x01b1
            r2.zzc = r0
            r0 = r3[r4]
            r2 = r3[r7]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r3 = r0
            r0 = r2
            goto L_0x01b6
        L_0x01b1:
            java.lang.IllegalArgumentException r0 = r0.zza()
            throw r0
        L_0x01b6:
            com.google.android.gms.internal.ads.zzftr r2 = new com.google.android.gms.internal.ads.zzftr
            r2.<init>(r3, r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzftr.zzj(int, java.lang.Object[], com.google.android.gms.internal.ads.zzfse):com.google.android.gms.internal.ads.zzftr");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto L_0x000c
        L_0x0009:
            r10 = r3
            goto L_0x009c
        L_0x000c:
            r4 = 1
            if (r2 != r4) goto L_0x0022
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0009
            r10 = r1[r4]
            r10.getClass()
            goto L_0x009c
        L_0x0022:
            if (r0 != 0) goto L_0x0025
            goto L_0x0009
        L_0x0025:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L_0x0051
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.ads.zzfru.zza(r0)
        L_0x0038:
            r0 = r0 & r6
            byte r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0009
        L_0x0041:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x004e:
            int r0 = r0 + 1
            goto L_0x0038
        L_0x0051:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L_0x007d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.ads.zzfru.zza(r0)
        L_0x0063:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0009
        L_0x006d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x007a:
            int r0 = r0 + 1
            goto L_0x0063
        L_0x007d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfru.zza(r6)
        L_0x0089:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0009
        L_0x0090:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r3
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzftr.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfrx zza() {
        return new zzftq(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzfsh zzf() {
        return new zzfto(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzfsh zzg() {
        return new zzftp(this, new zzftq(this.zzb, 0, this.zzd));
    }
}

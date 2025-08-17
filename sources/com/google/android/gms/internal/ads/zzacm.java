package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzacm implements zzaaw {
    private final zzfa zza = new zzfa(12);
    private final zzacl zzb = new zzacl((zzack) null);
    private int zzc;
    private zzaaz zzd = new zzaau();
    private zzacn zze;
    private long zzf = -9223372036854775807L;
    /* access modifiers changed from: private */
    public zzacp[] zzg = new zzacp[0];
    private long zzh;
    private zzacp zzi;
    private int zzj = -1;
    private long zzk = -1;
    private long zzl = -1;
    private int zzm;
    private boolean zzn;

    private final zzacp zzf(int i2) {
        for (zzacp zzacp : this.zzg) {
            if (zzacp.zzg(i2)) {
                return zzacp;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzaax r24, com.google.android.gms.internal.ads.zzabs r25) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            long r2 = r0.zzh
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x002e
            long r8 = r24.zzf()
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0028
            r10 = 262144(0x40000, double:1.295163E-318)
            long r10 = r10 + r8
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            long r2 = r2 - r8
            r8 = r1
            com.google.android.gms.internal.ads.zzaam r8 = (com.google.android.gms.internal.ads.zzaam) r8
            int r3 = (int) r2
            r8.zzo(r3, r5)
            goto L_0x002e
        L_0x0028:
            r8 = r25
            r8.zza = r2
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r0.zzh = r6
            if (r2 == 0) goto L_0x0034
            return r4
        L_0x0034:
            int r2 = r0.zzc
            r3 = 12
            r8 = 0
            if (r2 == 0) goto L_0x03b6
            r9 = 1819436136(0x6c726468, float:1.1721368E27)
            r10 = 1414744396(0x5453494c, float:3.62987127E12)
            r11 = 2
            if (r2 == r4) goto L_0x0357
            r12 = 3
            if (r2 == r11) goto L_0x022e
            r9 = 6
            r11 = 1769369453(0x69766f6d, float:1.8620122E25)
            r13 = 4
            r16 = 8
            r14 = 16
            if (r2 == r12) goto L_0x0199
            r6 = 5
            r7 = 8
            if (r2 == r13) goto L_0x0169
            if (r2 == r6) goto L_0x00e7
            long r12 = r24.zzf()
            long r14 = r0.zzl
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 < 0) goto L_0x0066
            r5 = -1
            goto L_0x00e6
        L_0x0066:
            com.google.android.gms.internal.ads.zzacp r2 = r0.zzi
            if (r2 == 0) goto L_0x0075
            boolean r1 = r2.zzh(r1)
            if (r1 != 0) goto L_0x0072
            goto L_0x00e6
        L_0x0072:
            r0.zzi = r8
            return r5
        L_0x0075:
            long r8 = r24.zzf()
            r12 = 1
            long r8 = r8 & r12
            int r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0086
            r2 = r1
            com.google.android.gms.internal.ads.zzaam r2 = (com.google.android.gms.internal.ads.zzaam) r2
            r2.zzo(r4, r5)
        L_0x0086:
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            byte[] r2 = r2.zzH()
            r4 = r1
            com.google.android.gms.internal.ads.zzaam r4 = (com.google.android.gms.internal.ads.zzaam) r4
            r4.zzm(r2, r5, r3, r5)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            r2.zzF(r5)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            int r2 = r2.zzg()
            if (r2 != r10) goto L_0x00b6
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            r2.zzF(r7)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            int r2 = r2.zzg()
            if (r2 != r11) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            r3 = 8
        L_0x00af:
            r4.zzo(r3, r5)
            r24.zzj()
            goto L_0x00e6
        L_0x00b6:
            com.google.android.gms.internal.ads.zzfa r3 = r0.zza
            int r3 = r3.zzg()
            r6 = 1263424842(0x4b4e554a, float:1.352225E7)
            if (r2 != r6) goto L_0x00cc
            long r1 = r24.zzf()
            long r3 = (long) r3
            long r1 = r1 + r3
            long r1 = r1 + r16
            r0.zzh = r1
            goto L_0x00e6
        L_0x00cc:
            r4.zzo(r7, r5)
            r24.zzj()
            com.google.android.gms.internal.ads.zzacp r2 = r0.zzf(r2)
            if (r2 != 0) goto L_0x00e1
            long r1 = r24.zzf()
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.zzh = r1
            goto L_0x00e6
        L_0x00e1:
            r2.zze(r3)
            r0.zzi = r2
        L_0x00e6:
            return r5
        L_0x00e7:
            com.google.android.gms.internal.ads.zzfa r2 = new com.google.android.gms.internal.ads.zzfa
            int r3 = r0.zzm
            r2.<init>((int) r3)
            byte[] r3 = r2.zzH()
            int r6 = r0.zzm
            com.google.android.gms.internal.ads.zzaam r1 = (com.google.android.gms.internal.ads.zzaam) r1
            r1.zzn(r3, r5, r6, r5)
            int r1 = r2.zza()
            if (r1 >= r14) goto L_0x0102
            r18 = 0
            goto L_0x011e
        L_0x0102:
            int r1 = r2.zzc()
            r2.zzG(r7)
            int r3 = r2.zzg()
            long r6 = (long) r3
            long r10 = r0.zzk
            int r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0117
            r18 = 0
            goto L_0x011b
        L_0x0117:
            long r10 = r10 + r16
            r18 = r10
        L_0x011b:
            r2.zzF(r1)
        L_0x011e:
            int r1 = r2.zza()
            if (r1 < r14) goto L_0x0146
            int r1 = r2.zzg()
            int r3 = r2.zzg()
            int r6 = r2.zzg()
            long r6 = (long) r6
            long r6 = r6 + r18
            r2.zzg()
            com.google.android.gms.internal.ads.zzacp r1 = r0.zzf(r1)
            if (r1 == 0) goto L_0x011e
            r3 = r3 & r14
            if (r3 != r14) goto L_0x0142
            r1.zzb(r6)
        L_0x0142:
            r1.zzd()
            goto L_0x011e
        L_0x0146:
            com.google.android.gms.internal.ads.zzacp[] r1 = r0.zzg
            int r2 = r1.length
            r3 = 0
        L_0x014a:
            if (r3 >= r2) goto L_0x0154
            r6 = r1[r3]
            r6.zzc()
            int r3 = r3 + 1
            goto L_0x014a
        L_0x0154:
            r0.zzn = r4
            com.google.android.gms.internal.ads.zzaaz r1 = r0.zzd
            com.google.android.gms.internal.ads.zzacj r2 = new com.google.android.gms.internal.ads.zzacj
            long r3 = r0.zzf
            r2.<init>(r0, r3)
            r1.zzN(r2)
            r0.zzc = r9
            long r1 = r0.zzk
            r0.zzh = r1
            return r5
        L_0x0169:
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            byte[] r2 = r2.zzH()
            r3 = r1
            com.google.android.gms.internal.ads.zzaam r3 = (com.google.android.gms.internal.ads.zzaam) r3
            r3.zzn(r2, r5, r7, r5)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            r2.zzF(r5)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            int r2 = r2.zzg()
            com.google.android.gms.internal.ads.zzfa r3 = r0.zza
            int r3 = r3.zzg()
            r4 = 829973609(0x31786469, float:3.6145826E-9)
            if (r2 != r4) goto L_0x0190
            r0.zzc = r6
            r0.zzm = r3
            goto L_0x0198
        L_0x0190:
            long r1 = r24.zzf()
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.zzh = r1
        L_0x0198:
            return r5
        L_0x0199:
            long r13 = r0.zzk
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01ab
            long r6 = r24.zzf()
            int r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r8 != 0) goto L_0x01a8
            goto L_0x01ab
        L_0x01a8:
            r0.zzh = r13
            return r5
        L_0x01ab:
            com.google.android.gms.internal.ads.zzfa r6 = r0.zza
            byte[] r6 = r6.zzH()
            r7 = r1
            com.google.android.gms.internal.ads.zzaam r7 = (com.google.android.gms.internal.ads.zzaam) r7
            r7.zzm(r6, r5, r3, r5)
            r24.zzj()
            com.google.android.gms.internal.ads.zzfa r6 = r0.zza
            r6.zzF(r5)
            com.google.android.gms.internal.ads.zzacl r6 = r0.zzb
            com.google.android.gms.internal.ads.zzfa r7 = r0.zza
            r6.zza(r7)
            com.google.android.gms.internal.ads.zzfa r6 = r0.zza
            int r6 = r6.zzg()
            com.google.android.gms.internal.ads.zzacl r7 = r0.zzb
            int r8 = r7.zza
            r12 = 1179011410(0x46464952, float:12690.33)
            if (r8 != r12) goto L_0x01db
            com.google.android.gms.internal.ads.zzaam r1 = (com.google.android.gms.internal.ads.zzaam) r1
            r1.zzo(r3, r5)
            return r5
        L_0x01db:
            if (r8 != r10) goto L_0x0221
            if (r6 == r11) goto L_0x01e0
            goto L_0x0221
        L_0x01e0:
            long r10 = r24.zzf()
            r0.zzk = r10
            int r3 = r7.zzb
            long r6 = (long) r3
            long r10 = r10 + r6
            long r10 = r10 + r16
            r0.zzl = r10
            boolean r3 = r0.zzn
            if (r3 != 0) goto L_0x0215
            com.google.android.gms.internal.ads.zzacn r3 = r0.zze
            r3.getClass()
            int r3 = r3.zzb
            r2 = 16
            r3 = r3 & r2
            if (r3 == r2) goto L_0x020f
            com.google.android.gms.internal.ads.zzaaz r2 = r0.zzd
            com.google.android.gms.internal.ads.zzabu r3 = new com.google.android.gms.internal.ads.zzabu
            long r6 = r0.zzf
            r10 = 0
            r3.<init>(r6, r10)
            r2.zzN(r3)
            r0.zzn = r4
            goto L_0x0215
        L_0x020f:
            r2 = 4
            r0.zzc = r2
            r0.zzh = r10
            return r5
        L_0x0215:
            long r1 = r24.zzf()
            r3 = 12
            long r1 = r1 + r3
            r0.zzh = r1
            r0.zzc = r9
            return r5
        L_0x0221:
            long r1 = r24.zzf()
            int r3 = r7.zzb
            long r3 = (long) r3
            long r1 = r1 + r3
            long r1 = r1 + r16
            r0.zzh = r1
            return r5
        L_0x022e:
            int r2 = r0.zzj
            int r2 = r2 + -4
            com.google.android.gms.internal.ads.zzfa r3 = new com.google.android.gms.internal.ads.zzfa
            r3.<init>((int) r2)
            byte[] r6 = r3.zzH()
            com.google.android.gms.internal.ads.zzaam r1 = (com.google.android.gms.internal.ads.zzaam) r1
            r1.zzn(r6, r5, r2, r5)
            com.google.android.gms.internal.ads.zzacq r1 = com.google.android.gms.internal.ads.zzacq.zzc(r9, r3)
            int r2 = r1.zza()
            if (r2 != r9) goto L_0x033c
            java.lang.Class<com.google.android.gms.internal.ads.zzacn> r2 = com.google.android.gms.internal.ads.zzacn.class
            com.google.android.gms.internal.ads.zzaci r2 = r1.zzb(r2)
            com.google.android.gms.internal.ads.zzacn r2 = (com.google.android.gms.internal.ads.zzacn) r2
            if (r2 == 0) goto L_0x0334
            r0.zze = r2
            int r3 = r2.zzc
            long r6 = (long) r3
            int r2 = r2.zza
            long r2 = (long) r2
            long r6 = r6 * r2
            r0.zzf = r6
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.google.android.gms.internal.ads.zzfsc r1 = r1.zza
            int r3 = r1.size()
            r6 = 0
            r14 = 0
        L_0x026d:
            if (r6 >= r3) goto L_0x0321
            java.lang.Object r7 = r1.get(r6)
            com.google.android.gms.internal.ads.zzaci r7 = (com.google.android.gms.internal.ads.zzaci) r7
            int r9 = r7.zza()
            r10 = 1819440243(0x6c727473, float:1.17243986E27)
            if (r9 != r10) goto L_0x0317
            com.google.android.gms.internal.ads.zzacq r7 = (com.google.android.gms.internal.ads.zzacq) r7
            int r9 = r14 + 1
            java.lang.Class<com.google.android.gms.internal.ads.zzaco> r10 = com.google.android.gms.internal.ads.zzaco.class
            com.google.android.gms.internal.ads.zzaci r10 = r7.zzb(r10)
            com.google.android.gms.internal.ads.zzaco r10 = (com.google.android.gms.internal.ads.zzaco) r10
            java.lang.Class<com.google.android.gms.internal.ads.zzacr> r13 = com.google.android.gms.internal.ads.zzacr.class
            com.google.android.gms.internal.ads.zzaci r13 = r7.zzb(r13)
            com.google.android.gms.internal.ads.zzacr r13 = (com.google.android.gms.internal.ads.zzacr) r13
            java.lang.String r15 = "AviExtractor"
            if (r10 != 0) goto L_0x02a1
            java.lang.String r7 = "Missing Stream Header"
            com.google.android.gms.internal.ads.zzer.zzf(r15, r7)
        L_0x029b:
            r22 = r6
            r24 = r9
            goto L_0x030f
        L_0x02a1:
            if (r13 != 0) goto L_0x02a9
            java.lang.String r7 = "Missing Stream Format"
            com.google.android.gms.internal.ads.zzer.zzf(r15, r7)
            goto L_0x029b
        L_0x02a9:
            int r15 = r10.zzd
            r24 = r9
            long r8 = (long) r15
            int r15 = r10.zzb
            r22 = r6
            long r5 = (long) r15
            int r15 = r10.zzc
            long r11 = (long) r15
            r15 = 1000000(0xf4240, double:4.940656E-318)
            long r18 = r5 * r15
            r16 = r8
            r20 = r11
            long r5 = com.google.android.gms.internal.ads.zzfj.zzp(r16, r18, r20)
            com.google.android.gms.internal.ads.zzam r8 = r13.zza
            com.google.android.gms.internal.ads.zzak r9 = r8.zzb()
            r9.zzG(r14)
            int r11 = r10.zze
            if (r11 == 0) goto L_0x02d3
            r9.zzL(r11)
        L_0x02d3:
            java.lang.Class<com.google.android.gms.internal.ads.zzacs> r11 = com.google.android.gms.internal.ads.zzacs.class
            com.google.android.gms.internal.ads.zzaci r7 = r7.zzb(r11)
            com.google.android.gms.internal.ads.zzacs r7 = (com.google.android.gms.internal.ads.zzacs) r7
            if (r7 == 0) goto L_0x02e2
            java.lang.String r7 = r7.zza
            r9.zzJ(r7)
        L_0x02e2:
            java.lang.String r7 = r8.zzm
            int r7 = com.google.android.gms.internal.ads.zzcc.zzb(r7)
            if (r7 == r4) goto L_0x02f1
            r8 = 2
            if (r7 != r8) goto L_0x02ef
            r15 = 2
            goto L_0x02f2
        L_0x02ef:
            r8 = 0
            goto L_0x030f
        L_0x02f1:
            r15 = r7
        L_0x02f2:
            com.google.android.gms.internal.ads.zzaaz r7 = r0.zzd
            com.google.android.gms.internal.ads.zzabz r7 = r7.zzv(r14, r15)
            com.google.android.gms.internal.ads.zzam r8 = r9.zzY()
            r7.zzk(r8)
            com.google.android.gms.internal.ads.zzacp r8 = new com.google.android.gms.internal.ads.zzacp
            int r9 = r10.zzd
            r13 = r8
            r16 = r5
            r18 = r9
            r19 = r7
            r13.<init>(r14, r15, r16, r18, r19)
            r0.zzf = r5
        L_0x030f:
            if (r8 == 0) goto L_0x0314
            r2.add(r8)
        L_0x0314:
            r14 = r24
            goto L_0x0319
        L_0x0317:
            r22 = r6
        L_0x0319:
            int r6 = r22 + 1
            r5 = 0
            r8 = 0
            r11 = 2
            r12 = 3
            goto L_0x026d
        L_0x0321:
            com.google.android.gms.internal.ads.zzacp[] r1 = new com.google.android.gms.internal.ads.zzacp[r5]
            java.lang.Object[] r1 = r2.toArray(r1)
            com.google.android.gms.internal.ads.zzacp[] r1 = (com.google.android.gms.internal.ads.zzacp[]) r1
            r0.zzg = r1
            com.google.android.gms.internal.ads.zzaaz r1 = r0.zzd
            r1.zzC()
            r1 = 3
            r0.zzc = r1
            return r5
        L_0x0334:
            java.lang.String r1 = "AviHeader not found"
            r2 = 0
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zza(r1, r2)
            throw r1
        L_0x033c:
            r2 = r8
            int r1 = r1.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected header list type "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zza(r1, r2)
            throw r1
        L_0x0357:
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            byte[] r2 = r2.zzH()
            com.google.android.gms.internal.ads.zzaam r1 = (com.google.android.gms.internal.ads.zzaam) r1
            r4 = 0
            r1.zzn(r2, r4, r3, r4)
            com.google.android.gms.internal.ads.zzfa r1 = r0.zza
            r1.zzF(r4)
            com.google.android.gms.internal.ads.zzacl r1 = r0.zzb
            com.google.android.gms.internal.ads.zzfa r2 = r0.zza
            r1.zza(r2)
            int r3 = r1.zza
            if (r3 != r10) goto L_0x039f
            int r2 = r2.zzg()
            r1.zzc = r2
            com.google.android.gms.internal.ads.zzacl r1 = r0.zzb
            int r2 = r1.zzc
            if (r2 != r9) goto L_0x0388
            int r1 = r1.zzb
            r0.zzj = r1
            r1 = 2
            r0.zzc = r1
            r1 = 0
            return r1
        L_0x0388:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "hdrl expected, found: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zza(r1, r2)
            throw r1
        L_0x039f:
            r2 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "LIST expected, found: "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zza(r1, r2)
            throw r1
        L_0x03b6:
            r2 = r8
            boolean r5 = r23.zzd(r24)
            if (r5 == 0) goto L_0x03c6
            com.google.android.gms.internal.ads.zzaam r1 = (com.google.android.gms.internal.ads.zzaam) r1
            r2 = 0
            r1.zzo(r3, r2)
            r0.zzc = r4
            return r2
        L_0x03c6:
            java.lang.String r1 = "AVI Header List not found"
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacm.zza(com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzabs):int");
    }

    public final void zzb(zzaaz zzaaz) {
        this.zzc = 0;
        this.zzd = zzaaz;
        this.zzh = -1;
    }

    public final void zzc(long j2, long j3) {
        int i2;
        this.zzh = -1;
        this.zzi = null;
        for (zzacp zzf2 : this.zzg) {
            zzf2.zzf(j2);
        }
        if (j2 != 0) {
            i2 = 6;
        } else if (this.zzg.length == 0) {
            this.zzc = 0;
            return;
        } else {
            i2 = 3;
        }
        this.zzc = i2;
    }

    public final boolean zzd(zzaax zzaax) throws IOException {
        ((zzaam) zzaax).zzm(this.zza.zzH(), 0, 12, false);
        this.zza.zzF(0);
        if (this.zza.zzg() != 1179011410) {
            return false;
        }
        this.zza.zzG(4);
        if (this.zza.zzg() == 541677121) {
            return true;
        }
        return false;
    }
}

package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.facebook.common.time.Clock;

final class zzkp {
    private final zzct zza = new zzct();
    private final zzcv zzb = new zzcv();
    private final zzls zzc;
    private final zzei zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzkm zzh;
    private zzkm zzi;
    private zzkm zzj;
    private int zzk;
    private Object zzl;
    private long zzm;

    public zzkp(zzls zzls, zzei zzei) {
        this.zzc = zzls;
        this.zzd = zzei;
    }

    private final boolean zzA(zzcw zzcw, zzto zzto) {
        if (!zzC(zzto)) {
            return false;
        }
        int i2 = zzcw.zzn(zzto.zza, this.zza).zzd;
        if (zzcw.zze(i2, this.zzb, 0).zzp == zzcw.zza(zzto.zza)) {
            return true;
        }
        return false;
    }

    private final boolean zzB(zzcw zzcw) {
        zzkm zzkm = this.zzh;
        if (zzkm == null) {
            return true;
        }
        int zza2 = zzcw.zza(zzkm.zzb);
        while (true) {
            zza2 = zzcw.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg);
            while (zzkm.zzg() != null && !zzkm.zzf.zzg) {
                zzkm = zzkm.zzg();
            }
            zzkm zzg2 = zzkm.zzg();
            if (zza2 == -1 || zzg2 == null || zzcw.zza(zzg2.zzb) != zza2) {
                boolean zzm2 = zzm(zzkm);
                zzkm.zzf = zzg(zzcw, zzkm.zzf);
            } else {
                zzkm = zzg2;
            }
        }
        boolean zzm22 = zzm(zzkm);
        zzkm.zzf = zzg(zzcw, zzkm.zzf);
        if (!zzm22) {
            return true;
        }
        return false;
    }

    private static final boolean zzC(zzto zzto) {
        return !zzto.zzb() && zzto.zze == -1;
    }

    private final long zzs(zzcw zzcw, Object obj, int i2) {
        zzcw.zzn(obj, this.zza);
        this.zza.zzi(i2);
        this.zza.zzk(i2);
        return 0;
    }

    private final zzkn zzt(zzcw zzcw, zzkm zzkm, long j2) {
        long j3;
        zzcw zzcw2 = zzcw;
        zzkn zzkn = zzkm.zzf;
        long zze2 = (zzkm.zze() + zzkn.zze) - j2;
        if (zzkn.zzg) {
            long j4 = 0;
            int zzi2 = zzcw.zzi(zzcw2.zza(zzkn.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (zzi2 != -1) {
                int i2 = zzcw2.zzd(zzi2, this.zza, true).zzd;
                Object obj = this.zza.zzc;
                obj.getClass();
                long j5 = zzkn.zza.zzd;
                if (zzcw2.zze(i2, this.zzb, 0).zzo == zzi2) {
                    Pair zzm2 = zzcw.zzm(this.zzb, this.zza, i2, -9223372036854775807L, Math.max(0, zze2));
                    if (zzm2 != null) {
                        obj = zzm2.first;
                        long longValue = ((Long) zzm2.second).longValue();
                        zzkm zzg2 = zzkm.zzg();
                        if (zzg2 == null || !zzg2.zzb.equals(obj)) {
                            j5 = this.zze;
                            this.zze = 1 + j5;
                        } else {
                            j5 = zzg2.zzf.zza.zzd;
                        }
                        j3 = longValue;
                        j4 = -9223372036854775807L;
                    }
                } else {
                    j3 = 0;
                }
                zzto zzx = zzx(zzcw, obj, j3, j5, this.zzb, this.zza);
                if (!(j4 == -9223372036854775807L || zzkn.zzc == -9223372036854775807L)) {
                    zzcw2.zzn(zzkn.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzu(zzcw, zzx, j4, j3);
            }
        } else {
            zzto zzto = zzkn.zza;
            zzcw2.zzn(zzto.zza, this.zza);
            if (zzto.zzb()) {
                int i3 = zzto.zzb;
                if (this.zza.zza(i3) != -1) {
                    int zzf2 = this.zza.zzf(i3, zzto.zzc);
                    if (zzf2 < 0) {
                        return zzv(zzcw, zzto.zza, i3, zzf2, zzkn.zzc, zzto.zzd);
                    }
                    long j6 = zzkn.zzc;
                    if (j6 == -9223372036854775807L) {
                        zzcv zzcv = this.zzb;
                        zzct zzct = this.zza;
                        Pair zzm3 = zzcw.zzm(zzcv, zzct, zzct.zzd, -9223372036854775807L, Math.max(0, zze2));
                        if (zzm3 != null) {
                            j6 = ((Long) zzm3.second).longValue();
                        }
                    }
                    zzs(zzcw2, zzto.zza, zzto.zzb);
                    return zzw(zzcw, zzto.zza, Math.max(0, j6), zzkn.zzc, zzto.zzd);
                }
            } else {
                int i4 = zzto.zze;
                if (i4 != -1) {
                    this.zza.zzm(i4);
                }
                int zze3 = this.zza.zze(zzto.zze);
                this.zza.zzn(zzto.zze);
                if (zze3 != this.zza.zza(zzto.zze)) {
                    return zzv(zzcw, zzto.zza, zzto.zze, zze3, zzkn.zze, zzto.zzd);
                }
                zzs(zzcw2, zzto.zza, zzto.zze);
                return zzw(zzcw, zzto.zza, 0, zzkn.zze, zzto.zzd);
            }
        }
        return null;
    }

    private final zzkn zzu(zzcw zzcw, zzto zzto, long j2, long j3) {
        zzto zzto2 = zzto;
        zzcw zzcw2 = zzcw;
        zzcw.zzn(zzto2.zza, this.zza);
        if (zzto.zzb()) {
            return zzv(zzcw, zzto2.zza, zzto2.zzb, zzto2.zzc, j2, zzto2.zzd);
        }
        return zzw(zzcw, zzto2.zza, j3, j2, zzto2.zzd);
    }

    private final zzkn zzv(zzcw zzcw, Object obj, int i2, int i3, long j2, long j3) {
        zzto zzto = new zzto(obj, i2, i3, j3);
        long zzh2 = zzcw.zzn(zzto.zza, this.zza).zzh(zzto.zzb, zzto.zzc);
        if (i3 == this.zza.zze(i2)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzto.zzb);
        long j4 = 0;
        if (zzh2 != -9223372036854775807L && zzh2 <= 0) {
            j4 = Math.max(0, -1 + zzh2);
        }
        return new zzkn(zzto, j4, j2, -9223372036854775807L, zzh2, false, false, false, false);
    }

    private final zzkn zzw(zzcw zzcw, Object obj, long j2, long j3, long j4) {
        long j5;
        long j6;
        long j7;
        zzcw zzcw2 = zzcw;
        Object obj2 = obj;
        long j8 = j2;
        zzcw2.zzn(obj2, this.zza);
        int zzc2 = this.zza.zzc(j8);
        if (zzc2 != -1) {
            this.zza.zzm(zzc2);
        }
        if (zzc2 == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(zzc2);
        }
        zzto zzto = new zzto(obj2, j4, zzc2);
        boolean zzC = zzC(zzto);
        boolean zzA = zzA(zzcw2, zzto);
        boolean zzz = zzz(zzcw2, zzto, zzC);
        if (zzc2 != -1) {
            this.zza.zzn(zzc2);
        }
        if (zzc2 != -1) {
            this.zza.zzi(zzc2);
            j5 = 0;
        } else {
            j5 = -9223372036854775807L;
        }
        if (j5 != -9223372036854775807L) {
            j7 = 0;
            j6 = 0;
        } else {
            j7 = j5;
            j6 = this.zza.zze;
        }
        if (j6 != -9223372036854775807L && j8 >= j6) {
            j8 = Math.max(0, j6 - 1);
        }
        return new zzkn(zzto, j8, j3, j7, j6, false, zzC, zzA, zzz);
    }

    private static zzto zzx(zzcw zzcw, Object obj, long j2, long j3, zzcv zzcv, zzct zzct) {
        zzcw zzcw2 = zzcw;
        Object obj2 = obj;
        long j4 = j2;
        zzct zzct2 = zzct;
        zzcw.zzn(obj, zzct2);
        zzcv zzcv2 = zzcv;
        zzcw.zze(zzct2.zzd, zzcv, 0);
        zzcw.zza(obj);
        zzct.zzb();
        zzcw.zzn(obj, zzct2);
        int zzd2 = zzct2.zzd(j2);
        if (zzd2 == -1) {
            long j5 = j3;
            return new zzto(obj, j3, zzct2.zzc(j2));
        }
        long j6 = j3;
        return new zzto(obj, zzd2, zzct2.zze(zzd2), j3);
    }

    private final void zzy() {
        zzto zzto;
        zzfrz zzfrz = new zzfrz();
        for (zzkm zzkm = this.zzh; zzkm != null; zzkm = zzkm.zzg()) {
            zzfrz.zzf(zzkm.zzf.zza);
        }
        zzkm zzkm2 = this.zzi;
        if (zzkm2 == null) {
            zzto = null;
        } else {
            zzto = zzkm2.zzf.zza;
        }
        this.zzd.zzh(new zzko(this, zzfrz, zzto));
    }

    private final boolean zzz(zzcw zzcw, zzto zzto, boolean z2) {
        int zza2 = zzcw.zza(zzto.zza);
        if (!zzcw.zze(zzcw.zzd(zza2, this.zza, false).zzd, this.zzb, 0).zzi) {
            if (zzcw.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z2) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final zzkm zza() {
        zzkm zzkm = this.zzh;
        if (zzkm == null) {
            return null;
        }
        if (zzkm == this.zzi) {
            this.zzi = zzkm.zzg();
        }
        zzkm.zzn();
        int i2 = this.zzk - 1;
        this.zzk = i2;
        if (i2 == 0) {
            this.zzj = null;
            zzkm zzkm2 = this.zzh;
            this.zzl = zzkm2.zzb;
            this.zzm = zzkm2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzkm zzb() {
        zzkm zzkm = this.zzi;
        boolean z2 = false;
        if (!(zzkm == null || zzkm.zzg() == null)) {
            z2 = true;
        }
        zzdy.zzf(z2);
        this.zzi = this.zzi.zzg();
        zzy();
        return this.zzi;
    }

    public final zzkm zzc() {
        return this.zzj;
    }

    public final zzkm zzd() {
        return this.zzh;
    }

    public final zzkm zze() {
        return this.zzi;
    }

    public final zzkn zzf(long j2, zzlc zzlc) {
        zzkm zzkm = this.zzj;
        if (zzkm != null) {
            return zzt(zzlc.zza, zzkm, j2);
        }
        return zzu(zzlc.zza, zzlc.zzb, zzlc.zzc, zzlc.zzr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzkn zzg(com.google.android.gms.internal.ads.zzcw r19, com.google.android.gms.internal.ads.zzkn r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzto r3 = r2.zza
            boolean r12 = zzC(r3)
            boolean r13 = r0.zzA(r1, r3)
            boolean r14 = r0.zzz(r1, r3, r12)
            com.google.android.gms.internal.ads.zzto r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzct r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0037
            int r1 = r3.zze
            if (r1 != r4) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            com.google.android.gms.internal.ads.zzct r9 = r0.zza
            r9.zzi(r1)
            r9 = r5
            goto L_0x0038
        L_0x0037:
            r9 = r7
        L_0x0038:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzct r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzh(r5, r6)
        L_0x0048:
            r7 = r9
            r9 = r5
            goto L_0x0057
        L_0x004b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0052
            r7 = r5
            r9 = r7
            goto L_0x0057
        L_0x0052:
            com.google.android.gms.internal.ads.zzct r1 = r0.zza
            long r5 = r1.zze
            goto L_0x0048
        L_0x0057:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzct r1 = r0.zza
            int r4 = r3.zzb
            r1.zzn(r4)
            goto L_0x006e
        L_0x0065:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x006e
            com.google.android.gms.internal.ads.zzct r4 = r0.zza
            r4.zzn(r1)
        L_0x006e:
            com.google.android.gms.internal.ads.zzkn r15 = new com.google.android.gms.internal.ads.zzkn
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.zzg(com.google.android.gms.internal.ads.zzcw, com.google.android.gms.internal.ads.zzkn):com.google.android.gms.internal.ads.zzkn");
    }

    public final zzto zzh(zzcw zzcw, Object obj, long j2) {
        long j3;
        int zza2;
        int i2 = zzcw.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (zza2 = zzcw.zza(obj2)) == -1 || zzcw.zzd(zza2, this.zza, false).zzd != i2) {
            zzkm zzkm = this.zzh;
            while (true) {
                if (zzkm == null) {
                    zzkm zzkm2 = this.zzh;
                    while (true) {
                        if (zzkm2 != null) {
                            int zza3 = zzcw.zza(zzkm2.zzb);
                            if (zza3 != -1 && zzcw.zzd(zza3, this.zza, false).zzd == i2) {
                                j3 = zzkm2.zzf.zza.zzd;
                                break;
                            }
                            zzkm2 = zzkm2.zzg();
                        } else {
                            j3 = this.zze;
                            this.zze = 1 + j3;
                            if (this.zzh == null) {
                                this.zzl = obj;
                                this.zzm = j3;
                            }
                        }
                    }
                } else if (zzkm.zzb.equals(obj)) {
                    j3 = zzkm.zzf.zza.zzd;
                    break;
                } else {
                    zzkm = zzkm.zzg();
                }
            }
        } else {
            j3 = this.zzm;
        }
        long j4 = j3;
        zzcw.zzn(obj, this.zza);
        zzcw.zze(this.zza.zzd, this.zzb, 0);
        int zza4 = zzcw.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcv zzcv = this.zzb;
            if (zza4 < zzcv.zzo) {
                return zzx(zzcw, obj3, j2, j4, zzcv, this.zza);
            }
            zzcw.zzd(zza4, this.zza, true);
            this.zza.zzb();
            zzct zzct = this.zza;
            if (zzct.zzd(zzct.zze) != -1) {
                obj3 = this.zza.zzc;
                obj3.getClass();
            }
            zza4--;
        }
    }

    public final void zzi() {
        if (this.zzk != 0) {
            zzkm zzkm = this.zzh;
            zzdy.zzb(zzkm);
            this.zzl = zzkm.zzb;
            this.zzm = zzkm.zzf.zza.zzd;
            while (zzkm != null) {
                zzkm.zzn();
                zzkm = zzkm.zzg();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzy();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzfrz zzfrz, zzto zzto) {
        this.zzc.zzQ(zzfrz.zzi(), zzto);
    }

    public final void zzk(long j2) {
        zzkm zzkm = this.zzj;
        if (zzkm != null) {
            zzkm.zzm(j2);
        }
    }

    public final boolean zzl(zztm zztm) {
        zzkm zzkm = this.zzj;
        return zzkm != null && zzkm.zza == zztm;
    }

    public final boolean zzm(zzkm zzkm) {
        boolean z2;
        boolean z3 = false;
        if (zzkm != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        if (zzkm.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkm;
        while (zzkm.zzg() != null) {
            zzkm = zzkm.zzg();
            if (zzkm == this.zzi) {
                this.zzi = this.zzh;
                z3 = true;
            }
            zzkm.zzn();
            this.zzk--;
        }
        this.zzj.zzo((zzkm) null);
        zzy();
        return z3;
    }

    public final boolean zzn() {
        zzkm zzkm = this.zzj;
        if (zzkm == null) {
            return true;
        }
        if (zzkm.zzf.zzi || !zzkm.zzr() || this.zzj.zzf.zze == -9223372036854775807L || this.zzk >= 100) {
            return false;
        }
        return true;
    }

    public final boolean zzo(zzcw zzcw, long j2, long j3) {
        zzkn zzkn;
        long j4;
        boolean z2;
        zzcw zzcw2 = zzcw;
        zzkm zzkm = this.zzh;
        zzkm zzkm2 = null;
        while (zzkm != null) {
            zzkn zzkn2 = zzkm.zzf;
            if (zzkm2 == null) {
                zzkn = zzg(zzcw2, zzkn2);
                long j5 = j2;
            } else {
                zzkn zzt = zzt(zzcw2, zzkm2, j2);
                if (zzt == null) {
                    if (!zzm(zzkm2)) {
                        return true;
                    }
                    return false;
                } else if (zzkn2.zzb == zzt.zzb && zzkn2.zza.equals(zzt.zza)) {
                    zzkn = zzt;
                } else if (!zzm(zzkm2)) {
                    return true;
                } else {
                    return false;
                }
            }
            zzkm.zzf = zzkn.zza(zzkn2.zzc);
            long j6 = zzkn2.zze;
            int i2 = (j6 > -9223372036854775807L ? 1 : (j6 == -9223372036854775807L ? 0 : -1));
            long j7 = zzkn.zze;
            if (i2 == 0 || j6 == j7) {
                zzkm2 = zzkm;
                zzkm = zzkm.zzg();
            } else {
                zzkm.zzq();
                long j8 = zzkn.zze;
                if (j8 == -9223372036854775807L) {
                    j4 = Clock.MAX_TIME;
                } else {
                    j4 = j8 + zzkm.zze();
                }
                if (zzkm == this.zzi) {
                    boolean z3 = zzkm.zzf.zzf;
                    if (j3 == Long.MIN_VALUE || j3 >= j4) {
                        z2 = true;
                        if (!zzm(zzkm) || z2) {
                            return false;
                        }
                        return true;
                    }
                }
                z2 = false;
                if (!zzm(zzkm)) {
                }
                return false;
            }
        }
        return true;
    }

    public final boolean zzp(zzcw zzcw, int i2) {
        this.zzf = i2;
        return zzB(zzcw);
    }

    public final boolean zzq(zzcw zzcw, boolean z2) {
        this.zzg = z2;
        return zzB(zzcw);
    }

    public final zzkm zzr(zzlk[] zzlkArr, zzxg zzxg, zzxp zzxp, zzlb zzlb, zzkn zzkn, zzxh zzxh) {
        long j2;
        zzkm zzkm = this.zzj;
        if (zzkm == null) {
            j2 = 1000000000000L;
            zzkn zzkn2 = zzkn;
        } else {
            j2 = (zzkm.zze() + zzkm.zzf.zze) - zzkn.zzb;
        }
        zzkm zzkm2 = new zzkm(zzlkArr, j2, zzxg, zzxp, zzlb, zzkn, zzxh);
        zzkm zzkm3 = this.zzj;
        if (zzkm3 != null) {
            zzkm3.zzo(zzkm2);
        } else {
            this.zzh = zzkm2;
            this.zzi = zzkm2;
        }
        this.zzl = null;
        this.zzj = zzkm2;
        this.zzk++;
        zzy();
        return zzkm2;
    }
}

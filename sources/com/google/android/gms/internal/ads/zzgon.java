package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

final class zzgon implements zzgrh {
    private final zzgom zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgon(zzgom zzgom) {
        byte[] bArr = zzgpw.zzd;
        this.zza = zzgom;
        zzgom.zzc = this;
    }

    private final void zzP(Object obj, zzgrp zzgrp, zzgoy zzgoy) throws IOException {
        int i2 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzgrp.zzh(obj, this, zzgoy);
            if (this.zzb != this.zzc) {
                throw zzgpy.zzg();
            }
        } finally {
            this.zzc = i2;
        }
    }

    private final void zzQ(Object obj, zzgrp zzgrp, zzgoy zzgoy) throws IOException {
        int zzn = this.zza.zzn();
        zzgom zzgom = this.zza;
        if (zzgom.zza < zzgom.zzb) {
            int zze = zzgom.zze(zzn);
            this.zza.zza++;
            zzgrp.zzh(obj, this, zzgoy);
            this.zza.zzz(0);
            zzgom zzgom2 = this.zza;
            zzgom2.zza--;
            zzgom2.zzA(zze);
            return;
        }
        throw new zzgpy("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i2) throws IOException {
        if (this.zza.zzd() != i2) {
            throw zzgpy.zzj();
        }
    }

    private final void zzS(int i2) throws IOException {
        if ((this.zzb & 7) != i2) {
            throw zzgpy.zza();
        }
    }

    private static final void zzT(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzgpy.zzg();
        }
    }

    private static final void zzU(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzgpy.zzg();
        }
    }

    public static zzgon zzq(zzgom zzgom) {
        zzgon zzgon = zzgom.zzc;
        return zzgon != null ? zzgon : new zzgon(zzgom);
    }

    public final void zzA(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgql.zzg(this.zza.zzo());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgql.zzg(this.zza.zzo());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzB(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpf) {
            zzgpf zzgpf = (zzgpf) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgpf.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd2);
            } else if (i2 == 5) {
                do {
                    zzgpf.zze(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd3);
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzgpy.zza();
            }
        }
    }

    @Deprecated
    public final void zzC(List list, zzgrp zzgrp, zzgoy zzgoy) throws IOException {
        int zzm;
        int i2 = this.zzb;
        if ((i2 & 7) == 3) {
            do {
                Object zze = zzgrp.zze();
                zzP(zze, zzgrp, zzgoy);
                zzgrp.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i2);
            this.zzd = zzm;
            return;
        }
        throw zzgpy.zza();
    }

    public final void zzD(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgpn.zzh(this.zza.zzh());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgpn.zzh(this.zza.zzh());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzE(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgql.zzg(this.zza.zzp());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgql.zzg(this.zza.zzp());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzF(List list, zzgrp zzgrp, zzgoy zzgoy) throws IOException {
        int zzm;
        int i2 = this.zzb;
        if ((i2 & 7) == 2) {
            do {
                Object zze = zzgrp.zze();
                zzQ(zze, zzgrp, zzgoy);
                zzgrp.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i2);
            this.zzd = zzm;
            return;
        }
        throw zzgpy.zza();
    }

    public final void zzG(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgpn.zzh(this.zza.zzk());
                } while (this.zza.zzd() < zzd2);
            } else if (i2 == 5) {
                do {
                    zzgpn.zzh(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd3);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzH(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgql.zzg(this.zza.zzt());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgql.zzg(this.zza.zzt());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzI(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgpn.zzh(this.zza.zzl());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgpn.zzh(this.zza.zzl());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzJ(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgql.zzg(this.zza.zzu());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgql.zzg(this.zza.zzu());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzK(List list, boolean z2) throws IOException {
        String str;
        int zzm;
        int zzm2;
        if ((this.zzb & 7) != 2) {
            throw zzgpy.zza();
        } else if ((list instanceof zzgqe) && !z2) {
            zzgqe zzgqe = (zzgqe) list;
            do {
                zzgqe.zzi(zzp());
                if (!this.zza.zzC()) {
                    zzm2 = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
        } else {
            do {
                if (z2) {
                    str = zzs();
                } else {
                    str = zzr();
                }
                list.add(str);
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
        }
    }

    public final void zzL(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgpn.zzh(this.zza.zzn());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgpn.zzh(this.zza.zzn());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzM(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgql = (zzgql) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgql.zzg(this.zza.zzv());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgql.zzg(this.zza.zzv());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    public final boolean zzO() throws IOException {
        int i2;
        if (this.zza.zzC() || (i2 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i2);
    }

    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    public final int zzc() throws IOException {
        int i2 = this.zzd;
        if (i2 != 0) {
            this.zzb = i2;
            this.zzd = 0;
        } else {
            i2 = this.zza.zzm();
            this.zzb = i2;
        }
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    public final zzgoe zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    public final void zzt(Object obj, zzgrp zzgrp, zzgoy zzgoy) throws IOException {
        zzS(3);
        zzP(obj, zzgrp, zzgoy);
    }

    public final void zzu(Object obj, zzgrp zzgrp, zzgoy zzgoy) throws IOException {
        zzS(2);
        zzQ(obj, zzgrp, zzgoy);
    }

    public final void zzv(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgns) {
            zzgns zzgns = (zzgns) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgns.zze(this.zza.zzD());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgns.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzgpy.zza();
    }

    public final void zzx(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgov) {
            zzgov zzgov = (zzgov) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgov.zze(this.zza.zzb());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgov.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzy(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgpn.zzh(this.zza.zzf());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i2 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzgpn.zzh(this.zza.zzf());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i3 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzgpy.zza();
            }
        }
    }

    public final void zzz(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpn = (zzgpn) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgpn.zzh(this.zza.zzg());
                } while (this.zza.zzd() < zzd2);
            } else if (i2 == 5) {
                do {
                    zzgpn.zzh(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzgpy.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd3);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzgpy.zza();
            }
        }
    }
}

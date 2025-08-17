package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzgra implements zzgrp {
    private final zzgqw zza;
    private final zzgsg zzb;
    private final boolean zzc;
    private final zzgoz zzd;

    private zzgra(zzgsg zzgsg, zzgoz zzgoz, zzgqw zzgqw) {
        this.zzb = zzgsg;
        this.zzc = zzgoz.zzh(zzgqw);
        this.zzd = zzgoz;
        this.zza = zzgqw;
    }

    static zzgra zzc(zzgsg zzgsg, zzgoz zzgoz, zzgqw zzgqw) {
        return new zzgra(zzgsg, zzgoz, zzgqw);
    }

    public final int zza(Object obj) {
        zzgsg zzgsg = this.zzb;
        int zzb2 = zzgsg.zzb(zzgsg.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzgqw zzgqw = this.zza;
        if (zzgqw instanceof zzgpm) {
            return ((zzgpm) zzgqw).zzaD();
        }
        return zzgqw.zzaP().zzan();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzgrr.zzC(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, zzgrh zzgrh, zzgoy zzgoy) throws IOException {
        boolean z2;
        zzgsg zzgsg = this.zzb;
        zzgoz zzgoz = this.zzd;
        Object zzc2 = zzgsg.zzc(obj);
        zzgpd zzb2 = zzgoz.zzb(obj);
        while (zzgrh.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzgrh.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzgoz.zzc(zzgoy, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzgoz.zzf(zzgrh, zzc3, zzgoy, zzb2);
                    } else {
                        z2 = zzgsg.zzp(zzc2, zzgrh);
                    }
                } else {
                    z2 = zzgrh.zzO();
                }
                if (!z2) {
                    zzgsg.zzn(obj, zzc2);
                    return;
                }
            } else {
                Object obj2 = null;
                zzgoe zzgoe = null;
                int i2 = 0;
                while (true) {
                    try {
                        if (zzgrh.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzgrh.zzd();
                        if (zzd3 == 16) {
                            i2 = zzgrh.zzj();
                            obj2 = zzgoz.zzc(zzgoy, this.zza, i2);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzgoz.zzf(zzgrh, obj2, zzgoy, zzb2);
                            } else {
                                zzgoe = zzgrh.zzp();
                            }
                        } else if (!zzgrh.zzO()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzgsg.zzn(obj, zzc2);
                        throw th;
                    }
                }
                if (zzgrh.zzd() != 12) {
                    throw zzgpy.zzb();
                } else if (zzgoe != null) {
                    if (obj2 != null) {
                        zzgoz.zzg(zzgoe, obj2, zzgoy, zzb2);
                    } else {
                        zzgsg.zzk(zzc2, i2, zzgoe);
                    }
                }
            }
        }
        zzgsg.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i2, int i3, zzgnq zzgnq) throws IOException {
        zzgpm zzgpm = (zzgpm) obj;
        if (zzgpm.zzc == zzgsh.zzc()) {
            zzgpm.zzc = zzgsh.zzf();
        }
        zzgpj zzgpj = (zzgpj) obj;
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    public final void zzm(Object obj, zzgou zzgou) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}

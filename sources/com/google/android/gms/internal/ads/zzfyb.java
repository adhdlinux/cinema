package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzfyb {
    private final zzgkx zza;
    private final List zzb;
    private final zzghn zzc;

    private zzfyb(zzgkx zzgkx, List list) {
        this.zza = zzgkx;
        this.zzb = list;
        this.zzc = zzghn.zza;
    }

    private zzfyb(zzgkx zzgkx, List list, zzghn zzghn) {
        this.zza = zzgkx;
        this.zzb = list;
        this.zzc = zzghn;
    }

    static final zzfyb zza(zzgkx zzgkx) throws GeneralSecurityException {
        zzi(zzgkx);
        return new zzfyb(zzgkx, zzh(zzgkx));
    }

    static final zzfyb zzb(zzgkx zzgkx, zzghn zzghn) throws GeneralSecurityException {
        zzi(zzgkx);
        return new zzfyb(zzgkx, zzh(zzgkx), zzghn);
    }

    public static final zzfyb zzc(zzfyf zzfyf) throws GeneralSecurityException {
        zzfxy zzfxy = new zzfxy();
        zzfxw zzfxw = new zzfxw(zzfyf, (zzfxv) null);
        zzfxw.zze();
        zzfxw.zzd();
        zzfxy.zza(zzfxw);
        return zzfxy.zzb();
    }

    private static zzgfa zzf(zzgkw zzgkw) {
        Integer num;
        int zza2 = zzgkw.zza();
        if (zzgkw.zzf() == zzglq.RAW) {
            num = null;
        } else {
            num = Integer.valueOf(zza2);
        }
        try {
            return zzgfa.zza(zzgkw.zzc().zzg(), zzgkw.zzc().zzf(), zzgkw.zzc().zzc(), zzgkw.zzf(), num);
        } catch (GeneralSecurityException e2) {
            throw new zzgfl("Creating a protokey serialization failed", e2);
        }
    }

    private static Object zzg(zzgdj zzgdj, zzgkw zzgkw, Class cls) throws GeneralSecurityException {
        try {
            zzgkk zzc2 = zzgkw.zzc();
            int i2 = zzfyp.zza;
            return zzfyp.zzc(zzc2.zzg(), zzc2.zzf(), cls);
        } catch (GeneralSecurityException e2) {
            if (e2.getMessage().contains("No key manager found for key type ") || e2.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e2;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    private static List zzh(zzgkx zzgkx) {
        zzfxs zzfxs;
        boolean z2;
        ArrayList arrayList = new ArrayList(zzgkx.zza());
        for (zzgkw zzgkw : zzgkx.zzh()) {
            int zza2 = zzgkw.zza();
            try {
                zzfxn zza3 = zzgeg.zzc().zza(zzf(zzgkw), zzfyq.zza());
                int zzk = zzgkw.zzk() - 2;
                if (zzk == 1) {
                    zzfxs = zzfxs.zza;
                } else if (zzk == 2) {
                    zzfxs = zzfxs.zzb;
                } else if (zzk == 3) {
                    zzfxs = zzfxs.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                zzfxs zzfxs2 = zzfxs;
                if (zza2 == zzgkx.zzc()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                arrayList.add(new zzfya(zza3, zzfxs2, zza2, z2, (zzfxz) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzi(zzgkx zzgkx) throws GeneralSecurityException {
        if (zzgkx == null || zzgkx.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static final Object zzj(zzgdj zzgdj, zzfxn zzfxn, Class cls) throws GeneralSecurityException {
        try {
            return zzgee.zza().zzc(zzfxn, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        zzgkx zzgkx = this.zza;
        Charset charset = zzfyr.zza;
        zzgkz zza2 = zzglc.zza();
        zza2.zzb(zzgkx.zzc());
        for (zzgkw zzgkw : zzgkx.zzh()) {
            zzgla zza3 = zzglb.zza();
            zza3.zzc(zzgkw.zzc().zzg());
            zza3.zzd(zzgkw.zzk());
            zza3.zzb(zzgkw.zzf());
            zza3.zza(zzgkw.zza());
            zza2.zza((zzglb) zza3.zzal());
        }
        return ((zzglc) zza2.zzal()).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzgkx zzd() {
        return this.zza;
    }

    public final Object zze(zzfxl zzfxl, Class cls) throws GeneralSecurityException {
        Object obj;
        boolean z2;
        Class zzb2 = zzfyp.zzb(cls);
        if (zzb2 != null) {
            zzgkx zzgkx = this.zza;
            Charset charset = zzfyr.zza;
            int zzc2 = zzgkx.zzc();
            int i2 = 0;
            boolean z3 = false;
            boolean z4 = true;
            for (zzgkw zzgkw : zzgkx.zzh()) {
                if (zzgkw.zzk() == 3) {
                    if (!zzgkw.zzj()) {
                        throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzgkw.zza())}));
                    } else if (zzgkw.zzf() == zzglq.UNKNOWN_PREFIX) {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzgkw.zza())}));
                    } else if (zzgkw.zzk() != 2) {
                        if (zzgkw.zza() == zzc2) {
                            if (!z3) {
                                z3 = true;
                            } else {
                                throw new GeneralSecurityException("keyset contains multiple primary keys");
                            }
                        }
                        if (zzgkw.zzc().zzc() != zzgkj.ASYMMETRIC_PUBLIC) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        z4 &= z2;
                        i2++;
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzgkw.zza())}));
                    }
                }
            }
            if (i2 == 0) {
                throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
            } else if (z3 || z4) {
                zzfyh zzfyh = new zzfyh(zzb2, (zzfyg) null);
                zzfyh.zzc(this.zzc);
                for (int i3 = 0; i3 < this.zza.zza(); i3++) {
                    zzgkw zze = this.zza.zze(i3);
                    if (zze.zzk() == 3) {
                        zzgdj zzgdj = (zzgdj) zzfxl;
                        Object zzg = zzg(zzgdj, zze, zzb2);
                        if (this.zzb.get(i3) != null) {
                            obj = zzj(zzgdj, ((zzfya) this.zzb.get(i3)).zza(), zzb2);
                        } else {
                            obj = null;
                        }
                        if (obj == null && zzg == null) {
                            throw new GeneralSecurityException("Unable to get primitive " + zzb2.toString() + " for key of type " + zze.zzc().zzg());
                        } else if (zze.zza() == this.zza.zzc()) {
                            zzfyh.zzb(obj, zzg, zze);
                        } else {
                            zzfyh.zza(obj, zzg, zze);
                        }
                    }
                }
                return zzgee.zza().zzd(zzfyh.zzd(), cls);
            } else {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
        } else {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
        }
    }
}

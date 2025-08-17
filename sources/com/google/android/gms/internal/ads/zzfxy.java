package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class zzfxy {
    private final List zza = new ArrayList();
    private final zzghn zzb = zzghn.zza;
    private boolean zzc = false;

    /* access modifiers changed from: private */
    public final void zzd() {
        for (zzfxw zzj : this.zza) {
            zzj.zza = false;
        }
    }

    public final zzfxy zza(zzfxw zzfxw) {
        if (zzfxw.zzf == null) {
            if (zzfxw.zza) {
                zzd();
            }
            zzfxw.zzf = this;
            this.zza.add(zzfxw);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzfyb zzb() throws GeneralSecurityException {
        byte b2;
        Object obj;
        if (!this.zzc) {
            this.zzc = true;
            zzgku zzd = zzgkx.zzd();
            List list = this.zza;
            int i2 = 0;
            while (i2 < list.size() - 1) {
                if (((zzfxw) list.get(i2)).zze != zzfxx.zza || ((zzfxw) list.get(i2 + 1)).zze == zzfxx.zza) {
                    i2++;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzfxw zzfxw : this.zza) {
                zzfxs unused = zzfxw.zzb;
                if (zzfxw.zze != null) {
                    int i3 = 3;
                    if (zzfxw.zze == zzfxx.zza) {
                        b2 = 0;
                        while (true) {
                            if (b2 != 0 && !hashSet.contains(Integer.valueOf(b2))) {
                                break;
                            }
                            SecureRandom secureRandom = new SecureRandom();
                            byte[] bArr = new byte[4];
                            byte b3 = 0;
                            while (b3 == 0) {
                                secureRandom.nextBytes(bArr);
                                b3 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                            }
                            b2 = b3;
                        }
                    } else {
                        zzfxx unused2 = zzfxw.zze;
                        b2 = 0;
                    }
                    Integer valueOf = Integer.valueOf(b2);
                    if (!hashSet.contains(valueOf)) {
                        hashSet.add(valueOf);
                        zzfxn unused3 = zzfxw.zzc;
                        zzfyf zzh = zzfxw.zzd;
                        zzfxs zzc2 = zzfxw.zzc();
                        if (!zzfxs.zza.equals(zzc2)) {
                            if (zzfxs.zzb.equals(zzc2)) {
                                i3 = 4;
                            } else if (zzfxs.zzc.equals(zzc2)) {
                                i3 = 5;
                            } else {
                                throw new IllegalStateException("Unknown key status");
                            }
                        }
                        if (zzh instanceof zzgdx) {
                            obj = ((zzgdx) zzh).zza();
                        } else {
                            obj = zzgeg.zzc().zzd(zzh, zzgfb.class);
                        }
                        zzgfb zzgfb = (zzgfb) obj;
                        zzgkk zza2 = zzfyp.zza(zzgfb.zzb());
                        zzgkv zzd2 = zzgkw.zzd();
                        zzd2.zzb(b2);
                        zzd2.zzd(i3);
                        zzd2.zza(zza2);
                        zzd2.zzc(zzgfb.zzb().zzf());
                        zzd.zza((zzgkw) zzd2.zzal());
                        if (zzfxw.zza) {
                            if (num == null) {
                                num = valueOf;
                            } else {
                                throw new GeneralSecurityException("Two primaries were set");
                            }
                        }
                    } else {
                        throw new GeneralSecurityException("Id " + b2 + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num != null) {
                zzd.zzb(num.intValue());
                return zzfyb.zzb((zzgkx) zzd.zzal(), this.zzb);
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}

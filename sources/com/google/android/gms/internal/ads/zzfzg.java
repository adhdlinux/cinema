package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzfzg {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private Integer zzd;
    private zzfzh zze;
    private zzfzi zzf;

    private zzfzg() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        throw null;
    }

    /* synthetic */ zzfzg(zzfzf zzfzf) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzf = zzfzi.zzc;
    }

    public final zzfzg zza(int i2) throws GeneralSecurityException {
        if (i2 == 16 || i2 == 24 || i2 == 32) {
            this.zza = Integer.valueOf(i2);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzfzg zzb(zzfzh zzfzh) {
        this.zze = zzfzh;
        return this;
    }

    public final zzfzg zzc(int i2) throws GeneralSecurityException {
        if (i2 >= 16) {
            this.zzb = Integer.valueOf(i2);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzfzg zzd(int i2) throws GeneralSecurityException {
        if (i2 < 12 || i2 > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", new Object[]{Integer.valueOf(i2)}));
        }
        this.zzc = Integer.valueOf(i2);
        return this;
    }

    public final zzfzg zze(int i2) throws GeneralSecurityException {
        if (i2 >= 10) {
            this.zzd = Integer.valueOf(i2);
            return this;
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzfzg zzf(zzfzi zzfzi) {
        this.zzf = zzfzi;
        return this;
    }

    public final zzfzk zzg() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("AES key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("HMAC key size is not set");
        } else if (this.zzc != null) {
            Integer num = this.zzd;
            if (num == null) {
                throw new GeneralSecurityException("tag size is not set");
            } else if (this.zze == null) {
                throw new GeneralSecurityException("hash type is not set");
            } else if (this.zzf != null) {
                int intValue = num.intValue();
                zzfzh zzfzh = this.zze;
                if (zzfzh == zzfzh.zza) {
                    if (intValue > 20) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzfzh == zzfzh.zzb) {
                    if (intValue > 28) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzfzh == zzfzh.zzc) {
                    if (intValue > 32) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzfzh == zzfzh.zzd) {
                    if (intValue > 48) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzfzh != zzfzh.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                } else if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                }
                return new zzfzk(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze, (zzfzj) null);
            } else {
                throw new GeneralSecurityException("variant is not set");
            }
        } else {
            throw new GeneralSecurityException("iv size is not set");
        }
    }
}

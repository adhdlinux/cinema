package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

class zzfmf {
    static final String zza = new UUID(0, 0).toString();
    final zzfmg zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    zzfmf(Context context, String str, String str2, String str3) {
        this.zzb = zzfmg.zzb(context);
        this.zzc = str;
        this.zzd = str.concat("_3p");
        this.zze = str2;
        this.zzf = str2.concat("_3p");
        this.zzg = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        String str4;
        if (str2 == null || str3 == null) {
            String str5 = this.zzg;
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            sb.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
            String str6 = "null";
            if (str2 == null) {
                str4 = str6;
            } else {
                str4 = "not null";
            }
            sb.append(str4);
            sb.append(", hashKey is ");
            if (str3 != null) {
                str6 = "not null";
            }
            sb.append(str6);
            throw new IllegalArgumentException(sb.toString());
        }
        return UUID.nameUUIDFromBytes((str + str2 + str3).getBytes(StandardCharsets.UTF_8)).toString();
    }

    /* access modifiers changed from: package-private */
    public final long zza(boolean z2) {
        return this.zzb.zza(z2 ? this.zzf : this.zze, -1);
    }

    /* access modifiers changed from: package-private */
    public final zzfme zzb(String str, String str2, long j2, boolean z2) throws IOException {
        String str3;
        boolean z3 = true;
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String zze2 = zze(true);
                    String zzc2 = this.zzb.zzc("paid_3p_hash_key", (String) null);
                    if (!(zze2 == null || zzc2 == null || zze2.equals(zzh(str, str2, zzc2)))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfme();
        }
        if (str == null) {
            z3 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            long zza2 = zza(z3);
            if (zza2 != -1) {
                if (currentTimeMillis < zza2) {
                    zzfmg zzfmg = this.zzb;
                    if (z3) {
                        str3 = this.zzf;
                    } else {
                        str3 = this.zze;
                    }
                    zzfmg.zzd(str3, Long.valueOf(currentTimeMillis));
                } else if (currentTimeMillis >= zza2 + j2) {
                    return zzc(str, str2);
                }
            }
            String zze3 = zze(z3);
            if (zze3 != null || z2) {
                return new zzfme(zze3, zza(z3));
            }
            return zzc(str, str2);
        }
        throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    /* access modifiers changed from: package-private */
    public final zzfme zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String uuid = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", uuid);
        return zzd(zzh(str, str2, uuid), true);
    }

    /* access modifiers changed from: package-private */
    public final zzfme zzd(String str, boolean z2) throws IOException {
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            zzfmg zzfmg = this.zzb;
            if (z2) {
                str2 = this.zzf;
            } else {
                str2 = this.zze;
            }
            zzfmg.zzd(str2, Long.valueOf(currentTimeMillis));
            zzfmg zzfmg2 = this.zzb;
            if (z2) {
                str3 = this.zzd;
            } else {
                str3 = this.zzc;
            }
            zzfmg2.zzd(str3, str);
            return new zzfme(str, currentTimeMillis);
        }
        throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    /* access modifiers changed from: package-private */
    public final String zze(boolean z2) {
        return this.zzb.zzc(z2 ? this.zzd : this.zzc, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z2) throws IOException {
        String str;
        String str2;
        zzfmg zzfmg = this.zzb;
        if (z2) {
            str = this.zzf;
        } else {
            str = this.zze;
        }
        zzfmg.zze(str);
        zzfmg zzfmg2 = this.zzb;
        if (z2) {
            str2 = this.zzd;
        } else {
            str2 = this.zzc;
        }
        zzfmg2.zze(str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(boolean z2) {
        return this.zzb.zzg(this.zzc);
    }
}

package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;

public final class zzgc extends zzfy {
    private zzgj zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgc() {
        super(false);
    }

    public final int zza(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.zzd;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        byte[] bArr2 = this.zzb;
        int i5 = zzfj.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i2, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzgj zzgj) throws IOException {
        zzi(zzgj);
        this.zza = zzgj;
        Uri normalizeScheme = zzgj.zza.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        zzdy.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i2 = zzfj.zza;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    throw zzcd.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e2);
                }
            } else {
                this.zzb = URLDecoder.decode(str, zzfot.zza.name()).getBytes(zzfot.zzc);
            }
            long j2 = zzgj.zzf;
            int length = this.zzb.length;
            if (j2 <= ((long) length)) {
                int i3 = (int) j2;
                this.zzc = i3;
                int i4 = length - i3;
                this.zzd = i4;
                long j3 = zzgj.zzg;
                if (j3 != -1) {
                    this.zzd = (int) Math.min((long) i4, j3);
                }
                zzj(zzgj);
                long j4 = zzgj.zzg;
                if (j4 != -1) {
                    return j4;
                }
                return (long) this.zzd;
            }
            this.zzb = null;
            throw new zzgf(2008);
        }
        throw zzcd.zzb("Unexpected URI format: ".concat(String.valueOf(normalizeScheme)), (Throwable) null);
    }

    public final Uri zzc() {
        zzgj zzgj = this.zza;
        if (zzgj != null) {
            return zzgj.zza;
        }
        return null;
    }

    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}

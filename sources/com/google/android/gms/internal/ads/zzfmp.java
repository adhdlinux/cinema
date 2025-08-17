package com.google.android.gms.internal.ads;

final class zzfmp extends zzfna {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzfmp(String str, String str2, zzfmo zzfmo) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfna) {
            zzfna zzfna = (zzfna) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfna.zzb()) : zzfna.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfna.zza()) : zzfna.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        String str = this.zza;
        int i3 = 0;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i2 ^ 1000003) * 1000003) ^ i3;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "OverlayDisplayDismissRequest{sessionToken=" + str + ", appId=" + str2 + "}";
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}

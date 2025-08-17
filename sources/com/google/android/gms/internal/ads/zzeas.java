package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;

final class zzeas extends zzebn {
    private final Activity zza;
    private final zzl zzb;
    private final zzbr zzc;
    private final String zzd;
    private final String zze;

    /* synthetic */ zzeas(Activity activity, zzl zzl, zzbr zzbr, String str, String str2, zzear zzear) {
        this.zza = activity;
        this.zzb = zzl;
        this.zzc = zzbr;
        this.zzd = str;
        this.zze = str2;
    }

    public final boolean equals(Object obj) {
        zzl zzl;
        zzbr zzbr;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzebn) {
            zzebn zzebn = (zzebn) obj;
            if (!this.zza.equals(zzebn.zza()) || ((zzl = this.zzb) != null ? !zzl.equals(zzebn.zzb()) : zzebn.zzb() != null) || ((zzbr = this.zzc) != null ? !zzbr.equals(zzebn.zzc()) : zzebn.zzc() != null) || ((str = this.zzd) != null ? !str.equals(zzebn.zzd()) : zzebn.zzd() != null) || ((str2 = this.zze) != null ? !str2.equals(zzebn.zze()) : zzebn.zze() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4;
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzl zzl = this.zzb;
        int i5 = 0;
        if (zzl == null) {
            i2 = 0;
        } else {
            i2 = zzl.hashCode();
        }
        int i6 = ((hashCode * 1000003) ^ i2) * 1000003;
        zzbr zzbr = this.zzc;
        if (zzbr == null) {
            i3 = 0;
        } else {
            i3 = zzbr.hashCode();
        }
        int i7 = (i6 ^ i3) * 1000003;
        String str = this.zzd;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i8 = (i7 ^ i4) * 1000003;
        String str2 = this.zze;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i8 ^ i5;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String str = this.zzd;
        String str2 = this.zze;
        return "OfflineUtilsParams{activity=" + obj + ", adOverlay=" + valueOf + ", workManagerUtil=" + valueOf2 + ", gwsQueryId=" + str + ", uri=" + str2 + "}";
    }

    public final Activity zza() {
        return this.zza;
    }

    public final zzl zzb() {
        return this.zzb;
    }

    public final zzbr zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zze;
    }
}

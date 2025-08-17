package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.client.zzep;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

public final class zzbrh implements NativeCustomFormatAd {
    private final zzbfl zza;
    private NativeCustomFormatAd.DisplayOpenMeasurement zzb;

    @VisibleForTesting
    public zzbrh(zzbfl zzbfl) {
        this.zza = zzbfl;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final String getCustomFormatId() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzb == null && this.zza.zzq()) {
                this.zzb = new zzbqz(this.zza);
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
        return this.zzb;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzber zzg = this.zza.zzg(str);
            if (zzg != null) {
                return new zzbra(zzg);
            }
            return null;
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzf() != null) {
                return new zzep(this.zza.zzf(), this.zza);
            }
            return null;
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zzj(str);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzo();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }
}

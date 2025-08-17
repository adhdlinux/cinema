package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzdcu;
import com.google.ar.core.ImageMetadata;

public final class zzm {
    public static final void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z2) {
        zzx zzx;
        if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
            zza zza = adOverlayInfoParcel.zzb;
            if (zza != null) {
                zza.onAdClicked();
            }
            zzdcu zzdcu = adOverlayInfoParcel.zzv;
            if (zzdcu != null) {
                zzdcu.zzr();
            }
            Activity zzi = adOverlayInfoParcel.zzd.zzi();
            zzc zzc = adOverlayInfoParcel.zza;
            if (!(zzc == null || !zzc.zzj || zzi == null)) {
                context = zzi;
            }
            zzt.zzh();
            zzc zzc2 = adOverlayInfoParcel.zza;
            zzz zzz = adOverlayInfoParcel.zzi;
            if (zzc2 != null) {
                zzx = zzc2.zzi;
            } else {
                zzx = null;
            }
            zza.zzb(context, zzc2, zzz, zzx);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.zzd);
        intent.putExtra("shouldCallOnOverlayOpened", z2);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(ImageMetadata.LENS_APERTURE);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzt.zzp();
        zzs.zzP(context, intent);
    }
}

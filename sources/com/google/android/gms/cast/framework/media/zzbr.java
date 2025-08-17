package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;

final class zzbr implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbu zza;
    final /* synthetic */ zzbu zzb;
    final /* synthetic */ TracksChooserDialogFragment zzc;

    zzbr(TracksChooserDialogFragment tracksChooserDialogFragment, zzbu zzbu, zzbu zzbu2) {
        this.zzc = tracksChooserDialogFragment;
        this.zza = zzbu;
        this.zzb = zzbu2;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        TracksChooserDialogFragment.zzc(this.zzc, this.zza, this.zzb);
    }
}

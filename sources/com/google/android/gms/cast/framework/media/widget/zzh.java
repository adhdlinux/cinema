package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzh implements zza {
    final /* synthetic */ ExpandedControllerActivity zza;

    zzh(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    @TargetApi(23)
    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            ExpandedControllerActivity expandedControllerActivity = this.zza;
            if (expandedControllerActivity.zzG != null) {
                expandedControllerActivity.zzG.setVisibility(8);
            }
            ExpandedControllerActivity expandedControllerActivity2 = this.zza;
            if (expandedControllerActivity2.zzF != null) {
                expandedControllerActivity2.zzF.setVisibility(0);
                this.zza.zzF.setImageBitmap(bitmap);
            }
        }
    }
}

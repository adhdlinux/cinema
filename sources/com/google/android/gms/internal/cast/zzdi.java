package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.api.Status;
import com.vungle.ads.internal.protos.Sdk$SDKError;

@TargetApi(19)
public final class zzdi extends zzdh {
    final /* synthetic */ zzdk zza;
    private final zzdp zzb;

    public zzdi(zzdk zzdk, zzdp zzdp) {
        this.zza = zzdk;
        this.zzb = zzdp;
    }

    public final void zzb(int i2, int i3, Surface surface) {
        int i4;
        zzdm.zza.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzb.getContext().getSystemService(ViewProps.DISPLAY);
        if (displayManager == null) {
            zzdm.zza.e("Unable to get the display manager", new Object[0]);
            this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        zzdm.zzf(this.zza.zzc);
        if (i2 < i3) {
            i4 = i2;
        } else {
            i4 = i3;
        }
        this.zza.zzc.zzc = displayManager.createVirtualDisplay("private_display", i2, i3, (i4 * Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE) / 1080, surface, 2);
        zzdm zzdm = this.zza.zzc;
        if (zzdm.zzc == null) {
            zzdm.zza.e("Unable to create virtual display", new Object[0]);
            this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
        } else if (zzdm.zzc.getDisplay() == null) {
            zzdm.zza.e("Virtual display does not have a display", new Object[0]);
            this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
        } else {
            try {
                zzdp zzdp = this.zzb;
                ((zzds) zzdp.getService()).zzf(this, this.zza.zzc.zzc.getDisplay().getDisplayId());
            } catch (RemoteException | IllegalStateException unused) {
                zzdm.zza.e("Unable to provision the route's new virtual Display", new Object[0]);
                this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
            }
        }
    }

    public final void zzc() {
        zzdm.zza.d("onConnectedWithDisplay", new Object[0]);
        zzdm zzdm = this.zza.zzc;
        if (zzdm.zzc == null) {
            zzdm.zza.e("There is no virtual display", new Object[0]);
            this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        Display display = zzdm.zzc.getDisplay();
        if (display != null) {
            this.zza.setResult(new zzdl(display));
            return;
        }
        zzdm.zza.e("Virtual display no longer has a display", new Object[0]);
        this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
    }

    public final void zzd(int i2) throws RemoteException {
        zzdm.zza.d("onError: %d", Integer.valueOf(i2));
        zzdm.zzf(this.zza.zzc);
        this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
    }
}

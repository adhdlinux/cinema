package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.util.PlatformVersion;

public final class zzcg extends UIController {
    private final ImageView zza;
    private final View zzb;
    private final boolean zzc;
    private final Drawable zzd;
    private final String zze;
    private final Drawable zzf;
    private final String zzg;
    private final Drawable zzh;
    private final String zzi;
    private boolean zzj = false;

    public zzcg(ImageView imageView, Context context, Drawable drawable, Drawable drawable2, Drawable drawable3, View view, boolean z2) {
        this.zza = imageView;
        this.zzd = drawable;
        this.zzf = drawable2;
        this.zzh = drawable3 != null ? drawable3 : drawable2;
        this.zze = context.getString(R.string.cast_play);
        this.zzg = context.getString(R.string.cast_pause);
        this.zzi = context.getString(R.string.cast_stop);
        this.zzb = view;
        this.zzc = z2;
        imageView.setEnabled(false);
    }

    private final void zza(Drawable drawable, String str) {
        boolean z2 = !drawable.equals(this.zza.getDrawable());
        this.zza.setImageDrawable(drawable);
        this.zza.setContentDescription(str);
        this.zza.setVisibility(0);
        this.zza.setEnabled(true);
        View view = this.zzb;
        if (view != null) {
            view.setVisibility(8);
        }
        if (z2 && this.zzj) {
            this.zza.sendAccessibilityEvent(8);
        }
    }

    @TargetApi(21)
    private final void zzb(boolean z2) {
        if (PlatformVersion.isAtLeastLollipop()) {
            this.zzj = this.zza.isAccessibilityFocused();
        }
        View view = this.zzb;
        int i2 = 0;
        if (view != null) {
            view.setVisibility(0);
            if (this.zzj) {
                this.zzb.sendAccessibilityEvent(8);
            }
        }
        ImageView imageView = this.zza;
        if (true == this.zzc) {
            i2 = 4;
        }
        imageView.setVisibility(i2);
        this.zza.setEnabled(!z2);
    }

    private final void zzc() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            this.zza.setEnabled(false);
        } else if (remoteMediaClient.isPlaying()) {
            if (remoteMediaClient.isLiveStream()) {
                zza(this.zzh, this.zzi);
            } else {
                zza(this.zzf, this.zzg);
            }
        } else if (remoteMediaClient.isBuffering()) {
            zzb(false);
        } else if (remoteMediaClient.isPaused()) {
            zza(this.zzd, this.zze);
        } else if (remoteMediaClient.isLoadingNextItem()) {
            zzb(true);
        }
    }

    public final void onMediaStatusUpdated() {
        zzc();
    }

    public final void onSendingRemoteMediaRequest() {
        zzb(true);
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zzc();
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}

package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaUtils;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.images.WebImage;

public final class zzbz extends UIController {
    /* access modifiers changed from: private */
    public final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    /* access modifiers changed from: private */
    public final View zzd;
    private final ImagePicker zze;
    /* access modifiers changed from: private */
    public final zzby zzf;
    private final zzb zzg;

    public zzbz(ImageView imageView, Context context, ImageHints imageHints, int i2, View view, zzby zzby) {
        Bitmap bitmap;
        this.zza = imageView;
        this.zzb = imageHints;
        this.zzf = zzby;
        ImagePicker imagePicker = null;
        if (i2 != 0) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), i2);
        } else {
            bitmap = null;
        }
        this.zzc = bitmap;
        this.zzd = view;
        CastContext zza2 = CastContext.zza(context);
        if (zza2 != null) {
            CastMediaOptions castMediaOptions = zza2.getCastOptions().getCastMediaOptions();
            this.zze = castMediaOptions != null ? castMediaOptions.getImagePicker() : imagePicker;
        } else {
            this.zze = null;
        }
        this.zzg = new zzb(context.getApplicationContext());
    }

    private final void zzd() {
        View view = this.zzd;
        if (view != null) {
            view.setVisibility(0);
            this.zza.setVisibility(4);
        }
        Bitmap bitmap = this.zzc;
        if (bitmap != null) {
            this.zza.setImageBitmap(bitmap);
        }
    }

    private final void zze() {
        Uri uri;
        WebImage onPickImage;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            zzd();
            return;
        }
        MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
        if (mediaInfo == null) {
            uri = null;
        } else {
            MediaMetadata metadata = mediaInfo.getMetadata();
            ImagePicker imagePicker = this.zze;
            if (imagePicker == null || metadata == null || (onPickImage = imagePicker.onPickImage(metadata, this.zzb)) == null || onPickImage.getUrl() == null) {
                uri = MediaUtils.getImageUri(mediaInfo, 0);
            } else {
                uri = onPickImage.getUrl();
            }
        }
        if (uri == null) {
            zzd();
        } else {
            this.zzg.zzd(uri);
        }
    }

    public final void onMediaStatusUpdated() {
        zze();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zzg.zzc(new zzbx(this));
        zzd();
        zze();
    }

    public final void onSessionEnded() {
        this.zzg.zza();
        zzd();
        super.onSessionEnded();
    }
}

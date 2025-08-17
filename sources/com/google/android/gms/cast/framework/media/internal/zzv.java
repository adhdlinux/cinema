package com.google.android.gms.cast.framework.media.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.zzg;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzdx;
import com.google.android.gms.internal.cast.zzdy;
import com.unity3d.services.core.device.MimeTypes;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzv {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final Logger zzb = new Logger("MediaSessionManager");
    /* access modifiers changed from: private */
    public final Context zzc;
    private final CastOptions zzd;
    private final zzbf zze;
    /* access modifiers changed from: private */
    public final SessionManager zzf;
    /* access modifiers changed from: private */
    public final NotificationOptions zzg;
    private final ComponentName zzh;
    /* access modifiers changed from: private */
    public final ComponentName zzi;
    private final zzb zzj;
    private final zzb zzk;
    private final zzo zzl;
    private final Handler zzm;
    private final Runnable zzn;
    private final RemoteMediaClient.Callback zzo;
    /* access modifiers changed from: private */
    public RemoteMediaClient zzp;
    private CastDevice zzq;
    private MediaSessionCompat zzr;
    private MediaSessionCompat.Callback zzs;
    private boolean zzt;
    private PlaybackStateCompat.CustomAction zzu;
    private PlaybackStateCompat.CustomAction zzv;
    private PlaybackStateCompat.CustomAction zzw;
    private PlaybackStateCompat.CustomAction zzx;

    public zzv(Context context, CastOptions castOptions, zzbf zzbf) {
        SessionManager sessionManager;
        NotificationOptions notificationOptions;
        String str;
        ComponentName componentName;
        String str2;
        ComponentName componentName2;
        this.zzc = context;
        this.zzd = castOptions;
        this.zze = zzbf;
        CastContext sharedInstance = CastContext.getSharedInstance();
        zzo zzo2 = null;
        if (sharedInstance != null) {
            sessionManager = sharedInstance.getSessionManager();
        } else {
            sessionManager = null;
        }
        this.zzf = sessionManager;
        CastMediaOptions castMediaOptions = castOptions.getCastMediaOptions();
        if (castMediaOptions == null) {
            notificationOptions = null;
        } else {
            notificationOptions = castMediaOptions.getNotificationOptions();
        }
        this.zzg = notificationOptions;
        this.zzo = new zzu(this, (zzt) null);
        if (castMediaOptions == null) {
            str = null;
        } else {
            str = castMediaOptions.getExpandedControllerActivityClassName();
        }
        if (!TextUtils.isEmpty(str)) {
            componentName = new ComponentName(context, str);
        } else {
            componentName = null;
        }
        this.zzh = componentName;
        if (castMediaOptions == null) {
            str2 = null;
        } else {
            str2 = castMediaOptions.getMediaIntentReceiverClassName();
        }
        if (!TextUtils.isEmpty(str2)) {
            componentName2 = new ComponentName(context, str2);
        } else {
            componentName2 = null;
        }
        this.zzi = componentName2;
        zzb zzb2 = new zzb(context);
        this.zzj = zzb2;
        zzb2.zzc(new zzq(this));
        zzb zzb3 = new zzb(context);
        this.zzk = zzb3;
        zzb3.zzc(new zzr(this));
        this.zzm = new zzdy(Looper.getMainLooper());
        this.zzl = zzo.zze(castOptions) ? new zzo(context) : zzo2;
        this.zzn = new zzp(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzm(java.lang.String r5, int r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -945151566(0xffffffffc7aa21b2, float:-87107.39)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -945080078(0xffffffffc7ab38f2, float:-87665.89)
            if (r0 == r1) goto L_0x0020
            r1 = 235550565(0xe0a3765, float:1.7036485E-30)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0064
            r0 = 0
            if (r5 == r3) goto L_0x0051
            if (r5 == r2) goto L_0x003e
            goto L_0x0070
        L_0x003e:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r5 = r4.zzp
            if (r5 == 0) goto L_0x004b
            boolean r5 = r5.zzs()
            if (r5 == 0) goto L_0x004b
            r0 = 32
            goto L_0x0070
        L_0x004b:
            java.lang.String r5 = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT"
            r7.putBoolean(r5, r3)
            return r0
        L_0x0051:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r5 = r4.zzp
            if (r5 == 0) goto L_0x005e
            boolean r5 = r5.zzt()
            if (r5 == 0) goto L_0x005e
            r0 = 16
            goto L_0x0070
        L_0x005e:
            java.lang.String r5 = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS"
            r7.putBoolean(r5, r3)
            return r0
        L_0x0064:
            r5 = 3
            if (r6 != r5) goto L_0x006c
            r6 = 514(0x202, double:2.54E-321)
            r0 = r6
            r6 = 3
            goto L_0x006e
        L_0x006c:
            r0 = 512(0x200, double:2.53E-321)
        L_0x006e:
            if (r6 == r2) goto L_0x0071
        L_0x0070:
            return r0
        L_0x0071:
            r5 = 516(0x204, double:2.55E-321)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzv.zzm(java.lang.String, int, android.os.Bundle):long");
    }

    private final Uri zzn(MediaMetadata mediaMetadata, int i2) {
        ImagePicker imagePicker;
        WebImage webImage;
        CastMediaOptions castMediaOptions = this.zzd.getCastMediaOptions();
        if (castMediaOptions == null) {
            imagePicker = null;
        } else {
            imagePicker = castMediaOptions.getImagePicker();
        }
        if (imagePicker != null) {
            webImage = imagePicker.onPickImage(mediaMetadata, i2);
        } else if (mediaMetadata.hasImages()) {
            webImage = mediaMetadata.getImages().get(0);
        } else {
            webImage = null;
        }
        if (webImage == null) {
            return null;
        }
        return webImage.getUrl();
    }

    private final MediaMetadataCompat.Builder zzo() {
        MediaMetadataCompat mediaMetadataCompat;
        MediaSessionCompat mediaSessionCompat = this.zzr;
        if (mediaSessionCompat == null) {
            mediaMetadataCompat = null;
        } else {
            mediaMetadataCompat = mediaSessionCompat.getController().getMetadata();
        }
        if (mediaMetadataCompat == null) {
            return new MediaMetadataCompat.Builder();
        }
        return new MediaMetadataCompat.Builder(mediaMetadataCompat);
    }

    /* access modifiers changed from: private */
    public final void zzp(Bitmap bitmap, int i2) {
        String str;
        MediaSessionCompat mediaSessionCompat = this.zzr;
        if (mediaSessionCompat != null) {
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                bitmap.eraseColor(0);
            }
            MediaMetadataCompat.Builder zzo2 = zzo();
            if (i2 == 0) {
                str = MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON;
            } else {
                str = MediaMetadataCompat.METADATA_KEY_ALBUM_ART;
            }
            mediaSessionCompat.setMetadata(zzo2.putBitmap(str, bitmap).build());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzq(android.support.v4.media.session.PlaybackStateCompat.Builder r9, java.lang.String r10, com.google.android.gms.cast.framework.media.NotificationAction r11) {
        /*
            r8 = this;
            int r0 = r10.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.cast.framework.action.FORWARD"
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.REWIND"
            switch(r0) {
                case -1699820260: goto L_0x002b;
                case -668151673: goto L_0x0023;
                case -124479363: goto L_0x001b;
                case 1362116196: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0033
        L_0x0013:
            boolean r0 = r10.equals(r4)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x001b:
            boolean r0 = r10.equals(r5)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0034
        L_0x0023:
            boolean r0 = r10.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 2
            goto L_0x0034
        L_0x002b:
            boolean r0 = r10.equals(r7)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            if (r0 == 0) goto L_0x00dd
            if (r0 == r3) goto L_0x00ad
            if (r0 == r2) goto L_0x0081
            if (r0 == r1) goto L_0x0054
            if (r11 == 0) goto L_0x0051
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r0 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            java.lang.String r1 = r11.getContentDescription()
            int r11 = r11.getIconResId()
            r0.<init>(r10, r1, r11)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r0.build()
            goto L_0x010c
        L_0x0051:
            r10 = 0
            goto L_0x010c
        L_0x0054:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzx
            if (r10 != 0) goto L_0x007d
            com.google.android.gms.cast.framework.media.NotificationOptions r10 = r8.zzg
            if (r10 == 0) goto L_0x007d
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r10 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.Context r11 = r8.zzc
            android.content.res.Resources r11 = r11.getResources()
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r8.zzg
            int r0 = r0.zza()
            java.lang.String r11 = r11.getString(r0)
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r8.zzg
            int r0 = r0.getDisconnectDrawableResId()
            r10.<init>(r5, r11, r0)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r10.build()
            r8.zzx = r10
        L_0x007d:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzx
            goto L_0x010c
        L_0x0081:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzw
            if (r10 != 0) goto L_0x00aa
            com.google.android.gms.cast.framework.media.NotificationOptions r10 = r8.zzg
            if (r10 == 0) goto L_0x00aa
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r10 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.Context r11 = r8.zzc
            android.content.res.Resources r11 = r11.getResources()
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r8.zzg
            int r0 = r0.zza()
            java.lang.String r11 = r11.getString(r0)
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r8.zzg
            int r0 = r0.getDisconnectDrawableResId()
            r10.<init>(r6, r11, r0)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r10.build()
            r8.zzw = r10
        L_0x00aa:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzw
            goto L_0x010c
        L_0x00ad:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzv
            if (r10 != 0) goto L_0x00da
            com.google.android.gms.cast.framework.media.NotificationOptions r10 = r8.zzg
            if (r10 == 0) goto L_0x00da
            long r10 = r10.getSkipStepMs()
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r8.zzg
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzd(r0, r10)
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r8.zzg
            int r10 = com.google.android.gms.cast.framework.media.internal.zzw.zzc(r1, r10)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r11 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.Context r1 = r8.zzc
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r0 = r1.getString(r0)
            r11.<init>(r7, r0, r10)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r11.build()
            r8.zzv = r10
        L_0x00da:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzv
            goto L_0x010c
        L_0x00dd:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzu
            if (r10 != 0) goto L_0x010a
            com.google.android.gms.cast.framework.media.NotificationOptions r10 = r8.zzg
            if (r10 == 0) goto L_0x010a
            long r10 = r10.getSkipStepMs()
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r8.zzg
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzb(r0, r10)
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r8.zzg
            int r10 = com.google.android.gms.cast.framework.media.internal.zzw.zza(r1, r10)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r11 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.Context r1 = r8.zzc
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r0 = r1.getString(r0)
            r11.<init>(r4, r0, r10)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r11.build()
            r8.zzu = r10
        L_0x010a:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r10 = r8.zzu
        L_0x010c:
            if (r10 == 0) goto L_0x0111
            r9.addCustomAction(r10)
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzv.zzq(android.support.v4.media.session.PlaybackStateCompat$Builder, java.lang.String, com.google.android.gms.cast.framework.media.NotificationAction):void");
    }

    @RequiresNonNull({"appContext", "handler", "options"})
    private final void zzr(boolean z2) {
        if (this.zzd.getEnableReconnectionService()) {
            Runnable runnable = this.zzn;
            if (runnable != null) {
                this.zzm.removeCallbacks(runnable);
            }
            Intent intent = new Intent(this.zzc, ReconnectionService.class);
            intent.setPackage(this.zzc.getPackageName());
            try {
                this.zzc.startService(intent);
            } catch (IllegalStateException unused) {
                if (z2) {
                    this.zzm.postDelayed(this.zzn, 1000);
                }
            }
        }
    }

    private final void zzs() {
        zzo zzo2 = this.zzl;
        if (zzo2 != null) {
            zzb.d("Stopping media notification.", new Object[0]);
            zzo2.zzc();
        }
    }

    private final void zzt() {
        if (this.zzd.getEnableReconnectionService()) {
            this.zzm.removeCallbacks(this.zzn);
            Intent intent = new Intent(this.zzc, ReconnectionService.class);
            intent.setPackage(this.zzc.getPackageName());
            this.zzc.stopService(intent);
        }
    }

    private final void zzu(int i2, MediaInfo mediaInfo) {
        PlaybackStateCompat playbackStateCompat;
        MediaSessionCompat mediaSessionCompat;
        MediaMetadata metadata;
        PendingIntent pendingIntent;
        long j2;
        zzg zzg2;
        long j3;
        MediaSessionCompat mediaSessionCompat2 = this.zzr;
        if (mediaSessionCompat2 != null) {
            Bundle bundle = new Bundle();
            PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
            RemoteMediaClient remoteMediaClient = this.zzp;
            long j4 = 0;
            if (remoteMediaClient == null || this.zzl == null) {
                playbackStateCompat = builder.build();
            } else {
                if (remoteMediaClient.zza() == 0 || remoteMediaClient.isLiveStream()) {
                    j2 = 0;
                } else {
                    j2 = remoteMediaClient.getApproximateStreamPosition();
                }
                builder.setState(i2, j2, 1.0f);
                if (i2 == 0) {
                    playbackStateCompat = builder.build();
                } else {
                    NotificationOptions notificationOptions = this.zzg;
                    if (notificationOptions != null) {
                        zzg2 = notificationOptions.zzm();
                    } else {
                        zzg2 = null;
                    }
                    RemoteMediaClient remoteMediaClient2 = this.zzp;
                    if (remoteMediaClient2 == null || remoteMediaClient2.isLiveStream() || this.zzp.isPlayingAd()) {
                        j3 = 0;
                    } else {
                        j3 = 256;
                    }
                    if (zzg2 != null) {
                        List<NotificationAction> zzf2 = zzw.zzf(zzg2);
                        if (zzf2 != null) {
                            for (NotificationAction notificationAction : zzf2) {
                                String action = notificationAction.getAction();
                                if (zzv(action)) {
                                    j3 |= zzm(action, i2, bundle);
                                } else {
                                    zzq(builder, action, notificationAction);
                                }
                            }
                        }
                    } else {
                        NotificationOptions notificationOptions2 = this.zzg;
                        if (notificationOptions2 != null) {
                            for (String next : notificationOptions2.getActions()) {
                                if (zzv(next)) {
                                    j3 |= zzm(next, i2, bundle);
                                } else {
                                    zzq(builder, next, (NotificationAction) null);
                                }
                            }
                        }
                    }
                    playbackStateCompat = builder.setActions(j3).build();
                }
            }
            mediaSessionCompat2.setPlaybackState(playbackStateCompat);
            NotificationOptions notificationOptions3 = this.zzg;
            if (notificationOptions3 != null && notificationOptions3.zzp()) {
                bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
            }
            NotificationOptions notificationOptions4 = this.zzg;
            if (notificationOptions4 != null && notificationOptions4.zzo()) {
                bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
            }
            if (bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
                mediaSessionCompat2.setExtras(bundle);
            }
            if (i2 != 0) {
                if (this.zzp != null) {
                    if (this.zzh == null) {
                        pendingIntent = null;
                    } else {
                        Intent intent = new Intent();
                        intent.setComponent(this.zzh);
                        pendingIntent = PendingIntent.getActivity(this.zzc, 0, intent, zzdx.zza | 134217728);
                    }
                    if (pendingIntent != null) {
                        mediaSessionCompat2.setSessionActivity(pendingIntent);
                    }
                }
                if (this.zzp != null && (mediaSessionCompat = this.zzr) != null && mediaInfo != null && (metadata = mediaInfo.getMetadata()) != null) {
                    RemoteMediaClient remoteMediaClient3 = this.zzp;
                    if (remoteMediaClient3 == null || !remoteMediaClient3.isLiveStream()) {
                        j4 = mediaInfo.getStreamDuration();
                    }
                    String string = metadata.getString(MediaMetadata.KEY_TITLE);
                    String string2 = metadata.getString(MediaMetadata.KEY_SUBTITLE);
                    MediaMetadataCompat.Builder putLong = zzo().putLong(MediaMetadataCompat.METADATA_KEY_DURATION, j4);
                    if (string != null) {
                        putLong.putString(MediaMetadataCompat.METADATA_KEY_TITLE, string);
                        putLong.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, string);
                    }
                    if (string2 != null) {
                        putLong.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, string2);
                    }
                    mediaSessionCompat.setMetadata(putLong.build());
                    Uri zzn2 = zzn(metadata, 0);
                    if (zzn2 != null) {
                        this.zzj.zzd(zzn2);
                    } else {
                        zzp((Bitmap) null, 0);
                    }
                    Uri zzn3 = zzn(metadata, 3);
                    if (zzn3 != null) {
                        this.zzk.zzd(zzn3);
                    } else {
                        zzp((Bitmap) null, 3);
                    }
                }
            } else {
                mediaSessionCompat2.setMetadata(new MediaMetadataCompat.Builder().build());
            }
        }
    }

    private static final boolean zzv(String str) {
        if (TextUtils.equals(str, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_PREV) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_NEXT)) {
            return true;
        }
        return false;
    }

    public final void zzh(RemoteMediaClient remoteMediaClient, CastDevice castDevice) {
        CastMediaOptions castMediaOptions;
        AudioManager audioManager;
        CastOptions castOptions = this.zzd;
        if (castOptions == null) {
            castMediaOptions = null;
        } else {
            castMediaOptions = castOptions.getCastMediaOptions();
        }
        if (this.zzt || this.zzd == null || castMediaOptions == null || this.zzg == null || remoteMediaClient == null || castDevice == null || this.zzi == null) {
            zzb.d("skip attaching media session", new Object[0]);
            return;
        }
        this.zzp = remoteMediaClient;
        remoteMediaClient.registerCallback(this.zzo);
        this.zzq = castDevice;
        if (!PlatformVersion.isAtLeastLollipop() && (audioManager = (AudioManager) this.zzc.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) != null) {
            audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 3);
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(this.zzi);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.zzc, 0, intent, zzdx.zza);
        if (castMediaOptions.getMediaSessionEnabled()) {
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this.zzc, "CastMediaSession", this.zzi, broadcast);
            this.zzr = mediaSessionCompat;
            zzu(0, (MediaInfo) null);
            CastDevice castDevice2 = this.zzq;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.getFriendlyName())) {
                mediaSessionCompat.setMetadata(new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, this.zzc.getResources().getString(R.string.cast_casting_to_device, new Object[]{this.zzq.getFriendlyName()})).build());
            }
            zzs zzs2 = new zzs(this);
            this.zzs = zzs2;
            mediaSessionCompat.setCallback(zzs2);
            mediaSessionCompat.setActive(true);
            this.zze.zzr(mediaSessionCompat);
        }
        this.zzt = true;
        zzl(false);
    }

    public final void zzi(int i2) {
        AudioManager audioManager;
        if (this.zzt) {
            this.zzt = false;
            RemoteMediaClient remoteMediaClient = this.zzp;
            if (remoteMediaClient != null) {
                remoteMediaClient.unregisterCallback(this.zzo);
            }
            if (!PlatformVersion.isAtLeastLollipop() && (audioManager = (AudioManager) this.zzc.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) != null) {
                audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
            this.zze.zzr((MediaSessionCompat) null);
            zzb zzb2 = this.zzj;
            if (zzb2 != null) {
                zzb2.zza();
            }
            zzb zzb3 = this.zzk;
            if (zzb3 != null) {
                zzb3.zza();
            }
            MediaSessionCompat mediaSessionCompat = this.zzr;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.setCallback((MediaSessionCompat.Callback) null);
                this.zzr.setMetadata(new MediaMetadataCompat.Builder().build());
                zzu(0, (MediaInfo) null);
            }
            MediaSessionCompat mediaSessionCompat2 = this.zzr;
            if (mediaSessionCompat2 != null) {
                mediaSessionCompat2.setActive(false);
                this.zzr.release();
                this.zzr = null;
            }
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            zzs();
            if (i2 == 0) {
                zzt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj() {
        zzr(false);
    }

    public final void zzk(CastDevice castDevice) {
        zzb.i("update Cast device to %s", castDevice);
        this.zzq = castDevice;
        zzl(false);
    }

    public final void zzl(boolean z2) {
        MediaQueueItem loadingItem;
        RemoteMediaClient remoteMediaClient = this.zzp;
        if (remoteMediaClient != null) {
            int zza2 = remoteMediaClient.zza();
            MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
            if (!(!remoteMediaClient.isLoadingNextItem() || (loadingItem = remoteMediaClient.getLoadingItem()) == null || loadingItem.getMedia() == null)) {
                mediaInfo = loadingItem.getMedia();
            }
            zzu(zza2, mediaInfo);
            if (!remoteMediaClient.hasMediaSession()) {
                zzs();
                zzt();
            } else if (zza2 != 0) {
                zzo zzo2 = this.zzl;
                if (zzo2 != null) {
                    zzb.d("Update media notification.", new Object[0]);
                    zzo2.zzd(this.zzq, this.zzp, this.zzr, z2);
                }
                if (!remoteMediaClient.isLoadingNextItem()) {
                    zzr(true);
                }
            }
        }
    }
}

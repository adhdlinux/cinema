package com.google.android.gms.cast.framework.media;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.media.app.NotificationCompat$MediaStyle;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.framework.media.internal.zzw;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzdx;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.util.ArrayList;
import java.util.List;

public class MediaNotificationService extends Service {
    public static final String ACTION_UPDATE_NOTIFICATION = "com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION";
    private static final Logger zza = new Logger("MediaNotificationService");
    private static Runnable zzb;
    private NotificationOptions zzc;
    private ImagePicker zzd;
    private ComponentName zze;
    private ComponentName zzf;
    private List zzg = new ArrayList();
    private int[] zzh;
    private long zzi;
    private zzb zzj;
    private ImageHints zzk;
    private Resources zzl;
    private zzm zzm;
    /* access modifiers changed from: private */
    public zzn zzn;
    private NotificationManager zzo;
    private Notification zzp;
    private CastContext zzq;

    public static boolean isNotificationOptionsValid(CastOptions castOptions) {
        NotificationOptions notificationOptions;
        int i2;
        int length;
        CastMediaOptions castMediaOptions = castOptions.getCastMediaOptions();
        if (castMediaOptions == null || (notificationOptions = castMediaOptions.getNotificationOptions()) == null) {
            return false;
        }
        zzg zzm2 = notificationOptions.zzm();
        if (zzm2 == null) {
            return true;
        }
        List zzf2 = zzw.zzf(zzm2);
        int[] zzg2 = zzw.zzg(zzm2);
        if (zzf2 == null) {
            i2 = 0;
        } else {
            i2 = zzf2.size();
        }
        Class<NotificationActionsProvider> cls = NotificationActionsProvider.class;
        if (zzf2 == null || zzf2.isEmpty()) {
            zza.e(cls.getSimpleName().concat(" doesn't provide any action."), new Object[0]);
        } else if (zzf2.size() > 5) {
            zza.e(cls.getSimpleName().concat(" provides more than 5 actions."), new Object[0]);
        } else if (zzg2 == null || (length = zzg2.length) == 0) {
            zza.e(cls.getSimpleName().concat(" doesn't provide any actions for compact view."), new Object[0]);
        } else {
            int i3 = 0;
            while (i3 < length) {
                int i4 = zzg2[i3];
                if (i4 < 0 || i4 >= i2) {
                    zza.e(cls.getSimpleName().concat("provides a compact view action whose index is out of bounds."), new Object[0]);
                } else {
                    i3++;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.core.app.NotificationCompat.Action zzc(java.lang.String r15) {
        /*
            r14 = this;
            int r0 = r15.hashCode()
            r1 = 2
            java.lang.String r2 = "com.google.android.gms.cast.framework.action.FORWARD"
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            java.lang.String r4 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            java.lang.String r8 = "com.google.android.gms.cast.framework.action.REWIND"
            r9 = 1
            r10 = 0
            switch(r0) {
                case -1699820260: goto L_0x0049;
                case -945151566: goto L_0x0041;
                case -945080078: goto L_0x0039;
                case -668151673: goto L_0x0031;
                case -124479363: goto L_0x0029;
                case 235550565: goto L_0x0021;
                case 1362116196: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0051
        L_0x0019:
            boolean r0 = r15.equals(r2)
            if (r0 == 0) goto L_0x0051
            r0 = 3
            goto L_0x0052
        L_0x0021:
            boolean r0 = r15.equals(r3)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            goto L_0x0052
        L_0x0029:
            boolean r0 = r15.equals(r4)
            if (r0 == 0) goto L_0x0051
            r0 = 6
            goto L_0x0052
        L_0x0031:
            boolean r0 = r15.equals(r5)
            if (r0 == 0) goto L_0x0051
            r0 = 5
            goto L_0x0052
        L_0x0039:
            boolean r0 = r15.equals(r6)
            if (r0 == 0) goto L_0x0051
            r0 = 2
            goto L_0x0052
        L_0x0041:
            boolean r0 = r15.equals(r7)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0049:
            boolean r0 = r15.equals(r8)
            if (r0 == 0) goto L_0x0051
            r0 = 4
            goto L_0x0052
        L_0x0051:
            r0 = -1
        L_0x0052:
            r11 = 134217728(0x8000000, float:3.85186E-34)
            java.lang.String r12 = "googlecast-extra_skip_step_ms"
            r13 = 0
            switch(r0) {
                case 0: goto L_0x018c;
                case 1: goto L_0x015a;
                case 2: goto L_0x0128;
                case 3: goto L_0x00f6;
                case 4: goto L_0x00c4;
                case 5: goto L_0x0098;
                case 6: goto L_0x0066;
                default: goto L_0x005a;
            }
        L_0x005a:
            com.google.android.gms.cast.internal.Logger r0 = zza
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r10] = r15
            java.lang.String r15 = "Action: %s is not a pre-defined action."
            r0.e(r15, r1)
            return r13
        L_0x0066:
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r4)
            android.content.ComponentName r0 = r14.zze
            r15.setComponent(r0)
            int r0 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r0)
            androidx.core.app.NotificationCompat$Action$Builder r0 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zzc
            int r1 = r1.getDisconnectDrawableResId()
            android.content.res.Resources r2 = r14.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zzc
            int r3 = r3.zza()
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.String r5 = ""
            r4[r10] = r5
            java.lang.String r2 = r2.getString(r3, r4)
            r0.<init>(r1, r2, r15)
            androidx.core.app.NotificationCompat$Action r15 = r0.a()
            return r15
        L_0x0098:
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r5)
            android.content.ComponentName r0 = r14.zze
            r15.setComponent(r0)
            int r0 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r0)
            androidx.core.app.NotificationCompat$Action$Builder r0 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zzc
            int r1 = r1.getDisconnectDrawableResId()
            android.content.res.Resources r2 = r14.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zzc
            int r3 = r3.zza()
            java.lang.String r2 = r2.getString(r3)
            r0.<init>(r1, r2, r15)
            androidx.core.app.NotificationCompat$Action r15 = r0.a()
            return r15
        L_0x00c4:
            long r0 = r14.zzi
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r8)
            android.content.ComponentName r2 = r14.zze
            r15.setComponent(r2)
            r15.putExtra(r12, r0)
            int r2 = com.google.android.gms.internal.cast.zzdx.zza
            r2 = r2 | r11
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r2)
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zzc
            int r2 = com.google.android.gms.cast.framework.media.internal.zzw.zzc(r2, r0)
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zzc
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzd(r3, r0)
            androidx.core.app.NotificationCompat$Action$Builder r1 = new androidx.core.app.NotificationCompat$Action$Builder
            android.content.res.Resources r3 = r14.zzl
            java.lang.String r0 = r3.getString(r0)
            r1.<init>(r2, r0, r15)
            androidx.core.app.NotificationCompat$Action r15 = r1.a()
            return r15
        L_0x00f6:
            long r0 = r14.zzi
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r2)
            android.content.ComponentName r2 = r14.zze
            r15.setComponent(r2)
            r15.putExtra(r12, r0)
            int r2 = com.google.android.gms.internal.cast.zzdx.zza
            r2 = r2 | r11
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r2)
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zzc
            int r2 = com.google.android.gms.cast.framework.media.internal.zzw.zza(r2, r0)
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zzc
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzb(r3, r0)
            androidx.core.app.NotificationCompat$Action$Builder r1 = new androidx.core.app.NotificationCompat$Action$Builder
            android.content.res.Resources r3 = r14.zzl
            java.lang.String r0 = r3.getString(r0)
            r1.<init>(r2, r0, r15)
            androidx.core.app.NotificationCompat$Action r15 = r1.a()
            return r15
        L_0x0128:
            com.google.android.gms.cast.framework.media.zzm r15 = r14.zzm
            boolean r15 = r15.zzg
            if (r15 == 0) goto L_0x013e
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r6)
            android.content.ComponentName r0 = r14.zze
            r15.setComponent(r0)
            int r0 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r13 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r0)
        L_0x013e:
            androidx.core.app.NotificationCompat$Action$Builder r15 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zzc
            int r0 = r0.getSkipPrevDrawableResId()
            android.content.res.Resources r1 = r14.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zzc
            int r2 = r2.zzl()
            java.lang.String r1 = r1.getString(r2)
            r15.<init>(r0, r1, r13)
            androidx.core.app.NotificationCompat$Action r15 = r15.a()
            return r15
        L_0x015a:
            com.google.android.gms.cast.framework.media.zzm r15 = r14.zzm
            boolean r15 = r15.zzf
            if (r15 == 0) goto L_0x0170
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r7)
            android.content.ComponentName r0 = r14.zze
            r15.setComponent(r0)
            int r0 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r13 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r0)
        L_0x0170:
            androidx.core.app.NotificationCompat$Action$Builder r15 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zzc
            int r0 = r0.getSkipNextDrawableResId()
            android.content.res.Resources r1 = r14.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zzc
            int r2 = r2.zzk()
            java.lang.String r1 = r1.getString(r2)
            r15.<init>(r0, r1, r13)
            androidx.core.app.NotificationCompat$Action r15 = r15.a()
            return r15
        L_0x018c:
            com.google.android.gms.cast.framework.media.zzm r15 = r14.zzm
            int r0 = r15.zzc
            boolean r15 = r15.zzb
            if (r0 != r1) goto L_0x01a1
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zzc
            int r0 = r0.getStopLiveStreamDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zzc
            int r1 = r1.getStopLiveStreamTitleResId()
            goto L_0x01ad
        L_0x01a1:
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zzc
            int r0 = r0.getPauseDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zzc
            int r1 = r1.zzf()
        L_0x01ad:
            if (r15 != 0) goto L_0x01b5
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zzc
            int r0 = r0.getPlayDrawableResId()
        L_0x01b5:
            if (r15 != 0) goto L_0x01bd
            com.google.android.gms.cast.framework.media.NotificationOptions r15 = r14.zzc
            int r1 = r15.zzg()
        L_0x01bd:
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r3)
            android.content.ComponentName r2 = r14.zze
            r15.setComponent(r2)
            int r2 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r14, r10, r15, r2)
            androidx.core.app.NotificationCompat$Action$Builder r2 = new androidx.core.app.NotificationCompat$Action$Builder
            android.content.res.Resources r3 = r14.zzl
            java.lang.String r1 = r3.getString(r1)
            r2.<init>(r0, r1, r15)
            androidx.core.app.NotificationCompat$Action r15 = r2.a()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.MediaNotificationService.zzc(java.lang.String):androidx.core.app.NotificationCompat$Action");
    }

    /* access modifiers changed from: private */
    public final void zzd() {
        Bitmap bitmap;
        PendingIntent pendingIntent;
        NotificationCompat.Action action;
        if (this.zzm != null) {
            zzn zzn2 = this.zzn;
            int[] iArr = null;
            if (zzn2 == null) {
                bitmap = null;
            } else {
                bitmap = zzn2.zzb;
            }
            NotificationCompat.Builder B = new NotificationCompat.Builder(this, "cast_media_notification").q(bitmap).y(this.zzc.getSmallIconDrawableResId()).m(this.zzm.zzd).l(this.zzl.getString(this.zzc.getCastingToDeviceStringResId(), new Object[]{this.zzm.zze})).s(true).w(false).B(1);
            ComponentName componentName = this.zzf;
            if (componentName == null) {
                pendingIntent = null;
            } else {
                Intent intent = new Intent();
                intent.putExtra("targetActivity", componentName);
                intent.setAction(componentName.flattenToString());
                intent.setComponent(componentName);
                TaskStackBuilder e2 = TaskStackBuilder.e(this);
                e2.b(intent);
                pendingIntent = e2.g(1, zzdx.zza | 134217728);
            }
            if (pendingIntent != null) {
                B.k(pendingIntent);
            }
            zzg zzm2 = this.zzc.zzm();
            if (zzm2 != null) {
                zza.i("actionsProvider != null", new Object[0]);
                int[] zzg2 = zzw.zzg(zzm2);
                if (zzg2 != null) {
                    iArr = (int[]) zzg2.clone();
                }
                this.zzh = iArr;
                List<NotificationAction> zzf2 = zzw.zzf(zzm2);
                this.zzg = new ArrayList();
                if (zzf2 != null) {
                    for (NotificationAction notificationAction : zzf2) {
                        String action2 = notificationAction.getAction();
                        if (action2.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action2.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action2.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action2.equals(MediaIntentReceiver.ACTION_FORWARD) || action2.equals(MediaIntentReceiver.ACTION_REWIND) || action2.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action2.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                            action = zzc(notificationAction.getAction());
                        } else {
                            Intent intent2 = new Intent(notificationAction.getAction());
                            intent2.setComponent(this.zze);
                            action = new NotificationCompat.Action.Builder(notificationAction.getIconResId(), notificationAction.getContentDescription(), PendingIntent.getBroadcast(this, 0, intent2, zzdx.zza)).a();
                        }
                        if (action != null) {
                            this.zzg.add(action);
                        }
                    }
                }
            } else {
                zza.i("actionsProvider == null", new Object[0]);
                this.zzg = new ArrayList();
                for (String zzc2 : this.zzc.getActions()) {
                    NotificationCompat.Action zzc3 = zzc(zzc2);
                    if (zzc3 != null) {
                        this.zzg.add(zzc3);
                    }
                }
                this.zzh = (int[]) this.zzc.getCompatActionIndices().clone();
            }
            for (NotificationCompat.Action b2 : this.zzg) {
                B.b(b2);
            }
            NotificationCompat$MediaStyle notificationCompat$MediaStyle = new NotificationCompat$MediaStyle();
            int[] iArr2 = this.zzh;
            if (iArr2 != null) {
                notificationCompat$MediaStyle.i(iArr2);
            }
            MediaSessionCompat.Token token = this.zzm.zza;
            if (token != null) {
                notificationCompat$MediaStyle.h(token);
            }
            B.z(notificationCompat$MediaStyle);
            Notification c2 = B.c();
            this.zzp = c2;
            startForeground(1, c2);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.zzo = (NotificationManager) getSystemService("notification");
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        this.zzq = sharedInstance;
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(sharedInstance.getCastOptions().getCastMediaOptions());
        this.zzc = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.zzd = castMediaOptions.getImagePicker();
        this.zzl = getResources();
        this.zze = new ComponentName(getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (!TextUtils.isEmpty(this.zzc.getTargetActivityClassName())) {
            this.zzf = new ComponentName(getApplicationContext(), this.zzc.getTargetActivityClassName());
        } else {
            this.zzf = null;
        }
        this.zzi = this.zzc.getSkipStepMs();
        int dimensionPixelSize = this.zzl.getDimensionPixelSize(this.zzc.zze());
        this.zzk = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.zzj = new zzb(getApplicationContext(), this.zzk);
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", getResources().getString(R.string.media_notification_channel_name), 2);
            notificationChannel.setShowBadge(false);
            this.zzo.createNotificationChannel(notificationChannel);
        }
        zzr.zzd(zzln.CAF_NOTIFICATION_SERVICE);
    }

    public void onDestroy() {
        zzb zzb2 = this.zzj;
        if (zzb2 != null) {
            zzb2.zza();
        }
        zzb = null;
        this.zzo.cancel(1);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        boolean z2;
        WebImage webImage;
        zzm zzm2;
        Intent intent2 = intent;
        MediaInfo mediaInfo = (MediaInfo) Preconditions.checkNotNull((MediaInfo) intent2.getParcelableExtra("extra_media_info"));
        MediaMetadata mediaMetadata = (MediaMetadata) Preconditions.checkNotNull(mediaInfo.getMetadata());
        int intExtra = intent2.getIntExtra("extra_remote_media_client_player_state", 0);
        int streamType = mediaInfo.getStreamType();
        String string = mediaMetadata.getString(MediaMetadata.KEY_TITLE);
        String friendlyName = ((CastDevice) Preconditions.checkNotNull((CastDevice) intent2.getParcelableExtra("extra_cast_device"))).getFriendlyName();
        MediaSessionCompat.Token token = (MediaSessionCompat.Token) intent2.getParcelableExtra("extra_media_session_token");
        if (intExtra == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzm zzm3 = new zzm(z2, streamType, string, friendlyName, token, intent2.getBooleanExtra("extra_can_skip_next", false), intent2.getBooleanExtra("extra_can_skip_prev", false));
        if (intent2.getBooleanExtra("extra_media_notification_force_update", false) || (zzm2 = this.zzm) == null || zzm3.zzb != zzm2.zzb || zzm3.zzc != zzm2.zzc || !CastUtils.zze(zzm3.zzd, zzm2.zzd) || !CastUtils.zze(zzm3.zze, zzm2.zze) || zzm3.zzf != zzm2.zzf || zzm3.zzg != zzm2.zzg) {
            this.zzm = zzm3;
            zzd();
        }
        ImagePicker imagePicker = this.zzd;
        if (imagePicker != null) {
            webImage = imagePicker.onPickImage(mediaMetadata, this.zzk);
        } else if (mediaMetadata.hasImages()) {
            webImage = mediaMetadata.getImages().get(0);
        } else {
            webImage = null;
        }
        zzn zzn2 = new zzn(webImage);
        zzn zzn3 = this.zzn;
        if (zzn3 == null || !CastUtils.zze(zzn2.zza, zzn3.zza)) {
            this.zzj.zzc(new zzl(this, zzn2));
            this.zzj.zzd(zzn2.zza);
        }
        startForeground(1, this.zzp);
        zzb = new zzk(this, i3);
        return 2;
    }
}

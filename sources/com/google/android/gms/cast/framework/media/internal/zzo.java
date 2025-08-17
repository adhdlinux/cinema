package com.google.android.gms.cast.framework.media.internal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.media.app.NotificationCompat$MediaStyle;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationActionsProvider;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.zzg;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzdx;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.util.ArrayList;
import java.util.List;

final class zzo {
    private static final Logger zza = new Logger("MediaNotificationProxy");
    private final Context zzb;
    private final NotificationManager zzc;
    private final CastContext zzd;
    private final NotificationOptions zze;
    private final ImagePicker zzf;
    private final ComponentName zzg;
    private final ComponentName zzh;
    private List zzi = new ArrayList();
    private int[] zzj;
    private final long zzk;
    private final zzb zzl;
    private final ImageHints zzm;
    private final Resources zzn;
    private zzm zzo;
    /* access modifiers changed from: private */
    public zzn zzp;
    private Notification zzq;
    private NotificationCompat.Action zzr;
    private NotificationCompat.Action zzs;
    private NotificationCompat.Action zzt;
    private NotificationCompat.Action zzu;
    private NotificationCompat.Action zzv;
    private NotificationCompat.Action zzw;
    private NotificationCompat.Action zzx;
    private NotificationCompat.Action zzy;

    zzo(Context context) {
        this.zzb = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.zzc = notificationManager;
        CastContext castContext = (CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance());
        this.zzd = castContext;
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(((CastOptions) Preconditions.checkNotNull(castContext.getCastOptions())).getCastMediaOptions());
        NotificationOptions notificationOptions = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.zze = notificationOptions;
        this.zzf = castMediaOptions.getImagePicker();
        Resources resources = context.getResources();
        this.zzn = resources;
        this.zzg = new ComponentName(context.getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (!TextUtils.isEmpty(notificationOptions.getTargetActivityClassName())) {
            this.zzh = new ComponentName(context.getApplicationContext(), notificationOptions.getTargetActivityClassName());
        } else {
            this.zzh = null;
        }
        this.zzk = notificationOptions.getSkipStepMs();
        int dimensionPixelSize = resources.getDimensionPixelSize(notificationOptions.zze());
        ImageHints imageHints = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.zzm = imageHints;
        this.zzl = new zzb(context.getApplicationContext(), imageHints);
        if (PlatformVersion.isAtLeastO() && notificationManager != null) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", ((Context) Preconditions.checkNotNull(context)).getResources().getString(R.string.media_notification_channel_name), 2);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        zzr.zzd(zzln.CAF_MEDIA_NOTIFICATION_PROXY);
    }

    static boolean zze(CastOptions castOptions) {
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
    private final androidx.core.app.NotificationCompat.Action zzf(java.lang.String r15) {
        /*
            r14 = this;
            int r0 = r15.hashCode()
            r1 = 2
            java.lang.String r2 = "com.google.android.gms.cast.framework.action.FORWARD"
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            java.lang.String r4 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.REWIND"
            r8 = 1
            java.lang.String r9 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
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
            boolean r0 = r15.equals(r9)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            goto L_0x0052
        L_0x0029:
            boolean r0 = r15.equals(r3)
            if (r0 == 0) goto L_0x0051
            r0 = 6
            goto L_0x0052
        L_0x0031:
            boolean r0 = r15.equals(r4)
            if (r0 == 0) goto L_0x0051
            r0 = 5
            goto L_0x0052
        L_0x0039:
            boolean r0 = r15.equals(r5)
            if (r0 == 0) goto L_0x0051
            r0 = 2
            goto L_0x0052
        L_0x0041:
            boolean r0 = r15.equals(r6)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0049:
            boolean r0 = r15.equals(r7)
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
                case 0: goto L_0x01c8;
                case 1: goto L_0x018c;
                case 2: goto L_0x0150;
                case 3: goto L_0x0114;
                case 4: goto L_0x00d8;
                case 5: goto L_0x00a2;
                case 6: goto L_0x0066;
                default: goto L_0x005a;
            }
        L_0x005a:
            com.google.android.gms.cast.internal.Logger r0 = zza
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r1[r10] = r15
            java.lang.String r15 = "Action: %s is not a pre-defined action."
            r0.e(r15, r1)
            return r13
        L_0x0066:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzx
            if (r15 != 0) goto L_0x009f
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r3)
            android.content.ComponentName r0 = r14.zzg
            r15.setComponent(r0)
            android.content.Context r0 = r14.zzb
            int r1 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r0, r10, r15, r1)
            androidx.core.app.NotificationCompat$Action$Builder r0 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zze
            int r1 = r1.getDisconnectDrawableResId()
            android.content.res.Resources r2 = r14.zzn
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zze
            int r3 = r3.zza()
            java.lang.Object[] r4 = new java.lang.Object[r8]
            java.lang.String r5 = ""
            r4[r10] = r5
            java.lang.String r2 = r2.getString(r3, r4)
            r0.<init>(r1, r2, r15)
            androidx.core.app.NotificationCompat$Action r15 = r0.a()
            r14.zzx = r15
        L_0x009f:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzx
            return r15
        L_0x00a2:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzy
            if (r15 != 0) goto L_0x00d5
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r4)
            android.content.ComponentName r0 = r14.zzg
            r15.setComponent(r0)
            android.content.Context r0 = r14.zzb
            int r1 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r0, r10, r15, r1)
            androidx.core.app.NotificationCompat$Action$Builder r0 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zze
            int r1 = r1.getDisconnectDrawableResId()
            android.content.res.Resources r2 = r14.zzn
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zze
            int r3 = r3.zza()
            java.lang.String r2 = r2.getString(r3)
            r0.<init>(r1, r2, r15)
            androidx.core.app.NotificationCompat$Action r15 = r0.a()
            r14.zzy = r15
        L_0x00d5:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzy
            return r15
        L_0x00d8:
            long r0 = r14.zzk
            androidx.core.app.NotificationCompat$Action r15 = r14.zzw
            if (r15 != 0) goto L_0x0111
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r7)
            android.content.ComponentName r2 = r14.zzg
            r15.setComponent(r2)
            r15.putExtra(r12, r0)
            android.content.Context r2 = r14.zzb
            int r3 = com.google.android.gms.internal.cast.zzdx.zza
            r3 = r3 | r11
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r2, r10, r15, r3)
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zze
            int r2 = com.google.android.gms.cast.framework.media.internal.zzw.zzc(r2, r0)
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zze
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzd(r3, r0)
            androidx.core.app.NotificationCompat$Action$Builder r1 = new androidx.core.app.NotificationCompat$Action$Builder
            android.content.res.Resources r3 = r14.zzn
            java.lang.String r0 = r3.getString(r0)
            r1.<init>(r2, r0, r15)
            androidx.core.app.NotificationCompat$Action r15 = r1.a()
            r14.zzw = r15
        L_0x0111:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzw
            return r15
        L_0x0114:
            long r0 = r14.zzk
            androidx.core.app.NotificationCompat$Action r15 = r14.zzv
            if (r15 != 0) goto L_0x014d
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r2)
            android.content.ComponentName r2 = r14.zzg
            r15.setComponent(r2)
            r15.putExtra(r12, r0)
            android.content.Context r2 = r14.zzb
            int r3 = com.google.android.gms.internal.cast.zzdx.zza
            r3 = r3 | r11
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r2, r10, r15, r3)
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zze
            int r2 = com.google.android.gms.cast.framework.media.internal.zzw.zza(r2, r0)
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zze
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzb(r3, r0)
            androidx.core.app.NotificationCompat$Action$Builder r1 = new androidx.core.app.NotificationCompat$Action$Builder
            android.content.res.Resources r3 = r14.zzn
            java.lang.String r0 = r3.getString(r0)
            r1.<init>(r2, r0, r15)
            androidx.core.app.NotificationCompat$Action r15 = r1.a()
            r14.zzv = r15
        L_0x014d:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzv
            return r15
        L_0x0150:
            com.google.android.gms.cast.framework.media.internal.zzm r15 = r14.zzo
            boolean r15 = r15.zzg
            androidx.core.app.NotificationCompat$Action r0 = r14.zzu
            if (r0 != 0) goto L_0x0189
            if (r15 == 0) goto L_0x016c
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r5)
            android.content.ComponentName r0 = r14.zzg
            r15.setComponent(r0)
            android.content.Context r0 = r14.zzb
            int r1 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r13 = android.app.PendingIntent.getBroadcast(r0, r10, r15, r1)
        L_0x016c:
            androidx.core.app.NotificationCompat$Action$Builder r15 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zze
            int r0 = r0.getSkipPrevDrawableResId()
            android.content.res.Resources r1 = r14.zzn
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zze
            int r2 = r2.zzl()
            java.lang.String r1 = r1.getString(r2)
            r15.<init>(r0, r1, r13)
            androidx.core.app.NotificationCompat$Action r15 = r15.a()
            r14.zzu = r15
        L_0x0189:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzu
            return r15
        L_0x018c:
            com.google.android.gms.cast.framework.media.internal.zzm r15 = r14.zzo
            boolean r15 = r15.zzf
            androidx.core.app.NotificationCompat$Action r0 = r14.zzt
            if (r0 != 0) goto L_0x01c5
            if (r15 == 0) goto L_0x01a8
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r6)
            android.content.ComponentName r0 = r14.zzg
            r15.setComponent(r0)
            android.content.Context r0 = r14.zzb
            int r1 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r13 = android.app.PendingIntent.getBroadcast(r0, r10, r15, r1)
        L_0x01a8:
            androidx.core.app.NotificationCompat$Action$Builder r15 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zze
            int r0 = r0.getSkipNextDrawableResId()
            android.content.res.Resources r1 = r14.zzn
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r14.zze
            int r2 = r2.zzk()
            java.lang.String r1 = r1.getString(r2)
            r15.<init>(r0, r1, r13)
            androidx.core.app.NotificationCompat$Action r15 = r15.a()
            r14.zzt = r15
        L_0x01c5:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzt
            return r15
        L_0x01c8:
            com.google.android.gms.cast.framework.media.internal.zzm r15 = r14.zzo
            int r0 = r15.zzc
            boolean r15 = r15.zzb
            if (r15 == 0) goto L_0x0215
            androidx.core.app.NotificationCompat$Action r15 = r14.zzs
            if (r15 != 0) goto L_0x0212
            if (r0 != r1) goto L_0x01e3
            com.google.android.gms.cast.framework.media.NotificationOptions r15 = r14.zze
            int r15 = r15.getStopLiveStreamDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zze
            int r0 = r0.getStopLiveStreamTitleResId()
            goto L_0x01ef
        L_0x01e3:
            com.google.android.gms.cast.framework.media.NotificationOptions r15 = r14.zze
            int r15 = r15.getPauseDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r0 = r14.zze
            int r0 = r0.zzf()
        L_0x01ef:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r9)
            android.content.ComponentName r2 = r14.zzg
            r1.setComponent(r2)
            android.content.Context r2 = r14.zzb
            int r3 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r1 = android.app.PendingIntent.getBroadcast(r2, r10, r1, r3)
            androidx.core.app.NotificationCompat$Action$Builder r2 = new androidx.core.app.NotificationCompat$Action$Builder
            android.content.res.Resources r3 = r14.zzn
            java.lang.String r0 = r3.getString(r0)
            r2.<init>(r15, r0, r1)
            androidx.core.app.NotificationCompat$Action r15 = r2.a()
            r14.zzs = r15
        L_0x0212:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzs
            goto L_0x024a
        L_0x0215:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzr
            if (r15 != 0) goto L_0x0248
            android.content.Intent r15 = new android.content.Intent
            r15.<init>(r9)
            android.content.ComponentName r0 = r14.zzg
            r15.setComponent(r0)
            android.content.Context r0 = r14.zzb
            int r1 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r0, r10, r15, r1)
            androidx.core.app.NotificationCompat$Action$Builder r0 = new androidx.core.app.NotificationCompat$Action$Builder
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r14.zze
            int r1 = r1.getPlayDrawableResId()
            android.content.res.Resources r2 = r14.zzn
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r14.zze
            int r3 = r3.zzg()
            java.lang.String r2 = r2.getString(r3)
            r0.<init>(r1, r2, r15)
            androidx.core.app.NotificationCompat$Action r15 = r0.a()
            r14.zzr = r15
        L_0x0248:
            androidx.core.app.NotificationCompat$Action r15 = r14.zzr
        L_0x024a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzo.zzf(java.lang.String):androidx.core.app.NotificationCompat$Action");
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        Bitmap bitmap;
        PendingIntent pendingIntent;
        NotificationCompat.Action action;
        if (this.zzc != null && this.zzo != null) {
            zzn zzn2 = this.zzp;
            int[] iArr = null;
            if (zzn2 == null) {
                bitmap = null;
            } else {
                bitmap = zzn2.zzb;
            }
            NotificationCompat.Builder B = new NotificationCompat.Builder(this.zzb, "cast_media_notification").q(bitmap).y(this.zze.getSmallIconDrawableResId()).m(this.zzo.zzd).l(this.zzn.getString(this.zze.getCastingToDeviceStringResId(), new Object[]{this.zzo.zze})).s(true).w(false).B(1);
            ComponentName componentName = this.zzh;
            if (componentName == null) {
                pendingIntent = null;
            } else {
                Intent intent = new Intent();
                intent.putExtra("targetActivity", componentName);
                intent.setAction(componentName.flattenToString());
                intent.setComponent(componentName);
                TaskStackBuilder e2 = TaskStackBuilder.e(this.zzb);
                e2.b(intent);
                pendingIntent = e2.g(1, zzdx.zza | 134217728);
            }
            if (pendingIntent != null) {
                B.k(pendingIntent);
            }
            zzg zzm2 = this.zze.zzm();
            if (zzm2 != null) {
                zza.d("actionsProvider != null", new Object[0]);
                int[] zzg2 = zzw.zzg(zzm2);
                if (zzg2 != null) {
                    iArr = (int[]) zzg2.clone();
                }
                this.zzj = iArr;
                List<NotificationAction> zzf2 = zzw.zzf(zzm2);
                this.zzi = new ArrayList();
                if (zzf2 != null) {
                    for (NotificationAction notificationAction : zzf2) {
                        String action2 = notificationAction.getAction();
                        if (action2.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action2.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action2.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action2.equals(MediaIntentReceiver.ACTION_FORWARD) || action2.equals(MediaIntentReceiver.ACTION_REWIND) || action2.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action2.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                            action = zzf(notificationAction.getAction());
                        } else {
                            Intent intent2 = new Intent(notificationAction.getAction());
                            intent2.setComponent(this.zzg);
                            action = new NotificationCompat.Action.Builder(notificationAction.getIconResId(), notificationAction.getContentDescription(), PendingIntent.getBroadcast(this.zzb, 0, intent2, zzdx.zza)).a();
                        }
                        if (action != null) {
                            this.zzi.add(action);
                        }
                    }
                }
            } else {
                zza.d("actionsProvider == null", new Object[0]);
                this.zzi = new ArrayList();
                for (String zzf3 : this.zze.getActions()) {
                    NotificationCompat.Action zzf4 = zzf(zzf3);
                    if (zzf4 != null) {
                        this.zzi.add(zzf4);
                    }
                }
                this.zzj = (int[]) this.zze.getCompatActionIndices().clone();
            }
            for (NotificationCompat.Action b2 : this.zzi) {
                B.b(b2);
            }
            NotificationCompat$MediaStyle notificationCompat$MediaStyle = new NotificationCompat$MediaStyle();
            int[] iArr2 = this.zzj;
            if (iArr2 != null) {
                notificationCompat$MediaStyle.i(iArr2);
            }
            MediaSessionCompat.Token token = this.zzo.zza;
            if (token != null) {
                notificationCompat$MediaStyle.h(token);
            }
            B.z(notificationCompat$MediaStyle);
            Notification c2 = B.c();
            this.zzq = c2;
            this.zzc.notify("castMediaNotification", 1, c2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzl.zza();
        NotificationManager notificationManager = this.zzc;
        if (notificationManager != null) {
            notificationManager.cancel("castMediaNotification", 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.cast.CastDevice r18, com.google.android.gms.cast.framework.media.RemoteMediaClient r19, android.support.v4.media.session.MediaSessionCompat r20, boolean r21) {
        /*
            r17 = this;
            r0 = r17
            if (r18 == 0) goto L_0x00f4
            if (r19 == 0) goto L_0x00f4
            if (r20 != 0) goto L_0x000a
            goto L_0x00f4
        L_0x000a:
            com.google.android.gms.cast.MediaInfo r1 = r19.getMediaInfo()
            if (r1 != 0) goto L_0x0011
            return
        L_0x0011:
            com.google.android.gms.cast.MediaMetadata r2 = r1.getMetadata()
            if (r2 != 0) goto L_0x0018
            return
        L_0x0018:
            com.google.android.gms.cast.MediaStatus r3 = r19.getMediaStatus()
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x0057
            int r7 = r3.getQueueRepeatMode()
            if (r7 == r5) goto L_0x0053
            if (r7 == r4) goto L_0x0053
            r8 = 3
            if (r7 == r8) goto L_0x0053
            int r7 = r3.getCurrentItemId()
            java.lang.Integer r7 = r3.getIndexById(r7)
            if (r7 == 0) goto L_0x0057
            int r8 = r7.intValue()
            if (r8 <= 0) goto L_0x003e
            r8 = 1
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r7 = r7.intValue()
            int r3 = r3.getQueueItemCount()
            int r3 = r3 + -1
            if (r7 >= r3) goto L_0x004f
            r16 = r8
            r15 = 1
            goto L_0x005a
        L_0x004f:
            r16 = r8
            r15 = 0
            goto L_0x005a
        L_0x0053:
            r15 = 1
            r16 = 1
            goto L_0x005a
        L_0x0057:
            r15 = 0
            r16 = 0
        L_0x005a:
            int r3 = r19.getPlayerState()
            if (r3 != r4) goto L_0x0062
            r10 = 1
            goto L_0x0063
        L_0x0062:
            r10 = 0
        L_0x0063:
            com.google.android.gms.cast.framework.media.internal.zzm r3 = new com.google.android.gms.cast.framework.media.internal.zzm
            int r11 = r1.getStreamType()
            java.lang.String r1 = "com.google.android.gms.cast.metadata.TITLE"
            java.lang.String r12 = r2.getString(r1)
            java.lang.String r13 = r18.getFriendlyName()
            android.support.v4.media.session.MediaSessionCompat$Token r14 = r20.getSessionToken()
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            if (r21 != 0) goto L_0x00ad
            com.google.android.gms.cast.framework.media.internal.zzm r1 = r0.zzo
            if (r1 == 0) goto L_0x00ad
            boolean r4 = r3.zzb
            boolean r5 = r1.zzb
            if (r4 != r5) goto L_0x00ad
            int r4 = r3.zzc
            int r5 = r1.zzc
            if (r4 != r5) goto L_0x00ad
            java.lang.String r4 = r3.zzd
            java.lang.String r5 = r1.zzd
            boolean r4 = com.google.android.gms.cast.internal.CastUtils.zze(r4, r5)
            if (r4 == 0) goto L_0x00ad
            java.lang.String r4 = r3.zze
            java.lang.String r5 = r1.zze
            boolean r4 = com.google.android.gms.cast.internal.CastUtils.zze(r4, r5)
            if (r4 == 0) goto L_0x00ad
            boolean r4 = r3.zzf
            boolean r5 = r1.zzf
            if (r4 != r5) goto L_0x00ad
            boolean r4 = r3.zzg
            boolean r1 = r1.zzg
            if (r4 == r1) goto L_0x00b2
        L_0x00ad:
            r0.zzo = r3
            r17.zzg()
        L_0x00b2:
            com.google.android.gms.cast.framework.media.internal.zzn r1 = new com.google.android.gms.cast.framework.media.internal.zzn
            com.google.android.gms.cast.framework.media.ImagePicker r3 = r0.zzf
            if (r3 == 0) goto L_0x00bf
            com.google.android.gms.cast.framework.media.ImageHints r4 = r0.zzm
            com.google.android.gms.common.images.WebImage r2 = r3.onPickImage((com.google.android.gms.cast.MediaMetadata) r2, (com.google.android.gms.cast.framework.media.ImageHints) r4)
            goto L_0x00d1
        L_0x00bf:
            boolean r3 = r2.hasImages()
            if (r3 == 0) goto L_0x00d0
            java.util.List r2 = r2.getImages()
            java.lang.Object r2 = r2.get(r6)
            com.google.android.gms.common.images.WebImage r2 = (com.google.android.gms.common.images.WebImage) r2
            goto L_0x00d1
        L_0x00d0:
            r2 = 0
        L_0x00d1:
            r1.<init>(r2)
            com.google.android.gms.cast.framework.media.internal.zzn r2 = r0.zzp
            if (r2 == 0) goto L_0x00e3
            android.net.Uri r3 = r1.zza
            android.net.Uri r2 = r2.zza
            boolean r2 = com.google.android.gms.cast.internal.CastUtils.zze(r3, r2)
            if (r2 == 0) goto L_0x00e3
            return
        L_0x00e3:
            com.google.android.gms.cast.framework.media.internal.zzb r2 = r0.zzl
            com.google.android.gms.cast.framework.media.internal.zzl r3 = new com.google.android.gms.cast.framework.media.internal.zzl
            r3.<init>(r0, r1)
            r2.zzc(r3)
            com.google.android.gms.cast.framework.media.internal.zzb r2 = r0.zzl
            android.net.Uri r1 = r1.zza
            r2.zzd(r1)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzo.zzd(com.google.android.gms.cast.CastDevice, com.google.android.gms.cast.framework.media.RemoteMediaClient, android.support.v4.media.session.MediaSessionCompat, boolean):void");
    }
}

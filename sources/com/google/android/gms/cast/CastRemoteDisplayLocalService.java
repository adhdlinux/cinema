package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.app.NotificationCompat;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzdx;
import com.google.android.gms.internal.cast.zzdy;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(19)
@Deprecated
public abstract class CastRemoteDisplayLocalService extends Service {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("CastRDLocalService");
    private static final int zzb = R.id.cast_notification_id;
    /* access modifiers changed from: private */
    public static final Object zzc = new Object();
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzd = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static CastRemoteDisplayLocalService zze;
    private String zzf;
    /* access modifiers changed from: private */
    public WeakReference zzg;
    private zzar zzh;
    private NotificationSettings zzi;
    private Notification zzj;
    private boolean zzk;
    private PendingIntent zzl;
    /* access modifiers changed from: private */
    public CastDevice zzm;
    /* access modifiers changed from: private */
    public Display zzn;
    /* access modifiers changed from: private */
    public Context zzo;
    /* access modifiers changed from: private */
    public ServiceConnection zzp;
    private Handler zzq;
    private MediaRouter zzr;
    /* access modifiers changed from: private */
    public boolean zzs = false;
    private CastRemoteDisplayClient zzt;
    private final MediaRouter.Callback zzu = new zzag(this);
    private final IBinder zzv = new zzao(this);

    public interface Callbacks {
        void onRemoteDisplayMuteStateChanged(boolean z2);

        void onRemoteDisplaySessionEnded(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        /* access modifiers changed from: private */
        public Notification zza;
        /* access modifiers changed from: private */
        public PendingIntent zzb;
        /* access modifiers changed from: private */
        public String zzc;
        /* access modifiers changed from: private */
        public String zzd;

        public static final class Builder {
            private final NotificationSettings zza = new NotificationSettings((zzap) null);

            public NotificationSettings build() {
                if (this.zza.zza != null) {
                    if (!TextUtils.isEmpty(this.zza.zzc)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zza.zzd)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zza.zzb != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zza.zzc) && TextUtils.isEmpty(this.zza.zzd) && this.zza.zzb == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zza;
            }

            public Builder setNotification(Notification notification) {
                this.zza.zza = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent pendingIntent) {
                this.zza.zzb = pendingIntent;
                return this;
            }

            public Builder setNotificationText(String str) {
                this.zza.zzd = str;
                return this;
            }

            public Builder setNotificationTitle(String str) {
                this.zza.zzc = str;
                return this;
            }
        }

        private NotificationSettings() {
        }

        /* synthetic */ NotificationSettings(NotificationSettings notificationSettings, zzap zzap) {
            this.zza = notificationSettings.zza;
            this.zzb = notificationSettings.zzb;
            this.zzc = notificationSettings.zzc;
            this.zzd = notificationSettings.zzd;
        }

        /* synthetic */ NotificationSettings(zzap zzap) {
        }
    }

    public static class Options {
        @CastRemoteDisplay.Configuration
        int zza = 2;

        @CastRemoteDisplay.Configuration
        public int getConfigPreset() {
            return this.zza;
        }

        public void setConfigPreset(@CastRemoteDisplay.Configuration int i2) {
            this.zza = i2;
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzc) {
            castRemoteDisplayLocalService = zze;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zza.zzb(true);
    }

    public static void startService(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, NotificationSettings notificationSettings, Callbacks callbacks) {
        startServiceWithOptions(context, cls, str, castDevice, new Options(), notificationSettings, callbacks);
    }

    public static void startServiceWithOptions(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Callbacks callbacks) {
        Logger logger = zza;
        logger.d("Starting Service", new Object[0]);
        synchronized (zzc) {
            if (zze != null) {
                logger.w("An existing service had not been stopped before starting one", new Object[0]);
                zzw(true);
            }
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null) {
                if (serviceInfo.exported) {
                    throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
                }
            }
            Preconditions.checkNotNull(context, "activityContext is required.");
            Preconditions.checkNotNull(cls, "serviceClass is required.");
            Preconditions.checkNotNull(str, "applicationId is required.");
            Preconditions.checkNotNull(castDevice, "device is required.");
            Preconditions.checkNotNull(options, "options is required.");
            Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
            Preconditions.checkNotNull(callbacks, "callbacks is required.");
            if (notificationSettings.zza == null && notificationSettings.zzb == null) {
                throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
            } else if (zzd.getAndSet(true)) {
                logger.e("Service is already being started, startService has been called twice", new Object[0]);
            } else {
                Intent intent = new Intent(context, cls);
                context.startService(intent);
                ConnectionTracker.getInstance().bindService(context, intent, new zzai(str, castDevice, options, notificationSettings, context, callbacks), 64);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?", e2);
        }
    }

    public static void stopService() {
        zzw(false);
    }

    static /* bridge */ /* synthetic */ void zzl(CastRemoteDisplayLocalService castRemoteDisplayLocalService, Display display) {
        if (display == null) {
            zza.e("Cast Remote Display session created without display", new Object[0]);
            return;
        }
        castRemoteDisplayLocalService.zzn = display;
        if (castRemoteDisplayLocalService.zzk) {
            Notification zzu2 = castRemoteDisplayLocalService.zzu(true);
            castRemoteDisplayLocalService.zzj = zzu2;
            castRemoteDisplayLocalService.startForeground(zzb, zzu2);
        }
        Callbacks callbacks = (Callbacks) castRemoteDisplayLocalService.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionStarted(castRemoteDisplayLocalService);
        }
        Preconditions.checkNotNull(castRemoteDisplayLocalService.zzn, "display is required.");
        castRemoteDisplayLocalService.onCreatePresentation(castRemoteDisplayLocalService.zzn);
    }

    static /* bridge */ /* synthetic */ void zzo(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        Callbacks callbacks = (Callbacks) castRemoteDisplayLocalService.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
        }
        stopService();
    }

    static /* bridge */ /* synthetic */ void zzq(CastRemoteDisplayLocalService castRemoteDisplayLocalService, NotificationSettings notificationSettings) {
        Preconditions.checkMainThread("updateNotificationSettingsInternal must be called on the main thread");
        if (castRemoteDisplayLocalService.zzi != null) {
            if (!castRemoteDisplayLocalService.zzk) {
                Preconditions.checkNotNull(notificationSettings.zza, "notification is required.");
                Notification zza2 = notificationSettings.zza;
                castRemoteDisplayLocalService.zzj = zza2;
                castRemoteDisplayLocalService.zzi.zza = zza2;
            } else if (notificationSettings.zza == null) {
                if (notificationSettings.zzb != null) {
                    castRemoteDisplayLocalService.zzi.zzb = notificationSettings.zzb;
                }
                if (!TextUtils.isEmpty(notificationSettings.zzc)) {
                    castRemoteDisplayLocalService.zzi.zzc = notificationSettings.zzc;
                }
                if (!TextUtils.isEmpty(notificationSettings.zzd)) {
                    castRemoteDisplayLocalService.zzi.zzd = notificationSettings.zzd;
                }
                castRemoteDisplayLocalService.zzj = castRemoteDisplayLocalService.zzu(true);
            } else {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            castRemoteDisplayLocalService.startForeground(zzb, castRemoteDisplayLocalService.zzj);
            return;
        }
        throw new IllegalStateException("No current notification settings to update");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r0.zzg = new java.lang.ref.WeakReference(r18);
        r0.zzf = r12;
        r0.zzm = r13;
        r0.zzo = r16;
        r0.zzp = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r0.zzr != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        r0.zzr = androidx.mediarouter.media.MediaRouter.j(r11.getApplicationContext());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r0.zzf, "applicationId is required.");
        r2 = new androidx.mediarouter.media.MediaRouteSelector.Builder().b(com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r0.zzf)).d();
        r11.zzv("addMediaRouterCallback");
        r0.zzr.b(r2, r0.zzu, 4);
        r0.zzj = com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zza(r15);
        r0.zzh = new com.google.android.gms.cast.zzar((com.google.android.gms.cast.zzaq) null);
        r2 = new android.content.IntentFilter();
        r2.addAction("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
        r2.addAction("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008f, code lost:
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastT() == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0091, code lost:
        r11.registerReceiver(r0.zzh, r2, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0097, code lost:
        com.google.android.gms.internal.cast.zzdw.zza(r11, r0.zzh, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009c, code lost:
        r5 = r15;
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings(r15, (com.google.android.gms.cast.zzap) null);
        r0.zzi = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a9, code lost:
        if (com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zza(r2) != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ab, code lost:
        r0.zzk = true;
        r0.zzj = r11.zzu(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b4, code lost:
        r0.zzk = false;
        r0.zzj = com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zza(r0.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00be, code lost:
        r11.startForeground(zzb, r0.zzj);
        r11.zzv("startRemoteDisplay");
        r2 = new android.content.Intent("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r0.zzo, "activityContext is required.");
        r2.setPackage(r0.zzo.getPackageName());
        r8 = android.app.PendingIntent.getBroadcast(r11, 0, r2, com.google.android.gms.internal.cast.zzdx.zza);
        r9 = new com.google.android.gms.cast.zzal(r11);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r0.zzf, "applicationId is required.");
        r0.zzt.zze(r13, r0.zzf, r14.getConfigPreset(), r8, r9).addOnCompleteListener(new com.google.android.gms.cast.zzam(r11));
        r1 = (com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks) r0.zzg.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0110, code lost:
        if (r1 != null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0112, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0114, code lost:
        r1.onServiceCreated(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0117, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ boolean zzt(com.google.android.gms.cast.CastRemoteDisplayLocalService r11, java.lang.String r12, com.google.android.gms.cast.CastDevice r13, com.google.android.gms.cast.CastRemoteDisplayLocalService.Options r14, com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings r15, android.content.Context r16, android.content.ServiceConnection r17, com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks r18) {
        /*
            r0 = r11
            java.lang.String r1 = "startRemoteDisplaySession"
            r11.zzv(r1)
            java.lang.String r1 = "Starting the Cast Remote Display must be done on the main thread"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r1)
            java.lang.Object r1 = zzc
            monitor-enter(r1)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r2 = zze     // Catch:{ all -> 0x0118 }
            r3 = 0
            if (r2 == 0) goto L_0x001f
            com.google.android.gms.cast.internal.Logger r0 = zza     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = "An existing service had not been stopped before starting one"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0118 }
            r0.w(r2, r4)     // Catch:{ all -> 0x0118 }
            monitor-exit(r1)     // Catch:{ all -> 0x0118 }
            goto L_0x0113
        L_0x001f:
            zze = r0     // Catch:{ all -> 0x0118 }
            monitor-exit(r1)     // Catch:{ all -> 0x0118 }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r2 = r18
            r1.<init>(r2)
            r0.zzg = r1
            r1 = r12
            r0.zzf = r1
            r1 = r13
            r0.zzm = r1
            r2 = r16
            r0.zzo = r2
            r2 = r17
            r0.zzp = r2
            androidx.mediarouter.media.MediaRouter r2 = r0.zzr
            if (r2 != 0) goto L_0x0047
            android.content.Context r2 = r11.getApplicationContext()
            androidx.mediarouter.media.MediaRouter r2 = androidx.mediarouter.media.MediaRouter.j(r2)
            r0.zzr = r2
        L_0x0047:
            java.lang.String r2 = r0.zzf
            java.lang.String r4 = "applicationId is required."
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2, r4)
            androidx.mediarouter.media.MediaRouteSelector$Builder r2 = new androidx.mediarouter.media.MediaRouteSelector$Builder
            r2.<init>()
            java.lang.String r4 = r0.zzf
            java.lang.String r4 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast((java.lang.String) r4)
            androidx.mediarouter.media.MediaRouteSelector$Builder r2 = r2.b(r4)
            androidx.mediarouter.media.MediaRouteSelector r2 = r2.d()
            java.lang.String r4 = "addMediaRouterCallback"
            r11.zzv(r4)
            androidx.mediarouter.media.MediaRouter r4 = r0.zzr
            androidx.mediarouter.media.MediaRouter$Callback r5 = r0.zzu
            r6 = 4
            r4.b(r2, r5, r6)
            android.app.Notification r2 = r15.zza
            r0.zzj = r2
            com.google.android.gms.cast.zzar r2 = new com.google.android.gms.cast.zzar
            r4 = 0
            r2.<init>(r4)
            r0.zzh = r2
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>()
            java.lang.String r5 = "com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"
            r2.addAction(r5)
            java.lang.String r5 = "com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED"
            r2.addAction(r5)
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastT()
            if (r5 == 0) goto L_0x0097
            com.google.android.gms.cast.zzar r5 = r0.zzh
            r11.registerReceiver(r5, r2, r6)
            goto L_0x009c
        L_0x0097:
            com.google.android.gms.cast.zzar r5 = r0.zzh
            com.google.android.gms.internal.cast.zzdw.zza(r11, r5, r2)
        L_0x009c:
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings
            r5 = r15
            r2.<init>(r15, r4)
            r0.zzi = r2
            android.app.Notification r2 = r2.zza
            r10 = 1
            if (r2 != 0) goto L_0x00b4
            r0.zzk = r10
            android.app.Notification r2 = r11.zzu(r3)
            r0.zzj = r2
            goto L_0x00be
        L_0x00b4:
            r0.zzk = r3
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r2 = r0.zzi
            android.app.Notification r2 = r2.zza
            r0.zzj = r2
        L_0x00be:
            int r2 = zzb
            android.app.Notification r4 = r0.zzj
            r11.startForeground(r2, r4)
            java.lang.String r2 = "startRemoteDisplay"
            r11.zzv(r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r4 = "com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED"
            r2.<init>(r4)
            android.content.Context r4 = r0.zzo
            java.lang.String r5 = "activityContext is required."
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r5)
            android.content.Context r4 = r0.zzo
            java.lang.String r4 = r4.getPackageName()
            r2.setPackage(r4)
            int r4 = com.google.android.gms.internal.cast.zzdx.zza
            android.app.PendingIntent r8 = android.app.PendingIntent.getBroadcast(r11, r3, r2, r4)
            com.google.android.gms.cast.zzal r9 = new com.google.android.gms.cast.zzal
            r9.<init>(r11)
            java.lang.String r2 = r0.zzf
            java.lang.String r3 = "applicationId is required."
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2, r3)
            com.google.android.gms.cast.CastRemoteDisplayClient r4 = r0.zzt
            java.lang.String r6 = r0.zzf
            int r7 = r14.getConfigPreset()
            r5 = r13
            com.google.android.gms.tasks.Task r1 = r4.zze(r5, r6, r7, r8, r9)
            com.google.android.gms.cast.zzam r2 = new com.google.android.gms.cast.zzam
            r2.<init>(r11)
            r1.addOnCompleteListener(r2)
            java.lang.ref.WeakReference r1 = r0.zzg
            java.lang.Object r1 = r1.get()
            com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks r1 = (com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks) r1
            if (r1 != 0) goto L_0x0114
            r3 = 1
        L_0x0113:
            return r3
        L_0x0114:
            r1.onServiceCreated(r11)
            return r10
        L_0x0118:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0118 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zzt(com.google.android.gms.cast.CastRemoteDisplayLocalService, java.lang.String, com.google.android.gms.cast.CastDevice, com.google.android.gms.cast.CastRemoteDisplayLocalService$Options, com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings, android.content.Context, android.content.ServiceConnection, com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks):boolean");
    }

    private final Notification zzu(boolean z2) {
        int i2;
        int i3;
        zzv("createDefaultNotification");
        String zzd2 = this.zzi.zzc;
        String zzc2 = this.zzi.zzd;
        if (z2) {
            i2 = R.string.cast_notification_connected_message;
            i3 = R.drawable.cast_ic_notification_on;
        } else {
            i2 = R.string.cast_notification_connecting_message;
            i3 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzd2)) {
            zzd2 = (String) getPackageManager().getApplicationLabel(getApplicationInfo());
        }
        if (TextUtils.isEmpty(zzc2)) {
            zzc2 = getString(i2, new Object[]{this.zzm.getFriendlyName()});
        }
        NotificationCompat.Builder s2 = new NotificationCompat.Builder(this, "cast_remote_display_local_service").m(zzd2).l(zzc2).k(this.zzi.zzb).y(i3).s(true);
        String string = getString(R.string.cast_notification_disconnect);
        if (this.zzl == null) {
            Preconditions.checkNotNull(this.zzo, "activityContext is required.");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intent.setPackage(this.zzo.getPackageName());
            this.zzl = PendingIntent.getBroadcast(this, 0, intent, zzdx.zza | 134217728);
        }
        return s2.a(17301560, string, this.zzl).c();
    }

    /* access modifiers changed from: private */
    public final void zzv(String str) {
        zza.d("[Instance: %s] %s", this, str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r3.zzq.post(new com.google.android.gms.cast.zzaj(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r3.zzx(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r3.zzq == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zzw(boolean r4) {
        /*
            com.google.android.gms.cast.internal.Logger r0 = zza
            java.lang.String r1 = "Stopping Service"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            java.util.concurrent.atomic.AtomicBoolean r1 = zzd
            r1.set(r2)
            java.lang.Object r1 = zzc
            monitor-enter(r1)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r3 = zze     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x0037
            r0 = 0
            zze = r0     // Catch:{ all -> 0x0040 }
            monitor-exit(r1)     // Catch:{ all -> 0x0040 }
            android.os.Handler r0 = r3.zzq
            if (r0 == 0) goto L_0x0036
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0033
            android.os.Handler r0 = r3.zzq
            com.google.android.gms.cast.zzaj r1 = new com.google.android.gms.cast.zzaj
            r1.<init>(r3, r4)
            r0.post(r1)
            return
        L_0x0033:
            r3.zzx(r4)
        L_0x0036:
            return
        L_0x0037:
            java.lang.String r4 = "Service is already being stopped"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0040 }
            r0.e(r4, r2)     // Catch:{ all -> 0x0040 }
            monitor-exit(r1)     // Catch:{ all -> 0x0040 }
            return
        L_0x0040:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0040 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zzw(boolean):void");
    }

    /* access modifiers changed from: private */
    public final void zzx(boolean z2) {
        zzv("Stopping Service");
        Preconditions.checkMainThread("stopServiceInstanceInternal must be called on the main thread");
        if (!z2 && this.zzr != null) {
            zzv("Setting default route");
            MediaRouter mediaRouter = this.zzr;
            mediaRouter.u(mediaRouter.g());
        }
        if (this.zzh != null) {
            zzv("Unregistering notification receiver");
            unregisterReceiver(this.zzh);
        }
        zzv("stopRemoteDisplaySession");
        zzv("stopRemoteDisplay");
        this.zzt.stopRemoteDisplay().addOnCompleteListener(new zzan(this));
        Callbacks callbacks = (Callbacks) this.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionEnded(this);
        }
        onDismissPresentation();
        zzv("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
        if (this.zzr != null) {
            Preconditions.checkMainThread("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzv("removeMediaRouterCallback");
            this.zzr.s(this.zzu);
        }
        Context context = this.zzo;
        ServiceConnection serviceConnection = this.zzp;
        if (!(context == null || serviceConnection == null)) {
            try {
                ConnectionTracker.getInstance().unbindService(context, serviceConnection);
            } catch (IllegalArgumentException unused) {
                zzv("No need to unbind service, already unbound");
            }
        }
        this.zzp = null;
        this.zzo = null;
        this.zzf = null;
        this.zzj = null;
        this.zzn = null;
    }

    /* access modifiers changed from: protected */
    public Display getCastRemoteDisplay() {
        return this.zzn;
    }

    public IBinder onBind(Intent intent) {
        zzv("onBind");
        return this.zzv;
    }

    public void onCreate() {
        zzv("onCreate");
        super.onCreate();
        zzdy zzdy = new zzdy(getMainLooper());
        this.zzq = zzdy;
        zzdy.postDelayed(new zzah(this), 100);
        if (this.zzt == null) {
            this.zzt = CastRemoteDisplay.getClient(this);
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_remote_display_local_service", getString(R.string.cast_notification_default_channel_name), 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int i2, int i3) {
        zzv("onStartCommand");
        this.zzs = true;
        return 2;
    }

    @Deprecated
    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        if (!PlatformVersion.isAtLeastS()) {
            Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
            Preconditions.checkNotNull(this.zzq, "Service is not ready yet.");
            this.zzq.post(new zzak(this, notificationSettings));
        }
    }
}

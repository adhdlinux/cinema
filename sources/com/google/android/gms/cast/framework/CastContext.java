package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzab;
import com.google.android.gms.internal.cast.zzae;
import com.google.android.gms.internal.cast.zzaf;
import com.google.android.gms.internal.cast.zzah;
import com.google.android.gms.internal.cast.zzay;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzbm;
import com.google.android.gms.internal.cast.zzcx;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class CastContext {
    public static final String OPTIONS_PROVIDER_CLASS_NAME_KEY = "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME";
    /* access modifiers changed from: private */
    public static final Logger zzb = new Logger("CastContext");
    private static final Object zzc = new Object();
    private static volatile CastContext zzd;
    @VisibleForTesting
    final zzae zza;
    private final Context zze;
    /* access modifiers changed from: private */
    public final zzz zzf;
    private final SessionManager zzg;
    private final zzs zzh;
    private final PrecacheManager zzi;
    private final MediaNotificationManager zzj;
    private final CastOptions zzk;
    private final zzn zzl;
    private final zzbf zzm;
    private final zzay zzn;
    private final List zzo;
    private final zzbm zzp;
    private final zzcx zzq;
    private zzah zzr;
    private CastReasonCodes zzs;

    private CastContext(Context context, CastOptions castOptions, List list, zzbf zzbf, zzn zzn2) throws ModuleUnavailableException {
        this.zze = context;
        this.zzk = castOptions;
        this.zzm = zzbf;
        this.zzl = zzn2;
        this.zzo = list;
        zzay zzay = new zzay(context);
        this.zzn = zzay;
        zzbm zzn3 = zzbf.zzn();
        this.zzp = zzn3;
        zzk();
        try {
            zzz zza2 = zzaf.zza(context, castOptions, zzbf, zzj());
            this.zzf = zza2;
            try {
                this.zzh = new zzs(zza2.zzg());
                try {
                    SessionManager sessionManager = new SessionManager(zza2.zzh(), context);
                    this.zzg = sessionManager;
                    this.zzj = new MediaNotificationManager(sessionManager);
                    this.zzi = new PrecacheManager(castOptions, sessionManager, zzn2);
                    if (zzn3 != null) {
                        zzn3.zzj(sessionManager);
                    }
                    this.zzq = new zzcx(context);
                    zzn2.zza(new String[]{"com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_UPDATE_DEVICES_DELAY_MS", "com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_DISCOVERY_TIMEOUT_MS", "com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_ZERO_DEVICE_TIMEOUT_MS", "com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_ENABLE_WIFI_WARNING"}).addOnSuccessListener(zzab.zza);
                    zzae zzae = new zzae();
                    this.zza = zzae;
                    try {
                        zza2.zzi(zzae);
                        zzae.zze(zzay.zza);
                        if (!castOptions.zza().isEmpty()) {
                            zzb.i("Setting Route Discovery for appIds: ".concat(String.valueOf(castOptions.zza())), new Object[0]);
                            zzay.zza(castOptions.zza());
                        }
                        zzn2.zza(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"}).addOnSuccessListener(new zzb(this));
                        zzn2.doRead(TaskApiCall.builder().run(new zzh(zzn2, new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"})).setFeatures(zzax.zzh).setAutoResolveMissingFeatures(false).setMethodKey(8427).build()).addOnSuccessListener(new zzc(this));
                        try {
                            if (zza2.zze() >= 224300000) {
                                CastButtonFactory.zzb(new zze(this));
                            }
                        } catch (RemoteException e2) {
                            zzb.d(e2, "Unable to call %s on %s.", "clientGmsVersion", zzz.class.getSimpleName());
                        }
                    } catch (RemoteException e3) {
                        throw new IllegalStateException("Failed to call addAppVisibilityListener", e3);
                    }
                } catch (RemoteException e4) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e4);
                }
            } catch (RemoteException e5) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e5);
            }
        } catch (RemoteException e6) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e6);
        }
    }

    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return zzd;
    }

    public static CastContext zza(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return getSharedInstance(context);
        } catch (RuntimeException e2) {
            zzb.e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e2);
            return null;
        }
    }

    static /* synthetic */ CastContext zzb(Context context, CastOptions castOptions, OptionsProvider optionsProvider, zzbf zzbf, zzn zzn2) throws Exception {
        synchronized (zzc) {
            if (zzd == null) {
                zzd = new CastContext(context, castOptions, optionsProvider.getAdditionalSessionProviders(context), zzbf, zzn2);
            }
        }
        return zzd;
    }

    private static OptionsProvider zzi(Context context) throws IllegalStateException {
        try {
            Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                zzb.e("Bundle is null", new Object[0]);
            }
            String string = bundle.getString(OPTIONS_PROVIDER_CLASS_NAME_KEY);
            if (string != null) {
                return (OptionsProvider) Class.forName(string).asSubclass(OptionsProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e2) {
            throw new IllegalStateException("Failed to initialize CastContext.", e2);
        }
    }

    private final Map zzj() {
        HashMap hashMap = new HashMap();
        zzah zzah = this.zzr;
        if (zzah != null) {
            hashMap.put(zzah.getCategory(), zzah.zza());
        }
        List<SessionProvider> list = this.zzo;
        if (list != null) {
            for (SessionProvider sessionProvider : list) {
                Preconditions.checkNotNull(sessionProvider, "Additional SessionProvider must not be null.");
                String checkNotEmpty = Preconditions.checkNotEmpty(sessionProvider.getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!hashMap.containsKey(checkNotEmpty), String.format("SessionProvider for category %s already added", new Object[]{checkNotEmpty}));
                hashMap.put(checkNotEmpty, sessionProvider.zza());
            }
        }
        return hashMap;
    }

    @RequiresNonNull({"castOptions", "mediaRouter", "appContext"})
    private final void zzk() {
        zzah zzah;
        if (!TextUtils.isEmpty(this.zzk.getReceiverApplicationId())) {
            zzah = new zzah(this.zze, this.zzk, this.zzm);
        } else {
            zzah = null;
        }
        this.zzr = zzah;
    }

    @Deprecated
    public void addAppVisibilityListener(AppVisibilityListener appVisibilityListener) throws IllegalStateException, NullPointerException {
    }

    public void addCastStateListener(CastStateListener castStateListener) throws IllegalStateException, NullPointerException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(castStateListener);
        this.zzg.zzc(castStateListener);
    }

    public void addSessionTransferCallback(SessionTransferCallback sessionTransferCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback);
        zzbm zzn2 = this.zzm.zzn();
        if (zzn2 != null) {
            zzn2.zzm(sessionTransferCallback);
        }
    }

    public CastOptions getCastOptions() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public int getCastReasonCodeForCastStatusCode(int i2) {
        CastReasonCodes castReasonCodes = this.zzs;
        if (castReasonCodes != null) {
            return castReasonCodes.zza(i2);
        }
        zzb.w("castReasonCodes hasn't been initialized yet", new Object[0]);
        return 0;
    }

    public int getCastState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg.zza();
    }

    public MediaNotificationManager getMediaNotificationManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public MediaRouteSelector getMergedSelector() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return MediaRouteSelector.d(this.zzf.zzf());
        } catch (RemoteException e2) {
            zzb.d(e2, "Unable to call %s on %s.", "getMergedSelectorAsBundle", zzz.class.getSimpleName());
            return null;
        }
    }

    public PrecacheManager getPrecacheManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    public SessionManager getSessionManager() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg;
    }

    @Deprecated
    public boolean isAppVisible() throws IllegalStateException {
        return false;
    }

    @Deprecated
    public boolean onDispatchVolumeKeyEventBeforeJellyBean(KeyEvent keyEvent) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return false;
    }

    @Deprecated
    public void removeAppVisibilityListener(AppVisibilityListener appVisibilityListener) throws IllegalStateException {
    }

    public void removeCastStateListener(CastStateListener castStateListener) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (castStateListener != null) {
            this.zzg.zzd(castStateListener);
        }
    }

    public void removeSessionTransferCallback(SessionTransferCallback sessionTransferCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback);
        zzbm zzn2 = this.zzm.zzn();
        if (zzn2 != null) {
            zzn2.zzn(sessionTransferCallback);
        }
    }

    public void setLaunchCredentialsData(CredentialsData credentialsData) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder(this.zzk.getLaunchOptions());
        builder.setCredentialsData(credentialsData);
        this.zzk.zzb(builder.build());
        zzk();
    }

    public void setReceiverApplicationId(String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!TextUtils.equals(str, this.zzk.getReceiverApplicationId())) {
            this.zzk.zzc(str);
            zzk();
            try {
                this.zzf.zzk(str, zzj());
            } catch (RemoteException e2) {
                zzb.d(e2, "Unable to call %s on %s.", "setReceiverApplicationId", zzz.class.getSimpleName());
            }
            CastButtonFactory.zza(this.zze);
        }
    }

    @ShowFirstParty
    public final zzs zzc() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    public final zzcx zzf() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzq;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Bundle bundle) {
        this.zzs = new CastReasonCodes(bundle);
    }

    @Deprecated
    public static CastContext getSharedInstance(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzd == null) {
            synchronized (zzc) {
                if (zzd == null) {
                    Context applicationContext = context.getApplicationContext();
                    OptionsProvider zzi2 = zzi(applicationContext);
                    CastOptions castOptions = zzi2.getCastOptions(applicationContext);
                    zzn zzn2 = new zzn(applicationContext);
                    try {
                        zzd = new CastContext(applicationContext, castOptions, zzi2.getAdditionalSessionProviders(applicationContext), new zzbf(applicationContext, MediaRouter.j(applicationContext), castOptions, zzn2), zzn2);
                    } catch (ModuleUnavailableException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
        return zzd;
    }

    public static Task<CastContext> getSharedInstance(Context context, Executor executor) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzd != null) {
            return Tasks.forResult(zzd);
        }
        Context applicationContext = context.getApplicationContext();
        OptionsProvider zzi2 = zzi(applicationContext);
        CastOptions castOptions = zzi2.getCastOptions(applicationContext);
        zzn zzn2 = new zzn(applicationContext);
        return Tasks.call(executor, new zzd(applicationContext, castOptions, zzi2, new zzbf(applicationContext, MediaRouter.j(applicationContext), castOptions, zzn2), zzn2));
    }
}

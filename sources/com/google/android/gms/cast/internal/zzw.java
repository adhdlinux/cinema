package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.cast.zzbu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zzw extends GmsClient {
    /* access modifiers changed from: private */
    public static final Logger zze = new Logger("CastClientImpl");
    /* access modifiers changed from: private */
    public static final Object zzf = new Object();
    private static final Object zzg = new Object();
    private Bundle zzA;
    private final Map zzB = new HashMap();
    /* access modifiers changed from: private */
    public BaseImplementation.ResultHolder zzC;
    private BaseImplementation.ResultHolder zzD;
    /* access modifiers changed from: private */
    public ApplicationMetadata zzh;
    /* access modifiers changed from: private */
    public final CastDevice zzi;
    /* access modifiers changed from: private */
    public final Cast.Listener zzj;
    /* access modifiers changed from: private */
    public final Map zzk = new HashMap();
    private final long zzl;
    private final Bundle zzm;
    private zzv zzn;
    /* access modifiers changed from: private */
    public String zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private double zzt;
    private zzav zzu;
    private int zzv;
    private int zzw;
    private final AtomicLong zzx = new AtomicLong(0);
    /* access modifiers changed from: private */
    public String zzy;
    /* access modifiers changed from: private */
    public String zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzw(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j2, Cast.Listener listener, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzi = castDevice;
        this.zzj = listener;
        this.zzl = j2;
        this.zzm = bundle;
        zzY();
        zzp();
    }

    static /* bridge */ /* synthetic */ void zzH(zzw zzw2, zza zza) {
        boolean z2;
        String zza2 = zza.zza();
        if (!CastUtils.zze(zza2, zzw2.zzo)) {
            zzw2.zzo = zza2;
            z2 = true;
        } else {
            z2 = false;
        }
        zze.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(zzw2.zzq));
        Cast.Listener listener = zzw2.zzj;
        if (listener != null && (z2 || zzw2.zzq)) {
            listener.onApplicationStatusChanged();
        }
        zzw2.zzq = false;
    }

    static /* bridge */ /* synthetic */ void zzI(zzw zzw2, zzab zzab) {
        boolean z2;
        boolean z3;
        boolean z4;
        ApplicationMetadata zze2 = zzab.zze();
        if (!CastUtils.zze(zze2, zzw2.zzh)) {
            zzw2.zzh = zze2;
            zzw2.zzj.onApplicationMetadataChanged(zze2);
        }
        double zzb = zzab.zzb();
        if (Double.isNaN(zzb) || Math.abs(zzb - zzw2.zzt) <= 1.0E-7d) {
            z2 = false;
        } else {
            zzw2.zzt = zzb;
            z2 = true;
        }
        boolean zzg2 = zzab.zzg();
        if (zzg2 != zzw2.zzp) {
            zzw2.zzp = zzg2;
            z2 = true;
        }
        zzab.zza();
        Logger logger = zze;
        logger.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(zzw2.zzr));
        Cast.Listener listener = zzw2.zzj;
        if (listener != null && (z2 || zzw2.zzr)) {
            listener.onVolumeChanged();
        }
        int zzc = zzab.zzc();
        if (zzc != zzw2.zzv) {
            zzw2.zzv = zzc;
            z3 = true;
        } else {
            z3 = false;
        }
        logger.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(zzw2.zzr));
        Cast.Listener listener2 = zzw2.zzj;
        if (listener2 != null && (z3 || zzw2.zzr)) {
            listener2.onActiveInputStateChanged(zzw2.zzv);
        }
        int zzd = zzab.zzd();
        if (zzd != zzw2.zzw) {
            zzw2.zzw = zzd;
            z4 = true;
        } else {
            z4 = false;
        }
        logger.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z4), Boolean.valueOf(zzw2.zzr));
        Cast.Listener listener3 = zzw2.zzj;
        if (listener3 != null && (z4 || zzw2.zzr)) {
            listener3.onStandbyStateChanged(zzw2.zzw);
        }
        if (!CastUtils.zze(zzw2.zzu, zzab.zzf())) {
            zzw2.zzu = zzab.zzf();
        }
        zzw2.zzr = false;
    }

    /* access modifiers changed from: private */
    public final void zzY() {
        this.zzs = false;
        this.zzv = -1;
        this.zzw = -1;
        this.zzh = null;
        this.zzo = null;
        this.zzt = 0.0d;
        zzp();
        this.zzp = false;
        this.zzu = null;
    }

    private final void zzZ() {
        zze.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzk) {
            this.zzk.clear();
        }
    }

    /* access modifiers changed from: private */
    public final void zzaa(long j2, int i2) {
        BaseImplementation.ResultHolder resultHolder;
        synchronized (this.zzB) {
            resultHolder = (BaseImplementation.ResultHolder) this.zzB.remove(Long.valueOf(j2));
        }
        if (resultHolder != null) {
            resultHolder.setResult(new Status(i2));
        }
    }

    /* access modifiers changed from: private */
    public final void zzab(int i2) {
        synchronized (zzg) {
            BaseImplementation.ResultHolder resultHolder = this.zzD;
            if (resultHolder != null) {
                resultHolder.setResult(new Status(i2));
                this.zzD = null;
            }
        }
    }

    private final void zzac(BaseImplementation.ResultHolder resultHolder) {
        synchronized (zzf) {
            BaseImplementation.ResultHolder resultHolder2 = this.zzC;
            if (resultHolder2 != null) {
                resultHolder2.setResult(new zzq(new Status(2477), (ApplicationMetadata) null, (String) null, (String) null, false));
            }
            this.zzC = resultHolder;
        }
    }

    private final void zzad(BaseImplementation.ResultHolder resultHolder) {
        synchronized (zzg) {
            if (this.zzD != null) {
                resultHolder.setResult(new Status(2001));
            } else {
                this.zzD = resultHolder;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        if (queryLocalInterface instanceof zzag) {
            return (zzag) queryLocalInterface;
        }
        return new zzag(iBinder);
    }

    public final void disconnect() {
        Logger logger = zze;
        logger.d("disconnect(); ServiceListener=%s, isConnected=%b", this.zzn, Boolean.valueOf(isConnected()));
        zzv zzv2 = this.zzn;
        this.zzn = null;
        if (zzv2 == null || zzv2.zzq() == null) {
            logger.d("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzZ();
        try {
            ((zzag) getService()).zzf();
        } catch (RemoteException | IllegalStateException e2) {
            zze.d(e2, "Error while disconnecting the controller interface", new Object[0]);
        } finally {
            super.disconnect();
        }
    }

    public final Bundle getConnectionHint() {
        Bundle bundle = this.zzA;
        if (bundle == null) {
            return super.getConnectionHint();
        }
        this.zzA = null;
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        zze.d("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzy, this.zzz);
        this.zzi.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzl);
        Bundle bundle2 = this.zzm;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        this.zzn = new zzv(this);
        bundle.putParcelable(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new BinderWrapper(this.zzn));
        String str = this.zzy;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.zzz;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    public final int getMinApkVersion() {
        return 12800000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        zzZ();
    }

    /* access modifiers changed from: protected */
    public final void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        zze.d("in onPostInitHandler; statusCode=%d", Integer.valueOf(i2));
        if (i2 == 0 || i2 == 2300) {
            this.zzs = true;
            this.zzq = true;
            this.zzr = true;
        } else {
            this.zzs = false;
        }
        if (i2 == 2300) {
            Bundle bundle2 = new Bundle();
            this.zzA = bundle2;
            bundle2.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i2 = 0;
        }
        super.onPostInitHandler(i2, iBinder, bundle, i3);
    }

    public final void zzL(String str, String str2, zzbu zzbu, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzac(resultHolder);
        zzbu zzbu2 = new zzbu();
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzg(str, str2, zzbu2);
        } else {
            zzR(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzM(String str, LaunchOptions launchOptions, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzac(resultHolder);
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzh(str, launchOptions);
        } else {
            zzR(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzN(BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzad(resultHolder);
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzi();
        } else {
            zzab(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzO(String str) throws IllegalArgumentException, RemoteException {
        Cast.MessageReceivedCallback messageReceivedCallback;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.zzk) {
                messageReceivedCallback = (Cast.MessageReceivedCallback) this.zzk.remove(str);
            }
            if (messageReceivedCallback != null) {
                try {
                    ((zzag) getService()).zzr(str);
                } catch (IllegalStateException e2) {
                    zze.d(e2, "Error unregistering namespace (%s)", str);
                }
            }
        } else {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
    }

    public final void zzP() throws IllegalStateException, RemoteException {
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzl();
        }
    }

    public final void zzQ(String str, String str2, BaseImplementation.ResultHolder resultHolder) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() <= 524288) {
            CastUtils.throwIfInvalidNamespace(str);
            long incrementAndGet = this.zzx.incrementAndGet();
            try {
                this.zzB.put(Long.valueOf(incrementAndGet), resultHolder);
                zzag zzag = (zzag) getService();
                if (zzW()) {
                    zzag.zzm(str, str2, incrementAndGet);
                } else {
                    zzaa(incrementAndGet, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
                }
            } catch (Throwable th) {
                this.zzB.remove(Long.valueOf(incrementAndGet));
                throw th;
            }
        } else {
            zze.w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
    }

    public final void zzR(int i2) {
        synchronized (zzf) {
            BaseImplementation.ResultHolder resultHolder = this.zzC;
            if (resultHolder != null) {
                resultHolder.setResult(new zzq(new Status(i2), (ApplicationMetadata) null, (String) null, (String) null, false));
                this.zzC = null;
            }
        }
    }

    public final void zzS(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        CastUtils.throwIfInvalidNamespace(str);
        zzO(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzk) {
                this.zzk.put(str, messageReceivedCallback);
            }
            zzag zzag = (zzag) getService();
            if (zzW()) {
                zzag.zzk(str);
            }
        }
    }

    public final void zzT(boolean z2) throws IllegalStateException, RemoteException {
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzn(z2, this.zzt, this.zzp);
        }
    }

    public final void zzU(double d2) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Volume cannot be " + d2);
        }
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzo(d2, this.zzt, this.zzp);
        }
    }

    public final void zzV(String str, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzad(resultHolder);
        zzag zzag = (zzag) getService();
        if (zzW()) {
            zzag.zzp(str);
        } else {
            zzab(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.zzn;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzW() {
        /*
            r1 = this;
            boolean r0 = r1.zzs
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.cast.internal.zzv r0 = r1.zzn
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzr()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzw.zzW():boolean");
    }

    public final boolean zzX() throws IllegalStateException {
        checkConnected();
        return this.zzp;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final double zzp() {
        Preconditions.checkNotNull(this.zzi, "device should not be null");
        if (this.zzi.hasCapability(2048)) {
            return 0.02d;
        }
        if (!this.zzi.hasCapability(4) || this.zzi.hasCapability(1) || "Chromecast Audio".equals(this.zzi.getModelName())) {
            return 0.05d;
        }
        return 0.02d;
    }

    public final double zzq() throws IllegalStateException {
        checkConnected();
        return this.zzt;
    }

    public final int zzr() throws IllegalStateException {
        checkConnected();
        return this.zzv;
    }

    public final int zzs() throws IllegalStateException {
        checkConnected();
        return this.zzw;
    }

    public final ApplicationMetadata zzt() throws IllegalStateException {
        checkConnected();
        return this.zzh;
    }

    public final String zzz() throws IllegalStateException {
        checkConnected();
        return this.zzo;
    }
}

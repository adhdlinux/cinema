package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzab;
import com.google.android.gms.cast.internal.zzag;
import com.google.android.gms.cast.internal.zzai;
import com.google.android.gms.cast.internal.zzak;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzdy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@SuppressLint({"UseSparseArrays"})
public final class zzbt extends GoogleApi implements zzr {
    public static final /* synthetic */ int zzf = 0;
    /* access modifiers changed from: private */
    public static final Logger zzg = new Logger("CastClient");
    private static final Api.AbstractClientBuilder zzh;
    private static final Api zzi;
    final zzbs zza = new zzbs(this);
    TaskCompletionSource zzb;
    TaskCompletionSource zzc;
    final Map zzd;
    final Map zze;
    private Handler zzj;
    /* access modifiers changed from: private */
    public boolean zzk;
    /* access modifiers changed from: private */
    public boolean zzl;
    private final AtomicLong zzm;
    private final Object zzn = new Object();
    private final Object zzo = new Object();
    /* access modifiers changed from: private */
    public ApplicationMetadata zzp;
    /* access modifiers changed from: private */
    public String zzq;
    private double zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private zzav zzv;
    /* access modifiers changed from: private */
    public final CastDevice zzw;
    /* access modifiers changed from: private */
    public final Cast.Listener zzx;
    /* access modifiers changed from: private */
    public final List zzy = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public int zzz;

    static {
        zzbk zzbk = new zzbk();
        zzh = zzbk;
        zzi = new Api("Cast.API_CXLESS", zzbk, zzak.zzb);
    }

    zzbt(Context context, Cast.CastOptions castOptions) {
        super(context, zzi, castOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(castOptions, "CastOptions cannot be null");
        this.zzx = castOptions.zzb;
        this.zzw = castOptions.zza;
        this.zzd = new HashMap();
        this.zze = new HashMap();
        this.zzm = new AtomicLong(0);
        this.zzz = 1;
        zzn();
    }

    static /* bridge */ /* synthetic */ void zzA(zzbt zzbt, zzab zzab) {
        boolean z2;
        boolean z3;
        boolean z4;
        ApplicationMetadata zze2 = zzab.zze();
        if (!CastUtils.zze(zze2, zzbt.zzp)) {
            zzbt.zzp = zze2;
            zzbt.zzx.onApplicationMetadataChanged(zze2);
        }
        double zzb2 = zzab.zzb();
        if (Double.isNaN(zzb2) || Math.abs(zzb2 - zzbt.zzr) <= 1.0E-7d) {
            z2 = false;
        } else {
            zzbt.zzr = zzb2;
            z2 = true;
        }
        boolean zzg2 = zzab.zzg();
        if (zzg2 != zzbt.zzs) {
            zzbt.zzs = zzg2;
            z2 = true;
        }
        Logger logger = zzg;
        logger.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(zzbt.zzk));
        Cast.Listener listener = zzbt.zzx;
        if (listener != null && (z2 || zzbt.zzk)) {
            listener.onVolumeChanged();
        }
        zzab.zza();
        int zzc2 = zzab.zzc();
        if (zzc2 != zzbt.zzt) {
            zzbt.zzt = zzc2;
            z3 = true;
        } else {
            z3 = false;
        }
        logger.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(zzbt.zzk));
        Cast.Listener listener2 = zzbt.zzx;
        if (listener2 != null && (z3 || zzbt.zzk)) {
            listener2.onActiveInputStateChanged(zzbt.zzt);
        }
        int zzd2 = zzab.zzd();
        if (zzd2 != zzbt.zzu) {
            zzbt.zzu = zzd2;
            z4 = true;
        } else {
            z4 = false;
        }
        logger.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z4), Boolean.valueOf(zzbt.zzk));
        Cast.Listener listener3 = zzbt.zzx;
        if (listener3 != null && (z4 || zzbt.zzk)) {
            listener3.onStandbyStateChanged(zzbt.zzu);
        }
        if (!CastUtils.zze(zzbt.zzv, zzab.zzf())) {
            zzbt.zzv = zzab.zzf();
        }
        zzbt.zzk = false;
    }

    static /* bridge */ /* synthetic */ void zzD(zzbt zzbt, Cast.ApplicationConnectionResult applicationConnectionResult) {
        synchronized (zzbt.zzn) {
            TaskCompletionSource taskCompletionSource = zzbt.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(applicationConnectionResult);
            }
            zzbt.zzb = null;
        }
    }

    static /* bridge */ /* synthetic */ void zzE(zzbt zzbt, long j2, int i2) {
        TaskCompletionSource taskCompletionSource;
        synchronized (zzbt.zzd) {
            Map map = zzbt.zzd;
            Long valueOf = Long.valueOf(j2);
            taskCompletionSource = (TaskCompletionSource) map.get(valueOf);
            zzbt.zzd.remove(valueOf);
        }
        if (taskCompletionSource == null) {
            return;
        }
        if (i2 == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.setException(zzP(i2));
        }
    }

    static /* bridge */ /* synthetic */ void zzF(zzbt zzbt, int i2) {
        synchronized (zzbt.zzo) {
            TaskCompletionSource taskCompletionSource = zzbt.zzc;
            if (taskCompletionSource != null) {
                if (i2 == 0) {
                    taskCompletionSource.setResult(new Status(0));
                } else {
                    taskCompletionSource.setException(zzP(i2));
                }
                zzbt.zzc = null;
            }
        }
    }

    private static ApiException zzP(int i2) {
        return ApiExceptionUtil.fromStatus(new Status(i2));
    }

    /* access modifiers changed from: private */
    public final Task zzQ(zzai zzai) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListener(zzai, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null"), 8415);
    }

    private final void zzR() {
        Preconditions.checkState(zzl(), "Not connected to device");
    }

    /* access modifiers changed from: private */
    public final void zzS() {
        zzg.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
        }
    }

    private final void zzT(TaskCompletionSource taskCompletionSource) {
        synchronized (this.zzn) {
            if (this.zzb != null) {
                zzU(2477);
            }
            this.zzb = taskCompletionSource;
        }
    }

    /* access modifiers changed from: private */
    public final void zzU(int i2) {
        synchronized (this.zzn) {
            TaskCompletionSource taskCompletionSource = this.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setException(zzP(i2));
            }
            this.zzb = null;
        }
    }

    private final void zzV() {
        boolean z2 = true;
        if (this.zzz == 1) {
            z2 = false;
        }
        Preconditions.checkState(z2, "Not active connection");
    }

    static /* bridge */ /* synthetic */ Handler zzo(zzbt zzbt) {
        if (zzbt.zzj == null) {
            zzbt.zzj = new zzdy(zzbt.getLooper());
        }
        return zzbt.zzj;
    }

    static /* bridge */ /* synthetic */ void zzy(zzbt zzbt) {
        zzbt.zzt = -1;
        zzbt.zzu = -1;
        zzbt.zzp = null;
        zzbt.zzq = null;
        zzbt.zzr = 0.0d;
        zzbt.zzn();
        zzbt.zzs = false;
        zzbt.zzv = null;
    }

    static /* bridge */ /* synthetic */ void zzz(zzbt zzbt, zza zza2) {
        boolean z2;
        String zza3 = zza2.zza();
        if (!CastUtils.zze(zza3, zzbt.zzq)) {
            zzbt.zzq = zza3;
            z2 = true;
        } else {
            z2 = false;
        }
        zzg.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(zzbt.zzl));
        Cast.Listener listener = zzbt.zzx;
        if (listener != null && (z2 || zzbt.zzl)) {
            listener.onApplicationStatusChanged();
        }
        zzbt.zzl = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str, String str2, zzbu zzbu, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzR();
        ((zzag) zzx2.getService()).zzg(str, str2, (zzbu) null);
        zzT(taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(String str, LaunchOptions launchOptions, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzR();
        ((zzag) zzx2.getService()).zzh(str, launchOptions);
        zzT(taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI(Cast.MessageReceivedCallback messageReceivedCallback, String str, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzV();
        if (messageReceivedCallback != null) {
            ((zzag) zzx2.getService()).zzr(str);
        }
        taskCompletionSource.setResult(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(String str, String str2, String str3, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        long incrementAndGet = this.zzm.incrementAndGet();
        zzR();
        try {
            this.zzd.put(Long.valueOf(incrementAndGet), taskCompletionSource);
            ((zzag) zzx2.getService()).zzm(str2, str3, incrementAndGet);
        } catch (RemoteException e2) {
            this.zzd.remove(Long.valueOf(incrementAndGet));
            taskCompletionSource.setException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str, Cast.MessageReceivedCallback messageReceivedCallback, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzV();
        ((zzag) zzx2.getService()).zzr(str);
        if (messageReceivedCallback != null) {
            ((zzag) zzx2.getService()).zzk(str);
        }
        taskCompletionSource.setResult(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL(boolean z2, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzag) zzx2.getService()).zzn(z2, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM(double d2, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzag) zzx2.getService()).zzo(d2, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(String str, zzx zzx2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzR();
        ((zzag) zzx2.getService()).zzp(str);
        synchronized (this.zzo) {
            if (this.zzc != null) {
                taskCompletionSource.setException(zzP(2001));
            } else {
                this.zzc = taskCompletionSource;
            }
        }
    }

    public final double zza() {
        zzR();
        return this.zzr;
    }

    public final int zzb() {
        zzR();
        return this.zzt;
    }

    public final int zzc() {
        zzR();
        return this.zzu;
    }

    public final ApplicationMetadata zzd() {
        zzR();
        return this.zzp;
    }

    public final Task zze() {
        ListenerHolder registerListener = registerListener(this.zza, "castDeviceControllerListenerKey");
        RegistrationMethods.Builder builder = RegistrationMethods.builder();
        zzay zzay = new zzay(this);
        return doRegisterEventListener(builder.withHolder(registerListener).register(zzay).unregister(zzbe.zza).setFeatures(zzax.zzb).setMethodKey(8428).build());
    }

    public final Task zzf() {
        Task doWrite = doWrite(TaskApiCall.builder().run(zzbf.zza).setMethodKey(8403).build());
        zzS();
        zzQ(this.zza);
        return doWrite;
    }

    public final Task zzg(String str) {
        Cast.MessageReceivedCallback messageReceivedCallback;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.zze) {
                messageReceivedCallback = (Cast.MessageReceivedCallback) this.zze.remove(str);
            }
            return doWrite(TaskApiCall.builder().run(new zzbi(this, messageReceivedCallback, str)).setMethodKey(8414).build());
        }
        throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }

    public final Task zzh(String str, String str2) {
        CastUtils.throwIfInvalidNamespace(str);
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() <= 524288) {
            return doWrite(TaskApiCall.builder().run(new zzba(this, (String) null, str, str2)).setMethodKey(8405).build());
        } else {
            zzg.w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size524288");
        }
    }

    public final Task zzi(String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        CastUtils.throwIfInvalidNamespace(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zze) {
                this.zze.put(str, messageReceivedCallback);
            }
        }
        return doWrite(TaskApiCall.builder().run(new zzbj(this, str, messageReceivedCallback)).setMethodKey(8413).build());
    }

    public final String zzj() {
        zzR();
        return this.zzq;
    }

    public final void zzk(zzq zzq2) {
        Preconditions.checkNotNull(zzq2);
        this.zzy.add(zzq2);
    }

    public final boolean zzl() {
        return this.zzz == 2;
    }

    public final boolean zzm() {
        zzR();
        return this.zzs;
    }

    /* access modifiers changed from: package-private */
    @RequiresNonNull({"device"})
    public final double zzn() {
        if (this.zzw.hasCapability(2048)) {
            return 0.02d;
        }
        if (!this.zzw.hasCapability(4) || this.zzw.hasCapability(1) || "Chromecast Audio".equals(this.zzw.getModelName())) {
            return 0.05d;
        }
        return 0.02d;
    }
}

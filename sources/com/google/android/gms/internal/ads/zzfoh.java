package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzfoh {
    private static final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzfnw zzc;
    private final String zzd;
    /* access modifiers changed from: private */
    public final List zze = new ArrayList();
    private final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Object zzg = new Object();
    /* access modifiers changed from: private */
    public boolean zzh;
    private final Intent zzi;
    private final WeakReference zzj;
    private final IBinder.DeathRecipient zzk = new zzfnz(this);
    /* access modifiers changed from: private */
    public final AtomicInteger zzl = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public ServiceConnection zzm;
    /* access modifiers changed from: private */
    public IInterface zzn;
    private final zzfne zzo;

    public zzfoh(Context context, zzfnw zzfnw, String str, Intent intent, zzfne zzfne, zzfoc zzfoc) {
        this.zzb = context;
        this.zzc = zzfnw;
        this.zzd = "OverlayDisplayService";
        this.zzi = intent;
        this.zzo = zzfne;
        this.zzj = new WeakReference((Object) null);
    }

    public static /* synthetic */ void zzj(zzfoh zzfoh) {
        zzfoh.zzc.zzc("reportBinderDeath", new Object[0]);
        zzfoc zzfoc = (zzfoc) zzfoh.zzj.get();
        if (zzfoc != null) {
            zzfoh.zzc.zzc("calling onBinderDied", new Object[0]);
            zzfoc.zza();
        } else {
            zzfoh.zzc.zzc("%s : Binder has died.", zzfoh.zzd);
            for (zzfnx zzc2 : zzfoh.zze) {
                zzc2.zzc(zzfoh.zzv());
            }
            zzfoh.zze.clear();
        }
        synchronized (zzfoh.zzg) {
            zzfoh.zzw();
        }
    }

    static /* bridge */ /* synthetic */ void zzn(zzfoh zzfoh, TaskCompletionSource taskCompletionSource) {
        zzfoh.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new zzfny(zzfoh, taskCompletionSource));
    }

    static /* bridge */ /* synthetic */ void zzp(zzfoh zzfoh, zzfnx zzfnx) {
        if (zzfoh.zzn == null && !zzfoh.zzh) {
            zzfoh.zzc.zzc("Initiate binding to the service.", new Object[0]);
            zzfoh.zze.add(zzfnx);
            zzfog zzfog = new zzfog(zzfoh, (zzfof) null);
            zzfoh.zzm = zzfog;
            zzfoh.zzh = true;
            if (!zzfoh.zzb.bindService(zzfoh.zzi, zzfog, 1)) {
                zzfoh.zzc.zzc("Failed to bind to the service.", new Object[0]);
                zzfoh.zzh = false;
                for (zzfnx zzc2 : zzfoh.zze) {
                    zzc2.zzc(new zzfoi());
                }
                zzfoh.zze.clear();
            }
        } else if (zzfoh.zzh) {
            zzfoh.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            zzfoh.zze.add(zzfnx);
        } else {
            zzfnx.run();
        }
    }

    static /* bridge */ /* synthetic */ void zzq(zzfoh zzfoh) {
        zzfoh.zzc.zzc("linkToDeath", new Object[0]);
        try {
            zzfoh.zzn.asBinder().linkToDeath(zzfoh.zzk, 0);
        } catch (RemoteException e2) {
            zzfoh.zzc.zzb(e2, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void zzr(zzfoh zzfoh) {
        zzfoh.zzc.zzc("unlinkToDeath", new Object[0]);
        zzfoh.zzn.asBinder().unlinkToDeath(zzfoh.zzk, 0);
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void zzw() {
        for (TaskCompletionSource trySetException : this.zzf) {
            trySetException.trySetException(zzv());
        }
        this.zzf.clear();
    }

    public final Handler zzc() {
        Handler handler;
        Map map = zza;
        synchronized (map) {
            if (!map.containsKey(this.zzd)) {
                HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                handlerThread.start();
                map.put(this.zzd, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.zzd);
        }
        return handler;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzs(zzfnx zzfnx, TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzfoa(this, zzfnx.zzb(), taskCompletionSource, zzfnx));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    public final void zzu() {
        zzc().post(new zzfob(this));
    }
}

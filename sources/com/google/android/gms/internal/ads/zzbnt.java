package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

public final class zzbnt extends zzbnv {
    private static final zzbpx zza = new zzbpx();

    public final zzbnz zzb(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzbnt.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzbow((MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            if (Adapter.class.isAssignableFrom(cls)) {
                return new zzbow((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            zzbzr.zzj("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
            throw new RemoteException();
        } catch (Throwable th) {
            zzbzr.zzk("Could not instantiate mediation adapter: " + str + ". ", th);
        }
        throw new RemoteException();
    }

    public final zzbpt zzc(String str) throws RemoteException {
        try {
            return new zzbqf((RtbAdapter) Class.forName(str, false, zzbpx.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }

    public final boolean zzd(String str) throws RemoteException {
        try {
            return Adapter.class.isAssignableFrom(Class.forName(str, false, zzbnt.class.getClassLoader()));
        } catch (Throwable unused) {
            zzbzr.zzj("Could not load custom event implementation class as Adapter: " + str + ", assuming old custom event implementation.");
            return false;
        }
    }

    public final boolean zze(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzbnt.class.getClassLoader()));
        } catch (Throwable unused) {
            zzbzr.zzj("Could not load custom event implementation class: " + str + ", trying Adapter implementation class.");
            return false;
        }
    }
}

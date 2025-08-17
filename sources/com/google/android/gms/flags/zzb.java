package com.google.android.gms.flags;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public final class zzb {
    private boolean zza = false;
    private zze zzb = null;

    public final <T> T zza(Flag<T> flag) {
        synchronized (this) {
            if (this.zza) {
                return flag.zza(this.zzb);
            }
            T zzc = flag.zzc();
            return zzc;
        }
    }

    public final void zzb(Context context) {
        synchronized (this) {
            if (!this.zza) {
                try {
                    zze asInterface = zzd.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.flags.impl.FlagProviderImpl"));
                    this.zzb = asInterface;
                    asInterface.init(ObjectWrapper.wrap(context));
                    this.zza = true;
                } catch (RemoteException | DynamiteModule.LoadingException e2) {
                    Log.w("FlagValueProvider", "Failed to initialize flags module.", e2);
                }
            }
        }
    }
}

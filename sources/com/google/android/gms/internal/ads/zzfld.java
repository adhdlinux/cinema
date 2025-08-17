package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzfld {
    final zzflg zza;
    final boolean zzb;

    private zzfld(zzflg zzflg) {
        this.zza = zzflg;
        this.zzb = zzflg != null;
    }

    public static zzfld zzb(Context context, String str, String str2) {
        zzflg zzflg;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzflg = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                if (queryLocalInterface instanceof zzflg) {
                    zzflg = (zzflg) queryLocalInterface;
                } else {
                    zzflg = new zzfle(instantiate);
                }
            }
            try {
                zzflg.zze(ObjectWrapper.wrap(context), str, (String) null);
                Log.i("GASS", "GassClearcutLogger Initialized.");
                return new zzfld(zzflg);
            } catch (RemoteException | zzfkf | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfld(new zzflh());
            }
        } catch (Exception e2) {
            throw new zzfkf(e2);
        } catch (Exception e3) {
            throw new zzfkf(e3);
        }
    }

    public static zzfld zzc() {
        zzflh zzflh = new zzflh();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfld(zzflh);
    }

    public final zzflc zza(byte[] bArr) {
        return new zzflc(this, bArr, (zzflb) null);
    }
}

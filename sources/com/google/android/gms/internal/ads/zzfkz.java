package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

public final class zzfkz {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfla zzc;
    private final zzfjb zzd;
    private final zzfiw zze;
    private zzfko zzf;
    private final Object zzg = new Object();

    public zzfkz(Context context, zzfla zzfla, zzfjb zzfjb, zzfiw zzfiw) {
        this.zzb = context;
        this.zzc = zzfla;
        this.zzd = zzfjb;
        this.zze = zzfiw;
    }

    private final synchronized Class zzd(zzfkp zzfkp) throws zzfky {
        String zzk = zzfkp.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfkp.zzc())) {
                File zzb2 = zzfkp.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzfkp.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzfky(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e2) {
            throw new zzfky(2026, (Throwable) e2);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e3) {
            throw new zzfky(2008, e3);
        }
    }

    public final zzfje zza() {
        zzfko zzfko;
        synchronized (this.zzg) {
            zzfko = this.zzf;
        }
        return zzfko;
    }

    public final zzfkp zzb() {
        synchronized (this.zzg) {
            zzfko zzfko = this.zzf;
            if (zzfko == null) {
                return null;
            }
            zzfkp zzf2 = zzfko.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(zzfkp zzfkp) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class zzd2 = zzd(zzfkp);
            zzfko zzfko = new zzfko(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfkp.zze(), null, new Bundle(), 2}), zzfkp, this.zzc, this.zzd);
            if (zzfko.zzh()) {
                int zze2 = zzfko.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzfko zzfko2 = this.zzf;
                        if (zzfko2 != null) {
                            try {
                                zzfko2.zzg();
                            } catch (zzfky e2) {
                                this.zzd.zzc(e2.zza(), -1, e2);
                            }
                        }
                        this.zzf = zzfko;
                    }
                    this.zzd.zzd(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzfky(4001, "ci: " + zze2);
            }
            throw new zzfky(4000, "init failed");
        } catch (Exception e3) {
            throw new zzfky(2004, (Throwable) e3);
        } catch (zzfky e4) {
            this.zzd.zzc(e4.zza(), System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        } catch (Exception e5) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e5);
            return false;
        }
    }
}

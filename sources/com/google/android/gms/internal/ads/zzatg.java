package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class zzatg {
    protected static final String zza = "zzatg";
    private final zzart zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzatg(zzart zzart, String str, String str2, Class... clsArr) {
        this.zzb = zzart;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzart.zzk().submit(new zzatf(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzatg zzatg) {
        CountDownLatch countDownLatch;
        try {
            zzart zzart = zzatg.zzb;
            Class<?> loadClass = zzart.zzi().loadClass(zzatg.zzc(zzart.zzu(), zzatg.zzc));
            if (loadClass == null) {
                countDownLatch = zzatg.zzg;
            } else {
                zzatg.zze = loadClass.getMethod(zzatg.zzc(zzatg.zzb.zzu(), zzatg.zzd), zzatg.zzf);
                if (zzatg.zze == null) {
                    countDownLatch = zzatg.zzg;
                }
                countDownLatch = zzatg.zzg;
            }
        } catch (zzaqx | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzatg.zzg;
        } catch (Throwable th) {
            zzatg.zzg.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzaqx, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}

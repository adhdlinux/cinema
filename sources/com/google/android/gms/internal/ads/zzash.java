package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzash extends zzath {
    private static final zzati zzi = new zzati();
    private final Context zzj;

    public zzash(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, Context context, zzanj zzanj) {
        super(zzart, "jrfJs+Yxsv/gGQ+cGnmY8EkHVJn84HokHsebN4IZy0eeE0ECK9wrDY7bM1U167G5", "b0nnYr5Y43sLp9uCG6eLzyBhSsauFEDPWpaZrhJ4ttc=", zzanq, i2, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzaon zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzaj()) {
                return null;
            }
            return zzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzape zzape;
        int i2;
        boolean z2;
        String str;
        Boolean bool;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzape zzape2 = (zzape) zza.get();
            if (zzape2 == null || zzarw.zzd(zzape2.zza) || zzape2.zza.equals("E") || zzape2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzarw.zzd((String) null)) {
                    i2 = 5;
                } else {
                    if (!zzarw.zzd((String) null)) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.FALSE;
                    }
                    bool.booleanValue();
                    i2 = 3;
                }
                if (i2 == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Boolean valueOf = Boolean.valueOf(z2);
                Boolean bool2 = (Boolean) zzba.zzc().zzb(zzbbm.zzce);
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzcd)).booleanValue()) {
                    str = zzb();
                } else {
                    str = null;
                }
                if (bool2.booleanValue() && this.zzb.zzp() && zzarw.zzd(str)) {
                    str = zzc();
                }
                zzape zzape3 = new zzape((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, str}));
                if (zzarw.zzd(zzape3.zza) || zzape3.zza.equals("E")) {
                    int i3 = i2 - 1;
                    if (i3 == 3) {
                        String zzc = zzc();
                        if (!zzarw.zzd(zzc)) {
                            zzape3.zza = zzc;
                        }
                    } else if (i3 == 4) {
                        throw null;
                    }
                }
                zza.set(zzape3);
            }
            zzape = (zzape) zza.get();
        }
        synchronized (this.zze) {
            if (zzape != null) {
                this.zze.zzx(zzape.zza);
                this.zze.zzX(zzape.zzb);
                this.zze.zzZ(zzape.zzc);
                this.zze.zzi(zzape.zzd);
                this.zze.zzw(zzape.zze);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzarw.zzf((String) zzba.zzc().zzb(zzbbm.zzcf));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzarw.zzf((String) zzba.zzc().zzb(zzbbm.zzcg)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            zzfwv zzf2 = zzfwv.zzf();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzatj(zzf2));
            return (String) zzf2.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}

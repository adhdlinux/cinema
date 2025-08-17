package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

public final class zzfkx {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfke zze;
    private boolean zzf = false;

    public zzfkx(Context context, int i2, zzfke zzfke, boolean z2) {
        this.zzb = context;
        this.zzd = Integer.toString(i2 - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfke;
        this.zzf = z2;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzatm zzatm) {
        zzato zze2 = zzatp.zze();
        zze2.zze(zzatm.zzd().zzk());
        zze2.zza(zzatm.zzd().zzj());
        zze2.zzb(zzatm.zzd().zza());
        zze2.zzd(zzatm.zzd().zzd());
        zze2.zzc(zzatm.zzd().zzc());
        return Hex.bytesToStringLowercase(((zzatp) zze2.zzal()).zzax());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i2, long j2) {
        this.zze.zza(i2, j2);
    }

    private final void zzj(int i2, long j2, String str) {
        this.zze.zzb(i2, j2, str);
    }

    private final zzatp zzk(int i2) {
        String str;
        zzgoy zzgoy;
        if (i2 == 1) {
            str = this.zzc.getString(zzh(), (String) null);
        } else {
            str = this.zzc.getString(zzg(), (String) null);
        }
        if (str == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] stringToBytes = Hex.stringToBytes(str);
            zzgoe zzgoe = zzgoe.zzb;
            zzgoe zzv = zzgoe.zzv(stringToBytes, 0, stringToBytes.length);
            if (this.zzf) {
                zzgoy = zzgoy.zza();
            } else {
                zzgoy = zzgoy.zzb();
            }
            return zzatp.zzi(zzv, zzgoy);
        } catch (zzgpy unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzatm r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zza
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzatp r3 = r7.zzd()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zzk()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zze(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzgoe r3 = r7.zze()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.zzA()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzfkr.zze(r4, r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zzi(r7, r0)     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            r7 = 0
            return r7
        L_0x0030:
            java.lang.String r7 = zzf(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzc     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzh()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfkx.zza(com.google.android.gms.internal.ads.zzatm):boolean");
    }

    public final boolean zzb(zzatm zzatm, zzfkw zzfkw) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzatp zzk = zzk(1);
            String zzk2 = zzatm.zzd().zzk();
            if (zzk == null || !zzk.zzk().equals(zzk2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File zze2 = zze(zzk2);
                if (zze2.exists()) {
                    String str = "1";
                    if (true != zze2.isDirectory()) {
                        str = "0";
                    }
                    String str2 = "1";
                    if (true != zze2.isFile()) {
                        str2 = "0";
                    }
                    zzj(4023, currentTimeMillis2, "d:" + str + ",f:" + str2);
                    zzi(4015, currentTimeMillis2);
                } else if (!zze2.mkdirs()) {
                    String str3 = "1";
                    if (true != zze2.canWrite()) {
                        str3 = "0";
                    }
                    zzj(4024, currentTimeMillis2, "cw:".concat(str3));
                    zzi(4015, currentTimeMillis2);
                    return false;
                }
                File zze3 = zze(zzk2);
                File file = new File(zze3, "pcam.jar");
                File file2 = new File(zze3, "pcbc");
                if (!zzfkr.zze(file, zzatm.zzf().zzA())) {
                    zzi(4016, currentTimeMillis);
                    return false;
                } else if (!zzfkr.zze(file2, zzatm.zze().zzA())) {
                    zzi(4017, currentTimeMillis);
                    return false;
                } else if (zzfkw == null || zzfkw.zza(file)) {
                    String zzf2 = zzf(zzatm);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzc.getString(zzh(), (String) null);
                    SharedPreferences.Editor edit = this.zzc.edit();
                    edit.putString(zzh(), zzf2);
                    if (string != null) {
                        edit.putString(zzg(), string);
                    }
                    if (!edit.commit()) {
                        zzi(4019, currentTimeMillis3);
                        return false;
                    }
                    HashSet hashSet = new HashSet();
                    zzatp zzk3 = zzk(1);
                    if (zzk3 != null) {
                        hashSet.add(zzk3.zzk());
                    }
                    zzatp zzk4 = zzk(2);
                    if (zzk4 != null) {
                        hashSet.add(zzk4.zzk());
                    }
                    for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                        if (!hashSet.contains(file3.getName())) {
                            zzfkr.zzd(file3);
                        }
                    }
                    zzi(5014, currentTimeMillis);
                    return true;
                } else {
                    zzi(4018, currentTimeMillis);
                    zzfkr.zzd(zze3);
                    return false;
                }
            } else {
                zzi(4014, currentTimeMillis);
                return false;
            }
        }
    }

    public final zzfkp zzc(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzatp zzk = zzk(1);
            if (zzk == null) {
                zzi(4022, currentTimeMillis);
                return null;
            }
            File zze2 = zze(zzk.zzk());
            File file = new File(zze2, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze2, "pcam");
            }
            File file2 = new File(zze2, "pcbc");
            File file3 = new File(zze2, "pcopt");
            zzi(5016, currentTimeMillis);
            zzfkp zzfkp = new zzfkp(zzk, file, file2, file3);
            return zzfkp;
        }
    }

    public final boolean zzd(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzatp zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze2 = zze(zzk.zzk());
            if (!new File(zze2, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            } else if (!new File(zze2, "pcbc").exists()) {
                zzi(4027, currentTimeMillis);
                return false;
            } else {
                zzi(5019, currentTimeMillis);
                return true;
            }
        }
    }
}

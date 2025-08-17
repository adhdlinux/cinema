package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;

public final class zzaup {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzave zze;
    private final zzavm zzf;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private int zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzaup(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = z2;
        this.zze = new zzave(i5);
        this.zzf = new zzavm(i6, i7, i8);
    }

    private final void zzp(String str, boolean z2, float f2, float f3, float f4, float f5) {
        if (str != null && str.length() >= this.zzc) {
            synchronized (this.zzg) {
                this.zzh.add(str);
                this.zzk += str.length();
                if (z2) {
                    this.zzi.add(str);
                    this.zzj.add(new zzava(f2, f3, f4, f5, this.zzi.size() - 1));
                }
            }
        }
    }

    private static final String zzq(ArrayList arrayList, int i2) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            sb.append((String) arrayList.get(i3));
            sb.append(' ');
            i3++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaup)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzaup) obj).zzo;
        if (str == null || !str.equals(this.zzo)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        int i2 = this.zzl;
        int i3 = this.zzn;
        int i4 = this.zzk;
        String zzq2 = zzq(this.zzh, 100);
        String zzq3 = zzq(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        return "ActivityContent fetchId: " + i2 + " score:" + i3 + " total_length:" + i4 + "\n text: " + zzq2 + "\n viewableText" + zzq3 + "\n signture: " + str + "\n viewableSignture: " + str2 + "\n viewableSignatureForVertical: " + str3;
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i2, int i3) {
        return this.zzd ? this.zzb : (i2 * this.zza) + (i3 * this.zzb);
    }

    public final int zzb() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzo;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzh() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzj(int i2) {
        this.zzl = i2;
    }

    public final void zzk(String str, boolean z2, float f2, float f3, float f4, float f5) {
        zzp(str, z2, f2, f3, f4, f5);
    }

    public final void zzl(String str, boolean z2, float f2, float f3, float f4, float f5) {
        zzp(str, z2, f2, f3, f4, f5);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                zzbzr.zze("ActivityContent: negative number of WebViews.");
            }
            zzm();
        }
    }

    public final void zzm() {
        synchronized (this.zzg) {
            int zza2 = zza(this.zzk, this.zzl);
            if (zza2 > this.zzn) {
                this.zzn = zza2;
                if (!zzt.zzo().zzh().zzM()) {
                    this.zzo = this.zze.zza(this.zzh);
                    this.zzp = this.zze.zza(this.zzi);
                }
                if (!zzt.zzo().zzh().zzN()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    public final void zzn() {
        synchronized (this.zzg) {
            int zza2 = zza(this.zzk, this.zzl);
            if (zza2 > this.zzn) {
                this.zzn = zza2;
            }
        }
    }

    public final boolean zzo() {
        boolean z2;
        synchronized (this.zzg) {
            if (this.zzm == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }
}

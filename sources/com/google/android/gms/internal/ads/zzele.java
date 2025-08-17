package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzq;

public final class zzele implements zzeqy {
    private final zzeqy zza;
    private final zzfai zzb;
    private final Context zzc;
    private final zzbza zzd;

    public zzele(zzemy zzemy, zzfai zzfai, Context context, zzbza zzbza) {
        this.zza = zzemy;
        this.zzb = zzfai;
        this.zzc = context;
        this.zzd = zzbza;
    }

    public final int zza() {
        return 7;
    }

    public final zzfwm zzb() {
        return zzfwc.zzl(this.zza.zzb(), new zzeld(this), zzcae.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzelf zzc(zzerd zzerd) {
        boolean z2;
        String str;
        String str2;
        int i2;
        float f2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics;
        zzq zzq = this.zzb.zze;
        zzq[] zzqArr = zzq.zzg;
        if (zzqArr != null) {
            str = null;
            boolean z3 = false;
            boolean z4 = false;
            z2 = false;
            for (zzq zzq2 : zzqArr) {
                boolean z5 = zzq2.zzi;
                if (!z5 && !z3) {
                    str = zzq2.zza;
                    z3 = true;
                }
                if (z5) {
                    if (!z4) {
                        z4 = true;
                        z2 = true;
                    } else {
                        z4 = true;
                    }
                }
                if (z3 && z4) {
                    break;
                }
            }
        } else {
            str = zzq.zza;
            z2 = zzq.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            i3 = 0;
            f2 = 0.0f;
            i2 = 0;
        } else {
            float f3 = displayMetrics.density;
            int i5 = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            str2 = this.zzd.zzh().zzm();
            i2 = i5;
            f2 = f3;
        }
        StringBuilder sb = new StringBuilder();
        zzq[] zzqArr2 = zzq.zzg;
        if (zzqArr2 != null) {
            boolean z6 = false;
            for (zzq zzq3 : zzqArr2) {
                if (zzq3.zzi) {
                    z6 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i6 = zzq3.zze;
                    if (i6 == -1) {
                        if (f2 != 0.0f) {
                            i6 = (int) (((float) zzq3.zzf) / f2);
                        } else {
                            i6 = -1;
                        }
                    }
                    sb.append(i6);
                    sb.append("x");
                    int i7 = zzq3.zzb;
                    if (i7 == -2) {
                        if (f2 != 0.0f) {
                            i7 = (int) (((float) zzq3.zzc) / f2);
                        } else {
                            i7 = -2;
                        }
                    }
                    sb.append(i7);
                }
            }
            if (z6) {
                if (sb.length() != 0) {
                    i4 = 0;
                    sb.insert(0, "|");
                } else {
                    i4 = 0;
                }
                sb.insert(i4, "320x50");
            }
        }
        return new zzelf(zzq, str, z2, sb.toString(), f2, i2, i3, str2, this.zzb.zzp);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzk;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.concurrent.TimeUnit;

public final class zzccb {
    private final Context zza;
    private final String zzb;
    private final zzbzx zzc;
    private final zzbcb zzd;
    private final zzbce zze;
    private final zzbf zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm;
    private zzcbg zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq = -1;

    public zzccb(Context context, zzbzx zzbzx, String str, zzbce zzbce, zzbcb zzbcb) {
        zzbd zzbd = new zzbd();
        zzbd zzbd2 = zzbd;
        zzbd2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbd2.zza("1_5", 1.0d, 5.0d);
        zzbd2.zza("5_10", 5.0d, 10.0d);
        zzbd2.zza("10_20", 10.0d, 20.0d);
        zzbd2.zza("20_30", 20.0d, 30.0d);
        zzbd2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzbd.zzb();
        this.zza = context;
        this.zzc = zzbzx;
        this.zzb = str;
        this.zze = zzbce;
        this.zzd = zzbcb;
        String str2 = (String) zzba.zzc().zzb(zzbbm.zzA);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                this.zzg[i2] = Long.parseLong(split[i2]);
            } catch (NumberFormatException e2) {
                zzbzr.zzk("Unable to parse frame hash target time number.", e2);
                this.zzg[i2] = -1;
            }
        }
    }

    public final void zza(zzcbg zzcbg) {
        zzbbw.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzcbg.zzj());
        this.zzn = zzcbg;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzbbw.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzbbw.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzd() {
        if (((Boolean) zzbdt.zza.zze()).booleanValue() && !this.zzo) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString(AdActivity.REQUEST_KEY_EXTRA, this.zzb);
            bundle.putString("player", this.zzn.zzj());
            for (zzbc zzbc : this.zzf.zza()) {
                String valueOf = String.valueOf(zzbc.zza);
                bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbc.zze));
                String valueOf2 = String.valueOf(zzbc.zza);
                bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbc.zzd));
            }
            int i2 = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i2 < jArr.length) {
                    String str = this.zzh[i2];
                    if (str != null) {
                        bundle.putString("fh_".concat(Long.valueOf(jArr[i2]).toString()), str);
                    }
                    i2++;
                } else {
                    zzt.zzp();
                    Context context = this.zza;
                    String str2 = this.zzc.zza;
                    zzt.zzp();
                    bundle.putString("device", zzs.zzp());
                    zzbbe zzbbe = zzbbm.zza;
                    bundle.putString("eids", TextUtils.join(",", zzba.zza().zza()));
                    zzay.zzb();
                    zzbzk.zzw(context, str2, "gmob-apps", bundle, true, new zzk(context, str2));
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzm = false;
    }

    public final void zzf(zzcbg zzcbg) {
        long j2;
        if (this.zzk && !this.zzl) {
            if (zze.zzc() && !this.zzl) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbbw.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = zzt.zzB().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            this.zzf.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzq)));
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) zzba.zzc().zzb(zzbbm.zzB)).longValue();
        long zza2 = (long) zzcbg.zza();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && longValue > Math.abs(zza2 - this.zzg[i2])) {
                String[] strArr2 = this.zzh;
                int i3 = 8;
                Bitmap bitmap = zzcbg.getBitmap(8, 8);
                long j3 = 63;
                long j4 = 0;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = 0;
                    while (i5 < i3) {
                        int pixel = bitmap.getPixel(i5, i4);
                        if (Color.blue(pixel) + Color.red(pixel) + Color.green(pixel) > 128) {
                            j2 = 1;
                        } else {
                            j2 = 0;
                        }
                        j4 |= j2 << ((int) j3);
                        j3--;
                        i5++;
                        i3 = 8;
                    }
                    i4++;
                    i3 = 8;
                }
                strArr2[i2] = String.format("%016X", new Object[]{Long.valueOf(j4)});
                return;
            }
            zzcbg zzcbg2 = zzcbg;
            i2++;
        }
    }
}

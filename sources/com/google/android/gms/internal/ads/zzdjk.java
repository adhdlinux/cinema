package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdjk {
    private final zzbo zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdjk(zzbo zzbo, Clock clock, Executor executor) {
        this.zza = zzbo;
        this.zzb = clock;
        this.zzc = executor;
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.zzb.elapsedRealtime();
        boolean z2 = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.zzb.elapsedRealtime();
        if (decodeByteArray != null) {
            long j2 = elapsedRealtime2 - elapsedRealtime;
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z2 = true;
            }
            zze.zza("Decoded image w: " + width + " h:" + height + " bytes: " + allocationByteCount + " time: " + j2 + " on ui thread: " + z2);
        }
        return decodeByteArray;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bitmap zza(double d2, boolean z2, zzalg zzalg) {
        byte[] bArr = zzalg.zzb;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d2 * 160.0d);
        if (!z2) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfT)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i2 = options.outWidth * options.outHeight;
            if (i2 > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i2 - 1) / ((Integer) zzba.zzc().zzb(zzbbm.zzfU)).intValue())) / 2);
            }
        }
        return zzc(bArr, options);
    }

    public final zzfwm zzb(String str, double d2, boolean z2) {
        return zzfwc.zzl(this.zza.zza(str), new zzdjj(this, d2, z2), this.zzc);
    }
}

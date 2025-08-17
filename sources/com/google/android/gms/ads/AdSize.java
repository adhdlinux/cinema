package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize INVALID = new AdSize(0, 0, Constants.COLLATION_INVALID);
    public static final AdSize LARGE_BANNER = new AdSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            if (r4 != r0) goto L_0x0006
            java.lang.String r0 = "FULL"
            goto L_0x000a
        L_0x0006:
            java.lang.String r0 = java.lang.String.valueOf(r4)
        L_0x000a:
            r1 = -2
            if (r5 != r1) goto L_0x0010
            java.lang.String r1 = "AUTO"
            goto L_0x0014
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r5)
        L_0x0014:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "x"
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = "_as"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r3.<init>(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        AdSize zzc2 = zzbzk.zzc(context, i2, 50, 0);
        zzc2.zze = true;
        return zzc2;
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i2) {
        int zza2 = zzbzk.zza(context, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i2, 0);
        adSize.zzg = zza2;
        adSize.zzf = true;
        return adSize;
    }

    public static AdSize getCurrentOrientationInterscrollerAdSize(Context context, int i2) {
        return zzj(i2, zzbzk.zza(context, 0));
    }

    public static AdSize getInlineAdaptiveBannerAdSize(int i2, int i3) {
        AdSize adSize = new AdSize(i2, 0);
        adSize.zzg = i3;
        adSize.zzf = true;
        if (i3 < 32) {
            zzbzr.zzj("The maximum height set for the inline adaptive ad size was " + i3 + " dp, which is below the minimum recommended value of 32 dp.");
        }
        return adSize;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        AdSize zzc2 = zzbzk.zzc(context, i2, 50, 2);
        zzc2.zze = true;
        return zzc2;
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context context, int i2) {
        int zza2 = zzbzk.zza(context, 2);
        AdSize adSize = new AdSize(i2, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        adSize.zzg = zza2;
        adSize.zzf = true;
        return adSize;
    }

    public static AdSize getLandscapeInterscrollerAdSize(Context context, int i2) {
        return zzj(i2, zzbzk.zza(context, 2));
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        AdSize zzc2 = zzbzk.zzc(context, i2, 50, 1);
        zzc2.zze = true;
        return zzc2;
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context context, int i2) {
        int zza2 = zzbzk.zza(context, 1);
        AdSize adSize = new AdSize(i2, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        adSize.zzg = zza2;
        adSize.zzf = true;
        return adSize;
    }

    public static AdSize getPortraitInterscrollerAdSize(Context context, int i2) {
        return zzj(i2, zzbzk.zza(context, 1));
    }

    private static AdSize zzj(int i2, int i3) {
        if (i3 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i2, 0);
        adSize.zzi = i3;
        adSize.zzh = true;
        return adSize;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        if (this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd)) {
            return true;
        }
        return false;
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(Context context) {
        int i2 = this.zzc;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 == -2) {
            return zzq.zza(context.getResources().getDisplayMetrics());
        }
        zzay.zzb();
        return zzbzk.zzx(context, this.zzc);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(Context context) {
        int i2 = this.zzb;
        if (i2 == -3) {
            return -1;
        }
        if (i2 != -1) {
            zzay.zzb();
            return zzbzk.zzx(context, this.zzb);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzq> creator = zzq.CREATOR;
        return displayMetrics.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    public String toString() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i2) {
        this.zzg = i2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i2) {
        this.zzi = i2;
    }

    /* access modifiers changed from: package-private */
    public final void zze(boolean z2) {
        this.zzf = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z2) {
        this.zzh = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi() {
        return this.zzh;
    }

    AdSize(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i2);
        } else if (i3 >= 0 || i3 == -2 || i3 == -4) {
            this.zzb = i2;
            this.zzc = i3;
            this.zzd = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i3);
        }
    }
}

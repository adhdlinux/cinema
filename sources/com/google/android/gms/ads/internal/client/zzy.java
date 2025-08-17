package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R;
import com.startapp.sdk.adsbase.model.AdPreferences;

public final class zzy {
    private final AdSize[] zza;
    private final String zzb;

    public zzy(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(R.styleable.AdsAttrs_adSizes);
        boolean z2 = !TextUtils.isEmpty(string);
        boolean z3 = !TextUtils.isEmpty(string2);
        if (z2 && !z3) {
            this.zza = zzc(string);
        } else if (!z2 && z3) {
            this.zza = zzc(string2);
        } else if (z2) {
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        String string3 = obtainAttributes.getString(R.styleable.AdsAttrs_adUnitId);
        this.zzb = string3;
        obtainAttributes.recycle();
        if (TextUtils.isEmpty(string3)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] zzc(String str) {
        int i2;
        int i3;
        String[] split = str.split("\\s*,\\s*");
        int length = split.length;
        AdSize[] adSizeArr = new AdSize[length];
        for (int i4 = 0; i4 < split.length; i4++) {
            String trim = split[i4].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    if ("FULL_WIDTH".equals(split2[0])) {
                        i2 = -1;
                    } else {
                        i2 = Integer.parseInt(split2[0]);
                    }
                    if ("AUTO_HEIGHT".equals(split2[1])) {
                        i3 = -2;
                    } else {
                        i3 = Integer.parseInt(split2[1]);
                    }
                    adSizeArr[i4] = new AdSize(i2, i3);
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(trim));
                }
            } else if (AdPreferences.TYPE_BANNER.equals(trim)) {
                adSizeArr[i4] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i4] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i4] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i4] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i4] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i4] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i4] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(trim)) {
                adSizeArr[i4] = AdSize.FLUID;
            } else if ("ICON".equals(trim)) {
                adSizeArr[i4] = AdSize.zza;
            } else {
                throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(trim));
            }
        }
        if (length != 0) {
            return adSizeArr;
        }
        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(str));
    }

    public final String zza() {
        return this.zzb;
    }

    public final AdSize[] zzb(boolean z2) {
        if (z2 || this.zza.length == 1) {
            return this.zza;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}

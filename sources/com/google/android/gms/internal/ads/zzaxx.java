package com.google.android.gms.internal.ads;

public enum zzaxx implements zzgpo {
    AD_FORMAT_TYPE_UNSPECIFIED(0),
    BANNER(1),
    INTERSTITIAL(2),
    NATIVE_EXPRESS(3),
    NATIVE_CONTENT(4),
    NATIVE_APP_INSTALL(5),
    NATIVE_CUSTOM_TEMPLATE(6),
    DFP_BANNER(7),
    DFP_INTERSTITIAL(8),
    REWARD_BASED_VIDEO_AD(9),
    BANNER_SEARCH_ADS(10);
    
    private static final zzgpp zzl = null;
    private final int zzn;

    static {
        zzl = new zzaxv();
    }

    private zzaxx(int i2) {
        this.zzn = i2;
    }

    public static zzaxx zzb(int i2) {
        switch (i2) {
            case 0:
                return AD_FORMAT_TYPE_UNSPECIFIED;
            case 1:
                return BANNER;
            case 2:
                return INTERSTITIAL;
            case 3:
                return NATIVE_EXPRESS;
            case 4:
                return NATIVE_CONTENT;
            case 5:
                return NATIVE_APP_INSTALL;
            case 6:
                return NATIVE_CUSTOM_TEMPLATE;
            case 7:
                return DFP_BANNER;
            case 8:
                return DFP_INTERSTITIAL;
            case 9:
                return REWARD_BASED_VIDEO_AD;
            case 10:
                return BANNER_SEARCH_ADS;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzn);
    }

    public final int zza() {
        return this.zzn;
    }
}

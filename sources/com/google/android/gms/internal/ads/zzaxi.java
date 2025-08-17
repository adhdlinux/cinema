package com.google.android.gms.internal.ads;

final class zzaxi implements zzgpq {
    static final zzgpq zza = new zzaxi();

    private zzaxi() {
    }

    public final boolean zza(int i2) {
        zzaxj zzaxj;
        zzaxj zzaxj2 = zzaxj.AD_INITIATER_UNSPECIFIED;
        switch (i2) {
            case 0:
                zzaxj = zzaxj.AD_INITIATER_UNSPECIFIED;
                break;
            case 1:
                zzaxj = zzaxj.BANNER;
                break;
            case 2:
                zzaxj = zzaxj.DFP_BANNER;
                break;
            case 3:
                zzaxj = zzaxj.INTERSTITIAL;
                break;
            case 4:
                zzaxj = zzaxj.DFP_INTERSTITIAL;
                break;
            case 5:
                zzaxj = zzaxj.NATIVE_EXPRESS;
                break;
            case 6:
                zzaxj = zzaxj.AD_LOADER;
                break;
            case 7:
                zzaxj = zzaxj.REWARD_BASED_VIDEO_AD;
                break;
            case 8:
                zzaxj = zzaxj.BANNER_SEARCH_ADS;
                break;
            case 9:
                zzaxj = zzaxj.GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                break;
            case 10:
                zzaxj = zzaxj.APP_OPEN;
                break;
            case 11:
                zzaxj = zzaxj.REWARDED_INTERSTITIAL;
                break;
            default:
                zzaxj = null;
                break;
        }
        return zzaxj != null;
    }
}

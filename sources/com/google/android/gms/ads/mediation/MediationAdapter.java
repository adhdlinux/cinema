package com.google.android.gms.ads.mediation;

@Deprecated
public interface MediationAdapter extends MediationExtrasReceiver {
    void onDestroy();

    void onPause();

    void onResume();
}

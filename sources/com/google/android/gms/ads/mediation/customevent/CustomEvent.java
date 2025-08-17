package com.google.android.gms.ads.mediation.customevent;

@Deprecated
public interface CustomEvent {
    void onDestroy();

    void onPause();

    void onResume();
}
